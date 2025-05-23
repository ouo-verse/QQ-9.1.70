package com.tencent.mobileqq.guild.media.pic.config.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildDownRequest extends QRouteApi {
    void clearRequest();

    List getRequest();
}
