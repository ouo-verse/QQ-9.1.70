package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileBridgeClientState;
import com.tencent.qqnt.kernel.nativeinterface.IKernelFileBridgeClientListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetFileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetPageContentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetRootPageContentCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelQueryUncompleteDownloadRecordsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelSendFileBridgeRequestCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelWiFiPhotoPreCheckCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.PlatformType;
import com.tencent.qqnt.kernel.nativeinterface.ThumbConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000f\u001a\u00020\u000eH&J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0014\u001a\u00020\u0013H&J$\u0010\u0019\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0013H&J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u001cH&J$\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010!H&J.\u0010%\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\b\u001a\u0004\u0018\u00010\u0018H\u0016J\u001c\u0010&\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010\u0018H&J\u0012\u0010'\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010)\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u0010\b\u001a\u0004\u0018\u00010(H&J\u0012\u0010+\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010*H&J\u0012\u0010.\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,H&J\u001c\u0010/\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\b\u001a\u0004\u0018\u00010\u0018H&J$\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u000e2\b\u00101\u001a\u0004\u0018\u00010\u000eH&J\u0010\u00103\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u0016H&J\b\u00104\u001a\u00020\u001eH&J\b\u00105\u001a\u00020\u0013H&\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/kernel/api/p;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelFileBridgeClientListener;", "listener", "", "addKernelFileBridgeClientListener", "I0", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelWiFiPhotoPreCheckCallback;", "cb", "preCheck", "Lcom/tencent/qqnt/kernel/nativeinterface/FileBridgeClientState;", "getCurrentStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/PlatformType;", "getHostSystemType", "", "getDeviceName", "clientName", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelSendFileBridgeRequestCallback;", "sendRequest", "", "getMaxAuthenticateWithoutPasswordValidDays", "passwordMD5Twice", "", "autoAuthenticationDays", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "authenticateWithPassword", "error", "disconnect", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetRootPageContentCallback;", "getRootPageContent", "", "refresh", "fileId", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetPageContentCallback;", "getPageContent", "Lcom/tencent/qqnt/kernel/nativeinterface/ThumbConfig;", DownloadInfo.spKey_Config, "getThumbnail", "getFile", "cancelGet", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGetFileCallback;", "getFileLocalStoragePath", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelQueryUncompleteDownloadRecordsCallback;", "queryUncompleteDownloadRecords", "", "context", "resumeUncompleteDownloadRecords", "clearUncompleteDownloadRecords", "sessionId", "keyWorld", "searchFolderForFiles", "cancelSearchFolderForFiles", "getHostIsSupportSearch", "getHostMaxSearchCount", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface p extends j {
    void I0(@Nullable IKernelFileBridgeClientListener listener);

    void addKernelFileBridgeClientListener(@Nullable IKernelFileBridgeClientListener listener);

    void authenticateWithPassword(@Nullable String passwordMD5Twice, long autoAuthenticationDays, @Nullable IOperateCallback cb5);

    void cancelGet(@Nullable String fileId);

    void cancelSearchFolderForFiles(long sessionId);

    void clearUncompleteDownloadRecords(@Nullable byte[] context, @Nullable IOperateCallback cb5);

    void disconnect(int error);

    @Nullable
    FileBridgeClientState getCurrentStatus();

    @NotNull
    String getDeviceName();

    void getFile(@Nullable String fileId, @Nullable IOperateCallback cb5);

    void getFileLocalStoragePath(@Nullable String fileId, @Nullable IKernelGetFileCallback cb5);

    boolean getHostIsSupportSearch();

    int getHostMaxSearchCount();

    @Nullable
    PlatformType getHostSystemType();

    int getMaxAuthenticateWithoutPasswordValidDays();

    void getPageContent(boolean refresh, @Nullable String fileId, @Nullable IKernelGetPageContentCallback cb5);

    void getRootPageContent(@Nullable IKernelGetRootPageContentCallback cb5);

    void getThumbnail(boolean refresh, @Nullable String fileId, @Nullable ThumbConfig config, @Nullable IOperateCallback cb5);

    void preCheck(@Nullable IKernelWiFiPhotoPreCheckCallback cb5);

    void queryUncompleteDownloadRecords(@Nullable IKernelQueryUncompleteDownloadRecordsCallback cb5);

    void resumeUncompleteDownloadRecords(@Nullable byte[] context);

    void searchFolderForFiles(long sessionId, @Nullable String fileId, @Nullable String keyWorld);

    void sendRequest(@NotNull String clientName, @Nullable IKernelSendFileBridgeRequestCallback cb5);
}
