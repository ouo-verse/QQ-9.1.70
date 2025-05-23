package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;

    /* renamed from: id, reason: collision with root package name */
    int f26468id;
    int orientation;
    ArrayList<ConstraintWidget> widgets = new ArrayList<>();
    boolean authoritative = false;
    ArrayList<MeasureResult> results = null;
    private int moveTo = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class MeasureResult {
        int baseline;
        int bottom;
        int left;
        int orientation;
        int right;
        int top;
        WeakReference<ConstraintWidget> widgetRef;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i3) {
            this.widgetRef = new WeakReference<>(constraintWidget);
            this.left = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.top = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.right = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.bottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.baseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.orientation = i3;
        }

        public void apply() {
            ConstraintWidget constraintWidget = this.widgetRef.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
            }
        }
    }

    public WidgetGroup(int i3) {
        int i16 = count;
        count = i16 + 1;
        this.f26468id = i16;
        this.orientation = i3;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.widgets.contains(constraintWidget);
    }

    private String getOrientationString() {
        int i3 = this.orientation;
        if (i3 == 0) {
            return "Horizontal";
        }
        if (i3 == 1) {
            return "Vertical";
        }
        if (i3 == 2) {
            return "Both";
        }
        return "Unknown";
    }

    private int measureWrap(int i3, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i3);
        if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) {
            return -1;
        }
        if (i3 == 0) {
            return constraintWidget.getWidth();
        }
        return constraintWidget.getHeight();
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i3) {
        int objectVariableValue;
        int objectVariableValue2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            arrayList.get(i16).addToSolver(linearSystem, false);
        }
        if (i3 == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i3 == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.results = new ArrayList<>();
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            this.results.add(new MeasureResult(arrayList.get(i17), linearSystem, i3));
        }
        if (i3 == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.widgets.contains(constraintWidget)) {
            return false;
        }
        this.widgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.results == null || !this.authoritative) {
            return;
        }
        for (int i3 = 0; i3 < this.results.size(); i3++) {
            this.results.get(i3).apply();
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.widgets.size();
        if (this.moveTo != -1 && size > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                WidgetGroup widgetGroup = arrayList.get(i3);
                if (this.moveTo == widgetGroup.f26468id) {
                    moveTo(this.orientation, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.f26468id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        for (int i3 = 0; i3 < this.widgets.size(); i3++) {
            if (widgetGroup.contains(this.widgets.get(i3))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public void moveTo(int i3, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            widgetGroup.add(next);
            if (i3 == 0) {
                next.horizontalGroup = widgetGroup.getId();
            } else {
                next.verticalGroup = widgetGroup.getId();
            }
        }
        this.moveTo = widgetGroup.f26468id;
    }

    public void setAuthoritative(boolean z16) {
        this.authoritative = z16;
    }

    public void setOrientation(int i3) {
        this.orientation = i3;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        String str = getOrientationString() + " [" + this.f26468id + "] <";
        Iterator<ConstraintWidget> it = this.widgets.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().getDebugName();
        }
        return str + " >";
    }

    public int measureWrap(LinearSystem linearSystem, int i3) {
        if (this.widgets.size() == 0) {
            return 0;
        }
        return solverMeasure(linearSystem, this.widgets, i3);
    }
}
