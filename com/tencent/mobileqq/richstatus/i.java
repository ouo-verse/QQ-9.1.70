package com.tencent.mobileqq.richstatus;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelGalleryActivity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes35.dex */
public class i extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "historicalSig";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (str2.equalsIgnoreCase("historicalSig")) {
            String account = this.mRuntime.b().getAccount();
            Activity a16 = this.mRuntime.a();
            if (str3.equalsIgnoreCase("historicalSiglist")) {
                try {
                    JSONObject jSONObject = new JSONObject(strArr[0]);
                    String optString = jSONObject.optString(IProfileCardConst.KEY_FROM_TYPE);
                    String optString2 = jSONObject.optString("fromUin");
                    if (ChatActivityUtils.P(optString2)) {
                        Intent intent = new Intent(a16, (Class<?>) PublicFragmentActivity.class);
                        intent.putExtra("key_uin", optString2);
                        if (optString.equalsIgnoreCase("1")) {
                            intent.putExtra("key_open_via", "history-msglist");
                            a16.finish();
                        }
                        PublicFragmentActivity.b.a(a16, intent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
                    }
                    QLog.d("JumpProfilePlugin", 1, "historicalSiglist", "fromType=", optString, " fromUin", StringUtil.getSimpleUinForPrint(optString2));
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpProfilePlugin", 2, e16.getMessage(), e16);
                    }
                }
            } else if (str3.equalsIgnoreCase("personalTagList")) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strArr[0]);
                    String optString3 = jSONObject2.optString(IProfileCardConst.KEY_FROM_TYPE);
                    String optString4 = jSONObject2.optString("fromUin");
                    if (ChatActivityUtils.P(optString4)) {
                        Intent intent2 = new Intent(this.mRuntime.a(), (Class<?>) PersonalityLabelGalleryActivity.class);
                        intent2.putExtra("uin", optString4);
                        if (optString3.equalsIgnoreCase("1")) {
                            intent2.putExtra(IProfileCardConst.KEY_FROM_TYPE, 4);
                        }
                        a16.startActivity(intent2);
                        a16.finish();
                    }
                    QLog.d("JumpProfilePlugin", 1, "personalTagList", "fromType=", optString3, " fromUin", StringUtil.getSimpleUinForPrint(optString4));
                } catch (JSONException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpProfilePlugin", 2, e17.getMessage(), e17);
                    }
                }
            } else if (str3.equalsIgnoreCase("zanlist")) {
                try {
                    JSONObject jSONObject3 = new JSONObject(strArr[0]);
                    String optString5 = jSONObject3.optString(IProfileCardConst.KEY_FROM_TYPE);
                    String optString6 = jSONObject3.optString("fromUin");
                    if (ChatActivityUtils.P(optString6) && optString6.equalsIgnoreCase(account)) {
                        Intent intent3 = new Intent(a16, (Class<?>) VisitorsActivity.class);
                        intent3.putExtra("toUin", Long.valueOf(optString6));
                        intent3.putExtra("extra_show_rank", true);
                        if (optString5.equalsIgnoreCase("1")) {
                            intent3.putExtra("extra_from", 2);
                        }
                        a16.startActivity(intent3);
                        a16.finish();
                    }
                    QLog.d("JumpProfilePlugin", 1, "zanlist", "fromType=", optString5, " fromUin", StringUtil.getSimpleUinForPrint(optString6));
                } catch (JSONException e18) {
                    if (QLog.isColorLevel()) {
                        QLog.i("JumpProfilePlugin", 2, e18.getMessage(), e18);
                    }
                }
            }
            return true;
        }
        return super.handleJsRequest(jsBridgeListener, str, str2, str3, strArr);
    }
}
