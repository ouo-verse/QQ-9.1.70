package com.tencent.mobileqq.pic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeInfo;
import com.tencent.qqnt.kernel.nativeinterface.AvifTranscodeResult;

@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IPicConvertForNativeApi extends QRouteApi {
    AvifTranscodeResult convertAvif2Jpg(int i3, AvifTranscodeInfo avifTranscodeInfo);
}
