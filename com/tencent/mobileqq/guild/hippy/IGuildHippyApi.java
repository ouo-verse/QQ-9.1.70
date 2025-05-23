package com.tencent.mobileqq.guild.hippy;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mtt.hippy.HippyAPIProvider;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes13.dex */
public interface IGuildHippyApi extends QRouteApi {
    HippyAPIProvider getGuildHippyApiProvider();

    boolean isGuildModule(String str);
}
