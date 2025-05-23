package com.tencent.mobileqq.jsp;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.api.ProcessConstant;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class AVGameShareJsApiPlugin extends WebViewPlugin {
    private void p(String... strArr) {
        try {
            QLog.d("AVGameShareJsApiPlugin", 1, "Call createRoom");
            Intent intent = new Intent(this.mRuntime.a(), (Class<?>) JumpActivity.class);
            StringBuilder sb5 = new StringBuilder(50);
            sb5.append("mqqapi://avgame/create_room?gameType=");
            if (strArr != null && strArr.length > 0) {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                sb5.append(Integer.valueOf(jSONObject.optString("gameType")).intValue());
                if (jSONObject.has(IProfileCardConst.KEY_FROM_TYPE)) {
                    sb5.append("&fromType=");
                    sb5.append(Integer.valueOf(jSONObject.optString(IProfileCardConst.KEY_FROM_TYPE)).intValue());
                }
            }
            intent.setData(Uri.parse(sb5.toString()));
            this.mRuntime.a().startActivity(intent);
        } catch (Exception e16) {
            QLog.e("AVGameShareJsApiPlugin", 1, "Call createRoom fail: " + e16.getMessage());
        }
    }

    private void r(String... strArr) {
        try {
            QLog.d("AVGameShareJsApiPlugin", 1, "handlePKQQCJAction");
            Intent intent = new Intent(this.mRuntime.a(), (Class<?>) JumpActivity.class);
            StringBuilder sb5 = new StringBuilder(100);
            sb5.append("mqqapi://avgame/pk_qqcj?");
            if (strArr != null && strArr.length > 0) {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                sb5.append("pkid=");
                sb5.append(Long.valueOf(jSONObject.optString("pkid")).longValue());
                sb5.append("&starttime=");
                sb5.append(Long.valueOf(jSONObject.optString(AEEditorConstants.VIDEO_CLIP_START_TIME)).longValue());
                sb5.append("&endtime=");
                sb5.append(Long.valueOf(jSONObject.optString(AEEditorConstants.VIDEO_CLIP_END_TIME)).longValue());
                sb5.append("&iscj=");
                sb5.append(Integer.valueOf(jSONObject.optString("iscj")).intValue());
                if (jSONObject.has("fromtype")) {
                    sb5.append("&fromtype=");
                    sb5.append(Integer.valueOf(jSONObject.optString("fromtype")).intValue());
                }
            }
            intent.setData(Uri.parse(sb5.toString()));
            this.mRuntime.a().startActivity(intent);
        } catch (Exception e16) {
            QLog.e("AVGameShareJsApiPlugin", 1, "handlePKQQCJActionfail: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return ProcessConstant.AVGAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, url is empty");
            return false;
        }
        QLog.d("AVGameShareJsApiPlugin", 1, "Call AVGameShareJsApiPlugin handleJsRequest, url" + str + " pkgName:" + str2);
        if (ProcessConstant.AVGAME.equals(str2)) {
            if ("joinRoom".equals(str3)) {
                q(strArr);
                return true;
            }
            if ("createRoom".equals(str3)) {
                p(strArr);
                return true;
            }
            if ("shareAward".equals(str3)) {
                s(strArr);
                return true;
            }
            if ("pk_qqcj".equals(str3)) {
                r(strArr);
                return true;
            }
            QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, method not match");
            return false;
        }
        QLog.e("AVGameShareJsApiPlugin", 1, "Call avgame jsapi error, package not match");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
    }

    private void q(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            QLog.d("AVGameShareJsApiPlugin", 1, "Call joinRoom, args:" + strArr);
            try {
                String optString = new JSONObject(strArr[0]).optString("key");
                Intent intent = new Intent(this.mRuntime.a(), (Class<?>) JumpActivity.class);
                intent.setData(Uri.parse("mqqapi://avgame/join_room?key=" + optString));
                this.mRuntime.a().startActivity(intent);
                return;
            } catch (Exception e16) {
                QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail: " + e16.getMessage());
                return;
            }
        }
        QLog.e("AVGameShareJsApiPlugin", 1, "Call joinRoom fail, args empty");
    }

    private void s(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            QLog.d("AVGameShareJsApiPlugin", 1, "Call handleShareArk, args:" + strArr);
            try {
                Intent intent = this.mRuntime.a().getIntent();
                TextUtils.isEmpty(intent.getStringExtra("avgame_share_link"));
                intent.getStringExtra("avgame_share_name");
                JSONObject jSONObject = new JSONObject(strArr[0]);
                jSONObject.optString("awardTitle");
                jSONObject.optString("awardDesc");
                jSONObject.optString("awardIconUrl");
                this.mRuntime.b().getCurrentAccountUin();
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.jsp.AVGameShareJsApiPlugin.1
                    @Override // java.lang.Runnable
                    public void run() {
                    }
                }, 200L);
                return;
            } catch (Exception e16) {
                QLog.e("AVGameShareJsApiPlugin", 1, "Call handleShareArk fail: " + e16.getMessage());
                return;
            }
        }
        QLog.e("AVGameShareJsApiPlugin", 1, "Call handleShareArk fail, args empty");
    }
}
