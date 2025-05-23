package com.qzone.app;

import NS_MOBILE_USERLOGO_TIMESTAMP.mobile_userlogo_timestamp_rsp;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.qzone.business.vip.QZoneVIPUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.feed.business.service.QZoneRapidCommentService;
import com.qzone.homepage.ui.Facade.QzoneUserLogoTimeStampRequest;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.util.al;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneUpdateService implements IQZoneServiceListener, IObserver.background {

    /* renamed from: i, reason: collision with root package name */
    public static String f44446i = "QZoneUpdateService";

    /* renamed from: m, reason: collision with root package name */
    private static final al<QZoneUpdateService, Void> f44447m = new a();

    /* renamed from: d, reason: collision with root package name */
    private long f44448d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44450f;

    /* renamed from: e, reason: collision with root package name */
    private volatile int f44449e = 2;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f44451h = false;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneUpdateService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneUpdateService a(Void r16) {
            return new QZoneUpdateService();
        }
    }

    QZoneUpdateService() {
    }

    public static QZoneUpdateService b() {
        return f44447m.get(null);
    }

    private void c(Handler handler, long j3, long j16) {
        QZoneTask qZoneTask = new QZoneTask(new QzoneUserLogoTimeStampRequest(j3, VipComponentProxy.f50997g.getServiceInterface().getABTestTimeStamp(), j16), handler, this, 1);
        qZoneTask.addParameter("userLogoTimestampUin", Long.valueOf(j3));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    private boolean e() {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_PRELOAD_PAY_H5_ENABLE, 1);
        if (QZLog.isColorLevel()) {
            QZLog.d(f44446i, 2, "WNS: isPreLoadPayH5Enable=" + config);
        }
        return config == 1;
    }

    private void g(mobile_userlogo_timestamp_rsp mobile_userlogo_timestamp_rspVar, QZoneTask qZoneTask) {
        VipComponentProxy.f50997g.getServiceInterface().saveABtest(((Long) qZoneTask.getParameter("userLogoTimestampUin")) + "", mobile_userlogo_timestamp_rspVar.open_vip_dialog_type, mobile_userlogo_timestamp_rspVar.timestamp);
        if (mobile_userlogo_timestamp_rspVar.open_vip_dialog_type == 1) {
            h();
        }
    }

    private void h() {
        long uin = LoginData.getInstance().getUin();
        QZoneVIPUtils.d(uin, 3, 1);
        QZoneVIPUtils.d(uin, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (VipComponentProxy.f50997g.getServiceInterface().getABTestType() == 1 && e()) {
            h();
        }
        if (NetworkState.isWifiConn()) {
            this.f44448d = u5.b.K("GetUserLogoLastTimeStamp", 0L, LoginData.getInstance().getUin());
            int config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_GETUSERTIMELOGO, QzoneConfig.SECONDARY_GETUSERTIMELOGO_INTERVAL, 3600);
            if (QZLog.isColorLevel()) {
                QZLog.d(f44446i, 2, "Start preloadInterleaveTime = " + config + ",get mLastPreloadTime = " + this.f44448d + ",currenttime - preloadIntereaveTime = " + (System.currentTimeMillis() - this.f44448d));
            }
            if (System.currentTimeMillis() - this.f44448d > config * 1000) {
                c(null, LoginData.getInstance().getUin(), QZoneRapidCommentService.v().E(0));
            }
        }
    }

    public void d() {
        if (this.f44450f) {
            return;
        }
        this.f44450f = true;
        EventCenter.getInstance().addObserver(this, 3, "Feed", 20);
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if ("Feed".equals(event.source.getName()) && event.what == 20 && !this.f44451h) {
            this.f44451h = true;
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(new Runnable() { // from class: com.qzone.app.QZoneUpdateService.2
                @Override // java.lang.Runnable
                public void run() {
                    QZoneUpdateService.this.i();
                }
            }, 1000L);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 1) {
            return;
        }
        f(qZoneTask);
    }

    private void f(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000102);
        if (qZoneTask.succeeded()) {
            JceStruct jceStruct = qZoneTask.mRequest.rsp;
            if (jceStruct != null) {
                if (jceStruct instanceof mobile_userlogo_timestamp_rsp) {
                    result.setSucceed(true);
                    mobile_userlogo_timestamp_rsp mobile_userlogo_timestamp_rspVar = (mobile_userlogo_timestamp_rsp) qZoneTask.mRequest.rsp;
                    g(mobile_userlogo_timestamp_rspVar, qZoneTask);
                    QZoneRapidCommentService.v().D(mobile_userlogo_timestamp_rspVar.rc_data);
                    long currentTimeMillis = System.currentTimeMillis();
                    this.f44448d = currentTimeMillis;
                    u5.b.u0("GetUserLogoLastTimeStamp", currentTimeMillis, LoginData.getInstance().getUin());
                    if (QZLog.isColorLevel()) {
                        QZLog.d(f44446i, 2, "onGetUserLogoTimeStampResponse put mLastPreloadTime to file: " + this.f44448d + ",put mLastPreloadTime = " + this.f44448d);
                    }
                } else {
                    result.setSucceed(false);
                }
            } else {
                result.setSucceed(false);
            }
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }
}
