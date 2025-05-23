package com.tencent.mobileqq.icgame.sso;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.IQQLiveSDKManager;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    public static void a(String str, long j3, String str2, long j16, String str3, int i3, String str4, long j17, String str5) {
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(str);
        if (sDKImpl != null && sDKImpl.getDataReportModule() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("event_code", String.valueOf(j16));
            hashMap.put(AudienceReportConst.EVENT_MSG, str3);
            hashMap.put("user_id", String.valueOf(j17));
            hashMap.put("ext1", String.valueOf(i3));
            hashMap.put("ext2", str4);
            hashMap.put("ext3", str2);
            hashMap.put("cost_time", String.valueOf(j3));
            com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_sso_request", hashMap);
        }
    }
}
