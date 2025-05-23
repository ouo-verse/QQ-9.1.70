package com.tencent.mobileqq.guild.nt.misc.api.impl;

import com.tencent.mobileqq.guild.nt.misc.api.IBeaconReportApi;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class BeaconReportApiImpl implements IBeaconReportApi {
    private static final String DEBUG_APP_KEY = "LOGDEBUGKEY00001";

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IBeaconReportApi
    public void report(String str, String str2, Map<String, String> map, boolean z16) {
        QQBeaconReport.report(str, str2, map, z16);
    }
}
