package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IWinkExport extends QRouteApi {
    int getHDMode(String str);

    void requestGenerateVideo(String str);

    void setHDMode(String str, Boolean bool);

    void setUploadSpeed(int i3, long j3, long j16);

    boolean supportHDMode(String str);
}
