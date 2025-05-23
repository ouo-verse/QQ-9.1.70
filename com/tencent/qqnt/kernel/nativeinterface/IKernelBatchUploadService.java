package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelBatchUploadService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelBatchUploadService {
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

        private native BatchUploadConfig native_createBatchUploadConfig(long j3);

        private native IBatchUploadManager native_getBatchUploadManager(long j3, BatchUploadConfig batchUploadConfig, IBatchUploadManagerDelegate iBatchUploadManagerDelegate);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBatchUploadService
        public BatchUploadConfig createBatchUploadConfig() {
            return native_createBatchUploadConfig(this.nativeRef);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBatchUploadService
        public IBatchUploadManager getBatchUploadManager(BatchUploadConfig batchUploadConfig, IBatchUploadManagerDelegate iBatchUploadManagerDelegate) {
            return native_getBatchUploadManager(this.nativeRef, batchUploadConfig, iBatchUploadManagerDelegate);
        }
    }

    BatchUploadConfig createBatchUploadConfig();

    IBatchUploadManager getBatchUploadManager(BatchUploadConfig batchUploadConfig, IBatchUploadManagerDelegate iBatchUploadManagerDelegate);
}
