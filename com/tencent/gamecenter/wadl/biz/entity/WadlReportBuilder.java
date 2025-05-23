package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameReportService;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ah;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlReportBuilder {
    public static final String KEY_DATA = "data";
    public static final String KEY_DC_ID = "dc_id";
    public static final String KEY_EXT = "ext";
    public static final String KEY_REPORT_LIST = "report_list";
    public static final String KEY_TARGET = "target";
    public static int MAX_EXT_SIZE = 51;
    public static final int TARGET_ATTR = 1;
    public static final int TARGET_DC = 0;
    public String adId;
    public String adTag;
    public String apkVolume;
    public String business;
    private String dcId;
    public HashMap<Integer, String> extMap;
    public String extModule;
    public String extSubModule;
    public String gameAppId;
    public String gameCenterSrc;
    public String logicId;
    public String operId;
    public String opertype;
    public String page;
    public int retId;
    public String tianjiReportStr;
    public int target = 0;
    public String operModule = WadlProxyConsts.OPER_MODULE_GAMECENTER;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface TableElem {
        public static final String AD_ID = "ad_id";
        public static final String APK_VOLUME = "apk_volume";
        public static final String DEVICE_TYPE = "device_type";
        public static final String DOMAIN = "domain";
        public static final String EXT_AD_TAG = "adtag";
        public static final String EXT_MODULE = "ext_module";
        public static final String EXT_SUB_MODULE = "ext_sub_module";
        public static final String GAMECENTER_SRC = "gamecenter_src";
        public static final String GAMECENTER_VER = "gamecenter_ver";
        public static final String GAMECENTER_VER_TYPE = "gamecenter_ver_type";
        public static final String GAME_APPID = "gameappid";
        public static final String IS_NEW_STATUS = "is_new_status";
        public static final String IS_RED_POINT = "is_red_point";
        public static final String NET_TYPE = "net_type";
        public static final String OPER_ID = "oper_id";
        public static final String OPER_MOUDLE = "oper_moudle";
        public static final String RESOLUTION = "resolution";
        public static final String RET_ID = "ret_id";
        public static final String SQ_VERSION = "sq_ver";
        public static final String TIANJI_REPORT_STR = "tianji_report_str";
        public static final String TIME_STAMP = "itimestamp";
        public static final String UIN = "uin";
    }

    public WadlReportBuilder() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.extMap = hashMap;
        hashMap.put(1, WadlProxyConsts.MOUDLE_TYPE_GAMECENTER);
        this.extMap.put(3, "1");
        this.extMap.put(11, "4");
        this.extMap.put(12, WadlProxyConsts.PAGE_ID_GAMECENTER);
        this.extMap.put(14, ah.s());
        this.extMap.put(15, Build.VERSION.RELEASE);
    }

    private String getNetWorkType() {
        int netWorkType = HttpUtil.getNetWorkType();
        if (netWorkType < 0 || netWorkType >= AppConstants.NET_TYPE_NAME.length) {
            netWorkType = 0;
        }
        return AppConstants.NET_TYPE_NAME[netWorkType];
    }

    public JSONObject parseJson(int i3) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(TableElem.TIME_STAMP, String.valueOf(NetConnInfoCenter.getServerTime()));
            jSONObject3.put("domain", "1");
            jSONObject3.put(TableElem.SQ_VERSION, AppSetting.f99551k);
            jSONObject3.put(TableElem.GAMECENTER_VER, "");
            jSONObject3.put(TableElem.GAMECENTER_VER_TYPE, "2");
            jSONObject3.put("device_type", Build.BRAND);
            jSONObject3.put("net_type", getNetWorkType());
            jSONObject3.put("resolution", GameCenterUtil.getDeceiveMetrics());
            jSONObject3.put(TableElem.IS_RED_POINT, "0");
            jSONObject3.put(TableElem.IS_NEW_STATUS, "0");
            jSONObject3.put(TableElem.RET_ID, String.valueOf(this.retId));
            if (!TextUtils.isEmpty(this.page)) {
                jSONObject3.put("page", this.page);
            }
            if (!TextUtils.isEmpty(this.business)) {
                jSONObject3.put("business", this.business);
            }
            if (!TextUtils.isEmpty(this.opertype)) {
                jSONObject3.put("opertype", this.opertype);
            }
            if (!TextUtils.isEmpty(this.logicId)) {
                jSONObject3.put("logicId", this.logicId);
            }
            if (!TextUtils.isEmpty(this.operId)) {
                jSONObject3.put(TableElem.OPER_ID, this.operId);
            }
            if (!TextUtils.isEmpty(this.operModule)) {
                jSONObject3.put(TableElem.OPER_MOUDLE, this.operModule);
            }
            if (!TextUtils.isEmpty(this.operId)) {
                jSONObject3.put(TableElem.OPER_ID, this.operId);
            }
            if (!TextUtils.isEmpty(this.gameAppId)) {
                jSONObject3.put(TableElem.GAME_APPID, this.gameAppId);
            }
            if (!TextUtils.isEmpty(this.tianjiReportStr)) {
                jSONObject3.put(TableElem.TIANJI_REPORT_STR, this.tianjiReportStr);
            }
            if (!TextUtils.isEmpty(this.apkVolume)) {
                jSONObject3.put(TableElem.APK_VOLUME, this.apkVolume);
            }
            if (!TextUtils.isEmpty(this.gameCenterSrc)) {
                jSONObject3.put(TableElem.GAMECENTER_SRC, this.gameCenterSrc);
            } else {
                jSONObject3.put(TableElem.GAMECENTER_SRC, "1");
            }
            if (!TextUtils.isEmpty(this.extModule)) {
                jSONObject3.put(TableElem.EXT_MODULE, this.extModule);
            }
            if (!TextUtils.isEmpty(this.extSubModule)) {
                jSONObject3.put(TableElem.EXT_SUB_MODULE, this.extSubModule);
            }
            if (!TextUtils.isEmpty(this.adTag)) {
                jSONObject3.put("adtag", this.adTag);
            }
            if (!TextUtils.isEmpty(this.adId)) {
                jSONObject3.put("ad_id", this.adId);
            }
            for (Map.Entry<Integer, String> entry : this.extMap.entrySet()) {
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    jSONObject3.put("ext" + entry.getKey(), value);
                }
            }
            jSONObject2.put("data", jSONObject3);
            jSONObject2.put(KEY_DC_ID, this.dcId);
            jSONArray.mo162put(jSONObject2);
            jSONObject.put("target", i3);
            jSONObject.put(KEY_REPORT_LIST, jSONArray);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jSONObject;
    }

    public void report() {
        ((IQQGameReportService) QRoute.api(IQQGameReportService.class)).reportDC(this);
    }

    public WadlReportBuilder setAdId(String str) {
        this.adId = str;
        return this;
    }

    public WadlReportBuilder setAdTag(String str) {
        this.adTag = str;
        return this;
    }

    public WadlReportBuilder setApkVolume(String str) {
        this.apkVolume = str;
        return this;
    }

    public WadlReportBuilder setBusiness(String str) {
        this.business = str;
        return this;
    }

    public WadlReportBuilder setBussinessId(String str) {
        setExt(11, str);
        return this;
    }

    public WadlReportBuilder setDcId(String str) {
        this.dcId = str;
        if (!WadlProxyConsts.TAG_DC_00087.equals(str) && !WadlProxyConsts.TAG_ATTA_NOTICE.equals(str)) {
            if (WadlProxyConsts.TAG_ATTA_05076.equals(str)) {
                this.target = 1;
            }
        } else {
            this.target = 0;
        }
        return this;
    }

    public WadlReportBuilder setExt(int i3, String str) {
        if (str != null && i3 >= 1 && i3 <= MAX_EXT_SIZE) {
            this.extMap.put(Integer.valueOf(i3), str);
        }
        return this;
    }

    public WadlReportBuilder setExtModule(String str) {
        this.extModule = str;
        return this;
    }

    public WadlReportBuilder setExtSubModule(String str) {
        this.extSubModule = str;
        return this;
    }

    public WadlReportBuilder setGameAppId(String str) {
        this.gameAppId = str;
        return this;
    }

    public WadlReportBuilder setGameCenterSrc(String str) {
        this.gameCenterSrc = str;
        return this;
    }

    public WadlReportBuilder setLogicId(String str) {
        this.logicId = str;
        return this;
    }

    public WadlReportBuilder setModuleType(String str) {
        setExt(1, str);
        return this;
    }

    public WadlReportBuilder setOperId(String str) {
        this.operId = str;
        return this;
    }

    public WadlReportBuilder setOperModule(String str) {
        this.operModule = str;
        return this;
    }

    public WadlReportBuilder setOperType(String str) {
        setExt(4, str);
        return this;
    }

    public WadlReportBuilder setOpertype(String str) {
        this.opertype = str;
        return this;
    }

    public WadlReportBuilder setPage(String str) {
        this.page = str;
        return this;
    }

    public WadlReportBuilder setPageId(String str) {
        setExt(12, str);
        return this;
    }

    public WadlReportBuilder setRetId(int i3) {
        this.retId = i3;
        return this;
    }

    public WadlReportBuilder setTianjiReportStr(String str) {
        this.tianjiReportStr = str;
        return this;
    }

    public String toString() {
        return "[dcId=" + this.dcId + ",operId=" + this.operId + ",operModule=" + this.operModule + "]";
    }
}
