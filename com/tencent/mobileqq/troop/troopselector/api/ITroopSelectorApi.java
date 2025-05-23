package com.tencent.mobileqq.troop.troopselector.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.troopselector.TroopSelectorConfig;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopselector/api/ITroopSelectorApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "openNewTroopSelector", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "troopSelectorConfig", "Lcom/tencent/mobileqq/troop/troopselector/TroopSelectorConfig;", "requestCode", "", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopSelectorApi extends QRouteApi {
    void openNewTroopSelector(@NotNull Context context, @NotNull Intent intent, @NotNull TroopSelectorConfig troopSelectorConfig, int requestCode);
}
