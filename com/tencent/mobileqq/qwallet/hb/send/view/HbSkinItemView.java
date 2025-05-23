package com.tencent.mobileqq.qwallet.hb.send.view;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import bl2.HbSkinInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import cooperation.qwallet.plugin.QWalletPicHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u001e\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/send/view/HbSkinItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lbl2/c;", "hbSkinInfo", "", "A0", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "hbSkinBgImg", "e", "hbSpecialSkinBgImg", "f", "hbSkinLogo", h.F, "hbSkinOpenLogo", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "hbSkinLogoText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hbSkinBottom", "Landroid/graphics/drawable/Drawable;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/drawable/Drawable;", "defaultSkin", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class HbSkinItemView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final Drawable defaultSkin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView hbSkinBgImg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView hbSpecialSkinBgImg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView hbSkinLogo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView hbSkinOpenLogo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView hbSkinLogoText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView hbSkinBottom;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/view/HbSkinItemView$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@Nullable View view, @Nullable Outline outline) {
            if (outline != null) {
                outline.setRoundRect(0, 0, HbSkinItemView.this.getWidth(), HbSkinItemView.this.getHeight(), HbSkinItemView.this.getWidth() * 0.065f);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qwallet/hb/send/view/HbSkinItemView$b", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions$URLDrawableListenerAdapter;", "Lcom/tencent/image/URLDrawable;", "arg0", "", "onLoadSuccessed", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends ApngOptions.URLDrawableListenerAdapter {
        b() {
        }

        @Override // com.tencent.mobileqq.vas.apng.api.ApngOptions.URLDrawableListenerAdapter, com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(@NotNull URLDrawable arg0) {
            Intrinsics.checkNotNullParameter(arg0, "arg0");
            HbSkinItemView.this.hbSkinBgImg.setVisibility(8);
            HbSkinItemView.this.setClipToOutline(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinItemView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void A0(@NotNull HbSkinInfo hbSkinInfo) {
        int i3;
        int i16;
        boolean z16;
        int i17;
        int i18;
        String popUrl;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(hbSkinInfo, "hbSkinInfo");
        int type = hbSkinInfo.getType();
        ImageView imageView2 = this.hbSkinLogo;
        int i19 = 8;
        if (hbSkinInfo.getIsDefault()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView2.setVisibility(i3);
        TextView textView = this.hbSkinLogoText;
        if (hbSkinInfo.getIsDefault()) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        textView.setVisibility(i16);
        if ((type & 8) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        ImageView imageView3 = this.hbSkinBottom;
        if (z16) {
            i17 = 8;
        } else {
            i17 = 0;
        }
        imageView3.setVisibility(i17);
        ImageView imageView4 = this.hbSkinBgImg;
        if (z16) {
            i18 = 8;
        } else {
            i18 = 0;
        }
        imageView4.setVisibility(i18);
        ImageView imageView5 = this.hbSpecialSkinBgImg;
        if (z16) {
            i19 = 0;
        }
        imageView5.setVisibility(i19);
        if (!getClipToOutline()) {
            setClipToOutline(true);
        }
        ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).updateOpenIcon(this.hbSkinOpenLogo, hbSkinInfo.getPopOpenUrl());
        if (z16) {
            popUrl = hbSkinInfo.getPopBrokenUrl();
        } else {
            popUrl = hbSkinInfo.getPopUrl();
        }
        if (z16) {
            imageView = this.hbSpecialSkinBgImg;
        } else {
            imageView = this.hbSkinBgImg;
        }
        if (hbSkinInfo.getIsDefault()) {
            imageView.setImageDrawable(this.defaultSkin);
            return;
        }
        if ((type & 4) != 0) {
            QWalletPicHelper.setNetDrawableForAIO(imageView, hbSkinInfo.getDefaultUrl(), hbSkinInfo.getPopUrl(), this.defaultSkin);
            return;
        }
        URLDrawable netDrawableForAIO = QWalletPicHelper.getNetDrawableForAIO(popUrl, this.defaultSkin);
        if (z16) {
            if (netDrawableForAIO.getStatus() != 1) {
                this.hbSkinBgImg.setVisibility(0);
                netDrawableForAIO.setURLDrawableListener(new b());
            } else {
                setClipToOutline(false);
            }
        }
        imageView.setImageDrawable(netDrawableForAIO);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ HbSkinItemView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HbSkinItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.defaultSkin = ContextCompat.getDrawable(context, R.drawable.fpw);
        View.inflate(context, R.layout.hj7, this);
        View findViewById = findViewById(R.id.d1w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.hb_skin_logo)");
        this.hbSkinLogo = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.x6u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.hb_open_logo)");
        this.hbSkinOpenLogo = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.d1t);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.hb_skin_defskin)");
        this.hbSkinBgImg = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.x7e);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.hb_special_skin)");
        this.hbSpecialSkinBgImg = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.d1x);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.hb_skin_logotxt)");
        this.hbSkinLogoText = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.x75);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.hb_skin_bottom)");
        this.hbSkinBottom = (ImageView) findViewById6;
        setOutlineProvider(new a());
        setClipToOutline(true);
    }
}
