package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.ark.module.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.module.c;
import com.tencent.mobileqq.ark.module.d;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public class ArkAPIServiceImpl implements IArkAPIService {
    public static boolean postArkNotify(String str, String str2, String str3, String str4, String str5) {
        l91.a.a();
        try {
            return ark.arkNotify(str, str2, str3, str4, str5);
        } catch (UnsatisfiedLinkError e16) {
            QLog.w("ArkApp", 1, "postArkNotify: " + e16.toString());
            return false;
        }
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAPIService
    public boolean dispatchAppNotification(String str, String str2, String str3) {
        return ArkAppNotifyCenter.notify(str, str2, str3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAPIService
    public boolean dispatchOpenURL(String str, String str2, JSONObject jSONObject, int i3, String str3, String str4) {
        return d.a(str, str2, jSONObject, i3, str3, str4);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAPIService
    public void registerAppNotification(String str, g gVar) {
        ArkAppNotifyCenter.setNotify(str, gVar);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAPIService
    public void registerModules(ark.ModuleRegister moduleRegister, ark.Application application) {
        c.c(moduleRegister, application);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAPIService
    public void unregisterAppNotification(String str) {
        ArkAppNotifyCenter.removeNotify(str);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkAPIService
    public void postArkNotify(String str, String str2, String str3, String str4) {
        postArkNotify(str, str2, str3, str4, ark.ARKMETADATA_JSON);
    }
}
