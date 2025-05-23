package com.tencent.mobileqq.guild.media.widget;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0003NOPB1\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010H\u0012\b\b\u0002\u0010J\u001a\u00020\u0010\u0012\b\b\u0002\u0010K\u001a\u00020\u0010\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010JD\u0010\u001b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001c\u001a\u00020\u0004H\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0014R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010'R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010'R\u0016\u0010,\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010+R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010+R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00103\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00100R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0017\u0010D\u001a\u00020?8\u0006\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00040E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010F\u00a8\u0006Q"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView$c;", "viewLayoutParam", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "isPlay", "l", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", tl.h.F, "", "column", "g", "i", "width", "height", "setWithAndHeight", "inviteAminForSingleColumn", "inviteShakeAnim", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView$b;", "listener", "f", NodeProps.ON_DETACHED_FROM_WINDOW, NodeProps.ON_ATTACHED_TO_WINDOW, "", "d", "Ljava/lang/String;", "INVITE_AMIN_ICON_URL", "Landroid/view/View;", "e", "Landroid/view/View;", "inviteAminView", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/airbnb/lottie/LottieAnimationView;", "inviteLottieAnim", "inviteShakeAnimIcon", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "inviteUserAnimIcon", "inviteUserIcon", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "inviteTitle", "D", "inviteBtn", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "inviteUserIconWrapper", UserInfo.SEX_FEMALE, "I", "currentColumn", "", "G", "J", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME, "Ljava/lang/Runnable;", "H", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "runnable", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "stopShakeAnim", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaInviteEnhanceView extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView inviteTitle;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView inviteBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private FrameLayout inviteUserIconWrapper;

    /* renamed from: F, reason: from kotlin metadata */
    private int currentColumn;

    /* renamed from: G, reason: from kotlin metadata */
    private long showTime;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Runnable runnable;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Function0<Unit> stopShakeAnim;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String INVITE_AMIN_ICON_URL;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View inviteAminView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView inviteLottieAnim;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LottieAnimationView inviteShakeAnimIcon;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView inviteUserAnimIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView inviteUserIcon;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView$b;", "", "", NodeProps.ON_CLICK, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void onClick();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0012\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "iconSize", "iconPadding", "c", "d", "textSize", "textPaddingTop", "<init>", "(FFFF)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class InviteViewLayoutParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final float iconSize;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float iconPadding;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float textSize;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final float textPaddingTop;

        public InviteViewLayoutParam(float f16, float f17, float f18, float f19) {
            this.iconSize = f16;
            this.iconPadding = f17;
            this.textSize = f18;
            this.textPaddingTop = f19;
        }

        /* renamed from: a, reason: from getter */
        public final float getIconPadding() {
            return this.iconPadding;
        }

        /* renamed from: b, reason: from getter */
        public final float getIconSize() {
            return this.iconSize;
        }

        /* renamed from: c, reason: from getter */
        public final float getTextPaddingTop() {
            return this.textPaddingTop;
        }

        /* renamed from: d, reason: from getter */
        public final float getTextSize() {
            return this.textSize;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteViewLayoutParam)) {
                return false;
            }
            InviteViewLayoutParam inviteViewLayoutParam = (InviteViewLayoutParam) other;
            if (Float.compare(this.iconSize, inviteViewLayoutParam.iconSize) == 0 && Float.compare(this.iconPadding, inviteViewLayoutParam.iconPadding) == 0 && Float.compare(this.textSize, inviteViewLayoutParam.textSize) == 0 && Float.compare(this.textPaddingTop, inviteViewLayoutParam.textPaddingTop) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.floatToIntBits(this.iconSize) * 31) + Float.floatToIntBits(this.iconPadding)) * 31) + Float.floatToIntBits(this.textSize)) * 31) + Float.floatToIntBits(this.textPaddingTop);
        }

        @NotNull
        public String toString() {
            return "InviteViewLayoutParam(iconSize=" + this.iconSize + ", iconPadding=" + this.iconPadding + ", textSize=" + this.textSize + ", textPaddingTop=" + this.textPaddingTop + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaInviteEnhanceView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final InviteViewLayoutParam g(int column) {
        if (column != 1) {
            if (column != 2) {
                if (column != 3) {
                    return new InviteViewLayoutParam(50.0f, 12.0f, 12.0f, 12.0f);
                }
                return new InviteViewLayoutParam(50.0f, 12.0f, 12.0f, 12.0f);
            }
            return new InviteViewLayoutParam(70.0f, 16.0f, 16.0f, 16.0f);
        }
        return new InviteViewLayoutParam(0.0f, 0.0f, 16.0f, 10.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Context context, IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        new com.tencent.mobileqq.guild.share.m((Activity) context, guildInfo, channelInfo, GuildSharePageSource.AUDIO_MEMBER_INVITE).z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildMediaInviteEnhanceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LottieAnimationView lottieAnimationView = this$0.inviteLottieAnim;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
            lottieAnimationView = null;
        }
        lottieAnimationView.playAnimation();
    }

    private final void l(boolean isPlay) {
        LottieAnimationView lottieAnimationView = null;
        if (isPlay) {
            LottieAnimationView lottieAnimationView2 = this.inviteLottieAnim;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.setVisibility(0);
            LottieAnimationView lottieAnimationView3 = this.inviteLottieAnim;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.setAnimation(getContext().getString(R.string.f1494712d));
            LottieAnimationView lottieAnimationView4 = this.inviteLottieAnim;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
            } else {
                lottieAnimationView = lottieAnimationView4;
            }
            lottieAnimationView.postDelayed(this.runnable, 2000L);
            return;
        }
        LottieAnimationView lottieAnimationView5 = this.inviteLottieAnim;
        if (lottieAnimationView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
            lottieAnimationView5 = null;
        }
        lottieAnimationView5.setVisibility(8);
        LottieAnimationView lottieAnimationView6 = this.inviteLottieAnim;
        if (lottieAnimationView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
            lottieAnimationView6 = null;
        }
        lottieAnimationView6.removeCallbacks(this.runnable);
        LottieAnimationView lottieAnimationView7 = this.inviteLottieAnim;
        if (lottieAnimationView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
        } else {
            lottieAnimationView = lottieAnimationView7;
        }
        lottieAnimationView.cancelAnimation();
    }

    private final void m(InviteViewLayoutParam viewLayoutParam) {
        l(false);
        View view = this.inviteAminView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteAminView");
            view = null;
        }
        view.setVisibility(8);
        ImageView imageView = this.inviteUserIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
            imageView = null;
        }
        imageView.setVisibility(0);
        TextView textView2 = this.inviteBtn;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteBtn");
            textView2 = null;
        }
        textView2.setVisibility(8);
        ImageView imageView2 = this.inviteUserIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
            imageView2 = null;
        }
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        int f16 = QQGuildUIUtil.f(viewLayoutParam.getIconSize());
        layoutParams.width = f16;
        layoutParams.height = f16;
        ImageView imageView3 = this.inviteUserIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
            imageView3 = null;
        }
        imageView3.setLayoutParams(layoutParams);
        int f17 = QQGuildUIUtil.f(viewLayoutParam.getIconPadding());
        ImageView imageView4 = this.inviteUserIcon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
            imageView4 = null;
        }
        imageView4.setPadding(f17, f17, f17, f17);
        TextView textView3 = this.inviteTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteTitle");
            textView3 = null;
        }
        textView3.setPadding(0, QQGuildUIUtil.f(viewLayoutParam.getTextPaddingTop()), 0, 0);
        TextView textView4 = this.inviteTitle;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteTitle");
            textView4 = null;
        }
        textView4.setTextSize(1, viewLayoutParam.getTextSize());
        TextView textView5 = this.inviteTitle;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inviteTitle");
        } else {
            textView = textView5;
        }
        textView.setText("\u9080\u8bf7\u597d\u53cb");
    }

    public final void f(@NotNull final Context context, @NotNull final IGProGuildInfo guildInfo, @NotNull final IGProChannelInfo channelInfo, int column, boolean inviteAminForSingleColumn, boolean inviteShakeAnim, @Nullable final b listener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        View view = null;
        if (column == 1) {
            if (System.currentTimeMillis() - this.showTime < 1000) {
                return;
            }
            this.showTime = System.currentTimeMillis();
            View view2 = this.inviteAminView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteAminView");
                view2 = null;
            }
            view2.setVisibility(0);
            ImageView imageView = this.inviteUserIcon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
                imageView = null;
            }
            imageView.setVisibility(8);
            FrameLayout frameLayout = this.inviteUserIconWrapper;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteUserIconWrapper");
                frameLayout = null;
            }
            frameLayout.setVisibility(8);
            TextView textView = this.inviteBtn;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteBtn");
                textView = null;
            }
            textView.setVisibility(8);
            if (inviteAminForSingleColumn) {
                ImageView imageView2 = this.inviteUserAnimIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteUserAnimIcon");
                    imageView2 = null;
                }
                imageView2.setVisibility(8);
                l(true);
            } else {
                ImageView imageView3 = this.inviteUserAnimIcon;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteUserAnimIcon");
                    imageView3 = null;
                }
                imageView3.setImageResource(R.drawable.guild_media_invite_icon_anime);
                ImageView imageView4 = this.inviteUserAnimIcon;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteUserAnimIcon");
                    imageView4 = null;
                }
                imageView4.setVisibility(0);
                l(false);
            }
            InviteViewLayoutParam g16 = g(column);
            TextView textView2 = this.inviteTitle;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteTitle");
                textView2 = null;
            }
            textView2.setPadding(0, QQGuildUIUtil.f(g16.getTextPaddingTop()), 0, 0);
            TextView textView3 = this.inviteTitle;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteTitle");
                textView3 = null;
            }
            textView3.setTextSize(1, g16.getTextSize());
            TextView textView4 = this.inviteTitle;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteTitle");
                textView4 = null;
            }
            textView4.setText(QQGuildUIUtil.r(R.string.f1496912z));
            jt1.b.b(this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView$bindView$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                    invoke2(view3);
                    return Unit.INSTANCE;
                }
            });
            TextView textView5 = this.inviteBtn;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteBtn");
            } else {
                view = textView5;
            }
            jt1.b.b(view, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView$bindView$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                    invoke2(view3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildMediaInviteEnhanceView.b bVar = GuildMediaInviteEnhanceView.b.this;
                    if (bVar != null) {
                        bVar.onClick();
                    }
                    this.h(context, guildInfo, channelInfo);
                }
            });
        } else {
            if (this.currentColumn == column) {
                return;
            }
            FrameLayout frameLayout2 = this.inviteUserIconWrapper;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteUserIconWrapper");
                frameLayout2 = null;
            }
            frameLayout2.setVisibility(0);
            if (inviteShakeAnim) {
                if (AppSetting.t(context)) {
                    LottieAnimationView lottieAnimationView = this.inviteShakeAnimIcon;
                    if (lottieAnimationView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                        lottieAnimationView = null;
                    }
                    ViewGroup.LayoutParams layoutParams = lottieAnimationView.getLayoutParams();
                    int i3 = (int) (layoutParams.height * 0.85f);
                    layoutParams.height = i3;
                    layoutParams.width = i3;
                }
                LottieAnimationView lottieAnimationView2 = this.inviteShakeAnimIcon;
                if (lottieAnimationView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                    lottieAnimationView2 = null;
                }
                lottieAnimationView2.setAnimation("guild_media_shake_anim.json");
                LottieAnimationView lottieAnimationView3 = this.inviteShakeAnimIcon;
                if (lottieAnimationView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                    lottieAnimationView3 = null;
                }
                lottieAnimationView3.addAnimatorListener(new d());
                LottieAnimationView lottieAnimationView4 = this.inviteShakeAnimIcon;
                if (lottieAnimationView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                    lottieAnimationView4 = null;
                }
                lottieAnimationView4.playAnimation();
                LottieAnimationView lottieAnimationView5 = this.inviteShakeAnimIcon;
                if (lottieAnimationView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                    lottieAnimationView5 = null;
                }
                lottieAnimationView5.setVisibility(0);
                ImageView imageView5 = this.inviteUserIcon;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
                } else {
                    view = imageView5;
                }
                view.setVisibility(8);
                ThreadUtils.c(3000L, this.stopShakeAnim);
            }
            m(g(column));
            jt1.b.b(this, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView$bindView$4
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view3) {
                    invoke2(view3);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    GuildMediaInviteEnhanceView.this.h(context, guildInfo, channelInfo);
                }
            });
        }
        this.currentColumn = column;
    }

    public final void i(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eya, this);
        View findViewById = findViewById(R.id.f115426w0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.user_invite_amin_layout)");
        this.inviteAminView = findViewById;
        View findViewById2 = findViewById(R.id.f115406vy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.user_invite_amin)");
        this.inviteLottieAnim = (LottieAnimationView) findViewById2;
        View findViewById3 = findViewById(R.id.f115416vz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.user_invite_amin_icon)");
        this.inviteUserAnimIcon = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.f115456w3);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.user_invite_icon_anim)");
        this.inviteShakeAnimIcon = (LottieAnimationView) findViewById4;
        View findViewById5 = findViewById(R.id.f115446w2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.user_invite_icon)");
        this.inviteUserIcon = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f115476w5);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.user_invite_title)");
        this.inviteTitle = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.f115436w1);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.user_invite_btn)");
        this.inviteBtn = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.f115466w4);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.user_invite_icon_wrapper)");
        this.inviteUserIconWrapper = (FrameLayout) findViewById8;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.currentColumn == 1) {
            LottieAnimationView lottieAnimationView = this.inviteLottieAnim;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteLottieAnim");
                lottieAnimationView = null;
            }
            if (lottieAnimationView.getVisibility() == 8) {
                ImageView imageView2 = this.inviteUserAnimIcon;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteUserAnimIcon");
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.guild_media_invite_icon_anime);
                ImageView imageView3 = this.inviteUserAnimIcon;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteUserAnimIcon");
                } else {
                    imageView = imageView3;
                }
                imageView.setVisibility(0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l(false);
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Function0<Unit> function0 = this.stopShakeAnim;
        uIHandlerV2.removeCallbacks(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.p
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaInviteEnhanceView.j(Function0.this);
            }
        });
    }

    public final void setWithAndHeight(int width, int height) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
            layoutParams.height = height;
        }
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(width, height);
        }
        setLayoutParams(layoutParams);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaInviteEnhanceView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaInviteEnhanceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildMediaInviteEnhanceView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMediaInviteEnhanceView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.INVITE_AMIN_ICON_URL = "https://downv6.qq.com/innovate/guild/media_game/guild_media_invite_icon_anime.png";
        this.runnable = new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.q
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaInviteEnhanceView.k(GuildMediaInviteEnhanceView.this);
            }
        };
        this.stopShakeAnim = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaInviteEnhanceView$stopShakeAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LottieAnimationView lottieAnimationView = GuildMediaInviteEnhanceView.this.inviteShakeAnimIcon;
                if (lottieAnimationView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                    lottieAnimationView = null;
                }
                lottieAnimationView.cancelAnimation();
            }
        };
        i(context);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaInviteEnhanceView$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            LottieAnimationView lottieAnimationView = GuildMediaInviteEnhanceView.this.inviteShakeAnimIcon;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteShakeAnimIcon");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(8);
            ImageView imageView2 = GuildMediaInviteEnhanceView.this.inviteUserIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inviteUserIcon");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@Nullable Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
        }
    }
}
