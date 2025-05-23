package com.tencent.mobileqq.teamwork;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITDocAttaReporterApi;
import com.tencent.mobileqq.teamwork.api.ITDocFileBrowserFacade;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J8\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0004H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/teamwork/f;", "", "Lcom/tencent/mobileqq/teamwork/OpenDocsPerformanceRecorder;", "b", "", "action", "", "openState", "", QCircleWeakNetReporter.KEY_COST, "code", TagName.ENGINE_TYPE, "ext", "", "a", "getFilePath", "getFileSize", "getFileName", "tencentdoc-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface f {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        public static void a(@NotNull f fVar, @NotNull String action, int i3, long j3, int i16, @NotNull String engineType) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(engineType, "engineType");
            fVar.a(action, i3, j3, i16, engineType, "");
        }

        public static void b(@NotNull f fVar, @NotNull String action, int i3, long j3, int i16, @NotNull String engineType, @NotNull String ext) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(engineType, "engineType");
            Intrinsics.checkNotNullParameter(ext, "ext");
            int docsTypeOfIntValue = ((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getDocsTypeOfIntValue(((ITDocFileBrowserFacade) QRoute.api(ITDocFileBrowserFacade.class)).getFileDocsType(fVar.getFilePath()));
            String extension = FileUtils.getExtension(fVar.getFilePath());
            Intrinsics.checkNotNullExpressionValue(extension, "getExtension(getFilePath())");
            String lowerCase = extension.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            ((ITDocAttaReporterApi) QRoute.api(ITDocAttaReporterApi.class)).fileBrowserReport(action, i3, j3, engineType, fVar.getFileSize(), docsTypeOfIntValue, lowerCase, i16, fVar.getFileName(), ext);
        }

        public static void c(@NotNull f fVar) {
            OpenDocsPerformanceRecorder b16 = fVar.b();
            Map<String, Object> m3 = b16.m();
            QLog.i("ITDocBrowserRecorder", 1, "tDoc_step recordPerformance data = " + m3);
            String jSONObject = new JSONObject(m3).toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(data).toString()");
            int b17 = b16.b();
            String a16 = b16.a();
            Intrinsics.checkNotNullExpressionValue(a16, "recorder.engineType");
            fVar.a(ITDocAttaReporterApi.REPORT_OPEN_RECORD, 1, 0L, b17, a16, jSONObject);
        }
    }

    void a(@NotNull String action, int openState, long cost, int code, @NotNull String engineType, @NotNull String ext);

    @NotNull
    OpenDocsPerformanceRecorder b();

    @NotNull
    String getFileName();

    @NotNull
    String getFilePath();

    long getFileSize();
}
