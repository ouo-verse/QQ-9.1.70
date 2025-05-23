package com.qzone.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.qzone.widget.AsyncImageable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes37.dex */
public class FeedImageView extends AsyncImageView {
    private static Bitmap W = null;

    /* renamed from: a0, reason: collision with root package name */
    private static Bitmap f60384a0 = null;

    /* renamed from: b0, reason: collision with root package name */
    private static Bitmap f60385b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    private static Bitmap f60386c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    private static Bitmap f60387d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    private static Bitmap f60388e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    private static Bitmap f60389f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    private static Bitmap f60390g0 = null;

    /* renamed from: h0, reason: collision with root package name */
    public static int f60391h0 = 1;

    /* renamed from: i0, reason: collision with root package name */
    public static int f60392i0 = 2;

    /* renamed from: j0, reason: collision with root package name */
    public static int f60393j0 = 4;

    /* renamed from: k0, reason: collision with root package name */
    public static int f60394k0 = 8;
    private boolean C;
    private boolean D;
    private int E;
    private int F;
    private float G;
    private float H;
    private boolean I;
    private int J;
    private RectF K;
    private Paint L;
    private int M;
    private long N;
    private Bitmap P;
    private Bitmap Q;
    private long R;
    private String S;
    private boolean T;
    Paint U;
    int V;

    /* renamed from: d, reason: collision with root package name */
    private int f60395d;

    /* renamed from: e, reason: collision with root package name */
    private int f60396e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f60397f;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f60398h;

    /* renamed from: i, reason: collision with root package name */
    private int f60399i;

