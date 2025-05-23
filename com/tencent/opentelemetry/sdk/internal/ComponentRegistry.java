package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.common.InstrumentationScopeInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ComponentRegistry<V> {
    static IPatchRedirector $redirector_;
    private final Function<InstrumentationScopeInfo, V> factory;
    private final ConcurrentMap<InstrumentationScopeInfo, V> registry;

    public ComponentRegistry(Function<InstrumentationScopeInfo, V> function) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) function);
        } else {
            this.registry = new ConcurrentHashMap();
            this.factory = function;
        }
    }

    public final V get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? get(str, null) : (V) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
    }

    public final Collection<V> getComponents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Collection) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return Collections.unmodifiableCollection(new ArrayList(this.registry.values()));
    }

    public final V get(String str, @Nullable String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? get(str, str2, null) : (V) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
    }

    public V get(String str, @Nullable String str2, @Nullable String str3) {
        Object apply;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, this, str, str2, str3);
        }
        InstrumentationScopeInfo create = InstrumentationScopeInfo.create(str, str2, str3);
        V v3 = this.registry.get(create);
        if (v3 != null) {
            return v3;
        }
        apply = this.factory.apply(create);
        V v16 = (V) apply;
        V v17 = (V) this.registry.putIfAbsent(create, v16);
        return v17 != null ? v17 : v16;
    }
}
