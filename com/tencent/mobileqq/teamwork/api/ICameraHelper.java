package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ICameraHelper extends QRouteApi {
    public static final long DELAY_CAMERA_PERMISSION_UNCERTAIN = 10000;
    public static final int ERROR_CAMERA_PERMISSION_DENIED = 1830003;
    public static final int ERROR_CAMERA_PERMISSION_UNCERTAIN = 1830004;
    public static final String METHOD_CAMERA_CHECK_PERMISSION = "cameraCheckPermission";
    public static final int MSG_CAMERA_PERMISSION_UNCERTAIN = 1;
    public static final int REQUEST_CODE_CAMERA_PERMISSION = 1819;

    boolean checkPermission(String str);

    void destroy();
}
