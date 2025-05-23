package com.tencent.mobileqq.qwallet.transaction.impl;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.qwallet.temp.IQWalletPBTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletPreferenceApi;
import com.tencent.mobileqq.qwallet.impl.QWalletPreferenceApiImpl;
import com.tencent.mobileqq.qwallet.impl.d;
import com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class NotifyMsgApiImpl implements INotifyMsgApi {
    public static final int BTYPE_AA_PAY = 1;
    public static final int BTYPE_GROUP_HB_GRABBED_LIST = 2;
    public static final String KEY_AAPAY_STATE = "qqpay_state";
    public static final String KEY_GROUP_TYPE = "groupType";
    public static final String KEY_GROUP_UIN = "groupUin";
    public static final String KEY_STATE = "state";
    public static final int LOAD_DB_STATE_FINISH = 2;
    public static final int LOAD_DB_STATE_LOADING = 1;
    public static final int LOAD_DB_STATE_RAW = 0;
    protected static final long MAX_KEEP_GROUP_HB_GRABBED_LIST_TIME_IN_SEC = 172800;
    protected static final long MAX_KEEP_NOTIFY_RECORD_TIME_IN_SEC = 2592000;
    private static final String TAG = "NotifyMsgApi";
    protected static com.tencent.mobileqq.qwallet.transaction.impl.a gDbHelper;
    protected static int gLoadDbState;
    protected static Object gDbHelperLock = new Object();
    protected static ArrayList<a> gWaitRecords = new ArrayList<>();
    protected static ArrayList<b> gWaitNotifyRecords = new ArrayList<>();
    protected static ArrayList<b> gList = new ArrayList<>(128);

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f279205a;

        /* renamed from: b, reason: collision with root package name */
        public String f279206b;

        /* renamed from: c, reason: collision with root package name */
        public MessageRecord f279207c;

        public a(int i3, String str, MessageRecord messageRecord) {
            this.f279205a = i3;
            this.f279206b = str;
            this.f279207c = messageRecord;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0097 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean checkAndUpdateToMesageRecord(final MessageRecord messageRecord, b bVar, int i3, String str, boolean z16) {
        boolean z17;
        MessageForQQWalletMsg messageForQQWalletMsg;
        QQWalletRedPacketMsg qQWalletRedPacketMsg;
        int intValue;
        if (messageRecord != null && str != null) {
            z17 = true;
            if (i3 == 1) {
                if (bVar == null) {
                    bVar = getRecord(gList, i3, str);
                }
                if (bVar != null) {
                    int b16 = bVar.b("state", -1);
                    String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(KEY_AAPAY_STATE);
                    if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                        try {
                            intValue = Integer.valueOf(extInfoFromExtStr).intValue();
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
                            }
                        }
                        if (b16 != -1 && b16 != intValue) {
                            messageRecord.saveExtInfoToExtStr(KEY_AAPAY_STATE, String.valueOf(b16));
                            if (z17 && z16) {
                                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (d.n() != null && MessageRecord.this != null) {
                                            IMessageFacade iMessageFacade = (IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
                                            MessageRecord messageRecord2 = MessageRecord.this;
                                            iMessageFacade.updateMsgFieldByUniseq(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord2.extStr);
                                        }
                                    }
                                }, 5, null, false);
                            }
                            return z17;
                        }
                    }
                    intValue = -1;
                    if (b16 != -1) {
                        messageRecord.saveExtInfoToExtStr(KEY_AAPAY_STATE, String.valueOf(b16));
                        if (z17) {
                            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (d.n() != null && MessageRecord.this != null) {
                                        IMessageFacade iMessageFacade = (IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
                                        MessageRecord messageRecord2 = MessageRecord.this;
                                        iMessageFacade.updateMsgFieldByUniseq(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord2.extStr);
                                    }
                                }
                            }, 5, null, false);
                        }
                        return z17;
                    }
                }
            } else if (i3 == 2) {
                if (bVar == null) {
                    bVar = getRecord(gList, i3, str);
                }
                if (bVar != null && (messageRecord instanceof MessageForQQWalletMsg) && (qQWalletRedPacketMsg = (messageForQQWalletMsg = (MessageForQQWalletMsg) messageRecord).mQQWalletRedPacketMsg) != null && qQWalletRedPacketMsg.isOpened) {
                    qQWalletRedPacketMsg.isOpened = true;
                    messageForQQWalletMsg.msgData = messageForQQWalletMsg.getBytes();
                    if (d.n() != null) {
                        ((IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForQQWalletMsg.frienduin, messageForQQWalletMsg.istroop, messageForQQWalletMsg.uniseq, messageForQQWalletMsg.msgData);
                    }
                }
            }
        }
        z17 = false;
        if (z17) {
        }
        return z17;
    }

    public static boolean checkBusinessTypeStatic(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    protected static b getRecord(ArrayList<b> arrayList, int i3, String str) {
        String str2;
        if (arrayList == null) {
            return null;
        }
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            b bVar = arrayList.get(i16);
            if (bVar != null && bVar.f279237c == i3 && (str2 = bVar.f279238d) != null && str2.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    protected static ArrayList<b> getRecords(ArrayList<b> arrayList, int i3) {
        if (arrayList == null) {
            return null;
        }
        ArrayList<b> arrayList2 = new ArrayList<>();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            b bVar = arrayList.get(i16);
            if (bVar != null && bVar.f279237c == i3) {
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    protected static boolean isInWaitList(int i3, String str, MessageRecord messageRecord) {
        String str2;
        for (int i16 = 0; i16 < gWaitRecords.size(); i16++) {
            a aVar = gWaitRecords.get(i16);
            if (aVar != null && aVar.f279205a == i3 && (str2 = aVar.f279206b) != null && str2.equals(str) && aVar.f279207c == messageRecord) {
                return true;
            }
        }
        return false;
    }

    protected static void loadFromDb() {
        gLoadDbState = 1;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (NotifyMsgApiImpl.gDbHelperLock) {
                    if (NotifyMsgApiImpl.gDbHelper == null) {
                        NotifyMsgApiImpl.gDbHelper = new com.tencent.mobileqq.qwallet.transaction.impl.a(MobileQQ.sMobileQQ);
                    }
                }
                BaseQQAppInterface n3 = d.n();
                if (n3 == null) {
                    return;
                }
                com.tencent.mobileqq.qwallet.transaction.impl.a aVar = NotifyMsgApiImpl.gDbHelper;
                if (aVar != null) {
                    aVar.d(n3.getCurrentUin(), NotifyMsgApiImpl.gList);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(NotifyMsgApiImpl.TAG, 2, "loadFromDb completed");
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Iterator it = new ArrayList(NotifyMsgApiImpl.gWaitNotifyRecords).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar != null) {
                        b record = NotifyMsgApiImpl.getRecord(NotifyMsgApiImpl.gList, bVar.f279237c, bVar.f279238d);
                        if (record != null) {
                            arrayList2.add(NotifyMsgApiImpl.onMergeMsg(bVar, record));
                        } else {
                            NotifyMsgApiImpl.gList.add(bVar);
                            arrayList.add(bVar);
                        }
                    }
                }
                NotifyMsgApiImpl.gWaitNotifyRecords.clear();
                if (arrayList.size() > 0) {
                    NotifyMsgApiImpl.updateOrCreateToDb(arrayList, true);
                }
                if (arrayList2.size() > 0) {
                    NotifyMsgApiImpl.updateOrCreateToDb(arrayList2, false);
                }
                NotifyMsgApiImpl.gLoadDbState = 2;
                NotifyMsgApiImpl.updateToMessageRecord(NotifyMsgApiImpl.gWaitRecords);
                Iterator<a> it5 = NotifyMsgApiImpl.gWaitRecords.iterator();
                while (it5.hasNext()) {
                    a next = it5.next();
                    if (next != null) {
                        NotifyMsgApiImpl.notifyUI(next);
                    }
                }
                NotifyMsgApiImpl.gWaitRecords.clear();
                long j3 = ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).getLong(n3.getCurrentUin(), QWalletPreferenceApiImpl.KEY_QWALLET_LAST_CLEAR_NOTIFY_TIME, 0L);
                long serverTime = NetConnInfoCenter.getServerTime();
                com.tencent.mobileqq.qwallet.transaction.impl.a aVar2 = NotifyMsgApiImpl.gDbHelper;
                if (aVar2 != null) {
                    if (j3 > serverTime || serverTime - j3 > NotifyMsgApiImpl.MAX_KEEP_GROUP_HB_GRABBED_LIST_TIME_IN_SEC) {
                        aVar2.a(NotifyMsgApiImpl.MAX_KEEP_NOTIFY_RECORD_TIME_IN_SEC, null);
                        int[] iArr = {2};
                        com.tencent.mobileqq.qwallet.transaction.impl.a aVar3 = NotifyMsgApiImpl.gDbHelper;
                        if (aVar3 != null) {
                            aVar3.a(NotifyMsgApiImpl.MAX_KEEP_GROUP_HB_GRABBED_LIST_TIME_IN_SEC, iArr);
                        }
                        ((IQWalletPreferenceApi) QRoute.api(IQWalletPreferenceApi.class)).putLong(n3.getCurrentUin(), QWalletPreferenceApiImpl.KEY_QWALLET_LAST_CLEAR_NOTIFY_TIME, serverTime);
                    }
                }
            }
        }, 10, null, false);
    }

    protected static void notifyUI(a aVar) {
        BaseQQAppInterface n3;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "notifyUI start");
        }
        if (aVar == null || aVar.f279207c == null || (n3 = d.n()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("btype", aVar.f279205a);
        bundle.putString("bid", aVar.f279206b);
        n3.notifyObservers(sl2.a.class, 1, true, bundle);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "notifyUI btype:" + aVar.f279205a + " bid:" + aVar.f279206b);
        }
    }

    public static void onGroupHbGrabbedNotify(String str, int i3, String str2) {
        BaseQQAppInterface n3;
        if ((i3 != 1 && i3 != 3000) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (n3 = d.n()) == null) {
            return;
        }
        b bVar = new b(0, n3.getLongAccountUin(), 2, str2, 0L, null);
        bVar.e("groupUin", str);
        bVar.d(KEY_GROUP_TYPE, i3);
        updateOrCreate(n3.getLongAccountUin(), bVar);
    }

    protected static b onMergeMsg(b bVar, b bVar2) {
        String str;
        if (bVar != null && bVar2 != null && bVar.f279237c == bVar2.f279237c && (str = bVar.f279238d) != null && str.equals(bVar2.f279238d)) {
            if (bVar.f279237c == 1) {
                int b16 = bVar2.b("state", 0);
                int b17 = bVar.b("state", 0);
                if (b16 != 2) {
                    b16 = b17;
                }
                bVar2.d("state", b16);
                return bVar2;
            }
            bVar2.f279240f = bVar.f279240f;
        }
        return bVar2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (r13 != 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r2 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001e, code lost:
    
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        com.tencent.qphone.base.util.QLog.i(com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.TAG, 2, "onReceiveAAPaySysNotify type:" + r12 + " billno:" + r13 + " action:" + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006d, code lost:
    
        if (r12 == 3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        r12 = com.tencent.mobileqq.qwallet.impl.d.n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (r12 != null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0077, code lost:
    
        r14 = new com.tencent.mobileqq.qwallet.transaction.impl.b(0, r12.getLongAccountUin(), 1, r13, 0, null);
        r14.d("state", r2);
        updateOrCreate(r12.getLongAccountUin(), r14);
        r14 = new android.os.Bundle();
        r14.putInt("btype", 1);
        r14.putString("bid", r13);
        r12.notifyObservers(sl2.a.class, 1, true, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0038, code lost:
    
        if (r13 != 0) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void onReceiveAAPaySysNotifyStatic(int i3, QWalletGoldMsgTipsElem qWalletGoldMsgTipsElem, QWalletGoldMsgTipsElem qWalletGoldMsgTipsElem2) {
        int i16;
        int i17;
        int i18 = 0;
        String str = null;
        if (i3 == 3000 && qWalletGoldMsgTipsElem2 != null) {
            i16 = qWalletGoldMsgTipsElem2.type;
            if (i16 == 0) {
                i16 = 0;
            }
            if (!TextUtils.isEmpty(qWalletGoldMsgTipsElem2.billno)) {
                str = qWalletGoldMsgTipsElem2.billno;
            }
            i17 = qWalletGoldMsgTipsElem2.action;
        } else if ((i3 == 1 || i3 == 0) && qWalletGoldMsgTipsElem != null) {
            i16 = qWalletGoldMsgTipsElem.type;
            if (i16 == 0) {
                i16 = 0;
            }
            if (!TextUtils.isEmpty(qWalletGoldMsgTipsElem.billno)) {
                str = qWalletGoldMsgTipsElem.billno;
            }
            i17 = qWalletGoldMsgTipsElem.action;
        }
    }

    public static void preloadData() {
        if (gLoadDbState == 0) {
            loadFromDb();
        }
    }

    public static b queryNotifyMsgRecord(int i3, String str, MessageRecord messageRecord) {
        b bVar = null;
        if (checkBusinessTypeStatic(i3) && !TextUtils.isEmpty(str) && messageRecord != null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "queryGoldMsgRecord btype:" + i3 + " bid:" + str + " dbstate:" + gLoadDbState);
            }
            if (gLoadDbState == 2) {
                bVar = getRecord(gList, i3, str);
                if (bVar != null) {
                    checkAndUpdateToMesageRecord(messageRecord, bVar, i3, str, true);
                }
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "queryGoldMsgRecord check in cache:" + bVar);
                }
            } else {
                if (i3 != 2) {
                    synchronized (gWaitRecords) {
                        if (!isInWaitList(i3, str, messageRecord)) {
                            gWaitRecords.add(new a(i3, str, messageRecord));
                        }
                    }
                }
                if (gLoadDbState == 0) {
                    loadFromDb();
                }
            }
        }
        return bVar;
    }

    public static ArrayList<b> queryRecordsInMemory(int i3) {
        int i16;
        if (!checkBusinessTypeStatic(i3)) {
            return null;
        }
        int i17 = gLoadDbState;
        if (i17 == 2) {
            ArrayList<b> records = getRecords(gList, i3);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("queryRecordsInMemory size:");
                if (records != null) {
                    i16 = records.size();
                } else {
                    i16 = 0;
                }
                sb5.append(i16);
                QLog.i(TAG, 2, sb5.toString());
            }
            return records;
        }
        if (i17 == 0) {
            loadFromDb();
        }
        return null;
    }

    protected static void updateOrCreate(long j3, b bVar) {
        if (bVar != null && checkBusinessTypeStatic(bVar.f279237c) && !TextUtils.isEmpty(bVar.f279238d)) {
            b record = getRecord(gList, bVar.f279237c, bVar.f279238d);
            if (record == null) {
                if (gLoadDbState == 2) {
                    gList.add(bVar);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(bVar);
                    updateOrCreateToDb(arrayList, true);
                    return;
                }
                b record2 = getRecord(new ArrayList(gWaitNotifyRecords), bVar.f279237c, bVar.f279238d);
                if (record2 == null) {
                    gWaitNotifyRecords.add(bVar);
                } else {
                    onMergeMsg(bVar, record2);
                }
                if (gLoadDbState == 0) {
                    loadFromDb();
                    return;
                }
                return;
            }
            if (bVar.f279237c != 2) {
                onMergeMsg(bVar, record);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(record);
                updateOrCreateToDb(arrayList2, false);
            }
        }
    }

    protected static void updateOrCreateToDb(final ArrayList<b> arrayList, final boolean z16) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.4
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.mobileqq.qwallet.transaction.impl.a aVar;
                synchronized (NotifyMsgApiImpl.gDbHelperLock) {
                    if (NotifyMsgApiImpl.gDbHelper == null) {
                        NotifyMsgApiImpl.gDbHelper = new com.tencent.mobileqq.qwallet.transaction.impl.a(BaseApplication.getContext());
                    }
                }
                BaseQQAppInterface n3 = d.n();
                if (n3 != null && (aVar = NotifyMsgApiImpl.gDbHelper) != null) {
                    if (z16) {
                        aVar.c(n3.getCurrentUin(), arrayList);
                    } else {
                        aVar.e(n3.getCurrentUin(), arrayList);
                    }
                }
            }
        }, 5, null, false);
    }

    protected static void updateToMessageRecord(List<a> list) {
        if (list != null && list.size() > 0) {
            final ArrayList arrayList = new ArrayList();
            for (a aVar : list) {
                if (aVar != null && checkAndUpdateToMesageRecord(aVar.f279207c, null, aVar.f279205a, aVar.f279206b, false)) {
                    arrayList.add(aVar);
                }
            }
            if (arrayList.size() <= 0) {
                return;
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.n() != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a aVar2 = (a) it.next();
                            if (aVar2 != null && aVar2.f279207c != null) {
                                IMessageFacade iMessageFacade = (IMessageFacade) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IMessageFacade.class, "");
                                MessageRecord messageRecord = aVar2.f279207c;
                                iMessageFacade.updateMsgFieldByUniseq(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
                            }
                        }
                    }
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
    public boolean checkBusinessType(int i3) {
        return checkBusinessTypeStatic(i3);
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
    public int getAAPayState(String str, MessageRecord messageRecord) {
        b queryNotifyMsgRecord = queryNotifyMsgRecord(1, str, messageRecord);
        if (queryNotifyMsgRecord != null) {
            return queryNotifyMsgRecord.b("state", -1);
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
    public boolean isBusinessTypeAAPay(int i3) {
        if (i3 == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
    public void onActiveAccount() {
        gLoadDbState = 0;
        gList.clear();
        gWaitRecords.clear();
        gWaitNotifyRecords.clear();
        com.tencent.mobileqq.qwallet.transaction.impl.a aVar = gDbHelper;
        if (aVar != null) {
            try {
                aVar.close();
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
            }
            gDbHelper = null;
        }
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
    public void onReceiveAAPaySysNotify(int i3, Object obj, Object obj2) {
        try {
            onReceiveAAPaySysNotifyStatic(i3, ((IQWalletPBTemp) QRoute.api(IQWalletPBTemp.class)).convertTroopTips(obj), ((IQWalletPBTemp) QRoute.api(IQWalletPBTemp.class)).convertTroopTips(obj2));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.transaction.INotifyMsgApi
    public String getAAPayState(@NonNull MessageRecord messageRecord) {
        return messageRecord.getExtInfoFromExtStr(KEY_AAPAY_STATE);
    }
}
