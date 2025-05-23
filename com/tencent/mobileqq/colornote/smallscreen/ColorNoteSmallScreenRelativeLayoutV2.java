package com.tencent.mobileqq.colornote.smallscreen;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.colornote.anim.MusicDanceImageView;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ColorNoteSmallScreenRelativeLayoutV2 extends BaseColorNoteSmallScreenRelativeLayout implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener, m {
    private boolean C;
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
    private Point W;

    /* renamed from: a0, reason: collision with root package name */
    private int f201611a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f201612b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f201613c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f201614d0;

    /* renamed from: e, reason: collision with root package name */
    private da1.a f201615e;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f201616e0;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f201617f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f201618f0;

    /* renamed from: g0, reason: collision with root package name */
    private MusicDanceImageView f201619g0;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f201620h;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.colornote.anim.c f201621h0;

    /* renamed from: i, reason: collision with root package name */
    private ValueAnimator f201622i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f201623i0;

    /* renamed from: j0, reason: collision with root package name */
    private a f201624j0;

    /* renamed from: k0, reason: collision with root package name */
    private Point f201625k0;

    /* renamed from: l0, reason: collision with root package name */
    private CheckForLongPress f201626l0;

    /* renamed from: m, reason: collision with root package name */
    private Display f201627m;

    /* renamed from: m0, reason: collision with root package name */
    private MqqHandler f201628m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f201629n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f201630o0;

    /* renamed from: p0, reason: collision with root package name */
    private NoteFlowerView f201631p0;

    /* renamed from: q0, reason: collision with root package name */
    private View f201632q0;

    /* renamed from: r0, reason: collision with root package name */
    private List<ColorNote> f201633r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f201634s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f201635t0;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f201636u0;

    /* renamed from: v0, reason: collision with root package name */
    private p f201637v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f201638w0;

    /* renamed from: x0, reason: collision with root package name */
    private LottieDrawable f201639x0;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f201640y0;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f201641z0;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private final class CheckForLongPress implements Runnable {
        CheckForLongPress() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ColorNoteSmallScreenRelativeLayoutV2.this.f201615e != null && ia1.b.d()) {
                ColorNoteSmallScreenRelativeLayoutV2.this.E = true;
                ColorNoteSmallScreenRelativeLayoutV2.this.G = true;
                ColorNoteSmallScreenRelativeLayoutV2.this.f201615e.onLongClick();
                ColorNoteSmallScreenRelativeLayoutV2.this.f201622i.start();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class a extends OrientationEventListener {
        public a(Context context, int i3) {
            super(context, i3);
        }

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int i3) {
            ColorNoteSmallScreenRelativeLayoutV2.this.R();
        }
    }

    public ColorNoteSmallScreenRelativeLayoutV2(Context context) {
        this(context, null);
    }

    private com.tencent.mobileqq.colornote.anim.c C() {
        com.tencent.mobileqq.colornote.anim.c cVar = this.f201621h0;
        if (cVar != null) {
            return cVar;
        }
        com.tencent.mobileqq.colornote.anim.c cVar2 = new com.tencent.mobileqq.colornote.anim.c();
        this.f201621h0 = cVar2;
        cVar2.a(getContext(), ViewUtils.dpToPx(18.0f), ViewUtils.dpToPx(20.0f), RichStatus.TOPIC_COLOR);
        return this.f201621h0;
    }

    private int F() {
        return this.f201629n0;
    }

    private int G() {
        try {
            return this.f201627m.getRotation();
        } catch (Exception e16) {
            QLog.e("ColorNoteSmallScreenRelativeLayoutV2", 1, "[getSysRotation]", e16.getMessage());
            return 0;
        }
    }

    private void I() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f201617f = ofFloat;
        ofFloat.setDuration(200L);
        this.f201617f.addListener(this);
        this.f201617f.addUpdateListener(this);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f201622i = ofFloat2;
        ofFloat2.setDuration(300L);
        this.f201622i.addListener(this);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f201620h = ofFloat3;
        ofFloat3.setDuration(400L);
        this.f201620h.addListener(this);
        this.f201620h.addUpdateListener(this);
    }

    private void J() {
        NoteFlowerView noteFlowerView = (NoteFlowerView) findViewById(R.id.u0z);
        this.f201631p0 = noteFlowerView;
        if (noteFlowerView != null) {
            noteFlowerView.setMaxColorNoteCount(ia1.b.a() + 1);
        }
        this.f201632q0 = findViewById(R.id.f164842u11);
    }

    private boolean K(List<ColorNote> list, List<ColorNote> list2, int i3, int i16, int i17) {
        if (i3 < 0 || i16 < 0 || i3 + i17 > list.size() || i16 + i17 > list2.size()) {
            return false;
        }
        for (int i18 = 0; i18 < i17; i18++) {
            ColorNote colorNote = list.get(i3 + i18);
            ColorNote colorNote2 = list2.get(i16 + i18);
            if (colorNote != colorNote2 && !TextUtils.equals(colorNote.getPicUrl(), colorNote2.getPicUrl())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(String str, LottieComposition lottieComposition) {
        if (lottieComposition == null) {
            QLog.e("ColorNoteSmallScreenRelativeLayoutV2", 1, "getLottieDrawable onCompositionLoaded failed");
            return;
        }
        LottieDrawable lottieDrawable = new LottieDrawable();
        lottieDrawable.setComposition(lottieComposition);
        lottieDrawable.setImagesAssetsFolder(str);
        this.f201639x0 = lottieDrawable;
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.colornote.smallscreen.f
            @Override // java.lang.Runnable
            public final void run() {
                ColorNoteSmallScreenRelativeLayoutV2.this.U();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(String str, final String str2) {
        LottieCompositionFactory.fromAsset(getContext(), str).addListener(new LottieListener() { // from class: com.tencent.mobileqq.colornote.smallscreen.d
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                ColorNoteSmallScreenRelativeLayoutV2.this.L(str2, (LottieComposition) obj);
            }
        }).addFailureListener(new LottieListener() { // from class: com.tencent.mobileqq.colornote.smallscreen.e
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                QLog.e("ColorNoteSmallScreenRelativeLayoutV2", 2, "load lottie failed", (Throwable) obj);
            }
        });
    }

    private void O(final String str, final String str2) {
        if (this.f201639x0 != null) {
            U();
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.colornote.smallscreen.c
                @Override // java.lang.Runnable
                public final void run() {
                    ColorNoteSmallScreenRelativeLayoutV2.this.N(str, str2);
                }
            }, 16, null, true);
        }
    }

    private boolean P() {
        if (Q() && !com.tencent.mobileqq.colornote.data.a.v(this.f201633r0)) {
            return true;
        }
        return false;
    }

    private void S(int i3, int i16, int i17, int i18, int i19, int i26) {
        T(i3, i16, i17, i18, i19, i26, true);
    }

    private void T(int i3, int i16, int i17, int i18, int i19, int i26, boolean z16) {
        int i27;
        if (z16) {
            Point point = this.f201625k0;
            point.x = i17;
            point.y = i18;
            if (i17 < 0) {
                i27 = 0;
            } else {
                i27 = 1;
            }
            this.f201629n0 = i27;
        }
        if (i3 == 0) {
            Y();
            a0();
        } else if (i3 == 1) {
            Y();
            a0();
        } else if (i3 == 2) {
            b0();
        }
        e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.f201639x0 == null) {
            QLog.e("ColorNoteSmallScreenRelativeLayoutV2", 1, "lottie loaded but still null");
            return;
        }
        QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 4, "play animation");
        this.f201619g0.setImageDrawable(this.f201639x0);
        this.f201639x0.setRepeatCount(-1);
        this.f201639x0.playAnimation();
    }

    private void V() {
        int D = D();
        int E = (E() + D) - this.V;
        if (F() == 0) {
            E = H() - this.V;
        } else if (F() == 1) {
            E = E() + D;
        }
        int i3 = E;
        int i16 = this.f201625k0.y;
        int i17 = i16 + this.M;
        da1.a aVar = this.f201615e;
        if (aVar != null) {
            aVar.h(this, D, i16, i3, i17);
        } else {
            layout(D, i16, i3, i17);
        }
    }

    private void W() {
        if (this.f201619g0 == null) {
            MusicDanceImageView musicDanceImageView = new MusicDanceImageView(getContext());
            this.f201619g0 = musicDanceImageView;
            musicDanceImageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewUtils.dpToPx(26.0f), -2));
            addView(this.f201619g0);
        }
        f0();
        this.f201619g0.setVisibility(0);
    }

    private void X() {
        if (!QQTheme.isNowThemeIsNight() && !BaseColorNoteSmallScreenRelativeLayout.f201555d) {
            if (this.f201625k0.x <= 0) {
                setBackgroundResource(R.drawable.jhc);
                return;
            } else {
                setBackgroundResource(R.drawable.jhj);
                return;
            }
        }
        if (this.f201625k0.x <= 0) {
            setBackgroundResource(R.drawable.jhd);
        } else {
            setBackgroundResource(R.drawable.jhk);
        }
    }

    private void Y() {
        int i3;
        this.K = this.N;
        this.f201625k0.x = D();
        if (this.f201625k0.x < 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        this.f201629n0 = i3;
        V();
    }

    private void Z(BaseColorNoteSmallScreenRelativeLayout baseColorNoteSmallScreenRelativeLayout, int i3, int i16, int i17, int i18) {
        da1.a aVar = this.f201615e;
        if (aVar != null) {
            aVar.h(baseColorNoteSmallScreenRelativeLayout, i3, i16, i17, i18);
        } else {
            layout(i3, i16, i17, i18);
        }
    }

    private void b0() {
        this.K = this.N;
        this.f201623i0 = false;
        if (this.f201620h.isStarted()) {
            this.f201620h.cancel();
        }
        this.f201632q0.setVisibility(0);
        g0();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201631p0.getLayoutParams();
        layoutParams.removeRule(21);
        layoutParams.removeRule(20);
        layoutParams.addRule(13);
    }

    private void c0() {
        if (this.f201640y0) {
            Drawable drawable = this.f201619g0.getDrawable();
            LottieDrawable lottieDrawable = this.f201639x0;
            if (drawable == lottieDrawable && lottieDrawable != null) {
                if (!lottieDrawable.isRunning()) {
                    this.f201639x0.start();
                    return;
                }
                return;
            }
            O("colornote_clock_blue/data.json", "colornote_clock_blue/images");
            return;
        }
        if (this.f201616e0) {
            Drawable drawable2 = this.f201619g0.getDrawable();
            com.tencent.mobileqq.colornote.anim.c cVar = this.f201621h0;
            if (drawable2 != cVar || cVar == null) {
                this.f201619g0.setImageDrawable(C());
            }
            com.tencent.mobileqq.colornote.anim.c cVar2 = this.f201621h0;
            if (cVar2 != null) {
                cVar2.start(1200);
                return;
            }
            return;
        }
        LottieDrawable lottieDrawable2 = this.f201639x0;
        if (lottieDrawable2 != null) {
            lottieDrawable2.stop();
        }
        com.tencent.mobileqq.colornote.anim.c cVar3 = this.f201621h0;
        if (cVar3 != null) {
            cVar3.stop();
        }
    }

    private void d0() {
        boolean z16;
        boolean z17;
        this.f201618f0 = this.f201616e0;
        this.f201641z0 = this.f201640y0;
        this.f201640y0 = com.tencent.mobileqq.colornote.data.a.n(this.f201633r0);
        boolean z18 = false;
        this.f201616e0 = false;
        this.f201623i0 = false;
        Iterator<ColorNote> it = this.f201633r0.iterator();
        while (it.hasNext()) {
            int i3 = it.next().mServiceType;
            if (i3 != 16973824 && i3 != 17367040) {
                z17 = false;
            } else {
                z17 = true;
            }
            this.f201616e0 = z17;
            if (z17) {
                break;
            }
        }
        if (!this.f201641z0 && !this.f201618f0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.f201640y0 || this.f201616e0) {
            z18 = true;
        }
        if (z18 != z16 && getVisibility() == 0) {
            if (this.f201633r0.size() <= 1) {
                if (this.f201633r0.size() == 1) {
                    if (!this.f201618f0 && !this.f201640y0) {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f201623i0 = true;
        }
    }

    private void e0() {
        if ((!this.f201616e0 && !this.f201640y0) || ((this.f201629n0 == 2 && !com.tencent.mobileqq.colornote.data.a.v(this.f201633r0)) || this.f201629n0 == -1)) {
            MusicDanceImageView musicDanceImageView = this.f201619g0;
            if (musicDanceImageView != null && musicDanceImageView.getVisibility() != 8) {
                if (this.f201623i0) {
                    if (this.f201620h.isStarted()) {
                        return;
                    }
                    this.f201620h.start();
                    return;
                } else {
                    this.f201619g0.setVisibility(8);
                    c0();
                    V();
                    return;
                }
            }
            return;
        }
        MusicDanceImageView musicDanceImageView2 = this.f201619g0;
        if (musicDanceImageView2 != null && musicDanceImageView2.getVisibility() == 0) {
            c0();
            f0();
            V();
            return;
        }
        W();
        c0();
        if (this.f201623i0) {
            if (this.f201620h.isStarted()) {
                return;
            }
            this.f201620h.start();
            return;
        }
        V();
    }

    private void f0() {
        boolean z16;
        int i3;
        int i16;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201619g0.getLayoutParams();
        int i17 = this.f201629n0;
        int i18 = 20;
        int i19 = 0;
        if (i17 == 2) {
            layoutParams.removeRule(21);
            layoutParams.removeRule(20);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.addRule(13);
            return;
        }
        boolean z17 = true;
        if (i17 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean v3 = com.tencent.mobileqq.colornote.data.a.v(this.f201633r0);
        if ((!z16 || v3) && (z16 || !v3)) {
            z17 = false;
        }
        int dpToPx = ViewUtils.dpToPx(12.0f);
        layoutParams.removeRule(13);
        layoutParams.addRule(15);
        if (z17) {
            i3 = 20;
        } else {
            i3 = 21;
        }
        layoutParams.addRule(i3);
        if (z17) {
            i18 = 21;
        }
        layoutParams.removeRule(i18);
        if (z17) {
            i16 = dpToPx;
        } else {
            i16 = 0;
        }
        layoutParams.leftMargin = i16;
        if (!z17) {
            i19 = dpToPx;
        }
        layoutParams.rightMargin = i19;
    }

    private void g0() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201632q0.getLayoutParams();
        if (com.tencent.mobileqq.colornote.data.a.v(this.f201633r0)) {
            layoutParams.addRule(13);
            layoutParams.removeRule(5);
            layoutParams.removeRule(6);
        } else {
            layoutParams.removeRule(13);
            layoutParams.addRule(5, R.id.u0z);
            layoutParams.addRule(6, R.id.u0z);
        }
    }

    private void h0(boolean z16) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f201631p0.getLayoutParams();
        layoutParams.removeRule(13);
        if (z16) {
            layoutParams.addRule(20);
            layoutParams.removeRule(21);
        } else {
            layoutParams.addRule(21);
            layoutParams.removeRule(20);
        }
    }

    private void i0(int i3, int i16) {
        int i17;
        int i18;
        int i19 = (this.P + i3) - this.R;
        int i26 = (this.Q + i16) - this.S;
        int E = E();
        this.K = E;
        int i27 = this.M;
        int A = A();
        int i28 = this.f201613c0 - i27;
        int B = B();
        if (i19 < B) {
            i19 = B;
        }
        if (i19 > A) {
            i17 = A;
        } else {
            i17 = i19;
        }
        int i29 = this.L;
        if (i26 < i29) {
            i26 = i29;
        }
        if (i26 > i28) {
            i18 = i28;
        } else {
            i18 = i26;
        }
        if ((i17 > B && i17 < A) || this.f201635t0) {
            this.f201630o0 = this.f201629n0;
            this.f201629n0 = 2;
            int E2 = E();
            this.K = E2;
            int i36 = this.M;
            Z(this, i17, i18, i17 + E2, i18 + i36);
            int i37 = this.f201630o0;
            int i38 = this.f201629n0;
            if (i37 != i38) {
                T(i38, i37, i17, i18, E2, i36, false);
            }
            if (QQTheme.isNowThemeIsNight()) {
                this.f201632q0.setBackgroundResource(R.drawable.jhf);
                setBackground(null);
                return;
            } else {
                this.f201632q0.setBackgroundResource(R.drawable.jhe);
                setBackground(null);
                return;
            }
        }
        if (i17 == B) {
            int i39 = this.f201629n0;
            this.f201630o0 = i39;
            this.f201629n0 = 0;
            if (i39 != 0) {
                S(0, i39, i17, i18, E, i27);
            }
            Z(this, i17, i18, i17 + E, i18 + i27);
            this.f201632q0.setVisibility(8);
            if (QQTheme.isNowThemeIsNight()) {
                setBackgroundResource(R.drawable.jhd);
                return;
            } else {
                setBackgroundResource(R.drawable.jhc);
                return;
            }
        }
        if (i17 == A) {
            int i46 = this.f201629n0;
            this.f201630o0 = i46;
            this.f201629n0 = 1;
            if (i46 != 1) {
                S(1, i46, i17, i18, E, i27);
            }
            Z(this, i17, i18, i17 + E, i18 + i27);
            this.f201632q0.setVisibility(8);
            if (QQTheme.isNowThemeIsNight()) {
                setBackgroundResource(R.drawable.jhk);
            } else {
                setBackgroundResource(R.drawable.jhj);
            }
        }
    }

    private void j0() {
        int[] iArr = new int[2];
        BaseColorNoteSmallScreenRelativeLayout.e(getContext(), iArr);
        this.f201612b0 = iArr[0];
        this.f201613c0 = iArr[1];
    }

    public int A() {
        return (this.f201612b0 - H()) + this.V;
    }

    public int B() {
        return (-this.V) - this.f201614d0;
    }

    public int D() {
        if (k()) {
            return ((-this.V) + H()) - E();
        }
        if (this.f201629n0 == 1) {
            QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 4, Integer.valueOf(H()));
            return (this.f201612b0 - H()) + this.V;
        }
        da1.a aVar = this.f201615e;
        if (aVar != null) {
            return aVar.g(this);
        }
        return getLeft();
    }

    public int E() {
        return this.N;
    }

    public int H() {
        int i3 = this.f201629n0;
        if (i3 != 0 && i3 != 1) {
            return this.N - this.f201614d0;
        }
        if (P()) {
            return this.N;
        }
        return this.N - this.f201614d0;
    }

    public boolean Q() {
        int i3;
        if ((this.f201616e0 || this.f201623i0 || this.f201640y0) && ((i3 = this.f201629n0) == 0 || i3 == 1)) {
            return true;
        }
        return false;
    }

    public void R() {
        int i3;
        int i16;
        int G = G();
        boolean g16 = ColorNoteSmallScreenUtil.g();
        int[] iArr = new int[2];
        BaseColorNoteSmallScreenRelativeLayout.e(getContext(), iArr);
        if (G % 2 == 1) {
            i3 = iArr[0];
            i16 = iArr[1];
        } else {
            int i17 = iArr[0];
            i3 = iArr[1];
            i16 = i17;
        }
        if (g16) {
            i3 -= this.I;
        }
        int i18 = this.f201611a0;
        if (i18 != G || i16 != this.f201612b0 || ((G == 0 && this.f201613c0 < i3) || (G != 0 && this.f201613c0 != i3))) {
            if (QLog.isColorLevel()) {
                QLog.w("ColorNoteSmallScreenRelativeLayoutV2", 1, "onOrientationChangedInner, mPosition[" + i18 + "], mRotation[" + this.f201611a0 + "->" + G + "], mScreenWidth[" + this.f201612b0 + "->" + i16 + "], mScreenHeight[" + this.f201613c0 + "->" + i3 + "], mIsInit[" + this.H + "]");
            }
            if (this.H && G != 0) {
                this.H = false;
            }
            this.f201617f.cancel();
            this.f201611a0 = G;
            this.f201612b0 = i16;
            this.f201613c0 = i3;
            Point point = new Point(D(), i3 / 2);
            this.f201625k0 = point;
            setCurPosition(point);
            da1.a aVar = this.f201615e;
            if (aVar != null) {
                int g17 = aVar.g(this);
                this.T = g17;
                this.P = g17;
                int d16 = this.f201615e.d(this);
                this.U = d16;
                this.Q = d16;
                this.f201615e.k(this.f201625k0, this.f201611a0);
            } else {
                int left = getLeft();
                this.T = left;
                this.P = left;
                int top = getTop();
                this.U = top;
                this.Q = top;
            }
            if (!this.H) {
                this.f201617f.start();
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.m
    public void a() {
        d0();
        e0();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public boolean b() {
        return Q();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public Point c() {
        return this.f201625k0;
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
                        this.f201635t0 = false;
                        this.E = false;
                        if (this.D) {
                            i0(rawX, rawY);
                            this.f201628m0.removeCallbacks(this.f201626l0);
                        }
                        da1.a aVar = this.f201615e;
                        if (aVar != null) {
                            this.T = aVar.g(this);
                            this.U = this.f201615e.d(this);
                        } else {
                            this.T = getLeft();
                            this.U = getTop();
                        }
                        this.f201617f.start();
                    }
                } else if (this.D) {
                    i0(rawX, rawY);
                    this.f201628m0.removeCallbacks(this.f201626l0);
                } else if (Math.abs(rawX - this.R) > this.J || Math.abs(rawY - this.S) > this.J) {
                    this.f201635t0 = true;
                    this.D = true;
                }
            } else {
                this.f201635t0 = false;
                this.f201628m0.removeCallbacks(this.f201626l0);
                if (this.D) {
                    i0(rawX, rawY);
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    da1.a aVar2 = this.f201615e;
                    if (aVar2 != null && !this.E && currentTimeMillis - this.F > 600) {
                        Point point = this.f201625k0;
                        if (this.f201611a0 == 0) {
                            z16 = true;
                        }
                        z16 = aVar2.q(point, z16);
                        this.F = currentTimeMillis;
                    }
                }
                da1.a aVar3 = this.f201615e;
                if (aVar3 != null) {
                    this.T = aVar3.g(this);
                    this.U = this.f201615e.d(this);
                } else {
                    this.T = getLeft();
                    this.U = getTop();
                }
                if (!z16) {
                    this.f201617f.start();
                }
            }
        } else {
            this.E = false;
            this.f201628m0.postDelayed(this.f201626l0, ViewConfiguration.getLongPressTimeout());
            this.f201617f.cancel();
            this.R = rawX;
            this.S = rawY;
            da1.a aVar4 = this.f201615e;
            if (aVar4 != null) {
                this.P = aVar4.g(this);
                this.Q = this.f201615e.d(this);
            } else {
                this.P = getLeft();
                this.Q = getTop();
            }
            this.D = false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int f() {
        return this.f201613c0;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int g() {
        return this.f201612b0;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int h() {
        return this.M;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public int i() {
        return this.K;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void j() {
        J();
        I();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public boolean k() {
        da1.a aVar;
        int i3;
        if (this.f201629n0 == -1 && (aVar = this.f201615e) != null) {
            this.f201625k0.x = aVar.g(this);
            this.f201625k0.y = this.f201615e.d(this);
            if (this.f201625k0.x < 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            this.f201629n0 = i3;
        }
        if (this.f201629n0 == 0 && this.f201625k0.x > 0 && QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 2, "state is STATE_LEFT, but mPoint.x grater than 0");
        }
        if (this.f201629n0 == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void l() {
        d0();
        boolean z16 = this.f201636u0;
        if (!z16 && this.f201618f0 == this.f201616e0 && this.f201641z0 && this.f201640y0) {
            return;
        }
        if (z16) {
            ArrayList arrayList = new ArrayList();
            for (ColorNote colorNote : this.f201633r0) {
                if (arrayList.size() >= this.f201631p0.g()) {
                    break;
                }
                if (colorNote.getServiceType() != 16973824 && colorNote.getServiceType() != 17367040 && colorNote.mExtra != 2) {
                    arrayList.add(colorNote);
                }
            }
            this.f201631p0.setColorNotes(arrayList);
        }
        this.f201636u0 = false;
        e0();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void m() {
        this.f201625k0.x = D();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void n() {
        List<ColorNote> list = this.f201633r0;
        if (list != null && list.size() != 0) {
            this.K = E();
            this.E = false;
            V();
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void o(List<ColorNote> list) {
        int i3;
        ColorNote colorNote;
        int i16;
        int i17;
        boolean K;
        this.f201636u0 = true;
        if (list == null) {
            this.f201633r0.clear();
            l();
            return;
        }
        int size = this.f201633r0.size();
        int size2 = list.size();
        if (size <= size2 && (i3 = size2 - size) <= 1) {
            ColorNote colorNote2 = null;
            if (this.f201633r0.size() >= 1) {
                colorNote = this.f201633r0.get(0);
            } else {
                colorNote = null;
            }
            if (list.size() >= 1) {
                colorNote2 = list.get(0);
            }
            if (size > 0 && com.tencent.mobileqq.colornote.data.a.t(colorNote) && com.tencent.mobileqq.colornote.data.a.t(colorNote2)) {
                i3++;
                i17 = 1;
                i16 = size - 1;
            } else {
                i16 = size;
                i17 = 0;
            }
            if (i16 == 0) {
                K = true;
            } else {
                K = K(this.f201633r0, list, i17, i3, i16);
            }
            this.f201633r0 = list;
            if (!K) {
                l();
                return;
            } else if (i3 > 0 && list.size() > 0) {
                z(this.f201633r0.get(i3 - 1));
                return;
            } else {
                this.f201636u0 = false;
                return;
            }
        }
        this.f201633r0 = list;
        l();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (animator == this.f201617f) {
            Point point = this.W;
            int E = E();
            this.K = E;
            int i3 = this.M;
            this.f201625k0 = point;
            int i16 = 1;
            if (point.x > 0 && F() != 0) {
                this.f201630o0 = this.f201629n0;
                this.f201629n0 = 1;
                this.f201625k0.x = D();
                if (this.f201625k0.x < 0) {
                    i16 = 0;
                }
                this.f201629n0 = i16;
                int D = D() + E();
                int i17 = this.f201630o0;
                int i18 = this.f201629n0;
                if (i17 != i18) {
                    Point point2 = this.f201625k0;
                    S(i18, i17, point2.x, point2.y, E, i3);
                }
                Point point3 = this.f201625k0;
                int i19 = point3.x;
                int i26 = point3.y;
                Z(this, i19, i26, D, i26 + i3);
                this.f201632q0.setVisibility(8);
                if (QQTheme.isNowThemeIsNight()) {
                    setBackgroundResource(R.drawable.jhk);
                } else {
                    setBackgroundResource(R.drawable.jhj);
                }
                if (this.f201616e0 && this.f201630o0 == this.f201629n0) {
                    W();
                }
            } else {
                this.f201630o0 = this.f201629n0;
                this.f201629n0 = 0;
                this.f201625k0.x = D();
                if (this.f201625k0.x < 0) {
                    i16 = 0;
                }
                this.f201629n0 = i16;
                int D2 = D();
                int E2 = D2 + E();
                int i27 = this.f201630o0;
                int i28 = this.f201629n0;
                if (i27 != i28) {
                    S(i28, i27, D2, this.f201625k0.y, E, i3);
                }
                int i29 = this.f201625k0.y;
                Z(this, D2, i29, E2, i29 + i3);
                this.f201632q0.setVisibility(8);
                if (QQTheme.isNowThemeIsNight()) {
                    setBackgroundResource(R.drawable.jhd);
                } else {
                    setBackgroundResource(R.drawable.jhc);
                }
                if (this.f201616e0 && this.f201630o0 == this.f201629n0) {
                    W();
                }
            }
            da1.a aVar = this.f201615e;
            if (aVar != null) {
                aVar.k(this.f201625k0, this.f201611a0);
            }
            this.H = false;
            if (this.f201625k0.y > this.f201613c0 / 2) {
                ReportController.o(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 2, 0, "", "", "", "");
                return;
            } else {
                ReportController.o(null, "dc00898", "", "", "0X800A6CC", "0X800A6CC", 1, 0, "", "", "", "");
                return;
            }
        }
        if (animator == this.f201620h) {
            this.f201623i0 = false;
            this.K = E();
            this.f201625k0.x = D();
            Point point4 = this.f201625k0;
            int i36 = point4.x;
            int i37 = point4.y;
            Z(this, i36, i37, i36 + this.K, i37 + this.M);
            MusicDanceImageView musicDanceImageView = this.f201619g0;
            if (musicDanceImageView != null && !this.f201616e0 && !this.f201640y0) {
                musicDanceImageView.setVisibility(8);
            }
            c0();
            return;
        }
        if (animator == this.f201622i) {
            if (this.E) {
                this.K = this.N;
            }
            Point point5 = this.f201625k0;
            point5.x = D();
            int E3 = E();
            this.K = E3;
            int i38 = this.M;
            int i39 = point5.x;
            if (i39 <= 0) {
                da1.a aVar2 = this.f201615e;
                if (aVar2 != null) {
                    int i46 = point5.y;
                    aVar2.c(this, i39, i46, E3 + i39 + 0, i46 + i38, 0, true);
                    return;
                }
                return;
            }
            da1.a aVar3 = this.f201615e;
            if (aVar3 != null) {
                int i47 = point5.y;
                aVar3.c(this, i39 + 0, i47, i39 + E3 + 0, i47 + i38, 0, true);
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (animator == this.f201617f) {
            if (this.T + (E() / 2) < this.f201612b0 / 2) {
                if (!this.f201616e0 && !this.f201640y0) {
                    this.W.x = (-this.V) - this.f201614d0;
                } else {
                    this.W.x = -this.V;
                }
                h0(false);
            } else {
                this.W.x = A();
                h0(true);
            }
            this.W.y = this.U;
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float D;
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        if (valueAnimator == this.f201617f) {
            Point point = this.W;
            int i3 = (int) (this.T + ((point.x - r2) * floatValue));
            int i16 = (int) (this.U + ((point.y - r3) * floatValue));
            int E = E();
            this.K = E;
            int i17 = this.M;
            da1.a aVar = this.f201615e;
            if (aVar != null) {
                aVar.h(this, i3, i16, i3 + E, i16 + i17);
                return;
            } else {
                layout(i3, i16, E + i3, i17 + i16);
                return;
            }
        }
        if (valueAnimator == this.f201620h) {
            if (!this.f201616e0 && !this.f201640y0) {
                if (k()) {
                    D = D() - (floatValue * this.f201614d0);
                } else {
                    D = D() + (floatValue * this.f201614d0);
                }
            } else if (k()) {
                D = D() - ((1.0f - floatValue) * this.f201614d0);
            } else {
                D = D() + ((1.0f - floatValue) * this.f201614d0);
            }
            int i18 = (int) D;
            Z(this, i18, this.f201625k0.y, i18 + E(), this.f201625k0.y + this.M);
            return;
        }
        if (valueAnimator == this.f201622i) {
            if (this.E) {
                this.K = this.N;
            }
            if (this.f201633r0.size() == 1 && !com.tencent.mobileqq.colornote.data.a.n(this.f201633r0)) {
                int i19 = (int) ((this.K / 2) * floatValue);
                this.f201625k0.x = D();
                Point point2 = this.f201625k0;
                int E2 = E();
                this.K = E2;
                int i26 = this.M;
                int i27 = point2.x;
                if (i27 <= 0) {
                    da1.a aVar2 = this.f201615e;
                    if (aVar2 != null) {
                        int i28 = point2.y;
                        aVar2.c(this, i27, i28, E2 + i27 + i19, i28 + i26, i19, false);
                        return;
                    }
                    return;
                }
                da1.a aVar3 = this.f201615e;
                if (aVar3 != null) {
                    int i29 = point2.y;
                    aVar3.c(this, i27 - i19, i29, (i27 + E2) - i19, i29 + i26, -i19, false);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        R();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        J();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.f201612b0 == 0 || this.f201613c0 == 0) {
            j0();
            setCurPosition(this.f201625k0);
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void p() {
        if (this.f201612b0 != 0 && this.f201613c0 != 0) {
            Point point = this.f201625k0;
            int E = E();
            this.K = E;
            int i3 = this.M;
            da1.a aVar = this.f201615e;
            if (aVar != null && !this.G) {
                int i16 = point.x;
                int i17 = point.y;
                aVar.h(this, i16, i17, i16 + E, i17 + i3);
            } else {
                int i18 = point.x;
                int i19 = point.y;
                layout(i18, i19, E + i18, i3 + i19);
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
            QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 2, "setCurPosition position = " + point);
            QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 2, "setCurPosition mScreenWidth = " + this.f201612b0);
            QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 2, "setCurPosition mScreenHeight = " + this.f201613c0);
        }
        this.f201625k0 = point;
        boolean z16 = false;
        if (point.x < 0) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        this.f201629n0 = i3;
        if (i3 == 1) {
            z16 = true;
        }
        h0(z16);
        int i17 = this.f201612b0;
        if (i17 != 0 && (i16 = this.f201613c0) != 0) {
            int i18 = this.K;
            int i19 = this.M;
            if (point.x == 0 && point.y == 0) {
                point.y = i16 / 2;
                point.x = i17 - i18;
            } else {
                point.x = D();
                this.f201625k0.x = D();
            }
            da1.a aVar = this.f201615e;
            if (aVar != null) {
                int i26 = point.x;
                int i27 = point.y;
                aVar.h(this, i26, i27, i26 + i18, i27 + i19);
            } else {
                int i28 = point.x;
                int i29 = point.y;
                layout(i28, i29, i18 + i28, i19 + i29);
            }
        }
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setCustomNightMode(boolean z16) {
        BaseColorNoteSmallScreenRelativeLayout.f201555d = z16;
        X();
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setFloatListener(da1.a aVar) {
        this.f201615e = aVar;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setShouldMaxRootView(boolean z16) {
        this.G = z16;
    }

    @Override // com.tencent.mobileqq.colornote.smallscreen.BaseColorNoteSmallScreenRelativeLayout
    public void setUpcomingController(p pVar) {
        this.f201637v0 = pVar;
    }

    public void z(ColorNote colorNote) {
        if (colorNote != null && colorNote.getServiceType() != 16973824 && colorNote.getServiceType() != 17367040) {
            this.f201631p0.f(colorNote);
        }
        d0();
        e0();
    }

    public ColorNoteSmallScreenRelativeLayoutV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorNoteSmallScreenRelativeLayoutV2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0L;
        this.G = false;
        this.H = true;
        this.L = ImmersiveUtils.getStatusBarHeight(getContext());
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
        this.T = -1;
        this.U = -1;
        this.V = -1;
        this.W = new Point(0, 0);
        this.f201611a0 = 0;
        this.f201612b0 = 0;
        this.f201613c0 = 0;
        this.f201614d0 = 0;
        this.f201616e0 = false;
        this.f201618f0 = false;
        this.f201623i0 = false;
        this.f201624j0 = null;
        this.f201625k0 = new Point();
        this.f201626l0 = new CheckForLongPress();
        this.f201628m0 = new MqqHandler(Looper.getMainLooper());
        this.f201629n0 = -1;
        this.f201630o0 = -1;
        this.f201633r0 = new ArrayList();
        this.f201634s0 = -1;
        this.f201635t0 = false;
        this.f201636u0 = true;
        this.f201638w0 = false;
        this.f201640y0 = false;
        this.f201641z0 = false;
        if (QLog.isColorLevel()) {
            QLog.d("ColorNoteSmallScreenRelativeLayoutV2", 2, "SmallScreenRelativeLayout");
        }
        this.J = ViewConfiguration.get(context).getScaledTouchSlop();
        this.K = getResources().getDimensionPixelSize(R.dimen.c75);
        this.M = getResources().getDimensionPixelSize(R.dimen.f158506c74);
        this.f201614d0 = getResources().getDimensionPixelSize(R.dimen.f158503c71);
        this.N = this.K;
        this.I = getResources().getDimensionPixelSize(R.dimen.a9i);
        this.f201627m = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.f201611a0 = G();
        if (Build.VERSION.SDK_INT != 23) {
            this.f201624j0 = new a(getContext(), 2);
        }
        j0();
        this.V = Utils.n(1.0f, getResources());
    }

    private void a0() {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }
}
