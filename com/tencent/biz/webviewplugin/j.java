package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class j extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    AIOAnimationControlManager f97575d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements AIOAnimationControlManager.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f97576a;

        a(String str) {
            this.f97576a = str;
        }

        @Override // com.tencent.mobileqq.utils.AIOAnimationControlManager.i
        public void a(String str, String str2) {
            if (AIOAnimationControlManager.R.equals(str2)) {
                j.this.callJs(this.f97576a, "{\"result\":1,\"id\":" + str2 + "}");
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "NearbyTroopsPlugin";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if ("NearbyTroopsPlugin".equals(str2)) {
            if ("setSelectTypeResult".equals(str3) && strArr.length > 0) {
                q(strArr[0]);
                return true;
            }
            if ("giftAnimation".equals(str3) && strArr.length > 0) {
                p(strArr[0]);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        AppInterface b16 = this.mRuntime.b();
        Activity a16 = this.mRuntime.a();
        if (b16 == null || a16 == null) {
            return;
        }
        this.f97575d = (AIOAnimationControlManager) b16.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        AIOAnimationControlManager aIOAnimationControlManager = this.f97575d;
        if (aIOAnimationControlManager != null) {
            aIOAnimationControlManager.C();
        }
    }

    protected void p(String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsPlugin", 2, "giftAnimation:" + str);
            }
            Activity a16 = this.mRuntime.a();
            if (a16 != null && !a16.isFinishing()) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("id");
                long optLong = jSONObject.optLong(AppConstants.Key.COLUMN_MSG_SENDER_UIN, 0L);
                long optLong2 = jSONObject.optLong("receiveUin", 0L);
                String optString = jSONObject.optString("brief");
                boolean optBoolean = jSONObject.optBoolean("showClose", false);
                String optString2 = jSONObject.optString("senderAvatarURL");
                String optString3 = jSONObject.optString("receiverAvatarURL");
                String optString4 = jSONObject.optString("callback");
                MessageForDeliverGiftTips messageForDeliverGiftTips = new MessageForDeliverGiftTips();
                messageForDeliverGiftTips.animationPackageId = optInt;
                messageForDeliverGiftTips.senderUin = optLong;
                messageForDeliverGiftTips.receiverUin = optLong2;
                messageForDeliverGiftTips.showCloseBtn = optBoolean;
                messageForDeliverGiftTips.animationBrief = optString;
                messageForDeliverGiftTips.senderAvatarUrl = optString2;
                messageForDeliverGiftTips.receiveAvatarUrl = optString3;
                messageForDeliverGiftTips.frienduin = String.valueOf(10000L);
                AIOAnimationControlManager aIOAnimationControlManager = this.f97575d;
                if (aIOAnimationControlManager == null) {
                    callJs(optString4, "{\"result\":10,\"message\":\"troopGiftManager is null\"}");
                    return;
                }
                aIOAnimationControlManager.H(a16);
                if (this.f97575d.I(messageForDeliverGiftTips)) {
                    this.f97575d.I = new a(optString4);
                    callJs(optString4, "{\"result\":0,\"id\":" + optInt + "}");
                    return;
                }
                callJs(optString4, "{\"result\":2}");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + e16.toString());
            }
        }
    }

    protected void q(String str) {
        JSONObject jSONObject;
        try {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + str);
            }
            Activity a16 = this.mRuntime.a();
            Intent intent = new Intent();
            try {
                jSONObject = new JSONObject(str).getJSONObject("data");
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + e16.toString());
                }
                jSONObject = null;
            }
            if (jSONObject != null) {
                intent.putExtra("data", jSONObject.toString());
                a16.setResult(-1, intent);
            } else {
                a16.setResult(0, intent);
            }
            a16.finish();
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.d("NearbyTroopsPlugin", 2, "setSelectTypeResult:" + e17.toString());
            }
        }
    }
}
