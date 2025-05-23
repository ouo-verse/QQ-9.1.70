package com.tencent.adelie.av.qav;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.tencent.adelie.av.qav.a;
import com.tencent.adelie.av.session.AdelieAVUserInfo;
import com.tencent.av.app.q;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.av.utils.d;
import com.tencent.av.utils.e;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qav.QavDef$MultiUserInfo;
import com.tencent.qav.channel.g;
import com.tencent.qav.monitor.CallingStateMonitor;
import com.tencent.qav.monitor.PhoneStatusAudioModeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.asr.api.IAdelieASRMsgHandlerApi;
import com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common.RobotCallingStatusSync$BotStatusSync;
import com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common.RobotCallingStatusSync$ElapsedTime;
import com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common.RobotCallingStatusSync$ElapsedTimeReport;
import com.tencent.trpcprotocol.group_robot.robot_realtime_speech.common.RobotCallingStatusSync$ToBotData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVController extends com.tencent.adelie.av.qav.a implements q.a {
    public static int L = 10000;
    private static volatile AdelieAVController M;
    private boolean C;
    private boolean E;
    private q F;
    private g G;
    private PhoneStatusAudioModeMonitor H;
    private PhoneStatusMonitor.a I;

    /* renamed from: e, reason: collision with root package name */
    private up.b f61353e;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.adelie.av.qav.b f61356i;

    /* renamed from: m, reason: collision with root package name */
    private a.InterfaceC0520a f61357m;

    /* renamed from: d, reason: collision with root package name */
    private final List<WeakReference<qp.a>> f61352d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    private boolean f61354f = true;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f61355h = new a();
    private boolean D = false;
    private CountDownTimer J = null;
    private com.tencent.qav.controller.multi.c K = new com.tencent.qav.controller.multi.c() { // from class: com.tencent.adelie.av.qav.AdelieAVController.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void f() {
            if (AdelieAVController.J()) {
                com.tencent.qav.log.a.d("AdelieAVController", "onEnterRoom success.");
                up.a E = AdelieAVController.this.E();
                if (E == null) {
                    return;
                }
                AdelieAVController.this.D = true;
                AdelieAVController.this.C = true;
                AdelieAVController.this.E = false;
                AdelieAVController.this.f61354f = true;
                E.h(2);
                AdelieAVController.this.y(false);
                AdelieAVController.this.z(true);
                AdelieAVController.this.f61356i.t(true);
                AdelieAVController.this.V((int) e.d(), 1);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AdelieAVController.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdelieAVController.this.S();
                    }
                }, 16, null, false);
                au.a.a(AdelieAVController.this.f61356i.m(), AdelieAVController.this.f61356i);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.HEADSET_PLUG");
                intentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
                BaseApplication.getContext().registerReceiver(AdelieAVController.this.f61355h, intentFilter);
                if (AdelieAVController.this.f61357m != null) {
                    AdelieAVController.this.f61357m.v(0);
                }
                AdelieAVController.this.f61357m = null;
                if (d.d()) {
                    d.c().j(null, AdelieAVController.this.f61356i.m());
                    AdelieAVController.this.f61356i.m().enableDumpAudioData(true);
                }
                tp.c.g().k(System.currentTimeMillis());
                tp.c.g().n(E.f439396o);
                tp.c.g().j(E.f439387f);
                QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                qQAppInterface.getAVNotifyCenter().S0(6, E.f439386e, E.f439387f, E.f439382a);
                qQAppInterface.getAVNotifyCenter().E0(0, String.valueOf(E.f439387f), null, false);
                qQAppInterface.getAVNotifyCenter().D0(E.f439386e, Long.valueOf(E.f439387f), true);
                qQAppInterface.getAVNotifyCenter().b1(E.f439386e, E.f439387f, false, false);
                QLog.d("AdelieAVController", 1, "onEnterRoom sessionType=" + E.f439382a + " relationType=" + E.f439386e + " relationId=" + E.f439387f);
                for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                    if (weakReference != null && weakReference.get() != 0) {
                        ((qp.a) weakReference.get()).e();
                    }
                }
                AdelieAVController.this.O();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void g(int i3) {
            com.tencent.qav.log.a.d("AdelieAVController", "onError, errorType[" + i3 + "]");
            if (i3 == 2 || i3 == 1) {
                com.tencent.qav.log.a.d("AdelieAVController", "onEnterRoom failed. errorType = " + i3);
                if (AdelieAVController.this.E() == null) {
                    com.tencent.qav.log.a.b("AdelieAVController", "onEnterRoom failed. session == null.");
                    return;
                }
                AdelieAVController.this.f61353e.e(AdelieAVController.this.f61353e.c().f439383b);
                ReportController.o(null, "dc00898", "", "", "0X800B041", "0X800B041", 0, 0, "", "", "", "");
                if (AdelieAVController.this.f61357m != null) {
                    AdelieAVController.this.f61357m.v(i3);
                }
                AdelieAVController.this.f61357m = null;
            }
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).d(i3);
                }
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void i(boolean z16, long j3, int i3) {
            if (AdelieAVController.this.f61353e == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onGoOffStageRet failed. sessionManager == null.");
                return;
            }
            up.a d16 = AdelieAVController.this.f61353e.d(up.a.b(i3, j3));
            if (d16 == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onGoOffStageRet failed. session == null.");
                return;
            }
            com.tencent.qav.log.a.d("AdelieAVController", "onGoOffStageRet, ret[" + z16 + "], relationId[" + j3 + "], relationType[" + i3 + "]");
            d16.i(0);
        }

        @Override // com.tencent.qav.controller.multi.c
        public void j(boolean z16, long j3, int i3) {
            if (AdelieAVController.this.f61353e == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onGoOnStageRet failed. sessionManager == null.");
                return;
            }
            up.a d16 = AdelieAVController.this.f61353e.d(up.a.b(i3, j3));
            if (d16 == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onGoOnStageRet failed. session == null.");
                return;
            }
            com.tencent.qav.log.a.d("AdelieAVController", "onGoOnStageRet, ret[" + z16 + "], relationId[" + j3 + "], relationType[" + i3 + "]");
            if (z16 || d16.f439397p != 1) {
                return;
            }
            d16.i(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void k(boolean z16, long j3, long j16, int i3, long j17, int i16) {
            com.tencent.qav.log.a.a("AdelieAVController", "onMemberVideoInOrOut. videoIn = " + z16 + ", userUin = " + j3);
            if (AdelieAVController.this.f61353e == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onMemberVideoInOrOut failed. sessionManager == null.");
                return;
            }
            up.a d16 = AdelieAVController.this.f61353e.d(up.a.b(i3, j16));
            if (d16 == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onMemberVideoInOrOut failed. session == null.");
                return;
            }
            com.tencent.qav.log.a.a("AdelieAVController", "onMemberVideoInOrOut. updateUserCameraVideoStatus result = " + d16.k(j3, z16, z16 ? 1 : 0));
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).f(z16, j3, 1);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void n(int i3) {
            up.a E = AdelieAVController.this.E();
            if (E == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onSelfVolumeUpdate failed. session == null.");
                return;
            }
            AdelieAVUserInfo d16 = E.d();
            if (d16 != null) {
                d16.mVolumeValue = i3;
            }
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).g(i3);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void o(int i3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onStartRemoteVideoRequestResult. success = ");
            sb5.append(i3 == 96);
            com.tencent.qav.log.a.a("AdelieAVController", sb5.toString());
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).h(i3);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void p(boolean z16) {
            boolean z17 = true;
            QLog.i("AdelieAVController", 1, "onSystemCallStateChanged, isCalling[" + z16 + "], enter[" + AdelieAVController.this.C + "]");
            if (z16) {
                AdelieAVController.this.R();
                if (AdelieAVController.this.f61356i != null) {
                    AdelieAVController.this.f61356i.enableLocalAudio(false);
                }
                AdelieAVController.this.V((int) e.d(), 2);
                if (AdelieAVController.this.J == null) {
                    AdelieAVController.this.J = new a(r1 * 20, AdelieAVController.L);
                } else {
                    AdelieAVController.this.J.cancel();
                }
                AdelieAVController.this.J.start();
            } else {
                AdelieAVController.this.Q();
                if (AdelieAVController.this.f61356i != null) {
                    up.a E = AdelieAVController.this.E();
                    com.tencent.adelie.av.qav.b bVar = AdelieAVController.this.f61356i;
                    if (E != null && E.f439392k) {
                        z17 = false;
                    }
                    bVar.enableLocalAudio(z17);
                }
                if (AdelieAVController.this.J != null) {
                    AdelieAVController.this.J.cancel();
                }
            }
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).i(z16);
                }
            }
            if (z16 && AdelieAVController.this.C) {
                CallingStateMonitor.k().h();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void q(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16) {
            com.tencent.qav.log.a.d("AdelieAVController", "onUserAudioAvailable. uin = " + qavDef$MultiUserInfo.mUin + ", available = " + z16);
            up.a E = AdelieAVController.this.E();
            if (E == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onUserAudioAvailable failed. session == null.");
                return;
            }
            E.a(qavDef$MultiUserInfo);
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).j(qavDef$MultiUserInfo, z16);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void r(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            com.tencent.qav.log.a.d("AdelieAVController", "onUserEnter. uin = " + qavDef$MultiUserInfo.mUin + ", isMicOn = " + qavDef$MultiUserInfo.mMicOn);
            up.a E = AdelieAVController.this.E();
            if (E == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onUserEnter failed. session == null.");
                return;
            }
            AdelieAVUserInfo a16 = E.a(qavDef$MultiUserInfo);
            if (a16 != null) {
                a16.mEnterTime = System.currentTimeMillis();
                com.tencent.qav.log.a.d("AdelieAVController", "onUserEnter time is " + a16.mEnterTime);
            }
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).k(qavDef$MultiUserInfo);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void s(QavDef$MultiUserInfo qavDef$MultiUserInfo) {
            com.tencent.qav.log.a.d("AdelieAVController", "onUserExit. uin = " + qavDef$MultiUserInfo.mUin);
            up.a E = AdelieAVController.this.E();
            if (E == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onUserExit failed. session == null.");
                return;
            }
            E.g(qavDef$MultiUserInfo.mUin);
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).l(qavDef$MultiUserInfo);
                }
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void t(long j3, int i3) {
            com.tencent.qav.log.a.a("AdelieAVController", "onUserFirstVideoFrameIn. userUin = " + j3 + ", videoSrcType = " + i3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void v(QavDef$MultiUserInfo qavDef$MultiUserInfo, boolean z16, int i3) {
            up.a E = AdelieAVController.this.E();
            if (E == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onUserSpeaking failed. session == null.");
                return;
            }
            AdelieAVUserInfo a16 = E.a(qavDef$MultiUserInfo);
            boolean z17 = a16.mIsSpeaking != z16;
            a16.mIsSpeaking = z16;
            a16.mAudioEnergy = i3;
            if (QLog.isDevelopLevel() || z17) {
                com.tencent.qav.log.a.d("AdelieAVController", "onUserSpeaking. uin[ " + qavDef$MultiUserInfo.mUin + "], isSpeaking[" + z16 + "], audioEnergy[" + i3 + "]");
            }
            if (!z16 || i3 >= 10) {
                int i16 = i3 == 0 ? 2968 : i3 == 100 ? 7187 : (int) (((i3 * 4218.75f) / 100.0f) + 2968.75f);
                for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                    if (weakReference != null && weakReference.get() != 0) {
                        ((qp.a) weakReference.get()).m(qavDef$MultiUserInfo, z16, i16);
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void w(List<QavDef$MultiUserInfo> list) {
            up.a E = AdelieAVController.this.E();
            if (E == null) {
                com.tencent.qav.log.a.b("AdelieAVController", "onUserUpdate failed. session == null.");
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (QavDef$MultiUserInfo qavDef$MultiUserInfo : list) {
                com.tencent.qav.log.a.d("AdelieAVController", "onUserUpdate. uin = " + qavDef$MultiUserInfo.mUin + ", isMicOn = " + qavDef$MultiUserInfo.mMicOn);
                E.a(qavDef$MultiUserInfo);
                arrayList.add(Long.valueOf(qavDef$MultiUserInfo.mUin));
            }
            E.j(arrayList);
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).n(list);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.qav.controller.multi.c
        public void y(boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("AdelieAVController", 2, "onVideoChatCallStateChanged, isCalling[" + z16 + "], enter[" + AdelieAVController.this.C + "]");
            }
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).o(z16);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:30:0x013a  */
        @Override // com.tencent.qav.controller.multi.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(long j3, int i3, int i16, long j16, byte[] bArr) {
            String str;
            Exception exc;
            String str2;
            String str3;
            if (j16 == 0) {
                QLog.e("AdelieAVController", 1, "onAdelieRobotStatusChange UNKNOWN_TYPE msg. groupId=" + j3 + " relationType=" + i3 + " multiAVType=" + i16);
                return;
            }
            int i17 = -1;
            String str4 = "";
            int i18 = 0;
            if (j16 != 1) {
                if (j16 == 2) {
                    RobotCallingStatusSync$ElapsedTimeReport robotCallingStatusSync$ElapsedTimeReport = new RobotCallingStatusSync$ElapsedTimeReport();
                    try {
                        robotCallingStatusSync$ElapsedTimeReport.mergeFrom(bArr);
                        if (robotCallingStatusSync$ElapsedTimeReport.elapsed_times.has()) {
                            for (RobotCallingStatusSync$ElapsedTime robotCallingStatusSync$ElapsedTime : robotCallingStatusSync$ElapsedTimeReport.elapsed_times.get()) {
                                int i19 = robotCallingStatusSync$ElapsedTime.path_id.has() ? robotCallingStatusSync$ElapsedTime.path_id.get() : 0;
                                if (!robotCallingStatusSync$ElapsedTime.task_id.has()) {
                                    str = "";
                                } else {
                                    str = robotCallingStatusSync$ElapsedTime.task_id.get();
                                }
                                int i26 = robotCallingStatusSync$ElapsedTime.elapsed_time.has() ? robotCallingStatusSync$ElapsedTime.elapsed_time.get() : -1;
                                QLog.i("AdelieAVController", 1, "onAdelieRobotStatusChange ElapsedTime, pathId=" + i19 + ", taskId=" + str + ", elapsedTime=" + i26 + ", server timestamp=" + (robotCallingStatusSync$ElapsedTime.curr_time.has() ? robotCallingStatusSync$ElapsedTime.curr_time.get() : 0L));
                                tp.c.g().e(i19, i26);
                            }
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        QLog.d("AdelieAVController", 1, "onAdelieRobotStatusChange error: " + e16);
                        return;
                    }
                }
                return;
            }
            RobotCallingStatusSync$BotStatusSync robotCallingStatusSync$BotStatusSync = new RobotCallingStatusSync$BotStatusSync();
            try {
                robotCallingStatusSync$BotStatusSync.mergeFrom(bArr);
                i17 = robotCallingStatusSync$BotStatusSync.status.get();
                if (!robotCallingStatusSync$BotStatusSync.speech_msg.has()) {
                    str2 = "";
                } else {
                    int i27 = robotCallingStatusSync$BotStatusSync.speech_msg.send_type.get();
                    try {
                        str3 = robotCallingStatusSync$BotStatusSync.speech_msg.text_msg.get();
                    } catch (Exception e17) {
                        exc = e17;
                        i18 = i27;
                        str2 = "";
                        QLog.d("AdelieAVController", 1, "onAdelieRobotStatusChange error: " + exc);
                        QLog.i("AdelieAVController", 1, "onAdelieRobotStatusChange groupId=" + j3 + " relationType=" + i3 + " multiAVType=" + i16 + " msgType=" + j16 + " status=" + i17 + " speechMsgType=" + i18 + " msg=" + str4 + " upgradeMsg=" + str2);
                        while (r0.hasNext()) {
                        }
                    }
                    try {
                        str4 = robotCallingStatusSync$BotStatusSync.speech_msg.upgrade_msg.get();
                        if (i27 != 1 && !TextUtils.isEmpty(str4)) {
                            str3 = str4;
                        }
                        if (!TextUtils.isEmpty(str3)) {
                            RobotCallingStatusSync$ToBotData robotCallingStatusSync$ToBotData = new RobotCallingStatusSync$ToBotData();
                            robotCallingStatusSync$ToBotData.realtime_speech_msg.set(1);
                            ((IAdelieASRMsgHandlerApi) QRoute.api(IAdelieASRMsgHandlerApi.class)).addAndSendASRMsg(String.valueOf(j3), str3, robotCallingStatusSync$ToBotData.toByteArray());
                        }
                        i18 = i27;
                        str2 = str4;
                        str4 = str3;
                    } catch (Exception e18) {
                        exc = e18;
                        i18 = i27;
                        str2 = str4;
                        str4 = str3;
                        QLog.d("AdelieAVController", 1, "onAdelieRobotStatusChange error: " + exc);
                        QLog.i("AdelieAVController", 1, "onAdelieRobotStatusChange groupId=" + j3 + " relationType=" + i3 + " multiAVType=" + i16 + " msgType=" + j16 + " status=" + i17 + " speechMsgType=" + i18 + " msg=" + str4 + " upgradeMsg=" + str2);
                        while (r0.hasNext()) {
                        }
                    }
                }
            } catch (Exception e19) {
                exc = e19;
            }
            QLog.i("AdelieAVController", 1, "onAdelieRobotStatusChange groupId=" + j3 + " relationType=" + i3 + " multiAVType=" + i16 + " msgType=" + j16 + " status=" + i17 + " speechMsgType=" + i18 + " msg=" + str4 + " upgradeMsg=" + str2);
            for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).a(j3, i17);
                }
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.adelie.av.qav.AdelieAVController$2$a */
        /* loaded from: classes37.dex */
        class a extends CountDownTimer {
            a(long j3, long j16) {
                super(j3, j16);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                if (AdelieAVController.J()) {
                    AdelieAVController.D().V((int) e.d(), 2);
                }
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
            }
        }

        @Override // com.tencent.qav.controller.multi.c
        public void x(long j3, int i3, long j16, int i16) {
        }
    };

    /* compiled from: P */
    /* renamed from: com.tencent.adelie.av.qav.AdelieAVController$6, reason: invalid class name */
    /* loaded from: classes37.dex */
    class AnonymousClass6 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f61364d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f61365e;
        final /* synthetic */ AdelieAVController this$0;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            for (WeakReference weakReference : this.this$0.f61352d) {
                if (weakReference != null && weakReference.get() != 0) {
                    ((qp.a) weakReference.get()).c(this.f61364d, this.f61365e);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AdelieAVController.this.L(context, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements PhoneStatusMonitor.a {
        c() {
        }

        @Override // com.tencent.av.utils.PhoneStatusMonitor.a
        public void a(boolean z16) {
            if (AdelieAVController.this.K != null) {
                AdelieAVController.this.K.p(z16);
            } else {
                QLog.e("AdelieAVController", 1, "PhoneStatusAudioModeMonitor onCall. MultiObserver is null");
            }
        }
    }

    AdelieAVController() {
        com.tencent.qav.log.a.d("AdelieAVController", "AdelieAVController create and init.");
        QLog.i("AdelieAVController", 1, "init, [" + BaseApplicationImpl.getApplication().getQQProcessName() + "]");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        com.tencent.qav.log.a.f(new com.tencent.qav.log.c());
        this.G = new b();
        com.tencent.qav.channel.c z16 = com.tencent.qav.channel.c.z();
        z16.A(runtime);
        z16.y(this.G);
        long longAccountUin = runtime.getLongAccountUin();
        Context applicationContext = BaseApplicationImpl.getApplication().getApplicationContext();
        com.tencent.adelie.av.qav.c cVar = new com.tencent.adelie.av.qav.c(applicationContext, new com.tencent.adelie.av.qav.b(applicationContext, longAccountUin, z16, true));
        com.tencent.qav.b b16 = com.tencent.qav.b.b();
        b16.f(cVar);
        b16.d(applicationContext, longAccountUin, z16);
        this.f61356i = (com.tencent.adelie.av.qav.b) com.tencent.qav.b.b().c();
        this.f61353e = new up.b();
        b16.a(this.K);
        q qVar = new q(this);
        this.F = qVar;
        AppNetConnInfo.registerConnectionChangeReceiver(applicationContext, qVar);
        M();
    }

    public static AdelieAVController D() {
        if (M == null) {
            synchronized (AdelieAVController.class) {
                if (M == null) {
                    M = new AdelieAVController();
                }
            }
            QLog.d("AdelieAVController", 1, "getInstance ", new Throwable());
        }
        return M;
    }

    private boolean H() {
        int i3;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter.isEnabled()) {
            if (ContextCompat.checkSelfPermission(BaseApplication.getContext(), QQPermissionConstants.Permission.BLUETOOTH_CONNECT) != 0) {
                QLog.d("AdelieAVController", 1, "isBluetoothOn has not permission");
            }
            i3 = defaultAdapter.getProfileConnectionState(2);
            int profileConnectionState = defaultAdapter.getProfileConnectionState(1);
            int profileConnectionState2 = defaultAdapter.getProfileConnectionState(3);
            if (i3 != 2) {
                if (profileConnectionState == 2) {
                    i3 = profileConnectionState;
                } else if (profileConnectionState2 == 2) {
                    i3 = profileConnectionState2;
                }
            }
            return i3 != -1 || ((AudioManager) BaseApplication.getContext().getSystemService("audio")).isBluetoothA2dpOn();
        }
        i3 = -1;
        if (i3 != -1) {
            return true;
        }
    }

    public static boolean J() {
        if (M == null) {
            com.tencent.qav.log.a.h("AdelieAVController", "ERROR!!! Instance == null. ", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
        }
        return M != null;
    }

    private void K(final int i3, final int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AdelieAVController.7
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                for (WeakReference weakReference : AdelieAVController.this.f61352d) {
                    if (weakReference != null && weakReference.get() != 0) {
                        ((qp.a) weakReference.get()).c(i3, i16);
                    }
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(Context context, final Intent intent) {
        final String action = intent.getAction();
        if (action == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AdelieAVController.5
            @Override // java.lang.Runnable
            public void run() {
                if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
                    QLog.d("AdelieAVController", 1, String.format("onReceive ACTION_AUDIO_STATE_CHANGED state=%s", Integer.valueOf(intExtra)));
                    if (intExtra == 12) {
                        int i3 = AdelieAVController.this.f61354f ? -1 : 0;
                        AdelieAVController.this.f61354f = false;
                        AdelieAVController.this.T(2, i3);
                        return;
                    } else {
                        if (intExtra == 10) {
                            AdelieAVController.this.U(2);
                            return;
                        }
                        return;
                    }
                }
                if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                    int intExtra2 = intent.getIntExtra("state", -1);
                    QLog.d("AdelieAVController", 1, String.format("onReceive ACTION_HEADSET_PLUG state=%s", Integer.valueOf(intExtra2)));
                    if (intExtra2 == 0) {
                        AdelieAVController.this.U(0);
                        return;
                    } else {
                        if (intExtra2 == 1) {
                            AdelieAVController.this.T(0, 3);
                            return;
                        }
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(action)) {
                    int intExtra3 = intent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
                    QLog.d("AdelieAVController", 1, String.format("onReceive ACTION_CONNECTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra3)));
                    if (intExtra3 == 2) {
                        AdelieAVController.this.T(2, 0);
                        return;
                    } else {
                        if (intExtra3 == 0) {
                            AdelieAVController.this.U(2);
                            return;
                        }
                        return;
                    }
                }
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
                    int intExtra4 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    QLog.d("AdelieAVController", 1, String.format("onReceive ACTION_STATE_CHANGED state=%s", Integer.valueOf(intExtra4)));
                    if (intExtra4 == 10 || intExtra4 == 13) {
                        AdelieAVController.this.U(2);
                    }
                }
            }
        }, 16, null, false);
    }

    private void M() {
        try {
            if (this.H == null && Build.VERSION.SDK_INT >= 31) {
                this.H = new PhoneStatusAudioModeMonitor();
                c cVar = new c();
                this.I = cVar;
                this.H.i(cVar);
                this.H.j(BaseApplication.getContext());
                QLog.d("AdelieAVController", 1, "[registerPhoneCallAudioModeMonitor] register android s phone call.");
            }
        } catch (Throwable th5) {
            QLog.e("AdelieAVController", 1, "[registerPhoneCallAudioModeMonitor] error: ", th5);
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AdelieAVController.9
            @Override // java.lang.Runnable
            public void run() {
                AVBizModuleFactory.getModuleByName(Constants.Business.QQ_RTC).requestAVFocus();
            }
        }, 16, null, true);
    }

    private void W() {
        PhoneStatusAudioModeMonitor phoneStatusAudioModeMonitor = this.H;
        if (phoneStatusAudioModeMonitor == null) {
            return;
        }
        phoneStatusAudioModeMonitor.o(BaseApplication.getContext());
        PhoneStatusMonitor.a aVar = this.I;
        if (aVar != null) {
            this.H.n(aVar);
            this.I = null;
        }
    }

    private void u() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AdelieAVController.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AVBizModuleFactory.getModuleByName(Constants.Business.QQ_RTC).abandonAVFocus();
                    AVBizModuleFactory.removeModuleByName(Constants.Business.QQ_RTC);
                } catch (Exception e16) {
                    QLog.e("AdelieAVController", 1, "abandonAVFocusOnSubThread exception:" + e16.toString());
                }
            }
        }, 16, null, true);
    }

    public static void x() {
        if (M != null) {
            synchronized (AdelieAVController.class) {
                if (M != null) {
                    M.w();
                }
                M = null;
            }
            QLog.d("AdelieAVController", 1, "destroyInstance ", new Throwable());
        }
    }

    public int A(String str, String str2, int i3, int i16, a.InterfaceC0520a interfaceC0520a) {
        if (!J() || this.f61353e == null) {
            return -1;
        }
        tp.c.g().o(System.currentTimeMillis());
        QLog.i("AdelieAVController", 1, "enterRoom. businessRoomId[" + str + "], onEnterRoom[" + interfaceC0520a + "], sourceType[" + i16 + "], svrRecordFlag[" + i3 + "] tid=" + Thread.currentThread().getId());
        long longAccountUin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
        if (longAccountUin == 0) {
            com.tencent.qav.log.a.b("AdelieAVController", "enterRoom failed. selfUin[" + longAccountUin + "] is illegal.");
            return -1;
        }
        long parseLong = Long.parseLong(str);
        if (parseLong == 0) {
            QLog.e("AdelieAVController", 1, "enterRoom failed. invalid args. [" + str + "]");
            return -1;
        }
        up.a c16 = this.f61353e.c();
        if (c16 != null) {
            QLog.e("AdelieAVController", 1, "enterRoom failed. a call already exist. relation id(or peer uin) = " + c16.f439387f + ", sessionId = " + c16.f439383b);
            return -1;
        }
        String b16 = up.a.b(12, parseLong);
        up.a d16 = this.f61353e.d(b16);
        if (d16 != null) {
            QLog.e("AdelieAVController", 1, "enterRoom failed. a call already exist. relation id = " + d16.f439387f + ", sessionId = " + d16.f439383b);
            return -1;
        }
        up.a b17 = this.f61353e.b(1, b16, true);
        if (b17 == null) {
            QLog.e("AdelieAVController", 1, "enterRoom failed. create session fail");
            return -1;
        }
        b17.f439386e = 12;
        b17.f439387f = parseLong;
        b17.f439388g = false;
        b17.f439389h = true;
        b17.f439390i = str2;
        b17.h(1);
        b17.f439396o = longAccountUin;
        com.tencent.qav.a aVar = new com.tencent.qav.a();
        aVar.f342343a = 12;
        aVar.f342344b = 18;
        aVar.f342345c = 1;
        aVar.f342346d = parseLong;
        aVar.f342348f = "";
        aVar.f342347e = b17.f439396o;
        aVar.f342349g = i16;
        aVar.f342351i = i3;
        int e16 = this.f61356i.e(aVar);
        if (e16 == 0) {
            this.f61357m = interfaceC0520a;
        } else {
            QLog.e("AdelieAVController", 1, "enterRoom failed. retCode = " + e16);
            up.b bVar = this.f61353e;
            bVar.e(bVar.c().f439383b);
        }
        if (!e.f77109a) {
            e.f77109a = e.j();
            e.t(longAccountUin);
        }
        return e16;
    }

    public boolean B() {
        if (!J()) {
            return true;
        }
        V((int) e.d(), 60);
        if (d.d()) {
            d.c().k();
        }
        tp.c.g().l(System.currentTimeMillis());
        tp.c.g().m(this.f61356i.m().getAibotQualityReportInfo());
        tp.c.g().i();
        up.a E = E();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("exitRoom, session[");
        sb5.append(E == null ? null : E.f439383b);
        sb5.append("] tid=");
        sb5.append(Thread.currentThread().getId());
        com.tencent.qav.log.a.b("AdelieAVController", sb5.toString());
        CallingStateMonitor.k().i();
        if (com.tencent.qav.b.b().c() != null) {
            com.tencent.qav.b.b().c().setEncodeDecodePtr(-1L, true, false);
        }
        au.a.b();
        if (E == null) {
            com.tencent.qav.log.a.b("AdelieAVController", "exitRoom failed. session == null.");
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        qQAppInterface.getAVNotifyCenter().D0(E.f439386e, Long.valueOf(E.f439387f), false);
        qQAppInterface.getAVNotifyCenter().S0(8, E.f439386e, E.f439387f, 0);
        E.h(3);
        up.b bVar = this.f61353e;
        if (bVar != null) {
            bVar.e(bVar.c().f439383b);
        }
        com.tencent.qav.log.a.d("AdelieAVController", "exitRoom mSessionManager has clear");
        this.f61356i.exitRoom();
        E.h(4);
        this.E = true;
        this.D = false;
        u();
        return true;
    }

    public int C() {
        com.tencent.adelie.av.qav.b bVar;
        if (J() && F() && (bVar = this.f61356i) != null) {
            return bVar.getAudioRoute();
        }
        return 0;
    }

    public up.a E() {
        up.b bVar;
        if (!J() || (bVar = this.f61353e) == null) {
            return null;
        }
        return bVar.c();
    }

    public boolean F() {
        return this.D;
    }

    public boolean G() {
        return this.D;
    }

    public boolean I() {
        return ((AudioManager) BaseApplication.getContext().getSystemService("audio")).isWiredHeadsetOn();
    }

    public void P(final int i3) {
        if (J() && F()) {
            com.tencent.qav.log.a.a("AdelieAVController", "setAudioRoute route = " + i3);
            up.a E = E();
            if (E != null) {
                E.f439391j = i3 == 1;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.adelie.av.qav.AdelieAVController.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AdelieAVController.this.f61356i != null) {
                        AdelieAVController.this.f61356i.setAudioRoute(i3);
                    }
                }
            }, 16, null, false);
            K(i3, 0);
        }
    }

    public void Q() {
        if (F()) {
            this.f61356i.O();
        }
    }

    public void R() {
        if (F()) {
            this.f61356i.P();
        }
    }

    public void V(int i3, int i16) {
        RobotCallingStatusSync$BotStatusSync robotCallingStatusSync$BotStatusSync = new RobotCallingStatusSync$BotStatusSync();
        robotCallingStatusSync$BotStatusSync.status.set(i16);
        robotCallingStatusSync$BotStatusSync.seq.set(i3);
        com.tencent.adelie.av.qav.b bVar = this.f61356i;
        if (bVar != null && bVar.m() != null) {
            this.f61356i.m().sendGeneralRawChannelData(1, robotCallingStatusSync$BotStatusSync.toByteArray());
        }
        QLog.d("AdelieAVController", 1, "syncChatStatus seq=" + i3 + " status=" + i16 + " byteSize=" + robotCallingStatusSync$BotStatusSync.toByteArray().length);
    }

    @Override // com.tencent.av.app.q.a
    public void onApnChanged(int i3) {
        QLog.d("AdelieAVController", 1, "onApnChanged netType=" + i3);
        for (WeakReference<qp.a> weakReference : this.f61352d) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().b(i3);
            }
        }
    }

    public void w() {
        com.tencent.qav.log.a.d("AdelieAVController", "destroy.");
        com.tencent.qav.b.b().e(this.K);
        this.K = null;
        up.b bVar = this.f61353e;
        if (bVar != null) {
            bVar.a();
            this.f61353e = null;
        }
        com.tencent.qav.channel.c.z().y(null);
        com.tencent.qav.channel.c.z().a(null);
        this.G = null;
        q qVar = this.F;
        if (qVar != null) {
            AppNetConnInfo.unregisterNetInfoHandler(qVar);
            this.F = null;
        }
        com.tencent.adelie.av.qav.b bVar2 = this.f61356i;
        if (bVar2 != null) {
            bVar2.l();
            this.f61356i = null;
        }
        com.tencent.qav.b.b().g();
        if (this.C) {
            this.C = false;
            BaseApplication.getContext().unregisterReceiver(this.f61355h);
            this.f61355h = null;
        }
        this.f61352d.clear();
        tp.c.f();
        CountDownTimer countDownTimer = this.J;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.J = null;
        }
        W();
    }

    public void y(boolean z16) {
        if (J() && F()) {
            com.tencent.adelie.av.qav.b bVar = this.f61356i;
            if (bVar != null) {
                bVar.enableLocalAudio(z16);
            }
            up.a E = E();
            if (E != null) {
                E.f439392k = !z16;
            }
        }
    }

    public void z(boolean z16) {
        if (J() && F()) {
            com.tencent.adelie.av.qav.b bVar = this.f61356i;
            if (bVar != null) {
                bVar.enableRemoteAudio(z16);
            }
            up.a E = E();
            if (E != null) {
                E.f439395n = !z16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        char c16 = 2;
        QLog.d("AdelieAVController", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s", Boolean.valueOf(I()), Boolean.valueOf(H())));
        com.tencent.qav.controller.multi.a c17 = com.tencent.qav.b.b().c();
        if (c17 != null) {
            if (I()) {
                c17.setAudioRoute(0);
                c16 = 0;
            } else if (H()) {
                c17.setAudioRoute(2);
            } else {
                c17.setAudioRoute(1);
                c16 = 1;
            }
            up.a E = E();
            if (E != null) {
                E.f439391j = c16 == 1;
            }
            K(c17.getAudioRoute(), -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i3, int i16) {
        QLog.d("AdelieAVController", 1, String.format("switchAudioRoute route=%s isHeadsetPlugged=%s isBluetoothOn=%s subType = %s", Integer.valueOf(i3), Boolean.valueOf(I()), Boolean.valueOf(H()), Integer.valueOf(i16)));
        com.tencent.qav.controller.multi.a c16 = com.tencent.qav.b.b().c();
        if (c16 != null) {
            c16.setAudioRoute(i3);
            K(c16.getAudioRoute(), i16);
        }
        up.a E = E();
        if (E != null) {
            E.f439391j = i3 == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i3) {
        int i16 = 3;
        char c16 = 2;
        QLog.d("AdelieAVController", 1, String.format("switchAudioRoute isHeadsetPlugged=%s isBluetoothOn=%s current = %d", Boolean.valueOf(I()), Boolean.valueOf(H()), Integer.valueOf(i3)));
        com.tencent.qav.controller.multi.a c17 = com.tencent.qav.b.b().c();
        if (c17 != null) {
            if (i3 != 0 && I()) {
                c17.setAudioRoute(0);
                c16 = 0;
            } else if (i3 != 2 && H()) {
                c17.setAudioRoute(2);
                i16 = 0;
            } else {
                c17.setAudioRoute(1);
                i16 = 0;
                c16 = 1;
            }
            up.a E = E();
            if (E != null) {
                E.f439391j = c16 == 1;
            }
            K(c17.getAudioRoute(), i16);
        }
    }

    public void N(qp.a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<qp.a> weakReference : this.f61352d) {
            if (weakReference != null && weakReference.get() != null && weakReference.get() == aVar) {
                this.f61352d.remove(weakReference);
                return;
            }
        }
    }

    public void v(qp.a aVar) {
        if (aVar == null) {
            return;
        }
        for (WeakReference<qp.a> weakReference : this.f61352d) {
            if (weakReference != null && weakReference.get() != null && weakReference.get() == aVar) {
                return;
            }
        }
        this.f61352d.add(new WeakReference<>(aVar));
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements g {
        b() {
        }

        @Override // com.tencent.qav.channel.g
        public boolean b(int i3) {
            return false;
        }

        @Override // com.tencent.qav.channel.g
        public boolean a(int i3) {
            boolean z16 = i3 + (-32) == 8;
            com.tencent.qav.log.a.a("AdelieAVController", String.format("isMultiVideoMsgSupport type=0x%X support=%s", Integer.valueOf(i3), Boolean.valueOf(z16)));
            return z16;
        }
    }
}
