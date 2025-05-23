package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MagicfaceView extends SurfaceView implements SurfaceHolder.Callback, b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceHolder f243524d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f243525e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f243526f;

    /* renamed from: h, reason: collision with root package name */
    private a f243527h;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
        void a();
    }

    public MagicfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f243525e = false;
        this.f243526f = false;
        e();
    }

    private void d(int[] iArr, int i3, int i16) {
        float width;
        float height;
        Canvas lockCanvas;
        float f16;
        int i17;
        float f17;
        int i18;
        Canvas canvas = null;
        try {
            width = getWidth();
            height = getHeight();
            lockCanvas = this.f243524d.lockCanvas(null);
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            lockCanvas.drawPaint(paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            paint.setFilterBitmap(true);
            paint.setAntiAlias(true);
            if (width < height) {
                f17 = width / i3;
                f16 = height / i16;
                i17 = 0;
            } else {
                f16 = height / i16;
                i17 = (int) (((((int) width) / 2) - ((int) ((i3 * f16) / 2.0f))) / f16);
                f17 = f16;
            }
            if (!this.f243525e) {
                lockCanvas.scale(f17, f17);
                i18 = (int) (((((int) height) / 2) - ((int) ((i16 * f17) / 2.0f))) / f17);
            } else {
                lockCanvas.scale(f17, f16);
                i18 = 0;
            }
            lockCanvas.drawBitmap(iArr, 0, i3, i17, i18, i3, i16, true, paint);
            this.f243524d.unlockCanvasAndPost(lockCanvas);
        } catch (Throwable th6) {
            th = th6;
            canvas = lockCanvas;
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("MagicfaceView", 2, "==drawVideo=error=" + th.toString());
                }
            } finally {
                if (canvas != null) {
                    this.f243524d.unlockCanvasAndPost(canvas);
                }
            }
        }
    }

    private void e() {
        SurfaceHolder holder = getHolder();
        this.f243524d = holder;
        holder.addCallback(this);
    }

    @Override // com.tencent.mobileqq.magicface.view.b
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f243526f;
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder.b
    public void b(byte[] bArr, byte[] bArr2, int i3, int i16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, bArr, bArr2, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.magicface.model.MagicfaceDecoder.b
    public void c(int[] iArr, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, iArr, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            d(iArr, i3, i16);
        }
    }

    @Override // com.tencent.mobileqq.magicface.view.b
    public void setIsFullScreen(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f243525e = z16;
        }
    }

    @Override // com.tencent.mobileqq.magicface.view.b
    public void setSurfaceCreatelistener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        } else {
            this.f243527h = aVar;
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) surfaceHolder);
            return;
        }
        this.f243526f = true;
        a aVar = this.f243527h;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) surfaceHolder);
        }
    }
}
