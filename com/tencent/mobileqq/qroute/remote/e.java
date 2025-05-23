package com.tencent.mobileqq.qroute.remote;

import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qzone.business.lbsv2.business.entity.PoiListCacheRecord;
import com.tencent.lbssearch.object.param.Geo2AddressParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f276478a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8756);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f276478a = new Class[]{Short.TYPE, Integer.TYPE, Long.TYPE, Double.TYPE, Float.TYPE, Boolean.TYPE, Character.TYPE, Byte.TYPE, String.class, Boolean.class, Parcelable.class, Serializable.class};
        }
    }

    public static void a(@NonNull Class<?> cls, @NonNull Method method) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            return;
        }
        throw new IllegalThreadStateException("IPC Dynamic class " + cls.getName() + "#" + method.getName() + " can't invoke in MainThread");
    }

    public static void b(@NonNull Method method, boolean z16, @Nullable Object[] objArr) {
        if (!method.isAnnotationPresent(QRemote.class)) {
            if (!z16) {
                return;
            }
            QRoute.logger.a("RemoteProxyUtil", f(method) + " has not QRemote annotation");
            throw new IllegalArgumentException(f(method) + " has not QRemote annotation");
        }
        Class<?>[] parameterTypes = method.getParameterTypes();
        int i3 = 0;
        while (true) {
            Object obj = null;
            if (i3 < parameterTypes.length) {
                if (objArr != null) {
                    obj = objArr[i3];
                }
                if (h(parameterTypes[i3], obj)) {
                    i3++;
                } else {
                    QRoute.logger.a("RemoteProxyUtil", f(method) + " has unsupported param:" + parameterTypes[i3].getName());
                    throw new IllegalArgumentException(f(method) + " has unsupported param:" + parameterTypes[i3].getName());
                }
            } else {
                if (!method.getReturnType().equals(Void.TYPE) && !h(method.getReturnType(), null)) {
                    QRoute.logger.a("RemoteProxyUtil", f(method) + " has unsupported return type:" + method.getReturnType());
                    throw new IllegalArgumentException(f(method) + " has unsupported return type:" + method.getReturnType());
                }
                return;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x00e5  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object c(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2) {
        Class<?>[] clsArr;
        Class<?> cls;
        if (str.endsWith("void")) {
            return null;
        }
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1402722386:
                if (str.equals("java.util.HashMap")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1325958191:
                if (str.equals("double")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1114099497:
                if (str.equals("java.util.ArrayList")) {
                    c16 = 2;
                    break;
                }
                break;
            case 104431:
                if (str.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    c16 = 3;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c16 = 4;
                    break;
                }
                break;
            case 3052374:
                if (str.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
                    c16 = 5;
                    break;
                }
                break;
            case 3327612:
                if (str.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                    c16 = 6;
                    break;
                }
                break;
            case 64711720:
                if (str.equals(HippyControllerProps.BOOLEAN)) {
                    c16 = 7;
                    break;
                }
                break;
            case 65821278:
                if (str.equals("java.util.List")) {
                    c16 = '\b';
                    break;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 109413500:
                if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    c16 = '\n';
                    break;
                }
                break;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    c16 = 11;
                    break;
                }
                break;
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    c16 = '\f';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return bundle.getSerializable(str2);
            case 1:
                return Double.valueOf(bundle.getDouble(str2));
            case 2:
            case '\b':
                return e(bundle, str2);
            case 3:
                return Integer.valueOf(bundle.getInt(str2));
            case 4:
                return Byte.valueOf(bundle.getByte(str2));
            case 5:
                return Character.valueOf(bundle.getChar(str2));
            case 6:
                return Long.valueOf(bundle.getLong(str2));
            case 7:
            case 11:
                return Boolean.valueOf(bundle.getBoolean(str2));
            case '\t':
                return Float.valueOf(bundle.getFloat(str2));
            case '\n':
                return Short.valueOf(bundle.getShort(str2));
            case '\f':
                return bundle.getString(str2);
            default:
                try {
                    cls = Class.forName(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                    QRoute.logger.b("RemoteProxyUtil", "getBundleParameter error", e16);
                }
                if (cls.getInterfaces().length > 0) {
                    clsArr = cls.getInterfaces();
                    if (clsArr != null) {
                        for (Class<?> cls2 : clsArr) {
                            if (cls2.isAssignableFrom(Parcelable.class)) {
                                return bundle.getParcelable(str2);
                            }
                            if (cls2.isAssignableFrom(Serializable.class)) {
                                return bundle.getSerializable(str2);
                            }
                            if (cls2.isAssignableFrom(Collection.class)) {
                                return e(bundle, str2);
                            }
                            if (cls2.isAssignableFrom(HashMap.class)) {
                                return bundle.getSerializable(str2);
                            }
                        }
                    }
                    QRoute.logger.a("RemoteProxyUtil", "getBundleParameter unSupportClass=" + str);
                    return null;
                }
                clsArr = null;
                if (clsArr != null) {
                }
                QRoute.logger.a("RemoteProxyUtil", "getBundleParameter unSupportClass=" + str);
                return null;
        }
    }

    public static Class<?> d(@NonNull String str) throws ClassNotFoundException {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1402722386:
                if (str.equals("java.util.HashMap")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1325958191:
                if (str.equals("double")) {
                    c16 = 1;
                    break;
                }
                break;
            case -1114099497:
                if (str.equals("java.util.ArrayList")) {
                    c16 = 2;
                    break;
                }
                break;
            case -361922034:
                if (str.equals("android.os.Parcelable")) {
                    c16 = 3;
                    break;
                }
                break;
            case 104431:
                if (str.equals(PoiListCacheRecord.WEIGHT_TYPE)) {
                    c16 = 4;
                    break;
                }
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c16 = 5;
                    break;
                }
                break;
            case 3052374:
                if (str.equals(WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR)) {
                    c16 = 6;
                    break;
                }
                break;
            case 3327612:
                if (str.equals(PoiListCacheRecord.TIMESTAMP_TYPE)) {
                    c16 = 7;
                    break;
                }
                break;
            case 64711720:
                if (str.equals(HippyControllerProps.BOOLEAN)) {
                    c16 = '\b';
                    break;
                }
                break;
            case 97526364:
                if (str.equals("float")) {
                    c16 = '\t';
                    break;
                }
                break;
            case 109413500:
                if (str.equals(Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT)) {
                    c16 = '\n';
                    break;
                }
                break;
            case 344809556:
                if (str.equals("java.lang.Boolean")) {
                    c16 = 11;
                    break;
                }
                break;
            case 1195259493:
                if (str.equals("java.lang.String")) {
                    c16 = '\f';
                    break;
                }
                break;
            case 1832181019:
                if (str.equals("java.io.Serializable")) {
                    c16 = '\r';
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return HashMap.class;
            case 1:
                return Double.TYPE;
            case 2:
                return ArrayList.class;
            case 3:
                return Parcelable.class;
            case 4:
                return Integer.TYPE;
            case 5:
                return Byte.TYPE;
            case 6:
                return Character.TYPE;
            case 7:
                return Long.TYPE;
            case '\b':
                return Boolean.TYPE;
            case '\t':
                return Float.TYPE;
            case '\n':
                return Short.TYPE;
            case 11:
                return Boolean.class;
            case '\f':
                return String.class;
            case '\r':
                return Serializable.class;
            default:
                return Class.forName(str);
        }
    }

    private static Object e(Bundle bundle, String str) {
        Serializable parcelableArrayList = bundle.getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            parcelableArrayList = bundle.getStringArrayList(str);
        }
        if (parcelableArrayList == null) {
            parcelableArrayList = bundle.getIntegerArrayList(str);
        }
        if (parcelableArrayList == null) {
            parcelableArrayList = bundle.getSerializable(str);
        }
        if (parcelableArrayList == null) {
            QRoute.logger.a("RemoteProxyUtil", "getListObject unSupportList, key=" + str);
        }
        return parcelableArrayList;
    }

    private static String f(@NonNull Method method) {
        return "QRemote Annotation Method " + method.getClass().getName() + "#" + method.getName();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean g(Class<?> cls, Class<?> cls2) {
        try {
            cls.asSubclass(cls2);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public static boolean h(Class<?> cls, @Nullable Object obj) {
        for (Class<?> cls2 : f276478a) {
            if (cls.isAssignableFrom(cls2) || g(cls, cls2)) {
                return true;
            }
        }
        return i(cls, obj);
    }

    private static boolean i(Class<?> cls, @Nullable Object obj) {
        if (!g(cls, List.class)) {
            return false;
        }
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.isEmpty()) {
            return true;
        }
        if (!(list.get(0) instanceof String) && !(list.get(0) instanceof Integer) && !(list.get(0) instanceof Parcelable) && !(obj instanceof Serializable)) {
            return false;
        }
        return true;
    }

    private static void j(Bundle bundle, String str, Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            if (!list.isEmpty()) {
                if (list.get(0) instanceof String) {
                    bundle.putStringArrayList(str, (ArrayList) obj);
                    return;
                }
                if (list.get(0) instanceof Integer) {
                    bundle.putIntegerArrayList(str, (ArrayList) obj);
                    return;
                } else if (list.get(0) instanceof Parcelable) {
                    bundle.putParcelableArrayList(str, (ArrayList) obj);
                    return;
                } else {
                    if (obj instanceof Serializable) {
                        bundle.putSerializable(str, (Serializable) obj);
                        return;
                    }
                    return;
                }
            }
            if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
    }

    public static void k(@NonNull Bundle bundle, @NonNull String str, @NonNull String str2, @NonNull Object obj) {
        if (PoiListCacheRecord.WEIGHT_TYPE.equals(str)) {
            bundle.putInt(str2, ((Integer) obj).intValue());
            return;
        }
        if ("java.lang.String".equals(str)) {
            bundle.putString(str2, (String) obj);
            return;
        }
        if ("java.lang.Boolean".equals(str)) {
            bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
            return;
        }
        if (PoiListCacheRecord.TIMESTAMP_TYPE.equals(str)) {
            bundle.putLong(str2, ((Long) obj).longValue());
            return;
        }
        if ("byte".equals(str)) {
            bundle.putByte(str2, ((Byte) obj).byteValue());
            return;
        }
        if ("double".equals(str)) {
            bundle.putDouble(str2, ((Double) obj).doubleValue());
            return;
        }
        if (Geo2AddressParam.PoiOptions.ADDRESS_FORMAT_SHORT.equals(str)) {
            bundle.putShort(str2, ((Short) obj).shortValue());
            return;
        }
        if ("float".equals(str)) {
            bundle.putFloat(str2, ((Float) obj).floatValue());
            return;
        }
        if (WinkDaTongReportConstant.ElementParamValue.XSJ_EDIT_STICKER_TYPE_CHAR.equals(str)) {
            bundle.putChar(str2, ((Character) obj).charValue());
            return;
        }
        if (HippyControllerProps.BOOLEAN.equals(str)) {
            bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
            return;
        }
        if ("java.util.List".equals(str)) {
            j(bundle, str2, obj);
        } else if (obj instanceof Parcelable) {
            bundle.putParcelable(str2, (Parcelable) obj);
        } else if (obj instanceof Serializable) {
            bundle.putSerializable(str2, (Serializable) obj);
        }
    }

    public static void l(@NonNull Method method, Object[] objArr, Bundle bundle) {
        Class<?>[] parameterTypes = method.getParameterTypes();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < parameterTypes.length; i3++) {
            String name = parameterTypes[i3].getName();
            arrayList.add(name);
            k(bundle, name, "__arg+" + i3 + "__", objArr[i3]);
        }
        bundle.putStringArrayList("__parameterTypes__", arrayList);
    }

    public static void m(@NonNull Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            b(method, false, null);
        }
    }
}
