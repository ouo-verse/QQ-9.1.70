package com.tencent.mobileqq.zplan.bubble.api;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.zplan.bubble.b;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/api/IZPlanAvatarBubbleControllerFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "parentWidthPx", "parentHeightPx", "", "externalEntrance", "Lcom/tencent/mobileqq/zplan/bubble/b;", "generateController", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanAvatarBubbleControllerFactory extends QRouteApi {
    @NotNull
    b generateController(@NotNull FrameLayout parent, int parentWidthPx, int parentHeightPx, @Nullable String externalEntrance);
}
