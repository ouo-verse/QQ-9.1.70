package com.tencent.av.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.av.widget.api.IChildLockCircleApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ChildLockCircle extends View implements Animation.AnimationListener, Handler.Callback {
    private Bitmap C;
    private Bitmap D;
    private boolean E;
    private final RectF F;
    private final RectF G;
    private final Paint H;
    private final int I;
    private int J;
    private AnimatedThread K;
    private int L;
    private Animation M;
    private Animation N;
    private int P;
    private int Q;
    public Handler R;
    private CountDownTimer S;

    /* renamed from: d, reason: collision with root package name */
    private String f77200d;

    /* renamed from: e, reason: collision with root package name */
    private String f77201e;

    /* renamed from: f, reason: collision with root package name */
    private String f77202f;

    /* renamed from: h, reason: collision with root package name */
    private String f77203h;

    /* renamed from: i, reason: collision with root package name */
    private String f77204i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f77205m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class AnimatedThread extends BaseThread {
        boolean C = false;
        private boolean D = false;

        AnimatedThread() {
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            this.D = false;
            if (ChildLockCircle.this.E) {
                ChildLockCircle.this.J = 0;
                ChildLockCircle childLockCircle = ChildLockCircle.this;
                childLockCircle.f77204i = childLockCircle.f77200d;
                ChildLockCircle childLockCircle2 = ChildLockCircle.this;
                childLockCircle2.D = childLockCircle2.C;
            } else {
                ChildLockCircle.this.J = 100;
                ChildLockCircle childLockCircle3 = ChildLockCircle.this;
                childLockCircle3.f77204i = childLockCircle3.f77202f;
                ChildLockCircle childLockCircle4 = ChildLockCircle.this;
                childLockCircle4.D = childLockCircle4.f77205m;
            }
            ChildLockCircle.this.z(0);
            if (!ChildLockCircle.this.E) {
                try {
                    LockMethodProxy.sleep(300L);
                } catch (InterruptedException unused) {
                }
            }
            float f16 = 0.0f;
            while (true) {
                if (!this.C) {
                    break;
                }
                if (ChildLockCircle.this.E) {
                    ChildLockCircle.this.J = (int) (((float) (r5.J + 1)) + f16);
                    if (ChildLockCircle.this.J >= 100) {
                        ChildLockCircle childLockCircle5 = ChildLockCircle.this;
                        childLockCircle5.f77204i = childLockCircle5.f77201e;
                        this.D = true;
                    }
                } else {
                    ChildLockCircle.this.J = (int) (((float) (r5.J - 1)) - f16);
                    if (ChildLockCircle.this.J <= 0) {
                        ChildLockCircle.this.J = 0;
                        ChildLockCircle childLockCircle6 = ChildLockCircle.this;
                        childLockCircle6.f77204i = childLockCircle6.f77203h;
                        ChildLockCircle childLockCircle7 = ChildLockCircle.this;
                        childLockCircle7.D = childLockCircle7.C;
                        this.D = true;
                    }
                }
                f16 = (float) (f16 + 0.08d);
                if (!this.D || !ChildLockCircle.this.E) {
                    ChildLockCircle.this.postInvalidate();
                }
                if (this.D && !ChildLockCircle.this.E) {
                    ChildLockCircle.this.x();
                    break;
                } else {
                    if (this.D && ChildLockCircle.this.E) {
                        ChildLockCircle.this.z(3);
                        break;
                    }
                    try {
                        LockMethodProxy.sleep(15L);
                    } catch (InterruptedException unused2) {
                    }
                }
            }
            try {
                if (this.D) {
                    if (ChildLockCircle.this.E) {
                        LockMethodProxy.sleep(900L);
                    } else {
                        LockMethodProxy.sleep(300L);
                    }
                } else {
                    while (true) {
                        if (ChildLockCircle.this.E) {
                            ChildLockCircle.this.J = (int) (r1.J - 2);
                            if (ChildLockCircle.this.J <= 0) {
                                ChildLockCircle.this.J = 0;
                                break;
                            }
                            ChildLockCircle.this.postInvalidate();
                            try {
                                LockMethodProxy.sleep(15L);
                            } catch (InterruptedException unused3) {
                            }
                        } else {
                            ChildLockCircle.this.J = (int) (r1.J + 2);
                            if (ChildLockCircle.this.J >= 100) {
                                break;
                            }
                            ChildLockCircle.this.postInvalidate();
                            LockMethodProxy.sleep(15L);
                        }
                    }
                    ChildLockCircle.this.postInvalidate();
                    ChildLockCircle.this.w();
                    LockMethodProxy.sleep(30L);
                }
            } catch (InterruptedException unused4) {
            }
            ChildLockCircle.this.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        int f77206a;

        /* renamed from: b, reason: collision with root package name */
        Bitmap f77207b;

        /* renamed from: c, reason: collision with root package name */
        Resources f77208c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f77209d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, long j16, Context context) {
            super(j3, j16);
            this.f77209d = context;
            this.f77206a = 1;
            this.f77207b = null;
            this.f77208c = context.getResources();
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ChildLockCircle childLockCircle = ChildLockCircle.this;
            childLockCircle.D = childLockCircle.f77205m;
            ChildLockCircle.this.J = 0;
            ChildLockCircle.this.postInvalidate();
            ChildLockCircle.this.x();
            Bitmap bitmap = this.f77207b;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f77207b.recycle();
                this.f77207b = null;
            }
            if (ChildLockCircle.this.S != null) {
                ChildLockCircle.this.S.cancel();
                ChildLockCircle.this.S = null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer finish");
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j3) {
            if (this.f77209d != null) {
                Bitmap s16 = ChildLockCircle.this.s(this.f77208c, this.f77206a);
                this.f77207b = s16;
                if (s16 != null) {
                    ChildLockCircle.this.D = s16;
                    ChildLockCircle.this.postInvalidate();
                }
                this.f77206a++;
                if (QLog.isColorLevel()) {
                    QLog.d("ChildLockCircle", 2, "LockAnimation, i[" + this.f77206a + "]");
                }
            }
        }
    }

    public ChildLockCircle(Context context) {
        super(context);
        this.E = true;
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = 100;
        this.J = 0;
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.S = null;
        u(null, 0);
    }

    private void A(boolean z16) {
        this.E = z16;
        if (z16) {
            this.J = 0;
            this.f77204i = this.f77200d;
            this.D = this.C;
        } else {
            this.J = 100;
            this.f77204i = this.f77202f;
            this.D = this.f77205m;
        }
    }

    private void B() {
        D();
        AnimatedThread animatedThread = new AnimatedThread();
        this.K = animatedThread;
        animatedThread.C = true;
        animatedThread.start();
    }

    private void D() {
        AnimatedThread animatedThread = this.K;
        if (animatedThread != null) {
            animatedThread.C = false;
            this.K = null;
        }
        CountDownTimer countDownTimer = this.S;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.S = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap s(Resources resources, int i3) {
        int i16 = R.drawable.hrt;
        switch (i3) {
            case 1:
                i16 = R.drawable.hrn;
                break;
            case 2:
                i16 = R.drawable.hru;
                break;
            case 3:
                i16 = R.drawable.hrv;
                break;
            case 4:
                i16 = R.drawable.hrw;
                break;
            case 5:
                i16 = R.drawable.hrx;
                break;
            case 6:
                i16 = R.drawable.hry;
                break;
            case 7:
                i16 = R.drawable.hrz;
                break;
            case 8:
                i16 = R.drawable.f161333hs0;
                break;
            case 9:
                i16 = R.drawable.f161334hs1;
                break;
            case 10:
                i16 = R.drawable.hro;
                break;
            case 11:
                i16 = R.drawable.hrp;
                break;
            case 12:
                i16 = R.drawable.hrq;
                break;
            case 13:
                i16 = R.drawable.hrr;
                break;
            case 14:
                i16 = R.drawable.hrs;
                break;
        }
        return BitmapFactory.decodeResource(resources, i16);
    }

    private boolean t() {
        return this.E;
    }

    private void u(AttributeSet attributeSet, int i3) {
        setId(R.id.g7h);
        setBackgroundResource(R.drawable.f161335ve);
        Resources resources = getResources();
        this.f77200d = resources.getString(R.string.d_6);
        this.f77201e = resources.getString(R.string.d_7);
        this.f77202f = resources.getString(R.string.d_4);
        this.f77203h = resources.getString(R.string.d_5);
        try {
            this.f77205m = BitmapFactory.decodeResource(resources, R.drawable.hrt);
            this.C = BitmapFactory.decodeResource(resources, R.drawable.hrn);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        }
        RectF rectF = this.F;
        rectF.left = 12.0f;
        rectF.top = 12.0f;
        this.H.setFlags(1);
        this.H.setColor(-1);
        this.R = new Handler(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        z(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        ((IChildLockCircleApi) QRoute.api(IChildLockCircleApi.class)).onAnimationFailed(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        z(2);
    }

    private void y(Context context) {
        if (((IChildLockCircleApi) QRoute.api(IChildLockCircleApi.class)).onLockSuccess(getContext()) && this.S == null) {
            if (QLog.isColorLevel()) {
                QLog.d("ChildLockCircle", 2, "LockAnimation,CountDownTimer start");
            }
            a aVar = new a(750L, 50L, context);
            this.S = aVar;
            aVar.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i3) {
        Message message = new Message();
        message.what = i3;
        this.R.sendMessage(message);
    }

    public void C(boolean z16) {
        ((IChildLockCircleApi) QRoute.api(IChildLockCircleApi.class)).startChildLockAnimation();
        F();
        if (this.M == null) {
            this.M = AnimationUtils.loadAnimation(getContext(), R.anim.f154838dl);
        }
        if (z16) {
            this.L = 1;
            this.M.setAnimationListener(this);
            startAnimation(this.M);
        } else {
            setVisibility(0);
            this.L = 2;
            B();
        }
    }

    public void E() {
        if (this.L == 1) {
            this.L = -1;
        }
        D();
    }

    public void F() {
        if (((IChildLockCircleApi) QRoute.api(IChildLockCircleApi.class)).updateText(getContext())) {
            A(true);
        } else {
            A(false);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (QLog.isColorLevel()) {
            QLog.d("ChildLockCircle", 2, "handleMessage, msg.what=" + message.what);
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && t()) {
                        y(getContext());
                        return false;
                    }
                    return false;
                }
                ((IChildLockCircleApi) QRoute.api(IChildLockCircleApi.class)).handleAnimSuccessMsg(getContext());
                return false;
            }
            if (this.N == null) {
                this.N = AnimationUtils.loadAnimation(getContext(), R.anim.f154839dm);
            }
            Animation animation = this.N;
            if (animation != null) {
                this.L = 3;
                animation.setAnimationListener(this);
                startAnimation(this.N);
                return false;
            }
            onAnimationEnd(animation);
            return false;
        }
        postInvalidate();
        return false;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        if (animation.equals(this.N)) {
            setVisibility(8);
            if (QLog.isDevelopLevel()) {
                QLog.w("ChildLockCircle", 1, "timtest onAnimationEnd animation.equals(fadeoutAnimation)");
            }
            ((IChildLockCircleApi) QRoute.api(IChildLockCircleApi.class)).onAnimationEnd();
            this.L = 0;
            new Handler().post(new Runnable() { // from class: com.tencent.av.widget.ChildLockCircle.2
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup viewGroup = (ViewGroup) ChildLockCircle.this.getParent();
                    if (viewGroup != null && viewGroup.findViewById(R.id.g7h) != null) {
                        viewGroup.removeView(ChildLockCircle.this);
                    }
                }
            });
            try {
                Bitmap bitmap = this.f77205m;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.f77205m.isRecycled();
                }
                Bitmap bitmap2 = this.C;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.C.isRecycled();
                }
                this.f77205m = null;
                this.C = null;
                this.D = null;
                return;
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (animation.equals(this.M)) {
            setVisibility(0);
            if (this.L == 1) {
                this.L = 2;
                B();
            } else {
                w();
                v();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.H.setStrokeWidth(8.0f);
        this.H.setStyle(Paint.Style.STROKE);
        this.H.setAlpha(255);
        canvas.drawArc(this.F, -90.0f, (this.J / 100.0f) * 360.0f, false, this.H);
        Bitmap bitmap = this.D;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.D, (Rect) null, this.G, this.H);
        }
        this.H.setStyle(Paint.Style.FILL);
        String str = this.f77204i;
        canvas.drawText(str, (this.P - this.H.measureText(str, 0, str.length())) / 2.0f, (this.Q * 6) / 7, this.H);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        this.P = i3;
        this.Q = i16;
        RectF rectF = this.F;
        rectF.left = (i3 * 18) / 65;
        rectF.top = (i16 * 19) / 120;
        rectF.right = (i3 * 47) / 65;
        rectF.bottom = (i16 * 77) / 120;
        if (QLog.isDevelopLevel()) {
            QLog.d("ChildLockCircle", 1, "[childLock] action : w = " + i3 + "  h = " + i16 + " width = " + this.P);
        }
        this.G.set(0.0f, 0.0f, i3, i16);
        this.H.setTextSize(i3 / 8);
    }

    public ChildLockCircle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = true;
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = 100;
        this.J = 0;
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.S = null;
        u(attributeSet, 0);
    }

    public ChildLockCircle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = true;
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = 100;
        this.J = 0;
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = null;
        this.S = null;
        u(attributeSet, i3);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
