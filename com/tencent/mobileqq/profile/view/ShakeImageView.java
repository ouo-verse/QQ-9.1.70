package com.tencent.mobileqq.profile.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.QLog;
import hd0.c;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ShakeImageView extends ImageView implements SensorEventListener {
    static IPatchRedirector $redirector_;
    private float C;
    private Paint D;
    private float E;
    float[] F;

    /* renamed from: d, reason: collision with root package name */
    private SensorManager f260423d;

    /* renamed from: e, reason: collision with root package name */
    private Sensor f260424e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f260425f;

    /* renamed from: h, reason: collision with root package name */
    private int f260426h;

    /* renamed from: i, reason: collision with root package name */
    private int f260427i;

    /* renamed from: m, reason: collision with root package name */
    private float f260428m;

    public ShakeImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = 1.0f;
        this.F = new float[]{0.0f, 0.0f, 0.0f};
        b();
    }

    private float[] a(SensorEvent sensorEvent) {
        float[] fArr = this.F;
        fArr[0] = c(sensorEvent.values[0] * 50.0f, fArr[0]);
        float[] fArr2 = this.F;
        fArr2[1] = c(sensorEvent.values[1] * 50.0f, fArr2[1]);
        float[] fArr3 = this.F;
        fArr3[2] = c(sensorEvent.values[2] * 50.0f, fArr3[2]);
        return this.F;
    }

    private void b() {
        Paint paint = new Paint();
        this.D = paint;
        paint.setAntiAlias(true);
        this.f260423d = (SensorManager) getContext().getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
    }

    public static float c(float f16, float f17) {
        return (int) (f17 + ((f16 - f17) * 0.3f));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) sensor, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (this.f260423d == null) {
            c.g("ShakeImageView", "onAttachedToWindow but mSensorManager is null.");
        }
        if (getVisibility() != 8 && this.f260424e != null && (sensorManager = this.f260423d) != null) {
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(sensorManager, 9);
            this.f260424e = defaultSensor;
            SensorMonitor.registerListener(this.f260423d, this, defaultSensor, 1);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        SensorManager sensorManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (this.f260423d == null) {
            c.g("ShakeImageView", "onDetachedFromWindow but mSensorManager is null.");
        }
        if (this.f260424e != null && (sensorManager = this.f260423d) != null) {
            sensorManager.unregisterListener(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) canvas);
            return;
        }
        System.currentTimeMillis();
        int i3 = this.f260426h;
        if (i3 > 0 && this.f260427i > 0 && this.f260425f != null) {
            int measuredWidth = (i3 - getMeasuredWidth()) / 2;
            int measuredHeight = (this.f260427i - getMeasuredHeight()) / 2;
            int i16 = -measuredWidth;
            float f16 = (this.f260428m * measuredWidth) / 400.0f;
            float f17 = this.E;
            float f18 = i16 - (f16 * f17);
            float f19 = i16 * 2;
            if (f18 < f19) {
                f18 = f19;
            }
            float f26 = 0.0f;
            if (f18 > 0.0f) {
                f18 = 0.0f;
            }
            int i17 = -measuredHeight;
            float f27 = i17 - (((this.C * measuredHeight) / 400.0f) * f17);
            float f28 = i17 * 2;
            if (f27 < f28) {
                f27 = f28;
            }
            if (f27 <= 0.0f) {
                f26 = f27;
            }
            canvas.drawBitmap(this.f260425f, f18, f26, this.D);
        }
        System.currentTimeMillis();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) sensorEvent);
            return;
        }
        float[] a16 = a(sensorEvent);
        this.f260428m = a16[0];
        this.C = a16[1];
        invalidate();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, i3);
            return;
        }
        super.onVisibilityChanged(view, i3);
        if (getVisibility() != 8 && this.f260424e == null) {
            Sensor defaultSensor = SensorMonitor.getDefaultSensor(this.f260423d, 9);
            this.f260424e = defaultSensor;
            SensorMonitor.registerListener(this.f260423d, this, defaultSensor, 1);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ae -> B:22:0x00bf). Please report as a decompilation issue!!! */
    public void setImage(String str, int i3, int i16, float f16) {
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
            return;
        }
        this.f260426h = i3;
        this.f260427i = i16;
        if (f16 >= 0.0f) {
            this.E = 1.0f;
        } else {
            this.E = -1.0f;
        }
        BufferedInputStream bufferedInputStream2 = null;
        try {
        } catch (Throwable th6) {
            th5 = th6;
        }
        try {
            try {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
                } catch (Exception e16) {
                    e = e16;
                    bufferedInputStream = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                }
                try {
                    Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream);
                    if (decodeStream.getWidth() == i3 && decodeStream.getHeight() == i16) {
                        this.f260425f = decodeStream;
                    } else {
                        Matrix matrix = new Matrix();
                        matrix.postScale(i3 / decodeStream.getWidth(), i16 / decodeStream.getHeight());
                        this.f260425f = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, false);
                        decodeStream.recycle();
                    }
                    bufferedInputStream.close();
                } catch (Exception e18) {
                    e = e18;
                    this.f260425f = null;
                    QLog.e("ShakeImageView", 1, "setImage error: ", e);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                } catch (OutOfMemoryError e19) {
                    e = e19;
                    bufferedInputStream2 = bufferedInputStream;
                    QLog.e("ShakeImageView", 1, "setImage error: ", e);
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                }
            } catch (IOException e26) {
                QLog.e("ShakeImageView", 1, "setImage error: ", e26);
            }
        } catch (Throwable th7) {
            th5 = th7;
            bufferedInputStream2 = 7;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                    throw th5;
                } catch (IOException e27) {
                    QLog.e("ShakeImageView", 1, "setImage error: ", e27);
                    throw th5;
                }
            }
            throw th5;
        }
    }

    public ShakeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.E = 1.0f;
        this.F = new float[]{0.0f, 0.0f, 0.0f};
        b();
    }

    public ShakeImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.E = 1.0f;
        this.F = new float[]{0.0f, 0.0f, 0.0f};
        b();
    }

    public void setImage(Bitmap bitmap, int i3, int i16, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
            return;
        }
        this.f260426h = i3;
        this.f260427i = i16;
        if (f16 >= 0.0f) {
            this.E = 1.0f;
        } else {
            this.E = -1.0f;
        }
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i16) {
            this.f260425f = bitmap;
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(i3 / bitmap.getWidth(), i16 / bitmap.getHeight());
        try {
            this.f260425f = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        } catch (OutOfMemoryError e16) {
            QLog.e("ShakeImageView", 1, "setImage OutOfMemory: " + e16.getMessage());
            System.gc();
            try {
                this.f260425f = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            } catch (OutOfMemoryError e17) {
                QLog.e("ShakeImageView", 1, "setImage OutOfMemory again: " + e17.getMessage());
            }
        }
    }
}
