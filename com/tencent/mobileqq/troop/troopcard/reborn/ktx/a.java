package com.tencent.mobileqq.troop.troopcard.reborn.ktx;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.troop.data.v;
import com.tencent.mobileqq.troop.data.w;
import com.tencent.mobileqq.troop.troopshare.tempapi.ITroopShareUtility;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\"\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/troopshare/tempapi/ITroopShareUtility;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/data/v;", "troopInfoWrapper", "", "a", "Lcom/tencent/common/app/AppInterface;", "appInterface", "b", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a {
    public static final void a(@NotNull ITroopShareUtility iTroopShareUtility, @NotNull Activity activity, @NotNull v troopInfoWrapper) {
        Intrinsics.checkNotNullParameter(iTroopShareUtility, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(troopInfoWrapper, "troopInfoWrapper");
        iTroopShareUtility.onDestroy();
        iTroopShareUtility.newTroopShareUtility(activity, w.d(troopInfoWrapper));
        iTroopShareUtility.startTroop2DCode();
    }

    public static final void b(@NotNull ITroopShareUtility iTroopShareUtility, @NotNull Activity activity, @NotNull AppInterface appInterface, @NotNull v troopInfoWrapper) {
        Intrinsics.checkNotNullParameter(iTroopShareUtility, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(appInterface, "appInterface");
        Intrinsics.checkNotNullParameter(troopInfoWrapper, "troopInfoWrapper");
        iTroopShareUtility.onDestroy();
        iTroopShareUtility.troopUtils_shareTroop(activity, w.d(v.b(troopInfoWrapper, null, false, null, 0, 0, "pg_group_apply_profile", 0, 0, null, NotificationUtil.Constants.NOTIFY_ID_MSF_PUSH_AVMSG, null)), appInterface);
    }
}
