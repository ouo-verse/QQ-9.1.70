package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelRichMediaService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelRichMediaService {
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

        public static native boolean isExtraLargePic(long j3, long j16, long j17);

        public static native boolean isFileExpired(int i3);

        private native void nativeDestroy(long j3);

        private native void native_batchGetGroupFileCount(long j3, ArrayList<Long> arrayList, IBatchGroupFileCountCallback iBatchGroupFileCountCallback);

        private native void native_beaconReportRMData(long j3, RMBeaconReportInfo rMBeaconReportInfo);

        private native void native_cancelSearcheGroupFile(long j3, int i3, int i16, String str);

        private native void native_cancelTransferTask(long j3, Contact contact, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2, IOperateTransferInfoCallback iOperateTransferInfoCallback);

        private native void native_cancelUrlDownload(long j3, ArrayList<Long> arrayList);

        private native void native_createGroupFolder(long j3, long j16, String str, IGroupItemCallback iGroupItemCallback);

        private native void native_deleteGroupFile(long j3, long j16, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, IDeleteGroupFileCallback iDeleteGroupFileCallback);

        private native void native_deleteGroupFolder(long j3, long j16, String str, IGroupFileCommonResultCallback iGroupFileCommonResultCallback);

        private native void native_deleteTransferInfo(long j3, Contact contact, ArrayList<Long> arrayList, IOperateTransferInfoCallback iOperateTransferInfoCallback);

        private native void native_downloadFile(long j3, CommonFileInfo commonFileInfo, int i3, int i16, String str);

        private native void native_downloadFileByUrlList(long j3, UrlFileDownloadType urlFileDownloadType, ArrayList<String> arrayList, IOperateReturnU64ListCallback iOperateReturnU64ListCallback);

        private native void native_downloadFileForFileInfo(long j3, ArrayList<CommonFileInfo> arrayList, String str);

        private native void native_downloadFileForFileUuid(long j3, Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList);

        private native void native_downloadFileForModelId(long j3, Contact contact, ArrayList<Long> arrayList, String str, IDownloadFileCallback iDownloadFileCallback);

        private native void native_downloadGroupFolder(long j3, long j16, String str, String str2, IOperateCallback iOperateCallback);

        private native void native_downloadRichMediaInVisit(long j3, RichDownLoadReq richDownLoadReq);

        private native void native_getGroupFileInfo(long j3, long j16, String str, IGroupFileInfoCallback iGroupFileInfoCallback);

        private native int native_getGroupFileList(long j3, long j16, GroupFileListForm groupFileListForm);

        private native void native_getGroupSpace(long j3, long j16, IGroupSpaceCallback iGroupSpaceCallback);

        private native int native_getGroupTransferList(long j3, long j16, GroupFileListForm groupFileListForm);

        private native RMCodecInfo native_getRichMediaCodecInfo(long j3, RMBizTypeEnum rMBizTypeEnum);

        private native String native_getRichMediaFileDir(long j3, int i3, int i16, boolean z16);

        private native void native_getScreenOCR(long j3, String str, IWindowsOcrCallback iWindowsOcrCallback);

        private native void native_getVideoPlayUrl(long j3, Contact contact, long j16, long j17, VideoCodecFormatType videoCodecFormatType, VideoRequestWay videoRequestWay, IVideoPlayUrlCallback iVideoPlayUrlCallback);

        private native void native_getVideoPlayUrlInVisit(long j3, RichDownLoadReq richDownLoadReq, IVideoPlayUrlCallback iVideoPlayUrlCallback);

        private native void native_getVideoPlayUrlV2(long j3, Contact contact, long j16, long j17, VideoCodecFormatType videoCodecFormatType, RMReqExParams rMReqExParams, IVideoPlayUrlCallback iVideoPlayUrlCallback);

        private native void native_moveGroupFile(long j3, long j16, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, String str, String str2, IMoveGroupFileCallback iMoveGroupFileCallback);

        private native void native_onlyDownloadFile(long j3, Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList);

        private native void native_onlyUploadFile(long j3, Contact contact, ArrayList<UploadGroupFileParams> arrayList);

        private native PicDownParams native_queryPicDownloadSize(long j3, PicReqParams picReqParams);

        private native void native_renameGroupFile(long j3, long j16, int i3, String str, String str2, String str3, IRenameGroupFileCallback iRenameGroupFileCallback);

        private native void native_renameGroupFolder(long j3, long j16, String str, String str2, IGroupItemCallback iGroupItemCallback);

        private native int native_searchGroupFile(long j3, ArrayList<String> arrayList, SearchGroupFileParams searchGroupFileParams, IOperateCallback iOperateCallback);

        private native void native_searchGroupFileByWord(long j3, ArrayList<Long> arrayList, ArrayList<Long> arrayList2, String str, String str2, int i3, ISearchGroupFileCallback iSearchGroupFileCallback);

        private native void native_searchMoreGroupFile(long j3, int i3);

        private native void native_transGroupFile(long j3, long j16, String str, ITransGroupFileCallback iTransGroupFileCallback);

        private native void native_translateEnWordToZn(long j3, ArrayList<String> arrayList, ITranslateWordsCallback iTranslateWordsCallback);

        private native void native_updateOnlineVideoElemStatus(long j3, UploadStatusParams uploadStatusParams);

        private native void native_uploadRMFileWithoutMsg(long j3, UploadFileWithoutMsgParams uploadFileWithoutMsgParams);

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void batchGetGroupFileCount(ArrayList<Long> arrayList, IBatchGroupFileCountCallback iBatchGroupFileCountCallback) {
            native_batchGetGroupFileCount(this.nativeRef, arrayList, iBatchGroupFileCountCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void beaconReportRMData(RMBeaconReportInfo rMBeaconReportInfo) {
            native_beaconReportRMData(this.nativeRef, rMBeaconReportInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void cancelSearcheGroupFile(int i3, int i16, String str) {
            native_cancelSearcheGroupFile(this.nativeRef, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void cancelTransferTask(Contact contact, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2, IOperateTransferInfoCallback iOperateTransferInfoCallback) {
            native_cancelTransferTask(this.nativeRef, contact, arrayList, arrayList2, iOperateTransferInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void cancelUrlDownload(ArrayList<Long> arrayList) {
            native_cancelUrlDownload(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void createGroupFolder(long j3, String str, IGroupItemCallback iGroupItemCallback) {
            native_createGroupFolder(this.nativeRef, j3, str, iGroupItemCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void deleteGroupFile(long j3, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, IDeleteGroupFileCallback iDeleteGroupFileCallback) {
            native_deleteGroupFile(this.nativeRef, j3, arrayList, arrayList2, iDeleteGroupFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void deleteGroupFolder(long j3, String str, IGroupFileCommonResultCallback iGroupFileCommonResultCallback) {
            native_deleteGroupFolder(this.nativeRef, j3, str, iGroupFileCommonResultCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void deleteTransferInfo(Contact contact, ArrayList<Long> arrayList, IOperateTransferInfoCallback iOperateTransferInfoCallback) {
            native_deleteTransferInfo(this.nativeRef, contact, arrayList, iOperateTransferInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadFile(CommonFileInfo commonFileInfo, int i3, int i16, String str) {
            native_downloadFile(this.nativeRef, commonFileInfo, i3, i16, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadFileByUrlList(UrlFileDownloadType urlFileDownloadType, ArrayList<String> arrayList, IOperateReturnU64ListCallback iOperateReturnU64ListCallback) {
            native_downloadFileByUrlList(this.nativeRef, urlFileDownloadType, arrayList, iOperateReturnU64ListCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadFileForFileInfo(ArrayList<CommonFileInfo> arrayList, String str) {
            native_downloadFileForFileInfo(this.nativeRef, arrayList, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadFileForFileUuid(Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList) {
            native_downloadFileForFileUuid(this.nativeRef, contact, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadFileForModelId(Contact contact, ArrayList<Long> arrayList, String str, IDownloadFileCallback iDownloadFileCallback) {
            native_downloadFileForModelId(this.nativeRef, contact, arrayList, str, iDownloadFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadGroupFolder(long j3, String str, String str2, IOperateCallback iOperateCallback) {
            native_downloadGroupFolder(this.nativeRef, j3, str, str2, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void downloadRichMediaInVisit(RichDownLoadReq richDownLoadReq) {
            native_downloadRichMediaInVisit(this.nativeRef, richDownLoadReq);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void getGroupFileInfo(long j3, String str, IGroupFileInfoCallback iGroupFileInfoCallback) {
            native_getGroupFileInfo(this.nativeRef, j3, str, iGroupFileInfoCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public int getGroupFileList(long j3, GroupFileListForm groupFileListForm) {
            return native_getGroupFileList(this.nativeRef, j3, groupFileListForm);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void getGroupSpace(long j3, IGroupSpaceCallback iGroupSpaceCallback) {
            native_getGroupSpace(this.nativeRef, j3, iGroupSpaceCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public int getGroupTransferList(long j3, GroupFileListForm groupFileListForm) {
            return native_getGroupTransferList(this.nativeRef, j3, groupFileListForm);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public RMCodecInfo getRichMediaCodecInfo(RMBizTypeEnum rMBizTypeEnum) {
            return native_getRichMediaCodecInfo(this.nativeRef, rMBizTypeEnum);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public String getRichMediaFileDir(int i3, int i16, boolean z16) {
            return native_getRichMediaFileDir(this.nativeRef, i3, i16, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void getScreenOCR(String str, IWindowsOcrCallback iWindowsOcrCallback) {
            native_getScreenOCR(this.nativeRef, str, iWindowsOcrCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void getVideoPlayUrl(Contact contact, long j3, long j16, VideoCodecFormatType videoCodecFormatType, VideoRequestWay videoRequestWay, IVideoPlayUrlCallback iVideoPlayUrlCallback) {
            native_getVideoPlayUrl(this.nativeRef, contact, j3, j16, videoCodecFormatType, videoRequestWay, iVideoPlayUrlCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void getVideoPlayUrlInVisit(RichDownLoadReq richDownLoadReq, IVideoPlayUrlCallback iVideoPlayUrlCallback) {
            native_getVideoPlayUrlInVisit(this.nativeRef, richDownLoadReq, iVideoPlayUrlCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void getVideoPlayUrlV2(Contact contact, long j3, long j16, VideoCodecFormatType videoCodecFormatType, RMReqExParams rMReqExParams, IVideoPlayUrlCallback iVideoPlayUrlCallback) {
            native_getVideoPlayUrlV2(this.nativeRef, contact, j3, j16, videoCodecFormatType, rMReqExParams, iVideoPlayUrlCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void moveGroupFile(long j3, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, String str, String str2, IMoveGroupFileCallback iMoveGroupFileCallback) {
            native_moveGroupFile(this.nativeRef, j3, arrayList, arrayList2, str, str2, iMoveGroupFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void onlyDownloadFile(Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList) {
            native_onlyDownloadFile(this.nativeRef, contact, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void onlyUploadFile(Contact contact, ArrayList<UploadGroupFileParams> arrayList) {
            native_onlyUploadFile(this.nativeRef, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public PicDownParams queryPicDownloadSize(PicReqParams picReqParams) {
            return native_queryPicDownloadSize(this.nativeRef, picReqParams);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void renameGroupFile(long j3, int i3, String str, String str2, String str3, IRenameGroupFileCallback iRenameGroupFileCallback) {
            native_renameGroupFile(this.nativeRef, j3, i3, str, str2, str3, iRenameGroupFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void renameGroupFolder(long j3, String str, String str2, IGroupItemCallback iGroupItemCallback) {
            native_renameGroupFolder(this.nativeRef, j3, str, str2, iGroupItemCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public int searchGroupFile(ArrayList<String> arrayList, SearchGroupFileParams searchGroupFileParams, IOperateCallback iOperateCallback) {
            return native_searchGroupFile(this.nativeRef, arrayList, searchGroupFileParams, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void searchGroupFileByWord(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, String str, String str2, int i3, ISearchGroupFileCallback iSearchGroupFileCallback) {
            native_searchGroupFileByWord(this.nativeRef, arrayList, arrayList2, str, str2, i3, iSearchGroupFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void searchMoreGroupFile(int i3) {
            native_searchMoreGroupFile(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void transGroupFile(long j3, String str, ITransGroupFileCallback iTransGroupFileCallback) {
            native_transGroupFile(this.nativeRef, j3, str, iTransGroupFileCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void translateEnWordToZn(ArrayList<String> arrayList, ITranslateWordsCallback iTranslateWordsCallback) {
            native_translateEnWordToZn(this.nativeRef, arrayList, iTranslateWordsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void updateOnlineVideoElemStatus(UploadStatusParams uploadStatusParams) {
            native_updateOnlineVideoElemStatus(this.nativeRef, uploadStatusParams);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRichMediaService
        public void uploadRMFileWithoutMsg(UploadFileWithoutMsgParams uploadFileWithoutMsgParams) {
            native_uploadRMFileWithoutMsg(this.nativeRef, uploadFileWithoutMsgParams);
        }
    }

    void batchGetGroupFileCount(ArrayList<Long> arrayList, IBatchGroupFileCountCallback iBatchGroupFileCountCallback);

    void beaconReportRMData(RMBeaconReportInfo rMBeaconReportInfo);

    void cancelSearcheGroupFile(int i3, int i16, String str);

    void cancelTransferTask(Contact contact, ArrayList<Long> arrayList, ArrayList<Integer> arrayList2, IOperateTransferInfoCallback iOperateTransferInfoCallback);

    void cancelUrlDownload(ArrayList<Long> arrayList);

    void createGroupFolder(long j3, String str, IGroupItemCallback iGroupItemCallback);

    void deleteGroupFile(long j3, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, IDeleteGroupFileCallback iDeleteGroupFileCallback);

    void deleteGroupFolder(long j3, String str, IGroupFileCommonResultCallback iGroupFileCommonResultCallback);

    void deleteTransferInfo(Contact contact, ArrayList<Long> arrayList, IOperateTransferInfoCallback iOperateTransferInfoCallback);

    void downloadFile(CommonFileInfo commonFileInfo, int i3, int i16, String str);

    void downloadFileByUrlList(UrlFileDownloadType urlFileDownloadType, ArrayList<String> arrayList, IOperateReturnU64ListCallback iOperateReturnU64ListCallback);

    void downloadFileForFileInfo(ArrayList<CommonFileInfo> arrayList, String str);

    void downloadFileForFileUuid(Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList);

    void downloadFileForModelId(Contact contact, ArrayList<Long> arrayList, String str, IDownloadFileCallback iDownloadFileCallback);

    void downloadGroupFolder(long j3, String str, String str2, IOperateCallback iOperateCallback);

    void downloadRichMediaInVisit(RichDownLoadReq richDownLoadReq);

    void getGroupFileInfo(long j3, String str, IGroupFileInfoCallback iGroupFileInfoCallback);

    int getGroupFileList(long j3, GroupFileListForm groupFileListForm);

    void getGroupSpace(long j3, IGroupSpaceCallback iGroupSpaceCallback);

    int getGroupTransferList(long j3, GroupFileListForm groupFileListForm);

    RMCodecInfo getRichMediaCodecInfo(RMBizTypeEnum rMBizTypeEnum);

    String getRichMediaFileDir(int i3, int i16, boolean z16);

    void getScreenOCR(String str, IWindowsOcrCallback iWindowsOcrCallback);

    void getVideoPlayUrl(Contact contact, long j3, long j16, VideoCodecFormatType videoCodecFormatType, VideoRequestWay videoRequestWay, IVideoPlayUrlCallback iVideoPlayUrlCallback);

    void getVideoPlayUrlInVisit(RichDownLoadReq richDownLoadReq, IVideoPlayUrlCallback iVideoPlayUrlCallback);

    void getVideoPlayUrlV2(Contact contact, long j3, long j16, VideoCodecFormatType videoCodecFormatType, RMReqExParams rMReqExParams, IVideoPlayUrlCallback iVideoPlayUrlCallback);

    void moveGroupFile(long j3, ArrayList<Integer> arrayList, ArrayList<String> arrayList2, String str, String str2, IMoveGroupFileCallback iMoveGroupFileCallback);

    void onlyDownloadFile(Contact contact, String str, ArrayList<DownloadGroupFileParams> arrayList);

    void onlyUploadFile(Contact contact, ArrayList<UploadGroupFileParams> arrayList);

    PicDownParams queryPicDownloadSize(PicReqParams picReqParams);

    void renameGroupFile(long j3, int i3, String str, String str2, String str3, IRenameGroupFileCallback iRenameGroupFileCallback);

    void renameGroupFolder(long j3, String str, String str2, IGroupItemCallback iGroupItemCallback);

    int searchGroupFile(ArrayList<String> arrayList, SearchGroupFileParams searchGroupFileParams, IOperateCallback iOperateCallback);

    void searchGroupFileByWord(ArrayList<Long> arrayList, ArrayList<Long> arrayList2, String str, String str2, int i3, ISearchGroupFileCallback iSearchGroupFileCallback);

    void searchMoreGroupFile(int i3);

    void transGroupFile(long j3, String str, ITransGroupFileCallback iTransGroupFileCallback);

    void translateEnWordToZn(ArrayList<String> arrayList, ITranslateWordsCallback iTranslateWordsCallback);

    void updateOnlineVideoElemStatus(UploadStatusParams uploadStatusParams);

    void uploadRMFileWithoutMsg(UploadFileWithoutMsgParams uploadFileWithoutMsgParams);
}
