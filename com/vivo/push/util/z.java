package com.vivo.push.util;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class z extends c {

    /* renamed from: b, reason: collision with root package name */
    private Context f387934b;

    public z(Context context) {
        if (context != null) {
            this.f387934b = context;
            a(context);
        }
    }

    private synchronized void a(Context context) {
        a(context, "com.vivo.push_preferences.appconfig_v1");
    }

    public final String b() {
        String str;
        Context context = this.f387934b;
        String packageName = context.getPackageName();
        Object a16 = ag.a(context, packageName, "com.vivo.push.app_id");
        if (a16 != null) {
            str = a16.toString();
        } else {
            Object a17 = ag.a(context, packageName, "app_id");
            if (a17 == null) {
                str = "";
            } else {
                str = a17.toString();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return b("APP_APPID", "");
        }
        return str;
    }

    public final String c() {
        String str;
        Context context = this.f387934b;
        String packageName = context.getPackageName();
        Object a16 = ag.a(context, packageName, "com.vivo.push.api_key");
        if (a16 != null) {
            str = a16.toString();
        } else {
            Object a17 = ag.a(context, packageName, "api_key");
            if (a17 == null) {
                str = "";
            } else {
                str = a17.toString();
            }
        }
        if (TextUtils.isEmpty(str)) {
            return b("APP_APIKEY", "");
        }
        return str;
    }
}
