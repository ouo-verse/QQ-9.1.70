package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelUixConvertService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelUixConvertService {
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

        private native void native_getUid(long j3, HashSet<Long> hashSet, IKernelGetUidInfoCallback iKernelGetUidInfoCallback);

        private native void native_getUin(long j3, HashSet<String> hashSet, IKernelGetUinInfoCallback iKernelGetUinInfoCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUixConvertService
        public void getUid(HashSet<Long> hashSet, IKernelGetUidInfoCallback iKernelGetUidInfoCallback) {
            native_getUid(this.nativeRef, hashSet, iKernelGetUidInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelUixConvertService
        public void getUin(HashSet<String> hashSet, IKernelGetUinInfoCallback iKernelGetUinInfoCallback) {
            native_getUin(this.nativeRef, hashSet, iKernelGetUinInfoCallback);
        }
    }

    void getUid(HashSet<Long> hashSet, IKernelGetUidInfoCallback iKernelGetUidInfoCallback);

    void getUin(HashSet<String> hashSet, IKernelGetUinInfoCallback iKernelGetUinInfoCallback);
}
