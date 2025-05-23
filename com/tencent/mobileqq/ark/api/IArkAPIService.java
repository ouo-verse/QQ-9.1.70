package com.tencent.mobileqq.ark.api;

import com.tencent.ark.ark;
import com.tencent.mobileqq.ark.module.g;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import org.json.JSONObject;

@QRouteFactory
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IArkAPIService extends QRouteApi {
    boolean dispatchAppNotification(String str, String str2, String str3);

    boolean dispatchOpenURL(String str, String str2, JSONObject jSONObject, int i3, String str3, String str4);

    void postArkNotify(String str, String str2, String str3, String str4);

    void registerAppNotification(String str, g gVar);

    void registerModules(ark.ModuleRegister moduleRegister, ark.Application application);

    void unregisterAppNotification(String str);
}
