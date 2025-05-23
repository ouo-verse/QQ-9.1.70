package com.tencent.richframework.gallery.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qui.b;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.compat.immersive.RFWNavigationBarImmersiveHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/part/QQLayerNavigateBarImmersivePart;", "Lcom/tencent/richframework/gallery/part/RFWLayerBasePart;", "()V", "onInitView", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "onPartCreate", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "qq-layer-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class QQLayerNavigateBarImmersivePart extends RFWLayerBasePart {
    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        b bVar = b.f276860a;
        bVar.a(rootView, RFWNavigationBarImmersiveHelper.ImmersiveType.IMMERSIVE);
        bVar.a(rootView, RFWNavigationBarImmersiveHelper.ImmersiveType.SIDES);
    }

    @Override // com.tencent.richframework.gallery.part.RFWLayerBasePart, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        b.f276860a.l(activity.getWindow());
    }
}
