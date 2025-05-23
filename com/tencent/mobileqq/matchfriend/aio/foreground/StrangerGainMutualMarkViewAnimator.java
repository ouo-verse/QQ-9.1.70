package com.tencent.mobileqq.matchfriend.aio.foreground;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.airbnb.lottie.LottieAnimationView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.ag;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkView;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.aio.utils.l;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020\u001f\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0014\u0010\u0017\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015J\u0014\u0010\u0018\u001a\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u001b\u0010/\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u0010&\u001a\u0004\b2\u00103R\u001b\u00108\u001a\u0002058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010&\u001a\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u00109R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00109R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010<R\u001e\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010<\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkViewAnimator;", "", "Landroid/animation/Animator;", tl.h.F, DomainData.DOMAIN_NAME, "p", "l", "i", "k", "o", "j", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "markView", "Landroid/graphics/Point;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "E", "g", UserInfo.SEX_FEMALE, "Lkotlin/Function0;", "end", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView;", "a", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView;", "B", "()Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView;", "view", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "b", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "y", "()Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;", "model", "c", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Landroid/view/View;", "maskView", "d", "w", "markIconView", "e", "u", "congratulationsLayout", "Landroid/widget/ImageView;", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Landroid/widget/ImageView;", "rotationView", "Lcom/airbnb/lottie/LottieAnimationView;", "v", "()Lcom/airbnb/lottie/LottieAnimationView;", "lottieView", "Landroid/animation/Animator;", "appearAnimator", "disappearAnimator", "Lkotlin/jvm/functions/Function0;", "onAppearAnimatorEnd", "onDisappearAnimatorEnd", "<init>", "(Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView;Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkView$a;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StrangerGainMutualMarkViewAnimator {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final StrangerGainMutualMarkView view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final StrangerGainMutualMarkView.StrangerGainMutualMarkModel model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy maskView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy markIconView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy congratulationsLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy rotationView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy lottieView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Animator appearAnimator;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Animator disappearAnimator;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onAppearAnimatorEnd;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onDisappearAnimatorEnd;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnStart$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            StrangerGainMutualMarkViewAnimator.this.w().setVisibility(0);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            Function0 function0 = StrangerGainMutualMarkViewAnimator.this.onAppearAnimatorEnd;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t\u00b8\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animator", "", "onAnimationRepeat", "onAnimationEnd", "onAnimationCancel", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$1"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements Animator.AnimatorListener {
        public c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            StrangerGainMutualMarkViewAnimator.this.g();
            Function0 function0 = StrangerGainMutualMarkViewAnimator.this.onDisappearAnimatorEnd;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }
    }

    public StrangerGainMutualMarkViewAnimator(StrangerGainMutualMarkView view, StrangerGainMutualMarkView.StrangerGainMutualMarkModel model) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(model, "model");
        this.view = view;
        this.model = model;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkViewAnimator$maskView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return StrangerGainMutualMarkViewAnimator.this.getView().findViewById(R.id.oqm);
            }
        });
        this.maskView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkViewAnimator$markIconView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return StrangerGainMutualMarkViewAnimator.this.getView().findViewById(R.id.oqn);
            }
        });
        this.markIconView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkViewAnimator$congratulationsLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return StrangerGainMutualMarkViewAnimator.this.getView().findViewById(R.id.oqj);
            }
        });
        this.congratulationsLayout = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkViewAnimator$rotationView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) StrangerGainMutualMarkViewAnimator.this.getView().findViewById(R.id.oql);
            }
        });
        this.rotationView = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<LottieAnimationView>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkViewAnimator$lottieView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LottieAnimationView invoke() {
                return (LottieAnimationView) StrangerGainMutualMarkViewAnimator.this.getView().findViewById(R.id.olt);
            }
        });
        this.lottieView = lazy5;
    }

    private final Point A(View markView) {
        Point aIOTitleMutualMarkLocation = ((IQQStrangerForegroundApi) QRoute.api(IQQStrangerForegroundApi.class)).getAIOTitleMutualMarkLocation();
        if (aIOTitleMutualMarkLocation == null) {
            aIOTitleMutualMarkLocation = new Point();
        }
        int[] iArr = new int[2];
        markView.getLocationOnScreen(iArr);
        aIOTitleMutualMarkLocation.offset(-(iArr[0] + (markView.getWidth() / 2)), -(iArr[1] + (markView.getHeight() / 2)));
        return aIOTitleMutualMarkLocation;
    }

    private final Animator h() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(n(), p(), i(), l());
        return animatorSet;
    }

    private final Animator i() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(u(), "translationY", l.a(160.0f), 0.0f);
        he0.b.l(ofFloat, R.anim.f154986ut);
        ofFloat.setDuration(240L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(u(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setDuration(150L);
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private final Animator j() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(u(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(150L);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(congratulationsL\u2026 duration = 150\n        }");
        return ofFloat;
    }

    private final Animator k() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(o(), j(), r(), m());
        return animatorSet;
    }

    private final Animator l() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(z(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(z(), BasicAnimation.KeyPath.ROTATION, 0.0f, 120.0f);
        ofFloat2.setDuration(2000L);
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private final Animator m() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(z(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(rotationView, \"a\u2026 duration = 200\n        }");
        return ofFloat;
    }

    private final Animator n() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(x(), com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat.setDuration(240L);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(maskView, \"alpha\u2026 duration = 240\n        }");
        return ofFloat;
    }

    private final Animator o() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(x(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(maskView, \"alpha\u2026 duration = 200\n        }");
        return ofFloat;
    }

    private final Animator p() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(w(), "translationY", l.a(253.0f), 0.0f);
        he0.b.l(ofFloat, R.anim.f154986ut);
        ofFloat.setDuration(240L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.7f, 1.0f);
        he0.b.l(ofFloat2, R.anim.f154980un);
        ofFloat2.setDuration(240L);
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.h
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                StrangerGainMutualMarkViewAnimator.q(StrangerGainMutualMarkViewAnimator.this, valueAnimator);
            }
        });
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat3.setDuration(200L);
        animatorSet.addListener(new a());
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(StrangerGainMutualMarkViewAnimator this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View w3 = this$0.w();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        w3.setScaleX(((Float) animatedValue).floatValue());
        View w16 = this$0.w();
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        w16.setScaleY(((Float) animatedValue2).floatValue());
    }

    private final Animator r() {
        if (this.model.getNeedMutualMarkViewTranslationAnimator()) {
            AnimatorSet animatorSet = new AnimatorSet();
            Point A = A(w());
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(w(), "translationX", A.x);
            he0.b.l(ofFloat, R.anim.f154977uk);
            ofFloat.setDuration(500L);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(w(), "translationY", A.y);
            he0.b.l(ofFloat2, R.anim.f154977uk);
            ofFloat2.setDuration(500L);
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.11111111f);
            he0.b.l(ofFloat3, R.anim.f154977uk);
            ofFloat3.setDuration(500L);
            ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StrangerGainMutualMarkViewAnimator.s(StrangerGainMutualMarkViewAnimator.this, valueAnimator);
                }
            });
            ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.11111111f, 0.13333334f);
            he0.b.l(ofFloat4, R.anim.f154980un);
            ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.j
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    StrangerGainMutualMarkViewAnimator.t(StrangerGainMutualMarkViewAnimator.this, valueAnimator);
                }
            });
            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).before(ofFloat4);
            return animatorSet;
        }
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(w(), com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat5, "{\n            ObjectAnim\u20260\n            }\n        }");
        return ofFloat5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(StrangerGainMutualMarkViewAnimator this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View w3 = this$0.w();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        w3.setScaleX(((Float) animatedValue).floatValue());
        View w16 = this$0.w();
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        w16.setScaleY(((Float) animatedValue2).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(StrangerGainMutualMarkViewAnimator this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View w3 = this$0.w();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        w3.setScaleX(((Float) animatedValue).floatValue());
        View w16 = this$0.w();
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Float");
        w16.setScaleY(((Float) animatedValue2).floatValue());
    }

    private final View u() {
        Object value = this.congratulationsLayout.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-congratulationsLayout>(...)");
        return (View) value;
    }

    private final LottieAnimationView v() {
        Object value = this.lottieView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-lottieView>(...)");
        return (LottieAnimationView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View w() {
        Object value = this.markIconView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-markIconView>(...)");
        return (View) value;
    }

    private final View x() {
        Object value = this.maskView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-maskView>(...)");
        return (View) value;
    }

    private final ImageView z() {
        Object value = this.rotationView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rotationView>(...)");
        return (ImageView) value;
    }

    /* renamed from: B, reason: from getter */
    public final StrangerGainMutualMarkView getView() {
        return this.view;
    }

    public final void C(Function0<Unit> end) {
        Intrinsics.checkNotNullParameter(end, "end");
        this.onAppearAnimatorEnd = end;
    }

    public final void D(Function0<Unit> end) {
        Intrinsics.checkNotNullParameter(end, "end");
        this.onDisappearAnimatorEnd = end;
    }

    public final void E() {
        Animator h16 = h();
        if (this.model.getNeedMutualMarkViewTranslationAnimator()) {
            A(w());
        }
        h16.addListener(new b());
        h16.start();
        this.appearAnimator = h16;
        if (this.model.getNeedLottieAnimation()) {
            ag.c(ag.f194106a, v(), this.model.getLottieJsonRes(), null, 4, null);
        }
    }

    public final void F() {
        Animator k3 = k();
        k3.addListener(new c());
        k3.start();
        this.disappearAnimator = k3;
    }

    public final void g() {
        Animator animator = this.appearAnimator;
        if (animator != null) {
            animator.cancel();
        }
        this.appearAnimator = null;
    }

    /* renamed from: y, reason: from getter */
    public final StrangerGainMutualMarkView.StrangerGainMutualMarkModel getModel() {
        return this.model;
    }
}
