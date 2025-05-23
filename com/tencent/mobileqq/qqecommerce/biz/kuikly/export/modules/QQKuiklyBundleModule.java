package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexResInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \r2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002JI\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00072+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016JI\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/QQKuiklyBundleModule;", "Li01/e;", "", "params", "", "a", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "i", "g", "c", "l", "j", "method", "call", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyBundleModule extends i01.e {
    private final String c(String params) {
        if (params == null) {
            return "{}";
        }
        String resId = new JSONObject(params).optString("bundle_name");
        Intrinsics.checkNotNullExpressionValue(resId, "resId");
        if (resId.length() == 0) {
            return "{}";
        }
        DexResInfo dexResInfo = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo(resId);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resVersion", dexResInfo.getResVersion());
        DexConfig config = dexResInfo.getConfig();
        if (config != null) {
            jSONObject.put(DownloadInfo.spKey_Config, new JSONObject().put("tag", config.getTag()));
        }
        String jSONObject2 = jSONObject.put("filePath", dexResInfo.getFilePath()).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "result.toString()");
        return jSONObject2;
    }

    private final void l(String params, final Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        if (params == null) {
            if (callback != null) {
                mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "error params"));
                callback.invoke(mapOf2);
                return;
            }
            return;
        }
        final String resId = new JSONObject(params).optString("bundle_name");
        Intrinsics.checkNotNullExpressionValue(resId, "resId");
        if (!(resId.length() == 0)) {
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(resId, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyBundleModule$updateBundle$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                    invoke2(resError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ResError error) {
                    Map mapOf3;
                    Intrinsics.checkNotNullParameter(error, "error");
                    IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
                    String resId2 = resId;
                    Intrinsics.checkNotNullExpressionValue(resId2, "resId");
                    DexResInfo dexResInfo = iQQKuiklyDexResApi.getDexResInfo(resId2);
                    Function1<Object, Unit> function1 = callback;
                    if (function1 != null) {
                        mapOf3 = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", Integer.valueOf(error.getCode())), TuplesKt.to("errMsg", error.getMessage()), TuplesKt.to("resVersion", Long.valueOf(dexResInfo.getResVersion())));
                        function1.invoke(mapOf3);
                    }
                }
            });
        } else if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "error params"));
            callback.invoke(mapOf);
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, Object params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "getShiplyTestBundleList")) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getShiplyTestBundleList().iterator();
            while (it.hasNext()) {
                jSONArray.mo162put((String) it.next());
            }
            return jSONArray.toString();
        }
        return super.call(method, params, callback);
    }

    private final String g(String params) {
        if (params == null) {
            return "{}";
        }
        String resId = new JSONObject(params).optString("bundle_name");
        IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
        Intrinsics.checkNotNullExpressionValue(resId, "resId");
        long lastRequestServerTime = iQQKuiklyDexResApi.getLastRequestServerTime(resId);
        if (QLog.isColorLevel()) {
            QLog.d("QQKuiklyBundleModule", 1, "[getLastRequestServerTime], time:" + lastRequestServerTime);
        }
        String jSONObject = new JSONObject().put("serverTime", lastRequestServerTime).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "result.toString()");
        return jSONObject;
    }

    private final String i(String params) {
        if (params == null) {
            return "{}";
        }
        String resId = new JSONObject(params).optString("bundle_name");
        IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
        Intrinsics.checkNotNullExpressionValue(resId, "resId");
        long fetchedResVersion = iQQKuiklyDexResApi.getFetchedResVersion(resId);
        if (QLog.isColorLevel()) {
            QLog.d("QQKuiklyBundleModule", 1, "[getLatestLocalVersion], version:" + fetchedResVersion);
        }
        String jSONObject = new JSONObject().put("localVersion", fetchedResVersion).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "result.toString()");
        return jSONObject;
    }

    private final void j(String params) {
        if (params == null || params.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
        String optString = jSONObject.optString("bundleName");
        Intrinsics.checkNotNullExpressionValue(optString, "paramJson.optString(\"bundleName\")");
        iQQKuiklyDexResApi.switchBundleShiplyEnv(optString, jSONObject.optBoolean(QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT));
    }

    private final void a(String params) {
        if (params == null) {
            return;
        }
        String bundleName = new JSONObject(params).optString("bundle_name");
        if (QLog.isColorLevel()) {
            QLog.d("QQKuiklyBundleModule", 1, "[deleteBundle], bundleName:" + bundleName);
        }
        if (TextUtils.isEmpty(bundleName)) {
            return;
        }
        IQQKuiklyDexResApi iQQKuiklyDexResApi = (IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class);
        Intrinsics.checkNotNullExpressionValue(bundleName, "bundleName");
        iQQKuiklyDexResApi.deleteBundle(bundleName);
    }

    private final void d(String params, final Function1<Object, Unit> callback) {
        Map mapOf;
        if (params != null) {
            ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getBundleInfoByScene(new JSONObject(params).optLong("scene_id"), new Function3<Boolean, Map<String, ? extends Long>, Map<String, ? extends String>, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyBundleModule$getBundleInfoByScene$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<String, ? extends Long> map, Map<String, ? extends String> map2) {
                    invoke(bool.booleanValue(), (Map<String, Long>) map, (Map<String, String>) map2);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, Map<String, Long> resMap, Map<String, String> errMap) {
                    Intrinsics.checkNotNullParameter(resMap, "resMap");
                    Intrinsics.checkNotNullParameter(errMap, "errMap");
                    try {
                        JSONObject jSONObject = new JSONObject();
                        if (!z16) {
                            jSONObject.put("errCode", -1);
                            jSONObject.put("errMsg", errMap.toString());
                        } else {
                            jSONObject.put("errCode", 0);
                            JSONArray jSONArray = new JSONArray();
                            for (Map.Entry<String, Long> entry : resMap.entrySet()) {
                                String key = entry.getKey();
                                long longValue = entry.getValue().longValue();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("bundle_name", key);
                                jSONObject2.put("version", longValue);
                                jSONArray.mo162put(jSONObject2);
                            }
                            Unit unit = Unit.INSTANCE;
                            jSONObject.put("list", jSONArray);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQKuiklyBundleModule", 1, "[getBundleInfoByScene], ret:" + jSONObject);
                        }
                        Function1<Object, Unit> function1 = callback;
                        if (function1 != null) {
                            function1.invoke(jSONObject);
                        }
                    } catch (Exception e16) {
                        QLog.e("QQKuiklyBundleModule", 1, e16, new Object[0]);
                        Function1<Object, Unit> function12 = callback;
                        if (function12 != null) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("errCode", -1);
                            jSONObject3.put("errMsg", e16.toString());
                            function12.invoke(jSONObject3);
                        }
                    }
                }
            });
        } else if (callback != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errCode", -1), TuplesKt.to("errMsg", "error params"));
            callback.invoke(mapOf);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2045377336:
                if (method.equals("getBundleInfosByScene")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1906906614:
                if (method.equals("getLatestLocalVersion")) {
                    return i(params);
                }
                return super.call(method, params, callback);
            case -1426138453:
                if (method.equals("updateBundle")) {
                    l(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1245940211:
                if (method.equals("deleteBundle")) {
                    a(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 319214702:
                if (method.equals("switchShiplyBundleEnv")) {
                    j(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1079160902:
                if (method.equals("getBundleInfo")) {
                    return c(params);
                }
                return super.call(method, params, callback);
            case 1601372915:
                if (method.equals("getLastRequestServerTime")) {
                    return g(params);
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
