package com.tencent.aelight.camera.util.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQIMShortVideoUtil extends QRouteApi {
    boolean isPeakAlive(Context context);

    void preLoadPeakProcess(Context context);

    void preLoadPeakProcess(Context context, Runnable runnable, String str);

    void preLoadPeakProcess(Context context, String str);
}
