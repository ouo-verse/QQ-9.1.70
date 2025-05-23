package com.tencent.biz.pubaccount.api;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QRouteFactory(singleton = false)
@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountHandler extends QRouteApi {
    public static final String CMD_PUBLICACCOUNT_SVC_SEND_LBS = "PubAccountSvc.ReportLbs";
    public static final int GET_FOLLOW_LIST_FROM_ASYNC_STEP = 1;
    public static final int GET_FOLLOW_LIST_FROM_DEFAULT = 0;
    public static final String KEY_AIO_TIME = "aio_time";
    public static final String KEY_LIST_TIME = "list_time";
    public static final String KEY_LOCATION_TIME = "location_time";
    public static final String KEY_LOC_LAT = "loc_lat";
    public static final String KEY_LOC_LNG = "loc_lng";
    public static final String MAIN_ACTION = "Pb_account_lifeservice";
    public static final int WEATHER_TYPE_AD = 1;
    public static final int WEATHER_TYPE_CHECK = 2;
    public static final int WEATHER_TYPE_OFFLINE = -1;
    public static final int WEATHER_TYPE_SWITCH = 4;
    public static final int WEATHER_TYPE_UNKOWN = 0;

    /* loaded from: classes4.dex */
    public interface a {
        void onComplete(String str);
    }

    void clearPublicAccountSeq();

    void clearWeatherInfoListener();

    void getAIOHistoryMsg(String str, long j3, int i3);

    int getRecommendList(Object obj);

    int getUserFollowList();

    void getWeatherInfo(Context context, int i3, a aVar);

    boolean hasStepRequestFollowList();

    boolean isNeedUpdate();

    Object newPublicAccountCheckUpdateItem();

    void notifyUI(int i3, boolean z16, Object obj);

    void onFollowPublicAccount(Object obj);

    void onReceivePushMessage(long j3, byte[] bArr);

    void onUnfollowPublicAccount(Object obj);

    void reportClickPublicAccountEvent(AppInterface appInterface, String str, String str2, String str3, String str4);

    void reportClickPublicAccountEvent(AppInterface appInterface, String str, String str2, String str3, String str4, int i3);

    void sendLBSInfo(String str, double d16, double d17, String str2);

    void sendLocRequest(int i3, int i16, int i17, int i18);

    void setLocalIp(String str);

    void setNotNeedUpdate();
}
