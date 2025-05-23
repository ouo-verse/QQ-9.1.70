package com.tencent.mobileqq.power.cpu;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001\nB\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u000f\u0010\u0016R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R#\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001c0\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\n\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/power/cpu/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getCreateTime", "()J", WadlProxyConsts.CREATE_TIME, "b", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "type", "c", "getEndTime", "(J)V", "endTime", "d", "getUin", "uin", "", "Lcom/tencent/mobileqq/power/cpu/b;", "e", "Ljava/util/Map;", "()Ljava/util/Map;", "threadDataMap", "<init>", "(JLjava/lang/String;)V", "f", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final /* data */ class a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final String[] f259428g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    private static final Map<String, Object> f259429h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long createTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long endTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String uin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, b> threadDataMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J8\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0004H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ.\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00040\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/power/cpu/a$a;", "", "", "name", "", "Lcom/tencent/mobileqq/power/cpu/proc/a;", "procDatas", "", "c", "Lcom/tencent/mobileqq/power/cpu/a;", "cpuData", "", "b", "a", "CREATE_TIME", "Ljava/lang/String;", "END_TIME", "KEY", "THREAD_DATAS", NowProxyConstants.AccountInfoKey.UID, "VERSION", "<init>", "()V", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.power.cpu.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.power.cpu.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes16.dex */
        public static final class C8229a<T> implements Comparator {
            static IPatchRedirector $redirector_;

            public C8229a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(Long.parseLong(((com.tencent.mobileqq.power.cpu.b) t16).c())), Long.valueOf(Long.parseLong(((com.tencent.mobileqq.power.cpu.b) t17).c())));
                    return compareValues;
                }
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.power.cpu.a$a$b */
        /* loaded from: classes16.dex */
        public static final class b<T> implements Comparator {
            static IPatchRedirector $redirector_;

            public b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(Long.parseLong(((com.tencent.mobileqq.power.cpu.proc.a) t16).e())), Long.valueOf(Long.parseLong(((com.tencent.mobileqq.power.cpu.proc.a) t17).e())));
                    return compareValues;
                }
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                return;
            }
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) defaultConstructorMarker);
        }

        private final List<com.tencent.mobileqq.power.cpu.proc.a> c(String name, Map<String, Map<String, com.tencent.mobileqq.power.cpu.proc.a>> procDatas) {
            boolean contains$default;
            List<com.tencent.mobileqq.power.cpu.proc.a> sortedWith;
            for (Map.Entry<String, Map<String, com.tencent.mobileqq.power.cpu.proc.a>> entry : procDatas.entrySet()) {
                String key = entry.getKey();
                Map<String, com.tencent.mobileqq.power.cpu.proc.a> value = entry.getValue();
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) key, false, 2, (Object) null);
                if (contains$default) {
                    sortedWith = CollectionsKt___CollectionsKt.sortedWith(value.values(), new b());
                    return sortedWith;
                }
            }
            return null;
        }

        public final void a(@NotNull a cpuData, @NotNull Map<String, Map<String, com.tencent.mobileqq.power.cpu.proc.a>> procDatas) {
            Object first;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) cpuData, (Object) procDatas);
                return;
            }
            Intrinsics.checkNotNullParameter(cpuData, "cpuData");
            Intrinsics.checkNotNullParameter(procDatas, "procDatas");
            Collection<com.tencent.mobileqq.power.cpu.b> values = cpuData.a().values();
            CollectionsKt___CollectionsKt.sortedWith(values, new C8229a());
            for (com.tencent.mobileqq.power.cpu.b bVar : values) {
                List<com.tencent.mobileqq.power.cpu.proc.a> c16 = c(bVar.d(), procDatas);
                if (c16 != null) {
                    for (com.tencent.mobileqq.power.cpu.proc.a aVar : c16) {
                        if (!aVar.l()) {
                            aVar.m(true);
                            aVar.s(bVar.c());
                            aVar.q(bVar.d());
                            Set<String> keySet = bVar.b().keySet();
                            if (!keySet.isEmpty()) {
                                first = CollectionsKt___CollectionsKt.first(keySet);
                                aVar.r((String) first);
                            }
                            bVar.g(aVar);
                        }
                    }
                }
            }
        }

        public final void b(@NotNull a cpuData) {
            Map<String, Integer> b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) cpuData);
                return;
            }
            Intrinsics.checkNotNullParameter(cpuData, "cpuData");
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            Intrinsics.checkNotNullExpressionValue(allStackTraces, "getAllStackTraces()");
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                Thread key = entry.getKey();
                StackTraceElement[] traceElements = entry.getValue();
                StringBuilder sb5 = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(traceElements, "traceElements");
                for (StackTraceElement stackTraceElement : traceElements) {
                    sb5.append(stackTraceElement);
                    sb5.append(",");
                }
                if (!cpuData.a().containsKey(String.valueOf(key.getId()))) {
                    String valueOf = String.valueOf(key.getId());
                    String name = key.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "thread.name");
                    com.tencent.mobileqq.power.cpu.b bVar = new com.tencent.mobileqq.power.cpu.b(valueOf, name);
                    bVar.e(String.valueOf(System.currentTimeMillis()));
                    bVar.f(bVar.a());
                    cpuData.a().put(String.valueOf(key.getId()), bVar);
                }
                com.tencent.mobileqq.power.cpu.b bVar2 = cpuData.a().get(String.valueOf(key.getId()));
                if (bVar2 != null && (b16 = bVar2.b()) != null) {
                    String sb6 = sb5.toString();
                    Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                    if (!b16.containsKey(sb6)) {
                        b16.put(sb6, 0);
                    }
                    Integer num = b16.get(sb6);
                    Intrinsics.checkNotNull(num);
                    b16.put(sb6, Integer.valueOf(num.intValue() + 1));
                }
                com.tencent.mobileqq.power.cpu.b bVar3 = cpuData.a().get(String.valueOf(key.getId()));
                if (bVar3 != null) {
                    bVar3.f(String.valueOf(System.currentTimeMillis()));
                }
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17203);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        INSTANCE = new Companion(null);
        f259428g = new String[]{"com.tencent.mobileqq.power"};
        f259429h = new LinkedHashMap();
    }

    public a() {
        this(0L, null, 3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            return;
        }
        iPatchRedirector.redirect((short) 16, (Object) this);
    }

    @NotNull
    public final Map<String, b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Map) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.threadDataMap;
    }

    public final void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.endTime = j3;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.createTime == aVar.createTime && Intrinsics.areEqual(this.type, aVar.type)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return (androidx.fragment.app.a.a(this.createTime) * 31) + this.type.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return "CpuData(createTime=" + this.createTime + ", type=" + this.type + ")";
    }

    public a(long j3, @NotNull String type) {
        SimpleAccount firstSimpleAccount;
        Intrinsics.checkNotNullParameter(type, "type");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), type);
            return;
        }
        this.createTime = j3;
        this.type = type;
        this.endTime = j3;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        this.uin = (mobileQQ == null || (firstSimpleAccount = mobileQQ.getFirstSimpleAccount()) == null) ? null : firstSimpleAccount.getUin();
        this.threadDataMap = new LinkedHashMap();
    }

    public /* synthetic */ a(long j3, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? "CpuMonitor_back" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
