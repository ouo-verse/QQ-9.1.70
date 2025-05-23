package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.internal.AssumptionViolatedException;
import org.junit.internal.runners.model.EachTestNotifier;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;

/* loaded from: classes29.dex */
public abstract class ParentRunner<T> extends Runner implements Filterable, Sortable {
    private static final List<TestClassValidator> VALIDATORS = Arrays.asList(new AnnotationsValidator(), new PublicClassValidator());
    private final Object childrenLock = new Object();
    private volatile Collection<T> filteredChildren = null;
    private volatile RunnerScheduler scheduler = new RunnerScheduler() { // from class: org.junit.runners.ParentRunner.1
        @Override // org.junit.runners.model.RunnerScheduler
        public void schedule(Runnable runnable) {
            runnable.run();
        }

        @Override // org.junit.runners.model.RunnerScheduler
        public void finished() {
        }
    };
    private final TestClass testClass;

    /* JADX INFO: Access modifiers changed from: protected */
    public ParentRunner(Class<?> cls) throws InitializationError {
        this.testClass = createTestClass(cls);
        validate();
    }

    private void applyValidators(List<Throwable> list) {
        if (getTestClass().getJavaClass() != null) {
            Iterator<TestClassValidator> it = VALIDATORS.iterator();
            while (it.hasNext()) {
                list.addAll(it.next().validateTestClass(getTestClass()));
            }
        }
    }

