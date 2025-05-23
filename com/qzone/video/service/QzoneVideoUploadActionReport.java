package com.qzone.video.service;

import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_RSP;
import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.commoncode.module.videorecommend.model.VideoClientReportRequest;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneVideoUploadActionReport implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static QzoneVideoUploadActionReport f60132d;

    public static QzoneVideoUploadActionReport b() {
        if (f60132d == null) {
            synchronized (QzoneVideoUploadActionReport.class) {
                if (f60132d == null) {
                    f60132d = new QzoneVideoUploadActionReport();
                }
            }
        }
        return f60132d;
    }

    private void c(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && qZoneRequest.rsp != null && qZoneTask.succeeded()) {
            CLIENT_REPORT_RSP client_report_rsp = (CLIENT_REPORT_RSP) qZoneTask.mRequest.rsp;
            if (client_report_rsp != null && QZLog.isDevelopLevel()) {
                QZLog.d("QzoneVideoUploadActionReport", 4, "[QZ_Video]return code = " + client_report_rsp.code + ", map = " + client_report_rsp.f24970msg);
                return;
            }
            return;
        }
        QZLog.i("QzoneVideoUploadActionReport", 1, "[QZ_Video]failed to get response from server");
    }

    private void i(final ArrayList<Map<String, String>> arrayList, final Map<String, String> map, final int i3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.video.service.QzoneVideoUploadActionReport.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList2 = new ArrayList();
                REPORT_INFO report_info = new REPORT_INFO(i3, null);
                report_info.info = arrayList;
                arrayList2.add(report_info);
                QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new VideoClientReportRequest(33, (Map<String, String>) map, (ArrayList<REPORT_INFO>) arrayList2), null, QzoneVideoUploadActionReport.this, 10002));
            }
        });
    }

    public void d(String str, String str2, int i3) {
        e(str, str2, i3, "");
    }

    public void e(String str, String str2, int i3, String str3) {
        QZLog.i("QzoneVideoUploadActionReport", 1, "video_upload_report: filePath:" + str + " event:" + str2 + " resultCode:" + i3 + " resultMsg" + str3);
        HashMap hashMap = new HashMap();
        hashMap.put("keyevent", str2);
        hashMap.put("retcode", Integer.toString(i3));
        hashMap.put("retMsg", str3);
        hashMap.put("filepath", str);
        hashMap.put("uin", LoginData.getInstance().getUinString());
        hashMap.put("qua", QUA.getQUA3());
        hashMap.put("clienttime", String.valueOf(System.currentTimeMillis()));
        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        arrayList.add(hashMap);
        i(arrayList, null, 15);
    }

    public void f(String str, int i3, String str2, String str3, String str4) {
        try {
            QZLog.i("QzoneVideoUploadActionReport", 1, "all_upload_report: filePath:null event:" + str + " resultCode:" + i3);
            HashMap hashMap = new HashMap();
            hashMap.put("keyevent", str);
            hashMap.put("retcode", Integer.toString(i3));
            hashMap.put("filepath", "");
            hashMap.put("uin", LoginData.getInstance().getUinString());
            hashMap.put("qua", QUA.getQUA3());
            hashMap.put("svrip", str2);
            hashMap.put(HippyReporter.EXTRA_KEY_REPORT_ERRMSG, str3);
            hashMap.put("reqmsg", str4);
            hashMap.put("clienttime", String.valueOf(System.currentTimeMillis()));
            ArrayList<Map<String, String>> arrayList = new ArrayList<>(1);
            arrayList.add(hashMap);
            i(arrayList, null, 15);
            a(hashMap);
        } catch (Throwable th5) {
            QZLog.i("QzoneVideoUploadActionReport", 1, "reportEventAll error", th5);
        }
    }

    public void g(final String str, final HashMap<String, String> hashMap) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.video.service.QzoneVideoUploadActionReport.2
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, (String) null, true);
            }
        });
    }

    public void h(int i3, int i16, int i17, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("task_type", str);
        hashMap.put("task_total_num", String.valueOf(i3));
        hashMap.put("task_video_num", String.valueOf(i16));
        hashMap.put("task_pic_num", String.valueOf(i17));
        g("task_average_video_num", hashMap);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 10002) {
            return;
        }
        c(qZoneTask);
    }

    private void a(Map<String, String> map) {
        if (map == null || map.entrySet().size() <= 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        hashMap.remove("filepath");
        hashMap.put("deviceinfo", PlatformInfor.g().getDeviceInfor());
        ArrayList<Map<String, String>> arrayList = new ArrayList<>(1);
        arrayList.add(map);
        i(arrayList, null, 38);
    }
}
