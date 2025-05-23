package com.tencent.cache.core.manager.report;

import android.os.Build;
import com.tencent.cache.api.memory.d;
import com.tencent.cache.core.manager.api.ClearMode;
import com.tencent.cache.core.manager.store.e;
import com.tencent.cache.core.manager.store.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f98761j = "";

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final a f98762k;

    /* renamed from: a, reason: collision with root package name */
    public int f98763a;

    /* renamed from: b, reason: collision with root package name */
    public int f98764b;

    /* renamed from: c, reason: collision with root package name */
    public int f98765c;

    /* renamed from: d, reason: collision with root package name */
    public int f98766d;

    /* renamed from: e, reason: collision with root package name */
    public int f98767e;

    /* renamed from: f, reason: collision with root package name */
    public int f98768f;

    /* renamed from: g, reason: collision with root package name */
    public List<b> f98769g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, b> f98770h;

    /* renamed from: i, reason: collision with root package name */
    public final ClearMode f98771i;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static final boolean a(a aVar, String str) {
            com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
            if (cVar.d().l() && cVar.d().k() && cVar.d().c() && cVar.b() != null && (!Intrinsics.areEqual(c.f98761j, str))) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98762k = new a();
        }
    }

    public c(@NotNull ClearMode clearMode) {
        Intrinsics.checkNotNullParameter(clearMode, "clearMode");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) clearMode);
            return;
        }
        this.f98771i = clearMode;
        i iVar = i.f98787d;
        this.f98763a = iVar.d().k();
        this.f98764b = iVar.c().g();
        this.f98765c = (int) iVar.e();
        e eVar = e.f98781d;
        this.f98766d = (int) eVar.c();
        this.f98769g = iVar.a();
        this.f98770h = eVar.b();
    }

    public final float a(float f16, String str) {
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Float) iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16), str)).floatValue();
        }
        ClearMode clearMode = this.f98771i;
        if (clearMode == ClearMode.PageChanged) {
            return f16 * 0.1f;
        }
        if (clearMode == ClearMode.LowMemory) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "low_app_", false, 2, null);
            if (startsWith$default) {
                return 1.0f;
            }
            return f16;
        }
        return f16;
    }

    public final HashMap<String, String> b(String str, Float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) f16);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("clearMode", this.f98771i.name());
        hashMap.put("fromDetail", str);
        hashMap.put("imageCacheTotalSize", String.valueOf(this.f98765c));
        hashMap.put("businessCacheSize", String.valueOf(this.f98766d));
        if (f16 != null) {
            hashMap.put("clearTargetRate", String.valueOf(f16.floatValue()));
        }
        return hashMap;
    }

    public final void c(@NotNull String fromDetail, @Nullable Float f16) {
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fromDetail, (Object) f16);
            return;
        }
        Intrinsics.checkNotNullParameter(fromDetail, "fromDetail");
        if (!a.a(f98762k, fromDetail)) {
            return;
        }
        f98761j = fromDetail;
        double random = Math.random();
        com.tencent.cache.core.manager.api.c cVar = com.tencent.cache.core.manager.api.c.f98725d;
        if (random < a(cVar.d().A(), fromDetail)) {
            this.f98767e = this.f98765c - ((int) i.f98787d.e());
            this.f98768f = this.f98766d - ((int) e.f98781d.c());
            HashMap<String, String> b16 = b(fromDetail, f16);
            b16.put("imageCacheSize", String.valueOf(this.f98763a));
            b16.put("bitmapPoolSize", String.valueOf(this.f98764b));
            b16.put("imageCacheClearSize", String.valueOf(this.f98767e));
            b16.put("businessCacheClearSize", String.valueOf(this.f98768f));
            b16.put("AndroidSDKVersion", String.valueOf(Build.VERSION.SDK_INT));
            b16.put("pendingImageMsg", String.valueOf(com.tencent.cache.core.size.task.a.f98811i));
            b16.put("pendingCollectionMsg", String.valueOf(com.tencent.cache.core.size.task.a.f98812m));
            b16.put("pendingClearMsg", String.valueOf(com.tencent.cache.core.size.task.a.C));
            b16.put("fixView", String.valueOf(cVar.d().q()));
            com.tencent.cache.api.memory.a aVar = com.tencent.cache.api.memory.a.f98606b;
            d e16 = aVar.e();
            b16.put("pssTotal", String.valueOf(e16.i()));
            b16.put("pssNative", String.valueOf(e16.e()));
            b16.put("pssDalvik", String.valueOf(e16.b()));
            com.tencent.cache.api.memory.b a16 = aVar.a();
            b16.put("javaHeapMaxSize", String.valueOf(a16.c()));
            b16.put("javaAllocSize", String.valueOf(a16.a()));
            b16.put("javaUsedRatio", String.valueOf(a16.e()));
            com.tencent.cache.api.memory.e f18 = aVar.f();
            b16.put("sysAvailMem", String.valueOf(f18.b()));
            b16.put("sysTotalMem", String.valueOf(f18.g()));
            b16.put("sysMemThreshold", String.valueOf(f18.e()));
            b16.put("sysIsLowMemory", String.valueOf(f18.d()));
            b16.put("availBlockSize", String.valueOf(f18.a()));
            b16.put("totalBlockSize", String.valueOf(f18.f()));
            com.tencent.cache.core.manager.api.b b17 = cVar.b();
            if (b17 != null) {
                b17.d("memory_control_cache_info", b16);
            }
        }
        if (Math.random() < a(cVar.d().s(), fromDetail)) {
            HashMap<String, String> b18 = b(fromDetail, f16);
            int i3 = 0;
            for (Object obj : this.f98769g) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                b bVar = (b) obj;
                b18.put("Img_" + i3 + "_len", String.valueOf(bVar.f98758d));
                b18.put("Img_" + i3 + "_size", String.valueOf(bVar.f98759e));
                b18.put("Img_" + i3 + "_getCount", String.valueOf(bVar.f98760f));
                b18.put("Img_" + i3 + "_hitRate", String.valueOf(bVar.f98757c));
                com.tencent.cache.core.manager.report.a aVar2 = bVar.f98755a;
                if (aVar2 != null && bVar.f98756b != null) {
                    Intrinsics.checkNotNull(aVar2);
                    int i17 = aVar2.f98754c;
                    com.tencent.cache.core.manager.report.a aVar3 = bVar.f98756b;
                    Intrinsics.checkNotNull(aVar3);
                    int i18 = i17 + aVar3.f98754c;
                    if (i18 == 0) {
                        f17 = 0.0f;
                    } else {
                        Intrinsics.checkNotNull(bVar.f98755a);
                        f17 = r5.f98754c / i18;
                    }
                    b18.put("dynamicItemRate", String.valueOf(f17));
                    com.tencent.cache.core.manager.report.a aVar4 = bVar.f98755a;
                    Intrinsics.checkNotNull(aVar4);
                    b18.put("dynamicHitRate", String.valueOf(aVar4.f98752a));
                    com.tencent.cache.core.manager.report.a aVar5 = bVar.f98755a;
                    Intrinsics.checkNotNull(aVar5);
                    b18.put("dynamicPerHitCount", String.valueOf(aVar5.f98753b));
                    com.tencent.cache.core.manager.report.a aVar6 = bVar.f98756b;
                    Intrinsics.checkNotNull(aVar6);
                    b18.put("staticHitRate", String.valueOf(aVar6.f98752a));
                    com.tencent.cache.core.manager.report.a aVar7 = bVar.f98756b;
                    Intrinsics.checkNotNull(aVar7);
                    b18.put("staticPerHitCount", String.valueOf(aVar7.f98753b));
                }
                i3 = i16;
            }
            com.tencent.cache.core.manager.api.b b19 = com.tencent.cache.core.manager.api.c.f98725d.b();
            if (b19 != null) {
                b19.d("ImageCacheMonitor", b18);
            }
            for (Map.Entry<String, b> entry : this.f98770h.entrySet()) {
                HashMap<String, String> b26 = b(fromDetail, f16);
                b26.put("col_key", entry.getKey());
                b26.put("col_len", String.valueOf(entry.getValue().f98758d));
                b26.put("col_size", String.valueOf(entry.getValue().f98759e));
                b26.put("col_getCount", String.valueOf(entry.getValue().f98760f));
                b26.put("col_hitRate", String.valueOf(entry.getValue().f98757c));
                com.tencent.cache.core.manager.api.b b27 = com.tencent.cache.core.manager.api.c.f98725d.b();
                if (b27 != null) {
                    b27.d("ColCacheMonitor", b26);
                }
            }
        }
    }
}
