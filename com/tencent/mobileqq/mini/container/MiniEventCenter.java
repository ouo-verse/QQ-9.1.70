package com.tencent.mobileqq.mini.container;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniEventCenter extends GPServiceObserver {
    private static final String TAG = "Mini-EventCenter";

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onAddGuildWithInfo(IGProGuildInfo iGProGuildInfo, int i3) {
        String guildID = iGProGuildInfo.getGuildID();
        if (TextUtils.isEmpty(guildID)) {
            return;
        }
        QLog.i(TAG, 1, "onGuildAdded, guildID: " + guildID);
        HashMap hashMap = new HashMap();
        hashMap.put("guildID", guildID);
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).dispatchNativeEvent("onGuildAdded", hashMap);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
    public void onRemoveGuild(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.i(TAG, 1, "onGuildRemoved, guildID: " + str);
        HashMap hashMap = new HashMap();
        hashMap.put("guildID", str);
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).dispatchNativeEvent("onGuildRemoved", hashMap);
    }

    public void initialize() {
        QLog.i(TAG, 1, "initialize");
        AppInterface appInterface = MiniAppUtils.getAppInterface();
        if (appInterface != null) {
            IGProGlobalService iGProGlobalService = (IGProGlobalService) appInterface.getRuntimeService(IGProGlobalService.class, "");
            iGProGlobalService.deleteObserver(this);
            iGProGlobalService.addObserver(this);
        }
    }
}
