package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static BasicMeasure.Measure measure = new BasicMeasure.Measure();

    private static boolean canMeasure(ConstraintWidget constraintWidget) {
        ConstraintWidgetContainer constraintWidgetContainer;
        boolean z16;
        boolean z17;
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        if (constraintWidget.getParent() != null) {
            constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.getParent();
        } else {
            constraintWidgetContainer = null;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getVerticalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour != dimensionBehaviour3 && horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultWidth != 0 || constraintWidget.mDimensionRatio != 0.0f || !constraintWidget.hasDanglingDimension(0)) && !constraintWidget.isResolvedHorizontally())) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (verticalDimensionBehaviour != dimensionBehaviour3 && verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && ((verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.mDimensionRatio != 0.0f || !constraintWidget.hasDanglingDimension(1)) && !constraintWidget.isResolvedVertically())) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (constraintWidget.mDimensionRatio > 0.0f && (z16 || z17)) {
            return true;
        }
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    private static void horizontalSolvingPass(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z16) {
        boolean z17;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        boolean z18;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && canMeasure(constraintWidget)) {
            ConstraintWidgetContainer.measure(constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                boolean canMeasure = canMeasure(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && canMeasure) {
                    ConstraintWidgetContainer.measure(constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidget2.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && !canMeasure) {
                    if (constraintWidget2.getHorizontalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxWidth >= 0 && constraintWidget2.mMatchConstraintMinWidth >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultWidth == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                        if (!constraintWidget2.isInHorizontalChain() && !constraintWidget2.isInVirtualLayout()) {
                            if ((next == constraintWidget2.mLeft && (constraintAnchor5 = constraintWidget2.mRight.mTarget) != null && constraintAnchor5.hasFinalValue()) || (next == constraintWidget2.mRight && (constraintAnchor4 = constraintWidget2.mLeft.mTarget) != null && constraintAnchor4.hasFinalValue())) {
                                z18 = true;
                            } else {
                                z18 = false;
                            }
                            if (z18 && !constraintWidget2.isInHorizontalChain()) {
                                solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget2, z16);
                            }
                        }
                    }
                } else if (!constraintWidget2.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor6 = constraintWidget2.mLeft;
                    if (next == constraintAnchor6 && constraintWidget2.mRight.mTarget == null) {
                        int margin = constraintAnchor6.getMargin() + finalValue;
                        constraintWidget2.setFinalHorizontal(margin, constraintWidget2.getWidth() + margin);
                        horizontalSolvingPass(constraintWidget2, measurer, z16);
                    } else {
                        ConstraintAnchor constraintAnchor7 = constraintWidget2.mRight;
                        if (next == constraintAnchor7 && constraintAnchor6.mTarget == null) {
                            int margin2 = finalValue - constraintAnchor7.getMargin();
                            constraintWidget2.setFinalHorizontal(margin2 - constraintWidget2.getWidth(), margin2);
                            horizontalSolvingPass(constraintWidget2, measurer, z16);
                        } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.mTarget) != null && constraintAnchor3.hasFinalValue() && !constraintWidget2.isInHorizontalChain()) {
                            solveHorizontalCenterConstraints(measurer, constraintWidget2, z16);
                        }
                    }
                }
            }
        }
        if (!(constraintWidget instanceof Guideline) && anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it5 = anchor2.getDependents().iterator();
            while (it5.hasNext()) {
                ConstraintAnchor next2 = it5.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                boolean canMeasure2 = canMeasure(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                    ConstraintWidgetContainer.measure(constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if ((next2 == constraintWidget3.mLeft && (constraintAnchor2 = constraintWidget3.mRight.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mRight && (constraintAnchor = constraintWidget3.mLeft.mTarget) != null && constraintAnchor.hasFinalValue())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour2 = constraintWidget3.getHorizontalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (horizontalDimensionBehaviour2 == dimensionBehaviour2 && !canMeasure2) {
                    if (constraintWidget3.getHorizontalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxWidth >= 0 && constraintWidget3.mMatchConstraintMinWidth >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultWidth == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                        if (!constraintWidget3.isInHorizontalChain() && !constraintWidget3.isInVirtualLayout() && z17 && !constraintWidget3.isInHorizontalChain()) {
                            solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget3, z16);
                        }
                    }
                } else if (!constraintWidget3.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor8 = constraintWidget3.mLeft;
                    if (next2 == constraintAnchor8 && constraintWidget3.mRight.mTarget == null) {
                        int margin3 = constraintAnchor8.getMargin() + finalValue2;
                        constraintWidget3.setFinalHorizontal(margin3, constraintWidget3.getWidth() + margin3);
                        horizontalSolvingPass(constraintWidget3, measurer, z16);
                    } else {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.mRight;
                        if (next2 == constraintAnchor9 && constraintAnchor8.mTarget == null) {
                            int margin4 = finalValue2 - constraintAnchor9.getMargin();
                            constraintWidget3.setFinalHorizontal(margin4 - constraintWidget3.getWidth(), margin4);
                            horizontalSolvingPass(constraintWidget3, measurer, z16);
                        } else if (z17 && !constraintWidget3.isInHorizontalChain()) {
                            solveHorizontalCenterConstraints(measurer, constraintWidget3, z16);
                        }
                    }
                }
            }
        }
    }

    private static void solveBarrier(Barrier barrier, BasicMeasure.Measurer measurer, int i3, boolean z16) {
        if (barrier.allSolved()) {
            if (i3 == 0) {
                horizontalSolvingPass(barrier, measurer, z16);
            } else {
                verticalSolvingPass(barrier, measurer);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x01cc, code lost:
    
        if (r6.mOwner == r2) goto L108;
     */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean solveChain(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i3, int i16, ChainHead chainHead, boolean z16, boolean z17, boolean z18) {
        int finalValue;
        int finalValue2;
        int finalValue3;
        int i17;
        int height;
        ConstraintWidget constraintWidget;
        float verticalBiasPercent;
        int height2;
        if (z18) {
            return false;
        }
        if (i3 == 0) {
            if (!constraintWidgetContainer.isResolvedHorizontally()) {
                return false;
            }
        } else if (!constraintWidgetContainer.isResolvedVertically()) {
            return false;
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        ConstraintWidget first = chainHead.getFirst();
        ConstraintWidget last = chainHead.getLast();
        ConstraintWidget firstVisibleWidget = chainHead.getFirstVisibleWidget();
        ConstraintWidget lastVisibleWidget = chainHead.getLastVisibleWidget();
        ConstraintWidget head = chainHead.getHead();
        ConstraintAnchor constraintAnchor = first.mListAnchors[i16];
        int i18 = i16 + 1;
        ConstraintAnchor constraintAnchor2 = last.mListAnchors[i18];
        ConstraintAnchor constraintAnchor3 = constraintAnchor.mTarget;
        if (constraintAnchor3 == null || constraintAnchor2.mTarget == null || !constraintAnchor3.hasFinalValue() || !constraintAnchor2.mTarget.hasFinalValue() || firstVisibleWidget == null || lastVisibleWidget == null || (finalValue3 = (finalValue2 = constraintAnchor2.mTarget.getFinalValue() - lastVisibleWidget.mListAnchors[i18].getMargin()) - (finalValue = constraintAnchor.mTarget.getFinalValue() + firstVisibleWidget.mListAnchors[i16].getMargin())) <= 0) {
            return false;
        }
        BasicMeasure.Measure measure2 = new BasicMeasure.Measure();
        boolean z19 = false;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        ConstraintWidget constraintWidget2 = first;
        while (true) {
            ConstraintWidget constraintWidget3 = null;
            if (!z19) {
                ConstraintAnchor constraintAnchor4 = constraintWidget2.mListAnchors[i16];
                if (!canMeasure(constraintWidget2)) {
                    return false;
                }
                ConstraintWidget constraintWidget4 = first;
                if (constraintWidget2.mListDimensionBehaviors[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    return false;
                }
                if (constraintWidget2.isMeasureRequested()) {
                    ConstraintWidgetContainer.measure(constraintWidget2, constraintWidgetContainer.getMeasurer(), measure2, BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                int margin = i27 + constraintWidget2.mListAnchors[i16].getMargin();
                if (i3 == 0) {
                    height2 = constraintWidget2.getWidth();
                } else {
                    height2 = constraintWidget2.getHeight();
                }
                i27 = margin + height2 + constraintWidget2.mListAnchors[i18].getMargin();
                i26++;
                if (constraintWidget2.getVisibility() != 8) {
                    i19++;
                }
                ConstraintAnchor constraintAnchor5 = constraintWidget2.mListAnchors[i18].mTarget;
                if (constraintAnchor5 != null) {
                    ConstraintWidget constraintWidget5 = constraintAnchor5.mOwner;
                    ConstraintAnchor constraintAnchor6 = constraintWidget5.mListAnchors[i16].mTarget;
                    if (constraintAnchor6 != null && constraintAnchor6.mOwner == constraintWidget2) {
                        constraintWidget3 = constraintWidget5;
                    }
                }
                if (constraintWidget3 != null) {
                    constraintWidget2 = constraintWidget3;
                } else {
                    z19 = true;
                }
                first = constraintWidget4;
            } else {
                ConstraintWidget constraintWidget6 = first;
                if (i19 == 0 || i19 != i26 || finalValue3 < i27) {
                    return false;
                }
                int i28 = finalValue3 - i27;
                if (z16) {
                    i28 /= i19 + 1;
                } else if (z17 && i19 > 2) {
                    i17 = 1;
                    i28 = (i28 / i19) - 1;
                    if (i19 != i17) {
                        if (i3 == 0) {
                            verticalBiasPercent = head.getHorizontalBiasPercent();
                        } else {
                            verticalBiasPercent = head.getVerticalBiasPercent();
                        }
                        int i29 = (int) (finalValue + 0.5f + (i28 * verticalBiasPercent));
                        if (i3 == 0) {
                            firstVisibleWidget.setFinalHorizontal(i29, firstVisibleWidget.getWidth() + i29);
                        } else {
                            firstVisibleWidget.setFinalVertical(i29, firstVisibleWidget.getHeight() + i29);
                        }
                        horizontalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                        return true;
                    }
                    if (z16) {
                        int i36 = finalValue + i28;
                        ConstraintWidget constraintWidget7 = constraintWidget6;
                        boolean z26 = false;
                        while (!z26) {
                            ConstraintAnchor constraintAnchor7 = constraintWidget7.mListAnchors[i16];
                            if (constraintWidget7.getVisibility() == 8) {
                                if (i3 == 0) {
                                    constraintWidget7.setFinalHorizontal(i36, i36);
                                    horizontalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer(), isRtl);
                                } else {
                                    constraintWidget7.setFinalVertical(i36, i36);
                                    verticalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer());
                                }
                            } else {
                                int margin2 = i36 + constraintWidget7.mListAnchors[i16].getMargin();
                                if (i3 == 0) {
                                    constraintWidget7.setFinalHorizontal(margin2, constraintWidget7.getWidth() + margin2);
                                    horizontalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer(), isRtl);
                                    height = constraintWidget7.getWidth();
                                } else {
                                    constraintWidget7.setFinalVertical(margin2, constraintWidget7.getHeight() + margin2);
                                    verticalSolvingPass(constraintWidget7, constraintWidgetContainer.getMeasurer());
                                    height = constraintWidget7.getHeight();
                                }
                                i36 = margin2 + height + constraintWidget7.mListAnchors[i18].getMargin() + i28;
                            }
                            constraintWidget7.addToSolver(linearSystem, false);
                            ConstraintAnchor constraintAnchor8 = constraintWidget7.mListAnchors[i18].mTarget;
                            if (constraintAnchor8 != null) {
                                constraintWidget = constraintAnchor8.mOwner;
                                ConstraintAnchor constraintAnchor9 = constraintWidget.mListAnchors[i16].mTarget;
                                if (constraintAnchor9 != null) {
                                }
                            }
                            constraintWidget = null;
                            if (constraintWidget != null) {
                                constraintWidget7 = constraintWidget;
                            } else {
                                z26 = true;
                            }
                        }
                    } else if (z17) {
                        if (i19 == 2) {
                            if (i3 == 0) {
                                firstVisibleWidget.setFinalHorizontal(finalValue, firstVisibleWidget.getWidth() + finalValue);
                                lastVisibleWidget.setFinalHorizontal(finalValue2 - lastVisibleWidget.getWidth(), finalValue2);
                                horizontalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                                horizontalSolvingPass(lastVisibleWidget, constraintWidgetContainer.getMeasurer(), isRtl);
                                return true;
                            }
                            firstVisibleWidget.setFinalVertical(finalValue, firstVisibleWidget.getHeight() + finalValue);
                            lastVisibleWidget.setFinalVertical(finalValue2 - lastVisibleWidget.getHeight(), finalValue2);
                            verticalSolvingPass(firstVisibleWidget, constraintWidgetContainer.getMeasurer());
                            verticalSolvingPass(lastVisibleWidget, constraintWidgetContainer.getMeasurer());
                            return true;
                        }
                        return false;
                    }
                    return true;
                }
                i17 = 1;
                if (i19 != i17) {
                }
            }
        }
    }

    private static void solveHorizontalCenterConstraints(BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget, boolean z16) {
        float horizontalBiasPercent = constraintWidget.getHorizontalBiasPercent();
        int finalValue = constraintWidget.mLeft.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mRight.mTarget.getFinalValue();
        int margin = constraintWidget.mLeft.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mRight.getMargin();
        if (finalValue == finalValue2) {
            horizontalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int width = constraintWidget.getWidth();
        int i3 = (finalValue2 - finalValue) - width;
        if (finalValue > finalValue2) {
            i3 = (finalValue - finalValue2) - width;
        }
        int i16 = ((int) ((horizontalBiasPercent * i3) + 0.5f)) + finalValue;
        int i17 = i16 + width;
        if (finalValue > finalValue2) {
            i17 = i16 - width;
        }
        constraintWidget.setFinalHorizontal(i16, i17);
        horizontalSolvingPass(constraintWidget, measurer, z16);
    }

    private static void solveHorizontalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z16) {
        int width;
        float horizontalBiasPercent = constraintWidget2.getHorizontalBiasPercent();
        int finalValue = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
        int finalValue2 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (finalValue2 >= finalValue) {
            int width2 = constraintWidget2.getWidth();
            if (constraintWidget2.getVisibility() != 8) {
                int i3 = constraintWidget2.mMatchConstraintDefaultWidth;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        width = constraintWidget.getWidth();
                    } else {
                        width = constraintWidget.getParent().getWidth();
                    }
                    width2 = (int) (constraintWidget2.getHorizontalBiasPercent() * 0.5f * width);
                } else if (i3 == 0) {
                    width2 = finalValue2 - finalValue;
                }
                width2 = Math.max(constraintWidget2.mMatchConstraintMinWidth, width2);
                int i16 = constraintWidget2.mMatchConstraintMaxWidth;
                if (i16 > 0) {
                    width2 = Math.min(i16, width2);
                }
            }
            int i17 = finalValue + ((int) ((horizontalBiasPercent * ((finalValue2 - finalValue) - width2)) + 0.5f));
            constraintWidget2.setFinalHorizontal(i17, width2 + i17);
            horizontalSolvingPass(constraintWidget2, measurer, z16);
        }
    }

    private static void solveVerticalCenterConstraints(BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
        int finalValue = constraintWidget.mTop.mTarget.getFinalValue();
        int finalValue2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int margin = constraintWidget.mTop.getMargin() + finalValue;
        int margin2 = finalValue2 - constraintWidget.mBottom.getMargin();
        if (finalValue == finalValue2) {
            verticalBiasPercent = 0.5f;
        } else {
            finalValue = margin;
            finalValue2 = margin2;
        }
        int height = constraintWidget.getHeight();
        int i3 = (finalValue2 - finalValue) - height;
        if (finalValue > finalValue2) {
            i3 = (finalValue - finalValue2) - height;
        }
        int i16 = (int) ((verticalBiasPercent * i3) + 0.5f);
        int i17 = finalValue + i16;
        int i18 = i17 + height;
        if (finalValue > finalValue2) {
            i17 = finalValue - i16;
            i18 = i17 - height;
        }
        constraintWidget.setFinalVertical(i17, i18);
        verticalSolvingPass(constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int height;
        float verticalBiasPercent = constraintWidget2.getVerticalBiasPercent();
        int finalValue = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
        int finalValue2 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (finalValue2 >= finalValue) {
            int height2 = constraintWidget2.getHeight();
            if (constraintWidget2.getVisibility() != 8) {
                int i3 = constraintWidget2.mMatchConstraintDefaultHeight;
                if (i3 == 2) {
                    if (constraintWidget instanceof ConstraintWidgetContainer) {
                        height = constraintWidget.getHeight();
                    } else {
                        height = constraintWidget.getParent().getHeight();
                    }
                    height2 = (int) (verticalBiasPercent * 0.5f * height);
                } else if (i3 == 0) {
                    height2 = finalValue2 - finalValue;
                }
                height2 = Math.max(constraintWidget2.mMatchConstraintMinHeight, height2);
                int i16 = constraintWidget2.mMatchConstraintMaxHeight;
                if (i16 > 0) {
                    height2 = Math.min(i16, height2);
                }
            }
            int i17 = finalValue + ((int) ((verticalBiasPercent * ((finalValue2 - finalValue) - height2)) + 0.5f));
            constraintWidget2.setFinalVertical(i17, height2 + i17);
            verticalSolvingPass(constraintWidget2, measurer);
        }
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidgetContainer.getVerticalDimensionBehaviour();
        constraintWidgetContainer.resetFinalResolution();
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i3 = 0; i3 < size; i3++) {
            children.get(i3).resetFinalResolution();
        }
        boolean isRtl = constraintWidgetContainer.isRtl();
        if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        boolean z16 = false;
        boolean z17 = false;
        for (int i16 = 0; i16 < size; i16++) {
            ConstraintWidget constraintWidget = children.get(i16);
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                if (guideline.getOrientation() == 1) {
                    if (guideline.getRelativeBegin() != -1) {
                        guideline.setFinalValue(guideline.getRelativeBegin());
                    } else if (guideline.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue(constraintWidgetContainer.getWidth() - guideline.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        guideline.setFinalValue((int) ((guideline.getRelativePercent() * constraintWidgetContainer.getWidth()) + 0.5f));
                    }
                    z16 = true;
                }
            } else if ((constraintWidget instanceof Barrier) && ((Barrier) constraintWidget).getOrientation() == 0) {
                z17 = true;
            }
        }
        if (z16) {
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget2 = children.get(i17);
                if (constraintWidget2 instanceof Guideline) {
                    Guideline guideline2 = (Guideline) constraintWidget2;
                    if (guideline2.getOrientation() == 1) {
                        horizontalSolvingPass(guideline2, measurer, isRtl);
                    }
                }
            }
        }
        horizontalSolvingPass(constraintWidgetContainer, measurer, isRtl);
        if (z17) {
            for (int i18 = 0; i18 < size; i18++) {
                ConstraintWidget constraintWidget3 = children.get(i18);
                if (constraintWidget3 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget3;
                    if (barrier.getOrientation() == 0) {
                        solveBarrier(barrier, measurer, 0, isRtl);
                    }
                }
            }
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        boolean z18 = false;
        boolean z19 = false;
        for (int i19 = 0; i19 < size; i19++) {
            ConstraintWidget constraintWidget4 = children.get(i19);
            if (constraintWidget4 instanceof Guideline) {
                Guideline guideline3 = (Guideline) constraintWidget4;
                if (guideline3.getOrientation() == 0) {
                    if (guideline3.getRelativeBegin() != -1) {
                        guideline3.setFinalValue(guideline3.getRelativeBegin());
                    } else if (guideline3.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue(constraintWidgetContainer.getHeight() - guideline3.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        guideline3.setFinalValue((int) ((guideline3.getRelativePercent() * constraintWidgetContainer.getHeight()) + 0.5f));
                    }
                    z18 = true;
                }
            } else if ((constraintWidget4 instanceof Barrier) && ((Barrier) constraintWidget4).getOrientation() == 1) {
                z19 = true;
            }
        }
        if (z18) {
            for (int i26 = 0; i26 < size; i26++) {
                ConstraintWidget constraintWidget5 = children.get(i26);
                if (constraintWidget5 instanceof Guideline) {
                    Guideline guideline4 = (Guideline) constraintWidget5;
                    if (guideline4.getOrientation() == 0) {
                        verticalSolvingPass(guideline4, measurer);
                    }
                }
            }
        }
        verticalSolvingPass(constraintWidgetContainer, measurer);
        if (z19) {
            for (int i27 = 0; i27 < size; i27++) {
                ConstraintWidget constraintWidget6 = children.get(i27);
                if (constraintWidget6 instanceof Barrier) {
                    Barrier barrier2 = (Barrier) constraintWidget6;
                    if (barrier2.getOrientation() == 1) {
                        solveBarrier(barrier2, measurer, 1, isRtl);
                    }
                }
            }
        }
        for (int i28 = 0; i28 < size; i28++) {
            ConstraintWidget constraintWidget7 = children.get(i28);
            if (constraintWidget7.isMeasureRequested() && canMeasure(constraintWidget7)) {
                ConstraintWidgetContainer.measure(constraintWidget7, measurer, measure, BasicMeasure.Measure.SELF_DIMENSIONS);
                horizontalSolvingPass(constraintWidget7, measurer, isRtl);
                verticalSolvingPass(constraintWidget7, measurer);
            }
        }
    }

    private static void verticalSolvingPass(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z16;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        boolean z17;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && canMeasure(constraintWidget)) {
            ConstraintWidgetContainer.measure(constraintWidget, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
        }
        ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor2 = constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int finalValue = anchor.getFinalValue();
        int finalValue2 = anchor2.getFinalValue();
        if (anchor.getDependents() != null && anchor.hasFinalValue()) {
            Iterator<ConstraintAnchor> it = anchor.getDependents().iterator();
            while (it.hasNext()) {
                ConstraintAnchor next = it.next();
                ConstraintWidget constraintWidget2 = next.mOwner;
                boolean canMeasure = canMeasure(constraintWidget2);
                if (constraintWidget2.isMeasureRequested() && canMeasure) {
                    ConstraintWidgetContainer.measure(constraintWidget2, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = constraintWidget2.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour == dimensionBehaviour && !canMeasure) {
                    if (constraintWidget2.getVerticalDimensionBehaviour() == dimensionBehaviour && constraintWidget2.mMatchConstraintMaxHeight >= 0 && constraintWidget2.mMatchConstraintMinHeight >= 0 && (constraintWidget2.getVisibility() == 8 || (constraintWidget2.mMatchConstraintDefaultHeight == 0 && constraintWidget2.getDimensionRatio() == 0.0f))) {
                        if (!constraintWidget2.isInVerticalChain() && !constraintWidget2.isInVirtualLayout()) {
                            if ((next == constraintWidget2.mTop && (constraintAnchor5 = constraintWidget2.mBottom.mTarget) != null && constraintAnchor5.hasFinalValue()) || (next == constraintWidget2.mBottom && (constraintAnchor4 = constraintWidget2.mTop.mTarget) != null && constraintAnchor4.hasFinalValue())) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17 && !constraintWidget2.isInVerticalChain()) {
                                solveVerticalMatchConstraint(constraintWidget, measurer, constraintWidget2);
                            }
                        }
                    }
                } else if (!constraintWidget2.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor6 = constraintWidget2.mTop;
                    if (next == constraintAnchor6 && constraintWidget2.mBottom.mTarget == null) {
                        int margin = constraintAnchor6.getMargin() + finalValue;
                        constraintWidget2.setFinalVertical(margin, constraintWidget2.getHeight() + margin);
                        verticalSolvingPass(constraintWidget2, measurer);
                    } else {
                        ConstraintAnchor constraintAnchor7 = constraintWidget2.mBottom;
                        if (next == constraintAnchor7 && constraintAnchor7.mTarget == null) {
                            int margin2 = finalValue - constraintAnchor7.getMargin();
                            constraintWidget2.setFinalVertical(margin2 - constraintWidget2.getHeight(), margin2);
                            verticalSolvingPass(constraintWidget2, measurer);
                        } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.mTarget) != null && constraintAnchor3.hasFinalValue()) {
                            solveVerticalCenterConstraints(measurer, constraintWidget2);
                        }
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (anchor2.getDependents() != null && anchor2.hasFinalValue()) {
            Iterator<ConstraintAnchor> it5 = anchor2.getDependents().iterator();
            while (it5.hasNext()) {
                ConstraintAnchor next2 = it5.next();
                ConstraintWidget constraintWidget3 = next2.mOwner;
                boolean canMeasure2 = canMeasure(constraintWidget3);
                if (constraintWidget3.isMeasureRequested() && canMeasure2) {
                    ConstraintWidgetContainer.measure(constraintWidget3, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if ((next2 == constraintWidget3.mTop && (constraintAnchor2 = constraintWidget3.mBottom.mTarget) != null && constraintAnchor2.hasFinalValue()) || (next2 == constraintWidget3.mBottom && (constraintAnchor = constraintWidget3.mTop.mTarget) != null && constraintAnchor.hasFinalValue())) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour2 = constraintWidget3.getVerticalDimensionBehaviour();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (verticalDimensionBehaviour2 == dimensionBehaviour2 && !canMeasure2) {
                    if (constraintWidget3.getVerticalDimensionBehaviour() == dimensionBehaviour2 && constraintWidget3.mMatchConstraintMaxHeight >= 0 && constraintWidget3.mMatchConstraintMinHeight >= 0 && (constraintWidget3.getVisibility() == 8 || (constraintWidget3.mMatchConstraintDefaultHeight == 0 && constraintWidget3.getDimensionRatio() == 0.0f))) {
                        if (!constraintWidget3.isInVerticalChain() && !constraintWidget3.isInVirtualLayout() && z16 && !constraintWidget3.isInVerticalChain()) {
                            solveVerticalMatchConstraint(constraintWidget, measurer, constraintWidget3);
                        }
                    }
                } else if (!constraintWidget3.isMeasureRequested()) {
                    ConstraintAnchor constraintAnchor8 = constraintWidget3.mTop;
                    if (next2 == constraintAnchor8 && constraintWidget3.mBottom.mTarget == null) {
                        int margin3 = constraintAnchor8.getMargin() + finalValue2;
                        constraintWidget3.setFinalVertical(margin3, constraintWidget3.getHeight() + margin3);
                        verticalSolvingPass(constraintWidget3, measurer);
                    } else {
                        ConstraintAnchor constraintAnchor9 = constraintWidget3.mBottom;
                        if (next2 == constraintAnchor9 && constraintAnchor8.mTarget == null) {
                            int margin4 = finalValue2 - constraintAnchor9.getMargin();
                            constraintWidget3.setFinalVertical(margin4 - constraintWidget3.getHeight(), margin4);
                            verticalSolvingPass(constraintWidget3, measurer);
                        } else if (z16 && !constraintWidget3.isInVerticalChain()) {
                            solveVerticalCenterConstraints(measurer, constraintWidget3);
                        }
                    }
                }
            }
        }
        ConstraintAnchor anchor3 = constraintWidget.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (anchor3.getDependents() != null && anchor3.hasFinalValue()) {
            int finalValue3 = anchor3.getFinalValue();
            Iterator<ConstraintAnchor> it6 = anchor3.getDependents().iterator();
            while (it6.hasNext()) {
                ConstraintAnchor next3 = it6.next();
                ConstraintWidget constraintWidget4 = next3.mOwner;
                boolean canMeasure3 = canMeasure(constraintWidget4);
                if (constraintWidget4.isMeasureRequested() && canMeasure3) {
                    ConstraintWidgetContainer.measure(constraintWidget4, measurer, new BasicMeasure.Measure(), BasicMeasure.Measure.SELF_DIMENSIONS);
                }
                if (constraintWidget4.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || canMeasure3) {
                    if (!constraintWidget4.isMeasureRequested() && next3 == constraintWidget4.mBaseline) {
                        constraintWidget4.setFinalBaseline(finalValue3);
                        verticalSolvingPass(constraintWidget4, measurer);
                    }
                }
            }
        }
    }
}
