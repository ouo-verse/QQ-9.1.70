package com.tencent.mobileqq.guild.nt.emoticon.api;

import bv1.a;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IEmoticonUtilsApi extends QRouteApi {
    void addToCommonUse(a aVar);

    String[] getSystemEmoticonSymbolArray();
}
