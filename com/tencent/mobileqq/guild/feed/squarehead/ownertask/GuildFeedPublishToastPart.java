package com.tencent.mobileqq.guild.feed.squarehead.ownertask;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Supplier;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.event.GuildFeedPublishToastShouldShowEvent;
import com.tencent.mobileqq.guild.event.GuildFeedSharePanelLaunchEvent;
import com.tencent.mobileqq.guild.feed.squarehead.ownertask.GuildFeedPublishToastPart;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.widget.GuildRoundBubbleImageView;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 Y2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010!\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f0\u001ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001f` H\u0016J\u0012\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010$\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020)8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b1\u0010+R\u0014\u00106\u001a\u0002038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00108\u001a\u0002038\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b7\u00105R\u0018\u0010;\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010=\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010LR\u0016\u0010N\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010'R\u0016\u0010P\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010'R\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010S\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/feed/squarehead/ownertask/GuildFeedPublishToastPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/guild/event/GuildFeedPublishToastShouldShowEvent;", "event", "", "P9", "W9", "Landroid/view/View;", "view", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager$LayoutParams;", "params", "Z9", "Q9", "V9", "N9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "da", "M9", "U9", "", "url", "Landroid/widget/ImageView;", "targetView", "T9", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "", "d", "Z", "shareToastHasShow", "", "e", "J", "publishToastAutoHideDurationMs", "", "f", "I", "publishShareToastHorizontalMarginDP", h.F, "enterAndExitAnimationDurationMs", "", "i", UserInfo.SEX_FEMALE, "publishToastElevation", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "IMAGE_VIEW_RADIUS_DP", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "publishShareRootView", "D", "publishShareContainerView", "Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "E", "Lcom/tencent/mobileqq/guild/feed/widget/GuildRoundBubbleImageView;", "publishShareImageView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "publishShareTitleView", "G", "publishShareContentView", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "publishShareIconLayout", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "publishShareIcon", "toastEnterAnimationRunning", "K", "toastExitAnimationRunning", "Landroid/animation/AnimatorSet;", "L", "Landroid/animation/AnimatorSet;", "enterAnimatorSet", "M", "exitAnimatorSet", "<init>", "()V", "N", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishToastPart extends Part implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View publishShareRootView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private View publishShareContainerView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private GuildRoundBubbleImageView publishShareImageView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView publishShareTitleView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView publishShareContentView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout publishShareIconLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUIButton publishShareIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean toastEnterAnimationRunning;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean toastExitAnimationRunning;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet enterAnimatorSet;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet exitAnimatorSet;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean shareToastHasShow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final long publishToastAutoHideDurationMs = 5000;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int publishShareToastHorizontalMarginDP = 16;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long enterAndExitAnimationDurationMs = 200;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float publishToastElevation = 20.0f;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float IMAGE_VIEW_RADIUS_DP = 8.0f;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/squarehead/ownertask/GuildFeedPublishToastPart$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f223487d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildFeedPublishToastPart f223488e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WindowManager f223489f;

        b(View view, GuildFeedPublishToastPart guildFeedPublishToastPart, WindowManager windowManager) {
            this.f223487d = view;
            this.f223488e = guildFeedPublishToastPart;
            this.f223489f = windowManager;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f223487d.setVisibility(8);
            this.f223488e.U9(this.f223489f);
            this.f223488e.toastExitAnimationRunning = false;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/squarehead/ownertask/GuildFeedPublishToastPart$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationStart", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f223491e;

        c(View view) {
            this.f223491e = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            GuildFeedPublishToastPart.this.toastEnterAnimationRunning = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            this.f223491e.setVisibility(0);
            this.f223491e.setPivotX(ImmersiveUtils.getScreenWidth() / 2);
            this.f223491e.setPivotY(r2.getHeight() / 2);
        }
    }

    private final void M9(WindowManager windowManager, View view, WindowManager.LayoutParams params) {
        ViewGroup viewGroup;
        if (view.getParent() != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        windowManager.addView(view, params);
    }

    private final void N9(final WindowManager windowManager) {
        final View view = this.publishShareRootView;
        if (view != null) {
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: rn1.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedPublishToastPart.O9(GuildFeedPublishToastPart.this, view, windowManager);
                }
            }, this.publishToastAutoHideDurationMs);
        }
        QLog.i("FirstFeedPublishContentSection", 1, "autoHidePublishShareBanner");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O9(GuildFeedPublishToastPart this$0, View it, WindowManager windowManager) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        Intrinsics.checkNotNullParameter(windowManager, "$windowManager");
        this$0.Q9(it, windowManager);
    }

    private final void P9(GuildFeedPublishToastShouldShowEvent event) {
        Activity activity = getActivity();
        if (activity != null) {
            da(event, activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(final View view, WindowManager windowManager) {
        boolean z16;
        if (!this.toastExitAnimationRunning) {
            AnimatorSet animatorSet = this.exitAnimatorSet;
            if (animatorSet != null && animatorSet.isRunning()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.toastExitAnimationRunning = true;
                AnimatorSet animatorSet2 = this.enterAnimatorSet;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                view.setPivotX(view.getWidth() / 2);
                view.setPivotY(view.getHeight() / 2);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(view.getScaleX(), 0.4f);
                ofFloat.setDuration(this.enterAndExitAnimationDurationMs);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rn1.a
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GuildFeedPublishToastPart.R9(view, valueAnimator);
                    }
                });
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(view.getAlpha(), 0.0f);
                ofFloat2.setDuration(this.enterAndExitAnimationDurationMs);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rn1.b
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GuildFeedPublishToastPart.S9(view, valueAnimator);
                    }
                });
                AnimatorSet animatorSet3 = new AnimatorSet();
                animatorSet3.playTogether(ofFloat, ofFloat2);
                animatorSet3.addListener(new b(view, this, windowManager));
                this.exitAnimatorSet = animatorSet3;
                animatorSet3.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        view.setScaleX(floatValue);
        view.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    private final void T9(String url, ImageView targetView) {
        String d16 = e.d(url);
        if (!TextUtils.isEmpty(d16) && !Intrinsics.areEqual(d16, targetView.getTag(R.id.waq))) {
            targetView.setTag(R.id.waq, d16);
            targetView.setImageDrawable(targetView.getContext().getDrawable(R.drawable.f162601b70));
            e.a().e(new Option().setTargetView(targetView).setLoadingDrawable(targetView.getContext().getDrawable(R.drawable.f162601b70)).setUrl(url).setDecodeMode(0).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565).setRequestWidth(targetView.getWidth()).setRequestHeight(targetView.getHeight()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(WindowManager windowManager) {
        View view = this.publishShareRootView;
        if (view != null) {
            Intrinsics.checkNotNull(view);
            if (view.getParent() != null) {
                windowManager.removeView(this.publishShareRootView);
                this.publishShareRootView = null;
            }
        }
    }

    private final void V9(GuildFeedPublishToastShouldShowEvent event) {
        ViewGroup.LayoutParams layoutParams;
        boolean z16;
        TextView textView = this.publishShareTitleView;
        ViewGroup.LayoutParams layoutParams2 = null;
        if (textView != null) {
            layoutParams = textView.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) layoutParams;
        TextView textView2 = this.publishShareContentView;
        if (textView2 != null) {
            layoutParams2 = textView2.getLayoutParams();
        }
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams2;
        String url = bm.b(event.getStFeed()).getUrl();
        if (url.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i("GuildFeedPublishToastPart", 1, "image style");
            GuildRoundBubbleImageView guildRoundBubbleImageView = this.publishShareImageView;
            if (guildRoundBubbleImageView != null) {
                guildRoundBubbleImageView.setVisibility(0);
            }
            layoutParams4.setMarginStart(cx.a(12.0f));
            layoutParams3.setMarginStart(cx.a(12.0f));
            GuildRoundBubbleImageView guildRoundBubbleImageView2 = this.publishShareImageView;
            if (guildRoundBubbleImageView2 != null) {
                guildRoundBubbleImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            GuildRoundBubbleImageView guildRoundBubbleImageView3 = this.publishShareImageView;
            if (guildRoundBubbleImageView3 != null) {
                guildRoundBubbleImageView3.setRadiusDP(this.IMAGE_VIEW_RADIUS_DP);
            }
            GuildRoundBubbleImageView guildRoundBubbleImageView4 = this.publishShareImageView;
            Intrinsics.checkNotNull(guildRoundBubbleImageView4, "null cannot be cast to non-null type android.widget.ImageView");
            T9(url, guildRoundBubbleImageView4);
        } else {
            QLog.i("GuildFeedPublishToastPart", 1, "mood style");
            GuildRoundBubbleImageView guildRoundBubbleImageView5 = this.publishShareImageView;
            if (guildRoundBubbleImageView5 != null) {
                guildRoundBubbleImageView5.setVisibility(8);
            }
            layoutParams3.setMarginStart(0);
            layoutParams4.setMarginStart(0);
        }
        TextView textView3 = this.publishShareTitleView;
        if (textView3 != null) {
            textView3.setLayoutParams(layoutParams3);
        }
        TextView textView4 = this.publishShareContentView;
        if (textView4 != null) {
            textView4.setLayoutParams(layoutParams4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9(GuildFeedPublishToastShouldShowEvent event) {
        final GuildFeedSharePanelLaunchEvent guildFeedSharePanelLaunchEvent = new GuildFeedSharePanelLaunchEvent(-1, event.getStFeed(), new Supplier() { // from class: rn1.c
            @Override // androidx.core.util.Supplier
            public final Object get() {
                Map X9;
                X9 = GuildFeedPublishToastPart.X9();
                return X9;
            }
        }, -1);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: rn1.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishToastPart.Y9(GuildFeedSharePanelLaunchEvent.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map X9() {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        return emptyMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(GuildFeedSharePanelLaunchEvent guildFeedSharePanelLaunchEvent) {
        Intrinsics.checkNotNullParameter(guildFeedSharePanelLaunchEvent, "$guildFeedSharePanelLaunchEvent");
        SimpleEventBus.getInstance().dispatchEvent(guildFeedSharePanelLaunchEvent);
    }

    private final void Z9(final View view, WindowManager windowManager, WindowManager.LayoutParams params) {
        boolean z16;
        if (!this.toastEnterAnimationRunning) {
            AnimatorSet animatorSet = this.enterAnimatorSet;
            if (animatorSet != null && animatorSet.isRunning()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                this.toastEnterAnimationRunning = true;
                view.setVisibility(4);
                M9(windowManager, view, params);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.4f, 1.0f);
                ofFloat.setDuration(this.enterAndExitAnimationDurationMs);
                ofFloat.setInterpolator(new DecelerateInterpolator());
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rn1.e
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GuildFeedPublishToastPart.aa(view, valueAnimator);
                    }
                });
                ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat2.setDuration(this.enterAndExitAnimationDurationMs);
                ofFloat2.setInterpolator(new DecelerateInterpolator());
                ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: rn1.f
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        GuildFeedPublishToastPart.ba(view, valueAnimator);
                    }
                });
                AnimatorSet animatorSet2 = new AnimatorSet();
                animatorSet2.playTogether(ofFloat, ofFloat2);
                animatorSet2.addListener(new c(view));
                this.enterAnimatorSet = animatorSet2;
                RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: rn1.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedPublishToastPart.ca(GuildFeedPublishToastPart.this);
                    }
                }, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        view.setScaleX(floatValue);
        view.setScaleY(floatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setAlpha(((Float) animatedValue).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ca(GuildFeedPublishToastPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AnimatorSet animatorSet = this$0.enterAnimatorSet;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    private final void da(final GuildFeedPublishToastShouldShowEvent event, Activity activity) {
        View view;
        GuildRoundBubbleImageView guildRoundBubbleImageView;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        if (this.shareToastHasShow) {
            return;
        }
        this.shareToastHasShow = true;
        Object systemService = activity.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        final WindowManager windowManager = (WindowManager) systemService;
        if (this.publishShareRootView != null) {
            return;
        }
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "activity.layoutInflater");
        QUIButton qUIButton = null;
        View findViewById = layoutInflater.inflate(R.layout.f9u, (ViewGroup) null, false).findViewById(R.id.x1t);
        this.publishShareRootView = findViewById;
        if (findViewById != null) {
            view = findViewById.findViewById(R.id.x1t);
        } else {
            view = null;
        }
        this.publishShareContainerView = view;
        View view2 = this.publishShareRootView;
        if (view2 != null) {
            guildRoundBubbleImageView = (GuildRoundBubbleImageView) view2.findViewById(R.id.x1v);
        } else {
            guildRoundBubbleImageView = null;
        }
        this.publishShareImageView = guildRoundBubbleImageView;
        View view3 = this.publishShareRootView;
        if (view3 != null) {
            textView = (TextView) view3.findViewById(R.id.x1y);
        } else {
            textView = null;
        }
        this.publishShareTitleView = textView;
        View view4 = this.publishShareRootView;
        if (view4 != null) {
            textView2 = (TextView) view4.findViewById(R.id.x1x);
        } else {
            textView2 = null;
        }
        this.publishShareContentView = textView2;
        View view5 = this.publishShareRootView;
        if (view5 != null) {
            linearLayout = (LinearLayout) view5.findViewById(R.id.x1u);
        } else {
            linearLayout = null;
        }
        this.publishShareIconLayout = linearLayout;
        View view6 = this.publishShareRootView;
        if (view6 != null) {
            qUIButton = (QUIButton) view6.findViewById(R.id.x1w);
        }
        this.publishShareIcon = qUIButton;
        View view7 = this.publishShareRootView;
        if (view7 != null) {
            view7.setElevation(this.publishToastElevation);
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ImmersiveUtils.getScreenWidth() - cx.a(this.publishShareToastHorizontalMarginDP * 2.0f), cx.a(76.0f), 1000, 40, -3);
        layoutParams.gravity = 49;
        layoutParams.y = cx.a(44.0f);
        V9(event);
        View view8 = this.publishShareRootView;
        if (view8 != null) {
            Z9(view8, windowManager, layoutParams);
        }
        N9(windowManager);
        final QUIButton qUIButton2 = this.publishShareIcon;
        if (qUIButton2 != null) {
            final long j3 = 200;
            qUIButton2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.squarehead.ownertask.GuildFeedPublishToastPart$showTopToast$$inlined$setSingleClickListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    View view9;
                    EventCollector.getInstance().onViewClickedBefore(it);
                    qUIButton2.setClickable(false);
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    this.W9(event);
                    view9 = this.publishShareRootView;
                    if (view9 != null) {
                        this.Q9(view9, windowManager);
                    }
                    final View view10 = qUIButton2;
                    view10.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.squarehead.ownertask.GuildFeedPublishToastPart$showTopToast$$inlined$setSingleClickListener$1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view10.setClickable(true);
                        }
                    }, j3);
                    EventCollector.getInstance().onViewClicked(it);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedPublishToastShouldShowEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof GuildFeedPublishToastShouldShowEvent) {
            P9((GuildFeedPublishToastShouldShowEvent) event);
        }
    }
}
