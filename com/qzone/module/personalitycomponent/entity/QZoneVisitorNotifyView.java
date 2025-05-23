package com.qzone.module.personalitycomponent.entity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.qzone.proxy.personalitycomponent.adapter.PLog;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.c;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneVisitorNotifyView extends AsyncImageView implements View.OnClickListener {
    private static final int H = PersonalityEnv.dpToPx(87.0f);
    private static final int I = PersonalityEnv.dpToPx(23.0f);
    private Drawable C;
    private int D;
    private int E;
    private int F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    private Paint f49015d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f49016e;

    /* renamed from: f, reason: collision with root package name */
    private PointF f49017f;

    /* renamed from: h, reason: collision with root package name */
    private ValueAnimator f49018h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f49019i;

    /* renamed from: m, reason: collision with root package name */
    private int f49020m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            QZoneVisitorNotifyView.this.f49017f = (PointF) valueAnimator.getAnimatedValue();
            QZoneVisitorNotifyView.this.postInvalidate();
        }
    }

    public QZoneVisitorNotifyView(Context context) {
        super(context);
        this.G = false;
        h();
    }

    private void g(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f49015d.getFontMetrics();
        float f16 = fontMetrics.bottom;
        float f17 = ((f16 - fontMetrics.top) / 2.0f) - f16;
        int i3 = 0;
        float f18 = 0.0f;
        for (String str : this.f49016e) {
            float measureText = this.f49015d.measureText(str);
            if (f18 <= measureText) {
                f18 = measureText;
            }
        }
        int i16 = I;
        int i17 = this.E;
        float f19 = i16 - i17;
        float f26 = (f19 / 2.0f) + f17;
        canvas.drawText("\u65b0\u589e\u6765\u8bbf", (this.F * 2) - 8, i17 + f26, this.f49015d);
        float f27 = H - ((this.F + f18) + 8.0f);
        while (true) {
            String[] strArr = this.f49016e;
            if (i3 < strArr.length) {
                PointF pointF = this.f49017f;
                canvas.drawText(strArr[i3], f27, ((this.E + f26) - (i3 * f19)) + (pointF != null ? pointF.y : 0.0f), this.f49015d);
                i3++;
            } else {
                l((strArr.length - 1) * f19);
                return;
            }
        }
    }

    private void h() {
        this.f49019i = new Handler(Looper.getMainLooper());
        i();
        setAsyncClipSize(H, I);
        setScaleType(ImageView.ScaleType.FIT_XY);
        Paint paint = new Paint();
        this.f49015d = paint;
        paint.setTextAlign(Paint.Align.LEFT);
        this.f49015d.setColor(-1);
        this.f49015d.setAntiAlias(true);
        this.f49015d.setTextSize(PersonalityEnv.dpToPx(10.0f));
        this.F = PersonalityEnv.dpToPx(7.0f);
        this.E = PersonalityEnv.dpToPx(3.0f);
        setOnClickListener(this);
    }

    private void i() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            this.f49019i.post(new Runnable() { // from class: com.qzone.module.personalitycomponent.entity.QZoneVisitorNotifyView.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneVisitorNotifyView.this.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20190721131840_u49Ejozac6.png");
                }
            });
        } else {
            setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20190721131840_u49Ejozac6.png");
        }
    }

    private void k(int i3) {
        int i16 = this.f49020m;
        int i17 = i16 != 0 ? i16 != 1 ? i16 != 2 ? i16 != 3 ? i16 != 8 ? i16 != 9 ? -1 : i3 == 0 ? 411 : 412 : i3 == 0 ? 413 : 414 : i3 == 0 ? 421 : 422 : i3 == 0 ? 417 : 418 : i3 == 0 ? 419 : 420 : i3 == 0 ? 415 : 416;
        if (i17 != -1) {
            c.c(i17);
        }
    }

    public void j() {
        if (this.G) {
            this.D = 0;
            setVisibility(8);
            this.G = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        PersonalityEnv.JumpToVistorFromUserHome(view.getContext(), "QzFeedVistorBubble");
        this.G = true;
        k(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f49016e == null) {
            return;
        }
        if (this.C == null) {
            i();
        } else {
            super.onDraw(canvas);
            g(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(H, I);
    }

    @Override // com.qzone.widget.AsyncImageView, com.qzone.widget.AsyncImageable
    public void setAsyncImage(String str) {
        try {
            if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str).l(VasDynamicDrawableCache.INSTANCE).a());
            } else {
                super.setAsyncImage(str);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            PLog.e("QZoneVisitorNotifyView", "setAsyncImage Throwable = " + th5.getMessage());
        }
    }

    @Override // com.qzone.widget.ExtendImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.C = drawable;
    }

    public void setUnReadNum(int i3, int i16) {
        if (i16 <= 0 || this.D == i16) {
            return;
        }
        this.f49020m = i3;
        this.D = i16;
        if (i3 == 4) {
            this.f49019i.post(new Runnable() { // from class: com.qzone.module.personalitycomponent.entity.QZoneVisitorNotifyView.1
                @Override // java.lang.Runnable
                public void run() {
                    QZoneVisitorNotifyView.this.setVisibility(8);
                }
            });
            return;
        }
        if (i16 > 999) {
            i16 = 999;
        }
        int i17 = 2;
        if (i16 >= 2) {
            i17 = 3;
        } else if (i16 < 1) {
            i17 = 1;
        }
        this.f49016e = new String[i17];
        int i18 = 0;
        while (true) {
            String[] strArr = this.f49016e;
            if (i18 >= strArr.length || i16 < 0) {
                break;
            }
            strArr[(strArr.length - i18) - 1] = String.valueOf(i16);
            i18++;
            i16--;
        }
        this.f49018h = null;
        PLog.d("QZoneVisitorNotifyView", "setUnReadNum widgetType = " + i3 + " num + " + i16);
        postInvalidate();
        k(0);
    }

    public QZoneVisitorNotifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G = false;
        h();
    }

    private void l(float f16) {
        if (f16 == 0.0f) {
            PLog.d("QZoneVisitorNotifyView", "initUnReadAnimation height = 0");
            return;
        }
        if (this.f49018h == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new b(), new PointF(0.0f, 0.0f), new PointF(0.0f, f16));
            this.f49018h = ofObject;
            ofObject.addUpdateListener(new a());
            this.f49018h.setDuration(1000L);
            this.f49018h.start();
        }
    }

    public QZoneVisitorNotifyView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = false;
        h();
    }
}
