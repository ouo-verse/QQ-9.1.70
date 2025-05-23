package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelFlashTransferService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelFlashTransferService {
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

        private native void native_addCompressedFileListener(long j3, IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener);

        private native void native_addDesktopFileSetSimpleStatusListener(long j3, IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener);

        private native void native_addDesktopFileSetSimpleStatusMonitoring(long j3, ArrayList<String> arrayList);

        private native void native_addDeviceStatusListener(long j3, IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener);

        private native void native_addFileSetClusteringListListener(long j3, IFlashTransferClusteringListListener iFlashTransferClusteringListListener);

        private native void native_addFileSetDownloadListener(long j3, IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener);

        private native void native_addFileSetSimpleStatusListener(long j3, String str, IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener);

        private native void native_addFileSetSimpleStatusMonitoring(long j3, String str, ArrayList<String> arrayList);

        private native void native_addFileSetSimpleUploadInfoListener(long j3, IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener);

        private native void native_addFileSetSimpleUploadInfoMonitoring(long j3, ArrayList<String> arrayList);

        private native void native_addFileSetUploadListener(long j3, IFlashTransferUploadListener iFlashTransferUploadListener);

        private native void native_addFlashTransferTaskInfoListener(long j3, IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener);

        private native void native_addFolderListener(long j3, IFlashTransferFolderListener iFlashTransferFolderListener);

        private native void native_asyncGetThumbnailPath(long j3, String str, ArrayList<String> arrayList);

        private native void native_asyncRequestDownLoadStatus(long j3, String str, IFlashTransferGetFileSetDownloadStatusCallback iFlashTransferGetFileSetDownloadStatusCallback);

        private native void native_batchRemoveFile(long j3, BatchRemoveFileReq batchRemoveFileReq, IFlashTransferServiceBatchRemoveFileCallback iFlashTransferServiceBatchRemoveFileCallback);

        private native void native_cancelPollFilesTransferProgress(long j3, CancelFilesTransferProgressReq cancelFilesTransferProgressReq);

        private native void native_checkDeviceStatus(long j3, CheckDeviceStatusReq checkDeviceStatusReq, IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback);

        private native void native_checkDownloadStatusBeforeLocalFileOper(long j3, int i3, String str, String str2, IFlashTransferCheckDownloadStatusCallback iFlashTransferCheckDownloadStatusCallback);

        private native void native_cleanFailedFiles(long j3, int i3, ArrayList<File> arrayList, IFlashTransferCleanFailedFilesCallback iFlashTransferCleanFailedFilesCallback);

        private native void native_createFlashTransferUploadTask(long j3, int i3, CreateFlashTransferParam createFlashTransferParam, IFlashTransferServiceCreateFileSetCallback iFlashTransferServiceCreateFileSetCallback);

        private native void native_doAIOFlashTransferBubbleActionWithStatus(long j3, String str, int i3, IOperateCallback iOperateCallback);

        private native void native_getCompressedFileFolder(long j3, GetCompressedFileFolderReq getCompressedFileFolderReq, IFlashTransferServiceGetCompressedFileFolderCallback iFlashTransferServiceGetCompressedFileFolderCallback);

        private native void native_getDownloadedFileCount(long j3, GetDownloadedFileCountReq getDownloadedFileCountReq, IFlashTransferServiceGetDownloadedFileCountCallback iFlashTransferServiceGetDownloadedFileCountCallback);

        private native void native_getFailedFileList(long j3, GetFailedFileListReq getFailedFileListReq, IFlashTransferGetFailedFileListCallback iFlashTransferGetFailedFileListCallback);

        private native void native_getFileCategoryList(long j3, GetFileCategoryReq getFileCategoryReq, IFlashTransferGetFileCategoryCallback iFlashTransferGetFileCategoryCallback);

        private native void native_getFileList(long j3, GetFileListReq getFileListReq, IFlashTransferServiceGetFileListCallback iFlashTransferServiceGetFileListCallback);

        private native void native_getFileSet(long j3, GetFileSetReq getFileSetReq, IFlashTransferServiceGetFileSetCallback iFlashTransferServiceGetFileSetCallback);

        private native void native_getFileSetClusteringDetail(long j3, MediaClusteringDetailReq mediaClusteringDetailReq, IFlashTransferGetClusteringDetailCallback iFlashTransferGetClusteringDetailCallback);

        private native void native_getFileSetClusteringList(long j3, MediaClusteringListReq mediaClusteringListReq);

        private native void native_getFileSetFirstClusteringList(long j3, int i3, String str, FlashTransferSceneType flashTransferSceneType, IFlashTransferGetFirstClusteringListCallback iFlashTransferGetFirstClusteringListCallback);

        private native void native_getFileSetIdByCode(long j3, String str, IFlashTransferServiceGetFileSetIdByCodeCallback iFlashTransferServiceGetFileSetIdByCodeCallback);

        private native void native_getFileSetList(long j3, GetFileSetListReq getFileSetListReq, IFlashTransferServiceGetFileSetListCallback iFlashTransferServiceGetFileSetListCallback);

        private native void native_getFilesTransferProgress(long j3, GetFilesTransferProgressReq getFilesTransferProgressReq, IFlashTransferGetFilesTransferProgressCallback iFlashTransferGetFilesTransferProgressCallback);

        private native void native_getLocalFileList(long j3, int i3, String str, ArrayList<String> arrayList, IFlashTransferServiceGetLocalFileListCallback iFlashTransferServiceGetLocalFileListCallback);

        private native void native_getLocalFileListByStatuses(long j3, GetLocalFileListByStatusesReq getLocalFileListByStatusesReq, IFlashTransferGetLocalFileListByStatusesCallback iFlashTransferGetLocalFileListByStatusesCallback);

        private native void native_getShareLinkReq(long j3, String str, IFlashTransferServiceGetShareLinkCallback iFlashTransferServiceGetShareLinkCallback);

        private native void native_onSystemGoingToSleep(long j3);

        private native void native_onSystemWokeUp(long j3);

        private native void native_pauseAllTasks(long j3, FlashTransferPauseReason flashTransferPauseReason, FlashTransferPauseTaskType flashTransferPauseTaskType);

        private native void native_pauseFileListDownLoad(long j3, String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_pauseFileSetDownload(long j3, String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_pauseFileSetUpload(long j3, String str);

        private native void native_pauseFileUpload(long j3, String str);

        private native void native_pollFilesTransferProgress(long j3, GetFilesTransferProgressReq getFilesTransferProgressReq);

        private native void native_removeCompressedFileListener(long j3, IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener);

        private native void native_removeDesktopFileSetSimpleStatusListener(long j3, IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener);

        private native void native_removeDesktopFileSetSimpleStatusMonitoring(long j3, ArrayList<String> arrayList);

        private native void native_removeDeviceStatusListener(long j3, IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener);

        private native void native_removeFileSetClusteringListListener(long j3, IFlashTransferClusteringListListener iFlashTransferClusteringListListener);

        private native void native_removeFileSetDownloadListener(long j3, IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener);

        private native void native_removeFileSetSimpleStatusListener(long j3, String str);

        private native void native_removeFileSetSimpleStatusMonitoring(long j3, String str, ArrayList<String> arrayList);

        private native void native_removeFileSetSimpleUploadInfoListener(long j3, IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener);

        private native void native_removeFileSetSimpleUploadInfoMonitoring(long j3, ArrayList<String> arrayList);

        private native void native_removeFileSetUploadListener(long j3, IFlashTransferUploadListener iFlashTransferUploadListener);

        private native void native_removeFlashTransferTaskInfoListener(long j3, IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener);

        private native void native_removeFolderListener(long j3, IFlashTransferFolderListener iFlashTransferFolderListener);

        private native void native_resumeAllUnfinishedTasks(long j3);

        private native void native_resumeFileListDownLoad(long j3, String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_resumeFileSetDownload(long j3, String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_resumeFileSetUpload(long j3, String str);

        private native void native_resumeFileUpload(long j3, String str, String str2);

        private native void native_resumePausedTasksAfterDeviceStatus(long j3, ResumePausedTasksAfterDeviceStatusReq resumePausedTasksAfterDeviceStatusReq, IFlashTransferResumePausedTasksAfterDeviceStatusCallback iFlashTransferResumePausedTasksAfterDeviceStatusCallback);

        private native void native_retrieveLocalLastFailedSetTasksInfo(long j3, IFlashTransferServiceGetLastFailedSetTasksCallback iFlashTransferServiceGetLastFailedSetTasksCallback);

        private native void native_sendFlashTransferMsg(long j3, FlashTransferSendMsgReq flashTransferSendMsgReq, IFlashTransferSendMsgCallback iFlashTransferSendMsgCallback);

        private native void native_setDownLoadDefaultFileDir(long j3, String str, IFlashTransferSetDownLoadFileDirCallback iFlashTransferSetDownLoadFileDirCallback);

        private native void native_setFlashTransferDir(long j3, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_startFileListDownLoad(long j3, String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_startFileSetDownload(long j3, String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_startFileSetUpload(long j3, String str);

        private native void native_startFileTransferUrl(long j3, File file, IFlashTransferServiceFileTransferCallback iFlashTransferServiceFileTransferCallback);

        private native void native_startThumbnailListDownload(long j3, ArrayList<FlashTransferThumbnailInfo> arrayList, IFlashTransferThumbnailDownloadCallback iFlashTransferThumbnailDownloadCallback);

        private native void native_stopFileListDownLoad(long j3, String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_stopFileSetDownload(long j3, String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

        private native void native_stopFileSetUpload(long j3, String str);

        private native void native_stopFileUpload(long j3, String str);

        private native void native_stopThumbnailListDownload(long j3, ArrayList<FlashTransferThumbnailInfo> arrayList, IFlashTransferThumbnailDownloadCallback iFlashTransferThumbnailDownloadCallback);

        private native void native_updateFlashTransfer(long j3, int i3, UpdateFlashTransferParam updateFlashTransferParam, IFlashTransferServiceUpdateFlashTransferCallback iFlashTransferServiceUpdateFlashTransferCallback);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addCompressedFileListener(IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener) {
            native_addCompressedFileListener(this.nativeRef, iFlashTransferCompressedFileListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addDesktopFileSetSimpleStatusListener(IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener) {
            native_addDesktopFileSetSimpleStatusListener(this.nativeRef, iFlashTransferFileSetStatusListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addDesktopFileSetSimpleStatusMonitoring(ArrayList<String> arrayList) {
            native_addDesktopFileSetSimpleStatusMonitoring(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addDeviceStatusListener(IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener) {
            native_addDeviceStatusListener(this.nativeRef, iFlashTransferServiceDeviceStatusListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetClusteringListListener(IFlashTransferClusteringListListener iFlashTransferClusteringListListener) {
            native_addFileSetClusteringListListener(this.nativeRef, iFlashTransferClusteringListListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetDownloadListener(IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener) {
            native_addFileSetDownloadListener(this.nativeRef, iFlashTransferServiceDownloadListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetSimpleStatusListener(String str, IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener) {
            native_addFileSetSimpleStatusListener(this.nativeRef, str, iFlashTransferFileSetStatusListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetSimpleStatusMonitoring(String str, ArrayList<String> arrayList) {
            native_addFileSetSimpleStatusMonitoring(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetSimpleUploadInfoListener(IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener) {
            native_addFileSetSimpleUploadInfoListener(this.nativeRef, iFlashTransferFileSetSimpleUploadListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetSimpleUploadInfoMonitoring(ArrayList<String> arrayList) {
            native_addFileSetSimpleUploadInfoMonitoring(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFileSetUploadListener(IFlashTransferUploadListener iFlashTransferUploadListener) {
            native_addFileSetUploadListener(this.nativeRef, iFlashTransferUploadListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFlashTransferTaskInfoListener(IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener) {
            native_addFlashTransferTaskInfoListener(this.nativeRef, iFlashTransferTaskInfoListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void addFolderListener(IFlashTransferFolderListener iFlashTransferFolderListener) {
            native_addFolderListener(this.nativeRef, iFlashTransferFolderListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void asyncGetThumbnailPath(String str, ArrayList<String> arrayList) {
            native_asyncGetThumbnailPath(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void asyncRequestDownLoadStatus(String str, IFlashTransferGetFileSetDownloadStatusCallback iFlashTransferGetFileSetDownloadStatusCallback) {
            native_asyncRequestDownLoadStatus(this.nativeRef, str, iFlashTransferGetFileSetDownloadStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void batchRemoveFile(BatchRemoveFileReq batchRemoveFileReq, IFlashTransferServiceBatchRemoveFileCallback iFlashTransferServiceBatchRemoveFileCallback) {
            native_batchRemoveFile(this.nativeRef, batchRemoveFileReq, iFlashTransferServiceBatchRemoveFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void cancelPollFilesTransferProgress(CancelFilesTransferProgressReq cancelFilesTransferProgressReq) {
            native_cancelPollFilesTransferProgress(this.nativeRef, cancelFilesTransferProgressReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void checkDeviceStatus(CheckDeviceStatusReq checkDeviceStatusReq, IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback) {
            native_checkDeviceStatus(this.nativeRef, checkDeviceStatusReq, iFlashTransferCheckDeviceStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void checkDownloadStatusBeforeLocalFileOper(int i3, String str, String str2, IFlashTransferCheckDownloadStatusCallback iFlashTransferCheckDownloadStatusCallback) {
            native_checkDownloadStatusBeforeLocalFileOper(this.nativeRef, i3, str, str2, iFlashTransferCheckDownloadStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void cleanFailedFiles(int i3, ArrayList<File> arrayList, IFlashTransferCleanFailedFilesCallback iFlashTransferCleanFailedFilesCallback) {
            native_cleanFailedFiles(this.nativeRef, i3, arrayList, iFlashTransferCleanFailedFilesCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void createFlashTransferUploadTask(int i3, CreateFlashTransferParam createFlashTransferParam, IFlashTransferServiceCreateFileSetCallback iFlashTransferServiceCreateFileSetCallback) {
            native_createFlashTransferUploadTask(this.nativeRef, i3, createFlashTransferParam, iFlashTransferServiceCreateFileSetCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void doAIOFlashTransferBubbleActionWithStatus(String str, int i3, IOperateCallback iOperateCallback) {
            native_doAIOFlashTransferBubbleActionWithStatus(this.nativeRef, str, i3, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getCompressedFileFolder(GetCompressedFileFolderReq getCompressedFileFolderReq, IFlashTransferServiceGetCompressedFileFolderCallback iFlashTransferServiceGetCompressedFileFolderCallback) {
            native_getCompressedFileFolder(this.nativeRef, getCompressedFileFolderReq, iFlashTransferServiceGetCompressedFileFolderCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getDownloadedFileCount(GetDownloadedFileCountReq getDownloadedFileCountReq, IFlashTransferServiceGetDownloadedFileCountCallback iFlashTransferServiceGetDownloadedFileCountCallback) {
            native_getDownloadedFileCount(this.nativeRef, getDownloadedFileCountReq, iFlashTransferServiceGetDownloadedFileCountCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFailedFileList(GetFailedFileListReq getFailedFileListReq, IFlashTransferGetFailedFileListCallback iFlashTransferGetFailedFileListCallback) {
            native_getFailedFileList(this.nativeRef, getFailedFileListReq, iFlashTransferGetFailedFileListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileCategoryList(GetFileCategoryReq getFileCategoryReq, IFlashTransferGetFileCategoryCallback iFlashTransferGetFileCategoryCallback) {
            native_getFileCategoryList(this.nativeRef, getFileCategoryReq, iFlashTransferGetFileCategoryCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileList(GetFileListReq getFileListReq, IFlashTransferServiceGetFileListCallback iFlashTransferServiceGetFileListCallback) {
            native_getFileList(this.nativeRef, getFileListReq, iFlashTransferServiceGetFileListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileSet(GetFileSetReq getFileSetReq, IFlashTransferServiceGetFileSetCallback iFlashTransferServiceGetFileSetCallback) {
            native_getFileSet(this.nativeRef, getFileSetReq, iFlashTransferServiceGetFileSetCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileSetClusteringDetail(MediaClusteringDetailReq mediaClusteringDetailReq, IFlashTransferGetClusteringDetailCallback iFlashTransferGetClusteringDetailCallback) {
            native_getFileSetClusteringDetail(this.nativeRef, mediaClusteringDetailReq, iFlashTransferGetClusteringDetailCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileSetClusteringList(MediaClusteringListReq mediaClusteringListReq) {
            native_getFileSetClusteringList(this.nativeRef, mediaClusteringListReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileSetFirstClusteringList(int i3, String str, FlashTransferSceneType flashTransferSceneType, IFlashTransferGetFirstClusteringListCallback iFlashTransferGetFirstClusteringListCallback) {
            native_getFileSetFirstClusteringList(this.nativeRef, i3, str, flashTransferSceneType, iFlashTransferGetFirstClusteringListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileSetIdByCode(String str, IFlashTransferServiceGetFileSetIdByCodeCallback iFlashTransferServiceGetFileSetIdByCodeCallback) {
            native_getFileSetIdByCode(this.nativeRef, str, iFlashTransferServiceGetFileSetIdByCodeCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFileSetList(GetFileSetListReq getFileSetListReq, IFlashTransferServiceGetFileSetListCallback iFlashTransferServiceGetFileSetListCallback) {
            native_getFileSetList(this.nativeRef, getFileSetListReq, iFlashTransferServiceGetFileSetListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getFilesTransferProgress(GetFilesTransferProgressReq getFilesTransferProgressReq, IFlashTransferGetFilesTransferProgressCallback iFlashTransferGetFilesTransferProgressCallback) {
            native_getFilesTransferProgress(this.nativeRef, getFilesTransferProgressReq, iFlashTransferGetFilesTransferProgressCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getLocalFileList(int i3, String str, ArrayList<String> arrayList, IFlashTransferServiceGetLocalFileListCallback iFlashTransferServiceGetLocalFileListCallback) {
            native_getLocalFileList(this.nativeRef, i3, str, arrayList, iFlashTransferServiceGetLocalFileListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getLocalFileListByStatuses(GetLocalFileListByStatusesReq getLocalFileListByStatusesReq, IFlashTransferGetLocalFileListByStatusesCallback iFlashTransferGetLocalFileListByStatusesCallback) {
            native_getLocalFileListByStatuses(this.nativeRef, getLocalFileListByStatusesReq, iFlashTransferGetLocalFileListByStatusesCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void getShareLinkReq(String str, IFlashTransferServiceGetShareLinkCallback iFlashTransferServiceGetShareLinkCallback) {
            native_getShareLinkReq(this.nativeRef, str, iFlashTransferServiceGetShareLinkCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void onSystemGoingToSleep() {
            native_onSystemGoingToSleep(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void onSystemWokeUp() {
            native_onSystemWokeUp(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void pauseAllTasks(FlashTransferPauseReason flashTransferPauseReason, FlashTransferPauseTaskType flashTransferPauseTaskType) {
            native_pauseAllTasks(this.nativeRef, flashTransferPauseReason, flashTransferPauseTaskType);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void pauseFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_pauseFileListDownLoad(this.nativeRef, str, arrayList, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void pauseFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_pauseFileSetDownload(this.nativeRef, str, downloadOptionParams, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void pauseFileSetUpload(String str) {
            native_pauseFileSetUpload(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void pauseFileUpload(String str) {
            native_pauseFileUpload(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void pollFilesTransferProgress(GetFilesTransferProgressReq getFilesTransferProgressReq) {
            native_pollFilesTransferProgress(this.nativeRef, getFilesTransferProgressReq);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeCompressedFileListener(IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener) {
            native_removeCompressedFileListener(this.nativeRef, iFlashTransferCompressedFileListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeDesktopFileSetSimpleStatusListener(IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener) {
            native_removeDesktopFileSetSimpleStatusListener(this.nativeRef, iFlashTransferFileSetStatusListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeDesktopFileSetSimpleStatusMonitoring(ArrayList<String> arrayList) {
            native_removeDesktopFileSetSimpleStatusMonitoring(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeDeviceStatusListener(IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener) {
            native_removeDeviceStatusListener(this.nativeRef, iFlashTransferServiceDeviceStatusListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetClusteringListListener(IFlashTransferClusteringListListener iFlashTransferClusteringListListener) {
            native_removeFileSetClusteringListListener(this.nativeRef, iFlashTransferClusteringListListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetDownloadListener(IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener) {
            native_removeFileSetDownloadListener(this.nativeRef, iFlashTransferServiceDownloadListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetSimpleStatusListener(String str) {
            native_removeFileSetSimpleStatusListener(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetSimpleStatusMonitoring(String str, ArrayList<String> arrayList) {
            native_removeFileSetSimpleStatusMonitoring(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetSimpleUploadInfoListener(IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener) {
            native_removeFileSetSimpleUploadInfoListener(this.nativeRef, iFlashTransferFileSetSimpleUploadListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetSimpleUploadInfoMonitoring(ArrayList<String> arrayList) {
            native_removeFileSetSimpleUploadInfoMonitoring(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFileSetUploadListener(IFlashTransferUploadListener iFlashTransferUploadListener) {
            native_removeFileSetUploadListener(this.nativeRef, iFlashTransferUploadListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFlashTransferTaskInfoListener(IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener) {
            native_removeFlashTransferTaskInfoListener(this.nativeRef, iFlashTransferTaskInfoListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void removeFolderListener(IFlashTransferFolderListener iFlashTransferFolderListener) {
            native_removeFolderListener(this.nativeRef, iFlashTransferFolderListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void resumeAllUnfinishedTasks() {
            native_resumeAllUnfinishedTasks(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void resumeFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_resumeFileListDownLoad(this.nativeRef, str, arrayList, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void resumeFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_resumeFileSetDownload(this.nativeRef, str, downloadOptionParams, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void resumeFileSetUpload(String str) {
            native_resumeFileSetUpload(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void resumeFileUpload(String str, String str2) {
            native_resumeFileUpload(this.nativeRef, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void resumePausedTasksAfterDeviceStatus(ResumePausedTasksAfterDeviceStatusReq resumePausedTasksAfterDeviceStatusReq, IFlashTransferResumePausedTasksAfterDeviceStatusCallback iFlashTransferResumePausedTasksAfterDeviceStatusCallback) {
            native_resumePausedTasksAfterDeviceStatus(this.nativeRef, resumePausedTasksAfterDeviceStatusReq, iFlashTransferResumePausedTasksAfterDeviceStatusCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void retrieveLocalLastFailedSetTasksInfo(IFlashTransferServiceGetLastFailedSetTasksCallback iFlashTransferServiceGetLastFailedSetTasksCallback) {
            native_retrieveLocalLastFailedSetTasksInfo(this.nativeRef, iFlashTransferServiceGetLastFailedSetTasksCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void sendFlashTransferMsg(FlashTransferSendMsgReq flashTransferSendMsgReq, IFlashTransferSendMsgCallback iFlashTransferSendMsgCallback) {
            native_sendFlashTransferMsg(this.nativeRef, flashTransferSendMsgReq, iFlashTransferSendMsgCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void setDownLoadDefaultFileDir(String str, IFlashTransferSetDownLoadFileDirCallback iFlashTransferSetDownLoadFileDirCallback) {
            native_setDownLoadDefaultFileDir(this.nativeRef, str, iFlashTransferSetDownLoadFileDirCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void setFlashTransferDir(String str, String str2, IOperateCallback iOperateCallback) {
            native_setFlashTransferDir(this.nativeRef, str, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void startFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_startFileListDownLoad(this.nativeRef, str, arrayList, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void startFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_startFileSetDownload(this.nativeRef, str, downloadOptionParams, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void startFileSetUpload(String str) {
            native_startFileSetUpload(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void startFileTransferUrl(File file, IFlashTransferServiceFileTransferCallback iFlashTransferServiceFileTransferCallback) {
            native_startFileTransferUrl(this.nativeRef, file, iFlashTransferServiceFileTransferCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void startThumbnailListDownload(ArrayList<FlashTransferThumbnailInfo> arrayList, IFlashTransferThumbnailDownloadCallback iFlashTransferThumbnailDownloadCallback) {
            native_startThumbnailListDownload(this.nativeRef, arrayList, iFlashTransferThumbnailDownloadCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void stopFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_stopFileListDownLoad(this.nativeRef, str, arrayList, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void stopFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback) {
            native_stopFileSetDownload(this.nativeRef, str, downloadOptionParams, iFlashTransferDownloadOperationCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void stopFileSetUpload(String str) {
            native_stopFileSetUpload(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void stopFileUpload(String str) {
            native_stopFileUpload(this.nativeRef, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void stopThumbnailListDownload(ArrayList<FlashTransferThumbnailInfo> arrayList, IFlashTransferThumbnailDownloadCallback iFlashTransferThumbnailDownloadCallback) {
            native_stopThumbnailListDownload(this.nativeRef, arrayList, iFlashTransferThumbnailDownloadCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelFlashTransferService
        public void updateFlashTransfer(int i3, UpdateFlashTransferParam updateFlashTransferParam, IFlashTransferServiceUpdateFlashTransferCallback iFlashTransferServiceUpdateFlashTransferCallback) {
            native_updateFlashTransfer(this.nativeRef, i3, updateFlashTransferParam, iFlashTransferServiceUpdateFlashTransferCallback);
        }
    }

    void addCompressedFileListener(IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener);

    void addDesktopFileSetSimpleStatusListener(IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener);

    void addDesktopFileSetSimpleStatusMonitoring(ArrayList<String> arrayList);

    void addDeviceStatusListener(IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener);

    void addFileSetClusteringListListener(IFlashTransferClusteringListListener iFlashTransferClusteringListListener);

    void addFileSetDownloadListener(IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener);

    void addFileSetSimpleStatusListener(String str, IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener);

    void addFileSetSimpleStatusMonitoring(String str, ArrayList<String> arrayList);

    void addFileSetSimpleUploadInfoListener(IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener);

    void addFileSetSimpleUploadInfoMonitoring(ArrayList<String> arrayList);

    void addFileSetUploadListener(IFlashTransferUploadListener iFlashTransferUploadListener);

    void addFlashTransferTaskInfoListener(IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener);

    void addFolderListener(IFlashTransferFolderListener iFlashTransferFolderListener);

    void asyncGetThumbnailPath(String str, ArrayList<String> arrayList);

    void asyncRequestDownLoadStatus(String str, IFlashTransferGetFileSetDownloadStatusCallback iFlashTransferGetFileSetDownloadStatusCallback);

    void batchRemoveFile(BatchRemoveFileReq batchRemoveFileReq, IFlashTransferServiceBatchRemoveFileCallback iFlashTransferServiceBatchRemoveFileCallback);

    void cancelPollFilesTransferProgress(CancelFilesTransferProgressReq cancelFilesTransferProgressReq);

    void checkDeviceStatus(CheckDeviceStatusReq checkDeviceStatusReq, IFlashTransferCheckDeviceStatusCallback iFlashTransferCheckDeviceStatusCallback);

    void checkDownloadStatusBeforeLocalFileOper(int i3, String str, String str2, IFlashTransferCheckDownloadStatusCallback iFlashTransferCheckDownloadStatusCallback);

    void cleanFailedFiles(int i3, ArrayList<File> arrayList, IFlashTransferCleanFailedFilesCallback iFlashTransferCleanFailedFilesCallback);

    void createFlashTransferUploadTask(int i3, CreateFlashTransferParam createFlashTransferParam, IFlashTransferServiceCreateFileSetCallback iFlashTransferServiceCreateFileSetCallback);

    void doAIOFlashTransferBubbleActionWithStatus(String str, int i3, IOperateCallback iOperateCallback);

    void getCompressedFileFolder(GetCompressedFileFolderReq getCompressedFileFolderReq, IFlashTransferServiceGetCompressedFileFolderCallback iFlashTransferServiceGetCompressedFileFolderCallback);

    void getDownloadedFileCount(GetDownloadedFileCountReq getDownloadedFileCountReq, IFlashTransferServiceGetDownloadedFileCountCallback iFlashTransferServiceGetDownloadedFileCountCallback);

    void getFailedFileList(GetFailedFileListReq getFailedFileListReq, IFlashTransferGetFailedFileListCallback iFlashTransferGetFailedFileListCallback);

    void getFileCategoryList(GetFileCategoryReq getFileCategoryReq, IFlashTransferGetFileCategoryCallback iFlashTransferGetFileCategoryCallback);

    void getFileList(GetFileListReq getFileListReq, IFlashTransferServiceGetFileListCallback iFlashTransferServiceGetFileListCallback);

    void getFileSet(GetFileSetReq getFileSetReq, IFlashTransferServiceGetFileSetCallback iFlashTransferServiceGetFileSetCallback);

    void getFileSetClusteringDetail(MediaClusteringDetailReq mediaClusteringDetailReq, IFlashTransferGetClusteringDetailCallback iFlashTransferGetClusteringDetailCallback);

    void getFileSetClusteringList(MediaClusteringListReq mediaClusteringListReq);

    void getFileSetFirstClusteringList(int i3, String str, FlashTransferSceneType flashTransferSceneType, IFlashTransferGetFirstClusteringListCallback iFlashTransferGetFirstClusteringListCallback);

    void getFileSetIdByCode(String str, IFlashTransferServiceGetFileSetIdByCodeCallback iFlashTransferServiceGetFileSetIdByCodeCallback);

    void getFileSetList(GetFileSetListReq getFileSetListReq, IFlashTransferServiceGetFileSetListCallback iFlashTransferServiceGetFileSetListCallback);

    void getFilesTransferProgress(GetFilesTransferProgressReq getFilesTransferProgressReq, IFlashTransferGetFilesTransferProgressCallback iFlashTransferGetFilesTransferProgressCallback);

    void getLocalFileList(int i3, String str, ArrayList<String> arrayList, IFlashTransferServiceGetLocalFileListCallback iFlashTransferServiceGetLocalFileListCallback);

    void getLocalFileListByStatuses(GetLocalFileListByStatusesReq getLocalFileListByStatusesReq, IFlashTransferGetLocalFileListByStatusesCallback iFlashTransferGetLocalFileListByStatusesCallback);

    void getShareLinkReq(String str, IFlashTransferServiceGetShareLinkCallback iFlashTransferServiceGetShareLinkCallback);

    void onSystemGoingToSleep();

    void onSystemWokeUp();

    void pauseAllTasks(FlashTransferPauseReason flashTransferPauseReason, FlashTransferPauseTaskType flashTransferPauseTaskType);

    void pauseFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void pauseFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void pauseFileSetUpload(String str);

    void pauseFileUpload(String str);

    void pollFilesTransferProgress(GetFilesTransferProgressReq getFilesTransferProgressReq);

    void removeCompressedFileListener(IFlashTransferCompressedFileListener iFlashTransferCompressedFileListener);

    void removeDesktopFileSetSimpleStatusListener(IFlashTransferFileSetStatusListener iFlashTransferFileSetStatusListener);

    void removeDesktopFileSetSimpleStatusMonitoring(ArrayList<String> arrayList);

    void removeDeviceStatusListener(IFlashTransferServiceDeviceStatusListener iFlashTransferServiceDeviceStatusListener);

    void removeFileSetClusteringListListener(IFlashTransferClusteringListListener iFlashTransferClusteringListListener);

    void removeFileSetDownloadListener(IFlashTransferServiceDownloadListener iFlashTransferServiceDownloadListener);

    void removeFileSetSimpleStatusListener(String str);

    void removeFileSetSimpleStatusMonitoring(String str, ArrayList<String> arrayList);

    void removeFileSetSimpleUploadInfoListener(IFlashTransferFileSetSimpleUploadListener iFlashTransferFileSetSimpleUploadListener);

    void removeFileSetSimpleUploadInfoMonitoring(ArrayList<String> arrayList);

    void removeFileSetUploadListener(IFlashTransferUploadListener iFlashTransferUploadListener);

    void removeFlashTransferTaskInfoListener(IFlashTransferTaskInfoListener iFlashTransferTaskInfoListener);

    void removeFolderListener(IFlashTransferFolderListener iFlashTransferFolderListener);

    void resumeAllUnfinishedTasks();

    void resumeFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void resumeFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void resumeFileSetUpload(String str);

    void resumeFileUpload(String str, String str2);

    void resumePausedTasksAfterDeviceStatus(ResumePausedTasksAfterDeviceStatusReq resumePausedTasksAfterDeviceStatusReq, IFlashTransferResumePausedTasksAfterDeviceStatusCallback iFlashTransferResumePausedTasksAfterDeviceStatusCallback);

    void retrieveLocalLastFailedSetTasksInfo(IFlashTransferServiceGetLastFailedSetTasksCallback iFlashTransferServiceGetLastFailedSetTasksCallback);

    void sendFlashTransferMsg(FlashTransferSendMsgReq flashTransferSendMsgReq, IFlashTransferSendMsgCallback iFlashTransferSendMsgCallback);

    void setDownLoadDefaultFileDir(String str, IFlashTransferSetDownLoadFileDirCallback iFlashTransferSetDownLoadFileDirCallback);

    void setFlashTransferDir(String str, String str2, IOperateCallback iOperateCallback);

    void startFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void startFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void startFileSetUpload(String str);

    void startFileTransferUrl(File file, IFlashTransferServiceFileTransferCallback iFlashTransferServiceFileTransferCallback);

    void startThumbnailListDownload(ArrayList<FlashTransferThumbnailInfo> arrayList, IFlashTransferThumbnailDownloadCallback iFlashTransferThumbnailDownloadCallback);

    void stopFileListDownLoad(String str, ArrayList<File> arrayList, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void stopFileSetDownload(String str, DownloadOptionParams downloadOptionParams, IFlashTransferDownloadOperationCallback iFlashTransferDownloadOperationCallback);

    void stopFileSetUpload(String str);

    void stopFileUpload(String str);

    void stopThumbnailListDownload(ArrayList<FlashTransferThumbnailInfo> arrayList, IFlashTransferThumbnailDownloadCallback iFlashTransferThumbnailDownloadCallback);

    void updateFlashTransfer(int i3, UpdateFlashTransferParam updateFlashTransferParam, IFlashTransferServiceUpdateFlashTransferCallback iFlashTransferServiceUpdateFlashTransferCallback);
}
