package junit.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* compiled from: P */
/* loaded from: classes28.dex */
public abstract class TestCase extends Assert implements Test {
    private String fName;

    public TestCase() {
        this.fName = null;
    }

    public static void assertEquals(String str, Object obj, Object obj2) {
        Assert.assertEquals(str, obj, obj2);
    }

    public static void assertFalse(String str, boolean z16) {
        Assert.assertFalse(str, z16);
    }

    public static void assertNotNull(Object obj) {
        Assert.assertNotNull(obj);
    }

    public static void assertNotSame(String str, Object obj, Object obj2) {
        Assert.assertNotSame(str, obj, obj2);
    }

    public static void assertNull(Object obj) {
        Assert.assertNull(obj);
    }

    public static void assertSame(String str, Object obj, Object obj2) {
        Assert.assertSame(str, obj, obj2);
    }

    public static void assertTrue(String str, boolean z16) {
        Assert.assertTrue(str, z16);
    }

    public static void fail(String str) {
        Assert.fail(str);
    }

    public static void failNotEquals(String str, Object obj, Object obj2) {
        Assert.failNotEquals(str, obj, obj2);
    }

    public static void failNotSame(String str, Object obj, Object obj2) {
        Assert.failNotSame(str, obj, obj2);
    }

    public static void failSame(String str) {
        Assert.failSame(str);
    }

    public static String format(String str, Object obj, Object obj2) {
        return Assert.format(str, obj, obj2);
    }

    @Override // junit.framework.Test
    public int countTestCases() {
        return 1;
    }

    protected TestResult createResult() {
        return new TestResult();
    }

    public String getName() {
        return this.fName;
    }

    public TestResult run() {
        TestResult createResult = createResult();
        run(createResult);
        return createResult;
    }

    public void runBare() throws Throwable {
        setUp();
        try {
            runTest();
            try {
                tearDown();
                th = null;
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            try {
                tearDown();
            } catch (Throwable unused) {
            }
        }
        if (th == null) {
        } else {
            throw th;
        }
    }

    protected void runTest() throws Throwable {
        assertNotNull("TestCase.fName cannot be null", this.fName);
        Method method = null;
        try {
            method = getClass().getMethod(this.fName, null);
        } catch (NoSuchMethodException unused) {
            fail("Method \"" + this.fName + "\" not found");
        }
        if (!Modifier.isPublic(method.getModifiers())) {
            fail("Method \"" + this.fName + "\" should be public");
        }
        try {
            method.invoke(this, new Object[0]);
        } catch (IllegalAccessException e16) {
            e16.fillInStackTrace();
            throw e16;
        } catch (InvocationTargetException e17) {
            e17.fillInStackTrace();
            throw e17.getTargetException();
        }
    }

    public void setName(String str) {
        this.fName = str;
    }

    public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }

    public static void assertEquals(Object obj, Object obj2) {
        Assert.assertEquals(obj, obj2);
    }

    public static void assertFalse(boolean z16) {
        Assert.assertFalse(z16);
    }

    public static void assertNotNull(String str, Object obj) {
        Assert.assertNotNull(str, obj);
    }

    public static void assertNotSame(Object obj, Object obj2) {
        Assert.assertNotSame(obj, obj2);
    }

    public static void assertNull(String str, Object obj) {
        Assert.assertNull(str, obj);
    }

    public static void assertSame(Object obj, Object obj2) {
        Assert.assertSame(obj, obj2);
    }

    public static void assertTrue(boolean z16) {
        Assert.assertTrue(z16);
    }

    public static void fail() {
        Assert.fail();
    }

    public TestCase(String str) {
        this.fName = str;
    }

    public static void assertEquals(String str, String str2, String str3) {
        Assert.assertEquals(str, str2, str3);
    }

    @Override // junit.framework.Test
    public void run(TestResult testResult) {
        testResult.run(this);
    }

    public static void assertEquals(String str, String str2) {
        Assert.assertEquals(str, str2);
    }

    public static void assertEquals(String str, double d16, double d17, double d18) {
        Assert.assertEquals(str, d16, d17, d18);
    }

    public static void assertEquals(double d16, double d17, double d18) {
        Assert.assertEquals(d16, d17, d18);
    }

    public static void assertEquals(String str, float f16, float f17, float f18) {
        Assert.assertEquals(str, f16, f17, f18);
    }

    public static void assertEquals(float f16, float f17, float f18) {
        Assert.assertEquals(f16, f17, f18);
    }

    public static void assertEquals(String str, long j3, long j16) {
        Assert.assertEquals(str, j3, j16);
    }

    public static void assertEquals(long j3, long j16) {
        Assert.assertEquals(j3, j16);
    }

    public static void assertEquals(String str, boolean z16, boolean z17) {
        Assert.assertEquals(str, z16, z17);
    }

    public static void assertEquals(boolean z16, boolean z17) {
        Assert.assertEquals(z16, z17);
    }

    public static void assertEquals(String str, byte b16, byte b17) {
        Assert.assertEquals(str, b16, b17);
    }

    public static void assertEquals(byte b16, byte b17) {
        Assert.assertEquals(b16, b17);
    }

    public static void assertEquals(String str, char c16, char c17) {
        Assert.assertEquals(str, c16, c17);
    }

    public static void assertEquals(char c16, char c17) {
        Assert.assertEquals(c16, c17);
    }

    public static void assertEquals(String str, short s16, short s17) {
        Assert.assertEquals(str, s16, s17);
    }

    public static void assertEquals(short s16, short s17) {
        Assert.assertEquals(s16, s17);
    }

    public static void assertEquals(String str, int i3, int i16) {
        Assert.assertEquals(str, i3, i16);
    }

    public static void assertEquals(int i3, int i16) {
        Assert.assertEquals(i3, i16);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }
}
