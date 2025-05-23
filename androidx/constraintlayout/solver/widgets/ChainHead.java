package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class ChainHead {
    private boolean mDefined;
    protected ConstraintWidget mFirst;
    protected ConstraintWidget mFirstMatchConstraintWidget;
    protected ConstraintWidget mFirstVisibleWidget;
    protected boolean mHasComplexMatchWeights;
    protected boolean mHasDefinedWeights;
    protected boolean mHasRatio;
    protected boolean mHasUndefinedWeights;
    protected ConstraintWidget mHead;
    private boolean mIsRtl;
    protected ConstraintWidget mLast;
    protected ConstraintWidget mLastMatchConstraintWidget;
    protected ConstraintWidget mLastVisibleWidget;
    boolean mOptimizable;
    private int mOrientation;
    int mTotalMargins;
    int mTotalSize;
    protected float mTotalWeight = 0.0f;
    int mVisibleWidgets;
    protected ArrayList<ConstraintWidget> mWeightedMatchConstraintsWidgets;
    protected int mWidgetsCount;
    protected int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int i3, boolean z16) {
        this.mFirst = constraintWidget;
        this.mOrientation = i3;
        this.mIsRtl = z16;
    }

    private void defineChainProperties() {
        int i3 = this.mOrientation * 2;
        ConstraintWidget constraintWidget = this.mFirst;
        boolean z16 = true;
        this.mOptimizable = true;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z17 = false;
        while (!z17) {
            this.mWidgetsCount++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.mNextChainWidget;
            int i16 = this.mOrientation;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i16] = null;
            constraintWidget.mListNextMatchConstraintsWidget[i16] = null;
            if (constraintWidget.getVisibility() != 8) {
                this.mVisibleWidgets++;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(this.mOrientation);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour != dimensionBehaviour2) {
                    this.mTotalSize += constraintWidget.getLength(this.mOrientation);
                }
                int margin = this.mTotalSize + constraintWidget.mListAnchors[i3].getMargin();
                this.mTotalSize = margin;
                int i17 = i3 + 1;
                this.mTotalSize = margin + constraintWidget.mListAnchors[i17].getMargin();
                int margin2 = this.mTotalMargins + constraintWidget.mListAnchors[i3].getMargin();
                this.mTotalMargins = margin2;
                this.mTotalMargins = margin2 + constraintWidget.mListAnchors[i17].getMargin();
                if (this.mFirstVisibleWidget == null) {
                    this.mFirstVisibleWidget = constraintWidget;
                }
                this.mLastVisibleWidget = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
                int i18 = this.mOrientation;
                if (dimensionBehaviourArr[i18] == dimensionBehaviour2) {
                    int i19 = constraintWidget.mResolvedMatchConstraintDefault[i18];
                    if (i19 == 0 || i19 == 3 || i19 == 2) {
                        this.mWidgetsMatchCount++;
                        float f16 = constraintWidget.mWeight[i18];
                        if (f16 > 0.0f) {
                            this.mTotalWeight += f16;
                        }
                        if (isMatchConstraintEqualityCandidate(constraintWidget, i18)) {
                            if (f16 < 0.0f) {
                                this.mHasUndefinedWeights = true;
                            } else {
                                this.mHasDefinedWeights = true;
                            }
                            if (this.mWeightedMatchConstraintsWidgets == null) {
                                this.mWeightedMatchConstraintsWidgets = new ArrayList<>();
                            }
                            this.mWeightedMatchConstraintsWidgets.add(constraintWidget);
                        }
                        if (this.mFirstMatchConstraintWidget == null) {
                            this.mFirstMatchConstraintWidget = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.mLastMatchConstraintWidget;
                        if (constraintWidget4 != null) {
                            constraintWidget4.mListNextMatchConstraintsWidget[this.mOrientation] = constraintWidget;
                        }
                        this.mLastMatchConstraintWidget = constraintWidget;
                    }
                    if (this.mOrientation == 0) {
                        if (constraintWidget.mMatchConstraintDefaultWidth != 0) {
                            this.mOptimizable = false;
                        } else if (constraintWidget.mMatchConstraintMinWidth != 0 || constraintWidget.mMatchConstraintMaxWidth != 0) {
                            this.mOptimizable = false;
                        }
                    } else if (constraintWidget.mMatchConstraintDefaultHeight != 0) {
                        this.mOptimizable = false;
                    } else if (constraintWidget.mMatchConstraintMinHeight != 0 || constraintWidget.mMatchConstraintMaxHeight != 0) {
                        this.mOptimizable = false;
                    }
                    if (constraintWidget.mDimensionRatio != 0.0f) {
                        this.mOptimizable = false;
                        this.mHasRatio = true;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.mNextChainWidget[this.mOrientation] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.mListAnchors[i3 + 1].mTarget;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.mOwner;
                ConstraintAnchor constraintAnchor2 = constraintWidget5.mListAnchors[i3].mTarget;
                if (constraintAnchor2 != null && constraintAnchor2.mOwner == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z17 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.mFirstVisibleWidget;
        if (constraintWidget6 != null) {
            this.mTotalSize -= constraintWidget6.mListAnchors[i3].getMargin();
        }
        ConstraintWidget constraintWidget7 = this.mLastVisibleWidget;
        if (constraintWidget7 != null) {
            this.mTotalSize -= constraintWidget7.mListAnchors[i3 + 1].getMargin();
        }
        this.mLast = constraintWidget;
        if (this.mOrientation == 0 && this.mIsRtl) {
            this.mHead = constraintWidget;
        } else {
            this.mHead = this.mFirst;
        }
        if (!this.mHasDefinedWeights || !this.mHasUndefinedWeights) {
            z16 = false;
        }
        this.mHasComplexMatchWeights = z16;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget constraintWidget, int i3) {
        int i16;
        if (constraintWidget.getVisibility() != 8 && constraintWidget.mListDimensionBehaviors[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && ((i16 = constraintWidget.mResolvedMatchConstraintDefault[i3]) == 0 || i16 == 3)) {
            return true;
        }
        return false;
    }

    public void define() {
        if (!this.mDefined) {
            defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}
