package cooperation.qzone.report.lp;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.sqshow.zootopia.taskcenter.bubble.ZPlanBubbleRedDotController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc02467 implements LpReportInfo {
    public static final String ERROR_CODE = "error_code";
    public static final String FACE_FEATURE_SIZE = "face_feature_size";
    public static final String REQUEST_TIME = "request_time";
    public static final String RESPONSE_FAIL_SIZE = "response_fail_size";
    public static final String RESPONSE_SIZE = "response_size";
    public static final String RESPONSE_SUCCESS_SIZE = "response_success_size";
    public static final String RESPONSE_TIME = "response_time";
    public static final String UIN = "uin";
    public int errorCode;
    public int faceFeatureSize;
    public String requestTime;
    public int responseFailSize;
    public int responseSize;
    public int responseSuccessSize;
    public String responseTime;
    public long uin;

    public String getCurrentDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ZPlanBubbleRedDotController.DismissType.TIME_FORMAT);
        if (date != null) {
            return simpleDateFormat.format(date);
        }
        return null;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc02467";
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        HashMap hashMap = new HashMap();
        long j3 = this.uin;
        if (j3 <= 1000) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        hashMap.put("uin", valueOf);
        hashMap.put(FACE_FEATURE_SIZE, String.valueOf(this.faceFeatureSize));
        hashMap.put("error_code", String.valueOf(this.errorCode));
        hashMap.put(RESPONSE_SUCCESS_SIZE, String.valueOf(this.responseSuccessSize));
        hashMap.put(RESPONSE_FAIL_SIZE, String.valueOf(this.responseFailSize));
        hashMap.put(RESPONSE_SIZE, String.valueOf(this.responseSize));
        hashMap.put(REQUEST_TIME, this.requestTime);
        hashMap.put(RESPONSE_TIME, this.responseTime);
        return hashMap;
    }

    public String toString() {
        return "uin = xxx faceSize = " + this.faceFeatureSize + " reqtime = " + this.requestTime + " restime = " + this.responseTime + "resSusSize = " + this.responseSuccessSize + " error = " + this.errorCode;
    }
}
