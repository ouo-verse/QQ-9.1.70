package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i3) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i3;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        boolean z16;
        int verticalChainStyle;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            WidgetRun next = it.next();
            int i3 = this.orientation;
            if (i3 == 0) {
                next.widget.horizontalChainRun = this;
            } else if (i3 == 1) {
                next.widget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        if (this.orientation == 0) {
            verticalChainStyle = this.widget.getHorizontalChainStyle();
        } else {
            verticalChainStyle = this.widget.getVerticalChainStyle();
        }
        this.chainStyle = verticalChainStyle;
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i3 = 0; i3 < this.widgets.size(); i3++) {
            WidgetRun widgetRun = this.widgets.get(i3);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i3 = 0; i3 < this.widgets.size(); i3++) {
            this.widgets.get(i3).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long j3 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j3 = j3 + r4.start.margin + this.widgets.get(i3).getWrapDimension() + r4.end.margin;
        }
        return j3;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!this.widgets.get(i3).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ChainRun ");
        if (this.orientation == 0) {
            str = "horizontal : ";
        } else {
            str = "vertical : ";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            String str2 = sb6 + "<";
            sb6 = (str2 + it.next()) + "> ";
        }
        return sb6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a5, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x01d0, code lost:
    
        r9.dimension.resolve(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01cd, code lost:
    
        r13 = r13 + 1;
        r7 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x01cb, code lost:
    
        if (r1 != r7) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:0x0418, code lost:
    
        r7 = r7 - r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00eb  */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        boolean z16;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        float f16;
        boolean z17;
        int i26;
        int i27;
        int i28;
        int i29;
        float verticalBiasPercent;
        int i36;
        int i37;
        int i38;
        int i39;
        int i46;
        int i47;
        boolean z18;
        int i48;
        int i49;
        float f17;
        int i56;
        int i57;
        int max;
        int i58;
        boolean z19;
        int i59;
        int i65;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            if (parent != null && (parent instanceof ConstraintWidgetContainer)) {
                z16 = ((ConstraintWidgetContainer) parent).isRtl();
            } else {
                z16 = false;
            }
            int i66 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i67 = 0;
            while (true) {
                i3 = -1;
                i16 = 8;
                if (i67 < size) {
                    if (this.widgets.get(i67).widget.getVisibility() != 8) {
                        break;
                    } else {
                        i67++;
                    }
                } else {
                    i67 = -1;
                    break;
                }
            }
            int i68 = size - 1;
            int i69 = i68;
            while (true) {
                if (i69 < 0) {
                    break;
                }
                if (this.widgets.get(i69).widget.getVisibility() != 8) {
                    i3 = i69;
                    break;
                }
                i69--;
            }
            int i75 = 0;
            while (i75 < 2) {
                int i76 = 0;
                i18 = 0;
                i19 = 0;
                int i77 = 0;
                f16 = 0.0f;
                while (i76 < size) {
                    WidgetRun widgetRun = this.widgets.get(i76);
                    if (widgetRun.widget.getVisibility() != i16) {
                        i77++;
                        if (i76 > 0 && i76 >= i67) {
                            i18 += widgetRun.start.margin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.dimension;
                        int i78 = dimensionDependency.value;
                        if (widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        if (z19) {
                            int i79 = this.orientation;
                            if (i79 == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (i79 == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            } else {
                                i59 = i78;
                            }
                        } else {
                            i59 = i78;
                            if (widgetRun.matchConstraintsType == 1 && i75 == 0) {
                                i65 = dimensionDependency.wrapValue;
                                i19++;
                            } else if (dimensionDependency.resolved) {
                                i65 = i59;
                            }
                            z19 = true;
                            if (z19) {
                                i19++;
                                float f18 = widgetRun.widget.mWeight[this.orientation];
                                if (f18 >= 0.0f) {
                                    f16 += f18;
                                }
                            } else {
                                i18 += i65;
                            }
                            if (i76 < i68 && i76 < i3) {
                                i18 += -widgetRun.end.margin;
                            }
                        }
                        i65 = i59;
                        if (z19) {
                        }
                        if (i76 < i68) {
                            i18 += -widgetRun.end.margin;
                        }
                    }
                    i76++;
                    i16 = 8;
                }
                if (i18 >= i66 && i19 != 0) {
                    i75++;
                    i16 = 8;
                } else {
                    i17 = i77;
                    break;
                }
            }
            i17 = 0;
            i18 = 0;
            i19 = 0;
            f16 = 0.0f;
            int i85 = this.start.value;
            if (z16) {
                i85 = this.end.value;
            }
            if (i18 > i66) {
                if (z16) {
                    i85 += (int) (((i18 - i66) / 2.0f) + 0.5f);
                } else {
                    i85 -= (int) (((i18 - i66) / 2.0f) + 0.5f);
                }
            }
            if (i19 > 0) {
                float f19 = i66 - i18;
                int i86 = (int) ((f19 / i19) + 0.5f);
                int i87 = 0;
                int i88 = 0;
                while (i87 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i87);
                    int i89 = i86;
                    int i95 = i18;
                    if (widgetRun2.widget.getVisibility() != 8 && widgetRun2.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.dimension;
                        if (!dimensionDependency2.resolved) {
                            if (f16 > 0.0f) {
                                i49 = i85;
                                i56 = (int) (((widgetRun2.widget.mWeight[this.orientation] * f19) / f16) + 0.5f);
                            } else {
                                i49 = i85;
                                i56 = i89;
                            }
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.widget;
                                f17 = f19;
                                int i96 = constraintWidget.mMatchConstraintMaxWidth;
                                int i97 = constraintWidget.mMatchConstraintMinWidth;
                                z18 = z16;
                                i48 = i17;
                                if (widgetRun2.matchConstraintsType == 1) {
                                    i58 = Math.min(i56, dimensionDependency2.wrapValue);
                                } else {
                                    i58 = i56;
                                }
                                max = Math.max(i97, i58);
                                if (i96 > 0) {
                                    max = Math.min(i96, max);
                                }
                            } else {
                                z18 = z16;
                                i48 = i17;
                                f17 = f19;
                                ConstraintWidget constraintWidget2 = widgetRun2.widget;
                                int i98 = constraintWidget2.mMatchConstraintMaxHeight;
                                int i99 = constraintWidget2.mMatchConstraintMinHeight;
                                if (widgetRun2.matchConstraintsType == 1) {
                                    i57 = Math.min(i56, dimensionDependency2.wrapValue);
                                } else {
                                    i57 = i56;
                                }
                                max = Math.max(i99, i57);
                                if (i98 > 0) {
                                    max = Math.min(i98, max);
                                }
                            }
                        }
                    }
                    z18 = z16;
                    i48 = i17;
                    i49 = i85;
                    f17 = f19;
                    i87++;
                    i86 = i89;
                    i18 = i95;
                    i85 = i49;
                    f19 = f17;
                    z16 = z18;
                    i17 = i48;
                }
                z17 = z16;
                i26 = i17;
                i27 = i85;
                int i100 = i18;
                if (i88 > 0) {
                    i19 -= i88;
                    int i101 = 0;
                    for (int i102 = 0; i102 < size; i102++) {
                        WidgetRun widgetRun3 = this.widgets.get(i102);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i102 > 0 && i102 >= i67) {
                                i101 += widgetRun3.start.margin;
                            }
                            i101 += widgetRun3.dimension.value;
                            if (i102 < i68 && i102 < i3) {
                                i101 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i18 = i101;
                } else {
                    i18 = i100;
                }
                i29 = 2;
                if (this.chainStyle == 2 && i88 == 0) {
                    i28 = 0;
                    this.chainStyle = 0;
                } else {
                    i28 = 0;
                }
            } else {
                z17 = z16;
                i26 = i17;
                i27 = i85;
                i28 = 0;
                i29 = 2;
            }
            if (i18 > i66) {
                this.chainStyle = i29;
            }
            if (i26 > 0 && i19 == 0 && i67 == i3) {
                this.chainStyle = i29;
            }
            int i103 = this.chainStyle;
            if (i103 == 1) {
                int i104 = i26;
                if (i104 > 1) {
                    i46 = (i66 - i18) / (i104 - 1);
                } else if (i104 == 1) {
                    i46 = (i66 - i18) / 2;
                } else {
                    i46 = i28;
                }
                if (i19 > 0) {
                    i46 = i28;
                }
                int i105 = i27;
                for (int i106 = i28; i106 < size; i106++) {
                    if (z17) {
                        i47 = size - (i106 + 1);
                    } else {
                        i47 = i106;
                    }
                    WidgetRun widgetRun4 = this.widgets.get(i47);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i105);
                        widgetRun4.end.resolve(i105);
                    } else {
                        if (i106 > 0) {
                            if (z17) {
                                i105 -= i46;
                            } else {
                                i105 += i46;
                            }
                        }
                        if (i106 > 0 && i106 >= i67) {
                            if (z17) {
                                i105 -= widgetRun4.start.margin;
                            } else {
                                i105 += widgetRun4.start.margin;
                            }
                        }
                        if (z17) {
                            widgetRun4.end.resolve(i105);
                        } else {
                            widgetRun4.start.resolve(i105);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.dimension;
                        int i107 = dimensionDependency3.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i107 = dimensionDependency3.wrapValue;
                        }
                        if (z17) {
                            i105 -= i107;
                        } else {
                            i105 += i107;
                        }
                        if (z17) {
                            widgetRun4.start.resolve(i105);
                        } else {
                            widgetRun4.end.resolve(i105);
                        }
                        widgetRun4.resolved = true;
                        if (i106 < i68 && i106 < i3) {
                            if (z17) {
                                i105 -= -widgetRun4.end.margin;
                            } else {
                                i105 += -widgetRun4.end.margin;
                            }
                        }
                    }
                }
                return;
            }
            int i108 = i26;
            if (i103 == 0) {
                int i109 = (i66 - i18) / (i108 + 1);
                if (i19 > 0) {
                    i109 = i28;
                }
                int i110 = i27;
                for (int i111 = i28; i111 < size; i111++) {
                    if (z17) {
                        i38 = size - (i111 + 1);
                    } else {
                        i38 = i111;
                    }
                    WidgetRun widgetRun5 = this.widgets.get(i38);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i110);
                        widgetRun5.end.resolve(i110);
                    } else {
                        if (z17) {
                            i39 = i110 - i109;
                        } else {
                            i39 = i110 + i109;
                        }
                        if (i111 > 0 && i111 >= i67) {
                            if (z17) {
                                i39 -= widgetRun5.start.margin;
                            } else {
                                i39 += widgetRun5.start.margin;
                            }
                        }
                        if (z17) {
                            widgetRun5.end.resolve(i39);
                        } else {
                            widgetRun5.start.resolve(i39);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.dimension;
                        int i112 = dimensionDependency4.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            i112 = Math.min(i112, dimensionDependency4.wrapValue);
                        }
                        if (z17) {
                            i110 = i39 - i112;
                        } else {
                            i110 = i39 + i112;
                        }
                        if (z17) {
                            widgetRun5.start.resolve(i110);
                        } else {
                            widgetRun5.end.resolve(i110);
                        }
                        if (i111 < i68 && i111 < i3) {
                            if (z17) {
                                i110 -= -widgetRun5.end.margin;
                            } else {
                                i110 += -widgetRun5.end.margin;
                            }
                        }
                    }
                }
                return;
            }
            if (i103 == 2) {
                if (this.orientation == 0) {
                    verticalBiasPercent = this.widget.getHorizontalBiasPercent();
                } else {
                    verticalBiasPercent = this.widget.getVerticalBiasPercent();
                }
                if (z17) {
                    verticalBiasPercent = 1.0f - verticalBiasPercent;
                }
                int i113 = (int) (((i66 - i18) * verticalBiasPercent) + 0.5f);
                if (i113 < 0 || i19 > 0) {
                    i113 = i28;
                }
                if (z17) {
                    i36 = i27 - i113;
                } else {
                    i36 = i27 + i113;
                }
                for (int i114 = i28; i114 < size; i114++) {
                    if (z17) {
                        i37 = size - (i114 + 1);
                    } else {
                        i37 = i114;
                    }
                    WidgetRun widgetRun6 = this.widgets.get(i37);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i36);
                        widgetRun6.end.resolve(i36);
                    } else {
                        if (i114 > 0 && i114 >= i67) {
                            if (z17) {
                                i36 -= widgetRun6.start.margin;
                            } else {
                                i36 += widgetRun6.start.margin;
                            }
                        }
                        if (z17) {
                            widgetRun6.end.resolve(i36);
                        } else {
                            widgetRun6.start.resolve(i36);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.dimension;
                        int i115 = dimensionDependency5.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i115 = dimensionDependency5.wrapValue;
                        }
                        i36 += i115;
                        if (z17) {
                            widgetRun6.start.resolve(i36);
                        } else {
                            widgetRun6.end.resolve(i36);
                        }
                        if (i114 < i68 && i114 < i3) {
                            if (z17) {
                                i36 -= -widgetRun6.end.margin;
                            } else {
                                i36 += -widgetRun6.end.margin;
                            }
                        }
                    }
                }
            }
        }
    }
}
