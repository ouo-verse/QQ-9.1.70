package com.tencent.mobileqq.wink.aiavatar.picker;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/picker/a;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", "topBanner", "Landroid/content/Intent;", "intent", "", "z9", "Landroid/widget/ImageView;", "imageView", "", "imageUrl", "x9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "<init>", "()V", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends Part {
    private final void x9(ImageView imageView, String imageUrl) {
        Option obtain = Option.obtain();
        obtain.setTargetView(imageView);
        obtain.setUrl(imageUrl);
        QQPicLoader.f201806a.d().loadImage(obtain, null);
    }

    private final void z9(View topBanner, Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("selected_style_material");
        View findViewById = topBanner.findViewById(R.id.yye);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) findViewById;
        View findViewById2 = topBanner.findViewById(R.id.yyf);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView2 = (ImageView) findViewById2;
        if (serializableExtra instanceof MetaMaterial) {
            MetaMaterial metaMaterial = (MetaMaterial) serializableExtra;
            x9(imageView, com.tencent.mobileqq.wink.editor.c.A(metaMaterial));
            x9(imageView2, com.tencent.mobileqq.wink.editor.c.n0(metaMaterial));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        boolean z16;
        WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment;
        boolean z17;
        super.onInitView(rootView);
        if (getHostFragment() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("WinkAIAvatarCPMediaPickerTopBannerPart", 1, "rec hostFragment is null?: " + z16);
        Fragment hostFragment = getHostFragment();
        if (hostFragment instanceof WinkMediaPickerMainBaseFragment) {
            winkMediaPickerMainBaseFragment = (WinkMediaPickerMainBaseFragment) hostFragment;
        } else {
            winkMediaPickerMainBaseFragment = null;
        }
        if (winkMediaPickerMainBaseFragment != null) {
            if (winkMediaPickerMainBaseFragment.Xh() == null) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.i("WinkAIAvatarCPMediaPickerTopBannerPart", 1, "rec topAppbarLayout is null?: " + z17);
            AppBarLayout Xh = winkMediaPickerMainBaseFragment.Xh();
            if (Xh != null) {
                Xh.removeAllViews();
            }
            View topBanner = LayoutInflater.from(winkMediaPickerMainBaseFragment.getContext()).inflate(R.layout.i4j, (ViewGroup) null);
            AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, ViewExKt.d(52));
            layoutParams.g(0);
            topBanner.setLayoutParams(layoutParams);
            AppBarLayout Xh2 = winkMediaPickerMainBaseFragment.Xh();
            if (Xh2 != null) {
                Xh2.addView(topBanner);
            }
            com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c b16 = com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.b(winkMediaPickerMainBaseFragment);
            Intent intent = winkMediaPickerMainBaseFragment.getHostActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "hostActivity.intent");
            b16.U1(intent);
            Intrinsics.checkNotNullExpressionValue(topBanner, "topBanner");
            Intent intent2 = winkMediaPickerMainBaseFragment.getHostActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "hostActivity.intent");
            z9(topBanner, intent2);
        }
    }
}
