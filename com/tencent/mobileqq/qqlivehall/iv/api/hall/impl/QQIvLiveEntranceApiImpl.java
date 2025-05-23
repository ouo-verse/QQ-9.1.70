package com.tencent.mobileqq.qqlivehall.iv.api.hall.impl;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveEntranceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/impl/QQIvLiveEntranceApiImpl;", "Lcom/tencent/mobileqq/qqlivehall/iv/api/hall/IQQIvLiveEntranceApi;", "()V", "aegisLogger", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "appendAdIdToTraceInfo", "", "url", "adId", "", "dealDynamicLiveRedTouch", "", "context", "Landroid/content/Context;", "appInterface", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "encodeString", "str", "getJumpUrl", "getLiveHallJumpUrl", "originUrl", "getUrlFromMsg", "jsonObject", "Lorg/json/JSONObject;", "getUrlFromParam", "qq-iv-live-hall-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQIvLiveEntranceApiImpl implements IQQIvLiveEntranceApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final IAegisLogApi aegisLogger;

    public QQIvLiveEntranceApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
    }

    private final String appendAdIdToTraceInfo(String url, long adId) {
        if (TextUtils.isEmpty(url)) {
            return url;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_id", adId);
        } catch (JSONException unused) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "JSONException happened!");
        }
        a aVar = a.f274100a;
        Intrinsics.checkNotNull(url);
        String str = aVar.b(url).get("trace_info");
        if (TextUtils.isEmpty(str)) {
            return aVar.a(url, "trace_info", jSONObject.toString());
        }
        try {
            JSONObject jSONObject2 = new JSONObject(Uri.decode(str));
            jSONObject2.put("ad_id", adId);
            return aVar.a(url, "trace_info", jSONObject2.toString());
        } catch (JSONException unused2) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "JSONException happened!");
            return url;
        }
    }

    private final String encodeString(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            Intrinsics.checkNotNullExpressionValue(encode, "encode(str, \"utf-8\")");
            return encode;
        } catch (UnsupportedEncodingException e16) {
            QLog.e("QQIvLiveEntranceApiImpl", 1, e16, new Object[0]);
            return str;
        }
    }

    private final String getJumpUrl(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "appInfo is null");
            return null;
        }
        if (!appInfo.buffer.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQIvLiveEntranceApiImpl", 2, "no buffer");
            }
            return null;
        }
        String str = appInfo.buffer.get();
        if (TextUtils.isEmpty(str)) {
            this.aegisLogger.i("QQIvLiveEntranceApiImpl", 1, "buffer is empty");
            return null;
        }
        appInfo.buffer.set("");
        try {
            QLog.i("QQIvLiveEntranceApiImpl", 1, str);
            JSONObject jSONObject = new JSONObject(str);
            String urlFromParam = getUrlFromParam(jSONObject);
            if (TextUtils.isEmpty(urlFromParam)) {
                urlFromParam = getUrlFromMsg(jSONObject);
            }
            return appendAdIdToTraceInfo(urlFromParam, jSONObject.optLong("ad_id"));
        } catch (JSONException e16) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "parse json error ,json=" + str + ",e=" + e16.getMessage());
            return null;
        }
    }

    private final String getUrlFromMsg(JSONObject jsonObject) {
        JSONObject optJSONObject = jsonObject.optJSONObject("msg");
        if (optJSONObject == null) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "msg is null");
            return null;
        }
        long optLong = jsonObject.optLong("ad_id");
        this.aegisLogger.i("QQIvLiveEntranceApiImpl", 1, "adId=" + optLong);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(String.valueOf(optLong));
        if (optJSONObject2 == null) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "redExtJsonObject is null");
            return null;
        }
        return optJSONObject2.optString(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK);
    }

    private final String getUrlFromParam(JSONObject jsonObject) {
        JSONObject optJSONObject = jsonObject.optJSONObject("param");
        if (optJSONObject == null) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "paramJsonObject is null");
            return null;
        }
        long optLong = jsonObject.optLong("ad_id");
        this.aegisLogger.i("QQIvLiveEntranceApiImpl", 1, "adId=" + optLong);
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(String.valueOf(optLong));
        if (optJSONObject2 == null) {
            this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "redExtJsonObject is null");
            return null;
        }
        if (optJSONObject2.optBoolean("_red_ext_has_rtmp")) {
            return optJSONObject2.optString("_red_ext_jump_url");
        }
        this.aegisLogger.e("QQIvLiveEntranceApiImpl", 1, "no rtmp");
        return null;
    }

    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveEntranceApi
    public void dealDynamicLiveRedTouch(@NotNull Context context, @NotNull BaseQQAppInterface appInterface, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, appInterface, appInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        String jumpUrl = getJumpUrl(appInfo);
        this.aegisLogger.i("QQIvLiveEntranceApiImpl", 1, "jumpUrl=" + jumpUrl);
        if (TextUtils.isEmpty(jumpUrl)) {
            return;
        }
        ax c16 = bi.c(appInterface, context, jumpUrl + "&pip=true");
        if (c16 != null) {
            QLog.d("QQIvLiveEntranceApiImpl", 2, "jumping");
            c16.b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    @Override // com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveEntranceApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getLiveHallJumpUrl(@Nullable String originUrl, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        boolean z16;
        boolean startsWith$default;
        int lastIndexOf$default;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) originUrl, (Object) appInfo);
        }
        this.aegisLogger.i("QQIvLiveEntranceApiImpl", 1, "getLiveHallJumpUrl:origin=" + originUrl);
        if (originUrl != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(originUrl);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(originUrl, "mqqapi://vaslive/portal", false, 2, null);
                    if (startsWith$default) {
                        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) originUrl, "&buffer=", 0, false, 6, (Object) null);
                        if (lastIndexOf$default >= 0) {
                            originUrl = originUrl.substring(0, lastIndexOf$default);
                            Intrinsics.checkNotNullExpressionValue(originUrl, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                        }
                        if (appInfo == null) {
                            return originUrl;
                        }
                        if (appInfo.iNewFlag.has() && appInfo.iNewFlag.get() == 1) {
                            if (!appInfo.buffer.has()) {
                                return originUrl;
                            }
                            String str = appInfo.buffer.get();
                            Intrinsics.checkNotNullExpressionValue(str, "appInfo.buffer.get()");
                            originUrl = originUrl + "&buffer=" + encodeString(str);
                            if (QLog.isColorLevel()) {
                                QLog.i("QQIvLiveEntranceApiImpl", 2, "liveHallJumpUrl is " + originUrl);
                            }
                        }
                        return originUrl;
                    }
                    return originUrl;
                }
                return "mqqapi://vaslive/portal?from=1&qq_live_product_type=1";
            }
        }
        z16 = true;
        if (z16) {
        }
    }
}
