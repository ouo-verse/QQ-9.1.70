package com.tencent.mobileqq.qqalbum;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPicToJpg extends QRouteApi {
    public static final String TAG = "PicToJpg";

    boolean isHeif(Object obj);

    boolean picToJpg(a aVar);
}
