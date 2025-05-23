package com.tencent.cache.api.collection;

import androidx.annotation.NonNull;
import com.tencent.cache.api.Business;
import com.tencent.cache.core.collection.base.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.Map;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a<K, V> implements com.tencent.cache.core.collection.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.cache.core.collection.collector.b f98597d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.cache.core.bitmap.base.lrucache.b<K, V> f98598e;

    /* compiled from: P */
    /* renamed from: com.tencent.cache.api.collection.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1001a extends com.tencent.cache.core.bitmap.base.lrucache.b<K, V> {
        static IPatchRedirector $redirector_;

        public C1001a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, i3);
            }
        }

        @Override // com.tencent.cache.core.bitmap.base.lrucache.b
        public void c(boolean z16, K k3, V v3, V v16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), k3, v3, v16);
                return;
            }
            a.this.c(z16, k3, v3, v16);
            if (z16) {
                com.tencent.cache.core.collection.collector.b bVar = a.this.f98597d;
                bVar.getClass();
                if (v3 != null) {
                    com.tencent.cache.core.size.task.a.D.a(bVar.f98716a, false, v3);
                }
                if (v16 != null) {
                    com.tencent.cache.core.size.task.a.D.a(bVar.f98716a, true, v16);
                }
            }
        }
    }

    public a(Business business, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, business, str, Integer.valueOf(i3));
            return;
        }
        this.f98597d = new com.tencent.cache.core.collection.collector.b(business.name(), str, i3);
        this.f98598e = new C1001a(i3);
        register(business, str);
    }

    public boolean b(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) k3)).booleanValue();
        }
        if (this.f98598e.e(k3) != null) {
            return true;
        }
        return false;
    }

    public void c(boolean z16, K k3, V v3, V v16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), k3, v3, v16);
        }
    }

    @Override // com.tencent.cache.api.b, java.util.AbstractMap, java.util.Map
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            this.f98598e.d();
            this.f98597d.g(false);
        }
    }

    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            clear();
        }
    }

    public V e(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3);
        }
        this.f98597d.c().g();
        return this.f98598e.e(k3);
    }

    public V f(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3, (Object) v3);
        }
        V i3 = this.f98598e.i(k3, v3);
        this.f98597d.f(i3, v3);
        return i3;
    }

    public V g(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (V) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3);
        }
        V j3 = this.f98598e.j(k3);
        this.f98597d.e(j3);
        return j3;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @JvmDefault
    @NotNull
    public d getCacheInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (d) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return getCollector().c();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    @Nullable
    public /* bridge */ /* synthetic */ com.tencent.cache.api.c getCacheListener() {
        return com.tencent.cache.core.collection.base.a.a(this);
    }

    @Override // com.tencent.cache.core.collection.base.b
    @NonNull
    public com.tencent.cache.core.collection.base.c getCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.cache.core.collection.base.c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.f98597d;
    }

    @Override // com.tencent.cache.core.collection.base.b
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return h();
    }

    @Override // com.tencent.cache.core.collection.base.b
    public String getItemType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (this.f98598e.n() == 0) {
            return GlobalUtil.DEF_STRING;
        }
        V value = this.f98598e.p().entrySet().iterator().next().getValue();
        if (value == null) {
            return "null";
        }
        return value.getClass().getName();
    }

    @Override // com.tencent.cache.api.b
    @JvmDefault
    public long getMemorySize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return getCacheInfo().f98708g;
    }

    @Override // com.tencent.cache.core.collection.base.b
    @NonNull
    public com.tencent.cache.core.manager.report.b getMonitorInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.cache.core.manager.report.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return new com.tencent.cache.core.manager.report.b(getCount(), (int) getMemorySize(), this.f98598e.f(), this.f98598e.f() + this.f98598e.h());
    }

    public int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f98598e.n();
    }

    public Map<K, V> i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.f98598e.p();
    }

    @Override // com.tencent.cache.api.b
    public /* synthetic */ void register(Business business, String str) {
        com.tencent.cache.api.a.a(this, business, str);
    }

    @Override // com.tencent.cache.api.b
    public long trimMemory(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, j3)).longValue();
        }
        return this.f98597d.b(this.f98598e, j3, false);
    }
}
