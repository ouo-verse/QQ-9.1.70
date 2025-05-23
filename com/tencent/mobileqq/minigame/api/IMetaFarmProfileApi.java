package com.tencent.mobileqq.minigame.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/minigame/api/IMetaFarmProfileApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearGuideFlag", "", "isMetaFarmUser", "", "openStatusListFragment", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "", "currentStatusId", "setSelfMetaFarmUid", "uid", "", "showGuideFragment", "qqmini-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMetaFarmProfileApi extends QRouteApi {
    void clearGuideFlag();

    boolean isMetaFarmUser();

    void openStatusListFragment(@NotNull Activity activity, int requestCode, int currentStatusId);

    void setSelfMetaFarmUid(long uid);

    void showGuideFragment(@NotNull Activity activity);
}
