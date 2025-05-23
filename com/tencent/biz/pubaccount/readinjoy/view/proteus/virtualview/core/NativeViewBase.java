package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.KeyEvent;
import android.view.View;

/* compiled from: P */
/* loaded from: classes4.dex */
public class NativeViewBase extends ViewBase {
    protected View __mNative;

    public NativeViewBase(VafContext vafContext) {
        super(vafContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredHeight() {
        View view = this.__mNative;
        if (view instanceof IView) {
            return ((IView) view).getComMeasuredHeight();
        }
        return view.getMeasuredHeight();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public int getComMeasuredWidth() {
        View view = this.__mNative;
        if (view instanceof IView) {
            return ((IView) view).getComMeasuredWidth();
        }
        return view.getMeasuredWidth();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public View getNativeView() {
        return this.__mNative;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        KeyEvent.Callback callback = this.__mNative;
        if (callback instanceof IView) {
            ((IView) callback).onComLayout(z16, i3, i16, i17, i18);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        KeyEvent.Callback callback = this.__mNative;
        if (callback instanceof IView) {
            ((IView) callback).onComMeasure(i3, i16);
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void reset() {
        super.reset();
        this.__mNative.setBackground(null);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    protected void setBackgroundColor(int i3) {
        this.__mNative.setBackgroundColor(i3);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    protected void setBackgroundImage(Bitmap bitmap) {
        this.__mNative.setBackground(new BitmapDrawable(this.mContext.getContext().getResources(), bitmap));
    }
}
