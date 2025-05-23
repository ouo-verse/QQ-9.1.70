package com.qzone.common.config.service;

import QMF_PROTOCAL.mobile_get_config_rsp;
import android.text.TextUtils;
import com.qzone.app.b;
import com.qzone.util.al;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.WiFiDash;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneConfigService implements NetworkState.NetworkStateListener {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.common.config.service.a f45840d;

    /* renamed from: e, reason: collision with root package name */
    private String f45841e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f45842f = "";

    /* renamed from: h, reason: collision with root package name */
    private Runnable f45843h = new UpdateConfig();

    /* renamed from: i, reason: collision with root package name */
    private static final al<QZoneConfigService, Void> f45838i = new a();

    /* renamed from: m, reason: collision with root package name */
    private static boolean f45839m = false;
    private static boolean C = false;
    private static boolean D = true;

    /* compiled from: P */
    /* renamed from: com.qzone.common.config.service.QZoneConfigService$3, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ mobile_get_config_rsp f45844d;
        final /* synthetic */ QZoneConfigService this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.l(this.f45844d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class UpdateConfig implements Runnable {
        UpdateConfig() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneConfigService", 2, "update config");
            }
            if (QZoneConfigService.D) {
                QZoneConfigService.D = false;
                return;
            }
            int gateIpOper = (int) FMTSrvAddrProvider.getInstance().getGateIpOper();
            if (gateIpOper > 0 && gateIpOper < 8) {
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneConfigService", 2, "load msf push isp operator suc:" + gateIpOper);
                }
                com.tencent.common.config.provider.a.c(gateIpOper);
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneConfigService", 2, "send request to update config");
            }
            QZoneConfigService.f().h(false, 101);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneConfigService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneConfigService a(Void r16) {
            return new QZoneConfigService();
        }
    }

    QZoneConfigService() {
        NetworkState.addListener(this);
        i();
    }

    private boolean d() {
        String sb5;
        if (C) {
            return true;
        }
        String apn = NetworkState.getAPN();
        if (NetworkState.isWifiConn()) {
            String bssid = WiFiDash.getBSSID();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(apn);
            sb6.append("_");
            sb6.append(bssid != null ? bssid : "");
            sb5 = sb6.toString();
        } else {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(apn != null ? apn : "");
            sb7.append("_");
            sb7.append(PlatformInfor.g().getIMSI());
            sb5 = sb7.toString();
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("QZoneConfigService", 2, "lastAPN=" + this.f45842f + ",currentAPN=" + sb5);
        }
        if (!TextUtils.isEmpty(this.f45842f) && sb5.equals(this.f45842f)) {
            if (!QZLog.isColorLevel()) {
                return false;
            }
            QZLog.i("QZoneConfigService", 2, "discover network change,apn=" + apn + ",currentAPN=" + sb5 + ",lastAPN=" + this.f45842f + " equal.");
            return false;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("QZoneConfigService", 2, "discover network change,apn=" + apn + ",currentAPN=" + sb5 + ",lastAPN=" + this.f45842f + "not equal.");
        }
        this.f45842f = sb5;
        return true;
    }

    public static QZoneConfigService f() {
        return f45838i.get(null);
    }

    private void j(Runnable runnable) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(runnable);
    }

    public com.qzone.common.config.service.a e() {
        return this.f45840d;
    }

    public void g(boolean z16) {
        if (f45839m) {
            h(z16, 100);
        }
    }

    public void i() {
        b bVar = new b();
        this.f45840d = bVar;
        if (bVar.b() != null) {
            this.f45841e = this.f45840d.b().getApplication().getQQProcessName();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(MobileQQ.PACKAGE_NAME);
        sb5.append(":qzone");
        f45839m = sb5.toString().equals(this.f45841e) || MobileQQ.PACKAGE_NAME.equals(this.f45841e);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneConfigService", 2, "init mainProcess=" + f45839m + ",processName=" + this.f45841e);
        }
        j(new Runnable() { // from class: com.qzone.common.config.service.QZoneConfigService.2
            @Override // java.lang.Runnable
            public void run() {
                QZoneConfigService.this.g(false);
            }
        });
    }

    public void k() {
        if (f45839m) {
            try {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f45843h);
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.f45843h, 3000L);
                if (QZLog.isColorLevel()) {
                    QZLog.i("QZoneConfigService", 2, "operator is invalid,refresh");
                }
            } catch (Error e16) {
                QZLog.e("exception", "onrefreshConfig Error:", e16);
            } catch (Exception e17) {
                QZLog.e("exception", "onrefreshConfig Exception:", e17);
            }
        }
    }

    @Override // cooperation.qzone.util.NetworkState.NetworkStateListener
    public void onNetworkConnect(boolean z16) {
        if (D && !z16) {
            if (QZLog.isColorLevel()) {
                QZLog.d("QZoneConfigService", 2, "receive netork change,no network");
            }
            D = false;
            return;
        }
        if (NetworkState.isWifiConn()) {
            WiFiDash.updateBSSID();
        }
        if (z16 && f45839m && d()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f45843h);
            if (QZLog.isColorLevel()) {
                QZLog.d("QZoneConfigService", 2, "receive netork change");
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this.f45843h, 15000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(mobile_get_config_rsp mobile_get_config_rspVar) {
        Map<String, byte[]> map;
        if (mobile_get_config_rspVar != null && (map = mobile_get_config_rspVar.config) != null && !map.isEmpty()) {
            try {
                C = com.tencent.common.config.provider.a.b(mobile_get_config_rspVar.config, f45839m);
            } catch (Exception unused) {
            }
            if (TextUtils.isEmpty(this.f45841e)) {
                this.f45841e = QzoneWebMusicJsPlugin.EVENT_UNKOWN;
            }
            com.tencent.common.config.provider.b.i(mobile_get_config_rspVar.config, mobile_get_config_rspVar.cookies, this.f45841e, this.f45840d.b());
            if (QZLog.isColorLevel()) {
                QZLog.i("QZoneConfigService", 2, "notify other");
            }
        }
        if (QZLog.isColorLevel()) {
            QZLog.i("QZoneConfigService", 2, "receive network config,mainProcess=" + f45839m);
        }
    }

    public void h(boolean z16, int i3) {
    }
}
