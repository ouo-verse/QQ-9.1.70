package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.horizontalBehavior;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (measure.verticalBehavior == dimensionBehaviour2) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 && constraintWidget.mDimensionRatio > 0.0f) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z17 && constraintWidget.mDimensionRatio > 0.0f) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            measure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z19 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            measure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x008e, code lost:
    
        if (r8 != r9) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0095, code lost:
    
        if (r5.mDimensionRatio <= 0.0f) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        boolean z16;
        HorizontalWidgetRun horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun;
        int size = constraintWidgetContainer.mChildren.size();
        boolean optimizeFor = constraintWidgetContainer.optimizeFor(64);
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i3);
            if (!(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !constraintWidget.isInVirtualLayout() && (!optimizeFor || (horizontalWidgetRun = constraintWidget.horizontalRun) == null || (verticalWidgetRun = constraintWidget.verticalRun) == null || !horizontalWidgetRun.dimension.resolved || !verticalWidgetRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                boolean z17 = true;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16 && constraintWidgetContainer.optimizeFor(1) && !(constraintWidget instanceof VirtualLayout)) {
                    if (dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour2 != dimensionBehaviour3 && !constraintWidget.isInHorizontalChain()) {
                        z16 = true;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour != dimensionBehaviour3 && !constraintWidget.isInHorizontalChain()) {
                        z16 = true;
                    }
                    if (dimensionBehaviour != dimensionBehaviour3) {
                    }
                }
                z17 = z16;
                if (!z17) {
                    measure(measurer, constraintWidget, Measure.SELF_DIMENSIONS);
                    Metrics metrics = constraintWidgetContainer.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i3, int i16) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i3);
        constraintWidgetContainer.setHeight(i16);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29) {
        boolean z16;
        int i36;
        int i37;
        boolean z17;
        boolean z18;
        boolean z19;
        int i38;
        Measurer measurer;
        int i39;
        int i46;
        int i47;
        boolean z26;
        Metrics metrics;
        Measurer measurer2 = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i3, 128);
        boolean z27 = enabled || Optimizer.enabled(i3, 64);
        if (z27) {
            for (int i48 = 0; i48 < size; i48++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i48);
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z28 = (horizontalDimensionBehaviour == dimensionBehaviour) && (constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z28) || ((constraintWidget.isInVerticalChain() && z28) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z27 = false;
                    break;
                }
            }
        }
        if (z27 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        boolean z29 = z27 & ((i18 == 1073741824 && i26 == 1073741824) || enabled);
        int i49 = 2;
        if (z29) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i19);
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i27);
            if (i18 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i26 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i18 == 1073741824 && i26 == 1073741824) {
                z16 = constraintWidgetContainer.directMeasure(enabled);
                i36 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                if (i18 == 1073741824) {
                    directMeasureSetup &= constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                    i36 = 1;
                } else {
                    i36 = 0;
                }
                if (i26 == 1073741824) {
                    z16 = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                    i36++;
                } else {
                    z16 = directMeasureSetup;
                }
            }
            if (z16) {
                constraintWidgetContainer.updateFromRuns(i18 == 1073741824, i26 == 1073741824);
            }
        } else {
            z16 = false;
            i36 = 0;
        }
        if (z16 && i36 == 2) {
            return 0L;
        }
        int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
        if (size > 0) {
            measureChildren(constraintWidgetContainer);
        }
        updateHierarchy(constraintWidgetContainer);
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer, "First pass", width, height);
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z36 = horizontalDimensionBehaviour2 == dimensionBehaviour2;
            boolean z37 = constraintWidgetContainer.getVerticalDimensionBehaviour() == dimensionBehaviour2;
            int max = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i56 = 0;
            boolean z38 = false;
            while (i56 < size2) {
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i56);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    i39 = optimizationLevel;
                    int height2 = constraintWidget2.getHeight();
                    i46 = width;
                    boolean measure = measure(measurer2, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS) | z38;
                    Metrics metrics2 = constraintWidgetContainer.mMetrics;
                    i47 = height;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z36 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        z26 = true;
                    } else {
                        z26 = measure;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z37 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        z26 = true;
                    }
                    z38 = z26 | ((VirtualLayout) constraintWidget2).needSolverPass();
                } else {
                    i39 = optimizationLevel;
                    i46 = width;
                    i47 = height;
                }
                i56++;
                optimizationLevel = i39;
                width = i46;
                height = i47;
                i49 = 2;
            }
            int i57 = optimizationLevel;
            int i58 = width;
            int i59 = height;
            int i65 = i49;
            int i66 = 0;
            while (i66 < i65) {
                int i67 = 0;
                while (i67 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i67);
                    if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.getVisibility() == 8 || ((z29 && constraintWidget3.horizontalRun.dimension.resolved && constraintWidget3.verticalRun.dimension.resolved) || (constraintWidget3 instanceof VirtualLayout))) {
                        z19 = z29;
                        i38 = size2;
                        measurer = measurer2;
                    } else {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        int i68 = Measure.TRY_GIVEN_DIMENSIONS;
                        z19 = z29;
                        if (i66 == 1) {
                            i68 = Measure.USE_GIVEN_DIMENSIONS;
                        }
                        boolean measure2 = measure(measurer2, constraintWidget3, i68) | z38;
                        Metrics metrics3 = constraintWidgetContainer.mMetrics;
                        i38 = size2;
                        measurer = measurer2;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z36 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            measure2 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z37 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            measure2 = true;
                        }
                        z38 = (!constraintWidget3.hasBaseline() || baselineDistance == constraintWidget3.getBaselineDistance()) ? measure2 : true;
                    }
                    i67++;
                    size2 = i38;
                    measurer2 = measurer;
                    z29 = z19;
                }
                boolean z39 = z29;
                int i69 = size2;
                Measurer measurer3 = measurer2;
                if (!z38) {
                    break;
                }
                solveLinearSystem(constraintWidgetContainer, "intermediate pass", i58, i59);
                i66++;
                measurer2 = measurer3;
                z29 = z39;
                i65 = 2;
                z38 = false;
                size2 = i69;
            }
            if (z38) {
                solveLinearSystem(constraintWidgetContainer, "2nd pass", i58, i59);
                if (constraintWidgetContainer.getWidth() < max) {
                    constraintWidgetContainer.setWidth(max);
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (constraintWidgetContainer.getHeight() < max2) {
                    constraintWidgetContainer.setHeight(max2);
                    z18 = true;
                } else {
                    z18 = z17;
                }
                if (z18) {
                    solveLinearSystem(constraintWidgetContainer, "3rd pass", i58, i59);
                }
            }
            i37 = i57;
        } else {
            i37 = optimizationLevel;
        }
        constraintWidgetContainer.setOptimizationLevel(i37);
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i3);
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (horizontalDimensionBehaviour == dimensionBehaviour || constraintWidget.getVerticalDimensionBehaviour() == dimensionBehaviour) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
