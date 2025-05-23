package com.tencent.aelight.camera.aebase.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMCameraSegmentCaptureButtonLayoutNew extends QIMCameraCaptureButtonLayoutNew {

    /* renamed from: i0, reason: collision with root package name */
    protected static final int f66068i0 = CodecParam.SEGMENT_RECORD_MAX_TIME;

    /* renamed from: c0, reason: collision with root package name */
    protected float f66069c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f66070d0;

    /* renamed from: e0, reason: collision with root package name */
    protected float f66071e0;

    /* renamed from: f0, reason: collision with root package name */
    protected ValueAnimator f66072f0;

    /* renamed from: g0, reason: collision with root package name */
    protected AtomicBoolean f66073g0;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f66074h0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QIMCameraSegmentCaptureButtonLayoutNew.this.f66071e0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QIMCameraSegmentCaptureButtonLayoutNew qIMCameraSegmentCaptureButtonLayoutNew = QIMCameraSegmentCaptureButtonLayoutNew.this;
            qIMCameraSegmentCaptureButtonLayoutNew.x(qIMCameraSegmentCaptureButtonLayoutNew.f66071e0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f66076d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f66077e;

        b(boolean z16, float f16) {
            this.f66076d = z16;
            this.f66077e = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f66076d) {
                QIMCameraSegmentCaptureButtonLayoutNew.this.F.forceNextSegmentAnimatorStart();
            } else {
                QIMCameraSegmentCaptureButtonLayoutNew.this.F.startBlinkAnimation(this.f66077e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QIMCameraSegmentCaptureButtonLayoutNew.this.F.setCenterScaleValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QIMCameraSegmentCaptureButtonLayoutNew.this.f66071e0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            QIMCameraSegmentCaptureButtonLayoutNew qIMCameraSegmentCaptureButtonLayoutNew = QIMCameraSegmentCaptureButtonLayoutNew.this;
            qIMCameraSegmentCaptureButtonLayoutNew.x(qIMCameraSegmentCaptureButtonLayoutNew.f66071e0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f66081d;

        e(boolean z16) {
            this.f66081d = z16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator end, shortVideoShot:" + QIMCameraSegmentCaptureButtonLayoutNew.this.f66056f.get() + " segmentShot:" + QIMCameraSegmentCaptureButtonLayoutNew.this.f66073g0.get() + ", mActionUpAnimator:" + QIMCameraSegmentCaptureButtonLayoutNew.this.f66057h.get());
            }
            if (!QIMCameraSegmentCaptureButtonLayoutNew.this.f66057h.get()) {
                if (this.f66081d) {
                    QIMCameraSegmentCaptureButtonLayoutNew.this.f66056f.set(true);
                }
                QIMCameraSegmentCaptureButtonLayoutNew.this.f66073g0.set(true);
                QIMCameraSegmentCaptureButtonLayoutNew.this.f66053b0.sendEmptyMessage(2);
                QIMCameraSegmentCaptureButtonLayoutNew.this.t();
                QIMCameraSegmentCaptureButtonLayoutNew.this.I = System.currentTimeMillis();
                QIMCameraSegmentCaptureButtonLayoutNew.this.f66053b0.sendEmptyMessage(5);
                QIMCameraSegmentCaptureButtonLayoutNew.this.G.setVisibility(0);
            } else if (this.f66081d) {
                QIMCameraSegmentCaptureButtonLayoutNew.this.w();
                QIMCameraSegmentCaptureButtonLayoutNew.this.x(1.0f);
            }
            QIMCameraSegmentCaptureButtonLayoutNew.this.f66057h.set(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("CameraSegmentCaptureLayout", 2, "scaleAnimator start!");
            }
            QIMCameraSegmentCaptureButtonLayoutNew.this.f66053b0.sendEmptyMessageDelayed(9, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QIMCameraSegmentCaptureButtonLayoutNew.this.F.setCenterScaleValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface g extends QIMCameraCaptureButtonLayoutNew.f {
        void j();
    }

    public QIMCameraSegmentCaptureButtonLayoutNew(Context context) {
        super(context);
        this.f66069c0 = 0.0f;
        this.f66070d0 = (this.f66058i * 0.98f) / 1000.0f;
        this.f66071e0 = -1.0f;
        this.f66072f0 = null;
        this.f66073g0 = new AtomicBoolean(false);
    }

    private void A() {
        if (this.f66056f.get()) {
            if (this.f66073g0.get()) {
                this.f66073g0.set(false);
                this.G.setVisibility(8);
                float currentProgress = this.F.getCurrentProgress();
                float f16 = QIMCircleProgress.MAX_PROGRESS;
                int i3 = f66068i0;
                boolean z16 = currentProgress >= (f16 * ((float) (((long) i3) - 500))) / ((float) i3);
                this.L = z16;
                QIMCameraCaptureButtonLayoutNew.f fVar = this.H;
                if (fVar != null) {
                    if (z16) {
                        if (fVar instanceof g) {
                            ((g) fVar).j();
                        } else {
                            Log.e("CameraSegmentCaptureLayout", "pauseSegmentVideo: should use instance of SegmentCaptureButtonListener to get callback");
                        }
                    }
                    this.H.a();
                }
                this.F.getSegmentPoints().add(Float.valueOf(this.F.getCurrentProgress()));
                if (QLog.isColorLevel()) {
                    QLog.d("CameraSegmentCaptureLayout", 2, "[segmentCapture] segmentPoints add, size = " + this.F.getSegmentPoints().size());
                }
                this.f66069c0 = this.F.getCurrentProgress();
                B(false);
                return;
            }
            B(true);
        }
    }

    protected void B(boolean z16) {
        if (this.f66071e0 < 0.0f) {
            this.f66071e0 = 1.45f;
        }
        ValueAnimator valueAnimator = this.f66072f0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f66072f0.removeAllListeners();
            this.f66072f0.removeAllUpdateListeners();
            this.f66072f0.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f66071e0, 1.0f);
        this.f66072f0 = ofFloat;
        ofFloat.setDuration(((this.f66071e0 - 1.0f) * 400.0f) / 0.45f);
        this.f66072f0.addUpdateListener(new a());
        float f16 = this.f66069c0;
        if (!this.L && this.F.getSegmentPoints().size() > 0) {
            this.f66072f0.addListener(new b(z16, f16));
        }
        this.f66072f0.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.85f, 1.0f);
        this.K = ofFloat2;
        ofFloat2.setDuration(400L);
        this.K.addUpdateListener(new c());
        this.K.start();
        this.F.changeMode(0);
    }

    protected void C(boolean z16) {
        if (this.f66071e0 < 0.0f) {
            this.f66071e0 = 1.0f;
        }
        ValueAnimator valueAnimator = this.f66072f0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f66072f0.removeAllListeners();
            this.f66072f0.removeAllUpdateListeners();
            this.f66072f0.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f66071e0, 1.45f);
        this.f66072f0 = ofFloat;
        ofFloat.setDuration(((1.45f - this.f66071e0) * 400.0f) / 0.45f);
        this.f66072f0.addUpdateListener(new d());
        this.f66072f0.addListener(new e(z16));
        this.f66072f0.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.85f);
        this.K = ofFloat2;
        ofFloat2.setDuration(400L);
        this.K.addUpdateListener(new f());
        this.K.start();
        this.F.changeMode(1);
        if (z16) {
            this.F.setStrokeWidth(3.0f);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    protected void m(Message message) {
        if (QLog.isColorLevel()) {
            QLog.i("CameraSegmentCaptureLayout", 2, "handleMessage what:" + message.what + ", shortVideoShot:" + this.f66056f.get() + ", segmentShot:" + this.f66073g0.get());
        }
        switch (message.what) {
            case 1:
                C(true);
                return;
            case 2:
                QIMCameraCaptureButtonLayoutNew.f fVar = this.H;
                if (fVar != null) {
                    fVar.h();
                    return;
                }
                return;
            case 3:
                if (this.f66056f.get()) {
                    QIMCameraCaptureButtonLayoutNew.f fVar2 = this.H;
                    if (fVar2 != null) {
                        fVar2.a();
                    }
                    this.f66056f.set(false);
                    q();
                    return;
                }
                return;
            case 4:
                QIMCameraCaptureButtonLayoutNew.f fVar3 = this.H;
                if (fVar3 != null) {
                    fVar3.g();
                }
                q();
                return;
            case 5:
                if (this.f66056f.get() && this.f66073g0.get() && !this.L) {
                    y();
                    this.f66053b0.sendEmptyMessageDelayed(5, 50L);
                    return;
                }
                return;
            case 6:
                p();
                return;
            case 7:
                A();
                return;
            case 8:
                C(false);
                return;
            case 9:
                QIMCameraCaptureButtonLayoutNew.f fVar4 = this.H;
                if (fVar4 != null) {
                    fVar4.d();
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    public boolean n(View view, MotionEvent motionEvent) {
        QIMCameraCaptureButtonLayoutNew.f fVar;
        if (QLog.isColorLevel()) {
            QLog.i("CameraSegmentCaptureLayout", 2, "touch action:" + (motionEvent.getAction() & 255) + ", shortVideoShot:" + this.f66056f.get() + ", segmentShot:" + this.f66073g0.get() + ", actionUp:" + this.f66057h.get() + ", isOver:" + this.L);
        }
        if (!this.f66074h0) {
            return super.n(view, motionEvent);
        }
        k();
        GLGestureProxy.getInstance().onTouchEvent(motionEvent, true, this.C, this.E);
        if (this.L) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1 || action == 3) {
                v();
                return true;
            }
            if (action == 5 && (fVar = this.H) != null) {
                fVar.i();
            }
            return false;
        }
        if (this.M) {
            return false;
        }
        QIMCameraCaptureButtonLayoutNew.f fVar2 = this.H;
        if (fVar2 != null && fVar2.e()) {
            int i3 = this.R;
            if (i3 == 3 || i3 == 1) {
                this.f66057h.set(false);
                if (this.f66056f.get()) {
                    this.f66053b0.sendEmptyMessage(8);
                } else {
                    this.f66053b0.sendEmptyMessage(1);
                }
            }
            this.N = true;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CameraSegmentCaptureLayout", 2, "[segmentCapture] ignore down action, capture not ready");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    public void o() {
        super.o();
        this.F.initBlinkAnimator();
        this.f66058i = f66068i0;
        this.f66074h0 = true;
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    public void p() {
        super.p();
        this.f66073g0.set(false);
        this.F.getSegmentPoints().clear();
        this.F.cancelAnimation();
        this.f66069c0 = 0.0f;
    }

    public void setCurrentAnimatorValue(float f16) {
        this.f66071e0 = f16;
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew, com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setMaxDuration(float f16) {
        super.setMaxDuration(f16);
        this.f66070d0 = (this.f66058i * 0.98f) / 1000.0f;
    }

    public void setSegment(boolean z16) {
        this.f66074h0 = z16;
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    public void v() {
        if (this.N) {
            if (!this.f66074h0) {
                super.v();
                return;
            }
            int i3 = this.R;
            if (i3 == 3 || i3 == 1) {
                this.f66057h.set(true);
                this.f66053b0.removeMessages(5);
                this.f66053b0.removeMessages(9);
                w();
                if (this.f66056f.get()) {
                    if (this.f66073g0.get()) {
                        this.f66053b0.sendEmptyMessage(7);
                    } else {
                        z();
                    }
                } else {
                    z();
                    this.f66053b0.removeMessages(1);
                }
            } else if (i3 == 2) {
                this.f66053b0.sendEmptyMessage(4);
            }
            this.N = false;
            this.F.changeMode(0);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    protected void w() {
        ValueAnimator valueAnimator = this.f66072f0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.K;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew
    protected void y() {
        float currentTimeMillis = (float) (System.currentTimeMillis() - this.I);
        float f16 = this.f66058i;
        int i3 = QIMCircleProgress.MAX_PROGRESS;
        float f17 = ((currentTimeMillis / f16) * i3) + this.f66069c0;
        this.L = f17 >= ((float) i3);
        float f18 = (f17 / i3) * (f16 / 1000.0f);
        String str = ((int) f18) + "\u79d2";
        if (f18 > this.f66070d0) {
            str = ((int) (this.f66058i / 1000.0f)) + "\u79d2";
        }
        this.G.setText(str);
        this.F.setProgress(f17);
        if (QLog.isColorLevel()) {
            QLog.i("CameraSegmentCaptureLayout", 2, "updateProgress percent:" + f17 + ", time:" + str + ", maxDuration:" + this.f66058i);
        }
        if (this.L) {
            QIMCameraCaptureButtonLayoutNew.f fVar = this.H;
            if (fVar instanceof g) {
                ((g) fVar).j();
            } else {
                Log.e("CameraSegmentCaptureLayout", "updateProgress: should use instance of SegmentCaptureButtonListener to get callback");
            }
            v();
        }
    }

    protected void z() {
        QIMCameraCaptureButtonLayoutNew.f fVar = this.H;
        if (fVar != null) {
            fVar.o();
        }
        B(true);
    }

    @Override // com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew, zq.a
    public void onResume() {
        this.M = false;
        this.f66057h.set(false);
    }

    public QIMCameraSegmentCaptureButtonLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66069c0 = 0.0f;
        this.f66070d0 = (this.f66058i * 0.98f) / 1000.0f;
        this.f66071e0 = -1.0f;
        this.f66072f0 = null;
        this.f66073g0 = new AtomicBoolean(false);
    }
}
