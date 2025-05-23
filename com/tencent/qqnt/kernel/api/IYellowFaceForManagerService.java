package com.tencent.qqnt.kernel.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IKernelYellowFaceDownloadCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000eH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IYellowFaceForManagerService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "download", "", "resourceConfigJson", "", "resourceDir", "cacheDir", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "callback", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelYellowFaceDownloadCallback;", "setHistory", "fullMd5", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "kernel_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IYellowFaceForManagerService extends QRouteApi {
    void download(@NotNull String resourceConfigJson, @NotNull String resourceDir, @NotNull String cacheDir, boolean force, @NotNull IKernelYellowFaceDownloadCallback callback);

    void setHistory(@NotNull String fullMd5, @NotNull IOperateCallback callback);
}
