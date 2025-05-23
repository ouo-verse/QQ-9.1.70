package com.tencent.gamecenter.wadl.api.impl;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameCheckService;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.api.IQQGameNoticeService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterBroadcastReceiver;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.biz.receiver.GameFullScreenReceiver;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameAutoDownloadTask$PreDownloadInfo;
import tencent.im.qqgame.QQGameAutoUpdateTask$PreUpdateInfo;

/* compiled from: P */
/* loaded from: classes6.dex */
public class QQGameCheckServiceImpl implements IQQGameCheckService {
    public static final String TAG = "Wadl_QQGameCheckServiceImpl";
    HashMap<Integer, ql0.a> downloaderMap = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public void check(int i3) {
        boolean z16;
        com.tencent.gamecenter.wadl.biz.entity.g gVar = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar == null) {
            gVar = new com.tencent.gamecenter.wadl.biz.entity.g(IQQGameConfigService.KEY_CONF_COMM);
        }
        QLog.d(TAG, 1, "check scenes=" + i3);
        synchronized (this.downloaderMap) {
            Iterator<Map.Entry<Integer, ql0.a>> it = this.downloaderMap.entrySet().iterator();
            z16 = false;
            while (it.hasNext()) {
                ql0.a value = it.next().getValue();
                if (value.c()) {
                    value.a(gVar);
                    z16 = true;
                }
            }
        }
        if (!z16) {
            QLog.d(TAG, 1, "check not has predownload task, unRegisterReceiver");
            GameCenterBroadcastReceiver.d();
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void checkGameCenter(final int i3) {
        boolean z16;
        QLog.i(TAG, 1, "checkGameCenter " + i3);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.api.impl.QQGameCheckServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    QQGameCheckServiceImpl.this.check(i3);
                }
            }, 16, null, true);
        } else {
            check(i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003c  */
    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleKeepLivePush(String str) {
        long optLong;
        if (!TextUtils.isEmpty(str)) {
            try {
                optLong = new JSONObject(str).optLong("endTime");
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "handleKeepLivePush exception", e16);
            }
            QLog.d(TAG, 1, "handleKeepLivePush content=" + str);
            if (optLong >= 1) {
                return;
            }
            long serverTime = NetConnInfoCenter.getServerTime();
            long j3 = optLong - serverTime;
            if (j3 < 10) {
                QLog.w(TAG, 1, "handleKeepLivePush fail now=" + serverTime + ",hideDelay=" + j3);
                return;
            }
            IQQGameNoticeService iQQGameNoticeService = (IQQGameNoticeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGameNoticeService.class, "");
            if (iQQGameNoticeService != null) {
                iQQGameNoticeService.showKeepLiveView(j3);
                return;
            }
            return;
        }
        optLong = 0;
        QLog.d(TAG, 1, "handleKeepLivePush content=" + str);
        if (optLong >= 1) {
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void handlePreDownloadList(List<QQGameAutoDownloadTask$PreDownloadInfo> list) {
        ql0.a aVar = this.downloaderMap.get(1);
        if (aVar instanceof ql0.d) {
            ql0.d dVar = (ql0.d) aVar;
            dVar.h(list);
            if (dVar.c()) {
                GameCenterBroadcastReceiver.c();
                checkGameCenter(0);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void handlePreDownloadPush(String str, String str2) {
        ql0.a aVar = this.downloaderMap.get(1);
        if (aVar instanceof ql0.d) {
            ((ql0.d) aVar).i(str, str2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00af  */
    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handlePreImitatePush(String str) {
        String str2;
        String str3;
        JSONObject jSONObject;
        int d16;
        com.tencent.gamecenter.wadl.biz.entity.a installInfo;
        String str4;
        String str5;
        String str6;
        String str7 = "";
        if (TextUtils.isEmpty(str)) {
            str3 = "";
            str2 = str3;
        } else {
            try {
                jSONObject = new JSONObject(str);
                str2 = jSONObject.optString("appid");
            } catch (JSONException e16) {
                e = e16;
                str2 = "";
            }
            try {
                str3 = jSONObject.optString("package_name");
            } catch (JSONException e17) {
                e = e17;
                QLog.e(TAG, 1, "handlePreImitatePush exception", e);
                str3 = "";
                d16 = ql0.e.d();
                QLog.d(TAG, 1, "handlePreImitatePush content=" + str);
                installInfo = GameCenterUtil.getInstallInfo(str2, str3);
                long[] U = ah.U();
                String str8 = "1";
                WadlReportBuilder ext = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("426").setOperId("205581").setGameAppId(str2).setExt(1, "42601").setExt(11, "1").setExt(12, "118").setExt(16, String.valueOf(d16));
                if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
                }
                WadlReportBuilder ext2 = ext.setExt(17, str4);
                if (!installInfo.f106749d) {
                }
                WadlReportBuilder ext3 = ext2.setExt(18, str5).setExt(19, String.valueOf(installInfo.f106751f));
                if (!TextUtils.isEmpty(installInfo.f106748c)) {
                }
                WadlReportBuilder ext4 = ext3.setExt(20, str7).setExt(21, String.valueOf(U[1]));
                if (!ql0.e.f(d16, 1)) {
                }
                WadlReportBuilder ext5 = ext4.setExt(22, str6);
                if (!ql0.e.f(d16, 2)) {
                }
                ext5.setExt(23, str8).report();
            }
        }
        d16 = ql0.e.d();
        QLog.d(TAG, 1, "handlePreImitatePush content=" + str);
        installInfo = GameCenterUtil.getInstallInfo(str2, str3);
        long[] U2 = ah.U();
        String str82 = "1";
        WadlReportBuilder ext6 = new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("426").setOperId("205581").setGameAppId(str2).setExt(1, "42601").setExt(11, "1").setExt(12, "118").setExt(16, String.valueOf(d16));
        if (!((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        WadlReportBuilder ext22 = ext6.setExt(17, str4);
        if (!installInfo.f106749d) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        WadlReportBuilder ext32 = ext22.setExt(18, str5).setExt(19, String.valueOf(installInfo.f106751f));
        if (!TextUtils.isEmpty(installInfo.f106748c)) {
            str7 = installInfo.f106748c;
        }
        WadlReportBuilder ext42 = ext32.setExt(20, str7).setExt(21, String.valueOf(U2[1]));
        if (!ql0.e.f(d16, 1)) {
            str6 = "1";
        } else {
            str6 = "0";
        }
        WadlReportBuilder ext52 = ext42.setExt(22, str6);
        if (!ql0.e.f(d16, 2)) {
            str82 = "0";
        }
        ext52.setExt(23, str82).report();
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void handlePreUpdateList(List<QQGameAutoUpdateTask$PreUpdateInfo> list) {
        ql0.a aVar = this.downloaderMap.get(1);
        if (aVar instanceof ql0.d) {
            ql0.d dVar = (ql0.d) aVar;
            dVar.j(list);
            if (dVar.c()) {
                GameCenterBroadcastReceiver.c();
                checkGameCenter(0);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void handlePreUpdatePush(String str, String str2) {
        ql0.a aVar = this.downloaderMap.get(1);
        if (aVar instanceof ql0.d) {
            ((ql0.d) aVar).k(str, str2);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void handlePreloadPush(String str) {
        ql0.a aVar = this.downloaderMap.get(4);
        if ((aVar instanceof ql0.f) && ((ql0.f) aVar).e(str)) {
            GameCenterBroadcastReceiver.c();
            checkGameCenter(3);
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public boolean hasAppointTask() {
        boolean z16;
        synchronized (this.downloaderMap) {
            Iterator<Map.Entry<Integer, ql0.a>> it = this.downloaderMap.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getValue().c()) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
        }
        QLog.d(TAG, 1, "hasAppointTask hasTask=" + z16);
        return z16;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        QLog.i(TAG, 1, "onCreate");
        GameCenterReceiver.registerReceiver();
        GameFullScreenReceiver.c();
        this.downloaderMap.put(1, new ql0.d());
        this.downloaderMap.put(2, new ql0.b());
        this.downloaderMap.put(3, new ql0.g());
        this.downloaderMap.put(4, new ql0.f());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        GameCenterReceiver.unRegisterReceiver();
        GameFullScreenReceiver.d();
        synchronized (this.downloaderMap) {
            Iterator<Map.Entry<Integer, ql0.a>> it = this.downloaderMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().onDestroy();
                it.remove();
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.api.IQQGameCheckService
    public void onSendDownloadRequest(WadlParams wadlParams) {
        QLog.d(TAG, 1, "onSendDownloadRequest...");
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.appId)) {
            ql0.e.j(wadlParams.appId, wadlParams.versionCode);
            synchronized (this.downloaderMap) {
                Iterator<Map.Entry<Integer, ql0.a>> it = this.downloaderMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().b(wadlParams);
                }
            }
        }
    }
}
