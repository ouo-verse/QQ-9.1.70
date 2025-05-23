package com.tencent.mobileqq.ark.api.module.method;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.aio.BaseArkAppContainer;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModule;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.ark.f;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomArkDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IArkMsgService;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.qqnt.msg.data.a;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes11.dex */
public class MethodSendMessage implements e {
    @Override // com.tencent.mobileqq.ark.module.e
    public boolean a() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public boolean b() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public void c(b bVar, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        JSONObject jSONObject;
        boolean z16;
        BaseArkAppContainer baseArkAppContainer;
        if (variantWrapperArr != null && variantWrapperArr.length >= 1) {
            if (variantWrapperArr[0].IsArray() || variantWrapperArr[0].IsTable()) {
                String GetTableAsJsonString = variantWrapperArr[0].GetTableAsJsonString();
                try {
                    jSONObject = new JSONObject(GetTableAsJsonString);
                    if (variantWrapperArr.length > 1 && variantWrapperArr[1].GetType() == 2) {
                        z16 = variantWrapperArr[1].GetBool();
                    } else {
                        z16 = true;
                    }
                    if (variantWrapperArr.length >= 3 && variantWrapperArr[2].IsView()) {
                        baseArkAppContainer = ArkAppQQModule.h0(variantWrapperArr[2].GetView());
                    } else {
                        baseArkAppContainer = null;
                    }
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage parameter error: " + e16.getMessage());
                    }
                }
                if (jSONObject.has(MiniAppConst.MENU_STYLE_LIGHT)) {
                    final a d16 = d(jSONObject);
                    if (d16 == null) {
                        return;
                    }
                    if (z16) {
                        if (baseArkAppContainer != null) {
                            ((IArkMsgService) QRoute.api(IArkMsgService.class)).sendMsg(new Contact(baseArkAppContainer.getChatType(), baseArkAppContainer.getPeerUid(), ""), d16, null);
                            if (QLog.isColorLevel()) {
                                QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage light currentChat success");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.method.MethodSendMessage.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity f16 = ArkAppQQModuleBase.f();
                            if (f16 instanceof BaseActivity) {
                                Bundle a16 = QQCustomArkDialog.b.a(d16.d(), d16.e(), d16.f(), d16.c(), d16.m(), f.c(), null, null);
                                a16.putBoolean(AppConstants.Key.FORWARD_ARK_APP_DIRECT, false);
                                a16.putString("forward_ark_app_name", d16.d());
                                a16.putString("forward_ark_app_view", d16.e());
                                a16.putString(AppConstants.Key.FORWARD_ARK_APP_DESC, d16.a());
                                a16.putString("forward_ark_app_ver", d16.c());
                                a16.putString("forward_ark_app_meta", d16.m());
                                a16.putString("forward_ark_app_prompt", d16.n());
                                a16.putString(AppConstants.Key.FORWARD_ARK_APP_CONFIG, d16.g());
                                Intent intent = new Intent();
                                intent.setClass(f16, ForwardRecentActivity.class);
                                intent.putExtra("forward_type", 27);
                                intent.putExtra("is_ark_display_share", true);
                                intent.putExtras(a16);
                                if (QLog.isColorLevel()) {
                                    QLog.i("MethodSendMessage", 2, "multiAio.buildForwardIntent: " + a16);
                                }
                                ForwardBaseOption.startForwardActivity(f16, intent);
                            }
                        }
                    });
                    return;
                }
                if (jSONObject.has("text")) {
                    final String string = jSONObject.getString("text");
                    if (z16) {
                        if (baseArkAppContainer != null) {
                            new TextElement().setContent(string);
                            ArrayList<MsgElement> arrayList = new ArrayList<>();
                            arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(string));
                            ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(new Contact(baseArkAppContainer.getChatType(), baseArkAppContainer.getPeerUid(), ""), arrayList, null);
                            if (QLog.isColorLevel()) {
                                QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text currentChat success");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    ArkDispatchTask.getInstance().postToMainThread(new Runnable() { // from class: com.tencent.mobileqq.ark.api.module.method.MethodSendMessage.2
                        @Override // java.lang.Runnable
                        public void run() {
                            Activity f16 = ArkAppQQModuleBase.f();
                            if (f16 instanceof BaseActivity) {
                                Bundle bundle = new Bundle();
                                bundle.putString(AppConstants.Key.FORWARD_TEXT, string);
                                Intent intent = new Intent();
                                intent.putExtras(bundle);
                                intent.putExtra("direct_send_if_dataline_forward", true);
                                ForwardBaseOption.startForwardActivityForResult(f16, intent, 21);
                                if (QLog.isColorLevel()) {
                                    QLog.i("ArkApp", 1, "multiAio.QQ.SendMessage text success.");
                                }
                            }
                        }
                    });
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("ArkApp", 1, String.format("multiAio.QQ.SendMessage fail, packet:%s", GetTableAsJsonString));
                }
            }
        }
    }

    protected a d(JSONObject jSONObject) {
        String str;
        String str2 = "";
        try {
            String str3 = "0.0.01";
            JSONObject jSONObject2 = jSONObject.getJSONObject(MiniAppConst.MENU_STYLE_LIGHT);
            String string = jSONObject2.getString("Application");
            String string2 = jSONObject2.getString("View");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map<String, String> applicationFromManifest = ArkAppCacheMgr.getApplicationFromManifest(string, "", "0.0.01");
                if (applicationFromManifest != null) {
                    str2 = applicationFromManifest.get("desc");
                    str3 = applicationFromManifest.get("version");
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str2)) {
                    str = string;
                } else {
                    str = str2;
                }
                String optString = jSONObject2.optString("Prompt");
                if (TextUtils.isEmpty(optString)) {
                    optString = String.format(HardCodeUtil.qqStr(R.string.joj), str);
                }
                String str5 = optString;
                String jSONObject3 = jSONObject2.getJSONObject("MetaData").toString();
                JSONObject optJSONObject = jSONObject2.optJSONObject("Config");
                if (optJSONObject == null) {
                    optJSONObject = new JSONObject();
                }
                optJSONObject.put("forward", 1);
                return new a(str5, string, str, string2, "", str4, jSONObject3, optJSONObject.toString(), "");
            }
            return null;
        } catch (Exception e16) {
            QLog.e("MethodSendMessage", 1, "e = " + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public String getMethodName() {
        return "SendMessage";
    }

    @Override // com.tencent.mobileqq.ark.module.e
    public String getPermission() {
        return null;
    }
}
