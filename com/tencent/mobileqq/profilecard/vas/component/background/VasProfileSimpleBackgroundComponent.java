package com.tencent.mobileqq.profilecard.vas.component.background;

import android.graphics.PointF;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.profilecard.base.framework.IComponentCenter;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.vas.VasProfileData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileSimpleBackgroundComponent;", "Lcom/tencent/mobileqq/profilecard/vas/component/background/VasProfileBackgroundComponent;", "componentCenter", "Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "(Lcom/tencent/mobileqq/profilecard/base/framework/IComponentCenter;Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;)V", "mDiyTextLayout", "Lcom/tencent/mobileqq/profile/view/SingleTouchLayout;", "mDiyTextMask", "Landroid/view/View;", "getDiyTextCenterPoint", "Landroid/graphics/PointF;", "onCreate", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onVasDataUpdate", "", "data", "Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class VasProfileSimpleBackgroundComponent extends VasProfileBackgroundComponent {

    @Nullable
    private SingleTouchLayout mDiyTextLayout;

    @Nullable
    private View mDiyTextMask;

    public VasProfileSimpleBackgroundComponent(@Nullable IComponentCenter iComponentCenter, @Nullable ProfileCardInfo profileCardInfo) {
        super(iComponentCenter, profileCardInfo);
    }

    @NotNull
    public final PointF getDiyTextCenterPoint() {
        PointF pointF;
        SingleTouchLayout singleTouchLayout = this.mDiyTextLayout;
        if (singleTouchLayout != null) {
            pointF = singleTouchLayout.f();
        } else {
            pointF = null;
        }
        if (pointF == null) {
            return new PointF();
        }
        return pointF;
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent, com.tencent.mobileqq.profilecard.base.component.AbsQQProfileComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onCreate(@NotNull QBaseActivity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View view = new View(activity);
        view.setBackgroundColor(-16777216);
        view.setVisibility(8);
        view.setContentDescription("qqvip_diy_text_mask");
        getContainerView().addView(view);
        this.mDiyTextMask = view;
        SingleTouchLayout singleTouchLayout = new SingleTouchLayout(activity);
        singleTouchLayout.setVisibility(8);
        singleTouchLayout.setEditable(false);
        singleTouchLayout.setMovable(false);
        singleTouchLayout.setContentDescription("qqvip_diy_text");
        getContainerView().addView(singleTouchLayout);
        this.mDiyTextLayout = singleTouchLayout;
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent, com.tencent.mobileqq.profilecard.base.framework.impl.AbsComponent, com.tencent.mobileqq.profilecard.base.framework.IComponentLifecycle
    public void onDestroy() {
        super.onDestroy();
        getContainerView().removeView(this.mDiyTextMask);
        getContainerView().removeView(this.mDiyTextLayout);
    }

    @Override // com.tencent.mobileqq.profilecard.vas.component.background.VasProfileBackgroundComponent, com.tencent.mobileqq.profilecard.vas.component.background.AbsVasProfileBackgroundComponent
    public boolean onVasDataUpdate(@NotNull VasProfileData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        super.onVasDataUpdate(data);
        return true;
    }
}
