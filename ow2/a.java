package ow2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ev2.h;
import java.util.Map;
import pw2.i;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f424215a;

    /* renamed from: b, reason: collision with root package name */
    private final String f424216b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str) {
        this.f424216b = TextUtils.isEmpty(str) ? "default_qad_sp_storage" : str;
    }

    private SharedPreferences b() {
        if (this.f424215a == null) {
            this.f424215a = i.l(this.f424216b);
        }
        return this.f424215a;
    }

    @Override // ow2.d
    public <T> T a(String str, Class<T> cls) {
        try {
            SharedPreferences b16 = b();
            if (b16 == null) {
                n.e("QADPrefsStorage", "get, pref == null");
                return null;
            }
            return (T) new Gson().fromJson(b16.getString(str, null), (Class) cls);
        } catch (Throwable th5) {
            n.c("QADPrefsStorage", th5);
            remove(str);
            return null;
        }
    }

    @Override // ow2.d
    public String[] getAllKeys() {
        try {
            SharedPreferences b16 = b();
            if (b16 == null) {
                n.e("QADPrefsStorage", "getAllKeys, pref == null");
                return null;
            }
            String[] a16 = h.a(b16);
            if (a16 == null) {
                Map<String, ?> all = b16.getAll();
                if (all == null) {
                    return null;
                }
                return (String[]) all.keySet().toArray(new String[all.size()]);
            }
            return a16;
        } catch (Throwable th5) {
            n.c("QADPrefsStorage", th5);
            return null;
        }
    }

    @Override // ow2.d
    public <T> void putValue(String str, T t16) {
        try {
            String json = new GsonBuilder().disableHtmlEscaping().create().toJson(t16);
            SharedPreferences b16 = b();
            if (b16 == null) {
                n.e("QADPrefsStorage", "put, pref == null");
            } else {
                b16.edit().putString(str, json).apply();
            }
        } catch (Throwable th5) {
            n.c("QADPrefsStorage", th5);
        }
    }

    @Override // ow2.d
    public void remove(String str) {
        try {
            SharedPreferences b16 = b();
            if (b16 == null) {
                n.e("QADPrefsStorage", "remove, pref == null");
            } else {
                b16.edit().remove(str).apply();
            }
        } catch (Throwable th5) {
            n.c("QADPrefsStorage", th5);
        }
    }
}
