package k01;

import d01.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00062\u00020\u0001:\u0001\fB;\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\u0012\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f\u00a2\u0006\u0004\b&\u0010'J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u000eJ\t\u0010\u0011\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0012H\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b$\u0010\"\u00a8\u0006("}, d2 = {"Lk01/a;", "", "", "pss", "javaHeap", "", "e", "", "f", "g", "c", "d", "a", "b", "Lorg/json/JSONObject;", h.F, "", "toString", "", "hashCode", "other", "equals", "J", "getInitPss", "()J", "setInitPss", "(J)V", "initPss", "getInitJavaHeap", "setInitJavaHeap", "initJavaHeap", "", "Ljava/util/List;", "getPssList", "()Ljava/util/List;", "pssList", "getJavaHeapList", "javaHeapList", "<init>", "(JJLjava/util/List;Ljava/util/List;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: k01.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class KRMemoryData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private long initPss;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private long initJavaHeap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Long> pssList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<Long> javaHeapList;

    public KRMemoryData() {
        this(0L, 0L, null, null, 15, null);
    }

    public final long a() {
        double averageOfLong;
        if (this.pssList.size() > 0) {
            averageOfLong = CollectionsKt___CollectionsKt.averageOfLong(this.pssList);
            return (long) averageOfLong;
        }
        return 0L;
    }

    public final long b() {
        int collectionSizeOrDefault;
        double averageOfLong;
        if (this.pssList.size() > 0) {
            List<Long> list = this.pssList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Number) it.next()).longValue() - this.initPss));
            }
            averageOfLong = CollectionsKt___CollectionsKt.averageOfLong(arrayList);
            return (long) averageOfLong;
        }
        return 0L;
    }

    public final long c() {
        Long l3 = (Long) b.a(this.pssList);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    public final long d() {
        int collectionSizeOrDefault;
        List<Long> list = this.pssList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Number) it.next()).longValue() - this.initPss));
        }
        Long l3 = (Long) b.a(arrayList);
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    public final void e(long pss, long javaHeap) {
        this.initPss = pss;
        this.initJavaHeap = javaHeap;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof KRMemoryData) {
                KRMemoryData kRMemoryData = (KRMemoryData) other;
                if (this.initPss != kRMemoryData.initPss || this.initJavaHeap != kRMemoryData.initJavaHeap || !Intrinsics.areEqual(this.pssList, kRMemoryData.pssList) || !Intrinsics.areEqual(this.javaHeapList, kRMemoryData.javaHeapList)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final boolean f() {
        w.f392617a.a("KRMemoryMonitor", this.initPss + ", " + this.initJavaHeap + ", " + this.pssList.size() + ", " + this.javaHeapList.size());
        if (this.initPss > 0 && this.initJavaHeap > 0 && (!this.pssList.isEmpty()) && (!this.javaHeapList.isEmpty())) {
            return true;
        }
        return false;
    }

    public final void g(long pss, long javaHeap) {
        this.pssList.add(Long.valueOf(pss));
        this.javaHeapList.add(Long.valueOf(javaHeap));
    }

    @NotNull
    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("avgIncrement", b());
        jSONObject.put("peakIncrement", d());
        jSONObject.put("appPeak", c());
        jSONObject.put("appAvg", a());
        return jSONObject;
    }

    public int hashCode() {
        int i3;
        long j3 = this.initPss;
        long j16 = this.initJavaHeap;
        int i16 = ((((int) (j3 ^ (j3 >>> 32))) * 31) + ((int) ((j16 >>> 32) ^ j16))) * 31;
        List<Long> list = this.pssList;
        int i17 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = (i16 + i3) * 31;
        List<Long> list2 = this.javaHeapList;
        if (list2 != null) {
            i17 = list2.hashCode();
        }
        return i18 + i17;
    }

    @NotNull
    public String toString() {
        return "KRMemoryData(initPss=" + this.initPss + ", initJavaHeap=" + this.initJavaHeap + ", pssList=" + this.pssList + ", javaHeapList=" + this.javaHeapList + ")";
    }

    public KRMemoryData(long j3, long j16, @NotNull List<Long> pssList, @NotNull List<Long> javaHeapList) {
        Intrinsics.checkNotNullParameter(pssList, "pssList");
        Intrinsics.checkNotNullParameter(javaHeapList, "javaHeapList");
        this.initPss = j3;
        this.initJavaHeap = j16;
        this.pssList = pssList;
        this.javaHeapList = javaHeapList;
    }

    public /* synthetic */ KRMemoryData(long j3, long j16, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? new ArrayList() : list, (i3 & 8) != 0 ? new ArrayList() : list2);
    }
}
