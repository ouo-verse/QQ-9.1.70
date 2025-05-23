package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IToastUtil extends QRouteApi {
    void determineShowByCode(long j3, Context context, int i3, String str, int i16);
}
