package com.tencent.mobileqq.guild.home.views;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ci;
import com.tencent.mobileqq.guild.util.t;
import com.tencent.mobileqq.guild.util.w;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vp1.ad;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 W2\u00020\u00012\u00020\u0002:\u0001XB)\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\u0006\u0010P\u001a\u00020\u0003\u0012\u0006\u0010Q\u001a\u00020\u0003\u00a2\u0006\u0004\bR\u0010SB\u0011\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u00a2\u0006\u0004\bR\u0010TB\u001b\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u00a2\u0006\u0004\bR\u0010UB#\b\u0016\u0012\u0006\u0010M\u001a\u00020L\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\u0006\u0010P\u001a\u00020\u0003\u00a2\u0006\u0004\bR\u0010VJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0003J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0014J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\u0006\u0010\u001e\u001a\u00020\u0003R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010#R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010%R\u0014\u0010(\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010'R*\u00102\u001a\u00020*2\u0006\u0010+\u001a\u00020*8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010#R\u0018\u00107\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R?\u0010C\u001a\u001f\u0012\u0013\u0012\u001109\u00a2\u0006\f\b:\u0012\b\b;\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0005\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR*\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010J\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/util/t;", "", "offset", "", "e", "", "normalCoverUrl", "j", "", "headerVisible", "g", "", com.tencent.luggage.wxa.c8.c.f123400v, h.F, "color", "i", "topMargin", "setRadiusFrameLayoutTopMargin", "w", "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/view/WindowInsets;", "insets", "onApplyWindowInsets", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "f", "Lvp1/ad;", "d", "Lvp1/ad;", "binding", "I", "scrollOffset", "Z", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "clipBoundsRect", "prevSystemInsetsRect", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "getGuildFacadeType", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "setGuildFacadeType", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "guildFacadeType", BdhLogUtil.LogTag.Tag_Conn, "clipCoverOffset", "D", "Ljava/lang/Integer;", "mCoverMainColor", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "E", "Lkotlin/jvm/functions/Function1;", "getOnBgBitmapUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnBgBitmapUpdated", "(Lkotlin/jvm/functions/Function1;)V", "onBgBitmapUpdated", "Lkotlin/Function0;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function0;", "getOnBannerSizeChanged", "()Lkotlin/jvm/functions/Function0;", "setOnBannerSizeChanged", "(Lkotlin/jvm/functions/Function0;)V", "onBannerSizeChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeCoverBelowList extends FrameLayout implements t {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Lazy<Integer> H;

    /* renamed from: C, reason: from kotlin metadata */
    private int clipCoverOffset;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Integer mCoverMainColor;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Bitmap, Unit> onBgBitmapUpdated;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onBannerSizeChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ad binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int scrollOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean headerVisible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect clipBoundsRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect prevSystemInsetsRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFacadeType guildFacadeType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList$a;", "", "", "GUILD_COVER_HEIGHT$delegate", "Lkotlin/Lazy;", "a", "()I", "GUILD_COVER_HEIGHT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) GuildHomeCoverBelowList.H.getValue()).intValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<Integer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList$Companion$GUILD_COVER_HEIGHT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(bi.b(154));
            }
        });
        H = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        ad f16 = ad.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
        this.headerVisible = true;
        this.clipBoundsRect = new Rect();
        this.prevSystemInsetsRect = new Rect(-1, -1, -1, -1);
        this.guildFacadeType = GuildFacadeType.Tab;
        setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.tencent.mobileqq.guild.home.views.a
            @Override // android.view.View.OnApplyWindowInsetsListener
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                WindowInsets b16;
                b16 = GuildHomeCoverBelowList.b(view, windowInsets);
                return b16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets b(View view, WindowInsets windowInsets) {
        WindowInsets consumeSystemWindowInsets = windowInsets.consumeSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(consumeSystemWindowInsets, "insets.consumeSystemWindowInsets()");
        return consumeSystemWindowInsets;
    }

    private final void e(int offset) {
        int coerceAtLeast;
        int coerceIn;
        Companion companion = INSTANCE;
        int a16 = companion.a();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(offset, 0);
        coerceIn = RangesKt___RangesKt.coerceIn(a16 + coerceAtLeast, 0, companion.a() * 3);
        int f16 = f();
        if (!this.headerVisible) {
            this.clipBoundsRect.set(0, 0, f16, 0);
        } else if (offset >= 0) {
            this.clipBoundsRect.set(0, 0, f16, coerceIn);
        } else {
            this.clipBoundsRect.set(0, 0, f16, Math.max(offset + coerceIn, 0));
        }
        setClipBounds(this.clipBoundsRect);
        ci.a(this, coerceIn);
        invalidate();
    }

    public final int f() {
        if (getMeasuredWidth() > 0) {
            return getMeasuredWidth();
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildHomeCoverBelowList", 1, "bannerWidth, view width == 0");
        }
        return QQGuildUIUtil.p(getContext()).f185860a;
    }

    public final void g(boolean headerVisible, int offset) {
        this.scrollOffset = offset;
        this.headerVisible = headerVisible;
        e(offset);
    }

    public final void h(float alpha) {
        boolean z16;
        this.binding.f442175c.setAlpha(alpha);
        this.binding.f442176d.setAlpha(alpha);
        View view = this.binding.f442174b;
        Intrinsics.checkNotNullExpressionValue(view, "binding.mainColorBelow");
        int i3 = 0;
        if (alpha > 0.0f && alpha < 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void i(int color) {
        Integer num = this.mCoverMainColor;
        if (num != null && num.intValue() == color) {
            return;
        }
        this.mCoverMainColor = Integer.valueOf(color);
        this.binding.f442176d.setBackground(GuildUIUtils.f235378a.i(color, g.a(color, 20), 255));
        this.binding.f442174b.setBackground(new ColorDrawable(color));
    }

    public final void j(@NotNull String normalCoverUrl) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(normalCoverUrl, "normalCoverUrl");
        isBlank = StringsKt__StringsJVMKt.isBlank(normalCoverUrl);
        if (isBlank) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        e(this.scrollOffset);
        this.binding.f442175c.setTag(R.id.wiq, "1");
        ImageView imageView = this.binding.f442175c;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.normalCover");
        w.c(this, normalCoverUrl, imageView, 0, 0, null, new ColorDrawable(getResources().getColor(R.color.f157116k8)), this.onBgBitmapUpdated, 16, null);
    }

    @Override // android.view.View
    @NotNull
    public WindowInsets onApplyWindowInsets(@NotNull WindowInsets insets) {
        Intrinsics.checkNotNullParameter(insets, "insets");
        int paddingTop = getPaddingTop();
        Insets systemWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(insets).getSystemWindowInsets();
        Intrinsics.checkNotNullExpressionValue(systemWindowInsets, "toWindowInsetsCompat(insets).systemWindowInsets");
        Rect rect = this.prevSystemInsetsRect;
        if (rect.left != systemWindowInsets.left || rect.top != systemWindowInsets.top || rect.right != systemWindowInsets.right || rect.bottom != systemWindowInsets.bottom) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.GuildHomeCoverBelowList", 2, "onApplyWindowInsets: " + this.prevSystemInsetsRect.toShortString() + " -> [" + systemWindowInsets.left + "," + systemWindowInsets.top + "][" + systemWindowInsets.right + "," + systemWindowInsets.bottom + "]");
            }
            this.prevSystemInsetsRect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
        }
        WindowInsets ret = super.onApplyWindowInsets(insets);
        if (getPaddingTop() > paddingTop) {
            ViewExtKt.f(this, paddingTop);
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("Guild.NewHome.GuildHomeCoverBelowList", 2, "onApplyWindowInsets! (" + insets + ") -> (" + ret + ")");
            }
        } else {
            Logger logger3 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.GuildHomeCoverBelowList", "onApplyWindowInsets (" + insets + ") -> (" + ret + ")");
            }
        }
        Intrinsics.checkNotNullExpressionValue(ret, "ret");
        return ret;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        requestLayout();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        Function0<Unit> function0 = this.onBannerSizeChanged;
        if (function0 != null) {
            function0.invoke();
        }
        e(this.scrollOffset);
    }

    public final void setGuildFacadeType(@NotNull GuildFacadeType value) {
        boolean z16;
        Intrinsics.checkNotNullParameter(value, "value");
        this.guildFacadeType = value;
        int i3 = 0;
        this.clipCoverOffset = 0;
        View view = this.binding.f442176d;
        Intrinsics.checkNotNullExpressionValue(view, "binding.shadowCover");
        if (value != GuildFacadeType.GameCenter) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    public final void setOnBannerSizeChanged(@Nullable Function0<Unit> function0) {
        this.onBannerSizeChanged = function0;
    }

    public final void setOnBgBitmapUpdated(@Nullable Function1<? super Bitmap, Unit> function1) {
        this.onBgBitmapUpdated = function1;
    }

    public final void setRadiusFrameLayoutTopMargin(int topMargin) {
        ViewGroup.LayoutParams layoutParams = this.binding.f442175c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = topMargin;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildHomeCoverBelowList(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildHomeCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildHomeCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
