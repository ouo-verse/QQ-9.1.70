package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import com.tencent.richframework.gallery.RFWLayerIOCUtil;
import com.tencent.richframework.gallery.delegate.inner.INavigationBarImmersiveStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/richframework/gallery/part/RFWLayerNavigationBarImmersivePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "Lcom/tencent/richframework/gallery/delegate/inner/INavigationBarImmersiveStrategy;", "()V", "isOpenImmersive", "", "isOpenNavigationBarImmersive", "onInitView", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWLayerNavigationBarImmersivePart extends RFWLayerBasePart implements INavigationBarImmersiveStrategy {
    private final boolean isOpenImmersive = RFWConfig.getConfigValue("open_new_navigation_bar_switch", true);

    @Override // com.tencent.richframework.gallery.delegate.inner.INavigationBarImmersiveStrategy
    /* renamed from: isOpenNavigationBarImmersive, reason: from getter */
    public boolean getIsOpenImmersive() {
        return this.isOpenImmersive;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        if (!this.isOpenImmersive) {
            RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper = RFWNavigationBarImmersiveHelper.INSTANCE;
            View findViewById = rootView.findViewById(R.id.f73943ux);
            RFWNavigationBarImmersiveHelper.ImmersiveType immersiveType = RFWNavigationBarImmersiveHelper.ImmersiveType.ABOVE;
            rFWNavigationBarImmersiveHelper.adjustView(findViewById, immersiveType);
            rFWNavigationBarImmersiveHelper.adjustView(rootView.findViewById(R.id.y9r), immersiveType);
        }
        RFWNavigationBarImmersiveHelper rFWNavigationBarImmersiveHelper2 = RFWNavigationBarImmersiveHelper.INSTANCE;
        rFWNavigationBarImmersiveHelper2.adjustView(rootView.findViewById(R.id.f73883ur), RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        View findViewById2 = rootView.findViewById(R.id.f73943ux);
        RFWNavigationBarImmersiveHelper.ImmersiveType immersiveType2 = RFWNavigationBarImmersiveHelper.ImmersiveType.SIDES;
        rFWNavigationBarImmersiveHelper2.adjustView(findViewById2, immersiveType2);
        rFWNavigationBarImmersiveHelper2.adjustView(rootView.findViewById(R.id.y9r), immersiveType2);
        RFWLayerIOCUtil.registerNavigationBarImmersiveStrategy(rootView, this);
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        RFWNavigationBarImmersiveHelper.INSTANCE.setNavigationBarImmersive(activity.getWindow());
    }
}
