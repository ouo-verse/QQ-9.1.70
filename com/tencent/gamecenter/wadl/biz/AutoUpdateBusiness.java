package com.tencent.gamecenter.wadl.biz;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcSsoService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import nl0.h;
import tencent.im.qqgame.QQGameAutoUpdateTask$CircleGameConfig;
import tencent.im.qqgame.QQGameAutoUpdateTask$GetGameUpdatesReq;
import tencent.im.qqgame.QQGameAutoUpdateTask$GetGameUpdatesRsp;
import tencent.im.qqgame.QQGameAutoUpdateTask$PreUpdateInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AutoUpdateBusiness implements h, Handler.Callback {
    private Handler C;

    /* renamed from: d, reason: collision with root package name */
    private long f106705d;

    /* renamed from: f, reason: collision with root package name */
    private IQQGameCheckService f106707f;

    /* renamed from: i, reason: collision with root package name */
    private int f106709i;

    /* renamed from: m, reason: collision with root package name */
    private long f106710m;

    /* renamed from: e, reason: collision with root package name */
    private long f106706e = 30;

    /* renamed from: h, reason: collision with root package name */
    private HashSet<String> f106708h = new HashSet<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        QLog.i("Wadl_AutoUpdateBusiness", 1, "checkAutoDownloadTask");
        if (this.f106707f.hasAppointTask()) {
            GameCenterBroadcastReceiver.c();
            this.f106707f.checkGameCenter(0);
        } else {
            QLog.d("Wadl_AutoUpdateBusiness", 1, "checkAutoDownloadTask has not appoint task");
        }
    }

    private void i() {
        try {
            QLog.w("Wadl_AutoUpdateBusiness", 1, "handleAutoDownloadFail retryCount=" + this.f106709i);
            int i3 = this.f106709i;
            if (i3 < 3) {
                this.f106709i = i3 + 1;
                m();
            }
        } catch (Throwable th5) {
            QLog.e("Wadl_AutoUpdateBusiness", 1, th5.getMessage(), th5);
        }
    }

    private void j(final QQGameAutoUpdateTask$GetGameUpdatesRsp qQGameAutoUpdateTask$GetGameUpdatesRsp) {
        this.f106709i = 0;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoUpdateBusiness.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AutoUpdateBusiness.this.o(qQGameAutoUpdateTask$GetGameUpdatesRsp);
                    boolean q16 = AutoUpdateBusiness.this.q(qQGameAutoUpdateTask$GetGameUpdatesRsp.update_games.get());
                    AutoUpdateBusiness.this.p(qQGameAutoUpdateTask$GetGameUpdatesRsp.circle_game_config);
                    if (q16) {
                        AutoUpdateBusiness.this.g();
                    }
                    if (qQGameAutoUpdateTask$GetGameUpdatesRsp.circle_game_config.has_new_version.get()) {
                        AutoUpdateBusiness.this.m();
                    }
                } catch (Throwable th5) {
                    QLog.e("Wadl_AutoUpdateBusiness", 1, "[handlePullAutoDownloadSuccess] exception", th5);
                }
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        long j3;
        long serverTime = NetConnInfoCenter.getServerTime();
        long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_UPDATE_START_PULL_TIME");
        long readFromSpLong2 = GameCenterSpUtils.readFromSpLong("QQGAME_UPDATE_END_PULL_TIME");
        QLog.i("Wadl_AutoUpdateBusiness", 1, "optScheduleJob startTime=" + GameCenterUtil.getDateStr(readFromSpLong) + " endTime=" + GameCenterUtil.getDateStr(readFromSpLong2) + ",now=" + GameCenterUtil.getDateStr(serverTime));
        if (serverTime >= readFromSpLong && serverTime <= readFromSpLong2) {
            if (!this.C.hasMessages(1) && !this.C.hasMessages(2)) {
                long readFromSpLong3 = GameCenterSpUtils.readFromSpLong("QQGAME_UPDATE_NEXT_TIME");
                long j16 = 0;
                if (readFromSpLong3 > 0 && readFromSpLong3 > readFromSpLong && readFromSpLong3 <= readFromSpLong2) {
                    if (readFromSpLong3 > serverTime) {
                        j3 = readFromSpLong3 - serverTime;
                    } else {
                        j3 = -1;
                    }
                    QLog.i("Wadl_AutoUpdateBusiness", 2, "optScheduleJob nextTime:" + GameCenterUtil.getDateStr(readFromSpLong3) + ",nextDelay=" + j3);
                } else {
                    j3 = -1;
                }
                if (j3 == -1) {
                    long j17 = serverTime - this.f106710m;
                    QLog.i("Wadl_AutoUpdateBusiness", 1, "optScheduleJob loadGap=" + this.f106706e + ",lastRequestTime:" + GameCenterUtil.getDateStr(this.f106710m) + ",lostTime:" + j17);
                    long j18 = this.f106706e;
                    if (j17 < j18 && j17 >= 0) {
                        j16 = j18 - j17;
                    }
                    QLog.i("Wadl_AutoUpdateBusiness", 1, "optScheduleJob from schedule, nextDelay=" + j16);
                    this.C.sendEmptyMessageDelayed(1, j16 * 1000);
                    return;
                }
                QLog.i("Wadl_AutoUpdateBusiness", 1, "optScheduleJob from nextTime, nextDelay=" + j3);
                if (this.f106705d != readFromSpLong3) {
                    this.f106705d = readFromSpLong3;
                    this.C.sendEmptyMessageDelayed(2, j3 * 1000);
                    return;
                }
                QLog.w("Wadl_AutoUpdateBusiness", 1, "optScheduleJob from nextTime, nextDelay=" + j3 + ", break, is same time " + this.f106705d);
                return;
            }
            QLog.w("Wadl_AutoUpdateBusiness", 1, "optScheduleJob break, is same message");
            return;
        }
        QLog.w("Wadl_AutoUpdateBusiness", 1, "optScheduleJob break, is time over");
    }

    private void n() {
        QLog.i("Wadl_AutoUpdateBusiness", 1, "requestAutoDownloadTasks...");
        this.f106710m = NetConnInfoCenter.getServerTime();
        QQGameAutoUpdateTask$GetGameUpdatesReq qQGameAutoUpdateTask$GetGameUpdatesReq = new QQGameAutoUpdateTask$GetGameUpdatesReq();
        qQGameAutoUpdateTask$GetGameUpdatesReq.qq_version.set(AppSetting.f99551k);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).requestTrpc(WadlProxyConsts.CMD_TRPC_REQUEST_PRE_UPDATE, qQGameAutoUpdateTask$GetGameUpdatesReq.toByteArray(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(QQGameAutoUpdateTask$GetGameUpdatesRsp qQGameAutoUpdateTask$GetGameUpdatesRsp) {
        int i3 = qQGameAutoUpdateTask$GetGameUpdatesRsp.king_switch.get();
        int i16 = qQGameAutoUpdateTask$GetGameUpdatesRsp.min_electricity.get();
        long j3 = qQGameAutoUpdateTask$GetGameUpdatesRsp.update_gap_druation.get();
        QLog.i("Wadl_AutoUpdateBusiness", 1, "[saveAttr] kingSwitch:" + i3 + ", minElectricity:" + i16 + ", gapDuration:" + j3);
        GameCenterUtil.addKingCardSwitch("QQGAME_KINGCARD_AUTODOWNLOAD_FLAG", i3);
        if (i16 < 1) {
            i16 = 1;
        }
        GameCenterUtil.addMinElectricity("UPDATE_MIN_POWER", i16);
        GameCenterSpUtils.writeToSpLong("QQGAME_UPDATE_DEFAULT_UPDATE_INTERVA", j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(QQGameAutoUpdateTask$CircleGameConfig qQGameAutoUpdateTask$CircleGameConfig) {
        long j3 = qQGameAutoUpdateTask$CircleGameConfig.circle_start_time.get();
        if (j3 != 0) {
            GameCenterSpUtils.writeToSpLong("QQGAME_UPDATE_START_PULL_TIME", j3);
        }
        long j16 = qQGameAutoUpdateTask$CircleGameConfig.circle_end_time.get();
        if (j16 != 0) {
            GameCenterSpUtils.writeToSpLong("QQGAME_UPDATE_END_PULL_TIME", j16);
        }
        long j17 = qQGameAutoUpdateTask$CircleGameConfig.next_time.get();
        GameCenterSpUtils.writeToSpLong("QQGAME_UPDATE_NEXT_TIME", j17);
        long j18 = qQGameAutoUpdateTask$CircleGameConfig.circle_gap_duration.get();
        if (j18 > 0) {
            this.f106706e = j18;
        }
        QLog.i("Wadl_AutoUpdateBusiness", 1, "[saveNextPullTaskTime] pullStartTime:" + GameCenterUtil.getDateStr(j3) + ", pullEndTime:" + GameCenterUtil.getDateStr(j16) + ", nextTime:" + GameCenterUtil.getDateStr(j17) + ", gapDuration:" + j18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q(List<QQGameAutoUpdateTask$PreUpdateInfo> list) {
        IQQGameCheckService iQQGameCheckService;
        if (list != null && !list.isEmpty()) {
            QLog.i("Wadl_AutoUpdateBusiness", 1, "[savePreUpdateData] preUpdateInfos size=" + list.size());
            Iterator<QQGameAutoUpdateTask$PreUpdateInfo> it = list.iterator();
            while (it.hasNext()) {
                ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onGetAutoUpdateInfo(it.next());
            }
            AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
            if (appInterface != null) {
                iQQGameCheckService = (IQQGameCheckService) appInterface.getRuntimeService(IQQGameCheckService.class, "");
            } else {
                iQQGameCheckService = null;
            }
            if (iQQGameCheckService == null) {
                return false;
            }
            iQQGameCheckService.handlePreUpdateList(list);
            return true;
        }
        QLog.i("Wadl_AutoUpdateBusiness", 1, "[savePreUpdateData] preUpdateInfos is empty");
        return false;
    }

    private boolean r() {
        long serverTime = NetConnInfoCenter.getServerTime();
        long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_UPDATE_DEFAULT_UPDATE_INTERVA");
        if (0 == readFromSpLong) {
            readFromSpLong = 86440;
        }
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_AutoUpdateBusiness", 2, "validRepeatTime loadGap=" + readFromSpLong + ", lastRequestTime:" + GameCenterUtil.getDateStr(this.f106710m) + ", now:" + GameCenterUtil.getDateStr(serverTime));
        }
        if (serverTime - this.f106710m >= readFromSpLong) {
            return true;
        }
        return false;
    }

    @Override // nl0.h
    public HashSet<String> getFilterCmds() {
        return this.f106708h;
    }

    public void h(boolean z16) {
        QLog.i("Wadl_AutoUpdateBusiness", 1, "execPullTaskByGap isForce=" + z16);
        if (r() || z16) {
            n();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        QLog.d("Wadl_AutoUpdateBusiness", 2, "handleMessage what=" + message.what);
        int i3 = message.what;
        if (i3 == 1 || i3 == 2) {
            n();
            return false;
        }
        return false;
    }

    public void k(IQQGameCheckService iQQGameCheckService) {
        this.f106707f = iQQGameCheckService;
        this.f106708h.add(WadlProxyConsts.CMD_TRPC_REQUEST_PRE_UPDATE);
        this.C = new Handler(ThreadManagerV2.getQQCommonThreadLooper(), this);
        this.f106710m = GameCenterSpUtils.readFromSpLong("QQGAME_UPDATE_LAST_REQUEST_TIME");
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).addListener(this);
    }

    public void l() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoUpdateBusiness.2
            @Override // java.lang.Runnable
            public void run() {
                GameCenterSpUtils.writeToSpLong("QQGAME_UPDATE_LAST_REQUEST_TIME", AutoUpdateBusiness.this.f106710m);
            }
        }, 64, null, false);
        ((IQQGameTrpcSsoService) QRoute.api(IQQGameTrpcSsoService.class)).removeListener(this);
        this.C.removeCallbacksAndMessages(null);
    }

    @Override // nl0.h
    public void onTrpcRsp(String str, boolean z16, int i3, int i16, Intent intent, Object obj) {
        if (!WadlProxyConsts.CMD_TRPC_REQUEST_PRE_UPDATE.equals(str)) {
            return;
        }
        QLog.w("Wadl_AutoUpdateBusiness", 1, "onTrpcRsp isSucc=" + z16 + ",trpcRspRetCode=" + i3 + ",trpcRspFuncRetCode=" + i16);
        if (!z16) {
            i();
            return;
        }
        QQGameAutoUpdateTask$GetGameUpdatesRsp qQGameAutoUpdateTask$GetGameUpdatesRsp = new QQGameAutoUpdateTask$GetGameUpdatesRsp();
        try {
            qQGameAutoUpdateTask$GetGameUpdatesRsp.mergeFrom((byte[]) obj);
            j(qQGameAutoUpdateTask$GetGameUpdatesRsp);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("Wadl_AutoUpdateBusiness", 1, "[onTrpcRsp] exception", e16);
        }
    }
}
