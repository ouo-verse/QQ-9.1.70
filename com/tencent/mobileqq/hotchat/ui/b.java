package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.qzone.util.WnsError;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private Paint f236923e;

    /* renamed from: f, reason: collision with root package name */
    private Canvas f236924f;

    /* renamed from: g, reason: collision with root package name */
    private int[] f236925g;

    /* renamed from: h, reason: collision with root package name */
    private Random f236926h;

    public b(Context context, int i3) {
        super(context, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
        } else {
            this.f236925g = new int[]{Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a")};
            this.f236926h = new Random(System.currentTimeMillis());
        }
    }

    public static void d(HeartLayout heartLayout) {
        HeartAnimator.a j3;
        if (heartLayout != null && heartLayout.j() != null && (j3 = heartLayout.j()) != null) {
            j3.f236885k = WnsError.WNS_CODE_DIS_STAT_BEGIN;
            HeartAnimator.a.f236874q = 0.05f;
        }
    }

    @Override // com.tencent.mobileqq.hotchat.ui.a
    public Bitmap c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        super.c();
        return e();
    }

    public Bitmap e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f236919a == null) {
            try {
                this.f236919a = BitmapFactory.decodeResource(this.f236921c.getResources(), this.f236920b);
            } catch (OutOfMemoryError unused) {
                return null;
            }
        }
        if (this.f236919a == null) {
            return null;
        }
        if (this.f236923e == null) {
            this.f236923e = new Paint(3);
        }
        if (this.f236924f == null) {
            this.f236924f = new Canvas();
        }
        Bitmap bitmap = this.f236919a;
        Bitmap a16 = HeartView.a(bitmap.getWidth(), this.f236919a.getHeight());
        if (a16 == null) {
            return null;
        }
        Canvas canvas = this.f236924f;
        canvas.setBitmap(a16);
        Paint paint = this.f236923e;
        int[] iArr = this.f236925g;
        paint.setColorFilter(new PorterDuffColorFilter(iArr[this.f236926h.nextInt(iArr.length)], PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        paint.setColorFilter(null);
        canvas.setBitmap(null);
        return a16;
    }

    public b(Context context, int i3, HeartAnimator heartAnimator) {
        super(context, i3, heartAnimator);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Integer.valueOf(i3), heartAnimator);
        } else {
            this.f236925g = new int[]{Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a")};
            this.f236926h = new Random(System.currentTimeMillis());
        }
    }
}
