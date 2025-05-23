package com.qzone.component.banner;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

/* loaded from: classes39.dex */
public class PassiveFeedBubbleBannerBg extends LinearLayout {
    private static int M = ar.e(8.0f);
    private static int N = ar.e(7.0f);
    private static int P = ar.e(27.0f);
    private static int Q = ar.e(22.5f);
    private int C;
    private Bitmap D;
    private Drawable E;
    private Drawable F;
    private int G;
    private Paint H;
    private PorterDuffXfermode I;
    private Scroller J;
    private Scroller K;
    private Handler L;

    /* renamed from: d, reason: collision with root package name */
    private boolean f46446d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f46447e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f46448f;

    /* renamed from: h, reason: collision with root package name */
    private String f46449h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f46450i;

    /* renamed from: m, reason: collision with root package name */
    private Drawable f46451m;

    /* loaded from: classes39.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                PassiveFeedBubbleBannerBg.this.L.removeCallbacksAndMessages(null);
                PassiveFeedBubbleBannerBg.this.L.sendEmptyMessageDelayed(2, 200L);
            } else if (i3 == 2) {
                PassiveFeedBubbleBannerBg.this.L.removeCallbacksAndMessages(null);
                PassiveFeedBubbleBannerBg.this.y();
            } else if (i3 == 4) {
                PassiveFeedBubbleBannerBg.this.L.removeCallbacksAndMessages(null);
                PassiveFeedBubbleBannerBg.this.x();
            }
            super.handleMessage(message);
        }
    }

    public PassiveFeedBubbleBannerBg(Context context) {
        super(context);
        this.f46446d = false;
        this.f46447e = false;
        this.f46448f = false;
        this.C = -1;
        this.G = 0;
        this.L = new a(Looper.getMainLooper());
        u();
    }

    private void A() {
        if (this.J.isFinished()) {
            this.G = 0;
            this.L.sendEmptyMessageDelayed(4, 800L);
        }
        invalidate();
    }

    private float r(float f16) {
        double d16;
        double d17;
        double d18 = f16;
        if (d18 < 0.2857142857142857d) {
            d17 = 0.5d;
            d16 = (d18 / 0.2857142857142857d) * 0.5d;
        } else {
            d16 = (-f16) / 0.7142857142857143d;
            d17 = 1.4d;
        }
        return (float) (d16 + d17);
    }

    private float s(float f16) {
        double d16;
        double d17;
        double d18 = f16;
        if (d18 < 0.5714285714285714d) {
            d16 = (d18 / 0.5714285714285714d) * 0.8d;
            d17 = 0.2d;
        } else {
            d16 = (-f16) / 0.42857142857142855d;
            d17 = 2.3333333333333335d;
        }
        return (float) (d16 + d17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t() {
        return R.drawable.leq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        if (this.G == 2) {
            return;
        }
        this.G = 2;
        if (this.K == null) {
            this.K = new Scroller(getContext(), new LinearInterpolator());
        }
        this.K.forceFinished(true);
        this.K.startScroll(0, 0, getWidth(), 0, 360);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.G == 1) {
            return;
        }
        this.G = 1;
        if (this.J == null) {
            this.J = new Scroller(getContext(), new LinearInterpolator());
        }
        this.J.forceFinished(true);
        this.J.startScroll(0, 0, getWidth(), 0, 360);
        invalidate();
    }

    private void z() {
        if (this.K.isFinished()) {
            this.G = 0;
            this.L.sendEmptyMessageDelayed(1, 1300L);
        }
        invalidate();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f46446d) {
            canvas.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), 255);
            Drawable drawable = this.f46450i;
            if (drawable != null) {
                drawable.setBounds(M, N, getWidth(), getHeight() - N);
                this.f46450i.draw(canvas);
            }
            int i3 = this.G;
            if (i3 == 1) {
                Scroller scroller = this.J;
                if (scroller != null && scroller.computeScrollOffset()) {
                    int currX = this.J.getCurrX();
                    Bitmap bitmap = this.D;
                    if (bitmap != null) {
                        canvas.drawBitmap(bitmap, currX, N, this.H);
                    }
                    A();
                }
            } else if (i3 == 2) {
                Scroller scroller2 = this.K;
                if (scroller2 != null && scroller2.computeScrollOffset()) {
                    float currX2 = this.K.getCurrX() / getWidth();
                    float s16 = s(currX2);
                    float r16 = r(currX2);
                    Drawable drawable2 = this.E;
                    if (drawable2 != null) {
                        drawable2.setAlpha((int) (s16 * 255.0f));
                        int width = (int) (getWidth() * 0.3d);
                        this.E.setBounds(width, (int) ((getHeight() - N) - ((P * 3.0d) / 4.0d)), (int) (width + ((Q * 3.0d) / 4.0d)), getHeight() - N);
                        this.E.draw(canvas);
                    }
                    Drawable drawable3 = this.F;
                    if (drawable3 != null) {
                        drawable3.setAlpha((int) (r16 * 255.0f));
                        int width2 = (int) (getWidth() * 0.7d);
                        Drawable drawable4 = this.F;
                        int i16 = N;
                        drawable4.setBounds(width2, i16, Q + width2, P + i16);
                        this.F.draw(canvas);
                    }
                }
                z();
            }
            canvas.restore();
            return;
        }
        Drawable drawable5 = this.f46450i;
        if (drawable5 != null) {
            drawable5.setBounds(M, N, canvas.getWidth(), canvas.getHeight() - N);
            this.f46450i.draw(canvas);
        }
    }

    public void setCustomSkin(String str) {
        if (TextUtils.equals(this.f46449h, str)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f46447e = true;
            this.f46446d = false;
        } else {
            this.f46447e = false;
        }
        this.f46449h = str;
        v();
    }

    public void setDefaultBackgoundDrawable(Drawable drawable) {
        this.f46451m = drawable;
        if (this.f46446d || !TextUtils.isEmpty(this.f46449h)) {
            return;
        }
        this.f46450i = this.f46451m;
    }

    public void setHasLv9(boolean z16) {
        if (this.f46446d == z16 && this.f46448f) {
            return;
        }
        this.f46446d = z16;
        v();
    }

    private void u() {
        setWillNotDraw(false);
        this.I = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
        if (this.H == null) {
            Paint paint = new Paint();
            this.H = paint;
            paint.setXfermode(this.I);
        }
        this.f46446d = false;
        v();
    }

    private void v() {
        this.f46448f = true;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new AnonymousClass2());
    }

    public void w() {
        this.f46448f = false;
        this.G = 0;
        this.D = null;
        this.E = null;
        this.F = null;
        this.L.removeCallbacksAndMessages(null);
    }

    public PassiveFeedBubbleBannerBg(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46446d = false;
        this.f46447e = false;
        this.f46448f = false;
        this.C = -1;
        this.G = 0;
        this.L = new a(Looper.getMainLooper());
        u();
    }

    public PassiveFeedBubbleBannerBg(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f46446d = false;
        this.f46447e = false;
        this.f46448f = false;
        this.C = -1;
        this.G = 0;
        this.L = new a(Looper.getMainLooper());
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.qzone.component.banner.PassiveFeedBubbleBannerBg$2, reason: invalid class name */
    /* loaded from: classes39.dex */
    public class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable drawable;
            if (!PassiveFeedBubbleBannerBg.this.f46446d) {
                String str = PassiveFeedBubbleBannerBg.this.f46449h;
                if (PassiveFeedBubbleBannerBg.this.f46451m == null) {
                    PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg = PassiveFeedBubbleBannerBg.this;
                    passiveFeedBubbleBannerBg.f46451m = passiveFeedBubbleBannerBg.getResources().getDrawable(PassiveFeedBubbleBannerBg.this.t());
                }
                PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg2 = PassiveFeedBubbleBannerBg.this;
                passiveFeedBubbleBannerBg2.f46450i = passiveFeedBubbleBannerBg2.f46451m;
                PassiveFeedBubbleBannerBg.this.D = null;
                PassiveFeedBubbleBannerBg.this.E = null;
                PassiveFeedBubbleBannerBg.this.F = null;
                if (!TextUtils.isEmpty(str)) {
                    QzoneZipAnimateUtil.d(str, "PassiveFeedPush", String.valueOf(str.hashCode()), new AnonymousClass1(str));
                }
            } else {
                PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg3 = PassiveFeedBubbleBannerBg.this;
                passiveFeedBubbleBannerBg3.f46450i = passiveFeedBubbleBannerBg3.getResources().getDrawable(R.drawable.gap);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                if ((PassiveFeedBubbleBannerBg.this.E == null || PassiveFeedBubbleBannerBg.this.F == null) && (drawable = PassiveFeedBubbleBannerBg.this.getResources().getDrawable(R.drawable.fyr)) != null && drawable.getConstantState() != null) {
                    PassiveFeedBubbleBannerBg.this.E = drawable.getConstantState().newDrawable().mutate();
                    PassiveFeedBubbleBannerBg.this.F = drawable.getConstantState().newDrawable().mutate();
                }
                if (PassiveFeedBubbleBannerBg.this.D == null) {
                    try {
                        PassiveFeedBubbleBannerBg passiveFeedBubbleBannerBg4 = PassiveFeedBubbleBannerBg.this;
                        passiveFeedBubbleBannerBg4.D = BitmapFactory.decodeResource(passiveFeedBubbleBannerBg4.getResources(), R.drawable.gaj, options);
                    } catch (Throwable th5) {
                        j.c("PassiveFeedBubbleBannerBg", "oom " + th5.toString());
                    }
                }
                PassiveFeedBubbleBannerBg.this.L.sendEmptyMessageDelayed(1, 500L);
            }
            PassiveFeedBubbleBannerBg.this.L.post(new Runnable() { // from class: com.qzone.component.banner.PassiveFeedBubbleBannerBg.2.2
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (PassiveFeedBubbleBannerBg.this.C == -1 || (layoutParams = PassiveFeedBubbleBannerBg.this.getLayoutParams()) == null) {
                        return;
                    }
                    layoutParams.height = PassiveFeedBubbleBannerBg.this.C;
                    PassiveFeedBubbleBannerBg.this.setLayoutParams(layoutParams);
                }
            });
            PassiveFeedBubbleBannerBg.this.postInvalidate();
        }

        /* renamed from: com.qzone.component.banner.PassiveFeedBubbleBannerBg$2$1, reason: invalid class name */
        /* loaded from: classes39.dex */
        class AnonymousClass1 implements QzoneZipCacheHelperCallBack {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f46452a;

            AnonymousClass1(String str) {
                this.f46452a = str;
            }

            @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
            public void onResult(boolean z16) {
                if (TextUtils.isEmpty(this.f46452a)) {
                    return;
                }
                QzoneZipAnimateUtil.g("PassiveFeedPush", String.valueOf(this.f46452a.hashCode()), "bg@2x.9.png", new ImageLoader.ImageLoadListener() { // from class: com.qzone.component.banner.PassiveFeedBubbleBannerBg.2.1.1
                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                        final int i3 = com.qzone.util.image.c.m(str).outHeight;
                        PassiveFeedBubbleBannerBg.this.L.post(new Runnable() { // from class: com.qzone.component.banner.PassiveFeedBubbleBannerBg.2.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Drawable drawable2 = drawable;
                                if (drawable2 != null) {
                                    PassiveFeedBubbleBannerBg.this.f46450i = drawable2;
                                    ViewGroup.LayoutParams layoutParams = PassiveFeedBubbleBannerBg.this.getLayoutParams();
                                    if (layoutParams != null) {
                                        if (PassiveFeedBubbleBannerBg.this.C == -1) {
                                            PassiveFeedBubbleBannerBg.this.C = layoutParams.height;
                                        }
                                        u5.a.d();
                                        layoutParams.height = ar.d((i3 / 2.0f) * 1.35f);
                                        PassiveFeedBubbleBannerBg.this.setLayoutParams(layoutParams);
                                    }
                                    PassiveFeedBubbleBannerBg.this.postInvalidate();
                                }
                            }
                        });
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageFailed(String str, ImageLoader.Options options) {
                        j.a("PassiveFeedBubbleBannerBg", 1, "skin bg loaded failed!!!");
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageCanceled(String str, ImageLoader.Options options) {
                    }

                    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                    public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                    }
                });
            }

            @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
            public void onResultOfNativeRequest(boolean z16, String str, String str2) {
            }
        }
    }
}
