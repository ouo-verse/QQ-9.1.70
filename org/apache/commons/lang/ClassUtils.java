package org.apache.commons.lang;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ClassUtils {
    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
    public static final char PACKAGE_SEPARATOR_CHAR = '.';
    private static final Map abbreviationMap;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$org$apache$commons$lang$ClassUtils;
    private static final Map primitiveWrapperMap;
    private static final Map reverseAbbreviationMap;
    private static final Map wrapperPrimitiveMap;
    public static final String PACKAGE_SEPARATOR = String.valueOf('.');
    public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');

    static {
        HashMap hashMap = new HashMap();
        primitiveWrapperMap = hashMap;
        Class cls = Boolean.TYPE;
        Class cls2 = class$java$lang$Boolean;
        if (cls2 == null) {
            cls2 = class$("java.lang.Boolean");
            class$java$lang$Boolean = cls2;
        }
        hashMap.put(cls, cls2);
        Class cls3 = Byte.TYPE;
        Class cls4 = class$java$lang$Byte;
        if (cls4 == null) {
            cls4 = class$("java.lang.Byte");
            class$java$lang$Byte = cls4;
        }
        hashMap.put(cls3, cls4);
        Class cls5 = Character.TYPE;
        Class cls6 = class$java$lang$Character;
        if (cls6 == null) {
            cls6 = class$("java.lang.Character");
            class$java$lang$Character = cls6;
        }
        hashMap.put(cls5, cls6);
        Class cls7 = Short.TYPE;
        Class cls8 = class$java$lang$Short;
        if (cls8 == null) {
            cls8 = class$("java.lang.Short");
            class$java$lang$Short = cls8;
        }
        hashMap.put(cls7, cls8);
        Class cls9 = Integer.TYPE;
        Class cls10 = class$java$lang$Integer;
        if (cls10 == null) {
            cls10 = class$("java.lang.Integer");
            class$java$lang$Integer = cls10;
        }
        hashMap.put(cls9, cls10);
        Class cls11 = Long.TYPE;
        Class cls12 = class$java$lang$Long;
        if (cls12 == null) {
            cls12 = class$("java.lang.Long");
            class$java$lang$Long = cls12;
        }
        hashMap.put(cls11, cls12);
        Class cls13 = Double.TYPE;
        Class cls14 = class$java$lang$Double;
        if (cls14 == null) {
            cls14 = class$("java.lang.Double");
            class$java$lang$Double = cls14;
        }
        hashMap.put(cls13, cls14);
        Class cls15 = Float.TYPE;
        Class cls16 = class$java$lang$Float;
        if (cls16 == null) {
            cls16 = class$("java.lang.Float");
            class$java$lang$Float = cls16;
        }
        hashMap.put(cls15, cls16);
        Class cls17 = Void.TYPE;
        hashMap.put(cls17, cls17);
        wrapperPrimitiveMap = new HashMap();
        for (Class cls18 : hashMap.keySet()) {
            Class cls19 = (Class) primitiveWrapperMap.get(cls18);
            if (!cls18.equals(cls19)) {
                wrapperPrimitiveMap.put(cls19, cls18);
            }
        }
        abbreviationMap = new HashMap();
        reverseAbbreviationMap = new HashMap();
        addAbbreviation(PoiListCacheRecord.WEIGHT_TYPE, "I");
        addAbbreviation(HippyControllerProps.BOOLEAN, "Z");
        addAbbreviation("float", UserInfo.SEX_FEMALE);
        addAbbreviation(PoiListCacheRecord.TIMESTAMP_TYPE, "J");
        addAbbreviation(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT, ExifInterface.LATITUDE_SOUTH);
        addAbbreviation("byte", "B");
        addAbbreviation("double", "D");
        addAbbreviation(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR, BdhLogUtil.LogTag.Tag_Conn);
    }

    private static void addAbbreviation(String str, String str2) {
        abbreviationMap.put(str, str2);
        reverseAbbreviationMap.put(str2, str);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e16) {
            throw new NoClassDefFoundError(e16.getMessage());
        }
    }

    public static List convertClassNamesToClasses(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(Class.forName((String) it.next()));
            } catch (Exception unused) {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public static List convertClassesToClassNames(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Class cls = (Class) it.next();
            if (cls == null) {
                arrayList.add(null);
            } else {
                arrayList.add(cls.getName());
            }
        }
        return arrayList;
    }

    public static List getAllInterfaces(Class cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        getAllInterfaces(cls, arrayList);
        return arrayList;
    }

    public static List getAllSuperclasses(Class cls) {
        if (cls == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            arrayList.add(superclass);
        }
        return arrayList;
    }

    private static String getCanonicalName(String str) {
        int length;
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace == null) {
            return null;
        }
        int i3 = 0;
        while (deleteWhitespace.startsWith("[")) {
            i3++;
            deleteWhitespace = deleteWhitespace.substring(1);
        }
        if (i3 < 1) {
            return deleteWhitespace;
        }
        if (deleteWhitespace.startsWith("L")) {
            if (deleteWhitespace.endsWith(";")) {
                length = deleteWhitespace.length() - 1;
            } else {
                length = deleteWhitespace.length();
            }
            deleteWhitespace = deleteWhitespace.substring(1, length);
        } else if (deleteWhitespace.length() > 0) {
            deleteWhitespace = (String) reverseAbbreviationMap.get(deleteWhitespace.substring(0, 1));
        }
        StrBuilder strBuilder = new StrBuilder(deleteWhitespace);
        for (int i16 = 0; i16 < i3; i16++) {
            strBuilder.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return strBuilder.toString();
    }

    public static Class getClass(ClassLoader classLoader, String str, boolean z16) throws ClassNotFoundException {
        try {
            Map map = abbreviationMap;
            if (map.containsKey(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                stringBuffer.append(map.get(str));
                return Class.forName(stringBuffer.toString(), z16, classLoader).getComponentType();
            }
            return Class.forName(toCanonicalName(str), z16, classLoader);
        } catch (ClassNotFoundException e16) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf != -1) {
                try {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(str.substring(0, lastIndexOf));
                    stringBuffer2.append('$');
                    stringBuffer2.append(str.substring(lastIndexOf + 1));
                    return getClass(classLoader, stringBuffer2.toString(), z16);
                } catch (ClassNotFoundException unused) {
                    throw e16;
                }
            }
            throw e16;
        }
    }

    public static String getPackageCanonicalName(Object obj, String str) {
        return obj == null ? str : getPackageCanonicalName(obj.getClass().getName());
    }

    public static String getPackageName(Object obj, String str) {
        return obj == null ? str : getPackageName(obj.getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Method getPublicMethod(Class cls, String str, Class[] clsArr) throws SecurityException, NoSuchMethodException {
        Method method;
        Method method2 = cls.getMethod(str, clsArr);
        if (Modifier.isPublic(method2.getDeclaringClass().getModifiers())) {
            return method2;
        }
        ArrayList<Class> arrayList = new ArrayList();
        arrayList.addAll(getAllInterfaces(cls));
        arrayList.addAll(getAllSuperclasses(cls));
        for (Class cls2 : arrayList) {
            if (Modifier.isPublic(cls2.getModifiers())) {
                try {
                    method = cls2.getMethod(str, clsArr);
                } catch (NoSuchMethodException unused) {
                }
                if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
                    return method;
                }
            }
            while (r2.hasNext()) {
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Can't find a public method for ");
        stringBuffer.append(str);
        stringBuffer.append(" ");
        stringBuffer.append(ArrayUtils.toString(clsArr));
        throw new NoSuchMethodException(stringBuffer.toString());
    }

    public static String getShortCanonicalName(Object obj, String str) {
        return obj == null ? str : getShortCanonicalName(obj.getClass().getName());
    }

    public static String getShortClassName(Object obj, String str) {
        return obj == null ? str : getShortClassName(obj.getClass());
    }

    public static boolean isAssignable(Class[] clsArr, Class[] clsArr2) {
        return isAssignable(clsArr, clsArr2, false);
    }

    public static boolean isInnerClass(Class cls) {
        if (cls == null || cls.getName().indexOf(36) < 0) {
            return false;
        }
        return true;
    }

    public static Class primitiveToWrapper(Class cls) {
        if (cls != null && cls.isPrimitive()) {
            return (Class) primitiveWrapperMap.get(cls);
        }
        return cls;
    }

    public static Class[] primitivesToWrappers(Class[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            clsArr2[i3] = primitiveToWrapper(clsArr[i3]);
        }
        return clsArr2;
    }

    private static String toCanonicalName(String str) {
        String deleteWhitespace = StringUtils.deleteWhitespace(str);
        if (deleteWhitespace != null) {
            if (deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                StrBuilder strBuilder = new StrBuilder();
                while (deleteWhitespace.endsWith(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                    deleteWhitespace = deleteWhitespace.substring(0, deleteWhitespace.length() - 2);
                    strBuilder.append("[");
                }
                String str2 = (String) abbreviationMap.get(deleteWhitespace);
                if (str2 != null) {
                    strBuilder.append(str2);
                } else {
                    strBuilder.append("L").append(deleteWhitespace).append(";");
                }
                return strBuilder.toString();
            }
            return deleteWhitespace;
        }
        throw new NullArgumentException(PushClientConstants.TAG_CLASS_NAME);
    }

    public static Class[] toClass(Object[] objArr) {
        Class<?> cls;
        if (objArr == null) {
            return null;
        }
        if (objArr.length == 0) {
            return ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        Class[] clsArr = new Class[objArr.length];
        for (int i3 = 0; i3 < objArr.length; i3++) {
            Object obj = objArr[i3];
            if (obj == null) {
                cls = null;
            } else {
                cls = obj.getClass();
            }
            clsArr[i3] = cls;
        }
        return clsArr;
    }

    public static Class wrapperToPrimitive(Class cls) {
        return (Class) wrapperPrimitiveMap.get(cls);
    }

    public static Class[] wrappersToPrimitives(Class[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        if (clsArr.length == 0) {
            return clsArr;
        }
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            clsArr2[i3] = wrapperToPrimitive(clsArr[i3]);
        }
        return clsArr2;
    }

    public static String getPackageCanonicalName(Class cls) {
        return cls == null ? "" : getPackageCanonicalName(cls.getName());
    }

    public static String getPackageName(Class cls) {
        return cls == null ? "" : getPackageName(cls.getName());
    }

    public static String getShortCanonicalName(Class cls) {
        return cls == null ? "" : getShortCanonicalName(cls.getName());
    }

    public static String getShortClassName(Class cls) {
        return cls == null ? "" : getShortClassName(cls.getName());
    }

    public static boolean isAssignable(Class[] clsArr, Class[] clsArr2, boolean z16) {
        if (!ArrayUtils.isSameLength(clsArr, clsArr2)) {
            return false;
        }
        if (clsArr == null) {
            clsArr = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        if (clsArr2 == null) {
            clsArr2 = ArrayUtils.EMPTY_CLASS_ARRAY;
        }
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            if (!isAssignable(clsArr[i3], clsArr2[i3], z16)) {
                return false;
            }
        }
        return true;
    }

    private static void getAllInterfaces(Class cls, List list) {
        while (cls != null) {
            Class<?>[] interfaces = cls.getInterfaces();
            for (int i3 = 0; i3 < interfaces.length; i3++) {
                if (!list.contains(interfaces[i3])) {
                    list.add(interfaces[i3]);
                    getAllInterfaces(interfaces[i3], list);
                }
            }
            cls = cls.getSuperclass();
        }
    }

    public static String getPackageCanonicalName(String str) {
        return getPackageName(getCanonicalName(str));
    }

    public static String getPackageName(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        while (str.charAt(0) == '[') {
            str = str.substring(1);
        }
        if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
            str = str.substring(1);
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    public static String getShortCanonicalName(String str) {
        return getShortClassName(getCanonicalName(str));
    }

    public static String getShortClassName(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StrBuilder strBuilder = new StrBuilder();
        if (str.startsWith("[")) {
            while (str.charAt(0) == '[') {
                str = str.substring(1);
                strBuilder.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            if (str.charAt(0) == 'L' && str.charAt(str.length() - 1) == ';') {
                str = str.substring(1, str.length() - 1);
            }
        }
        Map map = reverseAbbreviationMap;
        if (map.containsKey(str)) {
            str = (String) map.get(str);
        }
        int lastIndexOf = str.lastIndexOf(46);
        int indexOf = str.indexOf(36, lastIndexOf != -1 ? lastIndexOf + 1 : 0);
        String substring = str.substring(lastIndexOf + 1);
        if (indexOf != -1) {
            substring = substring.replace('$', '.');
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(substring);
        stringBuffer.append(strBuilder);
        return stringBuffer.toString();
    }

    public static boolean isAssignable(Class cls, Class cls2) {
        return isAssignable(cls, cls2, false);
    }

    public static Class getClass(ClassLoader classLoader, String str) throws ClassNotFoundException {
        return getClass(classLoader, str, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean isAssignable(Class cls, Class cls2, boolean z16) {
        if (cls2 == 0) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z16) {
            if (cls.isPrimitive() && !cls2.isPrimitive() && (cls = primitiveToWrapper(cls)) == null) {
                return false;
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = wrapperToPrimitive(cls)) == null) {
                return false;
            }
        }
        if (cls.equals(cls2)) {
            return true;
        }
        if (cls.isPrimitive()) {
            if (!cls2.isPrimitive()) {
                return false;
            }
            Class cls3 = Integer.TYPE;
            if (cls3.equals(cls)) {
                return Long.TYPE.equals(cls2) || Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            Class cls4 = Long.TYPE;
            if (cls4.equals(cls)) {
                return Float.TYPE.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                return false;
            }
            Class cls5 = Float.TYPE;
            if (cls5.equals(cls)) {
                return Double.TYPE.equals(cls2);
            }
            if (Character.TYPE.equals(cls)) {
                return cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Short.TYPE.equals(cls)) {
                return cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2);
            }
            if (Byte.TYPE.equals(cls)) {
                return Short.TYPE.equals(cls2) || cls3.equals(cls2) || cls4.equals(cls2) || cls5.equals(cls2) || Double.TYPE.equals(cls2);
            }
            return false;
        }
        return cls2.isAssignableFrom(cls);
    }

    public static Class getClass(String str) throws ClassNotFoundException {
        return getClass(str, true);
    }

    public static Class getClass(String str, boolean z16) throws ClassNotFoundException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            Class cls = class$org$apache$commons$lang$ClassUtils;
            if (cls == null) {
                cls = class$("org.apache.commons.lang.ClassUtils");
                class$org$apache$commons$lang$ClassUtils = cls;
            }
            contextClassLoader = cls.getClassLoader();
        }
        return getClass(contextClassLoader, str, z16);
    }
}
