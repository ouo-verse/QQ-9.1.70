package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountMessageUtil extends QRouteApi {
    public static final String ACTION_OPEN_LOCAL = "open_local";

    Object fromByteArray(byte[] bArr);

    Object fromXML(String str);

    boolean jumpNative(String str, Context context);

    byte[] toByteArray(Object obj);
}
