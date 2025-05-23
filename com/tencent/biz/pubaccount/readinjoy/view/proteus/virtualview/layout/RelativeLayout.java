package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.RelativeLayoutHelper;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RelativeLayout extends Layout {
    private static final String TAG = "RelativeLayout_TMTEST";
    private RelativeLayoutHelper relativeLayoutHelper;
    private List<ViewBase> sortedHorizontalView;
    private List<ViewBase> sortedVerticalView;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder implements ViewBase.IBuilder {
        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder
        public ViewBase build(VafContext vafContext) {
            return new RelativeLayout(vafContext);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Params extends Layout.Params {
        public static final int ABOVE_OF = 0;
        public static final int ALIGN_PARENT_BOTTOM = 7;
        public static final int ALIGN_PARENT_CENTER = 10;
        public static final int ALIGN_PARENT_CENTER_HORIZONTAL = 9;
        public static final int ALIGN_PARENT_CENTER_VERTICAL = 8;
        public static final int ALIGN_PARENT_LEFT = 4;
        public static final int ALIGN_PARENT_RIGHT = 5;
        public static final int ALIGN_PARENT_TOP = 6;
        public static final int BELOW_OF = 1;
        public static final int LEFT_OF = 2;
        public static final int RIGHT_OF = 3;
        public static final int RULE_COUNT = 11;
        public boolean alignWithParent;
        public int mBottom;
        public int mLeft;
        public int mRight;
        public int mTop;
        private String[] rule = new String[11];
        public static final int[] RULES_VERTICAL = {0, 1};
        public static final int[] RULES_HORIZONTAL = {2, 3};

        public String[] getRule() {
            return this.rule;
        }

        @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params
        public boolean setAttribute(int i3, String str) {
            boolean attribute = super.setAttribute(i3, str);
            if (attribute) {
                return attribute;
            }
            switch (i3) {
                case 25:
                    setRule(3, str);
                    break;
                case 26:
                    setRule(2, str);
                    break;
                case 27:
                    setRule(0, str);
                    break;
                case 28:
                    setRule(1, str);
                    break;
                case 29:
                    setRule(4, str);
                    break;
                case 30:
                    setRule(5, str);
                    break;
                case 31:
                    setRule(6, str);
                    break;
                case 32:
                    setRule(7, str);
                    break;
                case 33:
                    setRule(8, str);
                    break;
                case 34:
                    setRule(9, str);
                    break;
                case 35:
                    setRule(10, str);
                    break;
            }
            return false;
        }

        public void setRule(int i3, String str) {
            this.rule[i3] = str;
        }
    }

    public RelativeLayout(VafContext vafContext) {
        super(vafContext);
        this.relativeLayoutHelper = new RelativeLayoutHelper();
    }

    private int getMaxHeight() {
        int i3 = 0;
        for (ViewBase viewBase : this.mSubViews) {
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                int comMeasuredHeight = params.mTop + viewBase.getComMeasuredHeight() + params.mLayoutMarginBottom;
                if (comMeasuredHeight > i3) {
                    i3 = comMeasuredHeight;
                }
            }
        }
        return i3 + this.mPaddingBottom + (this.mBorderWidth << 1);
    }

    private int getMaxWidth() {
        int i3 = 0;
        for (ViewBase viewBase : this.mSubViews) {
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                int comMeasuredWidth = params.mLeft + viewBase.getComMeasuredWidth() + params.mLayoutMarginRight;
                if (comMeasuredWidth > i3) {
                    i3 = comMeasuredWidth;
                }
            }
        }
        return i3 + this.mPaddingRight + (this.mBorderWidth << 1);
    }

    private int getRealHeight(int i3, int i16) {
        if (Integer.MIN_VALUE == i3) {
            return getMaxHeight();
        }
        if (1073741824 != i3) {
            return getMaxHeight();
        }
        return i16;
    }

    private int getRealWidth(int i3, int i16) {
        if (Integer.MIN_VALUE == i3) {
            return getMaxWidth();
        }
        if (1073741824 != i3) {
            return getMaxWidth();
        }
        return i16;
    }

    private List<ViewBase> sortHorizontal() {
        List<ViewBase> list = this.sortedHorizontalView;
        if (list == null || list.size() != this.mSubViews.size()) {
            if (this.relativeLayoutHelper.getParent() == null) {
                this.relativeLayoutHelper.setParent(this);
            }
            this.sortedHorizontalView = this.relativeLayoutHelper.getHorizontalSortedView();
        }
        return this.sortedHorizontalView;
    }

    private List<ViewBase> sortVertical() {
        List<ViewBase> list = this.sortedVerticalView;
        if (list == null || list.size() != this.mSubViews.size()) {
            if (this.relativeLayoutHelper.getParent() == null) {
                this.relativeLayoutHelper.setParent(this);
            }
            this.sortedVerticalView = this.relativeLayoutHelper.getVerticalSortedView();
        }
        return this.sortedVerticalView;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComLayout(boolean z16, int i3, int i16, int i17, int i18) {
        for (ViewBase viewBase : this.mSubViews) {
            if (!viewBase.isGone()) {
                Params params = (Params) viewBase.getComLayoutParams();
                viewBase.comLayout(params.mLeft + i3, params.mTop + i16, params.mRight + i3, params.mBottom + i16);
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IBaseView
    public void onComMeasure(int i3, int i16) {
        boolean z16;
        int maxHeight;
        int maxWidth;
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i16);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == 0) {
            size = -1;
        }
        if (mode2 == 0) {
            size2 = -1;
        }
        List<ViewBase> sortHorizontal = sortHorizontal();
        int size3 = sortHorizontal.size();
        boolean z17 = true;
        if (mode != 1073741824) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (mode2 == 1073741824) {
            z17 = false;
        }
        for (int i17 = 0; i17 < size3; i17++) {
            ViewBase viewBase = sortHorizontal.get(i17);
            if (viewBase.getVisibility() != 8) {
                Params params = (Params) viewBase.getComLayoutParams();
                this.relativeLayoutHelper.applyHorizontalSizeRules(params, size);
                if (z16 && params.mLayoutWidth == -1 && (maxWidth = getMaxWidth()) > 0) {
                    size = maxWidth;
                }
                this.relativeLayoutHelper.measureChildHorizontal(viewBase, params, size, size2);
                this.relativeLayoutHelper.positionChildHorizontal(viewBase, params, size, z16);
            }
        }
        List<ViewBase> sortVertical = sortVertical();
        for (int i18 = 0; i18 < size3; i18++) {
            ViewBase viewBase2 = sortVertical.get(i18);
            if (viewBase2.getVisibility() != 8) {
                Params params2 = (Params) viewBase2.getComLayoutParams();
                this.relativeLayoutHelper.applyVerticalSizeRules(params2, size2);
                if (z17 && ((params2.mLayoutHeight == -1 || RelativeLayoutHelper.hasVerticleCenterRule(params2)) && (maxHeight = getMaxHeight()) > 0)) {
                    size2 = maxHeight;
                }
                this.relativeLayoutHelper.measureChild(viewBase2, params2, size, size2);
                this.relativeLayoutHelper.positionChildVertical(viewBase2, params2, size2, z17);
            }
        }
        setComMeasuredDimension(getRealWidth(mode, size), getRealHeight(mode2, size2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, String str) {
        return super.setAttribute(i3, str);
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout
    public Params generateParams() {
        return new Params();
    }
}
