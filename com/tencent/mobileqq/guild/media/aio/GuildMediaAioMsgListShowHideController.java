package com.tencent.mobileqq.guild.media.aio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0007R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010!\u001a\n \u001e*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010#\u001a\n \u001e*\u0004\u0018\u00010\u00050\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/media/aio/GuildMediaAioMsgListShowHideController;", "", "", "k", "j", "Landroid/animation/ValueAnimator;", "anim", "", "l", "o", "", com.tencent.luggage.wxa.c8.c.f123400v, "", NodeProps.VISIBLE, "u", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, DomainData.DOMAIN_NAME, "Landroid/view/View;", "a", "Landroid/view/View;", "msgListView", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "delayStartShowAnimRunnable", "kotlin.jvm.PlatformType", "d", "Landroid/animation/ValueAnimator;", "showAnim", "e", "hideAnim", "<init>", "(Landroid/view/View;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaAioMsgListShowHideController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View msgListView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> delayStartShowAnimRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ValueAnimator showAnim;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ValueAnimator hideAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioMsgListShowHideController$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildMediaAioMsgListShowHideController.this.u(0.0f, 8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            GuildMediaAioMsgListShowHideController.this.u(1.0f, 0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/media/aio/GuildMediaAioMsgListShowHideController$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            GuildMediaAioMsgListShowHideController.this.u(1.0f, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@Nullable Animator animation) {
            GuildMediaAioMsgListShowHideController.this.u(0.0f, 0);
        }
    }

    public GuildMediaAioMsgListShowHideController(@NotNull View msgListView) {
        Intrinsics.checkNotNullParameter(msgListView, "msgListView");
        this.msgListView = msgListView;
        this.handler = new Handler(Looper.getMainLooper());
        this.delayStartShowAnimRunnable = new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.aio.GuildMediaAioMsgListShowHideController$delayStartShowAnimRunnable$1
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
                boolean k3;
                ValueAnimator hideAnim;
                ValueAnimator valueAnimator;
                k3 = GuildMediaAioMsgListShowHideController.this.k();
                if (k3) {
                    GuildMediaAioMsgListShowHideController guildMediaAioMsgListShowHideController = GuildMediaAioMsgListShowHideController.this;
                    hideAnim = guildMediaAioMsgListShowHideController.hideAnim;
                    Intrinsics.checkNotNullExpressionValue(hideAnim, "hideAnim");
                    guildMediaAioMsgListShowHideController.l(hideAnim);
                    valueAnimator = GuildMediaAioMsgListShowHideController.this.showAnim;
                    valueAnimator.start();
                }
            }
        };
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.aio.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildMediaAioMsgListShowHideController.t(GuildMediaAioMsgListShowHideController.this, valueAnimator);
            }
        });
        ofFloat.addListener(new c());
        this.showAnim = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setDuration(200L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.aio.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                GuildMediaAioMsgListShowHideController.m(GuildMediaAioMsgListShowHideController.this, valueAnimator);
            }
        });
        ofFloat2.addListener(new b());
        this.hideAnim = ofFloat2;
    }

    private final boolean j() {
        boolean z16;
        if (this.hideAnim.isRunning()) {
            return false;
        }
        if (this.msgListView.getAlpha() == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k() {
        boolean z16;
        if (this.showAnim.isRunning()) {
            return false;
        }
        if (this.msgListView.getAlpha() == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(ValueAnimator anim) {
        if (anim.isRunning()) {
            anim.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildMediaAioMsgListShowHideController this$0, ValueAnimator valueAnimator) {
        Float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f16 = (Float) animatedValue;
        } else {
            f16 = null;
        }
        if (f16 != null) {
            this$0.msgListView.setAlpha(f16.floatValue());
        }
    }

    private final void o() {
        this.handler.removeCallbacksAndMessages(null);
        Handler handler = this.handler;
        final Function0<Unit> function0 = this.delayStartShowAnimRunnable;
        handler.removeCallbacks(new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.u
            @Override // java.lang.Runnable
            public final void run() {
                GuildMediaAioMsgListShowHideController.p(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(GuildMediaAioMsgListShowHideController this$0, ValueAnimator valueAnimator) {
        Float f16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue instanceof Float) {
            f16 = (Float) animatedValue;
        } else {
            f16 = null;
        }
        if (f16 != null) {
            this$0.msgListView.setAlpha(f16.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(float alpha, int visible) {
        this.msgListView.setAlpha(alpha);
        this.msgListView.setVisibility(visible);
    }

    public final void n() {
        ValueAnimator showAnim = this.showAnim;
        Intrinsics.checkNotNullExpressionValue(showAnim, "showAnim");
        l(showAnim);
        ValueAnimator hideAnim = this.hideAnim;
        Intrinsics.checkNotNullExpressionValue(hideAnim, "hideAnim");
        l(hideAnim);
        o();
    }

    public final void q(boolean visible) {
        o();
        if (visible) {
            Handler handler = this.handler;
            final Function0<Unit> function0 = this.delayStartShowAnimRunnable;
            handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.t
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAioMsgListShowHideController.r(Function0.this);
                }
            }, 500L);
            return;
        }
        ValueAnimator showAnim = this.showAnim;
        Intrinsics.checkNotNullExpressionValue(showAnim, "showAnim");
        l(showAnim);
        if (j()) {
            this.hideAnim.start();
        } else if (!this.hideAnim.isRunning()) {
            u(0.0f, 8);
        }
    }

    public final void s(boolean visible) {
        int i3;
        this.handler.removeCallbacksAndMessages(null);
        ValueAnimator showAnim = this.showAnim;
        Intrinsics.checkNotNullExpressionValue(showAnim, "showAnim");
        l(showAnim);
        ValueAnimator hideAnim = this.hideAnim;
        Intrinsics.checkNotNullExpressionValue(hideAnim, "hideAnim");
        l(hideAnim);
        if (visible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        u(1.0f, i3);
    }
}
