package com.tencent.mobileqq.troopmanage.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troopmanage.base.TroopManageRemoteHandler;
import com.tencent.mobileqq.troopmanage.base.TroopManagerHandler;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopManageService extends IRuntimeService {
    EntityManagerFactory getQQEntityManagerFactory();

    @NonNull
    TroopInfo getTroopInfo(String str);

    @NonNull
    TroopManagerHandler getTroopManageHandler();

    TroopManageRemoteHandler getTroopManageRemoteHandler();

    void reportClickEvent(String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9);
}
