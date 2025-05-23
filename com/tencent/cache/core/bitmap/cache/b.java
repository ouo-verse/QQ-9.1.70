package com.tencent.cache.core.bitmap.cache;

import android.view.View;
import com.tencent.cache.api.util.Priority;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b<K, V> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f98659a;

    /* renamed from: b, reason: collision with root package name */
    public int f98660b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public List<SoftReference<View>> f98661c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public a f98662d;

    /* renamed from: e, reason: collision with root package name */
    public int f98663e;

    /* renamed from: f, reason: collision with root package name */
    public final V f98664f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final String f98665g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f98666h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f98667i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public Priority f98668j;

    public b(V v3, @NotNull String businessName, @Nullable String str, boolean z16, @NotNull Priority priority) {
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(priority, "priority");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, v3, businessName, str, Boolean.valueOf(z16), priority);
            return;
        }
        this.f98664f = v3;
        this.f98665g = businessName;
        this.f98666h = str;
        this.f98667i = z16;
        this.f98668j = priority;
        this.f98661c = new ArrayList();
        this.f98662d = a.f98655a;
    }

    public final void a(@NotNull b<K, V> cacheItem) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cacheItem);
            return;
        }
        Intrinsics.checkNotNullParameter(cacheItem, "cacheItem");
        if (cacheItem.f98662d != a.f98657c && !cacheItem.f98661c.isEmpty() && cacheItem.f98664f == this.f98664f) {
            for (SoftReference<View> softReference : cacheItem.f98661c) {
                if (softReference.get() != null) {
                    List<SoftReference<View>> list = this.f98661c;
                    if (!(list instanceof Collection) || !list.isEmpty()) {
                        Iterator<T> it = list.iterator();
                        while (it.hasNext()) {
                            if (Intrinsics.areEqual((View) ((SoftReference) it.next()).get(), softReference.get())) {
                                z16 = true;
                                break;
                            }
                        }
                    }
                    z16 = false;
                    if (!z16) {
                        this.f98661c.add(softReference);
                    }
                }
            }
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append('[');
        sb5.append(this.f98665g);
        sb5.append(", ");
        sb5.append(this.f98666h);
        sb5.append(", ");
        V v3 = this.f98664f;
        Intrinsics.checkNotNull(v3);
        sb5.append(v3.getClass().getSimpleName());
        sb5.append(", ");
        sb5.append(this.f98663e);
        sb5.append(']');
        return sb5.toString();
    }
}
