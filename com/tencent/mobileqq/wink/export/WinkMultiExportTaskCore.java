package com.tencent.mobileqq.wink.export;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.export.WinkMultiExportTaskCore;
import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportErrorParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.utils.ay;
import com.tencent.mobileqq.wink.utils.r;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMultiExportTaskCore {

    /* renamed from: n, reason: collision with root package name */
    private static volatile WinkMultiExportTaskCore f322768n;

    /* renamed from: d, reason: collision with root package name */
    private WinkExportTask f322772d;

    /* renamed from: j, reason: collision with root package name */
    private long f322778j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f322779k;

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<WinkExportTask> f322769a = new CopyOnWriteArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private String f322770b = "QCIRCLE";

    /* renamed from: c, reason: collision with root package name */
    private Object f322771c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private ServiceConnection f322773e = null;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f322774f = false;

    /* renamed from: g, reason: collision with root package name */
    private int f322775g = 0;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f322776h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f322777i = "QCIRCLE";

    /* renamed from: l, reason: collision with root package name */
    BroadcastReceiver f322780l = new a();

    /* renamed from: m, reason: collision with root package name */
    Runnable f322781m = new Runnable() { // from class: com.tencent.mobileqq.wink.export.h
        @Override // java.lang.Runnable
        public final void run() {
            WinkMultiExportTaskCore.this.B();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, String str2, Intent intent) {
            String message;
            if (WinkMultiExportTaskCore.this.f322772d != null && WinkMultiExportTaskCore.this.f322772d.f322847d.equals(str)) {
                WinkMultiExportTaskCore.this.P();
            }
            str2.hashCode();
            if (!str2.equals("wink_export_completed_action")) {
                if (str2.equals("wink_export_error_action")) {
                    QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "on error " + str);
                    ExportErrorParam exportErrorParam = (ExportErrorParam) intent.getParcelableExtra("wink_export_error_param");
                    if (exportErrorParam != null) {
                        String str3 = "null";
                        if (WinkMultiExportTaskCore.this.f322772d != null && WinkMultiExportTaskCore.this.f322772d.f322847d.equals(str)) {
                            int i3 = WinkMultiExportTaskCore.this.f322775g;
                            WinkMultiExportTaskCore winkMultiExportTaskCore = WinkMultiExportTaskCore.this;
                            if (i3 < winkMultiExportTaskCore.x(winkMultiExportTaskCore.f322772d)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("retry error task missionId = ");
                                sb5.append(str);
                                ExportErrorCode exportErrorCode = exportErrorParam.f322838e;
                                if (exportErrorCode == null) {
                                    message = "null";
                                } else {
                                    message = exportErrorCode.getMessage();
                                }
                                sb5.append(message);
                                QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, sb5.toString());
                                WinkMultiExportTaskCore winkMultiExportTaskCore2 = WinkMultiExportTaskCore.this;
                                winkMultiExportTaskCore2.G("E_WINK_EXPORT_C_RETRY_TASK", winkMultiExportTaskCore2.f322772d, "error", "", "" + exportErrorParam.f322838e.transformedCode());
                                WinkMultiExportTaskCore winkMultiExportTaskCore3 = WinkMultiExportTaskCore.this;
                                winkMultiExportTaskCore3.E(winkMultiExportTaskCore3.f322772d);
                            } else {
                                WinkMultiExportTaskCore winkMultiExportTaskCore4 = WinkMultiExportTaskCore.this;
                                winkMultiExportTaskCore4.M(str, winkMultiExportTaskCore4.f322772d, exportErrorParam);
                                WinkMultiExportTaskCore.this.f322772d = null;
                                WinkMultiExportTaskCore.this.v(null);
                            }
                        } else {
                            QLog.e("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "not exporting task " + str);
                        }
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("error task ");
                        ExportErrorCode exportErrorCode2 = exportErrorParam.f322838e;
                        if (exportErrorCode2 != null) {
                            str3 = exportErrorCode2.getMessage();
                        }
                        sb6.append(str3);
                        QLog.e("WinkPublish-Manager-WinkMultiExportTaskCore", 1, sb6.toString());
                        return;
                    }
                    WinkMultiExportTaskCore winkMultiExportTaskCore5 = WinkMultiExportTaskCore.this;
                    winkMultiExportTaskCore5.G("E_WINK_EXPORT_C_TASK_ERROR", winkMultiExportTaskCore5.f322772d, str, "", "");
                    return;
                }
                return;
            }
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "on completed " + str);
            if (WinkMultiExportTaskCore.this.f322772d != null && !TextUtils.isEmpty(WinkMultiExportTaskCore.this.f322772d.f322847d) && WinkMultiExportTaskCore.this.f322772d.f322847d.equals(str)) {
                WinkMultiExportTaskCore winkMultiExportTaskCore6 = WinkMultiExportTaskCore.this;
                winkMultiExportTaskCore6.G("E_WINK_EXPORT_C_COMPLETED", winkMultiExportTaskCore6.f322772d, "", "", "0");
                WinkMultiExportTaskCore.this.f322772d = null;
            } else {
                WinkMultiExportTaskCore winkMultiExportTaskCore7 = WinkMultiExportTaskCore.this;
                winkMultiExportTaskCore7.G("E_WINK_EXPORT_C_COMPLETED", winkMultiExportTaskCore7.f322772d, "notExportTask", "", "0");
                QLog.e("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "not exporting task " + str);
            }
            ExportCompletedParam exportCompletedParam = (ExportCompletedParam) intent.getParcelableExtra("wink_export_completed_param");
            WinkMultiExportTaskCore winkMultiExportTaskCore8 = WinkMultiExportTaskCore.this;
            winkMultiExportTaskCore8.L(str, winkMultiExportTaskCore8.f322772d, exportCompletedParam);
            WinkMultiExportTaskCore.this.v(null);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            String str;
            final String action = intent.getAction();
            final String stringExtra = intent.getStringExtra("wink_export_mission_id");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive action = ");
            sb5.append(action);
            sb5.append(" missionID = ");
            sb5.append(stringExtra);
            sb5.append(" exportingTask id = ");
            if (WinkMultiExportTaskCore.this.f322772d != null) {
                str = WinkMultiExportTaskCore.this.f322772d.f322847d;
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, sb5.toString());
            WinkMultiExportTaskCore.this.f322779k.post(new Runnable() { // from class: com.tencent.mobileqq.wink.export.l
                @Override // java.lang.Runnable
                public final void run() {
                    WinkMultiExportTaskCore.a.this.b(stringExtra, action, intent);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, " onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, " onServiceDisconnected");
        }
    }

    WinkMultiExportTaskCore() {
        F();
        this.f322779k = RFWThreadManager.createNewThreadHandler("WinkMultiCoreQueue", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(String str) {
        String str2;
        WinkExportTask winkExportTask;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("cancelTask missionId = ");
        sb5.append(str);
        sb5.append(" exportingTask missionId = ");
        WinkExportTask winkExportTask2 = this.f322772d;
        String str3 = "";
        if (winkExportTask2 == null) {
            str2 = "";
        } else {
            str2 = winkExportTask2.f322847d;
        }
        sb5.append(str2);
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, sb5.toString());
        WinkExportTask winkExportTask3 = this.f322772d;
        if (winkExportTask3 != null && winkExportTask3.f322847d.equals(str)) {
            G("E_WINK_EXPORT_C_CANCEL_TASK", this.f322772d, "isExporting", "", "0");
            K("wink_export_cancel_task_action", this.f322772d, str);
            this.f322772d = null;
        } else {
            Iterator<WinkExportTask> it = this.f322769a.iterator();
            while (true) {
                if (it.hasNext()) {
                    winkExportTask = it.next();
                    if (winkExportTask.f322847d.equals(str)) {
                        break;
                    }
                } else {
                    winkExportTask = null;
                    break;
                }
            }
            if (winkExportTask != null) {
                WinkExportTask winkExportTask4 = this.f322772d;
                if (winkExportTask4 != null) {
                    str3 = winkExportTask4.f322847d;
                }
                G("E_WINK_EXPORT_C_CANCEL_TASK", winkExportTask, "notExporting", str3, "0");
                K("wink_export_cancel_task_action", winkExportTask, str);
                this.f322769a.remove(winkExportTask);
            }
        }
        v(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "checkRunnable lastNotifyTime = " + this.f322778j + " currentTime = " + System.currentTimeMillis());
        N();
        if (System.currentTimeMillis() - this.f322778j > 15000) {
            this.f322779k.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.export.WinkMultiExportTaskCore.2
                @Override // java.lang.Runnable
                public void run() {
                    QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "checkRunnable lastNotifyTime = " + WinkMultiExportTaskCore.this.f322778j + " currentTime = " + System.currentTimeMillis());
                    if (System.currentTimeMillis() - WinkMultiExportTaskCore.this.f322778j > 15000 && WinkMultiExportTaskCore.this.f322772d != null) {
                        int i3 = WinkMultiExportTaskCore.this.f322775g;
                        WinkMultiExportTaskCore winkMultiExportTaskCore = WinkMultiExportTaskCore.this;
                        if (i3 < winkMultiExportTaskCore.x(winkMultiExportTaskCore.f322772d)) {
                            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "out time retryTask " + WinkMultiExportTaskCore.this.f322772d.f322847d);
                            WinkMultiExportTaskCore winkMultiExportTaskCore2 = WinkMultiExportTaskCore.this;
                            winkMultiExportTaskCore2.G("E_WINK_EXPORT_C_RETRY_TASK", winkMultiExportTaskCore2.f322772d, "timeout", "", "0");
                            WinkMultiExportTaskCore winkMultiExportTaskCore3 = WinkMultiExportTaskCore.this;
                            winkMultiExportTaskCore3.E(winkMultiExportTaskCore3.f322772d);
                            return;
                        }
                        ExportErrorParam exportErrorParam = new ExportErrorParam(WinkMultiExportTaskCore.this.f322772d.f322847d, new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_TIMEOUT, null));
                        WinkMultiExportTaskCore winkMultiExportTaskCore4 = WinkMultiExportTaskCore.this;
                        winkMultiExportTaskCore4.M(winkMultiExportTaskCore4.f322772d.f322847d, WinkMultiExportTaskCore.this.f322772d, exportErrorParam);
                        WinkMultiExportTaskCore winkMultiExportTaskCore5 = WinkMultiExportTaskCore.this;
                        winkMultiExportTaskCore5.K("wink_export_cancel_task_action", winkMultiExportTaskCore5.f322772d, WinkMultiExportTaskCore.this.f322772d.f322847d);
                        WinkMultiExportTaskCore.this.f322772d = null;
                        WinkMultiExportTaskCore.this.v(null);
                    }
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(WinkExportTask winkExportTask) {
        WinkExportTask winkExportTask2 = this.f322772d;
        if (winkExportTask2 != null && winkExportTask2.f322847d.equals(winkExportTask.f322847d)) {
            this.f322772d = null;
        }
        v(winkExportTask);
        this.f322775g++;
    }

    private void D() {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "noTaskNeedToRun");
        Runnable runnable = this.f322776h;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
            this.f322776h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(final WinkExportTask winkExportTask) {
        if (winkExportTask == null) {
            return;
        }
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "reTryTask = " + winkExportTask.f322847d);
        if (winkExportTask.f322851i != 2 && winkExportTask.f322848e.equals("QZONE")) {
            winkExportTask.f322851i = 2;
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "reTryTask switch qzone " + winkExportTask.f322847d);
        } else if (winkExportTask.f322851i != 1) {
            winkExportTask.f322851i = 1;
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "reTryTask switch main " + winkExportTask.f322847d);
        }
        K("wink_export_cancel_task_action", winkExportTask, this.f322772d.f322847d);
        this.f322779k.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.export.k
            @Override // java.lang.Runnable
            public final void run() {
                WinkMultiExportTaskCore.this.C(winkExportTask);
            }
        }, y(winkExportTask));
    }

    private void F() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("wink_export_start_action");
        intentFilter.addAction("wink_export_ing_action");
        intentFilter.addAction("wink_export_ing_action_for_core");
        intentFilter.addAction("wink_export_completed_action");
        intentFilter.addAction("wink_export_error_action");
        intentFilter.addAction("wink_export_pause_all_task_action");
        intentFilter.addAction("wink_export_cancel_success_action");
        BaseApplication.getContext().registerReceiver(this.f322780l, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, WinkExportTask winkExportTask, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        WinkExportParams winkExportParams;
        try {
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId(str);
            String str9 = "";
            if (winkExportTask == null || (winkExportParams = winkExportTask.f322849f) == null) {
                str5 = "";
            } else {
                str5 = winkExportParams.F;
            }
            WinkPublishQualityReportData.Builder traceId = eventId.traceId(str5);
            if (winkExportTask == null) {
                str6 = "";
            } else {
                str6 = winkExportTask.f322847d;
            }
            WinkPublishQualityReportData.Builder ext1 = traceId.ext1(str6);
            if (winkExportTask == null) {
                str7 = "";
            } else {
                str7 = winkExportTask.f322851i + "";
            }
            WinkPublishQualityReportData.Builder ext5 = ext1.ext2(str7).ext3(str2).ext4(str3).ext5(this.f322770b);
            if (winkExportTask != null) {
                str9 = winkExportTask.f322848e + "";
            }
            WinkPublishQualityReportData reportData = ext5.ext6(str9).retCode(str4).getReportData();
            if (winkExportTask != null) {
                str8 = winkExportTask.f322848e;
            } else {
                str8 = this.f322777i;
            }
            WinkPublishReportQueue.INSTANCE.report(reportData, str8);
        } catch (Exception e16) {
            QLog.e("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "report error = " + e16);
        }
    }

    private void H(WinkExportTask winkExportTask) {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "runTask " + winkExportTask.f322847d);
        P();
        int i3 = winkExportTask.f322851i;
        if (i3 == 1) {
            d.t().K(winkExportTask);
        } else if (i3 == 2) {
            I(winkExportTask);
        } else if (i3 == 9) {
            if (winkExportTask.f322848e.equals("QZONE") && !t()) {
                I(winkExportTask);
                QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "runTask " + winkExportTask.f322847d + " start peak from qZone ");
            } else {
                J(winkExportTask);
            }
        } else {
            J(winkExportTask);
        }
        G("E_WINK_EXPORT_C_START_TASK", winkExportTask, winkExportTask.f322848e, this.f322770b, "0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(String str, WinkExportTask winkExportTask, String str2) {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "sendBroadcast action " + str + " " + str2);
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction(str);
        if (winkExportTask != null) {
            intent.putExtra("wink_export_task", winkExportTask);
        }
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("wink_export_mission_id", str2);
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str, WinkExportTask winkExportTask, ExportCompletedParam exportCompletedParam) {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "sendCoreExportCompletedBroadCast " + str);
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_completed_action_from_core");
        if (exportCompletedParam != null) {
            intent.putExtra("wink_export_completed_param", exportCompletedParam);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        if (winkExportTask != null) {
            intent.putExtra("wink_export_task", winkExportTask);
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(String str, WinkExportTask winkExportTask, ExportErrorParam exportErrorParam) {
        G("E_WINK_EXPORT_C_REAL_ERROR", winkExportTask, "", "", "" + exportErrorParam.f322838e.transformedCode());
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "sendRealExportErrorBroadCast " + str);
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_real_export_error_action");
        intent.putExtra("wink_export_error_param", exportErrorParam);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        if (winkExportTask != null) {
            intent.putExtra("wink_export_task", winkExportTask);
        }
        BaseApplication.getContext().sendBroadcast(intent);
    }

    private void N() {
        Runnable runnable = this.f322776h;
        if (runnable != null) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        if (this.f322772d != null || !this.f322769a.isEmpty()) {
            this.f322776h = ThreadManagerV2.executeDelay(this.f322781m, 16, null, true, 5000L);
        }
        if (this.f322769a.isEmpty()) {
            QLog.e("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "sendWaitingBroadCast list null");
            return;
        }
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "sendWaitingBroadCast action " + this.f322769a.size());
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_waiting_action");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f322769a);
        intent.putExtra("wink_export_waiting_list", arrayList);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        this.f322778j = System.currentTimeMillis();
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "set lastNotifyTime: " + this.f322778j);
        if (this.f322776h == null) {
            this.f322776h = ThreadManagerV2.executeDelay(this.f322781m, 16, null, true, 5000L);
        }
    }

    @SuppressLint({"WrongConstant"})
    private void s() {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "bindPeakService");
        QzoneConfig.getInstance();
        if (!QzoneConfig.isBindPeakServiceEnable() || this.f322774f) {
            return;
        }
        if (this.f322773e == null) {
            this.f322773e = new b();
        }
        BaseApplication.getContext().bindService(new Intent(BaseApplication.getContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass()), this.f322773e, 1);
        this.f322774f = true;
    }

    private boolean t() {
        if (r.f(BaseApplication.getContext())) {
            QLog.d("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "peakAlive");
            return true;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (!peekAppRuntime.isBackgroundPause && !peekAppRuntime.isBackgroundStop)) {
            return true;
        }
        QLog.d("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "appRuntime isBack");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(WinkExportTask winkExportTask) {
        String str;
        if (winkExportTask == null) {
            this.f322775g = 0;
        }
        synchronized (this.f322771c) {
            if (winkExportTask != null) {
                QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "doNext task missionId = " + winkExportTask.f322847d);
                G("E_WINK_EXPORT_C_DO_NEXT_TASK", winkExportTask, "", winkExportTask.f322850h + "", "0");
                if (winkExportTask.f322850h) {
                    WinkExportTask winkExportTask2 = this.f322772d;
                    if (winkExportTask2 != null) {
                        u(winkExportTask2.f322847d);
                    }
                    this.f322772d = winkExportTask;
                    this.f322769a.remove(winkExportTask);
                    H(winkExportTask);
                } else {
                    WinkExportTask winkExportTask3 = this.f322772d;
                    if (winkExportTask3 != null) {
                        if (winkExportTask3.f322847d.equals(winkExportTask.f322847d)) {
                            this.f322772d = winkExportTask;
                            this.f322769a.remove(winkExportTask);
                            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "doNext  is same task = " + this.f322772d.f322847d + " taskSize = " + this.f322769a.size());
                        } else {
                            this.f322769a.add(winkExportTask);
                            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "doNext  has running task = " + this.f322772d.f322847d + " taskSize = " + this.f322769a.size());
                        }
                    } else {
                        this.f322772d = winkExportTask;
                        this.f322769a.remove(winkExportTask);
                        H(winkExportTask);
                    }
                }
            } else if (this.f322772d == null && this.f322769a.size() > 0) {
                Iterator<WinkExportTask> it = this.f322769a.iterator();
                WinkExportTask winkExportTask4 = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    WinkExportTask next = it.next();
                    if (winkExportTask4 == null) {
                        winkExportTask4 = next;
                    }
                    WinkExportParams winkExportParams = next.f322849f;
                    if (winkExportParams != null && this.f322770b.equals(winkExportParams.D)) {
                        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "mScene equals " + this.f322770b + " " + next.f322847d);
                        winkExportTask4 = next;
                        break;
                    }
                }
                this.f322769a.remove(winkExportTask4);
                this.f322772d = winkExportTask4;
                H(winkExportTask4);
            } else {
                WinkExportTask winkExportTask5 = this.f322772d;
                if (winkExportTask5 != null) {
                    G("E_WINK_EXPORT_C_DO_NEXT_TASK", winkExportTask5, "notRun", this.f322769a.size() + "", "0");
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("task not to run ,exportingTask = ");
                WinkExportTask winkExportTask6 = this.f322772d;
                if (winkExportTask6 != null) {
                    str = winkExportTask6.f322847d;
                } else {
                    str = "";
                }
                sb5.append(str);
                sb5.append(" mTaskList ");
                sb5.append(this.f322769a.size());
                QLog.e("WinkPublish-Manager-WinkMultiExportTaskCore", 1, sb5.toString());
            }
        }
        WinkExportTask winkExportTask7 = this.f322772d;
        if (winkExportTask7 == null) {
            D();
        } else {
            this.f322777i = winkExportTask7.f322848e;
        }
    }

    public static WinkMultiExportTaskCore w() {
        if (f322768n == null) {
            synchronized (WinkMultiExportTaskCore.class) {
                if (f322768n == null) {
                    f322768n = new WinkMultiExportTaskCore();
                }
            }
        }
        return f322768n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x(WinkExportTask winkExportTask) {
        if (winkExportTask == null || winkExportTask.f322849f == null || !"QCIRCLE".equals(winkExportTask.f322848e) || winkExportTask.f322849f.G != 1) {
            return 1;
        }
        return ay.f326693a.b("qqcircle_wink_compress_retry_count", 3);
    }

    private int y(WinkExportTask winkExportTask) {
        if (winkExportTask == null || winkExportTask.f322849f == null || !"QCIRCLE".equals(winkExportTask.f322848e) || winkExportTask.f322849f.G != 1) {
            return 2000;
        }
        return ay.f326693a.b("qqcircle_wink_compress_retry_delay_time", 4000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(WinkExportTask winkExportTask) {
        if (winkExportTask != null && !TextUtils.isEmpty(winkExportTask.f322847d)) {
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "addTask " + winkExportTask.f322847d + " size= " + this.f322769a.size());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("size= ");
            sb5.append(this.f322769a.size());
            G("E_WINK_EXPORT_C_ADD_TASK", winkExportTask, sb5.toString(), "", "0");
            Iterator<WinkExportTask> it = this.f322769a.iterator();
            while (it.hasNext()) {
                WinkExportTask next = it.next();
                if (next.f322847d.equals(winkExportTask.f322847d)) {
                    this.f322769a.remove(next);
                    G("E_WINK_EXPORT_C_ADD_TASK", winkExportTask, "sameIdSize=" + this.f322769a.size(), "", "0");
                    QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "addTask " + winkExportTask.f322847d + " sameIdSize= " + this.f322769a.size());
                }
            }
            v(winkExportTask);
            return;
        }
        G("E_WINK_EXPORT_C_ADD_TASK", winkExportTask, "size= " + this.f322769a.size(), "exportTask = " + winkExportTask, "0");
    }

    void I(WinkExportTask winkExportTask) {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "runTaskForOther " + winkExportTask.f322847d);
        K("wink_export_add_task_action", winkExportTask, winkExportTask.f322847d);
    }

    void J(WinkExportTask winkExportTask) {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "runTaskForPeak " + winkExportTask.f322847d);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
        intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 12);
        intent.putExtra("wink_export_task", winkExportTask);
        try {
            BaseApplication.getContext().startService(intent);
            s();
        } catch (Exception e16) {
            QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "start peak service exception " + e16.getMessage());
        }
    }

    public void O(String str) {
        QLog.i("WinkPublish-Manager-WinkMultiExportTaskCore", 1, "setScenes " + str);
        this.f322770b = str;
    }

    public void r(final WinkExportTask winkExportTask) {
        this.f322779k.post(new Runnable() { // from class: com.tencent.mobileqq.wink.export.i
            @Override // java.lang.Runnable
            public final void run() {
                WinkMultiExportTaskCore.this.z(winkExportTask);
            }
        });
    }

    public void u(final String str) {
        this.f322779k.post(new Runnable() { // from class: com.tencent.mobileqq.wink.export.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkMultiExportTaskCore.this.A(str);
            }
        });
    }
}
