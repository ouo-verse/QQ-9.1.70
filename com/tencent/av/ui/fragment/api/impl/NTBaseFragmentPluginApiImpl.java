package com.tencent.av.ui.fragment.api.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.c;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.VideoNetStateBar;
import com.tencent.av.ui.api.IAVFoldingDeviceBizApi;
import com.tencent.av.ui.api.IAVVideoRecordBizApi;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.av.ui.effect.menuview.QavEffectBaseMenuView;
import com.tencent.av.ui.fragment.NTBaseVideoFragment;
import com.tencent.av.ui.fragment.NTDoubleMeetingFragment;
import com.tencent.av.ui.fragment.NTDoubleVideoFragment;
import com.tencent.av.ui.fragment.NTMultiVideoBaseFragment;
import com.tencent.av.ui.fragment.NTMultiVideoDiscussionFragment;
import com.tencent.av.ui.fragment.NTMultiVideoGroupFragment;
import com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi;
import com.tencent.mobileqq.R;
import com.tencent.xaction.log.b;
import java.util.ArrayList;

/* loaded from: classes32.dex */
public class NTBaseFragmentPluginApiImpl implements INTBaseFragmentPluginApi {
    private static final String TAG = "NTMultiFragmentPluginApiImpl";
    NTBaseVideoFragment mBaseVideoFragment;

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void adjustUIForDevice(int i3, boolean z16, int i16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTDoubleVideoFragment) {
            ((NTDoubleVideoFragment) nTBaseVideoFragment).Uk(i3, z16, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void changeStyle(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTDoubleVideoFragment) {
            ((NTDoubleVideoFragment) nTBaseVideoFragment).Yk(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void changeToDoubleScreen(boolean z16, boolean z17) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTDoubleVideoFragment) {
            ((NTDoubleVideoFragment) nTBaseVideoFragment).Zk(z16, z17);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void checkVideoLayerUI() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.qh();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void childLock() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTDoubleVideoFragment) {
            ((NTDoubleVideoFragment) nTBaseVideoFragment).hl();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void childUnlock() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTDoubleVideoFragment) {
            ((NTDoubleVideoFragment) nTBaseVideoFragment).il();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void dispatchEvent(MotionEvent motionEvent) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.rh(motionEvent);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void displayToolBar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.sh();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void doDebugInfo(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.th(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void doUpdateAudioVolumeChange(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.uh(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void enableButtons(int i3, boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.vh(i3, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public int getBottomToolbarHeight() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.xh();
        }
        return 0;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public AlphaAnimation getFaceAlphaAnimation(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Ah(z16);
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public IAVFoldingDeviceBizApi getFoldingDeviceBiz() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Bh();
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public int getSystemBarHeight() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Gh();
        }
        return 0;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public int getTopToolbarHeight(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Hh(j3);
        }
        return 0;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public int getTopToolbarTopMargin() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Ih();
        }
        return 0;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public IAVVideoRecordBizApi getVideoRecord() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Kh();
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public IAVZplanAvatarBizApi getZplanAvatarBiz(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Lh(z16);
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void handleChatRoomIsResumed() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Mh();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void handleChatRoomScrollChanged(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Nh(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void hideDoodle(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Rh(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void hideEffectPanel(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Sh(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void hideGassianBg() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Th();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void hideToolBar(String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Uh(str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void hideTopToolbar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Vh();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void init(Object obj, Context context, Object obj2, int i3) {
        AVActivity aVActivity = (AVActivity) context;
        FragmentTransaction beginTransaction = aVActivity.getSupportFragmentManager().beginTransaction();
        b.a(TAG, 1, "init relationType=" + i3 + " true");
        if (i3 == 1) {
            this.mBaseVideoFragment = new NTMultiVideoGroupFragment((VideoAppInterface) obj, aVActivity, (ControlUIObserver) obj2);
        } else if (i3 == 2) {
            this.mBaseVideoFragment = new NTMultiVideoDiscussionFragment((VideoAppInterface) obj, aVActivity, (ControlUIObserver) obj2);
        } else if (i3 == 100) {
            this.mBaseVideoFragment = new NTDoubleMeetingFragment((VideoAppInterface) obj, aVActivity, (ControlUIObserver) obj2);
        } else if (i3 == 3) {
            this.mBaseVideoFragment = new NTDoubleVideoFragment((VideoAppInterface) obj, aVActivity, (ControlUIObserver) obj2);
        }
        beginTransaction.replace(R.id.cks, this.mBaseVideoFragment);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void initScreenLayout() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTMultiVideoBaseFragment) {
            ((NTMultiVideoBaseFragment) nTBaseVideoFragment).bl();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean isChildLockShown() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Zh();
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean isDestroyed() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.isDestroyed();
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean isShowToolbar(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.ci(i3);
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean isToolBarDisplay() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.di();
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean isToolBarFlagDisplay() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        return nTBaseVideoFragment != null && nTBaseVideoFragment.ei();
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void notifyLayerUIAudioMemberChange() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment instanceof NTMultiVideoBaseFragment) {
            ((NTMultiVideoBaseFragment) nTBaseVideoFragment).gl();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onAfterCloseCamera(long j3, boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.gi(j3, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onAfterOpenCamera(long j3, boolean z16, int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.hi(j3, z16, i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public int onApnChanged(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.ii(i3);
        }
        return 0;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean onBackPressed() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.onBackPressed();
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onBeforeCloseCamera(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.ji(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onChangeUICloseVideo(ArrayList<c> arrayList) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.li(arrayList);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onClick(long j3, View view) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.mi(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onClick_Camera(long j3, View view) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.oi(j3, view);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onClose(long j3, int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Fi(j3, i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onConnected(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Hi(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onDavSpeakerModeChange() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ji();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onDestroy(long j3) {
        FragmentTransaction beginTransaction = getAvActivity().getSupportFragmentManager().beginTransaction();
        beginTransaction.remove(this.mBaseVideoFragment);
        beginTransaction.commitAllowingStateLoss();
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ki(j3);
            this.mBaseVideoFragment = null;
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onDetectNoDevicePermission(long j3, int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Li(j3, i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onInviteReached(String str, String str2) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Mi(str, str2);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.onKeyDown(i3, keyEvent);
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onLayoutModeChange(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ni(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onMoreSettingBarHideAnimationEnd() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Oi();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onMultiAvSpeakModeChangeByLocal(long j3, int i3, int i16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Pi(j3, i3, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onMultiAvSpeakerModeChange(long j3, int i3, int i16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Qi(j3, i3, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onNeedShowPeerVideo() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ri();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onNetStateDoubleConnected() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Si();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onNewIntent(Intent intent) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.onNewIntent(intent);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onNotRecvAudioData(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ti(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onNotifyEffectToolbarSelected(int i3, long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ui(i3, j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onOppositeAudioEngineReady() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Vi();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPause(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Wi(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPauseAudio() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Xi();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPauseEvent() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Yi();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPauseVideo() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Zi();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPeerSwitchTerminal(String str, boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.aj(str, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPhoneCalling(boolean z16, boolean z17) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.bj(z16, z17);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onPlayAnnimate(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.cj(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onRecvFirstAudioData(long j3, boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.dj(j3, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onResume(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.ej(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onResumeAudio() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.fj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onResumeVideo() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.gj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onSelfAudioEngineReady() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.hj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onServiceConnected() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.jj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onStart(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.kj(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onStop(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.lj(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onTerSwitchSyncStatus(int i3, int i16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.mj(i3, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onUserScreenShareClose(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.pj(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onUserScreenShareOpen(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.qj(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onVideoViewChange(String str, int i3, String str2, int i16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.rj(str, i3, str2, i16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onVideoViewModeChange(int i3, int i16, String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.sj(i3, i16, str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void pressHandFreeBtn() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.uj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void refreshUI() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.refreshUI();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void resetToolBarTimer(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.yj(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void restoreDoodle(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Aj(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setBigVideoNickName(String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Bj(str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean setGlassSwitch(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Ej(i3);
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setGlassWaitTime(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Fj(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setNeedChangeUIForDoubleToMulti() {
        this.mBaseVideoFragment.Gj();
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setNetStateImmersiveFlag(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Hj(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setNetStateNetLevel(int i3, int i16, int i17, String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Ij(i3, i16, i17, str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setNetStateNoNetworkFlag(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Jj(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setNetStatePeerCloseMICFlag(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Kj(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setNetStateSelfCloseMICFlag(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Lj(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setQCallHead(String str, Bitmap bitmap) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Mj(str, bitmap);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setQCallNickName(String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Nj(str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setRotation(long j3, int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Pj(j3, i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setSystemStatusBar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Qj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setSystemStatusBarForRecording(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Rj(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setTitleBarInnerMarginTop(int i3, boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Tj(i3, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void setTitleText(long j3, String str, boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Uj(j3, str, z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void showBottomLine(boolean z16) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Wj(z16);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void showBubbleTryAvatar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Xj();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void showTipsInDelay(int i3, String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Zj(i3, str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void showToolBars(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.ak(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void showTopToolbar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.bk();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void showtip_double2multi(String str) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.ck(str);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void triggerChildLock(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.hk(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateBigVideoMicState(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.jk(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateBigVideoStatusViewVisible(int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.kk(i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateBtn(long j3, int i3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.lk(j3, i3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateBtn_Beauty(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.pk(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean updateBtn_Camera(boolean z16, long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.rk(z16, j3);
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public boolean updateBtn_EffectAndVoice_ABTest(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.zk(j3);
        }
        return false;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateBtn_ScreenShare(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Hk(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateBtn_ShareMirror(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Jk(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateTextLayerStatus() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Pk();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateTips_SmallHomeEntry(long j3) {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Qk(j3);
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void updateTips_TryZplanAvatar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            nTBaseVideoFragment.Rk();
        }
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public AVActivity getAvActivity() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.wh();
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public VideoNetStateBar getNetStateBar() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Jh();
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public QavEffectBaseMenuView getQavEffectMenuView() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Dh();
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public QavPanel getQavPanel() {
        NTBaseVideoFragment nTBaseVideoFragment = this.mBaseVideoFragment;
        if (nTBaseVideoFragment != null) {
            return nTBaseVideoFragment.Eh();
        }
        return null;
    }

    @Override // com.tencent.av.ui.fragment.api.INTBaseFragmentPluginApi
    public void onCreate() {
    }
}
