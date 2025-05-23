package com.tencent.mobileqq.qqui.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static boolean f274797h;

    /* renamed from: a, reason: collision with root package name */
    private View f274798a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f274799b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f274800c;

    /* renamed from: d, reason: collision with root package name */
    private Rect f274801d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f274802e;

    /* renamed from: f, reason: collision with root package name */
    private int f274803f;

    /* renamed from: g, reason: collision with root package name */
    private Canvas f274804g;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        void superDrawMosaic(Canvas canvas);

        void superOnDrawMosaic(Canvas canvas);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f274797h = false;
        }
    }

    public b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f274801d = new Rect();
        this.f274802e = new Paint(5);
        this.f274803f = 10;
        this.f274804g = new Canvas();
        this.f274803f = i3;
    }

    public static boolean a(b bVar, b bVar2) {
        if (bVar == null && bVar2 == null) {
            return true;
        }
        if (bVar != null && bVar2 != null && bVar.f274803f == bVar2.f274803f) {
            return true;
        }
        return false;
    }

    public void b(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        SystemClock.uptimeMillis();
        int width = this.f274798a.getWidth() / this.f274803f;
        int height = this.f274798a.getHeight() / this.f274803f;
        Bitmap bitmap = this.f274799b;
        if (bitmap == null || bitmap.getWidth() != width || this.f274799b.getHeight() != height) {
            if (width <= 0) {
                QLog.e("MosaicEffect", 1, "draw: mosaicWidth <= 0");
                width = 1;
            }
            if (height <= 0) {
                QLog.e("MosaicEffect", 1, "draw: mosaicHeight <= 0");
                height = 1;
            }
            try {
                this.f274799b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (Exception e16) {
                QLog.e("MosaicEffect", 1, "draw: createBitmap failed ", e16);
                try {
                    this.f274799b = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                } catch (Exception e17) {
                    QLog.e("MosaicEffect", 1, "draw: alloc memory failed, do nothing", e17);
                }
            }
        }
        Bitmap bitmap2 = this.f274799b;
        if (bitmap2 == null) {
            QLog.e("MosaicEffect", 1, "draw: Bitmap is NULL");
            return;
        }
        bitmap2.eraseColor(0);
        this.f274804g.setBitmap(this.f274799b);
        this.f274798a.computeScroll();
        int save = this.f274804g.save();
        float f16 = 1.0f / this.f274803f;
        this.f274804g.scale(f16, f16);
        this.f274804g.translate(-this.f274798a.getScrollX(), -this.f274798a.getScrollY());
        this.f274800c = false;
        KeyEvent.Callback callback = this.f274798a;
        if (callback instanceof a) {
            ((a) callback).superDrawMosaic(this.f274804g);
        }
        this.f274804g.restoreToCount(save);
        this.f274804g.setBitmap(null);
        this.f274800c = true;
        KeyEvent.Callback callback2 = this.f274798a;
        if (callback2 instanceof a) {
            ((a) callback2).superDrawMosaic(canvas);
        }
    }

    public void c(Canvas canvas) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        if (this.f274800c) {
            this.f274802e.setFilterBitmap(false);
            if (this.f274799b != null) {
                if (canvas.getClipBounds(this.f274801d)) {
                    if (!canvas.isHardwareAccelerated() && (view = this.f274798a) != null && (view.getWidth() < this.f274801d.width() || this.f274798a.getHeight() < this.f274801d.height())) {
                        this.f274801d.set(0, 0, this.f274798a.getWidth(), this.f274798a.getHeight());
                    }
                    if (f274797h) {
                        this.f274802e.setStyle(Paint.Style.FILL);
                        this.f274802e.setColor(SupportMenu.CATEGORY_MASK);
                        canvas.drawRect(this.f274801d, this.f274802e);
                    }
                    canvas.drawBitmap(this.f274799b, (Rect) null, this.f274801d, this.f274802e);
                    return;
                }
                QLog.e("MosaicEffect", 1, "onDraw: clipBound is empty " + this.f274801d);
                return;
            }
            return;
        }
        KeyEvent.Callback callback = this.f274798a;
        if (callback instanceof a) {
            ((a) callback).superOnDrawMosaic(this.f274804g);
        }
    }

    public void d(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            this.f274798a = view;
        }
    }
}
