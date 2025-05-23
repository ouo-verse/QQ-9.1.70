package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import qqcircle.QQCircleCounter$RedPointInfo;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQFSRedPointInfoService extends QRouteApi {
    QQCircleCounter$RedPointInfo getGalleryRedPointInfoByAppId(String str);
}
