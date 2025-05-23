package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.os.Build;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.hippy.qq.utils.WebSSOUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.jsp.am;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.b;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReq;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerReqComm;
import com.tencent.pb.webssoagent.WebSSOAgent$UniSsoServerRsp;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJI\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/b;", "Li01/e;", "", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "<init>", "()V", "d", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0002JK\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00040\u0012j\u0002`\u0016H\u0002JI\u0010\u001d\u001a\u00020\u00042'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00040\u0012j\u0002`\u00162\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0006H\u0002JQ\u0010\u001f\u001a\u00020\u00042'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00040\u0012j\u0002`\u00162\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0002H\u0002J=\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u00062+\u0010\u0017\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0012j\u0004\u0018\u0001`\u0016R\u0014\u0010#\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b*\u0010)R\u0014\u0010+\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010,\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010)R\u0014\u0010-\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b.\u0010$R\u0014\u0010/\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010$\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/b$a;", "", "Lorg/json/JSONObject;", "jsonObj", "", "f", "", "cmd", "", "timeout", "requestJson", "Lmqq/observer/BusinessObserver;", "observer", "g", "", "isSuccess", "Landroid/os/Bundle;", "bundle", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "e", "", WebSSOUtils.CALLBACK_COLUMN_SSORET, WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, "errorMsg", "c", "data", "b", "d", "params", tl.h.F, "CALLBACK_COLUMN_BUSINESSRET", "Ljava/lang/String;", "CALLBACK_COLUMN_DATA", "CALLBACK_COLUMN_MSG", "CALLBACK_COLUMN_SSORET", "CODE_SSO_RET_MSF_FAILED", "I", "CODE_SSO_RET_MSF_TIMEOUT", "CODE_SSO_RET_NO_CONNECTION", "CODE_SSO_RET_SUCCESS", "CODE_SSO_RET_UNKNOWN_ERROR", "METHOD_UNI_AGENT", "MODULE_NAME", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.b$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(Function1<Object, Unit> callback, int ssoRet, int businessRet, String errorMsg) {
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            b(callback, jSONObject, ssoRet, businessRet, errorMsg);
        }

        private final JSONObject d() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("fingerprint", Build.FINGERPRINT);
                jSONObject.put("model", DeviceInfoMonitor.getModel());
                jSONObject.put("manufacturer", Build.MANUFACTURER);
                jSONObject.put("brand", Build.BRAND);
                jSONObject.put("device", Build.DEVICE);
                jSONObject.put("product", Build.PRODUCT);
                jSONObject.put("id", Build.ID);
                jSONObject.put("level", Build.VERSION.SDK_INT);
                jSONObject.put("cpu_abi", Build.CPU_ABI);
                jSONObject.put("cpu_abi2", Build.CPU_ABI2);
            } catch (Throwable th5) {
                QLog.e("QKRNetworkModule", 1, "getRomData e:" + th5);
            }
            return jSONObject;
        }

        private final void g(String cmd, long timeout, String requestJson, BusinessObserver observer) {
            WebSSOAgent$UniSsoServerReqComm webSSOAgent$UniSsoServerReqComm = new WebSSOAgent$UniSsoServerReqComm();
            webSSOAgent$UniSsoServerReqComm.platform.set(109L);
            webSSOAgent$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
            webSSOAgent$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
            WebSSOAgent$UniSsoServerReq webSSOAgent$UniSsoServerReq = new WebSSOAgent$UniSsoServerReq();
            webSSOAgent$UniSsoServerReq.comm.set(webSSOAgent$UniSsoServerReqComm);
            webSSOAgent$UniSsoServerReq.reqdata.set(requestJson);
            NewIntent newIntent = new NewIntent(BaseApplication.context, am.class);
            newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, cmd);
            newIntent.putExtra("extra_data", webSSOAgent$UniSsoServerReq.toByteArray());
            newIntent.putExtra("extra_callbackid", "0");
            newIntent.putExtra("extra_timeout", timeout);
            newIntent.setObserver(observer);
            if (QLog.isColorLevel()) {
                QLog.d("QKRNetworkModule", 2, "uniAgent, req, cmd=" + cmd + ", reqData=" + requestJson);
            }
            AppInterface appInterface = HippyUtils.getAppInterface();
            if (appInterface != null) {
                appInterface.startServlet(newIntent);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(String cmd, Function1 cb5, int i3, boolean z16, Bundle bundle) {
            Intrinsics.checkNotNullParameter(cb5, "$cb");
            Companion companion = b.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(cmd, "cmd");
            companion.e(cmd, z16, bundle, cb5);
        }

        Companion() {
        }

        private final void b(Function1<Object, Unit> callback, String data, int ssoRet, int businessRet, String errorMsg) {
            Map mapOf;
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("data", data), TuplesKt.to(WebSSOUtils.CALLBACK_COLUMN_SSORET, Integer.valueOf(ssoRet)), TuplesKt.to(WebSSOUtils.CALLBACK_COLUMN_BUSINESSRET, Integer.valueOf(businessRet)), TuplesKt.to("msg", errorMsg));
            callback.invoke(mapOf);
        }

        private final void f(JSONObject jsonObj) {
            if (jsonObj == null) {
                return;
            }
            jsonObj.remove("callback");
            jsonObj.remove("cmd");
            jsonObj.remove("needCookie");
            jsonObj.remove("timeout");
        }

        private final void e(String cmd, boolean isSuccess, Bundle bundle, Function1<Object, Unit> callback) {
            String str;
            String rspData;
            if (bundle == null) {
                return;
            }
            if (!isSuccess) {
                int i3 = bundle.getInt(WadlProxyConsts.EXTRA_RESULT_CODE);
                if (i3 == 1001) {
                    String qqStr = HardCodeUtil.qqStr(R.string.f238617k9);
                    Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.websso_send_request_failed)");
                    c(callback, 201, 0, qqStr);
                    return;
                } else if (i3 != 1002 && i3 != 1013) {
                    String qqStr2 = HardCodeUtil.qqStr(R.string.f238637ka);
                    Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.websso_unknown_error)");
                    c(callback, 255, 0, qqStr2);
                    return;
                } else {
                    String qqStr3 = HardCodeUtil.qqStr(R.string.f238627k_);
                    Intrinsics.checkNotNullExpressionValue(qqStr3, "qqStr(R.string.websso_send_request_timeout)");
                    c(callback, 202, 0, qqStr3);
                    return;
                }
            }
            try {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray == null) {
                    c(callback, 255, 0, "SSO\u8fd4\u56de\u6570\u636e\u5305\u4e3a\u7a7a");
                    return;
                }
                WebSSOAgent$UniSsoServerRsp webSSOAgent$UniSsoServerRsp = new WebSSOAgent$UniSsoServerRsp();
                webSSOAgent$UniSsoServerRsp.mergeFrom(byteArray);
                long j3 = (webSSOAgent$UniSsoServerRsp.comm.has() && webSSOAgent$UniSsoServerRsp.comm.proctime.has()) ? webSSOAgent$UniSsoServerRsp.comm.proctime.get() : -1L;
                long j16 = webSSOAgent$UniSsoServerRsp.ret.has() ? webSSOAgent$UniSsoServerRsp.ret.get() : 0L;
                if (webSSOAgent$UniSsoServerRsp.errmsg.has()) {
                    str = webSSOAgent$UniSsoServerRsp.errmsg.get();
                } else {
                    str = "SSO\u53d1\u9001\u6210\u529f";
                }
                String errMsg = str;
                if (webSSOAgent$UniSsoServerRsp.rspdata.has()) {
                    rspData = webSSOAgent$UniSsoServerRsp.rspdata.get();
                } else {
                    rspData = new JSONObject().toString();
                }
                Intrinsics.checkNotNullExpressionValue(rspData, "rspData");
                Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
                b(callback, rspData, 0, (int) j16, errMsg);
                if (QLog.isColorLevel()) {
                    QLog.d("QKRNetworkModule", 2, "uniAgent callback svrCostTime:" + j3 + ", Json string=" + rspData + ", bizRet: " + j16);
                }
            } catch (Throwable th5) {
                QLog.e("QKRNetworkModule", 1, "onUniAgent, onReceive, Exception: " + th5);
                c(callback, 255, 0, "parse error");
            }
        }

        public final void h(String params, final Function1<Object, Unit> callback) {
            if (callback == null || params == null) {
                return;
            }
            if (!NetworkUtil.isNetworkAvailable()) {
                c(callback, 103, 0, "\u7f51\u7edc\u672a\u8fde\u63a5");
                return;
            }
            JSONObject jSONObject = new JSONObject(params);
            final String cmd = jSONObject.optString("cmd");
            long optLong = jSONObject.optLong("timeout", -1L);
            QLog.i("QKRNetworkModule", 1, "uniAgent, cmd: " + cmd + ", timout: " + optLong);
            Intrinsics.checkNotNullExpressionValue(cmd, "cmd");
            if (cmd.length() == 0) {
                String qqStr = HardCodeUtil.qqStr(R.string.f238607k8);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.websso_miss_cmd)");
                c(callback, 255, 0, qqStr);
            } else {
                f(jSONObject);
                jSONObject.put("option", d());
                BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.a
                    @Override // mqq.observer.BusinessObserver
                    public final void onReceive(int i3, boolean z16, Bundle bundle) {
                        b.Companion.i(cmd, callback, i3, z16, bundle);
                    }
                };
                String jSONObject2 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "paramsJSONObject.toString()");
                g(cmd, optLong, jSONObject2, businessObserver);
            }
        }
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, "uniAgent")) {
            INSTANCE.h(params, callback);
        }
        return Unit.INSTANCE;
    }
}
