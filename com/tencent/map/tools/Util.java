package com.tencent.map.tools;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.internal.tb;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Util {
    private static final boolean DEBUG = false;
    private static final int DEFAUlT_GlEsVersion = 65537;
    private static final String DUID_FILE_NAME = "txlbs_duid";
    private static final String DUID_KEY = "txlbs_key_duid";
    public static final String META_NAME_API_KEY = "TencentMapSDK";
    public static final int SMALL_SCREEN_THRESHOLD = 400;
    private static final String SUID_FILE_NAME = "txlbs_suid";
    private static final String SUID_KEY = "txlbs_key_suid";
    private static final String TAG = "Util";

    public static boolean equals(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || !obj.equals(obj2)) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static String filterBuilder(String... strArr) {
        if (strArr != null) {
            String str = "category=";
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (i3 == 0) {
                    str = str + strArr[i3];
                } else {
                    str = str + "," + strArr[i3];
                }
            }
            return str;
        }
        return "";
    }

    public static Class findClass(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field findField(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            if (cls.getSuperclass() != Object.class) {
                return findField(cls.getSuperclass(), str);
            }
            return null;
        }
    }

    public static Method findMethod(Class cls, String str, Class[] clsArr) {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            if (cls.getSuperclass() != Object.class) {
                return findMethod(cls.getSuperclass(), str, clsArr);
            }
            return null;
        }
    }

    public static <T> void foreach(Iterable<T> iterable, Callback<T> callback) {
        if (iterable == null || callback == null) {
            return;
        }
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            callback.callback(it.next());
        }
    }

    public static String getAppName(Context context) {
        String rawAppName = getRawAppName(context);
        try {
            return URLEncoder.encode(rawAppName, "utf-8");
        } catch (Exception unused) {
            return rawAppName;
        }
    }

    public static String getAppVersion(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0);
            return packageInfo.versionName + packageInfo.versionCode;
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static float getDensity(Context context) {
        if (context == null) {
            return 1.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static String getDuid(Context context) {
        if (context == null) {
            return "";
        }
        return getDuidFromSharePrerences(context);
    }

    private static String getDuidFromSharePrerences(Context context) {
        String sharePreference = getSharePreference(context, DUID_FILE_NAME, DUID_KEY);
        if (TextUtils.isEmpty(sharePreference)) {
            String a16 = tb.a(context);
            saveSharePreference(context, DUID_FILE_NAME, DUID_KEY, a16);
            return a16;
        }
        return sharePreference;
    }

    public static Object getField(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Class<?> cls = obj.getClass();
            if (obj instanceof Class) {
                cls = (Class) obj;
            }
            Field findField = findField(cls, str);
            if (findField != null) {
                findField.setAccessible(true);
                return findField.get(obj);
            }
        } catch (IllegalAccessException unused) {
        }
        return null;
    }

    public static String getMD5String(String str) {
        return TextUtils.isEmpty(str) ? "" : getMD5String(str.getBytes());
    }

    public static String getMetaKey(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        if (context == null) {
            return "";
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return "";
        }
        return bundle.getString(str);
    }

    public static int getOpenglesVersion(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            return deviceConfigurationInfo.reqGlEsVersion;
        }
        return 65537;
    }

    public static String getProcessName(int i3) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i3 + "/cmdline"));
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                readLine = readLine.trim();
            }
            try {
                bufferedReader.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return readLine;
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        }
    }

    public static String getRawAppName(Context context) {
        ApplicationInfo applicationInfo;
        CharSequence charSequence;
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            charSequence = applicationInfo.loadLabel(packageManager);
        } else {
            charSequence = "can't find app name";
        }
        return charSequence.toString();
    }

    public static String getResolution(Context context) {
        if (context == null) {
            return "";
        }
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getSharePreference(Context context, String str, String str2) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String getSuid(Context context) {
        if (context == null) {
            return "";
        }
        return getSuidFromSharePrerences(context);
    }

    private static String getSuidFromSharePrerences(Context context) {
        String sharePreference = getSharePreference(context, SUID_FILE_NAME, SUID_KEY);
        if (TextUtils.isEmpty(sharePreference)) {
            String uuid = getUUID();
            saveSharePreference(context, SUID_FILE_NAME, SUID_KEY, uuid);
            return uuid;
        }
        return sharePreference;
    }

    public static String getUUID() {
        try {
            return UUID.randomUUID().toString();
        } catch (Exception unused) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(System.currentTimeMillis());
            return sb5.toString();
        }
    }

    public static int getWindowHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWindowWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int hash(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        if (obj == null) {
            return null;
        }
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i3 = 0; i3 < length; i3++) {
            clsArr[i3] = objArr[i3].getClass();
        }
        try {
            Method findMethod = findMethod(obj.getClass(), str, clsArr);
            if (findMethod != null) {
                findMethod.setAccessible(true);
                return findMethod.invoke(obj, objArr);
            }
        } catch (IllegalAccessException unused) {
        } catch (InvocationTargetException e16) {
            throw new RuntimeException(e16.getTargetException());
        }
        return null;
    }

    public static Object invokeStaticMethod(Class cls, String str, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            return null;
        }
        try {
            Method findMethod = findMethod(cls, str, clsArr);
            if (findMethod != null) {
                findMethod.setAccessible(true);
                return findMethod.invoke(cls, objArr);
            }
        } catch (IllegalAccessException unused) {
        } catch (InvocationTargetException e16) {
            throw new RuntimeException(e16.getTargetException());
        }
        return null;
    }

    private static boolean isMatchClassTypes(Class<?>[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < clsArr.length; i16++) {
            if (clsArr[i16] == objArr[i16].getClass() || clsArr[i16].isAssignableFrom(objArr[i16].getClass())) {
                i3++;
            }
        }
        if (i3 != clsArr.length) {
            return false;
        }
        return true;
    }

    public static <T> List<T> listWhere(Iterable<T> iterable, Condition<T> condition) {
        List<T> emptyList = Collections.emptyList();
        if (iterable != null && condition != null) {
            for (T t16 : iterable) {
                if (condition.callback((Condition<T>) t16).booleanValue()) {
                    emptyList.add(t16);
                }
            }
        }
        return emptyList;
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        if (cls != null && !cls.isEnum() && !cls.isInterface() && !cls.isAnnotation() && !cls.isArray()) {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            for (int i3 = 0; i3 < declaredConstructors.length; i3++) {
                if (isMatchClassTypes(declaredConstructors[i3].getParameterTypes(), objArr)) {
                    try {
                        declaredConstructors[i3].setAccessible(true);
                        return (T) declaredConstructors[i3].newInstance(objArr);
                    } catch (IllegalAccessException | InstantiationException unused) {
                        continue;
                    } catch (InvocationTargetException e16) {
                        throw new RuntimeException(e16.getTargetException());
                    }
                }
            }
            try {
                return cls.newInstance();
            } catch (IllegalAccessException unused2) {
            } catch (InstantiationException e17) {
                throw new RuntimeException(e17);
            }
        }
        return null;
    }

    public static void saveSharePreference(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    public static void setField(Object obj, String str, Object obj2) {
        if (obj == null) {
            return;
        }
        try {
            Field findField = findField(obj.getClass(), str);
            if (findField != null) {
                findField.setAccessible(true);
                findField.set(obj, obj2);
            }
        } catch (IllegalAccessException unused) {
        }
    }

    public static <T> T singleWhere(Iterable<T> iterable, Condition<T> condition) {
        if (iterable != null && condition != null) {
            for (T t16 : iterable) {
                if (condition.callback((Condition<T>) t16).booleanValue()) {
                    return t16;
                }
            }
        }
        return null;
    }

    public static <T> boolean where(Iterable<T> iterable, ReturnCallback<Boolean, T> returnCallback) {
        if (iterable != null && returnCallback != null) {
            Iterator<T> it = iterable.iterator();
            while (it.hasNext()) {
                if (returnCallback.callback(it.next()).booleanValue()) {
                    return true;
                }
            }
            returnCallback.callback(null);
        }
        return false;
    }

    public static <T> Class<? extends T> findClass(String str, Class<T> cls, ClassLoader classLoader) {
        try {
            Class<? extends T> cls2 = (Class<? extends T>) Class.forName(str, false, classLoader);
            if (cls.isAssignableFrom(cls2)) {
                return cls2;
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static <T> void foreach(T[] tArr, Callback<T> callback) {
        if (tArr == null || callback == null) {
            return;
        }
        for (T t16 : tArr) {
            callback.callback(t16);
        }
    }

    public static String getMD5String(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr2 = new char[32];
            int i3 = 0;
            for (int i16 = 0; i16 < 16; i16++) {
                byte b16 = digest[i16];
                int i17 = i3 + 1;
                cArr2[i3] = cArr[(b16 >>> 4) & 15];
                i3 = i17 + 1;
                cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
            }
            return new String(cArr2);
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static <T> boolean where(T[] tArr, ReturnCallback<Boolean, T> returnCallback) {
        if (tArr != null && returnCallback != null) {
            for (T t16 : tArr) {
                if (returnCallback.callback(t16).booleanValue()) {
                    return true;
                }
            }
            returnCallback.callback(null);
        }
        return false;
    }

    public static Object invokeMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        if (obj == null) {
            return null;
        }
        try {
            Method findMethod = findMethod(obj.getClass(), str, clsArr);
            if (findMethod != null) {
                findMethod.setAccessible(true);
                return findMethod.invoke(obj, objArr);
            }
        } catch (IllegalAccessException unused) {
        } catch (InvocationTargetException e16) {
            throw new RuntimeException(e16.getTargetException());
        }
        return null;
    }
}
