package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneGetQFSRedPointInfoApi extends QRouteApi {
    void updateQFSGalleryRedPointInfo(int i3, int i16);
}
