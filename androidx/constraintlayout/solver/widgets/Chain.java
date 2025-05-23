package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i3) {
        int i16;
        ChainHead[] chainHeadArr;
        int i17;
        if (i3 == 0) {
            i16 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i17 = 0;
        } else {
            i16 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i17 = 2;
        }
        for (int i18 = 0; i18 < i16; i18++) {
            ChainHead chainHead = chainHeadArr[i18];
            chainHead.define();
            if (arrayList == null || arrayList.contains(chainHead.mFirst)) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i3, i17, chainHead);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r7 == 2) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:309:0x003e, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x003c, code lost:
    
        if (r7 == 2) goto L25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x024e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x04bd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x04f2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04f6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x038d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0395 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:242:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c8  */
    /* JADX WARN: Type inference failed for: r2v56, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r8v41 */
    /* JADX WARN: Type inference failed for: r8v42 */
    /* JADX WARN: Type inference failed for: r8v47 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.solver.widgets.ConstraintWidget] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i3, int i16, ChainHead chainHead) {
        boolean z16;
        boolean z17;
        boolean z18;
        ArrayList<ConstraintWidget> arrayList;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i17;
        ConstraintWidget constraintWidget2;
        int i18;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget3;
        ConstraintAnchor constraintAnchor5;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget4;
        SolverVariable solverVariable5;
        float f16;
        int size;
        int i19;
        ArrayList<ConstraintWidget> arrayList2;
        boolean z19;
        boolean z26;
        boolean z27;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        int i26;
        ConstraintWidget constraintWidget7 = chainHead.mFirst;
        ConstraintWidget constraintWidget8 = chainHead.mLast;
        ConstraintWidget constraintWidget9 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget10 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget11 = chainHead.mHead;
        float f17 = chainHead.mTotalWeight;
        boolean z28 = constraintWidgetContainer.mListDimensionBehaviors[i3] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i3 == 0) {
            int i27 = constraintWidget11.mHorizontalChainStyle;
            z16 = i27 == 0;
            z17 = i27 == 1;
        } else {
            int i28 = constraintWidget11.mVerticalChainStyle;
            z16 = i28 == 0;
            z17 = i28 == 1;
        }
        boolean z29 = z17;
        boolean z36 = false;
        boolean z37 = z16;
        ?? r85 = constraintWidget7;
        while (true) {
            if (z36) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = r85.mListAnchors[i16];
            int i29 = z18 ? 1 : 4;
            int margin = constraintAnchor6.getMargin();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = r85.mListDimensionBehaviors[i3];
            float f18 = f17;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && r85.mResolvedMatchConstraintDefault[i3] == 0) {
                z19 = z36;
                z26 = true;
            } else {
                z19 = z36;
                z26 = false;
            }
            ConstraintAnchor constraintAnchor7 = constraintAnchor6.mTarget;
            if (constraintAnchor7 != null && r85 != constraintWidget7) {
                margin += constraintAnchor7.getMargin();
            }
            int i36 = margin;
            if (!z18 || r85 == constraintWidget7 || r85 == constraintWidget9) {
                z27 = z37;
            } else {
                z27 = z37;
                i29 = 8;
            }
            ConstraintAnchor constraintAnchor8 = constraintAnchor6.mTarget;
            if (constraintAnchor8 != null) {
                if (r85 == constraintWidget9) {
                    constraintWidget5 = constraintWidget11;
                    constraintWidget6 = constraintWidget7;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i36, 6);
                } else {
                    constraintWidget5 = constraintWidget11;
                    constraintWidget6 = constraintWidget7;
                    linearSystem.addGreaterThan(constraintAnchor6.mSolverVariable, constraintAnchor8.mSolverVariable, i36, 8);
                }
                linearSystem.addEquality(constraintAnchor6.mSolverVariable, constraintAnchor6.mTarget.mSolverVariable, i36, (!z26 || z18) ? i29 : 5);
            } else {
                constraintWidget5 = constraintWidget11;
                constraintWidget6 = constraintWidget7;
            }
            if (z28) {
                if (r85.getVisibility() == 8 || r85.mListDimensionBehaviors[i3] != dimensionBehaviour2) {
                    i26 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = r85.mListAnchors;
                    i26 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i16 + 1].mSolverVariable, constraintAnchorArr[i16].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(r85.mListAnchors[i16].mSolverVariable, constraintWidgetContainer.mListAnchors[i16].mSolverVariable, i26, 8);
            }
            ConstraintAnchor constraintAnchor9 = r85.mListAnchors[i16 + 1].mTarget;
            if (constraintAnchor9 != null) {
                ?? r26 = constraintAnchor9.mOwner;
                ConstraintAnchor constraintAnchor10 = r26.mListAnchors[i16].mTarget;
                if (constraintAnchor10 != null && constraintAnchor10.mOwner == r85) {
                    r20 = r26;
                }
            }
            if (r20 != null) {
                r85 = r20;
                z36 = z19;
            } else {
                z36 = true;
            }
            z37 = z27;
            f17 = f18;
            constraintWidget11 = constraintWidget5;
            constraintWidget7 = constraintWidget6;
            r85 = r85;
        }
        ConstraintWidget constraintWidget12 = constraintWidget11;
        float f19 = f17;
        ConstraintWidget constraintWidget13 = constraintWidget7;
        boolean z38 = z37;
        if (constraintWidget10 != null) {
            int i37 = i16 + 1;
            if (constraintWidget8.mListAnchors[i37].mTarget != null) {
                ConstraintAnchor constraintAnchor11 = constraintWidget10.mListAnchors[i37];
                if ((constraintWidget10.mListDimensionBehaviors[i3] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget10.mResolvedMatchConstraintDefault[i3] == 0) && !z18) {
                    ConstraintAnchor constraintAnchor12 = constraintAnchor11.mTarget;
                    if (constraintAnchor12.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor11.mSolverVariable, constraintAnchor12.mSolverVariable, -constraintAnchor11.getMargin(), 5);
                        linearSystem.addLowerThan(constraintAnchor11.mSolverVariable, constraintWidget8.mListAnchors[i37].mTarget.mSolverVariable, -constraintAnchor11.getMargin(), 6);
                        if (z28) {
                            int i38 = i16 + 1;
                            SolverVariable solverVariable6 = constraintWidgetContainer.mListAnchors[i38].mSolverVariable;
                            ConstraintAnchor constraintAnchor13 = constraintWidget8.mListAnchors[i38];
                            linearSystem.addGreaterThan(solverVariable6, constraintAnchor13.mSolverVariable, constraintAnchor13.getMargin(), 8);
                        }
                        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            float f26 = (chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f19 : chainHead.mWidgetsMatchCount;
                            float f27 = 0.0f;
                            float f28 = 0.0f;
                            ConstraintWidget constraintWidget14 = null;
                            i19 = 0;
                            while (i19 < size) {
                                ConstraintWidget constraintWidget15 = arrayList.get(i19);
                                float f29 = constraintWidget15.mWeight[i3];
                                if (f29 < f27) {
                                    if (chainHead.mHasComplexMatchWeights) {
                                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget15.mListAnchors;
                                        linearSystem.addEquality(constraintAnchorArr2[i16 + 1].mSolverVariable, constraintAnchorArr2[i16].mSolverVariable, 0, 4);
                                        arrayList2 = arrayList;
                                        i19++;
                                        arrayList = arrayList2;
                                        f27 = 0.0f;
                                    } else {
                                        f29 = 1.0f;
                                    }
                                }
                                if (f29 == f27) {
                                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget15.mListAnchors;
                                    linearSystem.addEquality(constraintAnchorArr3[i16 + 1].mSolverVariable, constraintAnchorArr3[i16].mSolverVariable, 0, 8);
                                    arrayList2 = arrayList;
                                    i19++;
                                    arrayList = arrayList2;
                                    f27 = 0.0f;
                                } else {
                                    if (constraintWidget14 != null) {
                                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget14.mListAnchors;
                                        SolverVariable solverVariable7 = constraintAnchorArr4[i16].mSolverVariable;
                                        int i39 = i16 + 1;
                                        SolverVariable solverVariable8 = constraintAnchorArr4[i39].mSolverVariable;
                                        ConstraintAnchor[] constraintAnchorArr5 = constraintWidget15.mListAnchors;
                                        SolverVariable solverVariable9 = constraintAnchorArr5[i16].mSolverVariable;
                                        SolverVariable solverVariable10 = constraintAnchorArr5[i39].mSolverVariable;
                                        arrayList2 = arrayList;
                                        ArrayRow createRow = linearSystem.createRow();
                                        createRow.createRowEqualMatchDimensions(f28, f26, f29, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                        linearSystem.addConstraint(createRow);
                                    } else {
                                        arrayList2 = arrayList;
                                    }
                                    constraintWidget14 = constraintWidget15;
                                    f28 = f29;
                                    i19++;
                                    arrayList = arrayList2;
                                    f27 = 0.0f;
                                }
                            }
                        }
                        if (constraintWidget9 == null && (constraintWidget9 == constraintWidget10 || z18)) {
                            ConstraintAnchor constraintAnchor14 = constraintWidget13.mListAnchors[i16];
                            int i46 = i16 + 1;
                            ConstraintAnchor constraintAnchor15 = constraintWidget8.mListAnchors[i46];
                            ConstraintAnchor constraintAnchor16 = constraintAnchor14.mTarget;
                            SolverVariable solverVariable11 = constraintAnchor16 != null ? constraintAnchor16.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor17 = constraintAnchor15.mTarget;
                            SolverVariable solverVariable12 = constraintAnchor17 != null ? constraintAnchor17.mSolverVariable : null;
                            ConstraintAnchor constraintAnchor18 = constraintWidget9.mListAnchors[i16];
                            ConstraintAnchor constraintAnchor19 = constraintWidget10.mListAnchors[i46];
                            if (solverVariable11 != null && solverVariable12 != null) {
                                if (i3 == 0) {
                                    f16 = constraintWidget12.mHorizontalBiasPercent;
                                } else {
                                    f16 = constraintWidget12.mVerticalBiasPercent;
                                }
                                linearSystem.addCentering(constraintAnchor18.mSolverVariable, solverVariable11, constraintAnchor18.getMargin(), f16, solverVariable12, constraintAnchor19.mSolverVariable, constraintAnchor19.getMargin(), 7);
                            }
                        } else if (z38 || constraintWidget9 == null) {
                            int i47 = 8;
                            if (z29 && constraintWidget9 != null) {
                                int i48 = chainHead.mWidgetsMatchCount;
                                boolean z39 = i48 <= 0 && chainHead.mWidgetsCount == i48;
                                constraintWidget = constraintWidget9;
                                ConstraintWidget constraintWidget16 = constraintWidget;
                                while (constraintWidget != null) {
                                    ConstraintWidget constraintWidget17 = constraintWidget.mNextChainWidget[i3];
                                    while (constraintWidget17 != null && constraintWidget17.getVisibility() == i47) {
                                        constraintWidget17 = constraintWidget17.mNextChainWidget[i3];
                                    }
                                    if (constraintWidget == constraintWidget9 || constraintWidget == constraintWidget10 || constraintWidget17 == null) {
                                        constraintWidget2 = constraintWidget16;
                                        i18 = i47;
                                    } else {
                                        ConstraintWidget constraintWidget18 = constraintWidget17 == constraintWidget10 ? null : constraintWidget17;
                                        ConstraintAnchor constraintAnchor20 = constraintWidget.mListAnchors[i16];
                                        SolverVariable solverVariable13 = constraintAnchor20.mSolverVariable;
                                        ConstraintAnchor constraintAnchor21 = constraintAnchor20.mTarget;
                                        if (constraintAnchor21 != null) {
                                            SolverVariable solverVariable14 = constraintAnchor21.mSolverVariable;
                                        }
                                        int i49 = i16 + 1;
                                        SolverVariable solverVariable15 = constraintWidget16.mListAnchors[i49].mSolverVariable;
                                        int margin2 = constraintAnchor20.getMargin();
                                        int margin3 = constraintWidget.mListAnchors[i49].getMargin();
                                        if (constraintWidget18 != null) {
                                            constraintAnchor4 = constraintWidget18.mListAnchors[i16];
                                            solverVariable = constraintAnchor4.mSolverVariable;
                                            ConstraintAnchor constraintAnchor22 = constraintAnchor4.mTarget;
                                            solverVariable2 = constraintAnchor22 != null ? constraintAnchor22.mSolverVariable : null;
                                        } else {
                                            constraintAnchor4 = constraintWidget10.mListAnchors[i16];
                                            solverVariable = constraintAnchor4 != null ? constraintAnchor4.mSolverVariable : null;
                                            solverVariable2 = constraintWidget.mListAnchors[i49].mSolverVariable;
                                        }
                                        if (constraintAnchor4 != null) {
                                            margin3 += constraintAnchor4.getMargin();
                                        }
                                        int i56 = margin3;
                                        int margin4 = constraintWidget16.mListAnchors[i49].getMargin() + margin2;
                                        int i57 = z39 ? 8 : 4;
                                        if (solverVariable13 == null || solverVariable15 == null || solverVariable == null || solverVariable2 == null) {
                                            constraintWidget3 = constraintWidget18;
                                            constraintWidget2 = constraintWidget16;
                                            i18 = 8;
                                        } else {
                                            constraintWidget3 = constraintWidget18;
                                            constraintWidget2 = constraintWidget16;
                                            i18 = 8;
                                            linearSystem.addCentering(solverVariable13, solverVariable15, margin4, 0.5f, solverVariable, solverVariable2, i56, i57);
                                        }
                                        constraintWidget17 = constraintWidget3;
                                    }
                                    if (constraintWidget.getVisibility() == i18) {
                                        constraintWidget = constraintWidget2;
                                    }
                                    i47 = i18;
                                    constraintWidget16 = constraintWidget;
                                    constraintWidget = constraintWidget17;
                                }
                                ConstraintAnchor constraintAnchor23 = constraintWidget9.mListAnchors[i16];
                                constraintAnchor = constraintWidget13.mListAnchors[i16].mTarget;
                                int i58 = i16 + 1;
                                constraintAnchor2 = constraintWidget10.mListAnchors[i58];
                                constraintAnchor3 = constraintWidget8.mListAnchors[i58].mTarget;
                                if (constraintAnchor != null) {
                                    i17 = 5;
                                } else if (constraintWidget9 != constraintWidget10) {
                                    i17 = 5;
                                    linearSystem.addEquality(constraintAnchor23.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor23.getMargin(), 5);
                                } else {
                                    i17 = 5;
                                    if (constraintAnchor3 != null) {
                                        linearSystem.addCentering(constraintAnchor23.mSolverVariable, constraintAnchor.mSolverVariable, constraintAnchor23.getMargin(), 0.5f, constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, constraintAnchor2.getMargin(), 5);
                                    }
                                }
                                if (constraintAnchor3 != null && constraintWidget9 != constraintWidget10) {
                                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i17);
                                }
                            }
                        } else {
                            int i59 = chainHead.mWidgetsMatchCount;
                            boolean z46 = i59 > 0 && chainHead.mWidgetsCount == i59;
                            ConstraintWidget constraintWidget19 = constraintWidget9;
                            ConstraintWidget constraintWidget20 = constraintWidget19;
                            while (constraintWidget19 != null) {
                                ConstraintWidget constraintWidget21 = constraintWidget19.mNextChainWidget[i3];
                                while (constraintWidget21 != null && constraintWidget21.getVisibility() == 8) {
                                    constraintWidget21 = constraintWidget21.mNextChainWidget[i3];
                                }
                                if (constraintWidget21 != null || constraintWidget19 == constraintWidget10) {
                                    ConstraintAnchor constraintAnchor24 = constraintWidget19.mListAnchors[i16];
                                    SolverVariable solverVariable16 = constraintAnchor24.mSolverVariable;
                                    ConstraintAnchor constraintAnchor25 = constraintAnchor24.mTarget;
                                    SolverVariable solverVariable17 = constraintAnchor25 != null ? constraintAnchor25.mSolverVariable : null;
                                    if (constraintWidget20 != constraintWidget19) {
                                        solverVariable17 = constraintWidget20.mListAnchors[i16 + 1].mSolverVariable;
                                    } else if (constraintWidget19 == constraintWidget9 && constraintWidget20 == constraintWidget19) {
                                        ConstraintAnchor constraintAnchor26 = constraintWidget13.mListAnchors[i16].mTarget;
                                        solverVariable17 = constraintAnchor26 != null ? constraintAnchor26.mSolverVariable : null;
                                    }
                                    int margin5 = constraintAnchor24.getMargin();
                                    int i65 = i16 + 1;
                                    int margin6 = constraintWidget19.mListAnchors[i65].getMargin();
                                    if (constraintWidget21 != null) {
                                        constraintAnchor5 = constraintWidget21.mListAnchors[i16];
                                        SolverVariable solverVariable18 = constraintAnchor5.mSolverVariable;
                                        solverVariable4 = constraintWidget19.mListAnchors[i65].mSolverVariable;
                                        solverVariable3 = solverVariable18;
                                    } else {
                                        constraintAnchor5 = constraintWidget8.mListAnchors[i65].mTarget;
                                        solverVariable3 = constraintAnchor5 != null ? constraintAnchor5.mSolverVariable : null;
                                        solverVariable4 = constraintWidget19.mListAnchors[i65].mSolverVariable;
                                    }
                                    if (constraintAnchor5 != null) {
                                        margin6 += constraintAnchor5.getMargin();
                                    }
                                    if (constraintWidget20 != null) {
                                        margin5 += constraintWidget20.mListAnchors[i65].getMargin();
                                    }
                                    if (solverVariable16 != null && solverVariable17 != null && solverVariable3 != null && solverVariable4 != null) {
                                        if (constraintWidget19 == constraintWidget9) {
                                            margin5 = constraintWidget9.mListAnchors[i16].getMargin();
                                        }
                                        int i66 = margin5;
                                        constraintWidget4 = constraintWidget21;
                                        linearSystem.addCentering(solverVariable16, solverVariable17, i66, 0.5f, solverVariable3, solverVariable4, constraintWidget19 == constraintWidget10 ? constraintWidget10.mListAnchors[i65].getMargin() : margin6, z46 ? 8 : 5);
                                        if (constraintWidget19.getVisibility() == 8) {
                                            constraintWidget20 = constraintWidget19;
                                        }
                                        constraintWidget19 = constraintWidget4;
                                    }
                                }
                                constraintWidget4 = constraintWidget21;
                                if (constraintWidget19.getVisibility() == 8) {
                                }
                                constraintWidget19 = constraintWidget4;
                            }
                        }
                        if ((z38 && !z29) || constraintWidget9 == null || constraintWidget9 == constraintWidget10) {
                            return;
                        }
                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget9.mListAnchors;
                        ConstraintAnchor constraintAnchor27 = constraintAnchorArr6[i16];
                        int i67 = i16 + 1;
                        ConstraintAnchor constraintAnchor28 = constraintWidget10.mListAnchors[i67];
                        ConstraintAnchor constraintAnchor29 = constraintAnchor27.mTarget;
                        solverVariable5 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
                        ConstraintAnchor constraintAnchor30 = constraintAnchor28.mTarget;
                        SolverVariable solverVariable19 = constraintAnchor30 != null ? constraintAnchor30.mSolverVariable : null;
                        if (constraintWidget8 != constraintWidget10) {
                            ConstraintAnchor constraintAnchor31 = constraintWidget8.mListAnchors[i67].mTarget;
                            solverVariable19 = constraintAnchor31 != null ? constraintAnchor31.mSolverVariable : null;
                        }
                        if (constraintWidget9 == constraintWidget10) {
                            constraintAnchor28 = constraintAnchorArr6[i67];
                        }
                        if (solverVariable5 == null || solverVariable19 == null) {
                            return;
                        }
                        linearSystem.addCentering(constraintAnchor27.mSolverVariable, solverVariable5, constraintAnchor27.getMargin(), 0.5f, solverVariable19, constraintAnchor28.mSolverVariable, constraintWidget10.mListAnchors[i67].getMargin(), 5);
                        return;
                    }
                }
                if (z18) {
                    ConstraintAnchor constraintAnchor32 = constraintAnchor11.mTarget;
                    if (constraintAnchor32.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor11.mSolverVariable, constraintAnchor32.mSolverVariable, -constraintAnchor11.getMargin(), 4);
                    }
                }
                linearSystem.addLowerThan(constraintAnchor11.mSolverVariable, constraintWidget8.mListAnchors[i37].mTarget.mSolverVariable, -constraintAnchor11.getMargin(), 6);
                if (z28) {
                }
                arrayList = chainHead.mWeightedMatchConstraintsWidgets;
                if (arrayList != null) {
                    if (chainHead.mHasUndefinedWeights) {
                    }
                    float f272 = 0.0f;
                    float f282 = 0.0f;
                    ConstraintWidget constraintWidget142 = null;
                    i19 = 0;
                    while (i19 < size) {
                    }
                }
                if (constraintWidget9 == null) {
                }
                if (z38) {
                }
                int i472 = 8;
                if (z29) {
                    int i482 = chainHead.mWidgetsMatchCount;
                    if (i482 <= 0) {
                    }
                    constraintWidget = constraintWidget9;
                    ConstraintWidget constraintWidget162 = constraintWidget;
                    while (constraintWidget != null) {
                    }
                    ConstraintAnchor constraintAnchor232 = constraintWidget9.mListAnchors[i16];
                    constraintAnchor = constraintWidget13.mListAnchors[i16].mTarget;
                    int i582 = i16 + 1;
                    constraintAnchor2 = constraintWidget10.mListAnchors[i582];
                    constraintAnchor3 = constraintWidget8.mListAnchors[i582].mTarget;
                    if (constraintAnchor != null) {
                    }
                    if (constraintAnchor3 != null) {
                        linearSystem.addEquality(constraintAnchor2.mSolverVariable, constraintAnchor3.mSolverVariable, -constraintAnchor2.getMargin(), i17);
                    }
                }
                if (z38) {
                }
                ConstraintAnchor[] constraintAnchorArr62 = constraintWidget9.mListAnchors;
                ConstraintAnchor constraintAnchor272 = constraintAnchorArr62[i16];
                int i672 = i16 + 1;
                ConstraintAnchor constraintAnchor282 = constraintWidget10.mListAnchors[i672];
                ConstraintAnchor constraintAnchor292 = constraintAnchor272.mTarget;
                if (constraintAnchor292 != null) {
                }
                ConstraintAnchor constraintAnchor302 = constraintAnchor282.mTarget;
                if (constraintAnchor302 != null) {
                }
                if (constraintWidget8 != constraintWidget10) {
                }
                if (constraintWidget9 == constraintWidget10) {
                }
                if (solverVariable5 == null) {
                    return;
                } else {
                    return;
                }
            }
        }
        if (z28) {
        }
        arrayList = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList != null) {
        }
        if (constraintWidget9 == null) {
        }
        if (z38) {
        }
        int i4722 = 8;
        if (z29) {
        }
        if (z38) {
        }
        ConstraintAnchor[] constraintAnchorArr622 = constraintWidget9.mListAnchors;
        ConstraintAnchor constraintAnchor2722 = constraintAnchorArr622[i16];
        int i6722 = i16 + 1;
        ConstraintAnchor constraintAnchor2822 = constraintWidget10.mListAnchors[i6722];
        ConstraintAnchor constraintAnchor2922 = constraintAnchor2722.mTarget;
        if (constraintAnchor2922 != null) {
        }
        ConstraintAnchor constraintAnchor3022 = constraintAnchor2822.mTarget;
        if (constraintAnchor3022 != null) {
        }
        if (constraintWidget8 != constraintWidget10) {
        }
        if (constraintWidget9 == constraintWidget10) {
        }
        if (solverVariable5 == null) {
        }
    }
}
