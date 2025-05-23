package com.tencent.aelight.camera.aebase.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.aebase.view.AbsAECaptureButton;
import com.tencent.aelight.camera.aebase.view.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.widget.QIMCircleProgress;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QIMCameraCaptureButtonLayoutNew extends AbsAECaptureButton {
    public View C;
    protected View D;
    protected GLSurfaceView E;
    protected AnimationQIMCircleProgress F;
    protected QIMCameraCountTimeLayout G;
    protected f H;
    protected long I;
    protected ValueAnimator J;
    protected ValueAnimator K;
    protected boolean L;
    protected boolean M;
    protected boolean N;
    protected boolean P;
    protected a.InterfaceC0568a Q;
    protected int R;
    private TextView S;
    protected View T;
    private boolean U;
    protected boolean V;
    private boolean W;

    /* renamed from: a0, reason: collision with root package name */
    private View.OnTouchListener f66052a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Handler f66053b0;

    /* renamed from: d, reason: collision with root package name */
    private int f66054d;

    /* renamed from: e, reason: collision with root package name */
    private int f66055e;

    /* renamed from: f, reason: collision with root package name */
    protected AtomicBoolean f66056f;

    /* renamed from: h, reason: collision with root package name */
    protected AtomicBoolean f66057h;

    /* renamed from: i, reason: collision with root package name */
    protected float f66058i;

    /* renamed from: m, reason: collision with root package name */
    public View f66059m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QIMCameraCaptureButtonLayoutNew.this.x(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator cancel!");
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator end, shortVideoShot:" + QIMCameraCaptureButtonLayoutNew.this.f66056f.get() + ", mActionUpAnimator:" + QIMCameraCaptureButtonLayoutNew.this.f66057h.get());
            }
            if (!QIMCameraCaptureButtonLayoutNew.this.f66057h.get()) {
                QIMCameraCaptureButtonLayoutNew.this.f66056f.set(true);
                QIMCameraCaptureButtonLayoutNew.this.f66053b0.sendEmptyMessage(2);
                QIMCameraCaptureButtonLayoutNew.this.t();
                QIMCameraCaptureButtonLayoutNew.this.I = System.currentTimeMillis();
                QIMCameraCaptureButtonLayoutNew.this.f66053b0.sendEmptyMessage(5);
            } else {
                QIMCameraCaptureButtonLayoutNew.this.w();
                QIMCameraCaptureButtonLayoutNew.this.x(1.0f);
            }
            QIMCameraCaptureButtonLayoutNew.this.f66057h.set(false);
            QIMCameraCaptureButtonLayoutNew.this.G.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (QLog.isColorLevel()) {
                QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "scaleAnimator start!");
            }
            QIMCameraCaptureButtonLayoutNew.this.f66053b0.sendEmptyMessage(9);
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
            QIMCameraCaptureButtonLayoutNew.this.F.setCenterScaleValue(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return QIMCameraCaptureButtonLayoutNew.this.n(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            QIMCameraCaptureButtonLayoutNew.this.m(message);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface f extends AbsAECaptureButton.a {
        void i();

        void p();
    }

    public QIMCameraCaptureButtonLayoutNew(Context context) {
        super(context);
        this.f66054d = BaseAIOUtils.f(53.0f, getResources());
        this.f66055e = BaseAIOUtils.f(80.0f, getResources());
        this.f66056f = new AtomicBoolean(false);
        this.f66057h = new AtomicBoolean(false);
        this.f66058i = 20000.0f;
        this.I = 0L;
        this.J = null;
        this.K = null;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.R = 1;
        this.U = true;
        this.V = true;
        this.W = true;
        this.f66052a0 = new d();
        this.f66053b0 = new e(Looper.getMainLooper());
        o();
    }

    private void j() {
        int i3 = this.R;
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            d();
            return;
        }
        if (i3 != 4) {
            return;
        }
        if (AEResUtil.R()) {
            QQToast.makeText(getContext(), 1, getContext().getString(R.string.y76), 1).show();
            return;
        }
        if (this.N && this.f66056f.get()) {
            v();
        } else {
            if (this.N) {
                return;
            }
            if (this.P) {
                u();
            } else {
                d();
            }
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void a() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
        layoutParams.bottomMargin = BaseAIOUtils.f(158.0f, this.G.getResources());
        this.G.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public View b() {
        return this.C;
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public boolean c() {
        return this.F.getMode() != 0;
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void d() {
        if (this.N) {
            if (QLog.isColorLevel()) {
                QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "start fail because is started");
                return;
            }
            return;
        }
        int i3 = this.R;
        if (i3 == 3 || i3 == 1 || i3 == 4) {
            this.f66053b0.sendEmptyMessageDelayed(1, 100L);
        }
        this.N = true;
        if (this.R == 2) {
            v();
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void e(boolean z16, a.InterfaceC0568a interfaceC0568a) {
        this.P = z16;
        this.Q = interfaceC0568a;
    }

    @Override // com.tencent.aelight.camera.aebase.view.a
    public void f(AbsAECaptureButton.a aVar, int i3, GLSurfaceView gLSurfaceView) {
        this.E = gLSurfaceView;
        if (aVar instanceof f) {
            this.H = (f) aVar;
            return;
        }
        throw new IllegalArgumentException("listener should be instance of SegmentCaptureButtonListener");
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void g(boolean z16, com.tencent.aelight.camera.ae.view.b bVar) {
        super.g(z16, bVar);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void h(boolean z16) {
        AnimationQIMCircleProgress animationQIMCircleProgress = this.F;
        if (animationQIMCircleProgress != null) {
            animationQIMCircleProgress.b(z16);
        }
        QIMCameraCountTimeLayout qIMCameraCountTimeLayout = this.G;
        if (qIMCameraCountTimeLayout != null) {
            qIMCameraCountTimeLayout.setTextColor(z16 ? -16777216 : -1);
        }
    }

    public void k() {
        TextView textView = this.S;
        if (textView == null || textView.getVisibility() != 0) {
            return;
        }
        this.S.clearAnimation();
        this.S.setVisibility(8);
    }

    public long l() {
        return this.I;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0036. Please report as an issue. */
    protected void m(Message message) {
        if (QLog.isColorLevel()) {
            QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "handleMessage what:" + message.what + ", shortVideoShot:" + this.f66056f.get());
        }
        int i3 = message.what;
        if (i3 != 9) {
            switch (i3) {
                case 1:
                    r();
                    return;
                case 2:
                    f fVar = this.H;
                    if (fVar != null) {
                        fVar.h();
                        return;
                    }
                    return;
                case 3:
                    if (this.f66056f.get()) {
                        f fVar2 = this.H;
                        if (fVar2 != null) {
                            fVar2.a();
                        }
                        this.f66056f.set(false);
                        q();
                        return;
                    }
                    return;
                case 4:
                    f fVar3 = this.H;
                    if (fVar3 != null) {
                        fVar3.g();
                    }
                    q();
                    return;
                case 5:
                    if (this.f66056f.get()) {
                        y();
                        this.f66053b0.sendEmptyMessageDelayed(5, 50L);
                        return;
                    }
                    return;
                case 6:
                    p();
                    break;
                default:
                    return;
            }
        }
        f fVar4 = this.H;
        if (fVar4 != null) {
            fVar4.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(View view, MotionEvent motionEvent) {
        f fVar;
        if (QLog.isColorLevel()) {
            QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "touch action:" + (motionEvent.getAction() & 255) + ", shortVideoShot:" + this.f66056f.get() + ", actionUp:" + this.f66057h.get() + ", isOver:" + this.L + ", mTouchEnable:" + this.U);
        }
        k();
        if (!this.U) {
            return false;
        }
        if (this.W) {
            GLGestureProxy.getInstance().onTouchEvent(motionEvent, true, this.C, this.E);
        }
        if (this.L) {
            return false;
        }
        if (!this.V) {
            if (this.H != null && (motionEvent.getAction() & 255) == 0) {
                this.H.p();
            }
            return false;
        }
        if (this.T.getVisibility() == 0) {
            i();
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            if (this.M) {
                return false;
            }
            j();
            return true;
        }
        if (action == 1 || action == 3) {
            v();
            return true;
        }
        if (action == 5 && (fVar = this.H) != null) {
            fVar.i();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o() {
        LayoutInflater.from(getContext()).inflate(R.layout.dos, (ViewGroup) this, true);
        this.D = findViewById(R.id.rqp);
        this.F = (AnimationQIMCircleProgress) findViewById(R.id.rrh);
        View findViewById = findViewById(R.id.rtz);
        this.C = findViewById;
        findViewById.setOnTouchListener(this.f66052a0);
        this.C.setEnabled(true);
        View findViewById2 = findViewById(R.id.f163753ru0);
        this.f66059m = findViewById2;
        findViewById2.setOnTouchListener(this.f66052a0);
        this.F.setBackgroundResource(R.drawable.iyn);
        this.F.setCenterView();
        this.F.setVisibility(0);
        this.F.changeMode(0);
        this.G = (QIMCameraCountTimeLayout) findViewById(R.id.rqt);
        this.S = (TextView) findViewById(R.id.rsx);
        this.T = findViewById(R.id.rri);
    }

    public void p() {
        q();
        this.f66057h.set(false);
        this.f66056f.set(false);
        this.I = 0L;
        this.L = false;
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        if (this.V == z16) {
            return;
        }
        this.V = z16;
        if (z16) {
            this.f66059m.setVisibility(8);
            this.C.setVisibility(0);
            this.F.setVisibility(0);
        } else {
            this.f66059m.setVisibility(0);
            this.C.setVisibility(8);
            this.F.setVisibility(8);
        }
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setFunctionFlag(int i3) {
        this.R = i3;
    }

    public void setIsFollowCaptureTips() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        layoutParams.topMargin += ScreenUtil.dip2px(10.0f);
        this.S.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setMaxDuration(float f16) {
        this.f66058i = f16;
    }

    public void setRecordTipsWording(String str) {
        this.S.setText(str);
    }

    @Override // com.tencent.aelight.camera.aebase.view.AbsAECaptureButton
    public void setTouchEnable(boolean z16) {
        this.U = z16;
    }

    public void u() {
        a.InterfaceC0568a interfaceC0568a = this.Q;
        if (interfaceC0568a != null) {
            interfaceC0568a.a();
        }
    }

    public void v() {
        f fVar;
        if (!this.N) {
            if (QLog.isColorLevel()) {
                QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "stop failed because is not start");
                return;
            }
            return;
        }
        int i3 = this.R;
        if (i3 != 1) {
            if (i3 == 2) {
                this.f66053b0.sendEmptyMessage(4);
                this.N = false;
                this.F.changeMode(0);
                return;
            } else if (i3 != 3) {
                if (i3 == 4 && this.f66056f.get()) {
                    this.f66057h.set(true);
                    this.f66053b0.removeMessages(5);
                    w();
                    AEBaseReportParam.U().V0(System.currentTimeMillis() - l());
                    this.f66053b0.sendEmptyMessage(3);
                    this.N = false;
                    this.F.changeMode(0);
                    return;
                }
                return;
            }
        }
        this.f66057h.set(true);
        this.f66053b0.removeMessages(5);
        w();
        if (this.f66056f.get()) {
            this.f66053b0.sendEmptyMessage(3);
        } else {
            this.f66053b0.removeMessages(1);
            int i16 = this.R;
            if (i16 == 1) {
                this.f66053b0.sendEmptyMessage(4);
            } else if (i16 == 3 && (fVar = this.H) != null) {
                fVar.o();
            }
        }
        this.N = false;
        this.F.changeMode(0);
    }

    protected void w() {
        ValueAnimator valueAnimator = this.J;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.K;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(float f16) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
        int i3 = this.f66054d;
        layoutParams.width = (int) (i3 * f16);
        layoutParams.height = (int) (i3 * f16);
        layoutParams.addRule(13);
        this.C.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
        int i16 = this.f66055e;
        layoutParams2.width = (int) (i16 * f16);
        layoutParams2.height = (int) (i16 * f16);
        layoutParams2.addRule(13);
        this.F.setLayoutParams(layoutParams2);
    }

    protected void y() {
        int i3;
        long currentTimeMillis = System.currentTimeMillis() - this.I;
        float f16 = (float) currentTimeMillis;
        float f17 = this.f66058i;
        boolean z16 = f16 >= f17;
        this.L = z16;
        if (z16) {
            i3 = QIMCircleProgress.MAX_PROGRESS;
        } else {
            i3 = (int) ((f16 / f17) * QIMCircleProgress.MAX_PROGRESS);
        }
        String str = (((int) currentTimeMillis) / 1000) + "\u79d2";
        this.G.setText(str);
        this.F.setProgress(i3);
        if (QLog.isColorLevel()) {
            QLog.i("QIMCameraCaptureButtonLayoutNew", 2, "updateProgress percent:" + i3 + ", time:" + str);
        }
        if (this.L) {
            v();
        }
    }

    public void i() {
        s(false);
    }

    @Override // zq.a
    public void onPause() {
        this.M = true;
        v();
    }

    @Override // zq.a
    public void onResume() {
        this.M = false;
        p();
    }

    protected void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.45f);
        this.J = ofFloat;
        ofFloat.setDuration(400L);
        this.J.addUpdateListener(new a());
        this.J.addListener(new b());
        this.J.start();
        this.F.changeMode(1);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.85f);
        this.K = ofFloat2;
        ofFloat2.setDuration(400L);
        this.F.setStrokeWidth(3.0f);
        this.K.addUpdateListener(new c());
        this.K.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
        x(1.0f);
        this.F.setProgress(0.0f);
        this.F.setCenterScaleValue(1.0f);
        this.G.setText("0\u79d2");
        this.G.setVisibility(8);
        this.C.setEnabled(true);
        this.C.setVisibility(0);
    }

    public void s(boolean z16) {
        if (z16) {
            this.T.setVisibility(0);
        } else {
            this.T.setVisibility(8);
        }
    }

    public QIMCameraCaptureButtonLayoutNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66054d = BaseAIOUtils.f(53.0f, getResources());
        this.f66055e = BaseAIOUtils.f(80.0f, getResources());
        this.f66056f = new AtomicBoolean(false);
        this.f66057h = new AtomicBoolean(false);
        this.f66058i = 20000.0f;
        this.I = 0L;
        this.J = null;
        this.K = null;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.R = 1;
        this.U = true;
        this.V = true;
        this.W = true;
        this.f66052a0 = new d();
        this.f66053b0 = new e(Looper.getMainLooper());
        o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
    }
}
