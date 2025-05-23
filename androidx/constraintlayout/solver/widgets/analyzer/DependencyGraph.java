package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes.dex */
public class DependencyGraph {
    private static final boolean USE_GROUPS = true;
    private ConstraintWidgetContainer container;
    private ConstraintWidgetContainer mContainer;
    private boolean mNeedBuildGraph = true;
    private boolean mNeedRedoMeasures = true;
    private ArrayList<WidgetRun> mRuns = new ArrayList<>();
    private ArrayList<RunGroup> runGroups = new ArrayList<>();
    private BasicMeasure.Measurer mMeasurer = null;
    private BasicMeasure.Measure mMeasure = new BasicMeasure.Measure();
    ArrayList<RunGroup> mGroups = new ArrayList<>();

    public DependencyGraph(ConstraintWidgetContainer constraintWidgetContainer) {
        this.container = constraintWidgetContainer;
        this.mContainer = constraintWidgetContainer;
    }

    private void applyGroup(DependencyNode dependencyNode, int i3, int i16, DependencyNode dependencyNode2, ArrayList<RunGroup> arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun.runGroup == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            if (widgetRun != constraintWidgetContainer.horizontalRun && widgetRun != constraintWidgetContainer.verticalRun) {
                if (runGroup == null) {
                    runGroup = new RunGroup(widgetRun, i16);
                    arrayList.add(runGroup);
                }
                widgetRun.runGroup = runGroup;
                runGroup.add(widgetRun);
                for (Dependency dependency : widgetRun.start.dependencies) {
                    if (dependency instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency, i3, 0, dependencyNode2, arrayList, runGroup);
                    }
                }
                for (Dependency dependency2 : widgetRun.end.dependencies) {
                    if (dependency2 instanceof DependencyNode) {
                        applyGroup((DependencyNode) dependency2, i3, 1, dependencyNode2, arrayList, runGroup);
                    }
                }
                if (i3 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                        if (dependency3 instanceof DependencyNode) {
                            applyGroup((DependencyNode) dependency3, i3, 2, dependencyNode2, arrayList, runGroup);
                        }
                    }
                }
                for (DependencyNode dependencyNode3 : widgetRun.start.targets) {
                    if (dependencyNode3 == dependencyNode2) {
                        runGroup.dual = true;
                    }
                    applyGroup(dependencyNode3, i3, 0, dependencyNode2, arrayList, runGroup);
                }
                for (DependencyNode dependencyNode4 : widgetRun.end.targets) {
                    if (dependencyNode4 == dependencyNode2) {
                        runGroup.dual = true;
                    }
                    applyGroup(dependencyNode4, i3, 1, dependencyNode2, arrayList, runGroup);
                }
                if (i3 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                    Iterator<DependencyNode> it = ((VerticalWidgetRun) widgetRun).baseline.targets.iterator();
                    while (it.hasNext()) {
                        applyGroup(it.next(), i3, 2, dependencyNode2, arrayList, runGroup);
                    }
                }
            }
        }
    }

    private boolean basicMeasureWidgets(ConstraintWidgetContainer constraintWidgetContainer) {
        int i3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i16;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        Iterator<ConstraintWidget> it = constraintWidgetContainer.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = next.mListDimensionBehaviors;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr2[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr2[1];
            if (next.getVisibility() == 8) {
                next.measured = true;
            } else {
                if (next.mMatchConstraintPercentWidth < 1.0f && dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultWidth = 2;
                }
                if (next.mMatchConstraintPercentHeight < 1.0f && dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.mMatchConstraintDefaultHeight = 2;
                }
                if (next.getDimensionRatio() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour7 == dimensionBehaviour9 && (dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour8 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultWidth = 3;
                    } else if (dimensionBehaviour8 == dimensionBehaviour9 && (dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour7 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.mMatchConstraintDefaultHeight = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour9 && dimensionBehaviour8 == dimensionBehaviour9) {
                        if (next.mMatchConstraintDefaultWidth == 0) {
                            next.mMatchConstraintDefaultWidth = 3;
                        }
                        if (next.mMatchConstraintDefaultHeight == 0) {
                            next.mMatchConstraintDefaultHeight = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour7 == dimensionBehaviour10 && next.mMatchConstraintDefaultWidth == 1 && (next.mLeft.mTarget == null || next.mRight.mTarget == null)) {
                    dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = dimensionBehaviour7;
                if (dimensionBehaviour8 == dimensionBehaviour10 && next.mMatchConstraintDefaultHeight == 1 && (next.mTop.mTarget == null || next.mBottom.mTarget == null)) {
                    dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = dimensionBehaviour8;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimensionBehavior = dimensionBehaviour11;
                int i17 = next.mMatchConstraintDefaultWidth;
                horizontalWidgetRun.matchConstraintsType = i17;
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimensionBehavior = dimensionBehaviour12;
                int i18 = next.mMatchConstraintDefaultHeight;
                verticalWidgetRun.matchConstraintsType = i18;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour11 != dimensionBehaviour13 && dimensionBehaviour11 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour11 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour12 != dimensionBehaviour13 && dimensionBehaviour12 != ConstraintWidget.DimensionBehaviour.FIXED && dimensionBehaviour12 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    if (dimensionBehaviour11 == dimensionBehaviour10 && (dimensionBehaviour12 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour12 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i17 == 3) {
                            if (dimensionBehaviour12 == dimensionBehaviour6) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour6, 0);
                            }
                            int height = next.getHeight();
                            int i19 = (int) ((height * next.mDimensionRatio) + 0.5f);
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour14, i19, dimensionBehaviour14, height);
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i17 == 1) {
                            measure(next, dimensionBehaviour6, 0, dimensionBehaviour12, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                        } else if (i17 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = constraintWidgetContainer.mListDimensionBehaviors[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour15 == dimensionBehaviour16 || dimensionBehaviour15 == dimensionBehaviour13) {
                                measure(next, dimensionBehaviour16, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour12, next.getHeight());
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.mListAnchors;
                            if (constraintAnchorArr[0].mTarget == null || constraintAnchorArr[1].mTarget == null) {
                                measure(next, dimensionBehaviour6, 0, dimensionBehaviour12, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour12 == dimensionBehaviour10 && (dimensionBehaviour11 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour11 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i18 == 3) {
                            if (dimensionBehaviour11 == dimensionBehaviour5) {
                                measure(next, dimensionBehaviour5, 0, dimensionBehaviour5, 0);
                            }
                            int width = next.getWidth();
                            float f16 = next.mDimensionRatio;
                            if (next.getDimensionRatioSide() == -1) {
                                f16 = 1.0f / f16;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            measure(next, dimensionBehaviour17, width, dimensionBehaviour17, (int) ((width * f16) + 0.5f));
                            next.horizontalRun.dimension.resolve(next.getWidth());
                            next.verticalRun.dimension.resolve(next.getHeight());
                            next.measured = true;
                        } else if (i18 == 1) {
                            measure(next, dimensionBehaviour11, 0, dimensionBehaviour5, 0);
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        } else if (i18 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = constraintWidgetContainer.mListDimensionBehaviors[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour18 == dimensionBehaviour19 || dimensionBehaviour18 == dimensionBehaviour13) {
                                measure(next, dimensionBehaviour11, next.getWidth(), dimensionBehaviour19, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.mListAnchors;
                            if (constraintAnchorArr2[2].mTarget == null || constraintAnchorArr2[3].mTarget == null) {
                                measure(next, dimensionBehaviour5, 0, dimensionBehaviour12, 0);
                                next.horizontalRun.dimension.resolve(next.getWidth());
                                next.verticalRun.dimension.resolve(next.getHeight());
                                next.measured = true;
                            }
                        }
                    }
                    if (dimensionBehaviour11 == dimensionBehaviour10 && dimensionBehaviour12 == dimensionBehaviour10) {
                        if (i17 != 1 && i18 != 1) {
                            if (i18 == 2 && i17 == 2 && ((dimensionBehaviour3 = (dimensionBehaviourArr = constraintWidgetContainer.mListDimensionBehaviors)[0]) == (dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED) || dimensionBehaviour3 == dimensionBehaviour4)) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = dimensionBehaviourArr[1];
                                if (dimensionBehaviour20 == dimensionBehaviour4 || dimensionBehaviour20 == dimensionBehaviour4) {
                                    measure(next, dimensionBehaviour4, (int) ((next.mMatchConstraintPercentWidth * constraintWidgetContainer.getWidth()) + 0.5f), dimensionBehaviour4, (int) ((next.mMatchConstraintPercentHeight * constraintWidgetContainer.getHeight()) + 0.5f));
                                    next.horizontalRun.dimension.resolve(next.getWidth());
                                    next.verticalRun.dimension.resolve(next.getHeight());
                                    next.measured = true;
                                }
                            }
                        } else {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour21 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            measure(next, dimensionBehaviour21, 0, dimensionBehaviour21, 0);
                            next.horizontalRun.dimension.wrapValue = next.getWidth();
                            next.verticalRun.dimension.wrapValue = next.getHeight();
                        }
                    }
                } else {
                    int width2 = next.getWidth();
                    if (dimensionBehaviour11 == dimensionBehaviour13) {
                        i3 = (constraintWidgetContainer.getWidth() - next.mLeft.mMargin) - next.mRight.mMargin;
                        dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i3 = width2;
                        dimensionBehaviour = dimensionBehaviour11;
                    }
                    int height2 = next.getHeight();
                    if (dimensionBehaviour12 == dimensionBehaviour13) {
                        i16 = (constraintWidgetContainer.getHeight() - next.mTop.mMargin) - next.mBottom.mMargin;
                        dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i16 = height2;
                        dimensionBehaviour2 = dimensionBehaviour12;
                    }
                    measure(next, dimensionBehaviour, i3, dimensionBehaviour2, i16);
                    next.horizontalRun.dimension.resolve(next.getWidth());
                    next.verticalRun.dimension.resolve(next.getHeight());
                    next.measured = true;
                }
            }
        }
        return false;
    }

    private int computeWrap(ConstraintWidgetContainer constraintWidgetContainer, int i3) {
        int size = this.mGroups.size();
        long j3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            j3 = Math.max(j3, this.mGroups.get(i16).computeWrapSize(constraintWidgetContainer, i3));
        }
        return (int) j3;
    }

    private void displayGraph() {
        Iterator<WidgetRun> it = this.mRuns.iterator();
        String str = "digraph {\n";
        while (it.hasNext()) {
            str = generateDisplayGraph(it.next(), str);
        }
        String str2 = str + "\n}\n";
        System.out.println("content:<<\n" + str2 + "\n>>");
    }

    private void findGroup(WidgetRun widgetRun, int i3, ArrayList<RunGroup> arrayList) {
        for (Dependency dependency : widgetRun.start.dependencies) {
            if (dependency instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency, i3, 0, widgetRun.end, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency).start, i3, 0, widgetRun.end, arrayList, null);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if (dependency2 instanceof DependencyNode) {
                applyGroup((DependencyNode) dependency2, i3, 1, widgetRun.start, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                applyGroup(((WidgetRun) dependency2).end, i3, 1, widgetRun.start, arrayList, null);
            }
        }
        if (i3 == 1) {
            for (Dependency dependency3 : ((VerticalWidgetRun) widgetRun).baseline.dependencies) {
                if (dependency3 instanceof DependencyNode) {
                    applyGroup((DependencyNode) dependency3, i3, 2, null, arrayList, null);
                }
            }
        }
    }

    private String generateChainDisplayGraph(ChainRun chainRun, String str) {
        String str2;
        String str3;
        int i3 = chainRun.orientation;
        String str4 = "cluster_" + chainRun.widget.getDebugName();
        if (i3 == 0) {
            str2 = str4 + "_h";
        } else {
            str2 = str4 + "_v";
        }
        String str5 = "subgraph " + str2 + " {\n";
        Iterator<WidgetRun> it = chainRun.widgets.iterator();
        String str6 = "";
        while (it.hasNext()) {
            WidgetRun next = it.next();
            String debugName = next.widget.getDebugName();
            if (i3 == 0) {
                str3 = debugName + "_HORIZONTAL";
            } else {
                str3 = debugName + "_VERTICAL";
            }
            str5 = str5 + str3 + ";\n";
            str6 = generateDisplayGraph(next, str6);
        }
        return str + str6 + (str5 + "}\n");
    }

    private String generateDisplayGraph(WidgetRun widgetRun, String str) {
        boolean z16;
        DependencyNode dependencyNode = widgetRun.start;
        DependencyNode dependencyNode2 = widgetRun.end;
        if (!(widgetRun instanceof HelperReferences) && dependencyNode.dependencies.isEmpty() && (dependencyNode2.dependencies.isEmpty() & dependencyNode.targets.isEmpty()) && dependencyNode2.targets.isEmpty()) {
            return str;
        }
        String str2 = str + nodeDefinition(widgetRun);
        boolean isCenteredConnection = isCenteredConnection(dependencyNode, dependencyNode2);
        String generateDisplayNode = generateDisplayNode(dependencyNode2, isCenteredConnection, generateDisplayNode(dependencyNode, isCenteredConnection, str2));
        boolean z17 = widgetRun instanceof VerticalWidgetRun;
        if (z17) {
            generateDisplayNode = generateDisplayNode(((VerticalWidgetRun) widgetRun).baseline, isCenteredConnection, generateDisplayNode);
        }
        if (!(widgetRun instanceof HorizontalWidgetRun) && (!((z16 = widgetRun instanceof ChainRun)) || ((ChainRun) widgetRun).orientation != 0)) {
            if (z17 || (z16 && ((ChainRun) widgetRun).orientation == 1)) {
                ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour = widgetRun.widget.getVerticalDimensionBehaviour();
                if (verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && verticalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                        widgetRun.widget.getDebugName();
                    }
                } else if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n");
                } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                    generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n");
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = widgetRun.widget.getHorizontalDimensionBehaviour();
            if (horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED && horizontalDimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                if (horizontalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun.widget.getDimensionRatio() > 0.0f) {
                    widgetRun.widget.getDebugName();
                }
            } else if (!dependencyNode.targets.isEmpty() && dependencyNode2.targets.isEmpty()) {
                generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode2.name() + " -> " + dependencyNode.name() + "\n");
            } else if (dependencyNode.targets.isEmpty() && !dependencyNode2.targets.isEmpty()) {
                generateDisplayNode = generateDisplayNode + ("\n" + dependencyNode.name() + " -> " + dependencyNode2.name() + "\n");
            }
        }
        if (widgetRun instanceof ChainRun) {
            return generateChainDisplayGraph((ChainRun) widgetRun, generateDisplayNode);
        }
        return generateDisplayNode;
    }

    private String generateDisplayNode(DependencyNode dependencyNode, boolean z16, String str) {
        for (DependencyNode dependencyNode2 : dependencyNode.targets) {
            String str2 = ("\n" + dependencyNode.name()) + " -> " + dependencyNode2.name();
            if (dependencyNode.margin > 0 || z16 || (dependencyNode.run instanceof HelperReferences)) {
                String str3 = str2 + "[";
                if (dependencyNode.margin > 0) {
                    str3 = str3 + "label=\"" + dependencyNode.margin + "\"";
                    if (z16) {
                        str3 = str3 + ",";
                    }
                }
                if (z16) {
                    str3 = str3 + " style=dashed ";
                }
                if (dependencyNode.run instanceof HelperReferences) {
                    str3 = str3 + " style=bold,color=gray ";
                }
                str2 = str3 + "]";
            }
            str = str + (str2 + "\n");
        }
        return str;
    }

    private boolean isCenteredConnection(DependencyNode dependencyNode, DependencyNode dependencyNode2) {
        Iterator<DependencyNode> it = dependencyNode.targets.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next() != dependencyNode2) {
                i3++;
            }
        }
        Iterator<DependencyNode> it5 = dependencyNode2.targets.iterator();
        int i16 = 0;
        while (it5.hasNext()) {
            if (it5.next() != dependencyNode) {
                i16++;
            }
        }
        if (i3 <= 0 || i16 <= 0) {
            return false;
        }
        return true;
    }

    private void measure(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i3, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i16) {
        BasicMeasure.Measure measure = this.mMeasure;
        measure.horizontalBehavior = dimensionBehaviour;
        measure.verticalBehavior = dimensionBehaviour2;
        measure.horizontalDimension = i3;
        measure.verticalDimension = i16;
        this.mMeasurer.measure(constraintWidget, measure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
    }

    private String nodeDefinition(WidgetRun widgetRun) {
        ConstraintWidget.DimensionBehaviour verticalDimensionBehaviour;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z16 = widgetRun instanceof VerticalWidgetRun;
        String debugName = widgetRun.widget.getDebugName();
        ConstraintWidget constraintWidget = widgetRun.widget;
        if (!z16) {
            verticalDimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        } else {
            verticalDimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        }
        RunGroup runGroup = widgetRun.runGroup;
        if (!z16) {
            str = debugName + "_HORIZONTAL";
        } else {
            str = debugName + "_VERTICAL";
        }
        String str5 = ((str + " [shape=none, label=<") + "<TABLE BORDER=\"0\" CELLSPACING=\"0\" CELLPADDING=\"2\">") + "  <TR>";
        if (!z16) {
            String str6 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str6 = str6 + " BGCOLOR=\"green\"";
            }
            str2 = str6 + " PORT=\"LEFT\" BORDER=\"1\">L</TD>";
        } else {
            String str7 = str5 + "    <TD ";
            if (widgetRun.start.resolved) {
                str7 = str7 + " BGCOLOR=\"green\"";
            }
            str2 = str7 + " PORT=\"TOP\" BORDER=\"1\">T</TD>";
        }
        String str8 = str2 + "    <TD BORDER=\"1\" ";
        boolean z17 = widgetRun.dimension.resolved;
        if (z17 && !widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"green\" ";
        } else if (z17 && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"lightgray\" ";
        } else if (!z17 && widgetRun.widget.measured) {
            str8 = str8 + " BGCOLOR=\"yellow\" ";
        }
        if (verticalDimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            str8 = str8 + "style=\"dashed\"";
        }
        if (runGroup != null) {
            str3 = " [" + (runGroup.groupIndex + 1) + "/" + RunGroup.index + "]";
        } else {
            str3 = "";
        }
        String str9 = str8 + ">" + debugName + str3 + " </TD>";
        if (!z16) {
            String str10 = str9 + "    <TD ";
            if (widgetRun.end.resolved) {
                str10 = str10 + " BGCOLOR=\"green\"";
            }
            str4 = str10 + " PORT=\"RIGHT\" BORDER=\"1\">R</TD>";
        } else {
            String str11 = str9 + "    <TD ";
            if ((widgetRun instanceof VerticalWidgetRun) && ((VerticalWidgetRun) widgetRun).baseline.resolved) {
                str11 = str11 + " BGCOLOR=\"green\"";
            }
            String str12 = (str11 + " PORT=\"BASELINE\" BORDER=\"1\">b</TD>") + "    <TD ";
            if (widgetRun.end.resolved) {
                str12 = str12 + " BGCOLOR=\"green\"";
            }
            str4 = str12 + " PORT=\"BOTTOM\" BORDER=\"1\">B</TD>";
        }
        return (str4 + "  </TR></TABLE>") + ">];\n";
    }

    public void buildGraph() {
        buildGraph(this.mRuns);
        this.mGroups.clear();
        RunGroup.index = 0;
        findGroup(this.container.horizontalRun, 0, this.mGroups);
        findGroup(this.container.verticalRun, 1, this.mGroups);
        this.mNeedBuildGraph = false;
    }

    public void defineTerminalWidgets(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2) {
        boolean z16;
        boolean z17;
        if (this.mNeedBuildGraph) {
            buildGraph();
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            boolean z18 = false;
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                boolean[] zArr = next.isTerminalWidget;
                zArr[0] = true;
                zArr[1] = true;
                if (next instanceof Barrier) {
                    z18 = true;
                }
            }
            if (!z18) {
                Iterator<RunGroup> it5 = this.mGroups.iterator();
                while (it5.hasNext()) {
                    RunGroup next2 = it5.next();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    next2.defineTerminalWidgets(z16, z17);
                }
            }
        }
    }

    public boolean directMeasure(boolean z16) {
        boolean z17;
        boolean z18 = true;
        boolean z19 = z16 & true;
        if (this.mNeedBuildGraph || this.mNeedRedoMeasures) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                next.horizontalRun.reset();
                next.verticalRun.reset();
            }
            this.container.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            constraintWidgetContainer.horizontalRun.reset();
            this.container.verticalRun.reset();
            this.mNeedRedoMeasures = false;
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(1);
        if (this.mNeedBuildGraph) {
            buildGraph();
        }
        int x16 = this.container.getX();
        int y16 = this.container.getY();
        this.container.horizontalRun.start.resolve(x16);
        this.container.verticalRun.start.resolve(y16);
        measureWidgets();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour == dimensionBehaviour3 || dimensionBehaviour2 == dimensionBehaviour3) {
            if (z19) {
                Iterator<WidgetRun> it5 = this.mRuns.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (!it5.next().supportsWrapComputation()) {
                        z19 = false;
                        break;
                    }
                }
            }
            if (z19 && dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                constraintWidgetContainer2.setWidth(computeWrap(constraintWidgetContainer2, 0));
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.horizontalRun.dimension.resolve(constraintWidgetContainer3.getWidth());
            }
            if (z19 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.setHeight(computeWrap(constraintWidgetContainer4, 1));
                ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
                constraintWidgetContainer5.verticalRun.dimension.resolve(constraintWidgetContainer5.getHeight());
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer6.mListDimensionBehaviors[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour4 != dimensionBehaviour5 && dimensionBehaviour4 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            z17 = false;
        } else {
            int width = constraintWidgetContainer6.getWidth() + x16;
            this.container.horizontalRun.end.resolve(width);
            this.container.horizontalRun.dimension.resolve(width - x16);
            measureWidgets();
            ConstraintWidgetContainer constraintWidgetContainer7 = this.container;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidgetContainer7.mListDimensionBehaviors[1];
            if (dimensionBehaviour6 == dimensionBehaviour5 || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer7.getHeight() + y16;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y16);
            }
            measureWidgets();
            z17 = true;
        }
        Iterator<WidgetRun> it6 = this.mRuns.iterator();
        while (it6.hasNext()) {
            WidgetRun next2 = it6.next();
            if (next2.widget != this.container || next2.resolved) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it7 = this.mRuns.iterator();
        while (it7.hasNext()) {
            WidgetRun next3 = it7.next();
            if (z17 || next3.widget != this.container) {
                if (!next3.start.resolved || ((!next3.end.resolved && !(next3 instanceof GuidelineReference)) || (!next3.dimension.resolved && !(next3 instanceof ChainRun) && !(next3 instanceof GuidelineReference)))) {
                    z18 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour2);
        return z18;
    }

    public boolean directMeasureSetup(boolean z16) {
        if (this.mNeedBuildGraph) {
            Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.ensureWidgetRuns();
                next.measured = false;
                HorizontalWidgetRun horizontalWidgetRun = next.horizontalRun;
                horizontalWidgetRun.dimension.resolved = false;
                horizontalWidgetRun.resolved = false;
                horizontalWidgetRun.reset();
                VerticalWidgetRun verticalWidgetRun = next.verticalRun;
                verticalWidgetRun.dimension.resolved = false;
                verticalWidgetRun.resolved = false;
                verticalWidgetRun.reset();
            }
            this.container.ensureWidgetRuns();
            ConstraintWidgetContainer constraintWidgetContainer = this.container;
            constraintWidgetContainer.measured = false;
            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidgetContainer.horizontalRun;
            horizontalWidgetRun2.dimension.resolved = false;
            horizontalWidgetRun2.resolved = false;
            horizontalWidgetRun2.reset();
            VerticalWidgetRun verticalWidgetRun2 = this.container.verticalRun;
            verticalWidgetRun2.dimension.resolved = false;
            verticalWidgetRun2.resolved = false;
            verticalWidgetRun2.reset();
            buildGraph();
        }
        if (basicMeasureWidgets(this.mContainer)) {
            return false;
        }
        this.container.setX(0);
        this.container.setY(0);
        this.container.horizontalRun.start.resolve(0);
        this.container.verticalRun.start.resolve(0);
        return true;
    }

    public boolean directMeasureWithOrientation(boolean z16, int i3) {
        boolean z17;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z18 = true;
        boolean z19 = z16 & true;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.container.getDimensionBehaviour(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = this.container.getDimensionBehaviour(1);
        int x16 = this.container.getX();
        int y16 = this.container.getY();
        if (z19 && (dimensionBehaviour2 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour3 == dimensionBehaviour)) {
            Iterator<WidgetRun> it = this.mRuns.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun next = it.next();
                if (next.orientation == i3 && !next.supportsWrapComputation()) {
                    z19 = false;
                    break;
                }
            }
            if (i3 == 0) {
                if (z19 && dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.container.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                    ConstraintWidgetContainer constraintWidgetContainer = this.container;
                    constraintWidgetContainer.setWidth(computeWrap(constraintWidgetContainer, 0));
                    ConstraintWidgetContainer constraintWidgetContainer2 = this.container;
                    constraintWidgetContainer2.horizontalRun.dimension.resolve(constraintWidgetContainer2.getWidth());
                }
            } else if (z19 && dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.container.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
                ConstraintWidgetContainer constraintWidgetContainer3 = this.container;
                constraintWidgetContainer3.setHeight(computeWrap(constraintWidgetContainer3, 1));
                ConstraintWidgetContainer constraintWidgetContainer4 = this.container;
                constraintWidgetContainer4.verticalRun.dimension.resolve(constraintWidgetContainer4.getHeight());
            }
        }
        if (i3 == 0) {
            ConstraintWidgetContainer constraintWidgetContainer5 = this.container;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer5.mListDimensionBehaviors[0];
            if (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int width = constraintWidgetContainer5.getWidth() + x16;
                this.container.horizontalRun.end.resolve(width);
                this.container.horizontalRun.dimension.resolve(width - x16);
                z17 = true;
            }
            z17 = false;
        } else {
            ConstraintWidgetContainer constraintWidgetContainer6 = this.container;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer6.mListDimensionBehaviors[1];
            if (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int height = constraintWidgetContainer6.getHeight() + y16;
                this.container.verticalRun.end.resolve(height);
                this.container.verticalRun.dimension.resolve(height - y16);
                z17 = true;
            }
            z17 = false;
        }
        measureWidgets();
        Iterator<WidgetRun> it5 = this.mRuns.iterator();
        while (it5.hasNext()) {
            WidgetRun next2 = it5.next();
            if (next2.orientation == i3 && (next2.widget != this.container || next2.resolved)) {
                next2.applyToWidget();
            }
        }
        Iterator<WidgetRun> it6 = this.mRuns.iterator();
        while (it6.hasNext()) {
            WidgetRun next3 = it6.next();
            if (next3.orientation == i3 && (z17 || next3.widget != this.container)) {
                if (!next3.start.resolved || !next3.end.resolved || (!(next3 instanceof ChainRun) && !next3.dimension.resolved)) {
                    z18 = false;
                    break;
                }
            }
        }
        this.container.setHorizontalDimensionBehaviour(dimensionBehaviour2);
        this.container.setVerticalDimensionBehaviour(dimensionBehaviour3);
        return z18;
    }

    public void invalidateGraph() {
        this.mNeedBuildGraph = true;
    }

    public void invalidateMeasures() {
        this.mNeedRedoMeasures = true;
    }

    public void measureWidgets() {
        boolean z16;
        DimensionDependency dimensionDependency;
        Iterator<ConstraintWidget> it = this.container.mChildren.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.measured) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.mListDimensionBehaviors;
                boolean z17 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i3 = next.mMatchConstraintDefaultWidth;
                int i16 = next.mMatchConstraintDefaultHeight;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour != dimensionBehaviour3 && (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || i3 != 1)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i16 == 1)) {
                    z17 = true;
                }
                DimensionDependency dimensionDependency2 = next.horizontalRun.dimension;
                boolean z18 = dimensionDependency2.resolved;
                DimensionDependency dimensionDependency3 = next.verticalRun.dimension;
                boolean z19 = dimensionDependency3.resolved;
                if (z18 && z19) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    measure(next, dimensionBehaviour4, dimensionDependency2.value, dimensionBehaviour4, dimensionDependency3.value);
                    next.measured = true;
                } else if (z18 && z17) {
                    measure(next, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency2.value, dimensionBehaviour3, dimensionDependency3.value);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.verticalRun.dimension.wrapValue = next.getHeight();
                    } else {
                        next.verticalRun.dimension.resolve(next.getHeight());
                        next.measured = true;
                    }
                } else if (z19 && z16) {
                    measure(next, dimensionBehaviour3, dimensionDependency2.value, ConstraintWidget.DimensionBehaviour.FIXED, dimensionDependency3.value);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.horizontalRun.dimension.wrapValue = next.getWidth();
                    } else {
                        next.horizontalRun.dimension.resolve(next.getWidth());
                        next.measured = true;
                    }
                }
                if (next.measured && (dimensionDependency = next.verticalRun.baselineDimension) != null) {
                    dimensionDependency.resolve(next.getBaselineDistance());
                }
            }
        }
    }

    public void setMeasurer(BasicMeasure.Measurer measurer) {
        this.mMeasurer = measurer;
    }

    public void buildGraph(ArrayList<WidgetRun> arrayList) {
        arrayList.clear();
        this.mContainer.horizontalRun.clear();
        this.mContainer.verticalRun.clear();
        arrayList.add(this.mContainer.horizontalRun);
        arrayList.add(this.mContainer.verticalRun);
        Iterator<ConstraintWidget> it = this.mContainer.mChildren.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof Guideline) {
                arrayList.add(new GuidelineReference(next));
            } else {
                if (next.isInHorizontalChain()) {
                    if (next.horizontalChainRun == null) {
                        next.horizontalChainRun = new ChainRun(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.horizontalChainRun);
                } else {
                    arrayList.add(next.horizontalRun);
                }
                if (next.isInVerticalChain()) {
                    if (next.verticalChainRun == null) {
                        next.verticalChainRun = new ChainRun(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.verticalChainRun);
                } else {
                    arrayList.add(next.verticalRun);
                }
                if (next instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<WidgetRun> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            it5.next().clear();
        }
        Iterator<WidgetRun> it6 = arrayList.iterator();
        while (it6.hasNext()) {
            WidgetRun next2 = it6.next();
            if (next2.widget != this.mContainer) {
                next2.apply();
            }
        }
    }
}
