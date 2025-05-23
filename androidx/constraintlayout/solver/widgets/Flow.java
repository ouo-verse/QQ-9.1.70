package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i3, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i16) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i3;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i16;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i3 = this.mCount;
            for (int i16 = 0; i16 < i3 && this.mStartIndex + i16 < Flow.this.mDisplayedWidgetsCount; i16++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                if (this.mOrientation != 0) {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i17 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i17 = 0;
                    }
                    this.mHeight += widgetHeight + i17;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                } else {
                    int width = constraintWidget.getWidth();
                    int i18 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i18 = 0;
                    }
                    this.mWidth += width + i18;
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight2) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight2;
                        this.mHeight = widgetHeight2;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i3 = 0;
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                int i16 = Flow.this.mHorizontalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i3 = i16;
                }
                this.mWidth += widgetWidth + i3;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                int i17 = Flow.this.mVerticalGap;
                if (constraintWidget.getVisibility() != 8) {
                    i3 = i17;
                }
                this.mHeight += widgetHeight2 + i3;
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z16, int i3, boolean z17) {
            boolean z18;
            ConstraintWidget constraintWidget;
            int i16;
            char c16;
            int i17;
            int i18;
            int i19 = this.mCount;
            for (int i26 = 0; i26 < i19 && this.mStartIndex + i26 < Flow.this.mDisplayedWidgetsCount; i26++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i26];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i19 != 0 && this.biggest != null) {
                if (z17 && i3 == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                int i27 = -1;
                int i28 = -1;
                for (int i29 = 0; i29 < i19; i29++) {
                    if (z16) {
                        i18 = (i19 - 1) - i29;
                    } else {
                        i18 = i29;
                    }
                    if (this.mStartIndex + i18 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    if (Flow.this.mDisplayedWidgets[this.mStartIndex + i18].getVisibility() == 0) {
                        if (i27 == -1) {
                            i27 = i29;
                        }
                        i28 = i29;
                    }
                }
                ConstraintWidget constraintWidget3 = null;
                if (this.mOrientation == 0) {
                    ConstraintWidget constraintWidget4 = this.biggest;
                    constraintWidget4.setVerticalChainStyle(Flow.this.mVerticalStyle);
                    int i36 = this.mPaddingTop;
                    if (i3 > 0) {
                        i36 += Flow.this.mVerticalGap;
                    }
                    constraintWidget4.mTop.connect(this.mTop, i36);
                    if (z17) {
                        constraintWidget4.mBottom.connect(this.mBottom, this.mPaddingBottom);
                    }
                    if (i3 > 0) {
                        this.mTop.mOwner.mBottom.connect(constraintWidget4.mTop, 0);
                    }
                    if (Flow.this.mVerticalAlign == 3 && !constraintWidget4.hasBaseline()) {
                        for (int i37 = 0; i37 < i19; i37++) {
                            if (z16) {
                                i17 = (i19 - 1) - i37;
                            } else {
                                i17 = i37;
                            }
                            if (this.mStartIndex + i17 >= Flow.this.mDisplayedWidgetsCount) {
                                break;
                            }
                            constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i17];
                            if (constraintWidget.hasBaseline()) {
                                break;
                            }
                        }
                    }
                    constraintWidget = constraintWidget4;
                    int i38 = 0;
                    while (i38 < i19) {
                        if (z16) {
                            i16 = (i19 - 1) - i38;
                        } else {
                            i16 = i38;
                        }
                        if (this.mStartIndex + i16 < Flow.this.mDisplayedWidgetsCount) {
                            ConstraintWidget constraintWidget5 = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                            if (i38 == 0) {
                                constraintWidget5.connect(constraintWidget5.mLeft, this.mLeft, this.mPaddingLeft);
                            }
                            if (i16 == 0) {
                                int i39 = Flow.this.mHorizontalStyle;
                                float f16 = Flow.this.mHorizontalBias;
                                if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                                    i39 = Flow.this.mFirstHorizontalStyle;
                                    f16 = Flow.this.mFirstHorizontalBias;
                                } else if (z17 && Flow.this.mLastHorizontalStyle != -1) {
                                    i39 = Flow.this.mLastHorizontalStyle;
                                    f16 = Flow.this.mLastHorizontalBias;
                                }
                                constraintWidget5.setHorizontalChainStyle(i39);
                                constraintWidget5.setHorizontalBiasPercent(f16);
                            }
                            if (i38 == i19 - 1) {
                                constraintWidget5.connect(constraintWidget5.mRight, this.mRight, this.mPaddingRight);
                            }
                            if (constraintWidget3 != null) {
                                constraintWidget5.mLeft.connect(constraintWidget3.mRight, Flow.this.mHorizontalGap);
                                if (i38 == i27) {
                                    constraintWidget5.mLeft.setGoneMargin(this.mPaddingLeft);
                                }
                                constraintWidget3.mRight.connect(constraintWidget5.mLeft, 0);
                                if (i38 == i28 + 1) {
                                    constraintWidget3.mRight.setGoneMargin(this.mPaddingRight);
                                }
                            }
                            if (constraintWidget5 != constraintWidget4) {
                                c16 = 3;
                                if (Flow.this.mVerticalAlign != 3 || !constraintWidget.hasBaseline() || constraintWidget5 == constraintWidget || !constraintWidget5.hasBaseline()) {
                                    int i46 = Flow.this.mVerticalAlign;
                                    if (i46 != 0) {
                                        if (i46 != 1) {
                                            if (z18) {
                                                constraintWidget5.mTop.connect(this.mTop, this.mPaddingTop);
                                                constraintWidget5.mBottom.connect(this.mBottom, this.mPaddingBottom);
                                            } else {
                                                constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                                constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                            }
                                        } else {
                                            constraintWidget5.mBottom.connect(constraintWidget4.mBottom, 0);
                                        }
                                    } else {
                                        constraintWidget5.mTop.connect(constraintWidget4.mTop, 0);
                                    }
                                } else {
                                    constraintWidget5.mBaseline.connect(constraintWidget.mBaseline, 0);
                                }
                            } else {
                                c16 = 3;
                            }
                            i38++;
                            constraintWidget3 = constraintWidget5;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                ConstraintWidget constraintWidget6 = this.biggest;
                constraintWidget6.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i47 = this.mPaddingLeft;
                if (i3 > 0) {
                    i47 += Flow.this.mHorizontalGap;
                }
                if (z16) {
                    constraintWidget6.mRight.connect(this.mRight, i47);
                    if (z17) {
                        constraintWidget6.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i3 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget6.mRight, 0);
                    }
                } else {
                    constraintWidget6.mLeft.connect(this.mLeft, i47);
                    if (z17) {
                        constraintWidget6.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i3 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget6.mLeft, 0);
                    }
                }
                int i48 = 0;
                while (i48 < i19 && this.mStartIndex + i48 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget7 = Flow.this.mDisplayedWidgets[this.mStartIndex + i48];
                    if (i48 == 0) {
                        constraintWidget7.connect(constraintWidget7.mTop, this.mTop, this.mPaddingTop);
                        int i49 = Flow.this.mVerticalStyle;
                        float f17 = Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                            i49 = Flow.this.mFirstVerticalStyle;
                            f17 = Flow.this.mFirstVerticalBias;
                        } else if (z17 && Flow.this.mLastVerticalStyle != -1) {
                            i49 = Flow.this.mLastVerticalStyle;
                            f17 = Flow.this.mLastVerticalBias;
                        }
                        constraintWidget7.setVerticalChainStyle(i49);
                        constraintWidget7.setVerticalBiasPercent(f17);
                    }
                    if (i48 == i19 - 1) {
                        constraintWidget7.connect(constraintWidget7.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget3 != null) {
                        constraintWidget7.mTop.connect(constraintWidget3.mBottom, Flow.this.mVerticalGap);
                        if (i48 == i27) {
                            constraintWidget7.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget3.mBottom.connect(constraintWidget7.mTop, 0);
                        if (i48 == i28 + 1) {
                            constraintWidget3.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget7 != constraintWidget6) {
                        if (z16) {
                            int i56 = Flow.this.mHorizontalAlign;
                            if (i56 != 0) {
                                if (i56 != 1) {
                                    if (i56 == 2) {
                                        constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                        constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                    }
                                } else {
                                    constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                }
                            } else {
                                constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                            }
                        } else {
                            int i57 = Flow.this.mHorizontalAlign;
                            if (i57 != 0) {
                                if (i57 != 1) {
                                    if (i57 == 2) {
                                        if (z18) {
                                            constraintWidget7.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                            constraintWidget7.mRight.connect(this.mRight, this.mPaddingRight);
                                        } else {
                                            constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                                            constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                        }
                                    }
                                } else {
                                    constraintWidget7.mRight.connect(constraintWidget6.mRight, 0);
                                }
                            } else {
                                constraintWidget7.mLeft.connect(constraintWidget6.mLeft, 0);
                            }
                            i48++;
                            constraintWidget3 = constraintWidget7;
                        }
                    }
                    i48++;
                    constraintWidget3 = constraintWidget7;
                }
            }
        }

        public int getHeight() {
            if (this.mOrientation == 1) {
                return this.mHeight - Flow.this.mVerticalGap;
            }
            return this.mHeight;
        }

        public int getWidth() {
            if (this.mOrientation == 0) {
                return this.mWidth - Flow.this.mHorizontalGap;
            }
            return this.mWidth;
        }

        public void measureMatchConstraints(int i3) {
            int i16 = this.mNbMatchConstraintsWidgets;
            if (i16 == 0) {
                return;
            }
            int i17 = this.mCount;
            int i18 = i3 / i16;
            for (int i19 = 0; i19 < i17 && this.mStartIndex + i19 < Flow.this.mDisplayedWidgetsCount; i19++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i19];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i18, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i18);
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i3) {
            this.mStartIndex = i3;
        }

        public void setup(int i3, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i16, int i17, int i18, int i19, int i26) {
            this.mOrientation = i3;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i16;
            this.mPaddingTop = i17;
            this.mPaddingRight = i18;
            this.mPaddingBottom = i19;
            this.mMax = i26;
        }
    }

    private void createAlignedConstraints(boolean z16) {
        ConstraintWidget constraintWidget;
        int i3;
        if (this.mAlignedDimensions != null && this.mAlignedBiggestElementsInCols != null && this.mAlignedBiggestElementsInRows != null) {
            for (int i16 = 0; i16 < this.mDisplayedWidgetsCount; i16++) {
                this.mDisplayedWidgets[i16].resetAnchors();
            }
            int[] iArr = this.mAlignedDimensions;
            int i17 = iArr[0];
            int i18 = iArr[1];
            ConstraintWidget constraintWidget2 = null;
            for (int i19 = 0; i19 < i17; i19++) {
                if (z16) {
                    i3 = (i17 - i19) - 1;
                } else {
                    i3 = i19;
                }
                ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i3];
                if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                    if (i19 == 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                        constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                    }
                    if (i19 == i17 - 1) {
                        constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                    }
                    if (i19 > 0) {
                        constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                        constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                    }
                    constraintWidget2 = constraintWidget3;
                }
            }
            for (int i26 = 0; i26 < i18; i26++) {
                ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i26];
                if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                    if (i26 == 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                        constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (i26 == i18 - 1) {
                        constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                    }
                    if (i26 > 0) {
                        constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                        constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                    }
                    constraintWidget2 = constraintWidget4;
                }
            }
            for (int i27 = 0; i27 < i17; i27++) {
                for (int i28 = 0; i28 < i18; i28++) {
                    int i29 = (i28 * i17) + i27;
                    if (this.mOrientation == 1) {
                        i29 = (i27 * i18) + i28;
                    }
                    ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                    if (i29 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i29]) != null && constraintWidget.getVisibility() != 8) {
                        ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i27];
                        ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i28];
                        if (constraintWidget != constraintWidget5) {
                            constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                            constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                        }
                        if (constraintWidget != constraintWidget6) {
                            constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                            constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i3) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i16 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i16 == 0) {
                return 0;
            }
            if (i16 == 2) {
                int i17 = (int) (constraintWidget.mMatchConstraintPercentHeight * i3);
                if (i17 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i17);
                }
                return i17;
            }
            if (i16 == 1) {
                return constraintWidget.getHeight();
            }
            if (i16 == 3) {
                return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i3) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i16 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i16 == 0) {
                return 0;
            }
            if (i16 == 2) {
                int i17 = (int) (constraintWidget.mMatchConstraintPercentWidth * i3);
                if (i17 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i17, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i17;
            }
            if (i16 == 1) {
                return constraintWidget.getWidth();
            }
            if (i16 == 3) {
                return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x010d -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x010f -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0115 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0117 -> B:22:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureAligned(ConstraintWidget[] constraintWidgetArr, int i3, int i16, int i17, int[] iArr) {
        int i18;
        int i19;
        boolean z16;
        ConstraintWidget constraintWidget;
        if (i16 == 0) {
            int i26 = this.mMaxElementsWrap;
            if (i26 <= 0) {
                i26 = 0;
                int i27 = 0;
                for (int i28 = 0; i28 < i3; i28++) {
                    if (i28 > 0) {
                        i27 += this.mHorizontalGap;
                    }
                    ConstraintWidget constraintWidget2 = constraintWidgetArr[i28];
                    if (constraintWidget2 != null) {
                        i27 += getWidgetWidth(constraintWidget2, i17);
                        if (i27 > i17) {
                            break;
                        } else {
                            i26++;
                        }
                    }
                }
            }
            i19 = i26;
            i18 = 0;
        } else {
            i18 = this.mMaxElementsWrap;
            if (i18 <= 0) {
                i18 = 0;
                int i29 = 0;
                for (int i36 = 0; i36 < i3; i36++) {
                    if (i36 > 0) {
                        i29 += this.mVerticalGap;
                    }
                    ConstraintWidget constraintWidget3 = constraintWidgetArr[i36];
                    if (constraintWidget3 != null) {
                        i29 += getWidgetHeight(constraintWidget3, i17);
                        if (i29 > i17) {
                            break;
                        } else {
                            i18++;
                        }
                    }
                }
            }
            i19 = 0;
        }
        if (this.mAlignedDimensions == null) {
            this.mAlignedDimensions = new int[2];
        }
        if ((i18 != 0 || i16 != 1) && (i19 != 0 || i16 != 0)) {
            z16 = false;
            while (!z16) {
                if (i16 == 0) {
                    i18 = (int) Math.ceil(i3 / i19);
                } else {
                    i19 = (int) Math.ceil(i3 / i18);
                }
                ConstraintWidget[] constraintWidgetArr2 = this.mAlignedBiggestElementsInCols;
                if (constraintWidgetArr2 != null && constraintWidgetArr2.length >= i19) {
                    Arrays.fill(constraintWidgetArr2, (Object) null);
                } else {
                    this.mAlignedBiggestElementsInCols = new ConstraintWidget[i19];
                }
                ConstraintWidget[] constraintWidgetArr3 = this.mAlignedBiggestElementsInRows;
                if (constraintWidgetArr3 != null && constraintWidgetArr3.length >= i18) {
                    Arrays.fill(constraintWidgetArr3, (Object) null);
                } else {
                    this.mAlignedBiggestElementsInRows = new ConstraintWidget[i18];
                }
                for (int i37 = 0; i37 < i19; i37++) {
                    for (int i38 = 0; i38 < i18; i38++) {
                        int i39 = (i38 * i19) + i37;
                        if (i16 == 1) {
                            i39 = (i37 * i18) + i38;
                        }
                        if (i39 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i39]) != null) {
                            int widgetWidth = getWidgetWidth(constraintWidget, i17);
                            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInCols[i37];
                            if (constraintWidget4 == null || constraintWidget4.getWidth() < widgetWidth) {
                                this.mAlignedBiggestElementsInCols[i37] = constraintWidget;
                            }
                            int widgetHeight = getWidgetHeight(constraintWidget, i17);
                            ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInRows[i38];
                            if (constraintWidget5 == null || constraintWidget5.getHeight() < widgetHeight) {
                                this.mAlignedBiggestElementsInRows[i38] = constraintWidget;
                            }
                        }
                    }
                }
                int i46 = 0;
                for (int i47 = 0; i47 < i19; i47++) {
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInCols[i47];
                    if (constraintWidget6 != null) {
                        if (i47 > 0) {
                            i46 += this.mHorizontalGap;
                        }
                        i46 += getWidgetWidth(constraintWidget6, i17);
                    }
                }
                int i48 = 0;
                for (int i49 = 0; i49 < i18; i49++) {
                    ConstraintWidget constraintWidget7 = this.mAlignedBiggestElementsInRows[i49];
                    if (constraintWidget7 != null) {
                        if (i49 > 0) {
                            i48 += this.mVerticalGap;
                        }
                        i48 += getWidgetHeight(constraintWidget7, i17);
                    }
                }
                iArr[0] = i46;
                iArr[1] = i48;
                if (i16 == 0) {
                    if (i46 > i17 && i19 > 1) {
                        i19--;
                    }
                } else if (i48 > i17 && i18 > 1) {
                    i18--;
                }
                while (!z16) {
                }
            }
            int[] iArr2 = this.mAlignedDimensions;
            iArr2[0] = i19;
            iArr2[1] = i18;
        }
        z16 = true;
        while (!z16) {
        }
        int[] iArr22 = this.mAlignedDimensions;
        iArr22[0] = i19;
        iArr22[1] = i18;
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i3, int i16, int i17, int[] iArr) {
        int i18;
        boolean z16;
        int i19;
        boolean z17;
        int i26;
        ConstraintAnchor constraintAnchor;
        int paddingRight;
        ConstraintAnchor constraintAnchor2;
        int paddingBottom;
        boolean z18;
        int i27;
        if (i3 == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(i16, this.mLeft, this.mTop, this.mRight, this.mBottom, i17);
        this.mChainList.add(widgetsList);
        if (i16 == 0) {
            i18 = 0;
            int i28 = 0;
            int i29 = 0;
            while (i29 < i3) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i29];
                int widgetWidth = getWidgetWidth(constraintWidget, i17);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i18++;
                }
                int i36 = i18;
                if ((i28 == i17 || this.mHorizontalGap + i28 + widgetWidth > i17) && widgetsList.biggest != null) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (!z18 && i29 > 0 && (i27 = this.mMaxElementsWrap) > 0 && i29 % i27 == 0) {
                    z18 = true;
                }
                if (z18) {
                    widgetsList = new WidgetsList(i16, this.mLeft, this.mTop, this.mRight, this.mBottom, i17);
                    widgetsList.setStartIndex(i29);
                    this.mChainList.add(widgetsList);
                } else if (i29 > 0) {
                    i28 += this.mHorizontalGap + widgetWidth;
                    widgetsList.add(constraintWidget);
                    i29++;
                    i18 = i36;
                }
                i28 = widgetWidth;
                widgetsList.add(constraintWidget);
                i29++;
                i18 = i36;
            }
        } else {
            i18 = 0;
            int i37 = 0;
            int i38 = 0;
            while (i38 < i3) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i38];
                int widgetHeight = getWidgetHeight(constraintWidget2, i17);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i18++;
                }
                int i39 = i18;
                if ((i37 == i17 || this.mVerticalGap + i37 + widgetHeight > i17) && widgetsList.biggest != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && i38 > 0 && (i19 = this.mMaxElementsWrap) > 0 && i38 % i19 == 0) {
                    z16 = true;
                }
                if (z16) {
                    widgetsList = new WidgetsList(i16, this.mLeft, this.mTop, this.mRight, this.mBottom, i17);
                    widgetsList.setStartIndex(i38);
                    this.mChainList.add(widgetsList);
                } else if (i38 > 0) {
                    i37 += this.mVerticalGap + widgetHeight;
                    widgetsList.add(constraintWidget2);
                    i38++;
                    i18 = i39;
                }
                i37 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i38++;
                i18 = i39;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = this.mTop;
        ConstraintAnchor constraintAnchor5 = this.mRight;
        ConstraintAnchor constraintAnchor6 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight2 = getPaddingRight();
        int paddingBottom2 = getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (horizontalDimensionBehaviour != dimensionBehaviour && getVerticalDimensionBehaviour() != dimensionBehaviour) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (i18 > 0 && z17) {
            for (int i46 = 0; i46 < size; i46++) {
                WidgetsList widgetsList2 = this.mChainList.get(i46);
                if (i16 == 0) {
                    widgetsList2.measureMatchConstraints(i17 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i17 - widgetsList2.getHeight());
                }
            }
        }
        int i47 = paddingTop;
        int i48 = paddingRight2;
        int i49 = 0;
        int i56 = 0;
        int i57 = 0;
        int i58 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor3;
        int i59 = paddingBottom2;
        while (i57 < size) {
            WidgetsList widgetsList3 = this.mChainList.get(i57);
            if (i16 == 0) {
                if (i57 < size - 1) {
                    constraintAnchor2 = this.mChainList.get(i57 + 1).biggest.mTop;
                    paddingBottom = 0;
                } else {
                    constraintAnchor2 = this.mBottom;
                    paddingBottom = getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor9 = widgetsList3.biggest.mBottom;
                ConstraintAnchor constraintAnchor10 = constraintAnchor8;
                ConstraintAnchor constraintAnchor11 = constraintAnchor8;
                int i65 = i49;
                ConstraintAnchor constraintAnchor12 = constraintAnchor7;
                int i66 = i56;
                ConstraintAnchor constraintAnchor13 = constraintAnchor5;
                ConstraintAnchor constraintAnchor14 = constraintAnchor5;
                i26 = i57;
                widgetsList3.setup(i16, constraintAnchor10, constraintAnchor12, constraintAnchor13, constraintAnchor2, i58, i47, i48, paddingBottom, i17);
                int max = Math.max(i66, widgetsList3.getWidth());
                i49 = i65 + widgetsList3.getHeight();
                if (i26 > 0) {
                    i49 += this.mVerticalGap;
                }
                constraintAnchor8 = constraintAnchor11;
                i56 = max;
                i47 = 0;
                constraintAnchor7 = constraintAnchor9;
                constraintAnchor = constraintAnchor14;
                int i67 = paddingBottom;
                constraintAnchor6 = constraintAnchor2;
                i59 = i67;
            } else {
                ConstraintAnchor constraintAnchor15 = constraintAnchor8;
                int i68 = i49;
                int i69 = i56;
                i26 = i57;
                if (i26 < size - 1) {
                    constraintAnchor = this.mChainList.get(i26 + 1).biggest.mLeft;
                    paddingRight = 0;
                } else {
                    constraintAnchor = this.mRight;
                    paddingRight = getPaddingRight();
                }
                ConstraintAnchor constraintAnchor16 = widgetsList3.biggest.mRight;
                widgetsList3.setup(i16, constraintAnchor15, constraintAnchor7, constraintAnchor, constraintAnchor6, i58, i47, paddingRight, i59, i17);
                i56 = i69 + widgetsList3.getWidth();
                int max2 = Math.max(i68, widgetsList3.getHeight());
                if (i26 > 0) {
                    i56 += this.mHorizontalGap;
                }
                i49 = max2;
                i58 = 0;
                i48 = paddingRight;
                constraintAnchor8 = constraintAnchor16;
            }
            i57 = i26 + 1;
            constraintAnchor5 = constraintAnchor;
        }
        iArr[0] = i56;
        iArr[1] = i49;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i3, int i16, int i17, int[] iArr) {
        WidgetsList widgetsList;
        if (i3 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i16, this.mLeft, this.mTop, this.mRight, this.mBottom, i17);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i16, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i17);
        }
        for (int i18 = 0; i18 < i3; i18++) {
            widgetsList.add(constraintWidgetArr[i18]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z16) {
        boolean z17;
        boolean z18;
        super.addToSolver(linearSystem, z16);
        if (getParent() != null) {
            z17 = ((ConstraintWidgetContainer) getParent()).isRtl();
        } else {
            z17 = false;
        }
        int i3 = this.mWrapMode;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    createAlignedConstraints(z17);
                }
            } else {
                int size = this.mChainList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    WidgetsList widgetsList = this.mChainList.get(i16);
                    if (i16 == size - 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    widgetsList.createConstraints(z17, i16, z18);
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z17, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    public void measure(int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        int[] iArr;
        boolean z16;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr2 = new int[2];
        int i27 = (i16 - paddingLeft) - paddingRight;
        int i28 = this.mOrientation;
        if (i28 == 1) {
            i27 = (i18 - paddingTop) - paddingBottom;
        }
        int i29 = i27;
        if (i28 == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i36 = 0;
        int i37 = 0;
        while (true) {
            i19 = this.mWidgetsCount;
            if (i36 >= i19) {
                break;
            }
            if (this.mWidgets[i36].getVisibility() == 8) {
                i37++;
            }
            i36++;
        }
        if (i37 > 0) {
            constraintWidgetArr = new ConstraintWidget[i19 - i37];
            int i38 = 0;
            for (int i39 = 0; i39 < this.mWidgetsCount; i39++) {
                ConstraintWidget constraintWidget = this.mWidgets[i39];
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr[i38] = constraintWidget;
                    i38++;
                }
            }
            i26 = i38;
        } else {
            i26 = i19;
        }
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i26;
        int i46 = this.mWrapMode;
        if (i46 != 0) {
            if (i46 != 1) {
                if (i46 != 2) {
                    z16 = true;
                    iArr = iArr2;
                } else {
                    z16 = true;
                    iArr = iArr2;
                    measureAligned(constraintWidgetArr, i26, this.mOrientation, i29, iArr2);
                }
            } else {
                z16 = true;
                iArr = iArr2;
                measureChainWrap(constraintWidgetArr, i26, this.mOrientation, i29, iArr2);
            }
        } else {
            iArr = iArr2;
            z16 = true;
            measureNoWrap(constraintWidgetArr, i26, this.mOrientation, i29, iArr2);
        }
        int i47 = iArr[0] + paddingLeft + paddingRight;
        int i48 = iArr[z16 ? 1 : 0] + paddingTop + paddingBottom;
        if (i3 == 1073741824) {
            i47 = i16;
        } else if (i3 == Integer.MIN_VALUE) {
            i47 = Math.min(i47, i16);
        } else if (i3 != 0) {
            i47 = 0;
        }
        if (i17 == 1073741824) {
            i48 = i18;
        } else if (i17 == Integer.MIN_VALUE) {
            i48 = Math.min(i48, i18);
        } else if (i17 != 0) {
            i48 = 0;
        }
        setMeasure(i47, i48);
        setWidth(i47);
        setHeight(i48);
        if (this.mWidgetsCount <= 0) {
            z16 = false;
        }
        needsCallbackFromSolver(z16);
    }

    public void setFirstHorizontalBias(float f16) {
        this.mFirstHorizontalBias = f16;
    }

    public void setFirstHorizontalStyle(int i3) {
        this.mFirstHorizontalStyle = i3;
    }

    public void setFirstVerticalBias(float f16) {
        this.mFirstVerticalBias = f16;
    }

    public void setFirstVerticalStyle(int i3) {
        this.mFirstVerticalStyle = i3;
    }

    public void setHorizontalAlign(int i3) {
        this.mHorizontalAlign = i3;
    }

    public void setHorizontalBias(float f16) {
        this.mHorizontalBias = f16;
    }

    public void setHorizontalGap(int i3) {
        this.mHorizontalGap = i3;
    }

    public void setHorizontalStyle(int i3) {
        this.mHorizontalStyle = i3;
    }

    public void setLastHorizontalBias(float f16) {
        this.mLastHorizontalBias = f16;
    }

    public void setLastHorizontalStyle(int i3) {
        this.mLastHorizontalStyle = i3;
    }

    public void setLastVerticalBias(float f16) {
        this.mLastVerticalBias = f16;
    }

    public void setLastVerticalStyle(int i3) {
        this.mLastVerticalStyle = i3;
    }

    public void setMaxElementsWrap(int i3) {
        this.mMaxElementsWrap = i3;
    }

    public void setOrientation(int i3) {
        this.mOrientation = i3;
    }

    public void setVerticalAlign(int i3) {
        this.mVerticalAlign = i3;
    }

    public void setVerticalBias(float f16) {
        this.mVerticalBias = f16;
    }

    public void setVerticalGap(int i3) {
        this.mVerticalGap = i3;
    }

    public void setVerticalStyle(int i3) {
        this.mVerticalStyle = i3;
    }

    public void setWrapMode(int i3) {
        this.mWrapMode = i3;
    }
}
