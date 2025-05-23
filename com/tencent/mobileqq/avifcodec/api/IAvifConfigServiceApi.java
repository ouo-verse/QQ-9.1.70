package com.tencent.mobileqq.avifcodec.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.avifcodec.data.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAvifConfigServiceApi extends QRouteApi {
    a getDecoderSupportAndUpdate(@NonNull AppRuntime appRuntime, long j3);

    a getEncoderSupportAndUpdate(@NonNull AppRuntime appRuntime, long j3);

    a isSupportDecoder();

    a isSupportEncoder();
}
