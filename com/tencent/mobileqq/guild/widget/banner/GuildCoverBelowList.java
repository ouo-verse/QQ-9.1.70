package com.tencent.mobileqq.guild.widget.banner;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.t;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001YB)\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010Q\u001a\u00020\u0004\u0012\u0006\u0010R\u001a\u00020\u0004\u00a2\u0006\u0004\bS\u0010TB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bS\u0010UB\u001b\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u00a2\u0006\u0004\bS\u0010VB#\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010P\u001a\u0004\u0018\u00010O\u0012\u0006\u0010Q\u001a\u00020\u0004\u00a2\u0006\u0004\bS\u0010WJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004J(\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0014R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R*\u00102\u001a\u00020*2\u0006\u0010+\u001a\u00020*8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R?\u0010E\u001a\u001f\u0012\u0013\u0012\u00110;\u00a2\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u0006\u0018\u00010:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR*\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010F8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/GuildCoverBelowList;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/util/t;", "", "", "color", "", "setBannerBackgroundColor", "alphaPosOffset", "setStartAlphaPosOffset", "", "topLeftRadius", "topRightRadius", "setTopRadius", "topMargin", "setRadiusFrameLayoutTopMargin", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lvp1/ae;", "d", "Lvp1/ae;", "binding", "e", UserInfo.SEX_FEMALE, "contentAlpha", "Lcom/tencent/mobileqq/guild/widget/b;", "f", "Lcom/tencent/mobileqq/guild/widget/b;", "bannerSizeHelper", "", "Z", "headerVisible", "Landroid/graphics/Rect;", "i", "Landroid/graphics/Rect;", "clipBoundsRect", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "value", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "getGuildFacadeType", "()Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "setGuildFacadeType", "(Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "guildFacadeType", BdhLogUtil.LogTag.Tag_Conn, "I", "clipCoverOffset", "", "D", "Ljava/lang/String;", "outsideBannerUrl", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, "E", "Lkotlin/jvm/functions/Function1;", "getOnBgBitmapUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnBgBitmapUpdated", "(Lkotlin/jvm/functions/Function1;)V", "onBgBitmapUpdated", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "getOnBannerSizeChanged", "()Lkotlin/jvm/functions/Function0;", "setOnBannerSizeChanged", "(Lkotlin/jvm/functions/Function0;)V", "onBannerSizeChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCoverBelowList extends FrameLayout implements t {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int H = QQGuildUIUtil.f(11.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private int clipCoverOffset;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String outsideBannerUrl;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Function1<? super Bitmap, Unit> onBgBitmapUpdated;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onBannerSizeChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ae binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float contentAlpha;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.widget.b bannerSizeHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean headerVisible;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect clipBoundsRect;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildFacadeType guildFacadeType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/GuildCoverBelowList$a;", "", "", "outsideBannerExtSize", "I", "a", "()I", "getOutsideBannerExtSize$annotations", "()V", "BANNER_TYPE_NONE", "BANNER_TYPE_NORMAL", "BANNER_TYPE_OUTSIDE", "", "DEFAULT_COVER_BG", "Ljava/lang/String;", "TAG", "UNKNOWN_GUILD_NAME", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.banner.GuildCoverBelowList$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildCoverBelowList.H;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.contentAlpha = 1.0f;
        this.bannerSizeHelper = new com.tencent.mobileqq.guild.widget.b(context, "Guild.MF.Rt.GuildCoverBelowList");
        this.headerVisible = true;
        this.clipBoundsRect = new Rect();
        this.guildFacadeType = GuildFacadeType.Tab;
        this.outsideBannerUrl = "";
        ae f16 = ae.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }

    public static final int b() {
        return INSTANCE.a();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.bannerSizeHelper.f(newConfig);
        requestLayout();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        if (w3 != oldw || h16 != oldh) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.MF.Rt.GuildCoverBelowList", 2, "onSizeChanged (" + oldw + ", " + oldh + ") -> (" + w3 + ", " + h16 + ")");
            }
        }
        this.bannerSizeHelper.g(w3, h16, oldw, oldh);
        Function0<Unit> function0 = this.onBannerSizeChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setBannerBackgroundColor(int color) {
        this.binding.f442179c.setBackgroundColor(color);
    }

    public final void setGuildFacadeType(@NotNull GuildFacadeType value) {
        int f16;
        Intrinsics.checkNotNullParameter(value, "value");
        this.guildFacadeType = value;
        if (value.isTabStyle()) {
            f16 = 0;
        } else {
            f16 = QQGuildUIUtil.f(2.5f);
        }
        this.clipCoverOffset = f16;
        this.bannerSizeHelper.h(value);
    }

    public final void setOnBannerSizeChanged(@Nullable Function0<Unit> function0) {
        this.onBannerSizeChanged = function0;
    }

    public final void setOnBgBitmapUpdated(@Nullable Function1<? super Bitmap, Unit> function1) {
        this.onBgBitmapUpdated = function1;
    }

    public final void setRadiusFrameLayoutTopMargin(int topMargin) {
        ViewGroup.LayoutParams layoutParams = this.binding.f442179c.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = topMargin;
    }

    public final void setStartAlphaPosOffset(int alphaPosOffset) {
        this.bannerSizeHelper.i(alphaPosOffset);
    }

    public final void setTopRadius(float topLeftRadius, float topRightRadius) {
        this.binding.f442179c.e(topLeftRadius, topRightRadius, 0.0f, 0.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCoverBelowList(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
