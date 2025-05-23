package com.tencent.tar.jni;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ScanFeatureFilterView extends SurfaceView implements SurfaceHolder.Callback, Handler.Callback {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    int E;
    int F;
    int G;
    private int H;
    private int I;
    int J;
    private Bitmap K;
    private Paint L;
    private volatile boolean M;
    private Rect N;
    private int P;
    private long Q;
    private boolean R;
    private int S;
    private int T;
    a[][] U;
    private final int V;
    private SurfaceHolder W;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f374229a0;

    /* renamed from: b0, reason: collision with root package name */
    private HandlerThread f374230b0;

    /* renamed from: c0, reason: collision with root package name */
    private Handler f374231c0;

    /* renamed from: d, reason: collision with root package name */
    private int f374232d;

    /* renamed from: e, reason: collision with root package name */
    private int f374233e;

    /* renamed from: f, reason: collision with root package name */
    private int f374234f;

    /* renamed from: h, reason: collision with root package name */
    private int f374235h;

    /* renamed from: i, reason: collision with root package name */
    private int f374236i;

    /* renamed from: m, reason: collision with root package name */
    int f374237m;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ScanFeatureFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f374232d = -1;
        this.f374233e = 0;
        this.f374234f = 1;
        this.f374235h = 2;
        this.f374236i = -1;
        this.f374237m = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.J = -1;
        this.L = new Paint();
        this.M = false;
        this.N = new Rect();
        this.P = 300;
        this.Q = 600L;
        this.R = false;
        this.S = 0;
        this.T = 0;
        this.U = null;
        d();
        this.V = a(getContext(), 10.0f);
        this.K = BitmapFactory.decodeResource(context.getResources(), R.drawable.etm);
        setZOrderOnTop(true);
        SurfaceHolder holder = getHolder();
        this.W = holder;
        holder.setFormat(-2);
        this.W.addCallback(this);
    }

    public static int a(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void b() {
        c();
    }

    private void c() {
        if (!this.M && this.f374231c0 != null && getVisibility() == 0) {
            Handler handler = this.f374231c0;
            if (handler != null) {
                handler.removeMessages(100);
            }
            Handler handler2 = this.f374231c0;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(100, 30L);
            }
        }
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.L.setColor(this.J);
            this.L.setStyle(Paint.Style.FILL);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 100) {
            try {
                b();
            } catch (Throwable unused) {
                return true;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        QLog.d("ScanFeatureFilterView", 2, "onSizeChanged ");
        super.onSizeChanged(i3, i16, i17, i18);
        this.f374237m = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.C = measuredHeight;
        int i19 = this.f374237m;
        int i26 = this.V;
        int i27 = i19 / i26;
        this.T = i27;
        int i28 = measuredHeight / i26;
        this.S = i28;
        this.U = (a[][]) Array.newInstance((Class<?>) a.class, i28, i27);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surfaceHolder);
            return;
        }
        QLog.d("ScanFeatureFilterView", 2, "create ");
        this.f374229a0 = true;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("FeaturePointDetecto_thread");
        this.f374230b0 = baseHandlerThread;
        baseHandlerThread.start();
        this.f374231c0 = new Handler(this.f374230b0.getLooper(), this);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) surfaceHolder);
            return;
        }
        QLog.d("ScanFeatureFilterView", 2, "surfaceDestroyed ");
        try {
            this.f374229a0 = false;
            this.f374231c0.removeCallbacksAndMessages(null);
            this.f374230b0.quit();
            this.f374230b0 = null;
            this.f374231c0 = null;
        } catch (Exception e16) {
            QLog.e("ScanFeatureFilterView", 2, "surfaceDestroyed error = " + e16.getMessage());
        }
    }
}
