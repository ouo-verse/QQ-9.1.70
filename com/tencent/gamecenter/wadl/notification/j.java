package com.tencent.gamecenter.wadl.notification;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.ipc.WadlQIPCModule;
import com.tencent.gamecenter.wadl.biz.receiver.GameCenterReceiver;
import com.tencent.gamecenter.wadl.notification.e;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.vas.comm.api.receiver.VasReceiver;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class j extends h implements nl0.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f106964a;

        a(int i3) {
            this.f106964a = i3;
        }

        @Override // com.tencent.gamecenter.wadl.notification.e.b
        public void onImageLoaded(String str, Bitmap bitmap, String str2) {
            if (QLog.isColorLevel()) {
                QLog.d("WadlVMNotification", 2, "loadGameIcon.onImageLoaded url=" + str + ",notificationId=" + this.f106964a);
            }
            j.this.e(this.f106964a, bitmap);
        }
    }

    public j() {
        QLog.i("WadlVMNotification", 1, "new Instance");
        GameCenterReceiver.registerReceiver();
        GameCenterReceiver.addListener(this);
    }

    private PendingIntent j(String str, String str2, String str3) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_VM_ACTION);
        intent.putExtra("key_event_id", 3);
        intent.putExtra("appid", str);
        intent.putExtra("packageName", str2);
        intent.putExtra(WadlProxyConsts.KEY_LOCAL_APK_PATH, str3);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private String k(String str) {
        return GameCenterUtil.FILE_NAME_PRE + str;
    }

    private PendingIntent m(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_VM_ACTION);
        intent.putExtra("key_event_id", 1);
        intent.putExtra("packageName", str);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private PendingIntent n(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_VM_ACTION);
        intent.putExtra("key_event_id", 5);
        intent.putExtra("packageName", str);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private PendingIntent o(String str) {
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) VasReceiver.class);
        intent.setAction(WadlProxyConsts.ACTION_VM_ACTION);
        intent.putExtra("key_event_id", 6);
        intent.putExtra("appid", str);
        return PendingIntent.getBroadcast(MobileQQ.sMobileQQ, (int) (System.currentTimeMillis() & 268435455), intent, 201326592);
    }

    private String p(int i3, int i16, WadlResult wadlResult) {
        WadlParams wadlParams = wadlResult.wadlParams;
        if (i3 == 1003) {
            return com.tencent.open.adapter.a.f().e().getString(R.string.f171172n1);
        }
        if (i3 == 1004) {
            if (!TextUtils.isEmpty(wadlParams.wadlParamsExt.f106735f)) {
                return com.tencent.open.adapter.a.f().e().getString(R.string.f171152mz) + "  " + wadlParams.wadlParamsExt.f106735f;
            }
            return com.tencent.gamecenter.wadl.util.i.a(wadlResult.speed) + "MB/s | " + com.tencent.gamecenter.wadl.util.i.a(wadlResult.downloadFileSize) + "/" + com.tencent.gamecenter.wadl.util.i.a(wadlResult.fileSize) + "MB";
        }
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
            return com.tencent.open.adapter.a.f().e().getString(R.string.notification_content_download_complete);
        }
        return "";
    }

    private String q(int i3, int i16, WadlResult wadlResult) {
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
                return com.tencent.open.adapter.a.f().e().getString(R.string.notification_content_download_complete);
            }
            return "";
        }
        return com.tencent.open.adapter.a.f().e().getString(R.string.f171482nv, wadlParams.appName);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void r(g gVar, WadlResult wadlResult, int i3) {
        String str;
        boolean z16;
        PendingIntent j3;
        if (QLog.isColorLevel()) {
            QLog.d("WadlVMNotification", 2, "handleTaskComplete id=" + wadlResult.wadlParams.getResId());
        }
        EIPCResult callServer = QIPCClientHelper.getInstance().callServer(WadlQIPCModule.NAME, WadlProxyConsts.QIPC_ACTION_CHECK_TOP_FRAGMENT, null);
        String str2 = "";
        if (callServer.isSuccess()) {
            String string = callServer.data.getString(WadlProxyConsts.TOP_FRAGMENT_NAME, "");
            boolean z17 = callServer.data.getBoolean("isForeground");
            QLog.d("WadlVMNotification", 4, "handleTaskComplete isForeground=" + z17);
            if ("com.tencent.qq.minibox.ui.MiniBoxAppLoadingFragment".equals(string) && z17) {
                if (!TextUtils.isEmpty(wadlResult.wadlParams.appName)) {
                    str = wadlResult.wadlParams.appName + "\u5df2\u7ecf\u52a0\u8f7d\u5b8c\u6bd5\uff0c\u70b9\u51fb\u7acb\u5373\u542f\u52a8";
                } else {
                    str = "\u4e0b\u8f7d\u5b8c\u6210";
                }
                z16 = true;
                if (!z16) {
                    str = q(1008, wadlResult.errCode, wadlResult);
                    str2 = p(1008, wadlResult.errCode, wadlResult);
                }
                h(gVar, str, wadlResult.wadlParams.appName, str2);
                gVar.setProgress(0, 0, false);
                gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
                if (!z16) {
                    j3 = o(wadlResult.wadlParams.appId);
                } else {
                    WadlParams wadlParams = wadlResult.wadlParams;
                    j3 = j(wadlParams.appId, wadlParams.packageName, wadlResult.downloadFilePath);
                }
                g(gVar, j3, false);
                w(gVar, wadlResult.wadlParams.iconUrl, i3, false);
            }
        }
        str = "";
        z16 = false;
        if (!z16) {
        }
        h(gVar, str, wadlResult.wadlParams.appName, str2);
        gVar.setProgress(0, 0, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        if (!z16) {
        }
        g(gVar, j3, false);
        w(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void s(g gVar, WadlResult wadlResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("WadlVMNotification", 2, "handleTaskFail id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, q(1005, wadlResult.errCode, wadlResult), wadlResult.wadlParams.appName, p(1005, wadlResult.errCode, wadlResult));
        gVar.setProgress(0, 0, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        g(gVar, m(wadlResult.wadlParams.packageName), true);
        w(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void t(g gVar, WadlResult wadlResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("WadlVMNotification", 2, "handleTaskPause id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, q(1006, wadlResult.errCode, wadlResult), com.tencent.open.adapter.a.f().e().getString(R.string.f171502nx, wadlResult.wadlParams.appName, wadlResult.floatProgress + "%"), p(1006, wadlResult.errCode, wadlResult));
        gVar.setProgress(100, wadlResult.progress, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        g(gVar, m(wadlResult.wadlParams.packageName), true);
        w(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void u(g gVar, WadlResult wadlResult, int i3) {
        h(gVar, q(1004, wadlResult.errCode, wadlResult), com.tencent.open.adapter.a.f().e().getString(R.string.f171512ny, wadlResult.wadlParams.appName, wadlResult.floatProgress + "%"), p(1004, wadlResult.errCode, wadlResult));
        gVar.setProgress(100, wadlResult.progress, false);
        gVar.setAutoCancel(false).setOngoing(true).setPriority(0);
        g(gVar, n(wadlResult.wadlParams.packageName), false);
        if (!gVar.f106961a.getBoolean("isSetPic")) {
            gVar.f106961a.putBoolean("isSetPic", true);
            w(gVar, wadlResult.wadlParams.iconUrl, i3, false);
        }
    }

    private void v(g gVar, WadlResult wadlResult, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("WadlVMNotification", 2, "handleTaskStart id=" + wadlResult.wadlParams.getResId());
        }
        h(gVar, q(1003, wadlResult.errCode, wadlResult), wadlResult.wadlParams.appName, p(1003, wadlResult.errCode, wadlResult));
        gVar.setProgress(100, wadlResult.progress, false);
        gVar.setAutoCancel(true).setOngoing(false).setPriority(0);
        g(gVar, n(wadlResult.wadlParams.packageName), false);
        w(gVar, wadlResult.wadlParams.iconUrl, i3, false);
    }

    private void w(NotificationCompat.Builder builder, String str, int i3, boolean z16) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("WadlVMNotification", 2, "loadGameIcon iconUrl=" + str + ",notificationId=" + i3);
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
            QLog.e("WadlVMNotification", 1, th5, new Object[0]);
        }
    }

    @Override // nl0.a
    public void onTaskDeleted(String str, String str2, int i3) {
        if (i3 == 3 && !TextUtils.isEmpty(str2)) {
            f(k(str2));
        }
    }

    @Override // nl0.a
    public void onTaskInstall(WadlResult wadlResult, int i3) {
        WadlParams wadlParams;
        if (i3 == 3 && wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
            f(k(wadlParams.packageName));
        }
    }

    public void x() {
        a();
        GameCenterReceiver.removeListener(this);
        QLog.d("WadlVMNotification", 1, "onDestroy...");
    }

    public void y(WadlResult wadlResult) {
        String str;
        if (wadlResult == null) {
            return;
        }
        WadlParams wadlParams = wadlResult.wadlParams;
        if (wadlParams != null && wadlParams.getFlagEnable(4) && !TextUtils.isEmpty(wadlResult.wadlParams.appName) && !TextUtils.isEmpty(wadlResult.wadlParams.packageName)) {
            String k3 = k(wadlResult.wadlParams.packageName);
            int i3 = wadlResult.taskStatus;
            if (i3 != 12 && i3 != 9) {
                int c16 = c(k3);
                g b16 = b(c16, R.drawable.qfile_file_ufdownload);
                int i16 = wadlResult.taskStatus;
                if (i16 != 2) {
                    if (i16 != 4) {
                        if (i16 != 5) {
                            str = QQNotificationManager.CHANNEL_ID_OTHER;
                            if (i16 != 6) {
                                if (i16 != 7) {
                                    return;
                                } else {
                                    s(b16, wadlResult, c16);
                                }
                            } else {
                                r(b16, wadlResult, c16);
                            }
                            i(c16, b16.build(), str);
                            return;
                        }
                        t(b16, wadlResult, c16);
                    } else {
                        u(b16, wadlResult, c16);
                    }
                } else {
                    v(b16, wadlResult, c16);
                }
                str = QQNotificationManager.CHANNEL_ID_HIDE_BADGE;
                i(c16, b16.build(), str);
                return;
            }
            return;
        }
        QLog.w("WadlVMNotification", 1, "update notification Error, wadlParams=" + wadlResult.wadlParams);
    }

    @Override // nl0.a
    public void onTaskComplete(WadlResult wadlResult, int i3) {
    }
}
