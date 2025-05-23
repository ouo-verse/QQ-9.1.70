package com.tencent.mobileqq.qqecommerce.biz.kuikly.config;

import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.PreRequestData;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.QQKuiklyPrePrequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u000e\u001a\u00020\rJ\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0005R\u0016\u0010\u0018\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001aRH\u0010!\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u001d0\u001cj\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u001d`\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010&\u001a\u0004\b\u001f\u0010'R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010)R\u001b\u0010+\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010&\u001a\u0004\b\"\u0010'R\u0014\u0010-\u001a\u00020%8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010'\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/QQKuiklyConfigManager;", "", "", "pageName", "turboDisplayKey", "", "l", "a", "", "b", "(Ljava/lang/String;)Ljava/lang/Long;", "c", "i", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/b;", "g", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/a;", "f", "configName", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/d;", h.F, "k", "Lme2/a;", "Lme2/a;", "remoteConfigManager", "Loe2/a;", "Loe2/a;", "localConfig", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "d", "Ljava/util/HashMap;", "preRequestMap", "e", "Ljava/util/List;", "defaultTurboEnableList", "Lorg/json/JSONObject;", "Lkotlin/Lazy;", "()Lorg/json/JSONObject;", "asyncLoadJson", "Ljava/util/Map;", "defaultEmbedViewTimeoutList", "embedViewTimeoutJson", "j", "turboDisplayJson", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyConfigManager {

    /* renamed from: a, reason: collision with root package name */
    public static final QQKuiklyConfigManager f262835a = new QQKuiklyConfigManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static me2.a remoteConfigManager = new me2.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static oe2.a localConfig = new oe2.a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<String, Map<String, PreRequestData>> preRequestMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final List<String> defaultTurboEnableList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final Lazy asyncLoadJson;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Long> defaultEmbedViewTimeoutList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final Lazy embedViewTimeoutJson;

    static {
        List<String> listOf;
        Lazy lazy;
        Map<String, Long> mapOf;
        Lazy lazy2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"meta_dream_page", "qsearch_detail", "nearbypro_main", "stranger_public_account", "mini_game_store_home_page", "mini_game_store_category_page", "mini_game_store_game_list_page", "mini_game_store_gift_list_page", "mini_game_store_search_page", "mini_game_store_welfare_code_list_page"});
        defaultTurboEnableList = listOf;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager$asyncLoadJson$2
            @Override // kotlin.jvm.functions.Function0
            public final JSONObject invoke() {
                try {
                    return new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102913", "{}"));
                } catch (Throwable th5) {
                    QLog.i("QQKuiklyConfigManager", 1, "parse asyncLoadJson error: " + th5);
                    return new JSONObject();
                }
            }
        });
        asyncLoadJson = lazy;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("meta_dream_page", 500L), TuplesKt.to("adelie_category_home", 500L), TuplesKt.to("adelie_creative_center", 500L));
        defaultEmbedViewTimeoutList = mapOf;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<JSONObject>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager$embedViewTimeoutJson$2
            @Override // kotlin.jvm.functions.Function0
            public final JSONObject invoke() {
                try {
                    return new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103116", "{}"));
                } catch (Throwable th5) {
                    QLog.i("QQKuiklyConfigManager", 1, "embedViewTimeoutJson error: " + th5);
                    return new JSONObject();
                }
            }
        });
        embedViewTimeoutJson = lazy2;
    }

    QQKuiklyConfigManager() {
    }

    private final JSONObject d() {
        return (JSONObject) asyncLoadJson.getValue();
    }

    private final JSONObject e() {
        return (JSONObject) embedViewTimeoutJson.getValue();
    }

    private final JSONObject j() {
        try {
            return new JSONObject(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102324", "{}"));
        } catch (Throwable th5) {
            QLog.i("QQKuiklyConfigManager", 1, "parse turboDisplayJson error: " + th5);
            return new JSONObject();
        }
    }

    public final boolean a(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return Intrinsics.areEqual(d().optString(pageName), "1");
    }

    public final Long b(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (e().has(pageName)) {
            return Long.valueOf(e().optLong(pageName));
        }
        return defaultEmbedViewTimeoutList.get(pageName);
    }

    public final boolean c() {
        return Intrinsics.areEqual(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103188", "1"), "1");
    }

    public final List<KuiklyBundleConfig> f() {
        String str = (String) remoteConfigManager.getUnitedConfig(101417, "predownloadConfig", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                String optString = optJSONObject.optString("bundleName");
                Intrinsics.checkNotNullExpressionValue(optString, "bundleObj.optString(KEY_RES_ID)");
                arrayList.add(new KuiklyBundleConfig(optString, optJSONObject.optLong(KuiklyLaunchParams.PARAM_MIN_RES_VERSION)));
            }
        } catch (JSONException e16) {
            QLog.e("QQKuiklyConfigManager", 1, e16, new Object[0]);
        }
        return arrayList;
    }

    public final PreRequestData h(Object configName, String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (!(configName instanceof String)) {
            return null;
        }
        if (((CharSequence) configName).length() == 0) {
            return null;
        }
        HashMap<String, Map<String, PreRequestData>> hashMap = preRequestMap;
        Map<String, PreRequestData> map = hashMap.get(configName);
        if (map == null) {
            map = QQKuiklyPrePrequest.INSTANCE.b((String) configName);
            hashMap.put(configName, map);
        }
        return map.get(pageName);
    }

    public final String i(String pageName) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        return (String) remoteConfigManager.getUnitedConfig(102869, pageName, "");
    }

    public final boolean k() {
        return ((Number) remoteConfigManager.getUnitedConfig(101417, "kuiklyCrashReportSwitch", 1)).intValue() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(String pageName, String turboDisplayKey) {
        boolean z16;
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        if (j().has(pageName)) {
            if (Intrinsics.areEqual(j().optString(pageName), "1")) {
                if (turboDisplayKey != null) {
                    if (turboDisplayKey.length() > 0) {
                        z16 = true;
                        if (z16) {
                            return true;
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
        } else {
            boolean contains = defaultTurboEnableList.contains(pageName);
            if (contains) {
                return contains;
            }
            if (turboDisplayKey != null) {
                if (turboDisplayKey.length() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public final RequestConfig g() {
        List list;
        try {
            JSONObject jSONObject = new JSONObject((String) remoteConfigManager.getUnitedConfig(101417, "kuiklyRequestConfig", "{}"));
            JSONArray optJSONArray = jSONObject.optJSONArray("bundleList");
            if (optJSONArray == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            } else {
                int length = optJSONArray.length();
                ArrayList arrayList = new ArrayList(length);
                for (int i3 = 0; i3 < length; i3++) {
                    arrayList.add(optJSONArray.getString(i3));
                }
                list = arrayList;
            }
            return new RequestConfig(jSONObject.optInt("requestFullSwitch") == 1, jSONObject.optInt("requestFullGapMin", 180), jSONObject.optInt("requestBundleGapMin", 10), list);
        } catch (Exception e16) {
            QLog.e("QQKuiklyConfigManager", 1, e16, new Object[0]);
            return new RequestConfig(false, 0, 0, null, 15, null);
        }
    }
}
