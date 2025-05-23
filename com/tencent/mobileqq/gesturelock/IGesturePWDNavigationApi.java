package com.tencent.mobileqq.gesturelock;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/gesturelock/IGesturePWDNavigationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "onCreated", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onDestroyed", "onResume", DKHippyEvent.EVENT_STOP, "QQCommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGesturePWDNavigationApi extends QRouteApi {
    void onCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState);

    void onDestroyed(@NotNull Activity activity);

    void onResume(@NotNull Activity activity);

    void onStop(@NotNull Activity activity);
}
