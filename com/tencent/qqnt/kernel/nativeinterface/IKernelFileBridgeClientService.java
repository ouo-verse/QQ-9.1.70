package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelFileBridgeClientService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelFileBridgeClientService {
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

        private native void native_addKernelFileBridgeClientListener(long j3, IKernelFileBridgeClientListener iKernelFileBridgeClientListener);

        private native void native_authenticateWithPassword(long j3, String str, long j16, IOperateCallback iOperateCallback);

        private native void native_cancelGet(long j3, String str);

        private native void native_cancelSearchFolderForFiles(long j3, long j16);

        private native void native_checkIfInWiFiPhotoOrFilebridge(long j3, IOperateCallback iOperateCallback);

        private native void native_clearUncompleteDownloadRecords(long j3, byte[] bArr, IOperateCallback iOperateCallback);

        private native void native_disconnect(long j3, int i3);

        private native FileBridgeAuthenticationType native_getAuthenticationType(long j3);

        private native FileBridgeClientState native_getCurrentStatus(long j3);

        private native void native_getFile(long j3, String str, IOperateCallback iOperateCallback);

        private native void native_getFileLocalStoragePath(long j3, String str, IKernelGetFileCallback iKernelGetFileCallback);

        private native String native_getHostDeviceName(long j3);

        private native boolean native_getHostIsSupportSearch(long j3);

        private native int native_getHostMaxSearchCount(long j3);

        private native PlatformType native_getHostSystemType(long j3);

        private native int native_getMaxAuthenticateWithoutPasswordValidDays(long j3);

        private native void native_getPageContent(long j3, boolean z16, String str, IKernelGetPageContentCallback iKernelGetPageContentCallback);

        private native void native_getRootPageContent(long j3, IKernelGetRootPageContentCallback iKernelGetRootPageContentCallback);

        private native void native_getThumbnail(long j3, boolean z16, String str, ThumbConfig thumbConfig, IOperateCallback iOperateCallback);

        private native void native_preCheck(long j3, IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback);

        private native void native_queryUncompleteDownloadRecords(long j3, IKernelQueryUncompleteDownloadRecordsCallback iKernelQueryUncompleteDownloadRecordsCallback);

        private native void native_removeKernelFileBridgeClientListener(long j3, IKernelFileBridgeClientListener iKernelFileBridgeClientListener);

        private native void native_resumeUncompleteDownloadRecords(long j3, byte[] bArr);

        private native void native_searchFolderForFiles(long j3, long j16, String str, String str2);

        private native void native_sendRequest(long j3, String str, IKernelSendFileBridgeRequestCallback iKernelSendFileBridgeRequestCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void addKernelFileBridgeClientListener(IKernelFileBridgeClientListener iKernelFileBridgeClientListener) {
            native_addKernelFileBridgeClientListener(this.nativeRef, iKernelFileBridgeClientListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void authenticateWithPassword(String str, long j3, IOperateCallback iOperateCallback) {
            native_authenticateWithPassword(this.nativeRef, str, j3, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void cancelGet(String str) {
            native_cancelGet(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void cancelSearchFolderForFiles(long j3) {
            native_cancelSearchFolderForFiles(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void checkIfInWiFiPhotoOrFilebridge(IOperateCallback iOperateCallback) {
            native_checkIfInWiFiPhotoOrFilebridge(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void clearUncompleteDownloadRecords(byte[] bArr, IOperateCallback iOperateCallback) {
            native_clearUncompleteDownloadRecords(this.nativeRef, bArr, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void disconnect(int i3) {
            native_disconnect(this.nativeRef, i3);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public FileBridgeAuthenticationType getAuthenticationType() {
            return native_getAuthenticationType(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public FileBridgeClientState getCurrentStatus() {
            return native_getCurrentStatus(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void getFile(String str, IOperateCallback iOperateCallback) {
            native_getFile(this.nativeRef, str, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void getFileLocalStoragePath(String str, IKernelGetFileCallback iKernelGetFileCallback) {
            native_getFileLocalStoragePath(this.nativeRef, str, iKernelGetFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public String getHostDeviceName() {
            return native_getHostDeviceName(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public boolean getHostIsSupportSearch() {
            return native_getHostIsSupportSearch(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public int getHostMaxSearchCount() {
            return native_getHostMaxSearchCount(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public PlatformType getHostSystemType() {
            return native_getHostSystemType(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public int getMaxAuthenticateWithoutPasswordValidDays() {
            return native_getMaxAuthenticateWithoutPasswordValidDays(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void getPageContent(boolean z16, String str, IKernelGetPageContentCallback iKernelGetPageContentCallback) {
            native_getPageContent(this.nativeRef, z16, str, iKernelGetPageContentCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void getRootPageContent(IKernelGetRootPageContentCallback iKernelGetRootPageContentCallback) {
            native_getRootPageContent(this.nativeRef, iKernelGetRootPageContentCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void getThumbnail(boolean z16, String str, ThumbConfig thumbConfig, IOperateCallback iOperateCallback) {
            native_getThumbnail(this.nativeRef, z16, str, thumbConfig, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void preCheck(IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback) {
            native_preCheck(this.nativeRef, iKernelWiFiPhotoPreCheckCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void queryUncompleteDownloadRecords(IKernelQueryUncompleteDownloadRecordsCallback iKernelQueryUncompleteDownloadRecordsCallback) {
            native_queryUncompleteDownloadRecords(this.nativeRef, iKernelQueryUncompleteDownloadRecordsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void removeKernelFileBridgeClientListener(IKernelFileBridgeClientListener iKernelFileBridgeClientListener) {
            native_removeKernelFileBridgeClientListener(this.nativeRef, iKernelFileBridgeClientListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void resumeUncompleteDownloadRecords(byte[] bArr) {
            native_resumeUncompleteDownloadRecords(this.nativeRef, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void searchFolderForFiles(long j3, String str, String str2) {
            native_searchFolderForFiles(this.nativeRef, j3, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientService
        public void sendRequest(String str, IKernelSendFileBridgeRequestCallback iKernelSendFileBridgeRequestCallback) {
            native_sendRequest(this.nativeRef, str, iKernelSendFileBridgeRequestCallback);
        }
    }

    void addKernelFileBridgeClientListener(IKernelFileBridgeClientListener iKernelFileBridgeClientListener);

    void authenticateWithPassword(String str, long j3, IOperateCallback iOperateCallback);

    void cancelGet(String str);

    void cancelSearchFolderForFiles(long j3);

    void checkIfInWiFiPhotoOrFilebridge(IOperateCallback iOperateCallback);

    void clearUncompleteDownloadRecords(byte[] bArr, IOperateCallback iOperateCallback);

    void disconnect(int i3);

    FileBridgeAuthenticationType getAuthenticationType();

    FileBridgeClientState getCurrentStatus();

    void getFile(String str, IOperateCallback iOperateCallback);

    void getFileLocalStoragePath(String str, IKernelGetFileCallback iKernelGetFileCallback);

    String getHostDeviceName();

    boolean getHostIsSupportSearch();

    int getHostMaxSearchCount();

    PlatformType getHostSystemType();

    int getMaxAuthenticateWithoutPasswordValidDays();

    void getPageContent(boolean z16, String str, IKernelGetPageContentCallback iKernelGetPageContentCallback);

    void getRootPageContent(IKernelGetRootPageContentCallback iKernelGetRootPageContentCallback);

    void getThumbnail(boolean z16, String str, ThumbConfig thumbConfig, IOperateCallback iOperateCallback);

    void preCheck(IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback);

    void queryUncompleteDownloadRecords(IKernelQueryUncompleteDownloadRecordsCallback iKernelQueryUncompleteDownloadRecordsCallback);

    void removeKernelFileBridgeClientListener(IKernelFileBridgeClientListener iKernelFileBridgeClientListener);

    void resumeUncompleteDownloadRecords(byte[] bArr);

    void searchFolderForFiles(long j3, String str, String str2);

    void sendRequest(String str, IKernelSendFileBridgeRequestCallback iKernelSendFileBridgeRequestCallback);
}
