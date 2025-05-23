package com.tencent.turingcam;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class JUeK5 {
    public static lkZFD a(Context context) {
        LocaleList locales;
        String languageTags;
        lkZFD lkzfd = lkZFD.f382305b;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33) {
            Object systemService = context.getSystemService("locale");
            if (systemService != null) {
                return new lkZFD(new jWEgB(((LocaleManager) systemService).getSystemLocales()));
            }
            return lkzfd;
        }
        Configuration configuration = Resources.getSystem().getConfiguration();
        if (i3 >= 24) {
            locales = configuration.getLocales();
            languageTags = locales.toLanguageTags();
            return lkZFD.a(languageTags);
        }
        return lkZFD.a(configuration.locale.toLanguageTag());
    }
}
