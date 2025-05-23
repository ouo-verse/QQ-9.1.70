package com.tencent.mobileqq.zplan.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import vk3.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/IZPlanPAGLoaderHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lvk3/a;", "listener", "", "addDownloadListener", "removeDownloadListener", "", "pagUrl", "Lorg/libpag/PAGFile;", "getPAGFileByUrl", "pagFile", "", "dp", "setPAGParam", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanPAGLoaderHelper extends QRouteApi {
    void addDownloadListener(@NotNull a listener);

    @Nullable
    PAGFile getPAGFileByUrl(@NotNull String pagUrl);

    void removeDownloadListener(@NotNull a listener);

    void setPAGParam(@Nullable PAGFile pagFile, int dp5);
}
