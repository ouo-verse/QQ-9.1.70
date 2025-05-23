package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc03950 implements LpReportInfo {
    public static final String LOVECHATTING_ACTION_TYPE = "16";
    public static final String LOVECHATTING_OPERATION_TYPE_CLICK = "2";
    public static final String LOVECHATTING_OPERATION_TYPE_EXPOSE = "1";
    public static final String LOVECHATTING_RESERVES_C2C_CHATTING_GRAY = "";
    public static final String LOVECHATTING_SUBACTION_TYPE = "1";
    public static final String LOVE_AIO_KEY = "6";
    public static final String LOVE_GRAYTIP_CLOSE = "7";
    public static final String LOVE_GRAYTIP_CLOSE_BEFORE = "8";
    public static final String LOVE_INTERACTIVE_LOGO = "1";
    public static final String LOVE_INTIMACY = "2";
    public static final String LOVE_PASSIVE_FEEDS = "7";
    public static final String LOVE_QZONE_FEEDS_TAIL = "5";
    public static final String LOVE_QZONE_FEEDS_TAIL_GUEST = "9";
    public static final String LOVE_QZONE_HOME_PAGE_PANEL = "3";
    public static final String LOVE_QZONE_HOME_PAGE_PANEL_GUEST = "8";
    public static final String LOVE_QZONE_WIDGET = "4";
    public static final String LOVE_SETTING_ME = "10";
    public static final String LOVE_SLIDE_RESERVES_C2C = "1";
    public static final String LOVE_SLIDE_SUBACTION_TYPE = "6";
    public static final String LOVE_UNKNOWN = "0";
    public static final String LOVE_ZONE_STATIONARY_ADDRESS = "25";
    public static final String REPORT_USER_TYPE_LOVE = "1";
    public static final String REPORT_USER_TYPE_SINGLE = "2";
    public static String TAG = "LpReport.LpReportInfo_dc03950";
    public String actiontype;
    public HashMap<String, String> extraInfoMap;
    private boolean isNeedSample;
    private boolean isReportNow;
    public String operation_type;
    public String qua;
    public String reserves;
    public String subactiontype;
    public long uin;
    public String usertype;
    public static final String AD_ID_EXPIRED = "168604";
    public static final String AD_ID_ANNIVERSARY = "171624";
    public static final String AD_ID_VISTOR = "171621";
    public static final String AD_ID_COMMENTS = "171620";
    public static final String AD_ID_LEAVE_COMMENTS = "171617";
    public static final String AD_ID_LIKE = "171629";
    public static final List<String> LOVE_ZONE_SETTING_ME_RESERVES_LIST = Arrays.asList(AD_ID_EXPIRED, AD_ID_ANNIVERSARY, AD_ID_VISTOR, AD_ID_COMMENTS, AD_ID_LEAVE_COMMENTS, AD_ID_LIKE);

    public LpReportInfo_dc03950(String str, String str2) {
        this.actiontype = str;
        this.subactiontype = str2;
        this.isNeedSample = false;
        this.isReportNow = false;
    }

    public static String getReportUserType(BaseQQAppInterface baseQQAppInterface) {
        return ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getReportUserType(baseQQAppInterface);
    }

    public static void report(LpReportInfo_dc03950 lpReportInfo_dc03950) {
        LpReportManager.getInstance().reportToDC03950(lpReportInfo_dc03950, lpReportInfo_dc03950.isNeedSample, lpReportInfo_dc03950.isReportNow);
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc03950:" + this.actiontype + "," + this.subactiontype + "," + this.reserves + "," + this.operation_type;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        String valueOf;
        HashMap hashMap = new HashMap();
        LpReportUtils.safePut(hashMap, "qua", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
        long j3 = this.uin;
        if (j3 == 0) {
            valueOf = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount();
        } else {
            valueOf = String.valueOf(j3);
        }
        LpReportUtils.safePut(hashMap, "uin", valueOf);
        LpReportUtils.safePut(hashMap, "actiontype", this.actiontype);
        LpReportUtils.safePut(hashMap, "subactiontype", this.subactiontype);
        LpReportUtils.safePut(hashMap, "reserves", this.reserves);
        LpReportUtils.safePut(hashMap, "usertype", this.usertype);
        if (!TextUtils.isEmpty(this.operation_type)) {
            LpReportUtils.safePut(hashMap, "operationtype", this.operation_type);
        }
        HashMap<String, String> hashMap2 = this.extraInfoMap;
        if (hashMap2 != null && hashMap2.size() > 0) {
            hashMap.putAll(this.extraInfoMap);
        }
        return hashMap;
    }

    public LpReportInfo_dc03950(String str, String str2, String str3) {
        this(str, str2);
        this.reserves = str3;
    }

    public LpReportInfo_dc03950(String str, String str2, String str3, String str4) {
        this(str, str2);
        this.reserves = str3;
        this.operation_type = str4;
    }

    public LpReportInfo_dc03950(String str, String str2, String str3, String str4, String str5) {
        this(str, str2);
        this.reserves = str3;
        this.operation_type = str4;
        this.usertype = str5;
    }

    public LpReportInfo_dc03950(String str, String str2, String str3, HashMap<String, String> hashMap) {
        this(str, str2, str3);
        this.extraInfoMap = hashMap;
    }
}
