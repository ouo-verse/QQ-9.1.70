package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.msf.core.stepcount.StepCounterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import com.tencent.util.QQDeviceInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc00307 implements LpReportInfo {
    public static final int ACTION_ID_CLICK = 2;
    public static final int ACTION_ID_EXPOSURE = 1;
    public static final int ACTION_ID_RECEIVE_PUSH = 4;
    public static final int ACTION_ID_WEBVIEW_LOADED = 6;
    public static final int ACTION_ID_WEBVIEW_START = 5;
    public static int ACTION_TYPE_RED_PACK = 48;
    public static final int MODULE_ID_1 = 1;
    public static final int MODULE_ID_2 = 2;
    public static final int MODULE_ID_3 = 3;
    public static final int PAGE_ID_ACTIVE_TAB_VIEW = 160;
    public static final int PAGE_ID_CONTACTS_TAB = 161;
    public static final int PAGE_ID_HEALTH_ACCOUNT_DETAIL = 162;
    public static final int PAGE_ID_HEALTH_CONTACT = 165;
    public static final int PAGE_ID_HEALTH_NEW_WEB_VIEW = 159;
    public static final int PAGE_ID_HEALTH_PUSH_MESSAGE = 158;
    public static final int PAGE_ID_HEALTH_SCHEMA = 167;
    public static final int PAGE_ID_HEALTH_SEARCH = 164;
    public static final int PAGE_ID_HEALTH_SEARCH_LATEST = 166;
    public static final int PAGE_ID_MESSAGE_TAB = 157;
    public static final int PAGE_ID_MESSAGE_TAB_HEALTH_BANER = 163;
    public static int SUB_ACTION_TYPE_RED_PACK_CLICK = 27;
    public static int SUB_ACTION_TYPE_RED_PACK_EXPOSURE = 26;
    public static final int platform_id = 2;
    public int act_id;
    public int act_type;
    public String ext0;
    public String ext1;
    public int module_id;
    public String uin;
    public int page_id = -1;
    public int src_id = -1;
    public int success_or_not = -1;
    public long data2 = -1;

    public LpReportInfo_dc00307() {
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc00307:" + this.act_id + "," + this.act_type;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount())) {
            LpReportUtils.safePut(hashMap, "uin", ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAccount());
        }
        int i3 = this.page_id;
        if (i3 >= 0) {
            LpReportUtils.safePut(hashMap, "page_id", i3);
        }
        int i16 = this.src_id;
        if (i16 >= 0) {
            LpReportUtils.safePut(hashMap, "src_id", i16);
        }
        LpReportUtils.safePut(hashMap, "act_id", this.act_id);
        LpReportUtils.safePut(hashMap, "act_type", this.act_type);
        LpReportUtils.safePut(hashMap, StartupReportKey.PLATFORM_ID, 2);
        LpReportUtils.safePut(hashMap, AppConstants.Preferences.QQ_VERSION, AppSetting.f99554n);
        LpReportUtils.safePut(hashMap, "imei", QQDeviceInfo.getIMEI("52b7f2"));
        LpReportUtils.safePut(hashMap, "module_id", this.module_id);
        LpReportUtils.safePut(hashMap, "data_timestamp", String.valueOf(System.currentTimeMillis()));
        LpReportUtils.safePut(hashMap, StepCounterConstants.BEACON_PARAM_KEY_EXT0, this.ext0);
        LpReportUtils.safePut(hashMap, "ext1", this.ext1);
        int i17 = this.success_or_not;
        if (i17 >= 0) {
            LpReportUtils.safePut(hashMap, "success_or_not", i17);
        }
        long j3 = this.data2;
        if (j3 >= 0) {
            LpReportUtils.safePut(hashMap, StepCounterConstants.BEACON_PARAM_KEY_DATA2, String.valueOf(j3));
        }
        return hashMap;
    }

    public LpReportInfo_dc00307(int i3, int i16, int i17) {
        this.act_id = i3;
        this.act_type = i16;
        this.module_id = i17;
    }
}
