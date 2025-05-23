package com.tencent.troopguild.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import uo4.e;

@Service(process = {""})
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J;\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH&JC\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tH&J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H&J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H&\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildPermissionService;", "Lmqq/app/api/IRuntimeService;", "", "guildId", "", "forceRefresh", "", "getTroopFeedTalkPermission", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "callback", "setTroopFeedTalkPermission", "troopUin", "switchOpen", "setTroopFeedSwitch", "isMute", "", "getMuteSelfTime", "getMuteAllTime", "onMuteStateChanged", "isAdmin", "Luo4/e;", "observer", "addObserver", "removeObserver", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public interface ITroopGuildPermissionService extends IRuntimeService {
    void addObserver(@NotNull e observer);

    long getMuteAllTime(@NotNull String troopUin);

    long getMuteSelfTime(@NotNull String troopUin);

    int getTroopFeedTalkPermission(@NotNull String guildId, boolean forceRefresh);

    boolean isAdmin(@NotNull String troopUin);

    boolean isMute(@NotNull String troopUin);

    void onMuteStateChanged(@NotNull String troopUin);

    void removeObserver(@NotNull e observer);

    void setTroopFeedSwitch(@NotNull String guildId, @NotNull String troopUin, boolean switchOpen, @NotNull Function1<? super Boolean, Unit> callback);

    void setTroopFeedTalkPermission(@NotNull String guildId, int permission, @NotNull Function1<? super Boolean, Unit> callback);
}
