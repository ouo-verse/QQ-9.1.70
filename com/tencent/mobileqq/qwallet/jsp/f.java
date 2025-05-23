package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.oskplayer.proxy.VideoProxy;
import com.tencent.qphone.base.util.QLog;
import fl2.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ=\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/f;", "Lcom/tencent/mobileqq/qwallet/jsp/QWalletJsPlugin$b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "", "args", "jsCallback", "", "a", "(Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;Lorg/json/JSONObject;[Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f extends QWalletJsPlugin.b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qwallet/jsp/f$b", "Lfl2/a$b;", "", "uin", "Lorg/json/JSONObject;", "rawData", "openId", CommonConstant.KEY_ACCESS_TOKEN, "", QAdRewardDefine$VideoParams.ISCACHE, "", "a", "", "retCode", "retMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewPlugin f278541a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f278542b;

        b(WebViewPlugin webViewPlugin, String str) {
            this.f278541a = webViewPlugin;
            this.f278542b = str;
        }

        @Override // fl2.a.b
        public void a(@Nullable String uin, @NotNull JSONObject rawData, @Nullable String openId, @Nullable String accessToken, boolean isCache) {
            Intrinsics.checkNotNullParameter(rawData, "rawData");
            QLog.i("OpenLoginHandler", 1, "openLogin success: " + rawData);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", 0);
            jSONObject.put("retMsg", "");
            jSONObject.put(QAdRewardDefine$VideoParams.ISCACHE, isCache ? 1 : 0);
            jSONObject.put("data", rawData);
            this.f278541a.callJs(this.f278542b, jSONObject.toString());
        }

        @Override // fl2.a.b
        public void onFail(int retCode, @NotNull String retMsg) {
            Intrinsics.checkNotNullParameter(retMsg, "retMsg");
            QLog.w("OpenLoginHandler", 1, "openLogin fail: " + retCode + " " + retMsg);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("retCode", retCode);
            jSONObject.put("retMsg", retMsg);
            this.f278541a.callJs(this.f278542b, jSONObject.toString());
        }
    }

    @Override // com.tencent.mobileqq.qwallet.jsp.QWalletJsPlugin.c
    public void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @NotNull String[] args, @Nullable String jsCallback) {
        Activity activity;
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(args, "args");
        QLog.i("OpenLoginHandler", 1, "OpenLoginHandler...");
        WebViewPlugin.b bVar = plugin.mRuntime;
        Integer num = null;
        Activity activity2 = null;
        if (bVar != null) {
            activity = bVar.a();
        } else {
            activity = null;
        }
        if (activity == null) {
            WebViewPlugin.b bVar2 = plugin.mRuntime;
            if (bVar2 != null) {
                activity2 = bVar2.a();
            }
            QLog.i("OpenLoginHandler", 2, "activity error : activity: " + activity2 + " is null");
            return;
        }
        WeakReference<Activity> weakReference = new WeakReference<>(activity);
        if (jsonData != null) {
            str = jsonData.optString("appid");
        } else {
            str = null;
        }
        if (jsonData != null) {
            num = Integer.valueOf(jsonData.optInt("apptype"));
        }
        Integer num2 = num;
        if (jsonData != null && jsonData.optInt(VideoProxy.PARAM_ENABLE_CACHE) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        fl2.a.f399772a.c(weakReference, true, str, num2, null, z16, new b(plugin, jsCallback));
    }
}
