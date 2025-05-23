package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ac {

    /* renamed from: c, reason: collision with root package name */
    private static volatile ac f388013c;

    /* renamed from: a, reason: collision with root package name */
    private Context f388014a;

    /* renamed from: b, reason: collision with root package name */
    private List<ab> f388015b = new ArrayList();

    ac(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f388014a = applicationContext;
        if (applicationContext == null) {
            this.f388014a = context;
        }
    }

    public static ac b(Context context) {
        if (f388013c == null) {
            synchronized (ac.class) {
                if (f388013c == null) {
                    f388013c = new ac(context);
                }
            }
        }
        return f388013c;
    }

    public int a(String str) {
        synchronized (this.f388015b) {
            ab abVar = new ab();
            abVar.f388012b = str;
            if (this.f388015b.contains(abVar)) {
                for (ab abVar2 : this.f388015b) {
                    if (abVar2.equals(abVar)) {
                        return abVar2.f388011a;
                    }
                }
            }
            return 0;
        }
    }

    public synchronized String c(v vVar) {
        return this.f388014a.getSharedPreferences("mipush_extra", 0).getString(vVar.name(), "");
    }

    public synchronized void d(v vVar, String str) {
        SharedPreferences sharedPreferences = this.f388014a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(vVar.name(), str).apply();
    }

    public void e(String str) {
        synchronized (this.f388015b) {
            ab abVar = new ab();
            abVar.f388011a = 0;
            abVar.f388012b = str;
            if (this.f388015b.contains(abVar)) {
                this.f388015b.remove(abVar);
            }
            this.f388015b.add(abVar);
        }
    }

    public boolean f(String str) {
        synchronized (this.f388015b) {
            ab abVar = new ab();
            abVar.f388012b = str;
            if (this.f388015b.contains(abVar)) {
                return true;
            }
            return false;
        }
    }

    public void g(String str) {
        synchronized (this.f388015b) {
            ab abVar = new ab();
            abVar.f388012b = str;
            if (this.f388015b.contains(abVar)) {
                Iterator<ab> it = this.f388015b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ab next = it.next();
                    if (abVar.equals(next)) {
                        abVar = next;
                        break;
                    }
                }
            }
            abVar.f388011a++;
            this.f388015b.remove(abVar);
            this.f388015b.add(abVar);
        }
    }

    public void h(String str) {
        synchronized (this.f388015b) {
            ab abVar = new ab();
            abVar.f388012b = str;
            if (this.f388015b.contains(abVar)) {
                this.f388015b.remove(abVar);
            }
        }
    }
}
