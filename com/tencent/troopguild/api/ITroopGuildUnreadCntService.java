package com.tencent.troopguild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observer;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uo4.f;

/* compiled from: P */
@Service(process = {""})
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072 \u0010\u0006\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004\u0018\u00010\u0002H&J \u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\tH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildUnreadCntService;", "Lmqq/app/api/IRuntimeService;", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadCntInfos", "", "onUnreadCntUpdate", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildGroupSceneType;", "sceneType", "", "isDelete", "setTroopGuildMsgRead", "cleanTroopGuildUnreadHighLight", "fetchUnreadCntInfo", "Ljava/util/Observer;", "observer", "addUnreadCntInfoObserver", "deleteUnreadCntInfoObserver", "Luo4/f;", "getUnreadCntInfo", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface ITroopGuildUnreadCntService extends IRuntimeService {
    void addUnreadCntInfoObserver(@NotNull Observer observer);

    void cleanTroopGuildUnreadHighLight(@NotNull String troopUin);

    void deleteUnreadCntInfoObserver(@NotNull Observer observer);

    void fetchUnreadCntInfo(@NotNull String troopUin);

    @NotNull
    f getUnreadCntInfo(@NotNull String troopUin);

    void onUnreadCntUpdate(@Nullable HashMap<Integer, ArrayList<UnreadCntInfo>> unreadCntInfos);

    void setTroopGuildMsgRead(@NotNull String troopUin, @NotNull GuildGroupSceneType sceneType, boolean isDelete);
}
