package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends VasWebviewJsPlugin {

    /* renamed from: d, reason: collision with root package name */
    private int f97559d = 0;

    /* renamed from: e, reason: collision with root package name */
    private String f97560e;

    public static void openSecCheckWeb(AppInterface appInterface, Context context, int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AddContactSecCheckWebPlugin", 2, "openSecCheckWeb, requestCode=" + i3 + ", url=" + str);
        }
        Intent p16 = p(appInterface, context, str);
        if (p16 == null) {
            return;
        }
        try {
            ((Activity) context).startActivityForResult(p16, i3);
        } catch (SecurityException unused) {
        }
    }

    public static void openSecCheckWebForFragment(AppInterface appInterface, Context context, QBaseFragment qBaseFragment, int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("AddContactSecCheckWebPlugin", 2, "openSecCheckWeb, requestCode=" + i3 + ", url=" + str);
        }
        Intent p16 = p(appInterface, context, str);
        if (p16 == null) {
            return;
        }
        try {
            qBaseFragment.startActivityForResult(p16, i3);
        } catch (SecurityException unused) {
        }
    }

    private static Intent p(AppInterface appInterface, Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("uin", appInterface.getCurrentAccountUin());
        intent.putExtra("url", str);
        return intent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int s(Activity activity, int i3) {
        WebViewProvider f16 = this.mRuntime.f();
        if (activity instanceof com.tencent.mobileqq.webview.swift.af) {
            return ((com.tencent.mobileqq.webview.swift.af) activity).switchRequestCode(this, (byte) i3);
        }
        return f16 != null ? f16.switchRequestCode(this, (byte) i3) : i3;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "addContact_SecCheck";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("addContact_SecCheck".equals(str2)) {
            if ("setTicket".equals(str3) && strArr.length == 1) {
                r(strArr[0]);
            } else if ("launchAct".equals(str3) && strArr.length == 1) {
                q(strArr[0]);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onActivityResult(Intent intent, byte b16, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AddContactSecCheckWebPlugin", 2, "doOnActivityResult requestCode = " + ((int) b16) + " resultCode = " + i3);
        }
        if (this.mRuntime.e() == null) {
            return;
        }
        int i16 = i3 == -1 ? 1 : 0;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("targetAct", (int) b16);
            jSONObject.put("status", i16);
            callJs(this.f97560e, jSONObject.toString());
        } catch (Exception e16) {
            QLog.e("AddContactSecCheckWebPlugin", 1, "doOnActivityResult exception:", e16);
        }
    }

    protected void q(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f97559d = jSONObject.optInt("targetAct", 0);
            this.f97560e = jSONObject.optString("callBackName", "");
            if (QLog.isColorLevel()) {
                QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, mTargetAct=" + this.f97559d + ", mCallBackName=" + this.f97560e);
            }
            if (this.f97559d > 0 && !TextUtils.isEmpty(this.f97560e)) {
                WebViewPlugin.b bVar = this.mRuntime;
                if (bVar != null && bVar.a() != null) {
                    Activity a16 = this.mRuntime.a();
                    int i3 = this.f97559d;
                    if (i3 == 1) {
                        Intent intent = new Intent(a16, (Class<?>) BindNumberActivity.class);
                        intent.putExtra("kSrouce", 21);
                        intent.putExtra("cmd_param_is_from_uni", true);
                        a16.startActivityForResult(intent, s(a16, 1));
                        return;
                    }
                    if (i3 == 2) {
                        Intent intent2 = new Intent(a16, (Class<?>) PhoneUnityBindInfoActivity.class);
                        intent2.putExtra("kSrouce", 21);
                        intent2.putExtra("kIsWeb", true);
                        a16.startActivityForResult(intent2, s(a16, 2));
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, runtime is null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AddContactSecCheckWebPlugin", 2, "launchAct, param is illeagal");
            }
        } catch (JSONException e16) {
            QLog.e("AddContactSecCheckWebPlugin", 2, "launchAct,", e16);
        }
    }

    protected void r(String str) {
        Activity a16;
        try {
            String optString = new JSONObject(str).optString("ticket");
            if (this.mRuntime.e() == null || this.mRuntime.b() == null || (a16 = this.mRuntime.a()) == null) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("ticket", optString);
            a16.setResult(-1, intent);
            if (!a16.isFinishing()) {
                a16.finish();
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("setTicket, ticket_len = ");
                sb5.append(TextUtils.isEmpty(optString) ? 0 : optString.length());
                QLog.d("AddContactSecCheckWebPlugin", 2, sb5.toString());
            }
        } catch (JSONException unused) {
        }
    }
}
