package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelYellowFaceForManagerService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelYellowFaceForManagerService {
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

        private native void native_download(long j3, String str, String str2, String str3, boolean z16, IKernelYellowFaceDownloadCallback iKernelYellowFaceDownloadCallback);

        private native void native_setHistory(long j3, String str, IOperateCallback iOperateCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceForManagerService
        public void download(String str, String str2, String str3, boolean z16, IKernelYellowFaceDownloadCallback iKernelYellowFaceDownloadCallback) {
            native_download(this.nativeRef, str, str2, str3, z16, iKernelYellowFaceDownloadCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceForManagerService
        public void setHistory(String str, IOperateCallback iOperateCallback) {
            native_setHistory(this.nativeRef, str, iOperateCallback);
        }
    }

    void download(String str, String str2, String str3, boolean z16, IKernelYellowFaceDownloadCallback iKernelYellowFaceDownloadCallback);

    void setHistory(String str, IOperateCallback iOperateCallback);
}
