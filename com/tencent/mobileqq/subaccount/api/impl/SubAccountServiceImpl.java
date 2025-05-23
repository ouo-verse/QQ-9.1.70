package com.tencent.mobileqq.subaccount.api.impl;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.message.m;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.data.SubAccountMessage;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.transaction.RemoveTransaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.mobileqq.subaccount.api.ISubAccountControlService;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.subaccount.h;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.api.IAppBadgeService;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactData;
import com.tencent.util.Pair;
import com.tencent.util.notification.NotificationController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SubAccountServiceImpl implements ISubAccountService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "SubAccountServiceImpl_SUB_ACCOUNT";

    /* renamed from: em, reason: collision with root package name */
    EntityManager f291085em;
    ArrayList<SubAccountInfo> listSubInfo;
    Lock lock;
    private boolean mNotifySwitch;
    public HashMap<String, ArrayList<SubAccountMessage>> mapSubMsg;

    public SubAccountServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.listSubInfo = new ArrayList<>();
        this.mapSubMsg = new HashMap<>();
        this.lock = new ReentrantLock();
        this.mNotifySwitch = true;
    }

    private void inflateMsgData() {
        Integer valueOf;
        this.lock.lock();
        try {
            this.mapSubMsg.clear();
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                String str = next.subuin;
                ArrayList<SubAccountMessage> arrayList = (ArrayList) this.f291085em.query(SubAccountMessage.class, SubAccountMessage.class.getSimpleName(), false, "subUin=?", new String[]{str}, (String) null, (String) null, "time desc", (String) null);
                if (arrayList != null && arrayList.size() > 0) {
                    this.mapSubMsg.put(str, arrayList);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("init() query subUin:");
                    sb5.append(str);
                    sb5.append(" allMsg and put map.list=");
                    if (arrayList == null) {
                        valueOf = null;
                    } else {
                        valueOf = Integer.valueOf(arrayList.size());
                    }
                    sb5.append(valueOf);
                    QLog.d(TAG, 2, sb5.toString());
                }
                countUnreadDatum(next, arrayList, 0);
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeAllMessage$0(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new RemoveTransaction((SubAccountMessage) it.next()));
        }
        if (!arrayList.isEmpty()) {
            this.f291085em.doMultiDBOperateByTransaction(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateRecentContact$1(int i3, String str) {
        QLog.i(TAG, 2, "[updateRecentContact] onResult:" + i3 + " ,errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$updateRecentContact$2() {
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.e(TAG, 1, "updateRecentContact service is null");
            return;
        }
        RecentContactData recentContactData = ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).getRecentContactData();
        if (recentContactData == null) {
            return;
        }
        recentContactService.upsertRecentContactManually(recentContactData, new IOperateCallback() { // from class: com.tencent.mobileqq.subaccount.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                SubAccountServiceImpl.lambda$updateRecentContact$1(i3, str);
            }
        });
    }

    private void sendBindUinMsgSwitchToServer(AppInterface appInterface, boolean z16) {
        boolean readMsgSwitch = readMsgSwitch(appInterface);
        NotificationController notificationController = (NotificationController) appInterface.getBusinessHandler(NotificationController.class.getName());
        if (notificationController != null) {
            notificationController.requestSetNewMsgSwitch(readMsgSwitch, z16);
            QLog.d("HPush", 1, "HPush_Huawei Push sendBindUinMsgSwitchToServer : " + z16);
        }
    }

    private void updateRecentContact() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.subaccount.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                SubAccountServiceImpl.lambda$updateRecentContact$2();
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void addNewMessage(SubAccountMessage subAccountMessage) {
        SubAccountInfo subAccountInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) subAccountMessage);
            return;
        }
        if (QLog.isColorLevel()) {
            if (subAccountMessage == null) {
                str = "null";
            } else {
                str = "subUin=" + subAccountMessage.subUin + " senderUin=" + subAccountMessage.senderuin;
            }
            QLog.d(TAG, 2, "addNewMessage() " + str);
        }
        if (!this.mNotifySwitch) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addNewMessage notify off");
                return;
            }
            return;
        }
        if (subAccountMessage != null && subAccountMessage.subUin != null && subAccountMessage.senderuin != null) {
            if (QLog.isDebugVersion()) {
                QLog.d(TAG, 4, "[addNewMessage] msg:" + subAccountMessage);
            }
            this.lock.lock();
            try {
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        subAccountInfo = it.next();
                        if (subAccountInfo != null && subAccountMessage.subUin.equals(subAccountInfo.subuin)) {
                            break;
                        }
                    } else {
                        subAccountInfo = null;
                        break;
                    }
                }
                if (this.mapSubMsg.containsKey(subAccountMessage.subUin)) {
                    ArrayList<SubAccountMessage> arrayList = this.mapSubMsg.get(subAccountMessage.subUin);
                    if (arrayList == null) {
                        ArrayList<SubAccountMessage> arrayList2 = new ArrayList<>();
                        arrayList2.add(subAccountMessage);
                        this.mapSubMsg.put(subAccountMessage.subUin, arrayList2);
                        countUnreadDatum(subAccountInfo, arrayList2, 1);
                    } else {
                        Iterator<SubAccountMessage> it5 = arrayList.iterator();
                        while (true) {
                            if (!it5.hasNext()) {
                                break;
                            }
                            SubAccountMessage next = it5.next();
                            if (subAccountMessage.subUin.equals(next.subUin) && subAccountMessage.senderuin.equals(next.senderuin)) {
                                if (QLog.isDebugVersion()) {
                                    QLog.d(TAG, 4, "[addNewMessage] tMsg:" + next);
                                }
                                String str2 = AppConstants.SUBACCOUNT_TROOP_UIN;
                                if (str2.equals(subAccountMessage.senderuin) && subAccountMessage.time == 0 && subAccountMessage.unreadNum == 0) {
                                    subAccountMessage.time = next.time;
                                } else if (str2.equals(subAccountMessage.senderuin)) {
                                    long j3 = subAccountMessage.time;
                                    long j16 = next.time;
                                    if (j3 <= j16) {
                                        subAccountMessage.unreadNum = next.unreadNum;
                                        subAccountMessage.time = j16;
                                    }
                                }
                                arrayList.remove(next);
                                this.f291085em.remove(next);
                            }
                        }
                        arrayList.add(0, subAccountMessage);
                        countUnreadDatum(subAccountInfo, arrayList, 1);
                    }
                } else {
                    ArrayList<SubAccountMessage> arrayList3 = new ArrayList<>();
                    arrayList3.add(subAccountMessage);
                    this.mapSubMsg.put(subAccountMessage.subUin, arrayList3);
                    countUnreadDatum(subAccountInfo, arrayList3, 1);
                }
                this.lock.unlock();
                updateEntity(subAccountMessage);
            } catch (Throwable th5) {
                this.lock.unlock();
                throw th5;
            }
        }
    }

    SubAccountMessage buildTroopMsgBox(String str) {
        SubAccountMessage subAccountMessage = new SubAccountMessage();
        subAccountMessage.frienduin = String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE);
        subAccountMessage.unreadNum = 0;
        subAccountMessage.msgtype = -1000;
        subAccountMessage.senderuin = String.valueOf(AppConstants.SUBACCOUNT_TROOP_UIN_LONGVALUE);
        subAccountMessage.subUin = str;
        subAccountMessage.istroop = 1;
        subAccountMessage.sendername = HardCodeUtil.qqStr(R.string.f229626wy);
        subAccountMessage.f203118msg = "";
        return subAccountMessage;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (r1.hintIsNew == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
    
        r1.hintIsNew = false;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void cancelHintIsNew(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cancelHintIsNew() subUin=" + str);
        }
        if (str != null && str.length() > 4) {
            this.lock.lock();
            try {
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                }
                subAccountInfo = null;
                if (subAccountInfo != null) {
                    ThreadManager.getFileThreadHandler().post(new Runnable(subAccountInfo) { // from class: com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl.3
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ SubAccountInfo f291088d;

                        {
                            this.f291088d = subAccountInfo;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountServiceImpl.this, (Object) subAccountInfo);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            SubAccountInfo subAccountInfo2 = this.f291088d;
                            if (subAccountInfo2 != null) {
                                SubAccountServiceImpl.this.updateEntity(subAccountInfo2);
                            }
                        }
                    });
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void clearAllUnNotifySenderNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearAllUnNotifySenderNum()");
        }
        if (this.listSubInfo == null) {
            return;
        }
        if (this.mapSubMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "clearAllUnNotifySenderNum() mapSubMsg is null.");
                return;
            }
            return;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (next != null) {
                    next.unNotifySender = 0;
                    ArrayList<SubAccountMessage> arrayList = this.mapSubMsg.get(next.subuin);
                    if (arrayList != null && arrayList.size() != 0) {
                        Iterator<SubAccountMessage> it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            SubAccountMessage next2 = it5.next();
                            if (next2.needNotify) {
                                next2.needNotify = false;
                            }
                        }
                    }
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
    
        r9 = r4.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0084, code lost:
    
        if (r9.hasNext() == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0086, code lost:
    
        r0 = r9.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008c, code lost:
    
        if (r0 != null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0092, code lost:
    
        if (r0.needNotify == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
    
        r0.needNotify = false;
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009b, code lost:
    
        if (r0.unreadNum == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009d, code lost:
    
        r0.unreadNum = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a1, code lost:
    
        if (r6 == false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00a3, code lost:
    
        updateEntity(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a0, code lost:
    
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a7, code lost:
    
        r3.unNotifySender = 0;
        r3.unreadMsgNum = 0;
        r3.unreadSenderNum = 0;
        r3.unreadTroopMsgNum = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b3, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b5, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl.TAG, 2, "clearUnreadNum() info.subuin=" + r3.subuin + " unreadMsgNum=" + r3.unreadMsgNum + " unNotify=" + r3.unNotifySender + " unreadSender=" + r3.unreadSenderNum);
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void clearUnreadNum(String str) {
        String str2;
        String str3;
        HashMap<String, ArrayList<SubAccountMessage>> hashMap;
        ArrayList<SubAccountMessage> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "clearUnreadNum() subUin=" + str);
        }
        if (str == null) {
            return;
        }
        ArrayList<SubAccountInfo> arrayList2 = this.listSubInfo;
        if (arrayList2 != null && arrayList2.size() != 0 && (hashMap = this.mapSubMsg) != null && hashMap.size() != 0) {
            this.lock.lock();
            try {
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SubAccountInfo next = it.next();
                    if (next != null && str.equals(next.subuin) && (arrayList = this.mapSubMsg.get(str)) != null && arrayList.size() != 0) {
                        break;
                    }
                }
                return;
            } finally {
                this.lock.unlock();
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("clearUnreadNum() ");
            if (this.listSubInfo == null) {
                str2 = "listSubInfo == null";
            } else {
                str2 = "listSubInfo.size() == 0";
            }
            sb5.append(str2);
            QLog.d(TAG, 2, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("clearUnreadNum() ");
            if (this.mapSubMsg == null) {
                str3 = "mapSubMsg == null";
            } else {
                str3 = "mapSubMsg.size() == 0";
            }
            sb6.append(str3);
            QLog.d(TAG, 2, sb6.toString());
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void countUnreadDatum(SubAccountInfo subAccountInfo, ArrayList<SubAccountMessage> arrayList, int i3) {
        String str;
        Object valueOf;
        Iterator<SubAccountMessage> it;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, subAccountInfo, arrayList, Integer.valueOf(i3));
            return;
        }
        if (subAccountInfo != null && arrayList != null) {
            Collections.sort(arrayList);
            Iterator<SubAccountMessage> it5 = arrayList.iterator();
            boolean z16 = true;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            while (it5.hasNext()) {
                SubAccountMessage next = it5.next();
                if (next != null) {
                    if (z16) {
                        if (next.mEmoRecentMsg == null && next.f203118msg != null) {
                            next.mEmoRecentMsg = new QQText(next.f203118msg, 3, 16);
                        }
                        subAccountInfo.lastMsg = next.mEmoRecentMsg;
                        long j3 = subAccountInfo.lasttime;
                        it = it5;
                        long j16 = next.time;
                        if (j3 <= j16) {
                            j3 = j16;
                        }
                        subAccountInfo.lasttime = j3;
                        subAccountInfo.lastUin = next.frienduin;
                        subAccountInfo.lastUinNick = next.sendername;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "countUnreadDatum() change lasttime=" + subAccountInfo.lasttime);
                        }
                        z16 = false;
                    } else {
                        it = it5;
                    }
                    if (next.istroop == 1) {
                        i19 += next.unreadNum;
                    } else if (!next.isread) {
                        i17 += next.unreadNum;
                        i18++;
                    }
                    if (next.needNotify) {
                        i16++;
                    }
                    it5 = it;
                }
            }
            subAccountInfo.unNotifySender = i16;
            subAccountInfo.unreadMsgNum = i17;
            subAccountInfo.unreadSenderNum = i18;
            subAccountInfo.unreadTroopMsgNum = i19;
            if (z16) {
                subAccountInfo.lastMsg = null;
                subAccountInfo.lasttime = 0L;
                subAccountInfo.lastUin = null;
                subAccountInfo.lastUinNick = null;
            }
            if (i3 == 1 && subAccountInfo.hintIsNew) {
                subAccountInfo.hintIsNew = false;
                updateEntity(subAccountInfo);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "countUnreadDatum() set hintIsNew=false");
                }
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("countUnreadDatum() info.subuin=");
                sb5.append(subAccountInfo.subuin);
                sb5.append(" unreadMsg=");
                sb5.append(subAccountInfo.unreadMsgNum);
                sb5.append(" unNotify=");
                sb5.append(subAccountInfo.unNotifySender);
                sb5.append(" unreadSender=");
                sb5.append(subAccountInfo.unreadSenderNum);
                sb5.append(" lastUin=");
                sb5.append(subAccountInfo.lastUin);
                sb5.append(" lastNick=");
                String str2 = subAccountInfo.lastUinNick;
                if (str2 == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(str2.length());
                }
                sb5.append(valueOf);
                sb5.append(" lastTime=");
                sb5.append(subAccountInfo.lasttime);
                QLog.d(TAG, 2, sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("countUnreadDatum() return,");
            if (subAccountInfo == null) {
                str = "info == null";
            } else {
                str = "list == null";
            }
            sb6.append(str);
            QLog.d(TAG, 2, sb6.toString());
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public com.tencent.mobileqq.app.message.a createSubAccountMessageProcessor(AppInterface appInterface, BaseMessageHandler baseMessageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.app.message.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) baseMessageHandler);
        }
        return new m(appInterface, baseMessageHandler);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public SubAccountMessage findSubAccountMessage(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (SubAccountMessage) iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, (Object) str2);
        }
        if (str != null && str2 != null) {
            List<SubAccountMessage> allMessage = getAllMessage(str);
            if (allMessage == null || allMessage.size() == 0) {
                return null;
            }
            for (SubAccountMessage subAccountMessage : allMessage) {
                if (subAccountMessage != null && str.equals(subAccountMessage.subUin) && str2.equals(subAccountMessage.senderuin)) {
                    return subAccountMessage;
                }
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "findSubAccountMessage() return, subUin=" + str + " sendUin=" + str2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public String getA2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        SubAccountInfo subAccountInfo = getSubAccountInfo(str);
        if (subAccountInfo != null) {
            return subAccountInfo.A2;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public long getActionTime(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Long) iPatchRedirector.redirect((short) 42, (Object) this, (Object) str)).longValue();
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getActionTime() subUin is null.");
            }
            return 0L;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getActionTime() listSubInfo is null.");
            }
            return 0L;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo == null) {
                return 0L;
            }
            return subAccountInfo.lasttime;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public List<SubAccountMessage> getAllMessage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (List) iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        if (!this.mNotifySwitch) {
            return arrayList;
        }
        this.lock.lock();
        try {
            HashMap<String, ArrayList<SubAccountMessage>> hashMap = this.mapSubMsg;
            if (hashMap != null && hashMap.containsKey(str)) {
                ArrayList<SubAccountMessage> arrayList2 = this.mapSubMsg.get(str);
                if (arrayList2 == null) {
                    return arrayList;
                }
                Iterator<SubAccountMessage> it = arrayList2.iterator();
                SubAccountMessage subAccountMessage = null;
                while (it.hasNext()) {
                    SubAccountMessage next = it.next();
                    if (AppConstants.SUBACCOUNT_TROOP_UIN.equals(next.senderuin)) {
                        subAccountMessage = next;
                    } else {
                        arrayList.add(next);
                    }
                }
                if (subAccountMessage != null && subAccountMessage.hasUnreadMsg()) {
                    arrayList.add(0, subAccountMessage);
                }
            }
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public ArrayList<SubAccountInfo> getAllSubAccountInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList<SubAccountInfo> arrayList = new ArrayList<>();
        this.lock.lock();
        try {
            arrayList.addAll(this.listSubInfo);
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public ArrayList<String> getAllSubUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ArrayList) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getAllSubUin() listSubInfo is null. return null;");
                return null;
            }
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (next != null) {
                    arrayList.add(next.subuin);
                }
            }
            this.lock.unlock();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getAllSubUin() return:" + String.valueOf(arrayList));
            }
            return arrayList;
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int getBindedNumber() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        this.lock.lock();
        try {
            ArrayList<SubAccountInfo> arrayList = this.listSubInfo;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            this.lock.unlock();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getBindedNumber() bindedNum=" + i3);
            }
            return i3;
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public byte[] getCookie(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCookie() subUin=" + str);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getCookie() subUin is null.");
            }
            return null;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getCookie() listSubInfo is null.");
            }
            return null;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo == null) {
                return null;
            }
            return subAccountInfo.cookie;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public CharSequence getLatestMsg(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (CharSequence) iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLatestMsg() subUin is null.");
            }
            return null;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLatestMsg() listSubInfo is null.");
            }
            return null;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo == null) {
                return null;
            }
            return subAccountInfo.lastMsg;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public String getLatestUin(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (String) iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLatestUin() subUin is null.");
            }
            return null;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLatestUin() listSubInfo is null.");
            }
            return null;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo == null) {
                return null;
            }
            return subAccountInfo.lastUin;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public String getLatestUinNick(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (String) iPatchRedirector.redirect((short) 45, (Object) this, (Object) str);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLatestNick() subUin is null.");
            }
            return null;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getLatestNick() listSubInfo is null.");
            }
            return null;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo == null) {
                return null;
            }
            return subAccountInfo.lastUinNick;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public HashMap<String, ArrayList<SubAccountMessage>> getMapSubMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mapSubMsg;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public boolean getNotifySwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this)).booleanValue();
        }
        return this.mNotifySwitch;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public Pair<Integer, String> getServerError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Pair) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
        Pair<Integer, String> pair = null;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getServerError() subUin is null.");
            }
            return null;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getServerError() listSubInfo is null.");
            }
            return null;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            SubAccountInfo subAccountInfo = null;
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    subAccountInfo = next;
                }
            }
            if (subAccountInfo != null) {
                pair = new Pair<>(Integer.valueOf(subAccountInfo.serverErrorType), subAccountInfo.serverErrorMsg);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getServerError() findInfo errType=" + subAccountInfo.serverErrorType + " errMsg=" + subAccountInfo.serverErrorMsg);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getServerError() findInfo is null.");
            }
            return pair;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int getStatus(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str)).intValue();
        }
        int i3 = 0;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getStatus() subUin is null.");
            }
            return 0;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getStatus() listSubInfo is null.");
            }
            return 0;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            SubAccountInfo subAccountInfo = null;
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    subAccountInfo = next;
                }
            }
            if (subAccountInfo != null) {
                i3 = subAccountInfo.status;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getStatus() findInfo status=" + i3);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getStatus() findInfo is null. return default 0");
            }
            return i3;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public SubAccountInfo getSubAccountInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (SubAccountInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        SubAccountInfo subAccountInfo = null;
        if (str == null) {
            return null;
        }
        this.lock.lock();
        try {
            ArrayList<SubAccountInfo> arrayList = this.listSubInfo;
            if (arrayList != null) {
                Iterator<SubAccountInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    SubAccountInfo next = it.next();
                    if (next != null && (ISubAccountControlService.UIN_DEFAULT.equals(str) || str.equals(next.subuin))) {
                        subAccountInfo = next;
                        break;
                    }
                }
            }
            return subAccountInfo;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int getUnNotifySenderNum(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this, (Object) str)).intValue();
        }
        int i3 = 0;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnNotificationSenderNum() subUin is null.");
            }
            return 0;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnNotificationSenderNum() listSubInfo is null.");
            }
            return 0;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    i3 = next.unNotifySender;
                }
            }
            return i3;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int getUnreadAllMsgNum(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str)).intValue();
        }
        int i3 = 0;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnreadAllMsgNum() subUin is null.");
            }
            return 0;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnreadAllMsgNum() listSubInfo is null.");
            }
            return 0;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    i3 = next.unreadMsgNum;
                }
            }
            return i3;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int getUnreadAllTroopMsgNum(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str)).intValue();
        }
        int i3 = 0;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnreadAllTroopMsgNum() subUin is null.");
            }
            return 0;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnreadAllTroopMsgNum() listSubInfo is null.");
            }
            return 0;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    i3 = next.unreadTroopMsgNum;
                }
            }
            return i3;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int getUnreadSenderNum(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this, (Object) str)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getUnreadSenderNum() subUin=" + str);
        }
        int i3 = 0;
        if (str == null) {
            return 0;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getUnreadSenderNum() listSubInfo is null.");
            }
            return 0;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    i3 = next.unreadSenderNum;
                }
            }
            return i3;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r0 = r2.hintIsNew;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean hintIsNew(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "hintIsNew() subUin is null.");
            }
            return false;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    break;
                }
            }
            return z16;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x004a, code lost:
    
        r2 = r4.isTop;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isRecentListTop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) str)).booleanValue();
        }
        boolean z16 = false;
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isRecentListTop() subUin is null.");
            }
            return false;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    break;
                }
            }
            this.lock.unlock();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isRecentListTop() subUin.top=" + z16);
            }
            return z16;
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public boolean isSubAccountUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isSubAccountUin() , subUin=" + str);
        }
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isSubAccountUin() listSubInfo is null.");
            }
            return false;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SubAccountInfo next = it.next();
                if (next != null && str.equals(next.subuin)) {
                    z16 = true;
                    break;
                }
            }
            return z16;
        } finally {
            this.lock.unlock();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        Integer valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) appRuntime);
            return;
        }
        EntityManager createEntityManager = appRuntime.getEntityManagerFactory().createEntityManager();
        this.f291085em = createEntityManager;
        List<? extends Entity> query = createEntityManager.query(SubAccountInfo.class);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("initSubAccountInfos() uin=");
            sb5.append(appRuntime.getCurrentAccountUin());
            sb5.append(" result=");
            if (query == null) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(query.size());
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (query != null && query.size() != 0) {
            this.listSubInfo.clear();
            this.listSubInfo.addAll(query);
            inflateMsgData();
            this.mNotifySwitch = SettingCloneUtil.readValue((Context) appRuntime.getApp(), appRuntime.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_SUBACCOUNT_NOTIFY, true);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "NotifySwitch ", Boolean.valueOf(this.mNotifySwitch));
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        this.lock.lock();
        try {
            this.listSubInfo.clear();
            this.mapSubMsg.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean readMsgSwitch(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Boolean) iPatchRedirector.redirect((short) 52, (Object) this, (Object) appInterface)).booleanValue();
        }
        return SettingCloneUtil.readValue((Context) appInterface.getApplication(), appInterface.getCurrentAccountUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void removeAllMessage(String str) {
        SubAccountInfo subAccountInfo;
        final ArrayList<SubAccountMessage> remove;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeAllMessage() subUin=" + str);
        }
        if (str == null) {
            return;
        }
        this.lock.lock();
        try {
            if (this.mapSubMsg.containsKey(str) && (remove = this.mapSubMsg.remove(str)) != null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.subaccount.api.impl.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        SubAccountServiceImpl.this.lambda$removeAllMessage$0(remove);
                    }
                }, 32, null, false);
            }
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    subAccountInfo = null;
                    break;
                }
                subAccountInfo = it.next();
                if (subAccountInfo != null && str.equals(subAccountInfo.subuin)) {
                    break;
                }
            }
            if (subAccountInfo != null) {
                subAccountInfo.unNotifySender = 0;
                subAccountInfo.unreadSenderNum = 0;
                subAccountInfo.unreadMsgNum = 0;
                subAccountInfo.unreadTroopMsgNum = 0;
                subAccountInfo.lastMsg = null;
                subAccountInfo.lastUin = null;
                subAccountInfo.lastUinNick = null;
                updateEntity(subAccountInfo);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "removeAllMessage() info.subuin=" + subAccountInfo.subuin + " unreadMsg=" + subAccountInfo.unreadMsgNum + " unNotify=" + subAccountInfo.unNotifySender + " unreadSender=" + subAccountInfo.unreadSenderNum);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void removeAllSubAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeAllSubAccount()");
        }
        this.lock.lock();
        try {
            this.listSubInfo.clear();
            this.lock.unlock();
            this.f291085em.drop(SubAccountInfo.class.getSimpleName());
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public int removeMessage(String str, String str2) {
        ArrayList<SubAccountMessage> arrayList;
        SubAccountInfo subAccountInfo;
        SubAccountMessage subAccountMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        int i3 = 0;
        if (str != null && str2 != null) {
            this.lock.lock();
            try {
                if (!this.mapSubMsg.containsKey(str) || (arrayList = this.mapSubMsg.get(str)) == null || arrayList.size() <= 0) {
                    return 0;
                }
                int size = arrayList.size() - 1;
                while (true) {
                    subAccountInfo = null;
                    if (size >= 0) {
                        subAccountMessage = arrayList.get(size);
                        if (str.equals(subAccountMessage.subUin) && str2.equals(subAccountMessage.senderuin)) {
                            arrayList.remove(size);
                            i3 = 0 - subAccountMessage.unreadNum;
                            break;
                        }
                        size--;
                    } else {
                        subAccountMessage = null;
                        break;
                    }
                }
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SubAccountInfo next = it.next();
                    if (next != null && str.equals(next.subuin)) {
                        subAccountInfo = next;
                        break;
                    }
                }
                countUnreadDatum(subAccountInfo, arrayList, 2);
                if (subAccountMessage != null) {
                    this.f291085em.remove(subAccountMessage);
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "removeMessage() subUin=" + str + " sendUin=" + str2 + " changedNum=" + i3);
                }
                return i3;
            } finally {
                this.lock.unlock();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeMessage() return, NULL, subUin=" + str + " sendUin=" + str2);
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        r3.listSubInfo.remove(r1);
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void removeSubAccountInfo(String str) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeSubAccountInfo() subUin=" + str);
        }
        if (str == null) {
            return;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo != null) {
                this.f291085em.remove(subAccountInfo);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void saveSubAccountInfo(SubAccountInfo subAccountInfo) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) subAccountInfo);
            return;
        }
        String str2 = "saveInfo is null.";
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("saveSubAccountInfo() ");
            if (subAccountInfo == null) {
                str = "saveInfo is null.";
            } else {
                str = "saveInfo.subuin=" + subAccountInfo.subuin;
            }
            sb5.append(str);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (subAccountInfo != null && subAccountInfo.subuin != null) {
            if (this.listSubInfo == null) {
                this.listSubInfo = new ArrayList<>();
            }
            this.lock.lock();
            try {
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                SubAccountInfo subAccountInfo2 = null;
                while (it.hasNext()) {
                    SubAccountInfo next = it.next();
                    if (subAccountInfo.subuin.equals(next.subuin)) {
                        next.cloneTo(subAccountInfo);
                        subAccountInfo2 = next;
                    }
                }
                if (subAccountInfo2 != null) {
                    updateEntity(subAccountInfo2);
                    return;
                }
                return;
            } finally {
                this.lock.unlock();
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("saveSubAccountInfo() ");
            if (subAccountInfo != null) {
                str2 = "saveInfo.subuin is null";
            }
            sb6.append(str2);
            QLog.d(TAG, 2, sb6.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009b, code lost:
    
        r1.lasttime = r7;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setActionTime(String str, long j3) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, this, str, Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setActionTime() subUin=" + str + " time=" + j3);
        }
        if (str == null) {
            return;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setActionTime() listSubInfo is null.");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setActionTime() subUin=" + str + " change lasttime=" + j3);
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo != null) {
                ThreadManager.getFileThreadHandler().post(new Runnable(subAccountInfo) { // from class: com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ SubAccountInfo f291087d;

                    {
                        this.f291087d = subAccountInfo;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountServiceImpl.this, (Object) subAccountInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SubAccountInfo subAccountInfo2 = this.f291087d;
                        if (subAccountInfo2 != null) {
                            SubAccountServiceImpl.this.updateEntity(subAccountInfo2);
                        }
                    }
                });
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void setAllMessageReaded(String str) {
        ArrayList<SubAccountMessage> arrayList;
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setAllSubMessageReaded() subUin=" + str);
        }
        if (str == null) {
            return;
        }
        this.lock.lock();
        try {
            if (this.mapSubMsg.containsKey(str) && (arrayList = this.mapSubMsg.get(str)) != null && arrayList.size() > 0) {
                for (SubAccountMessage subAccountMessage : arrayList) {
                    subAccountMessage.isread = true;
                    subAccountMessage.needNotify = false;
                    subAccountMessage.unreadNum = 0;
                }
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        subAccountInfo = it.next();
                        if (subAccountInfo != null && str.equals(subAccountInfo.subuin)) {
                            break;
                        }
                    } else {
                        subAccountInfo = null;
                        break;
                    }
                }
                if (subAccountInfo != null) {
                    subAccountInfo.unNotifySender = 0;
                    subAccountInfo.unreadSenderNum = 0;
                    subAccountInfo.unreadMsgNum = 0;
                    subAccountInfo.unreadTroopMsgNum = 0;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "setAllMessageReaded() info.subuin=" + subAccountInfo.subuin + " unreadMsg=" + subAccountInfo.unreadMsgNum + " unNotify=" + subAccountInfo.unNotifySender + " unreadSender=" + subAccountInfo.unreadSenderNum);
                    }
                }
                this.lock.unlock();
                String tableName = new SubAccountMessage().getTableName();
                ContentValues contentValues = new ContentValues();
                contentValues.put(AppConstants.Key.COLUMN_IS_READ, Boolean.TRUE);
                contentValues.put("unreadNum", (Integer) 0);
                boolean update = this.f291085em.update(tableName, contentValues, "subUin=?", new String[]{str});
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "setAllSubMessageReaded() set isRead and unreadNum, result" + update);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void setNotifySwitch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
            return;
        }
        this.mNotifySwitch = z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SettingCloneUtil.writeValue(peekAppRuntime.getApp(), peekAppRuntime.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_SUBACCOUNT_NOTIFY, this.mNotifySwitch);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
    
        r1.isTop = r8;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setRecentListTop(String str, boolean z16) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, this, str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setRecentListTop() subUin=" + str + " isTop=" + z16);
        }
        if (str != null && str.length() >= 5) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setRecentListTop() subUin=" + str + " isTop=" + z16);
            }
            this.lock.lock();
            try {
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (true) {
                    if (it.hasNext()) {
                        subAccountInfo = it.next();
                        if (str.equals(subAccountInfo.subuin)) {
                            break;
                        }
                    } else {
                        subAccountInfo = null;
                        break;
                    }
                }
                if (subAccountInfo != null) {
                    updateEntity(subAccountInfo);
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public boolean setStatus(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setStatus() subUin=" + str + " status=" + i3);
        }
        boolean z16 = false;
        if (str == null) {
            return false;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            SubAccountInfo subAccountInfo = null;
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    subAccountInfo = next;
                }
            }
            if (subAccountInfo != null) {
                if (subAccountInfo.status != i3) {
                    if (i3 == 2 || i3 == 3) {
                        z16 = true;
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "setStatus() need2setMsgNum_1=true");
                        }
                    }
                    subAccountInfo.status = i3;
                    updateEntity(subAccountInfo);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "setStatus() findInfo is null. return default 0");
            }
            return z16;
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x011a  */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateA2(String str, String str2, boolean z16) {
        SubAccountInfo subAccountInfo;
        boolean z17;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateA2() subUin=");
            sb5.append(str);
            sb5.append(" A2=");
            if (str2 == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(str2.length());
            }
            sb5.append(valueOf);
            sb5.append(" change=");
            sb5.append(z16);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateA2() subUin is null.");
                return;
            }
            return;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateA2() listSubInfo is null.");
                return;
            }
            return;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                subAccountInfo = null;
                if (!it.hasNext()) {
                    break;
                }
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    if ((str2 == null && next.A2 != null) || (str2 != null && !str2.equals(next.A2))) {
                        if (z16) {
                            next.lasttime = e.K0();
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "updateA2() change lasttime=" + next.lasttime);
                            }
                        }
                        next.A2 = str2;
                        if (str2 == null) {
                            next.hintIsNew = false;
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "updateA2() set hintIsNew=false");
                            }
                        }
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (str2 == null) {
                        next.cookie = null;
                        if (next.status == 0) {
                            next.status = 3;
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "updateA2() change status=" + next.status);
                            }
                            if (z18) {
                                subAccountInfo = next;
                            }
                        }
                    } else {
                        next.serverErrorMsg = null;
                        next.serverErrorType = 0;
                    }
                    z18 = z17;
                    if (z18) {
                    }
                }
            }
            if (subAccountInfo != null) {
                ThreadManager.getFileThreadHandler().post(new Runnable(subAccountInfo) { // from class: com.tencent.mobileqq.subaccount.api.impl.SubAccountServiceImpl.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ SubAccountInfo f291086d;

                    {
                        this.f291086d = subAccountInfo;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountServiceImpl.this, (Object) subAccountInfo);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        SubAccountInfo subAccountInfo2 = this.f291086d;
                        if (subAccountInfo2 != null) {
                            SubAccountServiceImpl.this.updateEntity(subAccountInfo2);
                        }
                    }
                });
            }
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0082, code lost:
    
        r1.cookie = r6;
     */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateCookie(String str, byte[] bArr) {
        SubAccountInfo subAccountInfo;
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateCookie() subUin=");
            sb5.append(str);
            sb5.append(" cookie=");
            if (bArr == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(bArr.length);
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateCookie() subUin is null.");
                return;
            }
            return;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateCookie() listSubInfo is null.");
                return;
            }
            return;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo != null) {
                updateEntity(subAccountInfo);
            }
        } finally {
            this.lock.unlock();
        }
    }

    boolean updateEntity(Entity entity) {
        if (this.f291085em.isOpen()) {
            if (entity.getStatus() == 1000) {
                this.f291085em.persistOrReplace(entity);
                if (entity.getStatus() != 1001) {
                    return false;
                }
                return true;
            }
            if (entity.getStatus() == 1001 || entity.getStatus() == 1002) {
                return this.f291085em.update(entity);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void updateMsgData2SupportSubUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateMsgData2SupportSubUin() subuin==null");
                return;
            }
            return;
        }
        String tableName = new SubAccountMessage().getTableName();
        ContentValues contentValues = new ContentValues();
        contentValues.put("subUin", str);
        boolean update = this.f291085em.update(tableName, contentValues, null, null);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateMsgData2SupportSubUin() set subUin=" + str + " result" + update);
        }
        if (update) {
            inflateMsgData();
        } else {
            removeAllMessage();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void updateMsgTimeStr(String str) {
        String str2;
        String str3;
        HashMap<String, ArrayList<SubAccountMessage>> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateSubAccountMsgTimeStr() dateFormate=" + str);
        }
        if (str == null) {
            return;
        }
        ArrayList<SubAccountInfo> arrayList = this.listSubInfo;
        if (arrayList != null && arrayList.size() != 0 && (hashMap = this.mapSubMsg) != null && hashMap.size() != 0) {
            this.lock.lock();
            try {
                Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
                while (it.hasNext()) {
                    SubAccountInfo next = it.next();
                    if (next != null) {
                        ArrayList<SubAccountMessage> arrayList2 = this.mapSubMsg.get(next.subuin);
                        if (arrayList2 != null && arrayList2.size() != 0) {
                            Iterator<SubAccountMessage> it5 = arrayList2.iterator();
                            boolean z16 = true;
                            while (it5.hasNext()) {
                                SubAccountMessage next2 = it5.next();
                                if (next2 != null) {
                                    next2.mTimeString = en.p(next2.time * 1000, true, str);
                                    if (z16) {
                                        z16 = false;
                                    }
                                }
                            }
                        }
                    }
                }
                return;
            } finally {
                this.lock.unlock();
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateSubAccountMsgTimeStr() ");
            if (this.listSubInfo == null) {
                str2 = "listSubInfo == null";
            } else {
                str2 = "listSubInfo.size() == 0";
            }
            sb5.append(str2);
            QLog.d(TAG, 2, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("updateSubAccountMsgTimeStr() ");
            if (this.mapSubMsg == null) {
                str3 = "mapSubMsg == null";
            } else {
                str3 = "mapSubMsg.size() == 0";
            }
            sb6.append(str3);
            QLog.d(TAG, 2, sb6.toString());
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void updateNotifySwitch(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) appInterface);
            return;
        }
        this.mNotifySwitch = SettingCloneUtil.readValue((Context) appInterface.getApp(), appInterface.getCurrentAccountUin(), (String) null, AppConstants.QQSETTING_SUBACCOUNT_NOTIFY, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateNotifySwitch ", Boolean.valueOf(this.mNotifySwitch));
        }
        sendBindUinMsgSwitchToServer(appInterface, this.mNotifySwitch);
        updateRecentContact();
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void updateServerError(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateServerError() subUin=" + str + " error type=" + i3 + " msg=" + str2);
        }
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateServerError() subUin is null.");
                return;
            }
            return;
        }
        if (this.listSubInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateServerError() listSubInfo is null.");
                return;
            }
            return;
        }
        this.lock.lock();
        try {
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            SubAccountInfo subAccountInfo = null;
            while (it.hasNext()) {
                SubAccountInfo next = it.next();
                if (str.equals(next.subuin)) {
                    next.serverErrorType = i3;
                    next.serverErrorMsg = str2;
                    subAccountInfo = next;
                }
            }
            if (subAccountInfo != null) {
                updateEntity(subAccountInfo);
            }
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void updateSubAccountInfo(com.tencent.mobileqq.subaccount.logic.a aVar) {
        SubAccountInfo subAccountInfo;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) aVar);
            return;
        }
        String str2 = "data == null";
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addAllSubAccountInfo() ");
            if (aVar == null) {
                str = "data == null";
            } else {
                str = "data.mMainAccount=" + aVar.f291123c + " data.mSubUin=" + aVar.f291124d;
            }
            sb5.append(str);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (aVar != null && aVar.f291123c != null && aVar.i()) {
            ArrayList<String> d16 = aVar.d();
            ArrayList<String> f16 = aVar.f();
            ArrayList<String> e16 = aVar.e();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addAllSubAccountInfo() allSubUin:" + f16.toString());
                QLog.d(TAG, 2, "removeOverdueSubAccountInfo() overdueUin:" + e16.toString());
            }
            ArrayList arrayList = new ArrayList();
            this.lock.lock();
            try {
                Iterator<String> it = f16.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    Iterator<SubAccountInfo> it5 = this.listSubInfo.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            subAccountInfo = it5.next();
                            if (aVar.f291123c.equals(subAccountInfo.trunkuin) && next.equals(subAccountInfo.subuin)) {
                                break;
                            }
                        } else {
                            subAccountInfo = null;
                            break;
                        }
                    }
                    if (subAccountInfo == null) {
                        subAccountInfo = new SubAccountInfo();
                        this.listSubInfo.add(subAccountInfo);
                    }
                    subAccountInfo.subuin = next;
                    subAccountInfo.trunkuin = aVar.f291123c;
                    subAccountInfo.serverErrorType = aVar.f291129i;
                    subAccountInfo.serverErrorMsg = aVar.f291122b;
                    if (d16 != null && d16.contains(next)) {
                        subAccountInfo.hintIsNew = true;
                        subAccountInfo.lasttime = e.K0();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "addSubAccountInfo() change subUin=" + subAccountInfo.subuin + " hintIsNew=" + subAccountInfo.hintIsNew + " lasttime=" + subAccountInfo.lasttime);
                        }
                    }
                    arrayList.add(subAccountInfo);
                }
                if (e16 != null && e16.size() > 0) {
                    Iterator<String> it6 = e16.iterator();
                    while (it6.hasNext()) {
                        removeSubAccountInfo(it6.next());
                    }
                }
                this.lock.unlock();
                if (arrayList.size() > 0) {
                    Iterator it7 = arrayList.iterator();
                    while (it7.hasNext()) {
                        updateEntity((SubAccountInfo) it7.next());
                    }
                    return;
                }
                return;
            } catch (Throwable th5) {
                this.lock.unlock();
                throw th5;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("addAllSubAccountInfo() return,");
            if (aVar != null) {
                str2 = "data.mMainAccount=" + aVar.f291123c + " data.mSubUin=" + aVar.f291124d;
            }
            sb6.append(str2);
            QLog.d(TAG, 2, sb6.toString());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x011c A[Catch: all -> 0x0137, TRY_LEAVE, TryCatch #0 {all -> 0x0137, blocks: (B:28:0x0081, B:30:0x008b, B:32:0x0098, B:35:0x009f, B:36:0x00a3, B:38:0x00a9, B:41:0x00b9, B:44:0x00c3, B:46:0x00c9, B:47:0x00e0, B:49:0x00ea, B:53:0x0116, B:55:0x011c, B:59:0x00f3, B:62:0x00fb, B:65:0x00ff, B:76:0x0108, B:78:0x010e), top: B:27:0x0081 }] */
    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updateTroopMsgRedDot(SubAccountMessage subAccountMessage) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) subAccountMessage);
            return;
        }
        if (QLog.isColorLevel()) {
            if (subAccountMessage == null) {
                str = "null";
            } else {
                str = "subUin=" + subAccountMessage.subUin + " senderUin=" + subAccountMessage.senderuin + " msg.time=" + subAccountMessage.time;
            }
            QLog.d(TAG, 2, "updateTroopMsgRedDot() " + str);
        }
        if (!this.mNotifySwitch) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateTroopMsgRedDot notify off");
                return;
            }
            return;
        }
        if (subAccountMessage != null && subAccountMessage.subUin != null && subAccountMessage.senderuin != null) {
            this.lock.lock();
            try {
                if (this.mapSubMsg.containsKey(subAccountMessage.subUin)) {
                    ArrayList<SubAccountMessage> arrayList = this.mapSubMsg.get(subAccountMessage.subUin);
                    z16 = true;
                    if (arrayList != null && arrayList.size() != 0) {
                        Iterator<SubAccountMessage> it = arrayList.iterator();
                        while (it.hasNext()) {
                            SubAccountMessage next = it.next();
                            if (subAccountMessage.subUin.equals(next.subUin) && subAccountMessage.senderuin.equals(next.senderuin)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "updateTroopMsgRedDot() tMsg.time=" + next.time);
                                }
                                String str2 = AppConstants.SUBACCOUNT_TROOP_UIN;
                                if (str2.equals(subAccountMessage.senderuin)) {
                                    if (subAccountMessage.time > next.time) {
                                        break;
                                    }
                                }
                                if (str2.equals(subAccountMessage.senderuin) && subAccountMessage.unreadNum == 0 && subAccountMessage.time == 0) {
                                    break;
                                }
                            }
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "updateTroopMsgRedDot() list is empty");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "updateTroopMsgRedDot() needUpdate=" + z16);
                    }
                }
                z16 = false;
                if (QLog.isColorLevel()) {
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void updateUnreadNum(AppInterface appInterface, String str, String str2, int i3) {
        SubAccountInfo subAccountInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, appInterface, str, str2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "updateUnreadNum");
        }
        SubAccountMessage findSubAccountMessage = findSubAccountMessage(str, str2);
        if (findSubAccountMessage == null) {
            return;
        }
        this.lock.lock();
        try {
            int i16 = findSubAccountMessage.unreadNum - i3;
            if (i16 == 0) {
                return;
            }
            findSubAccountMessage.unreadNum = i3;
            Iterator<SubAccountInfo> it = this.listSubInfo.iterator();
            while (true) {
                if (it.hasNext()) {
                    subAccountInfo = it.next();
                    if (subAccountInfo != null && str.equals(subAccountInfo.subuin)) {
                        break;
                    }
                } else {
                    subAccountInfo = null;
                    break;
                }
            }
            if (subAccountInfo == null) {
                return;
            }
            if (findSubAccountMessage.istroop == 1) {
                int i17 = subAccountInfo.unreadTroopMsgNum - i16;
                subAccountInfo.unreadTroopMsgNum = i17;
                subAccountInfo.unreadTroopMsgNum = Math.max(0, i17);
            } else {
                subAccountInfo.unreadMsgNum -= i16;
            }
            this.lock.unlock();
            updateEntity(findSubAccountMessage);
            h.b(appInterface, str, 6);
            ((IConversationFacade) appInterface.getRuntimeService(IConversationFacade.class, "")).increaseUnread(str, 7000, -i16);
            ((IMessageFacade) appInterface.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(new String[]{AppConstants.SUBACCOUNT_ASSISTANT_UIN, str});
            ((IAppBadgeService) appInterface.getRuntimeService(IAppBadgeService.class, "")).refreshAppBadge();
            com.tencent.mobileqq.subaccount.logic.a aVar = new com.tencent.mobileqq.subaccount.logic.a();
            aVar.f291124d = str;
            aVar.f291132l = true;
            aVar.f291133m = true;
            aVar.f291121a = 0;
            ((ISubAccountApi) QRoute.api(ISubAccountApi.class)).notifyBusinessMessage(8003, true, aVar);
        } finally {
            this.lock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.subaccount.api.ISubAccountService
    public void removeAllMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "removeAllMessage()");
        }
        this.lock.lock();
        try {
            this.mapSubMsg.clear();
            ArrayList<SubAccountInfo> arrayList = this.listSubInfo;
            if (arrayList != null) {
                Iterator<SubAccountInfo> it = arrayList.iterator();
                while (it.hasNext()) {
                    SubAccountInfo next = it.next();
                    next.unNotifySender = 0;
                    next.unreadSenderNum = 0;
                    next.unreadMsgNum = 0;
                    next.unreadTroopMsgNum = 0;
                    next.lastMsg = null;
                    next.lastUin = null;
                    next.lastUinNick = null;
                    updateEntity(next);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "removeAllMessage() info.subuin=" + next.subuin + " unreadMsg=" + next.unreadMsgNum + " unNotify=" + next.unNotifySender + " unreadSender=" + next.unreadSenderNum);
                    }
                }
            }
            this.lock.unlock();
            this.f291085em.drop(SubAccountMessage.class.getSimpleName());
        } catch (Throwable th5) {
            this.lock.unlock();
            throw th5;
        }
    }
}
