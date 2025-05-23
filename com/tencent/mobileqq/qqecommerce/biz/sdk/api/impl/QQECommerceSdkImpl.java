package com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl;

import android.os.Bundle;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECSendPackageCallback;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.mobileqq.qqecommerce.biz.consumer.impl.QQGoodsViewModelImpl;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRFragmentModel;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.QQHRViewModelImpl;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qqecommerce.repo.pbfile.delivery$ContentExt;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000fH\u0016J;\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000f2)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016J{\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000f2E\u0010\u0018\u001aA\u0012/\u0012-\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015`\u000f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\u0017H\u0016J8\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00052&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000fH\u0016JT\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u001e2&\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000f2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016JJ\u0010%\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u00122\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010$2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J(\u0010*\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012H\u0016Jz\u0010:\u001a\u0002092\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0016Jz\u0010;\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H\u0016J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u0005H\u0016J\u001c\u0010>\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$H\u0016J\u0010\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020\u0005H\u0016J\b\u0010C\u001a\u00020BH\u0016J-\u0010H\u001a\u00028\u0000\"\u0004\b\u0000\u0010D2\u0006\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\bH\u0010IJ \u0010J\u001a\u0002062\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00108\u001a\u000206H\u0016\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/IQQECommerceSdk;", "", "iniSdkConfig", "initSdkConfigInSubProcess", "", "url", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "data", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceSchemeCallback;", "schemeCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "handleScheme", "", "target", "logicType", "", "result", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "resultCallback", "handleLogic", "action", "dataReport", "service", "method", "", "ext", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/a;", "callback", "sendPackage", "codingType", "", "sendProxyPackage", "title", "coverUrl", "recallSource", "businessType", "getContentExtForPublisher", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "businessId", "businessScene", "contentId", "contentScene", "videoIndex", "authorUin", "sealTransfer", "traceId", "pageId", "fromPageId", "", "isContinuation", "isTopViewPreload", "Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel;", "createGoodsViewModel", "preloadGoodsViewModel", "uniqueIdPrefix", "releaseGoodsViewModel", "reportSaasPageDuration", "scene", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "createHRViewModel", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "createHRFragmentModel", "T", "configId", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getAladdinConfig", "(ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "isPreloadGoodsDataSuccess", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQECommerceSdkImpl implements IQQECommerceSdk {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String ERROR_PROCESS_MSG = "\u5f53\u524d\u65b9\u6cd5\u53ea\u652f\u6301\u5728\u4e3b\u8fdb\u7a0b\u8c03\u7528\uff0c\u8bf7\u5148\u4f7f\u7528QIPC\u8f6c\u5316\u8fdb\u7a0b";
    private static final ArrayList<Integer> NATIVE_MODE_WHITE_LIST;
    public static final String TAG = "ECommerceSdkImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\nj\b\u0012\u0004\u0012\u00020\u0004`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkImpl$a;", "", "", "b", "", "logicType", "a", "", "ERROR_PROCESS_MSG", "Ljava/lang/String;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "NATIVE_MODE_WHITE_LIST", "Ljava/util/ArrayList;", "TAG", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.QQECommerceSdkImpl$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int logicType) {
            return QQECommerceSdkImpl.NATIVE_MODE_WHITE_LIST.contains(Integer.valueOf(logicType));
        }

        public final boolean b() {
            return MobileQQ.sProcessId == 1;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/sdk/api/impl/QQECommerceSdkImpl$b", "Lcom/tencent/ecommerce/base/network/api/IECSendPackageCallback;", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "", "onError", "successResponse", "onSuccess", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IECSendPackageCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.sdk.api.a f263413a;

        b(com.tencent.mobileqq.qqecommerce.biz.sdk.api.a aVar) {
            this.f263413a = aVar;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onError(ECRemoteResponse errorResponse) {
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            com.tencent.mobileqq.qqecommerce.biz.sdk.api.a aVar = this.f263413a;
            if (aVar != null) {
                aVar.b(new ECQQRemoteResponse(errorResponse.getRequestId(), errorResponse.getCode(), errorResponse.getMsg(), errorResponse.getData(), errorResponse.getChannelCode(), errorResponse.getChannelMsg()));
            }
        }

        @Override // com.tencent.ecommerce.base.network.api.IECSendPackageCallback
        public void onSuccess(ECRemoteResponse successResponse) {
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            com.tencent.mobileqq.qqecommerce.biz.sdk.api.a aVar = this.f263413a;
            if (aVar != null) {
                aVar.a(new ECQQRemoteResponse(successResponse.getRequestId(), successResponse.getCode(), successResponse.getMsg(), successResponse.getData(), successResponse.getChannelCode(), successResponse.getChannelMsg()));
            }
        }
    }

    static {
        ArrayList<Integer> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(124, 128);
        NATIVE_MODE_WHITE_LIST = arrayListOf;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public IQQGoodsViewModel createGoodsViewModel(String uniqueId, int businessId, String businessScene, String contentId, int contentScene, int videoIndex, String authorUin, String sealTransfer, String traceId, int pageId, String fromPageId, boolean isContinuation, boolean isTopViewPreload) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        Intrinsics.checkNotNullParameter(fromPageId, "fromPageId");
        if (!INSTANCE.b()) {
            QLog.e(TAG, 2, "preloadGoodsViewModel: \u5f53\u524d\u65b9\u6cd5\u53ea\u652f\u6301\u5728\u4e3b\u8fdb\u7a0b\u8c03\u7528\uff0c\u8bf7\u5148\u4f7f\u7528QIPC\u8f6c\u5316\u8fdb\u7a0b");
        }
        return new QQGoodsViewModelImpl(uniqueId, businessId, businessScene, contentId, contentScene, videoIndex, authorUin, sealTransfer, traceId, pageId, fromPageId, isContinuation, isTopViewPreload);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public com.tencent.mobileqq.qqecommerce.biz.hr.api.d createHRFragmentModel() {
        return new QQHRFragmentModel();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public com.tencent.mobileqq.qqecommerce.biz.hr.api.e createHRViewModel(String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return new QQHRViewModelImpl(scene);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void dataReport(String action, HashMap<Object, Object> params) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (INSTANCE.b()) {
            QQECommerceSdkManager.INSTANCE.dataReport(action, params);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("DATA_ACTION", action);
        bundle.putSerializable("DATA_HASH_MAP", params);
        bundle.putLong("DATA_START_TIME", System.currentTimeMillis());
        QIPCClientHelper.getInstance().callServer("ECPluginIPCHelper", "ACTION_DATA_REPORT", bundle);
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
        delivery$ContentExt delivery_contentext = new delivery$ContentExt();
        delivery_contentext.ad_title.set(title);
        delivery_contentext.ad_cover.set(coverUrl);
        delivery_contentext.recall_source.set(recallSource);
        delivery_contentext.business_type.set(businessType);
        byte[] byteArray = delivery_contentext.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "ContentExt().also {\n    \u2026Type)\n    }.toByteArray()");
        return byteArray;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleLogic(int logicType, HashMap<String, String> params, final Function1<? super HashMap<String, Object>, Unit> resultCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Companion companion = INSTANCE;
        if (!companion.b() && !companion.a(logicType)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("CALL_BACK", resultCallback != null);
            bundle.putInt("DATA_LOGIC", logicType);
            bundle.putSerializable("DATA_HASH_MAP", params);
            bundle.putLong("DATA_START_TIME", System.currentTimeMillis());
            QIPCClientHelper.getInstance().callServer("ECPluginIPCHelper", "ACTION_HANDLE_LOGIC", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.c
                @Override // eipc.EIPCResultCallback
                public final void onCallback(EIPCResult eIPCResult) {
                    QQECommerceSdkImpl.handleLogic$lambda$5(Function1.this, eIPCResult);
                }
            });
            return;
        }
        QQECommerceSdkManager.INSTANCE.handleLogic(logicType, params, resultCallback);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleScheme(String url, final Function1<? super JSONObject, Unit> schemeCallback, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
        if (INSTANCE.b()) {
            QQECommerceSdkManager.INSTANCE.handleScheme(url, schemeCallback, params);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("CALL_BACK", schemeCallback != null);
        bundle.putString("DATA_URL", url);
        bundle.putLong("DATA_START_TIME", System.currentTimeMillis());
        bundle.putSerializable("DATA_HASH_MAP", params);
        QIPCClientHelper.getInstance().callServer("ECPluginIPCHelper", "ACTION_HANDLE_SCHEME", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.d
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQECommerceSdkImpl.handleScheme$lambda$1(Function1.this, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void iniSdkConfig() {
        if (INSTANCE.b()) {
            QQECommerceSdkManager.INSTANCE.iniSdkConfig();
        } else {
            QIPCClientHelper.getInstance().callServer("ECPluginIPCHelper", "ACTION_INIT_CONFIG", new Bundle());
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void initSdkConfigInSubProcess() {
        QQECommerceSdkManager.INSTANCE.initSdkConfigInSubProcess();
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
        if (!INSTANCE.b()) {
            QLog.e(TAG, 2, "preloadGoodsViewModel: \u5f53\u524d\u65b9\u6cd5\u53ea\u652f\u6301\u5728\u4e3b\u8fdb\u7a0b\u8c03\u7528\uff0c\u8bf7\u5148\u4f7f\u7528QIPC\u8f6c\u5316\u8fdb\u7a0b");
        } else {
            handleLogic(118, QQGoodsViewModelImpl.INSTANCE.a(uniqueId, businessId, businessScene, contentId, contentScene, videoIndex, authorUin, sealTransfer, traceId, pageId, fromPageId, isContinuation, isTopViewPreload), null);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void releaseGoodsViewModel(String uniqueIdPrefix) {
        HashMap<String, String> hashMapOf;
        Intrinsics.checkNotNullParameter(uniqueIdPrefix, "uniqueIdPrefix");
        if (!INSTANCE.b()) {
            QLog.e(TAG, 2, "releaseGoodsViewModel: \u5f53\u524d\u65b9\u6cd5\u53ea\u652f\u6301\u5728\u4e3b\u8fdb\u7a0b\u8c03\u7528\uff0c\u8bf7\u5148\u4f7f\u7528QIPC\u8f6c\u5316\u8fdb\u7a0b");
        } else if (f.f263425a.a()) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(new Pair("PARAM_UNIQUE_ID_PREFIX_CODE", uniqueIdPrefix));
            handleLogic(119, hashMapOf, null);
        } else {
            QLog.i(TAG, 1, "releaseGoodsViewModel, fast return, because sdk not init.");
        }
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
    public void sendPackage(String service, String method, byte[] data, HashMap<Object, Object> ext, final com.tencent.mobileqq.qqecommerce.biz.sdk.api.a callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        if (INSTANCE.b()) {
            QQECommerceSdkManager.INSTANCE.sendPackage(service, method, data, ext, callback);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("CALL_BACK", callback != null);
        bundle.putString("DATA_SERVICE", service);
        bundle.putString("DATA_METHOD", method);
        bundle.putByteArray("DATA_BYTE_ARRAY", data);
        bundle.putSerializable("DATA_HASH_MAP", ext);
        bundle.putLong("DATA_START_TIME", System.currentTimeMillis());
        QIPCClientHelper.getInstance().callServer("ECPluginIPCHelper", "ACTION_SEND_PACKAGE", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.e
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQECommerceSdkImpl.sendPackage$lambda$7(com.tencent.mobileqq.qqecommerce.biz.sdk.api.a.this, eIPCResult);
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public int sendProxyPackage(String service, String method, byte[] data, int codingType, Map<Object, ? extends Object> ext, com.tencent.mobileqq.qqecommerce.biz.sdk.api.a callback) {
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(method, "method");
        return new com.tencent.mobileqq.qqecommerce.base.msf.c().sendPackage(service, method, data, codingType, ext, new b(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleLogic$lambda$5(Function1 function1, EIPCResult eIPCResult) {
        Serializable hashMap;
        if (function1 != null) {
            Bundle bundle = eIPCResult.data;
            if (bundle == null || (hashMap = bundle.getSerializable("DATA_HASH_MAP")) == null) {
                hashMap = new HashMap();
            }
            Intrinsics.checkNotNullExpressionValue(hashMap, "data?.getSerializable(EC\u2026 hashMapOf<String, Any>()");
            Intrinsics.checkNotNull(hashMap, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.Any>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.Any> }");
            function1.invoke((HashMap) hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleScheme$lambda$1(Function1 function1, EIPCResult eIPCResult) {
        String str;
        if (function1 != null) {
            Bundle bundle = eIPCResult.data;
            if (bundle == null || (str = bundle.getString("DATA_JSON")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "data?.getString(ECPluginIPCHelper.DATA_JSON) ?: \"\"");
            function1.invoke(new JSONObject(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleScheme$lambda$3(Function1 function1, EIPCResult eIPCResult) {
        String str;
        if (function1 != null) {
            Bundle bundle = eIPCResult.data;
            if (bundle == null || (str = bundle.getString("DATA_JSON")) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "data?.getString(ECPluginIPCHelper.DATA_JSON) ?: \"\"");
            function1.invoke(new JSONObject(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendPackage$lambda$7(com.tencent.mobileqq.qqecommerce.biz.sdk.api.a aVar, EIPCResult eIPCResult) {
        Serializable b16;
        if (aVar != null) {
            Bundle bundle = eIPCResult.data;
            int i3 = bundle != null ? bundle.getInt("SENDER_CALLBACK_TYPE") : 1;
            if (bundle == null || (b16 = bundle.getSerializable("SENDER_CALLBACK_RESULT")) == null) {
                b16 = ECQQRemoteResponse.Companion.b(ECQQRemoteResponse.INSTANCE, 0L, new JSONObject(), 0, null, 12, null);
            }
            Intrinsics.checkNotNullExpressionValue(b16, "data?.getSerializable(EC\u2026.success(0, JSONObject())");
            if (i3 == 1) {
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse");
                aVar.a((ECQQRemoteResponse) b16);
            } else {
                if (i3 != 2) {
                    return;
                }
                Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.mobileqq.qqecommerce.biz.sdk.api.ECQQRemoteResponse");
                aVar.b((ECQQRemoteResponse) b16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleScheme(String url, Function1<? super JSONObject, Unit> schemeCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        handleScheme(url, schemeCallback, new HashMap<>());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk
    public void handleScheme(int target, HashMap<String, String> params, final Function1<? super JSONObject, Unit> schemeCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (INSTANCE.b()) {
            QQECommerceSdkManager.INSTANCE.handleScheme(target, params, schemeCallback);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("CALL_BACK", schemeCallback != null);
        bundle.putInt("DATA_TARGET", target);
        bundle.putSerializable("DATA_HASH_MAP", params);
        bundle.putLong("DATA_START_TIME", System.currentTimeMillis());
        QIPCClientHelper.getInstance().callServer("ECPluginIPCHelper", "ACTION_HANDLE_SCHEME_TARGET", bundle, new EIPCResultCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.sdk.api.impl.b
            @Override // eipc.EIPCResultCallback
            public final void onCallback(EIPCResult eIPCResult) {
                QQECommerceSdkImpl.handleScheme$lambda$3(Function1.this, eIPCResult);
            }
        });
    }
}
