package com.tencent.av.ui.api.impl;

import android.content.Context;
import android.graphics.Rect;
import ax.j;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.aj;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.utils.DataReport;
import com.tencent.av.zplan.avatar.resmgr.AVAvatarResMgr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.filament.zplan.view.AVFilamentTextureView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.LaunchScene;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AVZplanAvatarBizApiImpl implements IAVZplanAvatarBizApi {
    private static final String TAG = "AVZplanAvatarBizProxy";
    private static final int ZPLAN_AVATAR_EASTER_EGG_COUNT = 3;
    private static final long ZPLAN_AVATAR_EASTER_EGG_TIPS_DELAY = 30000;
    private ow.a mAvatarEasterEggPart;
    private WeakReference<Context> mContext;
    private int mBeforeZplanAvatarPreviewWidth = 0;
    private int mBeforeZplanAvatarPreviewHeight = 0;
    private final Runnable mZplanAvatarEasterEggTipsRunnable = new Runnable() { // from class: com.tencent.av.ui.api.impl.i
        @Override // java.lang.Runnable
        public final void run() {
            AVZplanAvatarBizApiImpl.this.lambda$new$0();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public AVActivity getAVActivity() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return (AVActivity) this.mContext.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        SessionInfo f16;
        String currentAccountUin;
        int e26;
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null || aVActivity.H0 == null || r.h0() == null || (f16 = n.e().f()) == null || f16.S2 || !f16.f73098x2 || (e26 = ea.e2((currentAccountUin = aVActivity.H0.getCurrentAccountUin()), 0)) >= 3 || !cw.e.n(aVActivity.H0, e26 + LaunchScene.LAUNCH_SCENE_GAME_CENTER_QA)) {
            return;
        }
        f16.S2 = true;
        ea.s3(currentAccountUin, e26 + 1);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void changeAvatarLayout(boolean z16, boolean z17) {
        j J0;
        if (r.h0() == null || (J0 = r.h0().J0()) == null) {
            return;
        }
        J0.r(z16);
        if (z16) {
            return;
        }
        J0.m0(z17);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void init(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onConnect() {
        ThreadManager.getUIHandler().postDelayed(this.mZplanAvatarEasterEggTipsRunnable, 30000L);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onDestroy() {
        ThreadManager.getUIHandler().removeCallbacks(this.mZplanAvatarEasterEggTipsRunnable);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyPeerZplanAvatarSupport(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNotifyPeerZplanAvatarSupport enable: " + z16);
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null || r.h0() == null || n.e().f() == null || !n.e().f().f73098x2) {
            return;
        }
        if (!z16) {
            cw.e.n(aVActivity.H0, 3032);
            ReportController.o(null, "dc00898", "", "", "0X800C448", "0X800C448", 0, 0, "", "", "", "");
        } else {
            cw.e.d(aVActivity.H0, 3032);
        }
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyPeerZplanAvatarSupportTips() {
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNotifyPeerZplanAvatarSupportTips");
        }
        cw.e.n(aVActivity.H0, 3032);
        DataReport.T(null, "dc00898", "", "", "0X800C448", "0X800C448", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyPeerZplanAvatarSwitch(String str, boolean z16, String str2) {
        aj ajVar;
        ICameraManagerApi iCameraManagerApi;
        VideoLayerUI videoLayerUI;
        aj ajVar2;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNotifyPeerZplanAvatarSwitch enable: " + z16 + " backgroundId: " + str2);
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null) {
            return;
        }
        aj ajVar3 = aVActivity.I0;
        if (ajVar3 != null) {
            ajVar3.x(com.tencent.av.utils.e.d());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.api.impl.AVZplanAvatarBizApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                if (r.h0() != null) {
                    r.h0().l2(2);
                }
            }
        }, 16, null, true);
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        if (z16) {
            f16.g0(false, true);
            if (!f16.O && !f16.N && !f16.f73098x2 && (ajVar2 = aVActivity.I0) != null) {
                ajVar2.v0();
                f16.p0(d16, "onNotifyPeerZplanAvatarSwitch", 1);
            }
            f16.x0(false, true);
            VideoChatRoomUIContoller videoChatRoomUIContoller = aVActivity.f74657h1;
            if (videoChatRoomUIContoller != null) {
                videoChatRoomUIContoller.o(3);
                aVActivity.f74657h1.y(false);
            }
            aj ajVar4 = aVActivity.I0;
            if (ajVar4 != null) {
                ajVar4.y(d16);
                aVActivity.I0.G0();
            }
            boolean z17 = f16.f73098x2;
            if (z17 && (videoLayerUI = aVActivity.J0) != null) {
                videoLayerUI.Z = false;
            }
            if (!z17 && f16.f73035i == 2 && (iCameraManagerApi = aVActivity.K0) != null && iCameraManagerApi.isCameraOpened(d16)) {
                QLog.d(TAG, 2, "onNotifyPeerZplanAvatarSwitch request close camera");
                aVActivity.H0.k0(new Object[]{106, Long.valueOf(d16)});
            }
            int i3 = aVActivity.f74642a0;
            switchFilamentViewMode(f16, (i3 == 4 || i3 == 5) ? false : true);
        } else {
            boolean s36 = aVActivity.s3();
            if (f16.A2) {
                QLog.d(TAG, 2, "onNotifyPeerZplanAvatarSwitch close peer view");
                aVActivity.J0.W1(d16, str, 1);
                f16.g0(false, false);
            } else if (f16.O && !f16.N && !f16.f73098x2) {
                QLog.d(TAG, 2, "onNotifyPeerZplanAvatarSwitch just close self video");
                aVActivity.J0.a2(d16);
            }
            f16.x0(false, false);
            r.h0().M0(false, false);
            if (!f16.O && !f16.N && !f16.f73098x2 && (ajVar = aVActivity.I0) != null) {
                ajVar.o0();
            }
            if (f16.f73098x2 && s36) {
                aVActivity.J3(false);
                VideoLayerUI videoLayerUI2 = aVActivity.J0;
                if (videoLayerUI2 != null) {
                    videoLayerUI2.Z = true;
                }
                changeAvatarLayout(false, true);
            }
            cw.e.d(aVActivity.H0, LaunchScene.LAUNCH_SCENE_BOTTOM_GUID);
            switchFilamentViewMode(f16, true);
        }
        aj ajVar5 = aVActivity.I0;
        if (ajVar5 != null) {
            ajVar5.i1(com.tencent.av.utils.e.d(), 33554431);
        }
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyUpdateZplanAvatarFakeBackground(boolean z16) {
        VideoLayerUI videoLayerUI;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onNotifyUpdateZplanAvatarFakeBackground isShow " + z16);
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null || (videoLayerUI = aVActivity.J0) == null) {
            return;
        }
        videoLayerUI.k1(z16);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyUpdateZplanAvatarLoadingProgress(int i3) {
        VideoLayerUI videoLayerUI;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onNotifyUpdateZplanAvatarLoadingProgress progress" + i3);
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null || (videoLayerUI = aVActivity.J0) == null) {
            return;
        }
        videoLayerUI.s3(i3);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyUpdateZplanAvatarLoadingView(boolean z16, boolean z17) {
        VideoLayerUI videoLayerUI;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onNotifyUpdateZplanAvatarLoadingView " + z16);
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null || (videoLayerUI = aVActivity.J0) == null) {
            return;
        }
        videoLayerUI.t3(z16, z17);
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyZplanAvatarSwitchLayoutBtn() {
        aj ajVar;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNotifyZplanAvatarSwitchLayoutBtn");
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null || (ajVar = aVActivity.I0) == null) {
            return;
        }
        ajVar.l1(com.tencent.av.utils.e.d());
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void onNotifyZplanAvatarTryTips() {
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNotifyZplanAvatarTryTips");
        }
        if (r.h0() != null) {
            SessionInfo f16 = n.e().f();
            aj ajVar = aVActivity.I0;
            if (ajVar == null || f16.f73098x2) {
                return;
            }
            ajVar.q1();
            aVActivity.I0.a1();
        }
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public boolean onReopenCamera(int i3, int i16) {
        if (!n.e().f().f73098x2) {
            return false;
        }
        if (i3 == 640 && i16 == 480) {
            return false;
        }
        this.mBeforeZplanAvatarPreviewWidth = i3;
        this.mBeforeZplanAvatarPreviewHeight = i16;
        return true;
    }

    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    public void switchFilamentViewMode(final SessionInfo sessionInfo, boolean z16) {
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null) {
            return;
        }
        if (sessionInfo == null) {
            QLog.i(TAG, 2, "switchFilamentViewMode session is null");
            return;
        }
        if (!sessionInfo.f73098x2 && !sessionInfo.f73102y2) {
            VideoLayerUI videoLayerUI = aVActivity.J0;
            if (videoLayerUI == null || !videoLayerUI.P0()) {
                return;
            }
            aVActivity.J0.g1(false);
            ow.a aVar = this.mAvatarEasterEggPart;
            if (aVar != null) {
                aVar.onDestroy();
                this.mAvatarEasterEggPart = null;
                return;
            }
            return;
        }
        aVActivity.checkVideoLayerUI();
        VideoLayerUI videoLayerUI2 = aVActivity.J0;
        if (videoLayerUI2 == null || videoLayerUI2.P0()) {
            return;
        }
        if (this.mAvatarEasterEggPart == null) {
            this.mAvatarEasterEggPart = new ow.a(this.mContext.get(), aVActivity.H0);
        }
        aVActivity.J0.g1(true);
        if (z16) {
            final AVFilamentTextureView v06 = aVActivity.J0.v0();
            v06.post(new Runnable() { // from class: com.tencent.av.ui.api.impl.AVZplanAvatarBizApiImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    AVActivity aVActivity2 = AVZplanAvatarBizApiImpl.this.getAVActivity();
                    if (r.h0() == null || aVActivity2 == null || aVActivity2.J0 == null) {
                        return;
                    }
                    r.h0().S0(v06);
                    j J0 = r.h0().J0();
                    if (J0 == null) {
                        return;
                    }
                    int mSmallViewWidth = J0.getMSmallViewWidth();
                    int mSmallViewHeight = J0.getMSmallViewHeight();
                    int height = v06.getHeight();
                    int width = v06.getWidth();
                    int mSmallViewLeftMargin = J0.getMSmallViewLeftMargin();
                    int mSmallViewWidth2 = J0.getMSmallViewWidth() + mSmallViewLeftMargin;
                    int mSmallViewBottomMargin = height - J0.getMSmallViewBottomMargin();
                    int mSmallViewHeight2 = mSmallViewBottomMargin - J0.getMSmallViewHeight();
                    if (mSmallViewHeight > 0 && mSmallViewWidth > 0 && mSmallViewLeftMargin >= 0 && mSmallViewWidth2 <= width && mSmallViewBottomMargin <= height && mSmallViewHeight2 >= 0) {
                        aVActivity2.J0.n1(mSmallViewLeftMargin, mSmallViewWidth2, mSmallViewHeight2, mSmallViewBottomMargin);
                    } else {
                        Rect rect = new Rect();
                        com.tencent.av.zplan.avatar.utils.b.c(aVActivity2.getResources(), 3, width, height, rect);
                        aVActivity2.J0.n1(rect.left, rect.right, rect.top, rect.bottom);
                        J0.p0(rect.width(), rect.height(), rect.left, height - rect.bottom);
                    }
                    if (r.h0().U0() && J0.getMIsDoubleHorizontal()) {
                        SessionInfo sessionInfo2 = sessionInfo;
                        if (sessionInfo2.f73098x2 && sessionInfo2.f73102y2) {
                            J0.r(true);
                            aVActivity2.e4();
                            return;
                        }
                    }
                    J0.m0(!sessionInfo.f73102y2);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0133  */
    @Override // com.tencent.av.ui.api.IAVZplanAvatarBizApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNotifySelfZplanAvatarSwitch(boolean z16) {
        boolean z17;
        SessionInfo sessionInfo;
        VideoLayerUI videoLayerUI;
        int i3;
        VideoChatRoomUIContoller videoChatRoomUIContoller;
        int i16;
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onNotifySelfZplanAvatarSwitch enable: " + z16);
        }
        AVActivity aVActivity = getAVActivity();
        if (aVActivity == null) {
            return;
        }
        aj ajVar = aVActivity.I0;
        if (ajVar != null) {
            ajVar.x(com.tencent.av.utils.e.d());
        }
        if (r.h0() == null) {
            QLog.e(TAG, 1, "onNotifySelfZplanAvatarSwitch error: VideoController.getInstance() is null.");
            return;
        }
        VideoAppInterface videoAppInterface = aVActivity.H0;
        if (videoAppInterface == null) {
            videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        }
        VideoLayerUI videoLayerUI2 = aVActivity.J0;
        r.h0().l2(1);
        long d16 = com.tencent.av.utils.e.d();
        SessionInfo f16 = n.e().f();
        String str = f16.f73091w;
        if (z16) {
            f16.x0(true, true);
            f16.g0(true, true);
            ICameraManagerApi iCameraManagerApi = aVActivity.K0;
            if (iCameraManagerApi != null && !iCameraManagerApi.isCameraOpened(d16)) {
                com.tencent.avcore.camera.b.f77378u = 640;
                com.tencent.avcore.camera.b.f77379v = 480;
                aVActivity.U0.O(false, d16);
                QLog.d(TAG, 1, "[onNotifySelfZplanAvatarSwitch] onRequest_OpenCamera.");
            } else {
                ICameraManagerApi iCameraManagerApi2 = aVActivity.K0;
                if (iCameraManagerApi2 != null && !iCameraManagerApi2.isFrontCamera()) {
                    if (videoAppInterface != null) {
                        videoAppInterface.k0(new Object[]{107, Long.valueOf(d16)});
                    }
                    f16.R = true;
                }
                r.h0().S1(f16.f73091w);
            }
            if (videoLayerUI2 != null) {
                videoLayerUI2.a2(d16);
                videoLayerUI2.W1(d16, str, 1);
            }
            if (com.tencent.avcore.camera.b.f77378u != 640 || com.tencent.avcore.camera.b.f77379v != 480) {
                this.mBeforeZplanAvatarPreviewWidth = com.tencent.avcore.camera.b.f77378u;
                this.mBeforeZplanAvatarPreviewHeight = com.tencent.avcore.camera.b.f77379v;
                if (videoAppInterface != null) {
                    i3 = 3;
                    videoAppInterface.k0(new Object[]{32, 640, 480, Long.valueOf(d16)});
                    videoChatRoomUIContoller = aVActivity.f74657h1;
                    if (videoChatRoomUIContoller != null) {
                        videoChatRoomUIContoller.o(i3);
                        aVActivity.f74657h1.y(false);
                    }
                    if (ajVar != null) {
                        ajVar.y(d16);
                    }
                    switchFilamentViewMode(f16, true);
                    i16 = f16.f73070q2;
                    if ((i16 != -1 && videoAppInterface != null && i16 < 10006) || f16.C2 == 0 || (i17 = f16.f73074r2) == 5 || i17 == 12) {
                        videoAppInterface.k0(new Object[]{533});
                    }
                    if (!f16.S2 && f16.z()) {
                        ThreadManager.getUIHandler().postDelayed(this.mZplanAvatarEasterEggTipsRunnable, 30000L);
                    }
                }
            }
            i3 = 3;
            videoChatRoomUIContoller = aVActivity.f74657h1;
            if (videoChatRoomUIContoller != null) {
            }
            if (ajVar != null) {
            }
            switchFilamentViewMode(f16, true);
            i16 = f16.f73070q2;
            if (i16 != -1) {
                videoAppInterface.k0(new Object[]{533});
                if (!f16.S2) {
                    ThreadManager.getUIHandler().postDelayed(this.mZplanAvatarEasterEggTipsRunnable, 30000L);
                }
            }
            videoAppInterface.k0(new Object[]{533});
            if (!f16.S2) {
            }
        } else if (videoLayerUI2 != null) {
            boolean N0 = videoLayerUI2.N0();
            f16.x0(true, false);
            videoLayerUI2.m0(1);
            if (f16.f73106z2) {
                aVActivity.U0.I(d16);
                f16.g0(true, false);
                QLog.d(TAG, 1, "[onNotifySelfZplanAvatarSwitch] onRequest_CloseCamera.");
            } else {
                videoLayerUI2.Z2();
                if ((com.tencent.avcore.camera.b.f77378u != this.mBeforeZplanAvatarPreviewWidth || com.tencent.avcore.camera.b.f77379v != this.mBeforeZplanAvatarPreviewHeight) && videoAppInterface != null) {
                    videoAppInterface.k0(new Object[]{32, Integer.valueOf(this.mBeforeZplanAvatarPreviewWidth), Integer.valueOf(this.mBeforeZplanAvatarPreviewHeight), Long.valueOf(d16)});
                }
            }
            if (!f16.O && !f16.f73102y2) {
                videoLayerUI2.W1(d16, str, 1);
            }
            if (f16.C2 == 1 || !f16.O) {
                z17 = false;
                sessionInfo = f16;
                videoLayerUI = videoLayerUI2;
            } else {
                z17 = false;
                sessionInfo = f16;
                videoLayerUI = videoLayerUI2;
                videoLayerUI2.g3(d16, aVActivity.f74660j0, 1, true, false, r.h0().j1(aVActivity.f74660j0));
            }
            cw.e.n(aVActivity.H0, 3028);
            if (sessionInfo.f73102y2 && N0) {
                aVActivity.J3(z17);
                videoLayerUI.Z = z17;
                changeAvatarLayout(z17, z17);
            }
            videoLayerUI.t3(z17, !AVAvatarResMgr.v().k());
            switchFilamentViewMode(sessionInfo, true);
            ThreadManager.getUIHandler().removeCallbacks(this.mZplanAvatarEasterEggTipsRunnable);
            cw.e.d(aVActivity.H0, 3032);
            cw.e.d(aVActivity.H0, 3026);
        }
        if (ajVar != null) {
            ajVar.i1(com.tencent.av.utils.e.d(), 33554431);
        }
    }
}
