package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IOriPicCompress extends QRouteApi {
    void compressOriginPic(CompressInfo compressInfo);
}
