package com.tencent.mobileqq.ar.ARRecord;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARRecord.b;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes11.dex */
public class ARVideoRecordViewProxy implements b {

    /* renamed from: b, reason: collision with root package name */
    private View f197003b;

    /* renamed from: c, reason: collision with root package name */
    private ARVideoRecordButtonView f197004c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f197005d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f197006e;

    /* renamed from: f, reason: collision with root package name */
    private View f197007f;

    /* renamed from: g, reason: collision with root package name */
    private View f197008g;

    /* renamed from: h, reason: collision with root package name */
    private b.a f197009h;

    /* renamed from: k, reason: collision with root package name */
    private boolean f197012k;

    /* renamed from: m, reason: collision with root package name */
    private Handler f197014m;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f197002a = 0;

    /* renamed from: i, reason: collision with root package name */
    private final String f197010i = HardCodeUtil.qqStr(R.string.jrr);

    /* renamed from: j, reason: collision with root package name */
    private final String f197011j = "0.00M";

    /* renamed from: l, reason: collision with root package name */
    private final int f197013l = 5000;

    /* renamed from: n, reason: collision with root package name */
    private Runnable f197015n = new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.1
        @Override // java.lang.Runnable
        public void run() {
            if (ARVideoRecordViewProxy.this.f197007f == null) {
                return;
            }
            ARVideoRecordViewProxy.this.f197007f.setVisibility(8);
            ARVideoRecordViewProxy.this.f197007f.clearAnimation();
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus stop animation");
            }
        }
    };

    /* loaded from: classes11.dex */
    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    ARVideoRecordViewProxy.this.f197004c.setAlpha(1.0f);
                    if (!ARVideoRecordViewProxy.this.f197012k) {
                        ARRecordUtils.f(true);
                        ARVideoRecordViewProxy.this.f197012k = true;
                    }
                    ARVideoRecordViewProxy.this.f197007f.setVisibility(8);
                    ARVideoRecordViewProxy.this.f197007f.clearAnimation();
                    if (ARVideoRecordViewProxy.this.f197009h != null) {
                        ARVideoRecordViewProxy.this.f197009h.c();
                        if (QLog.isColorLevel()) {
                            QLog.i("ARVideoRecordViewProxy", 2, "onMonitorUserOperation");
                        }
                    }
                }
            } else {
                ARVideoRecordViewProxy.this.f197004c.setAlpha(0.5f);
            }
            return true;
        }
    }

    public ARVideoRecordViewProxy(View view) {
        this.f197012k = false;
        this.f197003b = view;
        view.setVisibility(8);
        this.f197004c = (ARVideoRecordButtonView) view.findViewById(R.id.ej9);
        this.f197008g = view.findViewById(R.id.apw);
        this.f197007f = view.findViewById(R.id.f164418wz);
        boolean c16 = ARRecordUtils.c();
        this.f197012k = c16;
        if (c16) {
            this.f197007f.setVisibility(8);
        }
        this.f197008g.setOnClickListener(null);
        this.f197008g.setOnTouchListener(new a());
        this.f197005d = (TextView) view.findViewById(R.id.f164420x1);
        this.f197006e = (TextView) view.findViewById(R.id.f164419x0);
        this.f197014m = new Handler();
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordViewProxy", 2, "init self");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordViewProxy", 2, "resetToInnerTipsStatus");
        }
        this.f197004c.setShowState(2);
        this.f197004c.setVisibility(0);
        this.f197005d.setText(this.f197010i);
        this.f197006e.setText("0.00M");
        this.f197005d.setVisibility(8);
        this.f197006e.setVisibility(8);
        this.f197002a = 0;
        if (this.f197012k) {
            this.f197007f.setVisibility(8);
            this.f197007f.clearAnimation();
            return;
        }
        this.f197007f.setVisibility(0);
        q(this.f197007f, 600, -40);
        ARRecordUtils.f(true);
        this.f197012k = true;
        this.f197014m.postDelayed(this.f197015n, 5000L);
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordViewProxy", 2, "ARButtonTips resetToInnerTipsStatus start animation");
        }
    }

    private void q(View view, int i3, int i16) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, i16);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        int i17 = i3 / 2;
        long j3 = i17;
        translateAnimation.setDuration(j3);
        int i18 = i17 + 0;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0 - i16);
        translateAnimation2.setDuration(j3);
        translateAnimation2.setInterpolator(new DecelerateInterpolator());
        translateAnimation2.setStartOffset(i18);
        int i19 = i18 + i17;
        TranslateAnimation translateAnimation3 = new TranslateAnimation(0.0f, 0.0f, 0.0f, (i16 * 2) / 3);
        translateAnimation3.setInterpolator(new AccelerateInterpolator());
        translateAnimation3.setDuration(j3);
        translateAnimation3.setStartOffset(i19);
        int i26 = i19 + i17;
        TranslateAnimation translateAnimation4 = new TranslateAnimation(0.0f, 0.0f, 0.0f, 0 - r12);
        translateAnimation4.setInterpolator(new DecelerateInterpolator());
        translateAnimation4.setDuration(j3);
        translateAnimation4.setStartOffset(i26);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateAnimation2);
        animationSet.addAnimation(translateAnimation3);
        animationSet.addAnimation(translateAnimation4);
        if (view != null) {
            view.startAnimation(animationSet);
        }
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b
    public void a(final int i3, final int i16) {
        if (this.f197002a == 1) {
            this.f197004c.setProgress(i3, 60000L);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.5
            @Override // java.lang.Runnable
            public void run() {
                ARVideoRecordViewProxy.this.f197005d.setText(ARRecordUtils.b(i3 / 1000));
                ARVideoRecordViewProxy.this.f197006e.setText(ARRecordUtils.a(i16));
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b
    public void b(b.a aVar) {
        this.f197009h = aVar;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b
    public int c() {
        return this.f197002a;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b
    public void d(final int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode" + i3);
        }
        if (this.f197002a == i3) {
            if (QLog.isColorLevel()) {
                QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode mCurrentUIDisplayMode equal");
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.6
            @Override // java.lang.Runnable
            public void run() {
                int i16 = i3;
                if (i16 == 0) {
                    ARVideoRecordViewProxy.this.f197004c.setShowState(2);
                    ARVideoRecordViewProxy.this.p();
                    ARVideoRecordViewProxy.this.f197002a = 0;
                    if (QLog.isColorLevel()) {
                        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_NORMAL_MODE");
                        return;
                    }
                    return;
                }
                if (i16 == 1) {
                    ARVideoRecordViewProxy.this.f197004c.setShowState(3);
                    ARVideoRecordViewProxy.this.f197005d.setVisibility(0);
                    ARVideoRecordViewProxy.this.f197006e.setVisibility(0);
                    ARVideoRecordViewProxy.this.f197002a = 1;
                    if (QLog.isColorLevel()) {
                        QLog.i("ARVideoRecordViewProxy", 2, "switchUIdisplayMode run RECORD_PROGRESS_MODE");
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b
    public void hide() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordViewProxy", 2, "hide");
        }
        if (this.f197003b == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f197003b.setVisibility(8);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.4
                @Override // java.lang.Runnable
                public void run() {
                    if (ARVideoRecordViewProxy.this.f197003b != null) {
                        ARVideoRecordViewProxy.this.f197003b.setVisibility(8);
                    }
                }
            });
        }
        this.f197014m.removeCallbacks(this.f197015n);
    }

    public boolean o() {
        View view = this.f197003b;
        if (view != null && view.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ar.ARRecord.b
    public void show() {
        if (QLog.isColorLevel()) {
            QLog.i("ARVideoRecordViewProxy", 2, "show");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f197003b.setVisibility(0);
            p();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.ar.ARRecord.ARVideoRecordViewProxy.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ARVideoRecordViewProxy.this.f197003b != null) {
                        ARVideoRecordViewProxy.this.f197003b.setVisibility(0);
                        ARVideoRecordViewProxy.this.p();
                    }
                }
            });
        }
    }
}
