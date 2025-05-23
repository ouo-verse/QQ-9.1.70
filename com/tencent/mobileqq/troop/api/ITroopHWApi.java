package com.tencent.mobileqq.troop.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes19.dex */
public interface ITroopHWApi extends QRouteApi {
    public static final String ACTION_START_VIDEO_CHAT = "tencent.av.v2q.StartVideoChat";

    void browserNoticeFile(Activity activity, String str, String str2, String str3, int i3, long j3);

    int getBknBySkey(String str);

    String getFileSuffix(String str);

    Intent getSelectMediaIntent(int i3, Activity activity, String str);

    void goSelectMedia(Activity activity, Object obj, Object obj2, Intent intent, byte b16);

    void gotoSelectPicture(Activity activity, Object obj, Object obj2, int i3, byte b16);

    void initBossForMediaItem();

    boolean isAbsBaseWebViewActivity(Activity activity);

    void notifyTroopBannerHWBizOpened(@NotNull String str, @NotNull String str2);

    void showOnePicture(Activity activity, String str);

    void start_BulkSendMessageFragment(Activity activity, Bundle bundle);
}
