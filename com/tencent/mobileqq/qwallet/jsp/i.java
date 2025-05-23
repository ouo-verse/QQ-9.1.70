package com.tencent.mobileqq.qwallet.jsp;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.qwallet.student.StudentEntryFragment;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qwallet/jsp/i;", "", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "plugin", "Lorg/json/JSONObject;", "jsonData", "", "jsCallback", "", "a", "Landroid/content/Intent;", "intent", "", "requestCode", "b", "Ljava/lang/String;", "currentCallbackId", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentCallbackId;

    public final void a(@NotNull WebViewPlugin plugin, @Nullable JSONObject jsonData, @Nullable String jsCallback) {
        Activity activity;
        String str;
        String str2;
        String str3;
        long j3;
        String str4;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (QLog.isColorLevel()) {
            QLog.i("QWalletStudentHandler", 2, "QWalletStudentHandler...");
        }
        this.currentCallbackId = jsCallback;
        WebViewPlugin.b bVar = plugin.mRuntime;
        String str5 = null;
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
            QLog.i("QWalletStudentHandler", 2, "activity error : activity: " + activity2 + " is null");
            return;
        }
        if (jsonData != null) {
            str = jsonData.optString("appId");
        } else {
            str = null;
        }
        String str6 = "";
        if (str == null) {
            str = "";
        }
        if (jsonData != null) {
            str2 = jsonData.optString("openId");
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (jsonData != null) {
            str3 = jsonData.optString(CommonConstant.KEY_ACCESS_TOKEN);
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        if (jsonData != null) {
            j3 = jsonData.optLong("timestamp");
        } else {
            j3 = 0;
        }
        if (jsonData != null) {
            str4 = jsonData.optString("sign");
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        }
        if (jsonData != null) {
            str5 = jsonData.optString(WadlProxyConsts.CHANNEL);
        }
        if (str5 != null) {
            str6 = str5;
        }
        Intent intent = new Intent(activity, (Class<?>) QPublicTransFragmentActivity.class);
        intent.putExtra("extra_key_student_appid", str);
        intent.putExtra("extra_key_student_openid", str2);
        intent.putExtra("extra_key_student_access_token", str3);
        intent.putExtra("extra_key_student_timestamp", j3);
        intent.putExtra("extra_key_student_sign", str4);
        intent.putExtra("extra_key_student_channel", str6);
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("public_fragment_class", StudentEntryFragment.class.getName());
        plugin.startActivityForResult(intent, (byte) 100);
    }

    public final void b(@NotNull WebViewPlugin plugin, @Nullable Intent intent, byte requestCode) {
        String str;
        String stringExtra;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        if (requestCode != 100) {
            return;
        }
        int i3 = -1;
        if (intent != null) {
            i3 = intent.getIntExtra("extra_key_result_code", -1);
        }
        String str2 = "";
        if (intent == null || (str = intent.getStringExtra("extra_key_result_msg")) == null) {
            str = "";
        }
        if (intent != null && (stringExtra = intent.getStringExtra("extra_key_result_data")) != null) {
            str2 = stringExtra;
        }
        QLog.d("QWalletStudentHandler", 1, "onCallback: retCode = " + i3 + " retMsg = " + str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("retCode", i3);
        jSONObject.put("retMsg", str);
        jSONObject.put("result", str2);
        plugin.callJs(this.currentCallbackId, jSONObject.toString());
    }
}
