package com.tencent.mobileqq.qqexpand.widget;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.logic.RemoteHandleManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class i extends WebViewPlugin {
    private void p(String str) {
        try {
            int optInt = new JSONObject(str).optInt("certificateResult");
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_result", optInt == 1);
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 2, "onNotifyCampusFriendCertificateResult result=" + optInt);
            }
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ExtendFriendQIPCModule", "notifyCampusFriendCertificateResult", bundle);
        } catch (JSONException e16) {
            QLog.i("WebViewPlugin", 1, "onNotifyCampusFriendCertificateResult exception", e16);
        }
    }

    private void q(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("category");
            String optString = jSONObject.optString("name");
            String optString2 = jSONObject.optString("schoolid");
            int optInt2 = jSONObject.optInt("idx");
            Bundle bundle = new Bundle();
            bundle.putString("name", optString);
            bundle.putInt("category", optInt);
            bundle.putString("schoolid", optString2);
            bundle.putInt("idx", optInt2);
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 2, "onNotifyUpdateSchoolInfo result=" + str);
            }
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ExtendFriendQIPCModule", "notifyUpdateSchoolInfo", bundle);
            RemoteHandleManager.getInstance().getSender().updateSchoolinfo(bundle, this.mRuntime.b().getCurrentAccountUin());
        } catch (JSONException e16) {
            QLog.i("WebViewPlugin", 1, "onNotifyUpdateSchoolInfo exception", e16);
        }
    }

    private void r(String str) {
        try {
            int optInt = new JSONObject(str).optInt("uploadResult");
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_result", optInt == 1);
            if (QLog.isColorLevel()) {
                QLog.i("WebViewPlugin", 2, "onNotifyUploadSutudentIDResult result=" + optInt);
            }
            BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "ExtendFriendQIPCModule", "notifyUploadSutudentIDResult", bundle);
        } catch (JSONException e16) {
            QLog.i("WebViewPlugin", 1, "onNotifyUploadSutudentIDResult exception", e16);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "extendFriend";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.i("WebViewPlugin", 2, "handleJsRequest url is: " + str + " method: " + str3 + " pkgName: " + str2 + " args: " + strArr);
        }
        if (!"extendFriend".equals(str2)) {
            return false;
        }
        if ("answerResult".equals(str3)) {
            String currentAccountUin = this.mRuntime.b().getCurrentAccountUin();
            if (!TextUtils.isEmpty(currentAccountUin)) {
                ((IExpandQuestionUtils) QRoute.api(IExpandQuestionUtils.class)).setAnswerQuestionFlag(currentAccountUin, false);
            }
            return true;
        }
        if ("notifyCampusFriendCertificateResult".equals(str3)) {
            if (strArr.length >= 1) {
                p(strArr[0]);
                RemoteHandleManager.getInstance().getSender().updateSchoolCertificate(strArr[0], "notifyCampusFriendCertificateResult", this.mRuntime.b().getCurrentAccountUin());
            } else {
                QLog.i("WebViewPlugin", 1, "NOTIFY_CAMPUS_FRIEND_CERTIFICATE_RESULT arg error");
            }
            return true;
        }
        if ("notifyUploadSutudentIDResult".equals(str3)) {
            if (strArr.length >= 1) {
                r(strArr[0]);
                RemoteHandleManager.getInstance().getSender().updateSchoolCertificate(strArr[0], "notifyUploadSutudentIDResult", this.mRuntime.b().getCurrentAccountUin());
            } else {
                QLog.i("WebViewPlugin", 1, "ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT arg error");
            }
            return true;
        }
        if (!"notifyUpdateSchoolInfo".equals(str3)) {
            return false;
        }
        if (strArr.length >= 1) {
            q(strArr[0]);
        } else {
            QLog.i("WebViewPlugin", 1, "ACTION_NOTIFY_STUDENTID_UPLOAD_RESULT arg error");
        }
        return true;
    }
}
