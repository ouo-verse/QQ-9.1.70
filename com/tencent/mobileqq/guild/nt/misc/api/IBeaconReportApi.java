package com.tencent.mobileqq.guild.nt.misc.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IBeaconReportApi extends QRouteApi {
    void report(String str, String str2, Map<String, String> map, boolean z16);
}
