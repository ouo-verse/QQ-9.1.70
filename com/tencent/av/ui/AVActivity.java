package com.tencent.av.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.av.broadcast.ResDownloadBroadcastReceiver;
import com.tencent.av.broadcast.SmallHomeBroadcastReceiver;
import com.tencent.av.business.manager.magicface.MagicDataReport;
import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.camera.api.ICameraManagerApi;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.doodle.DoodleLogic;
import com.tencent.av.doodle.DoodleUtils;
import com.tencent.av.foldable.FoldInfoUtils;
import com.tencent.av.q;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.ControlUIObserver;
import com.tencent.av.ui.api.IAVZplanAvatarBizApi;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller;
import com.tencent.av.ui.funchat.record.QavRecordReporter;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.av.ui.m;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.utils.TraeHelper;
import com.tencent.av.utils.VideoUtil;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.av.utils.ba;
import com.tencent.av.zplan.QAVControllerForZplan;
import com.tencent.avcore.camera.observe.CameraObserver;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.avcore.jni.audiodevice.TraeConstants;
import com.tencent.avcore.util.AVConstants;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.GeneralSettingActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.debug.api.IQQDebugApi;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzonestatus.QZoneVideoContactsFeedHelper;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.SensorMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.minigame.utils.GameActivityStatusWatcher;
import com.tencent.tbs.reader.IReaderConstants;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import fu.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.BaseFragmentActivity;
import org.light.CameraConfig;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AVActivity extends BaseFragmentActivity implements SensorEventListener, ISystemBarPropertyProvider {
    public aj I0;
    public VideoLayerUI J0;
    public ICameraManagerApi K0;
    public Integer P0;
    public Integer Q0;
    public Integer R0;
    private SensorManager V0;
    private Sensor W0;

    /* renamed from: c1, reason: collision with root package name */
    public ScreenRecordHelper f74647c1;

    /* renamed from: h1, reason: collision with root package name */
    public VideoChatRoomUIContoller f74657h1;

    /* renamed from: i0, reason: collision with root package name */
    final String f74658i0;

    /* renamed from: i1, reason: collision with root package name */
    public ResDownloadBroadcastReceiver f74659i1;

    /* renamed from: j1, reason: collision with root package name */
    public SmallHomeBroadcastReceiver f74661j1;

    /* renamed from: a0, reason: collision with root package name */
    public int f74642a0 = -1;

    /* renamed from: b0, reason: collision with root package name */
    public int f74644b0 = 0;

    /* renamed from: c0, reason: collision with root package name */
    int f74646c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    String f74648d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    int f74650e0 = -1;

    /* renamed from: f0, reason: collision with root package name */
    int f74652f0 = 0;

    /* renamed from: g0, reason: collision with root package name */
    int f74654g0 = 0;

    /* renamed from: h0, reason: collision with root package name */
    byte[] f74656h0 = null;

    /* renamed from: j0, reason: collision with root package name */
    public String f74660j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    String f74662k0 = null;

    /* renamed from: l0, reason: collision with root package name */
    String f74664l0 = null;

    /* renamed from: m0, reason: collision with root package name */
    String f74666m0 = null;

    /* renamed from: n0, reason: collision with root package name */
    String f74668n0 = null;

    /* renamed from: o0, reason: collision with root package name */
    String f74670o0 = null;

    /* renamed from: p0, reason: collision with root package name */
    String f74672p0 = null;

    /* renamed from: q0, reason: collision with root package name */
    String f74674q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    String f74676r0 = null;

    /* renamed from: s0, reason: collision with root package name */
    String f74677s0 = null;

    /* renamed from: t0, reason: collision with root package name */
    String f74678t0 = null;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f74679u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    boolean f74680v0 = true;

    /* renamed from: w0, reason: collision with root package name */
    boolean f74681w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    boolean f74682x0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f74683y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    boolean f74684z0 = false;
    boolean A0 = false;
    boolean B0 = false;
    long C0 = 0;
    long D0 = 0;
    int E0 = 0;
    int F0 = 0;
    boolean G0 = false;
    public VideoAppInterface H0 = null;
    Bitmap L0 = null;
    Bitmap M0 = null;
    QAVNotification N0 = null;
    h O0 = null;
    public int S0 = 0;
    BroadcastReceiver T0 = null;
    public ControlUIObserver U0 = new MyControlUIObserver();
    private com.tencent.av.ui.h X0 = null;
    private SmallScreenActivityPlugin Y0 = null;
    public GuideHelper Z0 = new GuideHelper();

    /* renamed from: a1, reason: collision with root package name */
    public boolean f74643a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    private final com.tencent.av.compat.a f74645b1 = new com.tencent.av.compat.a();

    /* renamed from: d1, reason: collision with root package name */
    private boolean f74649d1 = false;

    /* renamed from: e1, reason: collision with root package name */
    private boolean f74651e1 = false;

    /* renamed from: f1, reason: collision with root package name */
    boolean f74653f1 = true;

    /* renamed from: g1, reason: collision with root package name */
    private final Runnable f74655g1 = new Runnable() { // from class: com.tencent.av.ui.AVActivity.1
        @Override // java.lang.Runnable
        public void run() {
            VideoAppInterface videoAppInterface = AVActivity.this.H0;
            if (videoAppInterface == null) {
                return;
            }
            if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && com.tencent.av.n.e().f() != null) {
                com.tencent.av.n.e().f().j0(videoAppInterface.O(AVActivity.this.f74660j0));
            }
            yt.e.g(videoAppInterface.getCurrentAccountUin());
        }
    };

    /* renamed from: k1, reason: collision with root package name */
    CameraObserver f74663k1 = new e();

    /* renamed from: l1, reason: collision with root package name */
    boolean f74665l1 = true;

    /* renamed from: m1, reason: collision with root package name */
    private boolean f74667m1 = false;

    /* renamed from: n1, reason: collision with root package name */
    boolean f74669n1 = false;

    /* renamed from: o1, reason: collision with root package name */
    VideoObserver f74671o1 = new MyVideoObserver();

    /* renamed from: p1, reason: collision with root package name */
    boolean f74673p1 = false;

    /* renamed from: q1, reason: collision with root package name */
    GAudioUIObserver f74675q1 = new d();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class MyControlUIObserver extends ControlUIObserver {

        /* compiled from: P */
        /* loaded from: classes3.dex */
        class a implements Comparator<com.tencent.av.gaudio.c> {
            a() {
            }

            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(com.tencent.av.gaudio.c cVar, com.tencent.av.gaudio.c cVar2) {
                if (!cVar.f73829c && !cVar2.f73829c) {
                    return 0;
                }
                return 1;
            }
        }

        MyControlUIObserver() {
        }

        private void V(long j3, boolean z16) {
            String str;
            aj ajVar;
            int i3;
            String str2;
            int i16;
            if (!AVActivity.this.isDestroyed() && com.tencent.av.r.h0() != null) {
                SessionInfo f16 = com.tencent.av.n.e().f();
                if (z16) {
                    str = "onChangeUI_Normal2Meeting";
                } else {
                    str = "onChangeUI_DobuleAudio2MultiAudio";
                }
                String str3 = str;
                if (QLog.isColorLevel()) {
                    QLog.w(AVActivity.this.f74658i0, 2, "changeUIForDoubleToMulti, isBackground_Stop[" + AVActivity.this.H0.isBackgroundStop + "], ActivityState[" + AVActivity.this.c3() + "], getVideoAbilityLevel[" + com.tencent.av.r.h0().H0() + "], session[" + f16 + "], seq[" + j3 + "], from[" + str3 + "]");
                }
                AVActivity aVActivity = AVActivity.this;
                int i17 = aVActivity.f74644b0;
                String str4 = aVActivity.f74662k0;
                int i18 = aVActivity.f74650e0;
                aj ajVar2 = aVActivity.I0;
                if (ajVar2 != null && ajVar2.t() != null) {
                    AVActivity.this.I0.t().changeUIForDoubleToMulti(f16, j3, str3);
                }
                int i19 = f16.f73047l;
                if (i19 != 16 && i19 != 11) {
                    if (z16) {
                        AVActivity.this.checkVideoLayerUI();
                    }
                    if (AVActivity.this.J0 != null) {
                        int i26 = 4;
                        if (com.tencent.av.r.h0().H0() == 4 && com.tencent.av.utils.af.B() && !z16) {
                            i26 = 3;
                        }
                        AVActivity.this.U2(i26);
                        ajVar = null;
                        i3 = i18;
                        str2 = str4;
                        i16 = i17;
                        AVActivity.this.J0.g3(j3, f16.f73091w, 1, false, false, false);
                    } else {
                        ajVar = null;
                        i3 = i18;
                        str2 = str4;
                        i16 = i17;
                    }
                    aj ajVar3 = AVActivity.this.I0;
                    if (ajVar3 != null) {
                        ajVar3.X(j3);
                        AVActivity.this.I0 = ajVar;
                    }
                    AVActivity.this.l4(str3, z16);
                    if (z16 && f16.f73035i == 2) {
                        f16.f73035i = 1;
                        if (QLog.isColorLevel()) {
                            QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting video to audio .");
                        }
                    }
                    AVActivity aVActivity2 = AVActivity.this;
                    int i27 = f16.f73035i;
                    aVActivity2.f74644b0 = i27;
                    if (z16 && i27 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i("normal_2_meeting", 2, "onChangeUI_Normal2Meeting illegal session type.");
                        }
                        AVActivity.this.f74644b0 = 1;
                    }
                    if (!AVCoreSystemInfo.isNormalSharp()) {
                        AVActivity.this.K0.closeCamera(j3, true);
                        VideoLayerUI videoLayerUI = AVActivity.this.J0;
                        if (videoLayerUI != null) {
                            videoLayerUI.f3(j3, false, false);
                        }
                        f16.c0(j3, false);
                    }
                    DoodleLogic.b().h();
                    AVActivity.this.B3(j3);
                    AVActivity aVActivity3 = AVActivity.this;
                    aj ajVar4 = aVActivity3.I0;
                    if (ajVar4 != null) {
                        ajVar4.M0();
                    } else {
                        aVActivity3.T2();
                    }
                    QLog.w("normal_2_meeting", 1, "changeUIForDoubleToMulti end, oldSessionType[" + i16 + "], oldUinType[" + i3 + "], oldRelationId[" + str2 + "], mRelationId[" + AVActivity.this.f74662k0 + "], sessionInfo[" + f16 + "]");
                    return;
                }
                aj ajVar5 = AVActivity.this.I0;
                if (ajVar5 != null) {
                    ajVar5.e1(null);
                }
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void A(int i3, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("PtuResChecker", 2, "onCheckPtuResRet, [" + i3 + "," + z16 + "]");
            }
            if (AVActivity.this.I0 != null && z16 && uv.b.j(i3) && uv.b.h()) {
                AVActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.AVActivity.MyControlUIObserver.3
                    @Override // java.lang.Runnable
                    public void run() {
                        long d16 = com.tencent.av.utils.e.d();
                        AVActivity.this.I0.j1(d16);
                        AVActivity.this.I0.n1(d16);
                        QavPanel p16 = AVActivity.this.I0.p();
                        if (p16 != null) {
                            p16.E0();
                        }
                    }
                });
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void B() {
            AVActivity.this.I0.S(com.tencent.av.utils.e.d(), null);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void D(int i3, long j3) {
            if (QLog.isDevelopLevel()) {
                QLog.i("ChatRoomUtil", 4, "onNotify_ChatRoom_InputPanelChange, lastPanelState[" + i3 + "], seq[" + j3 + "]");
            }
            AVActivity.this.S2(j3, 1);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void E(long j3, int i3) {
            QLog.w(AVActivity.this.f74658i0, 1, "onNotify_MenuView_Changed, menuType[" + i3 + "], seq[" + j3 + "]");
            AVActivity.this.R2(j3);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void G(long j3, boolean z16, boolean z17, long j16) {
            aj ajVar;
            if (!AVActivity.this.isDestroyed() && (ajVar = AVActivity.this.I0) != null && !ajVar.E()) {
                boolean z18 = true;
                if (!z16 && !z17) {
                    AVActivity.this.I0.N0(true);
                    AVActivity.this.I0.c0();
                }
                if (z16 && z17) {
                    AVActivity.this.I0.N0(false);
                }
                if (z16 && !z17) {
                    AVActivity aVActivity = AVActivity.this;
                    aVActivity.Z0.n(j3, aVActivity, 2, 2);
                }
                AVActivity.this.A3(6503, Boolean.valueOf(z17), null);
                AVActivity aVActivity2 = AVActivity.this;
                if (z16 || z17) {
                    z18 = false;
                }
                aVActivity2.g4(j3, "onNotify_SwitchToolbarAnimation", z18);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void H() {
            AVActivity.this.G0 = true;
            com.tencent.av.n.e().f().H2 = true;
            QLog.i(AVActivity.this.f74658i0, 2, "onPreClickSmallHomeEntry");
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void I(long j3) {
            if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed()) {
                SessionInfo f16 = com.tencent.av.n.e().f();
                f16.U2 = f16.f73030h;
            }
            AVActivity.this.P3(j3);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void L(int i3) {
            AVActivity.this.Z2(i3);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void M(String str) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.A(str);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void N(long j3) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.H0(-1056L);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void O(boolean z16, long j3) {
            float f16;
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.f74642a0 == 4) {
                return;
            }
            ICameraManagerApi iCameraManagerApi = aVActivity.K0;
            if (iCameraManagerApi != null) {
                iCameraManagerApi.openCamera(j3);
            }
            AVActivity.this.checkVideoLayerUI();
            AVActivity aVActivity2 = AVActivity.this;
            if (aVActivity2.J0 != null) {
                aVActivity2.p3();
                if (com.tencent.av.n.e().f().f73106z2) {
                    AVActivity.this.J0.E2(j3, Boolean.valueOf(z16));
                } else {
                    AVActivity.this.J0.f3(j3, true, z16);
                }
                if (com.tencent.av.n.e().f().f73035i == 4 && !com.tencent.av.n.e().f().f73060o0) {
                    String currentAccountUin = AVActivity.this.H0.getCurrentAccountUin();
                    String G = AVActivity.this.H0.G(AVUtil.g(AVActivity.this.f74650e0), currentAccountUin, String.valueOf(com.tencent.av.n.e().f().P0));
                    if (AVActivity.this.J0.L0(currentAccountUin, 1)) {
                        f16 = 18.0f;
                    } else {
                        f16 = 12.0f;
                    }
                    AVActivity.this.J0.i3(currentAccountUin, 1, G, ba.dp2px(AVActivity.this.getApplicationContext(), f16), -1);
                    AVActivity aVActivity3 = AVActivity.this;
                    aVActivity3.J0.b3(j3, currentAccountUin, 1, aVActivity3.M0, true, true);
                }
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
            if (videoChatRoomUIContoller != null) {
                videoChatRoomUIContoller.v();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void P() {
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.I0 != null) {
                aVActivity.g4(-1050L, "onRequest_RefreshRecordBtn", !r1.I());
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:60:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x0305  */
        @Override // com.tencent.av.ui.ControlUIObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void Q(long j3, ArrayList<com.tencent.av.gaudio.c> arrayList, boolean z16) {
            String str;
            int i3;
            com.tencent.av.gaudio.c cVar;
            int i16;
            String str2;
            boolean z17;
            boolean z18;
            int i17;
            boolean z19;
            int i18;
            char c16;
            char c17;
            float f16;
            boolean z26;
            boolean z27;
            String str3;
            AVActivity aVActivity;
            int i19;
            long j16 = j3;
            ArrayList<com.tencent.av.gaudio.c> arrayList2 = arrayList;
            int i26 = AVActivity.this.f74642a0;
            if (i26 != 4 && i26 != 5 && i26 != 3) {
                String I0 = (arrayList2 == null || com.tencent.av.r.h0() == null || AVActivity.this.isDestroyed()) ? null : com.tencent.av.r.h0().I0(arrayList2);
                if (QLog.isColorLevel()) {
                    QLog.w(AVActivity.this.f74658i0, 1, "onRequest_ShowVideo, infoLogs[" + I0 + "], seq[" + j16 + "]");
                }
                AVActivity.this.checkVideoLayerUI();
                if (AVActivity.this.J0 != null && arrayList2 != null && com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed()) {
                    int H0 = com.tencent.av.r.h0().H0();
                    Collections.sort(arrayList2, new a());
                    if (QLog.isColorLevel()) {
                        QLog.w(AVActivity.this.f74658i0, 1, "onRequest_ShowVideo, after sort infoLogs[" + I0 + "], seq[" + j16 + "]");
                    }
                    int i27 = 0;
                    while (i27 < arrayList.size()) {
                        com.tencent.av.gaudio.c cVar2 = arrayList2.get(i27);
                        String a16 = com.tencent.av.utils.i.a(cVar2.f73827a);
                        int i28 = cVar2.f73828b;
                        boolean z28 = cVar2.f73829c;
                        boolean s26 = AVActivity.this.J0.s2(a16, i28);
                        String G = AVActivity.this.H0.G(AVUtil.g(AVActivity.this.f74650e0), a16, String.valueOf(com.tencent.av.n.e().f().P0));
                        if (!cVar2.f73830d) {
                            str = a16;
                            i3 = i28;
                            cVar = cVar2;
                            i16 = i27;
                            str2 = G;
                            z17 = false;
                            z18 = z28;
                            i17 = H0;
                        } else if (!a16.equals(AVActivity.this.H0.getCurrentAccountUin())) {
                            VideoLayerUI videoLayerUI = AVActivity.this.J0;
                            long j17 = cVar2.f73833g;
                            if (j17 == 5 || j17 == 14) {
                                z18 = z28;
                                z27 = true;
                            } else {
                                z18 = z28;
                                z27 = false;
                            }
                            cVar = cVar2;
                            i16 = i27;
                            str = a16;
                            z17 = false;
                            i17 = H0;
                            videoLayerUI.g3(j3, a16, i28, true, z18, z27);
                            if (!z18 || cVar.f73832f) {
                                str2 = G;
                                i3 = i28;
                            } else {
                                if (com.tencent.av.utils.i.e(G) > 20) {
                                    StringBuilder sb5 = new StringBuilder();
                                    str2 = G;
                                    sb5.append(com.tencent.av.utils.i.h(str2, 0, 20));
                                    sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                    str3 = sb5.toString();
                                } else {
                                    str2 = G;
                                    str3 = str2;
                                }
                                i3 = i28;
                                if (i3 == 2) {
                                    aVActivity = AVActivity.this;
                                    i19 = R.string.dbn;
                                } else {
                                    aVActivity = AVActivity.this;
                                    i19 = R.string.dbo;
                                }
                                String format = String.format(aVActivity.getString(i19), str3);
                                int i29 = i3 == 2 ? 1036 : 1037;
                                if (QLog.isColorLevel()) {
                                    QLog.d(AVActivity.this.f74658i0, 1, "onRequest_ShowVideo, will loading name[" + str2 + "]");
                                }
                                if (AVActivity.this.v3()) {
                                    AVActivity.this.I0.b1(i29, format);
                                } else {
                                    cw.e.p(AVActivity.this.H0, i29, format);
                                }
                            }
                        } else {
                            str = a16;
                            i3 = i28;
                            cVar = cVar2;
                            i16 = i27;
                            i17 = H0;
                            str2 = G;
                            z17 = false;
                            z18 = z28;
                            if (str.equals(AVActivity.this.H0.getCurrentAccountUin()) && i3 == 2) {
                                AVActivity.this.J0.e3(j3, true, z18);
                            } else {
                                AVActivity.this.K0.openCamera(j3);
                                AVActivity.this.J0.f3(j3, true, z18);
                                z19 = true;
                                if (z19) {
                                    AVActivity.this.p3();
                                    boolean z29 = cVar.f73830d;
                                    if (z29 || (z26 = cVar.f73829c)) {
                                        i18 = i3;
                                        c16 = 4;
                                        AVActivity aVActivity2 = AVActivity.this;
                                        aVActivity2.J0.b3(j3, str, i18, aVActivity2.M0, z29, cVar.f73829c);
                                    } else if (i17 != 4) {
                                        if (com.tencent.av.n.e().f().S0 == 2) {
                                            DataReport.T(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
                                        } else if (com.tencent.av.n.e().f().f73063p == 10) {
                                            DataReport.T(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
                                        } else {
                                            DataReport.T(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
                                        }
                                        AVActivity aVActivity3 = AVActivity.this;
                                        if (aVActivity3.L0 == null) {
                                            aVActivity3.L0 = ba.getBitmapFromResourceId(aVActivity3.getApplicationContext(), R.drawable.dbr);
                                        }
                                        AVActivity aVActivity4 = AVActivity.this;
                                        c16 = 4;
                                        i18 = i3;
                                        aVActivity4.J0.b3(j3, str, i3, aVActivity4.L0, cVar.f73830d, cVar.f73829c);
                                    } else {
                                        c16 = 4;
                                        i18 = i3;
                                        AVActivity aVActivity5 = AVActivity.this;
                                        aVActivity5.J0.b3(j3, str, i18, aVActivity5.M0, z29, z26);
                                    }
                                } else {
                                    i18 = i3;
                                    c16 = 4;
                                }
                                if (!s26 || com.tencent.av.n.e().f().f73060o0) {
                                    c17 = 3;
                                } else {
                                    if (z18) {
                                        c17 = 3;
                                        if (AVActivity.this.J0.o2() != 3) {
                                            f16 = 18.0f;
                                            AVActivity.this.J0.i3(str, i18, str2, ba.dp2px(AVActivity.this.getApplicationContext(), f16), -1);
                                            AVActivity.this.J0.j1(str, i18);
                                        }
                                    } else {
                                        c17 = 3;
                                    }
                                    f16 = 12.0f;
                                    AVActivity.this.J0.i3(str, i18, str2, ba.dp2px(AVActivity.this.getApplicationContext(), f16), -1);
                                    AVActivity.this.J0.j1(str, i18);
                                }
                                i27 = i16 + 1;
                                arrayList2 = arrayList;
                                H0 = i17;
                                j16 = j3;
                            }
                        }
                        z19 = z17;
                        if (z19) {
                        }
                        if (s26) {
                        }
                        c17 = 3;
                        i27 = i16 + 1;
                        arrayList2 = arrayList;
                        H0 = i17;
                        j16 = j3;
                    }
                    AVActivity aVActivity6 = AVActivity.this;
                    aVActivity6.J0.e1(aVActivity6.S0, false);
                    if (z16) {
                        AVActivity.this.J0.T0(true);
                    }
                }
                AVActivity aVActivity7 = AVActivity.this;
                aj ajVar = aVActivity7.I0;
                if (ajVar != null) {
                    ajVar.U0(j3, aVActivity7.S0);
                }
                if (AVActivity.this.K0 != null && com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && com.tencent.av.n.e().f().f73063p != 2) {
                    AVActivity aVActivity8 = AVActivity.this;
                    aVActivity8.K0.setRotation(aVActivity8.S0);
                }
                VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
                if (videoChatRoomUIContoller != null) {
                    videoChatRoomUIContoller.v();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "onRequest_ShowVideo ignore ");
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void R(long j3) {
            com.tencent.av.utils.c.a("switch_camera", "onRequest_SwitchCamera", 3, Long.valueOf(j3));
            ICameraManagerApi iCameraManagerApi = AVActivity.this.K0;
            if (iCameraManagerApi != null) {
                iCameraManagerApi.switchCamera(j3);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void S(long j3) {
            AVActivity.this.f4(j3);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void T(int i3, boolean z16, String str, int i16) {
            AVActivity.this.h3(i3, z16, str, i16);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void U() {
            long d16 = com.tencent.av.utils.e.d();
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (QLog.isColorLevel()) {
                QLog.i(AVActivity.this.f74658i0, 2, "onUpdateSmallHomeStatus mIsPeerInZplanHome: " + f16.J2);
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.p1(d16);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void a(int i3, long j3) {
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.I0 != null && !aVActivity.isDestroyed()) {
                AVActivity.this.I0.j0(i3, j3);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void d() {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.W();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void e(long j3, int i3, int i16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.d0(j3, i3, i16);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void f() {
            ViewGroup viewGroup = (ViewGroup) AVActivity.this.findViewById(R.id.a2f);
            if (viewGroup != null) {
                DoodleUtils.a(viewGroup);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void g(boolean z16) {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 1, "onChangeUI_ChildLockStateChange, lock[" + z16 + "], seq[" + d16 + "]");
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar.t() != null) {
                AVActivity.this.I0.t().updateRecordButton();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void h() {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.R0(true);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void i(ArrayList<com.tencent.av.gaudio.c> arrayList) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.Q(arrayList);
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
            if (videoChatRoomUIContoller != null) {
                videoChatRoomUIContoller.v();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void j() {
            if (com.tencent.av.r.h0().d1()) {
                com.tencent.av.r.h0().f3(false);
                AVActivity aVActivity = AVActivity.this;
                aVActivity.f74683y0 = true;
                aVActivity.finish();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void k(long j3) {
            V(j3, false);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void m(String str, int i3, String str2, int i16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.D0(str, i3, str2, i16);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void n(int i3, int i16, String str) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.E0(i3, i16, str);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void o(int i3) {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 1, "onChangeUI_MagicFacePlayStateChange, state[" + i3 + "], seq[" + d16 + "]");
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar.t() != null) {
                AVActivity.this.g4(d16, "onChangeUI_MagicFacePlayStateChange", !r7.I0.I());
                AVActivity.this.I0.t().updateRecordButton();
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void p(long j3, int i3, int i16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.e0(j3, i3, i16);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void q(long j3) {
            V(j3, true);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void r() {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.R0(false);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void s(int i3) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar.t() != null) {
                AVActivity.this.I0.t().receiveEffect(i3);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void t() {
            AVActivity.this.g4(-1048L, "onChangeUI_RecordStateChange", !r0.I0.I());
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void u() {
            AVActivity.this.R2(-1032L);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void v(boolean z16) {
            if (!z16) {
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.AVActivity.MyControlUIObserver.2
                    @Override // java.lang.Runnable
                    public void run() {
                        aj ajVar = AVActivity.this.I0;
                        if (ajVar == null) {
                            return;
                        }
                        ajVar.d1();
                    }
                }, 300L);
            } else {
                AVActivity.this.I0.B();
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
            if (videoChatRoomUIContoller == null) {
                return;
            }
            videoChatRoomUIContoller.z(z16);
            if (z16 && AVActivity.this.f74657h1.p()) {
                AVActivity.this.f74657h1.y(true);
                AVActivity.this.f74657h1.o(3);
            } else if (!z16 && !AVActivity.this.f74657h1.p() && AVActivity.this.f74657h1.r()) {
                AVActivity.this.f74657h1.y(false);
                AVActivity.this.f74657h1.A(0);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void w(int i3) {
            aj ajVar;
            int i16 = com.tencent.av.n.e().f().f73035i;
            if (i16 != 1 && i16 != 3 && !com.tencent.av.n.e().f().K() && (ajVar = AVActivity.this.I0) != null) {
                ajVar.f1(i3);
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void x() {
            if (QLog.isColorLevel()) {
                QLog.i(AVActivity.this.f74658i0, 2, "onChangeUI_quitDoubleScreenStatus");
            }
            AVActivity.this.J3(true);
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        protected void y(String str) {
            if (str != null) {
                if (str.equals("1")) {
                    if (!com.tencent.av.n.e().f().O0) {
                        AVActivity.this.C3(null);
                        if (!AVActivity.this.isResume()) {
                            com.tencent.av.n.e().f().a0(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (str.startsWith("START")) {
                    AVActivity.this.C3(str.substring(6));
                }
            }
        }

        @Override // com.tencent.av.ui.ControlUIObserver
        public void z(String str, String str2) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar.t() != null) {
                AVActivity.this.I0.t().receiveRecordMsg(str, str2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements VideoChatRoomUIContoller.e {
        a() {
        }

        @Override // com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.e
        public void a(boolean z16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.w(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f74704d;

        b(boolean z16) {
            this.f74704d = z16;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!this.f74704d) {
                boolean l3 = AVActivity.this.l3();
                if (l3) {
                    TraeHelper.Z();
                }
                QLog.d(AVActivity.this.f74658i0, 1, "checkQAVPermission curHasBluetoothPermission=" + l3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f74706d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f74707e;

        c(String str, long j3) {
            this.f74706d = str;
            this.f74707e = j3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            cw.e.d(AVActivity.this.H0, 1044);
            AVActivity.this.U2(2);
            MagicDataReport.b(com.tencent.av.r.h0().J(com.tencent.av.n.e().f().f73091w) + "");
            if (com.tencent.av.utils.e.k()) {
                QLog.w(AVActivity.this.f74658i0, 1, "qav_double_screen_notify, click[" + this.f74706d + "], seq[" + this.f74707e + "]");
            }
            if (!TextUtils.isEmpty(this.f74706d)) {
                new ControlUIObserver.d(this.f74707e, this.f74706d, false, 4).b(AVActivity.this.H0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class d extends GAudioUIObserver {
        d() {
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void g(long j3, long j16) {
            if (AVActivity.this.isDestroyed()) {
                return;
            }
            AVActivity aVActivity = AVActivity.this;
            aVActivity.Z0.n(j3, aVActivity, 4, 0);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void k(long j3, long j16) {
            if (AVActivity.this.isDestroyed()) {
                return;
            }
            AVActivity aVActivity = AVActivity.this;
            aVActivity.Z0.n(j3, aVActivity, 4, 0);
        }

        @Override // com.tencent.av.app.GAudioUIObserver
        protected void z(long j3, int i3, int i16) {
            if (AVActivity.this.isDestroyed()) {
                return;
            }
            long d16 = com.tencent.av.utils.e.d();
            AVActivity aVActivity = AVActivity.this;
            aVActivity.Z0.n(d16, aVActivity, 3, 2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class e extends CameraObserver {
        e() {
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void b(long j3, boolean z16) {
            aj ajVar;
            boolean z17;
            if (QLog.isDevelopLevel()) {
                String str = AVActivity.this.f74658i0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onAfterCloseCamera, success[");
                sb5.append(z16);
                sb5.append("], mControlUI[");
                if (AVActivity.this.I0 != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                sb5.append("], seq[");
                sb5.append(j3);
                sb5.append("]");
                QLog.w(str, 1, sb5.toString());
            }
            if (!AVActivity.this.isDestroyed() && (ajVar = AVActivity.this.I0) != null && !ajVar.E()) {
                AVActivity.this.I0.L(j3, z16);
                com.tencent.av.opengl.effects.m R = com.tencent.av.r.h0().R(false);
                if (R != null) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("EffectSettingUi", 1, "onHide clear state");
                    }
                    R.uninit();
                }
            }
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void c(long j3, boolean z16, int i3) {
            aj ajVar;
            String str;
            ICameraManagerApi iCameraManagerApi;
            QLog.w(AVActivity.this.f74658i0, 1, "onAfterOpenCamera, success[" + z16 + "], preSessionType[" + i3 + "], mRotationAngle[" + AVActivity.this.S0 + "], mShutCamera[" + AVActivity.this.f74684z0 + "], seq[" + j3 + "]");
            if (!AVActivity.this.isDestroyed() && (ajVar = AVActivity.this.I0) != null && !ajVar.E()) {
                AVActivity.this.I0.i1(j3, 33554431);
                AVActivity aVActivity = AVActivity.this;
                aVActivity.I0.U0(j3, aVActivity.S0);
                AVActivity.this.I0.M(j3, z16, i3);
                if (AVActivity.this.K0 != null) {
                    iu.a.c().h(AVActivity.this.K0.isFrontCamera());
                }
                AVActivity.this.checkVideoLayerUI();
                if (AVActivity.this.J0 != null) {
                    if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && com.tencent.av.n.e().f().f73063p != 2) {
                        AVActivity aVActivity2 = AVActivity.this;
                        aVActivity2.J0.e1(aVActivity2.S0, false);
                    } else {
                        AVActivity aVActivity3 = AVActivity.this;
                        aVActivity3.J0.P(aVActivity3.S0);
                    }
                    AVActivity aVActivity4 = AVActivity.this;
                    ICameraManagerApi iCameraManagerApi2 = aVActivity4.K0;
                    if (iCameraManagerApi2 != null) {
                        aVActivity4.J0.U0(j3, iCameraManagerApi2.isFrontCamera());
                    }
                }
                if (com.tencent.av.r.h0() != null) {
                    AVActivity aVActivity5 = AVActivity.this;
                    if (aVActivity5.K0 != null && !aVActivity5.isDestroyed() && com.tencent.av.n.e().f().f73063p != 2) {
                        AVActivity aVActivity6 = AVActivity.this;
                        aVActivity6.K0.setRotation(aVActivity6.S0);
                    }
                }
                if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && com.tencent.av.n.e().f() != null && com.tencent.av.n.e().f().f73098x2 && (iCameraManagerApi = AVActivity.this.K0) != null && !iCameraManagerApi.isFrontCamera()) {
                    VideoAppInterface videoAppInterface = AVActivity.this.H0;
                    if (videoAppInterface != null) {
                        videoAppInterface.k0(new Object[]{107, Long.valueOf(j3)});
                    }
                    com.tencent.av.n.e().f().R = true;
                }
                if (!z16) {
                    AVActivity.this.f74684z0 = true;
                    if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && com.tencent.av.n.e().f() != null) {
                        if (com.tencent.av.n.e().f().F()) {
                            str = "0X8004894";
                        } else if (com.tencent.av.n.e().f().f73039j == 1) {
                            str = "0X8004888";
                        } else if (com.tencent.av.n.e().f().f73039j == 2) {
                            str = "0X800488E";
                        } else {
                            str = "";
                        }
                        String str2 = str;
                        DataReport.T(null, "CliOper", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                    VideoAppInterface videoAppInterface2 = AVActivity.this.H0;
                    if (videoAppInterface2 != null) {
                        videoAppInterface2.k0(new Object[]{38, 2, Long.valueOf(j3)});
                    }
                }
            }
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void e(boolean z16) {
            com.tencent.av.opengl.effects.m R;
            com.tencent.av.opengl.effects.q qVar;
            ICameraManagerApi iCameraManagerApi;
            long d16 = com.tencent.av.utils.e.d();
            com.tencent.av.utils.c.a("switch_camera", "onAfterSwitchCamera", 3, Long.valueOf(d16));
            QLog.w(AVActivity.this.f74658i0, 1, "onAfterSwitchCamera, success[" + z16 + "], seq[" + d16 + "]");
            if (z16) {
                aj ajVar = AVActivity.this.I0;
                if (ajVar != null) {
                    ajVar.j(m.l.B, true);
                }
                AVActivity aVActivity = AVActivity.this;
                ICameraManagerApi iCameraManagerApi2 = aVActivity.K0;
                if (iCameraManagerApi2 != null) {
                    VideoLayerUI videoLayerUI = aVActivity.J0;
                    if (videoLayerUI != null) {
                        videoLayerUI.L2(iCameraManagerApi2.isFrontCamera());
                    }
                    iu.a.c().h(AVActivity.this.K0.isFrontCamera());
                }
                if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && (R = com.tencent.av.r.h0().R(false)) != null && (qVar = R.F) != null && (iCameraManagerApi = AVActivity.this.K0) != null) {
                    qVar.s(iCameraManagerApi.isFrontCamera());
                    return;
                }
                return;
            }
            AVActivity.this.P3(d16);
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void f(long j3) {
            aj ajVar;
            boolean z16;
            if (QLog.isDevelopLevel()) {
                String str = AVActivity.this.f74658i0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onBeforeCloseCamera, mControlUI[");
                if (AVActivity.this.I0 != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("], seq[");
                sb5.append(j3);
                sb5.append("]");
                QLog.w(str, 1, sb5.toString());
            }
            if (!AVActivity.this.isDestroyed() && (ajVar = AVActivity.this.I0) != null && !ajVar.E()) {
                AVActivity.this.I0.P(j3);
                if (AVActivity.this.I0.o() != null) {
                    AVActivity.this.I0.o().m(3);
                }
            }
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void h(long j3, boolean z16) {
            aj ajVar;
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 1, "onBeforeOpenCamera, bLastOpen[" + z16 + "], seq[" + j3 + "]");
            }
            if (!AVActivity.this.isDestroyed() && (ajVar = AVActivity.this.I0) != null && !ajVar.E()) {
                AVActivity.this.I0.i1(j3, 33554431);
            }
        }

        @Override // com.tencent.avcore.camera.observe.CameraObserver
        protected void i() {
            com.tencent.av.utils.c.a("switch_camera", "onBeforeSwitchCamera", 3, new Object[0]);
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.j(m.l.B, false);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class f implements Comparator<com.tencent.av.gaudio.c> {
        f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.tencent.av.gaudio.c cVar, com.tencent.av.gaudio.c cVar2) {
            if (!cVar.f73829c && !cVar2.f73829c) {
                return 0;
            }
            return 1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class g extends BroadcastReceiver {
        g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra;
            if (intent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS") && (stringExtra = intent.getStringExtra("reason")) != null && com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && stringExtra.equals(GameActivityStatusWatcher.InnerRecevier.SYSTEM_DIALOG_REASON_HOME_KEY)) {
                if (com.tencent.av.n.e().f().f73035i == 4) {
                    int i3 = AVActivity.this.f74650e0;
                    if (i3 == 3000) {
                        if (com.tencent.av.n.e().f().N) {
                            DataReport.T(null, "CliOper", "", "", "0X80041BB", "0X80041BB", 0, 0, "", "", "", "");
                        } else {
                            DataReport.T(null, "CliOper", "", "", "0X80041BE", "0X80041BE", 0, 0, "", "", "", "");
                        }
                    } else if (i3 == 1) {
                        if (com.tencent.av.n.e().f().N) {
                            if (com.tencent.av.n.e().f().f73063p == 10) {
                                DataReport.T(null, "CliOper", "", "", "0X800593E", "0X800593E", 0, 0, "", "", "", "");
                            } else {
                                DataReport.T(null, "CliOper", "", "", "0X80046E8", "0X80046E8", 0, 0, "", "", "", "");
                            }
                        } else if (com.tencent.av.n.e().f().O) {
                            if (com.tencent.av.n.e().f().f73063p == 10) {
                                DataReport.T(null, "CliOper", "", "", "0X8005941", "0X8005941", 0, 0, "", "", "", "");
                            } else {
                                DataReport.T(null, "CliOper", "", "", "0X80046EB", "0X80046EB", 0, 0, "", "", "", "");
                            }
                        }
                    }
                }
                if (AVActivity.this.A0) {
                    if (com.tencent.av.n.e().f().N) {
                        DataReport.T(null, "CliOper", "", "", "0X8005216", "0X8005216", 0, 0, "", "", "", "");
                    } else {
                        DataReport.T(null, "CliOper", "", "", "0X8005219", "0X8005219", 0, 0, "", "", "", "");
                    }
                }
                if (AVActivity.this.Y0 != null) {
                    AVActivity.this.Y0.e(AVActivity.this.isResume());
                }
                com.tencent.av.r.h0().L3("backgroundReason", "1");
                q.a.f74207a = "1";
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class h extends com.tencent.av.ui.e {

        /* renamed from: i, reason: collision with root package name */
        private final WeakReference<AVActivity> f74713i;

        public h(AVActivity aVActivity, int i3) {
            super(aVActivity.getApplicationContext(), i3);
            this.f74713i = new WeakReference<>(aVActivity);
        }

        @Override // com.tencent.av.ui.e
        public void d(int i3, boolean z16) {
            long d16 = com.tencent.av.utils.e.d();
            AVActivity aVActivity = this.f74713i.get();
            if (aVActivity == null) {
                return;
            }
            if (aVActivity.S0 != i3) {
                QLog.d(aVActivity.f74658i0, 1, "onVideoOrientationChanged, mRotationAngle[" + aVActivity.S0 + "->" + i3 + "], seq[" + d16 + "], isFinishing[" + aVActivity.isFinishing() + "]");
            }
            if (aVActivity.isFinishing()) {
                return;
            }
            if (i3 != 0 && i3 != 90 && i3 != 180 && i3 != 270) {
                aVActivity.j3(d16, 270);
            } else {
                aVActivity.j3(d16, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class onWindowFocusChangedRunnable implements Runnable {
        onWindowFocusChangedRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QLog.isDevelopLevel()) {
                QLog.d(AVActivity.this.f74658i0, 4, "onWindowFocusChangedRunnable, nfonWindowFocus[" + AVActivity.this.f74665l1 + "->true]");
            }
            AVActivity.this.f74665l1 = true;
        }
    }

    public AVActivity() {
        this.mIsShadow = false;
        this.f74658i0 = "AVActivity_" + com.tencent.av.utils.e.d();
    }

    private void E3(String str, String str2) {
        AVCoreLog.printAllUserLog(this.f74658i0, "onVideoProcessError: " + str + " exit...");
        QQToast.makeText(super.getBaseContext(), super.getString(R.string.ico) + " " + str2, 0).show();
        this.f74683y0 = true;
        sendBroadcast(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        finish();
    }

    private void K3() {
        Intent intent = super.getIntent();
        if (intent != null && TextUtils.equals("SmallScreen", intent.getStringExtra("Fromwhere"))) {
            return;
        }
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(this, "em_bas_av_call_interface");
        HashMap hashMap = new HashMap();
        int i3 = 3;
        if (!this.A0) {
            int i16 = this.f74644b0;
            if (i16 != 1 && i16 != 3) {
                i3 = 2;
                if (i16 != 2 && i16 != 4) {
                    i3 = 0;
                }
            } else {
                i3 = 1;
            }
        }
        hashMap.put("room_type", Integer.valueOf(i3));
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16 != null) {
            String str = f16.f73091w;
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("to_uin", Long.valueOf(str));
            }
        }
        VideoReport.setPageParams(this, new PageParams(hashMap));
        VideoReport.setPageReportPolicy(this, PageReportPolicy.REPORT_ALL);
    }

    private void Q3() {
        Intent intent = super.getIntent();
        if (intent == null) {
            QLog.d(this.f74658i0, 1, "restoreSpeakerStatus-->can not get intent");
            return;
        }
        if (intent.getBooleanExtra("needRestoreSpeaker", false) && com.tencent.av.r.h0() != null && !isDestroyed() && this.I0 != null) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (f16 != null && f16.I0 != intent.getBooleanExtra("isSpeakerOn", false)) {
                this.I0.F0();
                QLog.d(this.f74658i0, 1, "restoreSpeakerStatus.");
                return;
            } else {
                QLog.d(this.f74658i0, 1, "do not Need restoreSpeakerStatus.");
                return;
            }
        }
        QLog.d(this.f74658i0, 1, "restoreSpeakerStatus error null");
    }

    private boolean R3(Intent intent) {
        String stringExtra = intent.getStringExtra("Fromwhere");
        if (stringExtra != null && stringExtra.compareTo("AVNotification") == 0) {
            return true;
        }
        return false;
    }

    private void S3(final Intent intent) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.AVActivity.16
            @Override // java.lang.Runnable
            public void run() {
                if (!AVActivity.this.isDestroyed()) {
                    AVActivity.this.sendBroadcast(intent);
                }
            }
        }, 16, null, true);
    }

    static void Y2(Activity activity) {
        LiuHaiUtils.initLiuHaiProperty(activity);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            int notchInScreenHeight = LiuHaiUtils.getNotchInScreenHeight(activity);
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(activity);
            QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, notchheight[" + notchInScreenHeight + "], statusBarHeight[" + statusBarHeight + "]");
            if (LiuHaiUtils.enableNotch(activity)) {
                if (QLog.isDevelopLevel()) {
                    QLog.w(ImmersiveUtils.TAG, 1, "initLiuHaiProperty, onAttachedToWindow, enableNotch");
                }
            } else if (Build.MANUFACTURER.equalsIgnoreCase("Lenovo")) {
                ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).enableLenovoNotch();
            }
        }
    }

    private String b3(Intent intent) {
        String stringExtra;
        int intExtra = intent.getIntExtra("uinType", -1);
        int intExtra2 = intent.getIntExtra("MultiAVType", -1);
        int uinType2AVRelationType = ba.uinType2AVRelationType(intExtra);
        if (uinType2AVRelationType == 0) {
            uinType2AVRelationType = 3;
        }
        if (intExtra == 1006) {
            stringExtra = intent.getStringExtra("toMobile");
        } else if (uinType2AVRelationType != 1 && uinType2AVRelationType != 2) {
            stringExtra = intent.getStringExtra("uin");
        } else {
            stringExtra = intent.getStringExtra("GroupId");
        }
        int i3 = 100;
        if (intent.getBooleanExtra("isDoubleVideoMeeting", false)) {
            stringExtra = intent.getStringExtra("GroupId");
            intExtra = 0;
            uinType2AVRelationType = 100;
        }
        String stringExtra2 = intent.getStringExtra("Fromwhere");
        if (uinType2AVRelationType == 3 && TextUtils.equals("AIOShareScreen", stringExtra2)) {
            stringExtra = intent.getStringExtra("uin");
        } else {
            i3 = uinType2AVRelationType;
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f74658i0, 2, "genSessionIdFromIntent, [" + intExtra + "," + i3 + "," + stringExtra + "]");
        }
        if (intExtra != -1 && !TextUtils.isEmpty(stringExtra)) {
            if (i3 == 1 && intExtra2 == 17) {
                i3 = 11;
            }
            return com.tencent.av.n.b(i3, stringExtra, new int[0]);
        }
        if (QLog.isColorLevel()) {
            QLog.e(this.f74658i0, 2, "genSessionIdFromIntent error: uinType " + intExtra + ", relationId " + stringExtra);
            return null;
        }
        return null;
    }

    private void b4() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.AVActivity.17
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && com.tencent.av.n.e().f() != null) {
                    z16 = com.tencent.av.n.e().f().F();
                } else {
                    z16 = false;
                }
                if (x.g(BaseApplication.getContext()) && AVActivity.this.isInOpenState() && !z16) {
                    aj ajVar = AVActivity.this.I0;
                    if (ajVar != null && ajVar.m() != null) {
                        AVActivity.this.I0.m().enableOrientation();
                        return;
                    }
                    return;
                }
                AVActivity.this.a4();
            }
        }, 16, null, true);
    }

    private void c4(long j3) {
        if (this.f74667m1) {
            return;
        }
        this.f74667m1 = true;
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.z0(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f4(long j3) {
        aj ajVar;
        if (!isDestroyed() && (ajVar = this.I0) != null && !ajVar.E()) {
            SessionInfo f16 = com.tencent.av.n.e().f();
            int i3 = f16.f73035i;
            if (QLog.isDevelopLevel()) {
                QLog.w(this.f74658i0, 4, "switchToolbar, sessionType[" + i3 + "], isInviting[" + f16.K() + "], isToolBarDisplay[" + this.I0.I() + "|" + this.I0.J() + "], curMenu[" + this.I0.p().K() + "], seq[" + j3 + "]");
            }
            if ((i3 == 1 || i3 == 3) && !f16.f73102y2 && !f16.f73098x2) {
                if (this.I0.p().v0(1) || this.I0.p().v0(6) || this.I0.p().v0(3) || this.I0.p().v0(5)) {
                    this.I0.p().X0(j3, 0, true);
                }
                if (!this.I0.J() || !this.I0.I()) {
                    this.I0.c1(0);
                    return;
                }
                return;
            }
            if (f16.K()) {
                if (i3 == 2) {
                    if (this.I0.p().v0(1) || this.I0.p().v0(6) || this.I0.p().v0(3) || this.I0.p().v0(5)) {
                        this.I0.p().X0(j3, 0, true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.I0.D()) {
                return;
            }
            if (f16.Y2 && !this.I0.I()) {
                VideoAppInterface videoAppInterface = this.H0;
                if (videoAppInterface != null) {
                    cw.e.o(videoAppInterface, 1022, R.string.dh9);
                    return;
                }
                return;
            }
            if (this.I0.p().v0(6)) {
                this.I0.p().X0(j3, 0, false);
                return;
            }
            if (this.I0.p().v0(3) && isInFoldingMode()) {
                this.I0.p().X0(j3, 0, false);
                return;
            }
            if (!x3()) {
                if (!this.I0.I() && (this.I0.p().v0(1) || this.I0.p().v0(3) || this.I0.p().v0(5))) {
                    this.I0.p().X0(j3, 0, false);
                }
                g4(j3, "switchToolbar", this.I0.I());
                this.I0.c1(0);
                return;
            }
            if (!this.I0.I()) {
                g4(j3, "SwitchToolbar2", this.I0.I());
                this.I0.c1(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(int i3, boolean z16, String str, int i16) {
        VideoLayerUI videoLayerUI;
        SessionInfo sessionInfo;
        if (this.I0 != null && (videoLayerUI = this.J0) != null) {
            if (i3 == 0) {
                if (com.tencent.av.r.h0() != null && !isDestroyed()) {
                    sessionInfo = com.tencent.av.n.e().f();
                } else {
                    sessionInfo = null;
                }
                int i17 = 8;
                boolean z17 = true;
                if (sessionInfo != null && !VideoUtil.f(this.H0) && (sessionInfo.O1 == 4 || (sessionInfo.f73045k1.size() == 1 && sessionInfo.O1 == 3))) {
                    aj ajVar = this.I0;
                    if (z16) {
                        i17 = 0;
                    }
                    ajVar.h1(i17);
                    VideoLayerUI videoLayerUI2 = this.J0;
                    if (!com.tencent.av.utils.af.A() || z16) {
                        z17 = false;
                    }
                    videoLayerUI2.h1(i3, z17);
                } else {
                    this.I0.h1(8);
                    this.J0.h1(i3, true);
                }
                if (!TextUtils.isEmpty(str)) {
                    this.I0.J0(str);
                }
                if (i16 >= -1) {
                    this.I0.g1(i16);
                    return;
                }
                return;
            }
            videoLayerUI.h1(i3, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInOpenState() {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.m() != null && this.I0.m().isInOpenState()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k4() {
        int i3 = this.f74650e0;
        if (i3 == 1024 || i3 == 1025) {
            String G = this.H0.G(i3, this.f74660j0, this.f74672p0);
            QLog.d(this.f74658i0, 1, "[updateCRMTempChatNick] mPeerName=" + this.f74664l0 + " mUinType=" + this.f74650e0 + " mPeerUin=" + this.f74660j0 + " mExtraUi=" + this.f74672p0 + " curNickName=" + G);
            if (TextUtils.isEmpty(this.f74664l0) || !this.f74664l0.equals(G)) {
                this.f74664l0 = G;
            }
            if (!TextUtils.isEmpty(this.f74664l0)) {
                com.tencent.av.n.e().f().f73099y = this.f74664l0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l3() {
        boolean z16;
        boolean z17;
        boolean z18;
        if (checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_SCAN) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_CONNECT) == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (checkSelfPermission(QQPermissionConstants.Permission.BLUETOOTH_ADVERTISE) == 0) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && z17 && z18) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o4(String str) {
        if (com.tencent.av.r.h0() != null && !isDestroyed() && com.tencent.av.utils.e.f77110b) {
            com.tencent.av.n.e().f().f73028g2 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p3() {
        if (this.M0 == null) {
            this.M0 = ba.getBitmapFromResourceId(getApplicationContext(), R.drawable.d_0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z3(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i(this.f74658i0, 2, "handleEnterResult result " + z16);
        }
        this.G0 = z16;
        if (com.tencent.av.r.h0() != null && !isDestroyed()) {
            com.tencent.av.n.e().f().H2 = z16;
        }
    }

    protected void A3(Integer num, Object obj, Object obj2) {
        AVCoreLog.printColorLog(this.f74658i0, "notifyEvent :" + num + "|" + obj + "|" + obj2);
        this.H0.k0(new Object[]{num, obj, obj2});
    }

    void B3(long j3) {
        SessionInfo f16 = com.tencent.av.n.e().f();
        QLog.w(this.f74658i0, 1, "avideo onCreateUI, SessionType[" + f16.f73035i + "], multiAVType[" + f16.f73063p + "], seq[" + j3 + "]");
        if (this.K0 == null) {
            ICameraManagerApi a16 = com.tencent.av.camera.b.a(this);
            this.K0 = a16;
            a16.addObserver(this.f74663k1);
            this.K0.setCameraListener(com.tencent.av.r.h0().I());
        }
        if (this.f74644b0 == 0) {
            QLog.i(this.f74658i0, 2, "onCreateUI, SessionType[" + this.f74644b0 + "], isDoubleMeeting[" + this.A0 + "]");
            if (this.A0) {
                this.f74644b0 = 1;
            }
        }
        int i3 = this.f74644b0;
        if (i3 == 2 || i3 == 4) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.AVActivity.4
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(AVActivity.this.f74658i0, 2, "OnCreateUI --> init EffectCtrlBase");
                    }
                    com.tencent.av.r.h0().R(true);
                }
            }, 16, null, true);
        }
        if (this.A0 && (this.I0 == null || this.f74644b0 == 2)) {
            this.I0 = new aj(this.H0, this, this.U0, 100);
            this.f74644b0 = f16.f73035i;
        } else if (this.I0 == null || this.f74644b0 == 2) {
            int i16 = this.f74644b0;
            if (i16 != 1 && i16 != 2) {
                if (i16 == 3 || i16 == 4) {
                    int i17 = f16.f73063p;
                    if (i17 != 10 && i17 != 17) {
                        this.I0 = new aj(this.H0, this, this.U0, 2);
                    } else {
                        this.I0 = new aj(this.H0, this, this.U0, 1);
                    }
                }
            } else {
                this.I0 = new aj(this.H0, this, this.U0, 3);
            }
        }
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.V();
            if (this.f74650e0 == 9500) {
                this.I0.a(m.l.f76071q, com.tencent.av.r.h0().l1(), R.drawable.da8);
                if (!com.tencent.av.r.h0().k1()) {
                    this.I0.p().H0(true, 0, false);
                }
            }
        }
        Q3();
        new Handler().post(new Runnable() { // from class: com.tencent.av.ui.AVActivity.5
            @Override // java.lang.Runnable
            public void run() {
                SessionInfo f17;
                VideoAppInterface videoAppInterface = AVActivity.this.H0;
                if (videoAppInterface != null && videoAppInterface.z("BEAUTY_SKIN") > 0 && (f17 = com.tencent.av.n.e().f()) != null) {
                    f17.Y = true;
                }
            }
        });
        K3();
    }

    public void BtnOnClick(View view) {
        long d16 = com.tencent.av.utils.e.d();
        QLog.d(this.f74658i0, 1, "BtnOnClick, id[" + m.a(view.getId()) + "], nfonWindowFocus[" + this.f74665l1 + "], seq[" + d16 + "]");
        if (!this.f74665l1) {
            return;
        }
        if (view.getId() == m.l.f76073s || view.getId() == m.l.f76074t) {
            X3(true);
        }
        aj ajVar = this.I0;
        if (ajVar != null) {
            if (ajVar.D()) {
                this.I0.R(d16, view);
                return;
            }
            this.I0.H0(d16);
            DataReport.P(view.getId());
            this.I0.R(d16, view);
            V2(d16);
        }
    }

    public void C3(String str) {
        VideoLayerUI videoLayerUI = this.J0;
        if (videoLayerUI != null && videoLayerUI.N0()) {
            return;
        }
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f74658i0, 1, "onNeedChangeDoubleScreenMode, id[" + str + "], seq[" + d16 + "], hasChangeDoubleScreen[" + com.tencent.av.n.e().f().O0 + "]");
        if (!com.tencent.av.n.e().f().O0) {
            com.tencent.av.n.e().f().a0(true);
            U2(2);
            cw.e.n(this.H0, 1043);
            return;
        }
        cw.e.k(this.H0, 1044, null, new c(str, d16));
    }

    public void D3(final int i3, final boolean z16, final String str, final int i16) {
        this.H0.M().post(new Runnable() { // from class: com.tencent.av.ui.AVActivity.15
            @Override // java.lang.Runnable
            public void run() {
                AVActivity.this.h3(i3, z16, str, i16);
            }
        });
    }

    public void F3(long j3, int i3, int i16) {
        if (i3 == m.l.A && i16 == 0) {
            this.Z0.n(j3, this, 1, 0);
        }
    }

    void G3(long j3) {
        SmallScreenActivityPlugin smallScreenActivityPlugin;
        boolean z16;
        if (com.tencent.av.r.h0() != null && !isDestroyed()) {
            d4();
            if (this.J0 != null) {
                SmallScreenActivityPlugin smallScreenActivityPlugin2 = this.Y0;
                if (smallScreenActivityPlugin2 == null || smallScreenActivityPlugin2.b()) {
                    if (com.tencent.av.n.e().f().f73035i == 4) {
                        ArrayList<com.tencent.av.gaudio.c> arrayList = com.tencent.av.n.e().f().f73045k1;
                        for (int i3 = 0; i3 < arrayList.size(); i3++) {
                            com.tencent.av.gaudio.c cVar = arrayList.get(i3);
                            String a16 = com.tencent.av.utils.i.a(cVar.f73827a);
                            int i16 = cVar.f73828b;
                            long j16 = cVar.f73833g;
                            if (j16 != 5 && j16 != 14) {
                                z16 = false;
                            } else {
                                z16 = true;
                            }
                            if (!a16.equals(this.H0.getCurrentAccountUin())) {
                                this.J0.g3(j3, a16, i16, false, false, z16);
                            }
                        }
                    }
                    this.K0.closeCamera(j3, false);
                    this.J0.f3(j3, false, false);
                }
                this.J0.W0();
            }
            aj ajVar = this.I0;
            if (ajVar != null) {
                ajVar.l0(j3);
                if (this.I0.m() != null) {
                    this.I0.m().onStop();
                }
            }
            h4();
            com.tencent.av.r.h0().L2(true);
            com.tencent.av.r.h0().K2(false);
            if (!this.G0 && !com.tencent.av.n.e().f().I2 && (smallScreenActivityPlugin = this.Y0) != null) {
                smallScreenActivityPlugin.f(j3, this.f74683y0);
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = this.f74657h1;
            if (videoChatRoomUIContoller != null) {
                videoChatRoomUIContoller.v();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void H3(long j3) {
        String str;
        String str2;
        boolean z16;
        String str3;
        int i3;
        String stringExtra;
        String str4;
        String str5;
        int uinType2AVRelationType;
        boolean z17;
        String str6;
        String str7;
        String str8;
        int i16;
        if (QLog.isColorLevel()) {
            QLog.d(this.f74658i0 + "|VideoNodeManager", 2, "processExtraData, seq[" + j3 + "]");
        }
        Intent intent = super.getIntent();
        if (intent == null) {
            QLog.d(this.f74658i0, 1, "processExtraData-->can not get intent");
            return;
        }
        com.tencent.av.utils.e.m("AVActivity.processExtraData", intent.getExtras());
        int intExtra = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        SessionInfo f16 = com.tencent.av.n.e().f();
        int i17 = f16.f73035i;
        String stringExtra2 = intent.getStringExtra("Fromwhere");
        boolean booleanExtra = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        l4("processExtraData", booleanExtra);
        if (!"AVNotification".equals(stringExtra2)) {
            str = "processExtraData";
            str2 = "AVNotification";
            z16 = booleanExtra;
            str3 = stringExtra2;
            i3 = i17;
            if ("AV_INVITE_HALF_SCREEN".equals(str3)) {
                this.f74653f1 = false;
            }
        } else {
            int i18 = f16.f73043k;
            if ((i18 != 2 && i18 != 13) || intExtra == 1 || intExtra == 2) {
                str = "processExtraData";
                str2 = "AVNotification";
                z16 = booleanExtra;
                str3 = stringExtra2;
                i3 = i17;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(this.f74658i0, 2, "Close Double Video Meeting. --> QAVNotification to MultiVideo");
                }
                if (!f16.f73060o0) {
                    str = "processExtraData";
                    str2 = "AVNotification";
                    z16 = booleanExtra;
                    str3 = stringExtra2;
                    i3 = i17;
                    com.tencent.av.r.h0().g(j3, f16.f73091w, 1, true);
                    com.tencent.av.r.h0().r(f16.f73091w, 230);
                    com.tencent.av.r.h0().j2(230);
                } else {
                    str = "processExtraData";
                    str2 = "AVNotification";
                    z16 = booleanExtra;
                    str3 = stringExtra2;
                    i3 = i17;
                    long longValue = Long.valueOf(f16.f73091w).longValue();
                    com.tencent.av.r.h0().P0(j3, 3, longValue);
                    com.tencent.av.r.h0().o(j3, longValue, 1);
                }
            }
            if (f16.f73067q == 1) {
                if (f16.f73063p == 10) {
                    DataReport.T(null, "CliOper", "", "", "0X8005930", "0X8005930", 0, 0, "", "", "", "");
                } else {
                    DataReport.T(null, "CliOper", "", "", "0X80046D7", "0X80046D7", 0, 0, "", "", "", "");
                }
            }
            if (z16) {
                DataReport.T(null, "CliOper", "", "", "0X8005209", "0X8005209", 0, 0, "", "", "", "");
            }
        }
        if (intExtra == 0) {
            AVCoreLog.printAllUserLog(this.f74658i0, "processExtraData-->can not get session type in intent.");
            ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1015L);
            finish();
            return;
        }
        if (intExtra != 1 && intExtra != 2) {
            if (intExtra != 3 && intExtra != 4) {
                str4 = str2;
                stringExtra = null;
                if (str4.equals(str3)) {
                    if (intExtra != 1 && intExtra != 2) {
                        if (intExtra == 3 || intExtra == 4) {
                            if (z16) {
                                stringExtra = f16.f73091w;
                            } else {
                                stringExtra = String.valueOf(com.tencent.av.r.h0().X());
                            }
                        }
                    } else {
                        stringExtra = f16.f73091w;
                    }
                }
                if (stringExtra != null) {
                    AVCoreLog.printAllUserLog(this.f74658i0, "processExtraData-->can not get uin in intent.");
                    ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                    finish();
                    return;
                }
                int i19 = i3;
                if (i19 != 1 && i19 != 2) {
                    if (i19 != 3 && i19 != 4) {
                        if (QLog.isColorLevel()) {
                            QLog.d(this.f74658i0, 2, "original session type is none");
                        }
                        str5 = null;
                        uinType2AVRelationType = 0;
                    } else {
                        str5 = String.valueOf(com.tencent.av.r.h0().X());
                        uinType2AVRelationType = com.tencent.av.r.h0().b0();
                        if (str5 == null) {
                            AVCoreLog.printAllUserLog(this.f74658i0, "can not get the original group uin");
                            ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                            finish();
                            return;
                        }
                    }
                } else {
                    str5 = f16.f73091w;
                    uinType2AVRelationType = ba.uinType2AVRelationType(f16.f73067q);
                    if (str5 == null) {
                        AVCoreLog.printAllUserLog(this.f74658i0, "can not get the original peeruin");
                        ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                        finish();
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(this.f74658i0, 2, "processExtraData-->IntentSessionType=" + intExtra + ", OriginalSessionType=" + i19 + ", IntentUin=" + stringExtra);
                }
                if (str5 != null && QLog.isColorLevel()) {
                    QLog.d(this.f74658i0, 2, "processExtraData-->OriginalUin=" + str5 + ", originalRelationType=" + uinType2AVRelationType);
                }
                f16.I2 = getIntent().getBooleanExtra("needNotifyHangupEvent", false);
                f16.K2 = getIntent().getStringExtra("visitUin");
                if (i19 == 0) {
                    I3(j3);
                } else if (i19 != 3 && i19 != 4) {
                    if ((i19 == 1 || i19 == 2) && (intExtra == 1 || intExtra == 2)) {
                        int intExtra2 = intent.getIntExtra("uinType", -1);
                        if (intExtra2 != -1 && intExtra2 != f16.f73067q) {
                            if (QLog.isColorLevel()) {
                                QLog.w(this.f74658i0, 2, "New Double Video in , newUinType !=-1 && newUinType != oldUinType , close old video.");
                            }
                            com.tencent.av.r.h0().p(false, 203, f16.f73063p);
                            com.tencent.av.r.h0().j2(203);
                            aj ajVar = this.I0;
                            if (ajVar != null) {
                                ajVar.X(j3);
                                this.I0 = null;
                            }
                            String str9 = f16.f73091w;
                            String b16 = com.tencent.av.n.b(3, str9, new int[0]);
                            SessionInfo i26 = com.tencent.av.n.e().i(b16);
                            if (i26 == null) {
                                AVCoreLog.printAllUserLog(this.f74658i0, "Can not get SessionInfo : SessionId = " + b16);
                                finish();
                                return;
                            }
                            String str10 = i26.f73103z;
                            int i27 = f16.f73067q;
                            String str11 = i26.Y0;
                            com.tencent.av.r.h0().r(str9, 231);
                            com.tencent.av.r.h0().j2(231);
                            com.tencent.av.r.h0().C2("AVActivity.processExtraData", b16, i27, str9, str10, 0, str11, false, true);
                            I3(j3);
                            String b17 = com.tencent.av.n.b(3, this.f74660j0, new int[0]);
                            SessionInfo a16 = com.tencent.av.n.e().a(b17, false);
                            a16.G = true;
                            a16.n0(str, 2);
                            a16.f73073r1 = false;
                            if (!b17.equals(this.f74648d0)) {
                                this.f74648d0 = b17;
                            }
                        } else {
                            String str12 = str;
                            if (QLog.isColorLevel()) {
                                QLog.w(this.f74658i0, 2, "New Double Video in , newUinType !=-1 && newUinType == oldUinType , resume old video");
                            }
                            this.f74644b0 = f16.f73035i;
                            l4(str12, f16.f73060o0);
                            this.f74650e0 = f16.f73067q;
                            this.f74660j0 = f16.f73091w;
                            this.f74664l0 = f16.f73099y;
                            this.f74677s0 = f16.E;
                            this.f74652f0 = f16.B0;
                            this.f74678t0 = f16.D0;
                            this.f74654g0 = f16.C0;
                            this.f74672p0 = f16.f73103z;
                            this.f74666m0 = f16.B;
                            this.f74679u0 = f16.G;
                            this.f74680v0 = f16.M0;
                            this.f74681w0 = f16.V;
                            this.f74682x0 = f16.f73084u0;
                        }
                    }
                } else {
                    String str13 = str;
                    if (intExtra != 1 && intExtra != 2) {
                        if (intExtra == 3 || intExtra == 4) {
                            long longValue2 = Long.valueOf(stringExtra).longValue();
                            int intExtra3 = intent.getIntExtra("MultiAVType", 0);
                            boolean booleanExtra2 = intent.getBooleanExtra("isInZplanHome", false);
                            this.G0 = booleanExtra2;
                            f16.H2 = booleanExtra2;
                            f16.H1 = intent.getBooleanExtra("disableInvite", false);
                            int i28 = f16.f73063p;
                            if (i28 != 0 && intExtra3 != i28 && intExtra3 != 0) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            f16.W(intExtra3);
                            if (z16) {
                                str6 = "]";
                                f16.f73091w = stringExtra;
                                this.f74644b0 = intExtra;
                                this.f74660j0 = stringExtra;
                            } else {
                                if (stringExtra.compareTo(str5) != 0 && com.tencent.av.r.h0().W0()) {
                                    str7 = str5;
                                    str8 = "uinType";
                                    str6 = "]";
                                    com.tencent.av.r.h0().a2(uinType2AVRelationType, com.tencent.av.r.h0().X(), 98);
                                    f16.W(intExtra3);
                                } else {
                                    str7 = str5;
                                    str8 = "uinType";
                                    str6 = "]";
                                }
                                if (z17) {
                                    i16 = intExtra;
                                    com.tencent.av.r.h0().a2(uinType2AVRelationType, com.tencent.av.r.h0().X(), 99);
                                    f16.W(intExtra3);
                                    f16.p0(j3, "processExtraData.1", 3);
                                } else {
                                    i16 = intExtra;
                                }
                                f16.Z("processExtraData.1", intent.getIntExtra("Type", -1));
                                f16.P0 = longValue2;
                                this.f74662k0 = stringExtra;
                                if (stringExtra.compareTo(str7) == 0) {
                                    if (z17) {
                                        this.f74644b0 = i16;
                                        int intExtra4 = intent.getIntExtra(str8, -1);
                                        f16.f73067q = intExtra4;
                                        this.f74650e0 = intExtra4;
                                        this.f74672p0 = f16.f73103z;
                                        if (f16.R0 == -1) {
                                            f16.Z("processExtraData.2", 0);
                                        }
                                        this.f74681w0 = f16.V;
                                        if (QLog.isColorLevel()) {
                                            QLog.d(this.f74658i0, 2, "processExtraData multiAVType: " + f16.f73063p);
                                        }
                                    } else {
                                        this.f74644b0 = f16.f73035i;
                                    }
                                } else {
                                    int i29 = i16;
                                    f16.p0(j3, "processExtraData.2", i29);
                                    f16.f73067q = intent.getIntExtra(str8, -1);
                                    int i36 = f16.R0;
                                    if (i36 == 0 || i36 == 1) {
                                        f16.Q0 = intent.getLongArrayExtra("DiscussUinList");
                                    }
                                    this.f74644b0 = i29;
                                }
                            }
                            if (!z17) {
                                this.f74650e0 = f16.f73067q;
                                this.f74672p0 = f16.f73103z;
                                this.f74681w0 = f16.V;
                            }
                            QLog.w(this.f74658i0, 1, "processExtraData, mSessionType[" + this.f74644b0 + "], mUinType[" + this.f74650e0 + "], mPeerUin[" + this.f74660j0 + "], mPeerName[" + this.f74664l0 + "], mPhoneNum[" + this.f74666m0 + "], mSelfNation[" + this.f74668n0 + "], mSelfMobile[" + this.f74670o0 + "], mIsReceiver[" + this.f74679u0 + "], mIsAudioMode[" + this.f74680v0 + "], mExtraUin[" + this.f74672p0 + "], mIsPeerNetworkWell[" + this.f74681w0 + "], mIsFriend[" + this.f74682x0 + "], mFromWhere[" + this.f74674q0 + "], intentUinStr[" + stringExtra + "], \nsession[" + f16 + str6);
                            HexUtil.printHexString(this.f74658i0, this.f74656h0);
                            return;
                        }
                    } else {
                        com.tencent.av.r.h0().a2(uinType2AVRelationType, Long.valueOf(str5).longValue(), 97);
                        I3(j3);
                        String b18 = com.tencent.av.n.b(3, this.f74660j0, new int[0]);
                        if (!com.tencent.av.n.e().j(b18)) {
                            SessionInfo a17 = com.tencent.av.n.e().a(b18, false);
                            a17.G = false;
                            a17.n0(str13, 0);
                            a17.f73073r1 = false;
                            if (!b18.equals(this.f74648d0)) {
                                this.f74648d0 = b18;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.w(this.f74658i0, 2, "mutivideo to doublevideo bug fix call");
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                str6 = "]";
                QLog.w(this.f74658i0, 1, "processExtraData, mSessionType[" + this.f74644b0 + "], mUinType[" + this.f74650e0 + "], mPeerUin[" + this.f74660j0 + "], mPeerName[" + this.f74664l0 + "], mPhoneNum[" + this.f74666m0 + "], mSelfNation[" + this.f74668n0 + "], mSelfMobile[" + this.f74670o0 + "], mIsReceiver[" + this.f74679u0 + "], mIsAudioMode[" + this.f74680v0 + "], mExtraUin[" + this.f74672p0 + "], mIsPeerNetworkWell[" + this.f74681w0 + "], mIsFriend[" + this.f74682x0 + "], mFromWhere[" + this.f74674q0 + "], intentUinStr[" + stringExtra + "], \nsession[" + f16 + str6);
                HexUtil.printHexString(this.f74658i0, this.f74656h0);
                return;
            }
            stringExtra = intent.getStringExtra("GroupId");
            int intExtra5 = intent.getIntExtra("MeetingConfID", 0);
            int intExtra6 = intent.getIntExtra("ConfAppID", 0);
            int intExtra7 = intent.getIntExtra("MeetingStasks", -1);
            f16.Q1 = intExtra5;
            f16.R1 = intExtra6;
            f16.S1 = intExtra7;
        } else {
            stringExtra = intent.getStringExtra("uin");
        }
        str4 = str2;
        if (str4.equals(str3)) {
        }
        if (stringExtra != null) {
        }
    }

    void I3(long j3) {
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        int i17;
        String b16;
        SessionInfo f16 = com.tencent.av.n.e().f();
        QLog.w(this.f74658i0 + "|VideoNodeManager", 1, "processIntentData begin, isProcessCreate[" + this.H0.F + "], isMsfRecv[" + this.H0.G + "], seq[" + j3 + "], \nSessionInfo[" + f16 + "]");
        VideoAppInterface videoAppInterface = this.H0;
        if (videoAppInterface.F || videoAppInterface.G) {
            videoAppInterface.F = false;
            videoAppInterface.G = false;
        }
        Intent intent = super.getIntent();
        com.tencent.av.utils.e.m(this.f74658i0 + "_processIntentData", intent.getExtras());
        this.f74644b0 = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        this.f74650e0 = intent.getIntExtra("uinType", -1);
        this.f74660j0 = intent.getStringExtra("uin");
        this.f74677s0 = intent.getStringExtra("dstClient");
        boolean booleanExtra = intent.getBooleanExtra("isDoubleVideoMeeting", false);
        String stringExtra = intent.getStringExtra("Fromwhere");
        if ("AIOShareScreen".equals(stringExtra)) {
            if (QLog.isColorLevel()) {
                QLog.i(this.f74658i0, 2, "processIntentData, from share screen. uinType[" + this.f74650e0 + "]");
            }
            if (this.f74650e0 == 0) {
                booleanExtra = true;
            }
            f16.f73042j2 = 4;
            if (booleanExtra) {
                i3 = 0;
                b16 = com.tencent.av.n.b(100, this.f74660j0, new int[0]);
                i17 = 1;
            } else {
                i3 = 0;
                i17 = 1;
                b16 = com.tencent.av.n.b(1, intent.getStringExtra("GroupId"), new int[0]);
            }
            com.tencent.av.screenshare.c.i(b16, i17, "processIntentData");
        } else {
            i3 = 0;
            if ("AV_INVITE_HALF_SCREEN".equals(stringExtra)) {
                this.f74653f1 = false;
            }
        }
        l4("processIntentData", booleanExtra);
        this.f74678t0 = intent.getStringExtra("bindId");
        this.f74652f0 = intent.getIntExtra("bindType", i3);
        this.f74646c0 = intent.getIntExtra("subServiceType", i3);
        this.f74654g0 = intent.getIntExtra("extraType", i3);
        this.f74664l0 = intent.getStringExtra("name");
        this.f74668n0 = intent.getStringExtra("selfNation");
        this.f74670o0 = intent.getStringExtra("selfMobile");
        this.f74666m0 = intent.getStringExtra("toMobile");
        this.f74679u0 = intent.getBooleanExtra("receive", false);
        this.f74680v0 = intent.getBooleanExtra("isAudioMode", true);
        this.C0 = intent.getLongExtra("main_timestamp", 0L);
        this.f74672p0 = intent.getStringExtra("extraUin");
        String stringExtra2 = intent.getStringExtra("extraCode");
        byte[] byteArrayExtra = intent.getByteArrayExtra(PreloadTRTCPlayerParams.KEY_SIG);
        this.f74681w0 = intent.getBooleanExtra("isPeerNetworkWell", false);
        this.f74682x0 = intent.getBooleanExtra(IProfileProtocolConst.PARAM_IS_FRIEND, false);
        this.f74674q0 = intent.getStringExtra("from");
        this.f74684z0 = intent.getBooleanExtra("shutCamera", false);
        this.D0 = VipFunCallUtil.getResIdByUin(this.H0, this.f74660j0, 3, true, null);
        this.E0 = intent.getIntExtra("vipType", 0);
        this.G0 = intent.getBooleanExtra("isInZplanHome", false);
        this.F0 = intent.getIntExtra("inviteScene", 0);
        f16.G2 = intent.getBooleanExtra("isAvatarFromH5", false);
        f16.I2 = intent.getBooleanExtra("needNotifyHangupEvent", false);
        f16.K2 = intent.getStringExtra("visitUin");
        AVCoreLog.printInfoLog("VideoNodeManager", "==> AVActivity processIntentData() mSessionType = " + this.f74644b0 + "  mIsAudioMode = " + this.f74680v0);
        k4();
        if (this.f74650e0 == 0 && this.f74679u0) {
            this.f74682x0 = this.H0.isFriend(this.f74660j0);
        }
        int i18 = this.f74650e0;
        if (i18 == 1008) {
            if (byteArrayExtra != null) {
                i16 = 3;
                byte[] bArr = new byte[byteArrayExtra.length + 3];
                this.f74656h0 = bArr;
                bArr[0] = 1;
                bArr[1] = 1;
                bArr[2] = -116;
                System.arraycopy(byteArrayExtra, 0, bArr, 3, byteArrayExtra.length);
            } else {
                i16 = 3;
                this.f74656h0 = new byte[]{1, 1, -118};
            }
        } else {
            i16 = 3;
            if (i18 == 1011) {
                if (byteArrayExtra != null) {
                    byte[] bArr2 = new byte[byteArrayExtra.length + 3];
                    this.f74656h0 = bArr2;
                    bArr2[0] = 1;
                    bArr2[1] = 1;
                    bArr2[2] = -118;
                    System.arraycopy(byteArrayExtra, 0, bArr2, 3, byteArrayExtra.length);
                } else {
                    this.f74656h0 = new byte[]{1, 1, -118};
                }
            } else {
                this.f74656h0 = byteArrayExtra;
            }
        }
        zv.b.a().f453508j0 = this.f74660j0;
        int i19 = this.f74644b0;
        if (i19 != i16 && i19 != 4) {
            boolean booleanExtra2 = intent.getBooleanExtra("isOtherTerminalOnChating", false);
            f16.f73081t1 = booleanExtra2;
            if (booleanExtra2) {
                f16.f73089v1 = intent.getLongExtra("otherTerminalChatingRoomId", 0L);
                f16.f73093w1 = intent.getBooleanExtra("startfromVideoEntry", false);
            }
        } else {
            f16.Z("processIntentData", intent.getIntExtra("Type", -1));
            String stringExtra3 = intent.getStringExtra("GroupId");
            if (TextUtils.isEmpty(stringExtra3)) {
                AVCoreLog.printAllUserLog(this.f74658i0, "relationIdStr is null");
                this.f74683y0 = true;
                ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                finish();
                return;
            }
            int intExtra = intent.getIntExtra("MultiAVType", 0);
            if (intExtra == 0) {
                intExtra = f16.f73063p;
                if (QLog.isColorLevel()) {
                    QLog.d(this.f74658i0, 2, "Not get avtype inside intent default value: " + intExtra);
                }
            }
            f16.W(intExtra);
            if (stringExtra3 != null) {
                f16.P0 = Long.valueOf(stringExtra3).longValue();
                this.f74662k0 = stringExtra3;
            }
            f16.Q0 = intent.getLongArrayExtra("DiscussUinList");
            f16.H1 = intent.getBooleanExtra("disableInvite", false);
        }
        if (this.f74644b0 == 0) {
            AVCoreLog.printAllUserLog(this.f74658i0, "invalid sessionType!!!");
            this.f74683y0 = true;
            ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1015L);
            finish();
            return;
        }
        int intExtra2 = intent.getIntExtra("remoteStatus", 0);
        if (this.f74679u0) {
            if (TextUtils.isEmpty(this.f74660j0)) {
                AVCoreLog.printAllUserLog(this.f74658i0, "uin is empty");
                this.f74683y0 = true;
                ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                finish();
                return;
            }
            if (TextUtils.isEmpty(this.f74664l0)) {
                this.f74664l0 = this.f74660j0;
            }
        } else if (this.f74650e0 == 1006) {
            if (TextUtils.isEmpty(this.f74666m0)) {
                AVCoreLog.printAllUserLog(this.f74658i0, "phoneNum is empty");
                this.f74683y0 = true;
                ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                finish();
                return;
            }
            this.f74660j0 = this.f74666m0;
            if (TextUtils.isEmpty(this.f74664l0)) {
                this.f74664l0 = this.f74666m0;
            }
        } else {
            if (TextUtils.isEmpty(this.f74660j0)) {
                AVCoreLog.printAllUserLog(this.f74658i0, "Create video failed because uin is empty");
                this.f74683y0 = true;
                ((VideoNodeReporter) this.H0.B(4)).w(f16.b(), 5, 1016L);
                finish();
                return;
            }
            if (TextUtils.isEmpty(this.f74664l0)) {
                this.f74664l0 = this.f74660j0;
            }
        }
        f16.p0(j3, "processIntentData", this.f74644b0);
        f16.f73067q = this.f74650e0;
        f16.f73091w = this.f74660j0;
        f16.f73099y = this.f74664l0;
        f16.f73103z = this.f74672p0;
        f16.A = stringExtra2;
        f16.j0(this.f74666m0);
        if (!TextUtils.isEmpty(this.f74660j0)) {
            ThreadManager.getSubThreadHandler().postDelayed(this.f74655g1, 5000L);
        }
        boolean z18 = this.f74679u0;
        f16.G = z18;
        if (!z18) {
            f16.f73079t = getIntent().getStringExtra("start_double_rtc_talk_from_source");
            f16.f73083u = getIntent().getLongExtra("timestamp", System.currentTimeMillis());
            f16.v0("processIntentData", getIntent().getStringExtra("trace_id"));
        }
        f16.M0 = this.f74680v0;
        f16.V = this.f74681w0;
        int i26 = this.F0;
        f16.f73004b0 = i26;
        if (i26 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        f16.f73098x2 = z16;
        f16.C = this.f74668n0;
        f16.D = this.f74670o0;
        f16.E = this.f74677s0;
        f16.D0 = this.f74678t0;
        f16.B0 = this.f74652f0;
        f16.C0 = this.f74654g0;
        f16.J0 = this.f74656h0;
        f16.f73084u0 = this.f74682x0;
        f16.f73039j = this.f74644b0;
        f16.S = this.f74684z0;
        f16.f73012d0 = this.D0;
        f16.f73016e0 = this.E0;
        if (intExtra2 == 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        f16.W = z17;
        f16.Q = intent.getIntExtra("friendTerminal", 3);
        f16.y0("processIntentData", this.A0);
        f16.f73021f0 = this.f74646c0;
        f16.f73026g0 = intent.getStringExtra(GameCenterCommonApiImpl.KEY_ACT_ID);
        f16.f73031h0 = intent.getStringExtra("mp_ext_params");
        f16.F = this.C0;
        f16.H2 = this.G0;
        QLog.w(this.f74658i0 + "|VideoNodeManager", 1, "processIntentData end, mRelationId[" + this.f74662k0 + "], bStartByTerminalSwitch[" + f16.f73081t1 + "], terSwitchStartFromVideoEntry[" + f16.f73093w1 + "], \nSessionInfo[" + f16 + "]");
    }

    public void J3(boolean z16) {
        boolean z17;
        boolean z18;
        int i3;
        boolean z19;
        SessionInfo sessionInfo;
        VideoLayerUI videoLayerUI;
        boolean z26 = false;
        if (com.tencent.av.r.h0() != null && !isDestroyed() && com.tencent.av.n.e().f() != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && VideoLayerUIBase.R0(com.tencent.av.n.e().f())) {
            z18 = true;
        } else {
            z18 = false;
        }
        QLog.d(this.f74658i0, 1, "quitDoubleScreenStatus, exit[" + z16 + "],[needIntercept:=" + z18 + "]");
        if (z18) {
            return;
        }
        VideoLayerUI videoLayerUI2 = this.J0;
        if (videoLayerUI2 != null) {
            i3 = videoLayerUI2.o2();
        } else {
            i3 = 1;
        }
        if (i3 != 8 && i3 != 9) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (com.tencent.av.r.h0() != null && !isDestroyed()) {
            sessionInfo = com.tencent.av.n.e().f();
        } else {
            sessionInfo = null;
        }
        if (i3 != 7 || !FoldInfoUtils.h(this) || sessionInfo == null || !sessionInfo.N || !sessionInfo.O || sessionInfo.f73098x2 || sessionInfo.f73102y2) {
            z26 = z19;
        }
        if (z26) {
            U2(1);
        }
        if (x3() && (videoLayerUI = this.J0) != null) {
            videoLayerUI.o3("onChangeUI_quitDoubleScreenStatus");
        }
        if (z16) {
            Z2(2);
        }
    }

    void L3() {
        if (this.O0 == null) {
            this.O0 = new h(this, 2);
        }
    }

    void M3() {
        Sensor sensor;
        SensorManager sensorManager = this.V0;
        if (sensorManager != null && (sensor = this.W0) != null) {
            SensorMonitor.registerListener(sensorManager, this, sensor, 2);
        }
    }

    void P3(long j3) {
        if (this.K0 == null) {
            return;
        }
        VideoLayerUI videoLayerUI = this.J0;
        if (videoLayerUI != null) {
            videoLayerUI.f3(j3, false, false);
            if (!this.K0.isCameraOpened(j3)) {
                com.tencent.av.n.e().f().c0(j3, false);
            }
        }
        ICameraManagerApi iCameraManagerApi = this.K0;
        if (iCameraManagerApi != null) {
            iCameraManagerApi.closeCamera(j3, true);
        }
        if (!this.K0.isCameraOpened(j3)) {
            QLog.w(this.f74658i0, 1, "requestCloseCamera, \u6444\u50cf\u5934\u672c\u6765\u6ca1\u6253\u5f00, seq[" + j3 + "]");
            aj ajVar = this.I0;
            if (ajVar != null) {
                ajVar.L(j3, true);
            }
        }
        if (!com.tencent.av.n.e().f().F()) {
            if (x.g(this)) {
                i3(false);
            } else {
                U2(1);
                VideoLayerUI videoLayerUI2 = this.J0;
                if (videoLayerUI2 != null) {
                    videoLayerUI2.f3(j3, false, false);
                }
            }
        }
        VideoChatRoomUIContoller videoChatRoomUIContoller = this.f74657h1;
        if (videoChatRoomUIContoller != null) {
            videoChatRoomUIContoller.v();
        }
    }

    public void R2(long j3) {
        S2(j3, 0);
    }

    void S2(long j3, int i3) {
        aj ajVar;
        int i16;
        int i17;
        VideoLayerUI videoLayerUI;
        if (!isDestroyed() && (ajVar = this.I0) != null && !ajVar.E()) {
            int r16 = this.I0.r(j3);
            int s16 = this.I0.s();
            int k3 = this.I0.k();
            if (!this.I0.I()) {
                if (r16 == 0 && LiuHaiUtils.isLiuHaiUseValid()) {
                    i16 = LiuHaiUtils.getNotchInScreenHeight(this);
                } else {
                    i16 = 0;
                }
                SessionInfo f16 = com.tencent.av.n.e().f();
                aj ajVar2 = this.I0;
                if (ajVar2 != null && ajVar2.t() != null && (videoLayerUI = this.J0) != null) {
                    videoLayerUI.G0 = this.I0.t().calcControlUIOffset(f16);
                }
            } else {
                i16 = 0;
            }
            int i18 = r16 + i16;
            VideoChatRoomUIContoller videoChatRoomUIContoller = this.f74657h1;
            if (videoChatRoomUIContoller != null) {
                i17 = videoChatRoomUIContoller.l();
            } else {
                i17 = 0;
            }
            if (QLog.isDevelopLevel()) {
                QLog.w("ChatRoomUtil", 1, "calcControlUIOffset, topOffset[" + i18 + "], topToolbarHeight[" + r16 + "], topToolbarTop[" + s16 + "], bottomToolbarHeight[" + k3 + "], chatRoomInputPanelHeight[" + i17 + "], recordBarHeight[0], systemBarHeight[" + i16 + "], from[" + i3 + "], seq[" + j3 + "]");
            }
            if (this.J0 != null && this.I0.p() != null && !this.I0.p().v0(6)) {
                if (g3() == 1 && i17 > k3) {
                    this.J0.I2(j3, i18, i17, !this.I0.J());
                } else {
                    this.J0.I2(j3, i18, k3, !this.I0.J());
                }
            }
            this.I0.V0();
            this.I0.o1();
            VideoChatRoomUIContoller videoChatRoomUIContoller2 = this.f74657h1;
            if (videoChatRoomUIContoller2 != null && i3 != 1) {
                videoChatRoomUIContoller2.E(k3);
            }
        }
    }

    public void T2() {
        String str;
        boolean z16;
        Object valueOf;
        int i3;
        QLog.d(this.f74658i0, 1, "changeUIAfterDoubleToMulti", new Throwable());
        final SessionInfo f16 = com.tencent.av.n.e().f();
        boolean z17 = this.A0;
        long d16 = com.tencent.av.utils.e.d();
        boolean z18 = f16.K;
        if (!z17) {
            str = "onChangeUI_DobuleAudio2MultiAudio";
        } else {
            str = "onChangeUI_Normal2Meeting";
        }
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.y0(d16);
            if (this.f74642a0 != 4) {
                this.I0.t0(d16);
            }
        }
        String str2 = f16.f73091w;
        if (str2 == null) {
            if (QLog.isColorLevel()) {
                QLog.e(this.f74658i0, 2, "onChangeUI_Normal2Meeting-->Peer uin is null!!!!!!!!!");
                return;
            }
            return;
        }
        long j3 = f16.P0;
        f16.Z0 = Long.valueOf(str2).longValue();
        if (z17) {
            aj ajVar2 = this.I0;
            if (ajVar2 != null) {
                ajVar2.e1(null);
            }
            z16 = z18;
        } else {
            if (f16.f73067q == 3000) {
                f16.Q0 = this.H0.E(String.valueOf(j3));
            }
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onChangeUI_DobuleAudio2MultiAudio uinList[");
                long[] jArr = f16.Q0;
                if (jArr == null) {
                    valueOf = "null";
                } else {
                    valueOf = Integer.valueOf(jArr.length);
                }
                sb5.append(valueOf);
                sb5.append("]");
                QLog.i("double_2_multi", 4, sb5.toString());
            }
            long longValue = Long.valueOf(this.H0.getCurrentAccountUin()).longValue();
            long[] jArr2 = f16.Q0;
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            while (jArr2 != null && i16 < jArr2.length) {
                long j16 = jArr2[i16];
                long[] jArr3 = jArr2;
                if (j16 != longValue && j16 != f16.Z0) {
                    arrayList.add(Long.valueOf(f16.Q0[i16]));
                }
                i16++;
                jArr2 = jArr3;
            }
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                z16 = z18;
                String G = this.H0.G(AVUtil.f(f16.S0), String.valueOf(((Long) arrayList.get(0)).longValue()), String.valueOf(f16.P0));
                if (G.length() > 7) {
                    G = G.substring(0, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                }
                if (size > 1) {
                    G = G + HardCodeUtil.qqStr(R.string.jug) + size + HardCodeUtil.qqStr(R.string.juf);
                }
                String format = String.format(getString(R.string.dks), G);
                aj ajVar3 = this.I0;
                if (ajVar3 != null) {
                    ajVar3.e1(format);
                }
            } else {
                z16 = z18;
                if (QLog.isColorLevel()) {
                    QLog.e("double_2_multi", 2, "onChangeUI_DobuleAudio2MultiAudio-->inviteList is null");
                }
            }
        }
        if (z16) {
            com.tencent.av.r.h0().z(str, j3, false, false, -1);
        }
        if (z17) {
            this.H0.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.AVActivity.18
                @Override // java.lang.Runnable
                public void run() {
                    f16.s0("AVActivity.onChangeUI_Normal2Meeting", false);
                }
            }, 1500L);
        } else {
            f16.u0("onChangeUI_DobuleAudio2MultiAudio", 0);
            com.tencent.av.r.h0().q3(false);
            com.tencent.av.r.h0().r3(false);
        }
        this.f74650e0 = f16.f73067q;
        if (z17) {
            i3 = 4;
            com.tencent.av.r.h0().P2(d16, f16.f73035i, false, true);
        } else {
            i3 = 4;
        }
        if (f16.N || f16.f73062o2 || this.f74644b0 == i3) {
            com.tencent.av.r.h0().P2(d16, f16.f73035i, false, false);
        }
        this.f74662k0 = String.valueOf(f16.P0);
        VideoChatRoomUIContoller videoChatRoomUIContoller = this.f74657h1;
        if (videoChatRoomUIContoller != null) {
            videoChatRoomUIContoller.v();
        }
    }

    public void T3(int i3) {
        this.f74642a0 = i3;
    }

    public void TestMenuBtnOnClick(View view) {
        if (com.tencent.av.utils.e.j()) {
            try {
                ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).addMenuInVideoView(this.H0, this, view);
            } catch (Throwable th5) {
                QLog.i(this.f74658i0, 1, "addMenuInVideoView", th5);
            }
        }
    }

    public void U2(int i3) {
        aj ajVar;
        int i16;
        Object valueOf;
        if (QLog.isDevelopLevel()) {
            String str = this.f74658i0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("changeVideoLayoutMode, mode[");
            sb5.append(i3);
            sb5.append("], ctrlUI[");
            sb5.append(this.I0);
            sb5.append("], curMode[");
            VideoLayerUI videoLayerUI = this.J0;
            if (videoLayerUI == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(videoLayerUI.o2());
            }
            sb5.append(valueOf);
            sb5.append("]");
            QLog.i(str, 4, sb5.toString());
        }
        if (!isDestroyed() && (ajVar = this.I0) != null && !ajVar.E()) {
            if (this.J0 == null && ((i16 = this.f74644b0) == 2 || i16 == 4)) {
                checkVideoLayerUI();
                QLog.i(this.f74658i0, 1, "changeVideoLayoutMode mVideoLayerUI=" + this.J0);
            }
            VideoLayerUI videoLayerUI2 = this.J0;
            if (videoLayerUI2 != null && i3 != videoLayerUI2.o2()) {
                long d16 = com.tencent.av.utils.e.d();
                this.J0.m0(i3);
                if ((i3 == 2 || i3 == 1) && !x.g(this) && this.I0 != null) {
                    this.J0.P2(d16);
                    this.I0.c(this.J0.N0(), u3());
                }
                this.I0.H0(d16);
                this.I0.i1(d16, 33554431);
                if (com.tencent.av.r.h0() != null && !isDestroyed() && com.tencent.av.n.e().f().Y2 && !com.tencent.av.n.e().f().f73034h3) {
                    QavRecordReporter.g("0X8008ABA");
                }
                this.I0.b0(i3);
                return;
            }
            QLog.d(this.f74658i0, 1, "changeVideoLayoutMode return");
        }
    }

    public void U3() {
        if (this.H0 == null) {
            return;
        }
        ImmersiveUtils.setStatusTextColor(false, getWindow());
    }

    void V2(long j3) {
        boolean hideSoftInputFromWindow;
        int i3;
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager.isActive()) {
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
                hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                i3 = 1;
            } else {
                hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                i3 = 2;
            }
            QLog.w(this.f74658i0, 1, "closeIME , InputMethodManager, result[" + hideSoftInputFromWindow + "], step[" + i3 + "], seq[" + j3 + "]");
        }
    }

    public void V3() {
        this.f74651e1 = true;
    }

    public void W2(boolean z16) {
        if (AVUtil.t(getWindow(), z16)) {
            this.f74673p1 = z16;
        }
    }

    public void W3(VideoLayerUI videoLayerUI) {
        aj ajVar;
        VideoLayerUI videoLayerUI2 = this.J0;
        if (videoLayerUI2 != null) {
            videoLayerUI2.V0();
        }
        this.J0 = videoLayerUI;
        aj ajVar2 = this.I0;
        if (ajVar2 != null && ajVar2.F()) {
            this.I0.C();
        }
        if (this.f74651e1 && (ajVar = this.I0) != null) {
            ajVar.K();
            this.f74651e1 = false;
        }
    }

    public void X3(boolean z16) {
        VideoLayerUI.l3(findViewById(R.id.a2f), z16);
    }

    void Z2(int i3) {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.o() != null) {
            this.I0.o().m(i3);
        }
    }

    public void a4() {
        h hVar = this.O0;
        if (hVar != null) {
            hVar.enable();
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean actNeedImmersive() {
        return false;
    }

    public int c3() {
        return this.f74642a0;
    }

    public void changeAvatarLayout(boolean z16, boolean z17) {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.u(false) != null) {
            this.I0.u(false).changeAvatarLayout(z16, z17);
        }
    }

    public void checkVideoLayerUI() {
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.d();
        }
    }

    @TargetApi(21)
    @Nullable
    public ScreenRecordHelper d3() {
        if (com.tencent.av.r.h0() != null && !isDestroyed()) {
            ScreenRecordHelper x06 = com.tencent.av.r.h0().x0();
            this.f74647c1 = x06;
            x06.k(this);
            return this.f74647c1;
        }
        return null;
    }

    public void d4() {
        h hVar = this.O0;
        if (hVar != null) {
            hVar.disable();
        }
    }

    public void dispatchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.g(motionEvent);
            return;
        }
        VideoLayerUI videoLayerUI = this.J0;
        if (videoLayerUI != null && (gestureDetector = videoLayerUI.F0) != null) {
            videoLayerUI.f75274f0 = -1;
            gestureDetector.onTouchEvent(motionEvent);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    public SessionInfo e3() {
        if (com.tencent.av.r.h0() != null && !isDestroyed()) {
            return com.tencent.av.n.e().f();
        }
        return null;
    }

    public void e4() {
        if ((!x.g(this) && !com.tencent.av.n.e().f().F()) || !isInOpenState()) {
            U2(2);
        } else if (isInFoldingMode()) {
            U2(8);
        } else {
            U2(7);
        }
    }

    public SmallScreenActivityPlugin f3() {
        return this.Y0;
    }

    @Override // android.app.Activity
    public void finish() {
        S3(new Intent("tencent.video.v2q.ACTION_DISSMISS_SMALL_HOME_GUIDE"));
        if (!TextUtils.isEmpty(this.f74674q0) && this.f74674q0.equals("from_app_contact")) {
            moveTaskToBack(true);
        }
        QLog.d(this.f74658i0, 1, "avideo life_finish, FromWhere[" + this.f74674q0 + "]", new Throwable());
        SessionInfo f16 = com.tencent.av.n.e().f();
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.t() != null) {
            this.I0.t().finish(f16);
        }
        if (this.f74683y0 && f16.f73038i2 && this.H0 != null) {
            String valueOf = String.valueOf(f16.P0);
            String G = this.H0.G(this.f74650e0, valueOf, f16.f73103z);
            Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(super.getApplicationContext()), null);
            m3.putExtra("uin", valueOf);
            m3.putExtra("uintype", f16.f73067q);
            m3.putExtra("uinname", G);
            startActivity(m3);
        }
        if (QLog.isColorLevel()) {
            QLog.i("double_2_multi", 2, "finish fromDoubleChat[" + f16.f73038i2 + "], session[" + f16 + "]");
        }
        super.finish();
    }

    public int g3() {
        VideoLayerUI videoLayerUI = this.J0;
        if (videoLayerUI != null) {
            return videoLayerUI.o2();
        }
        return 1;
    }

    void g4(long j3, String str, boolean z16) {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.t() != null) {
            this.I0.t().tryShowRecordBtn(com.tencent.av.n.e().f(), j3, str, z16, this.S0);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider
    public String getCurrentAccountUinFromRuntime() {
        VideoAppInterface videoAppInterface = this.H0;
        if (videoAppInterface != null) {
            return videoAppInterface.getCurrentAccountUin();
        }
        return "";
    }

    void h4() {
        SensorManager sensorManager = this.V0;
        if (sensorManager != null && this.W0 != null) {
            sensorManager.unregisterListener(this);
        }
    }

    public void handleVideoCountChangeLayout(boolean z16, boolean z17) {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.m() != null) {
            this.I0.m().handleVideoCountChangeLayout(z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean hasTitleBar() {
        return false;
    }

    public void i3(boolean z16) {
        boolean z17;
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16.N && f16.O) {
            z17 = true;
        } else {
            z17 = false;
        }
        handleVideoCountChangeLayout(z16, z17);
    }

    void i4() {
        h hVar = this.O0;
        if (hVar != null) {
            hVar.e();
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean isAttachedToWindow() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean isClearCoverLayer() {
        return false;
    }

    @Override // android.app.Activity
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    public boolean isEnableRecord() {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.t() != null && this.I0.t().isEnableRecord()) {
            return true;
        }
        return false;
    }

    public boolean isInFoldingMode() {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.m() != null && this.I0.m().isInFoldingMode()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    @TargetApi(24)
    public boolean isInMultiWindow() {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                return isInMultiWindowMode();
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean isNeedInterruptDoMultiWindow() {
        return false;
    }

    public void j3(long j3, int i3) {
        aj ajVar;
        if (!isDestroyed() && (ajVar = this.I0) != null && !ajVar.E() && this.S0 != i3) {
            this.I0.U0(j3, i3);
            VideoLayerUI videoLayerUI = this.J0;
            if (videoLayerUI != null) {
                videoLayerUI.e1(i3, false);
            }
            this.K0.setRotation(i3);
            this.S0 = i3;
            if (com.tencent.av.n.e().f().Y2 || com.tencent.av.n.e().f().f73003a3) {
                R2(j3);
            }
        }
    }

    public void l4(String str, boolean z16) {
        if (this.A0 != z16) {
            this.A0 = z16;
            if (QLog.isColorLevel()) {
                QLog.i(this.f74658i0, 2, "updateDoubleMeeting, from[" + str + "], [" + this.A0 + "-->" + z16);
            }
        }
    }

    public void m4(boolean z16, boolean z17) {
        com.tencent.av.opengl.effects.m R;
        com.tencent.av.opengl.effects.q qVar;
        CameraConfig.DeviceCameraOrientation deviceCameraOrientation;
        if (com.tencent.av.r.h0() != null && !isDestroyed() && (R = com.tencent.av.r.h0().R(false)) != null && (qVar = R.F) != null) {
            CameraConfig.DeviceCameraOrientation deviceCameraOrientation2 = CameraConfig.DeviceCameraOrientation.ROTATION_0;
            if (z17) {
                if (z16) {
                    deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_270;
                } else {
                    deviceCameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_90;
                }
                deviceCameraOrientation2 = deviceCameraOrientation;
            }
            qVar.r(deviceCameraOrientation2);
        }
    }

    void n3() {
        if (this.V0 == null && this.W0 == null) {
            SensorManager sensorManager = (SensorManager) getApplicationContext().getSystemService(WebRTCSDK.PRIVILEGE_SENSOR);
            this.V0 = sensorManager;
            this.W0 = SensorMonitor.getDefaultSensor(sensorManager, 1);
        }
    }

    public void n4(boolean z16) {
        int i3 = 2;
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f74658i0, 2, "updateNotificationFlag resume[" + z16 + "]");
        }
        QAVNotification l3 = QAVNotification.l(this.H0);
        if (l3 != null) {
            if (z16) {
                i3 = 1;
            }
            l3.x(i3);
        }
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public boolean needStatusTrans() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        ScreenRecordHelper screenRecordHelper;
        if (QLog.isColorLevel()) {
            QLog.d(this.f74658i0, 2, "life_onActivityResult, requestCode[" + i3 + "], resultCode[" + i16 + "]");
        }
        super.onActivityResult(i3, i16, intent);
        int i17 = Build.VERSION.SDK_INT;
        if (i3 == 8080 && (screenRecordHelper = this.f74647c1) != null) {
            if (i16 == -1) {
                if (i17 >= 29) {
                    qw.a.b().c(this);
                    Intent intent2 = new Intent(this, (Class<?>) AVServiceForQQ.class);
                    intent2.putExtra("isScreenCapture", true);
                    intent2.putExtra("code", i16);
                    intent2.putExtra("data", intent);
                    if (com.tencent.av.r.h0() != null && !isDestroyed()) {
                        SessionInfo f16 = com.tencent.av.n.e().f();
                        intent2.putExtra("peerUin", f16.f73091w);
                        intent2.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, f16.f73035i);
                        intent2.putExtra("uinType", f16.f73067q);
                    }
                    startForegroundService(intent2);
                    this.f74649d1 = true;
                    return;
                }
                screenRecordHelper.x(intent);
                this.f74647c1.g();
                return;
            }
            screenRecordHelper.r();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Y2(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z16;
        aj ajVar;
        if (this.f74669n1) {
            QLog.i(this.f74658i0, 1, "avideo onBackPressed, onSaveInstanceState, return");
            return;
        }
        QLog.i(this.f74658i0, 1, "avideo onBackPressed.");
        VideoChatRoomUIContoller videoChatRoomUIContoller = this.f74657h1;
        if (videoChatRoomUIContoller != null) {
            z16 = videoChatRoomUIContoller.t();
        } else {
            z16 = false;
        }
        if (!z16 && (ajVar = this.I0) != null) {
            z16 = ajVar.O();
        }
        if (!z16) {
            super.onBackPressed();
        }
        com.tencent.av.r.h0().L3("backgroundReason", "2");
        q.a.f74207a = "2";
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        aj ajVar;
        aj ajVar2;
        super.onConfigurationChanged(configuration);
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16 != null && !x.g(this) && !x.f(this)) {
            if (QLog.isDebugVersion()) {
                int rotation = ((WindowManager) getSystemService("window")).getDefaultDisplay().getRotation();
                QLog.d(this.f74658i0, 1, "onConfigurationChanged, displayRotation[" + rotation + "]");
            }
            VideoLayerUI videoLayerUI = this.J0;
            if (videoLayerUI != null) {
                videoLayerUI.M2(configuration.orientation);
            }
            if (configuration.orientation == 1 && (ajVar2 = this.I0) != null) {
                if (f16.f73086u2) {
                    ajVar2.A("onConfigurationChanged");
                } else if (f16.f73048l0) {
                    f16.b0(true);
                    this.I0.A("onConfigurationChanged");
                } else {
                    ajVar2.h();
                }
            }
            if (configuration.orientation != 1 && (ajVar = this.I0) != null && ajVar.I()) {
                this.I0.A("onConfigurationChanged");
            }
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        boolean z16;
        String stringExtra;
        SessionInfo i3;
        boolean z17;
        com.tencent.av.utils.e.p(this.f74658i0 + ".onCreate.begin");
        long d16 = com.tencent.av.utils.e.d();
        this.mIsShadow = false;
        super.requestWindowFeature(1);
        super.onCreate(null);
        if (getIntent() != null && getIntent().getBooleanExtra("isInZplanHome", false)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || FoldInfoUtils.h(this)) {
            setRequestedOrientation(1);
        }
        QLog.w(this.f74658i0 + "|VideoNodeManager", 1, "avideo life_onCreate, seq[" + d16 + "], IS_CPU_64_BIT = true needChangeOrientation=" + z16 + " savedInstanceState=" + bundle);
        super.setContentView(R.layout.fu9);
        super.getWindow().addFlags(524288);
        super.getWindow().addFlags(2097152);
        super.getWindow().addFlags(128);
        super.getWindow().setSoftInputMode(18);
        W2(true);
        AVUtil.u(super.getWindow());
        AppRuntime appRuntime = super.getAppRuntime();
        if (appRuntime == null) {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            if (application != null) {
                QLog.d(this.f74658i0, 1, "onCreate, \u5c1d\u8bd5\u540c\u6b65\u83b7\u53d6AppRuntime");
                appRuntime = application.getRuntime();
                String str = this.f74658i0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCreate, \u540c\u6b65\u83b7\u53d6AppRuntime\u7ed3\u679c");
                if (appRuntime != null) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                QLog.d(str, 1, sb5.toString());
            } else {
                QLog.d(this.f74658i0, 1, "onCreate, BaseApplicationImpl.getApplication is null");
            }
        }
        if (appRuntime == null) {
            E3("onCreate.appRuntime", "0x05");
            return;
        }
        if (appRuntime instanceof VideoAppInterface) {
            this.H0 = (VideoAppInterface) appRuntime;
            U3();
            VideoNodeReporter videoNodeReporter = (VideoNodeReporter) this.H0.B(4);
            SessionInfo f16 = com.tencent.av.n.e().f();
            if (f16 != null) {
                QLog.d(this.f74658i0, 1, "avideo life_onCreate roomId = " + f16.b() + ",isReceiver = " + f16.G);
                if (f16.G) {
                    videoNodeReporter.w(f16.b(), 7, 1L);
                }
            } else {
                QLog.d(this.f74658i0, 1, "avideo life_onCreate sessionInfo is null ");
            }
            boolean booleanExtra = getIntent().getBooleanExtra("isMakingAcall", false);
            if (booleanExtra) {
                videoNodeReporter.w(-1L, 1, 1L);
            }
            QLog.d(this.f74658i0, 1, "avideo life_onCreate  isMakingAcall =  " + booleanExtra);
            zv.b.a().b(getIntent(), this.H0.getCurrentAccountUin());
            iu.a.c().g(this);
            if (com.tencent.av.r.h0() != null && !isDestroyed()) {
                if (!com.tencent.av.r.h0().R0()) {
                    E3("onCreate.initVcController", "0x08");
                    return;
                }
                com.tencent.av.r.h0().O3();
                Intent intent = super.getIntent();
                if (intent != null) {
                    int intExtra = intent.getIntExtra("uinType", -1);
                    String stringExtra2 = intent.getStringExtra("uin");
                    if (intExtra == 1008 && ((i3 = com.tencent.av.n.e().i(com.tencent.av.n.b(3, stringExtra2, new int[0]))) == null || i3.f73067q == -1)) {
                        SessionInfo f17 = com.tencent.av.n.e().f();
                        if (f17.f73067q != -1 && (f17.K() || f17.u())) {
                            Intent intent2 = new Intent("tencent.video.v2q.ypc2b.failEnter.asIsInviting");
                            intent2.setPackage(this.H0.getApp().getPackageName());
                            intent2.putExtra("uin", stringExtra2);
                            intent2.putExtra("uinType", intExtra);
                            S3(intent2);
                            this.f74683y0 = true;
                            S3(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
                            AVCoreLog.printAllUserLog(this.f74658i0, "onCreate,VideoAppInterface.UIN_TYPE_PUBLIC_ACCOUNT exit: " + stringExtra2);
                            finish();
                            return;
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    String str2 = this.f74658i0;
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("onCreate, from[");
                    if (intent == null) {
                        stringExtra = "null";
                    } else {
                        stringExtra = intent.getStringExtra("Fromwhere");
                    }
                    sb6.append(stringExtra);
                    QLog.i(str2, 2, sb6.toString());
                }
                this.H0.addObserver(this.f74675q1);
                this.H0.addObserver(this.U0);
                this.H0.addObserver(this.f74671o1);
                com.tencent.av.r.h0().l0().sendGetGatewayMsg();
                L3();
                n3();
                ResDownloadBroadcastReceiver resDownloadBroadcastReceiver = new ResDownloadBroadcastReceiver();
                this.f74659i1 = resDownloadBroadcastReceiver;
                registerReceiver(resDownloadBroadcastReceiver, new IntentFilter(AECameraConstants.AE_CAMERA_RES_DOWNLOAD_FINISH_BROADCAST_ACTION));
                SmallHomeBroadcastReceiver smallHomeBroadcastReceiver = new SmallHomeBroadcastReceiver(new SmallHomeBroadcastReceiver.b() { // from class: com.tencent.av.ui.b
                    @Override // com.tencent.av.broadcast.SmallHomeBroadcastReceiver.b
                    public final void a(boolean z18) {
                        AVActivity.this.z3(z18);
                    }
                });
                this.f74661j1 = smallHomeBroadcastReceiver;
                registerReceiver(smallHomeBroadcastReceiver, new IntentFilter("tencent.video.q2v.ACTION_ENTER_SMALL_HOME"));
                String b36 = b3(getIntent());
                this.f74648d0 = b36;
                if (!TextUtils.isEmpty(b36) && !R3(getIntent()) && !com.tencent.av.n.e().j(this.f74648d0)) {
                    com.tencent.av.r.h0().p(false, 204, com.tencent.av.n.e().f().f73063p);
                    com.tencent.av.r.h0().j2(204);
                    com.tencent.av.n.e().a(this.f74648d0, false);
                } else {
                    this.f74648d0 = com.tencent.av.n.e().f().f73030h;
                }
                if (QLog.isColorLevel()) {
                    QLog.i(this.f74658i0, 2, "onCreate, sessionId[" + this.f74648d0 + "]");
                }
                if (!com.tencent.av.n.e().f().H()) {
                    H3(d16);
                }
                NtrtcVideoRender.getInstance();
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.av.ui.AVActivity.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AVActivity.this.T0 = new g();
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction("android.intent.action.CLOSE_SYSTEM_DIALOGS");
                            AVActivity aVActivity = AVActivity.this;
                            aVActivity.registerReceiver(aVActivity.T0, intentFilter);
                        } catch (Exception e16) {
                            if (QLog.isColorLevel()) {
                                QLog.d(AVActivity.this.f74658i0, 2, "Exception", e16);
                            }
                        }
                    }
                }, 5, null, false);
                this.N0 = QAVNotification.l(this.H0);
                T3(0);
                B3(d16);
                if (VideoUtil.g(this.H0, false)) {
                    com.tencent.av.ui.h hVar = new com.tencent.av.ui.h(this);
                    this.X0 = hVar;
                    hVar.f();
                }
                this.Y0 = SmallScreenActivityPlugin.a(this.H0);
                int i16 = com.tencent.av.n.e().f().O1;
                if (QLog.isDevelopLevel()) {
                    QLog.d(this.f74658i0, 4, "onCreate changeVideoLayoutMode Style=" + com.tencent.av.n.e().f().f73035i + "|" + com.tencent.av.n.e().f().O1 + "|" + com.tencent.av.r.h0().H0());
                }
                U2(i16);
                S3(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
                this.f74657h1 = new VideoChatRoomUIContoller(this, this.H0);
                this.Z0.l(this);
                this.H0.R().i(this);
                com.tencent.av.utils.e.p(this.f74658i0 + ".onCreate.end");
                if (this.G0) {
                    QAVControllerForZplan.p().O(this, this.H0);
                    onBackPressed();
                    return;
                }
                return;
            }
            E3("onCreate.VideoController.getInstance()", "0x07");
            return;
        }
        this.H0 = null;
        E3("onCreate.VideoAppInterface :" + appRuntime.getClass().getName(), "0x06");
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        this.mIsShadow = false;
        super.onDestroy();
        ThreadManager.getSubThreadHandler().removeCallbacks(this.f74655g1);
        QZoneVideoContactsFeedHelper.d();
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f74658i0, 1, "lgx avideo life_onDestroy, mActivityState[" + this.f74642a0 + "->5], seq[" + d16 + "], isQuit[" + this.f74683y0 + "], session[" + this.f74648d0 + "]");
        this.Z0.m(d16);
        T3(5);
        VideoChatRoomUIContoller videoChatRoomUIContoller = this.f74657h1;
        if (videoChatRoomUIContoller != null) {
            videoChatRoomUIContoller.k(this.f74683y0);
            this.f74657h1 = null;
        }
        ICameraManagerApi iCameraManagerApi = this.K0;
        if (iCameraManagerApi != null) {
            iCameraManagerApi.deleteObserver(this.f74663k1);
            this.K0 = null;
        }
        VideoLayerUI videoLayerUI = this.J0;
        if (videoLayerUI != null) {
            videoLayerUI.V0();
            this.J0 = null;
        }
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.X(d16);
            this.I0 = null;
        }
        VideoAppInterface videoAppInterface = this.H0;
        if (videoAppInterface != null) {
            videoAppInterface.deleteObserver(this.f74671o1);
            this.H0.deleteObserver(this.U0);
            this.H0.deleteObserver(this.f74675q1);
            ChatRoomMng D = this.H0.D();
            if (D != null) {
                D.d();
            }
        }
        BroadcastReceiver broadcastReceiver = this.T0;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
                this.T0 = null;
            } catch (Exception unused) {
                QLog.e(this.f74658i0, 2, "unregisterReceiver mHomeKeyReceiver fail");
            }
        }
        if (this.f74683y0) {
            DoodleLogic.b().h();
            QAVNotification qAVNotification = this.N0;
            if (qAVNotification != null) {
                qAVNotification.f(this.f74648d0);
            }
            com.tencent.av.camera.b.a(this).closeCamera(d16, true);
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.f74658i0, 2, "onDestroy isQuit[" + this.f74683y0 + "], session[" + this.f74648d0 + "]");
        }
        if (this.H0 != null) {
            com.tencent.av.n.e().f().u0("AVActivity.onDestroy", 0);
        }
        this.N0 = null;
        this.O0 = null;
        com.tencent.av.utils.e.f77110b = false;
        this.T0 = null;
        this.U0 = null;
        this.f74671o1 = null;
        com.tencent.av.ui.h hVar = this.X0;
        if (hVar != null) {
            hVar.h();
            this.X0 = null;
        }
        iu.a.c().g(null);
        this.H0 = null;
        if (com.tencent.av.utils.e.j()) {
            try {
                IQQDebugApi iQQDebugApi = (IQQDebugApi) QRoute.api(IQQDebugApi.class);
                if (iQQDebugApi.isQosTimerRun()) {
                    iQQDebugApi.stopQosTimer();
                }
            } catch (Throwable th5) {
                QLog.i(this.f74658i0, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY, th5);
            }
        }
        AVUtil.e(this);
        ResDownloadBroadcastReceiver resDownloadBroadcastReceiver = this.f74659i1;
        if (resDownloadBroadcastReceiver != null) {
            unregisterReceiver(resDownloadBroadcastReceiver);
        }
        SmallHomeBroadcastReceiver smallHomeBroadcastReceiver = this.f74661j1;
        if (smallHomeBroadcastReceiver != null) {
            unregisterReceiver(smallHomeBroadcastReceiver);
        }
        i4();
        if (QAVControllerForZplan.w()) {
            QAVControllerForZplan.p().j();
        }
        this.f74656h0 = null;
        this.f74660j0 = null;
        this.f74662k0 = null;
        this.f74664l0 = null;
        this.f74666m0 = null;
        this.f74668n0 = null;
        this.f74670o0 = null;
        this.f74672p0 = null;
        this.f74674q0 = null;
        this.f74676r0 = null;
        this.f74677s0 = null;
        this.f74678t0 = null;
        this.L0 = null;
        this.M0 = null;
        this.f74651e1 = false;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    @RequiresApi(api = 16)
    public boolean onKeyDown(int i3, KeyEvent keyEvent) {
        boolean z16;
        int i16;
        aj ajVar = this.I0;
        if (ajVar != null) {
            z16 = ajVar.a0(i3, keyEvent);
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        if (i3 != 24 && i3 != 25) {
            if (i3 == 84) {
                return true;
            }
        } else {
            try {
                if (au.a.d() && au.a.c().isPlayStarted()) {
                    if (i3 == 25) {
                        i16 = -1;
                    } else {
                        i16 = 1;
                    }
                    AudioManager audioManager = (AudioManager) BaseApplicationImpl.getApplication().getSystemService("audio");
                    int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 0);
                    if (this.P0 == null) {
                        this.P0 = Integer.valueOf(streamVolume);
                    }
                    int streamMaxVolume = audioManager.getStreamMaxVolume(0);
                    if (this.R0 == null) {
                        this.R0 = Integer.valueOf(streamMaxVolume);
                    }
                    audioManager.adjustStreamVolume(0, i16, 1);
                    int streamVolume2 = SystemMethodProxy.getStreamVolume(audioManager, 0);
                    this.Q0 = Integer.valueOf(streamVolume2);
                    if (QLog.isColorLevel()) {
                        QLog.d(this.f74658i0, 2, "adjustStreamVolume. streamType = 0, maxVolume = " + streamMaxVolume + ", oldVolume = " + streamVolume + ", newVolume = " + streamVolume2);
                    }
                    return true;
                }
            } catch (Exception e16) {
                QLog.e(this.f74658i0, 1, "adjustStreamVolume fail.", e16);
            }
        }
        return super.onKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        long d16 = com.tencent.av.utils.e.d();
        if (QLog.isColorLevel()) {
            QLog.w(this.f74658i0, 1, "life_onNewIntent, seq[" + d16 + "]");
        }
        SmallScreenActivityPlugin smallScreenActivityPlugin = this.Y0;
        if (smallScreenActivityPlugin != null) {
            smallScreenActivityPlugin.g();
        }
        setIntent(intent);
        int intExtra = intent.getIntExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, 0);
        int intExtra2 = intent.getIntExtra("MultiAVType", 0);
        int i3 = this.f74644b0;
        if (i3 != 1 && i3 != 2) {
            if (i3 == 3 || i3 == 4) {
                if (intExtra2 != 2 && com.tencent.av.n.e().f().f73063p != 2) {
                    if (intExtra != 3 && intExtra != 4) {
                        if (intExtra == 1 || intExtra == 2) {
                            aj ajVar = this.I0;
                            if (ajVar != null) {
                                ajVar.X(d16);
                                this.I0 = null;
                            }
                            H3(d16);
                            T3(0);
                            B3(d16);
                            return;
                        }
                        return;
                    }
                    H3(d16);
                    aj ajVar2 = this.I0;
                    if (ajVar2 != null) {
                        ajVar2.h0(intent);
                        return;
                    }
                    return;
                }
                if (com.tencent.av.n.e().f().f73063p == intExtra2) {
                    H3(d16);
                    aj ajVar3 = this.I0;
                    if (ajVar3 != null) {
                        ajVar3.h0(intent);
                        return;
                    }
                    return;
                }
                aj ajVar4 = this.I0;
                if (ajVar4 != null) {
                    ajVar4.X(d16);
                    this.I0 = null;
                }
                H3(d16);
                T3(0);
                B3(d16);
                return;
            }
            return;
        }
        if (intExtra != 3 && intExtra != 4) {
            if (intExtra == 1) {
                H3(d16);
                return;
            }
            return;
        }
        aj ajVar5 = this.I0;
        if (ajVar5 != null) {
            ajVar5.X(d16);
            this.I0 = null;
        }
        H3(d16);
        T3(0);
        B3(d16);
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f74658i0, 1, "avideo life_onPause, seq[" + d16 + "]");
        com.tencent.av.r.h0().I1();
        n4(false);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.AVActivity.12
            @Override // java.lang.Runnable
            public void run() {
                ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(AVActivity.this, 2, true);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 50, 1);
            }
        }, 16, null, true);
        this.f74643a1 = true;
        try {
            this.mIsShadow = false;
            super.onPause();
            T3(3);
            aj ajVar = this.I0;
            if (ajVar != null) {
                ajVar.n0();
            }
            if (com.tencent.av.r.h0() != null && !isDestroyed()) {
                com.tencent.av.r.h0().L3("state", "0");
                if ("0".equals(q.a.f74207a)) {
                    com.tencent.av.r.h0().L3("backgroundReason", "5");
                }
            }
            QLog.d(this.f74658i0, 1, "avideo life_onPause end");
            this.f74645b1.a(this.H0);
        } catch (Exception e16) {
            super.finish();
            QLog.w(this.f74658i0, 1, "life_onPause, exit when onPause Exception, seq[" + d16 + "]", e16);
            this.H0.u(d16, 1007);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0182  */
    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onResume() {
        int i3;
        ArrayList<com.tencent.av.gaudio.c> arrayList;
        int i16;
        int i17;
        char c16;
        int i18;
        String str;
        float f16;
        boolean z16;
        String str2;
        long j3;
        boolean z17;
        boolean z18;
        boolean z19;
        VideoLayerUI videoLayerUI;
        int i19 = 1;
        n4(true);
        final long d16 = com.tencent.av.utils.e.d();
        com.tencent.av.utils.e.p(this.f74658i0 + ".onResume.begin");
        int i26 = 0;
        try {
            this.mIsShadow = false;
            super.onResume();
        } catch (IllegalArgumentException e16) {
            QLog.e(this.f74658i0, 1, "onResume IllegalArgumentException " + e16);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.AVActivity.6
            @Override // java.lang.Runnable
            public void run() {
                ((IColorNoteUtil) QRoute.api(IColorNoteUtil.class)).sendUpdateSmallScreenStateBroadcast(AVActivity.this, 2, false);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplication.getContext(), 50, 0);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 50, 1);
                ((IQQFloatingWindowBroadcast) QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplication.getContext(), 50, 2);
            }
        }, 16, null, true);
        SessionInfo f17 = com.tencent.av.n.e().f();
        QLog.w(this.f74658i0, 1, "avideo onResume, mhasStopped[" + this.f74667m1 + "], seq[" + d16 + "], sessionInfo[" + f17 + "]");
        this.f74643a1 = false;
        VideoNodeReporter videoNodeReporter = (VideoNodeReporter) this.H0.B(4);
        if (f17.G) {
            videoNodeReporter.w(f17.b(), 8, 1L);
        }
        if (getIntent().getBooleanExtra("isMakingAcall", false)) {
            videoNodeReporter.w(-1L, 3, 1L);
        }
        if (!this.H0.f0()) {
            this.H0.o();
        }
        this.f74667m1 = false;
        this.f74669n1 = false;
        T3(2);
        com.tencent.av.r.h0().K2(true);
        SmallScreenActivityPlugin smallScreenActivityPlugin = this.Y0;
        if (smallScreenActivityPlugin != null && !this.f74649d1) {
            smallScreenActivityPlugin.g();
        }
        if (com.tencent.av.r.h0().k() || this.f74649d1) {
            final ScreenRecordHelper x06 = com.tencent.av.r.h0().x0();
            this.H0.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.AVActivity.7
                @Override // java.lang.Runnable
                public void run() {
                    if (AVActivity.this.f74649d1) {
                        AVActivity.this.Y0.g();
                        AVActivity.this.f74649d1 = false;
                    }
                    if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && x06.m() && com.tencent.av.n.e().f().f73046k2 == 2) {
                        cw.e.h(VideoAppInterface.N(), 1072, 0L, true);
                        if (!com.tencent.av.screenshare.d.f74296a) {
                            cw.e.g(VideoAppInterface.N(), 1070, 3000L);
                            com.tencent.av.screenshare.d.f74296a = true;
                        }
                    }
                }
            }, 300L);
        }
        this.H0.M().postDelayed(new Runnable() { // from class: com.tencent.av.ui.AVActivity.8
            @Override // java.lang.Runnable
            public void run() {
                if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed()) {
                    SessionInfo f18 = com.tencent.av.n.e().f();
                    if (f18.G()) {
                        com.tencent.av.r.h0().r(f18.f73091w, 229);
                        com.tencent.av.r.h0().j2(229);
                        int i27 = f18.f73035i;
                        com.tencent.av.r.h0().q(f18.f73091w, 21);
                        if (i27 == 1) {
                            f18.p0(d16, "av.onResume.1", 3);
                        } else if (i27 == 2) {
                            f18.p0(d16, "av.onResume.2", 4);
                        }
                        if (f18.I()) {
                            f18.f73067q = 1;
                        } else {
                            f18.f73067q = 3000;
                        }
                        f18.k0(d16, false);
                        f18.Z("AVActivity.onResume", 0);
                        AVActivity.this.U0.k(d16);
                    }
                }
            }
        }, 200L);
        int i27 = f17.f73035i;
        if (i27 == 2) {
            if (f17.z()) {
                String str3 = f17.f73091w;
                boolean z26 = f17.O;
                boolean j16 = com.tencent.av.r.h0().j1(this.f74660j0);
                boolean z27 = f17.M;
                boolean z28 = f17.N;
                if (z28) {
                    String s16 = com.tencent.mobileqq.utils.ah.s();
                    if (!this.K0.isCameraOpening(d16) && !this.K0.isCameraOpened(d16)) {
                        this.K0.openCamera(d16);
                    } else if (s16.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO) && this.K0.getCameraParams() == null) {
                        z17 = z28;
                        z18 = z27;
                        z19 = z26;
                        this.K0.reopenCamera("AVonResume", d16, -1, -1);
                        videoLayerUI = this.J0;
                        if (videoLayerUI != null) {
                            if (z17 && z19) {
                                if (z18) {
                                    videoLayerUI.g3(d16, str3, 1, true, false, j16);
                                    this.J0.f3(d16, true, false);
                                } else {
                                    videoLayerUI.f3(d16, true, false);
                                    this.J0.g3(d16, str3, 1, true, false, j16);
                                }
                            } else if (z17) {
                                videoLayerUI.f3(d16, true, false);
                            } else if (z19) {
                                videoLayerUI.g3(d16, str3, 1, true, false, j16);
                            }
                        }
                    }
                }
                z17 = z28;
                z18 = z27;
                z19 = z26;
                videoLayerUI = this.J0;
                if (videoLayerUI != null) {
                }
            } else if (!f17.f73081t1 && !this.f74684z0) {
                f17.c0(d16, true);
                this.K0.openCamera(d16);
                VideoLayerUI videoLayerUI2 = this.J0;
                if (videoLayerUI2 != null) {
                    videoLayerUI2.f3(d16, true, false);
                }
            }
        } else if (i27 == 4) {
            ArrayList<com.tencent.av.gaudio.c> arrayList2 = f17.f73045k1;
            Collections.sort(arrayList2, new f());
            int H0 = com.tencent.av.r.h0().H0();
            int i28 = 0;
            while (i28 < arrayList2.size()) {
                com.tencent.av.gaudio.c cVar = arrayList2.get(i28);
                String a16 = com.tencent.av.utils.i.a(cVar.f73827a);
                int i29 = cVar.f73828b;
                boolean z29 = cVar.f73829c;
                VideoLayerUI videoLayerUI3 = this.J0;
                if (videoLayerUI3 != null && videoLayerUI3.s2(a16, i29)) {
                    i3 = i19;
                } else {
                    i3 = i26;
                }
                String G = this.H0.G(AVUtil.g(this.f74650e0), a16, String.valueOf(f17.P0));
                if (cVar.f73830d && !a16.equals(this.H0.getCurrentAccountUin()) && z29 && !cVar.f73832f) {
                    if (com.tencent.av.utils.i.e(G) > 20) {
                        str2 = com.tencent.av.utils.i.h(G, i26, 20) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                    } else {
                        str2 = G;
                    }
                    if (i29 == 2) {
                        String string = getString(R.string.dbn);
                        arrayList = arrayList2;
                        Object[] objArr = new Object[1];
                        objArr[i26] = str2;
                        String format = String.format(string, objArr);
                        if (v3()) {
                            this.I0.b1(1036, format);
                        } else {
                            cw.e.p(this.H0, 1036, format);
                        }
                    } else {
                        arrayList = arrayList2;
                        String string2 = getString(R.string.dbo);
                        Object[] objArr2 = new Object[1];
                        objArr2[i26] = str2;
                        String format2 = String.format(string2, objArr2);
                        if (v3()) {
                            aj ajVar = this.I0;
                            if (ajVar != null) {
                                ajVar.b1(1037, format2);
                            }
                        } else {
                            cw.e.p(this.H0, 1037, format2);
                        }
                    }
                } else {
                    arrayList = arrayList2;
                }
                if (this.J0 != null) {
                    p3();
                    boolean z36 = cVar.f73830d;
                    if (!z36 && !(z16 = cVar.f73829c)) {
                        if (H0 != 4) {
                            if (f17.S0 == 2) {
                                DataReport.T(null, "CliOper", "", "", "0X8004CF8", "0X8004CF8", 0, 0, "", "", "", "");
                            } else if (f17.f73063p == 10) {
                                DataReport.T(null, "CliOper", "", "", "0X800594A", "0X800594A", 0, 0, "", "", "", "");
                            } else {
                                DataReport.T(null, "CliOper", "", "", "0X8004F5C", "0X8004F5C", 0, 0, "", "", "", "");
                            }
                            c16 = 4;
                            i18 = i29;
                            str = a16;
                            i16 = i28;
                            i17 = H0;
                            this.J0.b3(d16, a16, i18, this.L0, cVar.f73830d, cVar.f73829c);
                        } else {
                            c16 = 4;
                            i18 = i29;
                            str = a16;
                            i16 = i28;
                            i17 = H0;
                            this.J0.b3(d16, str, i18, this.M0, z36, z16);
                        }
                    } else {
                        i18 = i29;
                        str = a16;
                        i16 = i28;
                        i17 = H0;
                        c16 = 4;
                        this.J0.b3(d16, str, i18, this.M0, z36, cVar.f73829c);
                    }
                    if (i3 == 0 && !f17.f73060o0) {
                        int i36 = i18;
                        String str4 = str;
                        if (this.J0.L0(str4, i36) && this.J0.o2() != 3) {
                            f16 = 18.0f;
                        } else {
                            f16 = 12.0f;
                        }
                        this.J0.i3(str4, i36, G, ba.dp2px(getApplicationContext(), f16), -1);
                        this.J0.j1(str4, i36);
                    }
                } else {
                    i16 = i28;
                    i17 = H0;
                    c16 = 4;
                }
                i28 = i16 + 1;
                arrayList2 = arrayList;
                H0 = i17;
                i19 = 1;
                i26 = 0;
            }
        }
        VideoLayerUI videoLayerUI4 = this.J0;
        if (videoLayerUI4 != null) {
            videoLayerUI4.X0();
        }
        aj ajVar2 = this.I0;
        if (ajVar2 != null) {
            ajVar2.t0(d16);
            if (f17.f73035i == 2) {
                this.I0.I0(d16);
            }
        }
        com.tencent.av.r.h0().L2(false);
        b4();
        M3();
        S3(new Intent("com.tencent.av.ui.AVLoadingDialogActivity.ACTION_LOADING_FINISH"));
        if (this.J0 != null && x3()) {
            this.J0.o3("onResume");
        }
        if (f17.f73002a2 == -1) {
            SharedPreferences U0 = ea.U0(getApplicationContext());
            int i37 = U0.getInt("firstEnter_" + this.H0.getCurrentAccountUin(), 1);
            f17.f73002a2 = i37;
            if (i37 == 1) {
                U0.edit().putInt("firstEnter_" + this.H0.getCurrentAccountUin(), 0).commit();
            }
        }
        if (com.tencent.av.utils.e.j()) {
            try {
                ((IQQDebugApi) QRoute.api(IQQDebugApi.class)).showTestBtn(this);
            } catch (Throwable th5) {
                QLog.i(this.f74658i0, 1, "showTestBtn fail", th5);
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - this.H0.f73117f0;
        if (f17.b() > 0) {
            j3 = f17.b();
        } else {
            j3 = -1;
        }
        videoNodeReporter.w(j3, 25, currentTimeMillis);
        com.tencent.av.r.h0().L3("state", "1");
        com.tencent.av.r.h0().N1();
        q.a.f74207a = "0";
        com.tencent.av.utils.e.p(this.f74658i0 + ".onResume.end");
        if (getIntent().getIntExtra("hc_code", 0) != 0) {
            HardCoderManager.getInstance().stop(getIntent().getIntExtra("hc_code", 0), true);
        }
        com.tencent.av.r.h0().n();
        com.tencent.av.opengl.effects.m R = com.tencent.av.r.h0().R(false);
        if (R != null) {
            R.a(d16);
        }
        if (com.tencent.av.utils.e.j()) {
            QLog.w(this.f74658i0, 1, "getSystemUiVisibility[" + getWindow().getDecorView().getSystemUiVisibility() + "]");
        }
        this.f74645b1.b(this, this.H0);
        if (this.f74657h1 != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f74658i0, 2, "onResume, mCheckFirstShowChatRoomPanel[" + f17.f73018e2 + "]");
            }
            this.f74657h1.x(new a());
            if (f17.f73018e2) {
                this.f74657h1.A(0);
                f17.f73018e2 = false;
            }
            aj ajVar3 = this.I0;
            if (ajVar3 != null) {
                ajVar3.v();
            }
            this.f74657h1.v();
        }
        if (!this.f74653f1) {
            boolean l3 = l3();
            QLog.d(this.f74658i0, 1, "checkQAVPermission hasRequestBluetoothPermission=" + l3);
            ChatActivityUtils.m(getActivity(), true, new b(l3));
            this.f74653f1 = true;
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f74669n1 = true;
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (com.tencent.av.r.h0() != null && !isDestroyed() && sensorEvent != null) {
            com.tencent.avcore.camera.util.b.b(sensorEvent.values);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        this.mIsShadow = false;
        super.onStart();
        T3(1);
        this.f74667m1 = false;
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f74658i0, 1, "avideo life_onStart, seq[" + d16 + "]");
        aj ajVar = this.I0;
        if (ajVar != null) {
            ajVar.y0(d16);
        }
    }

    @Override // mqq.app.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        long d16 = com.tencent.av.utils.e.d();
        QLog.w(this.f74658i0, 1, "onStop, seq[" + d16 + "]");
        super.onStop();
        if (com.tencent.av.r.h0() != null && !isDestroyed()) {
            long c16 = com.tencent.av.utils.e.c();
            this.mIsShadow = false;
            T3(4);
            if (!this.B0) {
                G3(d16);
            }
            c4(d16);
            long c17 = com.tencent.av.utils.e.c();
            V2(d16);
            VideoLayerUI videoLayerUI = this.J0;
            if (videoLayerUI != null) {
                videoLayerUI.a1(false);
            }
            QLog.w(this.f74658i0, 1, "avideo life_onStop, mIsMultiFinish[" + this.B0 + "], seq[" + d16 + "], cost[" + (c17 - c16) + "]");
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (com.tencent.av.r.h0() != null && !isDestroyed() && com.tencent.av.n.e().f().f73063p == 2) {
            return;
        }
        T3(4);
        long d16 = com.tencent.av.utils.e.d();
        if (com.tencent.av.utils.e.k()) {
            QLog.w(this.f74658i0, 1, "life_onUserLeaveHint, seq[" + d16 + "]");
        }
        c4(d16);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(this.f74658i0, 2, "life_onWindowFocusChanged, hasFocus[" + z16 + "], nfonWindowFocus[" + this.f74665l1);
        }
        super.onWindowFocusChanged(z16);
        if (!z16) {
            this.f74665l1 = false;
            return;
        }
        super.getWindow().getDecorView().postDelayed(new onWindowFocusChangedRunnable(), 500L);
        if (zv.b.a().f453493c) {
            zv.b.a().f453511l = SystemClock.elapsedRealtime();
        } else {
            zv.b.a().A = SystemClock.elapsedRealtime();
        }
    }

    public boolean r3() {
        int c36 = c3();
        if (c36 != 2 && c36 != 3) {
            return false;
        }
        return true;
    }

    public boolean s3() {
        VideoLayerUI videoLayerUI = this.J0;
        if (videoLayerUI != null && videoLayerUI.N0()) {
            return true;
        }
        return false;
    }

    public boolean t3() {
        aj ajVar;
        VideoLayerUI videoLayerUI;
        if (isDestroyed() || (ajVar = this.I0) == null || ajVar.E() || this.I0.p() == null) {
            return false;
        }
        if (this.I0.p().v0(1) || this.I0.p().v0(6) || this.I0.p().v0(3) || this.I0.p().v0(6)) {
            return true;
        }
        if (!x3() && ((videoLayerUI = this.J0) == null || !videoLayerUI.N0())) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "TAG[" + this.f74658i0 + "], ActivityState[" + c3() + "], isActivityVisible[" + r3() + "], " + super.toString();
    }

    public boolean u3() {
        return this.f74673p1;
    }

    public boolean v3() {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.F()) {
            return true;
        }
        return false;
    }

    public boolean w3() {
        aj ajVar = this.I0;
        if (ajVar != null && ajVar.G()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x3() {
        aj ajVar = this.I0;
        if (ajVar == null) {
            return false;
        }
        return ajVar.H(4);
    }

    public void y3() {
        SessionInfo f16 = com.tencent.av.n.e().f();
        if (f16 != null && !f16.H2) {
            this.G0 = true;
            f16.H2 = true;
            long d16 = com.tencent.av.utils.e.d();
            VideoLayerUI videoLayerUI = this.J0;
            if (videoLayerUI != null) {
                videoLayerUI.g3(d16, f16.f73091w, 1, false, false, false);
            }
            int i3 = f16.f73035i;
            this.f74644b0 = i3;
            if (i3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(this.f74658i0, 2, "jumpToZplanHome illegal session type.");
                }
                this.f74644b0 = 1;
            }
            if (this.K0.isCameraOpened(d16)) {
                this.K0.closeCamera(d16, true);
                VideoLayerUI videoLayerUI2 = this.J0;
                if (videoLayerUI2 != null) {
                    videoLayerUI2.f3(d16, false, false);
                }
                f16.c0(d16, false);
            }
            if (!f16.I0) {
                this.I0.F0();
                return;
            }
            return;
        }
        QLog.d(this.f74658i0, 1, "jumpToZplanHome IsRequestFromZplan return");
    }

    @Override // com.tencent.mobileqq.app.activitymodule.IActivityPropertyProvider, or.e
    public Activity getActivity() {
        return this;
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public void notifyMultiWindowModeStatusVisibilityChange(int i3) {
    }

    @Override // com.tencent.mobileqq.app.activitymodule.ISystemBarPropertyProvider
    public void setStatusBarVisibilityNeedGone(boolean z16) {
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class MyVideoObserver extends VideoObserver {
        MyVideoObserver() {
        }

        private void e0(boolean z16, SessionInfo sessionInfo) {
            AVActivity.this.finish();
            if (!z16) {
                AVActivity.this.overridePendingTransition(0, SmallScreenUtils.j(sessionInfo.D1));
            } else {
                AVActivity.this.overridePendingTransition(0, R.anim.f154854e3);
            }
        }

        private void f0() {
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.J0 != null) {
                SharedPreferences.Editor edit = ea.U0(aVActivity.getApplicationContext()).edit();
                edit.putInt("video_position", AVActivity.this.J0.y0());
                edit.commit();
                DataReport.V(AVActivity.this.J0.y0());
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void A(boolean z16) {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifySelfZplanAvatarSwitch(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void B(boolean z16) {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyUpdateZplanAvatarFakeBackground(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void C(int i3) {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyUpdateZplanAvatarLoadingProgress(i3);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void D(boolean z16, boolean z17) {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyUpdateZplanAvatarLoadingView(z16, z17);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void E() {
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "[onNotifyUseCellularForQuality]");
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.AVActivity.MyVideoObserver.4
                @Override // java.lang.Runnable
                public void run() {
                    cw.e.n(AVActivity.this.H0, 3024);
                    DataReport.T(null, "dc00898", "", "", "0X800C2AC", "0X800C2AC", 0, 0, "", "", "", "");
                }
            }, 2000L);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void F() {
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "[onNotifyUseCellularForQualityClick]");
            }
            if (!AVActivity.this.isFinishing()) {
                Intent intent = new Intent(AVActivity.this, (Class<?>) GeneralSettingActivity.class);
                intent.putExtra("key_from_where", "form_qav");
                AVActivity.this.startActivity(intent);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void G() {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar.u(false) != null) {
                AVActivity.this.I0.u(false).onNotifyZplanAvatarSwitchLayoutBtn();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void H() {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyZplanAvatarTryTips();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void I() {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.k0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void J() {
            super.J();
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.Q0(true);
                AVActivity.this.I0.m0();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void K() {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 1, "onPauseVideo, begin, seq[" + d16 + "]");
            }
            if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed()) {
                SessionInfo f16 = com.tencent.av.n.e().f();
                VideoLayerUI videoLayerUI = AVActivity.this.J0;
                if (videoLayerUI != null) {
                    videoLayerUI.g3(d16, f16.f73091w, 1, false, false, com.tencent.av.r.h0().j1(AVActivity.this.f74660j0));
                    if (x.g(AVActivity.this) && !f16.F()) {
                        AVActivity.this.i3(false);
                    } else if (!f16.F()) {
                        AVActivity.this.U2(1);
                    }
                }
                aj ajVar = AVActivity.this.I0;
                if (ajVar != null) {
                    ajVar.o0();
                    AVActivity.this.I0.i1(d16, 33554431);
                }
                VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
                if (videoChatRoomUIContoller != null) {
                    videoChatRoomUIContoller.v();
                }
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void L(String str, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i(AVActivity.this.f74658i0, 2, "onPeerSwitchTerminal, bStartSwitch[" + z16 + "]");
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.p0(str, z16);
            }
            if (AVActivity.this.J0 != null && com.tencent.av.n.e().f().O) {
                AVActivity.this.J0.b1(com.tencent.av.n.e().f().f73091w, com.tencent.av.r.h0().j1(AVActivity.this.f74660j0));
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void M(boolean z16, boolean z17) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.q0(z16, z17);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void N(int i3) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.r0(i3);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        @TargetApi(17)
        protected void O(byte[] bArr, int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "onRecvAudioFrame=" + bArr.length + ", type=" + i3 + ", size=" + i16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void P(long j3, boolean z16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.s0(j3, z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void S(long j3, int i3, int i16) {
            ICameraManagerApi iCameraManagerApi;
            aj ajVar = AVActivity.this.I0;
            if ((ajVar == null || ajVar.u(false) == null || !AVActivity.this.I0.u(false).onReopenCamera(i3, i16)) && (iCameraManagerApi = AVActivity.this.K0) != null) {
                iCameraManagerApi.reopenCamera("AVnotify", j3, i3, i16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void U(long j3) {
            boolean z16;
            VideoLayerUI videoLayerUI;
            String str = AVActivity.this.f74658i0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onResumeVideo, mIsDoubleVideoMeeting[");
            sb5.append(AVActivity.this.A0);
            sb5.append("], mVideoLayerUI[");
            if (AVActivity.this.J0 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], isResume[");
            sb5.append(AVActivity.this.isResume());
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.w(str, 1, sb5.toString());
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.v0();
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.AVActivity.MyVideoObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    DoodleLogic.b().k();
                    QavVideoRecordUICtrl.p0(com.tencent.av.r.h0());
                }
            }, 16, null, true);
            AVActivity.this.p3();
            AVActivity.this.checkVideoLayerUI();
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.J0 != null && aVActivity.isResume()) {
                AVActivity.this.J0.g3(j3, com.tencent.av.n.e().f().f73091w, 1, true, false, com.tencent.av.r.h0().j1(AVActivity.this.f74660j0));
                AVActivity.this.J0.b3(j3, com.tencent.av.n.e().f().f73091w, 1, AVActivity.this.M0, true, false);
                aj ajVar2 = AVActivity.this.I0;
                if (ajVar2 != null) {
                    ajVar2.z();
                }
            }
            VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
            if (videoChatRoomUIContoller != null) {
                videoChatRoomUIContoller.v();
            }
            if (AVActivity.this.isInFoldingMode() && AVActivity.this.isInOpenState() && (videoLayerUI = AVActivity.this.J0) != null) {
                videoLayerUI.T1(videoLayerUI.o2());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void V() {
            super.V();
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.Q0(false);
                AVActivity.this.I0.u0();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void W() {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.w0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void X() {
            super.X();
            AVActivity.this.k4();
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.G0();
                AVActivity.this.I0.x0();
            }
            AVActivity aVActivity = AVActivity.this;
            VideoAppInterface videoAppInterface = aVActivity.H0;
            if (videoAppInterface != null) {
                String str = aVActivity.f74660j0;
                if (str != null) {
                    videoAppInterface.y0(aVActivity.f74650e0, str, aVActivity.f74672p0);
                }
                if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed()) {
                    AVActivity.this.f74652f0 = com.tencent.av.n.e().f().B0;
                    AVActivity.this.f74678t0 = com.tencent.av.n.e().f().D0;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(AVActivity.this.f74658i0, 2, "setBindInfo: mBindType = " + AVActivity.this.f74652f0 + ",mBindId = " + AVActivity.this.f74678t0);
                }
                AVActivity aVActivity2 = AVActivity.this;
                aVActivity2.H0.x0(aVActivity2.f74652f0, aVActivity2.f74678t0);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void Y(long j3, String str, boolean z16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.Y0(j3, str, z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        @TargetApi(21)
        public void Z(int i3, int i16, int i17, long j3, int i18) {
            long d16 = com.tencent.av.utils.e.d();
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 2, "onShareStateChange, shareState[" + i3 + "], shareType[" + i16 + "], relationType[" + i17 + "], relationId[" + j3 + "], multiAvType[" + i18 + "], seq[" + d16 + "]");
            }
            if (com.tencent.av.r.h0() != null) {
                AVActivity aVActivity = AVActivity.this;
                if (aVActivity.I0 != null && !aVActivity.isDestroyed()) {
                    SessionInfo f16 = com.tencent.av.n.e().f();
                    if (f16.S0 == i17 && f16.P0 == j3) {
                        if (i16 == 1) {
                            int i19 = f16.f73046k2;
                            if (i19 == 3) {
                                if (AVActivity.this.I0.p() != null) {
                                    AVActivity.this.I0.p().w(false);
                                }
                                ScreenRecordHelper d36 = AVActivity.this.d3();
                                if (d36 != null) {
                                    d36.y(3);
                                }
                                if (!yt.e.c(AVActivity.this.H0.getCurrentAccountUin())) {
                                    AVActivity.this.I0.k1(false, d16);
                                }
                            } else if (i19 == 2) {
                                if (AVActivity.this.I0.p() != null) {
                                    AVActivity.this.I0.p().w(true);
                                }
                                AVActivity.this.I0.C0(d16);
                                SessionInfo f17 = com.tencent.av.n.e().f();
                                com.tencent.av.screenshare.c.c("0X800AD8F", com.tencent.av.screenshare.c.d(f17), String.valueOf(com.tencent.av.screenshare.c.e(f17.f73030h)));
                                if (!yt.e.c(AVActivity.this.H0.getCurrentAccountUin())) {
                                    AVActivity.this.I0.k1(true, d16);
                                }
                                AVActivity.this.I0.i1(d16, 2097152);
                                AVActivity.this.I0.i1(d16, 8388608);
                            }
                            if (f16.f73046k2 == 5) {
                                if (AVActivity.this.I0.p() != null) {
                                    AVActivity.this.I0.p().w(false);
                                }
                                AVActivity.this.I0.B0(d16);
                                AVActivity.this.I0.i1(d16, 2097152);
                                AVActivity.this.I0.i1(d16, 8388608);
                                if (!yt.e.c(AVActivity.this.H0.getCurrentAccountUin())) {
                                    AVActivity.this.I0.k1(false, d16);
                                }
                            }
                        }
                        AVActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.av.ui.AVActivity.MyVideoObserver.2
                            @Override // java.lang.Runnable
                            public void run() {
                                aj ajVar = AVActivity.this.I0;
                                if (ajVar != null) {
                                    ajVar.m1(-1052L);
                                }
                            }
                        });
                        return;
                    }
                    QLog.i(AVConstants.SHARE_TAG, 1, "onShareStateChange, not same session");
                    return;
                }
            }
            QLog.i(AVConstants.SHARE_TAG, 1, "onShareStateChange, VideoController.getInstance() or mControlUI is null. ");
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void a0() {
            cw.e.n(AVActivity.this.H0, IReaderConstants.READER_CB_ENTER_FIND_DONE);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void b(int i3) {
            boolean z16;
            super.b(i3);
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.N(i3);
                aj ajVar2 = AVActivity.this.I0;
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ajVar2.P0(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void b0(String str) {
            AVActivity.this.o4(str);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void c(long j3, long j16, long j17) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.i(j3);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void c0(int i3, int i16) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.A0(i3, i16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void e(long j3, int i3, String str) {
            QLog.w(AVActivity.this.f74658i0, 1, "onClose, reason[" + i3 + "], peerUin[" + str + "], mPeerUin[" + AVActivity.this.f74660j0 + "], seq[" + j3 + "]");
            if (str != null && !ba.equals(str, AVActivity.this.f74660j0)) {
                return;
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar != null) {
                ajVar.T(j3, i3);
            }
            AVCoreLog.printColorLog(AVActivity.this.f74658i0, "DataReport onClose: ");
            AVActivity aVActivity = AVActivity.this;
            EffectPendantTools.a.c(aVActivity.f74658i0, aVActivity.H0);
            a.C10338a.d(AVActivity.this.H0);
            com.tencent.av.ui.effect.toolbar.a.a(AVActivity.this.H0.getCurrentAccountUin());
            ap.a(com.tencent.av.n.e().f());
            com.tencent.mobileqq.statistics.h.c(AVActivity.this.H0);
            String str2 = com.tencent.av.r.h0().J(com.tencent.av.n.e().f().f73091w) + "";
            MagicDataReport.i(AVActivity.this.H0, str2);
            MagicDataReport.m(2, str2);
            MagicDataReport.l(2);
            AVActivity aVActivity2 = AVActivity.this;
            aVActivity2.Z0.n(j3, aVActivity2, 3, 2);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void f(long j3, String str, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 1, "onCloseSessionFinished, peerUin[" + str + "], isQuit[" + z16 + "], seq[" + j3 + "]");
            }
            if (!TextUtils.isEmpty(str) && str.equals(AVActivity.this.f74660j0)) {
                TraeHelper.I().E(j3, TraeConstants.DEVICE_SPEAKERPHONE);
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && ajVar.t() != null) {
                AVActivity.this.I0.t().onCloseSessionFinished();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void g(long j3) {
            boolean z16;
            com.tencent.av.utils.e.p(AVActivity.this.f74658i0 + ".onConnected");
            SessionInfo f16 = com.tencent.av.n.e().f();
            String str = f16.f73091w;
            String str2 = AVActivity.this.f74658i0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onConnected, mVideoLayerUI[");
            if (AVActivity.this.J0 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            sb5.append("], peerUin[");
            sb5.append(str);
            sb5.append("], mShutCamera[");
            sb5.append(AVActivity.this.f74684z0);
            sb5.append("], SessionType[");
            sb5.append(f16.f73035i);
            sb5.append("], seq[");
            sb5.append(j3);
            sb5.append("]");
            QLog.w(str2, 1, sb5.toString());
            VideoLayerUI videoLayerUI = AVActivity.this.J0;
            if (videoLayerUI != null) {
                videoLayerUI.i1();
            }
            int i3 = f16.f73035i;
            if (i3 != 2 && i3 != 4) {
                AVActivity.this.X3(true);
                AVActivity.this.U3();
            } else {
                AVActivity.this.X3(false);
                AVActivity.this.U3();
            }
            if (f16.f73035i == 2) {
                if (AVActivity.this.f74684z0) {
                    f16.c0(j3, false);
                    AVActivity.this.H0.k0(new Object[]{106, Long.valueOf(j3)});
                }
                VideoLayerUI videoLayerUI2 = AVActivity.this.J0;
                if (videoLayerUI2 != null) {
                    videoLayerUI2.g3(j3, f16.f73091w, 1, f16.O, false, com.tencent.av.r.h0().j1(AVActivity.this.f74660j0));
                }
            }
            if (f16.f73035i == 1) {
                f16.c0(j3, false);
            }
            com.tencent.av.r.h0().D3(j3);
            AVActivity.this.R2(j3);
            if (f16.H2) {
                AVActivity.this.H0.v0(true, new Notification());
            } else if (AVActivity.this.H0.isBackgroundStop) {
                com.tencent.av.r.h0().K3();
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.U(j3);
                AVActivity.this.I0.g0();
            }
            if (f16.O) {
                DoodleLogic.b().k();
            }
            AVActivity aVActivity = AVActivity.this;
            aVActivity.Z0.n(j3, aVActivity, 4, 0);
            VideoChatRoomUIContoller videoChatRoomUIContoller = AVActivity.this.f74657h1;
            if (videoChatRoomUIContoller != null) {
                videoChatRoomUIContoller.v();
            }
            if (!TextUtils.isEmpty(str)) {
                QAVControllerForZplan.p().M(Long.parseLong(str), false);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void h(String str, boolean z16) {
            if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed()) {
                long d16 = com.tencent.av.utils.e.d();
                SessionInfo f16 = com.tencent.av.n.e().f();
                AVCoreLog.printAllUserLog(AVActivity.this.f74658i0, "onDestroyUI, peerUin[" + str + "], isQuit[" + z16 + "], mPeerUin[" + AVActivity.this.f74660j0 + "], mIsDoubleVideoMeeting[" + AVActivity.this.A0 + "], mSessionType[" + AVActivity.this.f74644b0 + "], mSessionId[" + AVActivity.this.f74648d0 + "], mRelationId[" + AVActivity.this.f74662k0 + "], seq[" + d16 + "], \nsession[" + f16 + "]");
                AVActivity aVActivity = AVActivity.this;
                int i3 = aVActivity.f74644b0;
                if (i3 != 1 && i3 != 2) {
                    if (i3 == 3 || i3 == 4) {
                        String str2 = aVActivity.f74662k0;
                        if (str2 == null || !str2.equals(str)) {
                            AVActivity aVActivity2 = AVActivity.this;
                            if (!aVActivity2.A0 || !TextUtils.equals(aVActivity2.f74660j0, str)) {
                                return;
                            }
                        }
                        AVActivity aVActivity3 = AVActivity.this;
                        aVActivity3.f74683y0 = z16;
                        AVCoreLog.printAllUserLog(aVActivity3.f74658i0, "onDestroyUI exit 2");
                        AVActivity.this.G3(d16);
                        AVActivity.this.B0 = true;
                        e0(z16, f16);
                        return;
                    }
                    return;
                }
                String str3 = aVActivity.f74660j0;
                if (str3 != null && str3.equals(str)) {
                    AVActivity aVActivity4 = AVActivity.this;
                    aVActivity4.f74683y0 = z16;
                    AVCoreLog.printAllUserLog(aVActivity4.f74658i0, "onDestroyUI exit 1");
                    e0(z16, f16);
                }
                f0();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void i(long j3, int i3) {
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.Y(j3, i3);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void k(String str, boolean z16) {
            int i3;
            SessionInfo f16;
            AVCoreLog.printAllUserLog(AVActivity.this.f74658i0, "onFinish peerUin = " + str + " # isQuit :" + z16 + "|" + AVActivity.this.f74644b0 + "|" + AVActivity.this.f74660j0);
            AVActivity aVActivity = AVActivity.this;
            int i16 = aVActivity.f74644b0;
            if (i16 == 1 || i16 == 2) {
                String str2 = aVActivity.f74660j0;
                if (str2 != null && str2.equals(str)) {
                    AVActivity aVActivity2 = AVActivity.this;
                    aVActivity2.f74683y0 = z16;
                    aVActivity2.finish();
                    if (!z16) {
                        if (com.tencent.av.r.h0() != null && !AVActivity.this.isDestroyed() && (f16 = com.tencent.av.n.e().f()) != null) {
                            i3 = SmallScreenUtils.j(f16.D1);
                        } else {
                            i3 = R.anim.f154833da;
                        }
                        AVActivity.this.overridePendingTransition(0, i3);
                    } else {
                        AVActivity.this.overridePendingTransition(0, R.anim.f154854e3);
                    }
                }
                f0();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void l(String str) {
            aj ajVar;
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.f74650e0 == 25 && (ajVar = aVActivity.I0) != null) {
                ajVar.T0(str);
            }
            super.l(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void m(String str, Bitmap bitmap) {
            aj ajVar;
            AVActivity aVActivity = AVActivity.this;
            if (aVActivity.f74650e0 == 25 && (ajVar = aVActivity.I0) != null) {
                ajVar.S0(str, bitmap);
            }
            super.m(str, bitmap);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void n(int i3) {
            aj ajVar;
            if (QLog.isColorLevel()) {
                QLog.w(AVActivity.this.f74658i0, 1, "onGroundGlassSwitch, nOff[" + i3 + "], mSessionType[" + AVActivity.this.f74644b0 + "]");
            }
            AVActivity aVActivity = AVActivity.this;
            if (2 == aVActivity.f74644b0 && (ajVar = aVActivity.I0) != null) {
                ajVar.K0(i3);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void o(int i3) {
            aj ajVar;
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "onGroundGlassWaitTimeChange : nTime=" + i3);
            }
            AVActivity aVActivity = AVActivity.this;
            if (2 == aVActivity.f74644b0 && (ajVar = aVActivity.I0) != null) {
                ajVar.L0(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void p(String str, String str2) {
            super.p(str, str2);
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.Z(str, str2);
            }
            QLog.d(AVActivity.this.f74658i0, 1, "onInviteReached");
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void s() {
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "onNeedShowPeerVideo, mIsDoubleVideoMeeting[" + AVActivity.this.A0 + "], mPeerUin" + AVActivity.this.f74660j0 + "]");
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.f0();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void t(int i3, String str) {
            int i16 = i3 & 3;
            int i17 = (i3 >> 4) & 7;
            int i18 = (i3 >> 7) & 7;
            int i19 = 1;
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, String.format("onNetLevel_S2C, levelInfo[%s], tips[%s], netLevel[%s], s2cSelfNetLevel[%s], s2cPeerNetLevel[%s]", Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
            }
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                if (i16 != 0 && i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            i19 = -1;
                        }
                    } else {
                        i19 = 2;
                    }
                } else {
                    i19 = 3;
                }
                ajVar.O0(i19, i17, i18, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void u() {
            super.u();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.av.app.VideoObserver
        public void v(boolean z16) {
            super.v(z16);
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null) {
                ajVar.i0(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void w(final String str) {
            if (QLog.isColorLevel()) {
                QLog.d(AVActivity.this.f74658i0, 2, "[onNotifyCommonTips] commonTips: " + str);
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.AVActivity.MyVideoObserver.3
                @Override // java.lang.Runnable
                public void run() {
                    cw.e.p(AVActivity.this.H0, 3021, str);
                    DataReport.T(null, "dc00898", "", "", "0X800C0A2", "0X800C0A2", 0, 0, "", "", str, "");
                }
            }, 1000L);
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void x(String str, boolean z16) {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyPeerZplanAvatarSupport(z16);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void y() {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyPeerZplanAvatarSupportTips();
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void z(String str, boolean z16, String str2, int i3) {
            IAVZplanAvatarBizApi u16;
            aj ajVar = AVActivity.this.I0;
            if (ajVar != null && (u16 = ajVar.u(true)) != null) {
                u16.onNotifyPeerZplanAvatarSwitch(str, z16, str2);
            }
        }

        @Override // com.tencent.av.app.VideoObserver
        protected void Q(int i3, int i16) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i3) {
    }
}
