package k45;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import i2.b;

/* compiled from: P */
/* loaded from: classes29.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static a f411708c;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f411709a;

    /* renamed from: b, reason: collision with root package name */
    private Context f411710b;

    public a(Context context) {
        this.f411709a = context.getSharedPreferences("HonorAccount", 0);
        this.f411710b = context.getApplicationContext();
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f411708c == null) {
                f411708c = new a(context);
            }
            aVar = f411708c;
        }
        return aVar;
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f411709a;
        if (sharedPreferences != null) {
            str2 = sharedPreferences.getString(str, str2);
        }
        if (str.equals("rkey")) {
            return str2;
        }
        String a16 = b.a(this.f411710b, str2);
        if (!TextUtils.isEmpty(a16)) {
            return a16;
        }
        return str2;
    }

    public void c(String str) {
        SharedPreferences.Editor edit = this.f411709a.edit();
        if (edit != null) {
            edit.remove(str).commit();
        }
    }

    public void d(String str, String str2) {
        SharedPreferences.Editor edit = this.f411709a.edit();
        if (edit != null) {
            edit.putString(str, b.b(this.f411710b, str2)).commit();
        }
    }
}
