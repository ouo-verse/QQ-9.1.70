package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ConfigurationCompat {
    ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        LocaleList locales;
        if (Build.VERSION.SDK_INT >= 24) {
            locales = configuration.getLocales();
            return LocaleListCompat.wrap(locales);
        }
        return LocaleListCompat.create(configuration.locale);
    }
}
