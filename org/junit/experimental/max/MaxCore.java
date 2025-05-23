package org.junit.experimental.max;

import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import junit.framework.TestSuite;
import org.junit.internal.requests.SortingRequest;
import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MaxCore {
    private static final String MALFORMED_JUNIT_3_TEST_CLASS_PREFIX = "malformed JUnit 3 test class: ";
    private final MaxHistory history;

    MaxCore(File file) {
        this.history = MaxHistory.forFolder(file);
    }

    private Runner buildRunner(Description description) {
        if (description.toString().equals("TestSuite with 0 tests")) {
            return Suite.emptySuite();
        }
        if (description.toString().startsWith(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX)) {
            return new JUnit38ClassRunner(new TestSuite(getMalformedTestClass(description)));
        }
        Class<?> testClass = description.getTestClass();
        if (testClass != null) {
            String methodName = description.getMethodName();
            if (methodName == null) {
                return Request.aClass(testClass).getRunner();
            }
            return Request.method(testClass, methodName).getRunner();
        }
        throw new RuntimeException("Can't build a runner from description [" + description + "]");
    }

    private Request constructLeafRequest(List<Description> list) {
        final ArrayList arrayList = new ArrayList();
        Iterator<Description> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(buildRunner(it.next()));
        }
        return new Request() { // from class: org.junit.experimental.max.MaxCore.1
            @Override // org.junit.runner.Request
            public Runner getRunner() {
                try {
                    return new Suite(null, arrayList) { // from class: org.junit.experimental.max.MaxCore.1.1
                    };
                } catch (InitializationError e16) {
                    return new ErrorReportingRunner(null, e16);
                }
            }
        };
    }

    private List<Description> findLeaves(Request request) {
        ArrayList arrayList = new ArrayList();
        findLeaves(null, request.getRunner().getDescription(), arrayList);
        return arrayList;
    }

    @Deprecated
    public static MaxCore forFolder(String str) {
        return storedLocally(new File(str));
    }

    private Class<?> getMalformedTestClass(Description description) {
        try {
            return Class.forName(description.toString().replace(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX, ""));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static MaxCore storedLocally(File file) {
        return new MaxCore(file);
    }

    public Result run(Class<?> cls) {
        return run(Request.aClass(cls));
    }

    public Request sortRequest(Request request) {
        if (request instanceof SortingRequest) {
            return request;
        }
        List<Description> findLeaves = findLeaves(request);
        Collections.sort(findLeaves, this.history.testComparator());
        return constructLeafRequest(findLeaves);
    }

    public List<Description> sortedLeavesForTest(Request request) {
        return findLeaves(sortRequest(request));
    }

    public Result run(Request request) {
        return run(request, new JUnitCore());
    }

    private void findLeaves(Description description, Description description2, List<Description> list) {
        if (description2.getChildren().isEmpty()) {
            if (description2.toString().equals("warning(junit.framework.TestSuite$1)")) {
                list.add(Description.createSuiteDescription(MALFORMED_JUNIT_3_TEST_CLASS_PREFIX + description, new Annotation[0]));
                return;
            }
            list.add(description2);
            return;
        }
        Iterator<Description> it = description2.getChildren().iterator();
        while (it.hasNext()) {
            findLeaves(description2, it.next(), list);
        }
    }

    public Result run(Request request, JUnitCore jUnitCore) {
        jUnitCore.addListener(this.history.listener());
        return jUnitCore.run(sortRequest(request).getRunner());
    }
}
