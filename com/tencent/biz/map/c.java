package com.tencent.biz.map;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f78687a;

    /* renamed from: b, reason: collision with root package name */
    private final FrameLayout f78688b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, View> f78689c = new HashMap();

    public c(Context context) {
        this.f78687a = context;
        if (context != null) {
            this.f78688b = new FrameLayout(context);
        } else {
            this.f78688b = new FrameLayout(BaseApplication.getContext());
        }
    }

    public void a(List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            View view = new View(this.f78687a);
            this.f78689c.put(str, view);
            this.f78688b.addView(view);
            VideoReport.setElementId(view, str);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        }
    }

    public void b(String str, Map<String, Object> map) {
        VideoReport.setPageId(this.f78688b, str);
        VideoReport.setPageParams(this.f78688b, new PageParams((Map<String, ?>) map));
    }

    public void c(String str, Map<String, Object> map) {
        View view = this.f78689c.get(str);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", view, map);
    }

    public void d(String str, Map<String, Object> map) {
        View view = this.f78689c.get(str);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_imp", view, map);
    }

    public void e(String str, Map<String, Object> map) {
        View view = this.f78689c.get(str);
        if (view == null) {
            return;
        }
        VideoReport.reportEvent("dt_imp_end", view, map);
    }

    public void f() {
        g(null);
    }

    public void g(Map<String, Object> map) {
        VideoReport.reportEvent("dt_pgin", this.f78688b, map);
    }

    public void h(Map<String, Object> map) {
        VideoReport.reportEvent("dt_pgout", this.f78688b, map);
    }
}
