package com.tencent.qqlive.module.videoreport.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BaseUtils {
    private static final String TAG = "BaseUtils";

    public static <T> boolean contains(Collection<T> collection, T t16) {
        if (!isEmpty(collection) && t16 != null) {
            return collection.contains(t16);
        }
        return false;
    }

    @NonNull
    public static <K, V> Map<K, V> copyNonNull(@Nullable Map<K, V> map) {
        return copyTo(map, new HashMap());
    }

    @NonNull
    public static <K, V> Map<K, V> copyTo(@Nullable Map<K, V> map, @NonNull Map<K, V> map2) {
        if (map != null) {
            map2.putAll(map);
        }
        return map2;
    }

    public static String emptyAs(String str, String str2) {
        if (isEmpty(str)) {
            return str2;
        }
        return str;
    }

    public static String getClassSimpleName(Object obj) {
        if (obj == null) {
            return "null";
        }
        return obj.getClass().getSimpleName();
    }

    public static String getErrorStack(Throwable th5) {
        if (th5 == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th5.printStackTrace(printWriter);
        printWriter.close();
        return stringWriter.toString();
    }

    public static <K, V> V getOrDefault(Map<K, V> map, K k3, V v3) {
        if (map == null) {
            return v3;
        }
        V v16 = map.get(k3);
        if (v16 != null) {
            return v16;
        }
        return v3;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static <T> Set<T> newWeakHashSet() {
        return Collections.newSetFromMap(new WeakHashMap());
    }

    public static <T> T nullAs(T t16, T t17) {
        if (t16 == null) {
            return t17;
        }
        return t16;
    }

    public static String readFileFromAssets(Context context, String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open(str);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                Log.v("readAssets", byteArrayOutputStream2);
                try {
                    byteArrayOutputStream.close();
                    inputStream.close();
                } catch (IOException e16) {
                    Log.e(TAG, "exception " + e16);
                }
                return byteArrayOutputStream2;
            } catch (Exception e17) {
                Log.e("readAssets", e17.getMessage());
                try {
                    byteArrayOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                        return "";
                    }
                    return "";
                } catch (IOException e18) {
                    Log.e(TAG, "exception " + e18);
                    return "";
                }
            }
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e19) {
                Log.e(TAG, "exception " + e19);
            }
            throw th5;
        }
    }

    public static <T> int size(Collection<T> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
