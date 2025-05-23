package com.tencent.mobileqq.richmedia.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.richmedia.c;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IRichMediaTransferUtils extends QRouteApi {
    public static final boolean NEW_STORE_FLAG = true;

    c createRichMediaIpSaver();
}
