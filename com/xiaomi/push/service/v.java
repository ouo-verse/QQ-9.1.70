package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import com.xiaomi.push.io;

/* compiled from: P */
/* loaded from: classes28.dex */
public class v {

    /* renamed from: c, reason: collision with root package name */
    private static v f389829c;

    /* renamed from: a, reason: collision with root package name */
    private Context f389830a;

    /* renamed from: b, reason: collision with root package name */
    private int f389831b = 0;

    v(Context context) {
        this.f389830a = context.getApplicationContext();
    }

    public static v c(Context context) {
        if (f389829c == null) {
            f389829c = new v(context);
        }
        return f389829c;
    }

    @SuppressLint({"NewApi"})
    public int a() {
        int i3 = this.f389831b;
        if (i3 != 0) {
            return i3;
        }
        try {
            this.f389831b = Settings.Global.getInt(this.f389830a.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f389831b;
    }

    @SuppressLint({"NewApi"})
    public Uri b() {
        return Settings.Global.getUriFor("device_provisioned");
    }

    public boolean d() {
        String str = io.f389426a;
        if (!str.contains("xmsf") && !str.contains("xiaomi") && !str.contains("miui")) {
            return false;
        }
        return true;
    }
}
