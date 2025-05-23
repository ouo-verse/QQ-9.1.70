package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IWinkFFmpegApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getFFmpegCmdBinPath", "", "getFFmpegCmdSoPath", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkFFmpegApi extends QRouteApi {
    @Nullable
    String getFFmpegCmdBinPath();

    @Nullable
    String getFFmpegCmdSoPath();
}
