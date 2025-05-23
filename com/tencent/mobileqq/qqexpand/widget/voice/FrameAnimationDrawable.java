package com.tencent.mobileqq.qqexpand.widget.voice;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqexpand.utils.e;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@Deprecated
/* loaded from: classes16.dex */
public class FrameAnimationDrawable extends Drawable implements Handler.Callback {
    private boolean C;
    private int D;
    private int E;
    private long F;
    private volatile boolean G;

    /* renamed from: d, reason: collision with root package name */
    private final Paint f264292d;

    /* renamed from: e, reason: collision with root package name */
    private final Handler f264293e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f264294f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f264295h;

    /* renamed from: i, reason: collision with root package name */
    private String[] f264296i;

    /* renamed from: m, reason: collision with root package name */
    private long f264297m = 1000;

    public FrameAnimationDrawable() {
        Paint paint = new Paint(1);
        this.f264292d = paint;
        paint.setAntiAlias(true);
        this.f264293e = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
    }

    private void f() {
        int i3 = this.D;
        if (i3 >= 0 && i3 < this.E) {
            String str = this.f264296i[i3];
            if (!TextUtils.isEmpty(str)) {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    Bitmap a16 = e.a(str, options);
                    if (a16 != null && !a16.isRecycled()) {
                        this.f264294f = a16;
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.widget.voice.FrameAnimationDrawable.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FrameAnimationDrawable.this.invalidateSelf();
                            }
                        });
                    }
                } catch (Exception e16) {
                    QLog.e("FrameAnimationDrawable", 2, "updateCurBitmap fail.", e16);
                }
            }
        }
    }

    public void a(long j3) {
        int length;
        long j16;
        this.f264297m = j3;
        String[] strArr = this.f264296i;
        if (strArr == null) {
            length = 0;
        } else {
            length = strArr.length;
        }
        this.E = length;
        if (length == 0) {
            j16 = 0;
        } else {
            j16 = j3 / length;
        }
        this.F = j16;
    }

    public void b(String[] strArr) {
        long j3;
        e();
        this.f264296i = strArr;
        int i3 = 0;
        this.D = 0;
        if (strArr != null) {
            i3 = strArr.length;
        }
        this.E = i3;
        if (i3 == 0) {
            j3 = 0;
        } else {
            j3 = this.f264297m / i3;
        }
        this.F = j3;
        f();
    }

    public void c(boolean z16) {
        this.C = z16;
    }

    public void d() {
        if (!this.G) {
            this.G = true;
            this.f264293e.removeMessages(10);
            this.f264293e.sendEmptyMessage(10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (canvas != null && (bitmap = this.f264294f) != null && !bitmap.isRecycled()) {
            if (this.f264295h == null) {
                this.f264295h = new Rect();
            }
            this.f264295h.set(0, 0, this.f264294f.getWidth(), this.f264294f.getHeight());
            canvas.drawBitmap(this.f264294f, this.f264295h, getBounds(), this.f264292d);
        }
    }

    public void e() {
        if (this.G) {
            this.G = false;
            this.f264293e.removeMessages(10);
            this.D = 0;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 10) {
            int i3 = this.D + 1;
            this.D = i3;
            if (this.C) {
                this.D = i3 % this.E;
            }
            int i16 = this.D;
            if (i16 >= 0 && i16 < this.E) {
                long currentTimeMillis = System.currentTimeMillis();
                f();
                if (this.G) {
                    this.f264293e.sendEmptyMessageDelayed(10, Math.max(this.F - (System.currentTimeMillis() - currentTimeMillis), 0L));
                }
            } else {
                this.G = false;
            }
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.f264292d.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f264292d.setColorFilter(colorFilter);
    }
}
