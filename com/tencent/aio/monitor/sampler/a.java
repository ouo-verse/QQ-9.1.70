package com.tencent.aio.monitor.sampler;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u0000 \u00152\u00020\u0001:\u0002/0B)\u0012\u0006\u0010&\u001a\u00020#\u0012\b\b\u0002\u0010(\u001a\u00020\u0006\u0012\u0006\u0010)\u001a\u00020\u0010\u0012\u0006\u0010*\u001a\u00020\u0010\u00a2\u0006\u0004\b+\u0010,B!\b\u0016\u0012\u0006\u0010-\u001a\u00020#\u0012\u0006\u0010)\u001a\u00020\u0010\u0012\u0006\u0010*\u001a\u00020\u0010\u00a2\u0006\u0004\b+\u0010.J7\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u000e2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007H\u0002J\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J2\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0017`\u00182\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u001a\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016J\u0006\u0010\u001c\u001a\u00020\u0014J\b\u0010\u001d\u001a\u00020\tH\u0016R0\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0017`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010'\u00a8\u00061"}, d2 = {"Lcom/tencent/aio/monitor/sampler/a;", "Lcom/tencent/aio/monitor/sampler/AbstractSampler;", "", "Ljava/lang/StackTraceElement;", "stackTrace", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hashCodeList", "", h.F, "([Ljava/lang/StackTraceElement;Ljava/util/ArrayList;)V", "left", "right", "", "l", "", "startTimeMs", "endTimeMs", "", "", "k", "Ljava/util/LinkedHashMap;", "Lcom/tencent/aio/monitor/sampler/a$b;", "Lkotlin/collections/LinkedHashMap;", "i", "d", "e", "j", "c", "Ljava/util/LinkedHashMap;", "mStackEntryMap", "f", "Lcom/tencent/aio/monitor/sampler/a$b;", "mCurrEntry", "Ljava/lang/Thread;", "g", "Ljava/lang/Thread;", "mCurrentThread", "I", "mMaxEntryCount", "sampleIntervalMillis", "sampleDelay", "<init>", "(Ljava/lang/Thread;IJJ)V", MosaicConstants$JsProperty.PROP_THREAD, "(Ljava/lang/Thread;JJ)V", "a", "b", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class a extends AbstractSampler {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    private static int f69425i;

    /* renamed from: j, reason: collision with root package name */
    private static int f69426j;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashMap<Long, b> mStackEntryMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private b mCurrEntry;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Thread mCurrentThread;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int mMaxEntryCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/aio/monitor/sampler/a$a;", "", "", "MAX_LEVEL", "I", "getMAX_LEVEL", "()I", "b", "(I)V", "SERIOUS_COUNT", "a", "setSERIOUS_COUNT", "DEFAULT_MAX_ENTRY_COUNT", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.monitor.sampler.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return a.f69426j;
            }
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }

        public final void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.f69425i = i3;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR2\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u000bj\b\u0012\u0004\u0012\u00020\u0004`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000bj\b\u0012\u0004\u0012\u00020\u0002`\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/aio/monitor/sampler/a$b;", "", "", "toString", "", "a", "I", "()I", "d", "(I)V", "count", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "e", "(Ljava/util/ArrayList;)V", "hashStackList", "c", "stackLineList", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int count;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<Integer> hashStackList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<String> stackLineList;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else {
                this.hashStackList = new ArrayList<>();
                this.stackLineList = new ArrayList<>();
            }
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
            }
            return this.count;
        }

        @NotNull
        public final ArrayList<Integer> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.hashStackList;
        }

        @NotNull
        public final ArrayList<String> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (ArrayList) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.stackLineList;
        }

        public final void d(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else {
                this.count = i3;
            }
        }

        public final void e(@NotNull ArrayList<Integer> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) arrayList);
            } else {
                Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
                this.hashStackList = arrayList;
            }
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("count=" + this.count);
            sb5.append(" \r\n ");
            Iterator<String> it = this.stackLineList.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
                sb5.append(" \r\n ");
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sBuilder.toString()");
            return sb6;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45452);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
            return;
        }
        INSTANCE = new Companion(null);
        f69425i = 30;
        f69426j = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Thread mCurrentThread, int i3, long j3, long j16) {
        super(j3, j16);
        Intrinsics.checkNotNullParameter(mCurrentThread, "mCurrentThread");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, mCurrentThread, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        this.mCurrentThread = mCurrentThread;
        this.mMaxEntryCount = i3;
        this.mStackEntryMap = new LinkedHashMap<>();
        this.mCurrEntry = new b();
    }

    private final void h(StackTraceElement[] stackTrace, ArrayList<Integer> hashCodeList) {
        int coerceAtMost;
        b bVar = new b();
        this.mCurrEntry = bVar;
        bVar.d(1);
        this.mCurrEntry.e(hashCodeList);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(f69425i, stackTrace.length);
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            this.mCurrEntry.c().add(stackTrace[i3].toString());
        }
        synchronized (this.mStackEntryMap) {
            int size = this.mStackEntryMap.size();
            int i16 = this.mMaxEntryCount;
            if (size == i16 && i16 > 0) {
                Long next = this.mStackEntryMap.keySet().iterator().next();
                Intrinsics.checkNotNullExpressionValue(next, "mStackEntryMap.keys.iterator().next()");
                this.mStackEntryMap.remove(Long.valueOf(next.longValue()));
            }
            this.mStackEntryMap.put(Long.valueOf(System.currentTimeMillis()), this.mCurrEntry);
        }
    }

    private final boolean l(ArrayList<Integer> left, ArrayList<Integer> right) {
        if (left.isEmpty() || right.isEmpty() || left.size() != right.size()) {
            return false;
        }
        int size = left.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (true ^ Intrinsics.areEqual(left.get(i3), right.get(i3))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.aio.monitor.sampler.AbstractSampler
    public void c() {
        int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        StackTraceElement[] stackTrace = this.mCurrentThread.getStackTrace();
        ArrayList<Integer> arrayList = new ArrayList<>(stackTrace.length);
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(f69425i, stackTrace.length);
        for (int i3 = 0; i3 < coerceAtMost; i3++) {
            arrayList.add(Integer.valueOf(stackTrace[i3].hashCode()));
        }
        if (l(arrayList, this.mCurrEntry.b())) {
            b bVar = this.mCurrEntry;
            bVar.d(bVar.a() + 1);
        } else {
            Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
            h(stackTrace, arrayList);
        }
    }

    @Override // com.tencent.aio.monitor.sampler.AbstractSampler
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!this.mStackEntryMap.isEmpty()) {
            this.mStackEntryMap.clear();
        }
        this.mCurrEntry = new b();
        super.d();
    }

    @Override // com.tencent.aio.monitor.sampler.AbstractSampler
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!this.mStackEntryMap.isEmpty()) {
            this.mStackEntryMap.clear();
        }
        super.e();
    }

    @NotNull
    public final LinkedHashMap<Long, b> i(long startTimeMs, long endTimeMs) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LinkedHashMap) iPatchRedirector.redirect((short) 2, this, Long.valueOf(startTimeMs), Long.valueOf(endTimeMs));
        }
        LinkedHashMap<Long, b> linkedHashMap = new LinkedHashMap<>();
        synchronized (this.mStackEntryMap) {
            for (Long entryTime : this.mStackEntryMap.keySet()) {
                long j3 = 1 + startTimeMs;
                Intrinsics.checkNotNullExpressionValue(entryTime, "entryTime");
                long longValue = entryTime.longValue();
                if (j3 <= longValue && endTimeMs > longValue && (bVar = this.mStackEntryMap.get(entryTime)) != null) {
                    Intrinsics.checkNotNullExpressionValue(bVar, "mStackEntryMap[entryTime] ?: continue");
                    linkedHashMap.put(entryTime, bVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return linkedHashMap;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        String name = this.mCurrentThread.getName();
        Intrinsics.checkNotNullExpressionValue(name, "mCurrentThread.name");
        return name;
    }

    @NotNull
    public final List<String> k(long startTimeMs, long endTimeMs) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, this, Long.valueOf(startTimeMs), Long.valueOf(endTimeMs));
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mStackEntryMap) {
            for (Long entryTime : this.mStackEntryMap.keySet()) {
                long j3 = 1 + startTimeMs;
                Intrinsics.checkNotNullExpressionValue(entryTime, "entryTime");
                long longValue = entryTime.longValue();
                if (j3 <= longValue && endTimeMs > longValue && (bVar = this.mStackEntryMap.get(entryTime)) != null) {
                    Intrinsics.checkNotNullExpressionValue(bVar, "mStackEntryMap[entryTime] ?: continue");
                    arrayList.add(com.tencent.aio.monitor.helper.a.f69420b.c().format(entryTime) + ", " + bVar);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        return arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Thread thread, long j3, long j16) {
        this(thread, 100, j3, j16);
        Intrinsics.checkNotNullParameter(thread, "thread");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, this, thread, Long.valueOf(j3), Long.valueOf(j16));
    }
}
