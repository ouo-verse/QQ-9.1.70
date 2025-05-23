package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes6.dex */
public class FavEmoConstant {
    public static final int ADD_CUSTOM_EMOTION_RESULT_DUPLICATE = 1;
    public static final int ADD_CUSTOM_EMOTION_RESULT_OVER_LIMIT = 2;
    public static final int ADD_CUSTOM_EMOTION_RESULT_OVER_SVIP_LIMIT = 3;
    public static final int ADD_CUSTOM_EMOTION_RESULT_SUCCESS = 0;
    public static final String CMD_FAV_MOVE = "OidbSvcTcp.0x902f";
    public static final String CMD_FAV_OCR = "OidbSvcTcp.0x902e";
    public static final String CMD_FAV_ROAMING = "Faceroam.OpReq";
    public static final String CMD_FAV_SUBCMD_KEY = "cmd_fav_subcmd";
    public static int FAV_LOCAL_COUNT_SHOW_SVIP = 451;
    public static int FAV_LOCAL_MAX_COUNT = 500;
    public static int FAV_LOCAL_MAX_COUNT_SVIP = 1000;
    public static int FAV_ROAMING_MAX_COUNT = 500;
    public static final int FROM_EMOTICON_MANAGER_ACTIVITY = 200;
    public static final int FROM_EMOTICON_PANEL = 100;
    public static final String ROAMING_TYPE_DELETE = "needDel";
    public static final String ROAMING_TYPE_FAILED = "failed";
    public static final String ROAMING_TYPE_INIT = "init";
    public static final String ROAMING_TYPE_NEED_UPLOAD = "needUpload";
    public static final String ROAMING_TYPE_OVERFLOW = "overflow";
    public static final String ROAMING_TYPE_OVERFLOW_DOWNLOADED = "overflow_downloaded";
    public static final String ROAMING_TYPE_PANEL = "needDownload";
    public static final String ROAMING_TYPE_PANEL_DOWNLOADED = "isUpdate";
    public static final String SNAPCHAT_PIC_UPLOAD_STATISTIC_TAG = "scbqmanyou";
    public static final String SP_LOCAL_OVERFLOW = "local_overflow";
    public static final String SP_MAX_FROM_SERVER = "fav_roaming_max";
    public static final String SP_ROAMING_ISCLICK = "fav_roaming_isclick";
    public static final String SP_ROAMING_ISSHOW = "fav_roaming_isshow";
    public static final String SP_ROAMING_TAG = "fav_roaming_sp";
    public static final String SP_ROAMING_TIME = "fav_roaming_time";

    public static int getAddFavEmoOverLimit() {
        boolean z16;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            z16 = VasUtil.getSignedService(peekAppRuntime).getVipStatus().isSVip();
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("FavEmoConstant", 1, "isSvip=" + z16);
        }
        if (z16) {
            return 1000;
        }
        return FAV_ROAMING_MAX_COUNT;
    }

    public static String getAddFavEmoOverLimitTips() {
        return String.format(HardCodeUtil.qqStr(R.string.f170072f2), Integer.valueOf(FAV_LOCAL_MAX_COUNT));
    }

    public static String getFavRoamingPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return AppConstants.SDCARD_IMG_FAVORITE + secureUin(str);
    }

    @Deprecated
    public static String getFavRoamingUrl(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return "https://p.qpic.cn/" + str2 + "/" + str3 + "/" + str + "/0";
        }
        return null;
    }

    public static String secureUin(String str) {
        if (str.length() > 4) {
            return str.substring(4);
        }
        return str;
    }
}
