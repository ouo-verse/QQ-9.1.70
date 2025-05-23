package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtils;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeLinearLayout extends LinearLayout {
    private static final String TAG = "NativeLinearLayout";
    protected NativeLayoutImpl mNative;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new NativeLinearLayout(vafContext);
        }
    }

    public NativeLinearLayout(VafContext vafContext) {
        super(vafContext);
        NativeLayoutImpl nativeLayoutImpl = new NativeLayoutImpl(vafContext.getContext());
        this.mNative = nativeLayoutImpl;
        nativeLayoutImpl.setVirtualView(this);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout
    public void addView(ViewBase viewBase) {
        if (LogUtils.shouldLog()) {
            LogUtils.d("NativeLinearLayout", "[addView] for " + this.mName);
        }
        super.addView(viewBase);
        this.mNative.attachViews(viewBase);
        if (LogUtils.shouldLog()) {
            LogUtils.d("NativeLinearLayout", "[addView] native child count: " + this.mNative.getChildCount());
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public View getNativeView() {
        return this.mNative;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onComLayout(z16, 0, 0, i17 - i3, i18 - i16);
        this.mNative.comLayout(i3, i16, i17, i18);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        super.onComMeasure(i3, i16);
        this.mNative.measureComponent(this.mMeasuredWidth, this.mMeasuredHeight);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        this.mNative.setBorderColor(this.mBorderColor);
        this.mNative.setBorderWidth(this.mBorderWidth);
        this.mNative.setBorderTopLeftRadius(this.mBorderTopLeftRadius);
        this.mNative.setBorderTopRightRadius(this.mBorderTopRightRadius);
        this.mNative.setBorderBottomLeftRadius(this.mBorderBottomLeftRadius);
        this.mNative.setBorderBottomRightRadius(this.mBorderBottomRightRadius);
        this.mNative.setBackgroundColor(this.mBackground);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout
    public LinearLayout.Params generateParams() {
        return new LinearLayout.Params();
    }
}
