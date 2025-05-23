package com.tencent.mobileqq.matchfriend.reborn.register.part;

import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/register/part/b;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "x9", "", "getLogTag", "onInitView", "d", "Landroid/view/View;", "bgView", "<init>", "()V", "e", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View bgView;

    private final void x9(View rootView) {
        View findViewById;
        String str;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        View findViewById2 = rootView != null ? rootView.findViewById(R.id.onb) : null;
        this.bgView = findViewById2;
        if (findViewById2 != null) {
            findViewById2.findViewById(R.id.on9).setBackgroundResource(!isNowThemeIsNight ? R.drawable.f6p : R.drawable.f7w);
            findViewById2.findViewById(R.id.ona).setBackgroundResource(!isNowThemeIsNight ? R.drawable.g1r : R.drawable.f159750g22);
            View findViewById3 = findViewById2.findViewById(R.id.onc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.qqstranger_bg_texture)");
            if (!isNowThemeIsNight) {
                str = "https://downv6.qq.com/extendfriend/qqstranger_homepage_texture.png";
            } else {
                str = "https://downv6.qq.com/extendfriend/qqstranger_homepage_texture_night.png";
            }
            com.tencent.mobileqq.matchfriend.reborn.utils.p.b(findViewById3, str, null, false, 8, null);
        }
        if (rootView == null || (findViewById = rootView.findViewById(R.id.oik)) == null) {
            return;
        }
        findViewById.setVisibility(AppSetting.o(getContext()) ? 8 : 0);
        findViewById.setBackgroundResource(isNowThemeIsNight ? R.drawable.g4z : R.drawable.g4y);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public String getLogTag() {
        return "QQStrangerRegisterBgPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        x9(rootView);
    }
}
