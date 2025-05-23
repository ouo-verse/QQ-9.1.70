package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

/* compiled from: P */
/* loaded from: classes.dex */
public class HorizontalWidgetRun extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    /* compiled from: P */
    /* renamed from: androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
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

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] iArr, int i3, int i16, int i17, int i18, float f16, int i19) {
        int i26 = i16 - i3;
        int i27 = i18 - i17;
        if (i19 != -1) {
            if (i19 != 0) {
                if (i19 == 1) {
                    iArr[0] = i26;
                    iArr[1] = (int) ((i26 * f16) + 0.5f);
                    return;
                }
                return;
            }
            iArr[0] = (int) ((i27 * f16) + 0.5f);
            iArr[1] = i27;
            return;
        }
        int i28 = (int) ((i27 * f16) + 0.5f);
        int i29 = (int) ((i26 / f16) + 0.5f);
        if (i28 <= i26) {
            iArr[0] = i28;
            iArr[1] = i27;
        } else if (i29 <= i27) {
            iArr[0] = i26;
            iArr[1] = i29;
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void apply() {
        ConstraintWidget parent;
        ConstraintWidget parent2;
        ConstraintWidget constraintWidget = this.widget;
        if (constraintWidget.measured) {
            this.dimension.resolve(constraintWidget.getWidth());
        }
        if (!this.dimension.resolved) {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = this.widget.getHorizontalDimensionBehaviour();
            this.dimensionBehavior = horizontalDimensionBehaviour;
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (horizontalDimensionBehaviour == dimensionBehaviour && (((parent2 = this.widget.getParent()) != null && parent2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent2.getHorizontalDimensionBehaviour() == dimensionBehaviour)) {
                    int width = (parent2.getWidth() - this.widget.mLeft.getMargin()) - this.widget.mRight.getMargin();
                    addTarget(this.start, parent2.horizontalRun.start, this.widget.mLeft.getMargin());
                    addTarget(this.end, parent2.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(width);
                    return;
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.dimensionBehavior;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (((parent = this.widget.getParent()) != null && parent.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) || parent.getHorizontalDimensionBehaviour() == dimensionBehaviour3)) {
                addTarget(this.start, parent.horizontalRun.start, this.widget.mLeft.getMargin());
                addTarget(this.end, parent.horizontalRun.end, -this.widget.mRight.getMargin());
                return;
            }
        }
        DimensionDependency dimensionDependency = this.dimension;
        if (dimensionDependency.resolved) {
            ConstraintWidget constraintWidget2 = this.widget;
            if (constraintWidget2.measured) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.mListAnchors;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && constraintAnchorArr[1].mTarget != null) {
                    if (constraintWidget2.isInHorizontalChain()) {
                        this.start.margin = this.widget.mListAnchors[0].getMargin();
                        this.end.margin = -this.widget.mListAnchors[1].getMargin();
                        return;
                    }
                    DependencyNode target = getTarget(this.widget.mListAnchors[0]);
                    if (target != null) {
                        addTarget(this.start, target, this.widget.mListAnchors[0].getMargin());
                    }
                    DependencyNode target2 = getTarget(this.widget.mListAnchors[1]);
                    if (target2 != null) {
                        addTarget(this.end, target2, -this.widget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode target3 = getTarget(constraintAnchor);
                    if (target3 != null) {
                        addTarget(this.start, target3, this.widget.mListAnchors[0].getMargin());
                        addTarget(this.end, this.start, this.dimension.value);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.mTarget != null) {
                    DependencyNode target4 = getTarget(constraintAnchor3);
                    if (target4 != null) {
                        addTarget(this.end, target4, -this.widget.mListAnchors[1].getMargin());
                        addTarget(this.start, this.end, -this.dimension.value);
                        return;
                    }
                    return;
                }
                if (!(constraintWidget2 instanceof Helper) && constraintWidget2.getParent() != null && this.widget.getAnchor(ConstraintAnchor.Type.CENTER).mTarget == null) {
                    addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
                    addTarget(this.end, this.start, this.dimension.value);
                    return;
                }
                return;
            }
        }
        if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.widget;
            int i3 = constraintWidget3.mMatchConstraintDefaultWidth;
            if (i3 != 2) {
                if (i3 == 3) {
                    if (constraintWidget3.mMatchConstraintDefaultHeight == 3) {
                        this.start.updateDelegate = this;
                        this.end.updateDelegate = this;
                        VerticalWidgetRun verticalWidgetRun = constraintWidget3.verticalRun;
                        verticalWidgetRun.start.updateDelegate = this;
                        verticalWidgetRun.end.updateDelegate = this;
                        dimensionDependency.updateDelegate = this;
                        if (constraintWidget3.isInVerticalChain()) {
                            this.dimension.targets.add(this.widget.verticalRun.dimension);
                            this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                            VerticalWidgetRun verticalWidgetRun2 = this.widget.verticalRun;
                            verticalWidgetRun2.dimension.updateDelegate = this;
                            this.dimension.targets.add(verticalWidgetRun2.start);
                            this.dimension.targets.add(this.widget.verticalRun.end);
                            this.widget.verticalRun.start.dependencies.add(this.dimension);
                            this.widget.verticalRun.end.dependencies.add(this.dimension);
                        } else if (this.widget.isInHorizontalChain()) {
                            this.widget.verticalRun.dimension.targets.add(this.dimension);
                            this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                        } else {
                            this.widget.verticalRun.dimension.targets.add(this.dimension);
                        }
                    } else {
                        DimensionDependency dimensionDependency2 = constraintWidget3.verticalRun.dimension;
                        dimensionDependency.targets.add(dimensionDependency2);
                        dimensionDependency2.dependencies.add(this.dimension);
                        this.widget.verticalRun.start.dependencies.add(this.dimension);
                        this.widget.verticalRun.end.dependencies.add(this.dimension);
                        DimensionDependency dimensionDependency3 = this.dimension;
                        dimensionDependency3.delegateToWidgetRun = true;
                        dimensionDependency3.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                        this.start.targets.add(this.dimension);
                        this.end.targets.add(this.dimension);
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
        }
        ConstraintWidget constraintWidget4 = this.widget;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.mListAnchors;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].mTarget != null) {
            if (constraintWidget4.isInHorizontalChain()) {
                this.start.margin = this.widget.mListAnchors[0].getMargin();
                this.end.margin = -this.widget.mListAnchors[1].getMargin();
                return;
            }
            DependencyNode target5 = getTarget(this.widget.mListAnchors[0]);
            DependencyNode target6 = getTarget(this.widget.mListAnchors[1]);
            target5.addDependency(this);
            target6.addDependency(this);
            this.mRunType = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode target7 = getTarget(constraintAnchor4);
            if (target7 != null) {
                addTarget(this.start, target7, this.widget.mListAnchors[0].getMargin());
                addTarget(this.end, this.start, 1, this.dimension);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.mTarget != null) {
            DependencyNode target8 = getTarget(constraintAnchor6);
            if (target8 != null) {
                addTarget(this.end, target8, -this.widget.mListAnchors[1].getMargin());
                addTarget(this.start, this.end, -1, this.dimension);
                return;
            }
            return;
        }
        if (!(constraintWidget4 instanceof Helper) && constraintWidget4.getParent() != null) {
            addTarget(this.start, this.widget.getParent().horizontalRun.start, this.widget.getX());
            addTarget(this.end, this.start, 1, this.dimension);
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        DependencyNode dependencyNode = this.start;
        if (dependencyNode.resolved) {
            this.widget.setX(dependencyNode.value);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
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
        this.dimension.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.widget.mMatchConstraintDefaultWidth == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "HorizontalRun " + this.widget.getDebugName();
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x02b9, code lost:
    
        if (r14 != 1) goto L135;
     */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        float f16;
        float dimensionRatio;
        float f17;
        int i3;
        int i16 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 == 3) {
                    ConstraintWidget constraintWidget = this.widget;
                    updateRunCenter(dependency, constraintWidget.mLeft, constraintWidget.mRight, 0);
                    return;
                }
            } else {
                updateRunEnd(dependency);
            }
        } else {
            updateRunStart(dependency);
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.widget;
            int i17 = constraintWidget2.mMatchConstraintDefaultWidth;
            if (i17 != 2) {
                if (i17 == 3) {
                    int i18 = constraintWidget2.mMatchConstraintDefaultHeight;
                    if (i18 != 0 && i18 != 3) {
                        int dimensionRatioSide = constraintWidget2.getDimensionRatioSide();
                        if (dimensionRatioSide != -1) {
                            if (dimensionRatioSide != 0) {
                                if (dimensionRatioSide != 1) {
                                    i3 = 0;
                                    this.dimension.resolve(i3);
                                } else {
                                    ConstraintWidget constraintWidget3 = this.widget;
                                    f16 = constraintWidget3.verticalRun.dimension.value;
                                    dimensionRatio = constraintWidget3.getDimensionRatio();
                                }
                            } else {
                                f17 = r0.verticalRun.dimension.value / this.widget.getDimensionRatio();
                                i3 = (int) (f17 + 0.5f);
                                this.dimension.resolve(i3);
                            }
                        } else {
                            ConstraintWidget constraintWidget4 = this.widget;
                            f16 = constraintWidget4.verticalRun.dimension.value;
                            dimensionRatio = constraintWidget4.getDimensionRatio();
                        }
                        f17 = f16 * dimensionRatio;
                        i3 = (int) (f17 + 0.5f);
                        this.dimension.resolve(i3);
                    } else {
                        VerticalWidgetRun verticalWidgetRun = constraintWidget2.verticalRun;
                        DependencyNode dependencyNode = verticalWidgetRun.start;
                        DependencyNode dependencyNode2 = verticalWidgetRun.end;
                        if (constraintWidget2.mLeft.mTarget != null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (constraintWidget2.mTop.mTarget != null) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (constraintWidget2.mRight.mTarget != null) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (constraintWidget2.mBottom.mTarget != null) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        int dimensionRatioSide2 = constraintWidget2.getDimensionRatioSide();
                        if (z16 && z17 && z18 && z19) {
                            float dimensionRatio2 = this.widget.getDimensionRatio();
                            if (dependencyNode.resolved && dependencyNode2.resolved) {
                                DependencyNode dependencyNode3 = this.start;
                                if (dependencyNode3.readyToSolve && this.end.readyToSolve) {
                                    computeInsetRatio(tempDimensions, dependencyNode3.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.value + dependencyNode.margin, dependencyNode2.value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide2);
                                    this.dimension.resolve(tempDimensions[0]);
                                    this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                    return;
                                }
                                return;
                            }
                            DependencyNode dependencyNode4 = this.start;
                            if (dependencyNode4.resolved) {
                                DependencyNode dependencyNode5 = this.end;
                                if (dependencyNode5.resolved) {
                                    if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                        computeInsetRatio(tempDimensions, dependencyNode4.value + dependencyNode4.margin, dependencyNode5.value - dependencyNode5.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide2);
                                        this.dimension.resolve(tempDimensions[0]);
                                        this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            DependencyNode dependencyNode6 = this.start;
                            if (dependencyNode6.readyToSolve && this.end.readyToSolve && dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                computeInsetRatio(tempDimensions, dependencyNode6.targets.get(0).value + this.start.margin, this.end.targets.get(0).value - this.end.margin, dependencyNode.targets.get(0).value + dependencyNode.margin, dependencyNode2.targets.get(0).value - dependencyNode2.margin, dimensionRatio2, dimensionRatioSide2);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                            } else {
                                return;
                            }
                        } else if (z16 && z18) {
                            if (this.start.readyToSolve && this.end.readyToSolve) {
                                float dimensionRatio3 = this.widget.getDimensionRatio();
                                int i19 = this.start.targets.get(0).value + this.start.margin;
                                int i26 = this.end.targets.get(0).value - this.end.margin;
                                if (dimensionRatioSide2 != -1 && dimensionRatioSide2 != 0) {
                                    if (dimensionRatioSide2 == 1) {
                                        int limitedDimension = getLimitedDimension(i26 - i19, 0);
                                        int i27 = (int) ((limitedDimension / dimensionRatio3) + 0.5f);
                                        int limitedDimension2 = getLimitedDimension(i27, 1);
                                        if (i27 != limitedDimension2) {
                                            limitedDimension = (int) ((limitedDimension2 * dimensionRatio3) + 0.5f);
                                        }
                                        this.dimension.resolve(limitedDimension);
                                        this.widget.verticalRun.dimension.resolve(limitedDimension2);
                                    }
                                } else {
                                    int limitedDimension3 = getLimitedDimension(i26 - i19, 0);
                                    int i28 = (int) ((limitedDimension3 * dimensionRatio3) + 0.5f);
                                    int limitedDimension4 = getLimitedDimension(i28, 1);
                                    if (i28 != limitedDimension4) {
                                        limitedDimension3 = (int) ((limitedDimension4 / dimensionRatio3) + 0.5f);
                                    }
                                    this.dimension.resolve(limitedDimension3);
                                    this.widget.verticalRun.dimension.resolve(limitedDimension4);
                                }
                            } else {
                                return;
                            }
                        } else if (z17 && z19) {
                            if (dependencyNode.readyToSolve && dependencyNode2.readyToSolve) {
                                float dimensionRatio4 = this.widget.getDimensionRatio();
                                int i29 = dependencyNode.targets.get(0).value + dependencyNode.margin;
                                int i36 = dependencyNode2.targets.get(0).value - dependencyNode2.margin;
                                if (dimensionRatioSide2 != -1) {
                                    if (dimensionRatioSide2 == 0) {
                                        int limitedDimension5 = getLimitedDimension(i36 - i29, 1);
                                        int i37 = (int) ((limitedDimension5 * dimensionRatio4) + 0.5f);
                                        int limitedDimension6 = getLimitedDimension(i37, 0);
                                        if (i37 != limitedDimension6) {
                                            limitedDimension5 = (int) ((limitedDimension6 / dimensionRatio4) + 0.5f);
                                        }
                                        this.dimension.resolve(limitedDimension6);
                                        this.widget.verticalRun.dimension.resolve(limitedDimension5);
                                    }
                                }
                                int limitedDimension7 = getLimitedDimension(i36 - i29, 1);
                                int i38 = (int) ((limitedDimension7 / dimensionRatio4) + 0.5f);
                                int limitedDimension8 = getLimitedDimension(i38, 0);
                                if (i38 != limitedDimension8) {
                                    limitedDimension7 = (int) ((limitedDimension8 * dimensionRatio4) + 0.5f);
                                }
                                this.dimension.resolve(limitedDimension8);
                                this.widget.verticalRun.dimension.resolve(limitedDimension7);
                            } else {
                                return;
                            }
                        }
                    }
                }
            } else {
                ConstraintWidget parent = constraintWidget2.getParent();
                if (parent != null) {
                    if (parent.horizontalRun.dimension.resolved) {
                        this.dimension.resolve((int) ((r0.value * this.widget.mMatchConstraintPercentWidth) + 0.5f));
                    }
                }
            }
        }
        DependencyNode dependencyNode7 = this.start;
        if (dependencyNode7.readyToSolve) {
            DependencyNode dependencyNode8 = this.end;
            if (dependencyNode8.readyToSolve) {
                if (dependencyNode7.resolved && dependencyNode8.resolved && this.dimension.resolved) {
                    return;
                }
                if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.widget;
                    if (constraintWidget5.mMatchConstraintDefaultWidth == 0 && !constraintWidget5.isInHorizontalChain()) {
                        DependencyNode dependencyNode9 = this.start.targets.get(0);
                        DependencyNode dependencyNode10 = this.end.targets.get(0);
                        int i39 = dependencyNode9.value;
                        DependencyNode dependencyNode11 = this.start;
                        int i46 = i39 + dependencyNode11.margin;
                        int i47 = dependencyNode10.value + this.end.margin;
                        dependencyNode11.resolve(i46);
                        this.end.resolve(i47);
                        this.dimension.resolve(i47 - i46);
                        return;
                    }
                }
                if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
                    DependencyNode dependencyNode12 = this.start.targets.get(0);
                    int min = Math.min((this.end.targets.get(0).value + this.end.margin) - (dependencyNode12.value + this.start.margin), this.dimension.wrapValue);
                    ConstraintWidget constraintWidget6 = this.widget;
                    int i48 = constraintWidget6.mMatchConstraintMaxWidth;
                    int max = Math.max(constraintWidget6.mMatchConstraintMinWidth, min);
                    if (i48 > 0) {
                        max = Math.min(i48, max);
                    }
                    this.dimension.resolve(max);
                }
                if (!this.dimension.resolved) {
                    return;
                }
                DependencyNode dependencyNode13 = this.start.targets.get(0);
                DependencyNode dependencyNode14 = this.end.targets.get(0);
                int i49 = dependencyNode13.value + this.start.margin;
                int i56 = dependencyNode14.value + this.end.margin;
                float horizontalBiasPercent = this.widget.getHorizontalBiasPercent();
                if (dependencyNode13 == dependencyNode14) {
                    i49 = dependencyNode13.value;
                    i56 = dependencyNode14.value;
                    horizontalBiasPercent = 0.5f;
                }
                this.start.resolve((int) (i49 + 0.5f + (((i56 - i49) - this.dimension.value) * horizontalBiasPercent)));
                this.end.resolve(this.start.value + this.dimension.value);
            }
        }
    }
}
