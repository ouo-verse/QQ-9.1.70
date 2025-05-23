package com.tencent.mobileqq.guild.main.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.main.view.GuildChannelAnimIcon;
import com.tencent.mobileqq.guild.main.view.a;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00015B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\u0017\u0012\b\b\u0002\u00101\u001a\u00020\u0017\u00a2\u0006\u0004\b2\u00103J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0014J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u001e\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\u0016\u0010 \u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010'\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0012\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/main/view/GuildChannelStateAnim;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "", "d", "Landroid/widget/TextView;", "textView", "e", "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$a;", "iconInfo", "Lcom/tencent/mobileqq/guild/main/view/a;", "b", "", "isPlay", "f", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "animateEnable", "setAnimateEnable", "g", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieAnimationView", "", "drawableRes", "setImageResource", "lottieResource", "setAnimation", "c", "Landroid/widget/LinearLayout;", "guildChannelStateView", "Landroid/widget/TextView;", "activeTip", "Lcom/airbnb/lottie/LottieAnimationView;", "activeVoiceAnim", h.F, "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$a;", "i", "Lcom/tencent/mobileqq/guild/main/view/a;", "channelIconType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$c;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/main/view/GuildChannelAnimIcon$c;", "lottieDrawable", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelStateAnim extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final GuildChannelAnimIcon.c lottieDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private LinearLayout guildChannelStateView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView activeTip;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView activeVoiceAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildChannelAnimIcon.ChannelAnimIconInfo iconInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a channelIconType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean animateEnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelStateAnim(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final a b(GuildChannelAnimIcon.ChannelAnimIconInfo iconInfo) {
        if (!iconInfo.getIsChannelStatusActive()) {
            return new a.c(iconInfo.getSpecifiedInactiveIcon(), iconInfo.getChannelType(), iconInfo.getChannelSubId());
        }
        int channelType = iconInfo.getChannelType();
        if (channelType != 2) {
            if (channelType != 5) {
                if (channelType != 8) {
                    return new a.c(iconInfo.getSpecifiedInactiveIcon(), iconInfo.getChannelType(), iconInfo.getChannelSubId());
                }
                return new a.C7822a(R.string.f141650h9, R.string.f142240iu, BackgroundColor.YELLOW);
            }
            return new a.C7822a(R.string.f141620h6, R.string.f142040ia, BackgroundColor.ORANGE);
        }
        return c(iconInfo);
    }

    private final void d(Context context) {
        LayoutInflater.from(context).inflate(R.layout.f168046ei3, this);
        View findViewById = findViewById(R.id.tsd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.channel_state)");
        this.guildChannelStateView = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.trv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.channel_active_tip)");
        this.activeTip = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tru);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.channel_active_anim)");
        this.activeVoiceAnim = (LottieAnimationView) findViewById3;
        try {
            Field declaredField = LottieAnimationView.class.getDeclaredField("lottieDrawable");
            declaredField.setAccessible(true);
            LottieAnimationView lottieAnimationView = this.activeVoiceAnim;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
                lottieAnimationView = null;
            }
            declaredField.set(lottieAnimationView, this.lottieDrawable);
        } catch (NoSuchFieldException unused) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("get LottieAnimationView lottieDrawable Field Failed");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.MF.Rt.GuildChannelStateAnim", 1, (String) it.next(), null);
            }
        }
    }

    private final void e(TextView textView) {
        textView.setTextColor(textView.getContext().getResources().getColor(R.color.qui_common_text_allwhite_primary));
    }

    private final void f(boolean isPlay) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.MF.Rt.GuildChannelStateAnim", "updateChannelLottieAnim: isPlay=" + isPlay);
        }
        LottieAnimationView lottieAnimationView = null;
        if (isPlay) {
            LottieAnimationView lottieAnimationView2 = this.activeVoiceAnim;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setVisibility(0);
            LottieAnimationView lottieAnimationView3 = this.activeVoiceAnim;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
            } else {
                lottieAnimationView = lottieAnimationView3;
            }
            lottieAnimationView.playAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView4 = this.activeVoiceAnim;
        if (lottieAnimationView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
        } else {
            lottieAnimationView = lottieAnimationView4;
        }
        lottieAnimationView.cancelAnimation();
    }

    @NotNull
    public final a c(@NotNull GuildChannelAnimIcon.ChannelAnimIconInfo iconInfo) {
        Intrinsics.checkNotNullParameter(iconInfo, "iconInfo");
        int voiceState = iconInfo.getVoiceState();
        if (voiceState != 6) {
            if (voiceState != 9) {
                if (voiceState != 17) {
                    if (voiceState != 18) {
                        return new a.C7822a(R.string.f141590h3, R.string.f142220is, BackgroundColor.PURPLE);
                    }
                    return new a.C7822a(R.string.f141630h7, R.string.f142170in, BackgroundColor.PURPLE);
                }
                return new a.C7822a(R.string.f141640h8, R.string.f142130ij, BackgroundColor.PURPLE);
            }
            return new a.C7822a(R.string.f141630h7, R.string.f142110ih, BackgroundColor.PURPLE);
        }
        return new a.b(R.drawable.guild_channel_voice_icon_screen_share, R.string.f142200iq, BackgroundColor.PURPLE);
    }

    public final void g(@NotNull GuildChannelAnimIcon.ChannelAnimIconInfo iconInfo) {
        Intrinsics.checkNotNullParameter(iconInfo, "iconInfo");
        this.iconInfo = iconInfo;
        this.lottieDrawable.v(iconInfo.getChannelName());
        TextView textView = this.activeTip;
        LottieAnimationView lottieAnimationView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activeTip");
            textView = null;
        }
        e(textView);
        a b16 = b(iconInfo);
        this.channelIconType = b16;
        if (b16 instanceof a.b) {
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.ChannelIconType.LottieImage");
            a.b bVar = (a.b) b16;
            TextView textView2 = this.activeTip;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeTip");
                textView2 = null;
            }
            TextView textView3 = this.activeTip;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeTip");
                textView3 = null;
            }
            textView2.setText(textView3.getContext().getText(bVar.getTipsResource()));
            LottieAnimationView lottieAnimationView2 = this.activeVoiceAnim;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
                lottieAnimationView2 = null;
            }
            setImageResource(lottieAnimationView2, bVar.getIconResource());
            LottieAnimationView lottieAnimationView3 = this.activeVoiceAnim;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
            } else {
                lottieAnimationView = lottieAnimationView3;
            }
            lottieAnimationView.cancelAnimation();
            return;
        }
        if (b16 instanceof a.C7822a) {
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.main.view.ChannelIconType.LottieAnimation");
            a.C7822a c7822a = (a.C7822a) b16;
            TextView textView4 = this.activeTip;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeTip");
                textView4 = null;
            }
            TextView textView5 = this.activeTip;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeTip");
                textView5 = null;
            }
            textView4.setText(textView5.getContext().getText(c7822a.getTipsResource()));
            LottieAnimationView lottieAnimationView4 = this.activeVoiceAnim;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("activeVoiceAnim");
            } else {
                lottieAnimationView = lottieAnimationView4;
            }
            setAnimation(lottieAnimationView, c7822a.getLottieResource());
            f(this.animateEnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.Rt.GuildChannelStateAnim", 2, "[onAttachedToWindow] iconInfo:" + this.iconInfo);
        }
        g(this.iconInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f(false);
    }

    public final void setAnimateEnable(boolean animateEnable) {
        this.animateEnable = animateEnable;
        this.lottieDrawable.u(animateEnable);
        if (animateEnable) {
            g(this.iconInfo);
        } else {
            f(false);
        }
    }

    public final void setAnimation(@NotNull LottieAnimationView lottieAnimationView, int lottieResource) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        Context context = lottieAnimationView.getContext();
        lottieAnimationView.setAnimation(context.getString(lottieResource));
        GuildUIUtils.f235378a.t(lottieAnimationView, context.getResources().getColor(R.color.qui_common_text_allwhite_primary));
    }

    public final void setImageResource(@NotNull LottieAnimationView lottieAnimationView, int drawableRes) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "lottieAnimationView");
        Context context = lottieAnimationView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "lottieAnimationView.context");
        lottieAnimationView.setImageDrawable(GuildUIUtils.w(context, drawableRes, Integer.valueOf(R.color.qui_common_text_allwhite_primary)));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelStateAnim(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelStateAnim(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildChannelStateAnim(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildChannelStateAnim(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.iconInfo = new GuildChannelAnimIcon.ChannelAnimIconInfo(1, false);
        this.animateEnable = true;
        this.lottieDrawable = new GuildChannelAnimIcon.c();
        d(context);
    }
}
