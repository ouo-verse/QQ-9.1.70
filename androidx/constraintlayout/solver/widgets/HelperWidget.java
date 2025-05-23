package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i3 = this.mWidgetsCount + 1;
            ConstraintWidget[] constraintWidgetArr = this.mWidgets;
            if (i3 > constraintWidgetArr.length) {
                this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
            int i16 = this.mWidgetsCount;
            constraintWidgetArr2[i16] = constraintWidget;
            this.mWidgetsCount = i16 + 1;
        }
    }

    public void addDependents(ArrayList<WidgetGroup> arrayList, int i3, WidgetGroup widgetGroup) {
        for (int i16 = 0; i16 < this.mWidgetsCount; i16++) {
            widgetGroup.add(this.mWidgets[i16]);
        }
        for (int i17 = 0; i17 < this.mWidgetsCount; i17++) {
            Grouping.findDependents(this.mWidgets[i17], i3, arrayList, widgetGroup);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i3 = helperWidget.mWidgetsCount;
        for (int i16 = 0; i16 < i3; i16++) {
            add(hashMap.get(helperWidget.mWidgets[i16]));
        }
    }

    public int findGroupInDependents(int i3) {
        int i16;
        int i17;
        for (int i18 = 0; i18 < this.mWidgetsCount; i18++) {
            ConstraintWidget constraintWidget = this.mWidgets[i18];
            if (i3 == 0 && (i17 = constraintWidget.horizontalGroup) != -1) {
                return i17;
            }
            if (i3 == 1 && (i16 = constraintWidget.verticalGroup) != -1) {
                return i16;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, (Object) null);
    }

    @Override // androidx.constraintlayout.solver.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
