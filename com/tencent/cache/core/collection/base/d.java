package com.tencent.cache.core.collection.base;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f98702a;

    /* renamed from: b, reason: collision with root package name */
    public int f98703b;

    /* renamed from: c, reason: collision with root package name */
    public int f98704c;

    /* renamed from: d, reason: collision with root package name */
    public int f98705d;

    /* renamed from: e, reason: collision with root package name */
    public long f98706e;

    /* renamed from: f, reason: collision with root package name */
    public long f98707f;

    /* renamed from: g, reason: collision with root package name */
    public long f98708g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f98709h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public com.tencent.cache.api.c f98710i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.cache.core.bitmap.base.lrucache.b<Object, Integer> f98711j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public final String f98712k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public final String f98713l;

    /* renamed from: m, reason: collision with root package name */
    public final int f98714m;

    public d(@NotNull String business, @NotNull String subBusiness, int i3) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(subBusiness, "subBusiness");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, business, subBusiness, Integer.valueOf(i3));
            return;
        }
        this.f98712k = business;
        this.f98713l = subBusiness;
        this.f98714m = i3;
        this.f98711j = new com.tencent.cache.core.bitmap.base.lrucache.b<>(50);
        System.currentTimeMillis();
        this.f98707f = SystemClock.uptimeMillis();
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f98704c;
    }

    @Nullable
    public final Integer b(@NotNull Object target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Integer) iPatchRedirector.redirect((short) 8, (Object) this, target);
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (com.tencent.cache.core.util.a.a(target)) {
            return null;
        }
        try {
            return this.f98711j.e(target);
        } catch (Exception e16) {
            com.tencent.cache.core.util.b.f98833f.b("CacheInfo", 1, "getFromSizeCache fail", e16);
            return null;
        }
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return this.f98708g;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f98705d;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return SystemClock.uptimeMillis() - this.f98707f;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f98704c + this.f98705d + this.f98702a + this.f98703b;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.f98707f = SystemClock.uptimeMillis();
        if (this.f98706e == 0) {
            this.f98706e = System.currentTimeMillis();
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("HashMapInfo{, capacity=");
        a16.append(this.f98714m);
        a16.append(", putCount=");
        a16.append(this.f98702a);
        a16.append(", removeCount=");
        a16.append(this.f98703b);
        a16.append(", hitCount=");
        a16.append(this.f98704c);
        a16.append(", missCount=");
        a16.append(this.f98705d);
        a16.append(", mMemorySize=");
        a16.append(this.f98708g);
        a16.append('}');
        return a16.toString();
    }
}
