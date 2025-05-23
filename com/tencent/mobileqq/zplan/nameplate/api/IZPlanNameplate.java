package com.tencent.mobileqq.zplan.nameplate.api;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zplan.nameplate.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/nameplate/api/IZPlanNameplate;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/widget/RelativeLayout;", "nameplateContainer", "Lcom/tencent/mobileqq/zplan/nameplate/a;", "generateManager", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanNameplate extends QRouteApi {
    @NotNull
    a generateManager(@NotNull RelativeLayout nameplateContainer);
}
