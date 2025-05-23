package je4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\b\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0002\u0007\bB\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001c\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u0006\u0010\u0007\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0003R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lje4/b;", "", "", "", "extra", "", "c", "a", "b", "Lje4/b$b;", "Lje4/b$b;", "currentTrace", "", "Ljava/util/List;", "traces", "Ljava/lang/String;", "sourceTag", "<init>", "(Ljava/lang/String;)V", "d", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TraceItem currentTrace;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<TraceItem> traces;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String sourceTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u000f\u0010\u0011R#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lje4/b$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getStartTime", "()J", "startTime", "b", "getEndTime", "(J)V", "endTime", "", "c", "Ljava/util/Map;", "getExtraInfo", "()Ljava/util/Map;", "extraInfo", "consumed", "<init>", "(JJLjava/util/Map;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: je4.b$b, reason: collision with other inner class name and from toString */
    /* loaded from: classes26.dex */
    public static final /* data */ class TraceItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long startTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long endTime;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Map<String, String> extraInfo;

        public TraceItem() {
            this(0L, 0L, null, 7, null);
        }

        public final long a() {
            return this.endTime - this.startTime;
        }

        public final void b(long j3) {
            this.endTime = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof TraceItem) {
                    TraceItem traceItem = (TraceItem) other;
                    if (this.startTime != traceItem.startTime || this.endTime != traceItem.endTime || !Intrinsics.areEqual(this.extraInfo, traceItem.extraInfo)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i3;
            int a16 = ((androidx.fragment.app.a.a(this.startTime) * 31) + androidx.fragment.app.a.a(this.endTime)) * 31;
            Map<String, String> map = this.extraInfo;
            if (map != null) {
                i3 = map.hashCode();
            } else {
                i3 = 0;
            }
            return a16 + i3;
        }

        @NotNull
        public String toString() {
            return "TraceItem(startTime=" + this.startTime + ", endTime=" + this.endTime + ", extraInfo=" + this.extraInfo + ")";
        }

        public TraceItem(long j3, long j16, @NotNull Map<String, String> extraInfo) {
            Intrinsics.checkParameterIsNotNull(extraInfo, "extraInfo");
            this.startTime = j3;
            this.endTime = j16;
            this.extraInfo = extraInfo;
        }

        public /* synthetic */ TraceItem(long j3, long j16, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map);
        }
    }

    public b(@NotNull String sourceTag) {
        Intrinsics.checkParameterIsNotNull(sourceTag, "sourceTag");
        this.sourceTag = sourceTag;
        this.traces = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(b bVar, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        bVar.c(map);
    }

    public final void a() {
        TraceItem traceItem = this.currentTrace;
        if (traceItem != null) {
            traceItem.b(System.nanoTime() / 1000);
            this.traces.add(traceItem);
        }
        this.currentTrace = null;
    }

    @NotNull
    public final String b() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.sourceTag);
        sb5.append(": totalCount: ");
        sb5.append(this.traces.size());
        sb5.append(", average: ");
        Iterator<TraceItem> it = this.traces.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().a();
        }
        sb5.append(j3 / this.traces.size());
        sb5.append("us");
        return sb5.toString();
    }

    public final void c(@NotNull Map<String, String> extra) {
        Intrinsics.checkParameterIsNotNull(extra, "extra");
        if (this.currentTrace != null) {
            return;
        }
        this.currentTrace = new TraceItem(System.nanoTime() / 1000, 0L, extra, 2, null);
    }
}
