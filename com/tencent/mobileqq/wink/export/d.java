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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.export.WinkVideoComposeTask;
import com.tencent.mobileqq.wink.editor.export.ab;
import com.tencent.mobileqq.wink.export.d;
import com.tencent.mobileqq.wink.export.model.ExportCompletedParam;
import com.tencent.mobileqq.wink.export.model.ExportErrorParam;
import com.tencent.mobileqq.wink.export.model.ExportStartParam;
import com.tencent.mobileqq.wink.export.model.ExportWaitingParam;
import com.tencent.mobileqq.wink.export.model.ExportingParam;
import com.tencent.mobileqq.wink.export.model.WinkExportTask;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskSnapshotApi;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes21.dex */
public class d {

    /* renamed from: j, reason: collision with root package name */
    private static volatile d f322791j;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    private Handler f322798g;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, WinkExportTask> f322792a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, com.tencent.mobileqq.wink.editor.export.d> f322793b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, x73.a> f322794c = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f322796e = false;

    /* renamed from: f, reason: collision with root package name */
    private ServiceConnection f322797f = null;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f322799h = new c();

    /* renamed from: i, reason: collision with root package name */
    com.tencent.mobileqq.wink.editor.export.c f322800i = new C9050d();

    /* renamed from: d, reason: collision with root package name */
    private int f322795d = MobileQQ.sProcessId;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f322801a;

