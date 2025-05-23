package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.junit.internal.MethodSorter;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TestSuite implements Test {
    private String fName;
    private Vector<Test> fTests;

    public TestSuite() {
        this.fTests = new Vector<>(10);
    }

    private void addTestMethod(Method method, List<String> list, Class<?> cls) {
        String name = method.getName();
        if (list.contains(name)) {
            return;
        }
        if (!isPublicTestMethod(method)) {
            if (isTestMethod(method)) {
                addTest(warning("Test method isn't public: " + method.getName() + "(" + cls.getCanonicalName() + ")"));
                return;
            }
            return;
        }
        list.add(name);
        addTest(createTest(cls, name));
    }

    private void addTestsFromTestCase(Class<?> cls) {
        this.fName = cls.getName();
        try {
            getTestConstructor(cls);
            if (!Modifier.isPublic(cls.getModifiers())) {
                addTest(warning("Class " + cls.getName() + " is not public"));
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Class<?> cls2 = cls; Test.class.isAssignableFrom(cls2); cls2 = cls2.getSuperclass()) {
                for (Method method : MethodSorter.getDeclaredMethods(cls2)) {
                    addTestMethod(method, arrayList, cls);
                }
            }
            if (this.fTests.size() == 0) {
                addTest(warning("No tests found in " + cls.getName()));
            }
        } catch (NoSuchMethodException unused) {
            addTest(warning("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()"));
        }
    }

    public static Test createTest(Class<?> cls, String str) {
        Object newInstance;
        try {
            Constructor<?> testConstructor = getTestConstructor(cls);
            try {
                if (testConstructor.getParameterTypes().length == 0) {
                    newInstance = testConstructor.newInstance(new Object[0]);
                    if (newInstance instanceof TestCase) {
                        ((TestCase) newInstance).setName(str);
                    }
                } else {
                    newInstance = testConstructor.newInstance(str);
                }
                return (Test) newInstance;
            } catch (IllegalAccessException e16) {
                return warning("Cannot access test case: " + str + " (" + exceptionToString(e16) + ")");
            } catch (InstantiationException e17) {
                return warning("Cannot instantiate test case: " + str + " (" + exceptionToString(e17) + ")");
            } catch (InvocationTargetException e18) {
                return warning("Exception in constructor: " + str + " (" + exceptionToString(e18.getTargetException()) + ")");
            }
        } catch (NoSuchMethodException unused) {
            return warning("Class " + cls.getName() + " has no public constructor TestCase(String name) or TestCase()");
        }
    }

    private static String exceptionToString(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static Constructor<?> getTestConstructor(Class<?> cls) throws NoSuchMethodException {
        try {
            return cls.getConstructor(String.class);
        } catch (NoSuchMethodException unused) {
            return cls.getConstructor(new Class[0]);
        }
    }

    private boolean isPublicTestMethod(Method method) {
        if (isTestMethod(method) && Modifier.isPublic(method.getModifiers())) {
            return true;
        }
        return false;
    }

    private boolean isTestMethod(Method method) {
        if (method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE)) {
            return true;
        }
        return false;
    }

    private Test testCaseForClass(Class<?> cls) {
        if (TestCase.class.isAssignableFrom(cls)) {
            return new TestSuite(cls.asSubclass(TestCase.class));
        }
        return warning(cls.getCanonicalName() + " does not extend TestCase");
    }

    public static Test warning(final String str) {
        return new TestCase("warning") { // from class: junit.framework.TestSuite.1
            @Override // junit.framework.TestCase
            protected void runTest() {
                TestCase.fail(str);
            }
        };
    }

    public void addTest(Test test) {
        this.fTests.add(test);
    }

    public void addTestSuite(Class<? extends TestCase> cls) {
        addTest(new TestSuite(cls));
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        Iterator<Test> it = this.fTests.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().countTestCases();
        }
        return i3;
    }

    public String getName() {
        return this.fName;
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        Iterator<Test> it = this.fTests.iterator();
        while (it.hasNext()) {
            Test next = it.next();
            if (!testResult.shouldStop()) {
                runTest(next, testResult);
            } else {
                return;
            }
        }
    }

    public void runTest(Test test, TestResult testResult) {
        test.run(testResult);
    }

    public void setName(String str) {
        this.fName = str;
    }

    public Test testAt(int i3) {
        return this.fTests.get(i3);
    }

    public int testCount() {
        return this.fTests.size();
    }

    public Enumeration<Test> tests() {
        return this.fTests.elements();
    }

    public String toString() {
        if (getName() != null) {
            return getName();
        }
        return super.toString();
    }

    public TestSuite(Class<?> cls) {
        this.fTests = new Vector<>(10);
        addTestsFromTestCase(cls);
    }

    public TestSuite(Class<? extends TestCase> cls, String str) {
        this(cls);
        setName(str);
    }

    public TestSuite(String str) {
        this.fTests = new Vector<>(10);
        setName(str);
    }

    public TestSuite(Class<?>... clsArr) {
        this.fTests = new Vector<>(10);
        for (Class<?> cls : clsArr) {
            addTest(testCaseForClass(cls));
        }
    }

    public TestSuite(Class<? extends TestCase>[] clsArr, String str) {
        this(clsArr);
        setName(str);
    }
}
