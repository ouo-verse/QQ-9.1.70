package com.tencent.imcore.message;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.imcore.message.facade.api.IMessageFacadeService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.fts.data.msg.FTSMessage;
import com.tencent.mobileqq.fts.data.msg.FTSMessageDelete;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes7.dex */
public class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final ConcurrentHashMap<String, Integer> f116738a;

    public w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f116738a = new ConcurrentHashMap<>();
        }
    }

    private void d(QQAppInterface qQAppInterface, BaseQQMessageFacade baseQQMessageFacade, long j3) {
        int i3 = 0;
        int i16 = 0;
        for (RecentUser recentUser : e(qQAppInterface.getProxyManager().m().getRecentList(true))) {
            int i17 = i3 + 1;
            if (recentUser.lastmsgtime > j3) {
                if (recentUser.uin.equals(AppConstants.TROOP_ASSISTANT_UIN)) {
                    i17--;
                } else {
                    if (h(recentUser.uin, recentUser.getType())) {
                        i17--;
                        for (MessageRecord messageRecord : baseQQMessageFacade.Q(recentUser.uin, recentUser.getType())) {
                            i17++;
                            if (messageRecord.time > j3) {
                                i16++;
                                this.f116738a.put(MessageRecord.getTableName(messageRecord.senderuin, messageRecord.istroop), Integer.valueOf(messageRecord.istroop));
                            }
                        }
                    } else {
                        try {
                            if (Long.valueOf(recentUser.uin).longValue() > 10000) {
                                i16++;
                                this.f116738a.put(MessageRecord.getTableName(recentUser.uin, recentUser.getType()), Integer.valueOf(recentUser.getType()));
                            } else {
                                i17--;
                            }
                        } catch (NumberFormatException e16) {
                            i17--;
                            e16.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.d("MsgCountChecker", 2, "filterClipTable " + e16);
                            }
                        }
                    }
                    i3 = i17;
                }
            }
            i3 = i17;
        }
        if (i16 == i3) {
            Set<String> keySet = this.f116738a.keySet();
            Cursor cursor = null;
            try {
                try {
                    cursor = qQAppInterface.getWritableDatabase().rawQuery("select name from sqlite_master where type=\"table\" and (name like \"mr_friend%\" or name like \"mr_troop%\" or name like \"mr_discusssion%\" or name like \"mr_guild%\" or name like \"mr_contact%\" or name like \"mr_data_line%\" or name like \"mr_devicemsg%\")", null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            String encode = SecurityUtile.encode(cursor.getString(0));
                            if (!g(qQAppInterface, encode) && !keySet.contains(encode)) {
                                this.f116738a.put(encode, Integer.valueOf(MessageRecord.getTypeByTableName(encode)));
                            }
                        }
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgCountChecker", 2, "filterClipTable " + e17);
                    }
                    if (cursor == null) {
                        return;
                    }
                }
                cursor.close();
            } catch (Throwable th5) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th5;
            }
        }
    }

    private List<RecentUser> e(List<RecentUser> list) {
        ArrayList arrayList = new ArrayList();
        for (RecentUser recentUser : list) {
            if (!ao.t(recentUser.getType(), recentUser.uin)) {
                arrayList.add(recentUser);
            }
        }
        return arrayList;
    }

    private boolean f(HashSet<String> hashSet, FTSMessageDelete fTSMessageDelete, String str) {
        if (TextUtils.isEmpty(str)) {
            fTSMessageDelete.deleteOne();
            return false;
        }
        if (hashSet.contains(str)) {
            return true;
        }
        try {
            fTSMessageDelete.delCounter = Long.valueOf(Long.parseLong(str)).longValue();
            fTSMessageDelete.deletePatch();
            hashSet.add(str);
            return false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgCountChecker", 2, e16.toString());
                return false;
            }
            return false;
        }
    }

    private boolean g(QQAppInterface qQAppInterface, String str) {
        int m3 = ad.m(str);
        Message S = ((IMessageFacadeService) QRoute.api(IMessageFacadeService.class)).getMessageFacade(qQAppInterface).F(m3).y(m3).S(str, qQAppInterface.getEntityManagerFactory().createEntityManager());
        if (S != null && ao.t(S.istroop, S.frienduin)) {
            return true;
        }
        return false;
    }

    private void i(com.tencent.mobileqq.persistence.g gVar, List<MessageRecord> list) {
        HashSet<String> hashSet = new HashSet<>(5);
        for (MessageRecord messageRecord : list) {
            if (messageRecord.isSupportFTS() && messageRecord.isValid && messageRecord.msgtype != -2006) {
                FTSMessage c16 = com.tencent.mobileqq.fts.v1.utils.a.c(messageRecord);
                c16.deleteOpt();
                FTSMessageDelete b16 = com.tencent.mobileqq.fts.v1.utils.a.b(c16);
                if (!f(hashSet, b16, messageRecord.getExtInfoFromExtStr("ExtraFTSMsgCounter"))) {
                    gVar.persistOrReplace(b16);
                }
            }
        }
    }

    public void a(QQAppInterface qQAppInterface) {
        ConcurrentHashMap concurrentHashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
            return;
        }
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        SharedPreferences sharedPreferences = qQAppInterface.getApplication().getSharedPreferences(qQAppInterface.getCurrentAccountUin(), 0);
        long j3 = sharedPreferences.getLong("table_last_clip_time", 0L);
        if ((System.currentTimeMillis() / 1000) - j3 < 86400) {
            return;
        }
        try {
            d(qQAppInterface, messageFacade, j3);
            StringBuilder sb5 = new StringBuilder("MessageFacade : checkMsgCounts:");
            synchronized (this.f116738a) {
                concurrentHashMap = new ConcurrentHashMap(this.f116738a);
                this.f116738a.clear();
            }
            for (String str : concurrentHashMap.keySet()) {
                int intValue = ((Integer) concurrentHashMap.get(str)).intValue();
                if (QLog.isColorLevel()) {
                    sb5.append(" tableName:");
                    sb5.append(str);
                    sb5.append(";");
                }
                b(qQAppInterface, str, intValue);
            }
            sharedPreferences.edit().putLong("table_last_clip_time", System.currentTimeMillis() / 1000).commit();
            if (QLog.isColorLevel()) {
                QLog.d("MsgCountChecker", 2, sb5.toString());
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.d("MsgCountChecker", 2, "checkMsgCounts " + e16);
            }
        }
    }

    public void b(QQAppInterface qQAppInterface, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, str, Integer.valueOf(i3));
        } else {
            c(qQAppInterface, str, i3, 6000, 5000);
        }
    }

    public void c(QQAppInterface qQAppInterface, String str, int i3, int i16, int i17) {
        int count;
        String format;
        String format2;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 3;
        char c17 = 2;
        char c18 = 0;
        int i19 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        SQLiteDatabase writableDatabase = qQAppInterface.getWritableDatabase();
        if (writableDatabase != null && (count = writableDatabase.getCount(str)) > i16) {
            int max = Math.max(count - i17, 1200);
            com.tencent.mobileqq.persistence.g gVar = (com.tencent.mobileqq.persistence.g) qQAppInterface.getEntityManagerFactory().a();
            EntityTransaction transaction = gVar.getTransaction();
            int i26 = (max / 2500) + 1;
            int i27 = max / i26;
            int i28 = 0;
            while (i28 < i26) {
                if (i3 == 0) {
                    Object[] objArr = new Object[i18];
                    objArr[c18] = str;
                    objArr[i19] = str;
                    objArr[c17] = Integer.valueOf(i27);
                    format = String.format("delete from %s where time in (select time from %s order by time limit %s)", objArr);
                    Object[] objArr2 = new Object[i18];
                    objArr2[c18] = str;
                    objArr2[i19] = str;
                    objArr2[2] = Integer.valueOf(i27);
                    format2 = String.format("SELECT * FROM %s WHERE time IN (SELECT time FROM %s ORDER BY time LIMIT %s)", objArr2);
                } else if (i3 != i19 && i3 != 3000 && i3 != 10014 && i3 != 1026) {
                    Object[] objArr3 = new Object[i18];
                    objArr3[0] = str;
                    objArr3[i19] = str;
                    objArr3[2] = Integer.valueOf(i27);
                    format = String.format("delete from %s where _id in (select _id from %s order by _id limit %s)", objArr3);
                    Object[] objArr4 = new Object[i18];
                    objArr4[0] = str;
                    objArr4[i19] = str;
                    objArr4[2] = Integer.valueOf(i27);
                    format2 = String.format("SELECT * FROM %s WHERE _id IN (SELECT _id FROM %s ORDER BY _id LIMIT %s)", objArr4);
                } else {
                    Object[] objArr5 = new Object[i18];
                    objArr5[0] = str;
                    objArr5[1] = str;
                    objArr5[2] = Integer.valueOf(i27);
                    format = String.format("delete from %s where shmsgseq in (select shmsgseq from %s order by shmsgseq limit %s)", objArr5);
                    Object[] objArr6 = new Object[i18];
                    objArr6[0] = str;
                    objArr6[1] = str;
                    objArr6[2] = Integer.valueOf(i27);
                    format2 = String.format("SELECT * FROM %s WHERE shmsgseq IN (SELECT shmsgseq FROM %s ORDER BY shmsgseq LIMIT %s)", objArr6);
                }
                long currentTimeMillis = System.currentTimeMillis();
                List<MessageRecord> list = null;
                if (transaction != null) {
                    try {
                        try {
                            transaction.begin();
                        } catch (Exception e16) {
                            QLog.d("MsgCountChecker", 1, "checkRecordCount " + e16);
                            if (transaction != null) {
                                transaction.end();
                            }
                        }
                    } catch (Throwable th5) {
                        if (transaction != null) {
                            transaction.end();
                        }
                        throw th5;
                    }
                }
                list = gVar.e(format2, null);
                if (list != null) {
                    i(gVar, list);
                }
                writableDatabase.execSQL(format);
                if (transaction != null) {
                    transaction.commit();
                }
                if (transaction != null) {
                    transaction.end();
                }
                if (list != null && list.size() > 0) {
                    QSlowTableManager qSlowTableManager = (QSlowTableManager) qQAppInterface.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
                    if (qSlowTableManager != null) {
                        if (!qSlowTableManager.c().isOpen()) {
                            break;
                        } else {
                            qSlowTableManager.g(str, list);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        c16 = 2;
                        QLog.d("MsgCountChecker", 2, "transfer " + str + " " + i27 + "|" + i28 + "|" + max + " rows cost " + (System.currentTimeMillis() - currentTimeMillis));
                        i28++;
                        c17 = c16;
                        i18 = 3;
                        c18 = 0;
                        i19 = 1;
                    }
                }
                c16 = 2;
                i28++;
                c17 = c16;
                i18 = 3;
                c18 = 0;
                i19 = 1;
            }
            gVar.close();
        }
    }

    boolean h(String str, int i3) {
        return ao.z(str, i3);
    }
}
