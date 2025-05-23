package com.tencent.mobileqq.qqvideoedit.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQQVideoEditExport extends QRouteApi {
    int getHDMode(String str);

    void requestGenerateVideo(String str);

    void setHDMode(String str, Boolean bool);

    boolean supportHDMode(String str);
}
