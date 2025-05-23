package gx2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKEventCenter;
import com.tencent.ams.dsdk.event.DKEventHandler;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.HippyEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pw2.n;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 22\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u00100\u001a\u00020)\u00a2\u0006\u0004\b1\u0010/J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u000f\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010\u0010\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J0\u0010\u0013\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u0014\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u0015\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J.\u0010\u0017\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\nH\u0016J&\u0010\u0018\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u0016\u0010\"\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0016\u0010$\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0016\u0010&\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lgx2/a;", "Lcom/tencent/ams/dsdk/event/DKEventHandler;", "", "callid", "Lcom/tencent/ams/dsdk/event/DKEventCenter$EngineType;", "enginType", "", "onEngineInitParams", "callId", TagName.ENGINE_TYPE, "", "errorCode", "onEngineCreateFail", "onEngineCreated", "onEngineInit", "onEngineInitSuccess", "onEngineInitFail", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_AD_TYPE, "bundleId", "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATE_FAIL, HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "onJsBundleLoadComplete", "onViewLoadComplete", "", "a", "J", "onEngineInitParamsTs", "b", "onEngineCreatedTs", "c", "onEngineInitdTs", "d", "onEngineInitSuccessTs", "e", "onCreateViewTs", "f", "onViewCreateSuccessTs", "g", "Ljava/lang/String;", "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;", h.F, "Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;", "getRewardDynamicReporter", "()Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;", "setRewardDynamicReporter", "(Lcom/tencent/mobileqq/tvideo/ad/miniqadsdk/rewardad/report/a;)V", "rewardDynamicReporter", "<init>", "i", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes19.dex */
public final class a implements DKEventHandler {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final C10400a f403700i = new C10400a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long onEngineInitParamsTs;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long onEngineCreatedTs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long onEngineInitdTs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long onEngineInitSuccessTs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long onCreateViewTs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long onViewCreateSuccessTs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String bundleId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a rewardDynamicReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lgx2/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "MiniQAdSdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: gx2.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    private static final class C10400a {
        C10400a() {
        }

        public /* synthetic */ C10400a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(@NotNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a rewardDynamicReporter) {
        Intrinsics.checkNotNullParameter(rewardDynamicReporter, "rewardDynamicReporter");
        this.rewardDynamicReporter = rewardDynamicReporter;
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onCreateView(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, @Nullable String adType, @Nullable String bundleId) {
        this.onCreateViewTs = System.currentTimeMillis();
        this.bundleId = bundleId;
        n.a("QAdDynamicRewardEventHandler", "onCreateView, callId: " + callId + ", timeCost: " + (System.currentTimeMillis() - this.onEngineInitSuccessTs) + ", bundleId: " + bundleId);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onEngineCreateFail(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, int errorCode) {
        long currentTimeMillis = System.currentTimeMillis() - this.onEngineInitParamsTs;
        n.a("QAdDynamicRewardEventHandler", "onEngineCreateFail, callId: " + callId + ", cost: " + currentTimeMillis + ", errorCode: " + errorCode);
        this.rewardDynamicReporter.j(callId, engineType, errorCode, currentTimeMillis);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onEngineCreated(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType) {
        long currentTimeMillis = System.currentTimeMillis();
        this.onEngineCreatedTs = currentTimeMillis;
        long j3 = currentTimeMillis - this.onEngineInitParamsTs;
        n.a("QAdDynamicRewardEventHandler", "onEngineCreated, callId: " + callId + ", cost: " + j3);
        this.rewardDynamicReporter.j(callId, enginType, 0, j3);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onEngineInit(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType) {
        this.onEngineInitdTs = System.currentTimeMillis();
        n.a("QAdDynamicRewardEventHandler", "onEngineInit, callId: " + callId + ", cost: " + (System.currentTimeMillis() - this.onEngineCreatedTs));
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onEngineInitFail(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType, int errorCode) {
        long currentTimeMillis = System.currentTimeMillis() - this.onEngineInitdTs;
        n.a("QAdDynamicRewardEventHandler", "onEngineInitFail, callId: " + callId + ", cost: " + currentTimeMillis + ", errorCode: " + errorCode);
        this.rewardDynamicReporter.k(callId, enginType, errorCode, currentTimeMillis);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onEngineInitParams(@Nullable String callid, @Nullable DKEventCenter.EngineType enginType) {
        n.a("QAdDynamicRewardEventHandler", "onEngineInitParams, callId: " + callid + ", engineType: " + enginType);
        this.onEngineInitParamsTs = System.currentTimeMillis();
        this.rewardDynamicReporter.m(callid, enginType);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onEngineInitSuccess(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType) {
        long currentTimeMillis = System.currentTimeMillis();
        this.onEngineInitSuccessTs = currentTimeMillis;
        long j3 = currentTimeMillis - this.onEngineInitdTs;
        n.a("QAdDynamicRewardEventHandler", "onEngineInitSuccess, callId: " + callId + ", cost: " + j3);
        this.rewardDynamicReporter.k(callId, enginType, HippyEngine.EngineInitStatus.STATUS_OK.value(), j3);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onJsBundleLoadComplete(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType, @Nullable String adType, int statusCode) {
        long currentTimeMillis = System.currentTimeMillis() - this.onCreateViewTs;
        n.a("QAdDynamicRewardEventHandler", "onJsBundleLoadComplete, callId: " + callId + ", timeCost: " + currentTimeMillis + ", statusCode: " + statusCode);
        this.rewardDynamicReporter.l(callId, enginType, this.bundleId, statusCode, currentTimeMillis);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onViewCreateFail(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType, int errorCode, @Nullable String adType) {
        long currentTimeMillis = System.currentTimeMillis() - this.onCreateViewTs;
        n.a("QAdDynamicRewardEventHandler", "onViewCreateFail, callId: " + callId + ", timeCost: " + currentTimeMillis + ", errorCode: " + errorCode);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a.o(this.rewardDynamicReporter, callId, enginType, errorCode, currentTimeMillis, this.bundleId, 0, 32, null);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onViewCreated(@Nullable String callId, @Nullable DKEventCenter.EngineType engineType, @Nullable String adType) {
        long currentTimeMillis = System.currentTimeMillis();
        this.onViewCreateSuccessTs = currentTimeMillis;
        long j3 = currentTimeMillis - this.onCreateViewTs;
        n.a("QAdDynamicRewardEventHandler", "onViewCreated, callId: " + callId + ", timeCost: " + j3);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.report.a.o(this.rewardDynamicReporter, callId, engineType, 9000, j3, this.bundleId, 0, 32, null);
    }

    @Override // com.tencent.ams.dsdk.event.DKEventHandler
    public void onViewLoadComplete(@Nullable String callId, @Nullable DKEventCenter.EngineType enginType, @Nullable String adType) {
        long currentTimeMillis = System.currentTimeMillis() - this.onCreateViewTs;
        n.a("QAdDynamicRewardEventHandler", "onViewLoadComplete, callId: " + callId + ", timeCost: " + currentTimeMillis);
        this.rewardDynamicReporter.p(callId, enginType, this.bundleId, currentTimeMillis);
    }
}
