package androidx.constraintlayout.solver.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes.dex */
public class DependencyNode implements Dependency {
    int margin;
    WidgetRun run;
    public int value;
    public Dependency updateDelegate = null;
    public boolean delegateToWidgetRun = false;
    public boolean readyToSolve = false;
    Type type = Type.UNKNOWN;
    int marginFactor = 1;
    DimensionDependency marginDependency = null;
    public boolean resolved = false;
    List<Dependency> dependencies = new ArrayList();
    List<DependencyNode> targets = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes.dex */
    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
        if (this.resolved) {
            dependency.update(dependency);
        }
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        String str;
        String debugName = this.run.widget.getDebugName();
        Type type = this.type;
        if (type != Type.LEFT && type != Type.RIGHT) {
            str = debugName + "_VERTICAL";
        } else {
            str = debugName + "_HORIZONTAL";
        }
        return str + ":" + this.type.name();
    }

    public void resolve(int i3) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = i3;
        for (Dependency dependency : this.dependencies) {
            dependency.update(dependency);
        }
    }

    public String toString() {
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.run.widget.getDebugName());
        sb5.append(":");
        sb5.append(this.type);
        sb5.append("(");
        if (this.resolved) {
            obj = Integer.valueOf(this.value);
        } else {
            obj = "unresolved";
        }
        sb5.append(obj);
        sb5.append(") <t=");
        sb5.append(this.targets.size());
        sb5.append(":d=");
        sb5.append(this.dependencies.size());
        sb5.append(">");
        return sb5.toString();
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        Iterator<DependencyNode> it = this.targets.iterator();
        while (it.hasNext()) {
            if (!it.next().resolved) {
                return;
            }
        }
        this.readyToSolve = true;
        Dependency dependency2 = this.updateDelegate;
        if (dependency2 != null) {
            dependency2.update(this);
        }
        if (this.delegateToWidgetRun) {
            this.run.update(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i3 = 0;
        for (DependencyNode dependencyNode2 : this.targets) {
            if (!(dependencyNode2 instanceof DimensionDependency)) {
                i3++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i3 == 1 && dependencyNode.resolved) {
            DimensionDependency dimensionDependency = this.marginDependency;
            if (dimensionDependency != null) {
                if (dimensionDependency.resolved) {
                    this.margin = this.marginFactor * dimensionDependency.value;
                } else {
                    return;
                }
            }
            resolve(dependencyNode.value + this.margin);
        }
        Dependency dependency3 = this.updateDelegate;
        if (dependency3 != null) {
            dependency3.update(this);
        }
    }
}
