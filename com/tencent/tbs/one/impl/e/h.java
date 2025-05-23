package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneManager;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final Context f375048a;

    /* renamed from: b, reason: collision with root package name */
    public final String f375049b;

    /* renamed from: c, reason: collision with root package name */
    final File f375050c;

    /* renamed from: d, reason: collision with root package name */
    public final b f375051d = new b(this);

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f375052e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    final Map<String, com.tencent.tbs.one.impl.c.b> f375053f = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Map<String, List<com.tencent.tbs.one.impl.common.g>> f375054g = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    public volatile TBSOneManager.Policy f375055h = TBSOneManager.Policy.AUTO;

    /* renamed from: i, reason: collision with root package name */
    public volatile boolean f375056i = false;

    /* renamed from: j, reason: collision with root package name */
    volatile long f375057j = 86400000;

    /* renamed from: k, reason: collision with root package name */
    volatile boolean f375058k = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f375059l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f375060m = false;

    /* renamed from: n, reason: collision with root package name */
    public TBSOneDelegate f375061n;

    /* renamed from: o, reason: collision with root package name */
    public com.tencent.tbs.one.impl.common.d f375062o;

    /* renamed from: p, reason: collision with root package name */
    public com.tencent.tbs.one.impl.a.b<com.tencent.tbs.one.impl.common.d> f375063p;

    public h(Context context, String str) {
        if (context.getApplicationContext() != null) {
            this.f375048a = context.getApplicationContext();
        } else {
            this.f375048a = context;
        }
        this.f375049b = str;
        File a16 = com.tencent.tbs.one.impl.common.f.a(context.getDir("tbs", 0), str);
        this.f375050c = a16;
        com.tencent.tbs.one.impl.a.d.e(a16);
        com.tencent.tbs.one.impl.a.d.e(com.tencent.tbs.one.impl.common.f.d(a16));
    }

    private com.tencent.tbs.one.impl.c.b i(String str) {
        com.tencent.tbs.one.impl.c.b bVar = this.f375053f.get(str);
        if (bVar == null) {
            com.tencent.tbs.one.impl.c.b bVar2 = new com.tencent.tbs.one.impl.c.b(this, str);
            this.f375053f.put(str, bVar2);
            return bVar2;
        }
        return bVar;
    }

    public TBSOneManager.Policy a() {
        return this.f375055h;
    }

    public boolean b(String str) {
        return true;
    }

    public TBSOneOnlineService c() {
        return null;
    }

    public TBSOneDebugger d() {
        return null;
    }

    public void e() {
    }

    public final com.tencent.tbs.one.impl.c.a f(String str) {
        com.tencent.tbs.one.impl.c.b e16 = e(str);
        if (e16 == null) {
            return null;
        }
        return e16.f374740j;
    }

    public final Object g(String str) {
        return this.f375052e.get(str);
    }

    public boolean h(String str) {
        return false;
    }

    public void a(boolean z16) {
        this.f375056i = z16;
    }

    public final boolean b() {
        TBSOneManager.Policy a16 = a();
        return (a16 == TBSOneManager.Policy.BUILTIN_ONLY || a16 == TBSOneManager.Policy.LOCAL_ONLY) ? false : true;
    }

    public int[] c(String str) {
        return new int[]{-1};
    }

    public final void d(String str) {
        com.tencent.tbs.one.impl.c.b e16 = e(str);
        if (e16 != null) {
            e16.b();
        }
    }

    public final com.tencent.tbs.one.impl.c.b e(String str) {
        return this.f375053f.get(str);
    }

    public final File a(String str) {
        return com.tencent.tbs.one.impl.common.f.b(this.f375050c, str);
    }

    public final File a(String str, int i3) {
        return new File(com.tencent.tbs.one.impl.common.f.b(this.f375050c, str), String.valueOf(i3));
    }

    public void b(String str, Bundle bundle, TBSOneCallback<File> tBSOneCallback) {
        i(str).a(bundle, tBSOneCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(e<com.tencent.tbs.one.impl.common.d> eVar) {
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManager] Finish loading DEPS#%d from %s", this.f375049b, Integer.valueOf(eVar.f375021b.f374824b), eVar.f375020a);
        this.f375062o = eVar.f375021b;
    }

    public void a(String str, Bundle bundle, TBSOneCallback<TBSOneComponent> tBSOneCallback) {
        i(str).b(bundle, tBSOneCallback);
    }

    public com.tencent.tbs.one.impl.a.b<e<File>> a(Bundle bundle, d.a aVar, m<e<File>> mVar) {
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManager].installComponent Installing component %s, version: %d", this.f375049b, aVar.f374826a, Integer.valueOf(aVar.f374828c));
        File a16 = a(aVar.f374826a, aVar.f374828c);
        com.tencent.tbs.one.impl.a.d.e(a16);
        com.tencent.tbs.one.impl.e.c.a aVar2 = new com.tencent.tbs.one.impl.e.c.a(this.f375048a, this.f375049b, aVar, a16, bundle, "");
        aVar2.a((m) mVar);
        return aVar2;
    }

    public void a(Bundle bundle, String str, TBSOneCallback<File> tBSOneCallback) {
        i(str).a(bundle, tBSOneCallback);
    }

    public void a(String str, Object obj) {
        if (str == null) {
            com.tencent.tbs.one.impl.common.h.b("TBSOneError", 510).a();
        } else if (obj == null) {
            com.tencent.tbs.one.impl.common.h.b("TBSOneError", 510).a();
        } else {
            this.f375052e.put(str, obj);
        }
    }

    public final boolean a(String str, String str2, boolean z16) {
        String str3 = str + "." + str2;
        if (this.f375052e.containsKey(str3)) {
            Object obj = this.f375052e.get(str3);
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
        }
        if (this.f375052e.containsKey(str2)) {
            Object obj2 = this.f375052e.get(str2);
            if (obj2 instanceof Boolean) {
                return ((Boolean) obj2).booleanValue();
            }
        }
        return z16;
    }

    public com.tencent.tbs.one.impl.a.b<e<com.tencent.tbs.one.impl.common.d>> a(Bundle bundle, m<e<com.tencent.tbs.one.impl.common.d>> mVar) {
        File b16 = com.tencent.tbs.one.impl.common.f.b(this.f375050c);
        com.tencent.tbs.one.impl.a.g.a("[%s] [PolicyManager] Installing DEPS, Policy=BUILTIN_ONLY, Path=%s", this.f375049b, b16.getAbsolutePath());
        com.tencent.tbs.one.impl.e.c.b bVar = new com.tencent.tbs.one.impl.e.c.b(this.f375048a, this.f375049b, b16);
        bVar.a((m) mVar);
        return bVar;
    }
}
