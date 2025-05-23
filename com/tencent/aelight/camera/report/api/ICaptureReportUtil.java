package com.tencent.aelight.camera.report.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ICaptureReportUtil extends QRouteApi {
    public static final int editVideoType = -1;

    void reportDoubleClickChangeCamera();

    void reportPhotoTaken(int i3);

    void reportVideoCapture(int i3);

    void setVideoDuration(long j3);
}
