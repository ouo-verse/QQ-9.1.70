package com.tencent.qqnt.kernel.nativeinterface;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IBatchUploadManager {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IBatchUploadManager {
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

        private native void native_addTaskToSession(long j3, BatchUploadTask batchUploadTask, BatchUploadSession batchUploadSession);

        private native void native_cancelUploadSession(long j3, BatchUploadSession batchUploadSession);

        private native void native_cancelUploadTask(long j3, BatchUploadTask batchUploadTask);

        private native void native_deleteCachedSession(long j3, String str);

        private native void native_getCachedSessions(long j3);

        private native void native_resumeUploadSession(long j3, BatchUploadSession batchUploadSession);

        private native void native_resumeUploadTask(long j3, BatchUploadTask batchUploadTask);

        private native void native_startUploadSession(long j3, BatchUploadSession batchUploadSession);

        private native void native_suspendUploadSession(long j3, BatchUploadSession batchUploadSession);

        private native void native_suspendUploadTask(long j3, BatchUploadTask batchUploadTask);

        private native void native_updateTaskInfo(long j3, BatchUploadTask batchUploadTask);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void addTaskToSession(BatchUploadTask batchUploadTask, BatchUploadSession batchUploadSession) {
            native_addTaskToSession(this.nativeRef, batchUploadTask, batchUploadSession);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void cancelUploadSession(BatchUploadSession batchUploadSession) {
            native_cancelUploadSession(this.nativeRef, batchUploadSession);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void cancelUploadTask(BatchUploadTask batchUploadTask) {
            native_cancelUploadTask(this.nativeRef, batchUploadTask);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void deleteCachedSession(String str) {
            native_deleteCachedSession(this.nativeRef, str);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void getCachedSessions() {
            native_getCachedSessions(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void resumeUploadSession(BatchUploadSession batchUploadSession) {
            native_resumeUploadSession(this.nativeRef, batchUploadSession);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void resumeUploadTask(BatchUploadTask batchUploadTask) {
            native_resumeUploadTask(this.nativeRef, batchUploadTask);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void startUploadSession(BatchUploadSession batchUploadSession) {
            native_startUploadSession(this.nativeRef, batchUploadSession);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void suspendUploadSession(BatchUploadSession batchUploadSession) {
            native_suspendUploadSession(this.nativeRef, batchUploadSession);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void suspendUploadTask(BatchUploadTask batchUploadTask) {
            native_suspendUploadTask(this.nativeRef, batchUploadTask);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IBatchUploadManager
        public void updateTaskInfo(BatchUploadTask batchUploadTask) {
            native_updateTaskInfo(this.nativeRef, batchUploadTask);
        }
    }

    void addTaskToSession(BatchUploadTask batchUploadTask, BatchUploadSession batchUploadSession);

    void cancelUploadSession(BatchUploadSession batchUploadSession);

    void cancelUploadTask(BatchUploadTask batchUploadTask);

    void deleteCachedSession(String str);

    void getCachedSessions();

    void resumeUploadSession(BatchUploadSession batchUploadSession);

    void resumeUploadTask(BatchUploadTask batchUploadTask);

    void startUploadSession(BatchUploadSession batchUploadSession);

    void suspendUploadSession(BatchUploadSession batchUploadSession);

    void suspendUploadTask(BatchUploadTask batchUploadTask);

    void updateTaskInfo(BatchUploadTask batchUploadTask);
}
