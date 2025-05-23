package com.tencent.mobileqq.app.message.messageclean;

import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.splash.GdtSplashAdCacheTool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006RN\u0010\u0012\u001a.\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n0\bj\u0016\u0012\u0004\u0012\u00020\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n`\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R7\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b`\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/app/message/messageclean/StorageCacheManager;", "", "Lcom/tencent/mobileqq/app/message/filescan/c;", "callback", "", "b", "", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/message/messageclean/x;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "c", "()Ljava/util/HashMap;", "setCacheToolClassMap", "(Ljava/util/HashMap;)V", "cacheToolClassMap", "Lkotlin/Lazy;", "d", "cacheToolMap", "<init>", "()V", "storage-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class StorageCacheManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StorageCacheManager f196111a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/StorageImpl/Inject_business_cache_tool_map.yml")
    @NotNull
    private static HashMap<String, Class<? extends x>> cacheToolClassMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy cacheToolMap;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19023);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f196111a = new StorageCacheManager();
        HashMap<String, Class<? extends x>> hashMap = new HashMap<>();
        cacheToolClassMap = hashMap;
        hashMap.put("FileTable", r.class);
        cacheToolClassMap.put("RMonitor", bb.class);
        cacheToolClassMap.put("QLog", av.class);
        cacheToolClassMap.put("GdtSplashAd", GdtSplashAdCacheTool.class);
        cacheToolClassMap.put("OnlineStatus", as.class);
        cacheToolClassMap.put(GdtLog.WEB_TAG, com.tencent.mobileqq.webview.injector.q.class);
        cacheToolClassMap.put("Album", d.class);
        cacheToolClassMap.put("AIOEditor", b.class);
        cacheToolClassMap.put("Ark", f.class);
        cacheToolClassMap.put("SogouInput", bd.class);
        cacheToolClassMap.put("ZPlan", bm.class);
        cacheToolClassMap.put("Guild", t.class);
        cacheToolClassMap.put("QCircle", au.class);
        cacheToolClassMap.put("ZPlanSquare", bo.class);
        cacheToolClassMap.put("Troop", bh.class);
        cacheToolClassMap.put("Kandian", ae.class);
        cacheToolClassMap.put("ZPlanRecord", bn.class);
        cacheToolClassMap.put("Apollo", e.class);
        cacheToolClassMap.put("SuperPlayer", bf.class);
        cacheToolClassMap.put("Tbs", bg.class);
        cacheToolClassMap.put("Enterprise", i.class);
        cacheToolClassMap.put("AE", a.class);
        cacheToolClassMap.put("TroopVideo", bj.class);
        cacheToolClassMap.put("Ad", c.class);
        cacheToolClassMap.put("TroopGift", bi.class);
        cacheToolClassMap.put("QZoneRes", az.class);
        cacheToolClassMap.put("Vip", bk.class);
        cacheToolClassMap.put("MiniGame", ai.class);
        cacheToolClassMap.put("Wallet", bl.class);
        cacheToolClassMap.put("GameCenter", s.class);
        cacheToolClassMap.put("MiniApp", ah.class);
        cacheToolClassMap.put("QZone", ay.class);
        cacheToolClassMap.put("NearBy", ar.class);
        cacheToolClassMap.put("PubAccount", at.class);
        cacheToolClassMap.put("Qav", ba.class);
        cacheToolClassMap.put("QQFav", aw.class);
        cacheToolClassMap.put("QQFileRecv", ax.class);
        cacheToolClassMap.put("Relationship", bc.class);
        lazy = LazyKt__LazyJVMKt.lazy(StorageCacheManager$cacheToolMap$2.INSTANCE);
        cacheToolMap = lazy;
    }

    StorageCacheManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Iterator<x> it = d().values().iterator();
        while (it.hasNext()) {
            it.next().clearCache();
        }
    }

    public final long b(@Nullable com.tencent.mobileqq.app.message.filescan.c callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback)).longValue();
        }
        int size = d().size();
        Iterator<x> it = d().values().iterator();
        long j3 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            j3 += it.next().getCacheSize();
            if (callback != null) {
                callback.a((i3 * 100) / size);
            }
        }
        return j3;
    }

    @NotNull
    public final HashMap<String, Class<? extends x>> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return cacheToolClassMap;
    }

    @NotNull
    public final HashMap<String, x> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return (HashMap) cacheToolMap.getValue();
    }
}
