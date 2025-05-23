package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qrscan.QBarResult;
import com.tencent.mobileqq.qrscan.l;
import java.util.ArrayList;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQRCodeApi extends QRouteApi {
    int getOneResult(StringBuilder sb5, StringBuilder sb6);

    int getOneResultForCamera(StringBuilder sb5, StringBuilder sb6);

    ArrayList<QBarResult> getResult();

    ArrayList<QBarResult> getResultForCamera();

    l.a getSupportReader();

    String getVersion();

    int init(int i3, String str, String str2);

    int initForCamera(int i3, String str, String str2);

    boolean isValidScanImageSize(int i3, int i16);

    boolean isWxCodeSupported();

    void preDownloadQbarSo();

    int release();

    int releaseForCamera();

    int scanImage(byte[] bArr, int i3, int i16);

    int scanImageForCamera(byte[] bArr, int i3, int i16);

    int setReaders(l.a aVar);

    int setReadersForCamera(l.a aVar);
}
