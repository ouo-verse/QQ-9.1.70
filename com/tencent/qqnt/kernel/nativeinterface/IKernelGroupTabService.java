package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGroupTabService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelGroupTabService {
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

        private native long native_addListener(long j3, IKernelGroupTabListener iKernelGroupTabListener);

        private native void native_getGroupTab(long j3, ArrayList<Long> arrayList, ArrayList<String> arrayList2, IOperateCallback iOperateCallback);

        private native void native_removeListener(long j3, long j16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabService
        public long addListener(IKernelGroupTabListener iKernelGroupTabListener) {
            return native_addListener(this.nativeRef, iKernelGroupTabListener);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabService
        public void getGroupTab(ArrayList<Long> arrayList, ArrayList<String> arrayList2, IOperateCallback iOperateCallback) {
            native_getGroupTab(this.nativeRef, arrayList, arrayList2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGroupTabService
        public void removeListener(long j3) {
            native_removeListener(this.nativeRef, j3);
        }
    }

    long addListener(IKernelGroupTabListener iKernelGroupTabListener);

    void getGroupTab(ArrayList<Long> arrayList, ArrayList<String> arrayList2, IOperateCallback iOperateCallback);

    void removeListener(long j3);
}
