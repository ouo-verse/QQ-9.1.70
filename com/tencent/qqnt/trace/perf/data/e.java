package com.tencent.qqnt.trace.perf.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.trace.perf.AIOPerfDataType;
import com.tencent.qqnt.trace.perf.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB+\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0004*\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016R\u0014\u0010\u000e\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\rR\u0016\u0010\u0019\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/trace/perf/data/e;", "Lcom/tencent/qqnt/trace/perf/a;", "", "b", "", "c", "Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "getType", "", "getTitle", "", "getContentList", "a", "J", "totalTime", "Ljava/util/List;", "frameTimeList", "gcPerf", "d", "averageFrameTime", "e", "minFrameTime", "f", "maxFrameTime", "g", "skipFrameCount", "<init>", "(JLjava/util/List;Ljava/util/List;)V", h.F, "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements com.tencent.qqnt.trace.perf.a<e> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long totalTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> frameTimeList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Long> gcPerf;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long averageFrameTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long minFrameTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long maxFrameTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long skipFrameCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/trace/perf/data/e$a;", "", "", "FRAME_INTERVAL", "I", "GC_PERF_BLOCK_COST", "GC_PERF_BLOCK_COUNT", "GC_PERF_COST", "GC_PERF_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.trace.perf.data.e$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43095);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(long j3, @NotNull List<Long> frameTimeList, @NotNull List<Long> gcPerf) {
        Intrinsics.checkNotNullParameter(frameTimeList, "frameTimeList");
        Intrinsics.checkNotNullParameter(gcPerf, "gcPerf");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), frameTimeList, gcPerf);
            return;
        }
        this.totalTime = j3;
        this.frameTimeList = frameTimeList;
        this.gcPerf = gcPerf;
    }

    private final void b() {
        if (this.averageFrameTime != 0 || this.frameTimeList.size() < 3) {
            return;
        }
        int size = this.frameTimeList.size() - 2;
        int i3 = 1;
        long longValue = this.frameTimeList.get(1).longValue();
        this.skipFrameCount = 0L;
        this.minFrameTime = this.frameTimeList.get(1).longValue();
        this.maxFrameTime = this.frameTimeList.get(1).longValue();
        int size2 = this.frameTimeList.size();
        if (1 <= size) {
            while (true) {
                long longValue2 = this.frameTimeList.get(i3).longValue();
                if (longValue2 < this.minFrameTime) {
                    this.minFrameTime = longValue2;
                }
                if (longValue2 > this.maxFrameTime) {
                    this.maxFrameTime = longValue2;
                }
                longValue += longValue2;
                if (longValue2 > 16666667) {
                    this.skipFrameCount += (int) (longValue2 / 16666667);
                }
                if (i3 == size) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.averageFrameTime = longValue / size2;
        this.minFrameTime = c(this.minFrameTime);
        this.maxFrameTime = c(this.maxFrameTime);
        this.averageFrameTime = c(this.averageFrameTime);
    }

    private final long c(long j3) {
        return j3 / 1000000;
    }

    @Override // com.tencent.qqnt.trace.perf.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) eVar);
        } else {
            a.C9704a.a(this, eVar);
        }
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public List<String> getContentList() {
        List<String> listOf;
        List<String> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.totalTime == 0 && this.frameTimeList.isEmpty()) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf("\u52a8\u753b\u76d1\u63a7\u672a\u5f00\u542f");
            return listOf2;
        }
        b();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u52a8\u753b\u603b\u65f6\u95f4\uff1a" + c(this.totalTime) + " ms  \u603b\u5e27\u6570\uff1a" + this.frameTimeList.size() + " \u4e22\u5e27\u6570\uff1a" + this.skipFrameCount, "\u5e73\u5747\u5e27\uff1a" + this.averageFrameTime + " ms  \u6700\u5c0f\u5e27\uff1a" + this.minFrameTime + " ms  \u6700\u5927\u5e27\uff1a" + this.maxFrameTime + " ms", "GC \u6b21\u6570\uff1a" + this.gcPerf.get(0) + "  \u8017\u65f6\uff1a" + this.gcPerf.get(1) + " ms", "GC \u963b\u585e\u6b21\u6570\uff1a" + this.gcPerf.get(2) + "  \u8017\u65f6\uff1a" + this.gcPerf.get(3) + " ms"});
        return listOf;
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "AIO \u52a8\u753b";
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public AIOPerfDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOPerfDataType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AIOPerfDataType.AIO_TRANSITION_ANIMATION_PERF;
    }
}
