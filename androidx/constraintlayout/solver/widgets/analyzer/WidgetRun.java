package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class WidgetRun implements Dependency {
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public int matchConstraintsType;
    RunGroup runGroup;
    ConstraintWidget widget;
    DimensionDependency dimension = new DimensionDependency(this);
    public int orientation = 0;
    boolean resolved = false;
    public DependencyNode start = new DependencyNode(this);
    public DependencyNode end = new DependencyNode(this);
    protected RunType mRunType = RunType.NONE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.widget = constraintWidget;
    }

    private void resolveDimension(int i3, int i16) {
        WidgetRun widgetRun;
        float f16;
        int i17;
        int i18 = this.matchConstraintsType;
        if (i18 != 0) {
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 == 3) {
                        ConstraintWidget constraintWidget = this.widget;
                        WidgetRun widgetRun2 = constraintWidget.horizontalRun;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun2.dimensionBehavior;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun2.matchConstraintsType == 3) {
                            VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
                            if (verticalWidgetRun.dimensionBehavior == dimensionBehaviour2 && verticalWidgetRun.matchConstraintsType == 3) {
                                return;
                            }
                        }
                        if (i3 == 0) {
                            widgetRun2 = constraintWidget.verticalRun;
                        }
                        if (widgetRun2.dimension.resolved) {
                            float dimensionRatio = constraintWidget.getDimensionRatio();
                            if (i3 == 1) {
                                i17 = (int) ((widgetRun2.dimension.value / dimensionRatio) + 0.5f);
                            } else {
                                i17 = (int) ((dimensionRatio * widgetRun2.dimension.value) + 0.5f);
                            }
                            this.dimension.resolve(i17);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintWidget parent = this.widget.getParent();
                if (parent != null) {
                    if (i3 == 0) {
                        widgetRun = parent.horizontalRun;
                    } else {
                        widgetRun = parent.verticalRun;
                    }
                    if (widgetRun.dimension.resolved) {
                        ConstraintWidget constraintWidget2 = this.widget;
                        if (i3 == 0) {
                            f16 = constraintWidget2.mMatchConstraintPercentWidth;
                        } else {
                            f16 = constraintWidget2.mMatchConstraintPercentHeight;
                        }
                        this.dimension.resolve(getLimitedDimension((int) ((r9.value * f16) + 0.5f), i3));
                        return;
                    }
                    return;
                }
                return;
            }
            this.dimension.resolve(Math.min(getLimitedDimension(this.dimension.wrapValue, i3), i16));
            return;
        }
        this.dimension.resolve(getLimitedDimension(i16, i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i3) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = i3;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void apply();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void applyToWidget();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void clear();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getLimitedDimension(int i3, int i16) {
        int max;
        if (i16 == 0) {
            ConstraintWidget constraintWidget = this.widget;
            int i17 = constraintWidget.mMatchConstraintMaxWidth;
            max = Math.max(constraintWidget.mMatchConstraintMinWidth, i3);
            if (i17 > 0) {
                max = Math.min(i17, i3);
            }
            if (max == i3) {
                return i3;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.widget;
            int i18 = constraintWidget2.mMatchConstraintMaxHeight;
            max = Math.max(constraintWidget2.mMatchConstraintMinHeight, i3);
            if (i18 > 0) {
                max = Math.min(i18, i3);
            }
            if (max == i3) {
                return i3;
            }
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i3 == 1) {
            return constraintWidget.horizontalRun.start;
        }
        if (i3 == 2) {
            return constraintWidget.horizontalRun.end;
        }
        if (i3 == 3) {
            return constraintWidget.verticalRun.start;
        }
        if (i3 == 4) {
            return constraintWidget.verticalRun.baseline;
        }
        if (i3 != 5) {
            return null;
        }
        return constraintWidget.verticalRun.end;
    }

    public long getWrapDimension() {
        if (this.dimension.resolved) {
            return r0.value;
        }
        return 0L;
    }

    public boolean isCenterConnection() {
        int size = this.start.targets.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            if (this.start.targets.get(i16).run != this) {
                i3++;
            }
        }
        int size2 = this.end.targets.size();
        for (int i17 = 0; i17 < size2; i17++) {
            if (this.end.targets.get(i17).run != this) {
                i3++;
            }
        }
        if (i3 < 2) {
            return false;
        }
        return true;
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    abstract void reset();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean supportsWrapComputation();

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i3) {
        float verticalBiasPercent;
        DependencyNode target = getTarget(constraintAnchor);
        DependencyNode target2 = getTarget(constraintAnchor2);
        if (target.resolved && target2.resolved) {
            int margin = target.value + constraintAnchor.getMargin();
            int margin2 = target2.value - constraintAnchor2.getMargin();
            int i16 = margin2 - margin;
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                resolveDimension(i3, i16);
            }
            DimensionDependency dimensionDependency = this.dimension;
            if (!dimensionDependency.resolved) {
                return;
            }
            if (dimensionDependency.value == i16) {
                this.start.resolve(margin);
                this.end.resolve(margin2);
                return;
            }
            ConstraintWidget constraintWidget = this.widget;
            if (i3 == 0) {
                verticalBiasPercent = constraintWidget.getHorizontalBiasPercent();
            } else {
                verticalBiasPercent = constraintWidget.getVerticalBiasPercent();
            }
            if (target == target2) {
                margin = target.value;
                margin2 = target2.value;
                verticalBiasPercent = 0.5f;
            }
            this.start.resolve((int) (margin + 0.5f + (((margin2 - margin) - this.dimension.value) * verticalBiasPercent)));
            this.end.resolve(this.start.value + this.dimension.value);
        }
    }

    public long wrapSize(int i3) {
        int i16;
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            long j3 = dimensionDependency.value;
            if (isCenterConnection()) {
                i16 = this.start.margin - this.end.margin;
            } else if (i3 == 0) {
                i16 = this.start.margin;
            } else {
                return j3 - this.end.margin;
            }
            return j3 + i16;
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i3, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = i3;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int i3) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
        WidgetRun widgetRun = i3 == 0 ? constraintWidget.horizontalRun : constraintWidget.verticalRun;
        int i16 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor2.mType.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.end;
        }
        return widgetRun.start;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRunEnd(Dependency dependency) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateRunStart(Dependency dependency) {
    }
}
