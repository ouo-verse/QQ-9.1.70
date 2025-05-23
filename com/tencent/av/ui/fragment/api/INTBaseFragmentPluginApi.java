package com.tencent.av.ui.fragment.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.av.gaudio.c;
import com.tencent.av.ui.api.IAVFoldingDeviceBizApi;
import com.tencent.av.ui.api.IAVVideoRecordBizApi;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.ArrayList;

@QRouteFactory(singleton = false)
@QAPI(process = {"video"})
/* loaded from: classes3.dex */
public interface INTBaseFragmentPluginApi extends QRouteApi {
    void adjustUIForDevice(int i3, boolean z16, int i16);

    void changeStyle(boolean z16);

    void changeToDoubleScreen(boolean z16, boolean z17);

    void checkVideoLayerUI();

    void childLock();

    void childUnlock();

    void dispatchEvent(MotionEvent motionEvent);

    void displayToolBar();

    void doDebugInfo(boolean z16);

    void doUpdateAudioVolumeChange(long j3);

    void enableButtons(int i3, boolean z16);

    Activity getAvActivity();

    int getBottomToolbarHeight();

    AlphaAnimation getFaceAlphaAnimation(boolean z16);

    IAVFoldingDeviceBizApi getFoldingDeviceBiz();

    Object getNetStateBar();

    Object getQavEffectMenuView();

    Object getQavPanel();

    int getSystemBarHeight();

    int getTopToolbarHeight(long j3);

    int getTopToolbarTopMargin();

    IAVVideoRecordBizApi getVideoRecord();

    IAVZplanAvatarBizApi getZplanAvatarBiz(boolean z16);

    void handleChatRoomIsResumed();

    void handleChatRoomScrollChanged(boolean z16);

    void hideDoodle(long j3);

    void hideEffectPanel(long j3);

    void hideGassianBg();

    void hideToolBar(String str);

    void hideTopToolbar();

    void init(Object obj, Context context, Object obj2, int i3);

    void initScreenLayout();

    boolean isChildLockShown();

    boolean isDestroyed();

    boolean isShowToolbar(int i3);

    boolean isToolBarDisplay();

    boolean isToolBarFlagDisplay();

    void notifyLayerUIAudioMemberChange();

    void onAfterCloseCamera(long j3, boolean z16);

    void onAfterOpenCamera(long j3, boolean z16, int i3);

    int onApnChanged(int i3);

    boolean onBackPressed();

    void onBeforeCloseCamera(long j3);

    void onChangeUICloseVideo(ArrayList<c> arrayList);

    void onClick(long j3, View view);

    void onClick_Camera(long j3, View view);

    void onClose(long j3, int i3);

    void onConnected(long j3);

    void onCreate();

    void onDavSpeakerModeChange();

    void onDestroy(long j3);

    void onDetectNoDevicePermission(long j3, int i3);

    void onInviteReached(String str, String str2);

    boolean onKeyDown(int i3, KeyEvent keyEvent);

    void onLayoutModeChange(int i3);

    void onMoreSettingBarHideAnimationEnd();

    void onMultiAvSpeakModeChangeByLocal(long j3, int i3, int i16);

    void onMultiAvSpeakerModeChange(long j3, int i3, int i16);

    void onNeedShowPeerVideo();

    void onNetStateDoubleConnected();

    void onNewIntent(Intent intent);

    void onNotRecvAudioData(boolean z16);

    void onNotifyEffectToolbarSelected(int i3, long j3);

    void onOppositeAudioEngineReady();

    void onPause(long j3);

    void onPauseAudio();

    void onPauseEvent();

    void onPauseVideo();

    void onPeerSwitchTerminal(String str, boolean z16);

    void onPhoneCalling(boolean z16, boolean z17);

    void onPlayAnnimate(int i3);

    void onRecvFirstAudioData(long j3, boolean z16);

    void onResume(long j3);

    void onResumeAudio();

    void onResumeVideo();

    void onSelfAudioEngineReady();

    void onServiceConnected();

    void onStart(long j3);

    void onStop(long j3);

    void onTerSwitchSyncStatus(int i3, int i16);

    void onUserScreenShareClose(long j3);

    void onUserScreenShareOpen(long j3);

    void onVideoViewChange(String str, int i3, String str2, int i16);

    void onVideoViewModeChange(int i3, int i16, String str);

    void pressHandFreeBtn();

    void refreshUI();

    void resetToolBarTimer(long j3);

    void restoreDoodle(long j3);

    void setBigVideoNickName(String str);

    boolean setGlassSwitch(int i3);

    void setGlassWaitTime(int i3);

    void setNeedChangeUIForDoubleToMulti();

    void setNetStateImmersiveFlag(boolean z16);

    void setNetStateNetLevel(int i3, int i16, int i17, String str);

    void setNetStateNoNetworkFlag(boolean z16);

    void setNetStatePeerCloseMICFlag(boolean z16);

    void setNetStateSelfCloseMICFlag(boolean z16);

    void setQCallHead(String str, Bitmap bitmap);

    void setQCallNickName(String str);

    void setRotation(long j3, int i3);

    void setSystemStatusBar();

    void setSystemStatusBarForRecording(boolean z16);

    void setTitleBarInnerMarginTop(int i3, boolean z16);

    void setTitleText(long j3, String str, boolean z16);

    void showBottomLine(boolean z16);

    void showBubbleTryAvatar();

    void showTipsInDelay(int i3, String str);

    void showToolBars(int i3);

    void showTopToolbar();

    void showtip_double2multi(String str);

    void triggerChildLock(int i3);

    void updateBigVideoMicState(int i3);

    void updateBigVideoStatusViewVisible(int i3);

    void updateBtn(long j3, int i3);

    void updateBtn_Beauty(long j3);

    boolean updateBtn_Camera(boolean z16, long j3);

    boolean updateBtn_EffectAndVoice_ABTest(long j3);

    void updateBtn_ScreenShare(long j3);

    void updateBtn_ShareMirror(long j3);

    void updateTextLayerStatus();

    void updateTips_SmallHomeEntry(long j3);

    void updateTips_TryZplanAvatar();
}
