package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.DrawableUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeImage extends ImageBase {
    private static final String TAG = "NativeImage_TMTEST";
    protected NativeImageImp mNative;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new NativeImage(vafContext);
        }
    }

    public NativeImage(VafContext vafContext) {
        super(vafContext);
        this.mNative = new NativeImageImp(vafContext.getContext());
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        return this.mNative.getComMeasuredHeight();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        return this.mNative.getComMeasuredWidth();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean isContainer() {
        return true;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase
    public void loadImage(String str) {
        LogUtil.QLog.d(TAG, 2, "loadImage: path is " + str);
        if (str != null && !str.equals("-1")) {
            NativeImageImp nativeImageImp = this.mNative;
            nativeImageImp.setImageDrawable(DrawableUtil.getDrawable(nativeImageImp.getContext(), str, null, null));
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        this.mNative.comLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        this.mNative.measureComponent(i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
        this.mNative.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
        this.mNative.setScaleType(ImageBase.IMAGE_SCALE_TYPE.get(this.mScaleType, ImageView.ScaleType.CENTER_CROP));
        this.mNative.setCorner(this.mBorderTopLeftRadius, this.mBorderTopRightRadius, this.mBorderBottomLeftRadius, this.mBorderBottomRightRadius);
        loadImage(this.mSrc);
        refresh();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.mNative.setImageSrc(null);
        this.mSrc = null;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase
    public void setBitmap(Bitmap bitmap, boolean z16) {
        this.mNative.setImageBitmap(bitmap);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase
    public void setImageDrawable(Drawable drawable, boolean z16) {
        this.mNative.setImageDrawable(drawable);
    }
}
