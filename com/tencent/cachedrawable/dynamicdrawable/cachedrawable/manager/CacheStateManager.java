package com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager;

import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.CacheDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.j;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.ref.WeakReference;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016J<\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J4\u0010\u0014\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/CacheStateManager;", "", "", "c", "", "key", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/CacheDrawable$CacheState;", "cacheState", tl.h.F, "filePath", "g", "timelineTag", "e", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "factory", "", "useFileCache", "Lkotlin/Function1;", "onGetCacheStateCallback", "d", "f", "<init>", "()V", "a", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class CacheStateManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final CacheStateManager f99001b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, WeakReference<CacheDrawable.CacheState>> f99002c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.cachedrawable.dynamicdrawable.h> f99003d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/CacheStateManager$a;", "", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/CacheStateManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/CacheStateManager;", "a", "()Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/manager/CacheStateManager;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.CacheStateManager$a, reason: from kotlin metadata */
    /* loaded from: classes5.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final CacheStateManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return CacheStateManager.f99001b;
            }
            return (CacheStateManager) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        INSTANCE = new Companion(null);
        f99001b = new CacheStateManager();
        f99002c = new ConcurrentHashMap<>();
        f99003d = new ConcurrentHashMap<>();
    }

    public CacheStateManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c() {
        if (!com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.g()) {
            return;
        }
        try {
            Iterator<Map.Entry<String, WeakReference<CacheDrawable.CacheState>>> it = f99002c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, WeakReference<CacheDrawable.CacheState>> next = it.next();
                String key = next.getKey();
                if (next.getValue().get() == null) {
                    com.tencent.cachedrawable.dynamicdrawable.h remove = f99003d.remove(key);
                    if (remove != null) {
                        remove.destroy();
                    }
                    it.remove();
                }
            }
        } catch (Exception e16) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.c("CacheStateManager", "clearLostCacheImage", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String key, CacheDrawable.CacheState cacheState) {
        com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.d("CacheStateManager", Intrinsics.stringPlus("saveCacheState : key ", key));
        f99002c.put(key, new WeakReference<>(cacheState));
        if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.g()) {
            f99003d.put(key, cacheState.b().r());
        }
    }

    public void d(@NotNull String timelineTag, @NotNull String filePath, @NotNull com.tencent.cachedrawable.dynamicdrawable.e factory, boolean useFileCache, @NotNull final Function1<? super CacheDrawable.CacheState, Unit> onGetCacheStateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, timelineTag, filePath, factory, Boolean.valueOf(useFileCache), onGetCacheStateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(timelineTag, "timelineTag");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(onGetCacheStateCallback, "onGetCacheStateCallback");
        final String str = timelineTag + util.base64_pad_url + filePath;
        CacheDrawable.CacheState e16 = e(timelineTag, filePath);
        if (e16 == null) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.d("CacheStateManager", Intrinsics.stringPlus("getCacheState == null : key ", str));
            f(filePath, factory, useFileCache, new Function1<CacheDrawable.CacheState, Unit>(str, onGetCacheStateCallback) { // from class: com.tencent.cachedrawable.dynamicdrawable.cachedrawable.manager.CacheStateManager$getCacheState$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $key;
                final /* synthetic */ Function1<CacheDrawable.CacheState, Unit> $onGetCacheStateCallback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$key = str;
                    this.$onGetCacheStateCallback = onGetCacheStateCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, CacheStateManager.this, str, onGetCacheStateCallback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(CacheDrawable.CacheState cacheState) {
                    invoke2(cacheState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull CacheDrawable.CacheState it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    CacheStateManager.this.h(this.$key, it);
                    this.$onGetCacheStateCallback.invoke(it);
                }
            });
        } else {
            onGetCacheStateCallback.invoke(e16);
        }
    }

    @Nullable
    public CacheDrawable.CacheState e(@NotNull String timelineTag, @NotNull String filePath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CacheDrawable.CacheState) iPatchRedirector.redirect((short) 3, (Object) this, (Object) timelineTag, (Object) filePath);
        }
        Intrinsics.checkNotNullParameter(timelineTag, "timelineTag");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String str = timelineTag + util.base64_pad_url + filePath;
        c();
        WeakReference<CacheDrawable.CacheState> weakReference = f99002c.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void f(@NotNull String filePath, @NotNull com.tencent.cachedrawable.dynamicdrawable.e factory, boolean useFileCache, @NotNull Function1<? super CacheDrawable.CacheState, Unit> onGetCacheStateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, filePath, factory, Boolean.valueOf(useFileCache), onGetCacheStateCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(onGetCacheStateCallback, "onGetCacheStateCallback");
        if (new CacheDrawable.CacheState(filePath, factory, useFileCache).b().w()) {
            onGetCacheStateCallback.invoke(new CacheDrawable.CacheState(filePath, factory, useFileCache));
        } else {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("CacheStateManager", Intrinsics.stringPlus("cacheState.mCacheImage.isUseAble == false : filePath : ", filePath));
        }
    }

    public void g(@NotNull String filePath) {
        Iterator it;
        boolean endsWith$default;
        CacheDrawable.CacheState cacheState;
        j b16;
        com.tencent.cachedrawable.dynamicdrawable.h r16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) filePath);
            return;
        }
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Enumeration<String> keys = f99002c.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "mStateCacheMap.keys()");
        it = CollectionsKt__IteratorsJVMKt.iterator(keys);
        while (it.hasNext()) {
            String key = (String) it.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(key, filePath, false, 2, null);
            if (endsWith$default) {
                WeakReference<CacheDrawable.CacheState> remove = f99002c.remove(key);
                if (com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a.g() && remove != null && (cacheState = remove.get()) != null && (b16 = cacheState.b()) != null && (r16 = b16.r()) != null) {
                    r16.destroy();
                }
            }
        }
    }
}
