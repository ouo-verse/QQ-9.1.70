package com.tencent.mobileqq.guild.temp.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J!\u0010\f\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&\u00a2\u0006\u0002\u0010\u000fJ\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/ITroopGuildAIOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getJumpToTroopGuildIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "troopUin", "", "bundle", "Landroid/os/Bundle;", "jumpToTroopFeedList", "", "onHandlePassiveExitTroop", QQBrowserActivity.KEY_MSG_TYPE, "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "updateFeedPopUp", "show", "", "helper", "", "qqguild-df-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes14.dex */
public interface ITroopGuildAIOApi extends QRouteApi {
    @NotNull
    Intent getJumpToTroopGuildIntent(@NotNull Context context, @NotNull String troopUin, @NotNull Bundle bundle);

    void jumpToTroopFeedList(@NotNull Context context, @NotNull String troopUin);

    void onHandlePassiveExitTroop(@Nullable String troopUin, @Nullable Integer msgType);

    void updateFeedPopUp(boolean show, @Nullable Object helper);
}
