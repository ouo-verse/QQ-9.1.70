package com.tencent.aelight.camera.download.old.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAEOldResPendentVersion extends QRouteApi {
    boolean checkConfigFileListIsOK(String str, String str2);

    boolean checkSignatureVersionIsOK(String str, int i3);
}
