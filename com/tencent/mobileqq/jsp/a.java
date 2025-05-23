package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qqpermission.util.PermissionUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private Activity f238796d;

    private Activity p() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private String parseCallback(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str).optString("callback");
        } catch (JSONException e16) {
            QLog.e("AccountsPlugin", 2, "parse callback exception", e16);
            return null;
        }
    }

    private void q(String str) {
        String parseCallback = parseCallback(str);
        if (TextUtils.isEmpty(parseCallback)) {
            if (QLog.isColorLevel()) {
                QLog.i("AccountsPlugin", 2, "handleAuthorityList callback is null");
                return;
            }
            return;
        }
        List<PermissionUtil.PermissionGroup> requestedPermissionGroups = PermissionUtil.getRequestedPermissionGroups(p());
        JSONObject jSONObject = new JSONObject();
        if (requestedPermissionGroups != null) {
            for (PermissionUtil.PermissionGroup permissionGroup : requestedPermissionGroups) {
                try {
                    jSONObject.put(permissionGroup.name, PermissionUtil.checkPermission(p(), permissionGroup));
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AccountsPlugin", 2, "handleAuthorityList put json object exception", e16);
                    }
                }
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("params", jSONObject);
        } catch (JSONException e17) {
            if (QLog.isColorLevel()) {
                QLog.e("AccountsPlugin", 2, "handleAuthorityList put json object exception", e17);
            }
        }
        callJs(parseCallback, jSONObject2.toString());
    }

    private void r() {
        PermissionUtil.gotoSettingPage(p());
    }

    private void s(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("authentication", str);
        this.f238796d.getIntent().putExtras(bundle);
        Activity activity = this.f238796d;
        activity.setResult(-1, activity.getIntent());
        this.f238796d.finish();
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "accounts";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"accounts".equals(str2)) {
            return false;
        }
        if ("faceDelete".equals(str3)) {
            QLog.d("AccountsPlugin", 1, "receive api METHOD_DELETE_FACE");
            this.f238796d.setResult(-1);
            this.f238796d.finish();
            return true;
        }
        if ("authorityList".equals(str3)) {
            q(strArr[0]);
            return true;
        }
        if ("gotoSetting".equals(str3)) {
            r();
            return true;
        }
        if (!"authentication".equals(str3)) {
            return false;
        }
        QLog.d("AccountsPlugin", 1, "receive api authentication");
        s(strArr[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f238796d = p();
    }
}
