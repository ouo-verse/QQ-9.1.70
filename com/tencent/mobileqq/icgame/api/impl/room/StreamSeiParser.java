package com.tencent.mobileqq.icgame.api.impl.room;

import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

/* loaded from: classes15.dex */
public class StreamSeiParser {
    private static final String TAG = "StreamSeiParser";
    private static final IAegisLogApi log = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    public static long getSeiServerTimeStamp(a32.c cVar) {
        byte[] bArr;
        if (isSeiUnRegisteredUserData(cVar) && (bArr = cVar.f25431d) != null && bArr.length > 0) {
            String str = new String(bArr);
            try {
                if (!str.contains("OnTencentMixInfo") || !str.contains(AudienceReportConst.LATENCY)) {
                    return 0L;
                }
                JSONObject jSONObject = new JSONObject(str.replace("OnTencentMixInfo", ""));
                if (!AudienceReportConst.LATENCY.equals(jSONObject.optString("type"))) {
                    return 0L;
                }
                return jSONObject.optLong("time");
            } catch (Exception e16) {
                log.e(TAG, "sei parse failed, error " + e16.getMessage());
            }
        }
        return 0L;
    }

    private static boolean isSeiUnRegisteredUserData(a32.c cVar) {
        if (cVar == null) {
            log.e(TAG, "sei info is null.");
            return false;
        }
        if (cVar.f25429b != 5) {
            return false;
        }
        return true;
    }
}
