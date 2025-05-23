package com.tencent.aelight.camera.play.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAETemplateInfo extends QRouteApi {
    void sendPickedPhotosToMe(Context context, Intent intent);
}
