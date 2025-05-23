package com.tencent.mobileqq.gamecenter.api;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;

@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGameCenterRedPointConfigApi extends QRouteApi {
    public static final String GAME_CENTER_RES_ID = "489";
    public static final String MMKV_KEY_SPECIAL_SHOW_COUNT = "mmkv_key_special_show_cnt";
    public static final String MMKV_KEY_SPECIAL_SHOW_RED_ID = "mmkv_key_special_show_red_id";
    public static final int MODEL_NORMAL = 0;
    public static final int MODEL_SIMPLE = 2;
    public static final int MODEL_STUDY = 1;

    void addSepcialRedPointShowCnt();

    boolean jumpGameCenterByRedPoint(Context context, boolean z16);

    void onDestory();

    void onItemClick(long j3);

    void reportClickForCommonVersion(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, int i3);

    void reportExposureForCommonVersion(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, int i3);

    void reportGameDynamicClick(BusinessInfoCheckUpdate.AppInfo appInfo, String str, boolean z16);

    void reportRedTouchArrived();

    void setBannerContainer(int i3, ViewGroup viewGroup);

    void setGameViewContainer(c cVar);

    void showOrHideBanner(String str, boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo);
}
