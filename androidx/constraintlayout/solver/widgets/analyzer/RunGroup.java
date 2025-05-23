package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i3) {
        this.firstRun = null;
        this.lastRun = null;
        int i16 = index;
        this.groupIndex = i16;
        index = i16 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i3;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i3) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (!widgetRun.widget.isTerminalWidget[i3]) {
            return false;
        }
        for (Dependency dependency : widgetRun.start.dependencies) {
            if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                    while (it.hasNext()) {
                        defineTerminalWidget(it.next(), i3);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i3] = false;
                }
                defineTerminalWidget(dependencyNode2.run, i3);
            }
        }
        for (Dependency dependency2 : widgetRun.end.dependencies) {
            if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                if (widgetRun instanceof ChainRun) {
                    Iterator<WidgetRun> it5 = ((ChainRun) widgetRun).widgets.iterator();
                    while (it5.hasNext()) {
                        defineTerminalWidget(it5.next(), i3);
                    }
                } else if (!(widgetRun instanceof HelperReferences)) {
                    widgetRun.widget.isTerminalWidget[i3] = false;
                }
                defineTerminalWidget(dependencyNode.run, i3);
            }
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j3) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j3;
        }
        int size = dependencyNode.dependencies.size();
        long j16 = j3;
        for (int i3 = 0; i3 < size; i3++) {
            Dependency dependency = dependencyNode.dependencies.get(i3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j16 = Math.min(j16, traverseEnd(dependencyNode2, dependencyNode2.margin + j3));
                }
            }
        }
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = j3 - widgetRun.getWrapDimension();
            return Math.min(Math.min(j16, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
        }
        return j16;
    }

    private long traverseStart(DependencyNode dependencyNode, long j3) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j3;
        }
        int size = dependencyNode.dependencies.size();
        long j16 = j3;
        for (int i3 = 0; i3 < size; i3++) {
            Dependency dependency = dependencyNode.dependencies.get(i3);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j16 = Math.max(j16, traverseStart(dependencyNode2, dependencyNode2.margin + j3));
                }
            }
        }
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = j3 + widgetRun.getWrapDimension();
            return Math.max(Math.max(j16, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
        }
        return j16;
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i3) {
        WidgetRun widgetRun;
        WidgetRun widgetRun2;
        long wrapDimension;
        int i16;
        WidgetRun widgetRun3 = this.firstRun;
        long j3 = 0;
        if (widgetRun3 instanceof ChainRun) {
            if (((ChainRun) widgetRun3).orientation != i3) {
                return 0L;
            }
        } else if (i3 == 0) {
            if (!(widgetRun3 instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun3 instanceof VerticalWidgetRun)) {
            return 0L;
        }
        if (i3 == 0) {
            widgetRun = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode = widgetRun.start;
        if (i3 == 0) {
            widgetRun2 = constraintWidgetContainer.horizontalRun;
        } else {
            widgetRun2 = constraintWidgetContainer.verticalRun;
        }
        DependencyNode dependencyNode2 = widgetRun2.end;
        boolean contains = widgetRun3.start.targets.contains(dependencyNode);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j16 = traverseStart - wrapDimension2;
            WidgetRun widgetRun4 = this.firstRun;
            int i17 = widgetRun4.end.margin;
            if (j16 >= (-i17)) {
                j16 += i17;
            }
            int i18 = widgetRun4.start.margin;
            long j17 = ((-traverseEnd) - wrapDimension2) - i18;
            if (j17 >= i18) {
                j17 -= i18;
            }
            float biasPercent = widgetRun4.widget.getBiasPercent(i3);
            if (biasPercent > 0.0f) {
                j3 = (((float) j17) / biasPercent) + (((float) j16) / (1.0f - biasPercent));
            }
            float f16 = (float) j3;
            long j18 = (f16 * biasPercent) + 0.5f + wrapDimension2 + (f16 * (1.0f - biasPercent)) + 0.5f;
            wrapDimension = r12.start.margin + j18;
            i16 = this.firstRun.end.margin;
        } else {
            if (contains) {
                return Math.max(traverseStart(this.firstRun.start, r12.margin), this.firstRun.start.margin + wrapDimension2);
            }
            if (contains2) {
                return Math.max(-traverseEnd(this.firstRun.end, r12.margin), (-this.firstRun.end.margin) + wrapDimension2);
            }
            wrapDimension = r12.start.margin + this.firstRun.getWrapDimension();
            i16 = this.firstRun.end.margin;
        }
        return wrapDimension - i16;
    }

    public void defineTerminalWidgets(boolean z16, boolean z17) {
        if (z16) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z17) {
            WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
