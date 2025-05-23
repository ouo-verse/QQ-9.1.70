package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

/* compiled from: P */
/* loaded from: classes.dex */
public class VirtualLayout extends HelperWidget {
    private int mPaddingTop = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingEnd = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;
    private boolean mNeedsCallFromSolver = false;
    private int mMeasuredWidth = 0;
    private int mMeasuredHeight = 0;
    protected BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    BasicMeasure.Measurer mMeasurer = null;

    public void applyRtl(boolean z16) {
        int i3 = this.mPaddingStart;
        if (i3 > 0 || this.mPaddingEnd > 0) {
            if (z16) {
                this.mResolvedPaddingLeft = this.mPaddingEnd;
                this.mResolvedPaddingRight = i3;
            } else {
                this.mResolvedPaddingLeft = i3;
                this.mResolvedPaddingRight = this.mPaddingEnd;
            }
        }
    }

    public void captureWidgets() {
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            ConstraintWidget constraintWidget = this.mWidgets[i3];
            if (constraintWidget != null) {
                constraintWidget.setInVirtualLayout(true);
            }
        }
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int i3, int i16, int i17, int i18) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean measureChildren() {
        BasicMeasure.Measurer measurer;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null) {
            measurer = ((ConstraintWidgetContainer) constraintWidget).getMeasurer();
        } else {
            measurer = null;
        }
        if (measurer == null) {
            return false;
        }
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= this.mWidgetsCount) {
                return true;
            }
            ConstraintWidget constraintWidget2 = this.mWidgets[i3];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultWidth == 1 || dimensionBehaviour2 != dimensionBehaviour3 || constraintWidget2.mMatchConstraintDefaultHeight == 1) {
                    z16 = false;
                }
                if (!z16) {
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.mMeasure;
                    measure.horizontalBehavior = dimensionBehaviour;
                    measure.verticalBehavior = dimensionBehaviour2;
                    measure.horizontalDimension = constraintWidget2.getWidth();
                    this.mMeasure.verticalDimension = constraintWidget2.getHeight();
                    measurer.measure(constraintWidget2, this.mMeasure);
                    constraintWidget2.setWidth(this.mMeasure.measuredWidth);
                    constraintWidget2.setHeight(this.mMeasure.measuredHeight);
                    constraintWidget2.setBaselineDistance(this.mMeasure.measuredBaseline);
                }
            }
            i3++;
        }
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void needsCallbackFromSolver(boolean z16) {
        this.mNeedsCallFromSolver = z16;
    }

    public void setMeasure(int i3, int i16) {
        this.mMeasuredWidth = i3;
        this.mMeasuredHeight = i16;
    }

    public void setPadding(int i3) {
        this.mPaddingLeft = i3;
        this.mPaddingTop = i3;
        this.mPaddingRight = i3;
        this.mPaddingBottom = i3;
        this.mPaddingStart = i3;
        this.mPaddingEnd = i3;
    }

    public void setPaddingBottom(int i3) {
        this.mPaddingBottom = i3;
    }

    public void setPaddingEnd(int i3) {
        this.mPaddingEnd = i3;
    }

    public void setPaddingLeft(int i3) {
        this.mPaddingLeft = i3;
        this.mResolvedPaddingLeft = i3;
    }

    public void setPaddingRight(int i3) {
        this.mPaddingRight = i3;
        this.mResolvedPaddingRight = i3;
    }

    public void setPaddingStart(int i3) {
        this.mPaddingStart = i3;
        this.mResolvedPaddingLeft = i3;
        this.mResolvedPaddingRight = i3;
    }

    public void setPaddingTop(int i3) {
        this.mPaddingTop = i3;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        captureWidgets();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i3, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i16) {
        while (this.mMeasurer == null && getParent() != null) {
            this.mMeasurer = ((ConstraintWidgetContainer) getParent()).getMeasurer();
        }
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i3;
        measure.verticalDimension = i16;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }
}
