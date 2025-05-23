package id3;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u00a2\u0006\u0004\b%\u0010&J(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J*\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0002J4\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J,\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J^\u0010\u0019\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0013JL\u0010\u001b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00132\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0003J\u0016\u0010 \u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u001eR\u0017\u0010$\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lid3/d;", "", "", "", "businessParams", "a", "eventID", "", "d", "obj", "c", "target", "view", ISchemeApi.KEY_PAGE_ID, "j", "targetView", "k", "Landroid/view/View;", "elementID", "", "autoReportClick", "autoReportExpose", IECDtReport.ACTION_IDENTIFIER, "isAsync", "fullExposure", "g", "onlyClick", "f", "id", "e", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "params", "b", "Ljava/lang/String;", "getAppKey", "()Ljava/lang/String;", com.heytap.mcssdk.a.a.f36102l, "<init>", "(Ljava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class d {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    private final String com.heytap.mcssdk.a.a.l java.lang.String;

    public d() {
        this(null, 1, null);
    }

    private final Map<String, Object> a(Map<String, Object> businessParams) {
        businessParams.put(DTParamKey.REPORT_KEY_APPKEY, this.com.heytap.mcssdk.a.a.l java.lang.String);
        return businessParams;
    }

    public static /* synthetic */ void h(d dVar, View view, String str, Map map, boolean z16, boolean z17, String str2, int i3, Object obj) {
        boolean z18;
        boolean z19;
        if ((i3 & 4) != 0) {
            map = new LinkedHashMap();
        }
        Map map2 = map;
        if ((i3 & 8) != 0) {
            z18 = false;
        } else {
            z18 = z16;
        }
        if ((i3 & 16) != 0) {
            z19 = false;
        } else {
            z19 = z17;
        }
        if ((i3 & 32) != 0) {
            str2 = null;
        }
        dVar.f(view, str, map2, z18, z19, str2);
    }

    public static /* synthetic */ void i(d dVar, View view, String str, Map map, boolean z16, boolean z17, String str2, boolean z18, boolean z19, int i3, Object obj) {
        boolean z26;
        boolean z27;
        String str3;
        boolean z28;
        boolean z29;
        if ((i3 & 8) != 0) {
            z26 = true;
        } else {
            z26 = z16;
        }
        if ((i3 & 16) != 0) {
            z27 = true;
        } else {
            z27 = z17;
        }
        if ((i3 & 32) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i3 & 64) != 0) {
            z28 = false;
        } else {
            z28 = z18;
        }
        if ((i3 & 128) != 0) {
            z29 = false;
        } else {
            z29 = z19;
        }
        dVar.g(view, str, map, z26, z27, str3, z28, z29);
    }

    public final synchronized void b(@NotNull Object target, @NotNull IDynamicParams params) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(params, "params");
        VideoReport.setEventDynamicParams(target, params);
    }

    public final synchronized void c(@NotNull String eventID, @NotNull Object obj, @NotNull Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        QLog.i("ZootopiaDtReportHelper", 4, "reportEvent eventID:" + eventID + ", obj:" + obj + ", businessParams:" + businessParams);
        try {
            a(businessParams);
            VideoReport.reportEvent(eventID, obj, businessParams);
        } catch (Exception e16) {
            QLog.e("ZootopiaDtReportHelper", 1, "reportEvent throw e: " + e16.getMessage());
        }
    }

    public final synchronized void d(@NotNull String eventID, @NotNull Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        QLog.i("ZootopiaDtReportHelper", 4, "reportEvent eventID:" + eventID + ", businessParams:" + businessParams);
        try {
            a(businessParams);
            VideoReport.reportEvent(eventID, businessParams);
        } catch (Exception e16) {
            QLog.e("ZootopiaDtReportHelper", 1, "reportEvent throw e: " + e16.getMessage());
        }
    }

    public final synchronized void e(@NotNull Object target, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(id5, "id");
        VideoReport.setElementId(target, id5);
    }

    public final synchronized void f(@NotNull View view, @NotNull String elementID, @NotNull Map<String, Object> businessParams, boolean onlyClick, boolean isAsync, @Nullable String r75) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        a(businessParams);
        VideoReport.setElementId(view, elementID);
        if (onlyClick) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        } else {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementParams(view, businessParams);
        if (r75 != null) {
            VideoReport.setElementReuseIdentifier(view, r75);
        }
        if (isAsync) {
            VideoReport.traverseExposure();
        }
    }

    public final synchronized void g(@NotNull View view, @NotNull String elementID, @NotNull Map<String, Object> businessParams, boolean autoReportClick, boolean autoReportExpose, @Nullable String r75, boolean isAsync, boolean fullExposure) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        a(businessParams);
        VideoReport.setElementId(view, elementID);
        if (autoReportExpose) {
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        }
        if (autoReportClick) {
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        } else {
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        }
        VideoReport.setElementParams(view, businessParams);
        if (r75 != null) {
            VideoReport.setElementReuseIdentifier(view, r75);
        }
        if (isAsync) {
            VideoReport.traverseExposure();
        }
        if (fullExposure) {
            VideoReport.setElementExposureMinRate(view, 1.0d);
        }
    }

    public final synchronized void j(@NotNull Object target, @NotNull Object view, @NotNull String r46, @Nullable Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(r46, "pageID");
        if ((target instanceof Activity) || (target instanceof Fragment) || (target instanceof View) || (target instanceof Dialog)) {
            if (target instanceof Fragment) {
                VideoReport.addToDetectionWhitelist(((Fragment) target).getActivity());
            }
            if (target instanceof Activity) {
                VideoReport.addToDetectionWhitelist((Activity) target);
            }
        }
        k(view, r46, businessParams);
    }

    public final synchronized void k(@NotNull Object targetView, @NotNull String r36, @Nullable Map<String, Object> businessParams) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Intrinsics.checkNotNullParameter(r36, "pageID");
        if (!(targetView instanceof Activity) && !(targetView instanceof Fragment) && !(targetView instanceof View) && !(targetView instanceof Dialog)) {
            QLog.e("ZootopiaDtReportHelper", 1, "setPageInfo targetView \u4e0d\u662fActivity Fragment\u6216\u8005View");
        }
        if (targetView instanceof Fragment) {
            VideoReport.addToDetectionWhitelist(((Fragment) targetView).getActivity());
        }
        if (targetView instanceof Activity) {
            VideoReport.addToDetectionWhitelist((Activity) targetView);
        }
        if (businessParams == null) {
            businessParams = new LinkedHashMap<>();
        }
        PageParams pageParams = new PageParams((Map<String, ?>) a(businessParams));
        VideoReport.setPageId(targetView, r36);
        VideoReport.setPageParams(targetView, pageParams);
    }

    public d(@NotNull String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        this.com.heytap.mcssdk.a.a.l java.lang.String = appKey;
    }

    public /* synthetic */ d(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? SquareReportConst.APP_KEY : str);
    }
}
