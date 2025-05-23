package org.apache.commons.lang.exception;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ExceptionUtils {
    private static final Method THROWABLE_CAUSE_METHOD;
    private static final Method THROWABLE_INITCAUSE_METHOD;
    static final String WRAPPED_MARKER = " [wrapped] ";
    static /* synthetic */ Class class$java$lang$Throwable;
    private static final Object CAUSE_METHOD_NAMES_LOCK = new Object();
    private static String[] CAUSE_METHOD_NAMES = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    static {
        Method method;
        Method method2 = null;
        try {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            method = cls.getMethod("getCause", null);
        } catch (Exception unused) {
            method = null;
        }
        THROWABLE_CAUSE_METHOD = method;
        try {
            Class cls2 = class$java$lang$Throwable;
            if (cls2 == null) {
                cls2 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls2;
            }
            Class<?>[] clsArr = new Class[1];
            Class<?> cls3 = class$java$lang$Throwable;
            if (cls3 == null) {
                cls3 = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls3;
            }
            clsArr[0] = cls3;
            method2 = cls2.getMethod("initCause", clsArr);
        } catch (Exception unused2) {
        }
        THROWABLE_INITCAUSE_METHOD = method2;
    }

    public static void addCauseMethodName(String str) {
        if (StringUtils.isNotEmpty(str) && !isCauseMethodName(str)) {
            ArrayList causeMethodNameList = getCauseMethodNameList();
            if (causeMethodNameList.add(str)) {
                synchronized (CAUSE_METHOD_NAMES_LOCK) {
                    CAUSE_METHOD_NAMES = toArray(causeMethodNameList);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e16) {
            throw new NoClassDefFoundError(e16.getMessage());
        }
    }

    public static Throwable getCause(Throwable th5) {
        Throwable cause;
        synchronized (CAUSE_METHOD_NAMES_LOCK) {
            cause = getCause(th5, CAUSE_METHOD_NAMES);
        }
        return cause;
    }

    private static ArrayList getCauseMethodNameList() {
        ArrayList arrayList;
        synchronized (CAUSE_METHOD_NAMES_LOCK) {
            arrayList = new ArrayList(Arrays.asList(CAUSE_METHOD_NAMES));
        }
        return arrayList;
    }

    private static Throwable getCauseUsingFieldName(Throwable th5, String str) {
        Field field;
        try {
            field = th5.getClass().getField(str);
        } catch (NoSuchFieldException | SecurityException unused) {
            field = null;
        }
        if (field != null) {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            if (cls.isAssignableFrom(field.getType())) {
                try {
                    return (Throwable) field.get(th5);
                } catch (IllegalAccessException | IllegalArgumentException unused2) {
                }
            }
        }
        return null;
    }

    private static Throwable getCauseUsingMethodName(Throwable th5, String str) {
        Method method;
        try {
            method = th5.getClass().getMethod(str, null);
        } catch (NoSuchMethodException | SecurityException unused) {
            method = null;
        }
        if (method != null) {
            Class cls = class$java$lang$Throwable;
            if (cls == null) {
                cls = class$("java.lang.Throwable");
                class$java$lang$Throwable = cls;
            }
            if (cls.isAssignableFrom(method.getReturnType())) {
                try {
                    return (Throwable) method.invoke(th5, ArrayUtils.EMPTY_OBJECT_ARRAY);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused2) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Throwable getCauseUsingWellKnownTypes(Throwable th5) {
        if (th5 instanceof Nestable) {
            return ((Nestable) th5).getCause();
        }
        if (th5 instanceof SQLException) {
            return ((SQLException) th5).getNextException();
        }
        if (th5 instanceof InvocationTargetException) {
            return ((InvocationTargetException) th5).getTargetException();
        }
        return null;
    }

    public static String getFullStackTrace(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        Throwable[] throwables = getThrowables(th5);
        for (int i3 = 0; i3 < throwables.length; i3++) {
            throwables[i3].printStackTrace(printWriter);
            if (isNestedThrowable(throwables[i3])) {
                break;
            }
        }
        return stringWriter.getBuffer().toString();
    }

    public static String getMessage(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        String shortClassName = ClassUtils.getShortClassName(th5, null);
        String message = th5.getMessage();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(shortClassName);
        stringBuffer.append(MsgSummary.STR_COLON);
        stringBuffer.append(StringUtils.defaultString(message));
        return stringBuffer.toString();
    }

    public static Throwable getRootCause(Throwable th5) {
        List throwableList = getThrowableList(th5);
        if (throwableList.size() < 2) {
            return null;
        }
        return (Throwable) throwableList.get(throwableList.size() - 1);
    }

    public static String getRootCauseMessage(Throwable th5) {
        Throwable rootCause = getRootCause(th5);
        if (rootCause != null) {
            th5 = rootCause;
        }
        return getMessage(th5);
    }

    public static String[] getRootCauseStackTrace(Throwable th5) {
        List list;
        if (th5 == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        Throwable[] throwables = getThrowables(th5);
        int length = throwables.length;
        ArrayList arrayList = new ArrayList();
        int i3 = length - 1;
        List stackFrameList = getStackFrameList(throwables[i3]);
        while (true) {
            length--;
            if (length >= 0) {
                if (length != 0) {
                    list = getStackFrameList(throwables[length - 1]);
                    removeCommonFrames(stackFrameList, list);
                } else {
                    list = stackFrameList;
                }
                if (length == i3) {
                    arrayList.add(throwables[length].toString());
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(WRAPPED_MARKER);
                    stringBuffer.append(throwables[length].toString());
                    arrayList.add(stringBuffer.toString());
                }
                for (int i16 = 0; i16 < stackFrameList.size(); i16++) {
                    arrayList.add(stackFrameList.get(i16));
                }
                stackFrameList = list;
            } else {
                return (String[]) arrayList.toArray(new String[0]);
            }
        }
    }

    static List getStackFrameList(Throwable th5) {
        StringTokenizer stringTokenizer = new StringTokenizer(getStackTrace(th5), SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        boolean z16 = false;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            int indexOf = nextToken.indexOf("at");
            if (indexOf != -1 && nextToken.substring(0, indexOf).trim().length() == 0) {
                arrayList.add(nextToken);
                z16 = true;
            } else if (z16) {
                break;
            }
        }
        return arrayList;
    }

    public static String[] getStackFrames(Throwable th5) {
        if (th5 == null) {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        return getStackFrames(getStackTrace(th5));
    }

    public static String getStackTrace(Throwable th5) {
        StringWriter stringWriter = new StringWriter();
        th5.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public static int getThrowableCount(Throwable th5) {
        return getThrowableList(th5).size();
    }

    public static List getThrowableList(Throwable th5) {
        ArrayList arrayList = new ArrayList();
        while (th5 != null && !arrayList.contains(th5)) {
            arrayList.add(th5);
            th5 = getCause(th5);
        }
        return arrayList;
    }

    public static Throwable[] getThrowables(Throwable th5) {
        List throwableList = getThrowableList(th5);
        return (Throwable[]) throwableList.toArray(new Throwable[throwableList.size()]);
    }

    private static int indexOf(Throwable th5, Class cls, int i3, boolean z16) {
        if (th5 != null && cls != null) {
            if (i3 < 0) {
                i3 = 0;
            }
            Throwable[] throwables = getThrowables(th5);
            if (i3 >= throwables.length) {
                return -1;
            }
            if (z16) {
                while (i3 < throwables.length) {
                    if (cls.isAssignableFrom(throwables[i3].getClass())) {
                        return i3;
                    }
                    i3++;
                }
            } else {
                while (i3 < throwables.length) {
                    if (cls.equals(throwables[i3].getClass())) {
                        return i3;
                    }
                    i3++;
                }
            }
        }
        return -1;
    }

    public static int indexOfThrowable(Throwable th5, Class cls) {
        return indexOf(th5, cls, 0, false);
    }

    public static int indexOfType(Throwable th5, Class cls) {
        return indexOf(th5, cls, 0, true);
    }

    public static boolean isCauseMethodName(String str) {
        boolean z16;
        synchronized (CAUSE_METHOD_NAMES_LOCK) {
            if (ArrayUtils.indexOf(CAUSE_METHOD_NAMES, str) >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    public static boolean isNestedThrowable(Throwable th5) {
        if (th5 == null) {
            return false;
        }
        if ((th5 instanceof Nestable) || (th5 instanceof SQLException) || (th5 instanceof InvocationTargetException) || isThrowableNested()) {
            return true;
        }
        Class<?> cls = th5.getClass();
        synchronized (CAUSE_METHOD_NAMES_LOCK) {
            int length = CAUSE_METHOD_NAMES.length;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    Method method = cls.getMethod(CAUSE_METHOD_NAMES[i3], null);
                    if (method == null) {
                        continue;
                    } else {
                        Class cls2 = class$java$lang$Throwable;
                        if (cls2 == null) {
                            cls2 = class$("java.lang.Throwable");
                            class$java$lang$Throwable = cls2;
                        }
                        if (cls2.isAssignableFrom(method.getReturnType())) {
                            return true;
                        }
                    }
                } catch (NoSuchMethodException | SecurityException unused) {
                }
            }
            if (cls.getField("detail") == null) {
                return false;
            }
            return true;
        }
    }

    public static boolean isThrowableNested() {
        if (THROWABLE_CAUSE_METHOD != null) {
            return true;
        }
        return false;
    }

    public static void printRootCauseStackTrace(Throwable th5) {
        printRootCauseStackTrace(th5, System.err);
    }

    public static void removeCauseMethodName(String str) {
        if (StringUtils.isNotEmpty(str)) {
            ArrayList causeMethodNameList = getCauseMethodNameList();
            if (causeMethodNameList.remove(str)) {
                synchronized (CAUSE_METHOD_NAMES_LOCK) {
                    CAUSE_METHOD_NAMES = toArray(causeMethodNameList);
                }
            }
        }
    }

    public static void removeCommonFrames(List list, List list2) {
        if (list != null && list2 != null) {
            int size = list.size() - 1;
            for (int size2 = list2.size() - 1; size >= 0 && size2 >= 0; size2--) {
                if (((String) list.get(size)).equals((String) list2.get(size2))) {
                    list.remove(size);
                }
                size--;
            }
            return;
        }
        throw new IllegalArgumentException("The List must not be null");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f A[Catch: IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0032, TryCatch #1 {IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0032, blocks: (B:6:0x0012, B:8:0x001f, B:9:0x0028), top: B:5:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean setCause(Throwable th5, Throwable th6) {
        boolean z16;
        Class<?> cls;
        if (th5 != null) {
            Object[] objArr = {th6};
            Method method = THROWABLE_INITCAUSE_METHOD;
            try {
                if (method != null) {
                    try {
                        method.invoke(th5, objArr);
                        z16 = true;
                    } catch (IllegalAccessException | InvocationTargetException unused) {
                    }
                    Class<?> cls2 = th5.getClass();
                    Class<?>[] clsArr = new Class[1];
                    cls = class$java$lang$Throwable;
                    if (cls == null) {
                        cls = class$("java.lang.Throwable");
                        class$java$lang$Throwable = cls;
                    }
                    clsArr[0] = cls;
                    cls2.getMethod("setCause", clsArr).invoke(th5, objArr);
                    return true;
                }
                Class<?> cls22 = th5.getClass();
                Class<?>[] clsArr2 = new Class[1];
                cls = class$java$lang$Throwable;
                if (cls == null) {
                }
                clsArr2[0] = cls;
                cls22.getMethod("setCause", clsArr2).invoke(th5, objArr);
                return true;
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                return z16;
            }
            z16 = false;
        } else {
            throw new NullArgumentException("target");
        }
    }

    private static String[] toArray(List list) {
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static int indexOfThrowable(Throwable th5, Class cls, int i3) {
        return indexOf(th5, cls, i3, false);
    }

    public static int indexOfType(Throwable th5, Class cls, int i3) {
        return indexOf(th5, cls, i3, true);
    }

    public static void printRootCauseStackTrace(Throwable th5, PrintStream printStream) {
        if (th5 == null) {
            return;
        }
        if (printStream != null) {
            for (String str : getRootCauseStackTrace(th5)) {
                printStream.println(str);
            }
            printStream.flush();
            return;
        }
        throw new IllegalArgumentException("The PrintStream must not be null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] getStackFrames(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, SystemUtils.LINE_SEPARATOR);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return toArray(arrayList);
    }

    public static Throwable getCause(Throwable th5, String[] strArr) {
        String str;
        if (th5 == null) {
            return null;
        }
        Throwable causeUsingWellKnownTypes = getCauseUsingWellKnownTypes(th5);
        if (causeUsingWellKnownTypes != null) {
            return causeUsingWellKnownTypes;
        }
        if (strArr == null) {
            synchronized (CAUSE_METHOD_NAMES_LOCK) {
                strArr = CAUSE_METHOD_NAMES;
            }
        }
        for (int i3 = 0; i3 < strArr.length && ((str = strArr[i3]) == null || (causeUsingWellKnownTypes = getCauseUsingMethodName(th5, str)) == null); i3++) {
        }
        return causeUsingWellKnownTypes == null ? getCauseUsingFieldName(th5, "detail") : causeUsingWellKnownTypes;
    }

    public static void printRootCauseStackTrace(Throwable th5, PrintWriter printWriter) {
        if (th5 == null) {
            return;
        }
        if (printWriter != null) {
            for (String str : getRootCauseStackTrace(th5)) {
                printWriter.println(str);
            }
            printWriter.flush();
            return;
        }
        throw new IllegalArgumentException("The PrintWriter must not be null");
    }
}
