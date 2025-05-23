package com.tencent.mobileqq.search.searchdetail.util;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ8\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bJ\u001e\u0010\r\u001a\u00020\n*\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/f;", "", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", CacheTable.TABLE_NAME, "", IECDtReport.ACTION_IDENTIFIER, "", "extraParam", "", "a", "outMap", "c", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f284742a = new f();

    f() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(f fVar, View view, SearchReportInfo searchReportInfo, String str, Map map, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            map = null;
        }
        fVar.a(view, searchReportInfo, str, map);
    }

    public final void a(@NotNull View view, @Nullable SearchReportInfo reportInfo, @NotNull String identifier, @Nullable Map<String, String> extraParam) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (reportInfo == null) {
            return;
        }
        if (extraParam == null) {
            extraParam = new HashMap<>();
        }
        c(reportInfo, extraParam);
        VideoReport.setElementId(view, reportInfo.eid);
        VideoReport.setElementReuseIdentifier(view, identifier + "_" + view.hashCode());
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, extraParam);
    }

    public final void c(@NotNull SearchReportInfo searchReportInfo, @NotNull Map<String, String> outMap) {
        Intrinsics.checkNotNullParameter(searchReportInfo, "<this>");
        Intrinsics.checkNotNullParameter(outMap, "outMap");
        try {
            String str = searchReportInfo.reportInfo;
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                Intrinsics.checkNotNullExpressionValue(keys, "reportInfoJson.keys()");
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    String optString = jSONObject.optString(key, "");
                    Intrinsics.checkNotNullExpressionValue(optString, "reportInfoJson.optString(key, \"\")");
                    outMap.put(key, optString);
                }
            }
        } catch (Exception e16) {
            QLog.d("QQSearch.NetDetail.NetSearchReportBindUtil", 4, "reportPramsToMap:" + e16);
        }
    }
}
