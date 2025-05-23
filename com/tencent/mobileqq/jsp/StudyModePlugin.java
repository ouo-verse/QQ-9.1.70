package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class StudyModePlugin extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    Activity f238689d;

    /* renamed from: e, reason: collision with root package name */
    String f238690e = null;

    /* renamed from: f, reason: collision with root package name */
    protected AtomicBoolean f238691f = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class a implements EIPCResultCallback {
        a() {
        }

        @Override // eipc.EIPCResultCallback
        public void onCallback(EIPCResult eIPCResult) {
            StudyModePlugin.this.q(eIPCResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        int f238694a;

        /* renamed from: b, reason: collision with root package name */
        String f238695b;

        public b(int i3, String str) {
            this.f238694a = i3;
            this.f238695b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(EIPCResult eIPCResult) {
        this.f238691f.set(false);
        b w3 = w(eIPCResult);
        v(w3);
        x(w3);
    }

    private Activity s() {
        Activity a16 = this.mRuntime.a();
        while (a16 instanceof BasePluginActivity) {
            a16 = ((BasePluginActivity) a16).getOutActivity();
        }
        return a16;
    }

    private void t(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("nonce");
            String optString = jSONObject.optString("idKey", "");
            this.f238690e = jSONObject.optString("callback", "");
            QLog.e("StudyModePlugin", 1, "handleClearPassword, nonce : ", Long.valueOf(optLong), " idKey : ", optString, " mCallback : ", this.f238690e);
            if (this.f238691f.get()) {
                v(new b(2, HardCodeUtil.qqStr(R.string.f2051254r)));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putLong("nonce", optLong);
            bundle.putString("idKey", optString);
            this.f238691f.set(true);
            r(bundle);
        } catch (JSONException e16) {
            QLog.e("StudyModePlugin", 1, e16, new Object[0]);
        }
    }

    private void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int optInt = new JSONObject(str).optInt("jumpType");
            Intent intent = new Intent();
            intent.setAction("com.tencent.mobileqq.studymode.pwdverify.studyidentify");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("jumpType", optInt);
            this.mRuntime.a().sendBroadcast(intent);
            this.mRuntime.a().finish();
        } catch (JSONException e16) {
            QLog.e("StudyModePlugin", 1, e16, new Object[0]);
        }
    }

    private void v(b bVar) {
        if (TextUtils.isEmpty(this.f238690e)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", bVar.f238694a);
            jSONObject.put("errMsg", bVar.f238695b);
            if (QLog.isColorLevel()) {
                QLog.d("StudyModePlugin", 2, "native invoke web ret:" + bVar.f238694a + " errMsg:" + bVar.f238695b);
            }
            callJs(this.f238690e, jSONObject.toString());
        } catch (JSONException e16) {
            QLog.e("StudyModePlugin", 1, e16, new Object[0]);
        }
    }

    private b w(EIPCResult eIPCResult) {
        String str;
        b bVar = new b(-1, HardCodeUtil.qqStr(R.string.f2051254r));
        Bundle bundle = eIPCResult.data;
        if (bundle != null) {
            int i3 = bundle.getInt("ret", -1);
            bVar.f238694a = i3;
            if (i3 == 0) {
                str = "";
            } else {
                str = bVar.f238695b;
            }
            bVar.f238695b = bundle.getString("errMsg", str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("StudyModePlugin", 2, "parseEIPCResult ret:" + bVar.f238694a + " errMsg:" + bVar.f238695b);
        }
        return bVar;
    }

    private void x(b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("StudyModePlugin", 2, "uiUpdate ret:" + bVar.f238694a + " errMsg:" + bVar.f238695b);
        }
        if (bVar.f238694a != 0) {
            return;
        }
        final WebViewFragment webViewFragment = (WebViewFragment) this.mRuntime.f();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.jsp.StudyModePlugin.2
            @Override // java.lang.Runnable
            public void run() {
                WebViewFragment webViewFragment2 = webViewFragment;
                if (webViewFragment2 == null || webViewFragment2.getSwiftTitleUI() == null || webViewFragment.getSwiftTitleUI().f314054i == null) {
                    return;
                }
                webViewFragment.getSwiftTitleUI().f314054i.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "studyMode";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"studyMode".equals(str2)) {
            QLog.e("StudyModePlugin", 1, "handleJsRequest, pkgName not match, pkgName : ", str2);
            return false;
        }
        QLog.d("StudyModePlugin", 1, "handleJsRequest, method : ", str3);
        if ("goToStudySetting".equalsIgnoreCase(str3) && strArr.length > 0) {
            u(strArr[0]);
        } else if ("clearPassword".equalsIgnoreCase(str3) && strArr.length > 0) {
            t(strArr[0]);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
        this.f238689d = s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    protected void r(Bundle bundle) {
        QIPCClientHelper.getInstance().callServer("StudyModeIpcServer_model", "clear_pwd", bundle, new a());
    }
}
