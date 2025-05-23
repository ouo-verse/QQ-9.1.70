package com.tencent.mobileqq.onlinestatus.api;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.DiyStatusEmoInfo;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.bw;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.model.d;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.onlinestatus.z;
import com.tencent.mobileqq.qroute.annotation.Service;
import h43.f;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes16.dex */
public interface IOnlineStatusService extends IRuntimeService {
    public static final String CMD_RECV_MUSIC_STATUS_PUSH = "ImStatus.ReqPushStatus";
    public static final String CMD_SET_ONLINE_STATUS = "StatSvc.SetStatusFromClient";
    public static final String CMD_SET_PUSH_TOKEN = "PushService.SetToken";
    public static final String DURATION = "duration";
    public static final String EXT_INFO = "extInfo";
    public static final String KEY_CUSTOM_SHARE_INFO = "key_custom_share_info";
    public static final String PARAMS_FROM_TYPE = "from_type";
    public static final String PARAMS_VENDOR_PUSH_TYPE = "vendor_push_type";
    public static final String PAUSE_FLAG = "pauseFlag";
    public static final int QQMUSIC_STATUS = 2;
    public static final String REMAIN_TIME = "remainTime";
    public static final String SET_AVATAR = "setStatusHasAvatar";
    public static final String SONG_ID = "songId";
    public static final String SONG_TYPE = "songType";
    public static final int SYNC_ONLINE_STATUS_MINI_APP = 2;
    public static final int SYNC_ONLINE_STATUS_QQ_MUSIC_THIRD_PARTY = 3;
    public static final int SYNC_ONLINE_STATUS_TENCENT_VIDEO_THIRD_PARTY = 1;
    public static final String SYNC_TYPE = "syncType";
    public static final int TENCENTVIDEO_STATUS = 1;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface AIOStatusPopupDialogListener {
        void onDismiss();

        void onShow();
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface From {
        public static final int AUTO_SET = 2;
        public static final int DEFAULT = 0;
        public static final int STUDY_MODE = 3;
        public static final int ZPLAN = 1;
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface OnlineStatusZplanPanelListener {
        void onZplanPanelCallback(int i3);
    }

    void checkAndSetConversationGuide(TextView textView, TextView textView2);

    void checkBatteryStatus();

    boolean dismissAIOStatusPopupDialog();

    int getBatteryCapacity();

    DiyStatusEmoInfo getDiyInfo();

    long getExtOnlineStatus();

    long getExtOnlineStatusFromSP();

    long getExtOnlineStatusFromSP(String str);

    void getOlympicMedalEventReq(boolean z16, boolean z17);

    AppRuntime.Status getOnlineStatus();

    AppRuntime.Status getOnlineStatusFromSP();

    AppRuntime.Status getOnlineStatusFromSP(String str);

    int getPowerConnect();

    SharedPreferences getSharedPreference();

    @Nullable
    f getStepStatusInfo();

    boolean isAIODialogNotShowing();

    y newAccountPanel(QBaseActivity qBaseActivity);

    y newAccountPanel(QBaseActivity qBaseActivity, int i3);

    z newPresenter(QBaseActivity qBaseActivity, bw bwVar);

    void onAIODialogResult(int i3, int i16, Intent intent);

    void onClickConversationGuide(AppRuntime appRuntime, TextView textView, TextView textView2);

    void onZplanPanelCallback(int i3);

    void registerBatteryBroadcastReceiver();

    void registerObserver();

    void requestSetPushToken(AppRuntime appRuntime, String str, String str2);

    void sendOnlineStatus(AppRuntime.Status status, boolean z16, long j3, boolean z17);

    void sendOnlineStatusWithExt(AppRuntime.Status status, boolean z16, long j3, boolean z17, long j16);

    void setAIOStatusPopupDialogListener(AIOStatusPopupDialogListener aIOStatusPopupDialogListener);

    void setBatteryCapacity(int i3);

    void setDiyInfo(DiyStatusEmoInfo diyStatusEmoInfo);

    void setExtOnlineStatus(long j3);

    void setOnlineStatus(AppRuntime.Status status, String str);

    void setOnlineStatusZplanPanelListener(OnlineStatusZplanPanelListener onlineStatusZplanPanelListener);

    void setPowerConnect(int i3);

    void setStepStatusInfo(@NonNull f fVar);

    void showAIOStatusPopupDialog(d dVar, Activity activity, int i3, boolean z16);

    void syncBusinessInfo(int i3, Bundle bundle);

    void unRegisterBatteryBroadcastReceiver();

    void updateDiyOnlineStatus(AppRuntime.Status status, long j3, DiyStatusEmoInfo diyStatusEmoInfo);

    void updateOnlineStatus(AppRuntime.Status status, long j3);

    void updateOnlineStatus(AppRuntime.Status status, long j3, int i3);

    void updateOnlineStatus(AppRuntime.Status status, long j3, boolean z16);

    void updateOnlineStatus(AppRuntime.Status status, long j3, boolean z16, int i3);

    void updateOnlineStatusUsingShareInfo(CustomShareInfo customShareInfo);

    void updateOnlineStatusUsingShareInfo(CustomShareInfo customShareInfo, DiyStatusEmoInfo diyStatusEmoInfo, boolean z16, int i3);
}
