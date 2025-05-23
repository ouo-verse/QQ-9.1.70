package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import java.util.Timer;
import java.util.TimerTask;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoodleMsgView extends BaseDoodleMsgView {
    private DoodleDrawer.a C;
    private Paint D;
    private Paint E;
    private Handler F;
    private WeakReference<e> G;
    private int H;
    private int I;

    /* renamed from: d, reason: collision with root package name */
    private DoodleDrawer f178385d;

    /* renamed from: e, reason: collision with root package name */
    private TimerTask f178386e;

    /* renamed from: f, reason: collision with root package name */
    private Timer f178387f;

    /* renamed from: h, reason: collision with root package name */
    private long f178388h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f178389i;

    /* renamed from: m, reason: collision with root package name */
    private Canvas f178390m;

    public DoodleMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178388h = -1L;
        this.F = new Handler();
        this.G = null;
    }

    static /* synthetic */ long j(DoodleMsgView doodleMsgView, long j3) {
        long j16 = doodleMsgView.f178388h + j3;
        doodleMsgView.f178388h = j16;
        return j16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m(int i3, int i16) {
        synchronized (this) {
            boolean z16 = true;
            if (this.f178390m != null && this.f178389i != null) {
                return true;
            }
            boolean z17 = false;
            try {
                if (this.f178389i != null) {
                    DoodleResHelper.k().o(this.f178389i);
                    this.f178389i = null;
                }
                this.f178390m = null;
                Bitmap c16 = DoodleResHelper.k().c(i3, i16);
                this.f178389i = c16;
                if (c16 != null) {
                    Canvas canvas = new Canvas(this.f178389i);
                    this.f178390m = canvas;
                    canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                } else {
                    z16 = false;
                }
                z17 = z16;
            } catch (Exception e16) {
                QLog.e("DoodleMsgView", 2, "create bitmapcache execption!" + e16);
                if (this.f178389i != null) {
                    DoodleResHelper.k().o(this.f178389i);
                    this.f178389i = null;
                }
                this.f178390m = null;
            } catch (OutOfMemoryError unused) {
                QLog.e("DoodleMsgView", 2, "create bitmapcache OOM!");
                if (this.f178389i != null) {
                    DoodleResHelper.k().o(this.f178389i);
                    this.f178389i = null;
                }
                this.f178390m = null;
            }
            return z17;
        }
    }

    private void o() {
        Paint paint;
        synchronized (this) {
            if (this.D == null) {
                Paint paint2 = new Paint();
                this.D = paint2;
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            Canvas canvas = this.f178390m;
            if (canvas != null && (paint = this.D) != null) {
                canvas.drawPaint(paint);
            }
        }
    }

    private void r(int i3, int i16) {
        if (this.f178385d != null) {
            return;
        }
        this.f178385d = new DoodleDrawer();
        DoodleDrawer.a aVar = new DoodleDrawer.a() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1
            @Override // com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.a
            public void a(String str, long j3, Bitmap bitmap) {
                if (DoodleMsgView.this.f178385d == null) {
                    return;
                }
                if (bitmap != null) {
                    if (DoodleMsgView.this.m(bitmap.getWidth(), bitmap.getHeight())) {
                        if (DoodleMsgView.this.E == null) {
                            DoodleMsgView.this.E = new Paint();
                            DoodleMsgView.this.E.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                            DoodleMsgView.this.E.setAntiAlias(true);
                        }
                        synchronized (DoodleMsgView.this) {
                            DoodleMsgView.this.f178390m.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, DoodleMsgView.this.f178389i.getWidth(), DoodleMsgView.this.f178389i.getHeight()), DoodleMsgView.this.E);
                        }
                    }
                    DoodleMsgView.this.postInvalidate();
                }
                if (DoodleMsgView.this.s() && j3 >= DoodleMsgView.this.f178385d.o() && DoodleMsgView.this.f178388h >= DoodleMsgView.this.f178385d.o()) {
                    DoodleMsgView.this.x();
                    DoodleMsgView.this.w(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            e eVar;
                            if (DoodleMsgView.this.G != null && (eVar = (e) DoodleMsgView.this.G.get()) != null) {
                                eVar.onPlayEnd();
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.a
            public void b(String str, final int i17) {
                QLog.d("DoodleMsgView", 2, "onDataState:" + i17 + " - " + str);
                DoodleMsgView.this.w(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        e eVar;
                        if (DoodleMsgView.this.G != null && (eVar = (e) DoodleMsgView.this.G.get()) != null) {
                            eVar.a(i17);
                        }
                    }
                });
            }
        };
        this.C = aVar;
        this.f178385d.q(aVar, 1, i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        if (this.f178386e != null) {
            return true;
        }
        return false;
    }

    private void v(long j3) {
        float f16;
        float f17;
        long j16;
        e eVar;
        DoodleDrawer doodleDrawer = this.f178385d;
        if (doodleDrawer == null) {
            return;
        }
        long o16 = doodleDrawer.o();
        if (o16 <= 3000) {
            f16 = ((float) o16) * 1.0f;
            f17 = 1.2f;
        } else if (o16 <= 20000) {
            f16 = ((float) o16) * 1.0f;
            f17 = 1.5f;
        } else {
            f16 = ((float) o16) * 1.0f;
            f17 = 1.8f;
        }
        final long o17 = this.f178385d.o();
        final long j17 = o17 / ((((int) (f16 / f17)) / 25) + 1);
        this.f178386e = new TimerTask() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    DoodleDrawer doodleDrawer2 = DoodleMsgView.this.f178385d;
                    if (doodleDrawer2 == null) {
                        DoodleMsgView.this.w(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleMsgView.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DoodleMsgView.this.x();
                            }
                        });
                        return;
                    }
                    if (DoodleMsgView.this.f178388h < 0) {
                        DoodleMsgView.this.f178388h = o17;
                    }
                    if (DoodleMsgView.this.f178388h < o17) {
                        DoodleMsgView.j(DoodleMsgView.this, j17);
                    }
                    doodleDrawer2.u(DoodleMsgView.this.f178388h, true);
                    if (DoodleMsgView.this.f178388h >= o17) {
                        DoodleMsgView.this.y();
                    } else if (!DoodleMsgView.this.s()) {
                        doodleDrawer2.u(o17, true);
                    }
                } catch (Exception unused) {
                }
            }
        };
        BaseTimer baseTimer = new BaseTimer();
        this.f178387f = baseTimer;
        this.f178388h = 0L;
        TimerTask timerTask = this.f178386e;
        if (j3 > 0) {
            j16 = j3;
        } else {
            j16 = 0;
        }
        baseTimer.schedule(timerTask, j16, 25L);
        WeakReference<e> weakReference = this.G;
        if (weakReference != null && (eVar = weakReference.get()) != null) {
            eVar.onPlayStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        synchronized (this) {
            TimerTask timerTask = this.f178386e;
            if (timerTask != null) {
                timerTask.cancel();
                this.f178386e = null;
            }
            Timer timer = this.f178387f;
            if (timer != null) {
                timer.cancel();
                this.f178387f = null;
            }
        }
    }

    public void n() {
        o();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        DoodleDrawer doodleDrawer = this.f178385d;
        if (doodleDrawer != null && doodleDrawer.k() != 0) {
            QLog.d("DoodleMsgView", 2, "onDraw not ready");
            return;
        }
        synchronized (this) {
            Bitmap bitmap = this.f178389i;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, new Rect(0, 0, this.f178389i.getWidth(), this.f178389i.getHeight()), new Rect(0, 0, this.H, this.I), (Paint) null);
            }
        }
    }

    public int p() {
        DoodleDrawer doodleDrawer = this.f178385d;
        if (doodleDrawer != null) {
            return doodleDrawer.k();
        }
        return 4;
    }

    public void q(e eVar, int i3, int i16) {
        QLog.d("DoodleMsgView", 2, "DoodleMsgView init begin");
        this.G = new WeakReference<>(eVar);
        this.f178390m = null;
        this.H = i3;
        this.I = i16;
        r(i3, i16);
        QLog.d("DoodleMsgView", 2, "DoodleMsgView init end");
    }

    public void setContent(String str, boolean z16) {
        e eVar;
        QLog.d("DoodleMsgView", 2, "setContent:" + str + " prepare:" + z16);
        DoodleDrawer doodleDrawer = this.f178385d;
        if (doodleDrawer == null) {
            return;
        }
        if (doodleDrawer.y(str, z16, getContext())) {
            QLog.d("DoodleMsgView", 2, "drawer setdata return true:");
            y();
            return;
        }
        QLog.d("DoodleMsgView", 2, "drawer setdata same data:" + p());
        WeakReference<e> weakReference = this.G;
        if (weakReference != null && (eVar = weakReference.get()) != null) {
            eVar.a(p());
        }
    }

    public void t(boolean z16) {
        DoodleDrawer doodleDrawer = this.f178385d;
        if (doodleDrawer != null) {
            doodleDrawer.t(z16);
        }
    }

    public void u(long j3) {
        e eVar;
        QLog.d("DoodleMsgView", 2, "play:");
        DoodleDrawer doodleDrawer = this.f178385d;
        if (doodleDrawer != null && doodleDrawer.m() != 0) {
            if (s()) {
                x();
            }
            v(j3);
        } else {
            WeakReference<e> weakReference = this.G;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.onPlayEnd();
            }
        }
    }

    protected void w(Runnable runnable) {
        this.F.post(runnable);
    }

    public void x() {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgView", 2, "stop");
        }
        y();
        this.f178388h = Long.MIN_VALUE;
        if (this.f178385d != null && isShown()) {
            this.f178385d.u(TTL.MAX_VALUE, false);
            if (QLog.isColorLevel()) {
                QLog.d("DoodleMsgView", 2, "preparesegments");
            }
        }
        QLog.d("DoodleMsgView", 2, "stop end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z() {
        if (this.f178385d != null) {
            x();
            this.f178385d.A();
            this.f178385d = null;
        }
        this.C = null;
        if (this.f178389i != null) {
            DoodleResHelper.k().o(this.f178389i);
            this.f178389i = null;
        }
        QLog.d("DoodleMsgView", 2, "DoodleMsgView unInit");
    }
}
