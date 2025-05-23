package com.tencent.mobileqq.vas.tianshu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.homepage.business.model.FunnySpaceModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/tianshu/VasAdBannerView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/vas/tianshu/a;", "adInfo", "", "a", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "luckyBagIcon", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "luckyBagText", "f", "luckyBagButton", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasAdBannerView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView luckyBagIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView luckyBagText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView luckyBagButton;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VasAdBannerView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a(@NotNull ADInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        String str = adInfo.a().get("gift_pic");
        if (str != null) {
            this.luckyBagIcon.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(str).a());
        }
        String str2 = adInfo.a().get(FunnySpaceModel.EXTRA_KEY_ICON_URL);
        if (str2 != null) {
            this.luckyBagButton.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(str2).a());
        }
        String str3 = adInfo.a().get("background_pic");
        if (str3 != null) {
            setBackground(com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(str3).a());
        }
        this.luckyBagText.setText(adInfo.a().get("text"));
        setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VasAdBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VasAdBannerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VasAdBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(16);
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(38.0f), ViewUtils.dpToPx(40.0f));
        layoutParams.setMargins(ViewUtils.dpToPx(20.0f), 0, 0, 0);
        imageView.setLayoutParams(layoutParams);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(imageView);
        this.luckyBagIcon = imageView;
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.setMargins(ViewUtils.dpToPx(8.0f), 0, 0, 0);
        layoutParams2.weight = 1.0f;
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(-16777216);
        textView.setTextSize(14.0f);
        textView.setGravity(16);
        addView(textView);
        this.luckyBagText = textView;
        ImageView imageView2 = new ImageView(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewUtils.dpToPx(70.0f), ViewUtils.dpToPx(30.0f));
        layoutParams3.setMargins(0, 0, ViewUtils.dpToPx(20.0f), 0);
        layoutParams3.gravity = 21;
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(imageView2);
        this.luckyBagButton = imageView2;
        setVisibility(8);
    }
}
