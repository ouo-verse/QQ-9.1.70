package com.tencent.biz.qqcircle.aspectj.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.richframework.part.utils.RFSafeMapUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleAnonymousObjectUtils {
    private static final String ANONYMOUS_OBJ_0 = "this$0";
    private static final String ANONYMOUS_OBJ_1 = "this$1";
    private static final String STRING_REGULAR = ".*\\$\\d+";
    private static final String TAG = "ObjectUtils";
    private static final Map<String, Boolean> mMemberClassMap = new HashMap(1);
    private static final Map<String, Boolean> mAnonymousClassMap = new HashMap(1);
    private static final Map<Integer, Pair<String, WeakReference<Object>>> mObjWeakMap = new HashMap(1);

    private static Object getDirectOuterObject(Object obj) {
        if (obj == null) {
            QLog.e(TAG, 2, "getDirectOuterObject target is null");
            return null;
        }
        return obtainFieldObj(obj, ANONYMOUS_OBJ_0);
    }

    public static Object getOuterObject(Object obj) {
        if (obj == null) {
            QLog.e(TAG, 2, "[getOuterObject] target is null.");
            return null;
        }
        if (isMemberClass(obj.getClass())) {
            return getDirectOuterObject(obtainFieldObj(obj, ANONYMOUS_OBJ_1));
        }
        return getDirectOuterObject(obj);
    }

    public static boolean isAnonymousClass(Class cls) {
        if (cls == null) {
            return false;
        }
        String name = cls.getName();
        if (TextUtils.isEmpty(name)) {
            Map<String, Boolean> map = mAnonymousClassMap;
            if (map.get(name) != null) {
                return map.get(name).booleanValue();
            }
        }
        if (cls.isAnonymousClass()) {
            mAnonymousClassMap.put(name, Boolean.TRUE);
            return true;
        }
        return isAnonymousClass(name);
    }

    public static boolean isMemberClass(Class cls) {
        if (cls == null) {
            QLog.e(TAG, 2, "[isMemberClass] clazz should not be is null.");
            return false;
        }
        return isMemberClass(cls.getName());
    }

    public static Object obtainFieldObj(Object obj, String str) {
        Pair<String, WeakReference<Object>> pair;
        String obj2;
        Object obj3;
        if (obj == null) {
            QLog.e(TAG, 2, "[obtainFieldObj] target should not be is null, get field fail.");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "[obtainFieldObj] name is empty, get field fail.");
            return null;
        }
        int hashCode = obj.hashCode();
        Map<Integer, Pair<String, WeakReference<Object>>> map = mObjWeakMap;
        if (map == null) {
            pair = null;
        } else {
            pair = map.get(Integer.valueOf(hashCode));
        }
        if (pair != null && TextUtils.equals((CharSequence) pair.first, str)) {
            Object obj4 = pair.second;
            if (obj4 == null) {
                obj3 = null;
            } else {
                obj3 = ((WeakReference) obj4).get();
            }
            if (obj3 != null) {
                return obj3;
            }
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            Object obj5 = declaredField.get(obj);
            if (map != null && obj5 != null) {
                map.put(Integer.valueOf(hashCode), new Pair<>(str, new WeakReference(obj5)));
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[obtainFieldObj] obtain target:");
            sb5.append(obj.toString());
            sb5.append(" object is: ");
            if (obj5 == null) {
                obj2 = "null";
            } else {
                obj2 = obj5.toString();
            }
            sb5.append(obj2);
            printDebugLog(sb5.toString());
            return obj5;
        } catch (Exception e16) {
            QLog.e(TAG, 2, "[obtainFieldObj] target:" + obj.toString() + " name: " + str + " | error:", e16);
            return null;
        }
    }

    private static void printDebugLog(String str) {
        if (str != null && QLog.isColorLevel()) {
            QLog.d(TAG, 2, str);
        }
    }

    public static void release() {
        RFSafeMapUtils.clear(mAnonymousClassMap);
        RFSafeMapUtils.clear(mMemberClassMap);
        RFSafeMapUtils.clear(mObjWeakMap);
    }

    public static boolean isMemberClass(String str) {
        Map<String, Boolean> map = mMemberClassMap;
        if (map != null && map.get(str) != null) {
            return map.get(str).booleanValue();
        }
        boolean z16 = false;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "[isMemberClass] current class name should not be null.");
            return false;
        }
        if (str.contains("$") && !str.matches(STRING_REGULAR)) {
            z16 = true;
        }
        if (map != null) {
            map.put(str, Boolean.valueOf(z16));
        }
        printDebugLog("[isMemberClass] class name: " + str + " | isMatches: " + z16);
        return z16;
    }

    public static boolean isAnonymousClass(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 2, "[isAnonymousClass] current class name: ");
            return false;
        }
        boolean matches = str.matches(STRING_REGULAR);
        printDebugLog("[isAnonymousClass] class name: " + str + " | isMatches: " + matches);
        return matches;
    }
}
