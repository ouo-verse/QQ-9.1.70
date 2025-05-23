package com.tencent.mobileqq.troop.selectmember.api;

import android.app.Activity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/api/ITroopSelectMemberApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createSelectTroopMemberFragment", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "launchSelectTroopMemberFragment", "", "launchSelectTroopMemberFragmentForResult", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopSelectMemberApi extends QRouteApi {
    @Nullable
    QPublicBaseFragment createSelectTroopMemberFragment(@NotNull TroopSelectMemberConfig config);

    void launchSelectTroopMemberFragment(@NotNull TroopSelectMemberConfig config);

    void launchSelectTroopMemberFragmentForResult(@NotNull TroopSelectMemberConfig config, @NotNull Activity activity, int requestCode);
}
