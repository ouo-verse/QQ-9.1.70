package cooperation.qzone.report.lp;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportInfo_dc04586 implements LpReportInfo {
    public static final int ACTION_ID_CLICK = 102;
    public static final int ACTION_ID_EXPOSED = 101;
    public static final int ACTION_ID_PAY = 109;
    public static final String APPID = "qzoneviptrace";
    public static final String ITEM_ID_BTN_ADD_FRIEND = "add_friend";
    public static final String ITEM_ID_BTN_APPLY_VISIT = "apply_visit";
    public static final String ITEM_ID_BTN_DELETE = "delete";
    public static final String ITEM_ID_BTN_OPEN = "open_yel";
    public static final String ITEM_ID_BTN_PAY = "yuantuquan";
    private static final int ITEM_TYPE = 4;
    public static final int ITEM_TYPE_BTN = 4;
    public static final String MODULE_ID_CONCISE_HEADER = "nichengmingpai";
    private static final String PAGE_ID = "yuantu_tanchuang";
    public static final String PAGE_ID_CONCISE_HEADER = "gonggetai";
    protected static final int PLATFORM_ID = 1;
    public static String TAG = "LpReport.LpReportInfo_dc04586";
    protected String appId;
    public HashMap<String, String> extraInfoMap;
    protected int itemType;
    protected int mActionId;
    protected String mBusinessInfo;
    private boolean mIsNeedSample;
    private boolean mIsReportNow;
    protected String mItemId;
    protected int mUserType;
    private String moduleId;
    protected String pageId;
    public String qua;
    public long uin;

    public LpReportInfo_dc04586(String str, int i3, int i16) {
        this(str, i3, i16, null);
    }

    public static void report(LpReportInfo_dc04586 lpReportInfo_dc04586) {
        LpReportManager.getInstance().reportToDC04586(lpReportInfo_dc04586, lpReportInfo_dc04586.mIsNeedSample, lpReportInfo_dc04586.mIsReportNow);
    }

    protected String getAppId() {
        return this.appId;
    }

    protected int getItemType() {
        return this.itemType;
    }

    protected String getPageId() {
        return this.pageId;
    }

    @Override // cooperation.qzone.report.lp.LpReportInfo
    public String getSimpleInfo() {
        return "dc04586:," + this.mActionId + "," + this.mItemId + "," + this.mUserType + "," + this.mBusinessInfo;
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
        LpReportUtils.safePut(hashMap, "appid", this.appId);
        LpReportUtils.safePut(hashMap, "page_id", this.pageId);
        LpReportUtils.safePut(hashMap, "item_type", this.itemType);
        LpReportUtils.safePut(hashMap, "item_id", this.mItemId);
        LpReportUtils.safePut(hashMap, "action_id", this.mActionId);
        LpReportUtils.safePut(hashMap, StartupReportKey.PLATFORM_ID, 1);
        LpReportUtils.safePut(hashMap, "user_type", this.mUserType);
        LpReportUtils.safePut(hashMap, "busi_info", this.mBusinessInfo);
        if (!TextUtils.isEmpty(this.moduleId)) {
            LpReportUtils.safePut(hashMap, "module_id", this.moduleId);
        }
        HashMap<String, String> hashMap2 = this.extraInfoMap;
        if (hashMap2 != null && hashMap2.size() > 0) {
            hashMap.putAll(this.extraInfoMap);
        }
        return hashMap;
    }

    public LpReportInfo_dc04586(String str, int i3, int i16, String str2) {
        this(null, null, str, i3, i16, str2, null, 4);
    }

    public LpReportInfo_dc04586(String str, String str2, String str3, int i3, int i16, String str4, String str5, int i17) {
        this.mBusinessInfo = "";
        this.appId = APPID;
        this.pageId = PAGE_ID;
        this.moduleId = "";
        this.itemType = 4;
        if (!TextUtils.isEmpty(str)) {
            this.appId = str;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.pageId = str2;
        }
        this.mActionId = i3;
        this.mItemId = str3;
        this.mUserType = i16;
        if (!TextUtils.isEmpty(str4)) {
            this.mBusinessInfo = str4;
        }
        if (!TextUtils.isEmpty(str5)) {
            this.moduleId = str5;
        }
        this.itemType = i17;
        this.mIsNeedSample = false;
        this.mIsReportNow = false;
    }
}
