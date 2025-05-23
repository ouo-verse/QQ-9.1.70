package mqq.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes28.dex */
public class QQPermissionHelper {
    private static final String TAG = "QQPermissionHelper";

    public static void doExecuteFail(Object obj, int i3) {
        try {
            executeMethod(obj, findMethodWithRequestCode(obj.getClass(), QQPermissionDenied.class, i3));
        } catch (Exception unused) {
        }
    }

    public static void doExecuteSuccess(Object obj, int i3) {
        executeMethod(obj, findMethodWithRequestCode(obj.getClass(), QQPermissionGrant.class, i3));
    }

    private static void executeMethod(Object obj, Method method) {
        if (method != null) {
            try {
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(obj, null);
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (InvocationTargetException e17) {
                e17.printStackTrace();
            }
        }
    }

    public static <A extends Annotation> Method findMethodWithRequestCode(Class cls, Class<A> cls2, int i3) {
        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(cls2) && isEqualRequestCodeFromAnntation(method, cls2, i3)) {
                return method;
            }
        }
        return null;
    }

    public static boolean isEqualRequestCodeFromAnntation(Method method, Class cls, int i3) {
        if (cls.equals(QQPermissionDenied.class)) {
            if (i3 == ((QQPermissionDenied) method.getAnnotation(QQPermissionDenied.class)).value()) {
                return true;
            }
            return false;
        }
        if (cls.equals(QQPermissionGrant.class) && i3 == ((QQPermissionGrant) method.getAnnotation(QQPermissionGrant.class)).value()) {
            return true;
        }
        return false;
    }

    public static void requestResult(Object obj, int i3, String[] strArr, int[] iArr) {
        if (iArr != null && iArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < iArr.length; i16++) {
                if (iArr[i16] != 0) {
                    arrayList.add(strArr[i16]);
                }
            }
            if (arrayList.size() > 0) {
                doExecuteFail(obj, i3);
            } else {
                doExecuteSuccess(obj, i3);
            }
        }
    }
}
