package com.tencent.mobileqq.matchfriend.reborn.content.signal.publish;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.matchfriend.reborn.guide.QQStrangerPagView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\u0006R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR#\u0010&\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%R#\u0010)\u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010%\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper;", "", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/graphics/Rect;", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", h.F, "Landroid/view/View;", "anchorView", "k", "p", "j", "Landroid/widget/FrameLayout;", "a", "Landroid/widget/FrameLayout;", "maskView", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerPagView;", "b", "Lcom/tencent/mobileqq/matchfriend/reborn/guide/QQStrangerPagView;", "pagView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isShowing", "Ljava/lang/Runnable;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/Runnable;", "hideRunnable", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "e", DomainData.DOMAIN_NAME, "()Landroid/animation/ObjectAnimator;", "showAnimator", "f", "l", "hideAnimator", "<init>", "()V", "g", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerSignalPublishGuideHelper {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FrameLayout maskView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QQStrangerPagView pagView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AtomicBoolean isShowing = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy hideRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy showAnimator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy hideAnimator;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper$a;", "", "", "a", "", "PAG_URL", "Ljava/lang/String;", "", "PAG_VIEW_SIZE", "I", "", "SHOW_ANI_DURATION", "J", "TAG", "TOTAL_DURATION", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishGuideHelper$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            QQPicLoader.f201806a.d().download(Option.obtainDownloadOption().setUrl("https://static-res.qq.com/static-res/qqstranger/signal/pag/qq_stranger_signal_publish_guide.pag"), null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewGroup f244888e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f244889f;

        b(ViewGroup viewGroup, View view) {
            this.f244888e = viewGroup;
            this.f244889f = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect k3 = QQStrangerSignalPublishGuideHelper.this.k(this.f244888e, this.f244889f);
            QLog.i("QQStrangerSignalPublishGuideHelper", 1, "addOnGlobalLayoutListener.");
            if (k3 != null) {
                QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper = QQStrangerSignalPublishGuideHelper.this;
                ViewGroup viewGroup = this.f244888e;
                View view = this.f244889f;
                qQStrangerSignalPublishGuideHelper.q(viewGroup, k3);
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    public QQStrangerSignalPublishGuideHelper() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new QQStrangerSignalPublishGuideHelper$hideRunnable$2(this));
        this.hideRunnable = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ObjectAnimator>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishGuideHelper$showAnimator$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper$showAnimator$2$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes33.dex */
            public static final class a extends AnimatorListenerAdapter {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQStrangerSignalPublishGuideHelper f244891d;

                a(QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper) {
                    this.f244891d = qQStrangerSignalPublishGuideHelper;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    this.f244891d.o();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    FrameLayout frameLayout;
                    QQStrangerPagView qQStrangerPagView;
                    frameLayout = this.f244891d.maskView;
                    if (frameLayout != null) {
                        frameLayout.setAlpha(1.0f);
                    }
                    qQStrangerPagView = this.f244891d.pagView;
                    if (qQStrangerPagView != null) {
                        qQStrangerPagView.q("https://static-res.qq.com/static-res/qqstranger/signal/pag/qq_stranger_signal_publish_guide.pag", null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ObjectAnimator invoke() {
                FrameLayout frameLayout;
                frameLayout = QQStrangerSignalPublishGuideHelper.this.maskView;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
                QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper = QQStrangerSignalPublishGuideHelper.this;
                ofFloat.setDuration(400L);
                ofFloat.addListener(new a(qQStrangerSignalPublishGuideHelper));
                return ofFloat;
            }
        });
        this.showAnimator = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ObjectAnimator>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.QQStrangerSignalPublishGuideHelper$hideAnimator$2

            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/signal/publish/QQStrangerSignalPublishGuideHelper$hideAnimator$2$a", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationCancel", "", "isReverse", "onAnimationEnd", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes33.dex */
            public static final class a extends AnimatorListenerAdapter {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQStrangerSignalPublishGuideHelper f244890d;

                a(QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper) {
                    this.f244890d = qQStrangerSignalPublishGuideHelper;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    this.f244890d.o();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation, boolean isReverse) {
                    this.f244890d.o();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    QQStrangerPagView qQStrangerPagView;
                    qQStrangerPagView = this.f244890d.pagView;
                    if (qQStrangerPagView != null) {
                        qQStrangerPagView.s();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ObjectAnimator invoke() {
                FrameLayout frameLayout;
                frameLayout = QQStrangerSignalPublishGuideHelper.this.maskView;
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(frameLayout, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
                QQStrangerSignalPublishGuideHelper qQStrangerSignalPublishGuideHelper = QQStrangerSignalPublishGuideHelper.this;
                ofFloat.setDuration(400L);
                ofFloat.addListener(new a(qQStrangerSignalPublishGuideHelper));
                return ofFloat;
            }
        });
        this.hideAnimator = lazy3;
    }

    private final void h(ViewGroup rootView, Rect position) {
        if (this.maskView != null) {
            return;
        }
        FrameLayout frameLayout = new FrameLayout(rootView.getContext());
        frameLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, -1));
        frameLayout.setBackgroundColor(Color.parseColor("#80000000"));
        Context context = frameLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QQStrangerPagView qQStrangerPagView = new QQStrangerPagView(context, null, 0, 6, null);
        this.pagView = qQStrangerPagView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(l.b(110), l.b(110));
        layoutParams.gravity = 5;
        int i3 = position.top;
        layoutParams.topMargin = i3 + (((position.bottom - i3) - l.b(110)) / 2);
        layoutParams.setMarginEnd(rootView.getWidth() - position.right);
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(qQStrangerPagView, layoutParams);
        frameLayout.setAlpha(0.0f);
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.publish.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerSignalPublishGuideHelper.i(QQStrangerSignalPublishGuideHelper.this, view);
            }
        });
        this.maskView = frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QQStrangerSignalPublishGuideHelper this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect k(View rootView, View anchorView) {
        Rect rect = new Rect();
        rootView.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        anchorView.getGlobalVisibleRect(rect2);
        if (!rect.contains(rect2)) {
            return null;
        }
        int i3 = rect2.left - rect.left;
        int i16 = rect2.top - rect.top;
        return new Rect(i3, i16, anchorView.getWidth() + i3, anchorView.getHeight() + i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ObjectAnimator l() {
        return (ObjectAnimator) this.hideAnimator.getValue();
    }

    private final Runnable m() {
        return (Runnable) this.hideRunnable.getValue();
    }

    private final ObjectAnimator n() {
        return (ObjectAnimator) this.showAnimator.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        QQStrangerPagView qQStrangerPagView = this.pagView;
        if (qQStrangerPagView != null) {
            qQStrangerPagView.s();
        }
        FrameLayout frameLayout = this.maskView;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FrameLayout frameLayout2 = this.maskView;
        ViewParent parent = frameLayout2 != null ? frameLayout2.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.maskView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(ViewGroup rootView, Rect position) {
        if (this.isShowing.get()) {
            QLog.d("QQStrangerSignalPublishGuideHelper", 2, "showGuideInner isShowing now!");
            return;
        }
        h(rootView, position);
        rootView.addView(this.maskView);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(m());
        n().start();
        ThreadManagerV2.getUIHandlerV2().postDelayed(m(), 2600L);
        com.tencent.mobileqq.matchfriend.reborn.utils.h.f245480a.q();
        this.isShowing.set(true);
    }

    public final void j() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(m());
    }

    public final void p(ViewGroup rootView, View anchorView) {
        if (rootView == null || anchorView == null || this.isShowing.get() || com.tencent.mobileqq.matchfriend.reborn.utils.h.f245480a.j()) {
            return;
        }
        Rect k3 = k(rootView, anchorView);
        if (k3 == null) {
            QLog.e("QQStrangerSignalPublishGuideHelper", 1, "[showGuide] first getPosition is null.");
            anchorView.getViewTreeObserver().addOnGlobalLayoutListener(new b(rootView, anchorView));
        } else {
            q(rootView, k3);
        }
    }
}
