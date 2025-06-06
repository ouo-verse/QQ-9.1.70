package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;

/* compiled from: P */
@Deprecated
/* loaded from: classes29.dex */
public class JUnit4ClassRunner extends Runner implements Filterable, Sortable {
    private TestClass testClass;
    private final List<Method> testMethods = getTestMethods();

    public JUnit4ClassRunner(Class<?> cls) throws InitializationError {
        this.testClass = new TestClass(cls);
        validate();
    }

    private void testAborted(RunNotifier runNotifier, Description description, Throwable th5) {
        runNotifier.fireTestStarted(description);
        runNotifier.fireTestFailure(new Failure(description, th5));
        runNotifier.fireTestFinished(description);
    }

    protected Annotation[] classAnnotations() {
        return this.testClass.getJavaClass().getAnnotations();
    }

    protected Object createTest() throws Exception {
        return getTestClass().getConstructor().newInstance(new Object[0]);
    }

    @Override // org.junit.runner.manipulation.Filterable
    public void filter(Filter filter) throws NoTestsRemainException {
        Iterator<Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            if (!filter.shouldRun(methodDescription(it.next()))) {
                it.remove();
            }
        }
        if (!this.testMethods.isEmpty()) {
        } else {
            throw new NoTestsRemainException();
        }
    }

    @Override // org.junit.runner.Runner, org.junit.runner.Describable
    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(getName(), classAnnotations());
        Iterator<Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            createSuiteDescription.addChild(methodDescription(it.next()));
        }
        return createSuiteDescription;
    }

    protected String getName() {
        return getTestClass().getName();
    }

    protected TestClass getTestClass() {
        return this.testClass;
    }

    protected List<Method> getTestMethods() {
        return this.testClass.getTestMethods();
    }

    protected void invokeTestMethod(Method method, RunNotifier runNotifier) {
        Description methodDescription = methodDescription(method);
        try {
            new MethodRoadie(createTest(), wrapMethod(method), runNotifier, methodDescription).run();
        } catch (InvocationTargetException e16) {
            testAborted(runNotifier, methodDescription, e16.getCause());
        } catch (Exception e17) {
            testAborted(runNotifier, methodDescription, e17);
        }
    }

    protected Description methodDescription(Method method) {
        return Description.createTestDescription(getTestClass().getJavaClass(), testName(method), testAnnotations(method));
    }

    @Override // org.junit.runner.Runner
    public void run(final RunNotifier runNotifier) {
        new ClassRoadie(runNotifier, this.testClass, getDescription(), new Runnable() { // from class: org.junit.internal.runners.JUnit4ClassRunner.1
            @Override // java.lang.Runnable
            public void run() {
                JUnit4ClassRunner.this.runMethods(runNotifier);
            }
        }).runProtected();
    }

    protected void runMethods(RunNotifier runNotifier) {
        Iterator<Method> it = this.testMethods.iterator();
        while (it.hasNext()) {
            invokeTestMethod(it.next(), runNotifier);
        }
    }

    @Override // org.junit.runner.manipulation.Sortable
    public void sort(final Sorter sorter) {
        Collections.sort(this.testMethods, new Comparator<Method>() { // from class: org.junit.internal.runners.JUnit4ClassRunner.2
            @Override // java.util.Comparator
            public int compare(Method method, Method method2) {
                return sorter.compare(JUnit4ClassRunner.this.methodDescription(method), JUnit4ClassRunner.this.methodDescription(method2));
            }
        });
    }

    protected Annotation[] testAnnotations(Method method) {
        return method.getAnnotations();
    }

    protected String testName(Method method) {
        return method.getName();
    }

    protected void validate() throws InitializationError {
        MethodValidator methodValidator = new MethodValidator(this.testClass);
        methodValidator.validateMethodsForDefaultRunner();
        methodValidator.assertValid();
    }

    protected TestMethod wrapMethod(Method method) {
        return new TestMethod(method, this.testClass);
    }
}
