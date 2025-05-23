package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.MusicDanceDrawable;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.list.DefaultItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSmallScreenRelativeLayout extends BaseColorNoteSmallScreenRelativeLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, m {
    private static int[] D0 = {0, 9, 5, 3};
    private static float[] E0 = {0.0f, 0.0f, 2.0f, 1.0f, 1.0f, 3.0f, 2.0f, 2.5f, 2.0f};
    private int A0;
    private LottieDrawable B0;
    private boolean C;
    private Cancellable C0;
    private boolean D;
    private boolean E;
    private long F;
    private boolean G;
    private boolean H;
    private final int I;
    private final int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f201564a0;

    /* renamed from: b0, reason: collision with root package name */
    private Point f201565b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f201566c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f201567d0;

    /* renamed from: e, reason: collision with root package name */
    private da1.a f201568e;

    /* renamed from: e0, reason: collision with root package name */
    private int f201569e0;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f201570f;

    /* renamed from: f0, reason: collision with root package name */
    private f f201571f0;

    /* renamed from: g0, reason: collision with root package name */
    private Point f201572g0;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f201573h;

    /* renamed from: h0, reason: collision with root package name */
    private CheckForLongPress f201574h0;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f201575i;

    /* renamed from: i0, reason: collision with root package name */
    private MqqHandler f201576i0;

    /* renamed from: j0, reason: collision with root package name */
    private LinearLayout f201577j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f201578k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f201579l0;

    /* renamed from: m, reason: collision with root package name */
    private Display f201580m;

    /* renamed from: m0, reason: collision with root package name */
    private MusicDanceImageView f201581m0;

    /* renamed from: n0, reason: collision with root package name */
    private MusicDanceImageView f201582n0;

    /* renamed from: o0, reason: collision with root package name */
    private RelativeLayout f201583o0;

    /* renamed from: p0, reason: collision with root package name */
    private LinearLayout f201584p0;

    /* renamed from: q0, reason: collision with root package name */
    private List<ColorNote> f201585q0;

    /* renamed from: r0, reason: collision with root package name */
    private com.tencent.mobileqq.colornote.anim.b f201586r0;

    /* renamed from: s0, reason: collision with root package name */
    private com.tencent.mobileqq.colornote.anim.b f201587s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f201588t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f201589u0;

    /* renamed from: v0, reason: collision with root package name */
    private int f201590v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f201591w0;

    /* renamed from: x0, reason: collision with root package name */
    private p f201592x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f201593y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f201594z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout$6, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f201595d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f201596e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f201597f;

        AnonymousClass6(String str, String str2, boolean z16) {
            this.f201595d = str;
            this.f201596e = str2;
            this.f201597f = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InputStream open = ColorNoteSmallScreenRelativeLayout.this.getContext().getAssets().open(this.f201595d);
                ColorNoteSmallScreenRelativeLayout.this.C0 = LottieComposition.Factory.fromInputStream(open, new OnCompositionLoadedListener() { // from class: com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.6.1
                    @Override // com.airbnb.lottie.OnCompositionLoadedListener
                    public void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (lottieComposition == null) {
                            QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "getLottieDrawable onCompositionLoaded failed");
                            return;
                        }
                        LottieDrawable lottieDrawable = new LottieDrawable();
                        lottieDrawable.setComposition(lottieComposition);
                        lottieDrawable.setImagesAssetsFolder(AnonymousClass6.this.f201596e);
                        ColorNoteSmallScreenRelativeLayout.this.B0 = lottieDrawable;
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                if (!anonymousClass6.f201597f) {
                                    ColorNoteSmallScreenRelativeLayout.this.c0();
                                }
                            }
                        });
                    }
                });
            } catch (Throwable th5) {
                QLog.e("ColorNoteSmallScreenRelativeLayout", 2, "load lottie failed", th5);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private final class CheckForLongPress implements Runnable {
        CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ColorNoteSmallScreenRelativeLayout.this.f201568e != null) {
                ColorNoteSmallScreenRelativeLayout.this.E = true;
                ColorNoteSmallScreenRelativeLayout.this.G = true;
                ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout = ColorNoteSmallScreenRelativeLayout.this;
                colorNoteSmallScreenRelativeLayout.K = colorNoteSmallScreenRelativeLayout.N;
                ColorNoteSmallScreenRelativeLayout.this.f201568e.onLongClick();
                ColorNoteSmallScreenRelativeLayout.this.f201575i.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ColorNoteSmallScreenRelativeLayout.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ColorNoteSmallScreenRelativeLayout.this.d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ColorNoteSmallScreenRelativeLayout.this.getViewTreeObserver().removeOnPreDrawListener(this);
            ColorNoteSmallScreenRelativeLayout.this.d0();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ColorNoteSmallScreenRelativeLayout f201604d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Point f201605e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LinearLayout.LayoutParams f201606f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f201607h;

        d(ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout, Point point, LinearLayout.LayoutParams layoutParams, int i3) {
            this.f201604d = colorNoteSmallScreenRelativeLayout;
            this.f201605e = point;
            this.f201606f = layoutParams;
            this.f201607h = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) ((ColorNoteSmallScreenRelativeLayout.this.M / 2) * ((Float) valueAnimator.getAnimatedValue()).floatValue());
            ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout = ColorNoteSmallScreenRelativeLayout.this;
            int Q = colorNoteSmallScreenRelativeLayout.Q();
            colorNoteSmallScreenRelativeLayout.K = Q;
            int i3 = ColorNoteSmallScreenRelativeLayout.this.L;
            if (ColorNoteSmallScreenRelativeLayout.this.f201568e != null) {
                da1.a aVar = ColorNoteSmallScreenRelativeLayout.this.f201568e;
                ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout2 = this.f201604d;
                Point point = this.f201605e;
                int i16 = point.x;
                int i17 = point.y;
                aVar.h(colorNoteSmallScreenRelativeLayout2, i16 - floatValue, i17, (i16 + Q) - floatValue, i17 + i3);
            }
            this.f201606f.leftMargin = this.f201607h + floatValue;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class f extends OrientationEventListener {
        public f(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            ColorNoteSmallScreenRelativeLayout.this.Z();
        }
    }

    public ColorNoteSmallScreenRelativeLayout(Context context) {
        this(context, null);
    }

    private void K(boolean z16, int i3) {
        MusicDanceDrawable musicDanceDrawable;
        if (i3 == 1) {
            musicDanceDrawable = new MusicDanceDrawable();
        } else {
            musicDanceDrawable = null;
        }
        if (musicDanceDrawable == null) {
            return;
        }
        if (z16) {
            this.f201586r0 = musicDanceDrawable;
            musicDanceDrawable.a(getContext(), x.c(getContext(), 15.0f), x.c(getContext(), 9.5f), getContext().getResources().getColor(R.color.f156953am0));
            this.f201582n0.setImageDrawable(musicDanceDrawable);
        } else {
            this.f201587s0 = musicDanceDrawable;
            musicDanceDrawable.a(getContext(), x.c(getContext(), 15.0f), x.c(getContext(), 9.5f), getContext().getResources().getColor(R.color.f156953am0));
            this.f201581m0.setImageDrawable(musicDanceDrawable);
        }
    }

    private SmallColorNoteItem L(ColorNote colorNote, ViewGroup viewGroup) {
        SmallColorNoteItem smallColorNoteItem = new SmallColorNoteItem(getContext(), k(), viewGroup);
        smallColorNoteItem.setAttachLeft(k());
        View findViewById = smallColorNoteItem.b().findViewById(R.id.lxv);
        new DefaultItemBuilder().f(colorNote, findViewById, (ImageView) smallColorNoteItem.b().findViewById(R.id.lxw), k());
        View findViewById2 = findViewById.findViewById(R.id.f166424ly2);
        View findViewById3 = findViewById.findViewById(R.id.f166423ly1);
        ViewCompat.setImportantForAccessibility(smallColorNoteItem, 2);
        ViewCompat.setImportantForAccessibility(findViewById2, 2);
        ViewCompat.setImportantForAccessibility(findViewById3, 2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewById(R.id.cgl).getLayoutParams();
        if (k()) {
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(11, 0);
            layoutParams.addRule(9);
        }
        return smallColorNoteItem;
    }

    private int O(int i3) {
        if (i3 > 0 && i3 < 4) {
            return x.c(getContext(), D0[i3]);
        }
        return x.c(getContext(), 4.0f);
    }

    private float R(int i3) {
        int dimensionPixelSize;
        if (i3 > 0 && i3 < 9) {
            dimensionPixelSize = x.c(getContext(), E0[i3]);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b85);
        }
        return dimensionPixelSize;
    }

    private int S() {
        return this.f201578k0;
    }

    private int T() {
        try {
            return this.f201580m.getRotation();
        } catch (Exception e16) {
            QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "[getSysRotation]", e16.getMessage());
            return 0;
        }
    }

    private boolean W() {
        if (this.f201578k0 == 2) {
            return true;
        }
        return false;
    }

    private void X(Context context, String str, String str2, boolean z16) {
        if (this.B0 != null) {
            if (!z16) {
                c0();
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new AnonymousClass6(str, str2, z16), 16, null, true);
    }

    private void Y(int i3, int i16) {
        this.A0 = i16;
        if (i3 == 1) {
            g0();
            return;
        }
        if (i3 == 3 || i3 == 2 || i3 == 4) {
            if (k()) {
                f0();
            } else {
                this.f201594z0 = true;
                h0();
            }
        }
    }

    private void a0(int i3, int i16, int i17, int i18, int i19, int i26) {
        b0(i3, i16, i17, i18, i19, i26, true);
    }

    private void b0(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16) {
        int i27;
        if (z16) {
            Point point = this.f201572g0;
            point.x = i17;
            point.y = i18;
            if (i17 < 0) {
                i27 = 0;
            } else {
                i27 = 1;
            }
            this.f201578k0 = i27;
        }
        if (i3 == 0) {
            if (V()) {
                f0();
            } else {
                g0();
            }
            k0();
            return;
        }
        if (i3 == 1) {
            if (V()) {
                h0();
            } else {
                g0();
            }
            k0();
            return;
        }
        if (i3 == 2) {
            l0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        if (this.B0 == null) {
            QLog.e("ColorNoteSmallScreenRelativeLayout", 1, "lottie loaded but still null");
            return;
        }
        QLog.d("ColorNoteSmallScreenRelativeLayout", 4, "play animation");
        float f16 = getContext().getResources().getDisplayMetrics().density / 2.0f;
        if (k()) {
            this.f201582n0.setScaleX(f16);
            this.f201582n0.setScaleY(f16);
            this.f201582n0.setImageDrawable(this.B0);
        } else {
            this.f201581m0.setScaleX(f16);
            this.f201581m0.setScaleY(f16);
            this.f201581m0.setImageDrawable(this.B0);
        }
        this.B0.setRepeatCount(-1);
        this.B0.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        int P = P();
        int Q = (Q() + P) - this.f201564a0;
        if (S() == 0) {
            Q = U() - this.f201564a0;
        } else if (S() == 1) {
            Q = Q() + P;
        }
        int i3 = Q;
        int i16 = this.f201572g0.y;
        int i17 = i16 + this.L;
        da1.a aVar = this.f201568e;
        if (aVar != null) {
            aVar.h(this, P, i16, i3, i17);
        } else {
            layout(P, i16, i3, i17);
        }
    }

    private void e0() {
        if (!QQTheme.isNowThemeIsNight() && !BaseColorNoteSmallScreenRelativeLayout.f201555d) {
            if (this.f201572g0.x <= 0) {
                setBackgroundResource(R.drawable.hjf);
                return;
            } else {
                setBackgroundResource(R.drawable.hjh);
                return;
            }
        }
        if (this.f201572g0.x <= 0) {
            setBackgroundResource(R.drawable.hjc);
        } else {
            setBackgroundResource(R.drawable.hje);
        }
    }

    private void f0() {
        if (!V()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201584p0.getLayoutParams();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f166890m91);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f201582n0.getLayoutParams();
        this.f201582n0.setVisibility(0);
        this.f201582n0.setScaleX(1.0f);
        this.f201582n0.setScaleY(1.0f);
        layoutParams.addRule(15);
        if (com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
            X(getContext(), "colornote/data.json", "colornote/images", false);
        } else {
            K(true, 1);
            if (this.f201586r0 == null) {
                MusicDanceDrawable musicDanceDrawable = new MusicDanceDrawable();
                this.f201586r0 = musicDanceDrawable;
                musicDanceDrawable.a(getContext(), x.c(getContext(), 15.0f), x.c(getContext(), 9.5f), getContext().getResources().getColor(R.color.f156953am0));
            }
            this.f201582n0.setImageDrawable((Drawable) this.f201586r0);
            this.f201586r0.start(300);
            com.tencent.mobileqq.colornote.anim.b bVar = this.f201587s0;
            if (bVar != null) {
                bVar.stop();
            }
        }
        this.f201581m0.setVisibility(8);
        layoutParams2.rightMargin = x.c(getContext(), 13.5f);
        if (this.f201585q0.size() == 1 && this.f201588t0) {
            linearLayout.setVisibility(8);
            this.K = this.M;
            layoutParams.addRule(13, 0);
            layoutParams.addRule(9, 0);
            layoutParams.addRule(11);
            layoutParams2.rightMargin = x.c(getContext(), 17.5f);
        } else {
            layoutParams.addRule(9);
            layoutParams.addRule(13, 0);
            layoutParams.addRule(11, 0);
            this.K = this.N;
            linearLayout.setVisibility(0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            linearLayout.setGravity(16);
            layoutParams3.width = getResources().getDimensionPixelSize(R.dimen.b89);
            layoutParams3.gravity = 16;
            if (k()) {
                layoutParams3.rightMargin = x.c(getContext(), 13.5f);
                layoutParams3.leftMargin = 0;
            }
            linearLayout.setLayoutParams(layoutParams3);
            l();
        }
        d0();
    }

    private void g0() {
        int dimensionPixelSize;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201584p0.getLayoutParams();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f166890m91);
        this.K = this.M;
        this.f201581m0.setVisibility(8);
        this.f201582n0.setVisibility(8);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (k()) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b89);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b__);
        }
        layoutParams2.width = dimensionPixelSize;
        int i3 = 0;
        if (k()) {
            layoutParams2.rightMargin = x.c(linearLayout.getContext(), 10.0f);
            layoutParams2.leftMargin = 0;
            layoutParams.addRule(9);
            layoutParams.addRule(11, 0);
        } else {
            layoutParams2.leftMargin = x.c(linearLayout.getContext(), 10.0f);
            layoutParams2.rightMargin = 0;
            layoutParams.addRule(11, 0);
            layoutParams.addRule(9);
        }
        linearLayout.setLayoutParams(layoutParams2);
        linearLayout.setVisibility(0);
        this.f201581m0.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        this.f201572g0.x = P();
        if (this.f201572g0.x >= 0) {
            i3 = 1;
        }
        this.f201578k0 = i3;
        if (this.A0 != 2) {
            d0();
        }
    }

    private void h0() {
        boolean z16;
        boolean z17;
        if (!V()) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201584p0.getLayoutParams();
        if (this.f201594z0 && this.f201585q0.size() > 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f166890m91);
        this.f201582n0.setVisibility(8);
        com.tencent.mobileqq.colornote.anim.b bVar = this.f201586r0;
        if (bVar != null) {
            bVar.stop();
        }
        this.f201581m0.setScaleX(1.0f);
        this.f201581m0.setScaleY(1.0f);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f201581m0.getLayoutParams();
        if (!z16) {
            this.f201581m0.setVisibility(0);
            layoutParams2.leftMargin = x.c(getContext(), 13.5f);
        }
        if (com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
            X(getContext(), "colornote/data.json", "colornote/images", false);
            z17 = false;
        } else {
            K(false, 1);
            z17 = true;
        }
        if (z17) {
            if (this.f201587s0 == null) {
                MusicDanceDrawable musicDanceDrawable = new MusicDanceDrawable();
                this.f201587s0 = musicDanceDrawable;
                musicDanceDrawable.a(getContext(), x.c(getContext(), 15.0f), x.c(getContext(), 9.5f), getContext().getResources().getColor(R.color.f156953am0));
            }
            this.f201581m0.setImageDrawable((Drawable) this.f201587s0);
            this.f201587s0.start(300);
        }
        if (this.f201585q0.size() == 1 && this.f201588t0) {
            linearLayout.setVisibility(8);
            this.K = this.M;
            layoutParams.addRule(13, 0);
            layoutParams.addRule(9);
            layoutParams.addRule(11, 0);
            layoutParams2.leftMargin = x.c(getContext(), 17.5f);
        } else {
            layoutParams.addRule(11, 0);
            layoutParams.addRule(9);
            layoutParams.addRule(13, 0);
            this.K = this.N;
            linearLayout.setVisibility(0);
            LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
            layoutParams3.gravity = 16;
            if (!z16) {
                layoutParams3.width = getResources().getDimensionPixelSize(R.dimen.b__);
                if (!k()) {
                    layoutParams3.leftMargin = x.c(getContext(), 14.5f);
                    layoutParams3.rightMargin = 0;
                }
                linearLayout.setLayoutParams(layoutParams3);
            }
        }
        if (!z16) {
            this.f201581m0.getViewTreeObserver().addOnPreDrawListener(new c());
        }
        if (z16) {
            j0();
        } else {
            d0();
        }
    }

    private void i0(ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout, int i3, int i16, int i17, int i18) {
        da1.a aVar = this.f201568e;
        if (aVar != null) {
            aVar.h(colorNoteSmallScreenRelativeLayout, i3, i16, i17, i18);
        } else {
            layout(i3, i16, i17, i18);
        }
    }

    private void j0() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(100L);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f201577j0.getLayoutParams();
        int i3 = layoutParams.leftMargin;
        Point point = this.f201572g0;
        point.x = (this.f201567d0 - this.M) + this.f201564a0;
        ofFloat.addUpdateListener(new d(this, point, layoutParams, i3));
        ofFloat.addListener(new e());
        ofFloat.start();
    }

    private void k0() {
        this.f201584p0.setVisibility(0);
        this.f201583o0.setVisibility(8);
    }

    private void l0() {
        this.f201584p0.setVisibility(8);
        this.f201583o0.setVisibility(0);
        this.K = this.M;
    }

    private void m0(int i3, int i16) {
        int i17;
        int i18;
        int i19 = (this.R + i3) - this.T;
        int i26 = (this.S + i16) - this.U;
        int Q = Q();
        this.K = Q;
        int i27 = this.L;
        int M = M();
        int i28 = this.f201569e0 - i27;
        int N = N();
        if (i19 < N) {
            i19 = N;
        }
        if (i19 > M) {
            i17 = M;
        } else {
            i17 = i19;
        }
        if (i26 < 0) {
            i26 = 0;
        }
        if (i26 > i28) {
            i18 = i28;
        } else {
            i18 = i26;
        }
        if ((i17 > N && i17 < M) || this.f201591w0) {
            this.f201579l0 = this.f201578k0;
            this.f201578k0 = 2;
            int Q2 = Q();
            this.K = Q2;
            int i29 = this.L;
            i0(this, i17, i18, i17 + Q2, i18 + i29);
            int i36 = this.f201579l0;
            int i37 = this.f201578k0;
            if (i36 != i37) {
                b0(i37, i36, i17, i18, Q2, i29, false);
            }
            if (QQTheme.isNowThemeIsNight()) {
                setBackgroundResource(R.drawable.hjd);
                return;
            } else {
                setBackgroundResource(R.drawable.hjg);
                return;
            }
        }
        if (i17 == N) {
            int i38 = this.f201578k0;
            this.f201579l0 = i38;
            this.f201578k0 = 0;
            if (i38 != 0) {
                a0(0, i38, i17, i18, Q, i27);
            }
            i0(this, i17, i18, i17 + Q, i18 + i27);
            if (QQTheme.isNowThemeIsNight()) {
                setBackgroundResource(R.drawable.hjc);
                return;
            } else {
                setBackgroundResource(R.drawable.hjf);
                return;
            }
        }
        if (i17 == M) {
            int i39 = this.f201578k0;
            this.f201579l0 = i39;
            this.f201578k0 = 1;
            this.f201594z0 = false;
            if (i39 != 1) {
                a0(1, i39, i17, i18, Q, i27);
            }
            i0(this, i17, i18, i17 + Q, i18 + i27);
            if (QQTheme.isNowThemeIsNight()) {
                setBackgroundResource(R.drawable.hje);
            } else {
                setBackgroundResource(R.drawable.hjh);
            }
        }
    }

    public int M() {
        return (this.f201567d0 - U()) + this.f201564a0;
    }

    public int N() {
        return -this.f201564a0;
    }

    public int P() {
        if (k()) {
            return -this.f201564a0;
        }
        QLog.d("ColorNoteSmallScreenRelativeLayout", 4, Integer.valueOf(U()));
        return (this.f201567d0 - U()) + this.f201564a0;
    }

    public int Q() {
        if (W()) {
            return this.M;
        }
        if (b()) {
            if (k()) {
                return this.N;
            }
            return this.P;
        }
        if (k()) {
            return this.M;
        }
        return this.P;
    }

    public int U() {
        if (!W() && !this.f201591w0) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 4, Boolean.valueOf(b()));
            if (b() && !this.f201593y0) {
                QLog.d("ColorNoteSmallScreenRelativeLayout", 4, Integer.valueOf(this.N));
                return this.N;
            }
            return this.M;
        }
        return this.M;
    }

    public boolean V() {
        if (!this.f201588t0 && !com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
            return false;
        }
        return true;
    }

    public void Z() {
        int screenWidth;
        int screenHeight;
        int T = T();
        boolean g16 = ColorNoteSmallScreenUtil.g();
        if (T % 2 == 1) {
            screenHeight = ViewUtils.getScreenWidth();
            screenWidth = ViewUtils.getScreenHeight();
        } else {
            screenWidth = ViewUtils.getScreenWidth();
            screenHeight = ViewUtils.getScreenHeight();
        }
        if (g16) {
            screenHeight -= this.I;
        }
        int i3 = this.f201566c0;
        if (i3 != T || screenWidth != this.f201567d0 || ((T == 0 && this.f201569e0 < screenHeight) || (T != 0 && this.f201569e0 != screenHeight))) {
            if (QLog.isColorLevel()) {
                QLog.w("ColorNoteSmallScreenRelativeLayout", 1, "onOrientationChangedInner, mPosition[" + i3 + "], mRotation[" + this.f201566c0 + "->" + T + "], mScreenWidth[" + this.f201567d0 + "->" + screenWidth + "], mScreenHeight[" + this.f201569e0 + "->" + screenHeight + "], mIsInit[" + this.H + "]");
            }
            if (this.H && T != 0) {
                this.H = false;
            }
            this.f201570f.cancel();
            this.f201566c0 = T;
            this.f201567d0 = screenWidth;
            this.f201569e0 = screenHeight;
            Point point = new Point(P(), screenHeight / 2);
            this.f201572g0 = point;
            setCurPosition(point);
            da1.a aVar = this.f201568e;
            if (aVar != null) {
                int g17 = aVar.g(this);
                this.V = g17;
                this.R = g17;
                int d16 = this.f201568e.d(this);
                this.W = d16;
                this.S = d16;
                this.f201568e.k(this.f201572g0, this.f201566c0);
            } else {
                int left = getLeft();
                this.V = left;
                this.R = left;
                int top = getTop();
                this.W = top;
                this.S = top;
            }
            if (!this.H) {
                this.f201570f.start();
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.m
    public void a() {
        boolean k3 = k();
        p pVar = this.f201592x0;
        if (pVar != null && pVar.j() == 2) {
            return;
        }
        if (k3) {
            f0();
        } else {
            h0();
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public boolean b() {
        if ((V() && this.f201585q0.size() != 1) || com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public Point c() {
        return this.f201572g0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (this.G) {
            return true;
        }
        int action = motionEvent.getAction();
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.f201591w0 = false;
                        this.E = false;
                        if (this.D) {
                            m0(rawX, rawY);
                            this.f201576i0.removeCallbacks(this.f201574h0);
                        }
                        da1.a aVar = this.f201568e;
                        if (aVar != null) {
                            this.V = aVar.g(this);
                            this.W = this.f201568e.d(this);
                        } else {
                            this.V = getLeft();
                            this.W = getTop();
                        }
                        this.f201570f.start();
                    }
                } else if (this.D) {
                    m0(rawX, rawY);
                    this.f201576i0.removeCallbacks(this.f201574h0);
                } else if (Math.abs(rawX - this.T) > this.J || Math.abs(rawY - this.U) > this.J) {
                    this.f201591w0 = true;
                    this.D = true;
                }
            } else {
                this.f201591w0 = false;
                this.f201576i0.removeCallbacks(this.f201574h0);
                if (this.D) {
                    m0(rawX, rawY);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    da1.a aVar2 = this.f201568e;
                    if (aVar2 != null && !this.E && currentTimeMillis - this.F > 600) {
                        Point point = this.f201572g0;
                        if (this.f201566c0 == 0) {
                            z16 = true;
                        }
                        z16 = aVar2.q(point, z16);
                        this.F = currentTimeMillis;
                    }
                }
                da1.a aVar3 = this.f201568e;
                if (aVar3 != null) {
                    this.V = aVar3.g(this);
                    this.W = this.f201568e.d(this);
                } else {
                    this.V = getLeft();
                    this.W = getTop();
                }
                if (!z16) {
                    this.f201570f.start();
                }
            }
        } else {
            this.E = false;
            this.f201576i0.postDelayed(this.f201574h0, ViewConfiguration.getLongPressTimeout());
            this.f201570f.cancel();
            this.T = rawX;
            this.U = rawY;
            da1.a aVar4 = this.f201568e;
            if (aVar4 != null) {
                this.R = aVar4.g(this);
                this.S = this.f201568e.d(this);
            } else {
                this.R = getLeft();
                this.S = getTop();
            }
            this.D = false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int f() {
        return this.f201569e0;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int g() {
        return this.f201567d0;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int h() {
        return this.L;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int i() {
        return this.K;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void j() {
        this.f201577j0 = (LinearLayout) findViewById(R.id.f166890m91);
        this.f201583o0 = (RelativeLayout) findViewById(R.id.lfv);
        this.f201584p0 = (LinearLayout) findViewById(R.id.f166889m90);
        this.f201581m0 = (MusicDanceImageView) findViewById(R.id.lo9);
        this.f201582n0 = (MusicDanceImageView) findViewById(R.id.lo_);
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public boolean k() {
        da1.a aVar;
        int i3;
        if (this.f201578k0 == -1 && (aVar = this.f201568e) != null) {
            this.f201572g0.x = aVar.g(this);
            this.f201572g0.y = this.f201568e.d(this);
            if (this.f201572g0.x < 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            this.f201578k0 = i3;
        }
        if (this.f201578k0 == 0 && this.f201572g0.x > 0 && QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "state is STATE_LEFT, but mPoint.x grater than 0");
        }
        if (this.f201578k0 == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void l() {
        int i3;
        int size;
        int R;
        int size2;
        int size3;
        int i16;
        List<ColorNote> list = this.f201585q0;
        if (list != null && list.size() != 0 && this.f201568e != null) {
            int i17 = 0;
            this.f201588t0 = false;
            int i18 = 0;
            while (true) {
                int size4 = this.f201585q0.size();
                i3 = android.R.layout.activity_list_item;
                if (i18 >= size4) {
                    break;
                }
                int i19 = this.f201585q0.get(i18).mServiceType;
                if (i19 == 16973824 || i19 == 17367040) {
                    break;
                } else {
                    i18++;
                }
            }
            this.f201588t0 = true;
            int i26 = this.f201590v0;
            if (V()) {
                if (com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
                    this.f201590v0 = 4;
                } else if (this.f201588t0 && this.f201585q0.size() > 1) {
                    this.f201590v0 = 2;
                } else {
                    this.f201590v0 = 3;
                }
            } else {
                this.f201590v0 = 1;
            }
            ViewGroup viewGroup = (LinearLayout) findViewById(R.id.f166890m91);
            viewGroup.removeAllViews();
            if (this.f201588t0) {
                size = this.f201585q0.size() - 1;
            } else {
                size = this.f201585q0.size();
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.f159560b84);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.f159559b83) - (O(size) * 2);
            if (size == 0) {
                R = dimensionPixelSize;
            } else {
                R = (int) (((dimensionPixelSize2 * 1.0f) / size) - R(size));
            }
            while (i17 < this.f201585q0.size()) {
                ColorNote colorNote = this.f201585q0.get(i17);
                int i27 = colorNote.mServiceType;
                if (i27 != 16973824 && i27 != i3) {
                    SmallColorNoteItem L = L(colorNote, viewGroup);
                    L.setAttachLeft(k());
                    if (this.f201588t0) {
                        size2 = this.f201585q0.size() - 1;
                    } else {
                        size2 = this.f201585q0.size();
                    }
                    if (size2 > 3) {
                        L.d();
                    } else {
                        L.g();
                        L.setTitle(colorNote.mMainTitle);
                        L.setSubTitle(colorNote.mSubTitle);
                    }
                    if (this.f201588t0) {
                        size3 = this.f201585q0.size() - 1;
                    } else {
                        size3 = this.f201585q0.size();
                    }
                    if (size3 > 4) {
                        L.c();
                    } else {
                        L.f();
                    }
                    L.a(R, dimensionPixelSize);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, R);
                    int R2 = (int) (R(size) / 2.0f);
                    if (R2 == 0) {
                        i16 = 1;
                    } else {
                        i16 = R2;
                    }
                    layoutParams.topMargin = i16;
                    if (R2 == 0) {
                        R2 = 1;
                    }
                    layoutParams.bottomMargin = R2;
                    viewGroup.addView(L.b(), -1, layoutParams);
                }
                i17++;
                i3 = android.R.layout.activity_list_item;
            }
            int i28 = this.f201590v0;
            if (i26 != i28) {
                Y(i28, i26);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void m() {
        this.f201572g0.x = P();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void n() {
        int dimensionPixelSize;
        List<ColorNote> list = this.f201585q0;
        if (list != null && list.size() != 0) {
            if (this.f201585q0.size() != 1 && V()) {
                this.K = this.N;
            } else {
                this.K = this.M;
            }
            if (this.f201584p0 != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f201577j0.getLayoutParams();
                if (k()) {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b89);
                } else {
                    dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.b__);
                }
                layoutParams.width = dimensionPixelSize;
                if (V()) {
                    if (k()) {
                        layoutParams.rightMargin = x.c(getContext(), 13.5f);
                        layoutParams.leftMargin = 0;
                    } else {
                        layoutParams.leftMargin = x.c(getContext(), 14.5f);
                        layoutParams.rightMargin = 0;
                    }
                } else if (k()) {
                    layoutParams.rightMargin = x.c(getContext(), 10.0f);
                    layoutParams.leftMargin = 0;
                } else {
                    layoutParams.leftMargin = x.c(getContext(), 10.0f);
                    layoutParams.rightMargin = 0;
                }
            }
            this.E = false;
            d0();
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void o(List<ColorNote> list) {
        int size;
        boolean z16;
        int measuredWidth;
        ColorNote next;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.f166890m91);
        boolean z17 = !com.tencent.mobileqq.colornote.data.a.r(this.f201585q0, list);
        if (linearLayout != null && list.size() > 0) {
            List<ColorNote> list2 = this.f201585q0;
            if (list2 == null) {
                size = 0;
            } else {
                size = list2.size();
            }
            if (!this.f201589u0 && z17) {
                Iterator<ColorNote> it = list.iterator();
                boolean z18 = false;
                loop0: while (true) {
                    z16 = z18;
                    while (it.hasNext()) {
                        next = it.next();
                        if (next.getServiceType() == 16973824 || next.getServiceType() == 17367040) {
                            if (next.animate) {
                                break;
                            } else {
                                z16 = true;
                            }
                        }
                    }
                    next.animate = false;
                    z18 = true;
                }
                boolean z19 = false;
                for (int i3 = 0; i3 < size; i3++) {
                    ColorNote colorNote = this.f201585q0.get(i3);
                    if (colorNote.getServiceType() == 16973824 || colorNote.getServiceType() == 17367040) {
                        z19 = true;
                    }
                }
                this.f201585q0 = list;
                if ((z18 || (!z16 && z19)) && Math.abs(list.size() - size) == 1) {
                    l();
                    return;
                }
                this.f201589u0 = true;
                ViewPropertyAnimator animate = linearLayout.animate();
                if (k()) {
                    measuredWidth = -linearLayout.getMeasuredWidth();
                } else {
                    measuredWidth = linearLayout.getMeasuredWidth();
                }
                animate.translationX(measuredWidth).setDuration(200L).setListener(new a(linearLayout)).start();
                return;
            }
            this.f201585q0 = list;
            l();
            return;
        }
        this.f201585q0 = list;
        l();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        int i3;
        int i16;
        int i17 = 1;
        if (animator == this.f201570f) {
            Point point = this.f201565b0;
            int Q = Q();
            this.K = Q;
            int i18 = this.L;
            this.f201572g0 = point;
            if (point.x > 0 && S() != 0) {
                this.f201579l0 = this.f201578k0;
                this.f201578k0 = 1;
                this.f201572g0.x = P();
                if (this.f201572g0.x < 0) {
                    i16 = 0;
                } else {
                    i16 = 1;
                }
                this.f201578k0 = i16;
                int P = P() + Q();
                int i19 = this.f201579l0;
                int i26 = this.f201578k0;
                if (i19 != i26) {
                    Point point2 = this.f201572g0;
                    a0(i26, i19, point2.x, point2.y, Q, i18);
                }
                this.f201594z0 = true;
                Point point3 = this.f201572g0;
                int i27 = point3.x;
                int i28 = point3.y;
                i0(this, i27, i28, P, i28 + i18);
                if (QQTheme.isNowThemeIsNight()) {
                    setBackgroundResource(R.drawable.hje);
                } else {
                    setBackgroundResource(R.drawable.hjh);
                }
            } else {
                this.f201579l0 = this.f201578k0;
                this.f201578k0 = 0;
                this.f201572g0.x = P();
                if (this.f201572g0.x < 0) {
                    i17 = 0;
                }
                this.f201578k0 = i17;
                int P2 = P();
                int Q2 = P2 + Q();
                int i29 = this.f201579l0;
                int i36 = this.f201578k0;
                if (i29 != i36) {
                    a0(i36, i29, P2, this.f201572g0.y, Q, i18);
                }
                int i37 = this.f201572g0.y;
                i0(this, P2, i37, Q2, i37 + i18);
                if (QQTheme.isNowThemeIsNight()) {
                    setBackgroundResource(R.drawable.hjc);
                } else {
                    setBackgroundResource(R.drawable.hjf);
                }
            }
            da1.a aVar = this.f201568e;
            if (aVar != null) {
                aVar.k(this.f201572g0, this.f201566c0);
            }
            this.H = false;
            if (this.f201572g0.y > this.f201569e0 / 2) {
                ReportController.o(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
            }
        } else if (animator == this.f201573h) {
            if (!this.C) {
                setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationEnd setVisibility(GONE)");
                }
                da1.a aVar2 = this.f201568e;
                if (aVar2 != null) {
                    aVar2.p(this);
                }
            }
        } else if (animator == this.f201575i) {
            if (this.E) {
                this.K = this.M;
            }
            int i38 = this.K / 2;
            Point point4 = this.f201572g0;
            if ((this.f201588t0 && this.f201585q0.size() != 1) || com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
                i3 = 0;
            } else {
                i3 = i38;
            }
            point4.x = P();
            int Q3 = Q();
            this.K = Q3;
            int i39 = this.L;
            int i46 = point4.x;
            if (i46 <= 0) {
                da1.a aVar3 = this.f201568e;
                if (aVar3 != null) {
                    int i47 = point4.y;
                    aVar3.c(this, i46, i47, Q3 + i46 + i3, i47 + i39, i3, true);
                }
            } else {
                da1.a aVar4 = this.f201568e;
                if (aVar4 != null) {
                    int i48 = point4.y;
                    aVar4.c(this, i46 - i3, i48, (i46 + Q3) - i3, i48 + i39, -i3, true);
                }
            }
        }
        l();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (animator == this.f201570f) {
            if (this.V + (Q() / 2) < this.f201567d0 / 2) {
                this.f201565b0.x = -this.f201564a0;
            } else {
                this.f201565b0.x = M();
            }
            this.f201565b0.y = this.W;
            this.f201594z0 = false;
            return;
        }
        if (animator == this.f201573h && this.C) {
            setVisibility(0);
            if (QLog.isColorLevel()) {
                QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "onAnimationStart setVisibility(VISIBLE)");
            }
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (valueAnimator == this.f201570f) {
            Point point = this.f201565b0;
            int i3 = (int) (this.V + ((point.x - r2) * floatValue));
            int i16 = (int) (this.W + ((point.y - r3) * floatValue));
            int Q = Q();
            this.K = Q;
            int i17 = this.L;
            da1.a aVar = this.f201568e;
            if (aVar != null) {
                aVar.h(this, i3, i16, i3 + Q, i16 + i17);
                return;
            } else {
                layout(i3, i16, Q + i3, i17 + i16);
                return;
            }
        }
        if (valueAnimator != this.f201573h && valueAnimator == this.f201575i) {
            if (this.E) {
                this.K = this.M;
            }
            if ((this.f201588t0 && this.f201585q0.size() != 1) || com.tencent.mobileqq.colornote.data.a.n(this.f201585q0)) {
                return;
            }
            int i18 = (int) ((this.K / 2) * floatValue);
            this.f201572g0.x = P();
            Point point2 = this.f201572g0;
            int Q2 = Q();
            this.K = Q2;
            int i19 = this.L;
            int i26 = point2.x;
            if (i26 <= 0) {
                da1.a aVar2 = this.f201568e;
                if (aVar2 != null) {
                    int i27 = point2.y;
                    aVar2.c(this, i26, i27, Q2 + i26 + i18, i27 + i19, i18, false);
                    return;
                }
                return;
            }
            da1.a aVar3 = this.f201568e;
            if (aVar3 != null) {
                int i28 = point2.y;
                aVar3.c(this, i26 - i18, i28, (i26 + Q2) - i18, i28 + i19, -i18, false);
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        Z();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f201584p0 = (LinearLayout) findViewById(R.id.f166889m90);
        this.f201577j0 = (LinearLayout) findViewById(R.id.f166890m91);
        this.f201581m0 = (MusicDanceImageView) findViewById(R.id.lo9);
        this.f201582n0 = (MusicDanceImageView) findViewById(R.id.lo_);
        this.f201583o0 = (RelativeLayout) findViewById(R.id.lfv);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.f201567d0 == 0 || this.f201569e0 == 0) {
            this.f201567d0 = ViewUtils.getScreenWidth();
            this.f201569e0 = ViewUtils.getScreenHeight();
            setCurPosition(this.f201572g0);
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void p() {
        if (this.f201567d0 != 0 && this.f201569e0 != 0) {
            Point point = this.f201572g0;
            int Q = Q();
            this.K = Q;
            int i3 = this.L;
            da1.a aVar = this.f201568e;
            if (aVar != null && !this.G) {
                int i16 = point.x;
                int i17 = point.y;
                aVar.h(this, i16, i17, i16 + Q, i17 + i3);
            } else {
                int i18 = point.x;
                int i19 = point.y;
                layout(i18, i19, Q + i18, i3 + i19);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void q() {
        if (!this.G) {
            n();
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setCurPosition(Point point) {
        int i3;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition position = " + point);
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenWidth = " + this.f201567d0);
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "setCurPosition mScreenHeight = " + this.f201569e0);
        }
        this.f201572g0 = point;
        int i17 = point.x;
        if (i17 < 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        this.f201578k0 = i3;
        int i18 = this.f201567d0;
        if (i18 != 0 && (i16 = this.f201569e0) != 0) {
            int i19 = this.K;
            int i26 = this.L;
            if (i17 == 0 && point.y == 0) {
                point.y = i16 / 2;
                point.x = i18 - i19;
            }
            da1.a aVar = this.f201568e;
            if (aVar != null) {
                int i27 = point.x;
                int i28 = point.y;
                aVar.h(this, i27, i28, i27 + i19, i28 + i26);
            } else {
                int i29 = point.x;
                int i36 = point.y;
                layout(i29, i36, i19 + i29, i26 + i36);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setCustomNightMode(boolean z16) {
        BaseColorNoteSmallScreenRelativeLayout.f201555d = z16;
        e0();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setFloatListener(da1.a aVar) {
        this.f201568e = aVar;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setShouldMaxRootView(boolean z16) {
        this.G = z16;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setUpcomingController(p pVar) {
        this.f201592x0 = pVar;
    }

    public ColorNoteSmallScreenRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorNoteSmallScreenRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0L;
        this.G = false;
        this.H = true;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.f201564a0 = -1;
        this.f201565b0 = new Point(0, 0);
        this.f201566c0 = 0;
        this.f201567d0 = 0;
        this.f201569e0 = 0;
        this.f201571f0 = null;
        this.f201572g0 = new Point();
        this.f201574h0 = new CheckForLongPress();
        this.f201576i0 = new MqqHandler(Looper.getMainLooper());
        this.f201578k0 = -1;
        this.f201579l0 = -1;
        this.f201588t0 = false;
        this.f201590v0 = -1;
        this.f201591w0 = false;
        this.f201593y0 = false;
        this.f201594z0 = false;
        this.A0 = 1;
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayout", 2, "SmallScreenRelativeLayout");
        }
        this.J = ViewConfiguration.get(context).getScaledTouchSlop();
        this.K = getResources().getDimensionPixelSize(R.dimen.b5x);
        this.L = getResources().getDimensionPixelSize(R.dimen.b5w);
        int i16 = this.K;
        this.M = i16;
        int i17 = (int) (i16 * 1.5d);
        this.N = i17;
        this.P = i16 * 2;
        this.Q = i17;
        this.I = getResources().getDimensionPixelSize(R.dimen.a9i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f201570f = ofFloat;
        ofFloat.setDuration(200L);
        this.f201570f.addListener(this);
        this.f201570f.addUpdateListener(this);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f201575i = ofFloat2;
        ofFloat2.setDuration(300L);
        this.f201575i.addListener(this);
        this.f201575i.addUpdateListener(this);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f201573h = ofFloat3;
        ofFloat3.setDuration(400L);
        this.f201573h.addListener(this);
        this.f201580m = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f201566c0 = T();
        if (Build.VERSION.SDK_INT != 23) {
            this.f201571f0 = new f(getContext(), 2);
        }
        this.f201569e0 = ViewUtils.getScreenHeight();
        this.f201567d0 = ViewUtils.getScreenWidth();
        this.f201564a0 = Utils.n(8.0f, getResources());
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a extends com.tencent.mobileqq.widget.f {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LinearLayout f201600d;

        a(LinearLayout linearLayout) {
            this.f201600d = linearLayout;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ColorNoteSmallScreenRelativeLayout.this.f201589u0 = false;
            Iterator it = ColorNoteSmallScreenRelativeLayout.this.f201585q0.iterator();
            while (it.hasNext()) {
                ((ColorNote) it.next()).animate = false;
            }
            ColorNoteSmallScreenRelativeLayout.this.l();
            this.f201600d.animate().setListener(null).translationX(0.0f).setDuration(200L).start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class e extends com.tencent.mobileqq.widget.f {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            int i3;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ColorNoteSmallScreenRelativeLayout.this.f201577j0.getLayoutParams();
            if (!ColorNoteSmallScreenRelativeLayout.this.k()) {
                layoutParams.leftMargin = x.c(ColorNoteSmallScreenRelativeLayout.this.getContext(), 14.5f);
                layoutParams.rightMargin = 0;
            }
            ColorNoteSmallScreenRelativeLayout.this.f201577j0.setLayoutParams(layoutParams);
            ColorNoteSmallScreenRelativeLayout.this.f201581m0.setVisibility(0);
            ((LinearLayout.LayoutParams) ColorNoteSmallScreenRelativeLayout.this.f201581m0.getLayoutParams()).leftMargin = x.c(ColorNoteSmallScreenRelativeLayout.this.getContext(), 13.5f);
            ColorNoteSmallScreenRelativeLayout.this.f201572g0.x = ColorNoteSmallScreenRelativeLayout.this.P();
            ColorNoteSmallScreenRelativeLayout colorNoteSmallScreenRelativeLayout = ColorNoteSmallScreenRelativeLayout.this;
            if (colorNoteSmallScreenRelativeLayout.f201572g0.x < 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            colorNoteSmallScreenRelativeLayout.f201578k0 = i3;
            ColorNoteSmallScreenRelativeLayout.this.f201593y0 = false;
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ColorNoteSmallScreenRelativeLayout.this.f201593y0 = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
