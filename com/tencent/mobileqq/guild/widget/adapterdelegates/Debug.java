package com.tencent.mobileqq.guild.widget.adapterdelegates;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt___MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002=>B\t\b\u0002\u00a2\u0006\u0004\b;\u0010<JO\u0010\r\u001a\u00020\f\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\u0011\u001a\u00020\b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J \u0010\u0017\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u001e\u0010\u001e\u001a\u00020\f2\u0016\b\u0002\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f\u0018\u00010\u001cJ\u0006\u0010\u001f\u001a\u00020\fR\u0016\u0010#\u001a\u00020 8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R'\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010%0$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010,\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010&\u001a\u0004\b*\u0010+R#\u00101\u001a\n .*\u0004\u0018\u00010-0-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b/\u00100R.\u00106\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001203\u0012\u0004\u0012\u000204028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u00105R\u001c\u00109\u001a\b\u0012\u0002\b\u0003\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00108R$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010:\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/Debug;", "", "T", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "delegate", "items", "", "position", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "holder", "", "payloads", "", "j", "(Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;Ljava/lang/Object;ILandroidx/recyclerview/widget/RecyclerView$ViewHolder;Ljava/util/List;)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "k", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/Debug$Type;", "type", "obj", "", QCircleWeakNetReporter.KEY_COST, "c", "Ljava/lang/Runnable;", tl.h.F, "", "d", "Lkotlin/Function1;", "callback", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", "Z", "ENABLE_DEBUG", "Ljava/util/concurrent/LinkedBlockingQueue;", "", "Lkotlin/Lazy;", "f", "()Ljava/util/concurrent/LinkedBlockingQueue;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "e", "()Ljava/lang/Runnable;", "calculateRunnable", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "g", "()Ljava/util/concurrent/ScheduledExecutorService;", "scheduledExecutorService", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/Debug$a;", "Ljava/util/concurrent/ConcurrentHashMap;", "costMap", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledFuture;", "future", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "a", "Type", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class Debug {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Debug f236182a = new Debug();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean ENABLE_DEBUG;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy queue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy calculateRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy scheduledExecutorService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Pair<String, Type>, DebugEntry> costMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ScheduledFuture<?> future;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super String, Unit> callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/Debug$Type;", "", "(Ljava/lang/String;I)V", "BIND", "CREATE", "GUILD_SLIDE_ANIMATION_DISPATCH", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum Type {
        BIND,
        CREATE,
        GUILD_SLIDE_ANIMATION_DISPATCH
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/adapterdelegates/Debug$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "d", "(I)V", "count", "", "b", "J", "()J", "e", "(J)V", "maxCostInNano", "c", "f", "totalCosts", "<init>", "(IJJ)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.widget.adapterdelegates.Debug$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class DebugEntry {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int count;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private long maxCostInNano;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private long totalCosts;

        public DebugEntry() {
            this(0, 0L, 0L, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: b, reason: from getter */
        public final long getMaxCostInNano() {
            return this.maxCostInNano;
        }

        /* renamed from: c, reason: from getter */
        public final long getTotalCosts() {
            return this.totalCosts;
        }

        public final void d(int i3) {
            this.count = i3;
        }

        public final void e(long j3) {
            this.maxCostInNano = j3;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DebugEntry)) {
                return false;
            }
            DebugEntry debugEntry = (DebugEntry) other;
            if (this.count == debugEntry.count && this.maxCostInNano == debugEntry.maxCostInNano && this.totalCosts == debugEntry.totalCosts) {
                return true;
            }
            return false;
        }

        public final void f(long j3) {
            this.totalCosts = j3;
        }

        public int hashCode() {
            return (((this.count * 31) + androidx.fragment.app.a.a(this.maxCostInNano)) * 31) + androidx.fragment.app.a.a(this.totalCosts);
        }

        @NotNull
        public String toString() {
            return "DebugEntry(count=" + this.count + ", maxCostInNano=" + this.maxCostInNano + ", totalCosts=" + this.totalCosts + ')';
        }

        public DebugEntry(int i3, long j3, long j16) {
            this.count = i3;
            this.maxCostInNano = j3;
            this.totalCosts = j16;
        }

        public /* synthetic */ DebugEntry(int i3, long j3, long j16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? 0L : j16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((DebugEntry) ((Map.Entry) t17).getValue()).getMaxCostInNano()), Long.valueOf(((DebugEntry) ((Map.Entry) t16).getValue()).getMaxCostInNano()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class c<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Comparator f236193d;

        public c(Comparator comparator) {
            this.f236193d = comparator;
        }

        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            int compare = this.f236193d.compare(t16, t17);
            if (compare == 0) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((DebugEntry) ((Map.Entry) t17).getValue()).getCount()), Integer.valueOf(((DebugEntry) ((Map.Entry) t16).getValue()).getCount()));
                return compareValues;
            }
            return compare;
        }
    }

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinkedBlockingQueue<Object[]>>() { // from class: com.tencent.mobileqq.guild.widget.adapterdelegates.Debug$queue$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinkedBlockingQueue<Object[]> invoke() {
                return new LinkedBlockingQueue<>();
            }
        });
        queue = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Runnable>() { // from class: com.tencent.mobileqq.guild.widget.adapterdelegates.Debug$calculateRunnable$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Runnable invoke() {
                Runnable h16;
                h16 = Debug.f236182a.h();
                return h16;
            }
        });
        calculateRunnable = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ScheduledExecutorService>() { // from class: com.tencent.mobileqq.guild.widget.adapterdelegates.Debug$scheduledExecutorService$2
            @Override // kotlin.jvm.functions.Function0
            public final ScheduledExecutorService invoke() {
                return ProxyExecutors.newSingleThreadScheduledExecutor();
            }
        });
        scheduledExecutorService = lazy3;
        costMap = new ConcurrentHashMap<>();
    }

    Debug() {
    }

    @JvmStatic
    public static final void c(@NotNull Type type, @NotNull Object obj, long cost) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(obj, "obj");
        f236182a.f().add(new Object[]{type, obj, Long.valueOf(cost)});
    }

    private final String d() {
        Sequence asSequence;
        Sequence sortedWith;
        Sequence take;
        List list;
        String takeLast;
        if (costMap.isEmpty()) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        asSequence = MapsKt___MapsKt.asSequence(costMap);
        sortedWith = SequencesKt___SequencesKt.sortedWith(asSequence, new c(new b()));
        take = SequencesKt___SequencesKt.take(sortedWith, 80);
        list = SequencesKt___SequencesKt.toList(take);
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            Pair pair = (Pair) ((Map.Entry) list.get(i3)).getKey();
            DebugEntry debugEntry = (DebugEntry) ((Map.Entry) list.get(i3)).getValue();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            i3++;
            takeLast = StringsKt___StringsKt.takeLast((String) pair.getFirst(), 60);
            String format = String.format("TOP %d: %s %s max: %.3f ms avg: %.3f ms cnt: %d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), takeLast, pair.getSecond(), Double.valueOf(debugEntry.getMaxCostInNano() / 1000000.0d), Double.valueOf((debugEntry.getTotalCosts() / 1000000.0d) / debugEntry.getCount()), Integer.valueOf(debugEntry.getCount())}, 6));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            sb5.append(format);
            Intrinsics.checkNotNullExpressionValue(sb5, "append(value)");
            sb5.append('\n');
            Intrinsics.checkNotNullExpressionValue(sb5, "append('\\n')");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
        return sb6;
    }

    private final Runnable e() {
        return (Runnable) calculateRunnable.getValue();
    }

    private final LinkedBlockingQueue<Object[]> f() {
        return (LinkedBlockingQueue) queue.getValue();
    }

    private final ScheduledExecutorService g() {
        return (ScheduledExecutorService) scheduledExecutorService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable h() {
        return new Runnable() { // from class: com.tencent.mobileqq.guild.widget.adapterdelegates.j
            @Override // java.lang.Runnable
            public final void run() {
                Debug.i();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        Object[] poll;
        Unit unit;
        int size = f236182a.f().size();
        boolean z16 = false;
        for (int i3 = 0; i3 < size && (poll = f236182a.f().poll()) != null; i3++) {
            String canonicalName = poll[1].getClass().getCanonicalName();
            Intrinsics.checkNotNull(canonicalName);
            Object obj = poll[0];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.adapterdelegates.Debug.Type");
            Pair<String, Type> pair = new Pair<>(canonicalName, (Type) obj);
            Object obj2 = poll[2];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Long");
            long longValue = ((Long) obj2).longValue();
            DebugEntry debugEntry = costMap.get(pair);
            if (debugEntry != null) {
                debugEntry.d(debugEntry.getCount() + 1);
                debugEntry.f(debugEntry.getTotalCosts() + longValue);
                debugEntry.e(Math.max(debugEntry.getMaxCostInNano(), longValue));
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                costMap.put(pair, new DebugEntry(1, longValue, longValue));
            }
        }
        String d16 = f236182a.d();
        if (d16.length() > 0) {
            z16 = true;
        }
        if (z16) {
            Function1<? super String, Unit> function1 = callback;
            if (function1 != null) {
                function1.invoke(d16);
            }
            Logger logger = Logger.f235387a;
            logger.d().i("Delegate-Debug", 1, "---------------------------------------");
            logger.d().i("Delegate-Debug", 1, d16);
            logger.d().i("Delegate-Debug", 1, "---------------------------------------");
        }
    }

    @JvmStatic
    public static final <T> void j(@NotNull com.tencent.mobileqq.guild.widget.adapterdelegates.b<T> delegate, @NotNull T items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        long nanoTime = System.nanoTime();
        delegate.c(items, position, holder, payloads);
        f236182a.f().add(new Object[]{Type.BIND, delegate, Long.valueOf(System.nanoTime() - nanoTime)});
    }

    @JvmStatic
    @NotNull
    public static final <T> RecyclerView.ViewHolder k(@NotNull com.tencent.mobileqq.guild.widget.adapterdelegates.b<T> delegate, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(parent, "parent");
        long nanoTime = System.nanoTime();
        RecyclerView.ViewHolder d16 = delegate.d(parent);
        Intrinsics.checkNotNullExpressionValue(d16, "delegate.onCreateViewHolder(parent)");
        f236182a.f().add(new Object[]{Type.CREATE, delegate, Long.valueOf(System.nanoTime() - nanoTime)});
        return d16;
    }

    public final void l(@Nullable Function1<? super String, Unit> callback2) {
        Logger.f235387a.d().i("Delegate-Debug", 1, "startCollect");
        callback = callback2;
        ScheduledFuture<?> scheduledFuture = future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        future = null;
        ENABLE_DEBUG = true;
        costMap.clear();
        f().clear();
        future = g().scheduleWithFixedDelay(e(), 0L, 1L, TimeUnit.SECONDS);
    }

    public final void m() {
        Logger.f235387a.d().i("Delegate-Debug", 1, "stopCollect");
        Function1<? super String, Unit> function1 = callback;
        if (function1 != null) {
            function1.invoke("");
        }
        callback = null;
        ENABLE_DEBUG = false;
        costMap.clear();
        f().clear();
        ScheduledFuture<?> scheduledFuture = future;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        future = null;
    }
}
