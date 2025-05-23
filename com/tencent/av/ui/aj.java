package com.tencent.av.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.api.IAVFoldingDeviceBizApi;
import com.tencent.av.ui.api.IAVVideoRecordBizApi;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class aj {

    /* renamed from: a, reason: collision with root package name */
    private INTBaseFragmentPluginApi f75338a;

    /* renamed from: b, reason: collision with root package name */
    private int f75339b;

    public aj(VideoAppInterface videoAppInterface, AVActivity aVActivity, ControlUIObserver controlUIObserver, int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = (INTBaseFragmentPluginApi) QRoute.api(INTBaseFragmentPluginApi.class);
        this.f75338a = iNTBaseFragmentPluginApi;
        iNTBaseFragmentPluginApi.init(videoAppInterface, aVActivity, controlUIObserver, i3);
        this.f75339b = i3;
    }

    public void A(String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.hideToolBar(str);
        }
    }

    public void A0(int i3, int i16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onTerSwitchSyncStatus(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.hideTopToolbar();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onUserScreenShareClose(j3);
        }
    }

    public void C() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.initScreenLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onUserScreenShareOpen(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean D() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.isChildLockShown();
        }
        return false;
    }

    public void D0(String str, int i3, String str2, int i16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onVideoViewChange(str, i3, str2, i16);
        }
    }

    public boolean E() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.isDestroyed();
        }
        return false;
    }

    public void E0(int i3, int i16, String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onVideoViewModeChange(i3, i16, str);
        }
    }

    public boolean F() {
        int i3 = this.f75339b;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public void F0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.pressHandFreeBtn();
        }
    }

    public boolean G() {
        if (this.f75339b == 100) {
            return true;
        }
        return false;
    }

    public void G0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.refreshUI();
        }
    }

    public boolean H(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.isShowToolbar(i3);
        }
        return false;
    }

    public void H0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.resetToolBarTimer(j3);
        }
    }

    public boolean I() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.isToolBarDisplay();
        }
        return false;
    }

    public void I0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.restoreDoodle(j3);
        }
    }

    public boolean J() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null && iNTBaseFragmentPluginApi.isToolBarFlagDisplay()) {
            return true;
        }
        return false;
    }

    public void J0(String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setBigVideoNickName(str);
        }
    }

    public void K() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.notifyLayerUIAudioMemberChange();
        }
    }

    public boolean K0(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.setGlassSwitch(i3);
        }
        return false;
    }

    public void L(long j3, boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onAfterCloseCamera(j3, z16);
        }
    }

    public void L0(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setGlassWaitTime(i3);
        }
    }

    public void M(long j3, boolean z16, int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onAfterOpenCamera(j3, z16, i3);
        }
    }

    public void M0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setNeedChangeUIForDoubleToMulti();
        }
    }

    public int N(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.onApnChanged(i3);
        }
        return 0;
    }

    public void N0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setNetStateImmersiveFlag(z16);
        }
    }

    public boolean O() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.onBackPressed();
        }
        return false;
    }

    public void O0(int i3, int i16, int i17, String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setNetStateNetLevel(i3, i16, i17, str);
        }
    }

    public void P(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onBeforeCloseCamera(j3);
        }
    }

    public void P0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setNetStateNoNetworkFlag(z16);
        }
    }

    public void Q(ArrayList<com.tencent.av.gaudio.c> arrayList) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onChangeUICloseVideo(arrayList);
        }
    }

    public void Q0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setNetStatePeerCloseMICFlag(z16);
        }
    }

    public void R(long j3, View view) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onClick(j3, view);
        }
    }

    public void R0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setNetStateSelfCloseMICFlag(z16);
        }
    }

    public void S(long j3, View view) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onClick_Camera(j3, view);
        }
    }

    public void S0(String str, Bitmap bitmap) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setQCallHead(str, bitmap);
        }
    }

    public void T(long j3, int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onClose(j3, i3);
        }
    }

    public void T0(String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setQCallNickName(str);
        }
    }

    public void U(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onConnected(j3);
        }
    }

    public void U0(long j3, int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setRotation(j3, i3);
        }
    }

    public void V() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onCreate();
        }
    }

    public void V0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setSystemStatusBar();
        }
    }

    public void W() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onDavSpeakerModeChange();
        }
    }

    public void W0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setSystemStatusBarForRecording(z16);
        }
    }

    public void X(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onDestroy(j3);
            this.f75338a = null;
        }
    }

    public void X0(int i3, boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setTitleBarInnerMarginTop(i3, z16);
        }
    }

    public void Y(long j3, int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onDetectNoDevicePermission(j3, i3);
        }
    }

    public void Y0(long j3, String str, boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.setTitleText(j3, str, z16);
        }
    }

    public void Z(String str, String str2) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onInviteReached(str, str2);
        }
    }

    public void Z0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.showBottomLine(z16);
        }
    }

    public void a(int i3, boolean z16, int i16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.adjustUIForDevice(i3, z16, i16);
        }
    }

    public boolean a0(int i3, KeyEvent keyEvent) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.onKeyDown(i3, keyEvent);
        }
        return false;
    }

    public void a1() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.showBubbleTryAvatar();
        }
    }

    public void b(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.changeStyle(z16);
        }
    }

    public void b0(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onLayoutModeChange(i3);
        }
    }

    public void b1(int i3, String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.showTipsInDelay(i3, str);
        }
    }

    public void c(boolean z16, boolean z17) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.changeToDoubleScreen(z16, z17);
        }
    }

    public void c0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onMoreSettingBarHideAnimationEnd();
        }
    }

    public void c1(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.showToolBars(i3);
        }
    }

    public void d() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.checkVideoLayerUI();
        }
    }

    public void d0(long j3, int i3, int i16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onMultiAvSpeakModeChangeByLocal(j3, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d1() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.showTopToolbar();
        }
    }

    public void e() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.childLock();
        }
    }

    public void e0(long j3, int i3, int i16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onMultiAvSpeakerModeChange(j3, i3, i16);
        }
    }

    public void e1(String str) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.showtip_double2multi(str);
        }
    }

    public void f() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.childUnlock();
        }
    }

    public void f0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onNeedShowPeerVideo();
        }
    }

    public void f1(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.triggerChildLock(i3);
        }
    }

    public void g(MotionEvent motionEvent) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.dispatchEvent(motionEvent);
        }
    }

    public void g0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onNetStateDoubleConnected();
        }
    }

    public void g1(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateBigVideoMicState(i3);
        }
    }

    public void h() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.displayToolBar();
        }
    }

    public void h0(Intent intent) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onNewIntent(intent);
        }
    }

    public void h1(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateBigVideoStatusViewVisible(i3);
        }
    }

    public void i(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.doUpdateAudioVolumeChange(j3);
        }
    }

    public void i0(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onNotRecvAudioData(z16);
        }
    }

    public void i1(long j3, int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateBtn(j3, i3);
        }
    }

    public void j(int i3, boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.enableButtons(i3, z16);
        }
    }

    public void j0(int i3, long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onNotifyEffectToolbarSelected(i3, j3);
        }
    }

    public void j1(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateBtn_Beauty(j3);
        }
    }

    public int k() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getBottomToolbarHeight();
        }
        return 0;
    }

    public void k0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onOppositeAudioEngineReady();
        }
    }

    public boolean k1(boolean z16, long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.updateBtn_Camera(z16, j3);
        }
        return false;
    }

    public AlphaAnimation l(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getFaceAlphaAnimation(z16);
        }
        return null;
    }

    public void l0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPause(j3);
        }
    }

    public boolean l1(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.updateBtn_EffectAndVoice_ABTest(j3);
        }
        return false;
    }

    public IAVFoldingDeviceBizApi m() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getFoldingDeviceBiz();
        }
        return null;
    }

    public void m0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPauseAudio();
        }
    }

    public void m1(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateBtn_ScreenShare(j3);
        }
    }

    public VideoNetStateBar n() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return (VideoNetStateBar) iNTBaseFragmentPluginApi.getNetStateBar();
        }
        return null;
    }

    public void n0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPauseEvent();
        }
    }

    public void n1(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateBtn_ShareMirror(j3);
        }
    }

    public QavEffectBaseMenuView o() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return (QavEffectBaseMenuView) iNTBaseFragmentPluginApi.getQavEffectMenuView();
        }
        return null;
    }

    public void o0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPauseVideo();
        }
    }

    public void o1() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateTextLayerStatus();
        }
    }

    public QavPanel p() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return (QavPanel) iNTBaseFragmentPluginApi.getQavPanel();
        }
        return null;
    }

    public void p0(String str, boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPeerSwitchTerminal(str, z16);
        }
    }

    public void p1(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateTips_SmallHomeEntry(j3);
        }
    }

    public int q() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getSystemBarHeight();
        }
        return 0;
    }

    public void q0(boolean z16, boolean z17) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPhoneCalling(z16, z17);
        }
    }

    public void q1() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.updateTips_TryZplanAvatar();
        }
    }

    public int r(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getTopToolbarHeight(j3);
        }
        return 0;
    }

    public void r0(int i3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onPlayAnnimate(i3);
        }
    }

    public int s() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getTopToolbarTopMargin();
        }
        return 0;
    }

    public void s0(long j3, boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onRecvFirstAudioData(j3, z16);
        }
    }

    public IAVVideoRecordBizApi t() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getVideoRecord();
        }
        return null;
    }

    public void t0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onResume(j3);
        }
    }

    public IAVZplanAvatarBizApi u(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            return iNTBaseFragmentPluginApi.getZplanAvatarBiz(z16);
        }
        return null;
    }

    public void u0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onResumeAudio();
        }
    }

    public void v() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.handleChatRoomIsResumed();
        }
    }

    public void v0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onResumeVideo();
        }
    }

    public void w(boolean z16) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.handleChatRoomScrollChanged(z16);
        }
    }

    public void w0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onSelfAudioEngineReady();
        }
    }

    public void x(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.hideDoodle(j3);
        }
    }

    public void x0() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onServiceConnected();
        }
    }

    public void y(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.hideEffectPanel(j3);
        }
    }

    public void y0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onStart(j3);
        }
    }

    public void z() {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.hideGassianBg();
        }
    }

    public void z0(long j3) {
        INTBaseFragmentPluginApi iNTBaseFragmentPluginApi = this.f75338a;
        if (iNTBaseFragmentPluginApi != null) {
            iNTBaseFragmentPluginApi.onStop(j3);
        }
    }
}
