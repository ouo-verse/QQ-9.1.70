package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IFlashTransferServiceDownloadListener {
    void onFileDidStartDownload(File file);

    void onFileDownloadDidError(File file, int i3, String str);

    void onFileDownloadProgressChanged(File file, long j3, long j16);

    void onFileDownloadSpeedChange(File file, int i3, int i16);

    void onFileListDidFinishDownload(ArrayList<File> arrayList);

    void onFileListDownloadDidCancel(ArrayList<File> arrayList);

    void onFileListDownloadDidError(ArrayList<File> arrayList);

    void onFileListDownloadDidPause(ArrayList<File> arrayList);

    void onFileListDownloadWaitDownloading(ArrayList<File> arrayList);

    void onFileSetDownloadTaskProgressChanged(String str, FlashFileSetDownloadInfo flashFileSetDownloadInfo);

    void onFileSetDownloadTaskStatusChange(FileSetDownloadTaskStatus fileSetDownloadTaskStatus, String str, FlashFileSetDownloadInfo flashFileSetDownloadInfo);

    void onProfilerFileDidStartDownload(String str, BasicFileInfo basicFileInfo);

    void onProfilerFileDownloadProgressChanged(String str, BasicFileInfo basicFileInfo, long j3, long j16);

    void onProfilerFileListDidFinishDownload(String str, ArrayList<DownloadFinishFileInfo> arrayList);

    void onProfilerFileListDownloadDidCancel(String str, ArrayList<BasicFileInfo> arrayList, int i3);

    void onProfilerFileListDownloadDidError(String str, ArrayList<DownloadErrorFileInfo> arrayList);

    void onProfilerFileListDownloadDidPause(String str, ArrayList<BasicFileInfo> arrayList, int i3);

    void onProfilerFileListDownloadWaitDownloading(String str, ArrayList<BasicFileInfo> arrayList);

    void onThumbnailDownloadResult(ArrayList<FlashTransferThumbnailDownloadResult> arrayList);

    void onUserDownloadOperationResultNotify(UserDownloadOperationInfo userDownloadOperationInfo);
}
