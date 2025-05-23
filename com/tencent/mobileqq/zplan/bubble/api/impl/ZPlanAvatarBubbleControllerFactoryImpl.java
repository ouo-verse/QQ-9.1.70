package com.tencent.mobileqq.zplan.bubble.api.impl;

import android.widget.FrameLayout;
import com.tencent.falco.utils.UIUtil;
import com.tencent.mobileqq.zplan.bubble.ZPlanAvatarBubbleController;
import com.tencent.mobileqq.zplan.bubble.api.IZPlanAvatarBubbleControllerFactory;
import com.tencent.mobileqq.zplan.bubble.b;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/api/impl/ZPlanAvatarBubbleControllerFactoryImpl;", "Lcom/tencent/mobileqq/zplan/bubble/api/IZPlanAvatarBubbleControllerFactory;", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "parentWidthPx", "parentHeightPx", "", "externalEntrance", "Lcom/tencent/mobileqq/zplan/bubble/b;", "generateController", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarBubbleControllerFactoryImpl implements IZPlanAvatarBubbleControllerFactory {
    @Override // com.tencent.mobileqq.zplan.bubble.api.IZPlanAvatarBubbleControllerFactory
    public b generateController(FrameLayout parent, int parentWidthPx, int parentHeightPx, String externalEntrance) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (parentWidthPx == 0 && parentHeightPx == 0) {
            parentWidthPx = UIUtil.dp2px(parent.getContext(), 375.0f);
            parentHeightPx = UIUtil.dp2px(parent.getContext(), 204.0f);
        }
        return new ZPlanAvatarBubbleController(parent, parentWidthPx, parentHeightPx, externalEntrance);
    }
}
