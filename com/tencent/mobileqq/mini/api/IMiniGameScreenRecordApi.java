package com.tencent.mobileqq.mini.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IMiniGameScreenRecordApi extends QRouteApi {
    boolean isEverShowScreenRecord();

    void jump2QCircleVideoEditionPage(String str, String str2, Activity activity);

    void openQCirclePublishPage(String str, String str2, Activity activity);

    void saveRecordVideo(String str, String str2, String str3, String str4, Activity activity);

    void share2QZone(String str, boolean z16, Activity activity, String str2, int i3);

    void shareRecordVideo2Friend(String str, String str2, Activity activity);

    void shareRecordVideo2TargetFriend(String str, String str2, Activity activity, String str3, int i3);

    void showDeleteVideoConfirmDialog(String str, String str2, IConfirmDeleteCallback iConfirmDeleteCallback, Activity activity);
}
