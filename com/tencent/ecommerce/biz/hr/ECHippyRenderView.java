package com.tencent.ecommerce.biz.hr;

import android.content.Context;
import android.util.Size;
import android.widget.FrameLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.ui.api.IECRenderViewRegister;
import com.tencent.ecommerce.biz.hr.component.HRAPNGView;
import com.tencent.ecommerce.biz.hr.component.HRAdsorptionPullView;
import com.tencent.ecommerce.biz.hr.component.HRCircleAvatarView;
import com.tencent.ecommerce.biz.hr.component.HREdgeTranslucentView;
import com.tencent.ecommerce.biz.hr.component.HRFragmentView;
import com.tencent.ecommerce.biz.hr.component.HRGameButton;
import com.tencent.ecommerce.biz.hr.component.HRGuildMixBackgroundView;
import com.tencent.ecommerce.biz.hr.component.HRPAGView;
import com.tencent.ecommerce.biz.hr.component.HRQQCircleRichTextView;
import com.tencent.ecommerce.biz.hr.component.HRQQECChartView;
import com.tencent.ecommerce.biz.hr.component.HRQQFaceImageView;
import com.tencent.ecommerce.biz.hr.component.HRSearchBar;
import com.tencent.ecommerce.biz.hr.module.HRBridgeModule;
import com.tencent.ecommerce.biz.hr.module.f;
import com.tencent.ecommerce.biz.hr.module.g;
import com.tencent.ecommerce.biz.hr.prop.ECHRDtViewPropHandler;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.kuikly.core.render.android.b;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.exception.KRAarBizException;
import com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator;
import com.tencent.kuikly.core.render.android.expand.a;
import com.tencent.kuikly.core.render.android.performace.KRMonitorType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 S2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0011B9\u0012\u0006\u0010P\u001a\u00020O\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0003\u0012\u001c\b\u0002\u0010N\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010\u0018\u00010K\u00a2\u0006\u0004\bQ\u0010RJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u00102\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\rH\u0002J6\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020#H\u0016J$\u0010'\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00042\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016J \u0010-\u001a\u00020\u00072\u0006\u0010)\u001a\u00020(2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020#H\u0016J\u001a\u0010.\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010J\u001a\u0010/\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010J\u001a\u00100\u001a\u00020\u00072\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010R\u0016\u00103\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00102R\u0016\u00105\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00104R\"\u0010<\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010>R\"\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020@0\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR(\u0010N\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0010\u0018\u00010K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/ECHippyRenderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/ecommerce/biz/hr/IECHippyRenderView;", "Lcom/tencent/kuikly/core/render/android/expand/a;", "", "tag", "msg", "", "e", "c", "d", "pageName", "b", "", "", "param", "", "a", "contextCode", "params", "Landroid/util/Size;", "size", "onAttach", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onDetach", "", "h4", "Lcom/tencent/kuikly/core/render/android/b;", "hippyRenderExport", "registerExternalModule", "registerExternalRenderView", "registerViewExternalPropHandler", "Sa", "p9", "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "C2", AdMetricTag.EVENT_NAME, "data", "sentEvent", "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "executeMode", "Ia", h.F, "g", "f", "Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator;", "Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator;", "hippyRenderViewDelegator", "Ljava/lang/String;", "pagerName", "", "I", "getPageProgressStatus", "()I", "setPageProgressStatus", "(I)V", "pageProgressStatus", "", "J", "pageStartTs", "Lcom/tencent/ecommerce/base/report/service/ECShowPageCostTimeScene;", "i", "Ljava/util/Map;", "pageCostTimeMap", "Lcom/tencent/ecommerce/base/report/service/k;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/kuikly/core/render/android/expand/a;", "delegate", "Lkotlin/Function0;", "D", "Lkotlin/jvm/functions/Function0;", "reportExtraMapGetter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/kuikly/core/render/android/expand/a;Lkotlin/jvm/functions/Function0;)V", UserInfo.SEX_FEMALE, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECHippyRenderView extends FrameLayout implements IECHippyRenderView, com.tencent.kuikly.core.render.android.expand.a {
    private static String E;

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.expand.a delegate;

    /* renamed from: D, reason: from kotlin metadata */
    private final Function0<Map<Object, Object>> reportExtraMapGetter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private KuiklyRenderViewDelegator hippyRenderViewDelegator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String pagerName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int pageProgressStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long pageStartTs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Map<String, ? extends ECShowPageCostTimeScene> pageCostTimeMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private k showPageCostTime;

    static {
        com.tencent.ecommerce.biz.hr.adapter.h.f102529b.a();
        E = "-1";
    }

    public /* synthetic */ ECHippyRenderView(Context context, com.tencent.kuikly.core.render.android.expand.a aVar, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : aVar, (i3 & 4) != 0 ? null : function0);
    }

    private final Map<String, Object> a(Map<String, Object> param) {
        param.put(MiniGamePAHippyBaseFragment.KEY_THEME, Boolean.valueOf(fg0.a.f398587b.a()));
        param.put("appId", 1);
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        param.put("uin", String.valueOf(qQEcommerceSdk.getGlobalInternalSdk().getAccountManager().getCurrentAccount()));
        param.put("isDebug", Boolean.valueOf(true ^ qQEcommerceSdk.getGlobalInternalSdk().getRuntime().isPublicVersion()));
        param.put("buildVersion", 1);
        param.put("isDevDebug", 0);
        return param;
    }

    private final void b(String pageName) {
        ECShowPageCostTimeScene eCShowPageCostTimeScene = this.pageCostTimeMap.get(pageName);
        if (eCShowPageCostTimeScene != null) {
            this.showPageCostTime = new k(eCShowPageCostTimeScene);
        }
    }

    private final void c() {
        Map<Object, Object> emptyMap;
        final Map mutableMapOf;
        long currentTimeMillis = System.currentTimeMillis() - this.pageStartTs;
        Function0<Map<Object, Object>> function0 = this.reportExtraMapGetter;
        if (function0 == null || (emptyMap = function0.invoke()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cost_time", Long.valueOf(currentTimeMillis)), TuplesKt.to("bundle_name", this.pagerName));
        mutableMapOf.putAll(emptyMap);
        ECThreadUtilKt.a(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$reportHRPageCost$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_quality_ktv_page_cost_time", mutableMapOf, false, 4, null);
            }
        });
    }

    private final void d() {
        Map<Object, Object> emptyMap;
        Map mutableMapOf;
        long currentTimeMillis = System.currentTimeMillis() - this.pageStartTs;
        Function0<Map<Object, Object>> function0 = this.reportExtraMapGetter;
        if (function0 == null || (emptyMap = function0.invoke()) == null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_status", Integer.valueOf(this.pageProgressStatus)), TuplesKt.to("bundle_name", this.pagerName), TuplesKt.to("cost_time", Long.valueOf(currentTimeMillis)));
        mutableMapOf.putAll(emptyMap);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ec_quality_ktv_page_result", mutableMapOf, false, 4, null);
    }

    private final void e(String tag, String msg2) {
        Map mapOf;
        com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("error_tag", tag), TuplesKt.to("error_msg", msg2), TuplesKt.to(PictureConst.KEY_CLASSNAME, this.pagerName), TuplesKt.to("method", this.pagerName));
        IECDataReport.a.a(bVar, "ec_quality_error_log", mapOf, false, 4, null);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public KuiklyRenderCoreExecuteMode C2() {
        KuiklyRenderCoreExecuteMode C2;
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        return (aVar == null || (C2 = aVar.C2()) == null) ? a.C5872a.a(this) : C2;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean Cc() {
        return a.C5872a.b(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ff(com.tencent.kuikly.core.render.android.b bVar) {
        a.C5872a.q(this, bVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ia(Throwable throwable, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        String stackTraceToString;
        String stackTraceToString2;
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isPublicVersion()) {
            if (throwable instanceof KRAarBizException) {
                stackTraceToString2 = ExceptionsKt__ExceptionsKt.stackTraceToString(throwable);
                e("HRDynamicAarBizException", stackTraceToString2);
                cg0.a.f("ECHippyRenderView", stackTraceToString2);
                return;
            } else {
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(throwable);
                e("HRBizException", stackTraceToString);
                cg0.a.f("ECHippyRenderView", stackTraceToString);
                return;
            }
        }
        throw throwable;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: K0 */
    public Long getEmbedSceneSyncTimeout() {
        return a.C5872a.t(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: M0 */
    public boolean getUseHostDisplayMetrics() {
        return a.C5872a.w(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public Map<String, Object> O1() {
        return a.C5872a.d(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public Integer Re() {
        return a.C5872a.s(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Sa() {
        a.C5872a.i(this);
        this.pageProgressStatus = 5;
        c();
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            aVar.Sa();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public String V0() {
        return a.C5872a.v(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean c1() {
        return a.C5872a.f(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public List<KRMonitorType> ec() {
        return a.C5872a.n(this);
    }

    public final void f(Map<Object, ? extends Object> data) {
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.a(1, data);
        }
    }

    public final void g(Map<Object, ? extends Object> data) {
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.a(3, data);
        }
    }

    public final void h(Map<Object, ? extends Object> data) {
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.a(2, data);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean h4() {
        return false;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void le(com.tencent.kuikly.core.render.android.performace.c cVar) {
        a.C5872a.h(this, cVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean ng() {
        return a.C5872a.c(this);
    }

    @Override // com.tencent.ecommerce.biz.hr.IECHippyRenderView
    public void onAttach(String contextCode, String pageName, Map<String, Object> params, Size size) {
        this.pageStartTs = System.currentTimeMillis();
        this.pagerName = pageName;
        b(pageName);
        KuiklyRenderViewDelegator.q(this.hippyRenderViewDelegator, this, contextCode, pageName, a(params), size, null, 32, null);
    }

    @Override // com.tencent.ecommerce.biz.hr.IECHippyRenderView
    public void onDetach() {
        this.hippyRenderViewDelegator.r();
        d();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void onPageLoadComplete(boolean z16, ErrorReason errorReason, KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        a.C5872a.k(this, z16, errorReason, kuiklyRenderCoreExecuteMode);
    }

    @Override // com.tencent.ecommerce.biz.hr.IECHippyRenderView
    public void onPause() {
        this.hippyRenderViewDelegator.s();
    }

    @Override // com.tencent.ecommerce.biz.hr.IECHippyRenderView
    public void onResume() {
        this.hippyRenderViewDelegator.t();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void p9() {
        a.C5872a.j(this);
        this.pageProgressStatus = 3;
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            aVar.p9();
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void pg(j01.a aVar) {
        a.C5872a.g(this, aVar);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalModule(com.tencent.kuikly.core.render.android.b hippyRenderExport) {
        a.C5872a.o(this, hippyRenderExport);
        hippyRenderExport.a("HRBridgeModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new HRBridgeModule();
            }
        });
        hippyRenderExport.a("KRNotifyModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new f();
            }
        });
        hippyRenderExport.a("HRCacheModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.ecommerce.biz.hr.module.b();
            }
        });
        hippyRenderExport.a("HRShareModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.ecommerce.biz.hr.module.h();
            }
        });
        hippyRenderExport.a("HRAddWindowModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.ecommerce.biz.hr.module.a();
            }
        });
        hippyRenderExport.a("HROpenTelemetryModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new g();
            }
        });
        hippyRenderExport.a("CalendarModule", new Function0<i01.a>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalModule$1$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.a invoke() {
                return new com.tencent.ecommerce.biz.hr.module.c();
            }
        });
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            aVar.registerExternalModule(hippyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalRenderView(com.tencent.kuikly.core.render.android.b hippyRenderExport) {
        a.C5872a.p(this, hippyRenderExport);
        b.a.a(hippyRenderExport, "HRPAGView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$1
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRPAGView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "HRGuildMixBackgroundView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$2
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRGuildMixBackgroundView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "HRQQFaceImageView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$3
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRQQFaceImageView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "HRAPNGView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$4
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRAPNGView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "ECFragmentView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$5
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRFragmentView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "HRSearchBar", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$6
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRSearchBar(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "HRGameButton", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$7
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRGameButton(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "ECCirAvatarView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$8
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRCircleAvatarView(context);
            }
        }, null, 4, null);
        hippyRenderExport.g("ECCirRichTextView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$9
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRQQCircleRichTextView(context);
            }
        }, new Function0<i01.b>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$10
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final i01.b invoke() {
                return new HRQQCircleRichTextView.b();
            }
        });
        b.a.a(hippyRenderExport, "HRAdsorptionPullView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$11
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRAdsorptionPullView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "HREdgeTranslucentView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$12
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HREdgeTranslucentView(context);
            }
        }, null, 4, null);
        b.a.a(hippyRenderExport, "QQECKTVChartView", new Function1<Context, i01.c>() { // from class: com.tencent.ecommerce.biz.hr.ECHippyRenderView$registerExternalRenderView$1$13
            @Override // kotlin.jvm.functions.Function1
            public final i01.c invoke(Context context) {
                return new HRQQECChartView(context);
            }
        }, null, 4, null);
        IECRenderViewRegister renderViewRegister = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRenderViewRegister();
        if (renderViewRegister != null) {
            renderViewRegister.registerHippyRenderView(hippyRenderExport);
        }
        com.tencent.kuikly.core.render.android.expand.a aVar = this.delegate;
        if (aVar != null) {
            aVar.registerExternalRenderView(hippyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerViewExternalPropHandler(com.tencent.kuikly.core.render.android.b hippyRenderExport) {
        a.C5872a.r(this, hippyRenderExport);
        hippyRenderExport.d(new ECHRDtViewPropHandler());
    }

    @Override // com.tencent.ecommerce.biz.hr.IECHippyRenderView
    public void sentEvent(String eventName, Map<String, ? extends Object> data) {
        this.hippyRenderViewDelegator.B(eventName, data);
    }

    public final void setPageProgressStatus(int i3) {
        this.pageProgressStatus = i3;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean u0() {
        return a.C5872a.e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECHippyRenderView(Context context, com.tencent.kuikly.core.render.android.expand.a aVar, Function0<? extends Map<Object, ? extends Object>> function0) {
        super(context);
        Map<String, ? extends ECShowPageCostTimeScene> mapOf;
        this.delegate = aVar;
        this.reportExtraMapGetter = function0;
        this.hippyRenderViewDelegator = new KuiklyRenderViewDelegator(this);
        this.pagerName = "";
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("38", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_AFTER_SALE_DETAIL), TuplesKt.to("blind_box_home", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_BLIND_BOX_HOME), TuplesKt.to("blind_box_detail_page", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_BLIND_BOX_DETAIL), TuplesKt.to("blind_box_friends_assist", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_BLIND_BOX_ASSIST), TuplesKt.to("blind_box_friends_assist_guest", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_BLIND_BOX_ASSIST_GUEST), TuplesKt.to("goods_center", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_KTV_GOODS_CENTER), TuplesKt.to("RewardPointsMall", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_REWARD_POINTS_MALL), TuplesKt.to("reward_point_order_submit", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_REWARD_POINTS_ORDER_SUBMIT), TuplesKt.to("reward_point_order_result", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_REWARD_POINTS_ORDER_RESULT), TuplesKt.to("reward_point_order_detail", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_REWARD_POINTS_ORDER_DETAIL), TuplesKt.to("reward_point_order_list", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_REWARD_POINTS_ORDER_LIST), TuplesKt.to("reward_points_detail", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_REWARD_POINTS_DETAIL_LIST), TuplesKt.to("product_detail", ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_KTV_PRODUCT_DETAIL));
        this.pageCostTimeMap = mapOf;
        setClipChildren(false);
    }
}
