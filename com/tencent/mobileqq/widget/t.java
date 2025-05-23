package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class t {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f317502h = false;

    /* renamed from: a, reason: collision with root package name */
    private View f317503a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f317504b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f317505c;

    /* renamed from: f, reason: collision with root package name */
    private int f317508f;

    /* renamed from: d, reason: collision with root package name */
    private Rect f317506d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private Paint f317507e = new Paint(5);

    /* renamed from: g, reason: collision with root package name */
    private Canvas f317509g = new Canvas();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void setMosaicEffect(t tVar);

        void superDrawMosaic(Canvas canvas);

        void superOnDrawMosaic(Canvas canvas);
    }

    public t(int i3) {
        this.f317508f = 10;
        this.f317508f = i3;
    }

    public void a(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        int width = this.f317503a.getWidth() / this.f317508f;
        int height = this.f317503a.getHeight() / this.f317508f;
        Bitmap bitmap = this.f317504b;
        if (bitmap == null || bitmap.getWidth() != width || this.f317504b.getHeight() != height) {
            if (QLog.isColorLevel()) {
                QLog.i("MosaicEffect", 2, "draw: try to alloc bitmap w x h=[" + width + HippyTKDListViewAdapter.X + height + "]");
            }
            if (width <= 0) {
                QLog.e("MosaicEffect", 1, "draw: mosaicWidth <= 0");
                width = 1;
            }
            if (height <= 0) {
                QLog.e("MosaicEffect", 1, "draw: mosaicHeight <= 0");
                height = 1;
            }
            try {
                this.f317504b = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            } catch (Exception e16) {
                QLog.e("MosaicEffect", 1, "draw: createBitmap failed ", e16);
                try {
                    this.f317504b = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
                } catch (Exception e17) {
                    QLog.e("MosaicEffect", 1, "draw: alloc memory failed, do nothing", e17);
                }
            }
        }
        Bitmap bitmap2 = this.f317504b;
        if (bitmap2 == null) {
            QLog.e("MosaicEffect", 1, "draw: Bitmap is NULL");
            return;
        }
        bitmap2.eraseColor(0);
        this.f317509g.setBitmap(this.f317504b);
        this.f317503a.computeScroll();
        int save = this.f317509g.save();
        float f16 = 1.0f / this.f317508f;
        this.f317509g.scale(f16, f16);
        this.f317509g.translate(-this.f317503a.getScrollX(), -this.f317503a.getScrollY());
        this.f317505c = false;
        KeyEvent.Callback callback = this.f317503a;
        if (callback instanceof a) {
            ((a) callback).superDrawMosaic(this.f317509g);
        }
        this.f317509g.restoreToCount(save);
        this.f317509g.setBitmap(null);
        this.f317505c = true;
        KeyEvent.Callback callback2 = this.f317503a;
        if (callback2 instanceof a) {
            ((a) callback2).superDrawMosaic(canvas);
        }
        if (QLog.isColorLevel()) {
            QLog.i("MosaicEffect", 2, "draw: " + (SystemClock.uptimeMillis() - uptimeMillis) + " ms");
        }
    }

    public void b(Canvas canvas) {
        View view;
        if (this.f317505c) {
            this.f317507e.setFilterBitmap(false);
            if (this.f317504b != null) {
                if (canvas.getClipBounds(this.f317506d)) {
                    if (!canvas.isHardwareAccelerated() && (view = this.f317503a) != null && (view.getWidth() < this.f317506d.width() || this.f317503a.getHeight() < this.f317506d.height())) {
                        this.f317506d.set(0, 0, this.f317503a.getWidth(), this.f317503a.getHeight());
                    }
                    if (f317502h) {
                        this.f317507e.setStyle(Paint.Style.FILL);
                        this.f317507e.setColor(SupportMenu.CATEGORY_MASK);
                        canvas.drawRect(this.f317506d, this.f317507e);
                    }
                    canvas.drawBitmap(this.f317504b, (Rect) null, this.f317506d, this.f317507e);
                    return;
                }
                QLog.e("MosaicEffect", 1, "onDraw: clipBound is empty " + this.f317506d);
                return;
            }
            return;
        }
        KeyEvent.Callback callback = this.f317503a;
        if (callback instanceof a) {
            ((a) callback).superOnDrawMosaic(this.f317509g);
        }
    }

    public void c(View view) {
        this.f317503a = view;
    }
}
