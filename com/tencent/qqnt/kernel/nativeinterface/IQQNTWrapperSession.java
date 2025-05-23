package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IQQNTWrapperSession {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IQQNTWrapperSession {
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

        public static native IQQNTWrapperSession getNTWrapperSession(String str);

        private native void nativeDestroy(long j3);

        private native void native_close(long j3, String str);

        private native void native_disableIpDirect(long j3, boolean z16);

        private native IKernelAVSDKService native_getAVSDKService(long j3);

        private native String native_getAccountPath(long j3, PathType pathType);

        private native IKernelAddBuddyService native_getAddBuddyService(long j3);

        private native IKernelAlbumService native_getAlbumService(long j3);

        private native IKernelAvatarService native_getAvatarService(long j3);

        private native IKernelBaseEmojiService native_getBaseEmojiService(long j3);

        private native IKernelBatchUploadService native_getBatchUploadService(long j3);

        private native IKernelBdhUploadService native_getBdhUploadService(long j3);

        private native IKernelBuddyService native_getBuddyService(long j3);

        private native ArrayList<String> native_getCacheErrLog(long j3);

        private native IKernelConfigMgrService native_getConfigMgrService(long j3);

        private native IKernelDataReportService native_getDataReportService(long j3);

        private native IKernelEmojiService native_getEmojiService(long j3);

        private native IKernelFileBridgeClientService native_getFileBridgeClientService(long j3);

        private native IKernelFlashTransferService native_getFlashTransferService(long j3);

        private native IKernelGroupSchoolService native_getGroupSchoolService(long j3);

        private native IKernelGroupService native_getGroupService(long j3);

        private native IKernelGroupTabService native_getGroupTabService(long j3);

        private native IKernelGuildMsgService native_getGuildMsgService(long j3);

        private native IKernelLiteBusinessService native_getLiteBusinessService(long j3);

        private native IKernelMsgService native_getMsgService(long j3);

        private native IKernelNearbyProService native_getNearbyProService(long j3);

        private native IKernelOnlineStatusService native_getOnlineStatusService(long j3);

        private native IKernelPersonalAlbumService native_getPersonalAlbumService(long j3);

        private native IKernelProfileService native_getProfileService(long j3);

        private native IKernelQRService native_getQRService(long j3);

        private native IKernelRecentContactService native_getRecentContactService(long j3);

        private native IKernelRichMediaService native_getRichMediaService(long j3);

        private native IKernelRobotService native_getRobotService(long j3);

        private native IKernelSearchService native_getSearchService(long j3);

        private native String native_getSessionId(long j3);

        private native IKernelSettingService native_getSettingService(long j3);

        private native ArrayList<String> native_getShortLinkBlacklist(long j3);

        private native IKernelStorageCleanService native_getStorageCleanService(long j3);

        private native IKernelTicketService native_getTicketService(long j3);

        private native IKernelUixConvertService native_getUixConvertService(long j3);

        private native IKernelUnifySearchService native_getUnifySearchService(long j3);

        private native IKernelUnitedConfigService native_getUnitedConfigService(long j3);

        private native IKernelWiFiPhotoHostService native_getWiFiPhotoHostService(long j3);

        private native void native_init(long j3, InitSessionConfig initSessionConfig, IDependsAdapter iDependsAdapter, IDispatcherAdapter iDispatcherAdapter, IKernelSessionListener iKernelSessionListener);

        private native void native_offLine(long j3, UnregisterInfo unregisterInfo, IOperateCallback iOperateCallback);

        private native boolean native_offLineSync(long j3, boolean z16);

        private native void native_onDispatchPush(long j3, int i3, byte[] bArr);

        private native void native_onDispatchPushWithJson(long j3, int i3, String str);

        private native void native_onDispatchRequestReply(long j3, long j16, int i3, byte[] bArr);

        private native void native_onLine(long j3, RegisterInfo registerInfo);

        private native void native_onMsfPush(long j3, String str, byte[] bArr, PushExtraInfo pushExtraInfo);

        private native void native_onNetReply(long j3, long j16, int i3, String str, byte[] bArr);

        private native void native_onSendOidbReply(long j3, long j16, int i3, int i16, String str, MsfRspInfo msfRspInfo);

        private native void native_onSendSSOReply(long j3, long j16, String str, int i3, String str2, MsfRspInfo msfRspInfo);

        private native void native_onUIConfigUpdate(long j3, UIConfig uIConfig, String str);

        private native void native_setOnMsfStatusChanged(long j3, MsfStatusType msfStatusType, MsfChangeReasonType msfChangeReasonType, int i3);

        private native void native_setOnNetworkChanged(long j3, NetStatusType netStatusType);

        private native void native_setOnWeakNetChanged(long j3, boolean z16);

        private native void native_setQimei36(long j3, String str);

        private native void native_switchToBackGround(long j3);

        private native void native_switchToFront(long j3);

        private native void native_updateTicket(long j3, SessionTicket sessionTicket);

        public static native void preloadInitJni();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void close(String str) {
            native_close(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void disableIpDirect(boolean z16) {
            native_disableIpDirect(this.nativeRef, z16);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelAVSDKService getAVSDKService() {
            return native_getAVSDKService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public String getAccountPath(PathType pathType) {
            return native_getAccountPath(this.nativeRef, pathType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelAddBuddyService getAddBuddyService() {
            return native_getAddBuddyService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelAlbumService getAlbumService() {
            return native_getAlbumService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelAvatarService getAvatarService() {
            return native_getAvatarService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelBaseEmojiService getBaseEmojiService() {
            return native_getBaseEmojiService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelBatchUploadService getBatchUploadService() {
            return native_getBatchUploadService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelBdhUploadService getBdhUploadService() {
            return native_getBdhUploadService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelBuddyService getBuddyService() {
            return native_getBuddyService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public ArrayList<String> getCacheErrLog() {
            return native_getCacheErrLog(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelConfigMgrService getConfigMgrService() {
            return native_getConfigMgrService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelDataReportService getDataReportService() {
            return native_getDataReportService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelEmojiService getEmojiService() {
            return native_getEmojiService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelFileBridgeClientService getFileBridgeClientService() {
            return native_getFileBridgeClientService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelFlashTransferService getFlashTransferService() {
            return native_getFlashTransferService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelGroupSchoolService getGroupSchoolService() {
            return native_getGroupSchoolService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelGroupService getGroupService() {
            return native_getGroupService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelGroupTabService getGroupTabService() {
            return native_getGroupTabService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelGuildMsgService getGuildMsgService() {
            return native_getGuildMsgService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelLiteBusinessService getLiteBusinessService() {
            return native_getLiteBusinessService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelMsgService getMsgService() {
            return native_getMsgService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelNearbyProService getNearbyProService() {
            return native_getNearbyProService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelOnlineStatusService getOnlineStatusService() {
            return native_getOnlineStatusService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelPersonalAlbumService getPersonalAlbumService() {
            return native_getPersonalAlbumService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelProfileService getProfileService() {
            return native_getProfileService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelQRService getQRService() {
            return native_getQRService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelRecentContactService getRecentContactService() {
            return native_getRecentContactService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelRichMediaService getRichMediaService() {
            return native_getRichMediaService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelRobotService getRobotService() {
            return native_getRobotService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelSearchService getSearchService() {
            return native_getSearchService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public String getSessionId() {
            return native_getSessionId(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelSettingService getSettingService() {
            return native_getSettingService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public ArrayList<String> getShortLinkBlacklist() {
            return native_getShortLinkBlacklist(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelStorageCleanService getStorageCleanService() {
            return native_getStorageCleanService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelTicketService getTicketService() {
            return native_getTicketService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelUixConvertService getUixConvertService() {
            return native_getUixConvertService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelUnifySearchService getUnifySearchService() {
            return native_getUnifySearchService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelUnitedConfigService getUnitedConfigService() {
            return native_getUnitedConfigService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public IKernelWiFiPhotoHostService getWiFiPhotoHostService() {
            return native_getWiFiPhotoHostService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void init(InitSessionConfig initSessionConfig, IDependsAdapter iDependsAdapter, IDispatcherAdapter iDispatcherAdapter, IKernelSessionListener iKernelSessionListener) {
            native_init(this.nativeRef, initSessionConfig, iDependsAdapter, iDispatcherAdapter, iKernelSessionListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void offLine(UnregisterInfo unregisterInfo, IOperateCallback iOperateCallback) {
            native_offLine(this.nativeRef, unregisterInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public boolean offLineSync(boolean z16) {
            return native_offLineSync(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onDispatchPush(int i3, byte[] bArr) {
            native_onDispatchPush(this.nativeRef, i3, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onDispatchPushWithJson(int i3, String str) {
            native_onDispatchPushWithJson(this.nativeRef, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onDispatchRequestReply(long j3, int i3, byte[] bArr) {
            native_onDispatchRequestReply(this.nativeRef, j3, i3, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onLine(RegisterInfo registerInfo) {
            native_onLine(this.nativeRef, registerInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onMsfPush(String str, byte[] bArr, PushExtraInfo pushExtraInfo) {
            native_onMsfPush(this.nativeRef, str, bArr, pushExtraInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onNetReply(long j3, int i3, String str, byte[] bArr) {
            native_onNetReply(this.nativeRef, j3, i3, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onSendOidbReply(long j3, int i3, int i16, String str, MsfRspInfo msfRspInfo) {
            native_onSendOidbReply(this.nativeRef, j3, i3, i16, str, msfRspInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onSendSSOReply(long j3, String str, int i3, String str2, MsfRspInfo msfRspInfo) {
            native_onSendSSOReply(this.nativeRef, j3, str, i3, str2, msfRspInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void onUIConfigUpdate(UIConfig uIConfig, String str) {
            native_onUIConfigUpdate(this.nativeRef, uIConfig, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void setOnMsfStatusChanged(MsfStatusType msfStatusType, MsfChangeReasonType msfChangeReasonType, int i3) {
            native_setOnMsfStatusChanged(this.nativeRef, msfStatusType, msfChangeReasonType, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void setOnNetworkChanged(NetStatusType netStatusType) {
            native_setOnNetworkChanged(this.nativeRef, netStatusType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void setOnWeakNetChanged(boolean z16) {
            native_setOnWeakNetChanged(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void setQimei36(String str) {
            native_setQimei36(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void switchToBackGround() {
            native_switchToBackGround(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void switchToFront() {
            native_switchToFront(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession
        public void updateTicket(SessionTicket sessionTicket) {
            native_updateTicket(this.nativeRef, sessionTicket);
        }
    }

    void close(String str);

    void disableIpDirect(boolean z16);

    IKernelAVSDKService getAVSDKService();

    String getAccountPath(PathType pathType);

    IKernelAddBuddyService getAddBuddyService();

    IKernelAlbumService getAlbumService();

    IKernelAvatarService getAvatarService();

    IKernelBaseEmojiService getBaseEmojiService();

    IKernelBatchUploadService getBatchUploadService();

    IKernelBdhUploadService getBdhUploadService();

    IKernelBuddyService getBuddyService();

    ArrayList<String> getCacheErrLog();

    IKernelConfigMgrService getConfigMgrService();

    IKernelDataReportService getDataReportService();

    IKernelEmojiService getEmojiService();

    IKernelFileBridgeClientService getFileBridgeClientService();

    IKernelFlashTransferService getFlashTransferService();

    IKernelGroupSchoolService getGroupSchoolService();

    IKernelGroupService getGroupService();

    IKernelGroupTabService getGroupTabService();

    IKernelGuildMsgService getGuildMsgService();

    IKernelLiteBusinessService getLiteBusinessService();

    IKernelMsgService getMsgService();

    IKernelNearbyProService getNearbyProService();

    IKernelOnlineStatusService getOnlineStatusService();

    IKernelPersonalAlbumService getPersonalAlbumService();

    IKernelProfileService getProfileService();

    IKernelQRService getQRService();

    IKernelRecentContactService getRecentContactService();

    IKernelRichMediaService getRichMediaService();

    IKernelRobotService getRobotService();

    IKernelSearchService getSearchService();

    String getSessionId();

    IKernelSettingService getSettingService();

    ArrayList<String> getShortLinkBlacklist();

    IKernelStorageCleanService getStorageCleanService();

    IKernelTicketService getTicketService();

    IKernelUixConvertService getUixConvertService();

    IKernelUnifySearchService getUnifySearchService();

    IKernelUnitedConfigService getUnitedConfigService();

    IKernelWiFiPhotoHostService getWiFiPhotoHostService();

    void init(InitSessionConfig initSessionConfig, IDependsAdapter iDependsAdapter, IDispatcherAdapter iDispatcherAdapter, IKernelSessionListener iKernelSessionListener);

    void offLine(UnregisterInfo unregisterInfo, IOperateCallback iOperateCallback);

    boolean offLineSync(boolean z16);

    void onDispatchPush(int i3, byte[] bArr);

    void onDispatchPushWithJson(int i3, String str);

    void onDispatchRequestReply(long j3, int i3, byte[] bArr);

    void onLine(RegisterInfo registerInfo);

    void onMsfPush(String str, byte[] bArr, PushExtraInfo pushExtraInfo);

    void onNetReply(long j3, int i3, String str, byte[] bArr);

    void onSendOidbReply(long j3, int i3, int i16, String str, MsfRspInfo msfRspInfo);

    void onSendSSOReply(long j3, String str, int i3, String str2, MsfRspInfo msfRspInfo);

    void onUIConfigUpdate(UIConfig uIConfig, String str);

    void setOnMsfStatusChanged(MsfStatusType msfStatusType, MsfChangeReasonType msfChangeReasonType, int i3);

    void setOnNetworkChanged(NetStatusType netStatusType);

    void setOnWeakNetChanged(boolean z16);

    void setQimei36(String str);

    void switchToBackGround();

    void switchToFront();

    void updateTicket(SessionTicket sessionTicket);
}
