package com.tencent.aelight.camera.pref.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IPhoneConfig extends QRouteApi {
    int getPhoneLevel();
}
