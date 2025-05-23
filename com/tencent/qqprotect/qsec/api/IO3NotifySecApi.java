package com.tencent.qqprotect.qsec.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IO3NotifySecApi extends QRouteApi {
    void sendMessage(String str, List<String> list);
}
