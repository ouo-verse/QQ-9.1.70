package com.qzone.feed.business.model;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.QzoneOnlineTimeCollectRptService;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QZoneTeenOnlineTimeHelper;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneTeenOnlineTimeLimitManager {

    /* renamed from: h, reason: collision with root package name */
    private static int f47099h;

    /* renamed from: a, reason: collision with root package name */
    private Activity f47100a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f47101b;

    /* renamed from: c, reason: collision with root package name */
    private QQCustomDialog f47102c = null;

    /* renamed from: d, reason: collision with root package name */
    private DialogInterface.OnClickListener f47103d = null;

    /* renamed from: e, reason: collision with root package name */
    private DialogInterface.OnClickListener f47104e = null;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f47105f = null;

    /* renamed from: g, reason: collision with root package name */
    private QZoneOnlineTimeReportRunnable f47106g = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class QZoneOnlineTimeReportRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneTeenOnlineTimeLimitManager> f47107d;

        public QZoneOnlineTimeReportRunnable(QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager) {
            this.f47107d = new WeakReference<>(qZoneTeenOnlineTimeLimitManager);
        }

        @Override // java.lang.Runnable
        public void run() {
            int config = QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_ACTIVE_ONLINE_REPORT_INTERVAL, 600000);
            if (QZLog.isDevelopLevel()) {
                QZLog.d("TeenagerModeOnlineTimeManager", 4, "onlineTimeRunnable: " + QZoneTeenOnlineTimeLimitManager.f47099h + ", postdelay=" + config);
            }
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(this, config);
            WeakReference<QZoneTeenOnlineTimeLimitManager> weakReference = this.f47107d;
            QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager = weakReference == null ? null : weakReference.get();
            if (qZoneTeenOnlineTimeLimitManager == null || !qZoneTeenOnlineTimeLimitManager.f47101b) {
                return;
            }
            QzoneOnlineTimeCollectRptService.getInstance().beginTrace(0, true);
            QZoneTeenOnlineTimeLimitManager.f47099h++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                QLog.d("TeenagerModeOnlineTimeManager", 1, "receive Broadcast action=" + action);
                if (QZoneTeenOnlineTimeHelper.TEEN_PSW_VERIFY_RESULT_ACTION.equals(action)) {
                    QZoneTeenOnlineTimeLimitManager.this.i(intent);
                    return;
                }
                return;
            }
            QLog.e("TeenagerModeOnlineTimeManager", 1, "receive psw broadcast intent is null or action is null");
        }
    }

    public QZoneTeenOnlineTimeLimitManager(Activity activity) {
        this.f47100a = activity;
        j();
    }

    private void j() {
        QLog.d("TeenagerModeOnlineTimeManager", 1, "[registerReceiver]");
        if (this.f47100a == null) {
            return;
        }
        if (this.f47105f == null) {
            this.f47105f = new c();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QZoneTeenOnlineTimeHelper.TEEN_PSW_VERIFY_RESULT_ACTION);
        try {
            this.f47100a.registerReceiver(this.f47105f, intentFilter);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("TeenagerModeOnlineTimeManager", 1, "registerReceiver fail");
        }
    }

    private void k() {
        if (this.f47102c != null) {
            return;
        }
        this.f47103d = new b(this);
        a aVar = new a();
        this.f47104e = aVar;
        QQCustomDialog i3 = com.qzone.component.e.i(this.f47100a, this.f47103d, aVar);
        this.f47102c = i3;
        i3.setCancelable(false);
    }

    private void m() {
        Activity activity = this.f47100a;
        if (activity == null) {
            QLog.e("TeenagerModeOnlineTimeManager", 1, "[unRegisterReceiver]");
            return;
        }
        try {
            activity.unregisterReceiver(this.f47105f);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.e("TeenagerModeOnlineTimeManager", 1, "unRegisterReceiver fail");
        }
        this.f47105f = null;
    }

    public void g() {
        QLog.d("TeenagerModeOnlineTimeManager", 1, "doResume");
        this.f47101b = true;
        if (this.f47106g == null) {
            this.f47106g = new QZoneOnlineTimeReportRunnable(this);
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f47106g);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(this.f47106g);
    }

    public void h() {
        QQCustomDialog qQCustomDialog;
        if (this.f47100a != null && (qQCustomDialog = this.f47102c) != null) {
            if (qQCustomDialog.isShowing()) {
                this.f47102c.dismiss();
            }
            this.f47100a.finish();
            return;
        }
        QLog.e("TeenagerModeOnlineTimeManager", 1, "handleDialogConfirmClick activity is null or dialog is null");
    }

    public void l() {
        Activity activity = this.f47100a;
        if (activity != null && !activity.isFinishing()) {
            k();
            QQCustomDialog qQCustomDialog = this.f47102c;
            if (qQCustomDialog != null && !qQCustomDialog.isShowing()) {
                LpReportInfo_pf00064.allReport(145, 0);
                this.f47102c.show();
                return;
            } else {
                QLog.e("TeenagerModeOnlineTimeManager", 2, "[showAlertDialog] dialog is null or isShowing");
                return;
            }
        }
        QLog.e("TeenagerModeOnlineTimeManager", 1, "[showAlertDialog] mActivity is null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Intent intent) {
        if (intent == null) {
            QLog.e("TeenagerModeOnlineTimeManager", 1, "handleTeenPwdVerifyResult data is null");
            return;
        }
        String stringExtra = intent.getStringExtra("msg");
        String stringExtra2 = intent.getStringExtra("result");
        QLog.d("TeenagerModeOnlineTimeManager", 1, "handleTeenPwdVerifyResult result=" + stringExtra2 + ", msg=" + stringExtra);
        if ("success".equals(stringExtra2)) {
            QQCustomDialog qQCustomDialog = this.f47102c;
            if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
                this.f47102c.dismiss();
            }
            QZoneTeenOnlineTimeHelper.savePswVerifyCorrectTime(LoginData.getInstance().getUin());
        }
    }

    public void e() {
        QLog.d("TeenagerModeOnlineTimeManager", 1, "doDestroy");
        m();
        QQCustomDialog qQCustomDialog = this.f47102c;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        this.f47100a = null;
    }

    public void f() {
        QLog.d("TeenagerModeOnlineTimeManager", 1, "doPause");
        this.f47101b = false;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).removeTask(this.f47106g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a implements DialogInterface.OnClickListener {
        a() {
        }

        private void a() {
            EIPCResult callServer = BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "StudyModeIpcServer_model", "verify_pwd", new Bundle());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("jumpTeenPswVerifyPage isSuc=");
            sb5.append(callServer.code == 0);
            QLog.d("TeenagerModeOnlineTimeManager", 1, sb5.toString());
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(145, 1, 1);
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<QZoneTeenOnlineTimeLimitManager> f47108d;

        public b(QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager) {
            this.f47108d = new WeakReference<>(qZoneTeenOnlineTimeLimitManager);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            LpReportInfo_pf00064.allReport(145, 1, 2);
            WeakReference<QZoneTeenOnlineTimeLimitManager> weakReference = this.f47108d;
            QZoneTeenOnlineTimeLimitManager qZoneTeenOnlineTimeLimitManager = weakReference == null ? null : weakReference.get();
            if (qZoneTeenOnlineTimeLimitManager == null) {
                return;
            }
            qZoneTeenOnlineTimeLimitManager.h();
        }
    }
}
