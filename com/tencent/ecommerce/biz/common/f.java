package com.tencent.ecommerce.biz.common;

import android.text.TextUtils;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J.\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0010\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/common/f;", "", "", "busId", "eventCode", "", "d", "inputQuery", "", "inputContentType", "requestWay", "e", "a", "queryList", "c", "", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f101556a = new f();

    f() {
    }

    public final int a(String inputQuery) {
        boolean startsWith$default;
        if (TextUtils.isEmpty(inputQuery)) {
            return 0;
        }
        if (inputQuery != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(inputQuery, "http", false, 2, null);
            if (startsWith$default) {
                return 2;
            }
        }
        return 1;
    }

    public final String b(List<String> queryList) {
        if (queryList == null) {
            return "";
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<String> it = queryList.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put(it.next());
            }
            return jSONArray.toString();
        } catch (JSONException e16) {
            cg0.a.a("ECSearchReportUtil", "[getQueryList]", e16.toString());
            return "";
        }
    }

    public final void c(String busId, String queryList, String eventCode) {
        Map<Object, Object> f16 = e.e(new e().a(busId), null, 1, null).b("query_list", queryList).f();
        cg0.a.b("ECSearchReportUtil", "[reportHistorySearchExposure] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void d(String busId, String eventCode) {
        Map<Object, Object> f16 = e.e(new e().a(busId), null, 1, null).f();
        cg0.a.b("ECSearchReportUtil", "[reportSearchBarClick] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }

    public final void e(String busId, String inputQuery, int inputContentType, int requestWay, String eventCode) {
        Map<Object, Object> f16 = e.e(new e().a(busId), null, 1, null).b("input_query", inputQuery).b("input_content_type", String.valueOf(inputContentType)).b("request_way", String.valueOf(requestWay)).f();
        cg0.a.b("ECSearchReportUtil", "[reportSearchRequest] eventCode = " + eventCode + ", params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, eventCode, f16, false, 4, null);
    }
}
