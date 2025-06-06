package org.junit.runner;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes29.dex */
public class Description implements Serializable {
    private static final long serialVersionUID = 1;
    private final Annotation[] fAnnotations;
    private final Collection<Description> fChildren;
    private final String fDisplayName;
    private volatile Class<?> fTestClass;
    private final Serializable fUniqueId;
    private static final Pattern METHOD_AND_CLASS_NAME_PATTERN = Pattern.compile("([\\s\\S]*)\\((.*)\\)");
    public static final Description EMPTY = new Description(null, "No Tests", new Annotation[0]);
    public static final Description TEST_MECHANISM = new Description(null, "Test mechanism", new Annotation[0]);

    Description(Class<?> cls, String str, Annotation... annotationArr) {
        this(cls, str, str, annotationArr);
    }

    public static Description createSuiteDescription(String str, Annotation... annotationArr) {
        return new Description(null, str, annotationArr);
    }

    public static Description createTestDescription(String str, String str2, Annotation... annotationArr) {
        return new Description(null, formatDisplayName(str2, str), annotationArr);
    }

    private static String formatDisplayName(String str, String str2) {
        return String.format("%s(%s)", str, str2);
    }

    private String methodAndClassNamePatternGroupOrDefault(int i3, String str) {
        Matcher matcher = METHOD_AND_CLASS_NAME_PATTERN.matcher(toString());
        if (matcher.matches()) {
            return matcher.group(i3);
        }
        return str;
    }

    public void addChild(Description description) {
        this.fChildren.add(description);
    }

    public Description childlessCopy() {
        return new Description(this.fTestClass, this.fDisplayName, this.fAnnotations);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Description)) {
            return false;
        }
        return this.fUniqueId.equals(((Description) obj).fUniqueId);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        for (Annotation annotation : this.fAnnotations) {
            if (annotation.annotationType().equals(cls)) {
                return cls.cast(annotation);
            }
        }
        return null;
    }

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.fAnnotations);
    }

    public ArrayList<Description> getChildren() {
        return new ArrayList<>(this.fChildren);
    }

    public String getClassName() {
        if (this.fTestClass != null) {
            return this.fTestClass.getName();
        }
        return methodAndClassNamePatternGroupOrDefault(2, toString());
    }

    public String getDisplayName() {
        return this.fDisplayName;
    }

    public String getMethodName() {
        return methodAndClassNamePatternGroupOrDefault(1, null);
    }

    public Class<?> getTestClass() {
        if (this.fTestClass != null) {
            return this.fTestClass;
        }
        String className = getClassName();
        if (className == null) {
            return null;
        }
        try {
            this.fTestClass = Class.forName(className, false, getClass().getClassLoader());
            return this.fTestClass;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public int hashCode() {
        return this.fUniqueId.hashCode();
    }

    public boolean isEmpty() {
        return equals(EMPTY);
    }

    public boolean isSuite() {
        return !isTest();
    }

    public boolean isTest() {
        return this.fChildren.isEmpty();
    }

    public int testCount() {
        if (isTest()) {
            return 1;
        }
        Iterator<Description> it = this.fChildren.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += it.next().testCount();
        }
        return i3;
    }

    public String toString() {
        return getDisplayName();
    }

    Description(Class<?> cls, String str, Serializable serializable, Annotation... annotationArr) {
        this.fChildren = new ConcurrentLinkedQueue();
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The display name must not be empty.");
        }
        if (serializable != null) {
            this.fTestClass = cls;
            this.fDisplayName = str;
            this.fUniqueId = serializable;
            this.fAnnotations = annotationArr;
            return;
        }
        throw new IllegalArgumentException("The unique id must not be null.");
    }

    public static Description createSuiteDescription(String str, Serializable serializable, Annotation... annotationArr) {
        return new Description(null, str, serializable, annotationArr);
    }

    public static Description createTestDescription(Class<?> cls, String str, Annotation... annotationArr) {
        return new Description(cls, formatDisplayName(str, cls.getName()), annotationArr);
    }

    public static Description createSuiteDescription(Class<?> cls) {
        return new Description(cls, cls.getName(), cls.getAnnotations());
    }

    public static Description createTestDescription(Class<?> cls, String str) {
        return new Description(cls, formatDisplayName(str, cls.getName()), new Annotation[0]);
    }

    public static Description createTestDescription(String str, String str2, Serializable serializable) {
        return new Description(null, formatDisplayName(str2, str), serializable, new Annotation[0]);
    }
}
