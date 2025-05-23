package com.tencent.mobileqq.zplan.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/api/IZPlanCrashUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearZPlanCrashSwitch", "", "closeZPlanSwitchWhenCrashTooMore", "", "handleCrash", "isNativeCrashed", "crashType", "", "crashStack", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanCrashUtil extends QRouteApi {
    void clearZPlanCrashSwitch();

    boolean closeZPlanSwitchWhenCrashTooMore();

    void handleCrash(boolean isNativeCrashed, @Nullable String crashType, @Nullable String crashStack);
}
