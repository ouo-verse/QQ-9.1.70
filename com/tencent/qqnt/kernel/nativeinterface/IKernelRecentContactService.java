package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelRecentContactService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelRecentContactService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native long native_addKernelRecentContactListener(long j3, IKernelRecentContactListener iKernelRecentContactListener);

        private native void native_addRecentContact(long j3, Contact contact, IOperateCallback iOperateCallback);

        private native void native_cleanAllModule(long j3);

        private native void native_clearMsgUnreadCount(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_clearRecentContacts(long j3, IOperateCallback iOperateCallback);

        private native void native_clearRecentContactsByChatType(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_deleteRecentContacts(long j3, ArrayList<RecentContactInfo> arrayList, IOperateCallback iOperateCallback);

        private native void native_deleteRecentContactsVer2(long j3, ArrayList<Contact> arrayList, IOperateCallback iOperateCallback);

        private native void native_enterOrExitMsgList(long j3, EnterOrExitMsgListInfo enterOrExitMsgListInfo, IOperateCallback iOperateCallback);

        private native void native_fetchAndSubscribeABatchOfRecentContact(long j3, RecentContactFetchParam recentContactFetchParam, IOperateCallback iOperateCallback);

        private native void native_getContacts(long j3, ArrayList<Contact> arrayList, IGetContactsCallback iGetContactsCallback);

        private native HashMap<String, Integer> native_getMsgUnreadCount(long j3);

        private native void native_getRecentContactInfos(long j3, IKernelRecentGetContactCallback iKernelRecentGetContactCallback);

        private native void native_getRecentContactList(long j3, IOperateCallback iOperateCallback);

        private native void native_getRecentContactListSnapShot(long j3, int i3, IKernelRecentSnapShotCallback iKernelRecentSnapShotCallback);

        private native CompleteRecentContactInfo native_getRecentContactListSync(long j3);

        private native CompleteRecentContactInfo native_getRecentContactListSyncLimit(long j3, int i3);

        private native void native_getServiceAssistantRecentContactInfos(long j3, IKernelRecentGetContactCallback iKernelRecentGetContactCallback);

        private native void native_getUnreadDetailsInfos(long j3, IKernelRecentGetContactUnreadDetailsCallback iKernelRecentGetContactUnreadDetailsCallback);

        private native void native_jumpToSpecifyRecentContact(long j3, RecentContactJumpInfo recentContactJumpInfo, IKernelRecentJumpCallback iKernelRecentJumpCallback);

        private native void native_jumpToSpecifyRecentContactVer2(long j3, RecentContactJumpInfoVer2 recentContactJumpInfoVer2, IKernelRecentJumpCallback iKernelRecentJumpCallback);

        private native void native_removeKernelRecentContactListener(long j3, long j16);

        private native void native_setAllGameMsgRead(long j3, IOperateCallback iOperateCallback);

        private native void native_setContactListTop(long j3, boolean z16, ArrayList<ContactTopData> arrayList, IOperateCallback iOperateCallback);

        private native void native_setThirdPartyBusinessInfos(long j3, ArrayList<ContactThirdPartyBusinessInfos> arrayList, IOperateCallback iOperateCallback);

        private native void native_upInsertModule(long j3, ArrayList<RecentContactModuleShieldInfo> arrayList);

        private native void native_updateGameMsgConfigs(long j3, ArrayList<GameMsgBoxConfig> arrayList, IOperateCallback iOperateCallback);

        private native void native_updateRecentContactExtBufForUI(long j3, Contact contact, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_upsertRecentContactManually(long j3, RecentContactData recentContactData, IOperateCallback iOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public long addKernelRecentContactListener(IKernelRecentContactListener iKernelRecentContactListener) {
            return native_addKernelRecentContactListener(this.nativeRef, iKernelRecentContactListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void addRecentContact(Contact contact, IOperateCallback iOperateCallback) {
            native_addRecentContact(this.nativeRef, contact, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void cleanAllModule() {
            native_cleanAllModule(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void clearMsgUnreadCount(String str, IOperateCallback iOperateCallback) {
            native_clearMsgUnreadCount(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void clearRecentContacts(IOperateCallback iOperateCallback) {
            native_clearRecentContacts(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void clearRecentContactsByChatType(int i3, IOperateCallback iOperateCallback) {
            native_clearRecentContactsByChatType(this.nativeRef, i3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void deleteRecentContacts(ArrayList<RecentContactInfo> arrayList, IOperateCallback iOperateCallback) {
            native_deleteRecentContacts(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void deleteRecentContactsVer2(ArrayList<Contact> arrayList, IOperateCallback iOperateCallback) {
            native_deleteRecentContactsVer2(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void enterOrExitMsgList(EnterOrExitMsgListInfo enterOrExitMsgListInfo, IOperateCallback iOperateCallback) {
            native_enterOrExitMsgList(this.nativeRef, enterOrExitMsgListInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void fetchAndSubscribeABatchOfRecentContact(RecentContactFetchParam recentContactFetchParam, IOperateCallback iOperateCallback) {
            native_fetchAndSubscribeABatchOfRecentContact(this.nativeRef, recentContactFetchParam, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void getContacts(ArrayList<Contact> arrayList, IGetContactsCallback iGetContactsCallback) {
            native_getContacts(this.nativeRef, arrayList, iGetContactsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public HashMap<String, Integer> getMsgUnreadCount() {
            return native_getMsgUnreadCount(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void getRecentContactInfos(IKernelRecentGetContactCallback iKernelRecentGetContactCallback) {
            native_getRecentContactInfos(this.nativeRef, iKernelRecentGetContactCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void getRecentContactList(IOperateCallback iOperateCallback) {
            native_getRecentContactList(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void getRecentContactListSnapShot(int i3, IKernelRecentSnapShotCallback iKernelRecentSnapShotCallback) {
            native_getRecentContactListSnapShot(this.nativeRef, i3, iKernelRecentSnapShotCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public CompleteRecentContactInfo getRecentContactListSync() {
            return native_getRecentContactListSync(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public CompleteRecentContactInfo getRecentContactListSyncLimit(int i3) {
            return native_getRecentContactListSyncLimit(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void getServiceAssistantRecentContactInfos(IKernelRecentGetContactCallback iKernelRecentGetContactCallback) {
            native_getServiceAssistantRecentContactInfos(this.nativeRef, iKernelRecentGetContactCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void getUnreadDetailsInfos(IKernelRecentGetContactUnreadDetailsCallback iKernelRecentGetContactUnreadDetailsCallback) {
            native_getUnreadDetailsInfos(this.nativeRef, iKernelRecentGetContactUnreadDetailsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void jumpToSpecifyRecentContact(RecentContactJumpInfo recentContactJumpInfo, IKernelRecentJumpCallback iKernelRecentJumpCallback) {
            native_jumpToSpecifyRecentContact(this.nativeRef, recentContactJumpInfo, iKernelRecentJumpCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void jumpToSpecifyRecentContactVer2(RecentContactJumpInfoVer2 recentContactJumpInfoVer2, IKernelRecentJumpCallback iKernelRecentJumpCallback) {
            native_jumpToSpecifyRecentContactVer2(this.nativeRef, recentContactJumpInfoVer2, iKernelRecentJumpCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void removeKernelRecentContactListener(long j3) {
            native_removeKernelRecentContactListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void setAllGameMsgRead(IOperateCallback iOperateCallback) {
            native_setAllGameMsgRead(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void setContactListTop(boolean z16, ArrayList<ContactTopData> arrayList, IOperateCallback iOperateCallback) {
            native_setContactListTop(this.nativeRef, z16, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void setThirdPartyBusinessInfos(ArrayList<ContactThirdPartyBusinessInfos> arrayList, IOperateCallback iOperateCallback) {
            native_setThirdPartyBusinessInfos(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void upInsertModule(ArrayList<RecentContactModuleShieldInfo> arrayList) {
            native_upInsertModule(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void updateGameMsgConfigs(ArrayList<GameMsgBoxConfig> arrayList, IOperateCallback iOperateCallback) {
            native_updateGameMsgConfigs(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void updateRecentContactExtBufForUI(Contact contact, byte[] bArr, IOperateCallback iOperateCallback) {
            native_updateRecentContactExtBufForUI(this.nativeRef, contact, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService
        public void upsertRecentContactManually(RecentContactData recentContactData, IOperateCallback iOperateCallback) {
            native_upsertRecentContactManually(this.nativeRef, recentContactData, iOperateCallback);
        }
    }

    long addKernelRecentContactListener(IKernelRecentContactListener iKernelRecentContactListener);

    void addRecentContact(Contact contact, IOperateCallback iOperateCallback);

    void cleanAllModule();

    void clearMsgUnreadCount(String str, IOperateCallback iOperateCallback);

    void clearRecentContacts(IOperateCallback iOperateCallback);

    void clearRecentContactsByChatType(int i3, IOperateCallback iOperateCallback);

    void deleteRecentContacts(ArrayList<RecentContactInfo> arrayList, IOperateCallback iOperateCallback);

    void deleteRecentContactsVer2(ArrayList<Contact> arrayList, IOperateCallback iOperateCallback);

    void enterOrExitMsgList(EnterOrExitMsgListInfo enterOrExitMsgListInfo, IOperateCallback iOperateCallback);

    void fetchAndSubscribeABatchOfRecentContact(RecentContactFetchParam recentContactFetchParam, IOperateCallback iOperateCallback);

    void getContacts(ArrayList<Contact> arrayList, IGetContactsCallback iGetContactsCallback);

    HashMap<String, Integer> getMsgUnreadCount();

    void getRecentContactInfos(IKernelRecentGetContactCallback iKernelRecentGetContactCallback);

    void getRecentContactList(IOperateCallback iOperateCallback);

    void getRecentContactListSnapShot(int i3, IKernelRecentSnapShotCallback iKernelRecentSnapShotCallback);

    CompleteRecentContactInfo getRecentContactListSync();

    CompleteRecentContactInfo getRecentContactListSyncLimit(int i3);

    void getServiceAssistantRecentContactInfos(IKernelRecentGetContactCallback iKernelRecentGetContactCallback);

    void getUnreadDetailsInfos(IKernelRecentGetContactUnreadDetailsCallback iKernelRecentGetContactUnreadDetailsCallback);

    void jumpToSpecifyRecentContact(RecentContactJumpInfo recentContactJumpInfo, IKernelRecentJumpCallback iKernelRecentJumpCallback);

    void jumpToSpecifyRecentContactVer2(RecentContactJumpInfoVer2 recentContactJumpInfoVer2, IKernelRecentJumpCallback iKernelRecentJumpCallback);

    void removeKernelRecentContactListener(long j3);

    void setAllGameMsgRead(IOperateCallback iOperateCallback);

    void setContactListTop(boolean z16, ArrayList<ContactTopData> arrayList, IOperateCallback iOperateCallback);

    void setThirdPartyBusinessInfos(ArrayList<ContactThirdPartyBusinessInfos> arrayList, IOperateCallback iOperateCallback);

    void upInsertModule(ArrayList<RecentContactModuleShieldInfo> arrayList);

    void updateGameMsgConfigs(ArrayList<GameMsgBoxConfig> arrayList, IOperateCallback iOperateCallback);

    void updateRecentContactExtBufForUI(Contact contact, byte[] bArr, IOperateCallback iOperateCallback);

    void upsertRecentContactManually(RecentContactData recentContactData, IOperateCallback iOperateCallback);
}