        a(String str) {
            this.f322801a = str;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NonNull WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            if (winkPublishServiceProxy2.cancelExportTask(this.f322801a)) {
                QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "postCancelToCore = " + this.f322801a);
                d dVar = d.this;
                dVar.B("E_WINK_EXPORT_M_CANCEL_CORE", (WinkExportTask) dVar.f322792a.get(this.f322801a), "", "", "0");
                return;
            }
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "cancelTask error exportTask = " + this.f322801a);
            d dVar2 = d.this;
            dVar2.B("E_WINK_EXPORT_M_CANCEL_CORE", (WinkExportTask) dVar2.f322792a.get(this.f322801a), "", "", ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_TO_CORE_ERROR + "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Intent intent, String str) {
            x73.a aVar;
            ExportCompletedParam exportCompletedParam = (ExportCompletedParam) intent.getParcelableExtra("wink_export_completed_param");
            if (exportCompletedParam != null && !TextUtils.isEmpty(str) && d.this.f322794c.containsKey(str) && (aVar = (x73.a) d.this.f322794c.get(str)) != null) {
                QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "real onCompleted missionId = " + str + " listener = " + aVar);
                aVar.onCompleted(str, exportCompletedParam);
                WinkExportTask winkExportTask = (WinkExportTask) d.this.f322792a.get(str);
                if (winkExportTask != null) {
                    d.this.B("E_WINK_EXPORT_M_COMPLETED", winkExportTask, exportCompletedParam.f322836f + "", "receive", "0");
                }
                QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "real onCompleted missionId = " + str + "remove listener = " + ((x73.a) d.this.f322794c.remove(str)));
                d.this.f322792a.remove(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(String str, int i3, Intent intent, WinkExportTask winkExportTask) {
            com.tencent.mobileqq.wink.editor.export.d dVar;
            x73.a aVar;
            String str2;
            WinkEditDataWrapper d16;
            String str3 = "WinkPublish-Manager-WinkMultiExportManager";
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "error missionId = " + str + " " + i3);
            ExportErrorParam exportErrorParam = (ExportErrorParam) intent.getParcelableExtra("wink_export_error_param");
            if (exportErrorParam != null && !TextUtils.isEmpty(str)) {
                if (d.this.f322794c.containsKey(str) && (aVar = (x73.a) d.this.f322794c.get(str)) != null) {
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "real error missionId = " + str + " listener = " + aVar);
                    WinkExportTask winkExportTask2 = (WinkExportTask) d.this.f322792a.get(str);
                    boolean z16 = false;
                    if (winkExportTask2 != null && winkExportTask2.f322849f.j() && (d16 = com.tencent.mobileqq.wink.editor.draft.a.d(winkExportTask2.f322847d)) != null && WinkExportUtils.N(d16)) {
                        LocalMediaInfo localMediaInfo = d16.getOriginMediaInfos().get(0);
                        d.this.C(localMediaInfo, winkExportTask2);
                        if (localMediaInfo.fileSize < uq3.c.M4()) {
                            ExportCompletedParam exportCompletedParam = new ExportCompletedParam(winkExportTask2.f322847d, localMediaInfo, false);
                            aVar.onCompleted(str, exportCompletedParam);
                            d.this.B("E_WINK_EXPORT_M_COMPLETED", winkExportTask2, exportCompletedParam.f322836f + "", "receive", "0");
                            w53.b.c("WinkPublish-Manager-WinkMultiExportManager", "export error, upload origin video!");
                            z16 = true;
                        } else {
                            w53.b.c("WinkPublish-Manager-WinkMultiExportManager", "export error, file too large, not upload origin video!");
                        }
                    }
                    if (!z16) {
                        aVar.onExportError(str, exportErrorParam);
                        if (winkExportTask2 != null) {
                            d dVar2 = d.this;
                            StringBuilder sb5 = new StringBuilder();
                            str2 = "WinkPublish-Manager-WinkMultiExportManager";
                            sb5.append(exportErrorParam.f322838e.transformedCode());
                            sb5.append("");
                            dVar2.B("E_WINK_EXPORT_M_REAL_ERROR", winkExportTask2, "", "receive", sb5.toString());
                            str3 = str2;
                            QLog.i(str3, 1, "real error missionId = " + str + "remove listener = " + ((x73.a) d.this.f322794c.remove(str)));
                            d.this.f322792a.remove(str);
                        }
                    }
                    str2 = "WinkPublish-Manager-WinkMultiExportManager";
                    str3 = str2;
                    QLog.i(str3, 1, "real error missionId = " + str + "remove listener = " + ((x73.a) d.this.f322794c.remove(str)));
                    d.this.f322792a.remove(str);
                }
                if (d.this.f322793b.containsKey(str) && (dVar = (com.tencent.mobileqq.wink.editor.export.d) d.this.f322793b.get(str)) != null) {
                    QLog.i(str3, 1, "error cancel missionId = " + str);
                    dVar.cancel();
                    if (winkExportTask != null) {
                        d.this.B("E_WINK_EXPORT_M_REAL_ERROR", winkExportTask, "errorCancel", "receive", "");
                    }
                    d.this.f322793b.remove(str);
                }
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            x73.a aVar;
            com.tencent.mobileqq.wink.editor.export.d dVar;
            x73.a aVar2;
            x73.a aVar3;
            String action = intent.getAction();
            final WinkExportTask winkExportTask = (WinkExportTask) intent.getParcelableExtra("wink_export_task");
            final String stringExtra = intent.getStringExtra("wink_export_mission_id");
            char c16 = '\uffff';
            final int intExtra = intent.getIntExtra("wink_export_process_id", -1);
            action.hashCode();
            switch (action.hashCode()) {
                case -2080207837:
                    if (action.equals("wink_export_waiting_action")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case -2022101466:
                    if (action.equals("wink_export_cancel_task_action")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case -1159266514:
                    if (action.equals("wink_export_start_action")) {
                        c16 = 2;
                        break;
                    }
                    break;
                case -456286610:
                    if (action.equals("wink_export_ing_action")) {
                        c16 = 3;
                        break;
                    }
                    break;
                case 10941239:
                    if (action.equals("wink_export_add_task_action")) {
                        c16 = 4;
                        break;
                    }
                    break;
                case 1476053754:
                    if (action.equals("wink_export_completed_action_from_core")) {
                        c16 = 5;
                        break;
                    }
                    break;
                case 1663990023:
                    if (action.equals("wink_real_export_error_action")) {
                        c16 = 6;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "waiting missionId = " + stringExtra + " " + intExtra);
                    ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("wink_export_waiting_list");
                    if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                        Iterator it = parcelableArrayListExtra.iterator();
                        while (it.hasNext()) {
                            WinkExportTask winkExportTask2 = (WinkExportTask) it.next();
                            if (winkExportTask2 != null) {
                                String str = winkExportTask2.f322847d;
                                if (!TextUtils.isEmpty(str) && d.this.f322794c.containsKey(str) && (aVar = (x73.a) d.this.f322794c.get(str)) != null) {
                                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "real waiting missionId = " + str + " listener = " + aVar);
                                    aVar.onExportWaiting(str, new ExportWaitingParam(str));
                                    d.this.B("E_WINK_EXPORT_M_WAITING_TASK", winkExportTask2, "", "receive", "0");
                                }
                            }
                        }
                        return;
                    }
                    return;
                case 1:
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "cancel missionId = " + stringExtra + " " + d.this.f322795d);
                    if (!TextUtils.isEmpty(stringExtra) && (dVar = (com.tencent.mobileqq.wink.editor.export.d) d.this.f322793b.get(stringExtra)) != null) {
                        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "real cancel missionId = " + stringExtra);
                        dVar.cancel();
                        if (winkExportTask != null) {
                            d.this.B("E_WINK_EXPORT_M_CANCEL_TASK", winkExportTask, "", "receive", "");
                        }
                        d.this.f322793b.remove(stringExtra);
                        return;
                    }
                    return;
                case 2:
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "start missionId = " + stringExtra + " " + intExtra);
                    if (!TextUtils.isEmpty(stringExtra) && d.this.f322794c.containsKey(stringExtra) && (aVar2 = (x73.a) d.this.f322794c.get(stringExtra)) != null) {
                        ExportStartParam exportStartParam = (ExportStartParam) intent.getParcelableExtra("wink_export_start_param");
                        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "start missionId = " + stringExtra + ", exportStartParams=" + exportStartParam);
                        aVar2.onExportStart(stringExtra, exportStartParam);
                        WinkExportTask winkExportTask3 = (WinkExportTask) d.this.f322792a.get(stringExtra);
                        if (winkExportTask3 != null) {
                            d.this.B("E_WINK_EXPORT_M_REAL_START_TASK", winkExportTask3, "", "receive", "0");
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    ExportingParam exportingParam = (ExportingParam) intent.getParcelableExtra("wink_exporting_param");
                    if (exportingParam != null && !TextUtils.isEmpty(stringExtra) && d.this.f322794c.containsKey(stringExtra) && (aVar3 = (x73.a) d.this.f322794c.get(stringExtra)) != null) {
                        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "receive real exporting missionId = " + stringExtra + " progress = " + exportingParam.f322842e + " listener = " + aVar3);
                        aVar3.onExporting(stringExtra, exportingParam);
                        return;
                    }
                    return;
                case 4:
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "addTask missionId = " + stringExtra + " " + intExtra);
                    if (winkExportTask != null && d.this.f322795d == 2) {
                        int i3 = winkExportTask.f322851i;
                        if (i3 == 2) {
                            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "receive addTask missionId = " + stringExtra);
                            d.this.K(winkExportTask);
                            return;
                        }
                        if (i3 == 9 && winkExportTask.f322848e.equals("QZONE")) {
                            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "receive addTask missionId = " + stringExtra + " start peak from qzone");
                            d.this.E(winkExportTask);
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "onCompleted missionId = " + stringExtra + " " + intExtra);
                    d.this.D(new Runnable() { // from class: com.tencent.mobileqq.wink.export.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.c.this.c(intent, stringExtra);
                        }
                    });
                    return;
                case 6:
                    d.this.D(new Runnable() { // from class: com.tencent.mobileqq.wink.export.f
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.c.this.d(stringExtra, intExtra, intent, winkExportTask);
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.export.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public class C9050d implements com.tencent.mobileqq.wink.editor.export.c {
        C9050d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(String str, LocalMediaInfo localMediaInfo, boolean z16) {
            QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExportCompleted missionID = " + str);
            d.this.F(str, new ExportCompletedParam(str, localMediaInfo, z16));
        }

        @Override // com.tencent.mobileqq.wink.editor.export.c
        public void a(String str) {
            QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExportCancel missionID = " + str);
            WinkExportTask winkExportTask = (WinkExportTask) d.this.f322792a.get(str);
            if (winkExportTask != null) {
                d.this.B("E_WINK_EXPORT_M_CANCEL_TASK", winkExportTask, "", "listener", "0");
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.export.c
        public void b(String str, ExportingParam exportingParam) {
            QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExporting exportingParam = " + exportingParam.toString() + " listener size:" + d.this.f322794c.size());
            if (!d.this.f322794c.containsKey(str)) {
                d.this.I(str, exportingParam);
                return;
            }
            x73.a aVar = (x73.a) d.this.f322794c.get(str);
            aVar.onExporting(str, exportingParam);
            if (d.this.f322795d == 1 || d.this.f322795d == 2) {
                d.this.J(str, exportingParam);
            }
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "real export ing missionId = " + str + " progress = " + exportingParam.f322842e + " listener = " + aVar);
        }

        @Override // com.tencent.mobileqq.wink.editor.export.c
        public void c(String str, ExportErrorCode exportErrorCode) {
            QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExportError missionID = " + str);
            if (TextUtils.isEmpty(str)) {
                QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExportError missionID is null");
                d.this.B("E_WINK_EXPORT_M_TASK_ERROR", null, "missionIdNull", "listener", exportErrorCode.transformedCode() + "");
                return;
            }
            WinkExportTask winkExportTask = (WinkExportTask) d.this.f322792a.get(str);
            if (winkExportTask != null) {
                d.this.B("E_WINK_EXPORT_M_TASK_ERROR", winkExportTask, "", "listener", exportErrorCode.transformedCode() + "");
            }
            d.this.G(str, new ExportErrorParam(str, exportErrorCode));
            d.this.f322793b.remove(str);
        }

        @Override // com.tencent.mobileqq.wink.editor.export.c
        public void d(final String str, final LocalMediaInfo localMediaInfo, final boolean z16) {
            d.this.D(new Runnable() { // from class: com.tencent.mobileqq.wink.export.g
                @Override // java.lang.Runnable
                public final void run() {
                    d.C9050d.this.h(str, localMediaInfo, z16);
                }
            });
        }

        @Override // com.tencent.mobileqq.wink.editor.export.c
        public void e(String str, int i3) {
            QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExportStart missionID = " + str);
            ExportStartParam exportStartParam = new ExportStartParam(i3);
            if (!d.this.f322794c.containsKey(str)) {
                d.this.H(str, exportStartParam);
                return;
            }
            ((x73.a) d.this.f322794c.get(str)).onExportStart(str, exportStartParam);
            WinkExportTask winkExportTask = (WinkExportTask) d.this.f322792a.get(str);
            if (winkExportTask != null) {
                d.this.B("E_WINK_EXPORT_M_REAL_START_TASK", winkExportTask, "", "listener", "0");
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.export.c
        public void f(String str, int i3) {
            QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "onWinkVideoExport missionID = " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, " onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, " onServiceDisconnected");
        }
    }

    d() {
        A();
        this.f322798g = RFWThreadManager.createNewThreadHandler("WinkMultiManagerQueue", 0);
    }

    private void A() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("wink_export_start_action");
        intentFilter.addAction("wink_export_ing_action");
        intentFilter.addAction("wink_export_completed_action_from_core");
        intentFilter.addAction("wink_export_add_task_action");
        intentFilter.addAction("wink_export_waiting_action");
        intentFilter.addAction("wink_real_export_error_action");
        intentFilter.addAction("wink_export_pause_all_task_action");
        intentFilter.addAction("wink_export_cancel_task_action");
        intentFilter.addAction("wink_export_cancel_success_action");
        BaseApplication.getContext().registerReceiver(this.f322799h, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(String str, WinkExportTask winkExportTask, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        WinkExportParams winkExportParams;
        try {
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId(str);
            String str8 = "";
            if (winkExportTask == null || (winkExportParams = winkExportTask.f322849f) == null) {
                str5 = "";
            } else {
                str5 = winkExportParams.F;
            }
            WinkPublishQualityReportData.Builder traceId = eventId.traceId(str5);
            if (winkExportTask == null || (str6 = winkExportTask.f322847d) == null) {
                str6 = "";
            }
            WinkPublishQualityReportData.Builder ext1 = traceId.ext1(str6);
            if (winkExportTask == null || winkExportTask.f322851i == 0) {
                str7 = "";
            } else {
                str7 = winkExportTask.f322851i + "";
            }
            WinkPublishQualityReportData.Builder ext5 = ext1.ext2(str7).ext3(str2).ext4(str3).ext5(this.f322795d + "");
            if (winkExportTask != null) {
                str8 = winkExportTask.f322848e + "";
            }
            WinkPublishQualityReportData reportData = ext5.ext6(str8).retCode(str4).getReportData();
            String str9 = "QCIRCLE";
            if (winkExportTask != null) {
                str9 = winkExportTask.f322848e;
            }
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.b(reportData, str9);
            }
        } catch (Exception e16) {
            QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, "report error = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(LocalMediaInfo localMediaInfo, WinkExportTask winkExportTask) {
        String str;
        String str2;
        String str3;
        WinkExportParams winkExportParams;
        try {
            WinkPublishQualityReportData.Builder eventId = new WinkPublishQualityReportData.Builder().eventId("P_VIDEO_PARAMS");
            if (winkExportTask == null || (winkExportParams = winkExportTask.f322849f) == null) {
                str = "";
            } else {
                str = winkExportParams.F;
            }
            WinkPublishQualityReportData.Builder traceId = eventId.traceId(str);
            if (winkExportTask == null || (str2 = winkExportTask.f322847d) == null) {
                str2 = "";
            }
            WinkPublishQualityReportData.Builder ext1 = traceId.ext1(str2);
            if (winkExportTask == null || winkExportTask.f322851i == 0) {
                str3 = "";
            } else {
                str3 = winkExportTask.f322851i + "";
            }
            WinkPublishQualityReportData reportData = ext1.ext2(str3).ext3(localMediaInfo.fileSize + "").ext4(localMediaInfo.mediaWidth + "").ext5(localMediaInfo.mediaWidth + "").ext6(localMediaInfo.mediaBitrate + "").retCode("0").getReportData();
            String str4 = "QCIRCLE";
            if (winkExportTask != null) {
                str4 = winkExportTask.f322848e;
            }
            z93.c f16 = Wink.INSTANCE.f();
            if (f16 != null) {
                f16.b(reportData, str4);
            }
        } catch (Exception e16) {
            QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, "report error = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(Runnable runnable) {
        Handler handler = this.f322798g;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str, ExportCompletedParam exportCompletedParam) {
        QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "sendExportCompletedBroadCast missionID = " + str);
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_completed_action");
        if (exportCompletedParam != null) {
            intent.putExtra("wink_export_completed_param", exportCompletedParam);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        intent.putExtra("wink_export_process_id", this.f322795d);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, ExportErrorParam exportErrorParam) {
        QLog.d("WinkPublish-Manager-WinkMultiExportManager", 1, "sendExportErrorBroadCast missionID = " + str);
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_error_action");
        if (exportErrorParam != null) {
            intent.putExtra("wink_export_error_param", exportErrorParam);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        intent.putExtra("wink_export_process_id", this.f322795d);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, ExportStartParam exportStartParam) {
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_start_action");
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        if (exportStartParam != null) {
            intent.putExtra("wink_export_start_param", exportStartParam);
        }
        intent.putExtra("wink_export_process_id", this.f322795d);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, ExportingParam exportingParam) {
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_ing_action");
        if (exportingParam != null) {
            intent.putExtra("wink_exporting_param", exportingParam);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        intent.putExtra("wink_export_process_id", this.f322795d);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str, ExportingParam exportingParam) {
        Intent intent = new Intent();
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.setAction("wink_export_ing_action_for_core");
        if (exportingParam != null) {
            intent.putExtra("wink_exporting_param", exportingParam);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("wink_export_mission_id", str);
        }
        intent.putExtra("wink_export_process_id", this.f322795d);
        BaseApplication.getContext().sendBroadcast(intent);
    }

    @SuppressLint({"WrongConstant"})
    private void q() {
        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "bindPeakService");
        QzoneConfig.getInstance();
        if (!QzoneConfig.isBindPeakServiceEnable() || this.f322796e) {
            return;
        }
        if (this.f322797f == null) {
            this.f322797f = new e();
        }
        BaseApplication.getContext().bindService(new Intent(BaseApplication.getContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass()), this.f322797f, 1);
        this.f322796e = true;
    }

    public static d t() {
        if (f322791j == null) {
            synchronized (d.class) {
                if (f322791j == null) {
                    f322791j = new d();
                }
            }
        }
        return f322791j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(WinkExportTask winkExportTask, x73.a aVar) {
        String str;
        WinkExportParams winkExportParams;
        if (winkExportTask != null && !TextUtils.isEmpty(winkExportTask.f322847d) && winkExportTask.f322849f != null && !TextUtils.isEmpty(winkExportTask.f322848e)) {
            if (TextUtils.isEmpty(winkExportTask.f322849f.F)) {
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    winkExportTask.f322849f.F = f16.getTraceId();
                } else {
                    winkExportTask.f322849f.F = QCirclePublishQualityReporter.getTraceId();
                }
                QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "mTraceID new " + winkExportTask.f322849f.F);
                B("E_WINK_EXPORT_M_ADD_TASK", winkExportTask, "noTraceId", "", "0");
            }
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "addTask exportTask = " + winkExportTask.f322847d + "listener" + aVar);
            if (aVar != null) {
                this.f322794c.put(winkExportTask.f322847d, aVar);
                if (this.f322792a.containsKey(winkExportTask.f322847d)) {
                    QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "addTask error same id + = " + winkExportTask.f322847d);
                    WinkExportTask winkExportTask2 = this.f322792a.get(winkExportTask.f322847d);
                    if (winkExportTask2 != null && (winkExportParams = winkExportTask2.f322849f) != null) {
                        if (winkExportParams.equals(winkExportTask.f322849f)) {
                            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "return same id params+ = " + winkExportTask.f322847d);
                            B("E_WINK_EXPORT_M_ADD_TASK", winkExportTask, "sameIdAndParam", "", "0");
                            return;
                        }
                        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "return same id params not same missionId = " + winkExportTask.f322847d);
                        B("E_WINK_EXPORT_M_ADD_TASK", winkExportTask, "notSameParam", "", "0");
                        z(winkExportTask.f322847d);
                    }
                }
                this.f322792a.put(winkExportTask.f322847d, winkExportTask);
                y(winkExportTask);
                return;
            }
            K(winkExportTask);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("addTask error exportTask = ");
        sb5.append(winkExportTask);
        if (winkExportTask != null) {
            str = " " + winkExportTask.f322847d + " " + winkExportTask.f322848e + " " + winkExportTask.f322849f;
        } else {
            str = " exportTask == null ";
        }
        sb5.append(str);
        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, sb5.toString());
        B("E_WINK_EXPORT_M_ADD_TASK", null, "", "", ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_ADD_TASK_ILLEGAL_PARAM + "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.f322792a.containsKey(str)) {
                B("E_WINK_EXPORT_M_CANCEL_TASK", this.f322792a.get(str), "", "", "0");
            } else {
                QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, "cancelTask not in map " + str);
            }
            z(str);
            this.f322792a.remove(str);
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, " cancelTask = " + str + " listener = " + this.f322794c.remove(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(WinkExportTask winkExportTask) {
        B("E_WINK_EXPORT_M_START_TASK", winkExportTask, "", "", "0");
        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "startTask missionId = " + winkExportTask.f322847d);
        com.tencent.mobileqq.wink.editor.export.d s16 = s(winkExportTask);
        if (s16 != null) {
            s16.b(winkExportTask.f322849f, this.f322800i);
            this.f322793b.put(winkExportTask.f322847d, s16);
        } else {
            QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, "startTask null type = " + winkExportTask.f322849f.G);
        }
    }

    private void y(WinkExportTask winkExportTask) {
        WinkPublishHelper2.INSTANCE.bindService(1, new b(winkExportTask));
    }

    private void z(String str) {
        WinkPublishHelper2.INSTANCE.bindService(1, new a(str));
    }

    void E(WinkExportTask winkExportTask) {
        try {
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "runTaskForPeak " + winkExportTask.f322847d);
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass());
            intent.putExtra(AECameraConstants.INTENT_KEY_ACTION, 12);
            intent.putExtra("wink_export_task", winkExportTask);
            BaseApplication.getContext().startService(intent);
            q();
        } catch (Exception e16) {
            QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, e16, new Object[0]);
        }
    }

    public void K(final WinkExportTask winkExportTask) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.export.c
            @Override // java.lang.Runnable
            public final void run() {
                d.this.x(winkExportTask);
            }
        }, 16, null, true);
    }

    public void p(final WinkExportTask winkExportTask, final x73.a aVar) {
        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "addTask start");
        D(new Runnable() { // from class: com.tencent.mobileqq.wink.export.a
            @Override // java.lang.Runnable
            public final void run() {
                d.this.v(winkExportTask, aVar);
            }
        });
    }

    public void r(final String str) {
        D(new Runnable() { // from class: com.tencent.mobileqq.wink.export.b
            @Override // java.lang.Runnable
            public final void run() {
                d.this.w(str);
            }
        });
    }

    com.tencent.mobileqq.wink.editor.export.d s(WinkExportTask winkExportTask) {
        boolean z16;
        int i3 = winkExportTask.f322849f.G;
        if (i3 == 0) {
            try {
                z16 = "QCIRCLE".equals(winkExportTask.f322848e);
            } catch (Exception e16) {
                QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, e16, new Object[0]);
                z16 = false;
            }
            if (z16 && WinkExportUtils.P()) {
                WinkEditDataWrapper d16 = com.tencent.mobileqq.wink.editor.draft.a.d(winkExportTask.f322849f.E);
                if (d16 != null) {
                    ((ITaskSnapshotApi) QRoute.api(ITaskSnapshotApi.class)).saveOriginalMediaInfo(d16.getOriginMediaInfos(), d16.getDuration());
                }
                try {
                    if (WinkExportUtils.N(d16)) {
                        winkExportTask.f322849f.p(com.tencent.mobileqq.wink.editor.draft.c.n(d16).get(0));
                        winkExportTask.f322849f.G = 1;
                        return new ab();
                    }
                } catch (Exception e17) {
                    QLog.e("WinkPublish-Manager-WinkMultiExportManager", 1, e17, new Object[0]);
                }
            }
            return new WinkVideoComposeTask();
        }
        if (i3 == 1) {
            return new ab();
        }
        QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "getExportTask type error " + winkExportTask.f322849f.G);
        return null;
    }

    public boolean u() {
        boolean z16;
        if (this.f322793b.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        w53.b.f("WinkPublish-Manager-WinkMultiExportManager", "hasRunningTask:" + z16);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkExportTask f322803a;

        b(WinkExportTask winkExportTask) {
            this.f322803a = winkExportTask;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NonNull WinkPublishServiceProxy2 winkPublishServiceProxy2) {
            if (winkPublishServiceProxy2.addExportTask(this.f322803a)) {
                QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "postAddToCore = " + this.f322803a.f322847d);
                d.this.B("E_WINK_EXPORT_M_ADD_CORE", this.f322803a, "", "", "0");
                return;
            }
            d.this.B("E_WINK_EXPORT_M_ADD_CORE", this.f322803a, "", "", ExportErrorCode.ERROR_CODE_VIDEO_EXPORT_TO_CORE_ERROR + "");
            QLog.i("WinkPublish-Manager-WinkMultiExportManager", 1, "postAddToCore error exportTask = " + this.f322803a.f322847d);
            if ("1".equals(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_wink_publish_qipc_open", "1"))) {
                QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeParcelable(QQWinkConstants.MMKV_QCIRCLE_EXPORT_TASK, this.f322803a);
                QIPCClientHelper.getInstance().callServer(IQCircleIPCApi.MODULE_NAME, IQCircleIPCApi.ACTION_ADD_EXPORT_TASK, null, new a());
            }
        }

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a implements EIPCResultCallback {
            a() {
            }

            @Override // eipc.EIPCResultCallback
            public void onCallback(EIPCResult eIPCResult) {
            }
        }
    }
}
