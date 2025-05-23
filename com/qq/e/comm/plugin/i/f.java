package com.qq.e.comm.plugin.i;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.i.c;
import com.qq.e.comm.plugin.i.d.c;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f39534a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f39535b = false;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f39536c = false;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f39537d = false;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, com.qq.e.comm.plugin.i.d.c> f39538e;

    /* renamed from: f, reason: collision with root package name */
    private c f39539f;

    /* renamed from: g, reason: collision with root package name */
    private com.qq.e.comm.plugin.i.b.a f39540g;

    /* renamed from: h, reason: collision with root package name */
    private volatile g f39541h;

    f(Context context) {
        a(context, new c.a().a(15).b(com.qq.e.comm.plugin.j.c.a("splash_preload_material_shard_download_count", 3)).a());
        this.f39538e = new ConcurrentHashMap();
    }

    public static f a(Context context) {
        if (f39534a == null) {
            synchronized (f.class) {
                if (f39534a == null) {
                    f39534a = new f(context);
                }
            }
        }
        return f39534a;
    }

    private boolean b() {
        return this.f39535b;
    }

    private boolean c() {
        return this.f39536c;
    }

    private boolean d() {
        return this.f39537d;
    }

    private boolean b(String str) {
        com.qq.e.comm.plugin.i.d.c cVar;
        if (TextUtils.isEmpty(str) || !this.f39538e.containsKey(str) || (cVar = this.f39538e.get(str)) == null) {
            return true;
        }
        if (cVar instanceof com.qq.e.comm.plugin.i.core.d) {
            return ((com.qq.e.comm.plugin.i.core.d) cVar).d();
        }
        GDTLogger.e("Downloader type error!");
        return true;
    }

    private void c(String str) {
        if (this.f39541h != null) {
            this.f39541h.a(str);
        }
    }

    private void a(Context context, c cVar) {
        if (cVar.a() <= cVar.b()) {
            this.f39540g = com.qq.e.comm.plugin.i.b.a.a(context);
            this.f39539f = cVar;
            return;
        }
        throw new IllegalArgumentException("download thread number must < max download number");
    }

    public void a(h hVar, String str, a aVar) {
        a(hVar, str, this.f39539f, aVar);
    }

    public void a(h hVar, String str, c cVar, a aVar) {
        if (b()) {
            a(aVar);
            return;
        }
        if (hVar.f39560a == 1 && c()) {
            a(aVar);
            return;
        }
        if (hVar.f39560a == 2 && d()) {
            a(aVar);
            return;
        }
        String a16 = a(str);
        if (b(a16)) {
            com.qq.e.comm.plugin.i.d.c cVar2 = this.f39538e.get(a16);
            if (cVar2 == null) {
                cVar2 = new com.qq.e.comm.plugin.i.core.d(hVar, this.f39540g, a16, cVar, this, aVar);
                this.f39538e.put(a16, cVar2);
            } else if (cVar2 instanceof com.qq.e.comm.plugin.i.core.d) {
                ((com.qq.e.comm.plugin.i.core.d) cVar2).a(aVar);
            }
            cVar2.f();
            return;
        }
        if (this.f39541h == null) {
            synchronized (this) {
                if (this.f39541h == null) {
                    this.f39541h = new g();
                }
            }
        }
        this.f39541h.a(hVar, a16, aVar);
    }

    private void a(a aVar) {
        GDTLogger.i("notAllowDownload :" + this.f39535b);
        if (aVar != null) {
            aVar.a(new d(-99, "\u5f53\u524d\u72b6\u6001\u4e0d\u5141\u8bb8\u4e0b\u8f7d\u7d20\u6750"), false);
        } else {
            GDTLogger.e("callbackFail wrong with null callback!");
        }
    }

    public void a(boolean z16) {
        GDTLogger.i("setNotAllowDownload :" + z16);
        this.f39535b = z16;
    }

    public void a() {
        for (com.qq.e.comm.plugin.i.d.c cVar : this.f39538e.values()) {
            if (cVar != null && cVar.a()) {
                cVar.g();
            }
        }
    }

    public static String a(String str) throws NullPointerException {
        if (TextUtils.isEmpty(str)) {
            GDTLogger.e("create tag but it's empty!");
            return "";
        }
        return String.valueOf(str.hashCode());
    }

    @Override // com.qq.e.comm.plugin.i.d.c.a
    public void a(String str, com.qq.e.comm.plugin.i.d.c cVar) {
        Map<String, com.qq.e.comm.plugin.i.d.c> map = this.f39538e;
        if (map != null && map.containsKey(str)) {
            this.f39538e.remove(str);
        }
        Map<String, com.qq.e.comm.plugin.i.d.c> map2 = this.f39538e;
        if (map2 != null && map2.isEmpty()) {
            this.f39540g.a();
        }
        c(str);
    }

    @Override // com.qq.e.comm.plugin.i.d.c.a
    public void a(int i3, h hVar, e eVar, d dVar) {
        if (this.f39541h != null) {
            this.f39541h.a(i3, hVar, eVar, dVar);
        }
    }
}
