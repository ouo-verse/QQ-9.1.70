package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* loaded from: classes32.dex */
public class PickerContainer extends RelativeLayout implements PickerBarLayout.b {
    public static final String N = HardCodeUtil.qqStr(R.string.p6q);
    private com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a C;
    private PickerBarLayout D;
    private ImageView E;
    private com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.c F;
    private Handler G;
    private Float H;
    private boolean I;
    private WeakReference<d> J;
    private ValueAnimator K;
    private boolean L;
    Property<PickerContainer, Float> M;

    /* renamed from: d, reason: collision with root package name */
    private float f68857d;

    /* renamed from: e, reason: collision with root package name */
    public float f68858e;

    /* renamed from: f, reason: collision with root package name */
    public float f68859f;

    /* renamed from: h, reason: collision with root package name */
    private float f68860h;

    /* renamed from: i, reason: collision with root package name */
    private int f68861i;

    /* renamed from: m, reason: collision with root package name */
    private View f68862m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PickerContainer pickerContainer = PickerContainer.this;
            pickerContainer.setAlpha(pickerContainer.H.floatValue());
            PickerContainer.this.invalidate();
        }
    }

    /* loaded from: classes32.dex */
    public interface d {
        void M(int i3, String str);

        void k(int i3, String str);

        void x(int i3, String str);
    }

    public PickerContainer(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Float p() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Float f16) {
        this.H = f16;
    }

    private void v(boolean z16, long j3) {
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.K.removeAllUpdateListeners();
            this.K = null;
        }
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat(this.M, this.H.floatValue(), !z16 ? 0.0f : 1.0f));
        this.K = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setDuration(j3);
            this.K.setRepeatMode(1);
            this.K.setRepeatCount(0);
            this.K.setStartDelay(0L);
            this.K.addUpdateListener(new b());
            this.K.addListener(new c());
            this.K.start();
        }
    }

    private void w() {
        if (this.I) {
            ValueAnimator valueAnimator = this.K;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.K.removeAllUpdateListeners();
                this.K = null;
            }
            this.I = false;
        }
    }

    private void x(Context context) {
        this.f68857d = r(context, this.f68857d);
        this.f68858e = r(context, this.f68858e);
        this.f68859f = r(context, this.f68859f);
        this.f68860h = r(context, this.f68860h);
        this.f68861i = BaseAIOUtils.f(this.f68861i, context.getResources());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout.b
    public void e(int i3, final String str, boolean z16, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d("PickerContainer", 2, "onSelected: index:" + i3 + " text:" + str + " bstart:" + z16 + " bend:" + z17);
        }
        d dVar = this.J.get();
        if (dVar != null) {
            if (z16) {
                this.L = true;
                dVar.M(i3, str);
            } else if (z17) {
                this.L = false;
                dVar.k(i3, str);
            } else {
                dVar.x(i3, str);
            }
        }
        this.G.removeCallbacksAndMessages(null);
        this.G.postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.4
            @Override // java.lang.Runnable
            public void run() {
                if (PickerContainer.this.F != null && PickerContainer.this.F.z(str)) {
                    PickerContainer.this.F.stop();
                    PickerContainer.this.F.w(!PickerContainer.this.L);
                    PickerContainer.this.F.v(1);
                    PickerContainer.this.F.start();
                }
                if (PickerContainer.this.E != null) {
                    PickerContainer.this.E.setVisibility(0);
                }
                if (PickerContainer.this.L || PickerContainer.this.C == null) {
                    return;
                }
                PickerContainer.this.C.stop();
                PickerContainer.this.C.o(true);
                PickerContainer.this.C.n(1);
                PickerContainer.this.C.start();
            }
        }, 300L);
    }

    public boolean q(EditVideoParams editVideoParams, d dVar) {
        this.J = new WeakReference<>(dVar);
        x(getContext());
        this.f68862m = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a aVar = new com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a();
        this.C = aVar;
        aVar.m(getContext());
        this.f68862m.setBackground(this.C);
        addView(this.f68862m, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.bottomMargin = this.f68861i;
        addView(relativeLayout, layoutParams2);
        PickerBarLayout pickerBarLayout = new PickerBarLayout(getContext());
        this.D = pickerBarLayout;
        pickerBarLayout.w(editVideoParams, getContext(), this);
        this.f68860h = (this.D.v() * 60) + 80 + (this.D.v() * 5) + 22 + 70;
        this.f68860h = r(getContext(), this.f68860h);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) this.f68857d, (int) this.f68860h);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.D, layoutParams3);
        this.E = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) this.f68858e, (int) this.f68859f);
        layoutParams4.addRule(13);
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.c cVar = new com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.c();
        this.F = cVar;
        cVar.u(getContext(), this.f68858e, this.f68859f, 1.2f);
        this.E.setBackground(this.F);
        relativeLayout.addView(this.E, layoutParams4);
        return true;
    }

    public void s(int i3, boolean z16) {
        PickerBarLayout pickerBarLayout = this.D;
        if (pickerBarLayout != null) {
            pickerBarLayout.C(i3, z16);
        }
    }

    public void u(boolean z16, long j3) {
        if (this.I) {
            w();
        }
        if (j3 > 0) {
            setVisibility(0);
            v(z16, j3);
            return;
        }
        setAlpha(1.0f);
        if (z16) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }

    /* loaded from: classes32.dex */
    class a extends Property<PickerContainer, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(PickerContainer pickerContainer) {
            if (pickerContainer != null) {
                return pickerContainer.p();
            }
            return Float.valueOf(1.0f);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(PickerContainer pickerContainer, Float f16) {
            if (pickerContainer != null) {
                pickerContainer.t(f16);
            }
        }
    }

    public PickerContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void y() {
        this.J = null;
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.c cVar = this.F;
        if (cVar != null) {
            cVar.B();
            this.F = null;
        }
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a aVar = this.C;
        if (aVar != null) {
            aVar.t();
            this.C = null;
        }
        this.f68862m = null;
        PickerBarLayout pickerBarLayout = this.D;
        if (pickerBarLayout != null) {
            pickerBarLayout.G();
        }
        this.E = null;
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.K.removeAllUpdateListeners();
            this.K = null;
        }
        this.M = null;
    }

    public PickerContainer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f68857d = 200.0f;
        this.f68858e = 333.6f;
        this.f68859f = 333.6f;
        this.f68860h = 497.0f;
        this.f68861i = 58;
        this.G = new Handler(Looper.getMainLooper());
        this.H = Float.valueOf(1.0f);
        this.I = false;
        this.L = false;
        this.M = new a(Float.class, "containerAlpha");
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout.b
    public void b(int i3) {
        if (i3 == 4) {
            this.G.removeCallbacksAndMessages(null);
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.c cVar = this.F;
            if (cVar != null) {
                cVar.stop();
                if (this.F.o() == 1 || this.F.o() == 3) {
                    this.F.v(2);
                    this.F.start();
                }
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout.b
    public void c(int i3) {
        com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a aVar;
        if (i3 == 1) {
            com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.a aVar2 = this.C;
            if (aVar2 != null) {
                aVar2.stop();
                this.C.o(false);
                this.C.n(1);
                this.C.start();
                return;
            }
            return;
        }
        if (i3 == 4 || (aVar = this.C) == null) {
            return;
        }
        aVar.stop();
        this.C.o(false);
        this.C.n(2);
        this.C.start();
    }

    private static float o(float f16, Resources resources) {
        if (f16 == 0.0f) {
            return 0.0f;
        }
        return f16 * resources.getDisplayMetrics().density;
    }

    public static float r(Context context, float f16) {
        return context == null ? f16 : o(f16 / 2.0f, context.getResources());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends com.tencent.mobileqq.widget.f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (PickerContainer.this.I) {
                if (PickerContainer.this.H.floatValue() < 0.01f) {
                    PickerContainer.this.setVisibility(4);
                }
                PickerContainer.this.I = false;
            }
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PickerContainer.this.I) {
                if (PickerContainer.this.H.floatValue() < 0.01f) {
                    PickerContainer.this.setVisibility(4);
                }
                PickerContainer.this.I = false;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout.b
    public void a(int i3) {
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBarLayout.b
    public void d(int i3) {
    }
}
