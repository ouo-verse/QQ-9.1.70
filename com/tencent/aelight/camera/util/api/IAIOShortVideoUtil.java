package com.tencent.aelight.camera.util.api;

import android.app.Activity;
import android.content.Intent;
import android.os.Environment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAIOShortVideoUtil extends QRouteApi {
    public static final int AIO_SHORTVIDEO_REQUEST_CODE = 11;
    public static final boolean CAM_START_MONITOR_FLAG = false;
    public static final String CAM_START_MONITOR_TAG = "CAM_START_MONITOR";
    public static final String MONITOR_EVENT_TAG = "CAM_MONITOR_EVENT";
    public static final int SYS_CAMERA_PHOTO = 0;
    public static final int SYS_CAMERA_VIDEO = 1;
    public static final String debugDecodeFilePath = Environment.getExternalStorageDirectory() + "/Tencent/com/tencent/mobileqq/debugDecodeShortVideo";

    long getBaseActivtiyCreateTime();

    long getBaseActivtiyResumeTime();

    long getBaseActivtiyStartTime();

    long getClickCameraTime();

    int getEntranceType(int i3);

    long getPeakLoadTime();

    long getStartActivityTime();

    void handleSysCameraResult(AppInterface appInterface, Activity activity, Intent intent, Object obj, int i3, int i16);

    void setBaseActivtiyCreateTime(long j3);

    void setBaseActivtiyResumeTime(long j3);

    void setBaseActivtiyStartTime(long j3);

    void setClickCameraTime(long j3);

    void setPeakLoadTime(long j3);

    void setStartActivtiyTime(long j3);
}
