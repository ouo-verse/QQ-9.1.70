package com.tencent.widget.media;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QUISeekBar extends FrameLayout implements SeekBar.OnSeekBarChangeListener, com.tencent.widget.media.a {
    static IPatchRedirector $redirector_;
    private static final int J;
    private static final int K;
    private static final int L;
    private static final int M;
    private static final int N;
    private static final int P;
    private static final int Q;
    private static final int R;
    private final Set<SeekBar.OnSeekBarChangeListener> C;
    private final Set<d> D;
    private boolean E;
    private int F;
    private boolean G;
    private int H;
    private com.tencent.widget.media.b I;

    /* renamed from: d, reason: collision with root package name */
    private final SeekBar f384802d;

    /* renamed from: e, reason: collision with root package name */
    private final View f384803e;

    /* renamed from: f, reason: collision with root package name */
    private final View f384804f;

    /* renamed from: h, reason: collision with root package name */
    private final View f384805h;

    /* renamed from: i, reason: collision with root package name */
    private final Runnable f384806i;

    /* renamed from: m, reason: collision with root package name */
    private SeekBar.OnSeekBarChangeListener f384807m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUISeekBar.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i3 = (int) (QUISeekBar.K - ((QUISeekBar.K - QUISeekBar.L) * floatValue));
            QUISeekBar.this.f384804f.getLayoutParams().height = i3;
            QUISeekBar.this.f384805h.getLayoutParams().height = i3;
            int K = QUISeekBar.this.K();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QUISeekBar.this.f384803e.getLayoutParams();
            int i16 = K - QUISeekBar.R;
            int i17 = K - QUISeekBar.R;
            float f16 = K;
            int max = (int) Math.max(QUISeekBar.R, f16 - (i16 * floatValue));
            int max2 = (int) Math.max(QUISeekBar.R, f16 - (i17 * floatValue));
            layoutParams.width = max;
            layoutParams.height = max2;
            if (QUISeekBar.this.f384802d.getProgress() >= QUISeekBar.this.J()) {
                QLog.d("QUISeekBar", 4, "min over max:" + layoutParams.leftMargin + max + "|" + QUISeekBar.this.I());
                layoutParams.leftMargin = QUISeekBar.this.I() - max;
            }
            QUISeekBar.this.f384804f.requestLayout();
            QUISeekBar.this.f384805h.requestLayout();
            QUISeekBar.this.f384803e.requestLayout();
            if (floatValue >= 1.0f) {
                QUISeekBar.this.E = false;
                QUISeekBar.this.f384805h.setBackground(QUISeekBar.this.L(0));
                QUISeekBar.this.f384804f.setBackground(QUISeekBar.this.H(0));
                QUISeekBar.this.f384803e.setBackground(QUISeekBar.this.N(0));
                int min = (int) Math.min((QUISeekBar.this.f384802d.getProgress() / QUISeekBar.this.f384802d.getMax()) * QUISeekBar.this.I(), r7 - max);
                layoutParams.leftMargin = min;
                QUISeekBar.this.f384805h.getLayoutParams().width = min + (max / 2);
                QUISeekBar.this.G();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUISeekBar.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i3 = (int) (QUISeekBar.J - ((QUISeekBar.J - QUISeekBar.K) * floatValue));
            QUISeekBar.this.f384804f.getLayoutParams().height = i3;
            QUISeekBar.this.f384805h.getLayoutParams().height = i3;
            int K = QUISeekBar.this.K();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) QUISeekBar.this.f384803e.getLayoutParams();
            int i16 = QUISeekBar.N - K;
            int i17 = QUISeekBar.M - K;
            int i18 = (int) (QUISeekBar.N - (i16 * floatValue));
            layoutParams.width = i18;
            layoutParams.height = (int) (QUISeekBar.M - (i17 * floatValue));
            if (QUISeekBar.this.f384802d.getProgress() >= QUISeekBar.this.J()) {
                QLog.d("QUISeekBar", 4, "middle over max:" + layoutParams.leftMargin + i18 + "|" + QUISeekBar.this.I());
                layoutParams.leftMargin = QUISeekBar.this.I() - i18;
            }
            QUISeekBar.this.f384804f.requestLayout();
            QUISeekBar.this.f384805h.requestLayout();
            QUISeekBar.this.f384803e.requestLayout();
            if (floatValue >= 1.0f) {
                QUISeekBar.this.E = false;
                QUISeekBar.this.f384803e.setBackground(QUISeekBar.this.N(1));
                QUISeekBar.this.f384805h.setBackground(QUISeekBar.this.L(1));
                QUISeekBar.this.f384804f.setBackground(QUISeekBar.this.H(1));
                if (QUISeekBar.this.G) {
                    QUISeekBar qUISeekBar = QUISeekBar.this;
                    qUISeekBar.postDelayed(qUISeekBar.f384806i, 2000L);
                }
                QUISeekBar.this.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QUISeekBar.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) valueAnimator);
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i3 = (int) (QUISeekBar.L + ((QUISeekBar.K - QUISeekBar.L) * floatValue));
            QUISeekBar.this.f384804f.getLayoutParams().height = i3;
            QUISeekBar.this.f384805h.getLayoutParams().height = i3;
            QUISeekBar.this.f384805h.setBackground(QUISeekBar.this.L(1));
            QUISeekBar.this.f384804f.setBackground(QUISeekBar.this.H(1));
            int K = QUISeekBar.this.K();
            int i16 = K - QUISeekBar.R;
            int i17 = K - QUISeekBar.R;
            float f16 = K;
            int min = (int) Math.min(f16, QUISeekBar.R + (i16 * floatValue));
            int min2 = (int) Math.min(f16, QUISeekBar.R + (i17 * floatValue));
            QUISeekBar.this.f384803e.getLayoutParams().width = min;
            QUISeekBar.this.f384803e.getLayoutParams().height = min2;
            QUISeekBar.this.f384803e.setBackground(QUISeekBar.this.N(1));
            QUISeekBar.this.f384804f.requestLayout();
            QUISeekBar.this.f384803e.requestLayout();
            QUISeekBar.this.f384805h.requestLayout();
            if (floatValue >= 1.0f) {
                QUISeekBar.this.E = false;
                QUISeekBar.this.F();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface d {
        void F();

        void h();

        void p();
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56875);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 25)) {
            redirector.redirect((short) 25);
            return;
        }
        J = ImmersiveUtils.dpToPx(10.0f);
        K = ImmersiveUtils.dpToPx(4.0f);
        L = ImmersiveUtils.dpToPx(1.0f);
        M = ImmersiveUtils.dpToPx(16.0f);
        N = ImmersiveUtils.dpToPx(10.0f);
        P = ImmersiveUtils.dpToPx(12.0f);
        Q = ImmersiveUtils.dpToPx(6.0f);
        R = ImmersiveUtils.dpToPx(3.0f);
    }

    public QUISeekBar(@NonNull Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void B() {
        int i3 = this.F;
        if (i3 == 0) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(320L);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.widget.media.d
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QUISeekBar.this.Q(valueAnimator);
                }
            });
            E();
            ofFloat.start();
            this.F = 2;
            return;
        }
        if (i3 == 1) {
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(160L);
            ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.widget.media.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    QUISeekBar.this.R(valueAnimator);
                }
            });
            E();
            ofFloat2.start();
            this.F = 2;
        }
    }

    private void C() {
        int i3 = this.F;
        if (i3 == 2) {
            this.E = true;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(160L);
            ofFloat.addUpdateListener(new b());
            ofFloat.start();
            this.F = 1;
            return;
        }
        if (i3 == 0) {
            this.E = true;
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat2.setDuration(160L);
            ofFloat2.addUpdateListener(new c());
            ofFloat2.start();
            this.F = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void S() {
        this.E = true;
        removeCallbacks(this.f384806i);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(160L);
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
        this.F = 0;
    }

    private void E() {
        Iterator<d> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        Iterator<d> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        Iterator<d> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable H(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_middle_back_drawable);
            }
            return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_max_back_drawable);
        }
        return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_min_back_drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int K() {
        if (this.H == 0) {
            return P;
        }
        return Q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable L(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_middle_progress_drawable);
            }
            return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_max_progress_drawable);
        }
        return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_min_progress_drawable);
    }

    private int M(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return K;
            }
            return J;
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Drawable N(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_middle_thumb_drawable);
            }
            return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_max_thumb_drawable);
        }
        return AppCompatResources.getDrawable(getContext(), R.drawable.qui_seek_bar_min_thumb_drawable);
    }

    private int O(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return K();
            }
            return M;
        }
        return R;
    }

    private int P(int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                return K();
            }
            return N;
        }
        return R;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int min = (int) Math.min(L + ((r0 - r1) * floatValue), J);
        this.f384804f.getLayoutParams().height = min;
        this.f384805h.getLayoutParams().height = min;
        this.f384805h.setBackground(L(2));
        this.f384804f.setBackground(H(2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f384803e.getLayoutParams();
        int i3 = N;
        int i16 = R;
        int i17 = M;
        int min2 = (int) Math.min(i3, i16 + ((i3 - i16) * floatValue));
        int min3 = (int) Math.min(i17, i16 + ((i17 - i16) * floatValue));
        layoutParams.width = min2;
        layoutParams.height = min3;
        if (layoutParams.leftMargin + min2 > I()) {
            QLog.d("QUISeekBar", 4, "over max:" + layoutParams.leftMargin + min2 + "|" + I());
            layoutParams.leftMargin = I() - min2;
        }
        this.f384803e.setBackground(N(2));
        this.f384804f.requestLayout();
        this.f384805h.requestLayout();
        this.f384803e.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        int i3 = J;
        int i16 = (int) (K + ((i3 - r1) * floatValue));
        this.f384804f.getLayoutParams().height = i16;
        this.f384805h.getLayoutParams().height = i16;
        this.f384805h.setBackground(L(2));
        this.f384804f.setBackground(H(2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f384803e.getLayoutParams();
        int K2 = K();
        int i17 = N;
        int i18 = i17 - K2;
        int i19 = M;
        int i26 = i19 - K2;
        float f16 = K2;
        int min = (int) Math.min(i17, (i18 * floatValue) + f16);
        int min2 = (int) Math.min(i19, f16 + (i26 * floatValue));
        layoutParams.width = min;
        layoutParams.height = min2;
        if (layoutParams.leftMargin + min > I()) {
            QLog.d("QUISeekBar", 4, "over max:" + layoutParams.leftMargin + min + "|" + I());
            layoutParams.leftMargin = I() - min;
        }
        this.f384803e.setBackground(N(2));
        this.f384804f.requestLayout();
        this.f384805h.requestLayout();
        this.f384803e.requestLayout();
    }

    public void A(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) dVar);
        } else {
            if (dVar == null) {
                return;
            }
            this.D.add(dVar);
        }
    }

    public int J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.f384802d.getMax();
    }

    public void T() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        removeCallbacks(this.f384806i);
        this.f384804f.getLayoutParams().height = M(1);
        this.f384805h.getLayoutParams().height = M(1);
        this.f384803e.getLayoutParams().width = P(1);
        this.f384803e.getLayoutParams().height = O(1);
        this.f384803e.setBackground(N(1));
        this.f384805h.setBackground(L(1));
        this.f384804f.setBackground(H(1));
        this.f384804f.requestLayout();
        this.f384805h.requestLayout();
        this.f384803e.requestLayout();
        this.F = 1;
        F();
    }

    public void U(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            this.C.remove(onSeekBarChangeListener);
        }
    }

    public void V(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
        } else {
            this.D.remove(dVar);
        }
    }

    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        removeCallbacks(this.f384806i);
        this.f384804f.getLayoutParams().height = M(!this.G ? 1 : 0);
        this.f384805h.getLayoutParams().height = M(!this.G ? 1 : 0);
        this.f384803e.getLayoutParams().width = P(!this.G ? 1 : 0);
        this.f384803e.getLayoutParams().height = O(!this.G ? 1 : 0);
        this.f384805h.setBackground(L(!this.G ? 1 : 0));
        this.f384804f.setBackground(H(!this.G ? 1 : 0));
        this.f384803e.setBackground(N(!this.G ? 1 : 0));
        this.f384804f.requestLayout();
        this.f384805h.requestLayout();
        this.f384803e.requestLayout();
        boolean z16 = this.G;
        this.F = !z16 ? 1 : 0;
        if (z16) {
            G();
        } else {
            F();
        }
    }

    public void X() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            W();
        }
    }

    @Override // com.tencent.widget.media.a
    public SeekBar a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (SeekBar) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.f384802d;
    }

    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (View) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, seekBar, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.E) {
            QLog.d("QUISeekBar", 1, "mIsOnAni return");
            return;
        }
        int I = I();
        int P2 = P(this.F);
        int min = (int) Math.min((i3 / this.f384802d.getMax()) * I, I - P2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f384803e.getLayoutParams();
        layoutParams.setMargins(min, 0, 0, 0);
        this.f384803e.setLayoutParams(layoutParams);
        this.f384803e.requestLayout();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f384805h.getLayoutParams();
        layoutParams2.width = min + (P2 / 2);
        this.f384805h.setLayoutParams(layoutParams2);
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.f384807m;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(seekBar, i3, z16);
        }
        Iterator<SeekBar.OnSeekBarChangeListener> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().onProgressChanged(seekBar, i3, z16);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) seekBar);
            return;
        }
        removeCallbacks(this.f384806i);
        B();
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.f384807m;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onStartTrackingTouch(seekBar);
        }
        Iterator<SeekBar.OnSeekBarChangeListener> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(seekBar);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) seekBar);
        } else {
            C();
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.f384807m;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
            Iterator<SeekBar.OnSeekBarChangeListener> it = this.C.iterator();
            while (it.hasNext()) {
                it.next().onStopTrackingTouch(seekBar);
            }
        }
        EventCollector.getInstance().onStopTrackingTouch(seekBar);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (!isEnabled()) {
            return false;
        }
        com.tencent.widget.media.b bVar = this.I;
        if (bVar != null) {
            return a().onTouchEvent(bVar.a(motionEvent, a()));
        }
        return this.f384802d.onTouchEvent(motionEvent);
    }

    public void setEnableMinStatus(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.G = z16;
            W();
        }
    }

    public void setEventHelper(com.tencent.widget.media.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            this.I = bVar;
        }
    }

    public void setMax(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f384802d.setMax(i3);
        }
    }

    public void setMiddleThumbStyle(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else if (i3 != 0 && i3 != 1) {
            QLog.d("QUISeekBar", 1, "error style");
        } else {
            this.H = i3;
            W();
        }
    }

    public void setProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f384802d.setProgress(i3);
        }
    }

    @Override // com.tencent.widget.media.a
    @Deprecated
    public void setSeekBarListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            this.f384807m = onSeekBarChangeListener;
        }
    }

    public void z(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) onSeekBarChangeListener);
        } else {
            if (onSeekBarChangeListener == null) {
                return;
            }
            this.C.add(onSeekBarChangeListener);
        }
    }

    public QUISeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QUISeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }

    public QUISeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f384806i = new Runnable() { // from class: com.tencent.widget.media.c
            @Override // java.lang.Runnable
            public final void run() {
                QUISeekBar.this.S();
            }
        };
        this.C = new HashSet();
        this.D = new HashSet();
        this.F = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.f410049f6);
        this.G = obtainStyledAttributes.getBoolean(jj2.b.f410061g6, false);
        this.H = obtainStyledAttributes.getInt(jj2.b.f410073h6, 0);
        obtainStyledAttributes.recycle();
        SeekBar seekBar = new SeekBar(context);
        this.f384802d = seekBar;
        seekBar.setOnSeekBarChangeListener(this);
        addView(seekBar, new FrameLayout.LayoutParams(-1, 0));
        View view = new View(context);
        this.f384804f = view;
        view.setBackground(H(!this.G ? 1 : 0));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, M(!this.G ? 1 : 0));
        layoutParams.gravity = 17;
        addView(view, layoutParams);
        View view2 = new View(context);
        this.f384805h = view2;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, M(!this.G ? 1 : 0));
        layoutParams2.gravity = 16;
        view2.setBackground(L(!this.G ? 1 : 0));
        addView(view2, layoutParams2);
        View view3 = new View(context);
        this.f384803e = view3;
        view3.setBackground(N(!this.G ? 1 : 0));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(P(!this.G ? 1 : 0), O(!this.G ? 1 : 0));
        layoutParams3.gravity = 16;
        addView(view3, layoutParams3);
    }
}
