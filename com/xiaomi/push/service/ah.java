package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.gk;
import com.xiaomi.push.gl;
import com.xiaomi.push.iq;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ah {

    /* renamed from: d, reason: collision with root package name */
    private static volatile ah f389589d;

    /* renamed from: a, reason: collision with root package name */
    protected SharedPreferences f389590a;

    /* renamed from: b, reason: collision with root package name */
    protected SharedPreferences f389591b;

    /* renamed from: c, reason: collision with root package name */
    private HashSet<a> f389592c = new HashSet<>();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static abstract class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private int f389593d;

        /* renamed from: e, reason: collision with root package name */
        private String f389594e;

        public a(int i3, String str) {
            this.f389593d = i3;
            this.f389594e = str;
        }

        protected abstract void e();

        public boolean equals(Object obj) {
            if (!(obj instanceof a) || this.f389593d != ((a) obj).f389593d) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f389593d;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e();
        }
    }

    ah(Context context) {
        this.f389590a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f389591b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public static ah d(Context context) {
        if (f389589d == null) {
            synchronized (ah.class) {
                if (f389589d == null) {
                    f389589d = new ah(context);
                }
            }
        }
        return f389589d;
    }

    private String e(int i3) {
        return "oc_" + i3;
    }

    private String g(gl glVar) {
        return "oc_version_" + glVar.a();
    }

    private void i(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(e(gk.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.aa.a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public int a(int i3, int i16) {
        try {
            String e16 = e(i3);
            if (this.f389591b.contains(e16)) {
                return this.f389591b.getInt(e16, 0);
            }
            if (this.f389590a.contains(e16)) {
                return this.f389590a.getInt(e16, 0);
            }
            return i16;
        } catch (Exception e17) {
            jz4.c.m(i3 + " oc int error " + e17);
            return i16;
        }
    }

    public int b(gl glVar, int i3) {
        try {
            return this.f389590a.getInt(g(glVar), i3);
        } catch (Exception e16) {
            jz4.c.m(glVar + " version error " + e16);
            return i3;
        }
    }

    public long c(int i3, long j3) {
        try {
            String e16 = e(i3);
            if (this.f389591b.contains(e16)) {
                return this.f389591b.getLong(e16, 0L);
            }
            if (this.f389590a.contains(e16)) {
                return this.f389590a.getLong(e16, 0L);
            }
            return j3;
        } catch (Exception e17) {
            jz4.c.m(i3 + " oc long error " + e17);
            return j3;
        }
    }

    public String f(int i3, String str) {
        try {
            String e16 = e(i3);
            if (this.f389591b.contains(e16)) {
                return this.f389591b.getString(e16, null);
            }
            if (this.f389590a.contains(e16)) {
                return this.f389590a.getString(e16, null);
            }
            return str;
        } catch (Exception e17) {
            jz4.c.m(i3 + " oc string error " + e17);
            return str;
        }
    }

    public synchronized void h() {
        this.f389592c.clear();
    }

    public synchronized void j(a aVar) {
        if (!this.f389592c.contains(aVar)) {
            this.f389592c.add(aVar);
        }
    }

    public void k(List<Pair<Integer, Object>> list) {
        if (iq.a(list)) {
            return;
        }
        SharedPreferences.Editor edit = this.f389591b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String e16 = e(((Integer) obj).intValue());
                if (pair.second == null) {
                    edit.remove(e16);
                } else {
                    i(edit, pair, e16);
                }
            }
        }
        edit.apply();
    }

    public void l(List<Pair<gl, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (!iq.a(list) && !iq.a(list2)) {
            SharedPreferences.Editor edit = this.f389590a.edit();
            edit.clear();
            for (Pair<gl, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    edit.putInt(g((gl) obj), ((Integer) pair.second).intValue());
                }
            }
            for (Pair<Integer, Object> pair2 : list2) {
                Object obj2 = pair2.first;
                if (obj2 != null && pair2.second != null) {
                    i(edit, pair2, e(((Integer) obj2).intValue()));
                }
            }
            edit.apply();
            return;
        }
        jz4.c.m("not update oc, because versions or configs are empty");
    }

    public boolean m(int i3, boolean z16) {
        try {
            String e16 = e(i3);
            if (this.f389591b.contains(e16)) {
                return this.f389591b.getBoolean(e16, false);
            }
            if (this.f389590a.contains(e16)) {
                return this.f389590a.getBoolean(e16, false);
            }
            return z16;
        } catch (Exception e17) {
            jz4.c.m(i3 + " oc boolean error " + e17);
            return z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        jz4.c.z("OC_Callback : receive new oc data");
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f389592c);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }
}
