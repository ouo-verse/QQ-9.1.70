package com.tencent.qqnt;

import android.app.Activity;
import android.app.Dialog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\rH&J&\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\rH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/ITroopMemberCardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "checkAndUpdateTroopInfo", "", "troopInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "allInOne", "Lcom/tencent/mobileqq/profilecard/data/AllInOne;", "createTroopMoreLoadingDialog", "Landroid/app/Dialog;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "getGroupName", "", "categoryId", "", "isGatherFriend", "", "cardInfo", "Lcom/tencent/mobileqq/profilecard/data/ProfileCardInfo;", "isQiDianPrivateTroop", "troopUin", "requestTroopMemberInfo", "app", "Lcom/tencent/common/app/AppInterface;", "from", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface ITroopMemberCardApi extends QRouteApi {
    void checkAndUpdateTroopInfo(@Nullable TroopInfo troopInfo, @Nullable AllInOne allInOne);

    @NotNull
    Dialog createTroopMoreLoadingDialog(@NotNull Activity activity);

    @Nullable
    String getGroupName(int categoryId);

    boolean isGatherFriend(@Nullable ProfileCardInfo cardInfo);

    boolean isQiDianPrivateTroop(@Nullable String troopUin);

    void requestTroopMemberInfo(@Nullable AppInterface app, @Nullable ProfileCardInfo cardInfo, @Nullable String from);
}
