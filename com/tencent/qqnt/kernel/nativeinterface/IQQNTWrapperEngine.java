package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IQQNTWrapperEngine {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IQQNTWrapperEngine {
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

        public static native IQQNTWrapperEngine get();

        private native void nativeDestroy(long j3);

        private native boolean native_ClearMoblieQQAccountData(long j3, String str);

        private native void native_destroy(long j3);

        private native DeviceInfo native_getDeviceInfo(long j3);

        private native IKernelECDHService native_getECDHService(long j3);

        private native IKernelThirdPartySigService native_getThirdPartySigService(long j3);

        private native boolean native_initWithDeskTopConfig(long j3, WrapperEngineGlobalConfig wrapperEngineGlobalConfig, IGlobalAdapter iGlobalAdapter);

        private native boolean native_initWithMobileConfig(long j3, WrapperEngineGlobalConfig wrapperEngineGlobalConfig, IGlobalAdapter iGlobalAdapter);

        private native void native_onSendSSOReply(long j3, long j16, String str, int i3, String str2, MsfRspInfo msfRspInfo);

        private native void native_readyToShow(long j3);

        private native void native_setLogLevel(long j3, int i3);

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public boolean ClearMoblieQQAccountData(String str) {
            return native_ClearMoblieQQAccountData(this.nativeRef, str);
        }

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public void destroy() {
            native_destroy(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public DeviceInfo getDeviceInfo() {
            return native_getDeviceInfo(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public IKernelECDHService getECDHService() {
            return native_getECDHService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public IKernelThirdPartySigService getThirdPartySigService() {
            return native_getThirdPartySigService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public boolean initWithDeskTopConfig(WrapperEngineGlobalConfig wrapperEngineGlobalConfig, IGlobalAdapter iGlobalAdapter) {
            return native_initWithDeskTopConfig(this.nativeRef, wrapperEngineGlobalConfig, iGlobalAdapter);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public boolean initWithMobileConfig(WrapperEngineGlobalConfig wrapperEngineGlobalConfig, IGlobalAdapter iGlobalAdapter) {
            return native_initWithMobileConfig(this.nativeRef, wrapperEngineGlobalConfig, iGlobalAdapter);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public void onSendSSOReply(long j3, String str, int i3, String str2, MsfRspInfo msfRspInfo) {
            native_onSendSSOReply(this.nativeRef, j3, str, i3, str2, msfRspInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public void readyToShow() {
            native_readyToShow(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperEngine
        public void setLogLevel(int i3) {
            native_setLogLevel(this.nativeRef, i3);
        }
    }

    boolean ClearMoblieQQAccountData(String str);

    void destroy();

    DeviceInfo getDeviceInfo();

    IKernelECDHService getECDHService();

    IKernelThirdPartySigService getThirdPartySigService();

    boolean initWithDeskTopConfig(WrapperEngineGlobalConfig wrapperEngineGlobalConfig, IGlobalAdapter iGlobalAdapter);

    boolean initWithMobileConfig(WrapperEngineGlobalConfig wrapperEngineGlobalConfig, IGlobalAdapter iGlobalAdapter);

    void onSendSSOReply(long j3, String str, int i3, String str2, MsfRspInfo msfRspInfo);

    void readyToShow();

    void setLogLevel(int i3);
}
