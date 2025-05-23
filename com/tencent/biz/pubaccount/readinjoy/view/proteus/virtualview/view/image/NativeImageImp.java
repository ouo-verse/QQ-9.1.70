package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeImageImp extends ImageView implements IView {
    private static final String TAG = "NativeImageImp_TMTEST";
    private int mBorderBottomLeftRadius;
    private int mBorderBottomRightRadius;
    private int mBorderTopLeftRadius;
    private int mBorderTopRightRadius;
    private Drawable mPlaceHolder;

    public NativeImageImp(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void comLayout(int i3, int i16, int i17, int i18) {
        onComLayout(true, i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView
    public void measureComponent(int i3, int i16) {
        onComMeasure(i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        layout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        measure(i3, i16);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mBorderBottomLeftRadius > 0 || this.mBorderBottomRightRadius > 0 || this.mBorderTopLeftRadius > 0 || this.mBorderTopRightRadius > 0) {
            VirtualViewUtils.clipCanvas(canvas, getWidth(), getHeight(), 0, this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        }
        super.onDraw(canvas);
    }

    public void setCorner(int i3, int i16, int i17, int i18) {
        this.mBorderTopLeftRadius = i3;
        this.mBorderTopRightRadius = i16;
        this.mBorderBottomRightRadius = i18;
        this.mBorderBottomLeftRadius = i17;
    }

    public void setImageSrc(String str) {
        try {
            setImageDrawable(DrawableUtil.getDrawable(getContext(), str, null, null));
        } catch (Exception unused) {
        }
    }
}
