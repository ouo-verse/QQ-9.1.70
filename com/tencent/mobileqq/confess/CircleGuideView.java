package com.tencent.mobileqq.confess;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CircleGuideView extends View {
    static IPatchRedirector $redirector_;
    private int C;

    /* renamed from: d, reason: collision with root package name */
    private Paint f202051d;

    /* renamed from: e, reason: collision with root package name */
    private Canvas f202052e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f202053f;

    /* renamed from: h, reason: collision with root package name */
    private float f202054h;

    /* renamed from: i, reason: collision with root package name */
    private float f202055i;

    /* renamed from: m, reason: collision with root package name */
    private float f202056m;

    public CircleGuideView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f202051d = new Paint();
        this.f202052e = new Canvas();
        this.C = 180;
        a();
    }

    private void a() {
        this.f202051d.setARGB(0, 0, 0, 0);
        this.f202051d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f202051d.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        if (this.f202053f == null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
                this.f202053f = createBitmap;
                this.f202052e.setBitmap(createBitmap);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d("CircleGuideView", 2, th5.toString());
                }
            }
        }
        if (this.f202053f != null) {
            this.f202052e.drawColor(Color.argb(this.C, 0, 0, 0));
            this.f202052e.drawCircle(this.f202054h, this.f202055i, this.f202056m, this.f202051d);
            canvas.drawBitmap(this.f202053f, new Rect(0, 0, this.f202053f.getWidth(), this.f202053f.getHeight()), new Rect(0, 0, canvas.getWidth(), canvas.getHeight()), (Paint) null);
            return;
        }
        canvas.drawColor(Color.argb(this.C, 0, 0, 0));
    }

    public void setCircle(float f16, float f17, float f18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18));
            return;
        }
        this.f202054h = f16;
        this.f202055i = f17;
        this.f202056m = f18;
    }

    public CircleGuideView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f202051d = new Paint();
        this.f202052e = new Canvas();
        this.C = 180;
        a();
    }

    public CircleGuideView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f202051d = new Paint();
        this.f202052e = new Canvas();
        this.C = 180;
        a();
    }
}
