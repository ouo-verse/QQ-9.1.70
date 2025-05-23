package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelStorageCleanService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelStorageCleanService {
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

        private native void native_addCacheScanedPaths(long j3, HashMap<String, ArrayList<String>> hashMap);

        private native void native_addFilesScanedPaths(long j3, ArrayList<String> arrayList);

        private native long native_addKernelStorageCleanListener(long j3, IKernelStorageCleanListener iKernelStorageCleanListener);

        private native void native_addNewDownloadOrUploadFile(long j3, CleanFileDetail cleanFileDetail);

        private native void native_addReportData(long j3, HashMap<String, Long> hashMap);

        private native void native_clearAllChatCacheInfo(long j3, IOperateCallback iOperateCallback);

        private native void native_clearCacheDataByKeys(long j3, ArrayList<String> arrayList, IOperateCallback iOperateCallback);

        private native void native_clearChatCacheInfo(long j3, ArrayList<ChatCacheDeleteInfo> arrayList, ArrayList<Long> arrayList2, IOperateCallback iOperateCallback);

        private native void native_closeCleanWindow(long j3);

        private native void native_endScan(long j3, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getChatCacheInfo(long j3, int i3, int i16, CacheOrderType cacheOrderType, int i17, IKernelGetChatCacheInfoCallback iKernelGetChatCacheInfoCallback);

        private native void native_getFileCacheInfo(long j3, CacheFileType cacheFileType, boolean z16, int i3, CacheOrderType cacheOrderType, FileCacheInfo fileCacheInfo, IKernelGetFileCacheInfoCallback iKernelGetFileCacheInfoCallback);

        private native void native_removeKernelStorageCleanListener(long j3, long j16);

        private native void native_reportData(long j3);

        private native void native_scanCache(long j3, IKernelScanEndCallback iKernelScanEndCallback);

        private native void native_setSilentScan(long j3, boolean z16);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void addCacheScanedPaths(HashMap<String, ArrayList<String>> hashMap) {
            native_addCacheScanedPaths(this.nativeRef, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void addFilesScanedPaths(ArrayList<String> arrayList) {
            native_addFilesScanedPaths(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public long addKernelStorageCleanListener(IKernelStorageCleanListener iKernelStorageCleanListener) {
            return native_addKernelStorageCleanListener(this.nativeRef, iKernelStorageCleanListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void addNewDownloadOrUploadFile(CleanFileDetail cleanFileDetail) {
            native_addNewDownloadOrUploadFile(this.nativeRef, cleanFileDetail);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void addReportData(HashMap<String, Long> hashMap) {
            native_addReportData(this.nativeRef, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void clearAllChatCacheInfo(IOperateCallback iOperateCallback) {
            native_clearAllChatCacheInfo(this.nativeRef, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void clearCacheDataByKeys(ArrayList<String> arrayList, IOperateCallback iOperateCallback) {
            native_clearCacheDataByKeys(this.nativeRef, arrayList, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void clearChatCacheInfo(ArrayList<ChatCacheDeleteInfo> arrayList, ArrayList<Long> arrayList2, IOperateCallback iOperateCallback) {
            native_clearChatCacheInfo(this.nativeRef, arrayList, arrayList2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void closeCleanWindow() {
            native_closeCleanWindow(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void endScan(boolean z16, IOperateCallback iOperateCallback) {
            native_endScan(this.nativeRef, z16, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void getChatCacheInfo(int i3, int i16, CacheOrderType cacheOrderType, int i17, IKernelGetChatCacheInfoCallback iKernelGetChatCacheInfoCallback) {
            native_getChatCacheInfo(this.nativeRef, i3, i16, cacheOrderType, i17, iKernelGetChatCacheInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void getFileCacheInfo(CacheFileType cacheFileType, boolean z16, int i3, CacheOrderType cacheOrderType, FileCacheInfo fileCacheInfo, IKernelGetFileCacheInfoCallback iKernelGetFileCacheInfoCallback) {
            native_getFileCacheInfo(this.nativeRef, cacheFileType, z16, i3, cacheOrderType, fileCacheInfo, iKernelGetFileCacheInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void removeKernelStorageCleanListener(long j3) {
            native_removeKernelStorageCleanListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void reportData() {
            native_reportData(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void scanCache(IKernelScanEndCallback iKernelScanEndCallback) {
            native_scanCache(this.nativeRef, iKernelScanEndCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelStorageCleanService
        public void setSilentScan(boolean z16) {
            native_setSilentScan(this.nativeRef, z16);
        }
    }

    void addCacheScanedPaths(HashMap<String, ArrayList<String>> hashMap);

    void addFilesScanedPaths(ArrayList<String> arrayList);

    long addKernelStorageCleanListener(IKernelStorageCleanListener iKernelStorageCleanListener);

    void addNewDownloadOrUploadFile(CleanFileDetail cleanFileDetail);

    void addReportData(HashMap<String, Long> hashMap);

    void clearAllChatCacheInfo(IOperateCallback iOperateCallback);

    void clearCacheDataByKeys(ArrayList<String> arrayList, IOperateCallback iOperateCallback);

    void clearChatCacheInfo(ArrayList<ChatCacheDeleteInfo> arrayList, ArrayList<Long> arrayList2, IOperateCallback iOperateCallback);

    void closeCleanWindow();

    void endScan(boolean z16, IOperateCallback iOperateCallback);

    void getChatCacheInfo(int i3, int i16, CacheOrderType cacheOrderType, int i17, IKernelGetChatCacheInfoCallback iKernelGetChatCacheInfoCallback);

    void getFileCacheInfo(CacheFileType cacheFileType, boolean z16, int i3, CacheOrderType cacheOrderType, FileCacheInfo fileCacheInfo, IKernelGetFileCacheInfoCallback iKernelGetFileCacheInfoCallback);

    void removeKernelStorageCleanListener(long j3);

    void reportData();

    void scanCache(IKernelScanEndCallback iKernelScanEndCallback);

    void setSilentScan(boolean z16);
}
