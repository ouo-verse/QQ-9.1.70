package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.theme.SkinnableBitmapDrawable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleRoundImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private Paint f93138d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f93139e;

    /* renamed from: f, reason: collision with root package name */
    private BitmapShader f93140f;

    /* renamed from: h, reason: collision with root package name */
    private int f93141h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f93142i;

    /* renamed from: m, reason: collision with root package name */
    private RectF f93143m;

    public QCircleRoundImageView(Context context) {
        this(context, null);
    }

    private void c() {
        this.f93140f = null;
    }

    private Bitmap d(Drawable drawable) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof SkinnableBitmapDrawable) {
            return ((SkinnableBitmapDrawable) drawable).getBitmap();
        }
        if (drawable.getIntrinsicWidth() <= 0) {
            intrinsicWidth = getWidth();
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() <= 0) {
            intrinsicHeight = getHeight();
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i3, Object obj) {
        super.setTag(i3, obj);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        if (getDrawable() == null) {
            return;
        }
        Bitmap bitmap = this.f93142i;
        float f18 = 1.0f;
        if (bitmap != null && (bitmap.getWidth() != getWidth() || this.f93142i.getHeight() != getHeight())) {
            float max = Math.max((getWidth() * 1.0f) / this.f93142i.getWidth(), (getHeight() * 1.0f) / this.f93142i.getHeight());
            f16 = ((getWidth() * 1.0f) - (this.f93142i.getWidth() * max)) / 2.0f;
            f17 = ((getHeight() * 1.0f) - (this.f93142i.getHeight() * max)) / 2.0f;
            f18 = max;
        } else {
            f16 = 0.0f;
            f17 = 0.0f;
        }
        this.f93139e.setScale(f18, f18);
        this.f93139e.postTranslate(f16, f17);
        BitmapShader bitmapShader = this.f93140f;
        if (bitmapShader != null) {
            bitmapShader.setLocalMatrix(this.f93139e);
            this.f93138d.setShader(this.f93140f);
        }
        try {
            RectF rectF = this.f93143m;
            int i3 = this.f93141h;
            canvas.drawRoundRect(rectF, i3, i3, this.f93138d);
        } catch (Exception e16) {
            RFWLog.e("QCircleRoundImageView", RFWLog.USR, e16);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        this.f93143m.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (drawable != null && drawable != getDrawable()) {
            Bitmap d16 = d(drawable);
            this.f93142i = d16;
            if (d16 != null) {
                Bitmap bitmap = this.f93142i;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.f93140f = new BitmapShader(bitmap, tileMode, tileMode);
            }
        }
        if (drawable == null) {
            c();
        }
        super.setImageDrawable(drawable);
    }

    public void setRoundRect(int i3) {
        if (i3 <= 0) {
            i3 = 0;
        }
        this.f93141h = i3;
        invalidate();
    }

    @Override // android.view.View
    public void setTag(final int i3, final Object obj) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                super.setTag(i3, obj);
                return;
            }
            if (RFWApplication.isDebug()) {
                RFWLog.w("QCircleRoundImageView", RFWLog.USR, "[setTag] in subThread error");
            }
            post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.v
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleRoundImageView.this.e(i3, obj);
                }
            });
        } catch (Exception e16) {
            RFWLog.e("QCircleRoundImageView", RFWLog.USR, "[setTag] ", e16);
        }
    }

    public QCircleRoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QCircleRoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93141h = 90;
        this.f93143m = new RectF();
        this.f93139e = new Matrix();
        Paint paint = new Paint();
        this.f93138d = paint;
        paint.setAntiAlias(true);
    }
}
