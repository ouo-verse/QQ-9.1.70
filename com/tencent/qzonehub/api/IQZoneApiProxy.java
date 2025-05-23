package com.tencent.qzonehub.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneApiProxy extends QRouteApi {
    Fragment createLebaFragment(@NonNull Activity activity, @NonNull AppRuntime appRuntime, @NonNull String str);

    boolean disableBssid();

    boolean enableShowRecommend();

    void fetchAndReportTeenageFeedModeExp();

    void fetchAndSaveLocalPhotoRecommendTabExperimentValue();

    String generatePublishId();

    String getExpContentInSimpleUI();

    String getExpContentInSimpleUI(AppRuntime appRuntime);

    String getExpPostBtnMode();

    String getExpPostBtnMode(@NonNull AppRuntime appRuntime);

    String getFirstVideoFeedCoverPath();

    AppRuntime getLastRuntime();

    boolean getLocalPhotoScanAuthorizeSwitch();

    String getPublishId();

    String getPublisherGamePlayReportStr(ArrayList<HashMap<String, Object>> arrayList);

    int getQZoneUnReadCount(int i3);

    boolean initEnv(@NonNull Context context, @NonNull AppRuntime appRuntime);

    boolean initServlet(@NonNull Context context, @NonNull AppRuntime appRuntime);

    boolean isInQZoneEnvironment();

    boolean isQZonePluginInit();

    boolean isShowQZoneFrameForTeenage();

    boolean isSimpleUiLebaProfileJumpExpGroup();

    void launchLocalPhotoRecommendStandalonePage(Context context, Bundle bundle);

    void launchQZoneUploadPhotoPage(Activity activity, ArrayList<LocalMediaInfo> arrayList, String str, int i3, Bundle bundle, int i16);

    boolean needShowAioFeedList(@Nullable Activity activity, @Nullable AppRuntime appRuntime);

    boolean needShowMsgFeedList(@Nullable Activity activity, @Nullable AppRuntime appRuntime);

    boolean needShowQzoneFrame(@Nullable Context context, @Nullable AppRuntime appRuntime);

    boolean needShowSubFeedList(@Nullable Activity activity, @Nullable AppRuntime appRuntime);

    void onAccountChange(@NonNull Context context, @NonNull AppRuntime appRuntime);

    void parseAddGamePlayRecordData(Intent intent, ArrayList<HashMap<String, Object>> arrayList);

    void reportDownloadResult(String str, boolean z16, HashMap<String, String> hashMap, long j3, String str2);

    void reportNTUploadFileResult(int i3, String str, long j3, long j16, int i16, String str2);

    void reportNTUploadMissionResult(int i3, String str, String str2, int i16, int i17);

    void requestAddFriendShowQZoneFeeds(long j3, BusinessObserver businessObserver);

    void setQzonePageDaTongParams(Activity activity, View view);
}
