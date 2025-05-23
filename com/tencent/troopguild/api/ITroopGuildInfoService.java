package com.tencent.troopguild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.v;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\bH&J(\u0010\u0013\u001a\u00020\b2\u001e\u0010\u0012\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f0\u000eH&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0016\u001a\u00020\bH&J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildInfoService;", "Lmqq/app/api/IRuntimeService;", "", "guildId", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lvh2/v;", "cb", "", "fetchGuildInfo", "isTroopGuildSwitchOpen", "onTroopGuildAioEntered", "onTroopGuildAioExisted", "onReconnect", "Ljava/util/HashMap;", "Lkotlin/Pair;", "", "", "troopGuildIds", "handleRegisterProxyGuildId", "troopUin", "verifyTroopInfoGuildId", "onGetTroopList", "getCurrentAioTroopGuildSwitch", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface ITroopGuildInfoService extends IRuntimeService {
    void fetchGuildInfo(@NotNull String guildId, boolean force, @NotNull v cb5);

    boolean getCurrentAioTroopGuildSwitch(@NotNull String troopUin);

    void handleRegisterProxyGuildId(@NotNull HashMap<String, Pair<Long, Integer>> troopGuildIds);

    void onGetTroopList();

    void onReconnect();

    void onTroopGuildAioEntered(@NotNull String guildId, boolean isTroopGuildSwitchOpen);

    void onTroopGuildAioExisted();

    void verifyTroopInfoGuildId(@NotNull String troopUin, @NotNull String guildId);
}
