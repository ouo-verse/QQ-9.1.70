package com.tencent.mobileqq.pluspanel;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/pluspanel/ITroopPanelAppLoaderUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkIfNeedHideApp", "", "curId", "", "troopAppInfo", "Lcom/tencent/mobileqq/troop/data/TroopAIOAppInfo;", "fillAppListIfNeed", "", "list", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ITroopPanelAppLoaderUtils extends QRouteApi {
    boolean checkIfNeedHideApp(@NotNull String curId, @NotNull TroopAIOAppInfo troopAppInfo);

    void fillAppListIfNeed(@NotNull String curId, @NotNull ArrayList<Integer> list);
}
