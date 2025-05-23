package com.tencent.mobileqq.filemanager.widget;

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
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import com.tencent.widget.URLThemeImageView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class AsyncImageView extends URLThemeImageView {
    private Path C;
    private float[] D;
    private Xfermode E;
    private int F;
    private Path G;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f209403d;

    /* renamed from: e, reason: collision with root package name */
    private Context f209404e;

    /* renamed from: f, reason: collision with root package name */
    private int f209405f;

    /* renamed from: h, reason: collision with root package name */
    private int f209406h;

    /* renamed from: i, reason: collision with root package name */
    private RectF f209407i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f209408m;

    public AsyncImageView(Context context) {
        this(context, null);
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
            if (QLog.isColorLevel()) {
                QLog.d("SelectPhotoTrace", 2, e16.getMessage(), e16);
            }
            return null;
        }
    }

    public static URL e(String str, int i3, int i16, File file, boolean z16, boolean z17) {
        return d(str, i3, i16, file, z16, z17, false);
    }

    public static URL f(String str) {
        try {
            return new URL(ProtocolDownloaderConstants.PROTOCOL_FILE_GALLERYORIGIMAGE, "", str);
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("SelectPhotoTrace", 2, e16.getMessage(), e16);
            }
            return null;
        }
    }

    private void g() {
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

    private void h(int i3, int i16, int i17, int i18) {
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

    private void i() {
        if (this.f209407i == null) {
            this.f209407i = new RectF();
        }
        this.f209407i.set(0.0f, 0.0f, getWidth(), getHeight());
    }

    public static boolean j(URL url) {
        if (url == null) {
            return false;
        }
        try {
            String protocol2 = url.getProtocol();
            if (protocol2 != null) {
                if (protocol2.equals(ProtocolDownloaderConstants.PROTOCOL_FILE_GALLERYORIGIMAGE)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void k(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
    }

    public void c(Canvas canvas) {
        String str;
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
        if (this.F <= 0) {
            c(canvas);
            return;
        }
        canvas.saveLayer(this.f209407i, null, 31);
        c(canvas);
        this.f209408m.reset();
        this.C.reset();
        this.G.reset();
        this.C.addRoundRect(this.f209407i, this.D, Path.Direction.CCW);
        this.f209408m.setAntiAlias(true);
        this.f209408m.setStyle(Paint.Style.FILL);
        this.f209408m.setXfermode(this.E);
        if (Build.VERSION.SDK_INT <= 26) {
            canvas.drawPath(this.C, this.f209408m);
        } else {
            this.G.addRect(this.f209407i, Path.Direction.CCW);
            this.G.op(this.C, Path.Op.DIFFERENCE);
            canvas.drawPath(this.G, this.f209408m);
        }
        this.f209408m.setXfermode(null);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        i();
    }

    public void setApkIconAsyncImage(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                int width = getWidth();
                int height = getHeight();
                if (width > 0 && height > 0) {
                    this.f209405f = width;
                    this.f209406h = height;
                }
                setAdjustViewBounds(false);
                URL e16 = e(str, this.f209405f, this.f209406h, file, false, true);
                if (e16 != null) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = this.f209405f;
                    obtain.mRequestHeight = this.f209406h;
                    Drawable drawable = this.f209403d;
                    obtain.mLoadingDrawable = drawable;
                    obtain.mFailedDrawable = drawable;
                    obtain.mGifRoundCorner = 12.0f;
                    URLDrawable drawable2 = URLDrawable.getDrawable(e16, obtain);
                    if (drawable2 != null) {
                        setImageDrawable(drawable2);
                        return;
                    } else {
                        k(this.f209403d);
                        return;
                    }
                }
                k(this.f209403d);
                return;
            } catch (Exception unused) {
                k(this.f209403d);
                return;
            }
        }
        k(this.f209403d);
    }

    public void setAsyncClipSize(int i3, int i16) {
        if (i3 > 0) {
            this.f209405f = i3;
        }
        if (i16 > 0) {
            this.f209406h = i16;
        }
    }

    public void setAsyncImage(String str) {
        if (str == null) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            try {
                setAdjustViewBounds(false);
                URL e16 = e(str, this.f209405f, this.f209406h, file, false, false);
                if (e16 == null) {
                    return;
                }
                int i3 = this.f209405f;
                int i16 = this.f209406h;
                Drawable drawable = this.f209403d;
                URLDrawable drawable2 = URLDrawable.getDrawable(e16, i3, i16, drawable, drawable, true);
                if (drawable2 == null) {
                    k(this.f209403d);
                    return;
                } else {
                    setImageDrawable(drawable2);
                    return;
                }
            } catch (Exception unused) {
                k(this.f209403d);
                return;
            }
        }
        k(this.f209403d);
    }

    public void setCornerRadius(int i3) {
        this.F = i3;
        i();
        g();
        invalidate();
    }

    public void setDefaultImage(int i3) {
        Drawable drawable = this.f209404e.getResources().getDrawable(i3);
        this.f209403d = drawable;
        setImageDrawable(drawable);
    }

    public void setHeight(int i3) {
        this.f209406h = i3;
    }

    public void setUrlIconAsyncImage(String str) {
        if (str == null) {
            k(this.f209403d);
            return;
        }
        try {
            URL url = new URL(str);
            int i3 = this.f209405f;
            int i16 = this.f209406h;
            Drawable drawable = this.f209403d;
            URLDrawable drawable2 = URLDrawable.getDrawable(url, i3, i16, drawable, drawable, true);
            if (drawable2 == null) {
                k(this.f209403d);
            } else {
                setImageDrawable(drawable2);
            }
        } catch (Exception unused) {
            k(this.f209403d);
        }
    }

    public void setWidth(int i3) {
        this.f209405f = i3;
    }

    public AsyncImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f209403d = null;
        this.f209405f = 128;
        this.f209406h = 128;
        this.f209404e = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nb1.a.j3);
        this.F = obtainStyledAttributes.getDimensionPixelOffset(nb1.a.k3, 0);
        this.C = new Path();
        if (Build.VERSION.SDK_INT <= 26) {
            this.E = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.E = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        }
        this.themeImageWrapper.setMaskShape(ThemeImageWrapper.MODE_SQURE);
        this.G = new Path();
        this.D = new float[8];
        this.f209408m = new Paint();
        i();
        g();
        obtainStyledAttributes.recycle();
    }

    public void setCornerRadius(int i3, int i16, int i17, int i18) {
        this.F = 1;
        i();
        h(i3, i16, i17, i18);
        invalidate();
    }
}
