package org.junit.runners;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.internal.runners.statements.Fail;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.MethodRule;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/* compiled from: P */
/* loaded from: classes29.dex */
public class BlockJUnit4ClassRunner extends ParentRunner<FrameworkMethod> {
    private final ConcurrentHashMap<FrameworkMethod, Description> methodDescriptions;

    public BlockJUnit4ClassRunner(Class<?> cls) throws InitializationError {
        super(cls);
        this.methodDescriptions = new ConcurrentHashMap<>();
    }

    private boolean expectsException(Test test) {
        if (getExpectedException(test) != null) {
            return true;
        }
        return false;
    }

    private Class<? extends Throwable> getExpectedException(Test test) {
        if (test != null && test.expected() != Test.None.class) {
            return test.expected();
        }
        return null;
    }

    private List<MethodRule> getMethodRules(Object obj) {
        return rules(obj);
    }

    private long getTimeout(Test test) {
        if (test == null) {
            return 0L;
        }
        return test.timeout();
    }

    private boolean hasOneConstructor() {
        if (getTestClass().getJavaClass().getConstructors().length == 1) {
            return true;
        }
        return false;
    }

    private void validateMethods(List<Throwable> list) {
        RuleMemberValidator.RULE_METHOD_VALIDATOR.validate(getTestClass(), list);
    }

    private Statement withMethodRules(FrameworkMethod frameworkMethod, List<TestRule> list, Object obj, Statement statement) {
        for (MethodRule methodRule : getMethodRules(obj)) {
            if (!list.contains(methodRule)) {
                statement = methodRule.apply(statement, frameworkMethod, obj);
            }
        }
        return statement;
    }

    private Statement withRules(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<TestRule> testRules = getTestRules(obj);
        return withTestRules(frameworkMethod, testRules, withMethodRules(frameworkMethod, testRules, obj, statement));
    }

    private Statement withTestRules(FrameworkMethod frameworkMethod, List<TestRule> list, Statement statement) {
        if (!list.isEmpty()) {
            return new RunRules(statement, list, describeChild(frameworkMethod));
        }
        return statement;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void collectInitializationErrors(List<Throwable> list) {
        super.collectInitializationErrors(list);
        validateNoNonStaticInnerClass(list);
        validateConstructor(list);
        validateInstanceMethods(list);
        validateFields(list);
        validateMethods(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<FrameworkMethod> computeTestMethods() {
        return getTestClass().getAnnotatedMethods(Test.class);
    }

    protected Object createTest() throws Exception {
        return getTestClass().getOnlyConstructor().newInstance(new Object[0]);
    }

    @Override // org.junit.runners.ParentRunner
    protected List<FrameworkMethod> getChildren() {
        return computeTestMethods();
    }

    protected List<TestRule> getTestRules(Object obj) {
        List<TestRule> annotatedMethodValues = getTestClass().getAnnotatedMethodValues(obj, Rule.class, TestRule.class);
        annotatedMethodValues.addAll(getTestClass().getAnnotatedFieldValues(obj, Rule.class, TestRule.class));
        return annotatedMethodValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Statement methodBlock(FrameworkMethod frameworkMethod) {
        try {
            Object run = new ReflectiveCallable() { // from class: org.junit.runners.BlockJUnit4ClassRunner.1
                @Override // org.junit.internal.runners.model.ReflectiveCallable
                protected Object runReflectiveCall() throws Throwable {
                    return BlockJUnit4ClassRunner.this.createTest();
                }
            }.run();
            return withRules(frameworkMethod, run, withAfters(frameworkMethod, run, withBefores(frameworkMethod, run, withPotentialTimeout(frameworkMethod, run, possiblyExpectingExceptions(frameworkMethod, run, methodInvoker(frameworkMethod, run))))));
        } catch (Throwable th5) {
            return new Fail(th5);
        }
    }

    protected Statement methodInvoker(FrameworkMethod frameworkMethod, Object obj) {
        return new InvokeMethod(frameworkMethod, obj);
    }

    protected Statement possiblyExpectingExceptions(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        Test test = (Test) frameworkMethod.getAnnotation(Test.class);
        if (expectsException(test)) {
            return new ExpectException(statement, getExpectedException(test));
        }
        return statement;
    }

    protected List<MethodRule> rules(Object obj) {
        List<MethodRule> annotatedMethodValues = getTestClass().getAnnotatedMethodValues(obj, Rule.class, MethodRule.class);
        annotatedMethodValues.addAll(getTestClass().getAnnotatedFieldValues(obj, Rule.class, MethodRule.class));
        return annotatedMethodValues;
    }

    protected String testName(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getName();
    }

    protected void validateConstructor(List<Throwable> list) {
        validateOnlyOneConstructor(list);
        validateZeroArgConstructor(list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validateFields(List<Throwable> list) {
        RuleMemberValidator.RULE_VALIDATOR.validate(getTestClass(), list);
    }

    @Deprecated
    protected void validateInstanceMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(After.class, false, list);
        validatePublicVoidNoArgMethods(Before.class, false, list);
        validateTestMethods(list);
        if (computeTestMethods().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    protected void validateNoNonStaticInnerClass(List<Throwable> list) {
        if (getTestClass().isANonStaticInnerClass()) {
            list.add(new Exception("The inner class " + getTestClass().getName() + " is not static."));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validateOnlyOneConstructor(List<Throwable> list) {
        if (!hasOneConstructor()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    protected void validateTestMethods(List<Throwable> list) {
        validatePublicVoidNoArgMethods(Test.class, false, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validateZeroArgConstructor(List<Throwable> list) {
        if (!getTestClass().isANonStaticInnerClass() && hasOneConstructor() && getTestClass().getOnlyConstructor().getParameterTypes().length != 0) {
            list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
        }
    }

    protected Statement withAfters(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(After.class);
        if (!annotatedMethods.isEmpty()) {
            return new RunAfters(statement, annotatedMethods, obj);
        }
        return statement;
    }

    protected Statement withBefores(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        List<FrameworkMethod> annotatedMethods = getTestClass().getAnnotatedMethods(Before.class);
        if (!annotatedMethods.isEmpty()) {
            return new RunBefores(statement, annotatedMethods, obj);
        }
        return statement;
    }

    @Deprecated
    protected Statement withPotentialTimeout(FrameworkMethod frameworkMethod, Object obj, Statement statement) {
        long timeout = getTimeout((Test) frameworkMethod.getAnnotation(Test.class));
        if (timeout <= 0) {
            return statement;
        }
        return FailOnTimeout.builder().withTimeout(timeout, TimeUnit.MILLISECONDS).build(statement);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public Description describeChild(FrameworkMethod frameworkMethod) {
        Description description = this.methodDescriptions.get(frameworkMethod);
        if (description != null) {
            return description;
        }
        Description createTestDescription = Description.createTestDescription(getTestClass().getJavaClass(), testName(frameworkMethod), frameworkMethod.getAnnotations());
        this.methodDescriptions.putIfAbsent(frameworkMethod, createTestDescription);
        return createTestDescription;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public boolean isIgnored(FrameworkMethod frameworkMethod) {
        return frameworkMethod.getAnnotation(Ignore.class) != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.ParentRunner
    public void runChild(FrameworkMethod frameworkMethod, RunNotifier runNotifier) {
        Description describeChild = describeChild(frameworkMethod);
        if (isIgnored(frameworkMethod)) {
            runNotifier.fireTestIgnored(describeChild);
        } else {
            runLeaf(methodBlock(frameworkMethod), describeChild, runNotifier);
        }
    }
}
