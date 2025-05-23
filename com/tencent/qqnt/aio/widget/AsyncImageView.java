package com.tencent.qqnt.aio.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.URLThemeImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AsyncImageView extends URLThemeImageView {
    static IPatchRedirector $redirector_;
    private Path C;
    private float[] D;
    private Xfermode E;
    private int F;
    private Path G;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f352347d;

    /* renamed from: e, reason: collision with root package name */
    private Context f352348e;

    /* renamed from: f, reason: collision with root package name */
    private int f352349f;

    /* renamed from: h, reason: collision with root package name */
    private int f352350h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f352351i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f352352m;

    public AsyncImageView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public static URL d(String str, int i3, int i16, File file, boolean z16, boolean z17, boolean z18) {
        long j3;
        String str2;
        String str3;
        String str4;
        if (file != null) {
            j3 = file.lastModified();
        } else {
            j3 = 0;
        }
        String str5 = str + "|" + i3 + "|" + i16 + "|" + j3 + "|1";
        if (z16) {
            str2 = str5 + "|1";
        } else {
            str2 = str5 + "|0";
        }
        if (z17) {
            str3 = str2 + "|1";
        } else {
            str3 = str2 + "|0";
        }
        if (z18) {
            str4 = str3 + "|1";
        } else {
            str4 = str3 + "|0";
        }
        try {
            return new URL(ProtocolDownloaderConstants.PROTOCOL_FILE_ASSISTANT_IMAGE, "", str4);
        } catch (MalformedURLException e16) {
            QLog.d("AsyncImageView", 4, e16.getMessage(), e16);
            return null;
        }
    }

    public static URL e(String str, int i3, int i16, File file, boolean z16, boolean z17) {
        return d(str, i3, i16, file, z16, z17, false);
    }

    private void f() {
        if (this.F > 0) {
            int i3 = 0;
            while (true) {
                float[] fArr = this.D;
                if (i3 < fArr.length) {
                    fArr[i3] = this.F / 2.0f;
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void g(int i3, int i16, int i17, int i18) {
        float[] fArr = this.D;
        float f16 = i3 / 2.0f;
        fArr[0] = f16;
        fArr[1] = f16;
        float f17 = i16 / 2.0f;
        fArr[2] = f17;
        fArr[3] = f17;
        float f18 = i17 / 2.0f;
        fArr[4] = f18;
        fArr[5] = f18;
        float f19 = i18 / 2.0f;
        fArr[6] = f19;
        fArr[7] = f19;
    }

    private void h() {
        if (this.f352351i == null) {
            this.f352351i = new RectF();
        }
        this.f352351i.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    private void i(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
    }

    public void c(Canvas canvas) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) canvas);
            return;
        }
        try {
            super.onDraw(canvas);
        } catch (RuntimeException e16) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                Rect bounds = drawable.getBounds();
                if (getId() != 0) {
                    str = getResources().getResourceEntryName(getId());
                } else {
                    str = "unknown";
                }
                QLog.i("URLThemeImageView", 1, "rect = " + bounds + ", entryName = " + str + ", err : ", e16);
                return;
            }
            throw new RuntimeException(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.widget.URLThemeImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) canvas);
            return;
        }
        if (this.F <= 0) {
            c(canvas);
            return;
        }
        canvas.saveLayer(this.f352351i, null, 31);
        c(canvas);
        this.f352352m.reset();
        this.C.reset();
        this.G.reset();
        this.C.addRoundRect(this.f352351i, this.D, Path.Direction.CCW);
        this.f352352m.setAntiAlias(true);
        this.f352352m.setStyle(Paint.Style.FILL);
        this.f352352m.setXfermode(this.E);
        if (Build.VERSION.SDK_INT <= 26) {
            canvas.drawPath(this.C, this.f352352m);
        } else {
            this.G.addRect(this.f352351i, Path.Direction.CCW);
            this.G.op(this.C, Path.Op.DIFFERENCE);
            canvas.drawPath(this.G, this.f352352m);
        }
        this.f352352m.setXfermode(null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            super.onSizeChanged(i3, i16, i17, i18);
            h();
        }
    }

    public void setApkIconAsyncImage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                int width = getWidth();
                int height = getHeight();
                if (width > 0 && height > 0) {
                    this.f352349f = width;
                    this.f352350h = height;
                }
                setAdjustViewBounds(false);
                URL e16 = e(str, this.f352349f, this.f352350h, file, false, true);
                if (e16 != null) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = this.f352349f;
                    obtain.mRequestHeight = this.f352350h;
                    Drawable drawable = this.f352347d;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    obtain.mGifRoundCorner = 12.0f;
                    URLDrawable drawable2 = URLDrawable.getDrawable(e16, obtain);
                    if (drawable2 != null) {
                        setImageDrawable(drawable2);
                        return;
                    } else {
                        i(this.f352347d);
                        return;
                    }
                }
                i(this.f352347d);
                return;
            } catch (Exception unused) {
                i(this.f352347d);
                return;
            }
        }
        i(this.f352347d);
    }

    public void setAsyncClipSize(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i3 > 0) {
            this.f352349f = i3;
        }
        if (i16 > 0) {
            this.f352350h = i16;
        }
    }

    public void setAsyncImage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                setAdjustViewBounds(false);
                URL e16 = e(str, this.f352349f, this.f352350h, file, false, false);
                if (e16 == null) {
                    return;
                }
                int i3 = this.f352349f;
                int i16 = this.f352350h;
                Drawable drawable = this.f352347d;
                URLDrawable drawable2 = URLDrawable.getDrawable(e16, i3, i16, drawable, drawable, true);
                if (drawable2 == null) {
                    i(this.f352347d);
                    return;
                } else {
                    setImageDrawable(drawable2);
                    return;
                }
            } catch (Exception unused) {
                i(this.f352347d);
                return;
            }
        }
        i(this.f352347d);
    }

    public void setCornerRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        this.F = i3;
        h();
        f();
        invalidate();
    }

    public void setDefaultImage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        Drawable drawable = this.f352348e.getResources().getDrawable(i3);
        this.f352347d = drawable;
        setImageDrawable(drawable);
    }

    public void setHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f352350h = i3;
        }
    }

    public void setUrlIconAsyncImage(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if (str == null) {
            i(this.f352347d);
            return;
        }
        try {
            URL url = new URL(str);
            int i3 = this.f352349f;
            int i16 = this.f352350h;
            Drawable drawable = this.f352347d;
            URLDrawable drawable2 = URLDrawable.getDrawable(url, i3, i16, drawable, drawable, true);
            if (drawable2 == null) {
                i(this.f352347d);
            } else {
                setImageDrawable(drawable2);
            }
        } catch (Exception unused) {
            i(this.f352347d);
        }
    }

    public void setWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f352349f = i3;
        }
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f352347d = null;
        this.f352349f = 128;
        this.f352350h = 128;
        this.f352348e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.Z6);
        this.F = obtainStyledAttributes.getDimensionPixelOffset(jj2.b.f409990a7, 0);
        this.C = new Path();
        if (Build.VERSION.SDK_INT <= 26) {
            this.E = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.E = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        }
        this.themeImageWrapper.setMaskShape(ThemeImageWrapper.MODE_SQURE);
        this.G = new Path();
        this.D = new float[8];
        this.f352352m = new Paint();
        h();
        f();
        obtainStyledAttributes.recycle();
    }

    public void setCornerRadius(int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.F = 1;
        h();
        g(i3, i16, i17, i18);
        invalidate();
    }
}
