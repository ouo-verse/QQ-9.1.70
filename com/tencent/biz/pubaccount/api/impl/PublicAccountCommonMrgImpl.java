package com.tencent.biz.pubaccount.api.impl;

import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.recentcontact.DefaultPAUnsubscribeMenuUseCase;
import com.tencent.biz.pubaccount.util.MsgListPluginDataManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J*\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001a\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0017H\u0016J\b\u0010%\u001a\u00020\nH\u0016\u00a8\u0006*"}, d2 = {"Lcom/tencent/biz/pubaccount/api/impl/PublicAccountCommonMrgImpl;", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg;", "Lcom/tencent/qqnt/kernel/api/aa;", "getRecentContactService", "Lcom/tencent/qqnt/kernel/api/w;", "getMsgService", "", "peerUid", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "callback", "", "asyncGetUnReadCnt4PA", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "cb", "deleteRecentContact4PA", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "recentContactInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IClearMsgRecordsCallback;", "clearMsgRecords4PA", "markRead4PA", "isShowSmallRedPoint", "", "peerUin", "", "isTop", "result", "setTop", "getTopState", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "getDefaultPAUnsubscribeMenuUseCase", "info", "Lcom/tencent/qqnt/kernel/nativeinterface/IMsgOperateCallback;", "asyncGetLastMsgRecord", "showRedDot", "initSubscribeFolderRedDotStyle", "doInit", "<init>", "()V", "Companion", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PublicAccountCommonMrgImpl implements IPublicAccountCommonMrg {
    public static final String TAG = "PublicAccountCommonMrgImpl";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncGetUnReadCnt4PA$lambda$0(IPublicAccountCommonMrg.a callback, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!(arrayList == null || arrayList.isEmpty())) {
            callback.c(0, ((RecentContactInfo) arrayList.get(0)).unreadCnt);
        } else {
            QLog.i(TAG, 1, "asyncGetUnReadCnt4PA foundContacts == null or size == 0");
            callback.c(-1, 0L);
        }
    }

    private final w getMsgService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.i(TAG, 1, "getService == null");
        }
        return msgService;
    }

    private final aa getRecentContactService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.i(TAG, 1, "getService == null");
        }
        return recentContactService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getTopState$lambda$4(IPublicAccountCommonMrg.a callback, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!(arrayList == null || arrayList.isEmpty())) {
            callback.b(0, ((RecentContactInfo) arrayList.get(0)).topFlag == 1);
        } else {
            QLog.i(TAG, 1, "getTopState foundContacts == null or size == 0");
            callback.b(-1, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isShowSmallRedPoint$lambda$2(IPublicAccountCommonMrg.a callback, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (!(arrayList == null || arrayList.isEmpty())) {
            callback.a(0, ((int) ((RecentContactInfo) arrayList.get(0)).unreadFlag) == 1);
        } else {
            QLog.i(TAG, 1, "isShowSmallRedPoint foundContacts == null or size == 0");
            callback.a(-1, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTop$lambda$3(IOperateCallback iOperateCallback, int i3, String str) {
        QLog.d(TAG, 1, "setContactListTop code:" + i3 + " msg:" + str);
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void asyncGetLastMsgRecord(RecentContactInfo info, final IMsgOperateCallback result) {
        Intrinsics.checkNotNullParameter(info, "info");
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(new Contact(info.chatType, info.peerUid, ""));
        w msgService = getMsgService();
        if (msgService != null) {
            msgService.getLastMessageList(arrayList, new IMsgOperateCallback() { // from class: com.tencent.biz.pubaccount.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList2) {
                    PublicAccountCommonMrgImpl.asyncGetLastMsgRecord$lambda$6(IMsgOperateCallback.this, i3, str, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void asyncGetUnReadCnt4PA(String peerUid, final IPublicAccountCommonMrg.a callback) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        aa recentContactService = getRecentContactService();
        if (recentContactService == null) {
            callback.c(-1, 0L);
        } else {
            recentContactService.F0(new Contact(103, peerUid, ""), new IGetContactsCallback() { // from class: com.tencent.biz.pubaccount.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    PublicAccountCommonMrgImpl.asyncGetUnReadCnt4PA$lambda$0(IPublicAccountCommonMrg.a.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void clearMsgRecords4PA(String peerUid, final IClearMsgRecordsCallback cb5) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        w msgService = getMsgService();
        if (msgService != null) {
            msgService.clearMsgRecords(new Contact(103, peerUid, ""), new IClearMsgRecordsCallback() { // from class: com.tencent.biz.pubaccount.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IClearMsgRecordsCallback
                public final void onResult(int i3, String str, long j3) {
                    PublicAccountCommonMrgImpl.clearMsgRecords4PA$lambda$1(IClearMsgRecordsCallback.this, i3, str, j3);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void deleteRecentContact4PA(String peerUid, IOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (peerUid.length() == 0) {
            QLog.d(TAG, 1, "deleteRecentContact4PA peerUin invalid");
            return;
        }
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(new Contact(103, peerUid, ""));
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            recentContactService.a0(arrayList, cb5);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void doInit() {
        com.tencent.biz.pubaccount.util.j.INSTANCE.i();
        MsgListPluginDataManager msgListPluginDataManager = MsgListPluginDataManager.f80156a;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a getDefaultPAUnsubscribeMenuUseCase(IRecentContactRepo recentContactRepo) {
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        return new DefaultPAUnsubscribeMenuUseCase(recentContactRepo);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void getTopState(String peerUid, final IPublicAccountCommonMrg.a callback) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        aa recentContactService = getRecentContactService();
        if (recentContactService == null) {
            callback.b(-1, false);
        } else {
            recentContactService.F0(new Contact(103, peerUid, ""), new IGetContactsCallback() { // from class: com.tencent.biz.pubaccount.api.impl.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    PublicAccountCommonMrgImpl.getTopState$lambda$4(IPublicAccountCommonMrg.a.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void initSubscribeFolderRedDotStyle(boolean showRedDot) {
        w msgService = getMsgService();
        if (msgService != null) {
            msgService.setSubscribeFolderUsingSmallRedPoint(showRedDot);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void isShowSmallRedPoint(String peerUid, final IPublicAccountCommonMrg.a callback) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        aa recentContactService = getRecentContactService();
        if (recentContactService == null) {
            callback.a(-1, false);
        } else {
            recentContactService.F0(new Contact(103, peerUid, ""), new IGetContactsCallback() { // from class: com.tencent.biz.pubaccount.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
                public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                    PublicAccountCommonMrgImpl.isShowSmallRedPoint$lambda$2(IPublicAccountCommonMrg.a.this, i3, str, arrayList, arrayList2);
                }
            });
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void markRead4PA(String peerUid, IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        w msgService = getMsgService();
        if (msgService != null) {
            msgService.setMsgRead(new Contact(103, peerUid, ""), callback);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void setTop(long peerUin, String peerUid, boolean isTop, final IOperateCallback result) {
        ArrayList<ContactTopData> arrayListOf;
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        if (peerUin == 0) {
            QLog.d(TAG, 1, "setTop peerUin invalid");
            return;
        }
        ContactTopData contactTopData = new ContactTopData();
        contactTopData.uid = peerUid;
        contactTopData.uin = peerUin;
        contactTopData.chatType = 103;
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contactTopData);
            recentContactService.setContactListTop(isTop, arrayListOf, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.api.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    PublicAccountCommonMrgImpl.setTop$lambda$3(IOperateCallback.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void asyncGetLastMsgRecord$lambda$6(IMsgOperateCallback iMsgOperateCallback, int i3, String str, ArrayList arrayList) {
        if (iMsgOperateCallback != null) {
            iMsgOperateCallback.onResult(i3, str, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearMsgRecords4PA$lambda$1(IClearMsgRecordsCallback iClearMsgRecordsCallback, int i3, String str, long j3) {
        if (iClearMsgRecordsCallback != null) {
            iClearMsgRecordsCallback.onResult(i3, str, j3);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg
    public void deleteRecentContact4PA(RecentContactInfo recentContactInfo, IOperateCallback cb5) {
        Intrinsics.checkNotNullParameter(recentContactInfo, "recentContactInfo");
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(new Contact(recentContactInfo.chatType, recentContactInfo.peerUid, ""));
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            recentContactService.a0(arrayList, cb5);
        }
    }
}
