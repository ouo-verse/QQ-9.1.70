package com.tencent.mobileqq.troop.roamsetting.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.roamsetting.a;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface IRoamSettingService extends IRuntimeService {
    ConcurrentHashMap<String, Boolean> getMapRequest();

    ConcurrentHashMap<String, Integer> getMapUploading();

    a getReqGetSettingsHandler();

    int getSettingValue(String str, int i3);

    void loadAllRoamSettings(boolean z16);

    void setRoamSettingNewValue(String str, Integer num);
}
