package com.tencent.mobileqq.qrscan.api;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.a;
import com.tencent.mobileqq.qrscan.i;
import com.tencent.mobileqq.qrscan.j;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IMiniCodeApi extends QRouteApi {
    void addDetectCallback(i iVar);

    void addInitCallback(j jVar);

    boolean bValidDecodeResult(String str);

    String decode(byte[] bArr, int i3, int i16, int i17, int i18);

    String decode(byte[] bArr, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28);

    boolean detect(Bitmap bitmap, long j3);

    boolean detectSync(Bitmap bitmap, ArrayList<a> arrayList);

    int getSupportDetectType();

    void init(Context context, long j3, String str);

    boolean isDecodeInited();

    boolean isDetectInited();

    boolean isDetectReady();

    void removeDetectCallback(i iVar);

    void removeInitCallback(j jVar);

    void unInit(long j3, String str);

    int yuv2Rgba(int[] iArr, byte[] bArr, int i3, int i16);
}
