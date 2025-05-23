package com.tencent.mobileqq.troop.troopgame.api;

import android.app.Dialog;
import android.content.Context;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J \u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/troopgame/api/ITroopGameApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/main/businesshelper/h;", "createHelper", "", "troopUin", "", "isJoin", "isPassive", "", "handleJoinOrExitTroop", "Landroid/content/Context;", "context", "Landroid/app/Dialog;", "showTroopGameCardTipsIfNeeded", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "enableShowGameCard", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopGameApi extends QRouteApi {
    @NotNull
    h createHelper();

    boolean enableShowGameCard(@Nullable TroopInfo troopInfo);

    void handleJoinOrExitTroop(@NotNull String troopUin, boolean isJoin, boolean isPassive);

    @Nullable
    Dialog showTroopGameCardTipsIfNeeded(@NotNull Context context);
}
