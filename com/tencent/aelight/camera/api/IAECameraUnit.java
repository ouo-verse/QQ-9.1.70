package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAECameraUnit extends QRouteApi {
    public static final String KEY_ARCAKE_ID = "KEY_ARCAKE_ID";
    public static final String KEY_CURRENT_SELECT_ID = "KEY_CURRENT_SELECT_ID";
    public static final String KEY_CURRENT_TAB = "KEY_CURRENT_TAB";
    public static final String KEY_CURRENT_TYPE = "KEY_CURRENT_TYPE";
    public static final String KEY_FACE_UNLOCK_CODE = "key_face_unlock_code";
    public static final String KEY_READ_IN_JOY_VIDEO_UPLOAD_REPORT = "key_read_in_joy_video_upload_report";
    public static final String WIDGET_NAME = "widgetid";

    Class getAEPitUnitClass();

    void setPublishStoryFlag(boolean z16);
}
