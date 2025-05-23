package com.tencent.qqnt.troop;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005H&J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u001b\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J&\u0010 \u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J&\u0010!\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J\u001c\u0010\"\u001a\u00020\u00112\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/troop/ITroopGagUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "troopUin", "getTroopOwnerReportStr", "", "isFirst", "Lcom/tencent/mobileqq/troop/troopgag/data/d;", "getSelfGagInfo", "Lcom/tencent/mobileqq/troop/troopgag/data/e;", "getTroopGagInfo", "", "gagTime", "transformGagTimeForSettingUI", "isMySelfSilent", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", "onPushTroopGagMsg", "onPushMeGagMsg", "onPushOtherMemberGagMsg", "", "resId", "bSucceed", "showTipsToast", "isAdmin", "isOwner", "clearMySelfGagInfo", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Lfs2/a;", "callback", "fetchGagListWithMemberInfoFromNet", "fetchGagListFromDB", "fetchGagListFromNet", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface ITroopGagUtils extends QRouteApi {
    void clearMySelfGagInfo(@Nullable String troopUin);

    void fetchGagListFromDB(@Nullable String troopUin, @Nullable LifecycleOwner owner, @Nullable fs2.a callback);

    void fetchGagListFromNet(@Nullable String troopUin, @Nullable LifecycleOwner owner);

    void fetchGagListWithMemberInfoFromNet(@Nullable String troopUin, @Nullable LifecycleOwner owner, @Nullable fs2.a callback);

    @NotNull
    com.tencent.mobileqq.troop.troopgag.data.d getSelfGagInfo(@Nullable String troopUin, boolean isFirst);

    @NotNull
    com.tencent.mobileqq.troop.troopgag.data.e getTroopGagInfo(@Nullable String troopUin);

    @NotNull
    String getTroopOwnerReportStr(@Nullable String troopUin);

    boolean isAdmin(@Nullable String troopUin);

    boolean isMySelfSilent(@Nullable String troopUin);

    boolean isOwner(@Nullable String troopUin);

    void onPushMeGagMsg(@NotNull TroopInfo troopInfo);

    void onPushOtherMemberGagMsg(@NotNull String troopUin);

    void onPushTroopGagMsg(@NotNull TroopInfo troopInfo);

    void showTipsToast(int resId, boolean bSucceed);

    @NotNull
    String transformGagTimeForSettingUI(long gagTime);
}
