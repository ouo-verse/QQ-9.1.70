package com.qzone.feed.gift.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.feed.gift.util.FeedGiftUtil;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GiftAnimationLayout extends FrameLayout {
    private Context C;
    private String D;
    private int E;
    private int F;
    private float G;
    private Matrix H;
    private Camera I;
    private int J;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f47255d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f47256e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f47257f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f47258h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f47259i;

    /* renamed from: m, reason: collision with root package name */
    private a f47260m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 == 1) {
                if (GiftAnimationLayout.this.f47257f != null) {
                    GiftAnimationLayout.this.f47256e.setImageDrawable(GiftAnimationLayout.this.f47257f);
                }
                if (GiftAnimationLayout.this.f47259i != null) {
                    GiftAnimationLayout.this.f47258h.setImageDrawable(GiftAnimationLayout.this.f47259i);
                    return;
                }
                return;
            }
            if (i3 == 2) {
                if (GiftAnimationLayout.this.f47257f != null) {
                    GiftAnimationLayout.this.f47256e.setScaleX(1.2f);
                    GiftAnimationLayout.this.f47256e.setScaleY(1.2f);
                    GiftAnimationLayout.this.f47256e.setVisibility(0);
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(GiftAnimationLayout.this.f47257f);
                }
                if (GiftAnimationLayout.this.f47259i != null) {
                    GiftAnimationLayout.this.f47258h.setVisibility(0);
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(GiftAnimationLayout.this.f47259i);
                    return;
                }
                return;
            }
            if (i3 != 3) {
                if (i3 != 4) {
                    return;
                }
                GiftAnimationLayout.this.f47255d.setAsyncImage(GiftAnimationLayout.this.D);
                return;
            }
            if (GiftAnimationLayout.this.f47257f != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(GiftAnimationLayout.this.f47257f);
                GiftAnimationLayout.this.f47256e.setVisibility(8);
            }
            if (GiftAnimationLayout.this.f47259i != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(GiftAnimationLayout.this.f47259i);
                GiftAnimationLayout.this.f47258h.setVisibility(8);
            }
        }
    }

    public GiftAnimationLayout(Context context) {
        super(context);
        j(context);
    }

    private Drawable g(String str, String str2, int i3) {
        Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(zipAnimationDrawable, str + File.separator + str2, i3);
        zipAnimationDrawable.setCallback(this);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(zipAnimationDrawable, FeedGiftUtil.f47229a);
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(zipAnimationDrawable);
        return zipAnimationDrawable;
    }

    private int i(int i3) {
        return this.J != 2 ? i3 : (int) (i3 * 1.125f);
    }

    private void j(Context context) {
        this.C = context;
        this.f47260m = new a(Looper.getMainLooper());
        this.G = context.getResources().getDisplayMetrics().density;
        this.H = new Matrix();
        this.I = new Camera();
        setClipChildren(false);
        setClipToPadding(false);
        AsyncImageView asyncImageView = new AsyncImageView(this.C);
        this.f47255d = asyncImageView;
        asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f47255d);
        ImageView imageView = new ImageView(this.C);
        this.f47256e = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f47256e);
        ImageView imageView2 = new ImageView(this.C);
        this.f47258h = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f47258h);
    }

    private void m() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.concat(this.H);
        super.dispatchDraw(canvas);
    }

    public void h(String str) {
        if (this.f47257f == null) {
            this.f47257f = g(str, "particleFall", 10);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.f47257f, true);
        }
        if (this.f47259i == null) {
            int i3 = this.J;
            if (i3 == 1) {
                this.f47259i = g(str, QCircleDaTongConstant.ElementParamValue.GIFT, 5);
            } else if (i3 == 2) {
                this.f47259i = g(str, QCircleDaTongConstant.ElementParamValue.GIFT, 10);
            }
            if (this.f47259i != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.f47259i, true);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.f47259i, false);
            }
        }
        this.f47260m.sendEmptyMessage(1);
    }

    public void l() {
        p();
        if (this.f47257f != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f47257f);
        }
        if (this.f47259i != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f47259i);
        }
        removeAllViews();
    }

    public void n(String str) {
        this.D = str;
        this.f47260m.sendEmptyMessage(4);
    }

    public void o() {
        if (this.f47260m.hasMessages(2)) {
            this.f47260m.removeMessages(2);
        }
        this.f47260m.sendEmptyMessage(2);
    }

    public void p() {
        if (this.f47260m.hasMessages(3)) {
            this.f47260m.removeMessages(3);
        }
        this.f47260m.sendEmptyMessage(3);
    }

    public void setCardLength(int i3, int i16) {
        this.E = i3;
        this.F = i16;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f47255d.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i3;
            layoutParams.height = i16;
            this.f47255d.setLayoutParams(layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f47258h.getLayoutParams();
        if (layoutParams2 != null && layoutParams2.width != i(i16)) {
            layoutParams2.width = i(i16);
            layoutParams2.height = i16;
            layoutParams2.gravity = 17;
            this.f47258h.setLayoutParams(layoutParams2);
        }
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f47256e.getLayoutParams();
        if (layoutParams3 != null && layoutParams3.width != i3) {
            layoutParams3.height = (int) (i3 * 0.5466667f);
            layoutParams3.width = i3;
            layoutParams3.gravity = 17;
            this.f47256e.setLayoutParams(layoutParams3);
        }
        j.e("GiftAnimationLayout", 4, "width = " + i3 + " height = " + i16);
    }

    public void setMatrix(float f16) {
        this.I.save();
        this.I.rotateY(f16);
        this.I.getMatrix(this.H);
        this.I.restore();
        float[] fArr = new float[9];
        this.H.getValues(fArr);
        float f17 = fArr[6];
        float f18 = this.G;
        fArr[6] = f17 / f18;
        fArr[7] = fArr[7] / f18;
        this.H.setValues(fArr);
        this.H.preTranslate((-this.E) / 2, (-this.F) / 2);
        this.H.postTranslate(this.E / 2, this.F / 2);
        m();
    }

    public void setType(int i3) {
        this.J = i3;
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        ImageView imageView;
        super.setVisibility(i3);
        if (i3 != 8 || this.f47256e == null || (imageView = this.f47258h) == null) {
            return;
        }
        imageView.setVisibility(8);
        this.f47256e.setVisibility(8);
        if (this.f47259i != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).preLoadFrame(this.f47259i, 0);
        }
    }

    public void k() {
        j.e("GiftAnimationLayout", 4, "animation pause ");
        if (this.f47257f != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f47257f);
        }
        if (this.f47259i != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f47259i);
        }
    }

    public GiftAnimationLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        j(context);
    }

    public GiftAnimationLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        j(context);
    }
}
