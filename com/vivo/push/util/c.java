package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected Context f387891a;

    /* renamed from: b, reason: collision with root package name */
    private String f387892b;

    /* renamed from: c, reason: collision with root package name */
    private volatile SharedPreferences f387893c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f387894d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, Long> f387895e = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private HashMap<String, Integer> f387896f = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private HashMap<String, Boolean> f387897g = new HashMap<>();

    public final void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f387892b = str;
            this.f387893c = context.getSharedPreferences(str, 0);
            this.f387891a = context;
            List<String> b16 = b("local_iv");
            if (b16 != null && b16.size() >= 4) {
                HashMap hashMap = new HashMap();
                hashMap.put("com.vivo.push.secure_sub_iv", b16.get(1));
                hashMap.put("com.vivo.push.secure_sub_key", b16.get(2));
                hashMap.put("com.vivo.push.secure_cache_iv", b16.get(3));
                hashMap.put("com.vivo.push.secure_cache_key", b16.get(0));
                a(hashMap);
                return;
            }
            u.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        throw new RuntimeException("sharedFileName can't be null");
    }

    public final String b(String str, String str2) {
        String str3 = this.f387894d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f387893c != null) {
            str3 = this.f387893c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f387894d.put(str, str3);
            }
        }
        return str3;
    }

    public final int b(String str, int i3) {
        Integer num = this.f387896f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f387893c != null) {
            num = Integer.valueOf(this.f387893c.getInt(str, i3));
            if (!num.equals(Integer.valueOf(i3))) {
                this.f387896f.put(str, num);
            }
        }
        return num.intValue();
    }

    public final void a(String str, String str2) {
        this.f387894d.put(str, str2);
        b();
        if (this.f387893c != null) {
            SharedPreferences.Editor edit = this.f387893c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final long b(String str, long j3) {
        Long l3 = this.f387895e.get(str);
        if (l3 != null) {
            return l3.longValue();
        }
        b();
        if (this.f387893c != null) {
            l3 = Long.valueOf(this.f387893c.getLong(str, j3));
            if (!l3.equals(Long.valueOf(j3))) {
                this.f387895e.put(str, l3);
            }
        }
        return l3.longValue();
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f387893c != null) {
                SharedPreferences.Editor edit = this.f387893c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f387894d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private synchronized void b() {
        if (this.f387893c == null) {
            Context context = this.f387891a;
            if (context != null) {
                this.f387893c = context.getSharedPreferences(this.f387892b, 0);
            } else {
                throw new RuntimeException("SharedPreferences is not init", new Throwable());
            }
        }
    }

    private List<String> b(String str) {
        Object a16;
        String[] split;
        if (this.f387891a == null) {
            u.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.f387891a;
            a16 = ag.a(context, context.getPackageName(), str);
        } catch (Exception e16) {
            u.c("BaseSharePreference", " parsLocalIv error e =" + e16.getMessage());
            e16.printStackTrace();
        }
        if (a16 == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a16.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final void a(String str, int i3) {
        this.f387896f.put(str, Integer.valueOf(i3));
        b();
        if (this.f387893c != null) {
            SharedPreferences.Editor edit = this.f387893c.edit();
            edit.putInt(str, i3);
            a(edit);
        }
    }

    public final void a(String str, long j3) {
        this.f387895e.put(str, Long.valueOf(j3));
        b();
        if (this.f387893c != null) {
            SharedPreferences.Editor edit = this.f387893c.edit();
            edit.putLong(str, j3);
            a(edit);
        }
    }

    public final void a(String str) {
        this.f387895e.remove(str);
        this.f387896f.remove(str);
        this.f387897g.remove(str);
        this.f387894d.remove(str);
        b();
        if (this.f387893c != null) {
            SharedPreferences.Editor edit = this.f387893c.edit();
            if (this.f387893c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f387895e.clear();
        this.f387896f.clear();
        this.f387897g.clear();
        this.f387894d.clear();
        b();
        if (this.f387893c != null) {
            SharedPreferences.Editor edit = this.f387893c.edit();
            edit.clear();
            a(edit);
        }
    }
}
