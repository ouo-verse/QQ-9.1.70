package com.tencent.zplan.common.soloader;

import com.tencent.av.so.ResInfo;
import com.tencent.zplan.common.utils.LogUtil;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lx4.d;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/zplan/common/soloader/c;", "", "c", "a", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    private static final LinkedHashMap<String, b> f385267a = new LinkedHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final LinkedHashMap<String, a> f385268b = new LinkedHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007J\u001d\u0010\u0011\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u000fH\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0007R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R0\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/zplan/common/soloader/c$a;", "", "", "key", "Lcom/tencent/zplan/common/soloader/b;", "loader", "", "e", "Lkotlin/Function0;", "loaderGenerator", "f", "soNickname", "", "b", "d", "", ResInfo.RES_TYPE_SO, "c", "([Ljava/lang/String;)Z", "a", "TAG", "Ljava/lang/String;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "loaders", "Ljava/util/LinkedHashMap;", "Lcom/tencent/zplan/common/soloader/a;", "soItems", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.common.soloader.c$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final boolean a(@NotNull String soNickname) {
            boolean containsKey;
            Intrinsics.checkNotNullParameter(soNickname, "soNickname");
            synchronized (c.f385268b) {
                containsKey = c.f385268b.containsKey(soNickname);
            }
            return containsKey;
        }

        @JvmStatic
        public final boolean b(@NotNull String soNickname) {
            List<b> sorted;
            LogUtil logUtil;
            a load;
            Intrinsics.checkNotNullParameter(soNickname, "soNickname");
            synchronized (c.f385268b) {
                if (!c.f385268b.containsKey(soNickname)) {
                    synchronized (c.f385267a) {
                        Collection values = c.f385267a.values();
                        Intrinsics.checkNotNullExpressionValue(values, "loaders.values");
                        sorted = CollectionsKt___CollectionsKt.sorted(values);
                    }
                    for (b bVar : sorted) {
                        try {
                            logUtil = LogUtil.f385285b;
                            lx4.d a16 = logUtil.a();
                            if (a16 != null) {
                                d.a.c(a16, "LoadManager", 1, "try load loader=" + bVar, null, 8, null);
                            }
                            load = bVar.load(soNickname);
                        } catch (Throwable th5) {
                            lx4.d a17 = LogUtil.f385285b.a();
                            if (a17 != null) {
                                d.a.b(a17, "LoadManager", 1, "load failed loader=" + bVar + " soNickName=" + soNickname + TokenParser.SP + th5, null, 8, null);
                            }
                        }
                        if (load != null) {
                            lx4.d a18 = logUtil.a();
                            if (a18 != null) {
                                d.a.c(a18, "LoadManager", 1, "load success loader=" + bVar + " soNickName=" + soNickname + " item=" + load, null, 8, null);
                            }
                            c.f385268b.put(soNickname, load);
                            return true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return false;
                }
                return false;
            }
        }

        @JvmStatic
        public final boolean c(@NotNull String[] so5) {
            boolean z16;
            List<b> sorted;
            Intrinsics.checkNotNullParameter(so5, "so");
            if (so5.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = !z16;
            for (String str : so5) {
                synchronized (c.f385268b) {
                    if (!c.f385268b.containsKey(str)) {
                        synchronized (c.f385267a) {
                            Collection values = c.f385267a.values();
                            Intrinsics.checkNotNullExpressionValue(values, "loaders.values");
                            sorted = CollectionsKt___CollectionsKt.sorted(values);
                        }
                        for (b bVar : sorted) {
                            try {
                                LogUtil logUtil = LogUtil.f385285b;
                                lx4.d a16 = logUtil.a();
                                if (a16 != null) {
                                    d.a.c(a16, "LoadManager", 1, "try load loader=" + bVar, null, 8, null);
                                }
                                a load = bVar.load(str);
                                if (load != null) {
                                    lx4.d a17 = logUtil.a();
                                    if (a17 != null) {
                                        d.a.c(a17, "LoadManager", 1, "load success loader=" + bVar + " soNickName=" + str + " item=" + load, null, 8, null);
                                    }
                                    c.f385268b.put(str, load);
                                }
                            } catch (Throwable th5) {
                                lx4.d a18 = LogUtil.f385285b.a();
                                if (a18 != null) {
                                    d.a.b(a18, "LoadManager", 1, "load failed loader=" + bVar + " soNickName=" + str + TokenParser.SP + th5, null, 8, null);
                                }
                                z17 = false;
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
            }
            return z17;
        }

        @JvmStatic
        public final boolean d(@NotNull String soNickname) {
            Intrinsics.checkNotNullParameter(soNickname, "soNickname");
            b(soNickname);
            return a(soNickname);
        }

        public final void e(@NotNull String key, @NotNull b loader) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(loader, "loader");
            synchronized (c.f385267a) {
                if (c.f385267a.containsKey(key)) {
                    return;
                }
            }
        }

        public final void f(@NotNull String key, @NotNull Function0<? extends b> loaderGenerator) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(loaderGenerator, "loaderGenerator");
            synchronized (c.f385267a) {
                if (c.f385267a.containsKey(key)) {
                    return;
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
