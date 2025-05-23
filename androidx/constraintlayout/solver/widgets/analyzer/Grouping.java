package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public static WidgetGroup findDependents(ConstraintWidget constraintWidget, int i3, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int i16;
        int findGroupInDependents;
        if (i3 == 0) {
            i16 = constraintWidget.horizontalGroup;
        } else {
            i16 = constraintWidget.verticalGroup;
        }
        int i17 = 0;
        if (i16 != -1 && (widgetGroup == null || i16 != widgetGroup.f26468id)) {
            int i18 = 0;
            while (true) {
                if (i18 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = arrayList.get(i18);
                if (widgetGroup2.getId() == i16) {
                    if (widgetGroup != null) {
                        widgetGroup.moveTo(i3, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i18++;
                }
            }
        } else if (i16 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if ((constraintWidget instanceof HelperWidget) && (findGroupInDependents = ((HelperWidget) constraintWidget).findGroupInDependents(i3)) != -1) {
                int i19 = 0;
                while (true) {
                    if (i19 >= arrayList.size()) {
                        break;
                    }
                    WidgetGroup widgetGroup3 = arrayList.get(i19);
                    if (widgetGroup3.getId() == findGroupInDependents) {
                        widgetGroup = widgetGroup3;
                        break;
                    }
                    i19++;
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup(i3);
            }
            arrayList.add(widgetGroup);
        }
        if (widgetGroup.add(constraintWidget)) {
            if (constraintWidget instanceof Guideline) {
                Guideline guideline = (Guideline) constraintWidget;
                ConstraintAnchor anchor = guideline.getAnchor();
                if (guideline.getOrientation() == 0) {
                    i17 = 1;
                }
                anchor.findDependents(i17, arrayList, widgetGroup);
            }
            if (i3 == 0) {
                constraintWidget.horizontalGroup = widgetGroup.getId();
                constraintWidget.mLeft.findDependents(i3, arrayList, widgetGroup);
                constraintWidget.mRight.findDependents(i3, arrayList, widgetGroup);
            } else {
                constraintWidget.verticalGroup = widgetGroup.getId();
                constraintWidget.mTop.findDependents(i3, arrayList, widgetGroup);
                constraintWidget.mBaseline.findDependents(i3, arrayList, widgetGroup);
                constraintWidget.mBottom.findDependents(i3, arrayList, widgetGroup);
            }
            constraintWidget.mCenter.findDependents(i3, arrayList, widgetGroup);
        }
        return widgetGroup;
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> arrayList, int i3) {
        int size = arrayList.size();
        for (int i16 = 0; i16 < size; i16++) {
            WidgetGroup widgetGroup = arrayList.get(i16);
            if (i3 == widgetGroup.f26468id) {
                return widgetGroup;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:214:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0390 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x038c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean simpleSolvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        WidgetGroup widgetGroup;
        boolean z16;
        WidgetGroup widgetGroup2;
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        for (int i3 = 0; i3 < size; i3++) {
            ConstraintWidget constraintWidget = children.get(i3);
            if (!validInGroup(constraintWidgetContainer.getHorizontalDimensionBehaviour(), constraintWidgetContainer.getVerticalDimensionBehaviour(), constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getVerticalDimensionBehaviour()) || (constraintWidget instanceof Flow)) {
                return false;
            }
        }
        Metrics metrics = constraintWidgetContainer.mMetrics;
        if (metrics != null) {
            metrics.grouping++;
        }
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        for (int i16 = 0; i16 < size; i16++) {
            ConstraintWidget constraintWidget2 = children.get(i16);
            if (!validInGroup(constraintWidgetContainer.getHorizontalDimensionBehaviour(), constraintWidgetContainer.getVerticalDimensionBehaviour(), constraintWidget2.getHorizontalDimensionBehaviour(), constraintWidget2.getVerticalDimensionBehaviour())) {
                ConstraintWidgetContainer.measure(constraintWidget2, measurer, constraintWidgetContainer.mMeasure, BasicMeasure.Measure.SELF_DIMENSIONS);
            }
            boolean z17 = constraintWidget2 instanceof Guideline;
            if (z17) {
                Guideline guideline = (Guideline) constraintWidget2;
                if (guideline.getOrientation() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(guideline);
                }
                if (guideline.getOrientation() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(guideline);
                }
            }
            if (constraintWidget2 instanceof HelperWidget) {
                if (constraintWidget2 instanceof Barrier) {
                    Barrier barrier = (Barrier) constraintWidget2;
                    if (barrier.getOrientation() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(barrier);
                    }
                    if (barrier.getOrientation() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(barrier);
                    }
                } else {
                    HelperWidget helperWidget = (HelperWidget) constraintWidget2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(helperWidget);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(helperWidget);
                }
            }
            if (constraintWidget2.mLeft.mTarget == null && constraintWidget2.mRight.mTarget == null && !z17 && !(constraintWidget2 instanceof Barrier)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(constraintWidget2);
            }
            if (constraintWidget2.mTop.mTarget == null && constraintWidget2.mBottom.mTarget == null && constraintWidget2.mBaseline.mTarget == null && !z17 && !(constraintWidget2 instanceof Barrier)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(constraintWidget2);
            }
        }
        ArrayList<WidgetGroup> arrayList7 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                findDependents((Guideline) it.next(), 0, arrayList7, null);
            }
        }
        WidgetGroup widgetGroup3 = null;
        int i17 = 0;
        if (arrayList2 != null) {
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                HelperWidget helperWidget2 = (HelperWidget) it5.next();
                WidgetGroup findDependents = findDependents(helperWidget2, i17, arrayList7, widgetGroup3);
                helperWidget2.addDependents(arrayList7, i17, findDependents);
                findDependents.cleanup(arrayList7);
                widgetGroup3 = null;
                i17 = 0;
            }
        }
        ConstraintAnchor anchor = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.LEFT);
        if (anchor.getDependents() != null) {
            Iterator<ConstraintAnchor> it6 = anchor.getDependents().iterator();
            while (it6.hasNext()) {
                findDependents(it6.next().mOwner, 0, arrayList7, null);
            }
        }
        ConstraintAnchor anchor2 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.RIGHT);
        if (anchor2.getDependents() != null) {
            Iterator<ConstraintAnchor> it7 = anchor2.getDependents().iterator();
            while (it7.hasNext()) {
                findDependents(it7.next().mOwner, 0, arrayList7, null);
            }
        }
        ConstraintAnchor anchor3 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.CENTER);
        if (anchor3.getDependents() != null) {
            Iterator<ConstraintAnchor> it8 = anchor3.getDependents().iterator();
            while (it8.hasNext()) {
                findDependents(it8.next().mOwner, 0, arrayList7, null);
            }
        }
        WidgetGroup widgetGroup4 = null;
        if (arrayList5 != null) {
            Iterator it9 = arrayList5.iterator();
            while (it9.hasNext()) {
                findDependents((ConstraintWidget) it9.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it10 = arrayList3.iterator();
            while (it10.hasNext()) {
                findDependents((Guideline) it10.next(), 1, arrayList7, null);
            }
        }
        if (arrayList4 != null) {
            Iterator it11 = arrayList4.iterator();
            while (it11.hasNext()) {
                HelperWidget helperWidget3 = (HelperWidget) it11.next();
                WidgetGroup findDependents2 = findDependents(helperWidget3, 1, arrayList7, widgetGroup4);
                helperWidget3.addDependents(arrayList7, 1, findDependents2);
                findDependents2.cleanup(arrayList7);
                widgetGroup4 = null;
            }
        }
        ConstraintAnchor anchor4 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.TOP);
        if (anchor4.getDependents() != null) {
            Iterator<ConstraintAnchor> it12 = anchor4.getDependents().iterator();
            while (it12.hasNext()) {
                findDependents(it12.next().mOwner, 1, arrayList7, null);
            }
        }
        ConstraintAnchor anchor5 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BASELINE);
        if (anchor5.getDependents() != null) {
            Iterator<ConstraintAnchor> it13 = anchor5.getDependents().iterator();
            while (it13.hasNext()) {
                findDependents(it13.next().mOwner, 1, arrayList7, null);
            }
        }
        ConstraintAnchor anchor6 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.BOTTOM);
        if (anchor6.getDependents() != null) {
            Iterator<ConstraintAnchor> it14 = anchor6.getDependents().iterator();
            while (it14.hasNext()) {
                findDependents(it14.next().mOwner, 1, arrayList7, null);
            }
        }
        ConstraintAnchor anchor7 = constraintWidgetContainer.getAnchor(ConstraintAnchor.Type.CENTER);
        if (anchor7.getDependents() != null) {
            Iterator<ConstraintAnchor> it15 = anchor7.getDependents().iterator();
            while (it15.hasNext()) {
                findDependents(it15.next().mOwner, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it16 = arrayList6.iterator();
            while (it16.hasNext()) {
                findDependents((ConstraintWidget) it16.next(), 1, arrayList7, null);
            }
        }
        for (int i18 = 0; i18 < size; i18++) {
            ConstraintWidget constraintWidget3 = children.get(i18);
            if (constraintWidget3.oppositeDimensionsTied()) {
                WidgetGroup findGroup = findGroup(arrayList7, constraintWidget3.horizontalGroup);
                WidgetGroup findGroup2 = findGroup(arrayList7, constraintWidget3.verticalGroup);
                if (findGroup != null && findGroup2 != null) {
                    findGroup.moveTo(0, findGroup2);
                    findGroup2.setOrientation(2);
                    arrayList7.remove(findGroup);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            Iterator<WidgetGroup> it17 = arrayList7.iterator();
            widgetGroup = null;
            int i19 = 0;
            while (it17.hasNext()) {
                WidgetGroup next = it17.next();
                if (next.getOrientation() != 1) {
                    next.setAuthoritative(false);
                    int measureWrap = next.measureWrap(constraintWidgetContainer.getSystem(), 0);
                    if (measureWrap > i19) {
                        widgetGroup = next;
                        i19 = measureWrap;
                    }
                }
            }
            if (widgetGroup != null) {
                constraintWidgetContainer.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidgetContainer.setWidth(i19);
                widgetGroup.setAuthoritative(true);
                if (constraintWidgetContainer.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    Iterator<WidgetGroup> it18 = arrayList7.iterator();
                    WidgetGroup widgetGroup5 = null;
                    int i26 = 0;
                    while (it18.hasNext()) {
                        WidgetGroup next2 = it18.next();
                        if (next2.getOrientation() != 0) {
                            next2.setAuthoritative(false);
                            int measureWrap2 = next2.measureWrap(constraintWidgetContainer.getSystem(), 1);
                            if (measureWrap2 > i26) {
                                widgetGroup5 = next2;
                                i26 = measureWrap2;
                            }
                        }
                    }
                    z16 = false;
                    if (widgetGroup5 != null) {
                        constraintWidgetContainer.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                        constraintWidgetContainer.setHeight(i26);
                        widgetGroup5.setAuthoritative(true);
                        widgetGroup2 = widgetGroup5;
                        if (widgetGroup == null || widgetGroup2 != null) {
                            return true;
                        }
                        return z16;
                    }
                } else {
                    z16 = false;
                }
                widgetGroup2 = null;
                if (widgetGroup == null) {
                }
                return true;
            }
        }
        widgetGroup = null;
        if (constraintWidgetContainer.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        }
        widgetGroup2 = null;
        if (widgetGroup == null) {
        }
        return true;
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        boolean z16;
        boolean z17;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour3 != dimensionBehaviour7 && dimensionBehaviour3 != (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour3 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == dimensionBehaviour6)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (dimensionBehaviour4 != dimensionBehaviour7 && dimensionBehaviour4 != (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == dimensionBehaviour5)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }
}
