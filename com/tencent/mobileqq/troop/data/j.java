package com.tencent.mobileqq.troop.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.MsgPool;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.persistence.transaction.DeleteTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.br;
import com.tencent.mobileqq.utils.ej;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import mqq.app.AppRuntime;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes19.dex */
public class j extends com.tencent.imcore.message.y {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    TroopManager f294912f;

    /* renamed from: g, reason: collision with root package name */
    private Comparator f294913g;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Comparator<MessageRecord> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        private long b(MessageRecord messageRecord, MessageRecord messageRecord2) {
            return messageRecord.shmsgseq - messageRecord2.shmsgseq;
        }

        private long c(MessageRecord messageRecord, MessageRecord messageRecord2) {
            return d(messageRecord, messageRecord2, messageRecord.time - messageRecord2.time);
        }

        private long d(MessageRecord messageRecord, MessageRecord messageRecord2, long j3) {
            if (j3 == 0) {
                boolean N = ad.N(messageRecord.msgtype);
                boolean N2 = ad.N(messageRecord2.msgtype);
                if (N) {
                    if (N2) {
                        return messageRecord.time - messageRecord2.time;
                    }
                    return 1L;
                }
                if (N2) {
                    return -1L;
                }
                return j3;
            }
            return j3;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MessageRecord messageRecord, MessageRecord messageRecord2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) messageRecord, (Object) messageRecord2)).intValue();
            }
            long b16 = b(messageRecord, messageRecord2);
            if (b16 == 0) {
                b16 = c(messageRecord, messageRecord2);
            }
            return (int) b16;
        }
    }

    public j(AppRuntime appRuntime, BaseProxyManager baseProxyManager, MsgPool msgPool) {
        super(appRuntime, baseProxyManager, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appRuntime, baseProxyManager, msgPool);
        } else {
            this.f294913g = new a();
        }
    }

    @Nullable
    private List<MessageRecord> F2(String str, int i3, boolean z16) {
        List<MessageRecord> i26;
        List<MessageRecord> list = I().b().get(t1(str, i3));
        if (list != null && !list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from aiopool size = " + list.size());
            }
        } else if (z16) {
            List<MessageRecord> D1 = D1(str, i3);
            if (D1 != null && !D1.isEmpty()) {
                if (QLog.isColorLevel() && ej.a()) {
                    StringBuilder sb5 = new StringBuilder((D1.size() * 48) + 28);
                    sb5.append("getAIOMsgList, msgInfoList: ");
                    for (MessageRecord messageRecord : D1) {
                        sb5.append("(");
                        sb5.append(messageRecord.time);
                        sb5.append(",");
                        sb5.append(messageRecord.shmsgseq);
                        sb5.append(",");
                        sb5.append(messageRecord.msgtype);
                        sb5.append(") ");
                    }
                    QLog.d("Q.msg.TroopMsgProxy", 2, sb5.toString());
                }
                new ArrayList();
                i26 = ad.h(D1, false);
                if (ao.m(str, i3, i26) || !ad.n(i26) || ao.o(i26)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList : pull more long msg");
                    }
                    i26 = ad.i(D1, false, 30);
                }
                if (!H2(i26) && i26 != null && !i26.isEmpty()) {
                    List<MessageRecord> G2 = G2(D1, i26.get(0).shmsgseq);
                    if (G2 == null || G2.isEmpty()) {
                        List<MessageRecord> q26 = q2(str, i3, 15);
                        if (QLog.isColorLevel()) {
                            Iterator<MessageRecord> it = q26.iterator();
                            while (it.hasNext()) {
                                QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList from DB query valid msg " + it.next().getBaseInfoString());
                            }
                        }
                        if (q26 != null && !q26.isEmpty()) {
                            G2 = ad.h(q26, true);
                        }
                    }
                    i26 = G2;
                }
            } else {
                i26 = i2(str, i3, 15);
            }
            if (i26 == null) {
                i26 = new ArrayList<>();
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMsgProxy", 2, "continuedList :" + i26.size());
            }
            J2(i26);
            I().b().put(t1(str, i3), i26);
        } else {
            I().b().remove(t1(str, i3));
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMsgProxy", 2, "getAioMsgPool().remove :");
                return null;
            }
            return null;
        }
        List<MessageRecord> list2 = I().b().get(t1(str, i3));
        J2(list2);
        return list2;
    }

    public static boolean H2(List<MessageRecord> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            MessageRecord messageRecord = list.get(i3);
            if (messageRecord.msgtype != -2006 || (messageRecord instanceof MessageForFoldMsg)) {
                return true;
            }
        }
        return false;
    }

    private void I2(MessageRecord messageRecord, List<MessageRecord> list) {
        long j3;
        int i3;
        if (!messageRecord.isSendFromLocal() && ((!ad.B(messageRecord) || (i3 = messageRecord.msgtype) == -4012 || i3 == -4009 || i3 == -5001 || i3 == -5021) && !ad.r(messageRecord))) {
            return;
        }
        long j16 = 0;
        if (ad.M(messageRecord.msgtype) && messageRecord.shmsgseq > 0) {
            return;
        }
        int i16 = messageRecord.msgtype;
        if (i16 == -2016 && messageRecord.shmsgseq != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList av offline msg " + messageRecord.getBaseInfoString());
                return;
            }
            return;
        }
        if (i16 == -1012) {
            return;
        }
        if (list != null && !list.isEmpty()) {
            j3 = list.get(list.size() - 1).shmsgseq;
        } else {
            j3 = 0;
        }
        if (j3 >= 0) {
            j16 = j3;
        }
        QLog.i("Q.msg.TroopMsgProxy", 1, "insertToListUpdateMsgSeq from [" + messageRecord.shmsgseq + "] to [" + j16 + "]" + messageRecord.getBaseInfoString());
        messageRecord.shmsgseq = j16;
    }

    private void J2(List<MessageRecord> list) {
        if (list == null) {
            return;
        }
        try {
            Collections.sort(list, this.f294913g);
        } catch (IllegalArgumentException e16) {
            QLog.e("Q.msg.TroopMsgProxy", 1, "sortMsg: ", e16);
        }
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public List<MessageRecord> A(String str, int i3, int i16, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "getAIOMsgList peerUin: " + str + " type: " + i3 + " , autoInit = " + z16);
        }
        Lock e16 = I().e(str, i3);
        e16.lock();
        try {
            return F2(str, i3, z16);
        } finally {
            e16.unlock();
        }
    }

    @Override // com.tencent.imcore.message.y
    public List<MessageRecord> D1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
        }
        Lock e16 = I().e(str, i3);
        e16.lock();
        try {
            List<MessageRecord> D1 = super.D1(str, i3);
            J2(D1);
            return D1;
        } finally {
            e16.unlock();
        }
    }

    protected List<MessageRecord> G2(List<MessageRecord> list, long j3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, this, list, Long.valueOf(j3));
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int size = list.size() - 1; size >= 0; size--) {
                MessageRecord messageRecord = list.get(size);
                if (messageRecord.shmsgseq < j3) {
                    if (messageRecord.isValid && (messageRecord.msgtype != -2006 || (messageRecord instanceof MessageForFoldMsg))) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(0, messageRecord);
                    }
                }
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public MessageRecord K(String str, int i3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), messageRecord);
        }
        List<MessageRecord> p16 = p(str, i3);
        MessageRecord L = L(str, i3, messageRecord, p16);
        if (L == null && ((QQAppInterface) this.app).getMsgCache().f286240x0 != null) {
            p16.clear();
            for (MessageRecord messageRecord2 : ((QQAppInterface) this.app).getMsgCache().f286240x0) {
                if (messageRecord2.frienduin.equals(str) && messageRecord2.istroop == i3) {
                    p16.add(messageRecord2);
                }
            }
            L = L(str, i3, messageRecord, p16);
            if (L != null) {
                QLog.d("Q.msg.TroopMsgProxy", 1, "getSendingMsgItem in send cache;");
            }
        }
        return L;
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public MessageRecord L(String str, int i3, MessageRecord messageRecord, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 13, this, str, Integer.valueOf(i3), messageRecord, list);
        }
        MessageRecord messageRecord2 = null;
        if (messageRecord != null && list != null && !list.isEmpty() && messageRecord.msgtype != -2006) {
            int size = list.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                if (ad.e(list.get(size), messageRecord, true, true)) {
                    messageRecord2 = list.get(size);
                    break;
                }
                if (list.get(size).msgtype == -2011 && messageRecord.msgtype == -2011) {
                    if (messageRecord.msgUid == list.get(size).msgUid) {
                        messageRecord2 = list.get(size);
                        break;
                    }
                    size--;
                } else {
                    if (list.get(size).msgtype == -2048 && messageRecord.msgtype == -2048 && ((MessageForTroopReward) list.get(size)).rewardSeq == ((MessageForTroopReward) messageRecord).rewardSeq) {
                        messageRecord2 = list.get(size);
                        break;
                    }
                    size--;
                }
            }
            if (messageRecord2 != null && QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMsgProxy", 2, "getSendingMsgItem: find msg =" + messageRecord2.getLogColorContent() + " , mr.seq = " + messageRecord2.shmsgseq + " , mr.time = " + messageRecord2.time + " , mr.msgtype = " + messageRecord2.msgtype + " , extra = " + messageRecord2.extraflag);
            }
        }
        return messageRecord2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.imcore.message.y
    public void S0(String str, int i3, List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), list);
            return;
        }
        super.S0(str, i3, list);
        Lock e16 = I().e(str, i3);
        e16.lock();
        try {
            for (MessageRecord messageRecord : list) {
                if (messageRecord.msgtype == -4004) {
                    ((QQAppInterface) this.app).getMessageFacade().A0(messageRecord.frienduin, 1, messageRecord.msgtype, messageRecord.uniseq);
                }
            }
        } finally {
            e16.unlock();
        }
    }

    @Override // com.tencent.imcore.message.y
    protected void T1(String str, int i3, MessageRecord messageRecord, boolean z16) {
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Integer.valueOf(i3), messageRecord, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "insertToList " + messageRecord.getBaseInfoString());
        } else {
            QLog.d("Q.msg.TroopMsgProxy", 1, "insertToList " + messageRecord.getUserLogString());
        }
        Lock e16 = I().e(str, i3);
        e16.lock();
        try {
            List<MessageRecord> D1 = D1(str, i3);
            String t16 = t1(str, i3);
            S1(str, i3, t16, D1);
            I2(messageRecord, D1);
            ad.o(D1, messageRecord, true);
            if (D1 != null && D1.size() > 40 && !ao.I(str)) {
                D1.remove(0);
            }
            if (I().b().containsKey(t16) && z16) {
                List<MessageRecord> list = I().b().get(t16);
                if (list == null) {
                    list = new ArrayList<>();
                } else if (list.size() > 200 && messageRecord.istroop == 1) {
                    TroopManager troopManager = this.f294912f;
                    if (troopManager == null) {
                        this.f294912f = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
                    } else if (!troopManager.X(str)) {
                        QLog.d("yellowye", 2, "list.remove(0)");
                        list.remove(0);
                    }
                }
                if ((messageRecord instanceof MessageForUniteGrayTip) && ((MessageForUniteGrayTip) messageRecord).tipParam.f213685h == 3211265) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if ((messageRecord instanceof MessageForUniteGrayTip) && ((MessageForUniteGrayTip) messageRecord).tipParam.f213685h == 655392) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                int i16 = messageRecord.msgtype;
                if (i16 != -4009 && i16 != -4012 && !z17 && !z18) {
                    if (i16 == -4021) {
                        ad.q(list, messageRecord, true);
                    } else if ((messageRecord instanceof MessageForConfessNews) && i16 == -2065 && messageRecord.istroop == 1) {
                        ad.o(list, messageRecord, false);
                    } else {
                        list.add(messageRecord);
                    }
                }
                ad.o(list, messageRecord, true);
            }
        } finally {
            e16.unlock();
        }
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public List<MessageRecord> V(String str, int i3, long j3, int i16, String str2) {
        List<MessageRecord> f26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str2);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessageByTimeOrSeq:uin=" + str + ",type=" + i3 + ",seq=" + j3 + ",count=" + i16);
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase();
        }
        if (br.e(MessageRecord.getTableName(str, i3), L1()) && (f26 = f2(str, i3, j3, i16, str2)) != null) {
            return f26;
        }
        return new ArrayList();
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public List<MessageRecord> Y(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), iArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables, peerUin = " + LogUtil.wrapLogUin(str) + ", type " + i3 + ",_id = " + j3 + ",versionCode = " + i16 + ", endSeq " + j16 + ",count = " + i17 + ",customTypes = " + Arrays.toString(iArr));
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
            sb5.append(" ) ");
            str2 = sb5.toString();
        } else {
            str2 = null;
        }
        StringBuilder a16 = br.a(MessageRecord.getTableName(str, i3), j3, i16, j16, str2, i17, L1());
        if (a16 == null) {
            return new ArrayList();
        }
        String sb6 = a16.toString();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables " + sb6);
        }
        List<MessageRecord> c16 = com.tencent.imcore.message.y.f116741e.c(sb6, null, this);
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public List<MessageRecord> Z(String str, int i3, long j3, int i16, long j16, int i17, int[] iArr) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), Long.valueOf(j16), Integer.valueOf(i17), iArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables, peerUin = " + str + ", type " + i3 + ",_id = " + j3 + ",versionCode = " + i16 + ", endSeq " + j16 + ",count = " + i17 + ",customTypes = " + Arrays.toString(iArr));
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
            sb5.append(" ) ");
            str2 = sb5.toString();
        } else {
            str2 = null;
        }
        StringBuilder d16 = br.d(MessageRecord.getOldTableName(str, i3), MessageRecord.getTableName(str, i3), j3, i16, j16, str2, i17, L1());
        if (d16 == null) {
            return new ArrayList();
        }
        String sb6 = d16.toString();
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "queryTroopMessageFromDB_UnionTables " + sb6);
        }
        List<MessageRecord> c16 = com.tencent.imcore.message.y.f116741e.c(sb6, null, this);
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public void c(String str, int i3, MessageRecord messageRecord, ProxyListener proxyListener, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), messageRecord, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        T1(str, i3, messageRecord, z18);
        long j3 = messageRecord.shmsgseq;
        if (j3 <= 0) {
            if (j3 < 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 1: peerUin = [" + str + "], type = [" + i3 + "], mr = [" + messageRecord + "]");
                    return;
                }
                return;
            }
            if (!ad.B(messageRecord)) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.msg.TroopMsgProxy", 2, "addMessage() msg discard !!! 2: peerUin = [" + str + "], type = [" + i3 + "], mr = [" + messageRecord + "]");
                    return;
                }
                return;
            }
        }
        u2(str, i3, messageRecord, proxyListener, z16, z17);
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public List<MessageRecord> g0(String str, int i3, long j3, long j16) {
        List<MessageRecord> n26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (j3 != 0 && str != null && str.length() != 0) {
            ArrayList arrayList = new ArrayList();
            List<MessageRecord> r16 = r(str, i3);
            if (r16 != null) {
                for (MessageRecord messageRecord : r16) {
                    if (messageRecord.shmsgseq == j3 && (!messageRecord.isSendFromLocal() || messageRecord.extraflag == 0)) {
                        if (!ad.B(messageRecord)) {
                            arrayList.add(messageRecord);
                        }
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

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public void i() {
        String[] allTableNameFromCache;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.proxyManager.transSaveToDatabase();
        this.proxyManager.clearMsgQueue();
        SQLiteDatabase P1 = P1();
        if (P1 == null || (allTableNameFromCache = P1.getAllTableNameFromCache()) == null) {
            return;
        }
        QSlowTableManager qSlowTableManager = (QSlowTableManager) this.app.getManager(QQManagerFactory.SLOW_TABLE_MANAGER);
        for (String str2 : allTableNameFromCache) {
            if (!str2.startsWith("mr_discusssion") && !str2.startsWith("mr_troop")) {
                str = null;
            } else {
                str = "select frienduin, istroop, shmsgseq as tmpseq, issend from " + str2 + " where shmsgseq=(select max(shmsgseq) from " + str2 + ")";
            }
            if (str != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("", 2, "sql zsw =" + str);
                }
                Cursor rawQuery = P1.rawQuery(str, null);
                if (rawQuery != null) {
                    try {
                        if (rawQuery.getCount() > 0) {
                            rawQuery.moveToFirst();
                            ((QQAppInterface) this.app).getMsgCache().A(rawQuery.getString(rawQuery.getColumnIndexOrThrow("frienduin")), rawQuery.getInt(rawQuery.getColumnIndexOrThrow(AppConstants.Key.COLUMN_IS_TROOP)), rawQuery.getLong(rawQuery.getColumnIndexOrThrow("tmpseq")));
                        }
                    } finally {
                        rawQuery.close();
                    }
                }
                if (rawQuery != null) {
                }
                ArrayList arrayList = new ArrayList();
                try {
                    arrayList.add(new DeleteTransaction(str2, null, null));
                    D().doMultiDBOperateByTransaction(arrayList);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.msg.TroopMsgProxy", 2, "clearAllHistoryFromDB: ", e16);
                    }
                }
                if (qSlowTableManager != null) {
                    qSlowTableManager.b(str2, null, null);
                }
            }
        }
    }

    @Override // com.tencent.imcore.message.y
    protected List<MessageRecord> n2(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB, peerUin[" + FileManagerUtil.enCodecString(str) + "] type[" + i3 + "] shmsgseq[" + j3 + "] msgUid[" + j16 + "]");
        }
        if (j3 == 0 && QLog.isColorLevel()) {
            QLog.e("Q.msg.TroopMsgProxy", 2, "queryMessagesByShmsgseqFromDB Warning! shmsgseq == 0");
        }
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<MessageRecord> c16 = com.tencent.imcore.message.y.f116741e.c("select * from " + MessageRecord.getTableName(str, i3) + " where shmsgseq=?", new String[]{String.valueOf(j3)}, this);
        if (c16 == null) {
            return new ArrayList();
        }
        return c16;
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public int r0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, str, Integer.valueOf(i3), Long.valueOf(j3))).intValue();
        }
        String tableName = MessageRecord.getTableName(str, i3);
        String format = String.format("select * from (select count() as unReadNum from %s mr where mr.isread=0 and mr.issend='0' and mr.%s>'%d'),%s m where m.%s>'%d' order by %s limit 1", tableName, AppConstants.Key.COLUMN_SHMSG_SEQ, Long.valueOf(j3), tableName, AppConstants.Key.COLUMN_SHMSG_SEQ, Long.valueOf(j3), "shmsgseq desc , _id desc");
        if (Z1(str, i3, true)) {
            this.proxyManager.transSaveToDatabase(D());
        }
        List<Entity> rawQuery = DBMethodProxy.rawQuery(D(), Message.class, format, null);
        if (rawQuery == null || rawQuery.isEmpty()) {
            return 0;
        }
        return ((Message) rawQuery.get(0)).unReadNum;
    }

    @Override // com.tencent.imcore.message.y
    protected String s1(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, i3);
        }
        return "select * from " + MessageRecord.getTableName(str, i3) + " where _id in (select _id from " + MessageRecord.getTableName(str, i3) + " order by shmsgseq desc limit 40) order by shmsgseq desc, _id desc";
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public int u(MessageRecord messageRecord, boolean z16) {
        MessageRecord z06;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, this, messageRecord, Boolean.valueOf(z16))).intValue();
        }
        if (messageRecord.extraflag == 32772) {
            z06 = t0(messageRecord, false);
        } else {
            z06 = z0(messageRecord, -2006);
        }
        if (z06 == null) {
            return -1;
        }
        if (!z06.isread) {
            return 2;
        }
        return 1;
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public int v(List<MessageRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, this, list, Boolean.valueOf(z16))).intValue();
        }
        if (list.size() == 0) {
            return -1;
        }
        Iterator<MessageRecord> it = list.iterator();
        while (it.hasNext()) {
            u(it.next(), z16);
        }
        return list.size();
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public void v0(String str, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        y2(str, i3, j3);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
        String valueOf = String.valueOf(j3);
        String tableName = MessageRecord.getTableName(str, i3);
        if (ao.G(i3) && ao.j() != null) {
            D2(str, i3, tableName, contentValues, String.format("isread=? and %s<=? and " + ao.j(), AppConstants.Key.COLUMN_SHMSG_SEQ), new String[]{"0", valueOf}, null);
            return;
        }
        D2(str, i3, tableName, contentValues, String.format("isread=? and %s<=?", AppConstants.Key.COLUMN_SHMSG_SEQ), new String[]{"0", valueOf}, null);
    }

    @Override // com.tencent.imcore.message.y, com.tencent.imcore.message.f
    public MessageRecord y0(String str, int i3, long j3, long j16, long j17) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 22, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17));
        }
        MessageRecord H = H(str, i3, j3);
        if (H != null) {
            z16 = H.shmsgseq <= 0;
            H.shmsgseq = j16;
            H.time = j17;
            String extInfoFromExtStr = H.getExtInfoFromExtStr("key_troop_sending_message_success");
            int i16 = H.extraflag;
            if (i16 == 32772 || i16 == 32768 || TextUtils.equals(extInfoFromExtStr, "1")) {
                H.setExtraFlag(0);
                H.setSendFailCode(0);
                if (!H.isValid) {
                    H.msgtype = -2006;
                    H.isValid = true;
                }
            }
            x(str, i3, j3);
            N(str, i3, H);
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.TroopMsgProxy", 2, "update msgSeq set msg =" + H.getBaseInfoString());
            }
        } else {
            z16 = false;
        }
        if (H != null && H.isSendFromLocal() && z16) {
            I0(str, i3, H, null);
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put(AppConstants.Key.COLUMN_SHMSG_SEQ, Long.valueOf(j16));
            contentValues.put("time", Long.valueOf(j17));
            if (H != null) {
                contentValues.put(AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(H.msgtype));
                contentValues.put(AppConstants.Key.COLUMN_IS_VALID, Boolean.valueOf(H.isValid));
                if (H.extraflag == 0) {
                    contentValues.put(AppConstants.Key.COLUMN_EXTRA_FLAG, (Integer) 0);
                    contentValues.put(AppConstants.Key.COLUMN_SEND_FAIL_CODE, (Integer) 0);
                }
                if (H.getId() > 0) {
                    C2(str, i3, H.versionCode, contentValues, "_id=?", new String[]{String.valueOf(H.getId())}, null);
                } else {
                    C2(str, i3, H.versionCode, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
                }
            } else {
                C2(str, i3, 3, contentValues, "uniseq=?", new String[]{String.valueOf(j3)}, null);
            }
        }
        return H;
    }
}
