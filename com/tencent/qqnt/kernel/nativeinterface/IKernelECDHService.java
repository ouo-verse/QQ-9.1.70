package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelECDHService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelECDHService {
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

        private native void native_init(long j3);

        private native void native_sendOIDBRequest(long j3, int i3, int i16, int i17, String str, byte[] bArr, ISendECDHRequestCallback iSendECDHRequestCallback);

        private native void native_sendSSORequest(long j3, String str, int i3, String str2, byte[] bArr, ISendECDHRequestCallback iSendECDHRequestCallback);

        private native void native_setGuid(long j3, String str);

        private native void native_setIsDebug(long j3, boolean z16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService
        public void init() {
            native_init(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService
        public void sendOIDBRequest(int i3, int i16, int i17, String str, byte[] bArr, ISendECDHRequestCallback iSendECDHRequestCallback) {
            native_sendOIDBRequest(this.nativeRef, i3, i16, i17, str, bArr, iSendECDHRequestCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService
        public void sendSSORequest(String str, int i3, String str2, byte[] bArr, ISendECDHRequestCallback iSendECDHRequestCallback) {
            native_sendSSORequest(this.nativeRef, str, i3, str2, bArr, iSendECDHRequestCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService
        public void setGuid(String str) {
            native_setGuid(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelECDHService
        public void setIsDebug(boolean z16) {
            native_setIsDebug(this.nativeRef, z16);
        }
    }

    void init();

    void sendOIDBRequest(int i3, int i16, int i17, String str, byte[] bArr, ISendECDHRequestCallback iSendECDHRequestCallback);

    void sendSSORequest(String str, int i3, String str2, byte[] bArr, ISendECDHRequestCallback iSendECDHRequestCallback);

    void setGuid(String str);

    void setIsDebug(boolean z16);
}
