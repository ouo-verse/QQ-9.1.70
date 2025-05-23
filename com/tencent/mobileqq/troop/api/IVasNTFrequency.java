package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/api/IVasNTFrequency;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "refreshRecentColorNameFrequency", "", "requestTroopColorNameFrequency", "friendUin", "", "troopColorNameId", "", "troopUin", "IMCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface IVasNTFrequency extends QRouteApi {
    void refreshRecentColorNameFrequency();

    void requestTroopColorNameFrequency(@NotNull String friendUin, int troopColorNameId, @NotNull String troopUin);
}
