package com.tencent.qqlive.tvkplayer.vinfo.ckey;

import java.util.Map;
import java.util.Properties;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface BeaconInterface {
    String getQIMEI();

    Properties getRequiredReportValue();

    boolean trackCustomKVEvent(String str, Map<String, String> map);
}
