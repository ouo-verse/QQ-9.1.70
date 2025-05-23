package com.tencent.mobileqq.zplan.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanFriendApi extends QRouteApi {
    void notifyNewFriendDialogClose(JSONObject jSONObject);

    void notifyUnreadCount();

    void openNativeForwardRecentPage(Context context, Intent intent, String str, boolean z16, int i3);

    void openNativeForwardRecentPage(Context context, Intent intent, String str, boolean z16, int i3, boolean z17);

    boolean shouldShowDoubleZanPopWindow(@NonNull AppInterface appInterface);

    void showDoubleZanDialog(@NonNull Activity activity, @NonNull View.OnClickListener onClickListener, @NonNull View.OnClickListener onClickListener2);

    void showRefuseAddFriendDialog(Activity activity);
}
