package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IODProxyUtil extends QRouteApi {
    Bundle getODIntentBundle(IVPluginInfo iVPluginInfo, ILoginKeyHelper iLoginKeyHelper);
}
