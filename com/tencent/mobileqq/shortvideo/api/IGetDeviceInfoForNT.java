package com.tencent.mobileqq.shortvideo.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.DeviceCodecFormatInfo;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IGetDeviceInfoForNT extends QRouteApi {
    DeviceCodecFormatInfo getDeviceCodecFormatInfo();
}
