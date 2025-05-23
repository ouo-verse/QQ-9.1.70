package com.tencent.mobileqq.vas.font.magic.impl;

import QQService.EVIPSPEC;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontSetProxy;
import com.tencent.mobileqq.vas.http.VasHttpRequest;
import com.tencent.mobileqq.vip.r;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.AppSetting;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/font/magic/impl/VasMagicFontSetProxyImpl;", "Lcom/tencent/mobileqq/vas/font/magic/IVasMagicFontSetProxy;", "", "getDefaultUserAgent", "", "id", "Lkotlin/Function1;", "", "", "callback", "setMagicFont", "uin", "getUidByUin", "isMaigcFontEnable", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasMagicFontSetProxyImpl implements IVasMagicFontSetProxy {

    @NotNull
    private static final String CONTENT_TYPE_KEY = "application/json";

    @NotNull
    private static final String DISABLE_MAGIC_FONT_URL = "https://zb.vip.qq.com/srf/QC_FontLogicServer_FontLogicObj/SetUserEffect";

    @NotNull
    private static final String TAG = "VasMagicFontSetProxyImpl";

    @NotNull
    private static final MediaType postJsonMediaType;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/font/magic/impl/VasMagicFontSetProxyImpl$b", "Lcom/tencent/mobileqq/vas/api/VasSkey$c;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements VasSkey.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f309177a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppRuntime f309178b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VasMagicFontSetProxyImpl f309179c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f309180d;

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/font/magic/impl/VasMagicFontSetProxyImpl$b$a", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes20.dex */
        public static final class a implements Callback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1<Boolean, Unit> f309181a;

            /* JADX WARN: Multi-variable type inference failed */
            a(Function1<? super Boolean, Unit> function1) {
                this.f309181a = function1;
            }

            @Override // okhttp3.Callback
            public void onFailure(@NotNull Call call, @NotNull IOException e16) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e16, "e");
                QLog.i(VasMagicFontSetProxyImpl.TAG, 1, "call failed", e16);
                this.f309181a.invoke(Boolean.FALSE);
            }

            @Override // okhttp3.Callback
            public void onResponse(@NotNull Call call, @NotNull Response response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                QLog.i(VasMagicFontSetProxyImpl.TAG, 1, "success, " + response.code());
                if (response.isSuccessful()) {
                    this.f309181a.invoke(Boolean.TRUE);
                } else {
                    this.f309181a.invoke(Boolean.FALSE);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(String str, AppRuntime appRuntime, VasMagicFontSetProxyImpl vasMagicFontSetProxyImpl, Function1<? super Boolean, Unit> function1) {
            this.f309177a = str;
            this.f309178b = appRuntime;
            this.f309179c = vasMagicFontSetProxyImpl;
            this.f309180d = function1;
        }

        @Override // com.tencent.mobileqq.vas.api.VasSkey.c
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.i(VasMagicFontSetProxyImpl.TAG, 1, "errMsg: " + errMsg);
            this.f309180d.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.vas.api.VasSkey.c
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str = domainToKeyMap.get(this.f309177a);
            if (TextUtils.isEmpty(str)) {
                QLog.i(VasMagicFontSetProxyImpl.TAG, 1, "pskey is empty");
                return;
            }
            String currentUin = this.f309178b.getCurrentUin();
            RequestBody.Companion companion = RequestBody.INSTANCE;
            MediaType mediaType = VasMagicFontSetProxyImpl.postJsonMediaType;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("iFontEffectId", 0);
            jSONObject.put("iImplat", 2);
            jSONObject.put("strClientVer", AppSetting.getSubVersion());
            jSONObject.put("lUin", currentUin);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("iKeyType", 1);
            jSONObject2.put("iOpplat", 2);
            jSONObject2.put("lUin", currentUin);
            jSONObject2.put("sClientIp", "");
            jSONObject2.put("sClientVer", AppSetting.getSubVersion());
            Unit unit = Unit.INSTANCE;
            jSONObject.put("stLogin", jSONObject2);
            String jSONObject3 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "JSONObject().apply {\n   \u2026             }.toString()");
            Request.Builder method = new Request.Builder().url(VasMagicFontSetProxyImpl.DISABLE_MAGIC_FONT_URL).method("POST", companion.create(mediaType, jSONObject3));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("p_uin=" + currentUin + ";p_skey=" + str, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            VasHttpRequest.f309555a.c().newCall(method.header("Cookie", format).header("User-Agent", this.f309179c.getDefaultUserAgent()).build()).enqueue(new a(this.f309180d));
        }
    }

    static {
        MediaType parse = MediaType.INSTANCE.parse("application/json");
        Intrinsics.checkNotNull(parse);
        postJsonMediaType = parse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getDefaultUserAgent() {
        String n3 = i.n(i.i(""), "", false);
        Intrinsics.checkNotNullExpressionValue(n3, "getWebViewUAForQQ(\n     \u2026(\"\"), \"\", false\n        )");
        return n3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMagicFont$lambda$0(VasMagicFontSetProxyImpl this$0, Function1 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        VasSkey.getPSkey(peekAppRuntime, "vip.qq.com", new b("vip.qq.com", peekAppRuntime, this$0, callback));
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontSetProxy
    @NotNull
    public String getUidByUin(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QRouteApi api = QRoute.api(IRelationNTUinAndUidApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IRelationNTUinAndUidApi::class.java)");
        String uidFromUin = ((IRelationNTUinAndUidApi) api).getUidFromUin(uin);
        if (uidFromUin == null) {
            return "";
        }
        return uidFromUin;
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontSetProxy
    public boolean isMaigcFontEnable(@NotNull String uin) {
        boolean z16;
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uidByUin = getUidByUin(uin);
        QRouteApi api = QRoute.api(IVasInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasInfoService::class.java)");
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) api).getVasSimpleInfoWithUid(uidByUin, "getSuperSVipLevel");
        if (vasSimpleInfoWithUid == null) {
            QLog.i(TAG, 1, "get VasSimpleInfo is null");
            return false;
        }
        int a16 = r.a(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERVIP);
        if ((vasSimpleInfoWithUid.superVipInfo & 65536) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i(TAG, 1, "serviceLevel:" + a16 + " isYearSVip:" + z16);
        if (a16 < 3 || !z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.vas.font.magic.IVasMagicFontSetProxy
    public void setMagicFont(int id5, @NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.font.magic.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                VasMagicFontSetProxyImpl.setMagicFont$lambda$0(VasMagicFontSetProxyImpl.this, callback);
            }
        }, 16, null, false);
    }
}
