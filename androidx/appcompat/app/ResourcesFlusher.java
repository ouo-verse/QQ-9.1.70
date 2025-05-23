package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    ResourcesFlusher() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void flush(@NonNull Resources resources) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 28) {
            return;
        }
        if (i3 >= 24) {
            flushNougats(resources);
        } else {
            flushMarshmallows(resources);
        }
    }

    @RequiresApi(21)
    private static void flushLollipops(@NonNull Resources resources) {
        Map map;
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e16) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e16);
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field = sDrawableCacheField;
        if (field != null) {
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e17) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e17);
                map = null;
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    @RequiresApi(23)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void flushMarshmallows(@NonNull Resources resources) {
        Object obj;
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e16) {
                Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e16);
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field = sDrawableCacheField;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e17) {
                Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e17);
            }
            if (obj != null) {
                return;
            }
            flushThemedResourcesCache(obj);
            return;
        }
        obj = null;
        if (obj != null) {
        }
    }

    @RequiresApi(24)
    private static void flushNougats(@NonNull Resources resources) {
        Object obj;
        if (!sResourcesImplFieldFetched) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                sResourcesImplField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e16) {
                Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e16);
            }
            sResourcesImplFieldFetched = true;
        }
        Field field = sResourcesImplField;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e17) {
            Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e17);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!sDrawableCacheFieldFetched) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                sDrawableCacheField = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e18) {
                Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e18);
            }
            sDrawableCacheFieldFetched = true;
        }
        Field field2 = sDrawableCacheField;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e19) {
                Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e19);
            }
        }
        if (obj2 != null) {
            flushThemedResourcesCache(obj2);
        }
    }

    @RequiresApi(16)
    private static void flushThemedResourcesCache(@NonNull Object obj) {
        LongSparseArray longSparseArray;
        if (!sThemedResourceCacheClazzFetched) {
            try {
                sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e16) {
                Log.e(TAG, "Could not find ThemedResourceCache class", e16);
            }
            sThemedResourceCacheClazzFetched = true;
        }
        Class<?> cls = sThemedResourceCacheClazz;
        if (cls == null) {
            return;
        }
        if (!sThemedResourceCache_mUnthemedEntriesFieldFetched) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                sThemedResourceCache_mUnthemedEntriesField = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e17) {
                Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e17);
            }
            sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
        }
        Field field = sThemedResourceCache_mUnthemedEntriesField;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e18) {
            Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e18);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
