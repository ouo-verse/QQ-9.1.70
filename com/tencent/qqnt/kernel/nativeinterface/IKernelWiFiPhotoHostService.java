package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelWiFiPhotoHostService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelWiFiPhotoHostService {
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

        private native void native_acceptRequest(long j3, int i3, WiFiPhotoAuthorizationInfo wiFiPhotoAuthorizationInfo, IOperateCallback iOperateCallback);

        private native void native_addKernelWiFiPhotoHostListener(long j3, IKernelWiFiPhotoHostListener iKernelWiFiPhotoHostListener);

        private native void native_checkIfInFilebridge(long j3, IOperateCallback iOperateCallback);

        private native void native_checkIfPendingRequest(long j3, IKernelWiFiPhotoCheckIfPendingRequestCallback iKernelWiFiPhotoCheckIfPendingRequestCallback);

        private native void native_disconnect(long j3, int i3);

        private native void native_precheckIfDeviceSupportWiFiPhotoRequest(long j3, IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback);

        private native void native_rejectRequest(long j3, int i3, int i16, IOperateCallback iOperateCallback);

        private native void native_removeKernelWiFiPhotoHostListener(long j3, IKernelWiFiPhotoHostListener iKernelWiFiPhotoHostListener);

        private native void native_requestVisitLocalAlbum(long j3, IOperateCallback iOperateCallback);

        private native void native_setAlbumAccessDelegate(long j3, IKernelWiFiPhotoAlbumAccessDelegate iKernelWiFiPhotoAlbumAccessDelegate);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void acceptRequest(int i3, WiFiPhotoAuthorizationInfo wiFiPhotoAuthorizationInfo, IOperateCallback iOperateCallback) {
            native_acceptRequest(this.nativeRef, i3, wiFiPhotoAuthorizationInfo, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void addKernelWiFiPhotoHostListener(IKernelWiFiPhotoHostListener iKernelWiFiPhotoHostListener) {
            native_addKernelWiFiPhotoHostListener(this.nativeRef, iKernelWiFiPhotoHostListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void checkIfInFilebridge(IOperateCallback iOperateCallback) {
            native_checkIfInFilebridge(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void checkIfPendingRequest(IKernelWiFiPhotoCheckIfPendingRequestCallback iKernelWiFiPhotoCheckIfPendingRequestCallback) {
            native_checkIfPendingRequest(this.nativeRef, iKernelWiFiPhotoCheckIfPendingRequestCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void disconnect(int i3) {
            native_disconnect(this.nativeRef, i3);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void precheckIfDeviceSupportWiFiPhotoRequest(IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback) {
            native_precheckIfDeviceSupportWiFiPhotoRequest(this.nativeRef, iKernelWiFiPhotoPreCheckCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void rejectRequest(int i3, int i16, IOperateCallback iOperateCallback) {
            native_rejectRequest(this.nativeRef, i3, i16, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void removeKernelWiFiPhotoHostListener(IKernelWiFiPhotoHostListener iKernelWiFiPhotoHostListener) {
            native_removeKernelWiFiPhotoHostListener(this.nativeRef, iKernelWiFiPhotoHostListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void requestVisitLocalAlbum(IOperateCallback iOperateCallback) {
            native_requestVisitLocalAlbum(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoHostService
        public void setAlbumAccessDelegate(IKernelWiFiPhotoAlbumAccessDelegate iKernelWiFiPhotoAlbumAccessDelegate) {
            native_setAlbumAccessDelegate(this.nativeRef, iKernelWiFiPhotoAlbumAccessDelegate);
        }
    }

    void acceptRequest(int i3, WiFiPhotoAuthorizationInfo wiFiPhotoAuthorizationInfo, IOperateCallback iOperateCallback);

    void addKernelWiFiPhotoHostListener(IKernelWiFiPhotoHostListener iKernelWiFiPhotoHostListener);

    void checkIfInFilebridge(IOperateCallback iOperateCallback);

    void checkIfPendingRequest(IKernelWiFiPhotoCheckIfPendingRequestCallback iKernelWiFiPhotoCheckIfPendingRequestCallback);

    void disconnect(int i3);

    void precheckIfDeviceSupportWiFiPhotoRequest(IKernelWiFiPhotoPreCheckCallback iKernelWiFiPhotoPreCheckCallback);

    void rejectRequest(int i3, int i16, IOperateCallback iOperateCallback);

    void removeKernelWiFiPhotoHostListener(IKernelWiFiPhotoHostListener iKernelWiFiPhotoHostListener);

    void requestVisitLocalAlbum(IOperateCallback iOperateCallback);

    void setAlbumAccessDelegate(IKernelWiFiPhotoAlbumAccessDelegate iKernelWiFiPhotoAlbumAccessDelegate);
}
