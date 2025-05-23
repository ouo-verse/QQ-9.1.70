package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> mChildren;

    public WidgetContainer() {
        this.mChildren = new ArrayList<>();
    }

    public void add(ConstraintWidget constraintWidget) {
        this.mChildren.add(constraintWidget);
        if (constraintWidget.getParent() != null) {
            ((WidgetContainer) constraintWidget.getParent()).remove(constraintWidget);
        }
        constraintWidget.setParent(this);
    }

    public ArrayList<ConstraintWidget> getChildren() {
        return this.mChildren;
    }

    public ConstraintWidgetContainer getRootConstraintContainer() {
        ConstraintWidgetContainer constraintWidgetContainer;
        ConstraintWidget parent = getParent();
        if (this instanceof ConstraintWidgetContainer) {
            constraintWidgetContainer = (ConstraintWidgetContainer) this;
        } else {
            constraintWidgetContainer = null;
        }
        while (parent != null) {
            ConstraintWidget parent2 = parent.getParent();
            if (parent instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) parent;
            }
            parent = parent2;
        }
        return constraintWidgetContainer;
    }

    public void layout() {
        ArrayList<ConstraintWidget> arrayList = this.mChildren;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = this.mChildren.get(i3);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).layout();
            }
        }
    }

    public void remove(ConstraintWidget constraintWidget) {
        this.mChildren.remove(constraintWidget);
        constraintWidget.reset();
    }

    public void removeAllChildren() {
        this.mChildren.clear();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void reset() {
        this.mChildren.clear();
        super.reset();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void resetSolverVariables(Cache cache) {
        super.resetSolverVariables(cache);
        int size = this.mChildren.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mChildren.get(i3).resetSolverVariables(cache);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void setOffset(int i3, int i16) {
        super.setOffset(i3, i16);
        int size = this.mChildren.size();
        for (int i17 = 0; i17 < size; i17++) {
            this.mChildren.get(i17).setOffset(getRootX(), getRootY());
        }
    }

    public WidgetContainer(int i3, int i16, int i17, int i18) {
        super(i3, i16, i17, i18);
        this.mChildren = new ArrayList<>();
    }

    public WidgetContainer(int i3, int i16) {
        super(i3, i16);
        this.mChildren = new ArrayList<>();
    }

    public void add(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget constraintWidget : constraintWidgetArr) {
            add(constraintWidget);
        }
    }
}
