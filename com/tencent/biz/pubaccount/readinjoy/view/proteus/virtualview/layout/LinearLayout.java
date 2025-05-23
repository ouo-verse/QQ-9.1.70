package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class LinearLayout extends Layout {
    private static final String TAG = "LinearLayout";
    protected int mMeasureChildrenHeight;
    protected int mMeasureChildrenWidth;
    public int mOrientation;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new LinearLayout(vafContext);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Params extends Layout.Params {
        public int mLayoutGravity;

        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params
        public boolean setAttribute(int i3, String str) {
            boolean attribute = super.setAttribute(i3, str);
            if (attribute) {
                return attribute;
            }
            if (i3 != 33) {
                if (i3 == 34) {
                    this.mLayoutGravity = 4;
                    return false;
                }
                return false;
            }
            this.mLayoutGravity = 32;
            return false;
        }
    }

    public LinearLayout(VafContext vafContext) {
        super(vafContext);
        this.mOrientation = 0;
    }

    private int getChildrenHeight() {
        if (this.mMeasureChildrenHeight <= 0) {
            this.mMeasureChildrenHeight = 0;
            Iterator<ViewBase> it = this.mSubViews.iterator();
            while (it.hasNext()) {
                this.mMeasureChildrenHeight += it.next().getComMeasuredHeightWithMargin();
            }
        }
        return this.mMeasureChildrenHeight;
    }

    private int getChildrenWidth() {
        if (this.mMeasureChildrenWidth <= 0) {
            this.mMeasureChildrenWidth = 0;
            Iterator<ViewBase> it = this.mSubViews.iterator();
            while (it.hasNext()) {
                this.mMeasureChildrenWidth += it.next().getComMeasuredWidthWithMargin();
            }
        }
        return this.mMeasureChildrenWidth;
    }

    private int getRealHeight(int i3, int i16) {
        int i17;
        int i18;
        int comMeasuredHeightWithMargin;
        int i19;
        int i26;
        int comMeasuredHeightWithMargin2;
        int i27 = 0;
        if (Integer.MIN_VALUE == i3) {
            int i28 = this.mOrientation;
            if (1 == i28) {
                for (ViewBase viewBase : this.mSubViews) {
                    if (!viewBase.isGone() && (comMeasuredHeightWithMargin2 = viewBase.getComMeasuredHeightWithMargin()) > i27) {
                        i27 = comMeasuredHeightWithMargin2;
                    }
                }
                this.mMeasureChildrenHeight = i27;
                i19 = this.mPaddingTop + this.mPaddingBottom;
                i26 = this.mBorderWidth;
            } else {
                if (i28 == 0) {
                    for (ViewBase viewBase2 : this.mSubViews) {
                        if (!viewBase2.isGone()) {
                            i27 += viewBase2.getComMeasuredHeightWithMargin();
                        }
                    }
                    this.mMeasureChildrenHeight = i27;
                    i19 = this.mPaddingTop + this.mPaddingBottom;
                    i26 = this.mBorderWidth;
                }
                return Math.min(i16, i27);
            }
            i27 += i19 + (i26 << 1);
            return Math.min(i16, i27);
        }
        if (1073741824 != i3) {
            int i29 = this.mOrientation;
            if (1 == i29) {
                for (ViewBase viewBase3 : this.mSubViews) {
                    if (!viewBase3.isGone() && (comMeasuredHeightWithMargin = viewBase3.getComMeasuredHeightWithMargin()) > i27) {
                        i27 = comMeasuredHeightWithMargin;
                    }
                }
                this.mMeasureChildrenHeight = i27;
                i17 = this.mPaddingTop + this.mPaddingBottom;
                i18 = this.mBorderWidth;
            } else {
                if (i29 == 0) {
                    for (ViewBase viewBase4 : this.mSubViews) {
                        if (!viewBase4.isGone()) {
                            i27 += viewBase4.getComMeasuredHeightWithMargin();
                        }
                    }
                    this.mMeasureChildrenHeight = i27;
                    i17 = this.mPaddingTop + this.mPaddingBottom;
                    i18 = this.mBorderWidth;
                }
                return i27;
            }
            i27 += i17 + (i18 << 1);
            return i27;
        }
        return i16;
    }

    private int getRealWidth(int i3, int i16, int i17) {
        int i18;
        int i19;
        int comMeasuredWidthWithMargin;
        if (Integer.MIN_VALUE == i3) {
            int i26 = this.mOrientation;
            int i27 = 0;
            if (1 == i26) {
                for (ViewBase viewBase : this.mSubViews) {
                    if (!viewBase.isGone()) {
                        i27 += viewBase.getComMeasuredWidthWithMargin();
                    }
                }
                this.mMeasureChildrenWidth = i27;
                i18 = this.mPaddingLeft + this.mPaddingRight;
                i19 = this.mBorderWidth;
            } else {
                if (i26 == 0) {
                    for (ViewBase viewBase2 : this.mSubViews) {
                        if (!viewBase2.isGone() && (comMeasuredWidthWithMargin = viewBase2.getComMeasuredWidthWithMargin()) > i27) {
                            i27 = comMeasuredWidthWithMargin;
                        }
                    }
                    this.mMeasureChildrenWidth = i27;
                    i18 = this.mPaddingLeft + this.mPaddingRight;
                    i19 = this.mBorderWidth;
                }
                return Math.min(i16, i27);
            }
            i27 += i18 + (i19 << 1);
            return Math.min(i16, i27);
        }
        if (1073741824 == i3) {
            return i16;
        }
        return i17 + this.mPaddingLeft + this.mPaddingRight;
    }

    private void measureHorizontal(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int i17 = 0;
        boolean z16 = false;
        for (ViewBase viewBase : this.mSubViews) {
            if (!viewBase.isGone()) {
                Layout.Params comLayoutParams = viewBase.getComLayoutParams();
                if (1073741824 != mode2 && -1 == comLayoutParams.mLayoutHeight) {
                    z16 = true;
                }
                if (mode != 0) {
                    measureComChild(viewBase, View.MeasureSpec.makeMeasureSpec(size - i17, 1073741824), i16);
                } else {
                    measureComChild(viewBase, i3, i16);
                }
                i17 += viewBase.getComMeasuredWidthWithMargin();
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size, i17), getRealHeight(mode2, size2));
        if (z16) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredHeight(), 1073741824);
            for (ViewBase viewBase2 : this.mSubViews) {
                if (!viewBase2.isGone() && -1 == viewBase2.getComLayoutParams().mLayoutHeight) {
                    measureComChild(viewBase2, i3, makeMeasureSpec);
                }
            }
        }
    }

    private final void measureVertical(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int i17 = 0;
        boolean z16 = false;
        for (ViewBase viewBase : this.mSubViews) {
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                if (1073741824 != mode && -1 == params.mLayoutWidth) {
                    z16 = true;
                }
                measureComChild(viewBase, i3, i16);
                if (i17 <= viewBase.getComMeasuredWidthWithMargin()) {
                    i17 = viewBase.getComMeasuredWidthWithMargin();
                }
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size, i17), getRealHeight(mode2, size2));
        if (z16) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getComMeasuredWidth(), 1073741824);
            for (ViewBase viewBase2 : this.mSubViews) {
                if (!viewBase2.isGone() && -1 == viewBase2.getComLayoutParams().mLayoutWidth) {
                    measureComChild(viewBase2, makeMeasureSpec, i16);
                }
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childrenHeight;
        int i19;
        int childrenWidth;
        int i26;
        int i27 = this.mOrientation;
        if (i27 != 0) {
            if (i27 == 1) {
                int i28 = this.mGravity;
                if ((i28 & 1) != 0) {
                    childrenWidth = i3 + this.mPaddingLeft + this.mBorderWidth;
                } else if ((i28 & 4) != 0) {
                    childrenWidth = ((i17 - i3) - getChildrenWidth()) >> 1;
                } else {
                    childrenWidth = ((i17 - getChildrenWidth()) - this.mPaddingRight) - this.mBorderWidth;
                }
                for (ViewBase viewBase : this.mSubViews) {
                    if (!viewBase.isGone()) {
                        Params params = (Params) viewBase.getComLayoutParams();
                        int comMeasuredWidth = viewBase.getComMeasuredWidth();
                        int comMeasuredHeight = viewBase.getComMeasuredHeight();
                        int i29 = childrenWidth + params.mLayoutMarginLeft;
                        int i36 = params.mLayoutGravity;
                        if ((i36 & 32) != 0) {
                            i26 = ((i18 + i16) - comMeasuredHeight) >> 1;
                        } else if ((i36 & 16) != 0) {
                            i26 = (((i18 - comMeasuredHeight) - this.mPaddingBottom) - this.mBorderWidth) - params.mLayoutMarginBottom;
                        } else {
                            i26 = this.mPaddingTop + i16 + this.mBorderWidth + params.mLayoutMarginTop;
                        }
                        viewBase.comLayout(i29, i26, i29 + comMeasuredWidth, comMeasuredHeight + i26);
                        childrenWidth = i29 + comMeasuredWidth + params.mLayoutMarginRight;
                    }
                }
                return;
            }
            return;
        }
        int i37 = this.mGravity;
        if ((i37 & 8) != 0) {
            childrenHeight = i16 + this.mPaddingTop + this.mBorderWidth;
        } else if ((i37 & 32) != 0) {
            childrenHeight = ((i18 + i16) - getChildrenHeight()) >> 1;
        } else {
            childrenHeight = ((i18 - getChildrenHeight()) - this.mPaddingBottom) - this.mBorderWidth;
        }
        for (ViewBase viewBase2 : this.mSubViews) {
            if (!viewBase2.isGone()) {
                Params params2 = (Params) viewBase2.getComLayoutParams();
                int comMeasuredWidth2 = viewBase2.getComMeasuredWidth();
                int comMeasuredHeight2 = viewBase2.getComMeasuredHeight();
                int i38 = childrenHeight + params2.mLayoutMarginTop;
                int i39 = params2.mLayoutGravity;
                if ((i39 & 4) != 0) {
                    i19 = ((i17 + i3) - comMeasuredWidth2) >> 1;
                } else if ((i39 & 2) != 0) {
                    i19 = (((i17 - this.mPaddingRight) - this.mBorderWidth) - params2.mLayoutMarginRight) - comMeasuredWidth2;
                } else {
                    i19 = this.mPaddingLeft + i3 + this.mBorderWidth + params2.mLayoutMarginLeft;
                }
                viewBase2.comLayout(i19, i38, comMeasuredWidth2 + i19, i38 + comMeasuredHeight2);
                childrenHeight = i38 + comMeasuredHeight2 + params2.mLayoutMarginBottom;
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        this.mMeasureChildrenWidth = 0;
        this.mMeasureChildrenHeight = 0;
        int i17 = this.mAutoDimDirection;
        if (i17 > 0) {
            if (i17 != 1) {
                if (i17 == 2 && 1073741824 == View.MeasureSpec.getMode(i16)) {
                    i3 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i16) * this.mAutoDimX) / this.mAutoDimY), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i3)) {
                i16 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i3) * this.mAutoDimY) / this.mAutoDimX), 1073741824);
            }
        }
        int i18 = this.mOrientation;
        if (i18 != 0) {
            if (i18 == 1) {
                measureHorizontal(i3, i16);
                return;
            }
            return;
        }
        measureVertical(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, String str) {
        boolean attribute = super.setAttribute(i3, str);
        if (!attribute && i3 == 12) {
            if (TextUtils.equals("vertical", str)) {
                this.mOrientation = 0;
            } else {
                this.mOrientation = 1;
            }
        }
        return attribute;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout
    public Params generateParams() {
        return new Params();
    }
}
