package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

/* compiled from: P */
/* loaded from: classes.dex */
public class VerticalWidgetRun extends WidgetRun {
    public DependencyNode baseline;
    DimensionDependency baselineDimension;

    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.baseline = dependencyNode;
        this.baselineDimension = null;
        this.start.type = DependencyNode.Type.TOP;
        this.end.type = DependencyNode.Type.BOTTOM;
        dependencyNode.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getHeight());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if (this.widget.hasBaseline()) {
                this.baselineDimension = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.dimensionBehavior;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent2 = this.widget.getParent()) != null && parent2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int height = (parent2.getHeight() - this.widget.mTop.getMargin()) - this.widget.mBottom.getMargin();
                    addTarget(this.start, parent2.verticalRun.start, this.widget.mTop.getMargin());
                    addTarget(this.end, parent2.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(height);
                    return;
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (parent = this.widget.getParent()) != null && parent.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            addTarget(this.start, parent.verticalRun.start, this.widget.mTop.getMargin());
            addTarget(this.end, parent.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }
        DimensionDependency dimensionDependency = this.dimension;
        boolean z16 = dimensionDependency.resolved;
        if (z16) {
            ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[3].mTarget != null) {
                    if (constraintWidget2.isInVerticalChain()) {
                        this.start.margin = this.widget.mListAnchors[2].getMargin();
                        this.end.margin = -this.widget.mListAnchors[3].getMargin();
                    } else {
                        DependencyNode target = getTarget(this.widget.mListAnchors[2]);
                        if (target != null) {
                            addTarget(this.start, target, this.widget.mListAnchors[2].getMargin());
                        }
                        DependencyNode target2 = getTarget(this.widget.mListAnchors[3]);
                        if (target2 != null) {
                            addTarget(this.end, target2, -this.widget.mListAnchors[3].getMargin());
                        }
                        this.start.delegateToWidgetRun = true;
                        this.end.delegateToWidgetRun = true;
                    }
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.widget.mListAnchors[2].getMargin());
                        addTarget(this.end, this.start, this.dimension.value);
                        if (this.widget.hasBaseline()) {
                            addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.widget.mListAnchors[3].getMargin());
                        addTarget(this.start, this.end, -this.dimension.value);
                    }
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.mTarget != null) {
                    DependencyNode target5 = getTarget(constraintAnchor4);
                    if (target5 != null) {
                        addTarget(this.baseline, target5, 0);
                        addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                    addTarget(this.end, this.start, this.dimension.value);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (!z16 && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.widget;
            int i3 = constraintWidget3.mMatchConstraintDefaultHeight;
            if (i3 != 2) {
                if (i3 == 3 && !constraintWidget3.isInVerticalChain()) {
                    ConstraintWidget constraintWidget4 = this.widget;
                    if (constraintWidget4.mMatchConstraintDefaultWidth != 3) {
                        DimensionDependency dimensionDependency2 = constraintWidget4.horizontalRun.dimension;
                        this.dimension.targets.add(dimensionDependency2);
                        dimensionDependency2.dependencies.add(this.dimension);
                        DimensionDependency dimensionDependency3 = this.dimension;
                        dimensionDependency3.delegateToWidgetRun = true;
                        dimensionDependency3.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                }
            } else {
                ConstraintWidget parent3 = constraintWidget3.getParent();
                if (parent3 != null) {
                    DimensionDependency dimensionDependency4 = parent3.verticalRun.dimension;
                    this.dimension.targets.add(dimensionDependency4);
                    dimensionDependency4.dependencies.add(this.dimension);
                    DimensionDependency dimensionDependency5 = this.dimension;
                    dimensionDependency5.delegateToWidgetRun = true;
                    dimensionDependency5.dependencies.add(this.start);
                    this.dimension.dependencies.add(this.end);
                }
            }
        } else {
            dimensionDependency.addDependency(this);
        }
        ConstraintWidget constraintWidget5 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.mListAnchors;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.mTarget;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].mTarget != null) {
            if (constraintWidget5.isInVerticalChain()) {
                this.start.margin = this.widget.mListAnchors[2].getMargin();
                this.end.margin = -this.widget.mListAnchors[3].getMargin();
            } else {
                DependencyNode target6 = getTarget(this.widget.mListAnchors[2]);
                DependencyNode target7 = getTarget(this.widget.mListAnchors[3]);
                target6.addDependency(this);
                target7.addDependency(this);
                this.mRunType = WidgetRun.RunType.CENTER;
            }
            if (this.widget.hasBaseline()) {
                addTarget(this.baseline, this.start, 1, this.baselineDimension);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode target8 = getTarget(constraintAnchor5);
            if (target8 != null) {
                addTarget(this.start, target8, this.widget.mListAnchors[2].getMargin());
                addTarget(this.end, this.start, 1, this.dimension);
                if (this.widget.hasBaseline()) {
                    addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.widget.getDimensionRatio() > 0.0f) {
                    HorizontalWidgetRun horizontalWidgetRun = this.widget.horizontalRun;
                    if (horizontalWidgetRun.dimensionBehavior == dimensionBehaviour3) {
                        horizontalWidgetRun.dimension.dependencies.add(this.dimension);
                        this.dimension.targets.add(this.widget.horizontalRun.dimension);
                        this.dimension.updateDelegate = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.mTarget != null) {
                DependencyNode target9 = getTarget(constraintAnchor7);
                if (target9 != null) {
                    addTarget(this.end, target9, -this.widget.mListAnchors[3].getMargin());
                    addTarget(this.start, this.end, -1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.mTarget != null) {
                    DependencyNode target10 = getTarget(constraintAnchor8);
                    if (target10 != null) {
                        addTarget(this.baseline, target10, 0);
                        addTarget(this.start, this.baseline, -1, this.baselineDimension);
                        addTarget(this.end, this.start, 1, this.dimension);
                    }
                } else if (!(constraintWidget5 instanceof Helper) && constraintWidget5.getParent() != null) {
                    addTarget(this.start, this.widget.getParent().verticalRun.start, this.widget.getY());
                    addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.dimensionBehavior;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.widget.getDimensionRatio() > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun2 = this.widget.horizontalRun;
                        if (horizontalWidgetRun2.dimensionBehavior == dimensionBehaviour5) {
                            horizontalWidgetRun2.dimension.dependencies.add(this.dimension);
                            this.dimension.targets.add(this.widget.horizontalRun.dimension);
                            this.dimension.updateDelegate = this;
                        }
                    }
                }
            }
        }
        if (this.dimension.targets.size() == 0) {
            this.dimension.readyToSolve = true;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setY(dependencyNode.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultHeight == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "VerticalRun " + this.widget.getDebugName();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        float f16;
        float dimensionRatio;
        float f17;
        int i3;
        int i16 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    ConstraintWidget constraintWidget = this.widget;
                    updateRunCenter(dependency, constraintWidget.mTop, constraintWidget.mBottom, 1);
                    return;
                }
            } else {
                updateRunEnd(dependency);
            }
        } else {
            updateRunStart(dependency);
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.readyToSolve && !dimensionDependency.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.widget;
            int i17 = constraintWidget2.mMatchConstraintDefaultHeight;
            if (i17 != 2) {
                if (i17 == 3 && constraintWidget2.horizontalRun.dimension.resolved) {
                    int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                    if (dimensionRatioSide != -1) {
                        if (dimensionRatioSide != 0) {
                            if (dimensionRatioSide != 1) {
                                i3 = 0;
                                this.dimension.resolve(i3);
                            } else {
                                ConstraintWidget constraintWidget3 = this.widget;
                                f16 = constraintWidget3.horizontalRun.dimension.value;
                                dimensionRatio = constraintWidget3.getDimensionRatio();
                            }
                        } else {
                            f17 = r7.horizontalRun.dimension.value * this.widget.getDimensionRatio();
                            i3 = (int) (f17 + 0.5f);
                            this.dimension.resolve(i3);
                        }
                    } else {
                        ConstraintWidget constraintWidget4 = this.widget;
                        f16 = constraintWidget4.horizontalRun.dimension.value;
                        dimensionRatio = constraintWidget4.getDimensionRatio();
                    }
                    f17 = f16 / dimensionRatio;
                    i3 = (int) (f17 + 0.5f);
                    this.dimension.resolve(i3);
                }
            } else {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.verticalRun.dimension.resolved) {
                        this.dimension.resolve((int) ((r7.value * this.widget.mMatchConstraintPercentHeight) + 0.5f));
                    }
                }
            }
        }
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.readyToSolve) {
            DependencyNode dependencyNode2 = this.end;
            if (dependencyNode2.readyToSolve) {
                if (dependencyNode.resolved && dependencyNode2.resolved && this.dimension.resolved) {
                    return;
                }
                if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.widget;
                    if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInVerticalChain()) {
                        DependencyNode dependencyNode3 = this.start.targets.get(0);
                        DependencyNode dependencyNode4 = this.end.targets.get(0);
                        int i18 = dependencyNode3.value;
                        DependencyNode dependencyNode5 = this.start;
                        int i19 = i18 + dependencyNode5.margin;
                        int i26 = dependencyNode4.value + this.end.margin;
                        dependencyNode5.resolve(i19);
                        this.end.resolve(i26);
                        this.dimension.resolve(i26 - i19);
                        return;
                    }
                }
                if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    DependencyNode dependencyNode6 = this.start.targets.get(0);
                    int i27 = (this.end.targets.get(0).value + this.end.margin) - (dependencyNode6.value + this.start.margin);
                    DimensionDependency dimensionDependency2 = this.dimension;
                    int i28 = dimensionDependency2.wrapValue;
                    if (i27 < i28) {
                        dimensionDependency2.resolve(i27);
                    } else {
                        dimensionDependency2.resolve(i28);
                    }
                }
                if (this.dimension.resolved && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    DependencyNode dependencyNode7 = this.start.targets.get(0);
                    DependencyNode dependencyNode8 = this.end.targets.get(0);
                    int i29 = dependencyNode7.value + this.start.margin;
                    int i36 = dependencyNode8.value + this.end.margin;
                    float verticalBiasPercent = this.widget.getVerticalBiasPercent();
                    if (dependencyNode7 == dependencyNode8) {
                        i29 = dependencyNode7.value;
                        i36 = dependencyNode8.value;
                        verticalBiasPercent = 0.5f;
                    }
                    this.start.resolve((int) (i29 + 0.5f + (((i36 - i29) - this.dimension.value) * verticalBiasPercent)));
                    this.end.resolve(this.start.value + this.dimension.value);
                }
            }
        }
    }
}
