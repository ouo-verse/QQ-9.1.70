package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.troopapps.data.PlusPanelAppsInfo;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process = {"all"})
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\rJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/ITroopPlusAppService;", "Lmqq/app/api/IRuntimeService;", "", "isMoreListSwitchOn", "", "troopUin", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "getAppsFromCache", "Lcom/tencent/mobileqq/troop/troopapps/api/ITroopPlusAppService$a;", "callback", "", "getAppsAsync", "initPlusAppsCache", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface ITroopPlusAppService extends IRuntimeService {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopapps/api/ITroopPlusAppService$a;", "", "", "errCode", "", "errMsg", "Lcom/tencent/mobileqq/troop/troopapps/data/PlusPanelAppsInfo;", "apps", "", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface a {
        void a(int errCode, @NotNull String errMsg, @NotNull PlusPanelAppsInfo apps);
    }

    void getAppsAsync(long troopUin, @NotNull a callback);

    @NotNull
    PlusPanelAppsInfo getAppsFromCache(long troopUin);

    void initPlusAppsCache(long troopUin);

    boolean isMoreListSwitchOn();
}
