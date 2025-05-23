package org.junit.runner;

import junit.framework.Test;
import junit.runner.Version;
import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.internal.TextListener;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

/* compiled from: P */
/* loaded from: classes29.dex */
public class JUnitCore {
    private final RunNotifier notifier = new RunNotifier();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Computer defaultComputer() {
        return new Computer();
    }

    public static void main(String... strArr) {
        System.exit(!new JUnitCore().runMain(new RealSystem(), strArr).wasSuccessful() ? 1 : 0);
    }

    public static Result runClasses(Class<?>... clsArr) {
        return runClasses(defaultComputer(), clsArr);
    }

    public void addListener(RunListener runListener) {
        this.notifier.addListener(runListener);
    }

    public String getVersion() {
        return Version.id();
    }

    public void removeListener(RunListener runListener) {
        this.notifier.removeListener(runListener);
    }

    public Result run(Class<?>... clsArr) {
        return run(defaultComputer(), clsArr);
    }

    Result runMain(JUnitSystem jUnitSystem, String... strArr) {
        jUnitSystem.out().println("JUnit version " + Version.id());
        JUnitCommandLineParseResult parse = JUnitCommandLineParseResult.parse(strArr);
        addListener(new TextListener(jUnitSystem));
        return run(parse.createRequest(defaultComputer()));
    }

    public static Result runClasses(Computer computer, Class<?>... clsArr) {
        return new JUnitCore().run(computer, clsArr);
    }

    public Result run(Computer computer, Class<?>... clsArr) {
        return run(Request.classes(computer, clsArr));
    }

    public Result run(Request request) {
        return run(request.getRunner());
    }

    public Result run(Test test) {
        return run(new JUnit38ClassRunner(test));
    }

    public Result run(Runner runner) {
        Result result = new Result();
        RunListener createListener = result.createListener();
        this.notifier.addFirstListener(createListener);
        try {
            this.notifier.fireTestRunStarted(runner.getDescription());
            runner.run(this.notifier);
            this.notifier.fireTestRunFinished(result);
            return result;
        } finally {
            removeListener(createListener);
        }
    }
}
