package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;

/* compiled from: P */
/* loaded from: classes20.dex */
public class CircleBubbleImageView extends ChatThumbView {
    protected BitmapShader C;
    protected Bitmap D;
    protected Canvas E;
    protected Paint F;
    protected Path G;
    protected Path H;
    protected int I;
    protected int J;
    protected Resources K;
    public boolean L;
    public boolean M;
    protected boolean N;
    protected boolean P;
    protected int Q;

    /* renamed from: h, reason: collision with root package name */
    protected Paint f315481h;

    /* renamed from: i, reason: collision with root package name */
    protected Bitmap f315482i;

    /* renamed from: m, reason: collision with root package name */
    protected Canvas f315483m;

    public CircleBubbleImageView(Context context) {
        super(context);
        this.M = true;
        this.N = false;
        this.P = false;
        this.Q = 1610612736;
        init();
    }

    private void d(Canvas canvas) {
        Path path;
        Path path2;
        Resources resources = this.K;
        int i3 = this.I / 2;
        if (this.L) {
            Path path3 = this.G;
            if (path3 != null) {
                path3.reset();
                path3.moveTo(r1 - c(23.0f, resources), c(26.0f, resources));
                path3.quadTo(r1 - c(13.0f, resources), c(28.0f, resources), r1 - c(9.0f, resources), c(23.0f, resources));
                path3.quadTo(r1 - c(10.0f, resources), c(32.0f, resources), r1 - c(19.0f, resources), c(34.0f, resources));
                path3.close();
                this.G = path3;
            }
        } else {
            Path path4 = this.H;
            if (path4 != null) {
                path4.reset();
                path4.moveTo(c(23.0f, resources), c(26.0f, resources));
                path4.quadTo(c(13.0f, resources), c(28.0f, resources), c(9.0f, resources), c(23.0f, resources));
                path4.quadTo(c(10.0f, resources), c(32.0f, resources), c(19.0f, resources), c(34.0f, resources));
                path4.close();
                this.H = path4;
            }
        }
        if (this.L) {
            float f16 = i3;
            canvas.drawCircle(f16, f16, f16, this.f315481h);
            if (this.M && (path2 = this.G) != null) {
                canvas.drawPath(path2, this.f315481h);
                return;
            }
            return;
        }
        float f17 = i3;
        canvas.drawCircle(f17, f17, f17, this.f315481h);
        if (this.M && (path = this.H) != null) {
            canvas.drawPath(path, this.f315481h);
        }
    }

    private void init() {
        this.K = getResources();
        Paint paint = new Paint();
        this.f315481h = paint;
        paint.setAntiAlias(true);
        this.f315481h.setFilterBitmap(true);
        this.f315481h.setStyle(Paint.Style.FILL);
        this.G = new Path();
        this.H = new Path();
    }

    public int c(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.I = getWidth();
        int height = getHeight();
        this.J = height;
        int i3 = this.I;
        if (i3 > 0 && height > 0) {
            if (this.f315482i == null) {
                try {
                    try {
                        this.f315482i = Bitmap.createBitmap(i3, height, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        this.f315482i = Bitmap.createBitmap(this.I, this.J, Bitmap.Config.ARGB_4444);
                    }
                } catch (OutOfMemoryError unused2) {
                    URLDrawable.clearMemoryCache();
                    try {
                        this.f315482i = Bitmap.createBitmap(this.I, this.J, Bitmap.Config.ARGB_4444);
                    } catch (OutOfMemoryError unused3) {
                    }
                }
                Canvas canvas2 = this.f315483m;
                if (canvas2 != null) {
                    canvas2.setBitmap(this.f315482i);
                }
            }
            if (this.f315482i == null) {
                super.draw(canvas);
                return;
            }
            if (this.f315483m == null) {
                Canvas canvas3 = new Canvas(this.f315482i);
                this.f315483m = canvas3;
                canvas3.setBitmap(this.f315482i);
            }
            if (this.C == null) {
                Bitmap bitmap = this.f315482i;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                this.C = bitmapShader;
                this.f315481h.setShader(bitmapShader);
            }
            this.f315482i.eraseColor(ITVKAsset.VOD_ASSET_MASK_BIT);
            super.draw(this.f315483m);
            if (this.P) {
                this.f315483m.drawColor(this.Q);
            }
            if (this.N && this.D == null) {
                try {
                    this.D = Bitmap.createBitmap(this.I, this.J, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused4) {
                }
                Canvas canvas4 = this.E;
                if (canvas4 != null) {
                    canvas4.setBitmap(this.D);
                }
            }
            if (this.N && this.D != null) {
                if (this.E == null) {
                    this.E = new Canvas(this.D);
                }
                this.D.eraseColor(0);
                d(this.E);
                canvas.drawBitmap(this.D, 0.0f, 0.0f, this.F);
                return;
            }
            d(canvas);
            return;
        }
        super.draw(canvas);
    }

    public void setColorMask(int i3) {
        this.Q = i3;
    }

    @Override // com.tencent.image.URLImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable == getDrawable()) {
            super.setImageDrawable(null);
        }
        super.setImageDrawable(drawable);
    }
}
