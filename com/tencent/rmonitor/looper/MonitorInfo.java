package com.tencent.rmonitor.looper;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.bugly.common.utils.RecyclablePool;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 S2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010&\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010(\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\"\u00105\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R$\u0010<\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b'\u00109\"\u0004\b:\u0010;R\"\u0010B\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b2\u0010?\"\u0004\b@\u0010AR\u0017\u0010G\u001a\u00020C8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\b.\u0010FR\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010>\u001a\u0004\bI\u0010?\"\u0004\bJ\u0010AR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010(R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010(R\u0016\u0010O\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010NR\u0016\u0010P\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010>\u00a8\u0006U"}, d2 = {"Lcom/tencent/rmonitor/looper/c;", "Lcom/tencent/bugly/common/utils/RecyclablePool$Recyclable;", "", "k", "", "delay", "", "r", QCircleWeakNetReporter.KEY_COST, "p", "", "count", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "flag", "w", "reset", "d", "c", "collectStackMsgDelayInMs", "collectStackMsgCostInUs", "b", "g", "", "e", "f", "", "toString", "Ljava/lang/String;", "getThreadId", "()Ljava/lang/String;", "y", "(Ljava/lang/String;)V", "threadId", "getThreadName", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "threadName", "l", HippyTKDListViewAdapter.X, "scene", h.F, "J", "j", "()J", "v", "(J)V", "lastStackRequestTime", "i", "getCacheRealStackTime", "setCacheRealStackTime", "cacheRealStackTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getDuration", "t", "duration", "Lorg/json/JSONObject;", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "u", "(Lorg/json/JSONObject;)V", "fullStack", "D", "Z", "()Z", "o", "(Z)V", "isAppInForeground", "Lcom/tencent/rmonitor/looper/provider/b;", "E", "Lcom/tencent/rmonitor/looper/provider/b;", "()Lcom/tencent/rmonitor/looper/provider/b;", "lagParam", UserInfo.SEX_FEMALE, DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "isDetectedLongLag", "G", "H", "I", "collectStackMsgCount", "quickTraceFlag", "<init>", "()V", "L", "a", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
/* renamed from: com.tencent.rmonitor.looper.c, reason: from toString */
/* loaded from: classes25.dex */
public final class MonitorInfo extends RecyclablePool.Recyclable {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private volatile JSONObject fullStack;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private volatile boolean isAppInForeground;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private boolean isDetectedLongLag;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private long collectStackMsgDelayInMs;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private long collectStackMsgCostInUs;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private int collectStackMsgCount;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private boolean quickTraceFlag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private volatile String scene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private volatile long lastStackRequestTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private volatile long cacheRealStackTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private volatile long duration;

    /* renamed from: L, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ThreadLocal<RecyclablePool> K = new ThreadLocal<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private volatile String threadId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private volatile String threadName = "";

    /* renamed from: E, reason: from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.rmonitor.looper.provider.b lagParam = new com.tencent.rmonitor.looper.provider.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rmonitor/looper/c$a;", "", "Lcom/tencent/bugly/common/utils/RecyclablePool;", "a", "Lcom/tencent/rmonitor/looper/c;", "b", "monitorInfo", "", "c", "", "MAX_STACK_LENGTH", "I", "POOL_CAPACITY", "", "TAG", "Ljava/lang/String;", "Ljava/lang/ThreadLocal;", "recyclablePool", "Ljava/lang/ThreadLocal;", "<init>", "()V", "rmonitor-looper_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.looper.c$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        private final RecyclablePool a() {
            RecyclablePool recyclablePool = (RecyclablePool) MonitorInfo.K.get();
            if (recyclablePool == null) {
                RecyclablePool recyclablePool2 = new RecyclablePool(MonitorInfo.class, 10);
                MonitorInfo.K.set(recyclablePool2);
                return recyclablePool2;
            }
            return recyclablePool;
        }

        @Nullable
        public final MonitorInfo b() {
            RecyclablePool.Recyclable obtain = a().obtain(MonitorInfo.class);
            if (obtain != null) {
                return (MonitorInfo) obtain;
            }
            return null;
        }

        public final void c(@NotNull MonitorInfo monitorInfo) {
            Intrinsics.checkParameterIsNotNull(monitorInfo, "monitorInfo");
            a().recycle(monitorInfo);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void b(long collectStackMsgDelayInMs, long collectStackMsgCostInUs) {
        if (collectStackMsgDelayInMs > 0) {
            this.collectStackMsgDelayInMs += collectStackMsgDelayInMs;
        }
        if (collectStackMsgCostInUs > 0) {
            this.collectStackMsgCostInUs += collectStackMsgCostInUs;
        }
        this.collectStackMsgCount++;
    }

    public final boolean c() {
        String str;
        try {
            if (this.fullStack != null) {
                str = String.valueOf(this.fullStack);
            } else {
                str = null;
            }
            if (str == null) {
                return false;
            }
            if (str.length() <= 524288) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @NotNull
    public final MonitorInfo d() {
        MonitorInfo monitorInfo = new MonitorInfo();
        monitorInfo.threadId = this.threadId;
        monitorInfo.threadName = this.threadName;
        monitorInfo.scene = this.scene;
        monitorInfo.lastStackRequestTime = this.lastStackRequestTime;
        monitorInfo.cacheRealStackTime = this.cacheRealStackTime;
        monitorInfo.duration = this.duration;
        monitorInfo.fullStack = this.fullStack;
        monitorInfo.isAppInForeground = this.isAppInForeground;
        monitorInfo.lagParam.a(this.lagParam);
        monitorInfo.collectStackMsgDelayInMs = this.collectStackMsgDelayInMs;
        monitorInfo.collectStackMsgCostInUs = this.collectStackMsgCostInUs;
        monitorInfo.collectStackMsgCount = this.collectStackMsgCount;
        monitorInfo.quickTraceFlag = this.quickTraceFlag;
        monitorInfo.isDetectedLongLag = this.isDetectedLongLag;
        return monitorInfo;
    }

    public final double e() {
        int i3 = this.collectStackMsgCount;
        if (i3 > 0) {
            return (this.collectStackMsgCostInUs * 1.0d) / i3;
        }
        return 0.0d;
    }

    public final long f() {
        int i3 = this.collectStackMsgCount;
        if (i3 > 0) {
            return this.collectStackMsgDelayInMs / i3;
        }
        return 0L;
    }

    /* renamed from: g, reason: from getter */
    public final int getCollectStackMsgCount() {
        return this.collectStackMsgCount;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final String getThreadId() {
        return this.threadId;
    }

    @NotNull
    public final String getThreadName() {
        return this.threadName;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final JSONObject getFullStack() {
        return this.fullStack;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final com.tencent.rmonitor.looper.provider.b getLagParam() {
        return this.lagParam;
    }

    /* renamed from: j, reason: from getter */
    public final long getLastStackRequestTime() {
        return this.lastStackRequestTime;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getQuickTraceFlag() {
        return this.quickTraceFlag;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getScene() {
        return this.scene;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsAppInForeground() {
        return this.isAppInForeground;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsDetectedLongLag() {
        return this.isDetectedLongLag;
    }

    public final void o(boolean z16) {
        this.isAppInForeground = z16;
    }

    public final void p(long cost) {
        this.collectStackMsgCostInUs = cost;
    }

    public final void q(int count) {
        this.collectStackMsgCount = count;
    }

    public final void r(long delay) {
        this.collectStackMsgDelayInMs = delay;
    }

    @Override // com.tencent.bugly.common.utils.RecyclablePool.Recyclable
    public void reset() {
        this.threadId = "";
        this.threadName = "";
        this.scene = null;
        this.lastStackRequestTime = 0L;
        this.cacheRealStackTime = 0L;
        this.duration = 0L;
        this.fullStack = null;
        this.isAppInForeground = false;
        this.lagParam.b();
        this.collectStackMsgDelayInMs = 0L;
        this.collectStackMsgCostInUs = 0L;
        this.collectStackMsgCount = 0;
        this.quickTraceFlag = false;
        this.isDetectedLongLag = false;
    }

    public final void s(boolean z16) {
        this.isDetectedLongLag = z16;
    }

    public final void t(long j3) {
        this.duration = j3;
    }

    @NotNull
    public String toString() {
        return "MonitorInfo(threadId=" + this.threadId + ", threadName=" + this.threadName + ", scene=" + this.scene + ", lastStackRequestTime=" + this.lastStackRequestTime + ", cacheRealStackTime=" + this.cacheRealStackTime + ", duration=" + this.duration + ", isAppInForeground=" + this.isAppInForeground + ", lagParam=" + this.lagParam + ", collectStackMsgDelayInMs=" + this.collectStackMsgDelayInMs + ", collectStackMsgCostInUs=" + this.collectStackMsgCostInUs + ", collectStackMsgCount=" + this.collectStackMsgCount + ", quickTraceFlag=" + this.quickTraceFlag + ", isDetectedLongLag=" + this.isDetectedLongLag;
    }

    public final void u(@Nullable JSONObject jSONObject) {
        this.fullStack = jSONObject;
    }

    public final void v(long j3) {
        this.lastStackRequestTime = j3;
    }

    public final void w(boolean flag) {
        this.quickTraceFlag = flag;
    }

    public final void x(@Nullable String str) {
        this.scene = str;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.threadId = str;
    }

    public final void z(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.threadName = str;
    }
}
