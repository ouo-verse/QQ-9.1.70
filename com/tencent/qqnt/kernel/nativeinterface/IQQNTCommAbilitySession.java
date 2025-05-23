package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IQQNTCommAbilitySession {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IQQNTCommAbilitySession {
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

        public static native IQQNTCommAbilitySession create();

        private native void nativeDestroy(long j3);

        private native void native_destroy(long j3);

        private native IKernelYellowFaceForManagerService native_getYellowFaceForManagerService(long j3);

        private native void native_init(long j3, InitCommAbilitySessionConfig initCommAbilitySessionConfig);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTCommAbilitySession
        public void destroy() {
            native_destroy(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTCommAbilitySession
        public IKernelYellowFaceForManagerService getYellowFaceForManagerService() {
            return native_getYellowFaceForManagerService(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTCommAbilitySession
        public void init(InitCommAbilitySessionConfig initCommAbilitySessionConfig) {
            native_init(this.nativeRef, initCommAbilitySessionConfig);
        }
    }

    void destroy();

    IKernelYellowFaceForManagerService getYellowFaceForManagerService();

    void init(InitCommAbilitySessionConfig initCommAbilitySessionConfig);
}
