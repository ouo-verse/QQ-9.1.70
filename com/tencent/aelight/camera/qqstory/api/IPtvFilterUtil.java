package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPtvFilterUtil extends QRouteApi {
    public static final String DynamicAdjustmentTag = "DynamicAdjustment";
    public static final int FILTER_KIND_INVALID = 0;
    public static final String OPEN_CUSTOM_CAMERA_TAG = "open_custom_camera";
    public static final int PTV_FILTER_KIND_BEAUTY = 1;

    void createFakeVidConfigFile(String str, String str2);

    void glSyncCommand(boolean z16);

    void setBeautyKindSafety(int i3);

    void setSupportBeautySafety(boolean z16);
}
