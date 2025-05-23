package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@PluginInterface
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopCreateInfoService extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void onCreateTroopCompletely(int i3, String str, String str2);

        void onInviteComplete(int i3, String str);

        void onReusedTroop(String str);
    }

    void clearTroopCreateInfo();

    void deleteInInviteList(String str, String str2);

    TroopCreateInfo getTroopCreateInfo();

    boolean isInInviteList(String str, String str2);

    void refreshCreateInfo(String str, int i3);
}