    private boolean areAllChildrenIgnored() {
        Iterator<T> it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            if (!isIgnored(it.next())) {
                return false;
            }
        }
        return true;
    }

    private Comparator<? super T> comparator(final Sorter sorter) {
        return new Comparator<T>() { // from class: org.junit.runners.ParentRunner.4
            @Override // java.util.Comparator
            public int compare(T t16, T t17) {
                return sorter.compare(ParentRunner.this.describeChild(t16), ParentRunner.this.describeChild(t17));
            }
        };
    }

    private Collection<T> getFilteredChildren() {
        if (this.filteredChildren == null) {
            synchronized (this.childrenLock) {
                if (this.filteredChildren == null) {
                    this.filteredChildren = Collections.unmodifiableCollection(getChildren());
                }
            }
        }
        return this.filteredChildren;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runChildren(final RunNotifier runNotifier) {
        RunnerScheduler runnerScheduler = this.scheduler;
        try {
            for (final T t16 : getFilteredChildren()) {
                runnerScheduler.schedule(new Runnable() { // from class: org.junit.runners.ParentRunner.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        ParentRunner.this.runChild(t16, runNotifier);
                    }
                });
            }
        } finally {
            runnerScheduler.finished();
        }
    }

    private boolean shouldRun(Filter filter, T t16) {
        return filter.shouldRun(describeChild(t16));
    }

    private void validate() throws InitializationError {
        ArrayList arrayList = new ArrayList();
        collectInitializationErrors(arrayList);
        if (arrayList.isEmpty()) {
        } else {
            throw new InitializationError(arrayList);
        }
    }

    private void validateClassRules(List<Throwable> list) {
        RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), list);
        RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    private Statement withClassRules(Statement statement) {
        List<TestRule> classRules = classRules();
        if (!classRules.isEmpty()) {
            return new RunRules(statement, classRules, getDescription());
        }
        return statement;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Statement childrenInvoker(final RunNotifier runNotifier) {
        return new Statement() { // from class: org.junit.runners.ParentRunner.2
            @Override // org.junit.runners.model.Statement
            public void evaluate() {
                ParentRunner.this.runChildren(runNotifier);
            }
        };
    }

    protected Statement classBlock(RunNotifier runNotifier) {
        Statement childrenInvoker = childrenInvoker(runNotifier);
        if (!areAllChildrenIgnored()) {
            return withClassRules(withAfterClasses(withBeforeClasses(childrenInvoker)));
        }
        return childrenInvoker;
    }

    protected List<TestRule> classRules() {
        List<TestRule> annotatedMethodValues = this.testClass.getAnnotatedMethodValues(null, ClassRule.class, TestRule.class);
        annotatedMethodValues.addAll(this.testClass.getAnnotatedFieldValues(null, ClassRule.class, TestRule.class));
        return annotatedMethodValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void collectInitializationErrors(List<Throwable> list) {
        validatePublicVoidNoArgMethods(BeforeClass.class, true, list);
        validatePublicVoidNoArgMethods(AfterClass.class, true, list);
        validateClassRules(list);
        applyValidators(list);
    }

    protected TestClass createTestClass(Class<?> cls) {
        return new TestClass(cls);
    }

    protected abstract Description describeChild(T t16);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        synchronized (this.childrenLock) {
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (shouldRun(filter, next)) {
                    try {
                        filter.apply(next);
                    } catch (NoTestsRemainException unused) {
                        it.remove();
                    }
                } else {
                    it.remove();
                }
            }
            this.filteredChildren = Collections.unmodifiableCollection(arrayList);
            if (this.filteredChildren.isEmpty()) {
                throw new NoTestsRemainException();
            }
        }
    }

    protected abstract List<T> getChildren();

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(getName(), getRunnerAnnotations());
        Iterator<T> it = getFilteredChildren().iterator();
        while (it.hasNext()) {
            createSuiteDescription.addChild(describeChild(it.next()));
        }
        return createSuiteDescription;
    }

    protected String getName() {
        return this.testClass.getName();
    }

    protected Annotation[] getRunnerAnnotations() {
        return this.testClass.getAnnotations();
    }

    public final TestClass getTestClass() {
        return this.testClass;
    }

    protected boolean isIgnored(T t16) {
        return false;
    }

    @Override // org.junit.runner.Runner
    public void run(RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, getDescription());
        try {
            classBlock(runNotifier).evaluate();
        } catch (AssumptionViolatedException e16) {
            eachTestNotifier.addFailedAssumption(e16);
        } catch (StoppedByUserException e17) {
            throw e17;
        } catch (Throwable th5) {
            eachTestNotifier.addFailure(th5);
        }
    }

    protected abstract void runChild(T t16, RunNotifier runNotifier);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void runLeaf(Statement statement, Description description, RunNotifier runNotifier) {
        EachTestNotifier eachTestNotifier = new EachTestNotifier(runNotifier, description);
        eachTestNotifier.fireTestStarted();
        try {
            try {
                statement.evaluate();
            } catch (AssumptionViolatedException e16) {
                eachTestNotifier.addFailedAssumption(e16);
            } catch (Throwable th5) {
                eachTestNotifier.addFailure(th5);
            }
        } finally {
            eachTestNotifier.fireTestFinished();
        }
    }

    public void setScheduler(RunnerScheduler runnerScheduler) {
        this.scheduler = runnerScheduler;
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(Sorter sorter) {
        synchronized (this.childrenLock) {
            Iterator<T> it = getFilteredChildren().iterator();
            while (it.hasNext()) {
                sorter.apply(it.next());
            }
            ArrayList arrayList = new ArrayList(getFilteredChildren());
            Collections.sort(arrayList, comparator(sorter));
            this.filteredChildren = Collections.unmodifiableCollection(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validatePublicVoidNoArgMethods(Class<? extends Annotation> cls, boolean z16, List<Throwable> list) {
        Iterator<FrameworkMethod> it = getTestClass().getAnnotatedMethods(cls).iterator();
        while (it.hasNext()) {
            it.next().validatePublicVoidNoArg(z16, list);
        }
    }

    protected Statement withAfterClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(AfterClass.class);
        if (!annotatedMethods.isEmpty()) {
            return new RunAfters(statement, annotatedMethods, null);
        }
        return statement;
    }

    protected Statement withBeforeClasses(Statement statement) {
        List<FrameworkMethod> annotatedMethods = this.testClass.getAnnotatedMethods(BeforeClass.class);
        if (!annotatedMethods.isEmpty()) {
            return new RunBefores(statement, annotatedMethods, null);
        }
        return statement;
    }
}
