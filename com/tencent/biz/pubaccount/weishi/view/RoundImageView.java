package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RoundImageView extends ResizeURLImageView implements Handler.Callback {
    private static final ImageView.ScaleType N = ImageView.ScaleType.CENTER_CROP;
    private static final Bitmap.Config P = Bitmap.Config.ARGB_8888;
    private int C;
    private int D;
    private Bitmap E;
    private BitmapShader F;
    private int G;
    private int H;
    private float I;
    private float J;
    private boolean K;
    private boolean L;
    private Handler M;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f82398d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f82399e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f82400f;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f82401h;

    /* renamed from: i, reason: collision with root package name */
    private final Paint f82402i;

    /* renamed from: m, reason: collision with root package name */
    private int f82403m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        Bitmap f82405a;

        /* renamed from: b, reason: collision with root package name */
        Drawable f82406b;

        a(Bitmap bitmap, Drawable drawable) {
            this.f82405a = bitmap;
            this.f82406b = drawable;
        }
    }

    public RoundImageView(Context context) {
        super(context);
        this.f82398d = new RectF();
        this.f82399e = new RectF();
        this.f82400f = new Matrix();
        this.f82401h = new Paint();
        this.f82402i = new Paint();
        this.f82403m = 0;
        this.C = 0;
        this.D = 0;
        this.M = new Handler(Looper.getMainLooper(), this);
    }

    private void e() {
        if (!this.K) {
            this.L = true;
            return;
        }
        if (this.E == null) {
            return;
        }
        Bitmap bitmap = this.E;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.F = new BitmapShader(bitmap, tileMode, tileMode);
        this.f82401h.setAntiAlias(true);
        this.f82401h.setShader(this.F);
        this.f82402i.setStyle(Paint.Style.STROKE);
        this.f82402i.setAntiAlias(true);
        this.f82402i.setColor(this.f82403m);
        this.f82402i.setStrokeWidth(this.C);
        this.H = this.E.getHeight();
        this.G = this.E.getWidth();
        this.f82399e.set(0.0f, 0.0f, getWidth(), getHeight());
        this.J = Math.min((this.f82399e.height() - this.C) / 2.0f, (this.f82399e.width() - this.C) / 2.0f);
        RectF rectF = this.f82398d;
        int i3 = this.C;
        rectF.set(i3, i3, this.f82399e.width() - this.C, this.f82399e.height() - this.C);
        this.I = Math.min(this.f82398d.height() / 2.0f, this.f82398d.width() / 2.0f) - this.D;
        g();
        invalidate();
    }

    private void f(final Drawable drawable) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.view.RoundImageView.1
            @Override // java.lang.Runnable
            public void run() {
                Bitmap d16 = RoundImageView.this.d(drawable);
                if (d16 == null) {
                    return;
                }
                if (RoundImageView.this.M == null) {
                    RoundImageView.this.M = new Handler(Looper.getMainLooper(), RoundImageView.this);
                }
                Message obtainMessage = RoundImageView.this.M.obtainMessage();
                obtainMessage.what = 101;
                obtainMessage.obj = new a(d16, drawable);
                RoundImageView.this.M.sendMessage(obtainMessage);
            }
        }, 8, null, true);
    }

    private void g() {
        float width;
        float height;
        this.f82400f.set(null);
        float f16 = 0.0f;
        if (this.G * this.f82398d.height() > this.f82398d.width() * this.H) {
            width = this.f82398d.height() / this.H;
            height = 0.0f;
            f16 = (this.f82398d.width() - (this.G * width)) * 0.5f;
        } else {
            width = this.f82398d.width() / this.G;
            height = (this.f82398d.height() - (this.H * width)) * 0.5f;
        }
        this.f82400f.setScale(width, width);
        Matrix matrix = this.f82400f;
        int i3 = this.C;
        matrix.postTranslate(((int) (f16 + 0.5f)) + i3, ((int) (height + 0.5f)) + i3);
        this.F.setLocalMatrix(this.f82400f);
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return N;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.I, this.f82401h);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.J, this.f82402i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        e();
    }

    public void setBorderColor(int i3) {
        if (i3 == this.f82403m) {
            return;
        }
        this.f82403m = i3;
        this.f82402i.setColor(i3);
        invalidate();
    }

    public void setBorderInnerPadding(int i3) {
        if (i3 == this.D) {
            return;
        }
        this.D = i3;
        e();
    }

    public void setBorderWidth(int i3) {
        if (i3 == this.C) {
            return;
        }
        this.C = i3;
        e();
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.E = bitmap;
        e();
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView, com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        f(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        super.setImageResource(i3);
        f(getDrawable());
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != N) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", scaleType));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message != null && message.what == 101) {
            Object obj = message.obj;
            if (obj instanceof a) {
                a aVar = (a) obj;
                Bitmap bitmap = aVar.f82405a;
                Drawable drawable = aVar.f82406b;
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
                this.E = bitmap;
                e();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap d(Drawable drawable) {
        Bitmap bitmap;
        if (drawable == null) {
            return null;
        }
        if ((drawable instanceof BitmapDrawable) && ((bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isMutable())) {
            return bitmap;
        }
        try {
            if (!(drawable instanceof ColorDrawable) && drawable.getIntrinsicWidth() != 0 && drawable.getIntrinsicHeight() != 0) {
                return Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), P);
            }
            return Bitmap.createBitmap(1, 1, P);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82398d = new RectF();
        this.f82399e = new RectF();
        this.f82400f = new Matrix();
        this.f82401h = new Paint();
        this.f82402i = new Paint();
        this.f82403m = 0;
        this.C = 0;
        this.D = 0;
        this.M = new Handler(Looper.getMainLooper(), this);
        super.setScaleType(N);
        this.K = true;
        if (this.L) {
            e();
            this.L = false;
        }
    }
}
