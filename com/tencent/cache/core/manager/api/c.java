package com.tencent.cache.core.manager.api;

import android.os.SystemClock;
import com.tencent.cache.api.Business;
import com.tencent.cache.core.manager.control.e;
import com.tencent.cache.core.manager.store.i;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import cooperation.qzone.cache.CacheManager;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u000e\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\u001a\u0010\u000f\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0018J\u0006\u0010\u001b\u001a\u00020\u001aR\"\u0010!\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010(\u001a\u0004\b\"\u0010)\"\u0004\b*\u0010+\u00a8\u0006."}, d2 = {"Lcom/tencent/cache/core/manager/api/c;", "", "Lcom/tencent/cache/core/manager/api/CacheConfig;", DownloadInfo.spKey_Config, "", "i", "", "level", "Lcom/tencent/cache/core/manager/api/d;", "logger", "l", "", "", "businessToSubBusinessList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/cache/core/manager/api/b;", "callback", "j", "Lcom/tencent/cache/core/manager/api/a;", "a", "", "c", "g", "Lkotlin/Pair;", "f", "Lcom/tencent/cache/api/Business;", "e", "J", h.F, "()J", "setInitTime", "(J)V", "initTime", "b", "Lcom/tencent/cache/core/manager/api/CacheConfig;", "d", "()Lcom/tencent/cache/core/manager/api/CacheConfig;", "setConfig", "(Lcom/tencent/cache/core/manager/api/CacheConfig;)V", "Lcom/tencent/cache/core/manager/api/b;", "()Lcom/tencent/cache/core/manager/api/b;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/cache/core/manager/api/b;)V", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static long initTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CacheConfig config;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static b callback;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final c f98725d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13722);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98725d = new c();
            config = new CacheConfig();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (a) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return e.f98736b;
    }

    @Nullable
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return callback;
    }

    public final long c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return com.tencent.cache.core.manager.store.e.f98781d.c();
    }

    @NotNull
    public final CacheConfig d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CacheConfig) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return config;
    }

    @NotNull
    public final Business e() {
        Business b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (Business) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        com.tencent.cache.api.d e16 = e.f98736b.e();
        if (e16 == null || (b16 = e16.b()) == null) {
            return Business.Conversation;
        }
        return b16;
    }

    @NotNull
    public final Pair<Integer, Integer> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (Pair) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return i.f98784a;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return i.f98787d.e();
    }

    public final long h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return initTime;
    }

    public final void i(@NotNull CacheConfig config2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) config2);
            return;
        }
        Intrinsics.checkNotNullParameter(config2, "config");
        com.tencent.cache.core.util.b.f98833f.j(CacheManager.TAG, 1, "initCacheConfig");
        config = config2;
        i iVar = i.f98787d;
        Intrinsics.checkNotNullParameter(config2, "config");
        Pair<Integer, Integer> b16 = iVar.b(config2, "reset");
        i.f98784a = b16;
        com.tencent.cache.core.bitmap.pool.e eVar = i.f98786c;
        int intValue = b16.getSecond().intValue();
        eVar.f98689a = intValue;
        eVar.c(intValue);
        com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
        cVar.g(i.f98784a.getFirst().intValue(), cVar.f98669a);
        int i3 = cVar.f98669a;
        for (int i16 = 0; i16 < i3; i16++) {
            com.tencent.cache.core.bitmap.base.lrucache.b<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> bVar = cVar.f98671c[i16];
            int[] iArr = cVar.f98670b;
            if (iArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("maxSizes");
            }
            bVar.l(iArr[i16]);
        }
        int i17 = com.tencent.cache.core.util.b.f98828a;
        com.tencent.cache.core.util.b.f98831d = config2.w();
        if (initTime == 0) {
            initTime = SystemClock.elapsedRealtime();
        }
    }

    public final void j(@NotNull b callback2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) callback2);
            return;
        }
        Intrinsics.checkNotNullParameter(callback2, "callback");
        callback = callback2;
        com.tencent.cache.core.util.b.f98833f.j(CacheManager.TAG, 1, "setCacheCallback");
    }

    public final void k(@NotNull Map<String, String> businessToSubBusinessList) {
        List split$default;
        Set set;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) businessToSubBusinessList);
            return;
        }
        Intrinsics.checkNotNullParameter(businessToSubBusinessList, "businessToSubBusinessList");
        for (Map.Entry<String, String> entry : businessToSubBusinessList.entrySet()) {
            Business valueOf = Business.valueOf(entry.getKey());
            split$default = StringsKt__StringsKt.split$default((CharSequence) entry.getValue(), new String[]{";"}, false, 0, 6, (Object) null);
            set = CollectionsKt___CollectionsKt.toSet(split$default);
            ((ConcurrentHashMap) com.tencent.cache.core.manager.store.e.f98780c).put(valueOf, set);
        }
        com.tencent.cache.core.util.b.f98833f.j(CacheManager.TAG, 1, "setFixedCacheList, result:" + com.tencent.cache.core.manager.store.e.f98780c);
    }

    public final void l(int level, @Nullable d logger) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, level, (Object) logger);
            return;
        }
        int i3 = com.tencent.cache.core.util.b.f98828a;
        if (level <= 2) {
            com.tencent.cache.core.util.b.f98828a = level;
        }
        if (logger != null) {
            com.tencent.cache.core.util.b.f98830c = logger;
        }
    }

    public final void m(@NotNull Map<String, String> businessToSubBusinessList) {
        List split$default;
        Set set;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) businessToSubBusinessList);
            return;
        }
        Intrinsics.checkNotNullParameter(businessToSubBusinessList, "businessToSubBusinessList");
        for (Map.Entry<String, String> entry : businessToSubBusinessList.entrySet()) {
            Business valueOf = Business.valueOf(entry.getKey());
            split$default = StringsKt__StringsKt.split$default((CharSequence) entry.getValue(), new String[]{";"}, false, 0, 6, (Object) null);
            set = CollectionsKt___CollectionsKt.toSet(split$default);
            ((ConcurrentHashMap) com.tencent.cache.core.manager.store.e.f98779b).put(valueOf, set);
        }
        com.tencent.cache.core.util.b.f98833f.j(CacheManager.TAG, 1, "setResidentCacheList, result:" + com.tencent.cache.core.manager.store.e.f98779b);
    }
}
