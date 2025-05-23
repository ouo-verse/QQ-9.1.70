package com.tencent.aio.monitor;

import android.os.Debug;
import android.view.Choreographer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.perf.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b\u0016\u0010%R$\u0010)\u001a\u00020 2\u0006\u0010'\u001a\u00020 8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b(\u0010\"\u001a\u0004\b\u0013\u0010$R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010+\u00a8\u00066"}, d2 = {"Lcom/tencent/aio/monitor/PerfFrameCollector;", "Landroid/view/Choreographer$FrameCallback;", "", "d", "", "", "j", "Lcom/tencent/aio/api/perf/a;", "callback", "c", "i", "e", "frameTimeNanos", "doFrame", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "callbacks", "frameCostList", "", "f", "[J", "gcData", h.F, "J", "startTime", "Lcom/tencent/aio/monitor/PerfFrameCollector$a;", "Lcom/tencent/aio/monitor/PerfFrameCollector$a;", "getConfig", "()Lcom/tencent/aio/monitor/PerfFrameCollector$a;", "g", "(Lcom/tencent/aio/monitor/PerfFrameCollector$a;)V", DownloadInfo.spKey_Config, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getEnablePerf", "()Z", "(Z)V", "enablePerf", "<set-?>", BdhLogUtil.LogTag.Tag_Conn, "recording", "D", "Ljava/lang/String;", "startGCCount", "E", "startGCTime", UserInfo.SEX_FEMALE, "startGCBlockCount", "G", "startGCBlockTime", "<init>", "()V", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class PerfFrameCollector implements Choreographer.FrameCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private static boolean recording;

    /* renamed from: D, reason: from kotlin metadata */
    private static String startGCCount;

    /* renamed from: E, reason: from kotlin metadata */
    private static String startGCTime;

    /* renamed from: F, reason: from kotlin metadata */
    private static String startGCBlockCount;

    /* renamed from: G, reason: from kotlin metadata */
    private static String startGCBlockTime;

    @NotNull
    public static final PerfFrameCollector H;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<com.tencent.aio.api.perf.a> callbacks;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<Long> frameCostList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final long[] gcData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static a config;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static boolean enablePerf;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aio/monitor/PerfFrameCollector$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "enableFrameRecord", "b", "enableGcRecord", "<init>", "(ZZ)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final boolean enableFrameRecord;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final boolean enableGcRecord;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public a() {
            this(r2, r2, 3, null);
            boolean z16 = false;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this);
        }

        public final boolean a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                return ((Boolean) iPatchRedirector.redirect((short) 1, (Object) this)).booleanValue();
            }
            return this.enableFrameRecord;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.enableGcRecord;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this != other) {
                if (other instanceof a) {
                    a aVar = (a) other;
                    if (this.enableFrameRecord != aVar.enableFrameRecord || this.enableGcRecord != aVar.enableGcRecord) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            boolean z16 = this.enableFrameRecord;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.enableGcRecord;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i16 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "Config(enableFrameRecord=" + this.enableFrameRecord + ", enableGcRecord=" + this.enableGcRecord + ")";
        }

        public a(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else {
                this.enableFrameRecord = z16;
                this.enableGcRecord = z17;
            }
        }

        public /* synthetic */ a(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        H = new PerfFrameCollector();
        callbacks = new CopyOnWriteArrayList<>();
        frameCostList = new CopyOnWriteArrayList<>();
        gcData = new long[4];
        boolean z16 = false;
        config = new a(z16, z16, 3, null);
        startGCCount = "0";
        startGCTime = "0";
        startGCBlockCount = "0";
        startGCBlockTime = "0";
    }

    PerfFrameCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        long sumOfLong;
        double averageOfLong;
        long sumOfLong2;
        List list;
        for (com.tencent.aio.api.perf.a aVar : callbacks) {
            CopyOnWriteArrayList<Long> copyOnWriteArrayList = frameCostList;
            sumOfLong2 = CollectionsKt___CollectionsKt.sumOfLong(copyOnWriteArrayList);
            ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
            list = ArraysKt___ArraysKt.toList(gcData);
            aVar.a(new a.b(sumOfLong2, arrayList, list));
        }
        if (config.a()) {
            com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sumTime: ");
            CopyOnWriteArrayList<Long> copyOnWriteArrayList2 = frameCostList;
            sumOfLong = CollectionsKt___CollectionsKt.sumOfLong(copyOnWriteArrayList2);
            sb5.append(sumOfLong);
            sb5.append(", count: ");
            sb5.append(copyOnWriteArrayList2.size());
            sb5.append(", frame rate: ");
            averageOfLong = CollectionsKt___CollectionsKt.averageOfLong(copyOnWriteArrayList2);
            sb5.append(averageOfLong);
            aVar2.d("PerfFrameCollector", sb5.toString());
            aVar2.d("PerfFrameCollector", "origin data: " + copyOnWriteArrayList2);
        }
        if (config.b()) {
            com.tencent.aio.base.log.a aVar3 = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("GC Data: GCCount: ");
            long[] jArr = gcData;
            sb6.append(jArr[0]);
            sb6.append(", GCTime: ");
            sb6.append(jArr[1]);
            sb6.append(", GCBlockCount: ");
            sb6.append(jArr[2]);
            sb6.append(", GCBlockTime: ");
            sb6.append(jArr[3]);
            aVar3.d("PerfFrameCollector", sb6.toString());
        }
        callbacks.clear();
    }

    private final long j(String str) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (longOrNull != null) {
            return longOrNull.longValue();
        }
        return 0L;
    }

    public final void c(@NotNull com.tencent.aio.api.perf.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            callbacks.addIfAbsent(callback);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long frameTimeNanos) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, frameTimeNanos);
            return;
        }
        CopyOnWriteArrayList<Long> copyOnWriteArrayList = frameCostList;
        if (copyOnWriteArrayList.size() > 50) {
            recording = false;
            callbacks.clear();
        } else {
            copyOnWriteArrayList.add(Long.valueOf(frameTimeNanos - startTime));
            startTime = frameTimeNanos;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (!enablePerf) {
            return;
        }
        if (config.a()) {
            Choreographer.getInstance().removeFrameCallback(this);
        }
        if (config.b()) {
            long[] jArr = gcData;
            String runtimeStat = Debug.getRuntimeStat("art.gc.gc-count");
            Intrinsics.checkNotNullExpressionValue(runtimeStat, "Debug.getRuntimeStat(\"art.gc.gc-count\")");
            jArr[0] = j(runtimeStat) - j(startGCCount);
            String runtimeStat2 = Debug.getRuntimeStat("art.gc.gc-time");
            Intrinsics.checkNotNullExpressionValue(runtimeStat2, "Debug.getRuntimeStat(\"art.gc.gc-time\")");
            jArr[1] = j(runtimeStat2) - j(startGCTime);
            String runtimeStat3 = Debug.getRuntimeStat("art.gc.blocking-gc-count");
            Intrinsics.checkNotNullExpressionValue(runtimeStat3, "Debug.getRuntimeStat(\"art.gc.blocking-gc-count\")");
            jArr[2] = j(runtimeStat3) - j(startGCBlockCount);
            String runtimeStat4 = Debug.getRuntimeStat("art.gc.blocking-gc-time");
            Intrinsics.checkNotNullExpressionValue(runtimeStat4, "Debug.getRuntimeStat(\"art.gc.blocking-gc-time\")");
            jArr[3] = j(runtimeStat4) - j(startGCBlockTime);
        }
        recording = false;
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), null, new PerfFrameCollector$endPerf$1(null), 2, null);
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return recording;
    }

    public final void g(@NotNull a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            config = aVar;
        }
    }

    public final void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            enablePerf = z16;
        }
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (!enablePerf) {
            return;
        }
        startTime = System.nanoTime();
        if (config.a()) {
            frameCostList.clear();
            Choreographer.getInstance().postFrameCallback(this);
        }
        if (config.b()) {
            String runtimeStat = Debug.getRuntimeStat("art.gc.gc-count");
            Intrinsics.checkNotNullExpressionValue(runtimeStat, "Debug.getRuntimeStat(\"art.gc.gc-count\")");
            startGCCount = runtimeStat;
            String runtimeStat2 = Debug.getRuntimeStat("art.gc.gc-time");
            Intrinsics.checkNotNullExpressionValue(runtimeStat2, "Debug.getRuntimeStat(\"art.gc.gc-time\")");
            startGCTime = runtimeStat2;
            String runtimeStat3 = Debug.getRuntimeStat("art.gc.blocking-gc-count");
            Intrinsics.checkNotNullExpressionValue(runtimeStat3, "Debug.getRuntimeStat(\"art.gc.blocking-gc-count\")");
            startGCBlockCount = runtimeStat3;
            String runtimeStat4 = Debug.getRuntimeStat("art.gc.blocking-gc-time");
            Intrinsics.checkNotNullExpressionValue(runtimeStat4, "Debug.getRuntimeStat(\"art.gc.blocking-gc-time\")");
            startGCBlockTime = runtimeStat4;
        }
        recording = true;
    }
}
