package com.tencent.mobileqq.guild.widget.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.t;
import com.tencent.mobileqq.guild.util.w;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\fB)\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u0012\u0006\u0010j\u001a\u00020\b\u0012\u0006\u0010k\u001a\u00020\b\u00a2\u0006\u0004\bl\u0010mB\u0011\b\u0016\u0012\u0006\u0010g\u001a\u00020f\u00a2\u0006\u0004\bl\u0010nB\u001b\b\u0016\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u00a2\u0006\u0004\bl\u0010oB#\b\u0016\u0012\u0006\u0010g\u001a\u00020f\u0012\b\u0010i\u001a\u0004\u0018\u00010h\u0012\u0006\u0010j\u001a\u00020\b\u00a2\u0006\u0004\bl\u0010pJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\bJ(\u0010!\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0014R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010#R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010#R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010'R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010'R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0014\u00101\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010'R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00109R\u0016\u0010=\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R$\u0010E\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b9\u00109\u001a\u0004\bC\u0010DR*\u0010N\u001a\u00020F2\u0006\u0010G\u001a\u00020F8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR*\u0010T\u001a\u00020\u00142\u0006\u0010G\u001a\u00020\u00148\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010<\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0016\u0010V\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010<R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u00109R?\u0010e\u001a\u001f\u0012\u0013\u0012\u00110[\u00a2\u0006\f\b\\\u0012\b\b]\u0012\u0004\b\b(^\u0012\u0004\u0012\u00020\u0006\u0018\u00010Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010d\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/BannerV2Layout;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/util/t;", "", "", "fraction", "", "c", "", "offset", "floatTitleBarHeight", "b", "a", com.tencent.luggage.wxa.c8.c.f123400v, "f", "", "outsideBannerUrl", "g", "color", "setBannerBackgroundColor", "", "animationEnd", "d", "e", "topLeftRadius", "topRightRadius", "setRadiusFrameLayoutTopRadius", "alphaPosOffset", "setStartAlphaPosOffset", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "bannerBackground", "outsizeBackground", "Landroid/view/View;", "Landroid/view/View;", "outsizeBackgroundContainer", "mask", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "i", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "maskContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "radiusFrameLayout", BdhLogUtil.LogTag.Tag_Conn, "shadow", "D", UserInfo.SEX_FEMALE, "contentAlpha", "Lcom/tencent/mobileqq/guild/widget/b;", "E", "Lcom/tencent/mobileqq/guild/widget/b;", "bannerSizeHelper", "I", "scrollOffset", "G", "Z", "headerVisible", "Landroid/graphics/Rect;", "H", "Landroid/graphics/Rect;", "clipBoundsRect", "<set-?>", "getBannerType", "()I", WadlProxyConsts.BANNER_TYPE, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "value", "J", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "getGuildFacadeType", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "setGuildFacadeType", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "guildFacadeType", "K", "getHasTopChannel", "()Z", "setHasTopChannel", "(Z)V", "hasTopChannel", "L", "topChannelAnimating", "M", "Ljava/lang/String;", "N", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "P", "Lkotlin/jvm/functions/Function1;", "getBackgroundBitmapUpdated", "()Lkotlin/jvm/functions/Function1;", "setBackgroundBitmapUpdated", "(Lkotlin/jvm/functions/Function1;)V", "backgroundBitmapUpdated", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class BannerV2Layout extends FrameLayout implements t {
    private static final int R = ch.i().getResources().getDimensionPixelSize(R.dimen.f158969ce4);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View shadow;

    /* renamed from: D, reason: from kotlin metadata */
    private float contentAlpha;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.widget.b bannerSizeHelper;

    /* renamed from: F, reason: from kotlin metadata */
    private int scrollOffset;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean headerVisible;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Rect clipBoundsRect;

    /* renamed from: I, reason: from kotlin metadata */
    private int bannerType;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private GuildFacadeType guildFacadeType;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean hasTopChannel;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean topChannelAnimating;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private String outsideBannerUrl;

    /* renamed from: N, reason: from kotlin metadata */
    private int floatTitleBarHeight;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Bitmap, Unit> backgroundBitmapUpdated;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView bannerBackground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView outsizeBackground;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View outsizeBackgroundContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RadiusFrameLayout maskContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RadiusFrameLayout radiusFrameLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BannerV2Layout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentAlpha = 1.0f;
        this.bannerSizeHelper = new com.tencent.mobileqq.guild.widget.b(context, "BannerV2Layout");
        this.headerVisible = true;
        this.clipBoundsRect = new Rect();
        this.guildFacadeType = GuildFacadeType.Tab;
        this.outsideBannerUrl = "";
        View.inflate(context, R.layout.evo, this);
        View findViewById = findViewById(R.id.xi9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.image_channel_banner)");
        this.bannerBackground = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.xik);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.image_outsize_banner)");
        this.outsizeBackground = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.xil);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.image_outsize_banner_container)");
        this.outsizeBackgroundContainer = findViewById3;
        View findViewById4 = findViewById(R.id.f70083kh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.radius_frame_layout)");
        this.radiusFrameLayout = (RadiusFrameLayout) findViewById4;
        View findViewById5 = findViewById(R.id.iql);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.shadow)");
        this.shadow = findViewById5;
        View findViewById6 = findViewById(R.id.enc);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.mask)");
        this.mask = findViewById6;
        View findViewById7 = findViewById(R.id.yxv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.mask_container)");
        this.maskContainer = (RadiusFrameLayout) findViewById7;
        findViewById6.setVisibility(this.hasTopChannel ? 0 : 8);
    }

    private final void a(int offset) {
        float coerceAtMost;
        float f16 = 1.0f;
        if (offset <= 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost((-offset) / getResources().getDimension(R.dimen.cfr), 1.0f);
            f16 = 1 - coerceAtMost;
        }
        f(f16);
    }

    private final void b(int offset, int floatTitleBarHeight) {
        boolean z16;
        float coerceIn;
        int d16 = this.bannerSizeHelper.d();
        com.tencent.mobileqq.guild.widget.b bVar = this.bannerSizeHelper;
        if (this.bannerType == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int c16 = bVar.c(floatTitleBarHeight, z16);
        if (offset <= (-d16)) {
            float f16 = 1 - ((((-offset) - d16) / (c16 - d16)) * 0.9f);
            if (f16 < 0.1f) {
                f16 = 0.0f;
            }
            coerceIn = RangesKt___RangesKt.coerceIn(f16, 0.0f, 1.0f);
            f(coerceIn);
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("GuildTitleBarInChannelListLayout", 1, "doBgAlphaAnim() offset:" + offset + " [" + d16 + ", " + c16 + "] alpha:(" + f16 + ", " + coerceIn + ")");
                return;
            }
            return;
        }
        f(1.0f);
    }

    private final void c(float fraction) {
        this.mask.setAlpha(fraction);
        b(this.scrollOffset, this.floatTitleBarHeight);
        float f16 = this.contentAlpha;
        a(this.scrollOffset);
        f(f16 + ((this.contentAlpha - f16) * fraction));
    }

    private final void f(float alpha) {
        this.contentAlpha = alpha;
        this.bannerBackground.setAlpha(alpha);
        this.outsizeBackground.setAlpha(alpha);
        this.shadow.setAlpha(alpha);
    }

    private final void g(String outsideBannerUrl) {
        boolean z16;
        this.outsideBannerUrl = outsideBannerUrl;
        if (outsideBannerUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.outsizeBackground.setVisibility(4);
            return;
        }
        if (this.hasTopChannel) {
            ViewGroup.LayoutParams layoutParams = this.outsizeBackground.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            int i3 = R;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -i3;
            ViewGroup.LayoutParams layoutParams2 = this.outsizeBackgroundContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i3;
        } else {
            ViewGroup.LayoutParams layoutParams3 = this.outsizeBackground.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = 0;
            ViewGroup.LayoutParams layoutParams4 = this.outsizeBackgroundContainer.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams4, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = 0;
        }
        this.outsizeBackground.requestLayout();
        this.outsizeBackgroundContainer.requestLayout();
        this.outsizeBackground.setVisibility(0);
        this.outsizeBackground.setTag(R.id.wiq, "1");
        w.c(this, outsideBannerUrl, this.outsizeBackground, Integer.valueOf(com.tencent.mobileqq.guild.mainframe.helper.a.c(getContext())), Integer.valueOf(com.tencent.mobileqq.guild.mainframe.helper.a.a(getContext())), null, new ColorDrawable(getResources().getColor(R.color.f157116k8)), null, 80, null);
    }

    public void d(float fraction, boolean animationEnd) {
        this.mask.setVisibility(0);
        this.topChannelAnimating = !animationEnd;
        c(fraction);
    }

    public void e(float fraction, boolean animationEnd) {
        int i3;
        View view = this.mask;
        if (!animationEnd) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        this.topChannelAnimating = !animationEnd;
        c(1 - fraction);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        if (w3 != oldw || h16 != oldh) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("BannerV2Layout", 2, "onSizeChanged (" + oldw + ", " + oldh + ") -> (" + w3 + ", " + h16 + ")");
            }
        }
        this.bannerSizeHelper.g(w3, h16, oldw, oldh);
    }

    public final void setBackgroundBitmapUpdated(@Nullable Function1<? super Bitmap, Unit> function1) {
        this.backgroundBitmapUpdated = function1;
    }

    public final void setBannerBackgroundColor(int color) {
        this.radiusFrameLayout.setBackgroundColor(color);
    }

    public final void setGuildFacadeType(@NotNull GuildFacadeType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.guildFacadeType = value;
        this.bannerSizeHelper.h(value);
    }

    public final void setHasTopChannel(boolean z16) {
        int i3;
        this.hasTopChannel = z16;
        View view = this.mask;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (this.hasTopChannel) {
            d(1.0f, true);
        } else {
            e(1.0f, true);
        }
        g(this.outsideBannerUrl);
    }

    public final void setRadiusFrameLayoutTopRadius(float topLeftRadius, float topRightRadius) {
        this.radiusFrameLayout.e(topLeftRadius, topRightRadius, 0.0f, 0.0f);
        this.maskContainer.e(topLeftRadius, topRightRadius, 0.0f, 0.0f);
    }

    public final void setStartAlphaPosOffset(int alphaPosOffset) {
        this.bannerSizeHelper.i(alphaPosOffset);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerV2Layout(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerV2Layout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BannerV2Layout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
