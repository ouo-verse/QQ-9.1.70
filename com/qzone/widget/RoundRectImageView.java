package com.qzone.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.widget.util.ImageDownloadDirector;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class RoundRectImageView extends View implements ImageDownloadDirector.a {
    private Rect C;
    private Rect D;
    private ImageDownloadDirector E;

    /* renamed from: d, reason: collision with root package name */
    private int f60663d;

    /* renamed from: e, reason: collision with root package name */
    private int f60664e;

    /* renamed from: f, reason: collision with root package name */
    private int f60665f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f60666h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f60667i;

    /* renamed from: m, reason: collision with root package name */
    private Path f60668m;

    public RoundRectImageView(Context context) {
        super(context);
        b(null, 0, 0);
    }

    private void b(AttributeSet attributeSet, int i3, int i16) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, jj2.b.f410074h7, i3, i16);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f60663d = dimensionPixelSize;
        if (dimensionPixelSize < 0) {
            this.f60663d = 0;
        }
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f60667i = paint;
        paint.setAntiAlias(true);
    }

    private void c() {
        Bitmap bitmap = this.f60666h;
        if (bitmap != null && !bitmap.isRecycled() && this.f60664e != 0 && this.f60665f != 0) {
            int width = this.f60666h.getWidth();
            int height = this.f60666h.getHeight();
            int i3 = this.f60665f;
            int i16 = width * i3;
            int i17 = this.f60664e;
            if (i16 > height * i17) {
                int i18 = (width - ((i17 * height) / i3)) / 2;
                this.C = new Rect(i18, 0, width - i18, height);
                return;
            } else {
                this.C = new Rect(0, 0, width, (i3 * width) / i17);
                return;
            }
        }
        this.C = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.C == null || this.f60666h.isRecycled() || this.f60668m == null) {
            return;
        }
        canvas.save();
        canvas.clipPath(this.f60668m);
        canvas.drawBitmap(this.f60666h, this.C, this.D, this.f60667i);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        int width = getWidth();
        int height = getHeight();
        if (width == this.f60664e && height == this.f60665f) {
            return;
        }
        this.f60664e = width;
        this.f60665f = height;
        Path path = new Path();
        this.f60668m = path;
        int i19 = this.f60663d;
        if (i19 == 0) {
            path.addRect(0.0f, 0.0f, this.f60664e, this.f60665f, Path.Direction.CCW);
        } else {
            int i26 = i19 * 2;
            int i27 = this.f60664e;
            if (i26 > i27) {
                i19 = i27 / 2;
            }
            int i28 = this.f60665f;
            if (i19 > i28) {
                i19 = i28;
            }
            RectF rectF = new RectF(0.0f, 0.0f, width, height + i19);
            float f16 = i19;
            path.addRoundRect(rectF, f16, f16, Path.Direction.CCW);
        }
        this.D = new Rect(0, 0, this.f60664e, this.f60665f);
        c();
    }

    public void setImg(Bitmap bitmap) {
        this.f60666h = bitmap;
        c();
        invalidate();
    }

    public void setUrl(String str) {
        QZLog.i("RoundRectImageView", "setUrl: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImageDownloadDirector imageDownloadDirector = this.E;
        if (imageDownloadDirector == null || !imageDownloadDirector.h().equals(str)) {
            if (this.f60666h != null) {
                this.f60666h = null;
                this.C = null;
            }
            ImageDownloadDirector imageDownloadDirector2 = new ImageDownloadDirector(getContext(), str, 1, this);
            this.E = imageDownloadDirector2;
            imageDownloadDirector2.j();
            invalidate();
        }
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet, 0, 0);
    }

    @Override // com.qzone.widget.util.ImageDownloadDirector.a
    public void a(String str, Bitmap bitmap) {
        ImageDownloadDirector imageDownloadDirector;
        if (bitmap == null || (imageDownloadDirector = this.E) == null || !imageDownloadDirector.h().equals(str)) {
            return;
        }
        setImg(bitmap);
    }

    public RoundRectImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(attributeSet, i3, 0);
    }
}
