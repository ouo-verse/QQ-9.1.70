package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IFlashTransferCompressedFileListener {
    void onCompressedFileDownloadStatusChange(File file, FileSetDownloadStatus fileSetDownloadStatus);

    void onCompressedFileSaveDirPathChange(File file, String str);
}
