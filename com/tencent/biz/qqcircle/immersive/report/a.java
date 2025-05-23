package com.tencent.biz.qqcircle.immersive.report;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<String, C0906a> f89697a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.report.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0906a {

        /* renamed from: a, reason: collision with root package name */
        private String f89698a;

        /* renamed from: b, reason: collision with root package name */
        private long f89699b;

        /* renamed from: c, reason: collision with root package name */
        private long f89700c;

        /* renamed from: d, reason: collision with root package name */
        private long f89701d;

        /* renamed from: e, reason: collision with root package name */
        private String f89702e;

        /* renamed from: f, reason: collision with root package name */
        private String f89703f;

        C0906a() {
        }

        public static C0906a e(String str) {
            C0906a c0906a = new C0906a();
            c0906a.f89698a = str;
            c0906a.f89699b = System.currentTimeMillis();
            return c0906a;
        }

        public void f() {
            this.f89700c = System.currentTimeMillis() - this.f89699b;
        }

        public void g() {
            this.f89701d = System.currentTimeMillis() - this.f89699b;
        }

        public void h(String str) {
            this.f89703f = str;
        }

        public void i(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f89702e = str;
        }
    }

    public static void a(String str, String str2, String str3) {
        C0906a c0906a;
        HashMap<String, C0906a> hashMap = f89697a;
        if (!hashMap.containsKey(str) || (c0906a = hashMap.get(str)) == null || c0906a.f89700c > 0) {
            return;
        }
        c0906a.f();
        if (c0906a.f89700c >= 0 && c0906a.f89700c <= 600000) {
            c0906a.i(str2);
            c0906a.h(str3);
            ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportLog("page_appear_event", new QCircleAlphaUserReportDataBuilder().setType(str).setRefer(str2).setExt1(str3).setExt2("3").setTimeCost(c0906a.f89700c));
            QLog.d("QFSCoreIndicatorReporter", 1, "recordAppearAction,type:", str, ",pageId:", str2, ",appear time cost:", Long.valueOf(c0906a.f89700c));
            return;
        }
        QLog.d("QFSCoreIndicatorReporter", 1, "recordAppearAction appearTimeCost invalid,return. type:", str, ",pageId:", str2, ",appear time cost:", Long.valueOf(c0906a.f89700c));
        hashMap.remove(str);
    }

    public static void b(String str, String str2, String str3) {
        C0906a c0906a;
        HashMap<String, C0906a> hashMap = f89697a;
        if (hashMap.containsKey(str) && (c0906a = hashMap.get(str)) != null) {
            if (c0906a.f89701d >= 0 && c0906a.f89701d <= 600000) {
                c0906a.g();
                ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).reportLog("fetch_data_event", new QCircleAlphaUserReportDataBuilder().setType(str).setCmd(str2).setRefer(c0906a.f89702e).setInfo(str3).setExt1(c0906a.f89703f).setExt2("3").setTimeCost(c0906a.f89701d));
                QLog.d("QFSCoreIndicatorReporter", 1, "recordFetchDataAction,type:", str, ",cmd:", str2, ",traceId:", str3, ",fetch data time cost:", Long.valueOf(c0906a.f89701d));
                hashMap.remove(str);
                return;
            }
            QLog.d("QFSCoreIndicatorReporter", 1, "recordFetchDataAction fetchDataTimeCost invalid,return. type:", str, ",cmd:", str2, ",traceId:", str3, ",fetch data time cost:", Long.valueOf(c0906a.f89701d));
            hashMap.remove(str);
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f89697a.put(str, C0906a.e(str));
        QLog.d("QFSCoreIndicatorReporter", 1, "recordLaunchAction,type:", str);
    }
}
