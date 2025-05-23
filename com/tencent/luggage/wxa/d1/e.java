package com.tencent.luggage.wxa.d1;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f124059a;

    public static void a(String str) {
        f124059a = str;
    }

    public static String a() {
        String str = f124059a;
        if (str != null && !str.isEmpty()) {
            return f124059a;
        }
        return Locale.getDefault().getLanguage();
    }

    public static Context a(Context context) {
        Locale locale = new Locale(a());
        Locale.setDefault(locale);
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(locale);
        return context.createConfigurationContext(configuration);
    }
}
