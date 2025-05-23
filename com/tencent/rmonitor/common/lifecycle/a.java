package com.tencent.rmonitor.common.lifecycle;

import android.app.Activity;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: j, reason: collision with root package name */
    private static final a f365473j = new a();

    /* renamed from: g, reason: collision with root package name */
    private final String[] f365480g;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f365476c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f365477d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f365478e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f365479f = "";

    /* renamed from: h, reason: collision with root package name */
    private int f365481h = -1;

    /* renamed from: i, reason: collision with root package name */
    private String f365482i = "";

    /* renamed from: a, reason: collision with root package name */
    private final CopyOnWriteArraySet<c> f365474a = new CopyOnWriteArraySet<>();

    /* renamed from: b, reason: collision with root package name */
    private final CopyOnWriteArraySet<d> f365475b = new CopyOnWriteArraySet<>();

    protected a() {
        String[] strArr = new String[10];
        this.f365480g = strArr;
        Arrays.fill(strArr, "");
    }

    public static String e() {
        return i().j();
    }

    public static String f() {
        return i().g();
    }

    public static a i() {
        return f365473j;
    }

    protected void a(String str) {
        int i3 = this.f365481h;
        if (i3 >= 0 && TextUtils.equals(str, this.f365480g[i3])) {
            return;
        }
        int i16 = (this.f365481h + 1) % 10;
        this.f365481h = i16;
        this.f365480g[i16] = str;
    }

    protected void b() {
        String g16 = g();
        if (!TextUtils.equals(g16, this.f365482i)) {
            this.f365482i = g16;
            Iterator<d> it = this.f365475b.iterator();
            while (it.hasNext()) {
                it.next().onSceneChanged(g16);
            }
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f365479f = str;
        a(str);
        Iterator<c> it = this.f365474a.iterator();
        while (it.hasNext()) {
            it.next().c(str);
        }
        b();
    }

    public void d(String str) {
        if (str == null || str.equals(this.f365479f)) {
            this.f365479f = "";
            if (!TextUtils.isEmpty(this.f365478e)) {
                a(this.f365478e);
            }
            Iterator<c> it = this.f365474a.iterator();
            while (it.hasNext()) {
                it.next().a(str);
            }
            b();
        }
    }

    protected String g() {
        String h16 = h();
        if (TextUtils.isEmpty(h16)) {
            return j();
        }
        return h16;
    }

    public String h() {
        return this.f365479f;
    }

    public String j() {
        return this.f365477d;
    }

    protected boolean k() {
        return !TextUtils.isEmpty(this.f365479f);
    }

    public void l(Activity activity) {
        WeakReference<Activity> weakReference = this.f365476c;
        if (activity != null) {
            if (weakReference == null || weakReference.get() != activity) {
                this.f365476c = new WeakReference<>(activity);
                this.f365478e = activity.getClass().getName();
                this.f365477d = activity.getClass().getSimpleName();
                if (!k()) {
                    a(this.f365478e);
                }
                b();
            }
        }
    }

    public void m(c cVar) {
        this.f365474a.add(cVar);
    }

    public void n(d dVar) {
        this.f365475b.add(dVar);
    }

    public void o(c cVar) {
        this.f365474a.remove(cVar);
    }
}
