package com.tencent.aio.widget.skeleton;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b extends Drawable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Path f69984a;

    /* renamed from: b, reason: collision with root package name */
    d f69985b;

    /* renamed from: c, reason: collision with root package name */
    private a f69986c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f69987d;

    public b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
            return;
        }
        this.f69987d = new RectF();
        this.f69984a = new Path();
        this.f69986c = aVar;
    }

    private void c(Path path, Rect rect, int i3, boolean z16) {
        path.rewind();
        path.moveTo(rect.left + i3, rect.bottom);
        path.lineTo(rect.right - i3, rect.bottom);
        int i16 = i3 * 2;
        this.f69987d.set(r0 - i16, r3 - i16, rect.right, rect.bottom);
        path.arcTo(this.f69987d, 90.0f, -90.0f, false);
        path.lineTo(rect.right, rect.top + i3);
        RectF rectF = this.f69987d;
        int i17 = rect.right;
        rectF.set(i17 - i16, rect.top, i17, r5 + i16);
        path.arcTo(this.f69987d, 0.0f, -90.0f, false);
        path.lineTo(rect.left + i3, rect.top);
        this.f69987d.set(rect.left, rect.top, r0 + i16, r5 + i16);
        path.arcTo(this.f69987d, 270.0f, -90.0f, false);
        path.lineTo(rect.left, rect.bottom - i3);
        this.f69987d.set(rect.left, r9 - i16, r11 + i16, rect.bottom);
        path.arcTo(this.f69987d, 180.0f, -90.0f, false);
        path.close();
    }

    public void a(Canvas canvas, Paint paint) {
        Path path;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) canvas, (Object) paint);
            return;
        }
        Rect bounds = getBounds();
        int bubbleRadius = this.f69986c.getBubbleRadius();
        d dVar = this.f69985b;
        boolean z17 = true;
        if (dVar != null) {
            path = dVar.f69991a;
            z16 = dVar.a(bounds, true, true);
        } else {
            path = this.f69984a;
            z16 = true;
        }
        if (z16) {
            if (paint == null) {
                z17 = false;
            }
            c(path, bounds, bubbleRadius, z17);
        }
        canvas.drawPath(path, paint);
    }

    public void b(Canvas canvas, d dVar, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, canvas, dVar, paint);
            return;
        }
        this.f69985b = dVar;
        a(canvas, paint);
        this.f69985b = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) colorFilter);
        }
    }
}
