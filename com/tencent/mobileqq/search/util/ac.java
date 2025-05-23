package com.tencent.mobileqq.search.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.addcontact.api.IAddContactRemoteConfig;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.guild.api.ISwitchConfigFactoryApi;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ac {

    /* renamed from: a, reason: collision with root package name */
    private static final ax3.a f284989a = ((ISwitchConfigFactoryApi) QRoute.api(ISwitchConfigFactoryApi.class)).create("exp_searchuser_history_search", "102034");

    public static boolean a() {
        if (!((IAddContactRemoteConfig) QRoute.api(IAddContactRemoteConfig.class)).showNewPage() && !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101096", false)) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return !TextUtils.equals(f284989a.getF356919a(), "0");
    }
}
