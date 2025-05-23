package com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl;

import android.content.Intent;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECPkgCodingType;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.IAccountCallback;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001W\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000fH\u0016J;\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000f2)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016J{\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000f2E\u0010\u0018\u001aA\u0012/\u0012-\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015`\u000f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\u0017H\u0016J8\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00052&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000fH\u0016JT\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u001e2&\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016JJ\u0010%\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u00122\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010$2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J(\u0010*\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012H\u0016Jz\u0010:\u001a\u0002092\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0016Jz\u0010;\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0016J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u0005H\u0016J\u001c\u0010>\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$H\u0016J\u0010\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020BH\u0016J-\u0010H\u001a\u00028\u0000\"\u0004\b\u0000\u0010D2\u0006\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\bH\u0010IJ \u0010J\u001a\u0002062\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00108\u001a\u000206H\u0016R\u0014\u0010K\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010M\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bM\u0010LR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010U\u001a\u00020T8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager;", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/IQQECommerceSdk;", "", "iniSdkConfig", "initSdkConfigInSubProcess", "", "url", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "data", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceSchemeCallback;", "schemeCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "handleScheme", "", "target", "logicType", "", "result", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "resultCallback", "handleLogic", "action", "dataReport", "service", "method", "", "ext", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/a;", "callback", "sendPackage", "codingType", "", "sendProxyPackage", "title", "coverUrl", "recallSource", "businessType", "getContentExtForPublisher", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "businessId", "businessScene", "contentId", "contentScene", "videoIndex", "authorUin", "sealTransfer", "traceId", "pageId", "fromPageId", "", "isContinuation", "isTopViewPreload", "Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel;", "createGoodsViewModel", "preloadGoodsViewModel", "uniqueIdPrefix", "releaseGoodsViewModel", "reportSaasPageDuration", "scene", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "createHRViewModel", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "createHRFragmentModel", "T", "configId", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getAladdinConfig", "(ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "isPreloadGoodsDataSuccess", "TAG", "Ljava/lang/String;", "ERROR_INVOKE_MSG", "Lcom/tencent/mobileqq/qqecommerce/base/msf/c;", "ecNetworkManager", "Lcom/tencent/mobileqq/qqecommerce/base/msf/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "ecDataReportManager", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "Ldf2/a;", "ecScreenBroadcastReceiver", "Ldf2/a;", "com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$a", "accountChangedCallback", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$a;", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQECommerceSdkManager implements IQQECommerceSdk {
    public static final String ERROR_INVOKE_MSG = "\u5f53\u524d\u65b9\u6cd5\u7981\u6b62\u76f4\u63a5\u8c03\u7528\uff0c\u8bf7\u4f7f\u7528IQQECommerceSDK";
    public static final QQECommerceSdkManager INSTANCE;
    public static final String TAG = "QQECommerceSdkManager";
    private static final a accountChangedCallback;
    private static ECDataReportManager ecDataReportManager;
    private static com.tencent.mobileqq.qqecommerce.base.msf.c ecNetworkManager;
    private static df2.a ecScreenBroadcastReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$a", "Lmqq/app/IAccountCallback;", "Lmqq/app/AppRuntime;", "newRuntime", "", "onAccountChanged", "onAccountChangeFailed", "Lmqq/app/Constants$LogoutReason;", "reason", "onLogout", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements IAccountCallback {
        a() {
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChanged(AppRuntime newRuntime) {
            MobileQQ application;
            QLog.d(QQECommerceSdkManager.TAG, 1, "onAccountChanged");
            ((IReadInJoyHelper) QRoute.api(IReadInJoyHelper.class)).initAladdin();
            Intent intent = new Intent("ACTION_ACCOUNT_CHANGED");
            if (newRuntime == null || (application = newRuntime.getApplication()) == null) {
                return;
            }
            application.sendBroadcast(intent);
        }

        @Override // mqq.app.IAccountCallback
        public void onAccountChangeFailed(AppRuntime newRuntime) {
        }

        @Override // mqq.app.IAccountCallback
        public void onLogout(Constants.LogoutReason reason) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$b", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "result", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IECLogicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<HashMap<String, Object>, Unit> f263414a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super HashMap<String, Object>, Unit> function1) {
            this.f263414a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
        public void onResult(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            this.f263414a.invoke(result);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$c", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<JSONObject, Unit> f263415a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super JSONObject, Unit> function1) {
            this.f263415a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f263415a.invoke(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$d", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<JSONObject, Unit> f263416a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super JSONObject, Unit> function1) {
            this.f263416a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.f263416a.invoke(data);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkManager$e", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "result", "", "onResult", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements IECLogicCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.sdk.api.a f263417a;

        e(com.tencent.mobileqq.qqecommerce.biz.sdk.api.a aVar) {
            this.f263417a = aVar;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
        public void onResult(HashMap<String, Object> result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.get("RESULT_SUCCESS") != null) {
                Object obj = result.get("RESULT_SUCCESS");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.ecommerce.base.network.api.ECRemoteResponse");
                ECRemoteResponse eCRemoteResponse = (ECRemoteResponse) obj;
                this.f263417a.a(new ECQQRemoteResponse(eCRemoteResponse.getRequestId(), eCRemoteResponse.getCode(), eCRemoteResponse.getMsg(), eCRemoteResponse.getData(), eCRemoteResponse.getChannelCode(), eCRemoteResponse.getChannelMsg()));
                return;
            }
            if (result.get("RESULT_ERROR") != null) {
                Object obj2 = result.get("RESULT_ERROR");
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.tencent.ecommerce.base.network.api.ECRemoteResponse");
                ECRemoteResponse eCRemoteResponse2 = (ECRemoteResponse) obj2;
                this.f263417a.b(new ECQQRemoteResponse(eCRemoteResponse2.getRequestId(), eCRemoteResponse2.getCode(), eCRemoteResponse2.getMsg(), eCRemoteResponse2.getData(), eCRemoteResponse2.getChannelCode(), eCRemoteResponse2.getChannelMsg()));
            }
        }
    }

    static {
        QQECommerceSdkManager qQECommerceSdkManager = new QQECommerceSdkManager();
        INSTANCE = qQECommerceSdkManager;
        accountChangedCallback = new a();
        qQECommerceSdkManager.iniSdkConfig();
    }

    QQECommerceSdkManager() {
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public IQQGoodsViewModel createGoodsViewModel(String uniqueId, int businessId, String businessScene, String contentId, int contentScene, int videoIndex, String authorUin, String sealTransfer, String traceId, int pageId, String fromPageId, boolean isContinuation, boolean isTopViewPreload) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fromPageId, "fromPageId");
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public com.tencent.mobileqq.qqecommerce.biz.hr.api.d createHRFragmentModel() {
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public com.tencent.mobileqq.qqecommerce.biz.hr.api.e createHRViewModel(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void dataReport(String action, HashMap<Object, Object> params) {
        Intrinsics.checkNotNullParameter(action, "action");
        ECDataReportManager eCDataReportManager = ecDataReportManager;
        if (eCDataReportManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ecDataReportManager");
            eCDataReportManager = null;
        }
        IECDataReport.a.a(eCDataReportManager, action, params, false, 4, null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public <T> T getAladdinConfig(int configId, String key, T defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        return (T) new me2.a().getConfig(configId, key, defaultValue);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public byte[] getContentExtForPublisher(String title, String coverUrl, int recallSource, int businessType) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleLogic(int logicType, HashMap<String, String> params, Function1<? super HashMap<String, Object>, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleLogic: logicType=" + logicType + ", params=" + params);
        }
        af2.d.f26007a.a(logicType, params, resultCallback != null ? new b(resultCallback) : null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleScheme(String url, Function1<? super JSONObject, Unit> schemeCallback, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleScheme: url=" + url);
        }
        if (com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.a.f263418a.a(url)) {
            return;
        }
        af2.d.f26007a.d(url, params, schemeCallback != null ? new c(schemeCallback) : null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void iniSdkConfig() {
        if (f.f263425a.b()) {
            hf2.b.f404840a.b();
            ecNetworkManager = new com.tencent.mobileqq.qqecommerce.base.msf.c();
            ecDataReportManager = new ECDataReportManager();
            df2.a.f393675a.a();
            MobileQQ.sMobileQQ.registerAccountCallback(accountChangedCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void initSdkConfigInSubProcess() {
        iniSdkConfig();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public boolean isPreloadGoodsDataSuccess(String contentId, int contentScene, boolean isTopViewPreload) {
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        if (contentScene == 8 && isTopViewPreload) {
            return oh0.a.f422682b.b(contentId);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void preloadGoodsViewModel(String uniqueId, int businessId, String businessScene, String contentId, int contentScene, int videoIndex, String authorUin, String sealTransfer, String traceId, int pageId, String fromPageId, boolean isContinuation, boolean isTopViewPreload) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fromPageId, "fromPageId");
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void releaseGoodsViewModel(String uniqueIdPrefix) {
        Intrinsics.checkNotNullParameter(uniqueIdPrefix, "uniqueIdPrefix");
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void reportSaasPageDuration(Map<String, String> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putAll(data);
        handleLogic(121, hashMap, null);
        QLog.d(TAG, 1, "reportSaasPageDuration handleLogic logicType = 121");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void sendPackage(String service, String method, byte[] data, HashMap<Object, Object> ext, com.tencent.mobileqq.qqecommerce.biz.sdk.api.a callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendPackage: service=" + service + ", method=" + method);
        }
        e eVar = callback != null ? new e(callback) : null;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("PARAM_SERVICE", service);
        hashMap.put("PARAM_METHOD", method);
        String jSONObject = com.tencent.ecommerce.base.network.api.c.a(data).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "convertBytesToJson(data).toString()");
        hashMap.put("PARAM_DATA", jSONObject);
        hashMap.put("PARAM_CODING_TYPE", String.valueOf(ECPkgCodingType.EC_PACKAGE_CODING_TYPE_JSON.ordinal()));
        af2.d.f26007a.a(114, hashMap, eVar);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public int sendProxyPackage(String service, String method, byte[] data, int codingType, Map<Object, ? extends Object> ext, com.tencent.mobileqq.qqecommerce.biz.sdk.api.a callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        throw new IllegalStateException(ERROR_INVOKE_MSG);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleScheme(String url, Function1<? super JSONObject, Unit> schemeCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        handleScheme(url, schemeCallback, new HashMap<>());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleScheme(int target, HashMap<String, String> params, Function1<? super JSONObject, Unit> schemeCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "handleScheme: url=" + target + ", params=" + params);
        }
        if (com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.a.f263418a.a(String.valueOf(target))) {
            return;
        }
        af2.d.f26007a.c(target, params, schemeCallback != null ? new d(schemeCallback) : null);
    }
}
