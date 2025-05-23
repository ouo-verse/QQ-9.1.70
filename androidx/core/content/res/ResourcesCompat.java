package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final ThreadLocal<TypedValue> sTempTypedValue = new ThreadLocal<>();
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap<>(0);
    private static final Object sColorStateCacheLock = new Object();

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final ColorStateList mValue;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration) {
            this.mValue = colorStateList;
            this.mConfiguration = configuration;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class ColorStateListCacheKey {
        final Resources mResources;

        @Nullable
        final Resources.Theme mTheme;

        ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.mResources = resources;
            this.mTheme = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            if (this.mResources.equals(colorStateListCacheKey.mResources) && ObjectsCompat.equals(this.mTheme, colorStateListCacheKey.mTheme)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.mResources, this.mTheme);
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int i3, @Nullable Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrievalFailed(i3);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(final Typeface typeface, @Nullable Handler handler) {
            getHandler(handler).post(new Runnable() { // from class: androidx.core.content.res.ResourcesCompat.FontCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    FontCallback.this.onFontRetrieved(typeface);
                }
            });
        }

        public abstract void onFontRetrievalFailed(int i3);

        public abstract void onFontRetrieved(@NonNull Typeface typeface);
    }

    /* compiled from: P */
    @RequiresApi(29)
    /* loaded from: classes.dex */
    static class ImplApi29 {
        ImplApi29() {
        }

        static float getFloat(@NonNull Resources resources, @DimenRes int i3) {
            float f16;
            f16 = resources.getFloat(i3);
            return f16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ThemeCompat {

        /* compiled from: P */
        @RequiresApi(23)
        /* loaded from: classes.dex */
        static class ImplApi23 {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = new Object();

            ImplApi23() {
            }

            static void rebase(@NonNull Resources.Theme theme) {
                synchronized (sRebaseMethodLock) {
                    if (!sRebaseMethodFetched) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            sRebaseMethod = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e16) {
                            Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e16);
                        }
                        sRebaseMethodFetched = true;
                    }
                    Method method = sRebaseMethod;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e17) {
                            Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e17);
                            sRebaseMethod = null;
                        }
                    }
                }
            }
        }

        /* compiled from: P */
        @RequiresApi(29)
        /* loaded from: classes.dex */
        static class ImplApi29 {
            ImplApi29() {
            }

            static void rebase(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                ImplApi29.rebase(theme);
            } else {
                ImplApi23.rebase(theme);
            }
        }
    }

    ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i3, @NonNull ColorStateList colorStateList) {
        synchronized (sColorStateCacheLock) {
            WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = sColorStateCaches;
            SparseArray<ColorStateListCacheEntry> sparseArray = weakHashMap.get(colorStateListCacheKey);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(colorStateListCacheKey, sparseArray);
            }
            sparseArray.append(i3, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.mResources.getConfiguration()));
        }
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i3) {
        ColorStateListCacheEntry colorStateListCacheEntry;
        synchronized (sColorStateCacheLock) {
            SparseArray<ColorStateListCacheEntry> sparseArray = sColorStateCaches.get(colorStateListCacheKey);
            if (sparseArray != null && sparseArray.size() > 0 && (colorStateListCacheEntry = sparseArray.get(i3)) != null) {
                if (colorStateListCacheEntry.mConfiguration.equals(colorStateListCacheKey.mResources.getConfiguration())) {
                    return colorStateListCacheEntry.mValue;
                }
                sparseArray.remove(i3);
            }
            return null;
        }
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context context, @FontRes int i3) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i3, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources resources, @ColorRes int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getColor(i3, theme);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources resources, @ColorRes int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getColorStateList(i3, theme);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources resources, @DrawableRes int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawable(i3, theme);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources resources, @DrawableRes int i3, int i16, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return resources.getDrawableForDensity(i3, i16, theme);
    }

    public static float getFloat(@NonNull Resources resources, @DimenRes int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ImplApi29.getFloat(resources, i3);
        }
        TypedValue typedValue = getTypedValue();
        resources.getValue(i3, typedValue, true);
        if (typedValue.type == 4) {
            return typedValue.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i3) + " type #0x" + Integer.toHexString(typedValue.type) + " is not valid");
    }

    @Nullable
    public static Typeface getFont(@NonNull Context context, @FontRes int i3) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i3, new TypedValue(), 0, null, null, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> threadLocal = sTempTypedValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources resources, int i3, @Nullable Resources.Theme theme) {
        if (isColorInt(resources, i3)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.createFromXml(resources, resources.getXml(i3), theme);
        } catch (Exception e16) {
            Log.e(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e16);
            return null;
        }
    }

    private static boolean isColorInt(@NonNull Resources resources, @ColorRes int i3) {
        TypedValue typedValue = getTypedValue();
        resources.getValue(i3, typedValue, true);
        int i16 = typedValue.type;
        if (i16 >= 28 && i16 <= 31) {
            return true;
        }
        return false;
    }

    private static Typeface loadFont(@NonNull Context context, int i3, TypedValue typedValue, int i16, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z16, boolean z17) {
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue, true);
        Typeface loadFont = loadFont(context, resources, typedValue, i3, i16, fontCallback, handler, z16, z17);
        if (loadFont != null || fontCallback != null || z17) {
            return loadFont;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i3) + " could not be retrieved.");
    }

    public static void getFont(@NonNull Context context, @FontRes int i3, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.checkNotNull(fontCallback);
        if (context.isRestricted()) {
            fontCallback.callbackFailAsync(-4, handler);
        } else {
            loadFont(context, i3, new TypedValue(), 0, fontCallback, handler, false, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface loadFont(@NonNull Context context, Resources resources, TypedValue typedValue, int i3, int i16, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z16, boolean z17) {
        CharSequence charSequence = typedValue.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            if (!charSequence2.startsWith("res/")) {
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            }
            Typeface findFromCache = TypefaceCompat.findFromCache(resources, i3, i16);
            if (findFromCache != null) {
                if (fontCallback != null) {
                    fontCallback.callbackSuccessAsync(findFromCache, handler);
                }
                return findFromCache;
            }
            if (z17) {
                return null;
            }
            try {
                if (charSequence2.toLowerCase().endsWith(".xml")) {
                    FontResourcesParserCompat.FamilyResourceEntry parse = FontResourcesParserCompat.parse(resources.getXml(i3), resources);
                    if (parse == null) {
                        Log.e(TAG, "Failed to find font-family tag");
                        if (fontCallback != null) {
                            fontCallback.callbackFailAsync(-3, handler);
                        }
                        return null;
                    }
                    return TypefaceCompat.createFromResourcesFamilyXml(context, parse, resources, i3, i16, fontCallback, handler, z16);
                }
                Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, i3, charSequence2, i16);
                if (fontCallback != null) {
                    if (createFromResourcesFontFile != null) {
                        fontCallback.callbackSuccessAsync(createFromResourcesFontFile, handler);
                    } else {
                        fontCallback.callbackFailAsync(-3, handler);
                    }
                }
                return createFromResourcesFontFile;
            } catch (IOException e16) {
                Log.e(TAG, "Failed to read xml resource " + charSequence2, e16);
                if (fontCallback != null) {
                    fontCallback.callbackFailAsync(-3, handler);
                }
                return null;
            } catch (XmlPullParserException e17) {
                Log.e(TAG, "Failed to parse xml resource " + charSequence2, e17);
                if (fontCallback != null) {
                }
                return null;
            }
        }
        throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i3) + "\" (" + Integer.toHexString(i3) + ") is not a Font: " + typedValue);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context context, @FontRes int i3, TypedValue typedValue, int i16, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return loadFont(context, i3, typedValue, i16, fontCallback, null, true, false);
    }
}
