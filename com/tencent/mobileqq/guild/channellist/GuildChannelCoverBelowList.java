package com.tencent.mobileqq.guild.channellist;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ci;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.u;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 >2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001?B)\u0012\u0006\u00104\u001a\u000203\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00107\u001a\u00020\u0004\u0012\u0006\u00108\u001a\u00020\u0004\u00a2\u0006\u0004\b9\u0010:B\u0011\b\u0016\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b9\u0010;B\u001b\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00106\u001a\u0004\u0018\u000105\u00a2\u0006\u0004\b9\u0010<B#\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00107\u001a\u00020\u0004\u00a2\u0006\u0004\b9\u0010=J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0016R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0014R?\u0010*\u001a\u001f\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/GuildChannelCoverBelowList;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/util/t;", "", "", "offset", "", "d", "w", tl.h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "e", "Lvp1/u;", "Lvp1/u;", "binding", "I", "scrollOffset", "", "f", "Z", "headerVisible", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "clipBoundsRect", "i", "latestWidth", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", MimeHelper.IMAGE_SUBTYPE_BITMAP, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "getOnBgBitmapUpdated", "()Lkotlin/jvm/functions/Function1;", "setOnBgBitmapUpdated", "(Lkotlin/jvm/functions/Function1;)V", "onBgBitmapUpdated", "Lkotlin/Function0;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function0;", "getOnBannerSizeChanged", "()Lkotlin/jvm/functions/Function0;", "setOnBannerSizeChanged", "(Lkotlin/jvm/functions/Function0;)V", "onBannerSizeChanged", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelCoverBelowList extends FrameLayout implements com.tencent.mobileqq.guild.util.t {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onBannerSizeChanged;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final u binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int scrollOffset;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean headerVisible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect clipBoundsRect;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int latestWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Bitmap, Unit> onBgBitmapUpdated;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.headerVisible = true;
        this.clipBoundsRect = new Rect();
        this.latestWidth = -1;
        u f16 = u.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }

    private final void d(int offset) {
        int coerceIn;
        int f16 = QQGuildUIUtil.f(170.0f);
        if (offset >= 0) {
            f16 = QQGuildUIUtil.f(170.0f) + offset;
        }
        coerceIn = RangesKt___RangesKt.coerceIn(f16, 0, QQGuildUIUtil.f(170.0f) * 3);
        int e16 = e();
        if (!this.headerVisible) {
            this.clipBoundsRect.set(0, 0, e16, 0);
        } else if (offset >= 0) {
            this.clipBoundsRect.set(0, 0, e16, coerceIn);
        } else {
            this.clipBoundsRect.set(0, 0, e16, Math.max(offset + coerceIn, 0));
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildHomeCoverBelowList", "clipBoundsRect = " + this.clipBoundsRect + ", height = " + coerceIn + ", headerVisible = " + this.headerVisible);
        }
        setClipBounds(this.clipBoundsRect);
        ci.a(this.binding.f443101b, coerceIn);
        invalidate();
    }

    public int e() {
        boolean z16;
        int i3;
        Integer valueOf = Integer.valueOf(getWidth());
        if (valueOf.intValue() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            i3 = valueOf.intValue();
        } else {
            i3 = GuildSplitViewUtils.f235370a.i(true, getContext());
        }
        if (this.latestWidth != i3) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.NewHome.GuildHomeCoverBelowList", 1, "bannerWidth, view width == " + this.latestWidth + " -> " + i3);
            }
            this.latestWidth = i3;
        }
        return i3;
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
        d(this.scrollOffset);
    }

    public final void setOnBannerSizeChanged(@Nullable Function0<Unit> function0) {
        this.onBannerSizeChanged = function0;
    }

    public final void setOnBgBitmapUpdated(@Nullable Function1<? super Bitmap, Unit> function1) {
        this.onBgBitmapUpdated = function1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelCoverBelowList(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelCoverBelowList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
