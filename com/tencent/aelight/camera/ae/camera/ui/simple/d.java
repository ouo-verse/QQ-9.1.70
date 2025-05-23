package com.tencent.aelight.camera.ae.camera.ui.simple;

import android.content.Intent;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {
    public static int a(int i3) {
        if (js.a.Q.d(i3)) {
            return AESimpleCapturePart.I() ? 2 : 1;
        }
        return 0;
    }

    public static int b(int i3) {
        if (i3 == 0) {
            return 2;
        }
        if (i3 == 1) {
            return 1;
        }
        return 3;
    }

    public static void c(Intent intent) {
        AioCaptureReportParams aioCaptureReportParams;
        if (intent == null || (aioCaptureReportParams = (AioCaptureReportParams) intent.getParcelableExtra("aio_capture_report_params")) == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C0A8", "0X800C0A8", aioCaptureReportParams.f63271d, 0, "", String.valueOf(aioCaptureReportParams.f63273f), String.valueOf(aioCaptureReportParams.f63272e), "");
    }

    public static void d(Intent intent) {
        AioCaptureReportParams aioCaptureReportParams;
        if (intent == null || (aioCaptureReportParams = (AioCaptureReportParams) intent.getParcelableExtra("aio_capture_report_params")) == null) {
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800C0A9", "0X800C0A9", aioCaptureReportParams.f63271d, 0, "", String.valueOf(aioCaptureReportParams.f63273f), String.valueOf(aioCaptureReportParams.f63272e), "");
    }
}
