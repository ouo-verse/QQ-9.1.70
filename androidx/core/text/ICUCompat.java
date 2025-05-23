package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;
    private static Method sGetScriptMethod;

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                sAddLikelySubtagsMethod = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e16) {
                throw new IllegalStateException(e16);
            }
        }
    }

    ICUCompat() {
    }

    private static String addLikelySubtags(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = sAddLikelySubtagsMethod;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e16) {
            Log.w(TAG, e16);
        } catch (InvocationTargetException e17) {
            Log.w(TAG, e17);
        }
        return locale2;
    }

    private static String getScript(String str) {
        try {
            Method method = sGetScriptMethod;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e16) {
            Log.w(TAG, e16);
        } catch (InvocationTargetException e17) {
            Log.w(TAG, e17);
        }
        return null;
    }

    @Nullable
    public static String maximizeAndGetScript(Locale locale) {
        ULocale forLocale;
        ULocale addLikelySubtags;
        String script;
        if (Build.VERSION.SDK_INT >= 24) {
            forLocale = ULocale.forLocale(locale);
            addLikelySubtags = ULocale.addLikelySubtags(forLocale);
            script = addLikelySubtags.getScript();
            return script;
        }
        try {
            return ((Locale) sAddLikelySubtagsMethod.invoke(null, locale)).getScript();
        } catch (IllegalAccessException e16) {
            Log.w(TAG, e16);
            return locale.getScript();
        } catch (InvocationTargetException e17) {
            Log.w(TAG, e17);
            return locale.getScript();
        }
    }
}
