package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelQRService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelQRService {
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

        private native void native_SendRejectQrRequest(long j3, byte[] bArr, IQRCallback iQRCallback);

        private native void native_initConfig(long j3, InitQRConfig initQRConfig);

        private native void native_sendAuthQrRequest(long j3, byte[] bArr, byte[] bArr2, SwitchOperation switchOperation, IQRCallback iQRCallback);

        private native void native_sendCancleQrRequest(long j3, byte[] bArr, IQRCallback iQRCallback);

        private native void native_sendScanQrRequest(long j3, ScanScene scanScene, byte[] bArr, IScanQRCallback iScanQRCallback);

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
        public void SendRejectQrRequest(byte[] bArr, IQRCallback iQRCallback) {
            native_SendRejectQrRequest(this.nativeRef, bArr, iQRCallback);
        }

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
        public void initConfig(InitQRConfig initQRConfig) {
            native_initConfig(this.nativeRef, initQRConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
        public void sendAuthQrRequest(byte[] bArr, byte[] bArr2, SwitchOperation switchOperation, IQRCallback iQRCallback) {
            native_sendAuthQrRequest(this.nativeRef, bArr, bArr2, switchOperation, iQRCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
        public void sendCancleQrRequest(byte[] bArr, IQRCallback iQRCallback) {
            native_sendCancleQrRequest(this.nativeRef, bArr, iQRCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelQRService
        public void sendScanQrRequest(ScanScene scanScene, byte[] bArr, IScanQRCallback iScanQRCallback) {
            native_sendScanQrRequest(this.nativeRef, scanScene, bArr, iScanQRCallback);
        }
    }

    void SendRejectQrRequest(byte[] bArr, IQRCallback iQRCallback);

    void initConfig(InitQRConfig initQRConfig);

    void sendAuthQrRequest(byte[] bArr, byte[] bArr2, SwitchOperation switchOperation, IQRCallback iQRCallback);

    void sendCancleQrRequest(byte[] bArr, IQRCallback iQRCallback);

    void sendScanQrRequest(ScanScene scanScene, byte[] bArr, IScanQRCallback iScanQRCallback);
}
