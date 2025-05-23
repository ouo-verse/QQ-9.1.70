package com.tencent.gamecenter.wadl.biz;

import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameNetService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.g;
import com.tencent.gamecenter.wadl.util.GameCenterSpUtils;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.qqgame.QQGameAutoDownloadTask$CircleGameConfig;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreCircleResponse;
import tencent.im.qqgame.QQGameAutoDownloadTask$GetPreUpdateResponse;
import tencent.im.qqgame.QQGameAutoDownloadTask$PreDownloadInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class AutoDownloadBusiness {

    /* renamed from: a, reason: collision with root package name */
    private Runnable f106701a;

    /* renamed from: b, reason: collision with root package name */
    private IQQGameCheckService f106702b;

    private boolean g(int i3) {
        long k3 = k(i3);
        long l3 = l(i3);
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_AutoDownloadBusiness", 2, "[canScheduleWhenFail] loadGap=" + l3 + ", lastFailTime:" + GameCenterUtil.getDateStr(k3) + ", now: " + GameCenterUtil.getDateStr(serverTime));
        }
        if (serverTime - k3 >= l3) {
            return true;
        }
        return false;
    }

    private long k(int i3) {
        if (i3 == 0) {
            return GameCenterSpUtils.readFromSpLong("QQGAME_UPDATE_FAILED_LASTGET_TIME");
        }
        if (1 == i3) {
            return GameCenterSpUtils.readFromSpLong("QQGAME_PULL_FAILED_LASTGET_TIME");
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(QQGameAutoDownloadTask$CircleGameConfig qQGameAutoDownloadTask$CircleGameConfig) {
        long j3 = qQGameAutoDownloadTask$CircleGameConfig.circle_start_time.get();
        if (j3 != 0) {
            GameCenterSpUtils.writeToSpLong("QQGAME_START_PULL_TIME", j3);
        }
        long j16 = qQGameAutoDownloadTask$CircleGameConfig.circle_end_time.get();
        if (j16 != 0) {
            GameCenterSpUtils.writeToSpLong("QQGAME_END_PULL_TIME", j16);
        }
        long j17 = qQGameAutoDownloadTask$CircleGameConfig.next_check_time.get();
        if (j17 == 0) {
            j17 = qQGameAutoDownloadTask$CircleGameConfig.recent_online_time.get();
            if (QLog.isColorLevel()) {
                QLog.e("Wadl_AutoDownloadBusiness", 2, "[saveNextPullTaskTime] recent_online_time: " + GameCenterUtil.getDateStr(j17));
            }
        }
        GameCenterSpUtils.writeToSpLong("QQGAME_NEXT_PULL_TIME", j17);
        long j18 = qQGameAutoDownloadTask$CircleGameConfig.circle_gap_duration.get();
        if (j18 == 0) {
            j18 = 60;
        }
        GameCenterSpUtils.writeToSpLong("QQGAME_DEFAULT_PULL_INTERVA", j18);
        if (QLog.isColorLevel()) {
            QLog.e("Wadl_AutoDownloadBusiness", 2, "[saveNextPullTaskTime] pullStartTime: " + GameCenterUtil.getDateStr(j3) + ",pullEndTime: " + GameCenterUtil.getDateStr(j16) + ", nextPullTime: " + GameCenterUtil.getDateStr(j17) + ", defaultTimeInterval: " + j18);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(QQGameAutoDownloadTask$GetPreUpdateResponse qQGameAutoDownloadTask$GetPreUpdateResponse) {
        GameCenterSpUtils.writeToSpLong("QQGAME_LASTGET_UPDATE_TIME", NetConnInfoCenter.getServerTime());
        long j3 = qQGameAutoDownloadTask$GetPreUpdateResponse.update_gap_duration.get();
        GameCenterSpUtils.writeToSpLong("QQGAME_DEFAULT_UPDATE_INTERVA", j3);
        long j16 = qQGameAutoDownloadTask$GetPreUpdateResponse.res_valid_duration.get();
        GameCenterUtil.saveResAvilTime(1000 * j16);
        if (QLog.isColorLevel()) {
            QLog.e("Wadl_AutoDownloadBusiness", 2, "[saveNextPullPredownloadTaskTime] loadGap: " + j3 + ",resTs: " + j16);
        }
    }

    protected boolean d() {
        long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_LASTGET_UPDATE_TIME");
        long readFromSpLong2 = GameCenterSpUtils.readFromSpLong("QQGAME_DEFAULT_UPDATE_INTERVA");
        if (0 == readFromSpLong2) {
            readFromSpLong2 = 30;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        g gVar = (g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar == null) {
            gVar = new g(IQQGameConfigService.KEY_CONF_COMM);
        }
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_AutoDownloadBusiness", 2, "GameCenterCheck loadGap=" + readFromSpLong2 + ", lastTime:" + GameCenterUtil.getDateStr(readFromSpLong) + ",isAppointDownload=" + gVar.f106807t + ",isDelayDownload=" + gVar.f106806s + ",isUpdateDownload=" + gVar.f106808u + ",isResApkDownload=" + gVar.f106809v + ",isResDefDownload=" + gVar.f106810w);
        }
        if (serverTime - readFromSpLong >= readFromSpLong2) {
            return true;
        }
        return false;
    }

    protected boolean e() {
        long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_LASTGET_PULL_TIME");
        long readFromSpLong2 = GameCenterSpUtils.readFromSpLong("QQGAME_DEFAULT_PULL_INTERVA");
        if (0 == readFromSpLong2) {
            readFromSpLong2 = 60;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_AutoDownloadBusiness", 2, "[canSchedulePerMinute] loadGap=" + readFromSpLong2 + ", lastTime:" + GameCenterUtil.getDateStr(readFromSpLong));
        }
        if (serverTime - readFromSpLong >= readFromSpLong2) {
            return true;
        }
        return false;
    }

    protected boolean f() {
        boolean z16;
        boolean z17;
        long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_START_PULL_TIME");
        long readFromSpLong2 = GameCenterSpUtils.readFromSpLong("QQGAME_END_PULL_TIME");
        long readFromSpLong3 = GameCenterSpUtils.readFromSpLong("QQGAME_NEXT_PULL_TIME");
        long serverTime = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
            QLog.i("Wadl_AutoDownloadBusiness", 2, "[canSchedulePullTask] pullStartTime: " + GameCenterUtil.getDateStr(readFromSpLong) + " pullEndTime: " + GameCenterUtil.getDateStr(readFromSpLong2) + " pullNextTime: " + GameCenterUtil.getDateStr(readFromSpLong3) + ", now: " + GameCenterUtil.getDateStr(serverTime));
        }
        if (readFromSpLong3 > 0 && readFromSpLong3 <= readFromSpLong2 && serverTime <= readFromSpLong2 && serverTime >= readFromSpLong) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (GameCenterSpUtils.readFromSpInt(WadlProxyConsts.KEY_PULL_AUTODOWNLOAD_SWITCH) == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_AutoDownloadBusiness", 2, "autoDownloadSwitchOn: " + z17 + ", canSchedulePullTask: " + z16);
        }
        if (!z17 || !z16) {
            return false;
        }
        return true;
    }

    protected void h() {
        QLog.d("Wadl_AutoDownloadBusiness", 2, "[pullAutoDownloadTaskCustom]");
        Runnable runnable = this.f106701a;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.f106701a = null;
        }
        long readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_NEXT_PULL_TIME");
        long serverTime = NetConnInfoCenter.getServerTime();
        QLog.i("Wadl_AutoDownloadBusiness", 2, "[pullAutoDownloadTaskCustom] , nextPullTime: " + GameCenterUtil.getDateStr(readFromSpLong) + ",now:" + GameCenterUtil.getDateStr(serverTime));
        long j3 = (readFromSpLong - serverTime) * 1000;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[pullAutoDownloadTaskCustom] , delay: ");
        sb5.append(j3);
        QLog.i("Wadl_AutoDownloadBusiness", 2, sb5.toString());
        if (j3 < 0) {
            long readFromSpLong2 = GameCenterSpUtils.readFromSpLong("QQGAME_DEFAULT_PULL_INTERVA");
            if (readFromSpLong2 < 1) {
                readFromSpLong2 = 60;
            }
            j3 = readFromSpLong2 * 1000;
        }
        this.f106701a = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.7
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("Wadl_AutoDownloadBusiness", 2, "[pullAutoDownloadTaskCustom] getAutoDownloadTask pull");
                ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getAutoDownloadTask(1);
            }
        }, 16, null, true, j3);
    }

    public void i() {
        boolean f16 = f();
        boolean e16 = e();
        QLog.i("Wadl_AutoDownloadBusiness", 1, "[execPullTaskByGap]  canSchedulePullTask: " + f16 + ", canSchedulePerMinute: " + e16);
        if (e16 && f16) {
            try {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("Wadl_AutoDownloadBusiness", 2, "[execPullTaskByGap] getAutoDownloadTask pull");
                        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getAutoDownloadTask(1);
                    }
                }, 192, null, false);
            } catch (Throwable th5) {
                QLog.e("Wadl_AutoDownloadBusiness", 1, th5.getMessage(), th5);
            }
        }
    }

    public void j() {
        boolean d16 = d();
        QLog.i("Wadl_AutoDownloadBusiness", 1, "[execUpdateTaskByGap]  canSchedulePerDay: " + d16);
        if (d16) {
            try {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("Wadl_AutoDownloadBusiness", 2, "[execPullTaskByGap] getAutoDownloadTask update");
                        ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getAutoDownloadTask(0);
                    }
                }, 192, null, false);
                return;
            } catch (Throwable th5) {
                QLog.e("Wadl_AutoDownloadBusiness", 1, th5.getMessage(), th5);
                return;
            }
        }
        QLog.d("Wadl_AutoDownloadBusiness", 2, "execUpdateTask checkGameCenter");
        this.f106702b.checkGameCenter(0);
    }

    protected long l(int i3) {
        long readFromSpLong;
        if (i3 == 0) {
            readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_DEFAULT_UPDATE_INTERVA");
            if (readFromSpLong == 0) {
                return 86440L;
            }
        } else {
            if (1 != i3) {
                return 0L;
            }
            readFromSpLong = GameCenterSpUtils.readFromSpLong("QQGAME_DEFAULT_PULL_INTERVA");
            if (readFromSpLong == 0) {
                return 60L;
            }
        }
        return readFromSpLong;
    }

    public void m(int i3) {
        QLog.i("Wadl_AutoDownloadBusiness", 2, "[handleAutoDownloadFail] mode: " + i3);
        if (i3 == 0) {
            try {
                if (g(i3)) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.5
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getAutoDownloadTask(0);
                        }
                    }, 192, null, false);
                    GameCenterSpUtils.writeToSpLong("QQGAME_UPDATE_FAILED_LASTGET_TIME", NetConnInfoCenter.getServerTime());
                    return;
                }
                return;
            } catch (Throwable th5) {
                QLog.e("Wadl_AutoDownloadBusiness", 1, th5.getMessage(), th5);
                return;
            }
        }
        if (1 == i3) {
            try {
                if (g(i3) && f()) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.6
                        @Override // java.lang.Runnable
                        public void run() {
                            ((IQQGameNetService) QRoute.api(IQQGameNetService.class)).getAutoDownloadTask(1);
                        }
                    }, 192, null, false);
                    GameCenterSpUtils.writeToSpLong("QQGAME_PULL_FAILED_LASTGET_TIME", NetConnInfoCenter.getServerTime());
                }
            } catch (Throwable th6) {
                QLog.e("Wadl_AutoDownloadBusiness", 1, th6.getMessage(), th6);
            }
        }
    }

    public void n(final QQGameAutoDownloadTask$GetPreCircleResponse qQGameAutoDownloadTask$GetPreCircleResponse) {
        QLog.i("Wadl_AutoDownloadBusiness", 2, "[handlePullAutoDownloadSuccess] currentThread: " + Thread.currentThread().getName());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.4
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                try {
                    GameCenterSpUtils.writeToSpLong("QQGAME_LASTGET_PULL_TIME", NetConnInfoCenter.getServerTime());
                    List<QQGameAutoDownloadTask$PreDownloadInfo> list = qQGameAutoDownloadTask$GetPreCircleResponse.pre_download_list.get();
                    boolean z16 = false;
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("[handlePullAutoDownloadSuccess] preDownloadInfos' size: ");
                        if (list != null) {
                            i3 = list.size();
                        } else {
                            i3 = 0;
                        }
                        sb5.append(i3);
                        QLog.i("Wadl_AutoDownloadBusiness", 2, sb5.toString());
                    }
                    if (list != null && list.size() > 0) {
                        AutoDownloadBusiness.this.f106702b.handlePreDownloadList(list);
                        QLog.i("Wadl_AutoDownloadBusiness", 2, "[handlePullAutoDownloadSuccess] checkGameCenter");
                    }
                    AutoDownloadBusiness.this.r(qQGameAutoDownloadTask$GetPreCircleResponse.circle_game_config);
                    if (AutoDownloadBusiness.this.f() && !StringUtil.isEmpty(qQGameAutoDownloadTask$GetPreCircleResponse.circle_game_config.recent_appid.get())) {
                        z16 = true;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("Wadl_AutoDownloadBusiness", 2, "[handlePullAutoDownloadSuccess] canPullNext: " + z16 + "\uff0c recent_appid\uff1a " + qQGameAutoDownloadTask$GetPreCircleResponse.circle_game_config.recent_appid.get());
                    }
                    if (z16) {
                        AutoDownloadBusiness.this.h();
                    }
                } catch (Throwable th5) {
                    QLog.e("Wadl_AutoDownloadBusiness", 1, "[handlePullAutoDownloadSuccess] error=" + th5.toString());
                }
            }
        }, 64, null, false);
    }

    public void o(final QQGameAutoDownloadTask$GetPreUpdateResponse qQGameAutoDownloadTask$GetPreUpdateResponse) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.biz.AutoDownloadBusiness.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AutoDownloadBusiness.this.s(qQGameAutoDownloadTask$GetPreUpdateResponse);
                    AutoDownloadBusiness.this.r(qQGameAutoDownloadTask$GetPreUpdateResponse.circle_game_config);
                    AutoDownloadBusiness.this.f106702b.handlePreDownloadList(qQGameAutoDownloadTask$GetPreUpdateResponse.pre_download_list.get());
                    AutoDownloadBusiness.this.i();
                } catch (Throwable th5) {
                    QLog.e("Wadl_AutoDownloadBusiness", 1, "onGetAutoDownloadApk error=" + th5.toString());
                }
            }
        }, 64, null, false);
    }

    public void p(IQQGameCheckService iQQGameCheckService) {
        this.f106702b = iQQGameCheckService;
    }

    public void q() {
        Runnable runnable = this.f106701a;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.f106701a = null;
        }
    }
}
