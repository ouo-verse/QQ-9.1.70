package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.earlydownload.handler.b;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQRScanEarlyHandlerApi extends QRouteApi {
    public static final int TYPE_MINI_DECODE_SO = 0;
    public static final int TYPE_MINI_DETECT_MODEL = 2;
    public static final int TYPE_MINI_DETECT_SO = 1;
    public static final int TYPE_QBAR_AI_MODEL = 3;
    public static final int TYPE_VOICE_SCAN_CHIRP = 4;

    b getHandler(int i3, AppRuntime appRuntime);

    String getResName(int i3);
}
