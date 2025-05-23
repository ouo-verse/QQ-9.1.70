package com.tencent.mobileqq.qqguildsdk.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.api.impl.GProGlobalServiceImpl;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0003012B\u0007\u00a2\u0006\u0004\b-\u0010.J=\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J3\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\rH\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010&\u001a\u00020%8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0015\u0010+\u001a\u00020%8\u00c2\u0002X\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGProGlobalService;", "Lcom/tencent/mobileqq/qqguildsdk/wrapper/a;", "", "event", "", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "observers", "", "source", "", "", "params", "", "measuredNotifyChange", "(ILjava/util/Set;Ljava/lang/String;[Ljava/lang/Object;)V", "getStack", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "observer", "addObserver", "deleteObserver", "notifyChange", "(ILjava/lang/String;[Ljava/lang/Object;)V", "initSdk", "mApp", "Lmqq/app/AppRuntime;", "mObservers", "Ljava/util/Set;", "Landroid/os/Handler;", "mUiHandler", "Landroid/os/Handler;", "", "mObserverCreateStacks", "Ljava/util/Map;", "", "mDebugSwitch", "Z", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecords;", "mRecords", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecords;", "isColor", "()Z", "<init>", "()V", "Companion", "a", "DurationRecord", "DurationRecords", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GProGlobalServiceImpl implements IGProGlobalService, com.tencent.mobileqq.qqguildsdk.wrapper.a {

    @NotNull
    private static final String TAG = "GProGlobalServiceImpl";

    @Nullable
    private AppRuntime mApp;
    private final boolean mDebugSwitch;

    @NotNull
    private Set<GPServiceObserver> mObservers = new CopyOnWriteArraySet();

    @NotNull
    private final Handler mUiHandler = new Handler(Looper.getMainLooper());

    @NotNull
    private final Map<Integer, String> mObserverCreateStacks = new ConcurrentHashMap();

    @NotNull
    private final DurationRecords mRecords = new DurationRecords(10);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001:\u0001\u0007B\u0017\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\t\u0010\n\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecord;", "", "", "eventId", "", "measuredTimeInMs", "", "a", "", "c", "toString", "hashCode", "other", "", "equals", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecord$a;", "Landroid/util/SparseArray;", "b", "()Landroid/util/SparseArray;", "map", "<init>", "(Landroid/util/SparseArray;)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final /* data */ class DurationRecord {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final SparseArray<EventRecord> map;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecord$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", AdMetricTag.EVENT_NAME, "I", "()I", "d", "(I)V", "callCounts", "", "c", "J", "()J", "e", "(J)V", "timeCost", "<init>", "(Ljava/lang/String;IJ)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qqguildsdk.api.impl.GProGlobalServiceImpl$DurationRecord$a, reason: from toString */
        /* loaded from: classes17.dex */
        public static final /* data */ class EventRecord {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private String eventName;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private int callCounts;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private long timeCost;

            public EventRecord() {
                this(null, 0, 0L, 7, null);
            }

            /* renamed from: a, reason: from getter */
            public final int getCallCounts() {
                return this.callCounts;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final String getEventName() {
                return this.eventName;
            }

            /* renamed from: c, reason: from getter */
            public final long getTimeCost() {
                return this.timeCost;
            }

            public final void d(int i3) {
                this.callCounts = i3;
            }

            public final void e(long j3) {
                this.timeCost = j3;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EventRecord)) {
                    return false;
                }
                EventRecord eventRecord = (EventRecord) other;
                if (Intrinsics.areEqual(this.eventName, eventRecord.eventName) && this.callCounts == eventRecord.callCounts && this.timeCost == eventRecord.timeCost) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return (((this.eventName.hashCode() * 31) + this.callCounts) * 31) + androidx.fragment.app.a.a(this.timeCost);
            }

            @NotNull
            public String toString() {
                return "EventRecord(eventName=" + this.eventName + ", callCounts=" + this.callCounts + ", timeCost=" + this.timeCost + ")";
            }

            public EventRecord(@NotNull String eventName, int i3, long j3) {
                Intrinsics.checkNotNullParameter(eventName, "eventName");
                this.eventName = eventName;
                this.callCounts = i3;
                this.timeCost = j3;
            }

            public /* synthetic */ EventRecord(String str, int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
                this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0 : i3, (i16 & 4) != 0 ? 0L : j3);
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes17.dex */
        public static final class b<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((EventRecord) t17).getTimeCost()), Long.valueOf(((EventRecord) t16).getTimeCost()));
                return compareValues;
            }
        }

        public DurationRecord() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final void a(int eventId, long measuredTimeInMs) {
            EventRecord eventRecord = this.map.get(eventId);
            if (eventRecord == null) {
                String str = GPServiceObserver.getEventNameMap().get(Integer.valueOf(eventId));
                if (str == null) {
                    str = String.valueOf(eventId);
                }
                eventRecord = new EventRecord(str, 0, 0L, 6, null);
                this.map.put(eventId, eventRecord);
            }
            eventRecord.d(eventRecord.getCallCounts() + 1);
            eventRecord.e(eventRecord.getTimeCost() + measuredTimeInMs);
        }

        @NotNull
        public final SparseArray<EventRecord> b() {
            return this.map;
        }

        @NotNull
        public final String c() {
            Sequence sequence;
            Sequence sortedWith;
            String joinToString$default;
            sequence = SequencesKt__SequenceBuilderKt.sequence(new GProGlobalServiceImpl$DurationRecord$output$1(new Ref.IntRef(), this, null));
            sortedWith = SequencesKt___SequencesKt.sortedWith(sequence, new b());
            joinToString$default = SequencesKt___SequencesKt.joinToString$default(sortedWith, " ", "(", ")", 0, null, new Function1<EventRecord, CharSequence>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGlobalServiceImpl$DurationRecord$output$3
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull GProGlobalServiceImpl.DurationRecord.EventRecord it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return "event<" + it.getEventName() + ">\u00d7" + it.getCallCounts() + ContainerUtils.KEY_VALUE_DELIMITER + it.getTimeCost() + "ms";
                }
            }, 24, null);
            return joinToString$default;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof DurationRecord) && Intrinsics.areEqual(this.map, ((DurationRecord) other).map)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        @NotNull
        public String toString() {
            return "DurationRecord(map=" + this.map + ")";
        }

        public DurationRecord(@NotNull SparseArray<EventRecord> map) {
            Intrinsics.checkNotNullParameter(map, "map");
            this.map = map;
        }

        public /* synthetic */ DurationRecord(SparseArray sparseArray, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new SparseArray() : sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecords;", "", "", "uptimeMillis", "", "event", "time", "", "b", "a", "I", "getN", "()I", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecord;", "[Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecord;", "perfArray", "c", "J", "getTickStartSecond", "()J", "setTickStartSecond", "(J)V", "tickStartSecond", "<init>", "(I)V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class DurationRecords {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int n;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final DurationRecord[] perfArray;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long tickStartSecond;

        public DurationRecords(int i3) {
            this.n = i3;
            DurationRecord[] durationRecordArr = new DurationRecord[10];
            for (int i16 = 0; i16 < 10; i16++) {
                durationRecordArr[i16] = new DurationRecord(null, 1, 0 == true ? 1 : 0);
            }
            this.perfArray = durationRecordArr;
        }

        public final void b(long uptimeMillis, int event, long time) {
            String joinToString$default;
            long j3 = uptimeMillis / 1000;
            long j16 = this.tickStartSecond;
            if (j16 == 0) {
                this.tickStartSecond = j3;
            } else if (j3 >= j16 + this.n) {
                this.tickStartSecond = j3;
                Logger.a d16 = Logger.f235387a.d();
                joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.perfArray, (CharSequence) null, "CostRecords=[", "]", 0, (CharSequence) null, new Function1<DurationRecord, CharSequence>() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.GProGlobalServiceImpl$DurationRecords$appendCost$1$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final CharSequence invoke(@NotNull GProGlobalServiceImpl.DurationRecord it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        String c16 = it.c();
                        it.b().clear();
                        return c16;
                    }
                }, 25, (Object) null);
                d16.i(GProGlobalServiceImpl.TAG, 1, joinToString$default);
            }
            this.perfArray[(int) (j3 % this.n)].a(event, time);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues((Long) ((Pair) t17).getSecond(), (Long) ((Pair) t16).getSecond());
            return compareValues;
        }
    }

    private final String getStack() {
        Sequence asSequence;
        Sequence drop;
        Sequence take;
        String joinToString$default;
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "Throwable().stackTrace");
        asSequence = ArraysKt___ArraysKt.asSequence(stackTrace);
        drop = SequencesKt___SequencesKt.drop(asSequence, 1);
        take = SequencesKt___SequencesKt.take(drop, 8);
        joinToString$default = SequencesKt___SequencesKt.joinToString$default(take, "\n", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    private final boolean isColor() {
        return QLog.isColorLevel();
    }

    /* JADX WARN: Type inference failed for: r7v0, types: [T, java.util.Collection, java.util.ArrayList] */
    private final void measuredNotifyChange(int event, Set<GPServiceObserver> observers, String source, Object[] params) {
        int collectionSizeOrDefault;
        List list;
        QLog.d(TAG, 1, "notifyChange() " + event + " start size=" + observers.size());
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        long currentTimeMillis = System.currentTimeMillis();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(observers, 10);
        ?? arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = observers.iterator();
        while (true) {
            list = null;
            if (!it.hasNext()) {
                break;
            }
            GPServiceObserver gPServiceObserver = (GPServiceObserver) it.next();
            Integer valueOf = Integer.valueOf(System.identityHashCode(gPServiceObserver));
            long nanoTime = System.nanoTime();
            gPServiceObserver.update(null, new Object[]{Integer.valueOf(event), source, params});
            arrayList.add(TuplesKt.to(valueOf, Long.valueOf(System.nanoTime() - nanoTime)));
        }
        objectRef.element = arrayList;
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        String str = GPServiceObserver.getEventNameMap().get(Integer.valueOf(event));
        if (str == null) {
            str = Integer.valueOf(event);
        }
        QLog.d(TAG, 1, "notifyChange(" + str + ") cost: " + currentTimeMillis2 + " ms, " + source);
        List list2 = (List) objectRef.element;
        if (list2 != null) {
            list = CollectionsKt___CollectionsKt.sortedWith(list2, new b());
        }
        QLog.d(TAG, 1, "timeDetail: " + list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyChange$lambda$0(GProGlobalServiceImpl this$0, int i3, String source, Object[] params) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.notifyChange(i3, source, Arrays.copyOf(params, params.length));
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService
    public void addObserver(@NotNull GPServiceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObservers.add(observer);
        if (QLog.isColorLevel()) {
            int identityHashCode = System.identityHashCode(observer);
            String stack = getStack();
            this.mObserverCreateStacks.put(Integer.valueOf(identityHashCode), stack);
            QLog.d(TAG, 1, "Observers[Add]: " + identityHashCode + " - " + stack);
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService
    public void deleteObserver(@NotNull GPServiceObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.mObservers.remove(observer);
        if (QLog.isColorLevel()) {
            int identityHashCode = System.identityHashCode(observer);
            QLog.d(TAG, 1, "Observers[Remove]: " + identityHashCode + " - " + this.mObserverCreateStacks.remove(Integer.valueOf(identityHashCode)));
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService
    public void initSdk() {
        AppRuntime appRuntime = this.mApp;
        if (appRuntime != null) {
        }
    }

    @Override // com.tencent.mobileqq.qqguildsdk.wrapper.a
    public void notifyChange(final int event, @NotNull final String source, @NotNull final Object... params) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(params, "params");
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            String str = GPServiceObserver.getEventNameMap().get(Integer.valueOf(event));
            if (str == null) {
                str = Integer.valueOf(event);
            }
            QLog.d(TAG, 1, "notifyChange(" + str + ") thread switch");
            this.mUiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.qqguildsdk.api.impl.cg
                @Override // java.lang.Runnable
                public final void run() {
                    GProGlobalServiceImpl.notifyChange$lambda$0(GProGlobalServiceImpl.this, event, source, params);
                }
            });
            return;
        }
        Set<GPServiceObserver> set = this.mObservers;
        if (QLog.isColorLevel()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                ((GPServiceObserver) it.next()).update(null, new Object[]{Integer.valueOf(event), source, params});
            }
            this.mRecords.b(uptimeMillis, event, System.currentTimeMillis() - currentTimeMillis);
            return;
        }
        Iterator<T> it5 = set.iterator();
        while (it5.hasNext()) {
            ((GPServiceObserver) it5.next()).update(null, new Object[]{Integer.valueOf(event), source, params});
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mApp = appRuntime;
        this.mObservers = new CopyOnWriteArraySet();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onCreate()");
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        this.mApp = null;
        this.mObservers.clear();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "onDestroy()");
        }
    }
}
