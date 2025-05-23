package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.business.QQPermissionBusinessManager;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class x extends WebViewPlugin {
    private List<QQPermissionBusinessManager.a> p(String str, List<String> list) {
        List<QQPermissionBusinessManager.a> findBusinessIdList = QQPermissionBusinessManager.findBusinessIdList(str, list);
        Activity r16 = r();
        if (r16 != null) {
            for (QQPermissionBusinessManager.a aVar : findBusinessIdList) {
                aVar.f274303e = com.tencent.mobileqq.qqpermission.multiscene.a.d(r16, aVar.f274300b, aVar.f274301c);
            }
        }
        return findBusinessIdList;
    }

    private String parseCallback(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("callback");
        } catch (JSONException e16) {
            QLog.e("QQPermissionPlugin", 2, "parse callback exception", e16);
            return null;
        }
    }

    private void q(String str) {
        String parseCallback = parseCallback(str);
        if (TextUtils.isEmpty(parseCallback)) {
            QLog.e("QQPermissionPlugin", 1, "getAppModuleList callback is null");
            return;
        }
        try {
            String optString = new JSONObject(str).optString("permissionId");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            List<QQPermissionBusinessManager.a> p16 = p(optString, PermissionUtil.queryPermissionsByGroup(r(), optString));
            JSONObject jSONObject = new JSONObject();
            if (p16 != null) {
                for (QQPermissionBusinessManager.a aVar : p16) {
                    try {
                        String str2 = aVar.f274300b;
                        if (str2 != null) {
                            jSONObject.put(str2, aVar.f274303e ? 0 : 1);
                        }
                    } catch (JSONException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("QQPermissionPlugin", 2, "getAppModuleList put json object exception", e16);
                        }
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("params", jSONObject);
            callJs(parseCallback, jSONObject2.toString());
        } catch (JSONException e17) {
            QLog.e("QQPermissionPlugin", 1, "getAppModuleList error: ", e17);
        }
    }

    private Activity r() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void s(String str) {
        String parseCallback = parseCallback(str);
        Activity r16 = r();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("permissionId");
            String optString2 = jSONObject.optString("moduleId");
            int optInt = jSONObject.optInt("authState");
            if (r16 != null) {
                com.tencent.mobileqq.qqpermission.multiscene.a.e(r16, optString2, optString, optInt == 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("result", 0);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("params", jSONObject2);
                callJs(parseCallback, jSONObject3.toString());
            }
        } catch (JSONException e16) {
            QLog.e("QQPermissionPlugin", 1, "getAppModuleList error: ", e16);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return QCircleDaTongConstant.ElementParamValue.PERMISSION;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        QLog.d("QQPermissionPlugin", 1, "handleJsRequest, url=" + str + ", pkgName=" + str2 + ", methodName=" + str3);
        if (!QCircleDaTongConstant.ElementParamValue.PERMISSION.equals(str2) || strArr.length == 0) {
            return false;
        }
        if ("getAppModuleList".equals(str3)) {
            q(strArr[0]);
            return true;
        }
        if ("setModuleAuthState".equals(str3)) {
            s(strArr[0]);
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
