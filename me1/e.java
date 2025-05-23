package me1;

import android.R;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mobileqq.gamecenter.yungame.view.floatMenu.FloatBallView;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e implements f {

    /* renamed from: a, reason: collision with root package name */
    private final FloatBallView f416603a;

    /* renamed from: b, reason: collision with root package name */
    private final WindowManager f416604b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f416605c;

    /* renamed from: i, reason: collision with root package name */
    private b f416611i;

    /* renamed from: d, reason: collision with root package name */
    private int f416606d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f416607e = 0;

    /* renamed from: f, reason: collision with root package name */
    private int f416608f = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f416610h = false;

    /* renamed from: g, reason: collision with root package name */
    private WindowManager.LayoutParams f416609g = new WindowManager.LayoutParams();

    public e(Activity activity) {
        this.f416605c = activity;
        this.f416604b = activity.getWindowManager();
        this.f416603a = new FloatBallView(this.f416605c);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void c(int i3, int i16) {
        WindowManager.LayoutParams layoutParams = this.f416609g;
        layoutParams.x = i3;
        layoutParams.y = i16;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 51;
        layoutParams.flags = 1576;
        layoutParams.flags = 1576 | Integer.MIN_VALUE;
        layoutParams.format = 1;
        g(this.f416605c);
        this.f416603a.a(0);
        this.f416603a.setOnTouchListener(new a(this));
        this.f416603a.bringToFront();
        this.f416604b.addView(this.f416603a, this.f416609g);
        r(1);
    }

    private boolean g(Activity activity) {
        int i3;
        boolean z16;
        if (Build.VERSION.SDK_INT >= 28) {
            i3 = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            if (i3 == 1 && (systemUiVisibility & 4) != 0 && (systemUiVisibility & 1024) != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f416610h = z16;
            if (z16) {
                this.f416609g.layoutInDisplayCutoutMode = 1;
            }
            QLog.d("FloatMenuManager", 2, "[adjustCutout] displayCutoutMode:" + i3 + ",systemUiVisibility:" + systemUiVisibility + ",isInsertCutout:" + this.f416610h);
        }
        return this.f416610h;
    }

    private void h(int i3, View view, long j3) {
        if (view instanceof FloatBallView) {
            if (i3 < this.f416606d / 2) {
                r(1);
                o(0, view, j3);
            } else {
                r(2);
                o(this.f416606d - view.getWidth(), view, j3);
            }
        }
    }

    private void j() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.f416604b.getDefaultDisplay().getRealMetrics(displayMetrics);
        this.f416606d = displayMetrics.widthPixels;
        this.f416607e = displayMetrics.heightPixels;
        int[] iArr = new int[2];
        this.f416605c.getWindow().getDecorView().findViewById(R.id.content).getLocationOnScreen(iArr);
        if (!this.f416610h) {
            int i3 = this.f416606d;
            int i16 = this.f416607e;
            if (i3 > i16) {
                this.f416606d = i3 - iArr[0];
            } else {
                this.f416607e = i16 - iArr[1];
            }
        }
        QLog.d("FloatMenuManager", 2, "[initScreenSize] screenWidth:" + this.f416606d + ",screenHeight:" + this.f416607e + ",locationX:" + iArr[0] + ",locationY:" + iArr[1] + ",isInsertCutout:" + this.f416610h);
    }

    private boolean k() {
        Activity activity = this.f416605c;
        if (activity != null && !activity.isFinishing()) {
            return this.f416605c.isDestroyed();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(int i3, int i16, View view, ValueAnimator valueAnimator) {
        if (k()) {
            return;
        }
        u((int) ((i3 - i16) * valueAnimator.getAnimatedFraction()), 0, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(int i3, int i16) {
        if (!k()) {
            try {
                c(i3, i16);
                j();
            } catch (Throwable th5) {
                QLog.e("FloatMenuManager", 1, th5, new Object[0]);
            }
        }
    }

    private void o(final int i3, final View view, long j3) {
        final int i16 = this.f416609g.x;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: me1.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.l(i3, i16, view, valueAnimator);
            }
        });
    }

    private void p(View view) {
        if (view == null) {
            return;
        }
        try {
            this.f416604b.removeViewImmediate(view);
        } catch (Exception e16) {
            QLog.e("FloatMenuManager", 1, e16, new Object[0]);
        }
    }

    private void r(int i3) {
        QLog.i("FloatMenuManager", 2, "[setState] state:" + i3);
        this.f416608f = i3;
    }

    private void t(View view) {
        int i3;
        if (view instanceof FloatBallView) {
            FloatBallView floatBallView = (FloatBallView) view;
            if (this.f416609g.x > 0 && this.f416606d - view.getWidth() > this.f416609g.x) {
                floatBallView.a(2);
                return;
            }
            if (this.f416609g.x == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            floatBallView.a(i3);
        }
    }

    private void u(int i3, int i16, View view) {
        WindowManager.LayoutParams layoutParams = this.f416609g;
        int i17 = layoutParams.x + i3;
        layoutParams.x = i17;
        layoutParams.y += i16;
        if (i17 < 0) {
            layoutParams.x = 0;
        }
        if (layoutParams.x > this.f416606d - view.getWidth()) {
            this.f416609g.x = this.f416606d - view.getWidth();
        }
        WindowManager.LayoutParams layoutParams2 = this.f416609g;
        if (layoutParams2.y < 0) {
            layoutParams2.y = 0;
        }
        if (layoutParams2.y > this.f416607e - view.getHeight()) {
            this.f416609g.y = this.f416607e - view.getHeight();
        }
        try {
            this.f416604b.updateViewLayout(view, this.f416609g);
            t(view);
        } catch (Throwable th5) {
            QLog.e("FloatMenuManager", 1, th5, new Object[0]);
        }
    }

    @Override // me1.f
    public void d(int i3, int i16, View view) {
        h(i3, view, 200L);
    }

    @Override // me1.f
    public void e(int i3, int i16, View view) {
        QLog.i("FloatMenuManager", 2, "[onClick] upX:" + i3 + ",upY:" + i16);
        b bVar = this.f416611i;
        if (bVar != null && (view instanceof FloatBallView)) {
            bVar.a();
        }
    }

    @Override // me1.f
    public void f(int i3, int i16, View view) {
        if (view instanceof FloatBallView) {
            u(i3, i16, view);
        }
    }

    public void i() {
        FloatBallView floatBallView = this.f416603a;
        if (floatBallView != null && this.f416609g != null) {
            try {
                j();
                if (this.f416609g.x < 0) {
                    QLog.e("FloatMenuManager", 1, "[fixLocationInRange] lp.x:" + this.f416609g.x);
                    this.f416609g.x = 0;
                }
                int width = floatBallView.getWidth();
                WindowManager.LayoutParams layoutParams = this.f416609g;
                int i3 = layoutParams.x;
                int i16 = this.f416606d;
                if (i3 > i16 - width) {
                    layoutParams.x = i16 - width;
                    QLog.e("FloatMenuManager", 1, "[fixLocationInRange] lp.x:" + this.f416609g.x + ",after:" + this.f416609g.x);
                }
                if (this.f416609g.y < 0) {
                    QLog.e("FloatMenuManager", 1, "[fixLocationInRange] lp.y:" + this.f416609g.y);
                    this.f416609g.y = 0;
                }
                int height = floatBallView.getHeight();
                WindowManager.LayoutParams layoutParams2 = this.f416609g;
                int i17 = layoutParams2.y;
                int i18 = this.f416607e;
                if (i17 > i18 - height) {
                    layoutParams2.y = i18 - height;
                    QLog.e("FloatMenuManager", 1, "[fixLocationInRange] lp.y:" + this.f416609g.y + ",after:" + this.f416609g.y);
                }
                this.f416604b.updateViewLayout(floatBallView, this.f416609g);
                t(floatBallView);
                h(this.f416609g.x, this.f416603a, 1L);
            } catch (Throwable th5) {
                QLog.e("FloatMenuManager", 1, th5, new Object[0]);
            }
        }
    }

    public void n() {
        p(this.f416603a);
        QLog.d("FloatMenuManager", 2, "[onDestroy]");
    }

    public void q(b bVar) {
        this.f416611i = bVar;
    }

    public void s(final int i3, final int i16) {
        if (!k() && this.f416605c.getWindow() != null) {
            QLog.d("FloatMenuManager", 2, "[show] locationX:" + i3 + ",locationY:" + i16);
            this.f416605c.getWindow().getDecorView().postDelayed(new Runnable() { // from class: me1.c
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.m(i3, i16);
                }
            }, 100L);
            return;
        }
        QLog.i("FloatMenuManager", 1, "[show] error,window:" + this.f416605c.getWindow());
    }
}