    /* renamed from: m, reason: collision with root package name */
    private int f60400m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements AsyncImageable.AsyncImageListener {
        a() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            FeedImageView.this.I = false;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
            FeedImageView.this.f60397f = true;
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
            int i3;
            if (!FeedImageView.this.I || (i3 = (int) (f16 * 100.0f)) == FeedImageView.this.J) {
                return;
            }
            FeedImageView.this.J = i3;
            FeedImageView.this.invalidate();
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
            FeedImageView.this.f60397f = false;
            if (FeedImageView.this.I && FeedImageView.this.J == 0) {
                FeedImageView.this.applyDefaultImage();
                FeedImageView.this.N = System.currentTimeMillis();
            }
        }
    }

    public FeedImageView(Context context) {
        super(context);
        this.f60395d = 0;
        this.f60396e = 2;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = false;
        this.J = 0;
        this.K = new RectF();
        this.M = 0;
        this.N = 0L;
        this.U = new Paint();
        this.V = 0;
        K(context);
    }

    private void C() {
        int i3 = this.f60395d;
        if (i3 == 3 || i3 == 4) {
            boolean z16 = this.C;
            if (z16 && !this.D) {
                this.f60398h = J(true);
                this.D = true;
            } else if (!z16 && this.D) {
                this.f60398h = J(false);
                this.D = false;
            }
            if (this.f60398h == null) {
                if (this.C) {
                    this.f60398h = J(true);
                } else {
                    this.f60398h = J(false);
                }
            }
        }
    }

    private void G(Canvas canvas, Bitmap bitmap) {
        int i3 = this.f60396e;
        if (i3 == 1) {
            H(canvas, bitmap);
            return;
        }
        if (i3 == 2) {
            F(canvas, bitmap);
        } else if (i3 == 5) {
            D(canvas, bitmap);
        } else {
            if (i3 != 6) {
                return;
            }
            E(canvas, bitmap);
        }
    }

    private void K(Context context) {
        this.f60399i = context.getResources().getDimensionPixelSize(R.dimen.f158699mo);
        this.f60400m = context.getResources().getDimensionPixelSize(R.dimen.f158712n1);
        this.F = context.getResources().getColor(R.color.f158017al3);
        this.E = context.getResources().getColor(R.color.a7z);
        this.H = context.getResources().getDimensionPixelSize(R.dimen.f158847qk);
        this.G = context.getResources().getDimensionPixelSize(R.dimen.f158845qi);
        this.M = context.getResources().getDimensionPixelSize(R.dimen.f158846qj);
        L();
        setInternalAsyncImageListener(new a());
        this.U.setStrokeWidth(com.qzone.proxy.feedcomponent.d.f50146c);
        this.U.setColor(getResources().getColor(R.color.a8o));
    }

    private void L() {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.widget.FeedImageView.1
            @Override // java.lang.Runnable
            public void run() {
                if (FeedImageView.f60389f0 == null) {
                    FeedImageView feedImageView = FeedImageView.this;
                    feedImageView.f60398h = com.qzone.util.image.c.s(feedImageView.getResources(), R.drawable.ghm);
                    FeedImageView.f60389f0 = FeedImageView.this.f60398h;
                    FeedImageView.f60390g0 = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.ghn);
                }
                if (FeedImageView.W == null) {
                    FeedImageView.W = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.f162226g25);
                }
                if (FeedImageView.f60384a0 == null) {
                    FeedImageView.f60384a0 = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.g27);
                }
                if (FeedImageView.f60386c0 == null) {
                    FeedImageView.f60386c0 = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.g8s);
                }
                if (FeedImageView.f60387d0 == null) {
                    FeedImageView.f60387d0 = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.g8u);
                }
                if (FeedImageView.f60385b0 == null) {
                    FeedImageView.f60385b0 = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.g8v);
                }
                if (FeedImageView.f60388e0 == null) {
                    FeedImageView.f60388e0 = com.qzone.util.image.c.s(FeedImageView.this.getResources(), R.drawable.g8t);
                }
            }
        });
    }

    public Bitmap I() {
        C();
        switch (this.f60395d) {
            case 1:
                Bitmap bitmap = W;
                if (bitmap == null) {
                    bitmap = com.qzone.util.image.c.s(getResources(), R.drawable.f162226g25);
                    W = bitmap;
                }
                setContentDescription(BaseApplication.getContext().getText(R.string.gqk));
                return bitmap;
            case 2:
                Bitmap bitmap2 = f60384a0;
                if (bitmap2 == null) {
                    bitmap2 = com.qzone.util.image.c.s(getResources(), R.drawable.g27);
                    f60384a0 = bitmap2;
                }
                setContentDescription(BaseApplication.getContext().getText(R.string.gqe));
                return bitmap2;
            case 3:
            case 4:
                Bitmap bitmap3 = this.f60398h;
                if (bitmap3 == null) {
                    bitmap3 = com.qzone.util.image.c.s(getResources(), R.drawable.ghm);
                    this.f60398h = bitmap3;
                }
                setContentDescription(BaseApplication.getContext().getText(R.string.gqr));
                return bitmap3;
            case 5:
            default:
                return null;
            case 6:
                Bitmap bitmap4 = f60385b0;
                if (bitmap4 != null) {
                    return bitmap4;
                }
                Bitmap s16 = com.qzone.util.image.c.s(getResources(), R.drawable.g8v);
                f60385b0 = s16;
                return s16;
            case 7:
                Bitmap bitmap5 = f60387d0;
                if (bitmap5 != null) {
                    return bitmap5;
                }
                Bitmap s17 = com.qzone.util.image.c.s(getResources(), R.drawable.g8u);
                f60387d0 = s17;
                return s17;
            case 8:
                Bitmap bitmap6 = f60386c0;
                if (bitmap6 != null) {
                    return bitmap6;
                }
                Bitmap s18 = com.qzone.util.image.c.s(getResources(), R.drawable.g8s);
                f60386c0 = s18;
                return s18;
            case 9:
                Bitmap bitmap7 = f60388e0;
                if (bitmap7 != null) {
                    return bitmap7;
                }
                Bitmap s19 = com.qzone.util.image.c.s(getResources(), R.drawable.g8t);
                f60388e0 = s19;
                return s19;
            case 10:
                long j3 = this.R;
                if (j3 > 0 && j3 == com.qzone.adapter.feedcomponent.i.H().t0()) {
                    Bitmap bitmap8 = this.P;
                    if (bitmap8 == null) {
                        bitmap8 = com.qzone.util.image.c.s(getResources(), R.drawable.fyn);
                    }
                    this.P = bitmap8;
                    return bitmap8;
                }
                Bitmap bitmap9 = this.Q;
                if (bitmap9 == null) {
                    bitmap9 = com.qzone.util.image.c.s(getResources(), R.drawable.fyj);
                }
                this.Q = bitmap9;
                return bitmap9;
            case 11:
                if (!TextUtils.isEmpty(this.S) && this.S.equals(com.qzone.adapter.feedcomponent.i.H().u0())) {
                    Bitmap bitmap10 = this.P;
                    if (bitmap10 == null) {
                        bitmap10 = com.qzone.util.image.c.s(getResources(), R.drawable.fyn);
                    }
                    this.P = bitmap10;
                    return bitmap10;
                }
                Bitmap bitmap11 = this.Q;
                if (bitmap11 == null) {
                    bitmap11 = com.qzone.util.image.c.s(getResources(), R.drawable.fyj);
                }
                this.Q = bitmap11;
                return bitmap11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap I;
        boolean z16;
        super.onDraw(canvas);
        if (this.I && !this.f60397f && this.J > 0 && this.L != null) {
            int width = getWidth();
            int height = getHeight();
            int i3 = this.M;
            if (width < i3 || height < i3) {
                this.I = false;
                z16 = false;
            } else {
                z16 = true;
            }
            if ((this.J != 100 || System.currentTimeMillis() - this.N >= 500) ? z16 : false) {
                float f16 = this.G / 2.0f;
                this.L.setAntiAlias(true);
                this.L.setColor(this.F);
                this.L.setStyle(Paint.Style.FILL);
                canvas.drawCircle(width / 2, height / 2, f16, this.L);
                float f17 = (this.J * 360.0f) / 100.0f;
                float f18 = ((100 - r2) * 360.0f) / 100.0f;
                this.L.setColor(this.E);
                float f19 = this.G - this.H;
                float f26 = width;
                float f27 = height;
                this.K.set((f26 - f19) / 2.0f, (f27 - f19) / 2.0f, (f26 + f19) / 2.0f, (f27 + f19) / 2.0f);
                canvas.drawArc(this.K, f17 - 90.0f, f18, true, this.L);
            }
        }
        if (this.f60395d != 0 && (I = I()) != null) {
            G(canvas, I);
        }
        int width2 = getWidth();
        int height2 = getHeight();
        if ((this.V & f60392i0) != 0) {
            canvas.drawLine(0.0f, 0.0f, 0.0f, height2, this.U);
        }
        if ((this.V & f60391h0) != 0) {
            canvas.drawLine(0.0f, 0.0f, width2, 0.0f, this.U);
        }
        if ((this.V & f60393j0) != 0) {
            float f28 = width2;
            canvas.drawLine(f28, 0.0f, f28, height2, this.U);
        }
        if ((this.V & f60394k0) != 0) {
            float f29 = height2;
            canvas.drawLine(0.0f, f29, width2, f29, this.U);
        }
    }

    public void setAudioUrl(String str) {
        this.S = str;
    }

    public void setIconPosition(int i3) {
        this.f60396e = i3;
    }

    public void setImageType(int i3, boolean z16) {
        this.f60395d = i3;
        this.C = z16;
        C();
    }

    public void setNoCheckChangtu(boolean z16) {
        this.T = z16;
    }

    public void setOutLineFlag(int i3) {
        this.V = i3;
    }

    public void setQQMusicId(long j3) {
        this.R = j3;
    }

    private Bitmap J(boolean z16) {
        if (z16) {
            Bitmap bitmap = f60390g0;
            return bitmap != null ? bitmap : com.qzone.util.image.c.s(getResources(), R.drawable.ghn);
        }
        Bitmap bitmap2 = f60389f0;
        return bitmap2 != null ? bitmap2 : com.qzone.util.image.c.s(getResources(), R.drawable.ghm);
    }

    public void setShowLoading(boolean z16) {
        if (z16 && this.L == null) {
            this.L = new Paint();
        }
        this.I = z16;
        if (this.J == 100) {
            this.J = 0;
        }
        setApplyDefaultImage(!z16);
    }

    private void D(Canvas canvas, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int i3 = this.f60400m + 0;
        int height = measuredHeight - bitmap.getHeight();
        int i16 = this.f60399i;
        int i17 = height - i16;
        if (i3 < 0) {
            int i18 = this.f60400m;
            if (i3 >= (-i18)) {
                i3 += i18;
            }
        }
        if (i17 < 0 && i17 >= (-i16)) {
            i17 += i16;
        }
        if (i3 < 0 || i17 < 0) {
            return;
        }
        canvas.drawBitmap(bitmap, i3, i17, (Paint) null);
    }

    private void E(Canvas canvas, Bitmap bitmap) {
        int width;
        int height;
        if (bitmap == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (this.f60395d != 2) {
            width = (measuredWidth - bitmap.getWidth()) - this.f60400m;
            int height2 = measuredHeight - bitmap.getHeight();
            int i3 = this.f60399i;
            height = height2 - i3;
            if (width < 0) {
                int i16 = this.f60400m;
                if (width >= (-i16)) {
                    width += i16;
                }
            }
            if (height < 0 && height >= (-i3)) {
                height += i3;
            }
        } else {
            width = measuredWidth - bitmap.getWidth();
            height = measuredHeight - bitmap.getHeight();
        }
        if (width < 0 || height < 0) {
            return;
        }
        canvas.drawBitmap(bitmap, width, height, (Paint) null);
    }

    private void F(Canvas canvas, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        int measuredWidth = getMeasuredWidth() / 2;
        int measuredHeight = getMeasuredHeight() / 2;
        int width = measuredWidth - (bitmap.getWidth() / 2);
        int height = measuredHeight - (bitmap.getHeight() / 2);
        if (width <= 0 || height <= 0) {
            return;
        }
        canvas.drawBitmap(bitmap, width, height, (Paint) null);
    }

    private void H(Canvas canvas, Bitmap bitmap) {
        int measuredWidth;
        if (bitmap != null && (measuredWidth = getMeasuredWidth() - bitmap.getWidth()) >= 0) {
            canvas.drawBitmap(bitmap, measuredWidth, 0.0f, (Paint) null);
        }
    }

    @Override // com.qzone.widget.AsyncImageView
    public void setImageType(int i3) {
        this.f60395d = i3;
        C();
    }

    public FeedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60395d = 0;
        this.f60396e = 2;
        this.C = false;
        this.D = false;
        this.E = 0;
        this.F = 0;
        this.G = 0.0f;
        this.H = 0.0f;
        this.I = false;
        this.J = 0;
        this.K = new RectF();
        this.M = 0;
        this.N = 0L;
        this.U = new Paint();
        this.V = 0;
        K(context);
    }
}
