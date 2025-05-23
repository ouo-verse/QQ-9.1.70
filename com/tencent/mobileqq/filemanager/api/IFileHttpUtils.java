package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.wstt.SSCM.a;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IFileHttpUtils extends QRouteApi {
    int getBlockSize(a aVar, long j3, long j16, long j17);

    String hexToString(byte[] bArr);

    boolean isNeedRetryOtherUrl(int i3);
}
