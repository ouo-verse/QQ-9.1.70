package com.tencent.ecommerce.biz.taskcenter.hippy.module;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCaller;
import cg0.a;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.share.api.ECShareParam;
import com.tencent.ecommerce.base.share.api.IECShareCallback;
import com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.hippy.IHippyUI;
import com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.taskcenter.hippy.ECHippyEventReceiver;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qqmini.sdk.plugins.ShareJsPlugin;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import mqq.app.Constants;
import org.json.JSONObject;
import yg0.ECPsKey;

/* compiled from: P */
@HippyNativeModule(init = true, name = ECBizModule.TAG)
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u001c\u0010!\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010\"\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010#\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010$\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010&\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006-"}, d2 = {"Lcom/tencent/ecommerce/biz/taskcenter/hippy/module/ECBizModule;", "Lcom/tencent/ecommerce/biz/hippy/module/ECHippyBaseModule;", "Lcom/tencent/ecommerce/biz/taskcenter/hippy/ECHippyEventReceiver;", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "getCurrentPageCallback", "", "event", "", "sendLifecycleEventToJs", "initialize", "destroy", "Lcom/tencent/mtt/hippy/common/HippyMap;", "params", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", com.tencent.luggage.wxa.gg.c.NAME, "openPublisher", "doApplyTask", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, IndividuationPlugin.Method_OpenPage, "closeCurrentPage", "openHippyPage", "preloadJsBundle", "sendRequest", "getUserInfo", "dataReport", "canOpenMiniApp", "toggleLoadingView", "sendEvent", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "onActivityResumed", "onActivityPaused", "onActivityDestroyed", "eventName", "onReceiverEvent", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "context", "<init>", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "Companion", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECBizModule extends ECHippyBaseModule implements ECHippyEventReceiver {
    private static final String ARG_EVENT_NAME = "eventName";
    private static final String ARG_MINI_APP_URL = "miniAppUrl";
    private static final String ARG_MODULE_NAME = "moduleName";
    private static final String ARG_PARAMS = "params";
    private static final String ARG_SHOW = "show";
    private static final String ARG_URL = "url";
    private static final String EVENT_LIFECYCLE = "@common:lifecycle";
    private static final String EVENT_LIFECYCLE_KEY = "type";
    private static final String EVENT_ONACTIVE = "onActive";
    private static final String EVENT_ONDEACTIVE = "onDeactive";
    private static final String EVENT_ONDESTROY = "onDestroy";
    private static final String EVENT_ONSTART = "onStart";
    private static final String EVENT_ON_EVENT_RECEIVED = "@common:onEventReceived";
    private static final String TAG = "ECBizModule";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/taskcenter/hippy/module/ECBizModule$b", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "", "Lyg0/b;", "pSKeys", "", "onSuccess", "", "msg", "onFailed", "onTimeout", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECPSKeyCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f104812a;

        b(Promise promise) {
            this.f104812a = promise;
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onFailed(String msg2) {
            a.b(ECBizModule.TAG, "[getUserInfo] onfailed msg " + msg2);
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onSuccess(List<ECPsKey> pSKeys) {
            Object first;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) pSKeys);
            String value = ((ECPsKey) first).getValue();
            if (value == null) {
                value = "";
            }
            Promise promise = this.f104812a;
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("psKey", value);
            Unit unit = Unit.INSTANCE;
            promise.resolve(hippyMap);
        }

        @Override // com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback
        public void onTimeout(String msg2) {
            a.b(ECBizModule.TAG, "[getUserInfo] onTimeout msg " + msg2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/taskcenter/hippy/module/ECBizModule$c", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECSchemeCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f104814b;

        c(Promise promise) {
            this.f104814b = promise;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            this.f104814b.resolve(data.toString());
            if (data.optBoolean("closePage")) {
                IECSchemeCallback currentPageCallback = ECBizModule.this.getCurrentPageCallback();
                if (currentPageCallback != null) {
                    currentPageCallback.onCallbackFinished(data);
                }
                a.b(ECBizModule.TAG, "openHippyPage do getActivity()?.finish()");
                Activity activity = ECBizModule.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "isSuc", "", "<anonymous parameter 1>", "Landroid/os/Bundle;", "onLaunchResult"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class d implements IECMiniAppLauncher.LaunchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f104815a;

        d(Promise promise) {
            this.f104815a = promise;
        }

        @Override // com.tencent.ecommerce.base.miniapp.api.IECMiniAppLauncher.LaunchListener
        public final void onLaunchResult(boolean z16, Bundle bundle) {
            a.b(ECBizModule.TAG, "openMiniApp onLaunchResult isSuc " + z16);
            this.f104815a.resolve(Boolean.valueOf(z16));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/taskcenter/hippy/module/ECBizModule$e", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECJsonNetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f104816a;

        e(Promise promise) {
            this.f104816a = promise;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            String str;
            Promise promise = this.f104816a;
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retCode", errorResponse != null ? errorResponse.getCode() : -1);
            if (errorResponse == null || (str = errorResponse.getMsg()) == null) {
                str = "\u8bf7\u6c42\u5931\u8d25";
            }
            hippyMap.pushString("errMsg", str);
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushJSONObject(com.tencent.ecommerce.base.network.api.c.a(errorResponse != null ? errorResponse.getData() : null));
            Unit unit = Unit.INSTANCE;
            hippyMap.pushObject("rspParams", hippyMap2);
            promise.resolve(hippyMap);
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            Promise promise = this.f104816a;
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("retCode", 0);
            HippyMap hippyMap2 = new HippyMap();
            hippyMap2.pushJSONObject(respData);
            Unit unit = Unit.INSTANCE;
            hippyMap.pushObject("rspParams", hippyMap2);
            promise.resolve(hippyMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/taskcenter/hippy/module/ECBizModule$f", "Lcom/tencent/ecommerce/base/share/api/IECShareCallback;", "", "type", "retCode", "", "onShareCallback", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements IECShareCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Promise f104817a;

        f(Promise promise) {
            this.f104817a = promise;
        }

        @Override // com.tencent.ecommerce.base.share.api.IECShareCallback
        public void onShareCallback(String type, String retCode) {
            Promise promise = this.f104817a;
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("type", type);
            hippyMap.pushString("retCode", retCode);
            Unit unit = Unit.INSTANCE;
            promise.resolve(hippyMap);
        }
    }

    public ECBizModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IECSchemeCallback getCurrentPageCallback() {
        String str;
        Intent intent;
        Activity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        return ug0.a.b(str);
    }

    private final void sendLifecycleEventToJs(String event) {
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("type", event);
        Unit unit = Unit.INSTANCE;
        sendEventToJs(EVENT_LIFECYCLE, hippyMap);
    }

    @HippyMethod(name = "canOpenMiniApp")
    public final void canOpenMiniApp(HippyMap params, Promise promise) {
        a.b(TAG, "canOpenMiniApp params " + params);
        boolean canOpenQQMiniApp = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMiniAppLauncher().canOpenQQMiniApp();
        a.b(TAG, "canOpenMiniApp onResult " + canOpenQQMiniApp);
        promise.resolve(Boolean.valueOf(canOpenQQMiniApp));
    }

    @HippyMethod(name = "closeCurrentPage")
    public final void closeCurrentPage(HippyMap params, Promise promise) {
        a.b(TAG, "closeCurrentPage");
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @HippyMethod(name = "dataReport")
    public final void dataReport(HippyMap params) {
        a.b(TAG, "dataReport params " + params);
        String string = params.getString("action");
        if (string != null) {
            HippyMap map = params.getMap("params");
            if (map == null) {
                map = new HippyMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : map.keySet()) {
                linkedHashMap.put(str, map.get(str));
            }
            a.b(TAG, "reportParam " + linkedHashMap);
            IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, string, linkedHashMap, false, 4, null);
        }
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        hj0.a.f405184b.c(this);
    }

    @HippyMethod(name = "doApplyTask")
    public final void doApplyTask(HippyMap params, Promise promise) {
        a.b(TAG, "doApplyTask params " + params);
        IECSchemeCallback currentPageCallback = getCurrentPageCallback();
        if (currentPageCallback == null) {
            a.a(TAG, "doApplyTask", "publisherCallback is null");
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.taskcenter.hippy.module.ECBizModule$doApplyTask$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f101155b.d("\u63a8\u5e7f\u5931\u8d25", ECToastIcon.ICON_ERROR, 0);
                }
            });
            Activity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        JSONObject jSONObject = params.toJSONObject();
        jSONObject.put("closePage", true);
        currentPageCallback.onCallbackFinished(jSONObject);
        a.b(TAG, "doApplyTask do getActivity()?.finish()");
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @HippyMethod(name = "getUserInfo")
    public final void getUserInfo(Promise promise) {
        a.b(TAG, "getUserInfo");
        zg0.a.f452502b.b(new String[]{"kandian.qq.com"}, new b(promise));
    }

    @Override // com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void initialize() {
        super.initialize();
        hj0.a.f405184b.b(this);
    }

    @Override // com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        sendLifecycleEventToJs(EVENT_ONSTART);
    }

    @Override // com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule
    public void onActivityDestroyed(Activity activity) {
        sendLifecycleEventToJs("onDestroy");
    }

    @Override // com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule
    public void onActivityPaused(Activity activity) {
        sendLifecycleEventToJs(EVENT_ONDEACTIVE);
    }

    @Override // com.tencent.ecommerce.biz.hippy.module.ECHippyBaseModule
    public void onActivityResumed(Activity activity) {
        sendLifecycleEventToJs(EVENT_ONACTIVE);
    }

    @Override // com.tencent.ecommerce.biz.taskcenter.hippy.ECHippyEventReceiver
    public void onReceiverEvent(String eventName, HippyMap params) {
        a.b(TAG, "onReceiverEvent eventName=" + eventName + ", params=" + params);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushString("eventName", eventName);
        hippyMap.pushMap("params", params);
        Unit unit = Unit.INSTANCE;
        sendEventToJs(EVENT_ON_EVENT_RECEIVED, hippyMap);
    }

    @HippyMethod(name = "openHippyPage")
    public final void openHippyPage(HippyMap params, Promise promise) {
        a.b(TAG, "openHippyPage, params=" + params);
        ECScheme.f(params.getString("url"), new c(promise), null, 4, null);
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_OPEN_MINI_APP)
    public final void openMiniApp(HippyMap params, Promise promise) {
        a.b(TAG, "openMiniApp params " + params);
        String string = params.getString(ARG_MINI_APP_URL);
        Context activity = getActivity();
        if (activity == null) {
            a.b(TAG, "openPublisher getActivity is null, use application context");
            activity = wg0.a.a();
        }
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getMiniAppLauncher().launchQQMiniAppByUrl(activity, string, new d(promise));
    }

    @HippyMethod(name = IndividuationPlugin.Method_OpenPage)
    public final void openPage(HippyMap params, Promise promise) {
        a.b(TAG, "openPage params " + params);
        int g16 = ECScheme.g(params.getString("url"), null, 2, null);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("retCode", g16);
        Unit unit = Unit.INSTANCE;
        promise.resolve(hippyMap);
    }

    @HippyMethod(name = "openPublisher")
    public final void openPublisher(HippyMap params, Promise promise) {
        a.b(TAG, "openPublisher params " + params);
        Context activity = getActivity();
        if (activity == null) {
            a.b(TAG, "openPublisher getActivity is null, use application context");
            activity = wg0.a.a();
        }
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getBizModuleProxy().openPublisher(activity, params.getString("url"));
    }

    @HippyMethod(name = "preloadJsBundle")
    public final void preloadJsBundle(HippyMap params, Promise promise) {
        a.b(TAG, "preloadJsBundle, params=" + params);
        String string = params.getString(ARG_MODULE_NAME);
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            a.a(TAG, "preloadJsBundle", "moduleName isNull");
        } else {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getHippyProxy().preloadJsBundle(string);
        }
    }

    @HippyMethod(name = "sendEvent")
    public final void sendEvent(HippyMap params) {
        a.b(TAG, "sendEvent params=" + params);
        hj0.a.f405184b.a(params.getString("eventName"), params.getMap("params"));
    }

    @HippyMethod(name = "sendRequest")
    public final void sendRequest(HippyMap params, Promise promise) {
        a.b(TAG, "sendRequest params " + params);
        String string = params.getString("service");
        String string2 = params.getString("method");
        HippyMap map = params.getMap("reqParams");
        com.tencent.ecommerce.base.network.service.a.c(string, string2, map != null ? map.toJSONObject() : null, new e(promise));
    }

    @HippyMethod(name = com.tencent.luggage.wxa.gg.c.NAME)
    public final void showShareMenu(HippyMap params, Promise promise) {
        String string = params.getString("jsonData");
        Activity activity = getActivity();
        if (activity == null) {
            a.a(TAG, com.tencent.luggage.wxa.gg.c.NAME, "activity is null!");
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.taskcenter.hippy.module.ECBizModule$showShareMenu$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    i.f101155b.d(ShareJsPlugin.ERRMSG_INVITE_REQUIRE, ECToastIcon.ICON_ERROR, 0);
                }
            });
        } else {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getShareProxy().showShareActionSheet(activity, new ECShareParam(string), new f(promise));
        }
    }

    @HippyMethod(name = "toggleLoadingView")
    public final void toggleLoadingView(final HippyMap params, Promise promise) {
        a.b(TAG, "toggleLoadingView: params=" + params);
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.taskcenter.hippy.module.ECBizModule$toggleLoadingView$1
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
                ActivityResultCaller fragment;
                fragment = ECBizModule.this.getFragment();
                if (!(fragment instanceof IHippyUI)) {
                    fragment = null;
                }
                IHippyUI iHippyUI = (IHippyUI) fragment;
                if (iHippyUI != null) {
                    iHippyUI.toggleLoadingView(params.getBoolean("show"));
                }
            }
        });
    }
}
