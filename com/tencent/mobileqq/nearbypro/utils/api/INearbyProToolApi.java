package com.tencent.mobileqq.nearbypro.utils.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0003H&J(\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/utils/api/INearbyProToolApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getLocationMode", "", "context", "Landroid/content/Context;", "getNotificationIntent", "Landroid/content/Intent;", "peerUid", "", "launchLocationSelectPage", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "requestCode", "updateCustomNoteText", "textView", "Landroid/widget/TextView;", WidgetCacheConstellationData.NUM, "resId", "maxNum", "qq_nearby_pro_df_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface INearbyProToolApi extends QRouteApi {
    int getLocationMode(@NotNull Context context);

    @NotNull
    Intent getNotificationIntent(@NotNull Context context, @NotNull String peerUid);

    void launchLocationSelectPage(@Nullable Activity activity, int requestCode);

    void updateCustomNoteText(@NotNull TextView textView, int num, int resId, int maxNum);
}
