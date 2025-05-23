package com.tencent.biz.pubaccount.weishi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.weishi.image.WSImageDownListener;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes32.dex */
public class RoundCornerImageView extends KandianUrlImageView {

    /* renamed from: d, reason: collision with root package name */
    private int f82393d;

    /* renamed from: e, reason: collision with root package name */
    private Path f82394e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f82395f;

    /* renamed from: h, reason: collision with root package name */
    private int f82396h;

    /* renamed from: i, reason: collision with root package name */
    private String f82397i;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes32.dex */
    @interface CornerMode {
    }

    public RoundCornerImageView(Context context) {
        super(context);
        this.f82393d = 0;
        this.f82394e = new Path();
        this.f82395f = new RectF();
        this.f82396h = 0;
    }

    private void a() {
        com.tencent.mobileqq.kandian.base.image.imageloader.b bVar;
        if (getUrl() == null || (bVar = this.mController) == null || !(bVar.h() instanceof WSImageDownListener)) {
            return;
        }
        ((WSImageDownListener) this.mController.h()).e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.tencent.mobileqq.kandian.base.image.b g16 = this.mController.g();
        if ((g16 == null || g16.f239007d) && !TextUtils.isEmpty(this.f82397i)) {
            setImageSrc(bb.c(this.f82397i));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f82393d > 0) {
            this.f82394e.reset();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            this.f82395f.left = getPaddingLeft();
            this.f82395f.top = getPaddingTop();
            this.f82395f.right = getPaddingLeft() + width;
            this.f82395f.bottom = getPaddingTop() + height;
            int i3 = this.f82393d;
            if (i3 <= 0) {
                i3 = width / 30;
            }
            int i16 = this.f82396h;
            if (i16 == -1) {
                this.f82394e.addRoundRect(this.f82395f, 0.0f, 0.0f, Path.Direction.CCW);
            } else if (i16 == 0) {
                float f16 = i3;
                this.f82394e.addRoundRect(this.f82395f, f16, f16, Path.Direction.CCW);
            } else if (i16 == 1) {
                float f17 = i3;
                this.f82394e.addRoundRect(this.f82395f, new float[]{f17, f17, f17, f17, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
            } else if (i16 == 2) {
                float f18 = i3;
                this.f82394e.addRoundRect(this.f82395f, new float[]{f18, f18, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
            } else if (i16 == 3) {
                float f19 = i3;
                this.f82394e.addRoundRect(this.f82395f, new float[]{0.0f, 0.0f, f19, f19, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CCW);
            }
            this.f82394e.setFillType(Path.FillType.EVEN_ODD);
            canvas.clipPath(this.f82394e);
        }
        a();
        try {
            super.onDraw(canvas);
        } catch (Exception e16) {
            x.f("RoundCornerImageView", e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView, android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.tencent.mobileqq.kandian.base.image.b g16 = this.mController.g();
        if ((g16 == null || g16.f239007d) && !TextUtils.isEmpty(this.f82397i)) {
            setImageSrc(bb.c(this.f82397i));
        }
    }

    public void setCorner(int i3) {
        setCorner(i3, 0);
    }

    @Override // com.tencent.mobileqq.kandian.base.view.widget.ZImageView
    public void setImageDrawable(Drawable drawable, boolean z16) {
        int i3 = this.mController.g().f239019p;
        x.b("RoundCornerImageView", "cacheType=" + i3);
        if (i3 != 0 && i3 != 3) {
            setImageDrawable(drawable);
        } else {
            super.setImageDrawable(drawable, z16);
        }
    }

    public void setCorner(int i3, int i16) {
        if (i3 < 0) {
            return;
        }
        this.f82396h = i16;
        this.f82393d = i3;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82393d = 0;
        this.f82394e = new Path();
        this.f82395f = new RectF();
        this.f82396h = 0;
    }

    public void setImageSrc(URL url) {
        if (url == null) {
            setImageResource(R.color.f157202bw1);
            return;
        }
        String url2 = url.toString();
        String str = this.f82397i;
        if (str != null && str.equalsIgnoreCase(url2)) {
            x.c("RoundCornerImageView", "[RoundCornerImageView.java][setImageSrc], current path unchanged ");
        } else {
            this.f82397i = url2;
            x.c("RoundCornerImageView", "[RoundCornerImageView.java][setImageSrc], current path changed ");
        }
        setImage(url);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f82393d = 0;
        this.f82394e = new Path();
        this.f82395f = new RectF();
        this.f82396h = 0;
    }
}
