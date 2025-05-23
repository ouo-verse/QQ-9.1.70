package com.tencent.imcore.message;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.util.LargerInteger;
import com.tencent.imcore.message.api.INTMsgProxyUtilsApi;
import com.tencent.imcore.message.f;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.MsgQueueItem;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.Metadata;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.br;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.NTOperateUtils;
import com.tencent.util.DeprecatedMethodInvokeReport;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class y extends f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static f.a f116741e;

    /* renamed from: b, reason: collision with root package name */
    protected EntityManager f116742b;

    /* renamed from: c, reason: collision with root package name */
    private Object f116743c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f116744d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37300);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 173)) {
            redirector.redirect((short) 173);
        } else {
            f116741e = new ac();
            s.a();
        }
    }

    @Metadata
    public y(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
            return;
        }
        this.f116742b = null;
        this.f116743c = new Object();
        this.f116744d = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105699", false);
    }

    private long A1(int i3, List<MessageRecord> list, long j3) {
        if (ao.u(i3) || ao.v(i3)) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                long j16 = it.next().shmsgseq;
                if (j16 < j3) {
                    j3 = j16;
                }
            }
        }
        return j3;
    }

    private void A2(String str, int i3, int i16) {
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null && !D1.isEmpty()) {
            for (MessageRecord messageRecord : D1) {
                if (!messageRecord.isread && messageRecord.getConfessTopicId() == i16) {
                    messageRecord.isread = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "setMsgRead " + D1.get(D1.size() - 1).getBaseInfoString());
            }
            List<MessageRecord> z16 = z(str, i3);
            if (z16 != null && !z16.isEmpty()) {
                for (MessageRecord messageRecord2 : z16) {
                    if (!messageRecord2.isread && messageRecord2.getConfessTopicId() == i16) {
                        messageRecord2.isread = true;
                    }
                }
            }
        }
    }

    private int B1(int i3, MessageRecord messageRecord) {
        int i16 = messageRecord.versionCode;
        if (i16 < i3) {
            return i16;
        }
        return i3;
    }

    private boolean B2(String str, int i3, String str2) {
        return f116741e.o(str, i3, str2, this);
    }

    private List<MessageRecord> H1(String str, int i3, String str2) {
        List<MessageRecord> C1 = C1(str2);
        if (C1 == null) {
            long nanoTime = System.nanoTime();
            List<MessageRecord> M = M(str, i3);
            V1(str, i3, M);
            f116741e.d(str, i3, str2, M, nanoTime, this);
            return M;
        }
        return C1;
    }

    private void O0(List<MessageRecord> list, ProxyListener proxyListener) {
        if (ae.c(list)) {
            return;
        }
        for (MessageRecord messageRecord : list) {
            if (messageRecord.versionCode > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("vip", 2, "proxy addSync id=" + messageRecord.vipBubbleID);
                }
                BaseProxyManager baseProxyManager = this.proxyManager;
                String str = messageRecord.frienduin;
                int i3 = messageRecord.istroop;
                baseProxyManager.addMsgQueueDonotNotify(str, i3, N1(str, i3), messageRecord, 0, proxyListener);
                f116741e.v(messageRecord);
            }
        }
        this.proxyManager.transSaveToDatabase();
    }

    private void P0(int[] iArr, HashSet<Integer> hashSet) {
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                hashSet.add(Integer.valueOf(i3));
            }
        }
    }

    private List<MessageRecord> Q1(String str, int i3) {
        List<MessageRecord> C1 = C1(t1(str, i3));
        if (C1 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "init from cache, uin=" + str);
            }
            return C1;
        }
        long currentTimeMillis = System.currentTimeMillis();
        final String s16 = s1(str, i3);
        boolean Z1 = Z1(str, i3, false);
        if (Z1) {
            this.proxyManager.transSaveToDatabase();
        }
        List<MessageRecord> F1 = F1(str, i3);
        List<MessageRecord> g16 = ConversationFacadeExt.f116416a.g(N1(str, i3), new Function0() { // from class: com.tencent.imcore.message.x
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List Y1;
                Y1 = y.this.Y1(s16);
                return Y1;
            }
        });
        if (g16 != null && g16.size() > 0) {
            for (int i16 = 0; i16 < g16.size(); i16++) {
                MessageRecord messageRecord = g16.get(i16);
                if (messageRecord != null && messageRecord.isSendFromLocal() && messageRecord.extraflag == 32772 && !f116741e.p(this.app, messageRecord)) {
                    QLog.e("Q.msg.MsgProxy", 1, "set sending message FAILED: ", messageRecord);
                    messageRecord.setExtraFlag(32768);
                }
            }
        }
        if (g16 != null) {
            int size = g16.size() / 2;
            int size2 = g16.size() - 1;
            int i17 = 0;
            while (i17 < size) {
                MessageRecord messageRecord2 = g16.get(i17);
                g16.set(i17, g16.get(size2));
                g16.set(size2, messageRecord2);
                i17++;
                size2--;
            }
        } else {
            g16 = new ArrayList<>();
        }
        Iterator<MessageRecord> it = ao.a(g16, F1).iterator();
        while (it.hasNext()) {
            f116741e.t(g16, it.next(), true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "init from db, uin=", str, ", isSaveToDatabase=", Boolean.valueOf(Z1), ", cost=", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), " sqlStr = ", s16, " size =", Integer.valueOf(g16.size()));
        }
        return g16;
    }

    private void R0(String str, int i3) {
        List<MessageRecord> h26;
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null && !D1.isEmpty()) {
            f116741e.w(D1, this);
            h26 = p1(str, i3, D1);
        } else {
            h26 = h2(str, i3);
        }
        if (h26 == null) {
            h26 = new ArrayList<>();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "continuedList :" + h26.size());
        }
        c2(str, i3, h26);
    }

    private void T0(String str, int i3, String str2, String str3, int i16) {
        List<MessageRecord> D1 = D1(str, i3);
        ArrayList arrayList = new ArrayList();
        if (D1 != null) {
            for (MessageRecord messageRecord : D1) {
                String str4 = messageRecord.senderuin;
                if (str4 != null && messageRecord.selfuin != null && str4.equals(str2) && messageRecord.selfuin.equals(str3) && ((i16 != 0 && i16 == messageRecord.getExtraKey()) || i16 == 0)) {
                    arrayList.add(messageRecord);
                }
            }
            D1.removeAll(arrayList);
        }
        if (i16 == 0) {
            Z0(str, i3, N1(str, i3), "senderuin=? and selfuin=?", new String[]{str2, str3}, null);
        } else if (i3 == 1032) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                u((MessageRecord) it.next(), false);
            }
        }
        arrayList.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a9, code lost:
    
        if (r12 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ab, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00b9, code lost:
    
        r12 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00be, code lost:
    
        r12.add(new com.tencent.mobileqq.persistence.transaction.DeleteTransaction(r11, null, null));
        D().doMultiDBOperateByTransaction(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00ce, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00cf, code lost:
    
        r11.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d6, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d8, code lost:
    
        com.tencent.qphone.base.util.QLog.e("Q.msg.MsgProxy", 2, "clearAllHistoryFromDB: ", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b6, code lost:
    
        if (r12 == null) goto L35;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void U0(EntityTransaction entityTransaction, SQLiteDatabase sQLiteDatabase, String[] strArr, int i3) {
        String str;
        Cursor cursor;
        String str2 = strArr[i3];
        ?? r142 = 0;
        if (str2.startsWith("mr_friend")) {
            str = "select frienduin, istroop, time as tmpseq, issend from " + str2 + " where time=(select max(time) from " + str2 + ")";
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("", 2, "sql zsw =" + str);
        }
        try {
            try {
                cursor = sQLiteDatabase.rawQuery(str, null);
                if (cursor != null) {
                    try {
                        if (cursor.getCount() > 0) {
                            cursor.moveToFirst();
                            long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("tmpseq"));
                            String string = cursor.getString(cursor.getColumnIndexOrThrow("frienduin"));
                            int i16 = cursor.getInt(cursor.getColumnIndexOrThrow(AppConstants.Key.COLUMN_IS_TROOP));
                            int i17 = cursor.getInt(cursor.getColumnIndexOrThrow(AppConstants.Key.COLUMN_IS_SEND));
                            if (!ao.u(i16) && !ao.v(i16) && i17 == 1) {
                                j3 += 2;
                            }
                            f116741e.y(string, i16, j3, this.app);
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e17) {
                e = e17;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                if (r142 != 0) {
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            r142 = sQLiteDatabase;
            if (r142 != 0) {
                r142.close();
            }
            throw th;
        }
    }

    private void U1(String str, int i3, MessageRecord messageRecord, boolean z16) {
        List<MessageRecord> D1 = D1(str, i3);
        String t16 = t1(str, i3);
        S1(str, i3, t16, D1);
        f116741e.t(D1, messageRecord, true);
        if (D1 != null && D1.size() > w1() && !ao.I(str)) {
            D1.remove(0);
        }
        b2(str, messageRecord, z16, t16);
    }

    private MessageRecord Y0(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16) {
        if (messageRecord == null) {
            return messageRecord2;
        }
        if (ao.D(messageRecord, messageRecord2)) {
            if (messageRecord.longMsgIndex > messageRecord2.longMsgIndex) {
                return messageRecord2;
            }
            return messageRecord;
        }
        if (z16) {
            if (messageRecord2.shmsgseq > messageRecord.shmsgseq) {
                return messageRecord2;
            }
            return messageRecord;
        }
        if (messageRecord2.time > messageRecord.time) {
            return messageRecord2;
        }
        return messageRecord;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List Y1(String str) {
        return f116741e.c(str, null, this);
    }

    private int b1(String str, int i3) {
        int i16;
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null) {
            i16 = D1.size();
            D1.clear();
        } else {
            i16 = 0;
        }
        if (l1().containsKey(t1(str, i3))) {
            l1().remove(t1(str, i3));
        }
        return i16;
    }

    private void b2(String str, MessageRecord messageRecord, boolean z16, String str2) {
        if (l1().containsKey(str2) && z16) {
            List<MessageRecord> k16 = k1(str2);
            if (k16 == null) {
                k16 = new ArrayList<>();
            }
            f116741e.k(str, messageRecord, k16, this);
        }
    }

    @Nullable
    private MessageRecord d1(String str, int i3, long j3) {
        MessageRecord messageRecord;
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null) {
            Iterator<MessageRecord> it = D1.iterator();
            while (it.hasNext()) {
                messageRecord = it.next();
                if (messageRecord.getId() == j3) {
                    D1.remove(messageRecord);
                    break;
                }
            }
        }
        messageRecord = null;
        List<MessageRecord> z16 = z(str, i3);
        if (z16 != null) {
            for (MessageRecord messageRecord2 : z16) {
                if (messageRecord2.getId() == j3) {
                    z16.remove(messageRecord2);
                    return messageRecord2;
                }
            }
            return messageRecord;
        }
        return messageRecord;
    }

    private Message d2(String str, EntityManager entityManager, int i3, int i16) {
        boolean z16;
        String str2;
        if (a2(str, true)) {
            this.proxyManager.transSaveToDatabase(entityManager);
        }
        if (!str.startsWith("mr_discusssion") && !str.startsWith("mr_troop")) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean endsWith = str.endsWith("_New");
        String str3 = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + ao.k() + " and m.longMsgId='%d' and m.issend='%d' order by %s limit 1";
        Object[] objArr = new Object[6];
        objArr[0] = str;
        objArr[1] = str;
        objArr[2] = str;
        objArr[3] = Integer.valueOf(i3);
        objArr[4] = Integer.valueOf(i16);
        if (endsWith) {
            if (z16) {
                str2 = "longMsgIndex asc , shmsgseq desc , _id desc";
            } else {
                str2 = "longMsgIndex asc , time desc , _id desc";
            }
        } else {
            str2 = "_id desc";
        }
        objArr[5] = str2;
        List<Entity> rawQuery = DBMethodProxy.rawQuery(D(), Message.class, String.format(str3, objArr), null);
        if (rawQuery == null || rawQuery.isEmpty()) {
            return null;
        }
        return (Message) rawQuery.get(0);
    }

    @Nullable
    private MessageRecord e1(String str, int i3, long j3) {
        MessageRecord messageRecord;
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null) {
            Iterator<MessageRecord> it = D1.iterator();
            while (it.hasNext()) {
                messageRecord = it.next();
                if (messageRecord.uniseq == j3) {
                    D1.remove(messageRecord);
                    break;
                }
            }
        }
        messageRecord = null;
        List<MessageRecord> z16 = z(str, i3);
        if (z16 != null) {
            for (MessageRecord messageRecord2 : z16) {
                if (messageRecord2.uniseq == j3) {
                    z16.remove(messageRecord2);
                    return messageRecord2;
                }
            }
            return messageRecord;
        }
        return messageRecord;
    }

    @Nullable
    private MessageRecord f1(String str, int i3, long j3) {
        List<MessageRecord> C1 = C1(t1(str, i3));
        if (C1 != null) {
            for (MessageRecord messageRecord : C1) {
                if (messageRecord.uniseq == j3) {
                    C1.remove(messageRecord);
                    return messageRecord;
                }
            }
        }
        return null;
    }

    private List<MessageRecord> h2(String str, int i3) {
        return i2(str, i3, 15);
    }

    @Nullable
    private List<MessageRecord> i1(String str, int i3, boolean z16) {
        List<MessageRecord> k16 = k1(t1(str, i3));
        if (k16 != null && !k16.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList from aioPool size = " + k16.size());
            }
        } else if (j1(str, i3, z16)) {
            return null;
        }
        return k1(t1(str, i3));
    }

    private boolean j1(String str, int i3, boolean z16) {
        if (z16) {
            R0(str, i3);
            return false;
        }
        l1().remove(t1(str, i3));
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MsgProxy", 4, "getAioMsgPool().remove");
            return true;
        }
        return true;
    }

    public static List<MessageRecord> n1(List<MessageRecord> list, long j3) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                MessageRecord messageRecord = list.get(i3);
                if (messageRecord.time >= j3) {
                    arrayList.add(messageRecord);
                }
            }
            return arrayList;
        }
        return null;
    }

    private Pair<Long, Long> o1(String str) {
        return f116741e.x(str, this.app);
    }

    private List<MessageRecord> q1(String str, int i3, List<MessageRecord> list, List<MessageRecord> list2) {
        boolean z16;
        List<MessageRecord> n16;
        if (list.size() > 15) {
            list2.addAll(list.subList(list.size() - 15, list.size()));
        } else {
            list2.addAll(list);
        }
        if (!ao.m(str, i3, list2) && !ao.o(list2)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (list.size() > 15 && z16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "getAIOMsgList : pull more long msg");
            }
            list2.clear();
            if (list.size() > 30) {
                list2.addAll(list.subList(list.size() - 30, list.size()));
            } else {
                list2.addAll(list);
            }
        }
        Pair<Long, Long> o16 = o1(str);
        if (o16 != null && (n16 = n1(list2, ((Long) o16.first).longValue())) != null && !n16.isEmpty()) {
            return n16;
        }
        return list2;
    }

    private void s2(List<MessageRecord> list, long j3) {
        if (list == null) {
            return;
        }
        Iterator<MessageRecord> it = list.iterator();
        while (it.hasNext()) {
            long j16 = it.next().time;
            if (j16 == j3) {
                it.remove();
            } else if (j16 > j3) {
                return;
            }
        }
    }

    private MessageRecord u1(String str, int i3, int i16) {
        String baseInfoString;
        List<MessageRecord> r16 = r(str, i3);
        MessageRecord messageRecord = null;
        if (r16 != null && !r16.isEmpty()) {
            for (int size = r16.size() - 1; size >= 0; size--) {
                if (i16 == 0 || r16.get(size).getConfessTopicId() == i16) {
                    messageRecord = r16.get(size);
                    break;
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getLastMsgFromList mr = ");
                if (messageRecord == null) {
                    baseInfoString = "null";
                } else {
                    baseInfoString = messageRecord.getBaseInfoString();
                }
                sb5.append(baseInfoString);
                QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
            }
        }
        if (messageRecord == null) {
            QLog.e("Q.msg.MsgProxy", 1, "getLastMsgFromList no cache", str, ",", Integer.valueOf(i3), ",", Integer.valueOf(i16));
            f116741e.b(this.app, str, i3);
            return e2(str, i3, i16);
        }
        return messageRecord;
    }

    private void v2(String str, int i3, int i16) {
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            A2(str, i3, i16);
        } finally {
            J1.unlock();
        }
    }

    public static void w2(f.a aVar) {
        f116741e = aVar;
    }

    @Nullable
    private MessageRecord x1(String str, int i3, long j3, int i16) {
        List<MessageRecord> C1 = C1(t1(str, i3));
        if (C1 != null) {
            for (MessageRecord messageRecord : C1) {
                if (messageRecord.shmsgseq == j3 && messageRecord.msgtype == i16) {
                    return messageRecord;
                }
            }
        }
        return null;
    }

    private long y1(long j3, MessageRecord messageRecord) {
        long j16 = messageRecord.time;
        if (j16 < j3) {
            return j16;
        }
        return j3;
    }

    private long z1(long j3, MessageRecord messageRecord) {
        if (messageRecord.getId() > 0 && messageRecord.getId() < j3) {
            return messageRecord.getId();
        }
        return j3;
    }

    private void z2(String str, int i3, long j3) {
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null && !D1.isEmpty()) {
            for (MessageRecord messageRecord : D1) {
                if (!messageRecord.isread && W1(i3, j3, messageRecord) && (!ao.G(i3) || !ao.y(messageRecord.msgtype))) {
                    messageRecord.isread = true;
                }
            }
            List<MessageRecord> z16 = z(str, i3);
            if (z16 != null && !z16.isEmpty()) {
                for (MessageRecord messageRecord2 : z16) {
                    if (!messageRecord2.isread && W1(i3, j3, messageRecord2) && (!ao.G(i3) || !ao.y(messageRecord2.msgtype))) {
                        messageRecord2.isread = true;
                    }
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> A(String str, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy_", 2, "getAIOMsgList peerUin: " + str + " type: " + i3 + " , autoInit = " + z16);
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return i1(str, i3, z16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord A0(String str, int i3, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 106)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 106, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2);
        }
        if (str2 == null) {
            return null;
        }
        QLog.i("Q.msg.MsgProxy", 1, "updateMsgContentByUniseq1 peerUin=" + MsfSdkUtils.getShortUin(str) + ",type=" + i3 + ",uniseq=" + j3 + ",msgDataSize=" + str2.length());
        MessageRecord H = H(str, i3, j3);
        ContentValues contentValues = new ContentValues();
        if (H != null) {
            if (H.versionCode > 0) {
                try {
                    contentValues.put(AppConstants.Key.COLUMN_MSG_DATA, str2.getBytes("UTF-8"));
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                contentValues.put("msg", str2);
            }
            H.f203106msg = str2;
            H.msgData = str2.getBytes();
            if (H.getId() > 0) {
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
            }
        } else {
            try {
                contentValues.put(AppConstants.Key.COLUMN_MSG_DATA, str2.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MsgProxy", 2, "updateMsgContentByUniseq fail!" + e16);
                }
            }
            C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
        }
        return H;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> B(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (List) iPatchRedirector.redirect((short) 26, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return h1(str, i3, j3, i16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord B0(String str, int i3, long j3, byte[] bArr) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 107)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 107, this, str, Integer.valueOf(i3), Long.valueOf(j3), bArr);
        }
        MessageRecord H = H(str, i3, j3);
        ContentValues contentValues = new ContentValues();
        if (bArr != null) {
            contentValues.put(AppConstants.Key.COLUMN_MSG_DATA, bArr);
            i16 = bArr.length;
        } else {
            i16 = -1;
        }
        QLog.i("Q.msg.MsgProxy", 1, "updateMsgContentByUniseq2 peerUin=" + MsfSdkUtils.getShortUin(str) + ",type=" + i3 + ",uniseq=" + j3 + ",msgDataSize=" + i16);
        if (H != null) {
            H.msgData = bArr;
            if (H.getId() > 0) {
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
            }
        } else {
            C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
        }
        return H;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord C0(String str, int i3, long j3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 104)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 104, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        MessageRecord H = H(str, i3, j3);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_EXTRA_FLAG, Integer.valueOf(i16));
        contentValues.put(AppConstants.Key.COLUMN_SEND_FAIL_CODE, Integer.valueOf(i17));
        if (H != null) {
            H.setExtraFlag(i16);
            H.setSendFailCode(i17);
            if (H.getId() > 0) {
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(H.uniseq)}, null);
            }
        } else {
            C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
        }
        return H;
    }

    protected List<MessageRecord> C1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        return I1().get(str);
    }

    public void C2(String str, int i3, int i16, ContentValues contentValues, String str2, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, this, str, Integer.valueOf(i3), Integer.valueOf(i16), contentValues, str2, strArr, proxyListener);
        } else if (i16 > 0) {
            this.proxyManager.addMsgQueue(str, i3, N1(str, i3), contentValues, str2, strArr, 1, proxyListener);
        } else {
            this.proxyManager.addMsgQueue(str, i3, K1(str, i3), contentValues, str2, strArr, 1, proxyListener);
        }
    }

    @Override // com.tencent.imcore.message.f
    public EntityManager D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (EntityManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        EntityManager entityManager = this.f116742b;
        if (entityManager == null || !entityManager.isOpen()) {
            synchronized (this.f116743c) {
                EntityManager entityManager2 = this.f116742b;
                if (entityManager2 == null || !entityManager2.isOpen()) {
                    this.f116742b = f116741e.h(this.app);
                }
            }
        }
        return this.f116742b;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord D0(String str, int i3, long j3, String str2, Object obj) {
        Field declaredField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 105)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 105, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, obj);
        }
        MessageRecord H = H(str, i3, j3);
        try {
            declaredField = MessageRecord.class.getDeclaredField(str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq error! ", e16);
            }
        }
        if (declaredField == null) {
            QLog.e("Q.msg.MsgProxy", 1, "updateMsgFieldByUniseq: field == null");
            return H;
        }
        Class<?> type = declaredField.getType();
        declaredField.setAccessible(true);
        declaredField.set(H, obj);
        if (!Modifier.isStatic(declaredField.getModifiers()) && !declaredField.isAnnotationPresent(notColumn.class)) {
            ContentValues contentValues = new ContentValues();
            if (type == Long.TYPE) {
                contentValues.put(str2, (Long) obj);
            } else if (type == Integer.TYPE) {
                contentValues.put(str2, (Integer) obj);
            } else if (type == String.class) {
                contentValues.put(str2, (String) obj);
            } else if (type == Byte.TYPE) {
                contentValues.put(str2, (Byte) obj);
            } else if (type == byte[].class) {
                contentValues.put(str2, (byte[]) obj);
            } else if (type == Short.TYPE) {
                contentValues.put(str2, (Short) obj);
            } else if (type == Boolean.TYPE) {
                contentValues.put(str2, (Boolean) obj);
            } else if (type == Float.TYPE) {
                contentValues.put(str2, (Float) obj);
            } else if (type == Double.TYPE) {
                contentValues.put(str2, (Double) obj);
            } else if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MsgProxy", 2, "updateMsgFieldByUniseq fieldType error! " + type.getClass().getSimpleName());
            }
            if (H.getId() > 0) {
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(H.uniseq)}, null);
            }
            return H;
        }
        return H;
    }

    public List<MessageRecord> D1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3);
        }
        String t16 = t1(str, i3);
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return H1(str, i3, t16);
        } finally {
            J1.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D2(String str, int i3, String str2, ContentValues contentValues, String str3, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 75)) {
            iPatchRedirector.redirect((short) 75, this, str, Integer.valueOf(i3), str2, contentValues, str3, strArr, proxyListener);
        } else {
            this.proxyManager.addMsgQueue(str, i3, str2, contentValues, str3, strArr, 1, proxyListener);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord E(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3);
        }
        return F(str, i3, 0);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord E0(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 109)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 109, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        MessageRecord H = H(str, i3, j3);
        if (H != null) {
            H.time = j16;
            H.shmsgseq = j17;
            x(str, i3, j3);
            N(str, i3, H);
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", Long.valueOf(j16));
        contentValues.put(AppConstants.Key.COLUMN_SHMSG_SEQ, Long.valueOf(j17));
        if (H != null) {
            if (H.getId() > 0) {
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
            }
        } else {
            C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
        }
        return H;
    }

    protected List<MessageRecord> E1(String str) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return (List) iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        }
        synchronized (this.proxyManager.getMsgQueueLock()) {
            Vector<MsgQueueItem> queue = this.proxyManager.getQueue();
            arrayList = new ArrayList();
            Iterator<MsgQueueItem> it = queue.iterator();
            while (it.hasNext()) {
                MsgQueueItem next = it.next();
                Entity entity = next.item;
                if (entity instanceof MessageRecord) {
                    MessageRecord messageRecord = (MessageRecord) entity;
                    if (TextUtils.equals(str, next.tableName) && next.action == 0) {
                        arrayList.add(messageRecord);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "getMsgListFromQueue tableName=", str, ", size=", Integer.valueOf(arrayList.size()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord F(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 17, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return u1(str, i3, i16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public void F0(String str, int i3, long j3, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 108)) {
            iPatchRedirector.redirect((short) 108, this, str, Integer.valueOf(i3), Long.valueOf(j3), contentValues);
            return;
        }
        QLog.i("Q.msg.MsgProxy", 1, "updateRecordField uin=" + MsfSdkUtils.getShortUin(str) + ",uniseq=" + j3 + ",type=" + i3);
        MessageRecord H = H(str, i3, j3);
        if (H != null) {
            if (H.getId() > 0) {
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
                return;
            } else {
                C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
                return;
            }
        }
        C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
    }

    protected List<MessageRecord> F1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (List) iPatchRedirector.redirect((short) 46, (Object) this, (Object) str, i3);
        }
        return G1(str, i3, 0);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord G(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 70, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return x1(str, i3, j3, i16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public void G0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 152)) {
            iPatchRedirector.redirect((short) 152, (Object) this);
        } else if (this.proxyManager.getQueue() != null && this.proxyManager.getQueue().size() > 0) {
            this.proxyManager.transSaveToDatabase(this.f116742b);
        }
    }

    public List<MessageRecord> G1(String str, int i3, int i16) {
        ArrayList arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (List) iPatchRedirector.redirect((short) 47, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        synchronized (this.proxyManager.getMsgQueueLock()) {
            Vector<MsgQueueItem> queue = this.proxyManager.getQueue();
            arrayList = new ArrayList();
            Iterator<MsgQueueItem> it = queue.iterator();
            while (it.hasNext()) {
                MsgQueueItem next = it.next();
                Entity entity = next.item;
                if (entity instanceof MessageRecord) {
                    MessageRecord messageRecord = (MessageRecord) entity;
                    if (ao.E(messageRecord.frienduin, str, messageRecord.istroop, i3) && next.action == 0 && (i16 <= 0 || messageRecord.getConfessTopicId() == i16)) {
                        arrayList.add(messageRecord);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "getMsgListFromQueue uin=", str, ", type=", Integer.valueOf(i3), ", size=", Integer.valueOf(arrayList.size()));
            }
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord H(String str, int i3, long j3) {
        List<MessageRecord> l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 33, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        MessageRecord messageRecord = null;
        if (j3 == 0 || str == null || str.length() == 0) {
            return null;
        }
        List<MessageRecord> p16 = p(str, i3);
        if (p16 != null) {
            Iterator<MessageRecord> it = p16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MessageRecord next = it.next();
                if (next.uniseq == j3) {
                    messageRecord = next;
                    break;
                }
            }
        }
        if (messageRecord == null && (l3 = l(str, i3)) != null) {
            for (MessageRecord messageRecord2 : l3) {
                if (messageRecord2.uniseq == j3) {
                    return messageRecord2;
                }
            }
            return messageRecord;
        }
        return messageRecord;
    }

    @Override // com.tencent.imcore.message.f
    public MsgPool I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (MsgPool) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.f116628a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I0(String str, int i3, Entity entity, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, this, str, Integer.valueOf(i3), entity, proxyListener);
            return;
        }
        if (entity instanceof MessageRecord) {
            MessageRecord messageRecord = (MessageRecord) entity;
            if (messageRecord.versionCode <= 0 || ae.b(messageRecord)) {
                return;
            }
            this.proxyManager.addMsgQueue(str, i3, N1(str, i3), entity, 0, proxyListener);
            f116741e.v(messageRecord);
        }
    }

    protected ConcurrentHashMap<String, List<MessageRecord>> I1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.f116628a.d();
    }

    protected void J0(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 85)) {
            iPatchRedirector.redirect((short) 85, this, str, Integer.valueOf(i3), list);
            return;
        }
        if (l1().containsKey(t1(str, i3))) {
            List<MessageRecord> k16 = k1(t1(str, i3));
            if (k16 == null) {
                k16 = new ArrayList<>();
            }
            List<MessageRecord> list2 = k16;
            List<MessageRecord> a16 = ao.a(list2, list);
            f116741e.z(str, i3, a16, list2, this.app);
            list.clear();
            list.addAll(a16);
        }
    }

    protected Lock J1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (Lock) iPatchRedirector.redirect((short) 58, (Object) this, (Object) str, i3);
        }
        return this.f116628a.e(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord K(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 160)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 160, this, str, Integer.valueOf(i3), messageRecord);
        }
        return null;
    }

    protected void K0(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 86)) {
            iPatchRedirector.redirect((short) 86, this, str, Integer.valueOf(i3), list);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "addAIOMessageLocked");
        }
        if (l1().containsKey(t1(str, i3))) {
            List<MessageRecord> k16 = k1(t1(str, i3));
            if (k16 == null) {
                k16 = new ArrayList<>();
            }
            List<MessageRecord> list2 = k16;
            List<MessageRecord> a16 = ao.a(list2, list);
            f116741e.A(str, i3, a16, list2, this.app);
            list.clear();
            list.addAll(a16);
        }
    }

    @NonNull
    protected String K1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 126)) {
            return (String) iPatchRedirector.redirect((short) 126, (Object) this, (Object) str, i3);
        }
        return MessageRecord.getOldTableName(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord L(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 140)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 140, this, str, Integer.valueOf(i3), messageRecord, list);
        }
        return null;
    }

    protected void L0(String str, int i3, long j3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, str, Integer.valueOf(i3), Long.valueOf(j3), list);
            return;
        }
        String t16 = t1(str, i3);
        if (I1().containsKey(t16)) {
            List<MessageRecord> C1 = C1(t16);
            int i16 = 0;
            while (true) {
                if (i16 < C1.size()) {
                    MessageRecord messageRecord = C1.get(i16);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MsgProxy", 2, "find cache " + messageRecord.getBaseInfoString());
                    }
                    if (messageRecord.uniseq == j3) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = 0;
                    break;
                }
            }
            if (i16 > 0 && i16 < C1.size()) {
                ArrayList arrayList = new ArrayList();
                for (int i17 = 0; i17 < i16; i17++) {
                    MessageRecord messageRecord2 = C1.get(i17);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MsgProxy", 2, "removeList " + messageRecord2.getBaseInfoString());
                    }
                    arrayList.add(messageRecord2);
                }
                C1.removeAll(arrayList);
                arrayList.clear();
                C1.addAll(0, list);
            } else if (i16 == 0) {
                C1.addAll(0, list);
            }
            if (C1.size() > w1()) {
                for (int size = C1.size() - w1(); size > 0; size--) {
                    C1.remove(0);
                }
            }
            V1(str, i3, C1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SQLiteDatabase L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 125)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 125, (Object) this);
        }
        return f116741e.r(this.app);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> M(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (List) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str, i3);
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return Q1(str, i3);
        } finally {
            J1.unlock();
        }
    }

    protected void M0(String str, int i3, long j3, long j16, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), list);
            return;
        }
        String t16 = t1(str, i3);
        if (I1().containsKey(t16)) {
            List<MessageRecord> C1 = C1(t16);
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            for (int i17 = 0; i17 < C1.size(); i17++) {
                MessageRecord messageRecord = C1.get(i17);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MsgProxy", 2, "find cache " + messageRecord.getBaseInfoString());
                }
                long j17 = messageRecord.uniseq;
                if (j17 >= j3 && j17 <= j16) {
                    if (arrayList.size() == 0) {
                        i16 = i17;
                    }
                    arrayList.add(messageRecord);
                }
                if (messageRecord.uniseq > j16) {
                    break;
                }
            }
            C1.removeAll(arrayList);
            C1.addAll(i16, list);
            if (C1.size() > w1()) {
                for (int size = C1.size() - w1(); size > 0; size--) {
                    C1.remove(0);
                }
            }
            V1(str, i3, C1);
        }
    }

    protected void M1(ah ahVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 156)) {
            iPatchRedirector.redirect((short) 156, (Object) this, (Object) ahVar);
        } else {
            f116741e.q(this.app, this.f116742b, ahVar);
        }
    }

    @Override // com.tencent.imcore.message.f
    public void N(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, this, str, Integer.valueOf(i3), messageRecord);
            return;
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            R1(str, i3, messageRecord);
        } finally {
            J1.unlock();
        }
    }

    protected void N0(String str, int i3, MessageRecord messageRecord, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 73)) {
            iPatchRedirector.redirect((short) 73, this, str, Integer.valueOf(i3), messageRecord, proxyListener);
            return;
        }
        if (messageRecord.versionCode > 0) {
            if (ae.b(messageRecord)) {
                return;
            }
            this.proxyManager.addMsgQueueDonotNotify(str, i3, N1(str, i3), messageRecord, 0, proxyListener);
            f116741e.v(messageRecord);
        }
        this.proxyManager.transSaveToDatabase();
    }

    @NonNull
    public String N1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 101)) {
            return (String) iPatchRedirector.redirect((short) 101, (Object) this, (Object) str, i3);
        }
        return MessageRecord.getTableName(str, i3);
    }

    @Override // com.tencent.imcore.message.f
    @Deprecated
    public Cursor O(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cursor) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
        }
        List<MessageRecord> p16 = p(str, i3);
        if (str.equals(String.valueOf(AppConstants.SYSTEM_MSG_UIN))) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < p16.size(); i16++) {
                arrayList.add(p16.get((p16.size() - i16) - 1));
            }
            new ArrayList();
            List<MessageRecord> i26 = i2(str, i3, Integer.MAX_VALUE);
            if (i26 != null) {
                for (int i17 = 0; i17 < i26.size(); i17++) {
                    arrayList.add(i26.get((i26.size() - i17) - 1));
                }
            }
            return new t(this, arrayList);
        }
        return new t(this, (List) ((ArrayList) p16).clone());
    }

    protected int O1(String str, int i3, long j3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        if (str == null) {
            return 0;
        }
        synchronized (this.proxyManager.getMsgQueueLock()) {
            Iterator<MsgQueueItem> it = this.proxyManager.getQueue().iterator();
            i16 = 0;
            while (it.hasNext()) {
                MsgQueueItem next = it.next();
                Entity entity = next.item;
                if (entity instanceof MessageRecord) {
                    MessageRecord messageRecord = (MessageRecord) entity;
                    if (ao.E(messageRecord.frienduin, str, messageRecord.istroop, i3) && next.action == 0 && messageRecord.time > j3 && !messageRecord.isread && !messageRecord.isSend()) {
                        i16++;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "getUnreadCountFromQueue uin=", str, ", type=", Integer.valueOf(i3), ", lastRead=", Integer.valueOf(i16));
            }
        }
        return i16;
    }

    @Override // com.tencent.imcore.message.f
    public void P(ah ahVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 155)) {
            iPatchRedirector.redirect((short) 155, (Object) this, (Object) ahVar);
            return;
        }
        if (TextUtils.isEmpty(ahVar.b())) {
            return;
        }
        if (Z1(ahVar.b(), ahVar.c(), true)) {
            this.proxyManager.transSaveToDatabase();
        }
        Cursor query = D().query(false, N1(ahVar.b(), ahVar.c()), (String[]) null, "msgtype in (?,?,?) AND time>=?", new String[]{String.valueOf(-1000), String.valueOf(MessageRecord.MSG_TYPE_MIX), String.valueOf(MessageRecord.MSG_TYPE_STRUCT_MSG), String.valueOf(NetConnInfoCenter.getServerTime() - 863913600)}, (String) null, (String) null, "time desc, longMsgIndex desc", String.valueOf(ahVar.a()));
        try {
            try {
                ahVar.d(query);
                M1(ahVar);
                if (query == null) {
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MsgProxy", 2, e16, new Object[0]);
                }
                if (query == null) {
                    return;
                }
            }
            query.close();
        } catch (Throwable th5) {
            if (query != null) {
                query.close();
            }
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SQLiteDatabase P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 96)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 96, (Object) this);
        }
        return f116741e.i(this.app);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> Q(String str, int i3, long j3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 163)) {
            return (List) iPatchRedirector.redirect((short) 163, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        return R(str, i3, j3, i16, true);
    }

    protected void Q0(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 83)) {
            iPatchRedirector.redirect((short) 83, this, str, Integer.valueOf(i3), list);
        } else {
            f116741e.f(str, i3, list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> R(String str, int i3, long j3, int i16, boolean z16) {
        List<MessageRecord> g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 164)) {
            return (List) iPatchRedirector.redirect((short) 164, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq uin=" + str + ", type=" + i3 + ", seq=" + j3 + ", count=" + i16);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase();
        }
        String N1 = N1(str, i3);
        String str2 = z16 ? "select * from " + N1 + " where (shmsgseq < ? and msgtype " + ao.h() + " and isValid=1) order by shmsgseq desc limit " : "select * from " + N1 + " where (shmsgseq < ?  and isValid=1) order by shmsgseq desc limit ";
        String[] strArr = {String.valueOf(j3)};
        List<MessageRecord> c16 = f116741e.c(str2 + i16, strArr, this);
        if (c16 == null) {
            c16 = new ArrayList<>();
        }
        List<MessageRecord> list = c16;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq list.size=" + list.size());
        }
        if (list.size() < i16 && (g16 = f116741e.g(str, i3, j3, i16 - list.size(), str2, strArr, this, this.app)) != null) {
            list.addAll(g16);
        }
        Collections.reverse(list);
        if (QLog.isColorLevel()) {
            for (MessageRecord messageRecord : list) {
                QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq " + messageRecord.time + ", " + messageRecord.getId() + ", " + messageRecord.getLogColorContent());
            }
            QLog.d("Q.msg.MsgProxy", 2, "queryBeforeHistoryByShmsgseq return size=" + list.size());
        }
        return list;
    }

    protected void R1(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, this, str, Integer.valueOf(i3), messageRecord);
            return;
        }
        List<MessageRecord> C1 = C1(t1(str, i3));
        if (C1 != null) {
            f116741e.t(C1, messageRecord, true);
            if (C1.size() > w1()) {
                C1.remove(0);
            }
            V1(str, i3, C1);
        }
    }

    @Override // com.tencent.imcore.message.f
    public Message S(String str, EntityManager entityManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (Message) iPatchRedirector.redirect((short) 43, (Object) this, (Object) str, (Object) entityManager);
        }
        return T(str, entityManager, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S0(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, this, str, Integer.valueOf(i3), list);
        } else {
            f116741e.m(str, i3, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean S1(String str, int i3, String str2, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 170)) {
            return ((Boolean) iPatchRedirector.redirect((short) 170, this, str, Integer.valueOf(i3), str2, list)).booleanValue();
        }
        if (!B2(str, i3, str2)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "insertToAioMsgPool because of orderMediaMsgSending " + str);
        }
        ArrayList arrayList = new ArrayList();
        if (list.size() > 15) {
            arrayList.addAll(list.subList(list.size() - 15, list.size()));
        } else {
            arrayList.addAll(list);
        }
        c2(str, i3, arrayList);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0119 A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:11:0x002f, B:13:0x0035, B:14:0x003a, B:16:0x0043, B:20:0x0050, B:24:0x008a, B:26:0x009f, B:28:0x00a5, B:31:0x00ae, B:33:0x00bb, B:36:0x00be, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:45:0x00d9, B:47:0x00df, B:49:0x00e5, B:52:0x00ee, B:54:0x00fa, B:56:0x00fd, B:61:0x0102, B:65:0x010e, B:66:0x0113, B:68:0x0119, B:72:0x0126, B:77:0x012e, B:78:0x0134, B:79:0x010c, B:80:0x0139), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x012e A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:11:0x002f, B:13:0x0035, B:14:0x003a, B:16:0x0043, B:20:0x0050, B:24:0x008a, B:26:0x009f, B:28:0x00a5, B:31:0x00ae, B:33:0x00bb, B:36:0x00be, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:45:0x00d9, B:47:0x00df, B:49:0x00e5, B:52:0x00ee, B:54:0x00fa, B:56:0x00fd, B:61:0x0102, B:65:0x010e, B:66:0x0113, B:68:0x0119, B:72:0x0126, B:77:0x012e, B:78:0x0134, B:79:0x010c, B:80:0x0139), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x010c A[Catch: all -> 0x013b, TryCatch #0 {, blocks: (B:11:0x002f, B:13:0x0035, B:14:0x003a, B:16:0x0043, B:20:0x0050, B:24:0x008a, B:26:0x009f, B:28:0x00a5, B:31:0x00ae, B:33:0x00bb, B:36:0x00be, B:38:0x00c7, B:40:0x00cd, B:42:0x00d1, B:45:0x00d9, B:47:0x00df, B:49:0x00e5, B:52:0x00ee, B:54:0x00fa, B:56:0x00fd, B:61:0x0102, B:65:0x010e, B:66:0x0113, B:68:0x0119, B:72:0x0126, B:77:0x012e, B:78:0x0134, B:79:0x010c, B:80:0x0139), top: B:10:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0087  */
    @Override // com.tencent.imcore.message.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Message T(String str, EntityManager entityManager, int i3) {
        boolean z16;
        boolean endsWith;
        String str2;
        List<Entity> rawQuery;
        Message message;
        List<MessageRecord> E1;
        int i16;
        int i17;
        int size;
        int size2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (Message) iPatchRedirector.redirect((short) 44, this, str, entityManager, Integer.valueOf(i3));
        }
        synchronized (f116741e.n(this.app)) {
            if (a2(str, false)) {
                this.proxyManager.transSaveToDatabase(entityManager);
            }
            if (!str.startsWith("mr_discusssion") && !str.startsWith("mr_troop")) {
                z16 = false;
                endsWith = str.endsWith("_New");
                String str3 = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + ao.k() + " order by %s limit 1";
                Object[] objArr = new Object[4];
                objArr[0] = str;
                objArr[1] = str;
                objArr[2] = str;
                if (!endsWith) {
                    if (z16) {
                        str2 = "shmsgseq desc , _id desc";
                    } else {
                        str2 = "time desc , _id desc";
                    }
                } else {
                    str2 = "_id desc";
                }
                objArr[3] = str2;
                rawQuery = DBMethodProxy.rawQuery(D(), Message.class, String.format(str3, objArr), new String[0]);
                message = null;
                if (rawQuery != null && !rawQuery.isEmpty()) {
                    for (size2 = rawQuery.size() - 1; size2 >= 0; size2--) {
                        if (i3 != 0 && ((Message) rawQuery.get(size2)).getConfessTopicId() != i3) {
                        }
                        message = (Message) rawQuery.get(size2);
                        break;
                    }
                    if (message != null && message.isLongMsg() && message.longMsgIndex > 0) {
                        message = d2(str, entityManager, message.longMsgId, message.issend);
                    }
                }
                E1 = E1(str);
                if (E1 != null && E1.size() > 0) {
                    for (size = E1.size() - 1; size >= 0; size--) {
                        if (i3 > 0 && E1.get(size).getConfessTopicId() != i3) {
                            E1.remove(size);
                        }
                    }
                }
                if (E1 != null && E1.size() > 0) {
                    if (message != null) {
                        i16 = 0;
                    } else {
                        i16 = message.unReadNum;
                    }
                    MessageRecord messageRecord = message;
                    for (MessageRecord messageRecord2 : E1) {
                        if (messageRecord2.isread) {
                            i17 = 0;
                        } else {
                            i17 = 1;
                        }
                        i16 += i17;
                        messageRecord = Y0(messageRecord, messageRecord2, z16);
                    }
                    if (message == null) {
                        message = new Message();
                    }
                    MessageRecord.copyMessageRecordBaseField(message, messageRecord);
                    message.unReadNum = i16;
                }
            }
            z16 = true;
            endsWith = str.endsWith("_New");
            String str32 = "select * from (select count() as unReadNum from %s mr where mr.isread=0),(select count() as hasReply from %s mr where mr.issend=0),%s m where m.isValid=1 and m.msgtype " + ao.k() + " order by %s limit 1";
            Object[] objArr2 = new Object[4];
            objArr2[0] = str;
            objArr2[1] = str;
            objArr2[2] = str;
            if (!endsWith) {
            }
            objArr2[3] = str2;
            rawQuery = DBMethodProxy.rawQuery(D(), Message.class, String.format(str32, objArr2), new String[0]);
            message = null;
            if (rawQuery != null) {
                while (size2 >= 0) {
                }
                if (message != null) {
                    message = d2(str, entityManager, message.longMsgId, message.issend);
                }
            }
            E1 = E1(str);
            if (E1 != null) {
                while (size >= 0) {
                }
            }
            if (E1 != null) {
                if (message != null) {
                }
                MessageRecord messageRecord3 = message;
                while (r11.hasNext()) {
                }
                if (message == null) {
                }
                MessageRecord.copyMessageRecordBaseField(message, messageRecord3);
                message.unReadNum = i16;
            }
        }
        return message;
    }

    protected void T1(String str, int i3, MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, this, str, Integer.valueOf(i3), messageRecord, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "insertToList " + messageRecord.getBaseInfoString());
        } else {
            QLog.d("Q.msg.MsgProxy", 1, "insertToList " + messageRecord.getUserLogString());
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            U1(str, i3, messageRecord, z16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord U(String str, int i3, String str2) {
        String sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 136)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 136, this, str, Integer.valueOf(i3), str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + str + ", type " + i3);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String str3 = "";
        if (!ao.u(i3) && !ao.v(i3)) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("select * from ");
            sb6.append(N1(str, i3));
            sb6.append(" where isValid=1 and msgtype ");
            sb6.append(ao.k());
            sb6.append(" ");
            if (str2 != null) {
                str3 = "and " + str2;
            }
            sb6.append(str3);
            sb6.append(" order by time desc , _id desc limit 1");
            sb5 = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("select * from ");
            sb7.append(N1(str, i3));
            sb7.append(" where isValid=1 and msgtype ");
            sb7.append(ao.k());
            sb7.append(" ");
            if (str2 != null) {
                str3 = "and " + str2;
            }
            sb7.append(str3);
            sb7.append(" order by shmsgseq desc , _id desc limit 1");
            sb5 = sb7.toString();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + sb5);
        }
        List<MessageRecord> c16 = f116741e.c(sb5, null, this);
        if (c16 == null || c16.size() < 1) {
            return null;
        }
        return c16.get(0);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> V(String str, int i3, long j3, int i16, String str2) {
        List<MessageRecord> g26;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 141)) {
            return (List) iPatchRedirector.redirect((short) 141, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq() called with: peerUin = [" + str + "], type = [" + i3 + "], seq = [" + j3 + "], count = [" + i16 + "], whereClause = [" + str2 + "]");
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + str + ",type=" + i3 + ",seq=" + j3 + ",count=" + i16);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase();
        }
        if (ao.u(i3) || ao.v(i3)) {
            z16 = true;
        }
        if (X1(str, i3)) {
            if (z16) {
                g26 = f2(str, i3, j3, i16, str2);
            } else {
                g26 = g2(str, i3, j3, i16, str2);
            }
            if (g26 != null) {
                return g26;
            }
        }
        return new ArrayList();
    }

    @Nullable
    protected List<MessageRecord> V0(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null) {
            return (List) ((ArrayList) D1).clone();
        }
        return null;
    }

    protected synchronized void V1(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, str, Integer.valueOf(i3), list);
        } else {
            I1().put(ao.f(str, i3), list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> W(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 115)) {
            return (List) iPatchRedirector.redirect((short) 115, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq, peerUin = " + str + ", type " + i3 + ",beginSeq = " + j3 + ",endSeq = " + j16);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String str2 = "select * from " + N1(str, i3) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + str2);
        }
        List<MessageRecord> c16 = f116741e.c(str2, new String[]{String.valueOf(j3), String.valueOf(j16)}, this);
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Nullable
    protected List<MessageRecord> W0(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
        }
        if (list != null) {
            return (List) ((ArrayList) list).clone();
        }
        return null;
    }

    protected boolean W1(int i3, long j3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 151)) {
            return ((Boolean) iPatchRedirector.redirect((short) 151, this, Integer.valueOf(i3), Long.valueOf(j3), messageRecord)).booleanValue();
        }
        if (!ao.u(i3) && !ao.v(i3)) {
            if (j3 >= messageRecord.time) {
                return true;
            }
            return false;
        }
        if (j3 >= messageRecord.shmsgseq) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> X(String str, int i3, long j3, long j16, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 116)) {
            return (List) iPatchRedirector.redirect((short) 116, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        return null;
    }

    @Nullable
    protected List<MessageRecord> X0(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (List) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
        }
        List<MessageRecord> C1 = C1(t1(str, i3));
        if (C1 != null) {
            return (List) ((ArrayList) C1).clone();
        }
        return null;
    }

    protected boolean X1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 142)) {
            return ((Boolean) iPatchRedirector.redirect((short) 142, (Object) this, (Object) str, i3)).booleanValue();
        }
        return br.e(N1(str, i3), L1());
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> Y(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 139)) {
            return (List) iPatchRedirector.redirect((short) 139, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), iArr);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> Z(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 138)) {
            return (List) iPatchRedirector.redirect((short) 138, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), iArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryC2CMessageFromDB_UnionTables, peerUin = " + str + ", type " + i3 + ",_id = " + j3 + ",versionCode = " + i16 + ", from " + j16 + ",count = " + i17 + ",customTypes = " + Arrays.toString(iArr));
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(str, i3);
        }
        if (iArr != null && iArr.length > 0) {
            StringBuilder sb5 = new StringBuilder(" and msgtype in ( ");
            for (int i18 = 0; i18 < iArr.length; i18++) {
                sb5.append(iArr[i18]);
                if (i18 < iArr.length - 1) {
                    sb5.append(" , ");
                }
            }
            sb5.append(") ");
            str2 = sb5.toString();
        } else {
            str2 = null;
        }
        List<MessageRecord> q06 = q0(str, i3, j3, i16, j16, i17, str2);
        if (q06 == null) {
            return new ArrayList();
        }
        return q06;
    }

    public void Z0(String str, int i3, String str2, String str3, String[] strArr, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, this, str, Integer.valueOf(i3), str2, str3, strArr, proxyListener);
        } else {
            this.proxyManager.addMsgQueue(str, i3, str2, str3, strArr, 2, proxyListener);
        }
    }

    public boolean Z1(String str, int i3, boolean z16) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return ((Boolean) iPatchRedirector.redirect((short) 50, this, str, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        if (str == null) {
            return false;
        }
        synchronized (this.proxyManager.getMsgQueueLock()) {
            Vector<MsgQueueItem> queue = this.proxyManager.getQueue();
            for (int i17 = 0; i17 < queue.size(); i17++) {
                MsgQueueItem msgQueueItem = queue.get(i17);
                if (ao.E(msgQueueItem.frindUin, str, msgQueueItem.type, i3) && ((i16 = msgQueueItem.action) == 1 || i16 == 2 || (z16 && i16 == 0))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MsgProxy", 2, "needTransSaveToDatabase uin=", str, ", type=", LargerInteger.valueOf(i3), ", hasInsertAction=", Boolean.valueOf(z16), ",result=true");
                    }
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.tencent.imcore.message.f
    public void a(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 81)) {
            iPatchRedirector.redirect((short) 81, this, str, Integer.valueOf(i3), list);
            return;
        }
        S0(str, i3, list);
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            try {
                J0(str, i3, list);
            } catch (Exception e16) {
                QLog.e("Q.msg.MsgProxy", 1, "addAIOHeadMessage catch exception", e16);
            }
            Q0(str, i3, list);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> a0(String str, int i3, String str2, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 134)) {
            return (List) iPatchRedirector.redirect((short) 134, this, str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17));
        }
        Contact contact = new Contact();
        contact.setChatType(i16);
        contact.setPeerUid(str2);
        return ((INTMsgProxyUtilsApi) QRoute.api(INTMsgProxyUtilsApi.class)).transToCompatMsgType(NTOperateUtils.f359554a.h(contact, i17), str, i3);
    }

    protected int a1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this, (Object) str, i3)).intValue();
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return b1(str, i3);
        } finally {
            J1.unlock();
        }
    }

    protected boolean a2(String str, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Boolean) iPatchRedirector.redirect((short) 51, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        if (str == null) {
            return false;
        }
        synchronized (this.proxyManager.getMsgQueueLock()) {
            Iterator<MsgQueueItem> it = this.proxyManager.getQueue().iterator();
            while (it.hasNext()) {
                MsgQueueItem next = it.next();
                if (TextUtils.isEmpty(next.tableName)) {
                    return true;
                }
                if (str.equals(next.tableName) && ((i3 = next.action) == 1 || i3 == 2 || (z16 && i3 == 0))) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.MsgProxy", 2, "needTransSaveToDatabase tableName=", str, ", hasInsertAction=", Boolean.valueOf(z16), ",result=true");
                    }
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.tencent.imcore.message.f
    public void b(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, this, str, Integer.valueOf(i3), list);
            return;
        }
        S0(str, i3, list);
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            K0(str, i3, list);
            J1.unlock();
            Q0(str, i3, list);
        } catch (Throwable th5) {
            J1.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> b0(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 133)) {
            return (List) iPatchRedirector.redirect((short) 133, this, str, str2, Integer.valueOf(i3));
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.f
    public void c(String str, int i3, MessageRecord messageRecord, ProxyListener proxyListener, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 77)) {
            iPatchRedirector.redirect((short) 77, this, str, Integer.valueOf(i3), messageRecord, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        } else {
            T1(str, i3, messageRecord, z18);
            u2(str, i3, messageRecord, proxyListener, z16, z17);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> c0(String str, int i3, long j3, long j16) {
        String str2;
        int size;
        long j17 = j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 118)) {
            return (List) iPatchRedirector.redirect((short) 118, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        String str3 = ", type ";
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromSeqRange, peerUin = " + str + ", type " + i3 + ",beginSeq = " + j3 + ",endSeq = " + j17);
        }
        List<MessageRecord> p16 = p(str, i3);
        ArrayList arrayList = new ArrayList();
        if (p16 != null && p16.size() > 0) {
            for (MessageRecord messageRecord : p16) {
                long j18 = messageRecord.shmsgseq;
                if (j18 >= j3 && j18 <= j17) {
                    arrayList.add(messageRecord);
                }
            }
        }
        if (arrayList.size() > 0 && ((MessageRecord) arrayList.get(0)).shmsgseq == j3) {
            return arrayList;
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String str4 = "select * from " + N1(str, i3) + " where shmsgseq>=? and shmsgseq<=? order by shmsgseq asc";
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromBySeq " + str4);
        }
        if (arrayList.size() > 0) {
            j17 = ((MessageRecord) arrayList.get(0)).shmsgseq;
        }
        long min = Math.min(j3, j17);
        Iterator it = arrayList.iterator();
        while (true) {
            if (it.hasNext()) {
                str2 = str3;
                long j19 = ((MessageRecord) it.next()).shmsgseq;
                if (j19 == j17) {
                    it.remove();
                } else if (j19 > j17) {
                    break;
                }
                str3 = str2;
            } else {
                str2 = str3;
                break;
            }
        }
        List<MessageRecord> c16 = f116741e.c(str4, new String[]{String.valueOf(min), String.valueOf(j17)}, this);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryMessageFromTimeRange, peerUin = ");
            sb5.append(str);
            sb5.append(str2);
            sb5.append(i3);
            sb5.append(",queryBeginSeq = ");
            sb5.append(min);
            sb5.append(",queryEndSeq = ");
            sb5.append(j17);
            sb5.append(",resultSize=");
            if (c16 == null) {
                size = 0;
            } else {
                size = c16.size();
            }
            sb5.append(size);
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
        }
        if (c16 != null) {
            arrayList.addAll(0, c16);
        }
        return arrayList;
    }

    protected MessageRecord c1(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 66, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return d1(str, i3, j3);
        } finally {
            J1.unlock();
        }
    }

    protected void c2(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, Integer.valueOf(i3), list);
            return;
        }
        l1().put(t1(str, i3), list);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "putAioMsgList list size:", Integer.valueOf(list.size()));
        }
    }

    @Override // com.tencent.imcore.message.f
    public void d(List<MessageRecord> list, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) list, (Object) proxyListener);
        } else {
            O0(ao.b(list), proxyListener);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> d0(String str, int i3, long j3, long j16, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 119)) {
            return (List) iPatchRedirector.redirect((short) 119, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), iArr);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f, com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 114)) {
            iPatchRedirector.redirect((short) 114, (Object) this);
            return;
        }
        EntityManager entityManager = this.f116742b;
        if (entityManager != null && entityManager.isOpen()) {
            this.f116742b.close();
        }
    }

    @Override // com.tencent.imcore.message.f
    public void e(String str, int i3, long j3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, this, str, Integer.valueOf(i3), Long.valueOf(j3), list);
            return;
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            L0(str, i3, j3, list);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord e0(String str, int i3, long j3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 145)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 145, this, str, Integer.valueOf(i3), Long.valueOf(j3), str2, str3);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String format = String.format("select * from " + N1(str, i3) + " where time=%d and senderuin=%s", Long.valueOf(j3), str2);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMsgByConstraints: sql=" + format + ", peeruin = " + str + ", type = " + i3);
        }
        List<MessageRecord> c16 = f116741e.c(format, null, this);
        if (c16 != null) {
            for (MessageRecord messageRecord : c16) {
                if (messageRecord.f203106msg.equals(str3)) {
                    return messageRecord;
                }
            }
        }
        return null;
    }

    protected MessageRecord e2(String str, int i3, int i16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        String N1 = N1(str, i3);
        if (a2(N1, false)) {
            this.proxyManager.transSaveToDatabase(this.f116742b);
        }
        StringBuilder sb5 = new StringBuilder(512);
        sb5.append("select * from %s m where m.isValid=1");
        sb5.append(" order by %s limit 1");
        String sb6 = sb5.toString();
        Object[] objArr = new Object[2];
        objArr[0] = N1;
        if (!ao.u(i3) && !ao.v(i3)) {
            str2 = "time desc , _id desc";
        } else {
            str2 = "shmsgseq desc , _id desc";
        }
        objArr[1] = str2;
        List<Entity> rawQuery = DBMethodProxy.rawQuery(D(), MessageRecord.class, String.format(sb6, objArr), null);
        if (rawQuery != null && !rawQuery.isEmpty()) {
            for (int size = rawQuery.size() - 1; size >= 0; size--) {
                if (((MessageRecord) rawQuery.get(size)).getConfessTopicId() == i16) {
                    return (MessageRecord) rawQuery.get(size);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f
    public void f(String str, int i3, long j3, long j16, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), list);
            return;
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            M0(str, i3, j3, j16, list);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord f0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 37, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (j3 != 0 && str != null && str.length() != 0) {
            List<MessageRecord> r16 = r(str, i3);
            if (r16 != null) {
                for (MessageRecord messageRecord : r16) {
                    if (messageRecord.shmsgseq == j3) {
                        return messageRecord;
                    }
                }
            }
            return m2(str, i3, j3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<MessageRecord> f2(String str, int i3, long j3, int i16, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 144)) {
            return (List) iPatchRedirector.redirect((short) 144, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String str4 = "select * from " + N1(str, i3) + " where shmsgseq<=? and shmsgseq>? %s order by shmsgseq asc";
        Object[] objArr = new Object[1];
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = "and " + str2;
        }
        objArr[0] = str3;
        String format = String.format(str4, objArr);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: sql=" + format + ", peeruin = " + str + ", type = " + i3);
        }
        long j16 = 0;
        if (i16 > 0) {
            long j17 = i16;
            if (j3 > j17) {
                j16 = j3 - j17;
            }
        }
        List<MessageRecord> c16 = f116741e.c(format, new String[]{String.valueOf(j3), String.valueOf(j16)}, this);
        if (c16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: list size =" + c16.size() + ", peeruin = " + str + ", type = " + i3);
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageBySeq: null list , peeruin = " + str + ", type = " + i3);
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.f
    public void g(String str, int i3, long j3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, this, str, Integer.valueOf(i3), Long.valueOf(j3), list);
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> g0(String str, int i3, long j3, long j16) {
        List<MessageRecord> n26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (List) iPatchRedirector.redirect((short) 36, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (j3 != 0 && j16 != 0 && str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            List<MessageRecord> r16 = r(str, i3);
            if (r16 != null) {
                for (MessageRecord messageRecord : r16) {
                    if (messageRecord.shmsgseq == j3 && messageRecord.msgUid == j16) {
                        arrayList.add(messageRecord);
                    }
                }
            }
            if (arrayList.isEmpty() && (n26 = n2(str, i3, j3, j16)) != null && !n26.isEmpty()) {
                arrayList.addAll(n26);
            }
            return arrayList;
        }
        return null;
    }

    void g1() {
        this.proxyManager.transSaveToDatabase();
        this.proxyManager.clearMsgQueue();
    }

    protected List<MessageRecord> g2(String str, int i3, long j3, int i16, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 143)) {
            return (List) iPatchRedirector.redirect((short) 143, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String str4 = "";
        if (i16 <= 0) {
            str3 = "";
        } else {
            str3 = "limit " + i16;
        }
        String str5 = "select * from " + N1(str, i3) + " where time<%d %s order by time desc, _id desc %s";
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j3);
        if (str2 != null) {
            str4 = "and " + str2;
        }
        objArr[1] = str4;
        objArr[2] = str3;
        String format = String.format(str5, objArr);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: sql=" + format + ", peeruin = " + str + ", type = " + i3);
        }
        List<MessageRecord> c16 = f116741e.c(format, null, this);
        if (c16 != null) {
            Collections.reverse(c16);
        }
        if (c16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: list size =" + c16.size() + ", peeruin = " + str + ", type = " + i3);
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageByTime: null list , peeruin = " + str + ", type = " + i3);
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.f
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this);
        } else {
            I1().clear();
            l1().clear();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord h0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 38, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (j3 != 0 && str != null && str.length() != 0) {
            List<MessageRecord> r16 = r(str, i3);
            if (r16 != null) {
                for (MessageRecord messageRecord : r16) {
                    if (messageRecord.shmsgseq == j3 && !f116741e.l(messageRecord)) {
                        return messageRecord;
                    }
                }
            }
            return o2(str, i3, j3);
        }
        return null;
    }

    protected List<MessageRecord> h1(String str, int i3, long j3, int i16) {
        List<MessageRecord> c06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (List) iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16));
        }
        if (!ao.u(i3) && !ao.v(i3)) {
            c06 = j2(str, i3, j3, TTL.MAX_VALUE, i16);
        } else {
            c06 = c0(str, i3, j3, TTL.MAX_VALUE);
        }
        if (c06 == null) {
            c06 = new ArrayList<>();
        }
        c2(str, i3, c06);
        return c06;
    }

    @Override // com.tencent.imcore.message.f
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this);
            return;
        }
        g1();
        EntityTransaction transaction = D().getTransaction();
        SQLiteDatabase P1 = P1();
        String[] allTableNameFromCache = P1.getAllTableNameFromCache();
        if (allTableNameFromCache == null) {
            return;
        }
        for (int i3 = 0; i3 < allTableNameFromCache.length; i3++) {
            U0(transaction, P1, allTableNameFromCache, i3);
        }
        f116741e.a(this, this.app);
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> i0(String str, int i3, long j3, long j16) {
        List<MessageRecord> p26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (List) iPatchRedirector.redirect((short) 39, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (j3 != 0 && j16 != 0 && str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            List<MessageRecord> r16 = r(str, i3);
            if (r16 != null) {
                for (MessageRecord messageRecord : r16) {
                    if (messageRecord.time == j3 && messageRecord.msgUid == j16) {
                        arrayList.add(messageRecord);
                    }
                }
            }
            if (arrayList.isEmpty() && (p26 = p2(str, i3, j3, j16)) != null && !p26.isEmpty()) {
                arrayList.addAll(p26);
            }
            return arrayList;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<MessageRecord> i2(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 146)) {
            return (List) iPatchRedirector.redirect((short) 146, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String format = String.format("select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from ( select _id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong from " + K1(str, i3) + " order by _id desc limit " + i16 + " ) order by _id asc", new Object[0]);
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: sqlStr=" + format + ", peeruin = " + str + ", type = " + i3);
        }
        List<MessageRecord> c16 = f116741e.c(format, null, this);
        if (c16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: list size =" + c16.size() + ", peeruin = " + str + ", type = " + i3);
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromOldDB: null list , peeruin = " + str + ", type = " + i3);
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.f, com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 113)) {
            iPatchRedirector.redirect((short) 113, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.f
    public int j(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 89)) {
            return ((Integer) iPatchRedirector.redirect((short) 89, this, str, Integer.valueOf(i3), Boolean.valueOf(z16))).intValue();
        }
        int a16 = a1(str, i3);
        if (z16) {
            Z0(str, i3, N1(str, i3), null, null, null);
            Z0(str, i3, K1(str, i3), null, null, null);
        }
        f116741e.e(str, i3, z16, this, this.app);
        return a16;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord j0(String str, int i3, long j3) {
        List<MessageRecord> k26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 34, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        MessageRecord messageRecord = null;
        if (j3 == 0 || str == null || str.length() == 0) {
            return null;
        }
        List<MessageRecord> r16 = r(str, i3);
        if (r16 != null) {
            Iterator<MessageRecord> it = r16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MessageRecord next = it.next();
                if (next.uniseq == j3) {
                    messageRecord = next;
                    break;
                }
            }
        }
        if (messageRecord == null && (k26 = k2(str, i3, j3)) != null && !k26.isEmpty()) {
            return k26.get(0);
        }
        return messageRecord;
    }

    public List<MessageRecord> j2(String str, int i3, long j3, long j16, int i16) {
        List<MessageRecord> c16;
        long j17 = j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 121)) {
            return (List) iPatchRedirector.redirect((short) 121, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i16));
        }
        String str2 = ",topicId=";
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange, peerUin = " + str + ", type " + i3 + ",beginTime = " + j3 + ",endTime = " + j17 + ",topicId=" + i16);
        }
        List<MessageRecord> p16 = p(str, i3);
        ArrayList arrayList = new ArrayList();
        if (p16 != null && p16.size() > 0) {
            for (MessageRecord messageRecord : p16) {
                String str3 = str2;
                long j18 = messageRecord.time;
                if (j18 >= j3 && j18 <= j17 && (i16 <= 0 || messageRecord.getConfessTopicId() == i16)) {
                    arrayList.add(messageRecord);
                }
                str2 = str3;
            }
        }
        String str4 = str2;
        if (arrayList.size() > 0 && arrayList.get(0).time == j3) {
            return arrayList;
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        int r16 = r1(i3, i16);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("select * from ");
        sb5.append(N1(str, i3));
        sb5.append(" where time>=? and time<=?");
        if (r16 != 0) {
            sb5.append(" and (extLong & 4194296)=?");
        }
        sb5.append(" order by time asc");
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessageFromTimeRange " + sb5.toString());
        }
        if (arrayList.size() > 0) {
            j17 = arrayList.get(0).time;
        }
        long min = Math.min(j3, j17);
        s2(arrayList, j17);
        if (r16 == 0) {
            c16 = f116741e.c(sb5.toString(), new String[]{String.valueOf(min), String.valueOf(j17)}, this);
        } else {
            c16 = f116741e.c(sb5.toString(), new String[]{String.valueOf(min), String.valueOf(j17), String.valueOf(r16)}, this);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("queryMessageFromTimeRange, peerUin = ");
            sb6.append(str);
            sb6.append(", type ");
            sb6.append(i3);
            sb6.append(",queryBeginTime = ");
            sb6.append(min);
            sb6.append(",queryEndTime = ");
            sb6.append(j17);
            sb6.append(",resultSize=");
            sb6.append(c16 == null ? 0 : c16.size());
            sb6.append(str4);
            sb6.append(i16);
            QLog.d("Q.msg.MsgProxy", 2, sb6.toString());
        }
        if (c16 != null) {
            arrayList.addAll(0, c16);
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.f
    public void k(String str, int i3, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, this, str, Integer.valueOf(i3), str2, str3, Integer.valueOf(i16));
            return;
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            T0(str, i3, str2, str3, i16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> k0(String str, int i3, List<Long> list) {
        MessageRecord H;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (List) iPatchRedirector.redirect((short) 35, this, str, Integer.valueOf(i3), list);
        }
        if (list != null && str != null && str.length() != 0 && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            while (i16 < list.size() && (H = H(str, i3, list.get(i16).longValue())) != null) {
                arrayList.add(H);
                i16++;
            }
            if (i16 < list.size() - 1) {
                arrayList.addAll(l2(str, i3, list.subList(i16, list.size())));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    protected List<MessageRecord> k1(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (List) iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        }
        return l1().get(str);
    }

    protected List<MessageRecord> k2(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 127)) {
            return (List) iPatchRedirector.redirect((short) 127, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, peerUin[" + MsfSdkUtils.getShortUin(str) + "] type[" + i3 + "] uniseq[" + j3 + "]");
        }
        if (j3 == 0) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
            }
            return new ArrayList();
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<MessageRecord> c16 = f116741e.c("select * from " + N1(str, i3) + " where uniseq=?", new String[]{String.valueOf(j3)}, this);
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> l(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, i3);
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return W0(z(str, i3));
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> l0(String str, int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 169)) {
            return (List) iPatchRedirector.redirect((short) 169, this, str, Integer.valueOf(i3), list);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, List<MessageRecord>> l1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            return (Map) iPatchRedirector.redirect((short) 93, (Object) this);
        }
        return this.f116628a.b();
    }

    protected List<MessageRecord> l2(String str, int i3, List<Long> list) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 128)) {
            return (List) iPatchRedirector.redirect((short) 128, this, str, Integer.valueOf(i3), list);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryMessagesByMsgUniseqFromDB, peerUin[");
            sb5.append(MsfSdkUtils.getShortUin(str));
            sb5.append("] type[");
            sb5.append(i3);
            sb5.append("] uniseqList[");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            sb5.append("]");
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
        }
        if (list != null && list.size() != 0) {
            if (Z1(str, i3, true)) {
                this.proxyManager.transSaveToDatabase(D());
            }
            String[] strArr = new String[list.size()];
            StringBuilder sb6 = new StringBuilder("(");
            for (int i16 = 0; i16 < list.size(); i16++) {
                strArr[i16] = String.valueOf(list.get(i16).longValue());
                sb6.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                if (i16 < list.size() - 1) {
                    sb6.append(",");
                }
            }
            sb6.append(")");
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB, uniseq list=" + sb6.toString());
            }
            List<MessageRecord> c16 = f116741e.c("select * from " + N1(str, i3) + " where uniseq in " + sb6.toString(), strArr, this);
            if (c16 == null) {
                return new ArrayList();
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByMsgUniseqFromDB Warning! uniseq==0");
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> m(String str, int i3, int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), iArr);
        }
        ArrayList arrayList = new ArrayList();
        List<MessageRecord> l3 = l(str, i3);
        HashSet<Integer> hashSet = new HashSet<>();
        P0(iArr, hashSet);
        if (l3 != null && !l3.isEmpty()) {
            if (hashSet.isEmpty()) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MsgProxy", 4, "getAllMessages size = " + arrayList.size());
                }
                return arrayList;
            }
            Iterator<MessageRecord> it = l3.iterator();
            long j3 = Long.MAX_VALUE;
            while (it.hasNext()) {
                long j16 = it.next().shmsgseq;
                if (j16 < j3) {
                    j3 = j16;
                }
            }
            for (MessageRecord messageRecord : l3) {
                if ((!ao.u(i3) && !ao.v(i3)) || messageRecord.versionCode != 3 || messageRecord.shmsgseq != j3 || j3 == 0) {
                    if (hashSet.contains(Integer.valueOf(messageRecord.msgtype)) || hashSet.isEmpty()) {
                        arrayList.add(messageRecord);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> m0(String str, int i3, List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 168)) {
            return (List) iPatchRedirector.redirect((short) 168, this, str, Integer.valueOf(i3), list);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public AppRuntime m1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 171)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 171, (Object) this);
        }
        return this.app;
    }

    public MessageRecord m2(String str, int i3, long j3) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 131)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 131, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + MsfSdkUtils.getShortUin(str) + "] type[" + i3 + "] shmsgseq[" + j3 + "]");
        }
        if (j3 == 0 && QLog.isColorLevel()) {
            QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<MessageRecord> c16 = f116741e.c("select * from " + N1(str, i3) + " where shmsgseq=?", new String[]{String.valueOf(j3)}, this);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryMessagesByShmsgseqFromDB, peerUin[");
            sb5.append(MsfSdkUtils.getShortUin(str));
            sb5.append("] type[");
            sb5.append(i3);
            sb5.append("] shmsgseq[");
            sb5.append(j3);
            sb5.append("], list.size():");
            if (c16 == null) {
                size = 0;
            } else {
                size = c16.size();
            }
            sb5.append(size);
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
        }
        if (c16 != null) {
            return c16.get(0);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> n(String str, int i3, int i16, int[] iArr) {
        long j3;
        long j16;
        int i17;
        Iterator<MessageRecord> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), Integer.valueOf(i16), iArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "getAllMessages uin " + str + " , type = " + i3 + " , customTypes = " + Arrays.toString(iArr));
        }
        ArrayList arrayList = new ArrayList();
        List<MessageRecord> l3 = l(str, i3);
        if (l3 == null || l3.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "getAllMessages from AIO CACHE FAIL\uff01 ");
            }
            l3 = p(str, i3);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        P0(iArr, hashSet);
        long j17 = Long.MAX_VALUE;
        if (l3 != null && !l3.isEmpty()) {
            if (l3.size() >= i16 && hashSet.isEmpty()) {
                arrayList.addAll(l3.subList(l3.size() - i16, l3.size()));
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MsgProxy", 4, "getAllMessages size = " + arrayList.size());
                }
                return arrayList;
            }
            j16 = A1(i3, l3, Long.MAX_VALUE);
            int i18 = 3;
            long j18 = Long.MAX_VALUE;
            for (Iterator<MessageRecord> it5 = l3.iterator(); it5.hasNext(); it5 = it) {
                MessageRecord next = it5.next();
                if ((ao.u(i3) || ao.v(i3)) && next.versionCode == 3) {
                    it = it5;
                    if (next.shmsgseq == j16 && j16 != 0) {
                    }
                } else {
                    it = it5;
                }
                if (hashSet.contains(Integer.valueOf(next.msgtype)) || hashSet.isEmpty()) {
                    i18 = B1(i18, next);
                    long z16 = z1(j18, next);
                    j17 = y1(j17, next);
                    arrayList.add(next);
                    j18 = z16;
                }
            }
            if (arrayList.size() >= i16) {
                return arrayList.subList(arrayList.size() - i16, arrayList.size());
            }
            i17 = i18;
            j3 = j18;
        } else {
            j3 = Long.MAX_VALUE;
            j16 = Long.MAX_VALUE;
            i17 = 3;
        }
        if (!ao.u(i3) && !ao.v(i3)) {
            arrayList.addAll(0, Z(str, i3, j3, i17, j17, i16 - arrayList.size(), iArr));
        } else {
            arrayList.addAll(0, Z(str, i3, j3, i17, j16, i16 - arrayList.size(), iArr));
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("Q.msg.MsgProxy", 4, "getAllMessages size = " + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord n0(String str, int i3) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 137)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 137, (Object) this, (Object) str, i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryLastMsgForMessageTabFromDB, peerUin = " + str + ", type " + i3);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        if (!ao.u(i3) && !ao.v(i3)) {
            str2 = "select * from " + N1(str, i3) + " where isValid=1 order by time asc , _id asc limit 1";
        } else {
            str2 = "select * from " + N1(str, i3) + " where isValid=1 order by shmsgseq asc , time asc limit 1";
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryLastTABSupportMessageFromDB : sqlStr:" + str2);
        }
        List<MessageRecord> c16 = f116741e.c(str2, null, this);
        if (c16 == null || c16.size() < 1) {
            return null;
        }
        return c16.get(0);
    }

    protected List<MessageRecord> n2(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 130)) {
            return (List) iPatchRedirector.redirect((short) 130, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + MsfSdkUtils.getShortUin(str) + "] type[" + i3 + "] shmsgseq[" + j3 + "] msgUid[" + j16 + "]");
        }
        if ((j3 == 0 || j16 == 0) && QLog.isColorLevel()) {
            QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0 || msgUid == 0");
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<MessageRecord> c16 = f116741e.c("select * from " + N1(str, i3) + " where shmsgseq=? and msgUid=?", new String[]{String.valueOf(j3), String.valueOf(j16)}, this);
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> o(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3);
        }
        return v1(p(str, i3));
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> o0(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 117)) {
            return (List) iPatchRedirector.redirect((short) 117, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        return null;
    }

    protected MessageRecord o2(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 135)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 135, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop, peerUin[" + MsfSdkUtils.getShortUin(str) + "] type[" + i3 + "] shmsgseq[" + j3 + "]");
        }
        if (j3 == 0 && QLog.isColorLevel()) {
            QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByShmsgseqFromDB4Troop Warning! shmsgseq == 0");
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<MessageRecord> c16 = f116741e.c("select * from " + N1(str, i3) + " where shmsgseq=? and msgtype " + ao.i(), new String[]{String.valueOf(j3)}, this);
        if (c16 != null && c16.size() > 0) {
            return c16.get(0);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> p(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, i3);
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return W0(D1(str, i3));
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> p0(String str, int i3, long j3, @NonNull Map<String, MessageRecord> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 123)) {
            return (List) iPatchRedirector.redirect((short) 123, this, str, Integer.valueOf(i3), Long.valueOf(j3), map);
        }
        if (map == null) {
            map = new HashMap<>();
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter,  peerUin = " + str + ", type " + i3 + ", seq = " + j3 + ", filterMsgSet.size = " + map.size() + ",filterMsgSet = " + map.keySet());
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String str2 = "select * from " + N1(str, i3) + " where shmsgseq=?";
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "querySameSeqMessageWithFilter " + str2);
        }
        List<MessageRecord> c16 = f116741e.c(str2, new String[]{String.valueOf(j3)}, this);
        if (c16 == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (MessageRecord messageRecord : c16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "filter msg , seq = " + messageRecord.shmsgseq + " ,id = " + messageRecord.getId() + ",uniseq=" + messageRecord.uniseq);
            }
            if (!map.containsKey("id&" + messageRecord.getId() + ContainerUtils.FIELD_DELIMITER + messageRecord.shmsgseq)) {
                if (!map.containsKey("uniseq&" + messageRecord.uniseq + ContainerUtils.FIELD_DELIMITER + messageRecord.shmsgseq)) {
                    arrayList.add(messageRecord);
                }
            }
        }
        return arrayList;
    }

    public List<MessageRecord> p1(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (List) iPatchRedirector.redirect((short) 31, this, str, Integer.valueOf(i3), list);
        }
        ArrayList arrayList = new ArrayList();
        if (i3 != 0 && i3 != 1000 && i3 != 1004 && i3 != 1044 && i3 != 1045) {
            arrayList.addAll(list);
            return arrayList;
        }
        return q1(str, i3, list, arrayList);
    }

    protected List<MessageRecord> p2(String str, int i3, long j3, long j16) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 129)) {
            return (List) iPatchRedirector.redirect((short) 129, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB, peerUin[" + MsfSdkUtils.getShortUin(str) + "] type[" + i3 + "] time[" + j3 + "] uid[" + j16 + "]");
        }
        if (j16 == 0 && QLog.isColorLevel()) {
            QLog.e("Q.msg.MsgProxy", 2, "queryMessagesByTimeFromDB Warning! msgseq == 0 || msgUid == 0");
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<MessageRecord> c16 = f116741e.c("select * from " + N1(str, i3) + " where time=? and msgUid=?", new String[]{String.valueOf(j3), String.valueOf(j16)}, this);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("queryMessagesByTimeFromDB, peerUin[");
            sb5.append(MsfSdkUtils.getShortUin(str));
            sb5.append("] type[");
            sb5.append(i3);
            sb5.append("] time[");
            sb5.append(j3);
            sb5.append("] uid[");
            sb5.append(j16);
            sb5.append("], list.size():");
            if (c16 == null) {
                size = 0;
            } else {
                size = c16.size();
            }
            sb5.append(size);
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
        }
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> q(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return V0(str, i3, i16);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> q0(String str, int i3, long j3, int i16, long j16, int i17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 124)) {
            return (List) iPatchRedirector.redirect((short) 124, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryTimedMessageDBUnion, peerUin = " + str + ", type " + i3 + ",_id = " + j3 + ",versionCode = " + i16 + ", from " + j16 + ",count = " + i17 + ",whrere = " + str2);
        }
        StringBuilder b16 = br.b(K1(str, i3), N1(str, i3), j3, i16, j16, i17, L1(), str2);
        if (b16 != null) {
            if (Z1(str, i3, true)) {
                this.proxyManager.transSaveToDatabase(D());
            }
            List<MessageRecord> c16 = f116741e.c(b16.toString(), null, this);
            if (QLog.isColorLevel()) {
                QLog.i("QQMessageFacade", 2, b16.toString());
            }
            if (c16 != null) {
                Collections.reverse(c16);
                return c16;
            }
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<MessageRecord> q2(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            return (List) iPatchRedirector.redirect((short) 149, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        String format = String.format("select * from " + N1(str, i3) + " where isValid=1 and msgtype != ? order by shmsgseq desc , _id desc limit ?", new Object[0]);
        String[] strArr = {String.valueOf(-2006), String.valueOf(i16)};
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: sql=" + format + ", peeruin = " + str + ", type = " + i3);
        }
        List<MessageRecord> c16 = f116741e.c(format, strArr, this);
        if (c16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: list size =" + c16.size() + ", peeruin = " + str + ", type = " + i3);
            }
            return c16;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "queryValidMessageBySeq: null list , peeruin = " + str + ", type = " + i3);
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> r(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, i3);
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return X0(str, i3);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public int r0(String str, int i3, long j3) {
        boolean z16;
        String str2;
        String str3;
        int u16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        String N1 = N1(str, i3);
        if (!ao.u(i3) && !ao.v(i3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str2 = "shmsgseq desc , _id desc";
        } else {
            str2 = "time desc , _id desc";
        }
        if (z16) {
            str3 = AppConstants.Key.COLUMN_SHMSG_SEQ;
        } else {
            str3 = "time";
        }
        String format = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", N1, str3, Long.valueOf(j3), N1, str3, Long.valueOf(j3), str2);
        synchronized (f116741e.n(this.app)) {
            if (Z1(str, i3, false)) {
                this.proxyManager.transSaveToDatabase(D());
            }
            List<Entity> rawQuery = DBMethodProxy.rawQuery(D(), Message.class, format, null);
            if (rawQuery != null && !rawQuery.isEmpty()) {
                i16 = ((Message) rawQuery.get(0)).unReadNum;
            }
            u16 = f116741e.u(str, i3, j3, i16 + O1(str, i3, j3), this.app);
        }
        return u16;
    }

    public int r1(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 122)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 122, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
    }

    protected void r2(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 98)) {
            iPatchRedirector.redirect((short) 98, (Object) this, (Object) str, i3);
            return;
        }
        List<MessageRecord> D1 = D1(str, i3);
        if (D1 != null && D1.size() == 0) {
            if (Z1(str, i3, true)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("Q.msg.MsgProxy", 2, "--->reloadMsgListIfNeeded : currentThread:" + Thread.currentThread().getName());
                }
                this.proxyManager.transSaveToDatabase(D());
            }
            I1().remove(t1(str, i3));
            V1(str, i3, M(str, i3));
        }
    }

    @Override // com.tencent.imcore.message.f
    public synchronized void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        l1().clear();
        f116741e.j(this.app);
        if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "delAIOMsg ");
        }
    }

    @Override // com.tencent.imcore.message.f
    public int s0(String str, int i3, long j3) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 100)) {
            return ((Integer) iPatchRedirector.redirect((short) 100, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        MessageRecord w3 = w(str, i3, j3);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("--->removeSingleMsg : peerUin:");
            sb5.append(str);
            sb5.append(" type:");
            sb5.append(i3);
            sb5.append(" uniseq:");
            sb5.append(j3);
            sb5.append(" mr:");
            sb5.append(w3);
            sb5.append(" dbid:");
            if (w3 != null) {
                obj = Long.valueOf(w3.getId());
            } else {
                obj = "mr is null.";
            }
            sb5.append(obj);
            QLog.d("Q.msg.MsgProxy", 2, sb5.toString());
        }
        if (w3 != null) {
            long id5 = w3.getId();
            if (id5 != -1) {
                Z0(str, i3, N1(str, i3), "_id=?", new String[]{String.valueOf(id5)}, null);
            } else {
                Z0(str, i3, N1(str, i3), "uniseq=?", new String[]{String.valueOf(j3)}, null);
            }
            r2(w3.frienduin, w3.istroop);
            if (!w3.isread) {
                return 2;
            }
            return 1;
        }
        Z0(str, i3, N1(str, i3), "uniseq=?", new String[]{String.valueOf(j3)}, null);
        return 1;
    }

    protected String s1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str, i3);
        }
        if (ao.I(str)) {
            return "select * from " + N1(str, i3) + " order by time desc , _id desc";
        }
        if (ao.r(i3)) {
            return "select * from " + N1(str, i3) + " where _id in (select _id from " + N1(str, i3) + " order by time desc limit " + w1() + ") order by time desc, _id desc";
        }
        return "select * from " + N1(str, i3) + " order by _id desc limit " + w1();
    }

    @Override // com.tencent.imcore.message.f
    public synchronized void t(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
            return;
        }
        l1().remove(ao.f(str, i3));
        f116741e.j(this.app);
        if (QLog.isColorLevel()) {
            QLog.d("msgFold", 2, "delAIOMsg ");
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord t0(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 111)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 111, this, messageRecord, Boolean.valueOf(z16));
        }
        if (messageRecord == null) {
            return null;
        }
        MessageRecord H = H(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
        messageRecord.isValid = z16;
        if (H != null) {
            H.isValid = z16;
        } else if (QLog.isColorLevel()) {
            QLog.w("Q.msg.MsgProxy", 2, "update : setMessageIsValidFlag : set fail !");
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_IS_VALID, Boolean.valueOf(z16));
        if (H != null) {
            if (H.getId() > 0) {
                C2(H.frienduin, H.istroop, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(H.frienduin, H.istroop, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(H.uniseq)}, null);
            }
        } else if (messageRecord.getId() > 0) {
            C2(messageRecord.frienduin, messageRecord.istroop, messageRecord.versionCode, contentValues, "_id=?", new String[]{String.valueOf(messageRecord.getId())}, null);
        }
        return H;
    }

    public String t1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str, i3);
        }
        return ao.f(str, i3);
    }

    protected void t2(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, this, str, Integer.valueOf(i3), messageRecord);
        } else {
            DeprecatedMethodInvokeReport.d("Message", "MsgProxy.saveToDB", DeprecatedMethodInvokeReport.b.a(i3, str, messageRecord.msgtype, messageRecord.getClass().getSimpleName()));
        }
    }

    @Override // com.tencent.imcore.message.f
    public int u(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 97)) {
            return ((Integer) iPatchRedirector.redirect((short) 97, this, messageRecord, Boolean.valueOf(z16))).intValue();
        }
        if (messageRecord == null) {
            return -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.MsgProxy", 2, "--->deleteC2CMsgByMessageRecord : peerUin:" + messageRecord.frienduin + " type:" + messageRecord.istroop + " uniseq:" + messageRecord.uniseq + " mr:" + messageRecord + " dbid:" + messageRecord.getId());
        }
        if (z16) {
            c1(messageRecord.frienduin, messageRecord.istroop, messageRecord.getId());
        } else {
            w(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
        }
        long id5 = messageRecord.getId();
        if (id5 > 0) {
            String str = messageRecord.frienduin;
            int i3 = messageRecord.istroop;
            Z0(str, i3, N1(str, i3), "_id=?", new String[]{String.valueOf(id5)}, null);
        } else {
            if (messageRecord.uniseq == 0) {
                return -1;
            }
            String str2 = messageRecord.frienduin;
            int i16 = messageRecord.istroop;
            Z0(str2, i16, N1(str2, i16), "uniseq=?", new String[]{String.valueOf(messageRecord.uniseq)}, null);
        }
        if (!messageRecord.isread) {
            return 2;
        }
        r2(messageRecord.frienduin, messageRecord.istroop);
        return 1;
    }

    @Override // com.tencent.imcore.message.f
    public void u0(String str, int i3, MessageRecord messageRecord, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 87)) {
            iPatchRedirector.redirect((short) 87, this, str, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16));
        } else {
            v2(str, i3, i16);
            x2(str, i3, messageRecord, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u2(String str, int i3, MessageRecord messageRecord, ProxyListener proxyListener, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 79)) {
            iPatchRedirector.redirect((short) 79, this, str, Integer.valueOf(i3), messageRecord, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        t2(str, i3, messageRecord);
        if ((ao.s(messageRecord.msgtype) && !ao.z(messageRecord.frienduin, messageRecord.istroop)) || !z17) {
            return;
        }
        if (z16) {
            N0(str, i3, messageRecord, proxyListener);
        } else {
            I0(str, i3, messageRecord, proxyListener);
        }
    }

    @Override // com.tencent.imcore.message.f
    public int v(List<MessageRecord> list, boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 99)) {
            return ((Integer) iPatchRedirector.redirect((short) 99, this, list, Boolean.valueOf(z16))).intValue();
        }
        if (list != null && list.size() != 0) {
            int size = list.size();
            MessageRecord messageRecord = list.get(list.size() - 1);
            String str = messageRecord.frienduin;
            int i16 = messageRecord.istroop;
            ArrayList<String> arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i17 = size;
            for (MessageRecord messageRecord2 : list) {
                if (z16) {
                    c1(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.getId());
                } else {
                    w(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq);
                }
                if (messageRecord2.getId() > 0) {
                    arrayList.add(String.valueOf(messageRecord2.getId()));
                } else {
                    long j3 = messageRecord2.uniseq;
                    if (j3 != 0) {
                        arrayList2.add(String.valueOf(j3));
                    } else {
                        i17--;
                    }
                }
            }
            int i18 = 100;
            if (arrayList.size() > 100) {
                for (String str2 : arrayList) {
                    String N1 = N1(str, i16);
                    String[] strArr = new String[1];
                    strArr[c16] = str2;
                    Z0(str, i16, N1, "_id=?", strArr, null);
                    i18 = i18;
                    c16 = 0;
                }
                i3 = i18;
            } else {
                i3 = 100;
                if (arrayList.size() != 0) {
                    int size2 = arrayList.size();
                    String[] strArr2 = new String[size2];
                    Arrays.fill(strArr2, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    String arrays = Arrays.toString(strArr2);
                    Z0(str, i16, N1(str, i16), "_id IN (" + arrays.substring(1, arrays.length() - 1) + ")", (String[]) arrayList.toArray(new String[size2]), null);
                }
            }
            if (arrayList2.size() > i3) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    Z0(str, i16, N1(str, i16), "uniseq=?", new String[]{(String) it.next()}, null);
                }
            } else if (arrayList2.size() != 0) {
                int size3 = arrayList2.size();
                String[] strArr3 = new String[size3];
                Arrays.fill(strArr3, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                String arrays2 = Arrays.toString(strArr3);
                Z0(str, i16, N1(str, i16), "uniseq IN (" + arrays2.substring(1, arrays2.length() - 1) + ")", (String[]) arrayList2.toArray(new String[size3]), null);
            }
            r2(str, i16);
            return i17;
        }
        return -1;
    }

    @Override // com.tencent.imcore.message.f
    public void v0(String str, int i3, long j3) {
        boolean z16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 147)) {
            iPatchRedirector.redirect((short) 147, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        y2(str, i3, j3);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
        if (!ao.u(i3) && !ao.v(i3)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            str2 = AppConstants.Key.COLUMN_SHMSG_SEQ;
        } else {
            str2 = "time";
        }
        String valueOf = String.valueOf(j3);
        String N1 = N1(str, i3);
        if (ao.G(i3) && ao.j() != null) {
            D2(str, i3, N1, contentValues, String.format("isread=? and %s<=? and " + ao.j(), str2), new String[]{"0", valueOf}, null);
            return;
        }
        D2(str, i3, N1, contentValues, String.format("isread=? and %s<=?", str2), new String[]{"0", valueOf}, null);
    }

    protected List<MessageRecord> v1(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 153)) {
            return (List) iPatchRedirector.redirect((short) 153, (Object) this, (Object) list);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        HashSet hashSet = new HashSet();
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (hashSet.contains(ao.d((MessageRecord) arrayList2.get(size)))) {
                arrayList.add((MessageRecord) arrayList2.get(size));
            } else {
                hashSet.add(ao.d((MessageRecord) arrayList2.get(size)));
            }
        }
        arrayList2.removeAll(arrayList);
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord w(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 65, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return e1(str, i3, j3);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public void w0(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 103)) {
            iPatchRedirector.redirect((short) 103, this, str, Integer.valueOf(i3), messageRecord);
            return;
        }
        if (messageRecord != null && messageRecord.uniseq == 0) {
            if (messageRecord.getId() > 0) {
                messageRecord.createMessageUniseq();
                ContentValues contentValues = new ContentValues();
                contentValues.put("uniseq", Long.valueOf(messageRecord.uniseq));
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.MsgProxy", 2, "updateUniseqByID: set msg =" + messageRecord.getBaseInfoString());
                }
                C2(str, i3, messageRecord.versionCode, contentValues, "_id=?", new String[]{String.valueOf(messageRecord.getId())}, null);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.MsgProxy", 2, "updateUniseqByID ERROR: _id<0 !");
            }
        }
    }

    protected int w1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 172)) {
            return ((Integer) iPatchRedirector.redirect((short) 172, (Object) this)).intValue();
        }
        return 40;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord x(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 67, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            return f1(str, i3, j3);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord x0(String str, int i3, long j3, long j16, String str2) {
        long j17;
        long j18;
        long j19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 110)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 110, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
        }
        MessageRecord H = H(str, i3, j3);
        if (H == null && str2 != null) {
            try {
                j19 = Long.valueOf(str2).longValue();
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i("Q.msg.MsgProxy", 2, "can't find message by uniseq, try filename");
                    }
                    H = H(str, i3, j19);
                } catch (NumberFormatException unused) {
                }
            } catch (NumberFormatException unused2) {
                j19 = j3;
            }
            j17 = j19;
        } else {
            j17 = j3;
        }
        if (H != null) {
            H.time = j16;
            int i16 = H.extraflag;
            if (i16 == 32772 || i16 == 32768) {
                H.setExtraFlag(0);
                H.setSendFailCode(0);
            }
            x(str, i3, j17);
            N(str, i3, H);
            j18 = j17;
            f116741e.s(str, i3, j17, j16, H, this.app);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.MsgProxy", 2, "update msgTime set msg =" + H.getBaseInfoString());
            }
        } else {
            j18 = j17;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("time", Long.valueOf(j16));
        if (H != null && H.extraflag == 0) {
            contentValues.put(AppConstants.Key.COLUMN_EXTRA_FLAG, (Integer) 0);
            contentValues.put(AppConstants.Key.COLUMN_SEND_FAIL_CODE, (Integer) 0);
        }
        if (H != null) {
            if (H.getId() > 0) {
                MessageRecord messageRecord = H;
                C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
                return messageRecord;
            }
            MessageRecord messageRecord2 = H;
            C2(str, i3, messageRecord2.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(j18)}, null);
            return messageRecord2;
        }
        MessageRecord messageRecord3 = H;
        C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j18)}, null);
        return messageRecord3;
    }

    public void x2(String str, int i3, MessageRecord messageRecord, int i16) {
        int i17;
        String K1;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, this, str, Integer.valueOf(i3), messageRecord, Integer.valueOf(i16));
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
        if ((i3 == 1001 || i3 == 10002) && (i17 = messageRecord.msgtype) != -1003 && i17 != -1031 && i17 != -1032 && i17 != 201) {
            if (messageRecord.versionCode > 0) {
                K1 = N1(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
            } else {
                K1 = K1(String.valueOf(AppConstants.LBS_HELLO_UIN), 1001);
            }
            D2(str, i3, K1, contentValues, "senderuin=? and isread=?", new String[]{str, "0"}, null);
            C2(str, i3, messageRecord.versionCode, contentValues, "isread=?", new String[]{"0"}, null);
            return;
        }
        if (i3 == 1009) {
            D2(str, i3, N1(AppConstants.SAME_STATE_BOX_UIN, 1009), contentValues, "senderuin=? and isread=?", new String[]{str, "0"}, null);
            C2(str, i3, messageRecord.versionCode, contentValues, "isread=?", new String[]{"0"}, null);
            return;
        }
        if (i3 == 1010) {
            D2(str, i3, N1(AppConstants.DATE_UIN, 1010), contentValues, "senderuin=? and isread=?", new String[]{str, "0"}, null);
            C2(str, i3, messageRecord.versionCode, contentValues, "isread=?", new String[]{"0"}, null);
            return;
        }
        if (i3 == 0) {
            String str2 = AppConstants.FRIEND_SYSTEM_MSG_UIN;
            if (TextUtils.equals(str, str2)) {
                D2(str, i3, N1(str2, 0), contentValues, "senderuin=? and isread=?", new String[]{str, "0"}, null);
                C2(str, i3, messageRecord.versionCode, contentValues, "isread=?", new String[]{"0"}, null);
                return;
            }
        }
        if (i3 == 1032 && TextUtils.equals(str, AppConstants.CONFESS_UIN)) {
            D2(str, i3, N1(str, i3), contentValues, "isread=?", new String[]{"0"}, null);
        }
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord y(List<MessageRecord> list, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 161)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 161, (Object) this, (Object) list, (Object) messageRecord);
        }
        return null;
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord y0(String str, int i3, long j3, long j16, long j17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 95, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y2(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 150)) {
            iPatchRedirector.redirect((short) 150, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        Lock J1 = J1(str, i3);
        J1.lock();
        try {
            z2(str, i3, j3);
        } finally {
            J1.unlock();
        }
    }

    @Override // com.tencent.imcore.message.f
    public List<MessageRecord> z(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (List) iPatchRedirector.redirect((short) 24, (Object) this, (Object) str, i3);
        }
        return A(str, i3, 0, false);
    }

    @Override // com.tencent.imcore.message.f
    public MessageRecord z0(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 112)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 112, (Object) this, (Object) messageRecord, i3);
        }
        if (messageRecord == null) {
            return null;
        }
        MessageRecord H = H(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq);
        QLog.i("Q.msg.MsgProxy", 1, "updateMessageType uin=" + MsfSdkUtils.getShortUin(messageRecord.frienduin) + ",uniseq=" + messageRecord.uniseq + ",msgType=" + i3);
        messageRecord.msgtype = i3;
        if (H != null) {
            H.msgtype = i3;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(i3));
        if (H != null) {
            if (H.getId() > 0) {
                C2(H.frienduin, H.istroop, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
            } else {
                C2(H.frienduin, H.istroop, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(H.uniseq)}, null);
            }
        } else if (messageRecord.getId() > 0) {
            C2(messageRecord.frienduin, messageRecord.istroop, messageRecord.versionCode, contentValues, "_id=?", new String[]{String.valueOf(messageRecord.getId())}, null);
        }
        return H;
    }
}
