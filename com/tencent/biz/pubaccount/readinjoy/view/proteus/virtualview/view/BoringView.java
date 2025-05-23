package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class BoringView extends ViewBase {
    private BoringViewImpl mNative;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private static class BoringViewImpl extends View {
        private int mBackgroundColor;
        private Paint mBackgroundPaint;
        private int mBorderBottomLeftRadius;
        private int mBorderBottomRightRadius;
        private int mBorderColor;
        private Paint mBorderPaint;
        private int mBorderTopLeftRadius;
        private int mBorderTopRightRadius;
        private int mBorderWidth;

        public BoringViewImpl(Context context) {
            super(context);
            this.mBackgroundColor = 0;
            this.mBorderTopLeftRadius = 0;
            this.mBorderTopRightRadius = 0;
            this.mBorderBottomLeftRadius = 0;
            this.mBorderBottomRightRadius = 0;
            this.mBorderWidth = 0;
            this.mBorderColor = -16777216;
        }

        @Override // android.view.View
        protected void onDraw(Canvas canvas) {
            if (this.mBackgroundColor != 0) {
                if (this.mBackgroundPaint == null) {
                    Paint paint = new Paint();
                    this.mBackgroundPaint = paint;
                    paint.setAntiAlias(true);
                }
                this.mBackgroundPaint.setColor(this.mBackgroundColor);
                VirtualViewUtils.drawBackground(canvas, this.mBackgroundPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
            }
            super.onDraw(canvas);
            if (this.mBorderWidth > 0) {
                if (this.mBorderPaint == null) {
                    Paint paint2 = new Paint();
                    this.mBorderPaint = paint2;
                    paint2.setStyle(Paint.Style.STROKE);
                    this.mBorderPaint.setAntiAlias(true);
                }
                this.mBorderPaint.setStrokeWidth(this.mBorderWidth);
                this.mBorderPaint.setColor(this.mBorderColor);
                VirtualViewUtils.drawBorder(canvas, this.mBorderPaint, getWidth(), getHeight(), this.mBorderWidth, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
            }
        }

        @Override // android.view.View
        public void setBackgroundColor(int i3) {
            this.mBackgroundColor = i3;
        }

        public void setBorderBottomLeftRadius(int i3) {
            this.mBorderBottomLeftRadius = i3;
        }

        public void setBorderBottomRightRadius(int i3) {
            this.mBorderBottomRightRadius = i3;
        }

        public void setBorderColor(int i3) {
            this.mBorderColor = i3;
        }

        public void setBorderTopLeftRadius(int i3) {
            this.mBorderTopLeftRadius = i3;
        }

        public void setBorderTopRightRadius(int i3) {
            this.mBorderTopRightRadius = i3;
        }

        public void setBorderWidth(int i3) {
            this.mBorderWidth = i3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new BoringView(vafContext);
        }
    }

    public BoringView(VafContext vafContext) {
        super(vafContext);
        this.mNative = new BoringViewImpl(vafContext.getContext());
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return this.mNative.getMeasuredHeight();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return this.mNative.getMeasuredWidth();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.mNative.layout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        this.mNative.measure(i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
        this.mNative.setBorderColor(this.mBorderColor);
        this.mNative.setBorderWidth(this.mBorderWidth);
        this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
        this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
        this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
        this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
        this.mNative.setBackgroundColor(this.mBackground);
    }
}
