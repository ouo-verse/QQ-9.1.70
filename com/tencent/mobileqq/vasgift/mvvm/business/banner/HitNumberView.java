package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPAGAnimationViewImpl;
import com.tencent.qphone.base.util.QLog;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HitNumberView extends FrameLayout {
    protected BannerResManager C;
    private int D;
    private int E;
    private boolean F;
    private g G;
    private e H;
    private int I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f311759d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f311760e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f311761f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f311762h;

    /* renamed from: i, reason: collision with root package name */
    private View f311763i;

    /* renamed from: m, reason: collision with root package name */
    private PAGView f311764m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("Gift_Banner_HitNumberView", 1, "scale onAnimationCancel curNum:" + HitNumberView.this.D + " target:" + HitNumberView.this.E);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z16) {
            onAnimationEnd(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (HitNumberView.this.F) {
                HitNumberView hitNumberView = HitNumberView.this;
                hitNumberView.J = hitNumberView.D;
                if (HitNumberView.this.D >= HitNumberView.this.E) {
                    HitNumberView.this.F = false;
                    if (HitNumberView.this.H != null) {
                        HitNumberView.this.H.h();
                        return;
                    }
                    return;
                }
                HitNumberView hitNumberView2 = HitNumberView.this;
                hitNumberView2.setNum(hitNumberView2.D + 1);
                HitNumberView.this.G.d();
                HitNumberView.this.G.c();
                HitNumberView.this.m();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z16) {
            onAnimationStart(animator);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }

    public HitNumberView(@NonNull Context context) {
        this(context, null);
    }

    private int[] i(int i3) {
        int[] iArr = {-1, -1, -1};
        int i16 = i3 / 100;
        if (i16 > 0) {
            iArr[0] = i16;
            iArr[1] = (i3 % 100) / 10;
            iArr[2] = i3 % 10;
            return iArr;
        }
        int i17 = i3 / 10;
        if (i17 > 0) {
            iArr[0] = i17;
            iArr[1] = i3 % 10;
            return iArr;
        }
        iArr[0] = i3;
        return iArr;
    }

    private int j(int i3) {
        if (i3 < 10) {
            return 1;
        }
        if (i3 < 50) {
            return 2;
        }
        if (i3 < 100) {
            return 3;
        }
        return 4;
    }

    private void l() {
        this.f311759d = (ImageView) findViewById(R.id.j9k);
        this.f311760e = (ImageView) findViewById(R.id.f166443fc1);
        this.f311761f = (ImageView) findViewById(R.id.f166444fc2);
        this.f311762h = (ImageView) findViewById(R.id.f166445fc3);
        this.f311763i = findViewById(R.id.t9a);
        g gVar = new g(this, 1.0f, 0.77f);
        this.G = gVar;
        gVar.a(new a());
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (!QQGiftPAGAnimationViewImpl.f311895g.a()) {
            QLog.e("Gift_Banner_HitNumberView", 1, "playBoom but pag is not load");
            return;
        }
        n();
        this.f311764m.setProgress(0.14000000059604645d);
        this.f311764m.play();
    }

    private void n() {
        if (this.f311764m == null && QQGiftPAGAnimationViewImpl.f311895g.a()) {
            this.f311764m = new PAGView(getContext());
            ViewParent parent = this.f311763i.getParent();
            if (parent instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.addView(this.f311764m, viewGroup.indexOfChild(this.f311763i), this.f311763i.getLayoutParams());
                viewGroup.removeView(this.f311763i);
            }
        }
    }

    private void q() {
        if (!QQGiftPAGAnimationViewImpl.f311895g.a()) {
            QLog.e("Gift_Banner_HitNumberView", 1, "stopBoom but pag is not load");
            return;
        }
        n();
        if (this.f311764m.isPlaying()) {
            this.f311764m.stop();
        }
    }

    private void s() {
        if (!QQGiftPAGAnimationViewImpl.f311895g.a()) {
            QLog.e("Gift_Banner_HitNumberView", 1, "updateBoomFile but pag is not load");
        } else {
            n();
            this.f311764m.setComposition(this.C.p(this.I));
        }
    }

    public int k() {
        return this.D;
    }

    public void o() {
        this.J = 0;
    }

    public void p() {
        QLog.i("Gift_Banner_HitNumberView", 1, "stop curNum " + this.D + " isPlaying is " + this.F);
        this.I = -1;
        this.F = false;
        this.G.d();
        q();
        o();
    }

    public void r(int i3) {
        QLog.i("Gift_Banner_HitNumberView", 1, "toNum " + i3 + " isPlaying is " + this.F);
        int i16 = this.D;
        if (i16 > i3) {
            return;
        }
        this.E = i3;
        if (!this.F) {
            this.F = true;
            if (i16 == this.J) {
                setNum(i16 + 1);
            }
            this.G.c();
            m();
            e eVar = this.H;
            if (eVar != null) {
                eVar.f();
            }
        }
    }

    public void setListener(e eVar) {
        this.H = eVar;
    }

    public void setNum(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Gift_Banner_HitNumberView", 1, "setNum " + i3);
        }
        this.D = i3;
        int j3 = j(i3);
        if (this.I != j3) {
            this.I = j3;
            QLog.i("Gift_Banner_HitNumberView", 1, "level change " + j3);
            e eVar = this.H;
            if (eVar != null) {
                eVar.d(j3);
            }
            s();
        }
        int[] i16 = i(i3);
        this.f311759d.setImageBitmap(this.C.B(j3));
        this.f311760e.setImageBitmap(this.C.z(j3, i16[0]));
        if (i16[1] >= 0) {
            this.f311761f.setVisibility(0);
            this.f311761f.setImageBitmap(this.C.z(j3, i16[1]));
        } else {
            this.f311761f.setVisibility(8);
        }
        if (i16[2] >= 0) {
            this.f311762h.setVisibility(0);
            this.f311762h.setImageBitmap(this.C.z(j3, i16[2]));
        } else {
            this.f311762h.setVisibility(8);
        }
    }

    public void setResManager(BannerResManager bannerResManager) {
        this.C = bannerResManager;
    }

    public HitNumberView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HitNumberView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.I = -1;
        this.J = 0;
        LayoutInflater.from(context).inflate(R.layout.h8s, (ViewGroup) this, true);
        l();
    }
}
