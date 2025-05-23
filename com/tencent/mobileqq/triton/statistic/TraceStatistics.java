package com.tencent.mobileqq.triton.statistic;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/TraceStatistics;", "", "records", "", "Lcom/tencent/mobileqq/triton/statistic/TraceStatistics$Record;", "(Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Record", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final /* data */ class TraceStatistics {

    @NotNull
    private final List<Record> records;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/triton/statistic/TraceStatistics$Record;", "", "name", "", "timeUs", "", "(Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "getTimeUs", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "TritonAPI_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes19.dex */
    public static final /* data */ class Record {

        @NotNull
        private final String name;
        private final long timeUs;

        public Record(@NotNull String name, long j3) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            this.name = name;
            this.timeUs = j3;
        }

        public static /* synthetic */ Record copy$default(Record record, String str, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = record.name;
            }
            if ((i3 & 2) != 0) {
                j3 = record.timeUs;
            }
            return record.copy(str, j3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimeUs() {
            return this.timeUs;
        }

        @NotNull
        public final Record copy(@NotNull String name, long timeUs) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            return new Record(name, timeUs);
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof Record) {
                    Record record = (Record) other;
                    if (!Intrinsics.areEqual(this.name, record.name) || this.timeUs != record.timeUs) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        public final long getTimeUs() {
            return this.timeUs;
        }

        public int hashCode() {
            int i3;
            String str = this.name;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            long j3 = this.timeUs;
            return (i3 * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }

        @NotNull
        public String toString() {
            return "Record(name=" + this.name + ", timeUs=" + this.timeUs + ")";
        }
    }

    public TraceStatistics(@NotNull List<Record> records) {
        Intrinsics.checkParameterIsNotNull(records, "records");
        this.records = records;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TraceStatistics copy$default(TraceStatistics traceStatistics, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = traceStatistics.records;
        }
        return traceStatistics.copy(list);
    }

    @NotNull
    public final List<Record> component1() {
        return this.records;
    }

    @NotNull
    public final TraceStatistics copy(@NotNull List<Record> records) {
        Intrinsics.checkParameterIsNotNull(records, "records");
        return new TraceStatistics(records);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (!(other instanceof TraceStatistics) || !Intrinsics.areEqual(this.records, ((TraceStatistics) other).records)) {
                return false;
            }
            return true;
        }
        return true;
    }

    @NotNull
    public final List<Record> getRecords() {
        return this.records;
    }

    public int hashCode() {
        List<Record> list = this.records;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "TraceStatistics(records=" + this.records + ")";
    }
}
