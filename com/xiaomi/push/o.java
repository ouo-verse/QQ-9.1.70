package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class o {

    /* renamed from: d, reason: collision with root package name */
    private static volatile o f389463d;

    /* renamed from: a, reason: collision with root package name */
    private Context f389464a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f389465b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private Map<String, Map<String, String>> f389466c = new HashMap();

    o(Context context) {
        this.f389464a = context;
    }

    public static o b(Context context) {
        if (f389463d == null) {
            synchronized (o.class) {
                if (f389463d == null) {
                    f389463d = new o(context);
                }
            }
        }
        return f389463d;
    }

    private synchronized String c(String str, String str2) {
        if (this.f389466c != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f389466c.get(str);
                    if (map != null) {
                        return map.get(str2);
                    }
                    return "";
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    private synchronized void f(String str, String str2, String str3) {
        if (this.f389466c == null) {
            this.f389466c = new HashMap();
        }
        Map<String, String> map = this.f389466c.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f389466c.put(str, map);
    }

    public synchronized String d(String str, String str2, String str3) {
        String c16 = c(str, str2);
        if (!TextUtils.isEmpty(c16)) {
            return c16;
        }
        return this.f389464a.getSharedPreferences(str, 4).getString(str2, str3);
    }

    public synchronized void e(final String str, final String str2, final String str3) {
        f(str, str2, str3);
        this.f389465b.post(new Runnable() { // from class: com.xiaomi.push.o.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = o.this.f389464a.getSharedPreferences(str, 4).edit();
                edit.putString(str2, str3);
                edit.commit();
            }
        });
    }
}
