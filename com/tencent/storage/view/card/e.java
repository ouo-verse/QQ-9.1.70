package com.tencent.storage.view.card;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0006\u0010\u0018\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/storage/view/card/e;", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/view/View;", "animationView", "l", "p", "", "size", "unit", "", "animate", "v", "Landroid/view/View$OnClickListener;", "listener", "t", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, DomainData.DOMAIN_NAME, "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "w", "Landroid/content/res/ColorStateList;", "color", "r", "Lcom/tencent/storage/view/card/StorageCardView;", "a", "Lcom/tencent/storage/view/card/StorageCardView;", "cardView", "b", "Z", "isClearAnimating", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "mLottieView", "Lcom/airbnb/lottie/LottieDrawable;", "d", "Lcom/airbnb/lottie/LottieDrawable;", "mLottieDrawable", "<init>", "(Lcom/tencent/storage/view/card/StorageCardView;)V", "e", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StorageCardView cardView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isClearAnimating;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mLottieView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieDrawable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/storage/view/card/e$a;", "", "", "ALPHA_DURATION", "J", "", "LOTTIE_JSON_STORAGE_CLEAR_COMPLETE", "Ljava/lang/String;", "LOTTIE_JSON_STORAGE_CLEAR_LOADING", "PROPERTY_ALPHA", "TAG", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.storage.view.card.e$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/storage/view/card/e$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LottieDrawable f373819d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f373820e;

        b(LottieDrawable lottieDrawable, e eVar) {
            this.f373819d = lottieDrawable;
            this.f373820e = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lottieDrawable, (Object) eVar);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            super.onAnimationEnd(animation);
            this.f373819d.removeAllAnimatorListeners();
            ImageView imageView = this.f373820e.mLottieView;
            if (imageView != null) {
                this.f373820e.p(imageView);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/storage/view/card/e$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f373822e;

        c(View view) {
            this.f373822e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) view);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            super.onAnimationEnd(animation);
            e.this.cardView.m().removeView(this.f373822e);
            e.this.mLottieView = null;
            e.this.mLottieDrawable = null;
            e.this.isClearAnimating = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35499);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull StorageCardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "cardView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cardView);
        } else {
            this.cardView = cardView;
        }
    }

    private final void l(View animationView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ObjectAnimator.ofFloat(this.cardView.n(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(150L), ObjectAnimator.ofFloat(animationView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(150L));
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(e this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLottieDrawable = lottieDrawable;
        ImageView imageView = this$0.mLottieView;
        if (imageView != null) {
            imageView.setImageDrawable(lottieDrawable);
        }
        this$0.z();
        this$0.q();
        lottieDrawable.addAnimatorListener(new b(lottieDrawable, this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(View animationView) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(animationView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f).setDuration(150L), ObjectAnimator.ofFloat(this.cardView.n(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f).setDuration(150L));
        animatorSet.addListener(new c(animationView));
        animatorSet.start();
    }

    private final void q() {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null) {
            Intrinsics.checkNotNull(lottieDrawable);
            if (!lottieDrawable.isAnimating()) {
                LottieDrawable lottieDrawable2 = this.mLottieDrawable;
                Intrinsics.checkNotNull(lottieDrawable2);
                lottieDrawable2.playAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(e this$0, View.OnClickListener listener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (!this$0.isClearAnimating) {
            listener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(e this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLottieDrawable = lottieDrawable;
        ImageView imageView = this$0.mLottieView;
        if (imageView != null) {
            imageView.setImageDrawable(lottieDrawable);
        }
        this$0.z();
        this$0.q();
        ImageView imageView2 = this$0.mLottieView;
        if (imageView2 != null) {
            this$0.l(imageView2);
        }
    }

    private final void z() {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable == null) {
            return;
        }
        Intrinsics.checkNotNull(lottieDrawable);
        if (lottieDrawable.isAnimating()) {
            LottieDrawable lottieDrawable2 = this.mLottieDrawable;
            Intrinsics.checkNotNull(lottieDrawable2);
            lottieDrawable2.stop();
        }
        LottieDrawable lottieDrawable3 = this.mLottieDrawable;
        Intrinsics.checkNotNull(lottieDrawable3);
        lottieDrawable3.setFrame(0);
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.cardView.h();
        }
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            this.cardView.i();
        }
    }

    public final void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.cardView.k();
        }
    }

    public final void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        com.tencent.storage.view.a aVar = com.tencent.storage.view.a.f373651a;
        LottieHelper.b(context, "storage_clear_complete.json", null, aVar.a(), aVar.a(), 0, new LottieHelper.d() { // from class: com.tencent.storage.view.card.c
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                e.o(e.this, lottieDrawable);
            }
        });
    }

    public final void r(@NotNull ColorStateList color) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) color);
        } else {
            Intrinsics.checkNotNullParameter(color, "color");
            this.cardView.setCardBackgroundColor(color);
        }
    }

    public final void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.cardView.setClearCardBtnShow();
        }
    }

    public final void t(@NotNull final View.OnClickListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
        } else {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.cardView.setOperateAction(new View.OnClickListener() { // from class: com.tencent.storage.view.card.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.u(e.this, listener, view);
                }
            });
        }
    }

    public final void v(@NotNull String size, @NotNull String unit, boolean animate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, size, unit, Boolean.valueOf(animate));
            return;
        }
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.cardView.setStorageSize(size, unit, animate);
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.cardView.setloadingGone();
        }
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.isClearAnimating) {
            return;
        }
        this.isClearAnimating = true;
        ImageView imageView = new ImageView(this.cardView.getContext());
        com.tencent.storage.view.a aVar = com.tencent.storage.view.a.f373651a;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar.a(), aVar.a());
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
        imageView.setAlpha(0.0f);
        LottieHelper.b(BaseApplication.getContext(), "storage_clear_loading.json", null, aVar.a(), aVar.a(), -1, new LottieHelper.d() { // from class: com.tencent.storage.view.card.d
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                e.y(e.this, lottieDrawable);
            }
        });
        this.mLottieView = imageView;
        this.cardView.m().addView(this.mLottieView);
    }
}
