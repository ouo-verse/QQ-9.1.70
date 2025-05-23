package com.tencent.mobileqq.vashealth.honorstep;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vashealth.SSOHttpUtils;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\t\u001a\u00020\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nJ\u001e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0007J\u0006\u0010\u0019\u001a\u00020\rJ\u0006\u0010\u001a\u001a\u00020\u0002J\u0006\u0010\u001b\u001a\u00020\nJ\u0016\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0007R\u0019\u0010&\u001a\u0004\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/vashealth/honorstep/g;", "", "", "o", "", "startTime", "p", "", "i", DomainData.DOMAIN_NAME, "", tl.h.F, "step", "", "t", "authorCode", "openId", "appId", "r", CommonConstant.KEY_ACCESS_TOKEN, "refreshToken", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lo2/c;", "j", "e", ReportConstant.COSTREPORT_PREFIX, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "requestToken", "isRefresh", "f", "c", "l", "Lokhttp3/MediaType;", "b", "Lokhttp3/MediaType;", "k", "()Lokhttp3/MediaType;", "postJsonMediaType", "<init>", "()V", "health-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f312292a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static final MediaType postJsonMediaType = MediaType.INSTANCE.parse("application/json");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vashealth/honorstep/g$a", "Lcom/tencent/mobileqq/vas/api/VasSkey$c;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "health-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements VasSkey.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f312294a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f312295b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f312296c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f312297d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vashealth/honorstep/g$a$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "health-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.vashealth.honorstep.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes20.dex */
        public static final class C8945a implements Callback {
            C8945a() {
            }

            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e16) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e16, "e");
                QLog.i("HonorStepHelper", 1, "call failed", e16);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                String str;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    ResponseBody body = response.body();
                    if (body != null) {
                        str = body.string();
                    } else {
                        str = null;
                    }
                    JSONObject jSONObject = new JSONObject(new JSONObject(str).optString("data"));
                    String accessToken = jSONObject.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "");
                    String refreshToken = jSONObject.optString("refresh_token", "");
                    g gVar = g.f312292a;
                    Intrinsics.checkNotNullExpressionValue(accessToken, "accessToken");
                    Intrinsics.checkNotNullExpressionValue(refreshToken, "refreshToken");
                    gVar.q(accessToken, refreshToken);
                } catch (JSONException e16) {
                    QLog.i("HonorStepHelper", 1, "getAccessToken failed " + e16);
                }
            }
        }

        a(String str, AppRuntime appRuntime, String str2, boolean z16) {
            this.f312294a = str;
            this.f312295b = appRuntime;
            this.f312296c = str2;
            this.f312297d = z16;
        }

        @Override // com.tencent.mobileqq.vas.api.VasSkey.c
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i("HonorStepHelper", 1, "errMsg: " + errMsg);
        }

        @Override // com.tencent.mobileqq.vas.api.VasSkey.c
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            String replace$default;
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str = domainToKeyMap.get(this.f312294a);
            if (TextUtils.isEmpty(str)) {
                QLog.i("HonorStepHelper", 1, "pskey is empty");
                return;
            }
            String currentUin = this.f312295b.getCurrentUin();
            RequestBody.Companion companion = RequestBody.INSTANCE;
            g gVar = g.f312292a;
            MediaType k3 = gVar.k();
            JSONObject jSONObject = new JSONObject();
            String str2 = this.f312296c;
            boolean z16 = this.f312297d;
            jSONObject.put("iFontEffectId", 0);
            jSONObject.put("iImplat", 2);
            jSONObject.put("lUin", currentUin);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("iKeyType", 1);
            jSONObject2.put("iOpplat", 2);
            jSONObject2.put("lUin", currentUin);
            jSONObject2.put("sClientIp", "");
            Unit unit = Unit.INSTANCE;
            jSONObject.put("stLogin", jSONObject2);
            replace$default = StringsKt__StringsJVMKt.replace$default(str2, "\\", "", false, 4, (Object) null);
            if (z16) {
                jSONObject.put("refresh_token", replace$default);
            } else {
                jSONObject.put("code", replace$default);
            }
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026             }.toString()");
            Request.Builder method = new Request.Builder().url("https://yundong.qq.com/v2/cgi/honorAccessToken").method("POST", companion.create(k3, jSONObject3));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("p_uin=" + currentUin + ";p_skey=" + str, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            HttpRequest.f312280a.c().newCall(method.header("Cookie", format).header("User-Agent", gVar.i()).build()).enqueue(new C8945a());
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String requestToken, boolean z16) {
        Intrinsics.checkNotNullParameter(requestToken, "$requestToken");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        VasSkey.getPSkey(peekAppRuntime, "yundong.qq.com", new a("yundong.qq.com", peekAppRuntime, requestToken, z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        String n3 = i.n(i.i(""), "", false);
        Intrinsics.checkNotNullExpressionValue(n3, "getWebViewUAForQQ(\n     \u2026(\"\"), \"\", false\n        )");
        return n3;
    }

    private final boolean o() {
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106078", false);
        QLog.d("HonorStepHelper", 2, "isInHonorSystemWhiteList: " + isSwitchOn);
        return isSwitchOn;
    }

    private final boolean p(long startTime) {
        if (startTime > SSOHttpUtils.d() && startTime < SSOHttpUtils.c()) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        if (l().length() > 0) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (System.currentTimeMillis() - from.decodeLong("honor_health_cancel_permission_time", System.currentTimeMillis()) > 240000) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String e() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("honor_health_accessToken", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(Hono\u2026LTH_ACCESS_TOKEN_KEY, \"\")");
        return decodeString;
    }

    public final void f(@NotNull final String requestToken, final boolean isRefresh) {
        Intrinsics.checkNotNullParameter(requestToken, "requestToken");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vashealth.honorstep.f
            @Override // java.lang.Runnable
            public final void run() {
                g.g(requestToken, isRefresh);
            }
        }, 16, null, false);
    }

    public final int h() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        int decodeInt = from.decodeInt("honor_step_cache_data_key", 0);
        if (!p(from.decodeLong("honor_step_cache_date_key", 0L))) {
            return 0;
        }
        return decodeInt;
    }

    @NotNull
    public final o2.c j() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return new o2.c("220711583", from.decodeString("honor_health_openid", ""), from.decodeString("honor_health_accessToken", ""));
    }

    @Nullable
    public final MediaType k() {
        return postJsonMediaType;
    }

    @NotNull
    public final String l() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        String decodeString = from.decodeString("honor_health_refreshToken", "");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(Hono\u2026TH_REFRESH_TOKEN_KEY, \"\")");
        return decodeString;
    }

    public final int m() {
        boolean contains$default;
        boolean contains$default2;
        boolean contains$default3;
        boolean contains$default4;
        boolean contains$default5;
        boolean contains$default6;
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, false, 2, (Object) null);
        if (!contains$default) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, false, 2, (Object) null);
            if (!contains$default2) {
                String MODEL2 = DeviceInfoMonitor.getModel();
                Intrinsics.checkNotNullExpressionValue(MODEL2, "MODEL");
                contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) MODEL2, (CharSequence) "HUAWEI", false, 2, (Object) null);
                if (!contains$default3) {
                    Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                    contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "HUAWEI", false, 2, (Object) null);
                    if (!contains$default4) {
                        String MODEL3 = DeviceInfoMonitor.getModel();
                        Intrinsics.checkNotNullExpressionValue(MODEL3, "MODEL");
                        contains$default5 = StringsKt__StringsKt.contains$default((CharSequence) MODEL3, (CharSequence) "OPPO", false, 2, (Object) null);
                        if (!contains$default5) {
                            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
                            contains$default6 = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "OPPO", false, 2, (Object) null);
                            if (!contains$default6) {
                                return 0;
                            }
                            return 3;
                        }
                        return 3;
                    }
                }
                return 2;
            }
            return 1;
        }
        return 1;
    }

    public final boolean n() {
        boolean contains$default;
        boolean z16;
        boolean contains$default2;
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) MODEL, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, false, 2, (Object) null);
        if (!contains$default) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, false, 2, (Object) null);
            if (!contains$default2) {
                z16 = false;
                if (!z16 && o()) {
                    return true;
                }
            }
        }
        z16 = true;
        return !z16 ? false : false;
    }

    public final void q(@NotNull String accessToken, @NotNull String refreshToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(refreshToken, "refreshToken");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("honor_health_accessToken", accessToken);
        from.encodeString("honor_health_refreshToken", refreshToken);
        from.encodeLong("honor_health_accessToken_update_time", NetConnInfoCenter.getServerTimeMillis());
    }

    public final void r(@NotNull String authorCode, @NotNull String openId, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(authorCode, "authorCode");
        Intrinsics.checkNotNullParameter(openId, "openId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeString("honor_health_author_code", authorCode);
        from.encodeString("honor_health_appId", appId);
        from.encodeString("honor_health_openid", openId);
    }

    public final void s() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong("honor_health_cancel_permission_time", System.currentTimeMillis());
    }

    public final void t(int step) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeInt("honor_step_cache_data_key", step);
        from.encodeLong("honor_step_cache_date_key", NetConnInfoCenter.getServerTimeMillis());
    }
}
