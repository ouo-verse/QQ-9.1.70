package com.tencent.mobileqq.wink.picker.interceptor;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\u001e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0005J\u0006\u0010\u0017\u001a\u00020\u0002J\u0016\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0010R \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010!R\u0016\u0010%\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010&R\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010$R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010$R\u001d\u0010,\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b#\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/MediaInterceptorMonitor;", "", "", "j", "l", "", "interceptorName", "Lcom/tencent/mobileqq/winkpublish/report/MediaPickerErrorCode;", "errorCode", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "g", "k", "Lcom/tencent/mobileqq/winkpublish/report/WinkPublishQualityReportData;", "a", "f", "_traceId", "", "_isVideoTemplate", "_fromTemplateLibrary", "o", "name", "i", tl.h.F, "b", "c", "", "e", "hasShowDialog", DomainData.DOMAIN_NAME, "", "Lcom/tencent/mobileqq/wink/picker/interceptor/e;", "Ljava/util/Map;", "records", "Ljava/lang/String;", "traceId", "d", "Z", "isVideoTemplate", "J", "startTime", "endTime", "isFromTemplateLibrary", "Lkotlin/Lazy;", "()Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MediaInterceptorMonitor {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MediaInterceptorMonitor f324886a = new MediaInterceptorMonitor();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, MonitorInfo> records = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String traceId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isVideoTemplate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long endTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean hasShowDialog;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean isFromTemplateLibrary;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy businessName;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.picker.interceptor.MediaInterceptorMonitor$businessName$2
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final String invoke() {
                return com.tencent.mobileqq.wink.picker.core.c.f324480a.a();
            }
        });
        businessName = lazy;
    }

    MediaInterceptorMonitor() {
    }

    private final WinkPublishQualityReportData a() {
        WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
        winkPublishQualityReportData.setTraceId(traceId);
        if (isVideoTemplate) {
            winkPublishQualityReportData.setAttachInfo("videoTemplate");
        }
        winkPublishQualityReportData.setExt1(String.valueOf(endTime - startTime));
        winkPublishQualityReportData.setExt2(f324886a.f());
        return winkPublishQualityReportData;
    }

    private final String d() {
        return (String) businessName.getValue();
    }

    private final String f() {
        List list;
        String joinToString$default;
        String replace$default;
        boolean z16;
        Map<String, MonitorInfo> map = records;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, MonitorInfo> entry : map.entrySet()) {
            if (entry.getValue().getEndTime() - entry.getValue().getStartTime() > 50) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            replace$default = StringsKt__StringsJVMKt.replace$default((String) entry2.getKey(), "Interceptor", "", false, 4, (Object) null);
            arrayList.add(replace$default + ":" + (((MonitorInfo) entry2.getValue()).getEndTime() - ((MonitorInfo) entry2.getValue()).getStartTime()));
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, ContainerUtils.FIELD_DELIMITER, null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    private final String g() {
        if (isFromTemplateLibrary) {
            return "inspiration_library_to_edit";
        }
        if (isVideoTemplate) {
            return "one_click_masterpiece";
        }
        return "select_image_to_edit";
    }

    private final void j() {
        if (TextUtils.isEmpty(d())) {
            return;
        }
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            WinkPublishQualityReportData a16 = a();
            a16.setEventId("P_PICKER_NEXT_STEP");
            String str = "0";
            a16.setRetCode("0");
            if (hasShowDialog) {
                str = "1";
            }
            a16.setExt4(str);
            String d16 = d();
            Intrinsics.checkNotNull(d16);
            f16.b(a16, d16);
        }
        l();
        records.clear();
    }

    private final void k(String interceptorName, MediaPickerErrorCode errorCode) {
        String str;
        if (TextUtils.isEmpty(d())) {
            return;
        }
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            WinkPublishQualityReportData a16 = a();
            a16.setEventId("E_PICKER_NEXT_STEP");
            a16.setRetCode(String.valueOf(errorCode.transformedCode()));
            a16.setExt3(interceptorName);
            if (hasShowDialog) {
                str = "1";
            } else {
                str = "0";
            }
            a16.setExt4(str);
            a16.setDesc(errorCode.getMessage());
            String d16 = d();
            Intrinsics.checkNotNull(d16);
            f16.b(a16, d16);
        }
        m(interceptorName, errorCode);
        records.clear();
    }

    private final void l() {
        z93.c f16;
        if (hasShowDialog && (f16 = Wink.INSTANCE.f()) != null) {
            WinkPublishQualityReportData a16 = a();
            a16.setEventId("E_PICKER_LOADING");
            a16.setExt4(f324886a.g());
            a16.setRetCode("0");
            String d16 = d();
            Intrinsics.checkNotNull(d16);
            f16.b(a16, d16);
        }
    }

    private final void m(String interceptorName, MediaPickerErrorCode errorCode) {
        z93.c f16;
        if (hasShowDialog && (f16 = Wink.INSTANCE.f()) != null) {
            WinkPublishQualityReportData a16 = a();
            a16.setEventId("E_PICKER_LOADING");
            a16.setRetCode(String.valueOf(errorCode.transformedCode()));
            a16.setExt3(interceptorName);
            a16.setExt4(f324886a.g());
            a16.setDesc(errorCode.getMessage());
            String d16 = d();
            Intrinsics.checkNotNull(d16);
            f16.b(a16, d16);
        }
    }

    public final void b() {
        endTime = System.currentTimeMillis();
        j();
    }

    public final void c(@NotNull String name, @NotNull MediaPickerErrorCode errorCode) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        h(name);
        endTime = System.currentTimeMillis();
        k(name, errorCode);
    }

    public final long e(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MonitorInfo monitorInfo = records.get(name);
        if (monitorInfo == null) {
            return 0L;
        }
        return monitorInfo.getEndTime() - monitorInfo.getStartTime();
    }

    public final void h(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        MonitorInfo monitorInfo = records.get(name);
        if (monitorInfo != null) {
            monitorInfo.c(System.currentTimeMillis());
        }
    }

    public final void i(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        records.put(name, new MonitorInfo(System.currentTimeMillis(), 0L, 2, null));
    }

    public final void n(boolean hasShowDialog2) {
        hasShowDialog = hasShowDialog2;
    }

    public final void o(@NotNull String _traceId, boolean _isVideoTemplate, boolean _fromTemplateLibrary) {
        Intrinsics.checkNotNullParameter(_traceId, "_traceId");
        traceId = _traceId;
        isVideoTemplate = _isVideoTemplate;
        isFromTemplateLibrary = _fromTemplateLibrary;
        startTime = System.currentTimeMillis();
        records.clear();
        hasShowDialog = false;
    }
}
