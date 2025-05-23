package com.tencent.mobileqq.search.searchdetail.content.view;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.search.searchdetail.content.base.BaseSearchTemplateSection;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernel.nativeinterface.SearchReportInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a0\u0010\t\u001a\u00020\b*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u001a6\u0010\u000b\u001a\u00020\b*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u001a \u0010\u000f\u001a\u00020\u0005*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u001a \u0010\u0011\u001a\u00020\u0005*\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\u0012"}, d2 = {"Landroid/view/View;", "", "elementId", "", "needAsync", "Lorg/json/JSONObject;", "elementParams", IECDtReport.ACTION_IDENTIFIER, "", "g", "Lkotlin/Function0;", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchReportInfo;", "params", QQBrowserActivity.APP_PARAM, "d", "Lcom/tencent/mobileqq/search/searchdetail/content/model/g;", "c", "qqsearch-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class i {
    @NotNull
    public static final JSONObject c(@NotNull com.tencent.mobileqq.search.searchdetail.content.model.g gVar, @NotNull JSONObject params, @Nullable JSONObject jSONObject) {
        String str;
        boolean z16;
        Iterator keys;
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        SearchReportInfo searchReportInfo = gVar.getCom.tencent.tmdownloader.internal.storage.table.CacheTable.TABLE_NAME java.lang.String();
        if (searchReportInfo != null) {
            str = searchReportInfo.getReportInfo();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return params;
        }
        String curTransferInfo = params.optString("transfer_info");
        BaseSearchTemplateSection.Companion companion = BaseSearchTemplateSection.INSTANCE;
        JSONObject jsonReportInfo = gVar.getJsonReportInfo();
        Intrinsics.checkNotNullExpressionValue(curTransferInfo, "curTransferInfo");
        JSONObject d16 = companion.d(jsonReportInfo, curTransferInfo);
        if (d16 != null) {
            if (jSONObject != null && (keys = jSONObject.keys()) != null) {
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    Object opt = jSONObject.opt(str2);
                    if (opt != null) {
                        Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                        d16.put(str2, opt);
                    }
                }
            }
            params.put("transfer_info", d16);
            BaseSearchTemplateSection.INSTANCE.b(params, d16);
        }
        return params;
    }

    @NotNull
    public static final JSONObject d(@NotNull SearchReportInfo searchReportInfo, @NotNull JSONObject params, @Nullable JSONObject jSONObject) {
        boolean z16;
        Iterator keys;
        Intrinsics.checkNotNullParameter(searchReportInfo, "<this>");
        Intrinsics.checkNotNullParameter(params, "params");
        String transferInfo = searchReportInfo.reportInfo;
        Intrinsics.checkNotNullExpressionValue(transferInfo, "transferInfo");
        if (transferInfo.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return params;
        }
        JSONObject c16 = BaseSearchTemplateSection.INSTANCE.c(transferInfo, params);
        if (c16 != null) {
            if (jSONObject != null && (keys = jSONObject.keys()) != null) {
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    Object opt = jSONObject.opt(str);
                    if (opt != null) {
                        Intrinsics.checkNotNullExpressionValue(opt, "opt(key)");
                        c16.put(str, opt);
                    }
                }
            }
            params.put("transfer_info", c16);
            BaseSearchTemplateSection.INSTANCE.b(params, c16);
        }
        return params;
    }

    public static /* synthetic */ JSONObject e(com.tencent.mobileqq.search.searchdetail.content.model.g gVar, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jSONObject = new JSONObject();
        }
        if ((i3 & 2) != 0) {
            jSONObject2 = null;
        }
        return c(gVar, jSONObject, jSONObject2);
    }

    public static /* synthetic */ JSONObject f(SearchReportInfo searchReportInfo, JSONObject jSONObject, JSONObject jSONObject2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            jSONObject = new JSONObject();
        }
        if ((i3 & 2) != 0) {
            jSONObject2 = null;
        }
        return d(searchReportInfo, jSONObject, jSONObject2);
    }

    public static final void g(@NotNull final View view, @Nullable final String str, boolean z16, @Nullable final JSONObject jSONObject, @Nullable final String str2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.h
            @Override // java.lang.Runnable
            public final void run() {
                i.h(str, jSONObject, str2, view);
            }
        };
        if (z16) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static final void h(String str, JSONObject jSONObject, String str2, View this_viewReport) {
        Intrinsics.checkNotNullParameter(this_viewReport, "$this_viewReport");
        if (str != null) {
            VideoReport.setElementId(this_viewReport, str);
        }
        if (jSONObject != null) {
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "it.keys()");
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                VideoReport.setElementParam(this_viewReport, str3, jSONObject.get(str3));
            }
        }
        if (str2 != null) {
            VideoReport.setElementReuseIdentifier(this_viewReport, str2);
        }
        VideoReport.setElementExposePolicy(this_viewReport, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this_viewReport, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this_viewReport, ClickPolicy.REPORT_ALL);
    }

    public static final void i(@NotNull final View view, @Nullable final String str, boolean z16, @Nullable final Function0<? extends JSONObject> function0, @Nullable final String str2) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.view.g
            @Override // java.lang.Runnable
            public final void run() {
                i.j(str, function0, str2, view);
            }
        };
        if (z16) {
            view.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static final void j(String str, Function0 function0, String str2, View this_vr) {
        Intrinsics.checkNotNullParameter(this_vr, "$this_vr");
        if (str != null) {
            VideoReport.setElementId(this_vr, str);
        }
        if (function0 != null) {
            JSONObject jSONObject = (JSONObject) function0.invoke();
            Iterator keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "jsonObj.keys()");
            while (keys.hasNext()) {
                String str3 = (String) keys.next();
                VideoReport.setElementParam(this_vr, str3, jSONObject.get(str3));
            }
        }
        if (str2 != null) {
            VideoReport.setElementReuseIdentifier(this_vr, str2);
        }
        VideoReport.setElementExposePolicy(this_vr, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(this_vr, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this_vr, ClickPolicy.REPORT_ALL);
    }
}
