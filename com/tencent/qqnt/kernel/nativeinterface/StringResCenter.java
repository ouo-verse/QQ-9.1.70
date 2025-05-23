package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface StringResCenter {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements StringResCenter {
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

        public static native StringResCenter getInstance();

        private native void nativeDestroy(long j3);

        private native void native_onResult(long j3, int i3, String str);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.StringResCenter
        public void onResult(int i3, String str) {
            native_onResult(this.nativeRef, i3, str);
        }
    }

    void onResult(int i3, String str);
}
