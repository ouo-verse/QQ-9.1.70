package com.tencent.gamecenter.wadl.notification;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlNotificationController implements Handler.Callback {
    private static WadlNotificationController D;
    private static final byte[] E = new byte[0];

    /* renamed from: d, reason: collision with root package name */
    private long f106939d = 0;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<WadlResult> f106941f = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private WadlCustomNotificationBuilder f106942h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f106943i = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f106944m = false;
    private WadlResult C = null;

    /* renamed from: e, reason: collision with root package name */
    private Handler f106940e = new Handler(ThreadManagerV2.getUIHandlerV2().getLooper(), this);

    WadlNotificationController() {
    }

    private void a() {
        QLog.d("WadlNotificationController", 2, "clearNotification notificationBuilder=" + this.f106942h);
        this.f106940e.removeCallbacksAndMessages(null);
        n();
        WadlCustomNotificationBuilder wadlCustomNotificationBuilder = this.f106942h;
        if (wadlCustomNotificationBuilder != null) {
            wadlCustomNotificationBuilder.i();
            this.f106942h = null;
        }
        QQNotificationManager.getInstance().cancel("gamecenter", NotificationUtil.Constants.NOTIFY_ID_APPCENTER_BEGIN);
    }

    public static WadlNotificationController b() {
        if (D == null) {
            synchronized (E) {
                if (D == null) {
                    D = new WadlNotificationController();
                }
            }
        }
        return D;
    }

    private boolean e() {
        Iterator<WadlResult> it = this.f106941f.iterator();
        while (it.hasNext()) {
            if (it.next().isRunning()) {
                return true;
            }
        }
        return false;
    }

    private void f(WadlResult wadlResult) {
        String str;
        String str2;
        String str3;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notificationNext showResult=");
            if (wadlResult != null) {
                str3 = wadlResult.toSimpleString();
            } else {
                str3 = GlobalUtil.DEF_STRING;
            }
            sb5.append(str3);
            QLog.d("WadlNotificationController", 2, sb5.toString());
        }
        if (wadlResult == null) {
            QLog.w("WadlNotificationController", 1, "notificationNext nextWadlResult is null");
            return;
        }
        if (this.f106944m) {
            QLog.d("WadlNotificationController", 2, "notificationNext rejectNotice is true");
            return;
        }
        if (this.f106942h == null) {
            this.f106942h = new WadlCustomNotificationBuilder(MobileQQ.sMobileQQ);
            QLog.i("WadlNotificationController", 1, "notificationNext create notificationBuilder=" + this.f106942h);
        }
        this.C = wadlResult;
        Iterator<WadlResult> it = this.f106941f.iterator();
        boolean z16 = false;
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            WadlResult next = it.next();
            if (next.isRunning()) {
                i3++;
            } else if (next.isTaskPaused()) {
                i16++;
            }
        }
        if (this.C.isRunning()) {
            if (i3 > 1) {
                str = i3 + "\u6b3e\u6e38\u620f\u4e0b\u8f7d\u4e2d";
                str2 = "\u5f53\u524d" + this.C.wadlParams.appName + " (\u5df2\u4e0b\u8f7d" + this.C.floatProgress + "%)";
            } else {
                str = this.C.wadlParams.appName + " (\u5df2\u4e0b\u8f7d " + this.C.floatProgress + "%)";
                str2 = com.tencent.gamecenter.wadl.util.i.k(this.C.downloadFileSize) + "/" + com.tencent.gamecenter.wadl.util.i.k(this.C.fileSize) + " (" + com.tencent.gamecenter.wadl.util.i.a(this.C.speed) + "MB/s)";
                z16 = true;
            }
        } else {
            if (this.C.isDownloadComplete()) {
                str2 = "\u70b9\u6b64\u7acb\u5373\u5b89\u88c5";
                if (i3 > 0) {
                    str = this.C.wadlParams.appName + "\uff08\u4e0b\u8f7d\u5b8c\u6210\uff0c\u5176\u4ed6" + i3 + "\u6b3e\u6e38\u620f\u4e0b\u8f7d\u4e2d\uff09";
                } else if (i16 > 0) {
                    str = this.C.wadlParams.appName + "\uff08\u4e0b\u8f7d\u5b8c\u6210\uff0c\u5176\u4ed6" + i16 + "\u6b3e\u6e38\u620f\u5df2\u6682\u505c\u4e0b\u8f7d\uff09";
                } else {
                    str = this.C.wadlParams.appName;
                    str2 = "\u4e0b\u8f7d\u5b8c\u6210\uff0c\u70b9\u6b64\u7acb\u5373\u5b89\u88c5";
                }
            } else if (i16 > 1) {
                str = i16 + "\u6b3e\u6e38\u620f\u5df2\u6682\u505c\u4e0b\u8f7d";
                str2 = "\u70b9\u6b64\u7acb\u5373\u6062\u590d";
            } else {
                str = this.C.wadlParams.appName + "\uff08\u5df2\u6682\u505c\u4e0b\u8f7d\uff0c\u5f53\u524d\u8fdb\u5ea6" + this.C.floatProgress + "%\uff09";
                str2 = "\u70b9\u6b64\u6062\u590d\u4e0b\u8f7d";
            }
            z16 = true;
        }
        Message obtainMessage = this.f106940e.obtainMessage(1, wadlResult);
        Bundle data = obtainMessage.getData();
        if (data == null) {
            data = new Bundle();
            obtainMessage.setData(data);
        }
        data.putString("K_TITLE", str);
        data.putString("K_SUB_TITLE", str2);
        data.putBoolean("K_IS_SINGLE_ICON", z16);
        obtainMessage.sendToTarget();
    }

    private synchronized boolean j(String str) {
        Iterator<WadlResult> it = this.f106941f.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().wadlParams.appId)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    private void k(String str) {
        this.f106944m = false;
        QLog.d("WadlNotificationController", 2, "resetUserCleanNotification from=" + str);
    }

    private boolean o(WadlResult wadlResult) {
        boolean z16;
        boolean z17;
        Iterator<WadlResult> it = this.f106941f.iterator();
        while (true) {
            if (it.hasNext()) {
                WadlResult next = it.next();
                if (wadlResult.wadlParams.appId.equals(next.wadlParams.appId)) {
                    z17 = next.update(wadlResult);
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                z17 = false;
                break;
            }
        }
        if (!z16) {
            synchronized (this.f106941f) {
                this.f106941f.add(wadlResult);
            }
            QLog.d("WadlNotificationController", 1, "updateWadlResult add new Task, this=" + this);
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onNotificationShow(wadlResult, wadlResult.taskStatus);
            return true;
        }
        if (wadlResult.isDownloadComplete()) {
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onNotificationShow(wadlResult, wadlResult.taskStatus);
        }
        return z17;
    }

    private boolean p(WadlResult wadlResult) {
        WadlParams wadlParams;
        if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null && !TextUtils.isEmpty(wadlParams.appName) && !TextUtils.isEmpty(wadlResult.wadlParams.appId) && wadlResult.wadlParams.getFlagEnable(4)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.w("WadlNotificationController", 1, "validParams fail, wadlResult=" + wadlResult);
            return false;
        }
        return false;
    }

    public WadlCustomNotificationBuilder c() {
        QLog.d("WadlNotificationController", 1, "getNotificationBuilder this=" + this);
        return this.f106942h;
    }

    public ArrayList<WadlResult> d() {
        return this.f106941f;
    }

    public void g() {
        try {
            this.f106941f.clear();
            a();
            synchronized (E) {
                D = null;
            }
        } catch (Throwable th5) {
            QLog.e("WadlNotificationController", 1, "onWadlTaskStatusChanged ctr exception", th5);
        }
        QLog.d("WadlNotificationController", 1, "onDestroy...");
    }

    public void h() {
        WadlResult wadlResult;
        this.f106944m = true;
        if (e()) {
            this.f106940e.obtainMessage(2, "\u4e0b\u8f7d\u4efb\u52a1\u5728\u540e\u53f0\u8fdb\u884c").sendToTarget();
        }
        if (this.f106942h != null && (wadlResult = this.C) != null && wadlResult.isDownloadComplete()) {
            this.C.wadlParams.setExtFlags(8);
        }
        WadlResult b16 = f.b(this.f106941f, true);
        if (b16 != null && b16.isDownloadComplete()) {
            k("userCleanNotification");
            f(b16);
        } else {
            a();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        WadlCustomNotificationBuilder wadlCustomNotificationBuilder;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    g();
                    return false;
                }
                return false;
            }
            if (message.obj instanceof String) {
                QQToast.makeText(BaseApplication.getContext(), -1, (String) message.obj, 1).show();
                return false;
            }
            return false;
        }
        Object obj = message.obj;
        if ((obj instanceof WadlResult) && (wadlCustomNotificationBuilder = this.f106942h) != null) {
            wadlCustomNotificationBuilder.m((WadlResult) obj, message.getData());
            m();
            return false;
        }
        return false;
    }

    public void i(WadlResult wadlResult) {
        if (!p(wadlResult)) {
            QLog.w("WadlNotificationController", 1, "onWadlTaskStatusChanged params invalid, wadlResult=" + wadlResult);
            return;
        }
        int i3 = wadlResult.taskStatus;
        if (i3 != 12 && i3 != 9) {
            if (o(wadlResult)) {
                k("taskStatusChange");
            }
        } else {
            QLog.d("WadlNotificationController", 1, "onWadlTaskStatusChanged removeWadlResultByAppId appId=" + wadlResult.wadlParams.appId + ", isRemove=" + j(wadlResult.wadlParams.appId));
        }
        WadlResult b16 = f.b(this.f106941f, true);
        if (b16 != null) {
            f(b16);
        } else {
            this.f106940e.sendEmptyMessage(3);
        }
    }

    public void l(boolean z16) {
        this.f106943i = z16;
    }

    @TargetApi(26)
    public void m() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.f106943i && this.f106939d + 5000 <= currentTimeMillis) {
            if (this.f106942h == null) {
                QLog.w("WadlNotificationController", 1, "startWadlService notificationBuilder is null");
            } else {
                this.f106939d = currentTimeMillis;
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.WadlNotificationController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int optInt = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMECENTER_DOWNLOADER_CONF).optInt("noticeServiceSwitch", 1);
                        QLog.i("WadlNotificationController", 1, "startWadlService,noticeServiceSwitch:" + optInt);
                        if (optInt == 0) {
                            return;
                        }
                        try {
                            MobileQQ.sMobileQQ.startForegroundService(new Intent(MobileQQ.sMobileQQ, (Class<?>) WadlNotificationService.class));
                        } catch (Exception e16) {
                            QLog.e("WadlNotificationController", 1, "startWadlService exception", e16);
                        }
                    }
                }, 16, null, true);
            }
        }
    }

    @TargetApi(26)
    public void n() {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        QLog.d("WadlNotificationController", 2, "stopWadlService...");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.gamecenter.wadl.notification.WadlNotificationController.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    MobileQQ.sMobileQQ.stopService(new Intent(MobileQQ.sMobileQQ, (Class<?>) WadlNotificationService.class));
                } catch (Exception e16) {
                    QLog.e("WadlNotificationController", 1, "stopWadlService exception", e16);
                }
            }
        }, 16, null, true);
        this.f106943i = false;
    }
}
