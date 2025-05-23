package com.tencent.mobileqq.wink.report;

import android.app.Activity;
import android.view.View;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.event.open.BeaconInitException;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.xweb.FileReaderHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%JB\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0002J6\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ8\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003J8\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003J8\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003J8\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003J8\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003J8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003JR\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006JR\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00032\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0002\b\u0003\u0018\u00010\u0006J\u0006\u0010\u001d\u001a\u00020\tJ\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001J,\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00032\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\"\u001a\u00020!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/report/e;", "", DTConstants.TAG.ELEMENT, "", "elementID", "type", "", "params", "reuseIdentifier", "", "b", "Landroid/view/View;", "contentView", "pageId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "i", "w", "j", ReportConstant.COSTREPORT_PREFIX, "l", "e", "g", "c", "eventID", "elementParams", "eventParams", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "y", HippyTKDListViewAdapter.X, "action", "map", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, DomainData.DOMAIN_NAME, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {

    /* renamed from: a */
    @NotNull
    public static final e f326265a = new e();

    static {
        try {
            UserAction.initUserAction(com.tencent.mobileqq.wink.b.c());
        } catch (Exception e16) {
            if (!(e16 instanceof BeaconInitException)) {
                QLog.e("WinkReport", 1, "[initUserAction] error, ", e16);
            }
        }
    }

    e() {
    }

    private final void b(Object r16, String elementID, String type, Map<String, ?> params, String reuseIdentifier) {
        x(r16);
        VideoReport.setElementId(r16, elementID);
        if (params != null) {
            VideoReport.setElementParams(r16, params);
        }
        if (reuseIdentifier != null) {
            VideoReport.setElementReuseIdentifier(r16, reuseIdentifier);
        }
        switch (type.hashCode()) {
            case -981080085:
                if (type.equals("EXPOSURE_POLICY_REPORT_ALL")) {
                    VideoReport.setElementExposePolicy(r16, ExposurePolicy.REPORT_ALL);
                    return;
                }
                return;
            case -956107281:
                if (type.equals("END_EXPOSURE_POLICY_REPORT_ALL")) {
                    VideoReport.setElementEndExposePolicy(r16, EndExposurePolicy.REPORT_ALL);
                    return;
                }
                return;
            case -15661300:
                if (type.equals("CLICK_REPORT_NONE")) {
                    VideoReport.setElementClickPolicy(r16, ClickPolicy.REPORT_NONE);
                    return;
                }
                return;
            case 79515283:
                if (type.equals("EXPOSURE_POLICY_REPORT_ONLY_FIRST")) {
                    VideoReport.setElementExposePolicy(r16, ExposurePolicy.REPORT_FIRST);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(e eVar, Object obj, String str, Map map, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        eVar.c(obj, str, map, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(e eVar, Object obj, String str, Map map, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        eVar.e(obj, str, map, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(e eVar, Object obj, String str, Map map, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        eVar.g(obj, str, map, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(e eVar, Object obj, String str, Map map, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        eVar.j(obj, str, map, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(e eVar, Object obj, String str, Map map, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        eVar.l(obj, str, map, str2);
    }

    public static /* synthetic */ void o(e eVar, String str, Map map, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        eVar.n(str, map, z16);
    }

    public static final void p(String action, Map map, boolean z16) {
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(map, "$map");
        String appKey = UserAction.getAppKey();
        UserAction.setAppKey("0AND0PWXC34GZX1C");
        UserAction.onUserAction(action, true, -1L, -1L, map, true, false);
        UserAction.setAppKey(appKey);
    }

    public static /* synthetic */ void r(e eVar, String str, Object obj, String str2, Map map, Map map2, int i3, Object obj2) {
        Object obj3;
        String str3;
        Map map3;
        Map map4;
        if ((i3 & 2) != 0) {
            obj3 = null;
        } else {
            obj3 = obj;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i3 & 8) != 0) {
            map3 = null;
        } else {
            map3 = map;
        }
        if ((i3 & 16) != 0) {
            map4 = null;
        } else {
            map4 = map2;
        }
        eVar.q(str, obj3, str3, map3, map4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void t(e eVar, Object obj, String str, Map map, String str2, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        eVar.s(obj, str, map, str2);
    }

    public static /* synthetic */ void v(e eVar, String str, Object obj, String str2, Map map, Map map2, int i3, Object obj2) {
        Object obj3;
        String str3;
        Map map3;
        Map map4;
        if ((i3 & 2) != 0) {
            obj3 = null;
        } else {
            obj3 = obj;
        }
        if ((i3 & 4) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i3 & 8) != 0) {
            map3 = null;
        } else {
            map3 = map;
        }
        if ((i3 & 16) != 0) {
            map4 = null;
        } else {
            map4 = map2;
        }
        eVar.u(str, obj3, str3, map3, map4);
    }

    public final void c(@NotNull Object r85, @NotNull String elementID, @Nullable Map<String, ?> params, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(r85, "element");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        b(r85, elementID, "END_EXPOSURE_POLICY_REPORT_ALL", params, reuseIdentifier);
    }

    public final void e(@NotNull Object r85, @NotNull String elementID, @Nullable Map<String, ?> params, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(r85, "element");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        b(r85, elementID, "EXPOSURE_POLICY_REPORT_ALL", params, reuseIdentifier);
    }

    public final void g(@NotNull Object r85, @NotNull String elementID, @Nullable Map<String, ?> params, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(r85, "element");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        b(r85, elementID, "EXPOSURE_POLICY_REPORT_ONLY_FIRST", params, reuseIdentifier);
    }

    public final void i(@NotNull View contentView, @NotNull String pageId, @Nullable Activity r46, @Nullable Map<String, ?> params) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        if (r46 != null) {
            VideoReport.addToDetectionWhitelist(r46);
        }
        VideoReport.setPageId(contentView, pageId);
        VideoReport.setPageParams(contentView, new WinkDTParamBuilder().buildPageParams(params, WinkContext.INSTANCE.d().getDtParams().c()));
    }

    public final void j(@NotNull Object r85, @NotNull String elementID, @Nullable Map<String, ?> params, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(r85, "element");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        b(r85, elementID, "CLICK_REPORT_NONE", params, reuseIdentifier);
        VideoReport.reportEvent("dt_clck", r85, WinkDTParamBuilder.buildElementParams());
    }

    public final void l(@NotNull Object r26, @NotNull String elementID, @Nullable Map<String, ?> params, @Nullable String reuseIdentifier) {
        Intrinsics.checkNotNullParameter(r26, "element");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        VideoReport.setElementExposePolicy(r26, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(r26, EndExposurePolicy.REPORT_NONE);
        j(r26, elementID, params, reuseIdentifier);
    }

    public final void n(@NotNull final String action, @NotNull final Map<String, String> map, final boolean z16) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(map, "map");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.report.d
            @Override // java.lang.Runnable
            public final void run() {
                e.p(action, map, z16);
            }
        }, 128, null, false);
    }

    public final void q(@NotNull String eventID, @Nullable Object obj, @Nullable String str, @Nullable Map<String, ?> map, @Nullable Map<String, ?> map2) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        VideoReport.setElementId(obj, str);
        VideoReport.setElementParams(obj, map);
        if (map2 != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(map2);
            mutableMap.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
            VideoReport.reportEvent(eventID, obj, mutableMap);
            return;
        }
        VideoReport.reportEvent(eventID, obj, WinkDTParamBuilder.buildElementParams());
    }

    public final void s(@NotNull Object element, @NotNull String elementID, @Nullable Map<String, ?> map, @Nullable String str) {
        Intrinsics.checkNotNullParameter(element, "element");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        b(element, elementID, "CLICK_REPORT_NONE", map, str);
        VideoReport.reportEvent("dt_clck", element, WinkDTParamBuilder.buildMainAppElementParams());
    }

    public final void u(@NotNull String eventID, @Nullable Object r36, @Nullable String elementID, @Nullable Map<String, ?> elementParams, @Nullable Map<String, ?> eventParams) {
        Map mutableMap;
        Intrinsics.checkNotNullParameter(eventID, "eventID");
        VideoReport.setElementId(r36, elementID);
        VideoReport.setElementParams(r36, elementParams);
        if (eventParams != null) {
            mutableMap = MapsKt__MapsKt.toMutableMap(eventParams);
            mutableMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
            VideoReport.reportEvent(eventID, r36, mutableMap);
            return;
        }
        VideoReport.reportEvent(eventID, r36, WinkDTParamBuilder.buildMainAppElementParams());
    }

    public final void w(@NotNull View contentView) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        VideoReport.reportPgOut(contentView);
    }

    public final void x(@NotNull Object element) {
        Intrinsics.checkNotNullParameter(element, "element");
        VideoReport.resetElementParams(element);
    }

    public final void y() {
        VideoReport.traverseExposure();
    }
}
