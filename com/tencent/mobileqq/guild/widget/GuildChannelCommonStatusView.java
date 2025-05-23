package com.tencent.mobileqq.guild.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 \u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\tR\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001bR\u0016\u0010\u0011\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/GuildChannelCommonStatusView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "b", "Landroid/graphics/drawable/Drawable;", "drawable", "c", "", "isPlay", "e", "Lcom/tencent/mobileqq/guild/widget/a;", "backgroundInfo", "d", "Lcom/tencent/mobileqq/guild/widget/e;", "channelStatusInfo", "animateEnable", "g", "f", "setAnimateEnable", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "channelIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "statusText", "Lcom/tencent/mobileqq/guild/widget/e;", tl.h.F, "Z", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelCommonStatusView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView channelIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView statusText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ChannelStatusInfo channelStatusInfo;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean animateEnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelCommonStatusView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(Context context) {
        LayoutInflater.from(context).inflate(R.layout.ehs, this);
        View findViewById = findViewById(R.id.trz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.channel_icon)");
        this.channelIcon = (LottieAnimationView) findViewById;
        View findViewById2 = findViewById(R.id.j2b);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.status_text)");
        this.statusText = (TextView) findViewById2;
        setPadding(bi.a(6.0f), 0, bi.a(6.0f), 0);
        setGravity(16);
    }

    private final Drawable c(Drawable drawable) {
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).mutate2();
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    private final void d(BackgroundInfo backgroundInfo) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(backgroundInfo.getCornerRadius());
        gradientDrawable.setStroke(bi.a(1.0f), backgroundInfo.getStrokeColor());
        gradientDrawable.setColor(backgroundInfo.getSolidColor());
        setBackground(gradientDrawable);
        TextView textView = this.statusText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView = null;
        }
        textView.setTextColor(backgroundInfo.getStrokeColor());
    }

    private final void e(boolean isPlay) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildChannelStatusView", "updateChannelLottieAnim: isPlay=" + isPlay);
        }
        LottieAnimationView lottieAnimationView = null;
        if (isPlay) {
            LottieAnimationView lottieAnimationView2 = this.channelIcon;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            } else {
                lottieAnimationView = lottieAnimationView2;
            }
            lottieAnimationView.playAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView3 = this.channelIcon;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            lottieAnimationView3 = null;
        }
        if (lottieAnimationView3.isAnimating()) {
            LottieAnimationView lottieAnimationView4 = this.channelIcon;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            } else {
                lottieAnimationView = lottieAnimationView4;
            }
            lottieAnimationView.cancelAnimation();
        }
    }

    public final void f(@NotNull ChannelStatusInfo channelStatusInfo) {
        Intrinsics.checkNotNullParameter(channelStatusInfo, "channelStatusInfo");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Rt.GuildChannelStatusView", 2, "[updateView] iconInfo:" + channelStatusInfo + ", animateEnable:" + this.animateEnable);
        }
        this.channelStatusInfo = channelStatusInfo;
        TextView textView = this.statusText;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusText");
            textView = null;
        }
        textView.setText(channelStatusInfo.getStatusText());
        d(channelStatusInfo.getBackgroundInfo());
        if (channelStatusInfo.getIsAnimation()) {
            LottieAnimationView lottieAnimationView2 = this.channelIcon;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            } else {
                lottieAnimationView = lottieAnimationView2;
            }
            lottieAnimationView.setAnimation(getContext().getString(channelStatusInfo.getIconResource()));
            e(this.animateEnable);
            return;
        }
        e(false);
        LottieAnimationView lottieAnimationView3 = this.channelIcon;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
            lottieAnimationView3 = null;
        }
        lottieAnimationView3.setImageDrawable(c(ResourcesCompat.getDrawable(getResources(), channelStatusInfo.getIconResource(), null)));
        LottieAnimationView lottieAnimationView4 = this.channelIcon;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelIcon");
        } else {
            lottieAnimationView = lottieAnimationView4;
        }
        lottieAnimationView.setColorFilter(channelStatusInfo.getBackgroundInfo().getStrokeColor());
    }

    public final void g(@NotNull ChannelStatusInfo channelStatusInfo, boolean animateEnable) {
        Intrinsics.checkNotNullParameter(channelStatusInfo, "channelStatusInfo");
        this.animateEnable = animateEnable;
        f(channelStatusInfo);
    }

    public final void setAnimateEnable(boolean animateEnable) {
        this.animateEnable = animateEnable;
        if (!this.channelStatusInfo.getIsAnimation()) {
            return;
        }
        e(animateEnable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelCommonStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelCommonStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildChannelCommonStatusView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelCommonStatusView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        ChannelStatusInfo channelStatusInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        this.animateEnable = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, up1.a.W2, i3, i16);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026efStyleAttr, defStyleRes)");
        float dimension = obtainStyledAttributes.getDimension(up1.a.X2, 0.0f);
        int color = obtainStyledAttributes.getColor(up1.a.f439446c3, 0);
        int color2 = obtainStyledAttributes.getColor(up1.a.f439418a3, 0);
        int resourceId = obtainStyledAttributes.getResourceId(up1.a.Z2, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(up1.a.Y2, 0);
        String string = obtainStyledAttributes.getString(up1.a.f439432b3);
        string = string == null ? "" : string;
        obtainStyledAttributes.recycle();
        b(context);
        if (resourceId == 0) {
            channelStatusInfo = new ChannelStatusInfo(false, resourceId2, string, new BackgroundInfo(dimension, color, color2));
        } else {
            channelStatusInfo = new ChannelStatusInfo(true, resourceId, string, new BackgroundInfo(dimension, color, color2));
        }
        this.channelStatusInfo = channelStatusInfo;
        f(channelStatusInfo);
    }
}
