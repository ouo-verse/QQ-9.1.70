package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bd;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 V2\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00012\u00020\u0004:\u0002WXB\u000f\u0012\u0006\u0010\"\u001a\u00020\u001f\u00a2\u0006\u0004\bT\u0010UJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0014\u0010\t\u001a\u00020\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0014\u0010\n\u001a\u00020\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0014\u0010\r\u001a\u00020\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J,\u0010\u0019\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003J\u0006\u0010\u001e\u001a\u00020\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010,R\u0016\u0010.\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010$R\u0016\u00100\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010,R\u0016\u00102\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u0016\u00104\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010$R\u0016\u00106\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u0010,R\u0016\u00108\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010)R\u0016\u0010:\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010$R\u0016\u0010<\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010,R\u0016\u0010>\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010;R\u001d\u0010F\u001a\u0004\u0018\u00010A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010P\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u001e\u0010S\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/a;", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "Landroid/view/View$OnClickListener;", "", "l", "k", "stFeed", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "p", "", "i", "Landroid/view/View;", "containerView", "o", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "view", NodeProps.ON_CLICK, DomainData.DOMAIN_NAME, "", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "d", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "depends", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f", "functionContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "shareImageView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "shareNumTv", "shareContainer", BdhLogUtil.LogTag.Tag_Conn, "commentNumTv", "D", "commentImageView", "E", "commentContainer", UserInfo.SEX_FEMALE, "preferNumTv", "G", "preferImageView", "H", "preferContainer", "I", "feedInfoTv", "J", "preferStatus", "K", "preferCount", "Landroid/graphics/drawable/Drawable;", "L", "Lkotlin/Lazy;", "g", "()Landroid/graphics/drawable/Drawable;", "preferDrawable", "Lcom/airbnb/lottie/LottieAnimationView;", "M", "Lcom/airbnb/lottie/LottieAnimationView;", "preferClickedAnimView", "", "N", "Z", "preferClickAnimProcess", "P", "preferLottieLoaded", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lqj1/h;", "displayable", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;)V", BdhLogUtil.LogTag.Tag_Req, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedBottomComponents extends a<qj1.h> implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView commentNumTv;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView commentImageView;

    /* renamed from: E, reason: from kotlin metadata */
    private View commentContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView preferNumTv;

    /* renamed from: G, reason: from kotlin metadata */
    private ImageView preferImageView;

    /* renamed from: H, reason: from kotlin metadata */
    private View preferContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView feedInfoTv;

    /* renamed from: J, reason: from kotlin metadata */
    private int preferStatus;

    /* renamed from: K, reason: from kotlin metadata */
    private int preferCount;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy preferDrawable;

    /* renamed from: M, reason: from kotlin metadata */
    private LottieAnimationView preferClickedAnimView;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean preferClickAnimProcess;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean preferLottieLoaded;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private qj1.h displayable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b depends;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View rootView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View functionContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView shareImageView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private TextView shareNumTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View shareContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0002H&J \u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "", "", "b", "", "e", "d", "g", "Landroid/view/View;", "share", "comment", "prefer", "c", "", "a", "f", "isEnable", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        int a();

        void b();

        void c(@NotNull View share, @NotNull View comment, @NotNull View prefer);

        void d();

        boolean e();

        boolean f();

        void g();

        boolean isEnable();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildFeedBottomComponents this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            qj1.h hVar = this$0.displayable;
            if (hVar != null) {
                this$0.r(hVar);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            hj1.b.a(GuildFeedBottomComponents.this.h(), "onAnimationEnd: UpVote click anim cancelled.");
            LottieAnimationView lottieAnimationView = GuildFeedBottomComponents.this.preferClickedAnimView;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(4);
            ImageView imageView2 = GuildFeedBottomComponents.this.preferImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            GuildFeedBottomComponents.this.preferClickAnimProcess = false;
            qj1.h hVar = GuildFeedBottomComponents.this.displayable;
            if (hVar != null) {
                GuildFeedBottomComponents.this.r(hVar);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            hj1.b.a(GuildFeedBottomComponents.this.h(), "onAnimationEnd: UpVote click anim finish.");
            LottieAnimationView lottieAnimationView = GuildFeedBottomComponents.this.preferClickedAnimView;
            ImageView imageView = null;
            if (lottieAnimationView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
                lottieAnimationView = null;
            }
            lottieAnimationView.setVisibility(4);
            ImageView imageView2 = GuildFeedBottomComponents.this.preferImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferImageView");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            GuildFeedBottomComponents.this.preferClickAnimProcess = false;
            qj1.h hVar = GuildFeedBottomComponents.this.displayable;
            if (hVar != null) {
                GuildFeedBottomComponents.this.r(hVar);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            hj1.b.a(GuildFeedBottomComponents.this.h(), "onAnimationStart: UpVote click anim start.");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildFeedBottomComponents guildFeedBottomComponents = GuildFeedBottomComponents.this;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedBottomComponents.c.b(GuildFeedBottomComponents.this);
                }
            }, 300L);
        }
    }

    public GuildFeedBottomComponents(@NotNull b depends) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(depends, "depends");
        this.depends = depends;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents$preferDrawable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                View view;
                view = GuildFeedBottomComponents.this.rootView;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                    view = null;
                }
                Context context = view.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                return GuildUIUtils.w(context, R.drawable.guild_feed_item_up_vote_icon_clicked_normal, Integer.valueOf(R.color.qui_common_feedback_error));
            }
        });
        this.preferDrawable = lazy;
    }

    private final Drawable g() {
        return (Drawable) this.preferDrawable.getValue();
    }

    private final void j() {
        if (com.tencent.mobileqq.guild.util.o.d("upvote", 300L)) {
            return;
        }
        hj1.b.a(h(), "handleUpVoteClicked: preferCount[" + this.preferCount + "] anim[" + this.preferClickAnimProcess + "] clicked[" + this.preferStatus + "]");
        if (this.depends.e()) {
            return;
        }
        LottieAnimationView lottieAnimationView = null;
        if (this.preferClickAnimProcess) {
            LottieAnimationView lottieAnimationView2 = this.preferClickedAnimView;
            if (lottieAnimationView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
                lottieAnimationView2 = null;
            }
            lottieAnimationView2.cancelAnimation();
        }
        if (!this.preferLottieLoaded) {
            k();
        }
        if (this.preferStatus != 1) {
            ImageView imageView = this.preferImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferImageView");
                imageView = null;
            }
            imageView.setVisibility(4);
            LottieAnimationView lottieAnimationView3 = this.preferClickedAnimView;
            if (lottieAnimationView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
                lottieAnimationView3 = null;
            }
            lottieAnimationView3.setVisibility(0);
            LottieAnimationView lottieAnimationView4 = this.preferClickedAnimView;
            if (lottieAnimationView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
            } else {
                lottieAnimationView = lottieAnimationView4;
            }
            lottieAnimationView.playAnimation();
            this.preferClickAnimProcess = true;
        }
        this.depends.d();
    }

    private final void k() {
        LottieAnimationView lottieAnimationView = this.preferClickedAnimView;
        View view = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setAnimation("feed/feed_item/list_prefer_clicked_anim.json");
        LottieAnimationView lottieAnimationView2 = this.preferClickedAnimView;
        if (lottieAnimationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
            lottieAnimationView2 = null;
        }
        lottieAnimationView2.addAnimatorListener(new c());
        com.tencent.mobileqq.guild.feed.util.au auVar = com.tencent.mobileqq.guild.feed.util.au.f223851a;
        LottieAnimationView lottieAnimationView3 = this.preferClickedAnimView;
        if (lottieAnimationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
            lottieAnimationView3 = null;
        }
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view2;
        }
        auVar.i(lottieAnimationView3, view.getContext().getResources().getColor(R.color.qui_common_text_primary));
        this.preferLottieLoaded = true;
    }

    private final void l() {
        if (Build.VERSION.SDK_INT >= 26) {
            View view = this.rootView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            StateListAnimator loadStateListAnimator = AnimatorInflater.loadStateListAnimator(view.getContext(), R.animator.f155134n);
            View view3 = this.shareContainer;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareContainer");
                view3 = null;
            }
            view3.setStateListAnimator(loadStateListAnimator);
            View view4 = this.commentContainer;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
                view4 = null;
            }
            view4.setStateListAnimator(loadStateListAnimator.clone());
            View view5 = this.preferContainer;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            } else {
                view2 = view5;
            }
            view2.setStateListAnimator(loadStateListAnimator.clone());
        }
    }

    private final void p(qj1.h stFeed) {
        boolean z16;
        long coerceAtLeast;
        String str;
        TextView textView = null;
        if (this.depends.f()) {
            TextView textView2 = this.feedInfoTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedInfoTv");
            } else {
                textView = textView2;
            }
            textView.setText(ax.z(stFeed.m(), stFeed.getCreateTime(), stFeed.z()));
            return;
        }
        if (stFeed.getCommentCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = stFeed.z().timestamp;
        int i3 = stFeed.z().type;
        int a16 = this.depends.a();
        if (a16 == 1 && z16 && j3 > 0 && (i3 == 1 || i3 == 2)) {
            str = "\u56de\u590d\u4e8e" + ax.w(j3 * 1000);
        } else {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(stFeed.m(), stFeed.getCreateTime());
            String w3 = ax.w(coerceAtLeast * 1000);
            if (a16 == 1) {
                str = "\u53d1\u8868\u4e8e" + w3;
            } else {
                str = w3;
            }
            Intrinsics.checkNotNullExpressionValue(str, "{\n                val cr\u2026pureTimeStr\n            }");
        }
        hj1.b.b(h(), "setFeedShowTime feedId: " + stFeed.getFeedId() + " showTimeStr: " + str + ", hasComment: " + z16 + ", sortMode: " + a16 + ", latestInteraction: " + stFeed.z());
        TextView textView3 = this.feedInfoTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedInfoTv");
        } else {
            textView = textView3;
        }
        textView.setText(str);
    }

    private final void q(qj1.h stFeed) {
        TextView textView = this.commentNumTv;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNumTv");
            textView = null;
        }
        textView.setText(bl1.b.h(bl1.b.f28597a, stFeed.getCommentCount(), null, null, 6, null));
        if (stFeed.getCommentCount() > 0) {
            View view = this.commentContainer;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
                view = null;
            }
            Object[] objArr = new Object[1];
            TextView textView2 = this.commentNumTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentNumTv");
                textView2 = null;
            }
            objArr[0] = textView2.getText();
            view.setContentDescription(QQGuildUIUtil.s(R.string.f143650mn, objArr));
        } else {
            View view2 = this.commentContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
                view2 = null;
            }
            TextView textView3 = this.commentNumTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("commentNumTv");
                textView3 = null;
            }
            view2.setContentDescription(textView3.getText());
        }
        ImageView imageView2 = this.commentImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentImageView");
        } else {
            imageView = imageView2;
        }
        imageView.setImageResource(R.drawable.guild_feed_item_comment_icon_token_normal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(qj1.h stFeed) {
        this.preferStatus = stFeed.getPreferStatus();
        this.preferCount = stFeed.e();
        TextView textView = this.preferNumTv;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferNumTv");
            textView = null;
        }
        textView.setText(bl1.b.h(bl1.b.f28597a, this.preferCount, null, null, 6, null));
        ImageView imageView = this.preferImageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferImageView");
            imageView = null;
        }
        imageView.setVisibility(0);
        if (this.preferStatus == 1) {
            ImageView imageView2 = this.preferImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferImageView");
                imageView2 = null;
            }
            imageView2.setImageDrawable(g());
            View view2 = this.preferContainer;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            } else {
                view = view2;
            }
            view.setContentDescription(QQGuildUIUtil.s(R.string.f143640mm, String.valueOf(this.preferCount)));
            return;
        }
        ImageView imageView3 = this.preferImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferImageView");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.guild_feed_item_up_vote_icon_token_normal);
        View view3 = this.preferContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
        } else {
            view = view3;
        }
        view.setContentDescription(QQGuildUIUtil.s(R.string.f143660mo, String.valueOf(this.preferCount)));
    }

    private final void s(qj1.h stFeed) {
        ImageView imageView = null;
        if (stFeed.d() > 0) {
            TextView textView = this.shareNumTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareNumTv");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView2 = this.shareNumTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareNumTv");
                textView2 = null;
            }
            textView2.setText(bl1.b.h(bl1.b.f28597a, stFeed.d(), null, null, 6, null));
        } else {
            TextView textView3 = this.shareNumTv;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shareNumTv");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        ImageView imageView2 = this.shareImageView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareImageView");
        } else {
            imageView = imageView2;
        }
        imageView.setImageResource(R.drawable.guild_feed_item_share_icon_token_normal);
    }

    @NotNull
    public final String h() {
        return "GuildFeedSquareFeedBottomSection";
    }

    @NotNull
    public int[] i() {
        return new int[]{R.id.w_b};
    }

    public void m(@NotNull qj1.h data, int position, @Nullable List<Object> payload) {
        float f16;
        Intrinsics.checkNotNullParameter(data, "data");
        this.displayable = data;
        this.preferClickAnimProcess = false;
        LottieAnimationView lottieAnimationView = this.preferClickedAnimView;
        View view = null;
        if (lottieAnimationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferClickedAnimView");
            lottieAnimationView = null;
        }
        lottieAnimationView.setVisibility(4);
        View view2 = this.functionContainer;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("functionContainer");
            view2 = null;
        }
        if (this.depends.isEnable()) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        view2.setAlpha(f16);
        q(data);
        s(data);
        r(data);
        b bVar = this.depends;
        View view3 = this.shareContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareContainer");
            view3 = null;
        }
        View view4 = this.commentContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
            view4 = null;
        }
        View view5 = this.preferContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
        } else {
            view = view5;
        }
        bVar.c(view3, view4, view);
        p(data);
    }

    public final void n(@NotNull qj1.h stFeed) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        this.displayable = stFeed;
        if (!this.preferClickAnimProcess) {
            r(stFeed);
        }
        q(stFeed);
        s(stFeed);
    }

    public void o(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.w_3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026_feed_item_bottom_layout)");
        this.rootView = findViewById;
        View findViewById2 = containerView.findViewById(R.id.w9z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026ottom_function_container)");
        this.functionContainer = findViewById2;
        View findViewById3 = containerView.findViewById(R.id.w_9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026d_feed_item_bottom_share)");
        this.shareImageView = (ImageView) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.w_a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026ed_item_bottom_share_num)");
        this.shareNumTv = (TextView) findViewById4;
        View findViewById5 = containerView.findViewById(R.id.w__);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026m_bottom_share_container)");
        this.shareContainer = findViewById5;
        View findViewById6 = containerView.findViewById(R.id.w9y);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "containerView.findViewBy\u2026_item_bottom_comment_num)");
        this.commentNumTv = (TextView) findViewById6;
        View findViewById7 = containerView.findViewById(R.id.w9x);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "containerView.findViewBy\u2026_item_bottom_comment_img)");
        this.commentImageView = (ImageView) findViewById7;
        View findViewById8 = containerView.findViewById(R.id.w9w);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "containerView.findViewBy\u2026bottom_comment_container)");
        this.commentContainer = findViewById8;
        View findViewById9 = containerView.findViewById(R.id.w_7);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "containerView.findViewBy\u2026d_item_bottom_prefer_num)");
        this.preferNumTv = (TextView) findViewById9;
        View findViewById10 = containerView.findViewById(R.id.w_d);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "containerView.findViewBy\u2026_item_bottom_up_vote_img)");
        this.preferImageView = (ImageView) findViewById10;
        View findViewById11 = containerView.findViewById(R.id.w_6);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "containerView.findViewBy\u2026_bottom_prefer_container)");
        this.preferContainer = findViewById11;
        View findViewById12 = containerView.findViewById(R.id.w_c);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "containerView.findViewBy\u2026item_bottom_up_vote_anim)");
        this.preferClickedAnimView = (LottieAnimationView) findViewById12;
        View findViewById13 = containerView.findViewById(R.id.wam);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "containerView.findViewBy\u2026ld_feed_item_header_time)");
        this.feedInfoTv = (TextView) findViewById13;
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(view.getContext(), R.color.qui_common_text_primary);
        TextView textView = this.preferNumTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferNumTv");
            textView = null;
        }
        textView.setTextColor(colorStateList);
        TextView textView2 = this.commentNumTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNumTv");
            textView2 = null;
        }
        textView2.setTextColor(colorStateList);
        TextView textView3 = this.shareNumTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareNumTv");
            textView3 = null;
        }
        textView3.setTextColor(colorStateList);
        TextView textView4 = this.preferNumTv;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferNumTv");
            textView4 = null;
        }
        com.tencent.mobileqq.guild.base.extension.s.a(textView4, 400, 0);
        TextView textView5 = this.commentNumTv;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentNumTv");
            textView5 = null;
        }
        com.tencent.mobileqq.guild.base.extension.s.a(textView5, 400, 0);
        TextView textView6 = this.shareNumTv;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareNumTv");
            textView6 = null;
        }
        com.tencent.mobileqq.guild.base.extension.s.a(textView6, 400, 0);
        View view3 = this.shareContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareContainer");
            view3 = null;
        }
        view3.setOnClickListener(this);
        View view4 = this.preferContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preferContainer");
            view4 = null;
        }
        view4.setOnClickListener(this);
        View view5 = this.commentContainer;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commentContainer");
            view5 = null;
        }
        view5.setOnClickListener(this);
        View view6 = this.shareContainer;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shareContainer");
        } else {
            view2 = view6;
        }
        view2.setContentDescription(HardCodeUtil.qqStr(R.string.f144320og));
        if (FontSettingManager.getFontLevel() >= 17.0f) {
            int[] iArr = {R.id.w_2, R.id.w9z};
            for (int i3 = 0; i3 < 2; i3++) {
                View findViewById14 = containerView.findViewById(iArr[i3]);
                if (findViewById14 != null) {
                    Intrinsics.checkNotNullExpressionValue(findViewById14, "containerView.findViewBy\u2026ew>(it) ?: return@forEach");
                    FontSettingManager.resetViewSize2Normal(findViewById14.getContext(), findViewById14);
                }
            }
        }
        l();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            int id5 = view.getId();
            if (id5 == R.id.w__) {
                this.depends.g();
            } else if (id5 == R.id.w9w) {
                bd.f223882a.a(view);
                this.depends.b();
            } else if (id5 == R.id.w_6) {
                j();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
