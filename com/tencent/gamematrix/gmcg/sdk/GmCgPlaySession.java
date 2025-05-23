package com.tencent.gamematrix.gmcg.sdk;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.tencent.gamematrix.gmcg.api.GmCgApiService;
import com.tencent.gamematrix.gmcg.api.GmCgAuthRefreshListener;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventRequest;
import com.tencent.gamematrix.gmcg.api.GmCgImeInputController;
import com.tencent.gamematrix.gmcg.api.GmCgPlayAllocatorListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayDcEventListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayPerfListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayPushEventListener;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatus;
import com.tencent.gamematrix.gmcg.api.GmCgPlayStatusListener;
import com.tencent.gamematrix.gmcg.api.GmCgSdkScreenShotListener;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameLoginInfo;
import com.tencent.gamematrix.gmcg.api.model.GmCgGameStreamQualityCfg;
import com.tencent.gamematrix.gmcg.sdk.event.dcevent.khmidgame.CGKingsHonorMidGameConfig;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCParameters;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.IGamepadController;
import java.util.List;

/* loaded from: classes6.dex */
public interface GmCgPlaySession extends IGamepadController {
    void addDcEventParser(GmCgDcEventParser gmCgDcEventParser);

    void cancelQueue();

    void changeOrientationOnFly(int i3);

    void configAutoLogin(int i3, String str, String str2, String str3);

    void configAutoLoginForDelegateCode(int i3, String str, String str2);

    void configAutoLoginForYsdk(int i3, String str, String str2, String str3, String str4);

    void directPlay();

    void enableRemoteMediaStream(boolean z16);

    void fetchCloudGameLog();

    boolean getAudioStatus();

    GmCgPlayStatus getPlayStatus();

    WebRTCParameters getRtcParameter();

    String getVideoCodecType();

    void keepRtcConnection(boolean z16);

    @MainThread
    void login(int i3, String str, @Nullable String str2, GmCgApiService.ActionResultListener actionResultListener);

    @MainThread
    void login(GmCgApiService.ActionResultListener actionResultListener);

    void loginGameInCloudGame(GmCgGameLoginInfo gmCgGameLoginInfo);

    boolean onGenericMotionEvent(MotionEvent motionEvent);

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    boolean onKeyUp(int i3, KeyEvent keyEvent);

    void onPageDestroy();

    void onPagePause();

    void onPageStart();

    @MainThread
    void pausePlay();

    List<GmCgGameStreamQualityCfg> regenerateAdaptivePlayStreamQuality(boolean z16);

    void releasePlay();

    void removePlayStatusListener();

    void reportCustomEvent(String str, Object obj);

    @MainThread
    void restartPlay();

    @MainThread
    void restartPlay(boolean z16);

    @MainThread
    void restartPlayWithResolutionChange();

    GmCgGameStreamQualityCfg restorePlayStreamQuality();

    @MainThread
    void resumePlay();

    void screenShot(@Nullable GmCgSdkScreenShotListener gmCgSdkScreenShotListener, @Nullable Integer num);

    void screenShotPlaySessionView(GmCgSdkScreenShotListener gmCgSdkScreenShotListener);

    void sendAppMonitorReq(int i3);

    void sendCommonNotifyToRemoteClient(int i3, String str);

    void sendCopiedText(String str);

    void sendDcEventRequest(GmCgDcEventRequest gmCgDcEventRequest);

    void sendDcEventRequestThroughHttp(GmCgDcEventRequest gmCgDcEventRequest, GmCgApiService.ActionResultListener actionResultListener);

    void sendEnterGameRoomReq(String str, String str2, String str3);

    void sendGameLoginState(int i3);

    void sendImage(String str);

    void sendKingsHonorMidGameBeginReq(CGKingsHonorMidGameConfig cGKingsHonorMidGameConfig);

    void sendObtainMidasConfigReq();

    void sendRefreshGameReq();

    void sendRestartGameReq();

    void sendSceneCheckReq(String str);

    void sendSwitchInfoLayerReq();

    void sendUserFeedback(boolean z16);

    void setAuthRefreshListener(GmCgAuthRefreshListener gmCgAuthRefreshListener);

    void setCloudGameLoginParam(int i3, String str);

    void setCloudGameLoginParamV1(int i3, GmCgGameLoginInfo gmCgGameLoginInfo);

    void setCloudGameLoginParamV2(int i3, String str);

    void setImeInputController(Activity activity, GmCgImeInputController gmCgImeInputController);

    void setInGameLoginYybParam(String str);

    void setPlayAllocatorListener(GmCgPlayAllocatorListener gmCgPlayAllocatorListener);

    void setPlayContainer(FrameLayout frameLayout, int i3, boolean z16);

    void setPlayDcEventListener(GmCgPlayDcEventListener gmCgPlayDcEventListener);

    void setPlayPerfListener(GmCgPlayPerfListener gmCgPlayPerfListener);

    void setPlayPushEventListener(GmCgPlayPushEventListener gmCgPlayPushEventListener);

    void setPlaySceneInfo(String str);

    void setPlayStatusListener(GmCgPlayStatusListener gmCgPlayStatusListener);

    GmCgGameStreamQualityCfg setPlayStreamQuality(int i3);

    void setPlayVideoBitrate(int i3);

    void setPlayVideoBitrateRange(int i3, int i16);

    void setPreview(boolean z16);

    void setRemoteAudioVolume(double d16);

    void showPlayExtraInfoOverlay(boolean z16);

    void startCloudGameFaceRecognition(Activity activity, String str, String str2, String str3);

    @MainThread
    void startPlay();

    @MainThread
    void stopPlay();

    void stopWebRtc();

    void switchOnAudio(boolean z16);

    void switchOnGps(boolean z16);

    void switchOnVoice(boolean z16);

    void switchToPreferredMode(int i3);
}
