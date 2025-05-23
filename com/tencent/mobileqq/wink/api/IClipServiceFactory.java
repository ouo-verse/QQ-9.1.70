package com.tencent.mobileqq.wink.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.wink.api.IClipService;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IClipServiceFactory extends QRouteApi {
    public static final String TAG = "ClipServiceFactory";

    IClipService.a getClipService();
}
