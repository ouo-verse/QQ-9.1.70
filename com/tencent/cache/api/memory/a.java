package com.tencent.cache.api.memory;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import android.os.StatFs;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ7\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0006\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004\"\u0006\u0012\u0002\b\u00030\u0005H\u0003\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u000b\u001a\u00020\nJ\u001c\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0015J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\fH\u0007J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\fR \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/cache/api/memory/a;", "", "", "methodName", "", "Ljava/lang/Class;", "args", "Ljava/lang/reflect/Method;", h.F, "(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Lcom/tencent/cache/api/memory/d;", "e", "Landroid/os/Debug$MemoryInfo;", "memoryInfo", "", "needFixGraphic", "c", "Lcom/tencent/cache/api/memory/b;", "a", "Lcom/tencent/cache/api/memory/e;", "f", "Lcom/tencent/cache/api/memory/c;", "b", "", "j", "memory", "g", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "Lcom/tencent/cache/api/collection/QQConcurrentHashMap;", "nameToField", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final QQConcurrentHashMap<String, Object> nameToField;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f98606b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13106);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98606b = new a();
            nameToField = new QQConcurrentHashMap<>(Business.Default, "MemoryCollect");
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ d d(a aVar, Debug.MemoryInfo memoryInfo, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            memoryInfo = null;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return aVar.c(memoryInfo, z16);
    }

    @SuppressLint({"PrivateApi"})
    private final Method h(String methodName, Class<?>... args) {
        QQConcurrentHashMap<String, Object> qQConcurrentHashMap = nameToField;
        Object obj = qQConcurrentHashMap.get(methodName);
        if (obj == null) {
            try {
                Method declaredMethod = Debug.MemoryInfo.class.getDeclaredMethod(methodName, (Class[]) Arrays.copyOf(args, args.length));
                declaredMethod.setAccessible(true);
                obj = declaredMethod;
            } catch (Throwable unused) {
                obj = "null";
            }
            Object putIfAbsent = qQConcurrentHashMap.putIfAbsent(methodName, obj);
            if (putIfAbsent != null) {
                obj = putIfAbsent;
            }
        }
        if (!(!Intrinsics.areEqual(obj, "null"))) {
            obj = null;
        }
        return (Method) obj;
    }

    public static /* synthetic */ Method i(a aVar, String str, Class[] clsArr, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "getOtherPss";
        }
        return aVar.h(str, clsArr);
    }

    @NotNull
    public final b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (b) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        b bVar = new b();
        long j3 = 1024;
        bVar.g((int) (Runtime.getRuntime().freeMemory() / j3));
        bVar.i((int) (Runtime.getRuntime().totalMemory() / j3));
        bVar.f(bVar.d() - bVar.b());
        bVar.h((int) (Runtime.getRuntime().maxMemory() / j3));
        bVar.j(bVar.a() / bVar.c());
        return bVar;
    }

    @NotNull
    public final c b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        c cVar = new c();
        long j3 = 1048576;
        cVar.d((int) (Debug.getNativeHeapSize() / j3));
        cVar.f((int) (Debug.getNativeHeapFreeSize() / j3));
        cVar.e((int) (Debug.getNativeHeapAllocatedSize() / j3));
        cVar.c((int) (com.tencent.cache.core.manager.api.c.f98725d.g() / j3));
        return cVar;
    }

    @NotNull
    public final d c(@Nullable Debug.MemoryInfo memoryInfo, boolean needFixGraphic) {
        Object obj;
        Context appContext;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (d) iPatchRedirector.redirect((short) 4, this, memoryInfo, Boolean.valueOf(needFixGraphic));
        }
        d dVar = new d();
        if (memoryInfo == null) {
            memoryInfo = com.tencent.cache.core.util.e.a(com.tencent.cache.core.util.e.f98836a, 0, 1);
        }
        dVar.q(memoryInfo.getTotalPss());
        dVar.k(memoryInfo.dalvikPss);
        dVar.n(memoryInfo.nativePss);
        dVar.o(memoryInfo.otherPss);
        a aVar = f98606b;
        dVar.p(aVar.j(memoryInfo));
        Object obj2 = null;
        Method i3 = i(aVar, null, new Class[]{Integer.TYPE}, 1, null);
        if (i3 != null) {
            for (MemoryFlag memoryFlag : MemoryFlag.values()) {
                Map<String, Integer> g16 = dVar.g();
                String reportKey = memoryFlag.getReportKey();
                Object invoke = i3.invoke(memoryInfo, Integer.valueOf(memoryFlag.getFlag()));
                if (invoke != null) {
                    g16.put(reportKey, (Integer) invoke);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
            Integer num = dVar.g().get("soMmap");
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = dVar.g().get("artMmap");
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue() + intValue;
            Integer num3 = dVar.g().get("jarMmap");
            Intrinsics.checkNotNull(num3);
            int intValue3 = num3.intValue() + intValue2;
            Integer num4 = dVar.g().get("apkMmap");
            Intrinsics.checkNotNull(num4);
            int intValue4 = num4.intValue() + intValue3;
            Integer num5 = dVar.g().get("ttfMmap");
            Intrinsics.checkNotNull(num5);
            int intValue5 = num5.intValue() + intValue4;
            Integer num6 = dVar.g().get("dexMmap");
            Intrinsics.checkNotNull(num6);
            int intValue6 = num6.intValue() + intValue5;
            Integer num7 = dVar.g().get("oatMmap");
            Intrinsics.checkNotNull(num7);
            dVar.j(num7.intValue() + intValue6);
            Integer num8 = dVar.g().get("GfxDev");
            Intrinsics.checkNotNull(num8);
            int intValue7 = num8.intValue();
            Integer num9 = dVar.g().get("egl");
            Intrinsics.checkNotNull(num9);
            int intValue8 = num9.intValue() + intValue7;
            Integer num10 = dVar.g().get("glMTrack");
            Intrinsics.checkNotNull(num10);
            dVar.l(num10.intValue() + intValue8);
            dVar.m(dVar.i());
            if (needFixGraphic) {
                com.tencent.cache.core.manager.api.b b16 = com.tencent.cache.core.manager.api.c.f98725d.b();
                if (b16 != null && (appContext = b16.getAppContext()) != null) {
                    obj = appContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                } else {
                    obj = null;
                }
                if (obj instanceof ActivityManager) {
                    obj2 = obj;
                }
                ActivityManager activityManager = (ActivityManager) obj2;
                if (activityManager != null) {
                    Debug.MemoryInfo memoryInfo2 = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()})[0];
                    Object invoke2 = i3.invoke(memoryInfo2, Integer.valueOf(MemoryFlag.OTHER_GFX_DEV.getFlag()));
                    if (invoke2 != null) {
                        int intValue9 = ((Integer) invoke2).intValue();
                        Object invoke3 = i3.invoke(memoryInfo2, Integer.valueOf(MemoryFlag.EGL.getFlag()));
                        if (invoke3 != null) {
                            int intValue10 = ((Integer) invoke3).intValue() + intValue9;
                            Object invoke4 = i3.invoke(memoryInfo2, Integer.valueOf(MemoryFlag.GL_M_TRACK.getFlag()));
                            if (invoke4 != null) {
                                int intValue11 = ((Integer) invoke4).intValue() + intValue10;
                                if (intValue11 > dVar.c()) {
                                    dVar.m((dVar.d() - dVar.c()) + intValue11);
                                    dVar.l(intValue11);
                                }
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            }
        }
        return dVar;
    }

    @NotNull
    public final d e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        d dVar = new d();
        Debug.MemoryInfo a16 = com.tencent.cache.core.util.e.a(com.tencent.cache.core.util.e.f98836a, 0, 1);
        dVar.q(a16.getTotalPss());
        dVar.k(a16.dalvikPss);
        dVar.n(a16.nativePss);
        dVar.o(a16.otherPss);
        return dVar;
    }

    @NotNull
    public final e f() {
        Context appContext;
        String path;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        e eVar = new e();
        com.tencent.cache.core.manager.api.b b16 = com.tencent.cache.core.manager.api.c.f98725d.b();
        if (b16 != null && (appContext = b16.getAppContext()) != null) {
            Object systemService = appContext.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (systemService != null) {
                ActivityManager activityManager = (ActivityManager) systemService;
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j3 = 1048576;
                eVar.o((int) (memoryInfo.totalMem / j3));
                eVar.i((int) (memoryInfo.availMem / j3));
                eVar.m((int) (memoryInfo.threshold / j3));
                eVar.k(memoryInfo.lowMemory);
                eVar.l(activityManager.getMemoryClass());
                eVar.j(activityManager.getLargeMemoryClass());
                try {
                    File cacheDir = appContext.getCacheDir();
                    if (cacheDir != null && (path = cacheDir.getPath()) != null) {
                        StatFs statFs = new StatFs(path);
                        eVar.n((int) (statFs.getTotalBytes() / j3));
                        eVar.h((int) (statFs.getAvailableBytes() / j3));
                    }
                } catch (Exception e16) {
                    com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
                    StringBuilder a16 = com.tencent.cache.api.collection.c.a("collectSystem fail, ");
                    a16.append(e16.getMessage());
                    String msg2 = a16.toString();
                    Intrinsics.checkNotNullParameter("MemoryCollect", "tag");
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    long currentTimeMillis = System.currentTimeMillis();
                    Map<String, Long> map = com.tencent.cache.core.util.b.f98832e;
                    Long l3 = (Long) ((LinkedHashMap) map).get("MemoryCollect");
                    if (l3 == null || currentTimeMillis - l3.longValue() > 600000) {
                        bVar.d("MemoryCollect", 1, msg2);
                        map.put("MemoryCollect", Long.valueOf(currentTimeMillis));
                    }
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
        }
        return eVar;
    }

    public final int g(@NotNull Debug.MemoryInfo memory) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) memory)).intValue();
        }
        Intrinsics.checkNotNullParameter(memory, "memory");
        boolean z16 = true;
        try {
            Method i3 = i(this, null, new Class[]{Integer.TYPE}, 1, null);
            if (i3 == null || (obj = i3.invoke(memory, Integer.valueOf(MemoryFlag.OTHER_DEX.getFlag()))) == null) {
                obj = 0;
            }
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e16) {
            com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
            if (com.tencent.cache.core.util.b.f98828a <= 1) {
                z16 = false;
            }
            if (!z16) {
                return 0;
            }
            bVar.b("MemoryCollect", 2, "getDexMmapMemory fail", e16);
            return 0;
        }
    }

    @SuppressLint({"PrivateApi"})
    public final int j(@NotNull Debug.MemoryInfo memoryInfo) {
        Object obj;
        Object obj2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) memoryInfo)).intValue();
        }
        Intrinsics.checkNotNullParameter(memoryInfo, "memoryInfo");
        try {
            Method h16 = h("hasSwappedOutPss", new Class[0]);
            if (h16 != null) {
                obj = h16.invoke(memoryInfo, new Object[0]);
            } else {
                obj = null;
            }
            if (Intrinsics.areEqual((Boolean) obj, Boolean.TRUE)) {
                Method h17 = h("getTotalSwappedOutPss", new Class[0]);
                if (h17 == null || (obj2 = h17.invoke(memoryInfo, new Object[0])) == null) {
                    obj2 = 0;
                }
                if (obj2 != null) {
                    return ((Integer) obj2).intValue();
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            String memoryStat = memoryInfo.getMemoryStat(MemoryStat.Swap.getStatName());
            Intrinsics.checkNotNullExpressionValue(memoryStat, "memoryInfo.getMemoryStat(MemoryStat.Swap.statName)");
            return Integer.parseInt(memoryStat);
        } catch (Exception unused) {
            return -1;
        }
    }
}
