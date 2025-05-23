package lx;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d implements s43.a {
    @Override // s43.a
    public JSONObject a() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime instanceof QQAppInterface) {
            QLog.d("AuthorizeConfigCommonBusinessDownloader", 1, "WebViewSwitchAio main process loadFuncDevWebViewConfig");
            return VasUpdateUtil.getJSONFromLocal(waitAppRuntime, "VASBiz_FuncDev_webview.json", true, null);
        }
        JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(waitAppRuntime, "VASBiz_FuncDev_webview.json", false, null);
        if (jSONFromLocal == null) {
            QLog.d("AuthorizeConfigCommonBusinessDownloader", 1, "WebViewSwitchAio calling main process to download FuncDevWebViewConfig");
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReqWithoutTimeout(com.tencent.mobileqq.emosm.a.a("download_FuncDev_webview", "", 0, null));
            return jSONFromLocal;
        }
        return jSONFromLocal;
    }
}
