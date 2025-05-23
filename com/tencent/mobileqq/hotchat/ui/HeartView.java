package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HeartView extends ImageView {
    static IPatchRedirector $redirector_;
    private static Canvas C;

    /* renamed from: h, reason: collision with root package name */
    private static Bitmap f236907h;

    /* renamed from: i, reason: collision with root package name */
    private static Bitmap f236908i;

    /* renamed from: m, reason: collision with root package name */
    private static Paint f236909m;

    /* renamed from: d, reason: collision with root package name */
    protected final int f236910d;

    /* renamed from: e, reason: collision with root package name */
    protected final int f236911e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f236912f;

    public HeartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f236910d = R.drawable.ev8;
        this.f236911e = R.drawable.ev7;
        this.f236912f = true;
    }

    public static Bitmap a(int i3, int i16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public Bitmap b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this, i3);
        }
        if (f236907h == null) {
            try {
                f236907h = BitmapFactory.decodeResource(getResources(), this.f236910d);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        if (f236908i == null) {
            try {
                f236908i = BitmapFactory.decodeResource(getResources(), this.f236911e);
            } catch (OutOfMemoryError unused2) {
                return null;
            }
        }
        if (f236909m == null) {
            f236909m = new Paint(3);
        }
        if (C == null) {
            C = new Canvas();
        }
        Bitmap bitmap = f236907h;
        Bitmap bitmap2 = f236908i;
        Bitmap a16 = a(bitmap2.getWidth(), bitmap2.getHeight());
        if (a16 == null) {
            return null;
        }
        Canvas canvas = C;
        canvas.setBitmap(a16);
        Paint paint = f236909m;
        if (this.f236912f) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
            paint.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap, (bitmap2.getWidth() - bitmap.getWidth()) / 2.0f, (bitmap2.getHeight() - bitmap.getHeight()) / 2.0f, paint);
        } else {
            paint.setColorFilter(new PorterDuffColorFilter(i3, PorterDuff.Mode.SRC_ATOP));
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        }
        paint.setColorFilter(null);
        canvas.setBitmap(null);
        return a16;
    }

    public void setColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        Bitmap b16 = b(i3);
        if (b16 != null) {
            super.setImageBitmap(b16);
        } else {
            super.setImageResource(this.f236910d);
        }
    }

    public HeartView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f236910d = R.drawable.ev8;
        this.f236911e = R.drawable.ev7;
        this.f236912f = true;
    }

    public HeartView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
            return;
        }
        this.f236910d = R.drawable.ev8;
        this.f236911e = R.drawable.ev7;
        this.f236912f = true;
    }
}
