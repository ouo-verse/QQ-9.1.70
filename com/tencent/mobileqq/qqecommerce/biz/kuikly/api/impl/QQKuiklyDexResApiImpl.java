package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexResInfo;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.d;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.KuiklyBundleConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.RequestConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.api.g;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.n;
import iz3.e;
import iz3.l;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import uf2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100JA\u0010\f\u001a\u00020\u00072#\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00022\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016J=\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016J5\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\n2#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016J;\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00172#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0016J-\u0010\u001c\u001a\u00020\u00072#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\nH\u0016Jw\u0010%\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\r2e\u0010\u0006\u001aa\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\"\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(#\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u0007\u0018\u00010!H\u0016J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u0014H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\u0017H\u0016R\u0017\u0010+\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyDexResApiImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyDexResApi;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "Lkotlin/ParameterName;", "name", "result", "", "callback", "", "", "resultMap", "callbackMultiDexRes", "", "getRequestFullConfigTime", "requestTime", "setRequestFullConfigTime", "resId", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/b;", "getDexResInfo", "", "forceUpdate", "updateDexRes", "", "resIdList", "updateMultiDexRes", "pageName", "isDexPageExist", "requestFullConfig", "getLastRequestServerTime", "getFetchedResVersion", "deleteBundle", "scenc", "Lkotlin/Function3;", "isAllSuccess", "resMap", "errMap", "getBundleInfoByScene", "bundleName", QFSSearchBaseRequest.EXTRA_KEY_IS_TEST_ENVIRONMENT, "switchBundleShiplyEnv", "getShiplyTestBundleList", "Loe2/a;", DownloadInfo.spKey_Config, "Loe2/a;", "getConfig", "()Loe2/a;", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyDexResApiImpl implements IQQKuiklyDexResApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_KUIKLY_SHIPLY_TEST = "key_kuikly_shiply_test";
    private static final String KEY_REQUEST_FULL_CONFIG = "kuikly_request_full_config_";
    private static final String TAG = "QQKuiklyDexResApiImpl";
    private final oe2.a config = new oe2.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyDexResApiImpl$a;", "", "", "KEY_KUIKLY_SHIPLY_TEST", "Ljava/lang/String;", "KEY_REQUEST_FULL_CONFIG", "TAG", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyDexResApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u00072\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyDexResApiImpl$b", "Lcom/tencent/rdelivery/reshub/api/b;", "", "isAllSuccess", "", "", "Lcom/tencent/rdelivery/reshub/api/g;", "Lcom/tencent/rdelivery/reshub/api/BatchResult;", "resMap", "Lcom/tencent/rdelivery/reshub/api/n;", "Lcom/tencent/rdelivery/reshub/api/BatchError;", "errorMap", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.rdelivery.reshub.api.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3<Boolean, Map<String, Long>, Map<String, String>, Unit> f262818a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function3<? super Boolean, ? super Map<String, Long>, ? super Map<String, String>, Unit> function3) {
            this.f262818a = function3;
        }

        @Override // com.tencent.rdelivery.reshub.api.b
        public void a(boolean isAllSuccess, Map<String, ? extends g> resMap, Map<String, ? extends n> errorMap) {
            Intrinsics.checkNotNullParameter(resMap, "resMap");
            Intrinsics.checkNotNullParameter(errorMap, "errorMap");
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            if (isAllSuccess) {
                for (Map.Entry<String, ? extends g> entry : resMap.entrySet()) {
                    hashMap.put(entry.getKey(), Long.valueOf(entry.getValue().getVersion()));
                }
            } else {
                for (Map.Entry<String, ? extends n> entry2 : errorMap.entrySet()) {
                    String key = entry2.getKey();
                    n value = entry2.getValue();
                    QLog.e(QQKuiklyDexResApiImpl.INSTANCE.getClass().getName(), 1, "[getBundleInfoByScene] err: " + key + ", " + value);
                    hashMap2.put(key, value.message());
                }
            }
            Function3<Boolean, Map<String, Long>, Map<String, String>, Unit> function3 = this.f262818a;
            if (function3 != null) {
                function3.invoke(Boolean.valueOf(isAllSuccess), hashMap, hashMap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callbackMultiDexRes(Function1<? super ResError, Unit> callback, Map<String, ResError> resultMap) {
        Iterator<T> it = resultMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
        }
        QLog.i("QQKuiklyResUpdate", 1, "updateMultiDexRes callbackMultiDexRes code:0, msg:");
        if (callback != null) {
            callback.invoke(new ResError(0, ""));
        }
    }

    private final long getRequestFullConfigTime() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String str = KEY_REQUEST_FULL_CONFIG + (runtime != null ? runtime.getAccount() : null);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeLong(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestFullConfig$lambda$2(i resHub, Function1 function1) {
        Intrinsics.checkNotNullParameter(resHub, "$resHub");
        resHub.g(new c(function1));
    }

    private final void setRequestFullConfigTime(long requestTime) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String str = KEY_REQUEST_FULL_CONFIG + (runtime != null ? runtime.getAccount() : null);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong(str, requestTime);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateMultiDexRes$lambda$0(i resHub, final List resIdList, final QQKuiklyDexResApiImpl this$0, final Function1 function1) {
        Intrinsics.checkNotNullParameter(resHub, "$resHub");
        Intrinsics.checkNotNullParameter(resIdList, "$resIdList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        resHub.f(resIdList, new l() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyDexResApiImpl$updateMultiDexRes$1$1
            @Override // iz3.m
            public void a(List<RDeliveryData> remainedDatas, List<RDeliveryData> updatedDatas, List<RDeliveryData> deletedDatas) {
                Intrinsics.checkNotNullParameter(remainedDatas, "remainedDatas");
                Intrinsics.checkNotNullParameter(updatedDatas, "updatedDatas");
                Intrinsics.checkNotNullParameter(deletedDatas, "deletedDatas");
                QLog.i("QQKuiklyResUpdate", 1, "updateMultiDexRes requestMultiRemoteResConfig onSuccess");
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                final List<String> list = resIdList;
                final QQKuiklyDexResApiImpl qQKuiklyDexResApiImpl = this$0;
                final Function1<ResError, Unit> function12 = function1;
                for (final String str : list) {
                    c.f438902a.a(str, false).e(false, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyDexResApiImpl$updateMultiDexRes$1$1$onSuccess$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
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
                            Intrinsics.checkNotNullParameter(error, "error");
                            linkedHashMap.put(str, error);
                            if (linkedHashMap.size() == list.size()) {
                                qQKuiklyDexResApiImpl.callbackMultiDexRes(function12, linkedHashMap);
                            }
                        }
                    });
                }
            }

            @Override // iz3.m
            public void onFail(String reason) {
                Intrinsics.checkNotNullParameter(reason, "reason");
                QLog.i("QQKuiklyResUpdate", 1, "updateMultiDexRes onFail reason:" + reason);
            }

            @Override // iz3.l
            public void onSuccess(List<RDeliveryData> datas) {
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void deleteBundle(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        d.a.a(uf2.c.f438902a, resId, false, 2, null).deleteBundle(resId);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void getBundleInfoByScene(long scenc, Function3<? super Boolean, ? super Map<String, Long>, ? super Map<String, String>, Unit> result) {
        uf2.c.f438902a.b().c(scenc, new b(result));
    }

    public final oe2.a getConfig() {
        return this.config;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public DexResInfo getDexResInfo(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c a16 = d.a.a(uf2.c.f438902a, resId, false, 2, null);
        long f16 = a16.f();
        DexConfig d16 = a16.d();
        File b16 = a16.b();
        String path = b16 != null ? b16.getPath() : null;
        if (path == null) {
            path = "";
        }
        return new DexResInfo(f16, d16, path);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public long getFetchedResVersion(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        return d.a.a(uf2.c.f438902a, resId, false, 2, null).h();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public long getLastRequestServerTime(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        return d.a.a(uf2.c.f438902a, resId, false, 2, null).g();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public List<String> getShiplyTestBundleList() {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray((String) IECLocalConfig.a.b(this.config, KEY_KUIKLY_SHIPLY_TEST, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, null, 4, null));
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                String string = jSONArray.getString(i3);
                Intrinsics.checkNotNullExpressionValue(string, "testArray.getString(i)");
                arrayList.add(string);
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public boolean isDexPageExist(String resId, String pageName) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        String a16 = d.a.a(uf2.c.f438902a, resId, false, 2, null).a(pageName);
        return a16 != null && a16.length() > 0;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void requestFullConfig(final Function1<? super ResError, Unit> result) {
        RequestConfig g16 = QQKuiklyConfigManager.f262835a.g();
        if (!g16.getRequestFullConfigSwitch()) {
            QLog.i("QQKuiklyResUpdate", 1, "requestFullConfig switch not open, requestConfig:" + g16);
            if (result != null) {
                result.invoke(new ResError(-2, "switch is not open"));
                return;
            }
            return;
        }
        final i b16 = uf2.c.f438902a.b();
        long requestFullConfigTime = getRequestFullConfigTime();
        long serverTime = NetConnInfoCenter.getServerTime();
        int requestFullConfigGapMim = g16.getRequestFullConfigGapMim();
        if (serverTime > requestFullConfigTime && serverTime - requestFullConfigTime < requestFullConfigGapMim * 60) {
            if (result != null) {
                result.invoke(new ResError(1, ""));
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQKuiklyResUpdate", 1, "requestFullConfig too soon! it's on time gap minutes:" + requestFullConfigGapMim + ", lastTime:" + requestFullConfigTime);
                return;
            }
            return;
        }
        setRequestFullConfigTime(serverTime);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyDexResApiImpl.requestFullConfig$lambda$2(i.this, result);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void switchBundleShiplyEnv(String bundleName, boolean isTest) {
        List mutableList;
        Intrinsics.checkNotNullParameter(bundleName, "bundleName");
        QLog.i(TAG, 1, "switchBundleShiplyEnv bundleName:" + bundleName + ", isTest:" + isTest);
        try {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getShiplyTestBundleList());
            mutableList.remove(bundleName);
            if (isTest) {
                mutableList.add(0, bundleName);
            }
            JSONArray jSONArray = new JSONArray();
            Iterator it = mutableList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put((String) it.next());
            }
            IECLocalConfig.a.g(this.config, KEY_KUIKLY_SHIPLY_TEST, jSONArray.toString(), null, 4, null);
        } catch (JSONException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        uf2.c.f438902a.c().deleteAll();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void updateDexRes(String resId, boolean forceUpdate, Function1<? super ResError, Unit> result) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        uf2.c.f438902a.a(resId, false).e(forceUpdate, result);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void updateMultiDexRes(final List<String> resIdList, final Function1<? super ResError, Unit> result) {
        Intrinsics.checkNotNullParameter(resIdList, "resIdList");
        final i b16 = uf2.c.f438902a.b();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyDexResApiImpl.updateMultiDexRes$lambda$0(i.this, resIdList, this, result);
            }
        }, 128, null, true);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi
    public void updateDexRes(String resId, Function1<? super ResError, Unit> result) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        uf2.c.f438902a.a(resId, false).e(true, result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J2\u0010\f\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyDexResApiImpl$c", "Liz3/e;", "", "reason", "", "onFail", "onSuccess", "", "Lcom/tencent/rdelivery/data/RDeliveryData;", "remainedDatas", "updatedDatas", "deletedDatas", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<ResError, Unit> f262819a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super ResError, Unit> function1) {
            this.f262819a = function1;
        }

        @Override // iz3.e, iz3.m
        public void a(List<RDeliveryData> remainedDatas, List<RDeliveryData> updatedDatas, List<RDeliveryData> deletedDatas) {
            Intrinsics.checkNotNullParameter(remainedDatas, "remainedDatas");
            Intrinsics.checkNotNullParameter(updatedDatas, "updatedDatas");
            Intrinsics.checkNotNullParameter(deletedDatas, "deletedDatas");
            QLog.i("QQKuiklyResUpdate", 1, "requestFullConfig onSuccess");
            Function1<ResError, Unit> function1 = this.f262819a;
            if (function1 != null) {
                function1.invoke(new ResError(0, ""));
            }
            for (KuiklyBundleConfig kuiklyBundleConfig : QQKuiklyConfigManager.f262835a.f()) {
                if (kuiklyBundleConfig.getResId().length() > 0) {
                    QLog.i("QQKuiklyResUpdate", 1, "requestFullConfig trigger predownload:" + kuiklyBundleConfig.getResId());
                    uf2.c.f438902a.a(kuiklyBundleConfig.getResId(), false).e(false, null);
                }
            }
        }

        @Override // iz3.m
        public void onFail(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            QLog.i("QQKuiklyResUpdate", 1, "requestFullConfig onFail reason:" + reason);
            Function1<ResError, Unit> function1 = this.f262819a;
            if (function1 != null) {
                function1.invoke(new ResError(-1, reason));
            }
        }

        @Override // iz3.e
        public void onSuccess() {
        }
    }
}
