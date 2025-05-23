package com.tencent.mobileqq.flashtransfer.api;

import android.content.Context;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.CheckDeviceStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.File;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferCheckDeviceStatusCallback;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDeviceStatusListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferServiceDownloadListener;
import com.tencent.qqnt.kernel.nativeinterface.IFlashTransferTaskInfoListener;
import com.tencent.smtt.sdk.stat.MttLoader;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qb1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002H&J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0014\u001a\u00020\u0012H&J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J*\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\u0018\u001a\u00020\u0007H&J\b\u0010\u001a\u001a\u00020\u0019H&J(\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\fH&J\u0018\u0010$\u001a\u00020\f2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\tH&J\b\u0010%\u001a\u00020\u0007H&J\b\u0010&\u001a\u00020\u0007H&J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007H&J\u001a\u0010*\u001a\u00020\u00072\b\u0010(\u001a\u0004\u0018\u00010\u00072\u0006\u0010)\u001a\u00020\u0007H&J\u0012\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010\u0007H&J\b\u0010.\u001a\u00020-H&J\b\u00100\u001a\u00020/H&J\b\u00101\u001a\u00020\fH&J\b\u00102\u001a\u00020\fH&J\b\u00103\u001a\u00020\fH&J\b\u00105\u001a\u000204H&J\u0018\u00109\u001a\u00020\f2\u0006\u00106\u001a\u00020\t2\u0006\u00108\u001a\u000207H&J\u0012\u0010:\u001a\u00020\f2\b\u0010+\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010;\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010@\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010<2\b\u0010?\u001a\u0004\u0018\u00010>H&J\b\u0010A\u001a\u000204H&\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/flashtransfer/api/IFlashTransferApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "", "getFlashTransferJumpParserClass", "Landroid/content/Context;", "context", "", "url", "", "fromSource", MttLoader.ENTRY_ID, "", "interceptFlashTransferUrl", "getFlashTransferProgressHandlerName", "getFlashTransferErrHandlerName", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferTaskInfoListener;", "getFlashTransferTaskInfoListener", "Lcom/tencent/mobileqq/app/BusinessObserver;", "getFlashTransferProgressObserver", "getFlashTransferErrObserver", "filesetId", "getDownloadActivityScheme", "extParams", "getCenterActivityScheme", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDownloadListener;", "getFlashTransferServiceDownloadListener", "Lcom/tencent/qqnt/kernel/nativeinterface/File;", "file", "uploaderName", "isFromBrowse", "isQueryDB", "Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;", "convertToFileManagerEntity", "entity", "action", "canAddMenu", "getFileSaveRootDirectory", "getFileCacheRootDirectory", "getThumbImgSaveRootDirectory", "urlString", "localPath", "downloadThumbImage", "filePath", "getTencentDocSupportedExtension", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferServiceDeviceStatusListener;", "getFlashTransferServiceDeviceStatusListener", "Lqb1/d;", "getFlashTransferFileBrowser", "hasSendEntrance", "isDisabledAioMsgOpen", "hasFlashTransferEntrance", "", "tryResumeFailedTransfer", TagName.FILE_TYPE, "", "size", "isTencentDocFileSizeExceeded", "isFlashTransferFile", "getShareWeChatOverSizeResId", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckDeviceStatusReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IFlashTransferCheckDeviceStatusCallback;", "callback", "checkDeviceStatus", "initFlashTransferService", "qqfile-common-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFlashTransferApi extends QRouteApi {
    boolean canAddMenu(@NotNull FileManagerEntity entity, int action);

    void checkDeviceStatus(@Nullable CheckDeviceStatusReq req, @Nullable IFlashTransferCheckDeviceStatusCallback callback);

    @NotNull
    FileManagerEntity convertToFileManagerEntity(@NotNull File file, @NotNull String uploaderName, boolean isFromBrowse, boolean isQueryDB);

    @NotNull
    String downloadThumbImage(@Nullable String urlString, @NotNull String localPath);

    @NotNull
    String getCenterActivityScheme();

    @NotNull
    String getDownloadActivityScheme(@NotNull String filesetId, int fromSource, int entryId);

    @NotNull
    String getDownloadActivityScheme(@NotNull String filesetId, int fromSource, int entryId, @Nullable String extParams);

    @NotNull
    String getFileCacheRootDirectory();

    @NotNull
    String getFileSaveRootDirectory();

    @NotNull
    String getFlashTransferErrHandlerName();

    @NotNull
    BusinessObserver getFlashTransferErrObserver();

    @NotNull
    d getFlashTransferFileBrowser();

    @NotNull
    Class<? extends Object> getFlashTransferJumpParserClass();

    @NotNull
    String getFlashTransferProgressHandlerName();

    @NotNull
    BusinessObserver getFlashTransferProgressObserver();

    @NotNull
    IFlashTransferServiceDeviceStatusListener getFlashTransferServiceDeviceStatusListener();

    @NotNull
    IFlashTransferServiceDownloadListener getFlashTransferServiceDownloadListener();

    @NotNull
    IFlashTransferTaskInfoListener getFlashTransferTaskInfoListener();

    int getShareWeChatOverSizeResId(@Nullable String filePath);

    @NotNull
    String getTencentDocSupportedExtension(@Nullable String filePath);

    @NotNull
    String getThumbImgSaveRootDirectory(@NotNull String filesetId);

    boolean hasFlashTransferEntrance();

    boolean hasSendEntrance();

    void initFlashTransferService();

    boolean interceptFlashTransferUrl(@NotNull Context context, @NotNull String url, int fromSource, int entryId);

    boolean isDisabledAioMsgOpen();

    boolean isFlashTransferFile(@Nullable String filePath);

    boolean isTencentDocFileSizeExceeded(int fileType, long size);

    void tryResumeFailedTransfer();
}
