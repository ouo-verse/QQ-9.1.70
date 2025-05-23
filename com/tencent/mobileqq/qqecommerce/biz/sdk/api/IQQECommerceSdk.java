package com.tencent.mobileqq.qqecommerce.biz.sdk.api;

import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.d;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.e;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000fH&J;\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH&J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000f2)\u0010\r\u001a%\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH&J\u008a\u0001\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000f2T\u0010\u0018\u001aP\u0012>\u0012<\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u000ej\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015`\u000f\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0016\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\u0017H&J8\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00052&\u0010\u0010\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000fH&JV\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u001e2(\b\u0002\u0010\u001f\u001a\"\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000ej\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000f2\b\u0010!\u001a\u0004\u0018\u00010 H&JL\u0010%\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u001e2\u0006\u0010#\u001a\u00020\u00122\u0016\b\u0002\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0018\u00010$2\b\u0010!\u001a\u0004\u0018\u00010 H&J(\u0010*\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u0012H&Jz\u0010:\u001a\u0002092\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H&Jz\u0010;\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00122\b\u0010-\u001a\u0004\u0018\u00010\u00052\b\u0010.\u001a\u0004\u0018\u00010\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010\u00052\b\u00103\u001a\u0004\u0018\u00010\u00052\u0006\u00104\u001a\u00020\u00122\u0006\u00105\u001a\u00020\u00052\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u000206H&J\u0010\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u0005H&J\u001c\u0010>\u001a\u00020\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050$H&J\u0010\u0010A\u001a\u00020@2\u0006\u0010?\u001a\u00020\u0005H&J\b\u0010C\u001a\u00020BH&J-\u0010H\u001a\u00028\u0000\"\u0004\b\u0000\u0010D2\u0006\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00028\u0000H&\u00a2\u0006\u0004\bH\u0010IJ \u0010J\u001a\u0002062\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00122\u0006\u00108\u001a\u000206H&\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/IQQECommerceSdk;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "iniSdkConfig", "initSdkConfigInSubProcess", "", "url", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ParameterName;", "name", "data", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceSchemeCallback;", "schemeCallback", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "params", "handleScheme", "", "target", "logicType", "", "result", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "resultCallback", "handleLogic", "action", "dataReport", "service", "method", "", "ext", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/a;", "callback", "sendPackage", "codingType", "", "sendProxyPackage", "title", "coverUrl", "recallSource", "businessType", "getContentExtForPublisher", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, "businessId", "businessScene", "contentId", "contentScene", "videoIndex", "authorUin", "sealTransfer", "traceId", "pageId", "fromPageId", "", "isContinuation", "isTopViewPreload", "Lcom/tencent/mobileqq/qqecommerce/biz/consumer/api/IQQGoodsViewModel;", "createGoodsViewModel", "preloadGoodsViewModel", "uniqueIdPrefix", "releaseGoodsViewModel", "reportSaasPageDuration", "scene", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/e;", "createHRViewModel", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/d;", "createHRFragmentModel", "T", "configId", "key", RemoteHandleConst.PARAM_DEFAULT_VALUE, "getAladdinConfig", "(ILjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "isPreloadGoodsDataSuccess", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQQECommerceSdk extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void sendPackage$default(IQQECommerceSdk iQQECommerceSdk, String str, String str2, byte[] bArr, HashMap hashMap, a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    hashMap = null;
                }
                iQQECommerceSdk.sendPackage(str, str2, bArr, hashMap, aVar);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPackage");
        }

        public static /* synthetic */ int sendProxyPackage$default(IQQECommerceSdk iQQECommerceSdk, String str, String str2, byte[] bArr, int i3, Map map, a aVar, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    map = null;
                }
                return iQQECommerceSdk.sendProxyPackage(str, str2, bArr, i3, map, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendProxyPackage");
        }
    }

    @NotNull
    IQQGoodsViewModel createGoodsViewModel(@NotNull String uniqueId, int businessId, @Nullable String businessScene, @Nullable String contentId, int contentScene, int videoIndex, @Nullable String authorUin, @Nullable String sealTransfer, @Nullable String traceId, int pageId, @NotNull String fromPageId, boolean isContinuation, boolean isTopViewPreload);

    @NotNull
    d createHRFragmentModel();

    @NotNull
    e createHRViewModel(@NotNull String scene);

    void dataReport(@NotNull String action, @Nullable HashMap<Object, Object> params);

    <T> T getAladdinConfig(int configId, @NotNull String key, T defaultValue);

    @NotNull
    byte[] getContentExtForPublisher(@NotNull String title, @NotNull String coverUrl, int recallSource, int businessType);

    void handleLogic(int logicType, @NotNull HashMap<String, String> params, @Nullable Function1<? super HashMap<String, Object>, Unit> resultCallback);

    void handleScheme(int target, @NotNull HashMap<String, String> params, @Nullable Function1<? super JSONObject, Unit> schemeCallback);

    void handleScheme(@NotNull String url, @Nullable Function1<? super JSONObject, Unit> schemeCallback);

    void handleScheme(@NotNull String url, @Nullable Function1<? super JSONObject, Unit> schemeCallback, @NotNull HashMap<String, String> params);

    void iniSdkConfig();

    void initSdkConfigInSubProcess();

    boolean isPreloadGoodsDataSuccess(@NotNull String contentId, int contentScene, boolean isTopViewPreload);

    void preloadGoodsViewModel(@NotNull String uniqueId, int businessId, @Nullable String businessScene, @Nullable String contentId, int contentScene, int videoIndex, @Nullable String authorUin, @Nullable String sealTransfer, @Nullable String traceId, int pageId, @NotNull String fromPageId, boolean isContinuation, boolean isTopViewPreload);

    void releaseGoodsViewModel(@NotNull String uniqueIdPrefix);

    void reportSaasPageDuration(@NotNull Map<String, String> data);

    void sendPackage(@NotNull String service, @NotNull String method, @Nullable byte[] data, @Nullable HashMap<Object, Object> ext, @Nullable a callback);

    int sendProxyPackage(@NotNull String service, @NotNull String method, @Nullable byte[] data, int codingType, @Nullable Map<Object, ? extends Object> ext, @Nullable a callback);
}
