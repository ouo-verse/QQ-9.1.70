package com.tencent.gamecenter.wadl.notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameConfigService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.notification.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class d extends h {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f106951a;

        a(int i3) {
            this.f106951a = i3;
        }

        @Override // com.tencent.gamecenter.wadl.notification.e.b
        public void onImageLoaded(String str, Bitmap bitmap, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlGameCenterNotification", 2, "loadGameIcon.onImageLoaded url=" + str + ",notificationId=" + this.f106951a);
            }
            d.this.e(this.f106951a, bitmap);
        }
    }

    public d() {
        QLog.i("Wadl_WadlGameCenterNotification", 1, "new Instance");
    }

    private PendingIntent j(String str, int i3, long j3) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.putExtra("key_event_id", 1);
        intent.putExtra("appid", str);
        intent.putExtra("actionFrom", 4);
        intent.putExtra("actionType", i3);
        intent.putExtra("progress", j3);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private PendingIntent k(String str, long j3) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_GAME_CENTER_ACTION);
        intent.putExtra("key_event_id", 5);
        intent.putExtra("appid", str);
        intent.putExtra("actionFrom", 4);
        intent.putExtra("progress", j3);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private String m(int i3, int i16, WadlResult wadlResult) {
        String string;
        WadlParams wadlParams = wadlResult.wadlParams;
        if (i3 == 1003) {
            String string2 = com.tencent.open.adapter.a.f().e().getString(R.string.f171172n1);
            if (!TextUtils.isEmpty(wadlParams.wadlParamsExt.f106735f)) {
                String str = string2 + "  " + wadlParams.wadlParamsExt.f106735f;
                new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setOperId(WadlProxyConsts.OPER_ID_SHOW_NOTICE_TIPS).setOperType("8").setGameAppId(wadlParams.appId).setExt(6, "1").setExt(1, "81718").setExt(11, "1").setTianjiReportStr(wadlParams.wadlParamsExt.f106734e).setExt(12, WadlProxyConsts.PAGE_ID_DOWNLOAD).report();
                return str;
            }
            return string2;
        }
        if (i3 == 1004) {
            if (!TextUtils.isEmpty(wadlParams.wadlParamsExt.f106735f)) {
                return com.tencent.open.adapter.a.f().e().getString(R.string.f171152mz) + "  " + wadlParams.wadlParamsExt.f106735f;
            }
            return com.tencent.gamecenter.wadl.util.i.a(wadlResult.speed) + "MB/s | " + com.tencent.gamecenter.wadl.util.i.a(wadlResult.downloadFileSize) + "/" + com.tencent.gamecenter.wadl.util.i.a(wadlResult.fileSize) + "MB";
        }
        if (i3 == 1006) {
            String string3 = com.tencent.open.adapter.a.f().e().getString(R.string.f171362nj);
            if (!TextUtils.isEmpty(wadlParams.wadlParamsExt.f106735f)) {
                return string3 + "  " + wadlParams.wadlParamsExt.f106735f;
            }
            return string3;
        }
        if (i3 == 1005) {
            if (i16 == 999) {
                return com.tencent.open.adapter.a.f().e().getString(R.string.f171162n0);
            }
            return com.tencent.open.adapter.a.f().e().getString(R.string.f171142my);
        }
        if (i3 == 1008) {
            int i17 = wadlParams.from;
            if (i17 == 1) {
                string = com.tencent.open.adapter.a.f().e().getString(R.string.f171462nt);
            } else if (i17 == 3) {
                string = com.tencent.open.adapter.a.f().e().getString(R.string.f171442nr);
            } else {
                string = com.tencent.open.adapter.a.f().e().getString(R.string.notification_content_download_complete);
            }
            if (!TextUtils.isEmpty(wadlParams.wadlParamsExt.f106735f)) {
                return string + "  " + wadlParams.wadlParamsExt.f106735f;
            }
            return string;
        }
        return "";
    }

    private int n(int i3) {
        if (i3 == 1) {
            return R.string.f171472nu;
        }
        if (i3 == 3) {
            return R.string.f171452ns;
        }
        return R.string.f171482nv;
    }

    private String o(int i3, int i16, WadlResult wadlResult) {
        WadlParams wadlParams = wadlResult.wadlParams;
        if (i3 != 1003 && i3 != 1004) {
            if (i3 == 1006) {
                return com.tencent.open.adapter.a.f().e().getString(R.string.f171362nj);
            }
            if (i3 == 1005) {
                if (i16 == 999) {
                    return com.tencent.open.adapter.a.f().e().getString(R.string.f171162n0);
                }
                return com.tencent.open.adapter.a.f().e().getString(R.string.f171142my);
            }
            if (i3 == 1008) {
                int i17 = wadlParams.from;
                if (i17 == 1) {
                    return com.tencent.open.adapter.a.f().e().getString(R.string.f171462nt);
                }
                if (i17 == 3) {
                    return com.tencent.open.adapter.a.f().e().getString(R.string.f171442nr);
                }
                return com.tencent.open.adapter.a.f().e().getString(R.string.notification_content_download_complete);
            }
            return "";
        }
        return com.tencent.open.adapter.a.f().e().getString(n(wadlParams.from), wadlParams.appName);
    }

    private void p(g gVar, WadlResult wadlResult, int i3) {
        String str;
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlGameCenterNotification", 2, "handleTaskComplete id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, o(1008, wadlResult.errCode, wadlResult), wadlResult.wadlParams.appName, m(1008, wadlResult.errCode, wadlResult));
        gVar.setProgress(0, 0, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        int expIntValue = ((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).getExpIntValue(wadlResult.wadlParams.getResId(), IQQGameCommApi.KEY_INSTALL_NOTICE_ACTION_TYPE, true);
        com.tencent.gamecenter.wadl.biz.entity.g gVar2 = (com.tencent.gamecenter.wadl.biz.entity.g) ((IQQGameConfigService) QRoute.api(IQQGameConfigService.class)).getConfig(IQQGameConfigService.KEY_CONF_COMM);
        if (gVar2 != null) {
            str = gVar2.f106790c;
        } else {
            str = null;
        }
        String str2 = str;
        WadlParams wadlParams = wadlResult.wadlParams;
        g(gVar, com.tencent.gamecenter.wadl.util.i.e(wadlParams.appId, wadlParams.packageName, wadlResult.downloadFilePath, wadlParams.from, expIntValue, str2), false);
        u(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void q(g gVar, WadlResult wadlResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlGameCenterNotification", 2, "handleTaskFail id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, o(1005, wadlResult.errCode, wadlResult), wadlResult.wadlParams.appName, m(1005, wadlResult.errCode, wadlResult));
        gVar.setProgress(0, 0, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        g(gVar, j(wadlResult.wadlParams.appId, 0, wadlResult.progress), true);
        u(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void r(g gVar, WadlResult wadlResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlGameCenterNotification", 2, "handleTaskPause id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, o(1006, wadlResult.errCode, wadlResult), com.tencent.open.adapter.a.f().e().getString(R.string.f171502nx, wadlResult.wadlParams.appName, wadlResult.floatProgress + "%"), m(1006, wadlResult.errCode, wadlResult));
        gVar.setProgress(100, wadlResult.progress, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        g(gVar, j(wadlResult.wadlParams.appId, 0, (long) wadlResult.progress), true);
        u(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void s(g gVar, WadlResult wadlResult, int i3) {
        h(gVar, o(1004, wadlResult.errCode, wadlResult), com.tencent.open.adapter.a.f().e().getString(R.string.f171512ny, wadlResult.wadlParams.appName, wadlResult.floatProgress + "%"), m(1004, wadlResult.errCode, wadlResult));
        gVar.setProgress(100, wadlResult.progress, false);
        gVar.setAutoCancel(false).setOngoing(true).setPriority(0);
        g(gVar, k(wadlResult.wadlParams.appId, (long) wadlResult.progress), false);
        if (!gVar.f106961a.getBoolean("isSetPic")) {
            gVar.f106961a.putBoolean("isSetPic", true);
            u(gVar, wadlResult.wadlParams.iconUrl, i3, false);
        }
    }

    private void t(g gVar, WadlResult wadlResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("Wadl_WadlGameCenterNotification", 2, "handleTaskStart id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, o(1003, wadlResult.errCode, wadlResult), wadlResult.wadlParams.appName, m(1003, wadlResult.errCode, wadlResult));
        gVar.setProgress(100, wadlResult.progress, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        g(gVar, k(wadlResult.wadlParams.appId, wadlResult.progress), false);
        u(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void u(NotificationCompat.Builder builder, String str, int i3, boolean z16) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("Wadl_WadlGameCenterNotification", 2, "loadGameIcon iconUrl=" + str + ",notificationId=" + i3);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Bitmap c16 = e.b().c(str);
            if (c16 != null) {
                builder.setLargeIcon(c16);
            } else {
                if (z16) {
                    return;
                }
                e.b().d(str, new a(i3), 100, 100);
            }
        } catch (Throwable th5) {
            QLog.e("Wadl_WadlGameCenterNotification", 1, th5, new Object[0]);
        }
    }

    private void x(String str, String str2, int i3, String str3) {
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setPageId(WadlProxyConsts.PAGE_ID_DOWNLOAD).setOperModule(WadlProxyConsts.OPER_MODULE_DOWNLOAD).setModuleType(WadlProxyConsts.BUSINESS_ID_DOWNLOAD).setBussinessId("1").setOperId(str).setOperType("8").setGameAppId(str2).setExt(3, str3).setRetId(i3).report();
    }

    public void v() {
        a();
        QLog.d("Wadl_WadlGameCenterNotification", 1, "onDestroy...");
    }

    public void w(WadlResult wadlResult) {
        if (wadlResult != null) {
            boolean z16 = true;
            if (wadlResult.businessId == 1) {
                WadlParams wadlParams = wadlResult.wadlParams;
                if (wadlParams != null && wadlParams.getFlagEnable(4) && !TextUtils.isEmpty(wadlResult.wadlParams.appName) && !TextUtils.isEmpty(wadlResult.wadlParams.appId)) {
                    int i3 = wadlResult.taskStatus;
                    if (i3 != 12 && i3 != 9) {
                        int c16 = c(wadlResult.wadlParams.appId);
                        g b16 = b(c16, R.drawable.qfile_file_ufdownload);
                        int i16 = wadlResult.taskStatus;
                        String str = QQNotificationManager.CHANNEL_ID_HIDE_BADGE;
                        if (i16 != 2) {
                            if (i16 != 4) {
                                if (i16 != 5) {
                                    str = QQNotificationManager.CHANNEL_ID_OTHER;
                                    if (i16 != 6) {
                                        if (i16 != 7) {
                                            return;
                                        } else {
                                            q(b16, wadlResult, c16);
                                        }
                                    } else {
                                        p(b16, wadlResult, c16);
                                        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(WadlProxyConsts.OPER_ID_SHOW_NOTICE).setOperType("8").setGameAppId(wadlResult.wadlParams.appId).setTianjiReportStr(wadlResult.wadlParams.wadlParamsExt.f106734e).setRetId(wadlResult.wadlParams.from).report();
                                    }
                                } else {
                                    r(b16, wadlResult, c16);
                                }
                            } else {
                                s(b16, wadlResult, c16);
                                z16 = false;
                            }
                        } else {
                            t(b16, wadlResult, c16);
                        }
                        if (z16) {
                            x(WadlProxyConsts.OPER_ID_NOTIFICATION_SHOW, wadlResult.wadlParams.appId, wadlResult.taskStatus, String.valueOf(wadlResult.progress));
                        }
                        i(c16, b16.build(), str);
                        return;
                    }
                    f(wadlResult.wadlParams.appId);
                    return;
                }
                QLog.w("Wadl_WadlGameCenterNotification", 1, "update notification Error, wadlParams=" + wadlResult.wadlParams);
            }
        }
    }
}
