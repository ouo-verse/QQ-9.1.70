package com.tencent.mobileqq.vas.adv.web;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.comic.api.hippy.BoodoModuleProxy;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.preload.f;
import com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback;
import com.tencent.mobileqq.vas.adv.reward.data.VasRewardAdParams;
import com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import sz2.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016JO\u0010 \u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u001d\"\u0004\u0018\u00010\u0004H\u0014\u00a2\u0006\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/web/b;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "Lorg/json/JSONObject;", "jsonObj", "", "jsCallback", "", "u", "w", ReportConstant.COSTREPORT_PREFIX, "y", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "r", "Landroid/app/Activity;", "getActivity", "v", "t", "adJson", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "callback", "errMsg", "p", "getNameSpace", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "listener", "url", PushClientConstants.TAG_PKG_NAME, "method", "", "args", "", "handleJsRequest", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "<init>", "()V", "d", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends WebViewPlugin {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/adv/web/b$b", "Lcom/tencent/mobileqq/vas/adv/reward/callback/VasRewardAdCallback;", "", "retCode", "", "requestBizBuff", "reportBizBuff", "", "onReward", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.adv.web.b$b, reason: collision with other inner class name */
    /* loaded from: classes20.dex */
    public static final class C8904b implements VasRewardAdCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f308324b;

        C8904b(String str) {
            this.f308324b = str;
        }

        @Override // com.tencent.mobileqq.vas.adv.reward.callback.VasRewardAdCallback
        public void onReward(int retCode, @Nullable byte[] requestBizBuff, @Nullable byte[] reportBizBuff) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("returnCode", retCode);
            JSONObject jSONObject2 = new JSONObject();
            if (requestBizBuff != null) {
                jSONObject2.put("request_busi_buff", new String(requestBizBuff, Charsets.UTF_8));
            }
            jSONObject.put("data", jSONObject2);
            b.this.callJs(this.f308324b, jSONObject.toString(0));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/adv/web/b$c", "Lcom/tencent/mobileqq/vas/adv/web/event/VasAdvWebEvent$Callback;", "", "data", "", "errMsg", "", "onResult", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class c implements VasAdvWebEvent.Callback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f308326b;

        c(String str) {
            this.f308326b = str;
        }

        @Override // com.tencent.mobileqq.vas.adv.web.event.VasAdvWebEvent.Callback
        public void onResult(@Nullable Object data, @Nullable String errMsg) {
            String obj;
            JSONObject jSONObject = new JSONObject();
            if (data != null) {
                if (data instanceof String) {
                    obj = (String) data;
                } else {
                    obj = data.toString();
                }
                jSONObject.put("returnCode", 0);
                jSONObject.put("data", obj);
            } else {
                jSONObject.put("errorMsg", errMsg);
                jSONObject.put("returnCode", 1);
            }
            b.this.callJs(this.f308326b, jSONObject.toString());
        }
    }

    public b() {
        VasAdvSupport.INSTANCE.a().m();
    }

    private final Activity getActivity() {
        Activity a16 = this.mRuntime.a();
        Intrinsics.checkNotNullExpressionValue(a16, "mRuntime.activity");
        return a16;
    }

    private final void p(String callback, String errMsg) {
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("returnCode", -1);
            jSONObject.put("errorMsg", errMsg);
            callJs(callback, jSONObject.toString(0));
        }
    }

    private final JSONObject q(String adJson) {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(adJson)) {
            jSONObject.put("returnCode", 0);
            jSONObject.put("data", new JSONObject().put("preloadAd", adJson));
        } else {
            jSONObject.put("returnCode", -1);
            jSONObject.put("errorMsg", "preload ad is null");
        }
        return jSONObject;
    }

    private final VasRewardAdCallback r(String jsCallback) {
        return new C8904b(jsCallback);
    }

    private final void s(JSONObject jsonObj, String jsCallback) {
        try {
            String businessId = jsonObj.getString("businessId");
            c cVar = new c(jsCallback);
            VasAdvWebManager vasAdvWebManager = VasAdvWebManager.f308319d;
            Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
            vasAdvWebManager.c(businessId, "get_gdt_ad_data", cVar, null);
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleGetGdtAdData error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "handleGetGdtAdData invalid args", th5);
        }
    }

    private final void t(JSONObject jsonObj, String jsCallback) {
        try {
            String businessId = jsonObj.getString("businessId");
            f.Companion companion = f.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
            callJs(jsCallback, q(companion.b(businessId)).toString(0));
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleGetPreloadGdtAd error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "handleGetPreloadGdtAd failed", th5);
        }
    }

    private final void u(JSONObject jsonObj, String jsCallback) {
        try {
            String traceInfoOfLastClick = ((IVasService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IVasService.class, "tool")).getTianshuWebManager().getTraceInfoOfLastClick();
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(traceInfoOfLastClick)) {
                jSONObject.put("returnCode", 0);
                jSONObject.put("data", traceInfoOfLastClick);
            } else {
                jSONObject.put("returnCode", -1);
                jSONObject.put("errorMsg", "trace info don`t exist");
            }
            callJs(jsCallback, jSONObject.toString(0));
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleGetTraceInfo error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "handleGetTraceInfo failed", th5);
        }
    }

    private final void v(String jsCallback) {
        try {
            VasAdvSupport.INSTANCE.a().m();
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleInitDeviceInfo error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "handleInitDeviceInfo", th5);
        }
    }

    private final void w(JSONObject jsonObj, String jsCallback) {
        try {
            String businessId = jsonObj.getString("businessId");
            String string = jsonObj.getString("status");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"status\")");
            int parseInt = Integer.parseInt(string);
            VasAdvWebManager vasAdvWebManager = VasAdvWebManager.f308319d;
            Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
            vasAdvWebManager.c(businessId, "notify_web_status", null, Integer.valueOf(parseInt));
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleNotifyWebStatus error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "handleNotifyWebStatus invalid args", th5);
        }
    }

    private final void x(JSONObject jsonObj, String jsCallback) {
        boolean z16;
        boolean z17;
        try {
            VasRewardAdParams.Builder builder = new VasRewardAdParams.Builder();
            String string = jsonObj.getString("adv_pos");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"adv_pos\")");
            builder.setAdvPos(Integer.valueOf(Integer.parseInt(string)));
            String string2 = jsonObj.getString("reward_type");
            Intrinsics.checkNotNullExpressionValue(string2, "jsonObj.getString(\"reward_type\")");
            builder.setRewardType(Integer.valueOf(Integer.parseInt(string2)));
            builder.setRewardItem(jsonObj.optString("reward_item"));
            String optString = jsonObj.optString("reward_text");
            boolean z18 = false;
            if (optString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                optString = null;
            }
            builder.setRewardText(optString);
            VasAdvSupport.Companion companion = VasAdvSupport.INSTANCE;
            builder.setUin(Long.valueOf(companion.a().i()));
            String optString2 = jsonObj.optString("biz_src_id");
            if (optString2.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                optString2 = "biz_src_jc_vip";
            }
            builder.setBizSrcId(optString2);
            String optString3 = jsonObj.optString("gdt_biz_id");
            if (optString3.length() == 0) {
                z18 = true;
            }
            if (z18) {
                optString3 = companion.a().b();
            }
            builder.setGdtBizId(optString3);
            new h(getActivity(), builder.build(), r(jsCallback)).v();
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleRewardVideo error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "invalid args", th5);
        }
    }

    private final void y(JSONObject jsonObj, String jsCallback) {
        try {
            String businessId = jsonObj.getString("businessId");
            String string = jsonObj.getString("areaType");
            Intrinsics.checkNotNullExpressionValue(string, "jsonObj.getString(\"areaType\")");
            int parseInt = Integer.parseInt(string);
            VasAdvWebManager vasAdvWebManager = VasAdvWebManager.f308319d;
            Intrinsics.checkNotNullExpressionValue(businessId, "businessId");
            vasAdvWebManager.c(businessId, "handle_web_click", null, Integer.valueOf(parseInt));
        } catch (Throwable th5) {
            String message = th5.getMessage();
            if (message == null) {
                message = "handleWebViewClick error";
            }
            p(jsCallback, message);
            QLog.e("VasAdvWebPlugin", 1, "handleWebViewClick invalid args", th5);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    @NotNull
    public String getNameSpace() {
        return "vasAdv";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(@Nullable JsBridgeListener listener, @Nullable String url, @Nullable String pkgName, @Nullable String method, @NotNull String... args) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.d("VasAdvWebPlugin", 2, "handleJsRequest -> url : " + url + ",pkgName : " + pkgName + ",method : " + method + ",args[0 : " + args[0]);
        }
        if (Intrinsics.areEqual("vasAdv", pkgName)) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(args);
            String str = (String) firstOrNull;
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("callback", null);
                if (method == null) {
                    return false;
                }
                switch (method.hashCode()) {
                    case -1479864882:
                        if (!method.equals("getGdtAdData")) {
                            return false;
                        }
                        s(jSONObject, optString);
                        break;
                    case -1091552849:
                        if (!method.equals("showRewardAD")) {
                            return false;
                        }
                        x(jSONObject, optString);
                        break;
                    case -1091160153:
                        if (!method.equals("getPreloadGdtAd")) {
                            return false;
                        }
                        t(jSONObject, optString);
                        break;
                    case -1007590627:
                        if (!method.equals(BoodoModuleProxy.METHOD_NOTIFY_WEB_STATUS)) {
                            return false;
                        }
                        w(jSONObject, optString);
                        break;
                    case 714346717:
                        if (!method.equals("getTraceInfo")) {
                            return false;
                        }
                        u(jSONObject, optString);
                        break;
                    case 1467416640:
                        if (!method.equals("handleClick")) {
                            return false;
                        }
                        y(jSONObject, optString);
                        break;
                    case 1696532820:
                        if (!method.equals("initDeviceInfo")) {
                            return false;
                        }
                        v(optString);
                        break;
                    default:
                        return false;
                }
                return true;
            }
            return super.handleJsRequest(listener, url, pkgName, method, (String[]) Arrays.copyOf(args, args.length));
        }
        return false;
    }
}
