package com.tencent.av.ui.api;

import android.app.Activity;
import com.tencent.av.app.SessionInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

/* compiled from: P */
@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface IAVVideoRecordBizApi extends QRouteApi {
    int calcControlUIOffset(SessionInfo sessionInfo);

    void changeUIForDoubleToMulti(SessionInfo sessionInfo, long j3, String str);

    void changeVideoLayoutMode(Activity activity);

    void finish(SessionInfo sessionInfo);

    void handleVideoOrientationChanged(int i3);

    void init(Activity activity);

    void initRecordUiCtrl(Activity activity, long j3);

    void initVideoLayerUI(Activity activity);

    boolean isEnableRecord();

    void onCloseSessionFinished();

    void onDestroy(SessionInfo sessionInfo);

    void onPauseVideo(Activity activity, SessionInfo sessionInfo, long j3);

    void onPeerSwitchTerminal(Activity activity);

    void onResume(SessionInfo sessionInfo, Object obj);

    void onStop(SessionInfo sessionInfo);

    void onVideoClose(SessionInfo sessionInfo, int i3);

    void receiveEffect(int i3);

    void receiveRecordMsg(String str, String str2);

    void resetControlUI(Object obj);

    void tryShowRecordBtn(SessionInfo sessionInfo, long j3, String str, boolean z16, int i3);

    void updateRecordButton();
}
