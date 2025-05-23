package com.tencent.mobileqq.troopreward;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes19.dex */
public class OrientationAdapterImageView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected int f303319d;

    /* renamed from: e, reason: collision with root package name */
    protected Paint f303320e;

    /* renamed from: f, reason: collision with root package name */
    protected RectF f303321f;

    /* renamed from: h, reason: collision with root package name */
    protected Bitmap f303322h;

    /* renamed from: i, reason: collision with root package name */
    protected Handler f303323i;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) OrientationAdapterImageView.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            OrientationAdapterImageView orientationAdapterImageView = OrientationAdapterImageView.this;
            if (orientationAdapterImageView.f303322h != null) {
                orientationAdapterImageView.invalidate();
            }
            if (QLog.isColorLevel()) {
                QLog.d("OrientationAdapterImageView", 2, "handleMessage:" + OrientationAdapterImageView.this.f303319d + "," + OrientationAdapterImageView.this.f303322h);
            }
        }
    }

    public OrientationAdapterImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f303319d = 1;
        this.f303320e = null;
        this.f303321f = new RectF();
        this.f303322h = null;
        this.f303323i = new a();
        b(context);
    }

    protected void a(RectF rectF, Bitmap bitmap, View view) {
        int i3;
        int i16;
        int i17;
        int i18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, rectF, bitmap, view);
            return;
        }
        int height = view.getHeight();
        int width = view.getWidth();
        int height2 = bitmap.getHeight();
        int width2 = bitmap.getWidth();
        float f16 = width;
        float f17 = height;
        rectF.set(0.0f, 0.0f, f16, f17);
        float f18 = (f16 * 1.0f) / f17;
        float f19 = width2;
        float f26 = f19 * 1.0f;
        float f27 = height2;
        float f28 = f26 / f27;
        if (QLog.isColorLevel()) {
            QLog.d("OrientationAdapterImageView", 2, "getTargetRectF,  viewRatio:" + f18 + ", bmpRatio:" + f28 + ", mOrientation:" + this.f303319d);
        }
        int i19 = this.f303319d;
        if (i19 != 0 && i19 != 180) {
            if (f18 > f28) {
                int i26 = (int) (f16 * f28);
                i16 = (width - i26) / 2;
                i3 = (height - width) / 2;
                i17 = i26 + i16;
            } else {
                i16 = (-(((int) (f16 * f28)) - width)) / 2;
                i3 = (height - width) / 2;
                i17 = width - i16;
            }
            i18 = width + i3;
        } else if (f18 > f28) {
            int i27 = (int) ((f26 * f17) / f27);
            i16 = (width - i27) / 2;
            i17 = i16 + i27;
            i18 = height;
            i3 = 0;
        } else {
            int i28 = (int) (((f27 * 1.0f) * f16) / f19);
            i3 = (height - i28) / 2;
            int i29 = i28 + i3;
            i16 = 0;
            i17 = width;
            i18 = i29;
        }
        rectF.set(i16, i3, i17, i18);
        if (QLog.isColorLevel()) {
            QLog.d("OrientationAdapterImageView", 2, "getTargetRectF:" + rectF.toString());
        }
    }

    protected void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        Paint paint = new Paint();
        this.f303320e = paint;
        paint.setFilterBitmap(true);
        this.f303320e.setAntiAlias(true);
        this.f303320e.setDither(true);
        setBackgroundColor(-16777216);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        Bitmap bitmap = this.f303322h;
        if (bitmap != null) {
            a(this.f303321f, bitmap, this);
            canvas.save();
            canvas.rotate(this.f303319d, getWidth() / 2, getHeight() / 2);
            canvas.drawBitmap(this.f303322h, (Rect) null, this.f303321f, this.f303320e);
            canvas.restore();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        } else {
            this.f303322h = bitmap;
            invalidate();
        }
    }

    public OrientationAdapterImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f303319d = 1;
        this.f303320e = null;
        this.f303321f = new RectF();
        this.f303322h = null;
        this.f303323i = new a();
        b(context);
    }
}
