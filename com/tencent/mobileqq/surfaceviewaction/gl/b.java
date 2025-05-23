package com.tencent.mobileqq.surfaceviewaction.gl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends e {
    static IPatchRedirector $redirector_;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private int f291298a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f291299b0;

    /* renamed from: c0, reason: collision with root package name */
    private Paint f291300c0;

    public b(SpriteGLView spriteGLView, Context context, String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, spriteGLView, context, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.Z = "";
        this.f291298a0 = 20;
        this.f291299b0 = -1;
        Paint paint = new Paint();
        this.f291300c0 = paint;
        paint.setAntiAlias(true);
        M(i3);
        N(i16);
        L(spriteGLView, str);
    }

    public void L(SpriteGLView spriteGLView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) spriteGLView, (Object) str);
            return;
        }
        if (str.equals(this.Z)) {
            return;
        }
        this.Z = str;
        Bitmap createBitmap = Bitmap.createBitmap((int) this.f291300c0.measureText(str), this.f291298a0, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-16777216, PorterDuff.Mode.CLEAR);
        canvas.drawText(this.Z, 0.0f, this.f291298a0 * 0.8f, this.f291300c0);
        Texture texture = this.Q;
        if (texture != null) {
            texture.e();
        }
        this.Q = new Texture(spriteGLView, createBitmap);
        G();
        H();
    }

    public void M(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.f291299b0 = i3;
            this.f291300c0.setColor(i3);
        }
    }

    public void N(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f291298a0 = i3;
            this.f291300c0.setTextSize(i3);
        }
    }
}
