package com.tencent.qqnt.inner;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010\u000b\u001a\u00020\nH&J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\fH&J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u000eH&J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0005H&J\b\u0010\u0015\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0018\u001a\u00020\u0017H&\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/inner/ITroopInfoInnerService;", "Lmqq/app/api/IRuntimeService;", "", "initAfterNTCreated", "", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "getCache", "", "", "getCacheMap", "", "isCacheInited", "Lfx3/a;", "getTroopListLiveData", "", IProfileProtocolConst.PARAM_TROOP_CODE, "getTroopUinByTroopCode", "troopUin", "onJceExitTroop", "troopInfo", "onDetailInfoUpdate", "onLoadTroopExtInfoFinish", "isCacheAllInited", "Lcom/tencent/qqnt/troop/f;", "getDispatcher", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface ITroopInfoInnerService extends IRuntimeService {
    @NotNull
    List<TroopInfo> getCache();

    @NotNull
    Map<Long, TroopInfo> getCacheMap();

    @NotNull
    com.tencent.qqnt.troop.f getDispatcher();

    @NotNull
    fx3.a<List<TroopInfo>> getTroopListLiveData();

    @NotNull
    String getTroopUinByTroopCode(@NotNull String troopCode);

    void initAfterNTCreated();

    boolean isCacheAllInited();

    boolean isCacheInited();

    void onDetailInfoUpdate(@NotNull TroopInfo troopInfo);

    void onJceExitTroop(@NotNull String troopUin);

    void onLoadTroopExtInfoFinish();
}
