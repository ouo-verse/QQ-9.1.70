package com.tencent.av.temp;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IQavTemp extends QRouteApi {
    String getAudio3ALicenseFilename();

    boolean isVideoChatting(AppRuntime appRuntime);
}
