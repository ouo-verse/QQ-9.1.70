package com.tencent.av.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.n;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.aj;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleSurfaceView extends MySurfaceView implements DoodleLogic.a, Handler.Callback {
    private Paint C;
    private long D;
    public Handler E;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f73599f;

    /* renamed from: h, reason: collision with root package name */
    private Canvas f73600h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f73601i;

    /* renamed from: m, reason: collision with root package name */
    private DoodleLogic f73602m;

    public DoodleSurfaceView(Context context) {
        super(context);
        this.f73600h = new Canvas();
        this.f73602m = null;
        this.D = -1L;
        d(context);
    }

    private void i(DoodleLogic doodleLogic) {
        this.f73602m = doodleLogic;
        doodleLogic.f73590i = getHeight();
        this.f73602m.f73589h = getWidth();
    }

    private void j(float f16, float f17) {
        this.f73602m.n(0, f16, f17);
    }

    private void k(float f16, float f17) {
        this.f73602m.o(0, f16, f17);
    }

    private void l(float f16, float f17) {
        this.f73602m.p(0, f16, f17);
    }

    @Override // com.tencent.av.doodle.DoodleLogic.a
    public void a(int i3) {
        Bitmap bitmap = this.f73599f;
        if (bitmap != null && !bitmap.isRecycled()) {
            synchronized (this.f73600h) {
                h(this.f73600h, this.f73602m.f73583b[i3], false);
            }
        }
        if (this.D == -1) {
            this.D = this.f73602m.f73583b[i3].f73616i;
        }
    }

    @Override // com.tencent.av.doodle.MySurfaceView
    protected void b(Canvas canvas) {
        this.f73602m.f73591j.lock();
        try {
            canvas.drawPaint(this.C);
            SessionInfo f16 = n.e().f();
            if (f16 != null && f16.f73035i == 2) {
                Iterator<b> it = this.f73602m.f73582a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    long j3 = this.D;
                    if (j3 == -1 || next.f73616i - j3 < 0) {
                        h(canvas, next, false);
                    }
                }
                Bitmap bitmap = this.f73599f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    canvas.drawBitmap(this.f73599f, 0.0f, 0.0f, this.f73601i);
                }
                DoodleLogic doodleLogic = this.f73602m;
                if (doodleLogic.f73584c) {
                    h(canvas, doodleLogic.f73583b[1], true);
                    h(canvas, this.f73602m.f73583b[0], true);
                } else {
                    h(canvas, doodleLogic.f73583b[0], true);
                    h(canvas, this.f73602m.f73583b[1], true);
                }
            }
        } finally {
            this.f73602m.f73591j.unlock();
            if (this.f73602m.f73582a.isEmpty()) {
                b[] bVarArr = this.f73602m.f73583b;
                if (bVarArr[0] == null && bVarArr[1] == null) {
                    g(false);
                }
            }
        }
    }

    @Override // com.tencent.av.doodle.MySurfaceView
    protected void e(boolean z16) {
        m(z16, getWidth(), getHeight());
        if (z16 || isClickable()) {
            return;
        }
        Message message = new Message();
        message.what = 0;
        this.E.sendMessage(message);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ViewGroup viewGroup;
        if (QLog.isColorLevel()) {
            QLog.d("DoodleSurfaceView", 2, "handleMessage, msg.what=" + message.what);
        }
        if (message.what != 0 || (viewGroup = (ViewGroup) getParent()) == null) {
            return false;
        }
        viewGroup.removeView(this);
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (i3 <= 0 || i16 <= 0) {
            return;
        }
        try {
            m(c(), i3, i16);
            DoodleLogic doodleLogic = this.f73602m;
            if (doodleLogic != null) {
                doodleLogic.f73590i = i16;
                doodleLogic.f73589h = i3;
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e("DoodleSurfaceView", 2, "WL_DEBUG onSizeChanged e = " + th5);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
    
        if (r7 != 3) goto L41;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        View findViewById;
        aj ajVar;
        View findViewById2;
        aj ajVar2;
        boolean isClickable = isClickable();
        if (isClickable) {
            float x16 = motionEvent.getX();
            float y16 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        j(x16, y16);
                        invalidate();
                    }
                }
                l(x16, y16);
                Context context = getContext();
                if ((context instanceof AVActivity) && (findViewById2 = ((View) getParent()).findViewById(R.id.g7k)) != null && (ajVar2 = ((AVActivity) context).I0) != null) {
                    AlphaAnimation l3 = ajVar2.l(true);
                    if (l3 != null) {
                        findViewById2.startAnimation(l3);
                    }
                    ajVar2.h();
                }
                invalidate();
            } else {
                View view = (View) getParent();
                if (isClickable) {
                    k(x16, y16);
                    Context context2 = getContext();
                    if ((context2 instanceof AVActivity) && (findViewById = view.findViewById(R.id.g7k)) != null && (ajVar = ((AVActivity) context2).I0) != null) {
                        AlphaAnimation l16 = ajVar.l(false);
                        if (l16 != null) {
                            findViewById.startAnimation(l16);
                        }
                        ajVar.h();
                    }
                    invalidate();
                }
            }
        } else if (this.f73602m.f73583b[0] != null) {
            l(motionEvent.getX(), motionEvent.getY());
            invalidate();
        }
        return isClickable;
    }

    @Override // com.tencent.av.doodle.MySurfaceView, android.view.View
    public void onWindowFocusChanged(boolean z16) {
        DoodleLogic doodleLogic;
        super.onWindowFocusChanged(z16);
        if (!z16 || (doodleLogic = this.f73602m) == null) {
            return;
        }
        doodleLogic.f73590i = getHeight();
        this.f73602m.f73589h = getWidth();
    }

    public void setColor(int i3, int i16, float f16) {
        DoodleLogic doodleLogic = this.f73602m;
        doodleLogic.f73595n.b(doodleLogic.f73586e);
        DoodleLogic doodleLogic2 = this.f73602m;
        doodleLogic2.f73586e = i3;
        doodleLogic2.f73587f = i16;
        doodleLogic2.f73588g = f16;
    }

    @Override // com.tencent.av.doodle.MySurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.f73602m.c() != this) {
            this.f73602m.l(this);
        }
        super.surfaceCreated(surfaceHolder);
    }

    @Override // com.tencent.av.doodle.MySurfaceView, android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        super.surfaceDestroyed(surfaceHolder);
        if (this.f73602m.c() == this) {
            this.f73602m.l(null);
        }
    }

    @Override // android.view.View, com.tencent.av.doodle.DoodleLogic.a
    public void invalidate() {
        g(true);
    }

    private void h(Canvas canvas, b bVar, boolean z16) {
        if (bVar != null) {
            bVar.b(canvas, this, z16);
        }
    }

    private void d(Context context) {
        setId(R.id.g7u);
        setClickable(false);
        this.f73601i = new Paint();
        Paint paint = new Paint();
        this.C = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        i(DoodleLogic.b());
        this.E = new Handler(Looper.getMainLooper(), this);
    }

    private void m(boolean z16, int i3, int i16) {
        try {
            if (z16) {
                Bitmap bitmap = this.f73599f;
                if ((bitmap != null && !bitmap.isRecycled() && this.f73599f.getWidth() == i3 && this.f73599f.getHeight() == i16) || i3 == 0 || i16 == 0) {
                    return;
                }
                Bitmap bitmap2 = this.f73599f;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.f73599f.recycle();
                    this.f73599f = null;
                }
                try {
                    Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                    this.f73599f = createBitmap;
                    if (createBitmap != null) {
                        synchronized (this.f73600h) {
                            this.f73600h.setBitmap(this.f73599f);
                        }
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("DoodleSurfaceView", 2, "WL_DEBUG updateBitmap e = " + th5);
                        return;
                    }
                    return;
                }
            }
            Bitmap bitmap3 = this.f73599f;
            if (bitmap3 != null) {
                if (!bitmap3.isRecycled()) {
                    this.f73599f.recycle();
                }
                this.f73599f = null;
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("DoodleSurfaceView", 2, "WL_DEBUG updateBitmap e = " + e16);
            }
        }
    }

    @Override // com.tencent.av.doodle.MySurfaceView
    protected void f(long j3) {
        Bitmap bitmap;
        b peek;
        this.f73602m.f73591j.lock();
        try {
            DoodleLogic doodleLogic = this.f73602m;
            boolean[] zArr = doodleLogic.f73592k;
            if (zArr[1] || zArr[0]) {
                Iterator<b> it = doodleLogic.f73582a.iterator();
                while (it.hasNext()) {
                    b next = it.next();
                    long j16 = this.f73606e;
                    if (j16 - next.f73616i <= 1200) {
                        next.f73616i = j16;
                    }
                }
            }
            while (this.f73602m.f73582a.size() > 0 && (peek = this.f73602m.f73582a.peek()) != null && this.f73606e - peek.f73616i > 2000) {
                this.f73602m.f73582a.poll();
                QLog.w("DoodleSurfaceView", 1, "onUpdateDoodle, poll[" + peek + "], size[" + this.f73602m.f73582a.size() + "]");
            }
            Iterator<b> it5 = this.f73602m.f73582a.iterator();
            while (it5.hasNext()) {
                b next2 = it5.next();
                if (this.f73606e - next2.f73616i <= 1200) {
                    break;
                } else {
                    next2.d(j3);
                }
            }
            long j17 = this.D;
            long j18 = -1;
            if (j17 != -1 && this.f73606e - j17 > 1200 && (bitmap = this.f73599f) != null && !bitmap.isRecycled()) {
                synchronized (this.f73600h) {
                    this.f73600h.drawPaint(this.C);
                    Iterator<b> it6 = this.f73602m.f73582a.iterator();
                    long j19 = -1;
                    while (it6.hasNext()) {
                        b next3 = it6.next();
                        if (j19 == j18) {
                            long j26 = this.f73606e;
                            long j27 = next3.f73616i;
                            if (j26 - j27 <= 1200) {
                                j19 = j27;
                            }
                        }
                        j18 = -1;
                        if (j19 != -1 && next3.f73616i - j19 >= 0) {
                            h(this.f73600h, next3, false);
                        }
                    }
                    this.D = j19;
                }
            }
            this.f73602m.f(j3);
        } finally {
            this.f73602m.f73591j.unlock();
        }
    }

    public DoodleSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f73600h = new Canvas();
        this.f73602m = null;
        this.D = -1L;
        d(context);
    }

    public DoodleSurfaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f73600h = new Canvas();
        this.f73602m = null;
        this.D = -1L;
        d(context);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
    }
}
