package com.tencent.luggage.wxa.e4;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z3.o;
import com.tencent.mobileqq.R;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a extends com.tencent.luggage.wxa.g4.a {

    /* renamed from: g0, reason: collision with root package name */
    public static final C6150a f124486g0 = new C6150a(null);
    public View C;
    public TextView D;
    public ImageView E;
    public Bitmap F;
    public ArrayList G;
    public int H;
    public int I;
    public int J;
    public ValueAnimator K;
    public ValueAnimator L;
    public float M;
    public com.tencent.luggage.wxa.g4.e N;
    public Rect O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;
    public com.tencent.luggage.wxa.e4.c T;
    public int U;
    public Timer V;
    public TimerTask W;

    /* renamed from: a0, reason: collision with root package name */
    public ValueAnimator f124487a0;

    /* renamed from: b0, reason: collision with root package name */
    public AccelerateInterpolator f124488b0;

    /* renamed from: c0, reason: collision with root package name */
    public DecelerateInterpolator f124489c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f124490d0;

    /* renamed from: e0, reason: collision with root package name */
    public PointF f124491e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f124492f0;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f124493m;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.e4.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6150a {
        public C6150a() {
        }

        public /* synthetic */ C6150a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b extends TimerTask {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e4.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6151a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f124495a;

            public RunnableC6151a(a aVar) {
                this.f124495a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f124495a.o();
            }
        }

        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            c0.a(new RunnableC6151a(a.this));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ImageView imageView = a.this.f124493m;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
                imageView = null;
            }
            imageView.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            ImageView imageView = a.this.f124493m;
            ImageView imageView2 = null;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
                imageView = null;
            }
            imageView.setTranslationY(floatValue);
            float height = a.this.O.height() * a.this.M;
            float f16 = floatValue - a.this.O.top;
            if (f16 <= height) {
                float f17 = 1.0f - ((height - f16) / height);
                ImageView imageView3 = a.this.f124493m;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
                } else {
                    imageView2 = imageView3;
                }
                imageView2.setAlpha(f17);
                return;
            }
            float f18 = 1;
            if (f16 < a.this.O.height() * (f18 - a.this.M)) {
                ImageView imageView4 = a.this.f124493m;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
                } else {
                    imageView2 = imageView4;
                }
                imageView2.setAlpha(1.0f);
                return;
            }
            float height2 = 1.0f - ((f16 - (a.this.O.height() * (f18 - a.this.M))) / height);
            ImageView imageView5 = a.this.f124493m;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
            } else {
                imageView2 = imageView5;
            }
            imageView2.setAlpha(height2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class e implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator.AnimatorListener f124498a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f124499b;

        public e(Animator.AnimatorListener animatorListener, a aVar) {
            this.f124498a = animatorListener;
            this.f124499b = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.f124499b.q();
            Animator.AnimatorListener animatorListener = this.f124498a;
            if (animatorListener != null) {
                animatorListener.onAnimationCancel(animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            w.d("Luggage.ScanCodeMaskView", "alvinluo onViewDestroy onAnimationEnd");
            this.f124499b.q();
            Animator.AnimatorListener animatorListener = this.f124498a;
            if (animatorListener != null) {
                animatorListener.onAnimationEnd(animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animator.AnimatorListener animatorListener = this.f124498a;
            if (animatorListener != null) {
                animatorListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animator.AnimatorListener animatorListener = this.f124498a;
            if (animatorListener != null) {
                animatorListener.onAnimationStart(animation);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class f implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f124501b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e4.a$f$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6152a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f124502a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ h f124503b;

            public RunnableC6152a(a aVar, h hVar) {
                this.f124502a = aVar;
                this.f124503b = hVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f124502a.b(this.f124503b);
            }
        }

        public f(h hVar) {
            this.f124501b = hVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            c0.a(new RunnableC6152a(a.this, this.f124501b), 50L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class g implements ValueAnimator.AnimatorUpdateListener {
        public g() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            ArrayList arrayList = a.this.G;
            a aVar = a.this;
            int i3 = 0;
            for (Object obj : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view = (View) obj;
                if (i3 < aVar.J) {
                    view.setScaleX(floatValue);
                    view.setScaleY(floatValue);
                }
                i3 = i16;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class h implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f124505a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f124506b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e4.a$h$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6153a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f124507a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f124508b;

            public RunnableC6153a(int i3, a aVar) {
                this.f124507a = i3;
                this.f124508b = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i3 = this.f124507a;
                if (i3 < 2) {
                    this.f124508b.a(i3 + 1);
                }
            }
        }

        public h(int i3, a aVar) {
            this.f124505a = i3;
            this.f124506b = aVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            c0.a(new RunnableC6153a(this.f124505a, this.f124506b), 50L);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class i implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.b4.e f124510b;

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.e4.a$i$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public static final class RunnableC6154a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f124511a;

            public RunnableC6154a(a aVar) {
                this.f124511a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ViewPropertyAnimator alpha;
                ViewPropertyAnimator duration;
                if (!this.f124511a.b() && this.f124511a.F != null) {
                    Bitmap bitmap = this.f124511a.F;
                    Intrinsics.checkNotNull(bitmap);
                    if (!bitmap.isRecycled()) {
                        ImageView imageView = this.f124511a.E;
                        ImageView imageView2 = null;
                        if (imageView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("frameImage");
                            imageView = null;
                        }
                        imageView.setImageBitmap(this.f124511a.F);
                        ImageView imageView3 = this.f124511a.E;
                        if (imageView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("frameImage");
                            imageView3 = null;
                        }
                        imageView3.setVisibility(0);
                        ImageView imageView4 = this.f124511a.E;
                        if (imageView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("frameImage");
                            imageView4 = null;
                        }
                        imageView4.setAlpha(0.0f);
                        ImageView imageView5 = this.f124511a.E;
                        if (imageView5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("frameImage");
                            imageView5 = null;
                        }
                        ViewPropertyAnimator animate = imageView5.animate();
                        if (animate != null) {
                            animate.cancel();
                        }
                        ImageView imageView6 = this.f124511a.E;
                        if (imageView6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("frameImage");
                        } else {
                            imageView2 = imageView6;
                        }
                        ViewPropertyAnimator animate2 = imageView2.animate();
                        if (animate2 != null && (alpha = animate2.alpha(1.0f)) != null && (duration = alpha.setDuration(200L)) != null) {
                            duration.start();
                        }
                    }
                }
            }
        }

        public i(com.tencent.luggage.wxa.b4.e eVar) {
            this.f124510b = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            a aVar = a.this;
            aVar.F = aVar.a(this.f124510b);
            w.d("Luggage.ScanCodeMaskView", "alvinluo getFrameBitmap cost: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            c0.a(new RunnableC6154a(a.this));
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class j implements View.OnClickListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f124513b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f124514c;

        public j(int i3, Ref.ObjectRef objectRef) {
            this.f124513b = i3;
            this.f124514c = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.U = this.f124513b;
            com.tencent.luggage.wxa.e4.c cVar = a.this.T;
            if (cVar != null) {
                cVar.a(this.f124513b, (View) this.f124514c.element);
            }
            Iterator it = a.this.G.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class k implements Animator.AnimatorListener {
        public k() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            w.e("Luggage.ScanCodeMaskView", "alvinluo showSuccessView onAnimationEnd");
            com.tencent.luggage.wxa.g4.e eVar = a.this.N;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            com.tencent.luggage.wxa.g4.e eVar = a.this.N;
            if (eVar != null) {
                eVar.b();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class l implements ValueAnimator.AnimatorUpdateListener {
        public l() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Object animatedValue = animation.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            TextView scanTips = a.this.getScanTips();
            if (scanTips != null) {
                scanTips.setAlpha(1.0f - floatValue);
            }
            ArrayList arrayList = a.this.G;
            a aVar = a.this;
            int i3 = 0;
            for (Object obj : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                View view = (View) obj;
                if (i3 < aVar.J) {
                    view.setAlpha(floatValue);
                    view.setScaleX(floatValue);
                    view.setScaleY(floatValue);
                }
                i3 = i16;
            }
            if (a.this.Q) {
                TextView textView = a.this.D;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                    textView = null;
                }
                textView.setAlpha(floatValue);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class m implements Animator.AnimatorListener {
        public m() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            a.this.l();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.luggage.wxa.g4.a
    @Nullable
    public View getTargetSuccessMarkView() {
        Object orNull;
        Object orNull2;
        if (this.Q) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.G, this.U);
            return (View) orNull2;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.G, 0);
        return (View) orNull;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getMeasuredWidth() != 0 && getMeasuredWidth() != this.S) {
            this.S = getMeasuredWidth();
            k();
        }
        if (this.f124492f0) {
            PointF pointF = this.f124491e0;
            TextView textView = this.D;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                textView = null;
            }
            pointF.x = textView.getX();
            PointF pointF2 = this.f124491e0;
            TextView textView3 = this.D;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
            } else {
                textView2 = textView3;
            }
            pointF2.y = textView2.getY();
        }
    }

    public final void p() {
        w.a("Luggage.ScanCodeMaskView", "alvinluo startScanLineAnimation");
        this.L.cancel();
        ImageView imageView = this.f124493m;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
            imageView = null;
        }
        imageView.setVisibility(0);
        this.L.start();
    }

    public final void q() {
        w.a("Luggage.ScanCodeMaskView", "alvinluo stopScanLineAnimation");
        this.L.cancel();
    }

    @Override // com.tencent.luggage.wxa.g4.a, com.tencent.luggage.wxa.g4.b
    public void release() {
        super.release();
        i();
        h();
    }

    public final void setAnimationRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.O.set(rect);
        w.a("Luggage.ScanCodeMaskView", "alvinluo setAnimationRect %s", rect);
        ImageView imageView = this.f124493m;
        ViewGroup.LayoutParams layoutParams = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
            imageView = null;
        }
        ImageView imageView2 = this.f124493m;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scanLineImageView");
            imageView2 = null;
        }
        ViewGroup.LayoutParams layoutParams2 = imageView2.getLayoutParams();
        if (layoutParams2 != null) {
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = this.O.left;
            }
            layoutParams = layoutParams2;
        }
        imageView.setLayoutParams(layoutParams);
        ValueAnimator valueAnimator = this.L;
        Rect rect2 = this.O;
        valueAnimator.setFloatValues(rect2.top, rect2.bottom);
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void setBottomExtraHeight(int i3) {
        super.setBottomExtraHeight(i3);
        b(120);
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void setDecodeSuccessFrameData(@Nullable com.tencent.luggage.wxa.b4.e eVar) {
        super.setDecodeSuccessFrameData(eVar);
        com.tencent.luggage.wxa.zp.h.f146825d.execute(new i(eVar));
    }

    public final void setNeedRotate(boolean z16) {
        this.P = z16;
    }

    public final void setSuccessMarkClickListener(@NotNull com.tencent.luggage.wxa.e4.c successMarkClickListener) {
        Intrinsics.checkNotNullParameter(successMarkClickListener, "successMarkClickListener");
        this.T = successMarkClickListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void c(boolean z16) {
        w.a("Luggage.ScanCodeMaskView", "alvinluo fixMultiCodeTipsPosition valid: %b, current: %d", Boolean.valueOf(z16), Integer.valueOf(this.f124490d0));
        this.f124492f0 = false;
        if (!z16 && this.f124490d0 != 32) {
            b(32);
        } else {
            if (!z16 || this.f124490d0 == 120) {
                return;
            }
            b(120);
        }
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void d() {
        super.d();
        q();
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void e() {
        super.e();
        p();
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void f() {
        super.f();
        w.g("Luggage.ScanCodeMaskView", "alvinluo onViewReady hashCode: %d", Integer.valueOf(hashCode()));
    }

    public final View g() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fff, (ViewGroup) null);
        int i3 = this.H;
        addView(view, new RelativeLayout.LayoutParams(i3, i3));
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return view;
    }

    public final void h() {
        ValueAnimator valueAnimator = this.f124487a0;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
        }
        ValueAnimator valueAnimator2 = this.f124487a0;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f124487a0;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.f124487a0 = null;
    }

    public final void i() {
        Timer timer = this.V;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.W;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.V = null;
        this.W = null;
    }

    public final void j() {
        this.K.removeAllListeners();
        this.K.removeAllUpdateListeners();
        this.K.cancel();
    }

    public final void k() {
        int measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        setAnimationRect(new Rect(0, (int) (0.15f * measuredHeight), measuredWidth, (int) (measuredHeight * 0.6f)));
    }

    public final void l() {
        i();
        this.W = new b();
        this.V = new BaseTimer();
        w.a("Luggage.ScanCodeMaskView", "alvinluo initScaleAnimation period: %d", 3350L);
        Timer timer = this.V;
        if (timer != null) {
            timer.scheduleAtFixedRate(this.W, 0L, 3350L);
        }
    }

    public final void m() {
        this.M = 0.16f;
        this.L.setInterpolator(new LinearInterpolator());
        this.L.setDuration(2500L);
        this.L.addListener(new c());
        this.L.addUpdateListener(new d());
        this.L.setRepeatMode(1);
        this.L.setRepeatCount(-1);
    }

    public final void n() {
        Bitmap bitmap = this.F;
        if (bitmap != null) {
            Intrinsics.checkNotNull(bitmap);
            if (bitmap.isRecycled()) {
                return;
            }
            Bitmap bitmap2 = this.F;
            Intrinsics.checkNotNull(bitmap2);
            bitmap2.recycle();
        }
    }

    public final void o() {
        w.a("Luggage.ScanCodeMaskView", "alvinluo runScaleAnimation");
        a(1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.G = new ArrayList();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159553dc1);
        this.H = dimensionPixelSize;
        this.I = (dimensionPixelSize - (getResources().getDimensionPixelSize(R.dimen.bl9) * 2)) + (getResources().getDimensionPixelSize(R.dimen.bpd) * 2);
        this.K = new ValueAnimator();
        this.L = new ValueAnimator();
        this.O = new Rect(0, 0, 0, 0);
        this.U = -1;
        this.f124488b0 = new AccelerateInterpolator(1.5f);
        this.f124489c0 = new DecelerateInterpolator(1.5f);
        this.f124490d0 = 120;
        this.f124491e0 = new PointF();
        this.f124492f0 = true;
        a(context);
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void b(View flashSwitcher) {
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(flashSwitcher, "flashSwitcher");
        super.b(flashSwitcher);
        View flashSwitcher2 = getFlashSwitcher();
        if (flashSwitcher2 == null) {
            return;
        }
        View flashSwitcher3 = getFlashSwitcher();
        if (flashSwitcher3 == null || (layoutParams = flashSwitcher3.getLayoutParams()) == null) {
            layoutParams = null;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.luggage.wxa.kn.a.a(getContext(), 32) + getMBottomExtraHeight();
        }
        flashSwitcher2.setLayoutParams(layoutParams);
    }

    public final void a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.ffe, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.f79554_3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.scan_line)");
        this.f124493m = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.f166346zi4);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.multi_code_mask)");
        this.C = findViewById2;
        View findViewById3 = inflate.findViewById(R.id.zi5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.multi_code_tips)");
        this.D = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.vei);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.frame_image)");
        this.E = (ImageView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f79594_7);
        if (findViewById5 != null) {
            this.G.clear();
            this.G.add(findViewById5);
        }
        k();
        m();
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void b(boolean z16) {
        super.b(z16);
        Iterator it = this.G.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setVisibility(8);
        }
        TextView textView = this.D;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
            textView = null;
        }
        textView.setVisibility(8);
        View view = this.C;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
            view = null;
        }
        view.setVisibility(8);
        ImageView imageView = this.E;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("frameImage");
            imageView = null;
        }
        imageView.setVisibility(8);
        this.R = false;
        this.Q = false;
        if (!z16) {
            TextView scanTips = getScanTips();
            if (scanTips != null) {
                scanTips.setVisibility(0);
            }
            TextView scanTips2 = getScanTips();
            if (scanTips2 != null) {
                scanTips2.setAlpha(1.0f);
            }
        }
        a(this, 0.0f, 1.0f, (Animator.AnimatorListener) null);
        i();
        h();
        j();
    }

    public final void c(Animator.AnimatorListener animatorListener) {
        a(1.0f, 0.8f, this.f124488b0, animatorListener);
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public boolean c() {
        if (this.Q && this.R) {
            return true;
        }
        return super.c();
    }

    @Override // com.tencent.luggage.wxa.g4.a, com.tencent.luggage.wxa.g4.b
    public void a(Animator.AnimatorListener animatorListener) {
        super.a(animatorListener);
        this.L.cancel();
        n();
        a(this, 1.0f, 0.0f, new e(animatorListener, this));
    }

    @Override // com.tencent.luggage.wxa.g4.a
    public void a(Object data, com.tencent.luggage.wxa.g4.e eVar) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(data, "data");
        this.N = eVar;
        if (data instanceof ArrayList) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) data);
            if (firstOrNull instanceof com.tencent.luggage.wxa.b4.d) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : (Iterable) data) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.luggage.scanner.qbar.LuggageQBarResult");
                    com.tencent.luggage.wxa.b4.c cVar = ((com.tencent.luggage.wxa.b4.d) obj).f121843b;
                    if (cVar != null) {
                        Intrinsics.checkNotNullExpressionValue(cVar, "codeResultPoint ?: return@forEach");
                        arrayList.add(a(a(cVar)));
                    }
                }
                a(arrayList);
            }
        }
    }

    public final void b(int i3) {
        w.a("Luggage.ScanCodeMaskView", "alvinluo updateMultiCodeTipsBottomMargin: %d", Integer.valueOf(i3));
        TextView textView = this.D;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
            textView = null;
        }
        TextView textView3 = this.D;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
        } else {
            textView2 = textView3;
        }
        ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            this.f124490d0 = i3;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = com.tencent.luggage.wxa.kn.a.a(getContext(), i3) + getMBottomExtraHeight();
        }
        textView.setLayoutParams(layoutParams);
    }

    public final void b(Animator.AnimatorListener animatorListener) {
        a(0.8f, 1.0f, this.f124489c0, animatorListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v8, types: [T, android.view.View, java.lang.Object] */
    public final void a(ArrayList arrayList) {
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator listener;
        Object firstOrNull;
        ImageView imageView;
        Object orNull;
        ?? orNull2;
        w.d("Luggage.ScanCodeMaskView", "alvinluo showSuccessView pointList %d", Integer.valueOf(arrayList.size()));
        this.J = 0;
        this.R = true;
        Iterator it = arrayList.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            PointF pointF = (PointF) it.next();
            if (pointF != null) {
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(this.G, this.J);
                objectRef.element = orNull2;
                if (orNull2 == 0) {
                    ?? g16 = g();
                    objectRef.element = g16;
                    this.G.add(g16);
                }
                View view = (View) objectRef.element;
                ImageView imageView2 = (ImageView) view.findViewById(R.id.f79594_7);
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.ou6);
                }
                view.setVisibility(0);
                view.setPivotX(this.H / 2.0f);
                view.setPivotY(this.H / 2.0f);
                view.setTranslationX(pointF.x - (this.H / 2));
                view.setTranslationY(pointF.y - (this.H / 2));
                view.setAlpha(0.0f);
                view.setScaleX(0.0f);
                view.setScaleY(0.0f);
                if (!a(pointF.x, pointF.y)) {
                    z16 = false;
                }
                view.setOnClickListener(new j(this.J, objectRef));
                this.J++;
            }
        }
        int size = this.G.size();
        for (int i3 = this.J; i3 < size; i3++) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(this.G, i3);
            View view2 = (View) orNull;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        boolean z17 = this.J > 1;
        this.Q = z17;
        View view3 = null;
        if (!z17) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.G);
            View view4 = (View) firstOrNull;
            if (view4 != null && (imageView = (ImageView) view4.findViewById(R.id.f79594_7)) != null) {
                imageView.setImageResource(R.drawable.ou5);
            }
            View view5 = this.C;
            if (view5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
                view5 = null;
            }
            view5.setVisibility(8);
            TextView textView = this.D;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                textView = null;
            }
            textView.setVisibility(4);
        } else {
            View view6 = this.C;
            if (view6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
                view6 = null;
            }
            view6.setVisibility(0);
            View view7 = this.C;
            if (view7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
                view7 = null;
            }
            view7.setAlpha(0.0f);
            TextView textView2 = this.D;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                textView2 = null;
            }
            textView2.setVisibility(0);
            TextView textView3 = this.D;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                textView3 = null;
            }
            textView3.setAlpha(0.0f);
            c(z16);
        }
        w.d("Luggage.ScanCodeMaskView", "alvinluo showSuccessView isMultiCode: %b, pointCount: %d, successMarkViewList: %d, tipsPositionValid: %b", Boolean.valueOf(this.Q), Integer.valueOf(this.J), Integer.valueOf(this.G.size()), Boolean.valueOf(z16));
        ValueAnimator valueAnimator = this.K;
        valueAnimator.removeAllUpdateListeners();
        valueAnimator.removeAllListeners();
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(300L);
        valueAnimator.addListener(new k());
        valueAnimator.addUpdateListener(new l());
        valueAnimator.start();
        if (this.Q) {
            View view8 = this.C;
            if (view8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeBgMask");
            } else {
                view3 = view8;
            }
            ViewPropertyAnimator animate = view3.animate();
            if (animate == null || (alpha = animate.alpha(1.0f)) == null || (interpolator = alpha.setInterpolator(new LinearInterpolator())) == null || (duration = interpolator.setDuration(600L)) == null || (listener = duration.setListener(new m())) == null) {
                return;
            }
            listener.start();
        }
    }

    public final boolean a(float f16, float f17) {
        Object[] objArr = new Object[6];
        objArr[0] = Float.valueOf(f16);
        objArr[1] = Float.valueOf(f17);
        objArr[2] = Float.valueOf(this.f124491e0.x);
        objArr[3] = Float.valueOf(this.f124491e0.y);
        TextView textView = this.D;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
            textView = null;
        }
        objArr[4] = Integer.valueOf(textView.getMeasuredWidth());
        TextView textView3 = this.D;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
            textView3 = null;
        }
        objArr[5] = Integer.valueOf(textView3.getMeasuredHeight());
        w.d("Luggage.ScanCodeMaskView", "alvinluo checkMultiCodeTipsPositionValid [%s, %s], multiCodeTips: [%s, %s], [%s, %s]", objArr);
        float f18 = this.I / 2;
        float f19 = f16 + f18;
        float f26 = this.f124491e0.x;
        if (f19 >= f26) {
            float f27 = f16 - f18;
            TextView textView4 = this.D;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                textView4 = null;
            }
            if (f27 <= f26 + textView4.getMeasuredWidth()) {
                float f28 = this.I / 2;
                float f29 = f17 + f28;
                float f36 = this.f124491e0.y;
                if (f29 >= f36) {
                    float f37 = f17 - f28;
                    TextView textView5 = this.D;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("multiCodeTips");
                    } else {
                        textView2 = textView5;
                    }
                    if (f37 <= f36 + textView2.getMeasuredHeight()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final void a(int i3) {
        w.a("Luggage.ScanCodeMaskView", "alvinluo runZoomAnimation %d", Integer.valueOf(i3));
        c(new f(new h(i3, this)));
    }

    public final void a(float f16, float f17, Interpolator interpolator, Animator.AnimatorListener animatorListener) {
        w.a("Luggage.ScanCodeMaskView", "alvinluo runZoomAnimation from: %f, to: %f", Float.valueOf(f16), Float.valueOf(f17));
        h();
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f124487a0 = valueAnimator;
        valueAnimator.setFloatValues(f16, f17);
        valueAnimator.setInterpolator(interpolator);
        valueAnimator.setDuration(300L);
        valueAnimator.addUpdateListener(new g());
        valueAnimator.addListener(animatorListener);
        valueAnimator.start();
    }

    public final PointF a(com.tencent.luggage.wxa.b4.c cVar) {
        if (cVar.point_cnt != 4 || getMPreviewRect() == null || getScanCamera() == null) {
            return null;
        }
        o scanCamera = getScanCamera();
        Intrinsics.checkNotNull(scanCamera);
        if (scanCamera.i() && this.P) {
            float f16 = cVar.f342416x0 + cVar.f342417x1 + cVar.f342418x2 + cVar.f342419x3;
            Intrinsics.checkNotNull(getMPreviewRect());
            float height = f16 / (r3.height() * 4);
            float f17 = cVar.f342420y0 + cVar.f342421y1 + cVar.f342422y2 + cVar.f342423y3;
            Intrinsics.checkNotNull(getMPreviewRect());
            return new PointF(height, f17 / (r6.width() * 4));
        }
        float f18 = cVar.f342416x0 + cVar.f342417x1 + cVar.f342418x2 + cVar.f342419x3;
        Intrinsics.checkNotNull(getMPreviewRect());
        float width = f18 / (r3.width() * 4);
        float f19 = cVar.f342420y0 + cVar.f342421y1 + cVar.f342422y2 + cVar.f342423y3;
        Intrinsics.checkNotNull(getMPreviewRect());
        return new PointF(width, f19 / (r6.height() * 4));
    }

    public final PointF a(PointF pointF) {
        if (pointF == null || getMScanRect() == null) {
            return null;
        }
        float f16 = pointF.x;
        Intrinsics.checkNotNull(getMScanRect());
        float width = f16 * r2.width();
        Intrinsics.checkNotNull(getMScanRect());
        float f17 = width + r2.left;
        float f18 = pointF.y;
        Intrinsics.checkNotNull(getMScanRect());
        float height = f18 * r2.height();
        Intrinsics.checkNotNull(getMScanRect());
        return new PointF(f17, height + r2.top);
    }

    public final Bitmap a(com.tencent.luggage.wxa.b4.e eVar) {
        byte[] c16;
        try {
            o scanCamera = getScanCamera();
            Intrinsics.checkNotNull(scanCamera);
            int l3 = scanCamera.l();
            o scanCamera2 = getScanCamera();
            Intrinsics.checkNotNull(scanCamera2);
            Point d16 = scanCamera2.d();
            if (eVar == null || (c16 = eVar.c()) == null) {
                return null;
            }
            w.d("Luggage.ScanCodeMaskView", "alvinluo getFrameBitmap data length: %d, size: %d, %d, rotation: %d, previewFormat: %d", Integer.valueOf(c16.length), Integer.valueOf(eVar.d()), Integer.valueOf(eVar.b()), Integer.valueOf(eVar.a()), Integer.valueOf(l3));
            YuvImage yuvImage = new YuvImage(eVar.c(), l3, d16.x, d16.y, null);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, d16.x, d16.y), 100, byteArrayOutputStream);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
            if (decodeByteArray == null || decodeByteArray.isRecycled()) {
                return null;
            }
            w.d("Luggage.ScanCodeMaskView", "alvinluo getFrameBitmap bitmap width: %d, height: %d", Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(decodeByteArray.getHeight()));
            return eVar.a() != 0 ? a(decodeByteArray, eVar.a(), getMeasuredWidth(), getMeasuredHeight()) : decodeByteArray;
        } catch (Exception e16) {
            w.a("Luggage.ScanCodeMaskView", e16, "alvinluo getFrameBitmap exception", new Object[0]);
            return null;
        }
    }

    public final Bitmap a(Bitmap bitmap, int i3, int i16, int i17) {
        Bitmap createBitmap;
        if (bitmap == null) {
            return null;
        }
        w.d("Luggage.ScanCodeMaskView", "alvinlu rotateAndScaleBitmap rotation: %d, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        Matrix matrix = new Matrix();
        matrix.postRotate(i3);
        boolean z16 = i3 % 180 != 0;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int height2 = z16 ? bitmap.getHeight() : bitmap.getWidth();
        int width2 = z16 ? bitmap.getWidth() : bitmap.getHeight();
        if (i16 != 0 && i17 != 0) {
            float f16 = height2;
            float f17 = width2;
            float f18 = (i16 * 1.0f) / i17;
            if ((f16 * 1.0f) / f17 > f18) {
                width = (int) (f18 * f17);
                height = width2;
            } else {
                height = (int) (f16 / f18);
                width = height2;
            }
        }
        int max = Math.max(0, (height2 - width) / 2);
        int max2 = Math.max(0, (width2 - height) / 2);
        w.d("Luggage.ScanCodeMaskView", "alvinluo rotateAndScaleBitmap finalWidth: %d, finalHeight: %d, x: %d, y: %d", Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(max), Integer.valueOf(max2));
        if (z16) {
            createBitmap = Bitmap.createBitmap(bitmap, max2, max, height, width, matrix, true);
        } else {
            createBitmap = Bitmap.createBitmap(bitmap, max, max2, width, height, matrix, true);
        }
        Intrinsics.checkNotNullExpressionValue(createBitmap, "if (needRotate) {\n      \u2026, matrix, true)\n        }");
        if (!Intrinsics.areEqual(createBitmap, bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
