package com.tencent.mobileqq.qqlive.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqlive.api.end.IQQLiveEndView;
import com.tencent.mobileqq.qqlive.api.room.StartRoomConfig;
import com.tencent.mobileqq.qqlive.callback.EndLiveClickCallback;
import com.tencent.mobileqq.qqlive.data.QQLiveEndPageInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.superplayer.api.ISuperPlayer;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQLiveUtil extends QRouteApi {
    public static final String ACTIVITY_ID = "activity_id";
    public static final String COVER_INFO_KEY = "COVER_INFO_KEY";
    public static final String LIVE_TRACEID = "live_traceid";
    public static final String PARAM_KEY_ENTRANCE_SOURCE = "source";
    public static final String SOURCE_CHANNEL = "2";
    public static final String SOURCE_GAME = "1";
    public static final String SOURCE_HOMEPAGE = "0";
    public static final String SOURCE_XSJ = "3";
    public static final String UPLOAD_ERROR_CODE = "upload_error_code";
    public static final String UPLOAD_ERROR_MESSAGE = "upload_error_message";

    boolean checkAvEnable(Context context);

    void enterAnchorPrepareFragment(Context context, Intent intent);

    void enterCropFragment(Activity activity, String str, String str2, int i3);

    void enterRoomByUrl(Context context, String str);

    void fetchFloatWindowStatus();

    IQQLiveEndView getAnchorEndLiveView(QBaseActivity qBaseActivity, QQLiveEndPageInfo qQLiveEndPageInfo, EndLiveClickCallback endLiveClickCallback);

    void hideFloatingWindow();

    void notifyChatAudioChange(boolean z16, boolean z17);

    boolean notifyOuterHasPlayer(long j3, int i3, int i16, int i17, ISuperPlayer iSuperPlayer);

    void openCommonWebDialog(Context context, String str, Bundle bundle);

    void openCommonWebDialog(Context context, String str, Bundle bundle, Drawable drawable);

    void preloadQQLiveRoomProcess();

    void startQQLiveAudiencePage(Context context, StartRoomConfig startRoomConfig);
}
