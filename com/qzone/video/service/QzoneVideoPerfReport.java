package com.qzone.video.service;

import NS_MOBILE_CLIENT_UPDATE.CLIENT_REPORT_RSP;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.commoncode.module.videorecommend.model.VideoClientReportRequest;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import s4.c;

/* loaded from: classes37.dex */
public class QzoneVideoPerfReport implements IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name */
    private static QzoneVideoPerfReport f60097e;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, Map<Integer, Long>> f60098d = new HashMap();

    QzoneVideoPerfReport() {
    }

    public static QzoneVideoPerfReport a(String str, int i3) {
        if (f60097e == null) {
            f60097e = new QzoneVideoPerfReport();
        }
        f60097e.g(str, i3);
        return f60097e;
    }

    private void b(QZoneTask qZoneTask) {
        QZoneRequest qZoneRequest;
        if (qZoneTask != null && (qZoneRequest = qZoneTask.mRequest) != null && qZoneRequest.rsp != null && qZoneTask.succeeded()) {
            CLIENT_REPORT_RSP client_report_rsp = (CLIENT_REPORT_RSP) qZoneTask.mRequest.rsp;
            if (client_report_rsp != null && QZLog.isDevelopLevel()) {
                QZLog.d("QzoneVideoPerfReport", 4, "[QZ_Video]return code = " + client_report_rsp.code + ", map = " + client_report_rsp.f24970msg);
                return;
            }
            return;
        }
        QZLog.i("QzoneVideoPerfReport", 1, "[QZ_Video]failed to get response from server");
    }

    private void g(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Map<Integer, Long> map = this.f60098d.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.f60098d.put(str, map);
        }
        map.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis));
    }

    public void c(long j3, String str, Map<String, String> map) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.putAll(map);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(j3 + "", str, true, 0L, 0L, hashMap, null);
        if (QLog.isColorLevel()) {
            QLog.d("QzoneVideoPerfReport", 2, "event:" + str);
        }
    }

    public void f(final ArrayList<Map<String, String>> arrayList, final Map<String, String> map) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.video.service.QzoneVideoPerfReport.1
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("QzoneVideoPerfReport", 2, "[Dc01340:]" + arrayList);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("host_uin", LoginData.getInstance().getUinString());
                hashMap.put("qua", QUA.getQUA3());
                hashMap.put("network_type", String.valueOf(NetworkState.getNetworkType()));
                hashMap.put("client_time", String.valueOf(System.currentTimeMillis()));
                arrayList.add(hashMap);
                QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new VideoClientReportRequest(34, (ArrayList<Map<String, String>>) arrayList, (Map<String, String>) map), null, QzoneVideoPerfReport.this, 10001));
            }
        });
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 10001) {
            return;
        }
        b(qZoneTask);
    }

    public void d(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("QzoneVideoPerfReport", 2, "perfReport id:" + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Map<Integer, Long> map = this.f60098d.get(str);
        HashMap hashMap = new HashMap();
        if (map != null) {
            int i3 = 5;
            while (i3 >= 1) {
                if (map.keySet().contains(Integer.valueOf(i3))) {
                    int i16 = i3 - 1;
                    while (!map.keySet().contains(Integer.valueOf(i16)) && i16 >= 0) {
                        i16--;
                    }
                    if (i16 < 0) {
                        return;
                    }
                    long longValue = map.get(Integer.valueOf(i3)).longValue() - map.get(Integer.valueOf(i16)).longValue();
                    QLog.d("QzoneVideoPerfReport", 2, "T" + i3 + ContainerUtils.KEY_VALUE_DELIMITER + longValue);
                    if (i3 == 1) {
                        e(str2, "event_in_queue", longValue, 0);
                        hashMap.put("queue_time", longValue + "");
                    } else if (i3 == 2) {
                        e(str2, "event_video_process", longValue, 0);
                        hashMap.put("video_process_time", longValue + "");
                    } else if (i3 == 3) {
                        e(str2, "event_process_callback", longValue, 0);
                        hashMap.put("video_callback_time", longValue + "");
                    } else if (i3 == 4) {
                        e(str2, "event_upload", longValue, 0);
                        hashMap.put(c.UPLOAD_TIME, longValue + "");
                    } else if (i3 == 5) {
                        e(str2, "event_video_transcode", longValue, 0);
                        hashMap.put("transcode_time", longValue + "");
                    }
                    i3 = i16;
                } else {
                    i3--;
                }
            }
            ArrayList<Map<String, String>> arrayList = new ArrayList<>();
            arrayList.add(hashMap);
            f(arrayList, null);
        }
    }

    public void e(String str, String str2, long j3, int i3) {
        boolean z16 = i3 == 0;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", i3 + "");
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, z16, j3, 0L, hashMap, null);
    }
}
