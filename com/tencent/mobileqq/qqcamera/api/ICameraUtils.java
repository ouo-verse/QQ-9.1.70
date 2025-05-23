package com.tencent.mobileqq.qqcamera.api;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.io.IOException;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface ICameraUtils extends QRouteApi {
    @TargetApi(10)
    Bitmap clipJpegToBitmap(byte[] bArr, Rect rect, boolean z16, int i3) throws IOException, OutOfMemoryError;

    int getJpegRotation(int i3, int i16);

    Class getNearbyPeoplePhotoUploadProcessorClass();

    byte[] getStructMsgBytes(Bundle bundle);

    Bitmap rotateBitmap(Bitmap bitmap, int i3, boolean z16);

    boolean tryRecycle(Bitmap bitmap);
}
