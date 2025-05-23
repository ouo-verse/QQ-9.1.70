package com.tencent.mobileqq.power.cpu.proc;

import android.os.Process;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringBuilderJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b#\u0010$J \u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0002H\u0002J \u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0002H\u0002J,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0002J.\u0010\r\u001a\u00020\f2\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ0\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0018\u00010\u0002J\u001e\u0010\u0011\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0002J4\u0010\u0015\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u001e\u0010\u0014\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0002R/\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/power/cpu/proc/b;", "", "", "", "Lcom/tencent/mobileqq/power/cpu/proc/a;", "b", "c", "map", "Ljava/util/PriorityQueue;", "d", "Lcom/tencent/mobileqq/power/config/b;", "level", "", "e", "Lcom/tencent/mobileqq/power/a;", "callBack", "a", "f", "", "procDatas", "cpuDataMap", "g", "Ljava/util/Map;", "getMCpuDataMap1", "()Ljava/util/Map;", "mCpuDataMap1", "getMCpuDataMap2", "mCpuDataMap2", "", "Z", "getMDataInOne", "()Z", "setMDataInOne", "(Z)V", "mDataInOne", "<init>", "()V", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final String f259458e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Map<String, a>> mCpuDataMap1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, Map<String, a>> mCpuDataMap2;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mDataInOne;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0003J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0005\u001a\u00020\u0003J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/power/cpu/proc/b$a;", "", "", "", "d", "tid", "c", "Lcom/tencent/mobileqq/power/cpu/proc/a;", "a", "b", "<init>", "()V", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.power.cpu.proc.b$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final a a(@NotNull String tid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tid);
            }
            Intrinsics.checkNotNullParameter(tid, "tid");
            String c16 = c(tid);
            if (c16 == null) {
                return null;
            }
            List<String> split = new Regex("\\s+").split(c16, 0);
            if (split.size() <= 14 || split.get(1).length() <= 2) {
                return null;
            }
            String substring = split.get(1).substring(1, split.get(1).length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            return new a(tid, substring, split.get(13), split.get(14));
        }

        @NotNull
        public final List<a> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (List) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = d().iterator();
            while (it.hasNext()) {
                a a16 = b.INSTANCE.a((String) it.next());
                if (a16 != null) {
                    arrayList.add(a16);
                }
            }
            return arrayList;
        }

        @Nullable
        public final String c(@NotNull String tid) {
            String readText$default;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) tid);
            }
            Intrinsics.checkNotNullParameter(tid, "tid");
            File file = new File("proc/" + Process.myPid() + "/task/" + tid + "/stat");
            if (file.exists()) {
                readText$default = FilesKt__FileReadWriteKt.readText$default(file, null, 1, null);
                return readText$default;
            }
            return null;
        }

        @NotNull
        public final List<String> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            ArrayList arrayList = new ArrayList();
            File[] fileList = new File("proc/" + Process.myPid() + "/task/").listFiles();
            Intrinsics.checkNotNullExpressionValue(fileList, "fileList");
            for (File file : fileList) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "f.name");
                arrayList.add(name);
            }
            return arrayList;
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/power/cpu/proc/b$b", "Ljava/util/Comparator;", "Lcom/tencent/mobileqq/power/cpu/proc/a;", "o1", "o2", "", "a", "power_monitor_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.power.cpu.proc.b$b, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8231b implements Comparator<a> {
        static IPatchRedirector $redirector_;

        C8231b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(@NotNull a o16, @NotNull a o26) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) o16, (Object) o26)).intValue();
            }
            Intrinsics.checkNotNullParameter(o16, "o1");
            Intrinsics.checkNotNullParameter(o26, "o2");
            return Intrinsics.compare(o26.b(), o16.b());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17433);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
            f259458e = "USER";
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mCpuDataMap1 = new LinkedHashMap();
            this.mCpuDataMap2 = new LinkedHashMap();
        }
    }

    private final Map<String, Map<String, a>> b() {
        if (this.mDataInOne) {
            return this.mCpuDataMap1;
        }
        return this.mCpuDataMap2;
    }

    private final Map<String, Map<String, a>> c() {
        if (this.mDataInOne) {
            return this.mCpuDataMap2;
        }
        return this.mCpuDataMap1;
    }

    public final void a(@NotNull com.tencent.mobileqq.power.a callBack, @Nullable Map<String, Map<String, a>> map) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) callBack, (Object) map);
            return;
        }
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            PriorityQueue<a> d16 = d(map);
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; !d16.isEmpty() && i3 < callBack.c(); i3++) {
                a poll = d16.poll();
                if (poll != null) {
                    float a16 = poll.a();
                    if (a16 == 0.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        StringsKt__StringBuilderJVMKt.clear(sb5);
                        sb5.append("highPowerData:");
                        sb5.append("thread_name: " + poll.f());
                        sb5.append(",linux_thread_id: " + poll.e());
                        sb5.append(",thread_fullnames: " + poll.d());
                        sb5.append(",thread_id: " + poll.j());
                        sb5.append(",cpu_ratio: " + a16 + " %");
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("HighPower callBack\uff1a ");
                        sb6.append((Object) sb5);
                        com.tencent.mobileqq.perf.log.a.d("HP_CPU", sb6.toString());
                        sb5.append("\n     stack_trace: " + poll.g());
                        String sb7 = sb5.toString();
                        Intrinsics.checkNotNullExpressionValue(sb7, "logStr.toString()");
                        arrayList.add(sb7);
                    } else {
                        return;
                    }
                }
            }
        }
        callBack.a(arrayList);
    }

    @NotNull
    public final PriorityQueue<a> d(@NotNull Map<String, Map<String, a>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (PriorityQueue) iPatchRedirector.redirect((short) 6, (Object) this, (Object) map);
        }
        Intrinsics.checkNotNullParameter(map, "map");
        PriorityQueue<a> priorityQueue = new PriorityQueue<>(map.keySet().size() * 2, new C8231b());
        Iterator<Map<String, a>> it = map.values().iterator();
        while (it.hasNext()) {
            priorityQueue.addAll(it.next().values());
        }
        return priorityQueue;
    }

    public final void e(@NotNull Map<String, Map<String, a>> map, @NotNull com.tencent.mobileqq.power.config.b level) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) map, (Object) level);
            return;
        }
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(level, "level");
        PriorityQueue<a> d16 = d(map);
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; !d16.isEmpty() && i3 < level.d(); i3++) {
            a poll = d16.poll();
            if (poll != null) {
                float a16 = poll.a();
                if (a16 == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    StringsKt__StringBuilderJVMKt.clear(sb5);
                    sb5.append("highPowerData:");
                    sb5.append("thread_name: " + poll.f());
                    sb5.append(",linux_thread_id: " + poll.e());
                    sb5.append(",thread_fullnames: " + poll.d());
                    sb5.append(",thread_id: " + poll.j());
                    sb5.append(",cpu_ratio: " + a16 + " %");
                    if (level.c()) {
                        sb5.append("\n     stack_trace: " + poll.g());
                    }
                    com.tencent.mobileqq.perf.log.a.d("HP_CPU", "HighPower\uff1a " + ((Object) sb5));
                } else {
                    return;
                }
            }
        }
    }

    @NotNull
    public final Map<String, Map<String, a>> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Map) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        c().clear();
        List<a> b16 = INSTANCE.b();
        Map<String, Map<String, a>> b17 = b();
        g(b16, b17);
        g(b16, c());
        this.mDataInOne = !this.mDataInOne;
        return b17;
    }

    public final void g(@NotNull List<a> procDatas, @NotNull Map<String, Map<String, a>> cpuDataMap) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) procDatas, (Object) cpuDataMap);
            return;
        }
        Intrinsics.checkNotNullParameter(procDatas, "procDatas");
        Intrinsics.checkNotNullParameter(cpuDataMap, "cpuDataMap");
        for (a aVar2 : procDatas) {
            String f16 = aVar2.f();
            if (cpuDataMap.containsKey(f16)) {
                Map<String, a> map = cpuDataMap.get(f16);
                if (map != null) {
                    String e16 = aVar2.e();
                    if (!map.containsKey(e16)) {
                        map.put(e16, aVar2);
                    }
                }
            } else {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(aVar2.e(), aVar2);
                cpuDataMap.put(f16, linkedHashMap);
            }
            Map<String, a> map2 = cpuDataMap.get(f16);
            if (map2 != null && (aVar = map2.get(aVar2.e())) != null) {
                aVar.p(aVar2.i());
                aVar.n(aVar2.h());
                aVar.o(aVar2.c());
            }
        }
    }
}
