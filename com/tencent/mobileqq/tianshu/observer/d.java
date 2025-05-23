package com.tencent.mobileqq.tianshu.observer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010$\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\nR,\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/tianshu/observer/d;", "", "", "path", "", "b", "e", "a", "Lcom/tencent/mobileqq/tianshu/observer/b;", "delayInfo", "", "f", "key", "Lcom/tencent/mobileqq/tianshu/observer/a;", "d", "c", "", "", "Ljava/util/Map;", "observers", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f293094a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Map<String, a>> observers;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34414);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            f293094a = new d();
            observers = new LinkedHashMap();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(String path) {
        Map map;
        boolean z16;
        boolean z17 = false;
        if (path == null) {
            return false;
        }
        Map<String, a> map2 = observers.get(path);
        if (map2 != null) {
            map = MapsKt__MapsKt.toMutableMap(map2);
        } else {
            map = null;
        }
        if (map != null && !map.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            long j3 = 0;
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                a aVar = (a) entry.getValue();
                if (Long.parseLong(str) > j3) {
                    long parseLong = Long.parseLong(str);
                    z17 = aVar.a();
                    j3 = parseLong;
                }
            }
        }
        return z17;
    }

    public final boolean a(@NotNull String path) {
        boolean endsWith$default;
        String removeSuffix;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) path)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        boolean b16 = b(path);
        if (!b16) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(path, ".0", false, 2, null);
            if (endsWith$default) {
                removeSuffix = StringsKt__StringsKt.removeSuffix(path, (CharSequence) ".0");
                return b(removeSuffix);
            }
            return b16;
        }
        return b16;
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            observers.clear();
        }
    }

    @Nullable
    public final a d(@NotNull String path, @NotNull String key) {
        Map map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) path, (Object) key);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, a> map2 = observers.get(path);
        if (map2 != null) {
            map = MapsKt__MapsKt.toMutableMap(map2);
        } else {
            map = null;
        }
        if (map == null) {
            return null;
        }
        return (a) map.get(key);
    }

    public final boolean e(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(path, "path");
        return TianshuRedTouch.INSTANCE.b(path);
    }

    public final void f(@NotNull b delayInfo) {
        Map<String, a> map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) delayInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(delayInfo, "delayInfo");
        Map<String, Map<String, a>> map2 = observers;
        Map<String, a> map3 = map2.get(delayInfo.a());
        if (map3 != null) {
            map = MapsKt__MapsKt.toMutableMap(map3);
        } else {
            map = null;
        }
        if (map == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(delayInfo.e(), new a(delayInfo.a(), delayInfo.b(), delayInfo.c()));
            map2.put(delayInfo.a(), linkedHashMap);
        } else {
            map.put(delayInfo.e(), new a(delayInfo.a(), delayInfo.b(), delayInfo.c()));
            map2.put(delayInfo.a(), map);
        }
    }
}
