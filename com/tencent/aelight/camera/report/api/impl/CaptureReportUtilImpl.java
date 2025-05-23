package com.tencent.aelight.camera.report.api.impl;

import com.tencent.aelight.camera.aioeditor.b;
import com.tencent.aelight.camera.report.api.ICaptureReportUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class CaptureReportUtilImpl implements ICaptureReportUtil {
    @Override // com.tencent.aelight.camera.report.api.ICaptureReportUtil
    public void reportDoubleClickChangeCamera() {
        b.c();
    }

    @Override // com.tencent.aelight.camera.report.api.ICaptureReportUtil
    public void reportPhotoTaken(int i3) {
        b.p(i3);
    }

    @Override // com.tencent.aelight.camera.report.api.ICaptureReportUtil
    public void reportVideoCapture(int i3) {
        b.q(i3);
    }

    @Override // com.tencent.aelight.camera.report.api.ICaptureReportUtil
    public void setVideoDuration(long j3) {
        b.f66581g = j3;
    }
}
