package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IImgProcessApi extends QRouteApi {
    int ArrayConvert(int i3, byte[] bArr, int[] iArr);

    int CropGray2(byte[] bArr, byte[] bArr2, int i3, int i16, int i17);

    int TransBytes(int[] iArr, byte[] bArr, int i3, int i16);

    int TransPixels(int[] iArr, byte[] bArr, int i3, int i16);

    int YUVrotate(byte[] bArr, byte[] bArr2, int i3, int i16);

    int YUVrotateLessMemCost(byte[] bArr, int i3, int i16);

    int YuvToCropIntArray(byte[] bArr, int[] iArr, int i3, int i16, int i17, int i18, int i19, int i26);

    int gray_rotate_crop_sub(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    int gray_rotate_sub(byte[] bArr, int[] iArr, byte[] bArr2, int i3, int i16, int i17, int i18);
}
