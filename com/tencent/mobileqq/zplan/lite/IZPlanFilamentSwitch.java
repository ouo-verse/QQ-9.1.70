package com.tencent.mobileqq.zplan.lite;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import wk3.h;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/lite/IZPlanFilamentSwitch;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "enableZPlanFilamentBase", "Lwk3/h;", DownloadInfo.spKey_Config, "enableSameStyle", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanFilamentSwitch extends QRouteApi {
    boolean enableSameStyle();

    boolean enableZPlanFilamentBase();

    boolean enableZPlanFilamentBase(@Nullable h config);
}
