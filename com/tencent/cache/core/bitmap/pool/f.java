package com.tencent.cache.core.bitmap.pool;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final d f98697a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.cache.core.bitmap.base.lrucache.a<c, Bitmap> f98698b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<Bitmap.Config, NavigableMap<Integer, Integer>> f98699c;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f98697a = new d();
        this.f98698b = new com.tencent.cache.core.bitmap.base.lrucache.a<>();
        this.f98699c = new HashMap<>();
    }

    public final int a(@NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap)).intValue();
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        return com.tencent.cache.api.util.c.f98640a.b(bitmap);
    }

    public final String b(int i3, Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) config);
        }
        return '[' + i3 + "](" + config + ')';
    }

    public final NavigableMap<Integer, Integer> c(Bitmap.Config config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (NavigableMap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) config);
        }
        NavigableMap<Integer, Integer> navigableMap = this.f98699c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f98699c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    public final void d(int i3, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) bitmap);
            return;
        }
        Bitmap.Config config = bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "removed.config");
        NavigableMap<Integer, Integer> c16 = c(config);
        Integer num = c16.get(Integer.valueOf(i3));
        if (num != null) {
            int intValue = num.intValue();
            Integer valueOf = Integer.valueOf(i3);
            if (intValue == 1) {
                c16.remove(valueOf);
                return;
            } else {
                c16.put(valueOf, Integer.valueOf(intValue - 1));
                return;
            }
        }
        com.tencent.cache.core.util.b.f98833f.h("LruBitmapPool", 1, "Tried to decrement empty size, size: " + i3 + ", removed: " + e(bitmap) + ", this: " + this);
    }

    @NotNull
    public final String e(@NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        }
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        int b16 = com.tencent.cache.api.util.c.f98640a.b(bitmap);
        Bitmap.Config config = bitmap.getConfig();
        Intrinsics.checkNotNullExpressionValue(config, "bitmap.config");
        return b(b16, config);
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder a16 = com.tencent.cache.api.collection.c.a("SizeConfigStrategy{groupedMap=");
        a16.append(this.f98698b);
        a16.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f98699c.entrySet()) {
            a16.append(entry.getKey());
            a16.append('[');
            a16.append(entry.getValue());
            a16.append("], ");
        }
        if (!this.f98699c.isEmpty()) {
            a16.replace(a16.length() - 2, a16.length(), "");
        }
        a16.append(")}");
        String sb5 = a16.toString();
        Intrinsics.checkNotNullExpressionValue(sb5, "sb.append(\")}\").toString()");
        return sb5;
    }
}
