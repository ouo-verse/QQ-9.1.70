package com.qzone.proxy.feedcomponent.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.SparseArray;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends Paint {

    /* renamed from: e, reason: collision with root package name */
    private static int f50705e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static SoftReference<SparseArray<Bitmap>> f50706f;

    /* renamed from: g, reason: collision with root package name */
    private static int[] f50707g;

    /* renamed from: h, reason: collision with root package name */
    private static Canvas f50708h;

    /* renamed from: a, reason: collision with root package name */
    private IETFont f50709a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f50710b;

    /* renamed from: c, reason: collision with root package name */
    private Paint.FontMetrics f50711c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f50712d;

    public d() {
        this(0);
    }

    private boolean a() {
        IETFont iETFont = this.f50709a;
        if (iETFont == null || TextUtils.isEmpty(iETFont.getPath())) {
            return false;
        }
        if (e.f().b().nativeIsFontLoaded(this.f50709a.getId())) {
            return true;
        }
        return e.f().b().nativeLoadFont(this.f50709a.getPath(), this.f50709a.getId(), true);
    }

    private void b(Paint paint) {
        setTextSize(paint.getTextSize());
        setColor(paint.getColor());
        setFakeBoldText(paint.isFakeBoldText());
    }

    private synchronized Bitmap d(int i3) {
        Bitmap bitmap;
        if (f50706f == null) {
            f50706f = new SoftReference<>(new SparseArray(5));
        }
        SparseArray<Bitmap> sparseArray = f50706f.get();
        if (sparseArray == null) {
            sparseArray = new SparseArray<>(5);
            f50706f = new SoftReference<>(sparseArray);
        }
        bitmap = sparseArray.get(i3);
        if (bitmap == null) {
            try {
                bitmap = Bitmap.createBitmap(u5.a.d(), i3, Bitmap.Config.ARGB_8888);
                sparseArray.put(i3, bitmap);
            } catch (OutOfMemoryError e16) {
                e16.printStackTrace();
                return null;
            }
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    private boolean h() {
        return !TextUtils.isEmpty(this.f50709a.getPath());
    }

    @Override // android.graphics.Paint
    public float ascent() {
        Paint.FontMetrics fontMetrics;
        if (h() && (fontMetrics = this.f50711c) != null) {
            return fontMetrics.ascent;
        }
        return super.ascent();
    }

    @Override // android.graphics.Paint
    public float descent() {
        Paint.FontMetrics fontMetrics;
        if (h() && (fontMetrics = this.f50711c) != null) {
            return fontMetrics.descent;
        }
        return super.descent();
    }

    public Paint e() {
        return this.f50710b;
    }

    public IETFont f() {
        return this.f50709a;
    }

    public String g() {
        return this.f50709a.getPath();
    }

    @Override // android.graphics.Paint
    public Paint.FontMetrics getFontMetrics() {
        Paint.FontMetrics fontMetrics = this.f50711c;
        return fontMetrics == null ? super.getFontMetrics() : fontMetrics;
    }

    @Override // android.graphics.Paint
    public int getTextWidths(String str, int i3, int i16, float[] fArr) {
        if (!h()) {
            return super.getTextWidths(str, i3, i16, fArr);
        }
        if (str != null) {
            int i17 = i16 - i3;
            if ((i3 | i16 | i17 | (str.length() - i16)) >= 0) {
                if (i17 <= fArr.length) {
                    if (str.length() == 0 || i3 == i16) {
                        return 0;
                    }
                    e f16 = e.f();
                    IETFont iETFont = this.f50709a;
                    return f16.g(str, i3, i16, iETFont, this.f50710b, fArr, iETFont.getFontType() == 4);
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("text cannot be null");
    }

    public boolean i() {
        return this.f50709a.getFontType() == 4;
    }

    public boolean j(int i3, String str, Paint paint, int i16) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        this.f50709a.setId(i3);
        this.f50709a.setPath(str);
        this.f50709a.setFontType(i16);
        if (this.f50710b == null) {
            this.f50710b = paint;
        }
        b(paint);
        if (!h()) {
            return true;
        }
        if (f50705e <= 0) {
            int dimensionPixelSize = BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.f158273bz);
            f50705e = Math.max(dimensionPixelSize * dimensionPixelSize * 240 * 8, 1048576);
        }
        if (!e.f().h(8, f50705e)) {
            return false;
        }
        if ((i16 == 4 && !e.f().j()) || e.f().b() == null || !a()) {
            return false;
        }
        this.f50711c = e.f().e(this.f50709a);
        return true;
    }

    @Override // android.graphics.Paint
    public float measureText(String str) {
        return measureText(str, 0, str.length());
    }

    @Override // android.graphics.Paint
    public void setColor(int i3) {
        super.setColor(i3);
        this.f50709a.setColor(i3);
        Paint paint = this.f50710b;
        if (paint != null) {
            paint.setColor(i3);
        }
    }

    @Override // android.graphics.Paint
    public void setFakeBoldText(boolean z16) {
        super.setFakeBoldText(z16);
        Paint paint = this.f50710b;
        if (paint != null) {
            paint.setFakeBoldText(z16);
        }
        this.f50709a.setBold(z16);
        this.f50711c = e.f().e(this.f50709a);
    }

    @Override // android.graphics.Paint
    public void setTextSize(float f16) {
        super.setTextSize(f16);
        this.f50709a.setSize(f16);
        Paint paint = this.f50710b;
        if (paint != null) {
            paint.setTextSize(f16);
        }
        this.f50711c = e.f().e(this.f50709a);
    }

    public d(int i3) {
        super(i3);
        this.f50709a = ((IETFontService) QRoute.api(IETFontService.class)).createETFont(0, null, 0.0f);
        this.f50712d = true;
    }

    @Override // android.graphics.Paint
    public float measureText(String str, int i3, int i16) {
        if (!h()) {
            return super.measureText(str, i3, i16);
        }
        if (str != null) {
            if ((i3 | i16 | (i16 - i3) | (str.length() - i16)) >= 0) {
                if (str.length() == 0 || i3 == i16) {
                    return 0.0f;
                }
                return e.f().m(str, i3, i16, this.f50709a, this.f50710b);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("text cannot be null");
    }

    public void c(String str, int i3, float f16, float f17, Canvas canvas, Bitmap bitmap) {
        if (this.f50712d) {
            if (i()) {
                IETEngine d16 = e.f().d();
                if (d16 != null && a()) {
                    if (bitmap != null && !bitmap.isRecycled()) {
                        d16.nativeSpaceDrawText(str, canvas, bitmap, (int) f16, (int) f17, this.f50709a, this.f50710b);
                        return;
                    }
                    int nativeSpaceMeasureText = d16.nativeSpaceMeasureText(str, 0, str.length(), this.f50709a, null);
                    if (nativeSpaceMeasureText > 0 && i3 > 0) {
                        Bitmap createBitmap = Bitmap.createBitmap(nativeSpaceMeasureText, i3, Bitmap.Config.ARGB_8888);
                        createBitmap.eraseColor(0);
                        if (f50708h == null) {
                            f50708h = new Canvas();
                        }
                        f50708h.setBitmap(createBitmap);
                        d16.nativeSpaceDrawText(str, f50708h, createBitmap, 0, 0, this.f50709a, this.f50710b);
                        canvas.drawBitmap(createBitmap, f16, f17, (Paint) null);
                        createBitmap.recycle();
                        return;
                    }
                    QLog.w("ETPaint", 1, "width or height is zero, w:" + nativeSpaceMeasureText + " h:" + i3);
                    return;
                }
                canvas.drawText(str, f16, f17 - ascent(), this.f50710b);
                return;
            }
            if (bitmap == null) {
                Bitmap d17 = d(i3);
                if (d17 != null && e.f().b() != null && a()) {
                    if (f50708h == null) {
                        f50708h = new Canvas();
                    }
                    f50708h.setBitmap(d17);
                    e.f().b().nativeSpaceDrawText(str, f50708h, d17, 0, 0, this.f50709a, this.f50710b);
                    int width = d17.getWidth();
                    int height = d17.getHeight();
                    int i16 = width * height;
                    int[] iArr = f50707g;
                    if (iArr == null || iArr.length < i16) {
                        try {
                            f50707g = new int[i16];
                        } catch (OutOfMemoryError e16) {
                            e16.printStackTrace();
                            canvas.drawText(str, f16, f17 - ascent(), this.f50710b);
                            return;
                        }
                    }
                    d17.getPixels(f50707g, 0, width, 0, 0, width, height);
                    canvas.drawBitmap(f50707g, 0, width, f16, f17, width, height, true, this.f50710b);
                    return;
                }
                canvas.drawText(str, f16, f17 - ascent(), this.f50710b);
                return;
            }
            if (e.f().b() != null && a()) {
                e.f().b().nativeSpaceDrawText(str, canvas, bitmap, (int) f16, (int) f17, this.f50709a, this.f50710b);
            } else {
                canvas.drawText(str, f16, f17 - ascent(), this.f50710b);
            }
        }
    }
}
