package com.tencent.mobileqq.reminder.ark;

import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ark.module.b;
import com.tencent.mobileqq.ark.module.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.reminder.api.IQQReminderBlessingApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes18.dex */
public class ArkAppSendBirthdayBlessingModule extends b {
    public ArkAppSendBirthdayBlessingModule(ark.Application application, int i3) {
        super(application, i3);
    }

    private void p(ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (variantWrapperArr == null || variantWrapperArr.length < 1 || ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(variantWrapperArr[0].GetTableAsJsonString());
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String optString = jSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    try {
                        arrayList.add(Long.valueOf(Long.parseLong(optString)));
                    } catch (NumberFormatException unused) {
                        QLog.i("ark.sendBirthdayBlessing.module", 1, "sendBlessingFriendUins err uin[" + i3 + "] = " + optString);
                    }
                }
            }
            ((IQQReminderBlessingApi) QRoute.api(IQQReminderBlessingApi.class)).sendBlessingTimedMessage(arrayList, 1, null);
        } catch (JSONException e16) {
            QLog.i("ark.sendBirthdayBlessing.module", 1, "sendBlessingFriendUins error: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        super.Destruct();
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return "QQRemind";
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        return str.equals("SendBirthdayBlessingToFriend");
    }

    @Override // com.tencent.mobileqq.ark.module.b, com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        if (str.equals("SendBirthdayBlessingToFriend")) {
            p(variantWrapperArr, variantWrapper);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ark.sendBirthdayBlessing.module", 1, "Invoke method: " + str + " is error!");
            return false;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    protected e[] e() {
        return null;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean n() {
        return true;
    }

    @Override // com.tencent.mobileqq.ark.module.b
    public boolean o() {
        return false;
    }
}
