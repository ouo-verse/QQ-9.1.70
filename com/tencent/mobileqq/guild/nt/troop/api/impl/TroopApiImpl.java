package com.tencent.mobileqq.guild.nt.troop.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.data.QQGuildOpenData;
import com.tencent.mobileqq.guild.nt.troop.api.ITroopApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class TroopApiImpl implements ITroopApi {
    public static final String TAG = "TroopApiImpl";

    @Override // com.tencent.mobileqq.guild.nt.troop.api.ITroopApi
    public void enterTroop(String str, QQGuildOpenData qQGuildOpenData) {
        QLog.i("TroopApiImpl", 2, "handleEnterToTroop, troopUin: " + str + ",guildOpenData: " + qQGuildOpenData);
        if (TextUtils.isEmpty(str)) {
            QLog.e("TroopApiImpl", 1, "handleEnterToTroop error troop uin");
            return;
        }
        Intent m3 = BaseAIOUtils.m(new Intent(), new int[]{2});
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 1);
        m3.putExtra("fromThirdAppByOpenSDK", true);
        m3.putExtra("action", 4);
        m3.putExtra("appid", String.valueOf(qQGuildOpenData.appId));
        m3.putExtra("app_name", qQGuildOpenData.appName);
        m3.putExtra("pkg_name", qQGuildOpenData.packageId);
        RouteUtils.startActivity(BaseApplication.getContext(), m3, RouterConstants.UI_ROUTER_SPLASH);
    }

    @Override // com.tencent.mobileqq.guild.nt.troop.api.ITroopApi
    public String extractPackageId(Bundle bundle) {
        return bundle.getString("pkg_name");
    }

    @Override // com.tencent.mobileqq.guild.nt.troop.api.ITroopApi
    public boolean isFromThirdApp(Bundle bundle) {
        return bundle.getBoolean("fromThirdAppByOpenSDK");
    }
}
