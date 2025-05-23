package androidx.core.telephony.mbms;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.telephony.mbms.ServiceInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MbmsHelper {
    MbmsHelper() {
    }

    @Nullable
    @SuppressLint({"BanTargetApiAnnotation"})
    @TargetApi(28)
    public static CharSequence getBestNameForService(@NonNull Context context, @NonNull ServiceInfo serviceInfo) {
        LocaleList locales;
        Set namedContentLocales;
        Set namedContentLocales2;
        Locale firstMatch;
        CharSequence nameForLocale;
        if (Build.VERSION.SDK_INT >= 28) {
            locales = context.getResources().getConfiguration().getLocales();
            namedContentLocales = serviceInfo.getNamedContentLocales();
            int size = namedContentLocales.size();
            if (size == 0) {
                return null;
            }
            String[] strArr = new String[size];
            namedContentLocales2 = serviceInfo.getNamedContentLocales();
            Iterator it = namedContentLocales2.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                strArr[i3] = ((Locale) it.next()).toLanguageTag();
                i3++;
            }
            firstMatch = locales.getFirstMatch(strArr);
            if (firstMatch != null) {
                nameForLocale = serviceInfo.getNameForLocale(firstMatch);
                return nameForLocale;
            }
            return null;
        }
        return null;
    }
}
