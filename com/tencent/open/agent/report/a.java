package com.tencent.open.agent.report;

import android.view.View;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.open.agent.report.b;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/open/agent/report/a;", "Lcom/tencent/open/agent/report/b;", "Lcom/tencent/open/agent/report/b$a;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "c", "Landroid/view/View;", "view", "i", "d", "g", "b", "a", "e", h.F, "", "positive", "f", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/open/agent/report/a$a;", "", "", "pageId", "elementId", "Lcom/tencent/open/agent/report/b$a;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "", "b", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.open.agent.report.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes22.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, String> b(String pageId, String elementId, b.a reportParams) {
            Map<String, String> f16;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("qq_eid", elementId);
            linkedHashMap.put("qq_pgid", pageId);
            if (reportParams != null && (f16 = reportParams.f()) != null) {
                linkedHashMap.putAll(f16);
            }
            return linkedHashMap;
        }

        Companion() {
        }
    }

    @Override // com.tencent.open.agent.report.b
    public void a(@Nullable b.a reportParams) {
        VideoReport.reportEvent("qq_clck", INSTANCE.b("pg_bas_send_confirmation", "em_bas_send", reportParams));
    }

    @Override // com.tencent.open.agent.report.b
    public void b(@Nullable View view, @Nullable b.a reportParams) {
        Map<String, String> f16;
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, "pg_bas_send_confirmation");
        if (reportParams != null && (f16 = reportParams.f()) != null) {
            for (Map.Entry<String, String> entry : f16.entrySet()) {
                VideoReport.setPageParams(view, entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.tencent.open.agent.report.b
    public void c(@Nullable b.a reportParams) {
        Map<String, String> linkedHashMap;
        if (reportParams == null || (linkedHashMap = reportParams.f()) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        VideoReport.reportEvent("ev_bas_third_app_sharing_qq_clck", linkedHashMap);
    }

    @Override // com.tencent.open.agent.report.b
    public void d(@Nullable b.a reportParams) {
        VideoReport.reportEvent("qq_clck", INSTANCE.b("pg_bas_share_object_selection", "em_bas_close", reportParams));
    }

    @Override // com.tencent.open.agent.report.b
    public void e(@Nullable b.a reportParams) {
        VideoReport.reportEvent("qq_clck", INSTANCE.b("pg_bas_send_confirmation", "em_bas_cancel", reportParams));
    }

    @Override // com.tencent.open.agent.report.b
    public void f(boolean positive, @Nullable b.a reportParams) {
        String str;
        Companion companion = INSTANCE;
        if (positive) {
            str = "em_bas_stay_qq";
        } else {
            str = "em_bas_return_app";
        }
        VideoReport.reportEvent("qq_clck", companion.b("pg_bas_return_app_popup", str, reportParams));
    }

    @Override // com.tencent.open.agent.report.b
    public void g(@Nullable b.a reportParams) {
        if (reportParams == null) {
            return;
        }
        int i3 = 0;
        for (b.ShareTarget shareTarget : reportParams.d()) {
            Map b16 = INSTANCE.b("pg_bas_send_confirmation", "em_bas_sharing_group", reportParams);
            b16.put("position", String.valueOf(i3));
            b16.put("target_uin", shareTarget.getUin());
            b16.put("target_type", String.valueOf(shareTarget.getType()));
            VideoReport.reportEvent("qq_clck", b16);
            i3++;
        }
    }

    @Override // com.tencent.open.agent.report.b
    public void h(@Nullable View view, @Nullable b.a reportParams) {
        Map<String, String> f16;
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, "pg_bas_return_app_popup");
        if (reportParams != null && (f16 = reportParams.f()) != null) {
            for (Map.Entry<String, String> entry : f16.entrySet()) {
                VideoReport.setPageParams(view, entry.getKey(), entry.getValue());
            }
        }
    }

    @Override // com.tencent.open.agent.report.b
    public void i(@Nullable View view, @Nullable b.a reportParams) {
        Map<String, String> f16;
        if (view == null) {
            return;
        }
        VideoReport.setPageId(view, "pg_bas_share_object_selection");
        if (reportParams != null && (f16 = reportParams.f()) != null) {
            for (Map.Entry<String, String> entry : f16.entrySet()) {
                VideoReport.setPageParams(view, entry.getKey(), entry.getValue());
            }
        }
    }
}
