package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelFileBridgeHostService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelFileBridgeHostService {
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

        private native void native_addKernelFileBridgeHostListener(long j3, IKernelFileBridgeHostListener iKernelFileBridgeHostListener);

        private native void native_disconnect(long j3, int i3, IOperateCallback iOperateCallback);

        private native void native_isLocalPasswordSet(long j3, IIsLocalPasswordSetCallback iIsLocalPasswordSetCallback);

        private native void native_isTransferingFile(long j3, IIsTransferingFileCallback iIsTransferingFileCallback);

        private native void native_removeKernelFileBridgeHostListener(long j3, IKernelFileBridgeHostListener iKernelFileBridgeHostListener);

        private native void native_resetLocalPassword(long j3, IOperateCallback iOperateCallback);

        private native void native_setLocalPassword(long j3, String str, IOperateCallback iOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void addKernelFileBridgeHostListener(IKernelFileBridgeHostListener iKernelFileBridgeHostListener) {
            native_addKernelFileBridgeHostListener(this.nativeRef, iKernelFileBridgeHostListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void disconnect(int i3, IOperateCallback iOperateCallback) {
            native_disconnect(this.nativeRef, i3, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void isLocalPasswordSet(IIsLocalPasswordSetCallback iIsLocalPasswordSetCallback) {
            native_isLocalPasswordSet(this.nativeRef, iIsLocalPasswordSetCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void isTransferingFile(IIsTransferingFileCallback iIsTransferingFileCallback) {
            native_isTransferingFile(this.nativeRef, iIsTransferingFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void removeKernelFileBridgeHostListener(IKernelFileBridgeHostListener iKernelFileBridgeHostListener) {
            native_removeKernelFileBridgeHostListener(this.nativeRef, iKernelFileBridgeHostListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void resetLocalPassword(IOperateCallback iOperateCallback) {
            native_resetLocalPassword(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeHostService
        public void setLocalPassword(String str, IOperateCallback iOperateCallback) {
            native_setLocalPassword(this.nativeRef, str, iOperateCallback);
        }
    }

    void addKernelFileBridgeHostListener(IKernelFileBridgeHostListener iKernelFileBridgeHostListener);

    void disconnect(int i3, IOperateCallback iOperateCallback);

    void isLocalPasswordSet(IIsLocalPasswordSetCallback iIsLocalPasswordSetCallback);

    void isTransferingFile(IIsTransferingFileCallback iIsTransferingFileCallback);

    void removeKernelFileBridgeHostListener(IKernelFileBridgeHostListener iKernelFileBridgeHostListener);

    void resetLocalPassword(IOperateCallback iOperateCallback);

    void setLocalPassword(String str, IOperateCallback iOperateCallback);
}
