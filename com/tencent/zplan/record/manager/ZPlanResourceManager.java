package com.tencent.zplan.record.manager;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.zplan.common.utils.FileCache;
import com.tencent.zplan.common.utils.LogUtil;
import com.tencent.zplan.meme.Constant;
import com.tencent.zplan.persistent.ZPlanDataBase;
import com.tencent.zplan.record.model.ExpireConfig;
import com.tencent.zplan.record.model.ZPlanRecordResource;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import lx4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xx4.a;
import yx4.c;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000e\u001a\u00020\r*\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\u0011\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000fH\u0002J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J?\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0004R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001d\u0010%\u001a\u0004\u0018\u00010!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$R\u001b\u0010)\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\"\u001a\u0004\b'\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/tencent/zplan/record/manager/ZPlanResourceManager;", "", "Lcom/tencent/zplan/record/model/ZPlanRecordResource;", "resource", "", "d", "", "key", "localPath", "f", "e", DomainData.DOMAIN_NAME, "o", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function0;", "block", "l", "i", "Lcom/tencent/zplan/record/model/ExpireConfig;", "expire", "Lyx4/c$e;", "forceDeleteConfig", "downloadFromNetIfLocalAbsent", "g", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/ExpireConfig;Lyx4/c$e;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "(Ljava/lang/String;Lcom/tencent/zplan/record/model/ZPlanRecordResource;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "a", "Ljava/util/Map;", "resourceCache", "Lxx4/a;", "Lkotlin/Lazy;", "j", "()Lxx4/a;", "resourceDao", "Lcom/tencent/zplan/common/utils/FileCache;", "k", "()Lcom/tencent/zplan/common/utils/FileCache;", "resourcePool", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class ZPlanResourceManager {

    /* renamed from: b, reason: from kotlin metadata */
    private static final Lazy resourceDao;

    /* renamed from: c, reason: from kotlin metadata */
    private static final Lazy resourcePool;

    /* renamed from: d */
    @NotNull
    public static final ZPlanResourceManager f386013d = new ZPlanResourceManager();

    /* renamed from: a, reason: from kotlin metadata */
    private static final Map<String, ZPlanRecordResource> resourceCache = new LinkedHashMap();

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceManager$resourceDao$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final a invoke() {
                try {
                    return ZPlanDataBase.INSTANCE.e().g();
                } catch (Throwable th5) {
                    d a16 = LogUtil.f385285b.a();
                    if (a16 != null) {
                        a16.e("[ZPlanRRC]ZPlanResourceManager", 1, "create resourceDao exception", th5);
                    }
                    return null;
                }
            }
        });
        resourceDao = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<FileCache>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceManager$resourcePool$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FileCache invoke() {
                Object a16 = mx4.a.f417748a.a(c.class);
                Intrinsics.checkNotNull(a16);
                long q16 = ((c) a16).q();
                d a17 = LogUtil.f385285b.a();
                if (a17 != null) {
                    d.a.c(a17, "[ZPlanRRC]ZPlanResourceManager", 1, "resourcePool cacheSize:" + q16, null, 8, null);
                }
                return new FileCache(Constant.f385743c.b(), q16);
            }
        });
        resourcePool = lazy2;
    }

    ZPlanResourceManager() {
    }

    private final void d(final ZPlanRecordResource resource) {
        Map<String, ZPlanRecordResource> map = resourceCache;
        synchronized (map) {
            map.remove(resource.getKey());
        }
        l(new Function0<Unit>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceManager$deleteResource$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a j3;
                j3 = ZPlanResourceManager.f386013d.j();
                if (j3 != null) {
                    j3.a(ZPlanRecordResource.this);
                }
            }
        });
        com.tencent.zplan.common.utils.c.f385288a.g(resource.getLocalPath());
    }

    private final String e(String key) {
        File c16 = k().c(key);
        if (c16 != null && c16.exists()) {
            return c16.getAbsolutePath();
        }
        return null;
    }

    private final synchronized String f(String key, String localPath) {
        boolean z16;
        File c16 = k().c(key);
        if (c16 != null && c16.exists()) {
            return c16.getAbsolutePath();
        }
        if (localPath != null && localPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str = null;
        if (z16) {
            return null;
        }
        if (m(localPath)) {
            k().f(localPath, key);
        } else {
            k().g(localPath, key);
        }
        File c17 = k().c(key);
        if (c17 != null) {
            str = c17.getAbsolutePath();
        }
        return str;
    }

    public static /* synthetic */ Object h(ZPlanResourceManager zPlanResourceManager, String str, ExpireConfig expireConfig, c.ForceDeleteResourceConfig forceDeleteResourceConfig, boolean z16, Continuation continuation, int i3, Object obj) {
        ExpireConfig expireConfig2;
        c.ForceDeleteResourceConfig forceDeleteResourceConfig2;
        if ((i3 & 2) != 0) {
            expireConfig2 = null;
        } else {
            expireConfig2 = expireConfig;
        }
        if ((i3 & 4) != 0) {
            forceDeleteResourceConfig2 = null;
        } else {
            forceDeleteResourceConfig2 = forceDeleteResourceConfig;
        }
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return zPlanResourceManager.g(str, expireConfig2, forceDeleteResourceConfig2, z16, continuation);
    }

    public final a j() {
        return (a) resourceDao.getValue();
    }

    private final FileCache k() {
        return (FileCache) resourcePool.getValue();
    }

    private final void l(Function0<Unit> block) {
        try {
            block.invoke();
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                a16.e("[ZPlanRRC]ZPlanResourceManager", 1, "invoke db function exception:", th5);
            }
        }
    }

    private final boolean m(String str) {
        boolean z16;
        boolean startsWith$default;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, Constant.f385743c.a(), false, 2, null);
        return startsWith$default;
    }

    private final ZPlanRecordResource n(String str) {
        try {
            a j3 = j();
            if (j3 == null) {
                return null;
            }
            return j3.get(str);
        } catch (Throwable th5) {
            d a16 = LogUtil.f385285b.a();
            if (a16 == null) {
                return null;
            }
            a16.e("[ZPlanRRC]ZPlanResourceManager", 1, "queryDbWithCatch exception:", th5);
            return null;
        }
    }

    private final ZPlanRecordResource o(String str, String str2) {
        boolean z16;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        return new ZPlanRecordResource(str2, str, null, 0L, 0, 0, null, 124, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(@NotNull String str, @NotNull ZPlanRecordResource zPlanRecordResource, boolean z16, @NotNull Continuation<? super Unit> continuation) {
        ZPlanResourceManager$addResource$1 zPlanResourceManager$addResource$1;
        Object coroutine_suspended;
        int i3;
        final ZPlanRecordResource f16;
        ZPlanResourceManager zPlanResourceManager;
        String str2;
        ZPlanRecordResource zPlanRecordResource2;
        Map<String, ZPlanRecordResource> map;
        if (continuation instanceof ZPlanResourceManager$addResource$1) {
            zPlanResourceManager$addResource$1 = (ZPlanResourceManager$addResource$1) continuation;
            int i16 = zPlanResourceManager$addResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanResourceManager$addResource$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanResourceManager$addResource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanResourceManager$addResource$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        zPlanRecordResource2 = (ZPlanRecordResource) zPlanResourceManager$addResource$1.L$2;
                        str2 = (String) zPlanResourceManager$addResource$1.L$1;
                        zPlanResourceManager = (ZPlanResourceManager) zPlanResourceManager$addResource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    f16 = ZPlanRecordResource.f(zPlanRecordResource, null, null, null, 0L, 0, 0, null, 127, null);
                    if (z16) {
                        ZPlanResourceDownloader zPlanResourceDownloader = ZPlanResourceDownloader.f386006c;
                        zPlanResourceManager$addResource$1.L$0 = this;
                        zPlanResourceManager$addResource$1.L$1 = str;
                        zPlanResourceManager$addResource$1.L$2 = f16;
                        zPlanResourceManager$addResource$1.label = 1;
                        Object b16 = zPlanResourceDownloader.b(zPlanRecordResource, zPlanResourceManager$addResource$1);
                        if (b16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        zPlanRecordResource2 = f16;
                        obj = b16;
                        str2 = str;
                        zPlanResourceManager = this;
                    } else {
                        zPlanResourceManager = this;
                        str2 = str;
                        map = resourceCache;
                        synchronized (map) {
                            map.put(str2, f16);
                            Unit unit = Unit.INSTANCE;
                        }
                        zPlanResourceManager.l(new Function0<Unit>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceManager$addResource$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                a j3;
                                j3 = ZPlanResourceManager.f386013d.j();
                                if (j3 != null) {
                                    j3.b(ZPlanRecordResource.this);
                                }
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }
                zPlanRecordResource2.q(zPlanResourceManager.f(str2, (String) obj));
                f16 = zPlanRecordResource2;
                map = resourceCache;
                synchronized (map) {
                }
            }
        }
        zPlanResourceManager$addResource$1 = new ZPlanResourceManager$addResource$1(this, continuation);
        Object obj2 = zPlanResourceManager$addResource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanResourceManager$addResource$1.label;
        if (i3 == 0) {
        }
        zPlanRecordResource2.q(zPlanResourceManager.f(str2, (String) obj2));
        f16 = zPlanRecordResource2;
        map = resourceCache;
        synchronized (map) {
        }
    }

    public final synchronized void c() {
        d a16 = LogUtil.f385285b.a();
        if (a16 != null) {
            d.a.d(a16, "[ZPlanRRC]ZPlanResourceManager", 1, "clear!!", null, 8, null);
        }
        Map<String, ZPlanRecordResource> map = resourceCache;
        synchronized (map) {
            map.clear();
            Unit unit = Unit.INSTANCE;
        }
        l(new Function0<Unit>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceManager$clear$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a j3;
                j3 = ZPlanResourceManager.f386013d.j();
                if (j3 != null) {
                    j3.clear();
                }
            }
        });
        com.tencent.zplan.common.utils.c.f385288a.e(Constant.f385743c.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(@NotNull String str, @Nullable ExpireConfig expireConfig, @Nullable c.ForceDeleteResourceConfig forceDeleteResourceConfig, boolean z16, @NotNull Continuation<? super ZPlanRecordResource> continuation) {
        ZPlanResourceManager$getResource$1 zPlanResourceManager$getResource$1;
        Object coroutine_suspended;
        int i3;
        ZPlanRecordResource zPlanRecordResource;
        final ZPlanRecordResource n3;
        String str2;
        ZPlanResourceManager zPlanResourceManager;
        String e16;
        Object b16;
        ZPlanResourceManager zPlanResourceManager2;
        ZPlanRecordResource zPlanRecordResource2;
        String str3 = str;
        boolean z17 = z16;
        if (continuation instanceof ZPlanResourceManager$getResource$1) {
            zPlanResourceManager$getResource$1 = (ZPlanResourceManager$getResource$1) continuation;
            int i16 = zPlanResourceManager$getResource$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanResourceManager$getResource$1.label = i16 - Integer.MIN_VALUE;
                Object obj = zPlanResourceManager$getResource$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanResourceManager$getResource$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        boolean z18 = zPlanResourceManager$getResource$1.Z$0;
                        String str4 = (String) zPlanResourceManager$getResource$1.L$6;
                        zPlanResourceManager2 = (ZPlanResourceManager) zPlanResourceManager$getResource$1.L$5;
                        ZPlanRecordResource zPlanRecordResource3 = (ZPlanRecordResource) zPlanResourceManager$getResource$1.L$4;
                        zPlanRecordResource2 = (ZPlanRecordResource) zPlanResourceManager$getResource$1.L$3;
                        zPlanRecordResource = (ZPlanRecordResource) zPlanResourceManager$getResource$1.L$2;
                        str2 = (String) zPlanResourceManager$getResource$1.L$1;
                        zPlanResourceManager = (ZPlanResourceManager) zPlanResourceManager$getResource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        z17 = z18;
                        str3 = str4;
                        b16 = obj;
                        n3 = zPlanRecordResource3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    Map<String, ZPlanRecordResource> map = resourceCache;
                    synchronized (map) {
                        zPlanRecordResource = map.get(str3);
                    }
                    if (zPlanRecordResource == null || (n3 = ZPlanRecordResource.f(zPlanRecordResource, null, null, null, 0L, 0, 0, null, 127, null)) == null) {
                        n3 = n(str);
                    }
                    if (n3 == null) {
                        n3 = o(e(str), str3);
                    }
                    if (n3 == null) {
                        return null;
                    }
                    if (n3.d(forceDeleteResourceConfig)) {
                        d a16 = LogUtil.f385285b.a();
                        if (a16 != null) {
                            d.a.d(a16, "[ZPlanRRC]ZPlanResourceManager", 1, "resource force deleted:" + n3 + ", forceDeleteConfig:" + forceDeleteResourceConfig, null, 8, null);
                        }
                        d(n3);
                        return null;
                    }
                    if (n3.c(expireConfig)) {
                        d a17 = LogUtil.f385285b.a();
                        if (a17 != null) {
                            d.a.d(a17, "[ZPlanRRC]ZPlanResourceManager", 1, "resource expired, delete it:" + n3 + ", expire:" + expireConfig, null, 8, null);
                        }
                        d(n3);
                        return null;
                    }
                    if (!n3.o() && z17) {
                        e16 = e(str);
                        if (e16 != null) {
                            str2 = str3;
                            zPlanResourceManager = this;
                            zPlanRecordResource2 = n3;
                            n3.q(e16);
                            n3 = zPlanRecordResource2;
                            if (!Intrinsics.areEqual(n3, zPlanRecordResource)) {
                            }
                            if (n3.o()) {
                            }
                            return n3;
                        }
                        ZPlanResourceDownloader zPlanResourceDownloader = ZPlanResourceDownloader.f386006c;
                        zPlanResourceManager$getResource$1.L$0 = this;
                        zPlanResourceManager$getResource$1.L$1 = str3;
                        zPlanResourceManager$getResource$1.L$2 = zPlanRecordResource;
                        zPlanResourceManager$getResource$1.L$3 = n3;
                        zPlanResourceManager$getResource$1.L$4 = n3;
                        zPlanResourceManager$getResource$1.L$5 = this;
                        zPlanResourceManager$getResource$1.L$6 = str3;
                        zPlanResourceManager$getResource$1.Z$0 = z17;
                        zPlanResourceManager$getResource$1.label = 1;
                        b16 = zPlanResourceDownloader.b(n3, zPlanResourceManager$getResource$1);
                        if (b16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str2 = str3;
                        zPlanResourceManager2 = this;
                        zPlanResourceManager = zPlanResourceManager2;
                        zPlanRecordResource2 = n3;
                    } else {
                        str2 = str3;
                        zPlanResourceManager = this;
                        if (!Intrinsics.areEqual(n3, zPlanRecordResource)) {
                            if (!n3.o() && !n3.p()) {
                                zPlanResourceManager.d(n3);
                            } else {
                                Map<String, ZPlanRecordResource> map2 = resourceCache;
                                synchronized (map2) {
                                    map2.put(str2, n3);
                                    Unit unit = Unit.INSTANCE;
                                }
                                zPlanResourceManager.l(new Function0<Unit>() { // from class: com.tencent.zplan.record.manager.ZPlanResourceManager$getResource$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        a j3;
                                        j3 = ZPlanResourceManager.f386013d.j();
                                        if (j3 != null) {
                                            j3.b(ZPlanRecordResource.this);
                                        }
                                    }
                                });
                            }
                        }
                        if (n3.o() && (!n3.p() || z17)) {
                            return null;
                        }
                        return n3;
                    }
                }
                e16 = zPlanResourceManager2.f(str3, (String) b16);
                n3.q(e16);
                n3 = zPlanRecordResource2;
                if (!Intrinsics.areEqual(n3, zPlanRecordResource)) {
                }
                if (n3.o()) {
                }
                return n3;
            }
        }
        zPlanResourceManager$getResource$1 = new ZPlanResourceManager$getResource$1(this, continuation);
        Object obj2 = zPlanResourceManager$getResource$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanResourceManager$getResource$1.label;
        if (i3 == 0) {
        }
        e16 = zPlanResourceManager2.f(str3, (String) b16);
        n3.q(e16);
        n3 = zPlanRecordResource2;
        if (!Intrinsics.areEqual(n3, zPlanRecordResource)) {
        }
        if (n3.o()) {
        }
        return n3;
    }

    @Nullable
    public final ZPlanRecordResource i(@NotNull String key) {
        ZPlanRecordResource zPlanRecordResource;
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, ZPlanRecordResource> map = resourceCache;
        synchronized (map) {
            zPlanRecordResource = map.get(key);
        }
        return zPlanRecordResource;
    }
}
