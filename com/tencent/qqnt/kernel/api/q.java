package com.tencent.qqnt.kernel.api;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.FlashTransferSendMsgReq;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferFileSetStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferResumePausedTasksAfterDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferSendMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceFileTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetFileSetIdByCodeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetLocalFileListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceGetShareLinkCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceUpdateFlashTransferCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ResumePausedTasksAfterDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.UpdateFlashTransferParam;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u000eH&J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\u0010H&J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H&J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H&J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001aH&J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u001dH&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001fH&J\"\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010#H&J\u001c\u0010'\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\t2\b\u0010\u0018\u001a\u0004\u0018\u00010&H&J2\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020!2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\u0010\u0018\u001a\u0004\u0018\u00010*H&J4\u00100\u001a\u00020\u00042\u0006\u0010(\u001a\u00020!2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\b\u0010\u0018\u001a\u0004\u0018\u00010/H&J\u0012\u00102\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u000101H&J\u001c\u00105\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u0001032\b\u0010\u0018\u001a\u0004\u0018\u000104H&J\b\u00106\u001a\u00020\u0004H&J$\u0010:\u001a\u00020\u00042\u0006\u0010(\u001a\u00020!2\b\u00108\u001a\u0004\u0018\u0001072\b\u0010\u0018\u001a\u0004\u0018\u000109H&J\u001c\u0010=\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010;2\b\u0010\u0018\u001a\u0004\u0018\u00010<H&\u00a8\u0006>"}, d2 = {"Lcom/tencent/qqnt/kernel/api/q;", "Lcom/tencent/qqnt/kernel/api/j;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "listener", "", "addFileSetDownloadListener", "", "fileSetId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "files", "K", "H", WadlProxyConsts.SCENE_ID, "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferFileSetStatusListener;", "addFileSetSimpleStatusListener", "Lkotlin/collections/ArrayList;", "fileSetIds", "addFileSetSimpleStatusMonitoring", "removeFileSetSimpleStatusMonitoring", "removeFileSetSimpleStatusListener", "Lcom/tencent/qqnt/kernel/nativeinterface/FlashTransferSendMsgReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferSendMsgCallback;", "callback", "sendFlashTransferMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetShareLinkCallback;", "getShareLinkReq", "code", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetIdByCodeCallback;", "getFileSetIdByCode", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "addFlashTransferTaskInfoListener", "", "currentStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "doAIOFlashTransferBubbleActionWithStatus", "file", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceFileTransferCallback;", "startFileTransferUrl", "seq", "fileIds", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetLocalFileListCallback;", "getLocalFileList", "", "isUseCache", "isNoReqSvr", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceGetFileSetCallback;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "addDeviceStatusListener", "Lcom/tencent/qqnt/kernel/nativeinterface/ResumePausedTasksAfterDeviceStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferResumePausedTasksAfterDeviceStatusCallback;", "resumePausedTasksAfterDeviceStatus", "resumeAllUnfinishedTasks", "Lcom/tencent/qqnt/kernel/nativeinterface/UpdateFlashTransferParam;", "updateParam", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceUpdateFlashTransferCallback;", "updateFlashTransfer", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "checkDeviceStatus", "kernel_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface q extends j {
    void H(@NotNull String fileSetId, @NotNull ArrayList<File> files);

    void K(@NotNull String fileSetId, @NotNull ArrayList<File> files);

    void addDeviceStatusListener(@Nullable IFlashTransferServiceDeviceStatusListener listener);

    void addFileSetDownloadListener(@NotNull IFlashTransferServiceDownloadListener listener);

    void addFileSetSimpleStatusListener(@NotNull String sceneId, @NotNull IFlashTransferFileSetStatusListener listener);

    void addFileSetSimpleStatusMonitoring(@NotNull String sceneId, @NotNull ArrayList<String> fileSetIds);

    void addFlashTransferTaskInfoListener(@NotNull IFlashTransferTaskInfoListener listener);

    void checkDeviceStatus(@Nullable CheckDeviceStatusReq req, @Nullable IFlashTransferCheckDeviceStatusCallback callback);

    void doAIOFlashTransferBubbleActionWithStatus(@NotNull String fileSetId, int currentStatus, @Nullable IOperateCallback callback);

    void f(int seq, @Nullable String fileSetId, boolean isUseCache, boolean isNoReqSvr, @Nullable IFlashTransferServiceGetFileSetCallback callback);

    void getFileSetIdByCode(@NotNull String code, @NotNull IFlashTransferServiceGetFileSetIdByCodeCallback callback);

    void getLocalFileList(int seq, @Nullable String fileSetId, @NotNull ArrayList<String> fileIds, @Nullable IFlashTransferServiceGetLocalFileListCallback callback);

    void getShareLinkReq(@NotNull String fileSetId, @NotNull IFlashTransferServiceGetShareLinkCallback callback);

    void removeFileSetSimpleStatusListener(@NotNull String sceneId);

    void removeFileSetSimpleStatusMonitoring(@NotNull String sceneId, @NotNull ArrayList<String> fileSetIds);

    void resumeAllUnfinishedTasks();

    void resumePausedTasksAfterDeviceStatus(@Nullable ResumePausedTasksAfterDeviceStatusReq req, @Nullable IFlashTransferResumePausedTasksAfterDeviceStatusCallback callback);

    void sendFlashTransferMsg(@NotNull FlashTransferSendMsgReq req, @Nullable IFlashTransferSendMsgCallback callback);

    void startFileTransferUrl(@Nullable File file, @Nullable IFlashTransferServiceFileTransferCallback callback);

    void updateFlashTransfer(int seq, @Nullable UpdateFlashTransferParam updateParam, @Nullable IFlashTransferServiceUpdateFlashTransferCallback callback);
}
