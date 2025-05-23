package com.tencent.biz.qqcircle.rerank.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.utils.QCircleHostStubUtil;
import cooperation.qzone.QUA;
import cooperation.qzone.remote.ServiceConst;
import feedcloud.FeedCloudCommon$Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSRankEdgeReportHelper {

    /* renamed from: a, reason: collision with root package name */
    private static String f91875a;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f91877a;

        /* renamed from: b, reason: collision with root package name */
        private String f91878b;

        /* renamed from: c, reason: collision with root package name */
        private String f91879c;

        /* renamed from: d, reason: collision with root package name */
        private String f91880d = "";

        /* renamed from: e, reason: collision with root package name */
        private String f91881e = "";

        /* renamed from: f, reason: collision with root package name */
        private long f91882f;

        /* renamed from: g, reason: collision with root package name */
        private long f91883g;

        /* renamed from: h, reason: collision with root package name */
        private String f91884h;

        /* renamed from: i, reason: collision with root package name */
        private String f91885i;

        /* renamed from: j, reason: collision with root package name */
        private String f91886j;

        /* renamed from: k, reason: collision with root package name */
        private long f91887k;

        public a l(String str) {
            this.f91880d = str;
            return this;
        }

        public a m(String str) {
            this.f91884h = str;
            return this;
        }

        public a n(String str) {
            this.f91885i = str;
            return this;
        }

        public a o(long j3) {
            this.f91883g = j3;
            return this;
        }

        public a p(long j3) {
            this.f91887k = j3;
            return this;
        }

        public a q(String str) {
            this.f91878b = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(List<FeedCloudCommon$Entry> list) {
        if (list != null && !list.isEmpty()) {
            list.addAll(f());
            QCircleReporter.getInstance().addReRankReportData(QCircleReportHelper.newSingleDcData(d(), list, null, QCircleReportHelper.getInstance().newSessionEntries()));
        }
    }

    static void c(final a aVar) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.rerank.util.QFSRankEdgeReportHelper.1
            @Override // java.lang.Runnable
            public void run() {
                QFSRankEdgeReportHelper.b(new ArrayList(Arrays.asList(QCircleReportHelper.newEntry(ServiceConst.PARA_SESSION_ID, a.this.f91877a), QCircleReportHelper.newEntry("rerank_trace_id", a.this.f91878b), QCircleReportHelper.newEntry("items", a.this.f91879c), QCircleReportHelper.newEntry(DownloadInfo.spKey_Config, a.this.f91880d), QCircleReportHelper.newEntry("rank_info", a.this.f91881e), QCircleReportHelper.newEntry("ret_code", String.valueOf(a.this.f91883g)), QCircleReportHelper.newEntry(CheckForwardServlet.KEY_ERR_CODE, String.valueOf(a.this.f91882f)), QCircleReportHelper.newEntry("err_msg", a.this.f91884h), QCircleReportHelper.newEntry("time_cost", String.valueOf(((float) a.this.f91887k) / 1000.0f)), QCircleReportHelper.newEntry("event_id", a.this.f91885i), QCircleReportHelper.newEntry("edge_recom_trace", a.this.f91886j))));
            }
        });
    }

    private static int d() {
        return DigestErrCode.UN_SUPPORT_TYPE;
    }

    private static String e() {
        if (TextUtils.isEmpty(f91875a)) {
            f91875a = "mem=" + ((QCircleDeviceInfoUtils.getSystemTotalMemory() / 1024) / 1024) + "&core=" + QCircleDeviceInfoUtils.getNumberOfCores();
        }
        return f91875a;
    }

    private static Collection<FeedCloudCommon$Entry> f() {
        return new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("uin", QCircleHostStubUtil.getCurrentAccount()), QCircleReportHelper.newEntry("timestamps", String.valueOf(System.currentTimeMillis())), QCircleReportHelper.newEntry("qua", QUA.getQUA3()), QCircleReportHelper.newEntry("platform", "android"), QCircleReportHelper.newEntry("os_version", Build.VERSION.RELEASE), QCircleReportHelper.newEntry("mobile_type", DeviceInfoMonitor.getModel()), QCircleReportHelper.newEntry("device_info", Build.DEVICE), QCircleReportHelper.newEntry("device_param", e())));
    }

    public static void g(a aVar) {
        if (aVar == null) {
            QLog.e("QFSRankEdgeReportHelper", 1, "DataBuilder == null");
        } else {
            c(aVar);
        }
    }

    public static void h(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        b(QCircleReportHelper.convertEntryListFromObjMap(new HashMap(map)));
    }
}
