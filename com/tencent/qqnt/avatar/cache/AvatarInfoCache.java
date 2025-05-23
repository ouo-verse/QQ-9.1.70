package com.tencent.qqnt.avatar.cache;

import androidx.collection.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.g;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J\u001a\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u001d\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0013\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0002R&\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001aR&\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0014\u0010 \u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010!R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010$R&\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040&0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/AvatarInfoCache;", "", "", "avatarType", "", "id", "a", "d", "", "hit", "", "f", "Lcom/tencent/qqnt/avatar/meta/a;", "bean", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "c", "(Lcom/tencent/qqnt/avatar/meta/a;)[Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfo", "e", "(Lcom/tencent/qqnt/avatar/meta/a;[Lcom/tencent/qqnt/avatar/meta/info/a;)V", "g", "b", "level", h.F, "", "Ljava/util/Map;", "infoCache", "Landroidx/collection/LruCache;", "Landroidx/collection/LruCache;", "infoLruCache", "Z", "useLruCache", "I", "lruCacheMaxSize", "Lkotlin/Pair;", "Lkotlin/Pair;", "hitRatPair", "", "beanKeyMap", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AvatarInfoCache {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AvatarInfoCache f352688a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, com.tencent.qqnt.avatar.meta.info.a[]> infoCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, com.tencent.qqnt.avatar.meta.info.a[]> infoLruCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final boolean useLruCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final int lruCacheMaxSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Pair<Integer, Integer> hitRatPair;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Set<String>> beanKeyMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        AvatarInfoCache avatarInfoCache = new AvatarInfoCache();
        f352688a = avatarInfoCache;
        infoCache = new LinkedHashMap();
        hitRatPair = new Pair<>(0, 0);
        com.tencent.qqnt.avatar.util.c i3 = g.f352801a.i();
        boolean z16 = true;
        if (i3 != null) {
            z16 = i3.isSwitchOn("proavatar_info_cache_lru_config", true);
        }
        useLruCache = z16;
        int d16 = avatarInfoCache.d();
        lruCacheMaxSize = d16;
        infoLruCache = new LruCache<>(d16);
        com.tencent.qqnt.avatar.util.d.f352991a.e("AvatarInfoCache", "useLruCache: " + z16 + ", lruCacheMaxSize: " + d16);
        beanKeyMap = new LinkedHashMap();
    }

    AvatarInfoCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a(int avatarType, String id5) {
        return avatarType + "_" + id5;
    }

    private final int d() {
        String str;
        boolean z16;
        com.tencent.qqnt.avatar.util.c i3 = g.f352801a.i();
        if (i3 != null) {
            str = i3.loadAsString("proavatar_info_cache_lru_config", "");
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 500;
        }
        try {
            return new JSONObject(str).optInt("lruCacheMaxSize", 500);
        } catch (JSONException unused) {
            return 500;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void f(boolean hit) {
        byte b16;
        final Map<String, ? extends Object> mapOf;
        g gVar = g.f352801a;
        com.tencent.qqnt.avatar.util.b h16 = gVar.h();
        if (h16 != null && h16.b()) {
            b16 = true;
        } else {
            b16 = false;
        }
        if (b16 == false) {
            return;
        }
        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(hitRatPair.getFirst().intValue() + (hit ? 1 : 0)), Integer.valueOf(hitRatPair.getSecond().intValue() + 1));
        hitRatPair = pair;
        if (pair.getSecond().intValue() >= 100) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("max_size", Integer.valueOf(lruCacheMaxSize)), TuplesKt.to("cache_size", Integer.valueOf(infoLruCache.size())), TuplesKt.to("hit_rate", Float.valueOf(hitRatPair.getFirst().intValue() / hitRatPair.getSecond().floatValue())));
            com.tencent.qqnt.avatar.util.d.f352991a.a("AvatarInfoCache", new Function0<String>(mapOf) { // from class: com.tencent.qqnt.avatar.cache.AvatarInfoCache$recordAndReportHitRate$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Map<String, Object> $map;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$map = mapOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) mapOf);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "reportHitRate: " + this.$map;
                }
            });
            com.tencent.qqnt.avatar.util.b h17 = gVar.h();
            if (h17 != null) {
                h17.report("info_cache_hit_rate", mapOf);
            }
            hitRatPair = new Pair<>(0, 0);
        }
    }

    public final synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (useLruCache) {
            infoLruCache.evictAll();
        } else {
            infoCache.clear();
        }
    }

    @Nullable
    public final synchronized com.tencent.qqnt.avatar.meta.info.a[] c(@NotNull com.tencent.qqnt.avatar.meta.a bean) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.avatar.meta.info.a[]) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bean);
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (useLruCache) {
            com.tencent.qqnt.avatar.meta.info.a[] aVarArr = infoLruCache.get(bean.d());
            if (aVarArr != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            f(z16);
            return aVarArr;
        }
        return infoCache.get(bean.d());
    }

    public final synchronized void e(@NotNull com.tencent.qqnt.avatar.meta.a bean, @NotNull com.tencent.qqnt.avatar.meta.info.a[] avatarInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bean, (Object) avatarInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(avatarInfo, "avatarInfo");
        if (useLruCache) {
            infoLruCache.put(bean.d(), avatarInfo);
        } else {
            infoCache.put(bean.d(), avatarInfo);
        }
        Map<String, Set<String>> map = beanKeyMap;
        String a16 = a(bean.a(), bean.c());
        Set<String> set = map.get(a16);
        if (set == null) {
            set = new LinkedHashSet<>();
            map.put(a16, set);
        }
        set.add(bean.d());
    }

    public final synchronized void g(int avatarType, @Nullable String id5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, avatarType, (Object) id5);
            return;
        }
        Set<String> remove = beanKeyMap.remove(a(avatarType, id5));
        if (remove != null) {
            for (String str : remove) {
                if (useLruCache) {
                    infoLruCache.remove(str);
                } else {
                    infoCache.remove(str);
                }
            }
        }
    }

    public final void h(int level) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, level);
            return;
        }
        if (level == 20) {
            com.tencent.qqnt.avatar.util.d.f352991a.e("AvatarInfoCache", "onTrimMemory level=" + level);
            if (useLruCache) {
                infoLruCache.trimToSize(lruCacheMaxSize / 2);
                return;
            }
            return;
        }
        if (level >= 40) {
            com.tencent.qqnt.avatar.util.d.f352991a.e("AvatarInfoCache", "onTrimMemory level=" + level);
            b();
        }
    }
}
