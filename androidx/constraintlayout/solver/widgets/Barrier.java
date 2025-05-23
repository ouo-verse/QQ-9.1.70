package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    boolean resolved = false;

    public Barrier() {
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z16) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i26 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i26 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i26];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i26++;
        }
        int i27 = this.mBarrierType;
        if (i27 >= 0 && i27 < 4) {
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i27];
            if (!this.resolved) {
                allSolved();
            }
            if (this.resolved) {
                this.resolved = false;
                int i28 = this.mBarrierType;
                if (i28 != 0 && i28 != 1) {
                    if (i28 == 2 || i28 == 3) {
                        linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                        linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                        return;
                    }
                    return;
                }
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            }
            for (int i29 = 0; i29 < this.mWidgetsCount; i29++) {
                ConstraintWidget constraintWidget = this.mWidgets[i29];
                if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i18 = this.mBarrierType) == 0 || i18 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i19 = this.mBarrierType) == 2 || i19 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                    z17 = true;
                    break;
                }
            }
            z17 = false;
            if (!this.mLeft.hasCenteredDependents() && !this.mRight.hasCenteredDependents()) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (!this.mTop.hasCenteredDependents() && !this.mBottom.hasCenteredDependents()) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (!z17 && (((i17 = this.mBarrierType) == 0 && z18) || ((i17 == 2 && z19) || ((i17 == 1 && z18) || (i17 == 3 && z19))))) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (!z26) {
                i3 = 4;
            } else {
                i3 = 5;
            }
            for (int i36 = 0; i36 < this.mWidgetsCount; i36++) {
                ConstraintWidget constraintWidget2 = this.mWidgets[i36];
                if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                    SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                    int i37 = this.mBarrierType;
                    ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i37];
                    constraintAnchor3.mSolverVariable = createObjectVariable;
                    ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                    if (constraintAnchor4 != null && constraintAnchor4.mOwner == this) {
                        i16 = constraintAnchor3.mMargin + 0;
                    } else {
                        i16 = 0;
                    }
                    if (i37 != 0 && i37 != 2) {
                        linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i16, z17);
                    } else {
                        linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin - i16, z17);
                    }
                    linearSystem.addEquality(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i16, i3);
                }
            }
            int i38 = this.mBarrierType;
            if (i38 == 0) {
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
                return;
            }
            if (i38 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
            } else if (i38 == 2) {
                linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
            } else if (i38 == 3) {
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
                linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
            }
        }
    }

    public boolean allSolved() {
        int i3;
        int i16;
        int i17;
        boolean z16 = true;
        int i18 = 0;
        while (true) {
            i3 = this.mWidgetsCount;
            if (i18 >= i3) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i18];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i16 = this.mBarrierType) == 0 || i16 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i17 = this.mBarrierType) == 2 || i17 == 3) && !constraintWidget.isResolvedVertically()))) {
                z16 = false;
            }
            i18++;
        }
        if (!z16 || i3 <= 0) {
            return false;
        }
        int i19 = 0;
        boolean z17 = false;
        for (int i26 = 0; i26 < this.mWidgetsCount; i26++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i26];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z17) {
                    int i27 = this.mBarrierType;
                    if (i27 == 0) {
                        i19 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i27 == 1) {
                        i19 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i27 == 2) {
                        i19 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i27 == 3) {
                        i19 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z17 = true;
                }
                int i28 = this.mBarrierType;
                if (i28 == 0) {
                    i19 = Math.min(i19, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i28 == 1) {
                    i19 = Math.max(i19, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i28 == 2) {
                    i19 = Math.min(i19, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i28 == 3) {
                    i19 = Math.max(i19, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i29 = i19 + this.mMargin;
        int i36 = this.mBarrierType;
        if (i36 != 0 && i36 != 1) {
            setFinalVertical(i29, i29);
        } else {
            setFinalHorizontal(i29, i29);
        }
        this.resolved = true;
        return true;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i3 = this.mBarrierType;
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                return 1;
            }
            return -1;
        }
        return 0;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.resolved;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markWidgets() {
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            ConstraintWidget constraintWidget = this.mWidgets[i3];
            int i16 = this.mBarrierType;
            if (i16 != 0 && i16 != 1) {
                if (i16 == 2 || i16 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            } else {
                constraintWidget.setInBarrier(0, true);
            }
        }
    }

    public void setAllowsGoneWidget(boolean z16) {
        this.mAllowsGoneWidget = z16;
    }

    public void setBarrierType(int i3) {
        this.mBarrierType = i3;
    }

    public void setMargin(int i3) {
        this.mMargin = i3;
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i3 = 0; i3 < this.mWidgetsCount; i3++) {
            ConstraintWidget constraintWidget = this.mWidgets[i3];
            if (i3 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.getDebugName();
        }
        return str + "}";
    }

    public Barrier(String str) {
        setDebugName(str);
    }
}
