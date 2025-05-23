package org.junit.runners.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Runner;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class RunnerBuilder {
    private final Set<Class<?>> parents = new HashSet();

    Class<?> addParent(Class<?> cls) throws InitializationError {
        if (this.parents.add(cls)) {
            return cls;
        }
        throw new InitializationError(String.format("class '%s' (possibly indirectly) contains itself as a SuiteClass", cls.getName()));
    }

    void removeParent(Class<?> cls) {
        this.parents.remove(cls);
    }

    public abstract Runner runnerForClass(Class<?> cls) throws Throwable;

    public List<Runner> runners(Class<?> cls, Class<?>[] clsArr) throws InitializationError {
        addParent(cls);
        try {
            return runners(clsArr);
        } finally {
            removeParent(cls);
        }
    }

    public Runner safeRunnerForClass(Class<?> cls) {
        try {
            return runnerForClass(cls);
        } catch (Throwable th5) {
            return new ErrorReportingRunner(cls, th5);
        }
    }

    public List<Runner> runners(Class<?> cls, List<Class<?>> list) throws InitializationError {
        return runners(cls, (Class<?>[]) list.toArray(new Class[0]));
    }

    private List<Runner> runners(Class<?>[] clsArr) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls : clsArr) {
            Runner safeRunnerForClass = safeRunnerForClass(cls);
            if (safeRunnerForClass != null) {
                arrayList.add(safeRunnerForClass);
            }
        }
        return arrayList;
    }
}
