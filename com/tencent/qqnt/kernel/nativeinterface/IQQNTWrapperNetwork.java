package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IQQNTWrapperNetwork {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IQQNTWrapperNetwork {
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

        private native long native_addNetworkServiceListener(long j3, IQQNTWrapperNetworkListener iQQNTWrapperNetworkListener);

        private native NetStatusType native_getNetworkStatus(long j3);

        private native void native_removedNetworkServiceListener(long j3, long j16);

        private native boolean native_startGetNetworkStatus(long j3);

        private native void native_stopGetNetworkStatus(long j3);

        public static native IQQNTWrapperNetwork openNetworkService();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetwork
        public long addNetworkServiceListener(IQQNTWrapperNetworkListener iQQNTWrapperNetworkListener) {
            return native_addNetworkServiceListener(this.nativeRef, iQQNTWrapperNetworkListener);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetwork
        public NetStatusType getNetworkStatus() {
            return native_getNetworkStatus(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetwork
        public void removedNetworkServiceListener(long j3) {
            native_removedNetworkServiceListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetwork
        public boolean startGetNetworkStatus() {
            return native_startGetNetworkStatus(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperNetwork
        public void stopGetNetworkStatus() {
            native_stopGetNetworkStatus(this.nativeRef);
        }
    }

    long addNetworkServiceListener(IQQNTWrapperNetworkListener iQQNTWrapperNetworkListener);

    NetStatusType getNetworkStatus();

    void removedNetworkServiceListener(long j3);

    boolean startGetNetworkStatus();

    void stopGetNetworkStatus();
}
