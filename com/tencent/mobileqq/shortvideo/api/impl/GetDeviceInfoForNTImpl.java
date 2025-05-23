package com.tencent.mobileqq.shortvideo.api.impl;

import android.os.Build;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.mobileqq.shortvideo.api.IGetDeviceInfoForNT;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qqnt.kernel.nativeinterface.DeviceCodecFormatInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GetDeviceInfoForNTImpl implements IGetDeviceInfoForNT {
    @Override // com.tencent.mobileqq.shortvideo.api.IGetDeviceInfoForNT
    public DeviceCodecFormatInfo getDeviceCodecFormatInfo() {
        return new DeviceCodecFormatInfo("android_" + Build.HARDWARE + "_" + AVCoreSystemInfo.getCpuModel(), String.valueOf(ah.K()), String.valueOf(ah.s()));
    }
}
