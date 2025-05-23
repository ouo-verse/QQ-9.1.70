package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IFlashTransferUploadListener {
    void onFileDidFinishUpload(File file);

    void onFileDidStartUpload(File file);

    void onFileSetUploadProgressChanged(FileSetUploadProgressInfo fileSetUploadProgressInfo);

    void onFileSetUploadStatusChanged(FileSet fileSet);

    void onFileStaticStatusChanged(File file);

    void onFileUploadDidCancel(File file);

    void onFileUploadDidError(File file);

    void onFileUploadProgressChanged(File file, long j3, long j16);

    void onFileUploadStatusChanged(File file);

    void onThumbnailGeneratePath(FlashTransferUploadThumbnailInfo flashTransferUploadThumbnailInfo);
}
