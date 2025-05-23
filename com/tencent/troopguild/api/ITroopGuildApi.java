package com.tencent.troopguild.api;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uo4.a;
import uo4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002H&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0002H&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&J&\u0010\u0016\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0002H&J,\u0010\u001e\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0002H&J$\u0010\u001f\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u0002H&J\u0010\u0010!\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020 H&\u00a8\u0006$"}, d2 = {"Lcom/tencent/troopguild/api/ITroopGuildApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "", "isTroopGuild", "isTroopGuildSwitchOpen", "Landroid/content/Context;", "context", "Luo4/b;", "createGuildContainer", "getTroopGuildId", "guildId", "getTroopFeedChannelId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "getTroopFeedChannelInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "getTroopName", "Luo4/a;", "cb", "", "getGuildGroupTransData", "", "optType", "getHighLightStringByOptType", "getTroopGuildRole", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", WadlProxyConsts.KEY_JUMP_URL, "doBubbleOpJumpAction", "doGrayTipJumpFeedAction", "Landroid/view/View;", "getLoadingView", "view", "getLoadingAnimView", "troop-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes7.dex */
public interface ITroopGuildApi extends QRouteApi {
    @Nullable
    b createGuildContainer(@NotNull Context context);

    void doBubbleOpJumpAction(@Nullable BaseQQAppInterface app, @Nullable Context context, @NotNull String troopUin, @NotNull String jumpUrl);

    void doGrayTipJumpFeedAction(@Nullable BaseQQAppInterface app, @Nullable Context context, @NotNull String jumpUrl);

    void getGuildGroupTransData(@Nullable String troopUin, @Nullable String guildId, @Nullable a cb5);

    @NotNull
    String getHighLightStringByOptType(@NotNull Context context, int optType);

    @Nullable
    View getLoadingAnimView(@NotNull View view);

    @NotNull
    View getLoadingView(@NotNull Context context);

    @Nullable
    String getTroopFeedChannelId(@NotNull String guildId);

    @Nullable
    IGProChannelInfo getTroopFeedChannelInfo(@NotNull String guildId);

    @NotNull
    String getTroopGuildId(@NotNull String troopUin);

    int getTroopGuildRole(@NotNull String troopUin);

    @NotNull
    String getTroopName(@NotNull String troopUin);

    boolean isTroopGuild(@Nullable TroopInfo troopInfo);

    boolean isTroopGuild(@Nullable String troopUin);

    boolean isTroopGuildSwitchOpen(@Nullable String troopUin);
}
