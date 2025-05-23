package com.tencent.mobileqq.qqecommerce.biz.hippy;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngine;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngineListener;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.common.HippyJsException;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u00012\u00020\u0002:\u0002 #BE\u0012\u0006\u0010\"\u001a\u00020\u001e\u0012\b\u0010'\u001a\u0004\u0018\u00010&\u0012\u0006\u0010(\u001a\u00020\u0005\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b.\u0010/J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0014J,\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0014J$\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001f\u001a\u00020\u001eH\u0016R\u0014\u0010\"\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/a;", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "Lcom/tencent/hippy/qq/app/HippyQQEngine;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "msg", "", "c", "loadModule", "checkPackageUpdate", "result", "filePath", "", "checkStartTime", "doUpdatePackageComplete", "initJsBundleTypeFromUrl", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lorg/json/JSONObject;", ISchemeApi.KEY_PAGE_DATA, "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngineListener;", "engineListener", "initHippyInContainer", "Lcom/tencent/mtt/hippy/adapter/font/HippyFontScaleAdapter;", "createHippyFontScaleAdapter", "onDestroyView", "Lcom/tencent/mtt/hippy/HippyEngine$EngineInitParams;", "initParams", "fillEngineInitParams", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "a", "Landroidx/fragment/app/Fragment;", "currentFragment", "b", "I", "minModuleVersion", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "moduleName", "hippyUrl", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "provider", "Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;", "customViewCreator", "<init>", "(Landroidx/fragment/app/Fragment;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mtt/hippy/HippyAPIProvider;Lcom/tencent/mtt/hippy/uimanager/HippyCustomViewCreator;I)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a extends HippyQQEngine implements IECHippyEngine {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Fragment currentFragment;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int minModuleVersion;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hippy/a$b;", "Lcom/tencent/hippy/qq/app/HippyQQEngine$MyHippyExceptionHandlerAdapter;", "Lcom/tencent/mtt/hippy/common/HippyJsException;", "exception", "", "handleJsException", "Lcom/tencent/mobileqq/tianjige/i;", "a", "Lcom/tencent/mobileqq/tianjige/i;", "openTelemetryTracer", "Lwe2/d;", "b", "Lwe2/d;", "openTelemetryMetric", "Lcom/tencent/mobileqq/qqecommerce/biz/hippy/a;", EnginePathProvider.ENGINE_DIR, "<init>", "(Lcom/tencent/mobileqq/qqecommerce/biz/hippy/a;)V", "c", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends HippyQQEngine.MyHippyExceptionHandlerAdapter {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final i openTelemetryTracer;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final we2.d openTelemetryMetric;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a engine) {
            super(engine);
            Intrinsics.checkNotNullParameter(engine, "engine");
            this.openTelemetryTracer = we2.b.INSTANCE.b();
            this.openTelemetryMetric = new we2.d();
        }

        @Override // com.tencent.hippy.qq.app.HippyQQEngine.MyHippyExceptionHandlerAdapter, com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter
        public void handleJsException(HippyJsException exception) {
            Map<String, String> emptyMap;
            Map<String, String> mapOf;
            super.handleJsException(exception);
            if (exception != null) {
                we2.d dVar = this.openTelemetryMetric;
                emptyMap = MapsKt__MapsKt.emptyMap();
                dVar.addLongValue(1L, "ECHippyEngine_Js_Exception", "1", "normal counter report", emptyMap);
                i iVar = this.openTelemetryTracer;
                if (iVar != null) {
                    iVar.r("ECHippyJsStatus");
                    String message = exception.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("exception", message));
                    iVar.b("ECHippyJsStatus", 1, mapOf);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hippy/a$c", "Lcom/tencent/hippy/qq/app/HippyQQEngine$HippyQQEngineListener;", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "", "msg", "", "onError", "onSuccess", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements HippyQQEngine.HippyQQEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IECHippyEngineListener f262554d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f262555e;

        c(IECHippyEngineListener iECHippyEngineListener, a aVar) {
            this.f262554d = iECHippyEngineListener;
            this.f262555e = aVar;
        }

        @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
        public void onError(int statusCode, String msg2) {
            this.f262554d.onError(statusCode, msg2);
            this.f262555e.c(statusCode, msg2);
        }

        @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
        public void onSuccess() {
            this.f262554d.onSuccess();
            this.f262555e.c(0, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment currentFragment, Activity activity, String moduleName, String hippyUrl, HippyAPIProvider provider, HippyCustomViewCreator hippyCustomViewCreator, int i3) {
        super(activity, moduleName, hippyUrl);
        Intrinsics.checkNotNullParameter(currentFragment, "currentFragment");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(hippyUrl, "hippyUrl");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.currentFragment = currentFragment;
        this.minModuleVersion = i3;
        ECHippyReporter.INSTANCE.a().h();
        this.providers.add(provider);
        this.viewCreator = hippyCustomViewCreator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int statusCode, String msg2) {
        ECHippyReporter a16 = ECHippyReporter.INSTANCE.a();
        String moduleName = getModuleName();
        Intrinsics.checkNotNullExpressionValue(moduleName, "moduleName");
        int moduleVersion = getModuleVersion();
        HashMap<String, String> generateReportExtraParams = generateReportExtraParams();
        Intrinsics.checkNotNullExpressionValue(generateReportExtraParams, "generateReportExtraParams()");
        HashMap<String, Long> loadStepsTime = getLoadStepsTime();
        Intrinsics.checkNotNullExpressionValue(loadStepsTime, "loadStepsTime");
        a16.e(statusCode, msg2, new ECHippyPerformance(false, false, null, moduleName, moduleVersion, generateReportExtraParams, loadStepsTime, 7, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void checkPackageUpdate() {
        super.checkPackageUpdate();
        QLog.i("ECHippyEngine", 1, "#checkPackageUpdate: begin");
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected HippyFontScaleAdapter createHippyFontScaleAdapter() {
        return new h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void doUpdatePackageComplete(int result, String msg2, String filePath, long checkStartTime) {
        QLog.i("ECHippyEngine", 1, "#doUpdatePackageComplete: result=" + result + ", msg=" + msg2 + ", filePath=" + filePath + ", checkStartTime=" + checkStartTime);
        super.doUpdatePackageComplete(result, msg2, filePath, checkStartTime);
    }

    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    protected void fillEngineInitParams(HippyEngine.EngineInitParams initParams) {
        Intrinsics.checkNotNullParameter(initParams, "initParams");
        initParams.exceptionHandler = new b(this);
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public Fragment getCurrentFragment() {
        return this.currentFragment;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void initHippyInContainer(ViewGroup container, JSONObject pageData, IECHippyEngineListener engineListener) {
        Intrinsics.checkNotNullParameter(container, "container");
        c cVar = engineListener != null ? new c(engineListener, this) : null;
        if (pageData == null) {
            pageData = new JSONObject();
        }
        initHippyInContainer(container, pageData, false, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void initJsBundleTypeFromUrl() {
        super.initJsBundleTypeFromUrl();
        String queryParameter = Uri.parse(this.mUrl).getQueryParameter(HippyQQConstants.URL_COMPONENT_NAME);
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        this.componentName = queryParameter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.app.HippyQQEngine
    public void loadModule() {
        int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(getModuleName());
        QLog.i("ECHippyEngine", 1, "#loadModule: version=" + moduleVersion + ", minModuleVersion=" + this.minModuleVersion);
        int i3 = this.minModuleVersion;
        if (i3 > 0 && moduleVersion < i3) {
            checkPackageUpdate();
        } else {
            super.loadModule();
        }
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void onDestroyView() {
        onDestroy();
    }
}
