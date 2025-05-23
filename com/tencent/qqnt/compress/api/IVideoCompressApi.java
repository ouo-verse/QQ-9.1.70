package com.tencent.qqnt.compress.api;

import com.tencent.mobileqq.aio.msglist.holder.component.video.u;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IOperateResult;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J@\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0012\u001a\u00020\u0011H&J\u001c\u0010\u0017\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/compress/api/IVideoCompressApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/AppRuntime;", "appRuntime", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "fileWidth", "fileHeight", "thumbWidth", "thumbHeight", "Lcom/tencent/mobileqq/aio/msglist/holder/component/video/u;", "formatInfo", "getVideoDownloadRequestCodecFormat", "videoInPutCodecFormat", "getVideoUploadRequestCodecFormat", "", "isAIOConfigEnableH265Video", "", "getVideoItemLimitTimeMills", "", "srcVideoPath", "dstVideoPath", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateResult;", "onCompressVideo", "compress_kit_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IVideoCompressApi extends QRouteApi {
    int getVideoDownloadRequestCodecFormat(@NotNull AppRuntime appRuntime, int busiType, int fileWidth, int fileHeight, int thumbWidth, int thumbHeight, @NotNull u formatInfo);

    long getVideoItemLimitTimeMills();

    int getVideoUploadRequestCodecFormat(@NotNull AppRuntime appRuntime, int videoInPutCodecFormat);

    boolean isAIOConfigEnableH265Video(@NotNull AppRuntime appRuntime);

    @NotNull
    IOperateResult onCompressVideo(@Nullable String srcVideoPath, @Nullable String dstVideoPath);
}
