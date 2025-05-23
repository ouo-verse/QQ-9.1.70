package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.troopapps.FullListGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.GrayGroupAppsDbHelper;
import com.tencent.mobileqq.troop.troopapps.data.GrayGroupAppEntity;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {""})
/* loaded from: classes19.dex */
public interface ITroopAioAppService extends IRuntimeService {
    void clearRedDotInCacheAndDb(int i3);

    FullListGroupAppsDbHelper fullListGroupAppsDbHelper();

    List<TroopAIOAppInfo> getAllAppsFromCache();

    List<TroopAIOAppInfo> getAppsFromCache(long j3);

    void getAppsInObserver(long j3);

    String getFullAppListHash();

    List<TroopAIOAppInfo> getFullAppsListInfos();

    ConcurrentHashMap<Long, GrayGroupAppEntity> getGrayAppInfoMap();

    String getGrayAppsHash(long j3);

    long getRequestIntervalSecond(long j3);

    GrayGroupAppsDbHelper grayGroupAppsDbHelper();

    void initAioAppsCache();

    void requestClearRedDot(int i3);

    void saveFullAppListHashInSp();

    void setFullAppListHash(String str);

    void setFullAppsListInfos(List<TroopAIOAppInfo> list);
}
