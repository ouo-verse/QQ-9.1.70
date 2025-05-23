package com.qzone.reborn.configx;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J%\u0010\u001e\u001a\u00028\u0000\"\b\b\u0000\u0010\u001b*\u00020\u001a2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u001c\u0012\u0004\u0012\u00020\u001a0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010!\u00a8\u0006%"}, d2 = {"Lcom/qzone/reborn/configx/g;", "", "Lcom/qzone/reborn/configx/i;", "k", "Lcom/qzone/reborn/configx/n;", "l", "Lcom/qzone/reborn/configx/l;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/configx/h;", tl.h.F, "Lcom/qzone/reborn/configx/b;", "g", "Lcom/qzone/reborn/configx/k;", "j", "Lcom/qzone/reborn/configx/e;", "b", "Lcom/qzone/reborn/configx/j;", "i", "Lcom/qzone/reborn/configx/a;", "d", "Lcom/qzone/reborn/configx/f;", "a", "Lcom/qzone/reborn/configx/c;", "e", "Lcom/qzone/reborn/configx/o;", "c", "Lcom/qzone/reborn/configx/d;", "T", "Ljava/lang/Class;", "moduleClass", "f", "(Ljava/lang/Class;)Lcom/qzone/reborn/configx/d;", "", "Ljava/util/Map;", "sConfigModuleMap", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f53821a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Class<? extends d>, d> sConfigModuleMap;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        sConfigModuleMap = linkedHashMap;
        linkedHashMap.put(i.class, new i());
        linkedHashMap.put(n.class, new n());
        linkedHashMap.put(l.class, new l());
        linkedHashMap.put(h.class, new h());
        linkedHashMap.put(k.class, new k());
        linkedHashMap.put(e.class, new e());
        linkedHashMap.put(b.class, new b());
        linkedHashMap.put(a.class, new a());
        linkedHashMap.put(j.class, new j());
        linkedHashMap.put(f.class, new f());
        linkedHashMap.put(c.class, new c());
        linkedHashMap.put(o.class, new o());
    }

    g() {
    }

    public final f a() {
        return (f) f(f.class);
    }

    public final e b() {
        return (e) f(e.class);
    }

    public final o c() {
        return (o) f(o.class);
    }

    public final a d() {
        return (a) f(a.class);
    }

    public final c e() {
        return (c) f(c.class);
    }

    public final <T extends d> T f(Class<T> moduleClass) {
        Intrinsics.checkNotNullParameter(moduleClass, "moduleClass");
        T t16 = (T) sConfigModuleMap.get(moduleClass);
        if (t16 != null) {
            return t16;
        }
        throw new RuntimeException(moduleClass.getName() + " not in sConfigModuleMap, please register!");
    }

    public final b g() {
        return (b) f(b.class);
    }

    public final h h() {
        return (h) f(h.class);
    }

    public final j i() {
        return (j) f(j.class);
    }

    public final k j() {
        return (k) f(k.class);
    }

    public final i k() {
        return (i) f(i.class);
    }

    public final n l() {
        return (n) f(n.class);
    }

    public final l m() {
        return (l) f(l.class);
    }
}
