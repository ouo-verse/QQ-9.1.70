package com.tencent.mobileqq.qzonevip.gift.particle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

/* loaded from: classes16.dex */
public abstract class ParticleTextureView extends TextureView implements TextureView.SurfaceTextureListener {
    static IPatchRedirector $redirector_;
    protected int C;
    protected HandlerThread D;
    protected Handler E;
    protected volatile boolean F;
    protected final Object G;
    protected int H;
    private Surface I;
    private Rect J;

    /* renamed from: d, reason: collision with root package name */
    protected Random f280173d;

    /* renamed from: e, reason: collision with root package name */
    protected Matrix f280174e;

    /* renamed from: f, reason: collision with root package name */
    protected Paint f280175f;

    /* renamed from: h, reason: collision with root package name */
    protected ArrayList<com.tencent.mobileqq.qzonevip.gift.particle.a> f280176h;

    /* renamed from: i, reason: collision with root package name */
    protected Context f280177i;

    /* renamed from: m, reason: collision with root package name */
    protected int f280178m;

    /* loaded from: classes16.dex */
    public interface a {
    }

    /* loaded from: classes16.dex */
    private class b extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private Bitmap[] f280179a;

        public b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ParticleTextureView.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            if (ParticleTextureView.this.f280176h.size() > 0 || !ParticleTextureView.this.F) {
                                ParticleTextureView.this.i();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ParticleTextureView particleTextureView = ParticleTextureView.this;
                    particleTextureView.H++;
                    particleTextureView.n();
                    if (ParticleTextureView.this.h()) {
                        ParticleTextureView.this.l(2);
                        return;
                    } else {
                        ParticleTextureView.this.l(4);
                        return;
                    }
                }
                ParticleTextureView.this.H = 0;
                QLog.i("ParticleTextureView", 1, "handleMessage: MSG_ADD_DATA");
                ParticleTextureView.this.b(this.f280179a);
                ParticleTextureView.this.l(4);
                return;
            }
            QLog.i("ParticleTextureView", 1, "handleMessage: MSG_INIT_DATA");
            this.f280179a = ParticleTextureView.this.f();
            ParticleTextureView.this.l(2);
        }
    }

    public ParticleTextureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.F = false;
        this.G = new Object();
        this.H = 0;
        this.J = new Rect();
        g(context);
    }

    private void g(Context context) {
        this.f280177i = context;
        this.f280173d = new Random();
        this.f280174e = new Matrix();
        Paint paint = new Paint();
        this.f280175f = paint;
        paint.setAntiAlias(true);
        this.f280175f.setColor(-1);
        this.f280176h = new ArrayList<>();
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3) {
        m(i3, 0);
    }

    private void m(int i3, int i16) {
        Handler handler = this.E;
        if (handler == null) {
            QLog.i("ParticleTextureView", 1, "sendValidMessage: handle = null ");
            return;
        }
        if (handler.hasMessages(i3)) {
            this.E.removeMessages(i3);
        }
        this.E.sendEmptyMessageDelayed(i3, i16);
    }

    protected abstract void b(Bitmap[] bitmapArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public float c(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), Float.valueOf(f17))).floatValue();
        }
        if (f16 > f17) {
            return f16;
        }
        return (this.f280173d.nextFloat() * (f17 - f16)) + f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        if (i3 > i16) {
            return i3;
        }
        return this.f280173d.nextInt(i16 - i3) + i3;
    }

    protected abstract int e();

    protected abstract Bitmap[] f();

    protected abstract boolean h();

    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void i() {
        String str;
        String str2;
        Surface surface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.G) {
            Canvas canvas = null;
            try {
                try {
                    surface = this.I;
                } catch (Throwable th5) {
                    try {
                        QLog.e("ParticleTextureView", 1, "onCanvasDraw draw has a exception e: " + th5);
                        try {
                            Surface surface2 = this.I;
                            if (surface2 != null) {
                                surface2.unlockCanvasAndPost(canvas);
                            }
                        } catch (Throwable th6) {
                            str = "ParticleTextureView";
                            str2 = "onCanvasDraw unlockCanvasAndPost has a exception e: " + th6;
                            QLog.e(str, 1, str2);
                            QLog.i("ParticleTextureView", 1, "consume = " + (System.currentTimeMillis() - currentTimeMillis));
                            if (this.E != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                    } finally {
                    }
                }
                if (surface == null) {
                    if (surface != null) {
                        try {
                            surface.unlockCanvasAndPost(null);
                        } catch (Throwable th7) {
                            QLog.e("ParticleTextureView", 1, "onCanvasDraw unlockCanvasAndPost has a exception e: " + th7);
                        }
                    }
                    return;
                }
                canvas = surface.lockCanvas(this.J);
                if (canvas != null && this.I.isValid()) {
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    try {
                        Iterator<com.tencent.mobileqq.qzonevip.gift.particle.a> it = this.f280176h.iterator();
                        while (it.hasNext()) {
                            com.tencent.mobileqq.qzonevip.gift.particle.a next = it.next();
                            if (next != null) {
                                next.a(canvas, this.f280175f, this.f280174e);
                            }
                        }
                    } catch (Throwable th8) {
                        QLog.e("ParticleTextureView", 1, "onCanvasDraw draw has a exception e: " + th8);
                    }
                }
                try {
                    Surface surface3 = this.I;
                    if (surface3 != null) {
                        surface3.unlockCanvasAndPost(canvas);
                    }
                } catch (Throwable th9) {
                    str = "ParticleTextureView";
                    str2 = "onCanvasDraw unlockCanvasAndPost has a exception e: " + th9;
                    QLog.e(str, 1, str2);
                    QLog.i("ParticleTextureView", 1, "consume = " + (System.currentTimeMillis() - currentTimeMillis));
                    if (this.E != null) {
                    }
                }
                QLog.i("ParticleTextureView", 1, "consume = " + (System.currentTimeMillis() - currentTimeMillis));
                if (this.E != null && this.f280176h.size() != 0) {
                    m(3, e());
                    return;
                }
                return;
            } catch (Throwable th10) {
                throw th10;
            }
            throw th10;
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            l(1);
        }
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.F = true;
        }
    }

    protected abstract void n();

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        QLog.i("ParticleTextureView", 1, "onSurfaceTextureAvailable: width = " + i3 + " height = " + i16);
        this.I = new Surface(surfaceTexture);
        this.f280178m = i3;
        this.C = i16;
        this.J = new Rect(0, 0, i3, i16);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Particle-Texture-Thread" + UUID.randomUUID());
        this.D = baseHandlerThread;
        baseHandlerThread.start();
        this.E = new b(this.D.getLooper());
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) surfaceTexture)).booleanValue();
        }
        this.I = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, surfaceTexture, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surfaceTexture);
        }
    }

    public void setParticleListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        }
    }

    public ParticleTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.F = false;
        this.G = new Object();
        this.H = 0;
        this.J = new Rect();
        g(context);
    }

    public ParticleTextureView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.F = false;
        this.G = new Object();
        this.H = 0;
        this.J = new Rect();
        g(context);
    }
}
