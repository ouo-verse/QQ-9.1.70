package com.tencent.luggage.wxa.y4;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.luggage.wxa.fr.a;
import com.tencent.luggage.wxa.h6.h;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.ic.g;
import com.tencent.luggage.wxa.kj.p;
import com.tencent.luggage.wxa.kl.i;
import com.tencent.luggage.wxa.lo.i;
import com.tencent.luggage.wxa.tn.c0;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.modelappbrand.image.WxaIconTransformation;
import com.tencent.mm.plugin.appbrand.ui.WxaDefaultIcon;
import com.tencent.mm.ui.statusbar.DrawStatusBarFrameLayout;
import com.tencent.mobileqq.R;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a extends com.tencent.luggage.wxa.fr.a implements DialogInterface {
    public DialogInterface.OnClickListener P;
    public DialogInterface.OnClickListener Q;
    public Animation R;
    public Animation S;
    public p T;
    public DrawStatusBarFrameLayout U;
    public com.tencent.luggage.wxa.kl.b V;
    public ImageView W;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.y4.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C6934a implements a.e {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.y4.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class RunnableC6935a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f145417a;

            public RunnableC6935a(a aVar) {
                this.f145417a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ViewGroup viewGroup;
                ViewParent parent = this.f145417a.getParent();
                if (parent instanceof ViewGroup) {
                    viewGroup = (ViewGroup) parent;
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    viewGroup.removeView(this.f145417a);
                }
            }
        }

        public C6934a() {
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public int a(boolean z16) {
            return 1;
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public boolean c() {
            return false;
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(int i3) {
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(int i3, float f16) {
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(MotionEvent motionEvent) {
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void a(View view, int i3, int i16) {
        }

        @Override // com.tencent.luggage.wxa.fr.a.e
        public void a() {
            a.this.setVisibility(8);
            a aVar = a.this;
            aVar.post(new RunnableC6935a(aVar));
        }

        @Override // com.tencent.luggage.wxa.fr.a.d
        public void b() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            a.this.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            g runtime;
            p pVar = a.this.T;
            if (pVar != null && (runtime = pVar.getRuntime()) != null) {
                com.tencent.luggage.wxa.ic.e.a(runtime.getAppId(), e.d.CLOSE);
                runtime.o();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DialogInterface.OnClickListener positiveButton = a.this.getPositiveButton();
            if (positiveButton != null) {
                positiveButton.onClick(a.this, -1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(context, "context");
        a(new C6934a());
        DrawStatusBarFrameLayout drawStatusBarFrameLayout = new DrawStatusBarFrameLayout(context);
        drawStatusBarFrameLayout.setClickable(true);
        drawStatusBarFrameLayout.setBackgroundColor(context.getResources().getColor(R.color.f158017al3));
        drawStatusBarFrameLayout.setWillNotDraw(false);
        drawStatusBarFrameLayout.a(false);
        drawStatusBarFrameLayout.a(0, true ^ i.g());
        this.U = drawStatusBarFrameLayout;
        addView(drawStatusBarFrameLayout, new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.U);
        com.tencent.luggage.wxa.kl.b bVar = new com.tencent.luggage.wxa.kl.b(context);
        bVar.setFullscreenMode(false);
        bVar.setBackButtonClickListener(new b());
        bVar.setCloseButtonClickListener(new c());
        DrawStatusBarFrameLayout drawStatusBarFrameLayout2 = this.U;
        Intrinsics.checkNotNull(drawStatusBarFrameLayout2);
        drawStatusBarFrameLayout2.addView(bVar, new FrameLayout.LayoutParams(-1, com.tencent.luggage.wxa.il.b.a(context)));
        this.V = bVar;
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167648dy1, (ViewGroup) this.U, false);
        ((TextView) inflate.findViewById(R.id.sqx)).setText(R.string.yzj);
        ((TextView) inflate.findViewById(R.id.sqv)).setText(R.string.yzi);
        DrawStatusBarFrameLayout drawStatusBarFrameLayout3 = this.U;
        Intrinsics.checkNotNull(drawStatusBarFrameLayout3);
        drawStatusBarFrameLayout3.addView(inflate);
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = com.tencent.luggage.wxa.il.b.a(context);
        }
        this.W = (ImageView) findViewById(R.id.sqw);
        findViewById(R.id.sqv).setOnClickListener(new d());
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        dismiss();
        DialogInterface.OnClickListener onClickListener = this.Q;
        if (onClickListener != null) {
            onClickListener.onClick(this, -2);
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        Animation animation = this.R;
        if (animation != null) {
            animation.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.luggage.wxa.lo.g.f133712d);
        this.R = loadAnimation;
        Intrinsics.checkNotNull(loadAnimation);
        loadAnimation.setAnimationListener(new e());
        Animation animation2 = this.R;
        Intrinsics.checkNotNull(animation2);
        startAnimation(animation2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        boolean z16;
        if (this.R != null || this.S != null) {
            return true;
        }
        boolean z17 = false;
        if (keyEvent != null && keyEvent.getAction() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (keyEvent != null && keyEvent.getKeyCode() == 4) {
                z17 = true;
            }
            if (z17) {
                h.a(getContext());
                dismiss();
                return true;
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // com.tencent.luggage.wxa.fr.a, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.R == null && this.S == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public final void g() {
        Animation animation = getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        Animation animation2 = getAnimation();
        ViewGroup viewGroup = null;
        if (animation2 != null) {
            animation2.setAnimationListener(null);
        }
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        com.tencent.luggage.wxa.kl.b bVar = this.V;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Nullable
    public final DialogInterface.OnClickListener getNegativeButton() {
        return this.Q;
    }

    @Nullable
    public final DialogInterface.OnClickListener getPositiveButton() {
        return this.P;
    }

    public final void h() {
        setVisibility(8);
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
    }

    public final void setNegativeButton(@Nullable DialogInterface.OnClickListener onClickListener) {
        this.Q = onClickListener;
    }

    public final void setPositiveButton(@Nullable DialogInterface.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public final void a(g gVar) {
        com.tencent.luggage.wxa.kl.b bVar = this.V;
        if (bVar != null) {
            com.tencent.luggage.wxa.fd.i S = gVar.S();
            String str = S != null ? S.f125809b : null;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "runtime.initConfig?.brandName ?: \"\"");
            }
            bVar.setMainTitle(str);
            bVar.setBackgroundColor(0);
            bVar.setForegroundStyle(!i.g());
            bVar.a(true, i.a.EnumC6399a.PageConfig);
        }
        ImageView imageView = this.W;
        if (imageView != null) {
            ColorMatrix colorMatrix = new ColorMatrix();
            colorMatrix.setSaturation(0.0f);
            imageView.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
            AppBrandSimpleImageLoader instance = AppBrandSimpleImageLoader.instance();
            com.tencent.luggage.wxa.fd.i S2 = gVar.S();
            instance.attach(imageView, S2 != null ? S2.f125810c : null, WxaDefaultIcon.get(), WxaIconTransformation.INSTANCE);
        }
    }

    public final void a(p pageContainer, Runnable runnable) {
        Intrinsics.checkNotNullParameter(pageContainer, "pageContainer");
        this.T = pageContainer;
        pageContainer.addView(this, new FrameLayout.LayoutParams(-1, -1));
        bringToFront();
        g runtime = pageContainer.getRuntime();
        Intrinsics.checkNotNull(runtime);
        a(runtime);
        Animation animation = this.S;
        if (animation != null) {
            animation.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.luggage.wxa.lo.g.f133709a);
        this.S = loadAnimation;
        Intrinsics.checkNotNull(loadAnimation);
        loadAnimation.setAnimationListener(new f(runnable));
        Animation animation2 = this.S;
        Intrinsics.checkNotNull(animation2);
        startAnimation(animation2);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class e implements Animation.AnimationListener {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.y4.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class RunnableC6936a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f145422a;

            public RunnableC6936a(a aVar) {
                this.f145422a = aVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f145422a.g();
            }
        }

        public e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.setVisibility(8);
            c0.a(new RunnableC6936a(a.this));
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class f implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f145424b;

        public f(Runnable runnable) {
            this.f145424b = runnable;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.S = null;
            Runnable runnable = this.f145424b;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
