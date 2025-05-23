package com.tencent.mobileqq.filemanager.util;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FileDTReporter {

    /* renamed from: a, reason: collision with root package name */
    private static final a f209149a = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f209153a = "pg_bas_file_preview";

        /* renamed from: b, reason: collision with root package name */
        private String f209154b = PageUtils.VR_PAGE_NONE;

        /* renamed from: c, reason: collision with root package name */
        private int f209155c = 0;

        public HashMap<String, Object> a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("qq_pgid", this.f209153a);
            hashMap.put("qq_pgstp", Integer.valueOf(this.f209155c));
            hashMap.put("qq_ref_pgid", this.f209154b);
            return hashMap;
        }

        public void b(a aVar) {
            this.f209153a = aVar.f209153a;
            this.f209154b = aVar.f209154b;
            this.f209155c = aVar.f209155c;
        }

        public a c(int i3) {
            this.f209155c = i3;
            return this;
        }

        public a d(String str) {
            this.f209154b = str;
            return this;
        }
    }

    public static void a(final View view, final a aVar, final HashMap<String, Object> hashMap) {
        if (view.getVisibility() == 0) {
            QLog.d("AIO_Report", 1, "enter " + view.hashCode());
            b(view, aVar, hashMap);
            return;
        }
        QLog.d("AIO_Report", 1, "enter delay " + view.hashCode());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.FileDTReporter.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("AIO_Report", 1, "enterAIO delay report " + view.hashCode());
                FileDTReporter.b(view, aVar, hashMap);
            }
        }, 17L);
    }

    public static void b(Object obj, a aVar, HashMap<String, Object> hashMap) {
        a aVar2 = f209149a;
        aVar2.b(aVar);
        HashMap<String, Object> a16 = aVar2.a();
        a16.putAll(hashMap);
        VideoReport.setPageId(obj, "pg_bas_file_preview");
        VideoReport.setPageReportPolicy(obj, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(obj, new PageParams(a16));
        VideoReport.reportPgIn(obj);
    }

    public static void c(Object obj, HashMap<String, Object> hashMap) {
        HashMap<String, Object> a16 = f209149a.a();
        a16.putAll(hashMap);
        QLog.d("AIO_Report", 1, "exit " + obj.hashCode());
        VideoReport.setPageId(obj, "pg_bas_file_preview");
        VideoReport.setPageReportPolicy(obj, PageReportPolicy.REPORT_NONE);
        VideoReport.setPageParams(obj, new PageParams(a16));
        VideoReport.reportPgOut(obj);
    }
}
