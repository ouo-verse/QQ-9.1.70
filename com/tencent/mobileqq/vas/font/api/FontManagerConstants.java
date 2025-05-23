package com.tencent.mobileqq.vas.font.api;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.VasConstant;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class FontManagerConstants {
    public static final int ANDROID_PLATFORM = 2;
    public static final float DEFAULT_ENLARGE_EMO_SIZE = 1.5f;
    public static final float DEFAULT_ENLARGE_FONT_SIZE = 1.5f;
    public static final float DEFAULT_ENLARGE_FONT_SIZE_MAX = 1.3f;
    public static final int ENLARGE_EFFECT_CLOSE = 0;
    public static final int ENLARGE_EFFECT_OPEN = 1;
    public static final String FONTTEST = "fonttest";
    public static final String FONT_DOWN_LOAD_PATH;
    public static final String FONT_EFFECT_CFG;
    public static final int FONT_EFFECT_ENLARGE = 2000;
    public static final int FONT_EFFECT_MAGIC = 1;
    public static final int FONT_EFFECT_NONE = 0;
    public static final String FONT_EFFECT_PATH;
    public static final String FONT_FZ_COMPATIBLE_DIR;
    public static final String FONT_OPEN_SWITCH = "font_open_switch";
    public static final String FONT_SUFF = ".ttf";
    public static final String FONT_TEST_FILE = "font_test_file";
    public static final String FONT_TEST_SWITCH = "font_test_switch";
    public static final String FONT_TEST_TYPE = "font_test_type";
    public static final int FONT_TYPE_DIYFONT_TEST = 99;
    public static final int FONT_TYPE_FANGZHENG = 2;
    public static final int FONT_TYPE_FZCOLOR = 3;
    public static final int FONT_TYPE_FZCOLOR_2 = 4;
    public static final int FONT_TYPE_HANYI = 1;
    public static final String FZ_COLOR_FONT_SO_TAG = "FounderColorFontEngine";
    public static final String ISUSEROPENFONTSWITCH = "isUserOpenFontSwitch_";
    public static final boolean IS_USE_NEW_HY_SO;
    public static final int MAGIC_FONT_DEFAULT_GROUP_SIZE = 4;
    public static final float MAGIC_FONT_DEFAULT_MAX_SIZE1 = 1.3f;
    public static final float MAGIC_FONT_DEFAULT_MAX_SIZE2 = 0.7f;
    public static final float MAGIC_FONT_DEFAULT_NORMAL_SIZE1 = 1.5f;
    public static final float MAGIC_FONT_DEFAULT_NORMAL_SIZE2 = 0.7f;
    public static final float MAGIC_FONT_DEFAULT_SIZE1_NUMBER = 0.3f;
    public static final float MAGIC_FONT_DEFAULT_SIZE2_NUMBER = 0.3f;
    public static final int MAX_ENGINE_CACHE_FONT_NUM = 18;
    public static final String MESSAGE_EXTRA_INFO_KEY_DIY_TIMESTAMP = "diy_timestamp";
    public static final String TAG = "FontManagerConstants";
    public static boolean isTest;
    public static Vector<Integer> mFontBlackList;
    public static AtomicBoolean mFontSwitchFZ;
    public static AtomicBoolean mFontSwitchHanYi;
    public static long mMineLastReportTime;
    public static long mOthersLastReportTime;
    public static AtomicBoolean magicFontConfigInited;
    public static boolean magicFontEnable;
    public static int magicFontGroupSize;
    public static float magicFontMaxSize1;
    public static float magicFontMaxSize2;
    public static float magicFontNormalSize1;
    public static float magicFontNormalSize2;
    public static boolean magicFontOneWordEnable;
    public static float magicFontSize1Number;
    public static float magicFontSize2Number;
    public static volatile boolean sHasChatFont;
    public static Map<Long, Integer> testFontId;
    public static long todayStartTime;
    public AtomicBoolean isTestOn = new AtomicBoolean(false);
    public int mTestFontType = -1;
    public String mTestFontFile = null;

    static {
        String str = VasConstant.FONT_DOWN_LOAD_PATH;
        FONT_DOWN_LOAD_PATH = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("fz2.0/");
        FONT_FZ_COMPATIBLE_DIR = sb5.toString();
        IS_USE_NEW_HY_SO = VasToggle.FEATURE_HY_SO_8953.isEnable(true);
        magicFontConfigInited = new AtomicBoolean(false);
        magicFontEnable = true;
        magicFontOneWordEnable = true;
        magicFontSize1Number = 0.3f;
        magicFontSize2Number = 0.3f;
        magicFontNormalSize1 = 1.5f;
        magicFontNormalSize2 = 0.7f;
        magicFontMaxSize1 = 1.3f;
        magicFontMaxSize2 = 0.7f;
        magicFontGroupSize = 4;
        mMineLastReportTime = 0L;
        mOthersLastReportTime = 0L;
        mFontSwitchHanYi = new AtomicBoolean(true);
        mFontSwitchFZ = new AtomicBoolean(true);
        mFontBlackList = new Vector<>();
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".font_effect");
        FONT_EFFECT_PATH = sDKPrivatePath;
        FONT_EFFECT_CFG = sDKPrivatePath + str2 + VasUpdateConstants.SCID_FONT_EFFECT;
        todayStartTime = 0L;
        isTest = false;
        testFontId = new HashMap();
    }

    public static boolean checkFontExist(int i3, int i16) {
        return ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).isFileExists(i3);
    }

    public static int generateFontValue(NTVasSimpleInfo nTVasSimpleInfo) {
        int i3;
        if (nTVasSimpleInfo != null) {
            long j3 = nTVasSimpleInfo.uVipFont;
            i3 = ((int) (((j3 & 255) << 8) + ((j3 >> 8) & 255))) + (nTVasSimpleInfo.vipFontType << 16) + (nTVasSimpleInfo.magicFont << 24);
        } else {
            i3 = 0;
        }
        if (isTest && nTVasSimpleInfo != null) {
            testFontId.put(Long.valueOf(i3), Integer.valueOf((int) nTVasSimpleInfo.uVipFont));
        }
        return i3;
    }

    public static String getSenderUin(MessageRecord messageRecord) {
        if (Arrays.asList(0, 1000, 1001, 10002, 10004, 1002, 1003, 1004, 1005, 1006, 1008, 1009, 1020, 1021, 1022, 1010, 1025, 10008, 10010).contains(Integer.valueOf(messageRecord.istroop))) {
            if (messageRecord.isSend()) {
                return messageRecord.selfuin;
            }
            return messageRecord.frienduin;
        }
        int i3 = messageRecord.istroop;
        if (i3 == 1) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && !((IFontManagerService) peekAppRuntime.getRuntimeService(IFontManagerService.class, "")).isAnonymousMsg(messageRecord)) {
                if (messageRecord.isSend()) {
                    return messageRecord.selfuin;
                }
                return messageRecord.senderuin;
            }
        } else if (i3 == 3000) {
            if (messageRecord.isSend()) {
                return messageRecord.selfuin;
            }
            return messageRecord.senderuin;
        }
        return null;
    }

    public static String getStaticTTFPath(int i3, int i16) {
        return ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).getSavePath(i3) + File.separator + i3 + "." + i16 + ".ttf";
    }

    public static String getTTFPath(int i3, int i16) {
        return ((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).getFontPath(i3);
    }

    public static long parseFontId(long j3) {
        if (isTest) {
            return testFontId.get(Long.valueOf(j3)).intValue();
        }
        return ((j3 & 255) << 8) + ((j3 >> 8) & 255);
    }

    public static int parseFontType(long j3) {
        return (int) ((j3 >> 16) & 15);
    }

    public static int parseMagicFont(long j3) {
        return ((int) (j3 >> 24)) & 1;
    }

    public static void resetFontSwitch() {
        QLog.e(TAG, 1, "resetFontSwitch");
        mFontSwitchHanYi.set(true);
        mFontSwitchFZ.set(true);
        mFontBlackList.clear();
    }

    public static void updateFontSwitch(String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateFontSwitch configContent = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                JSONObject jSONObject = new JSONObject(str);
                mFontSwitchHanYi.set(jSONObject.optBoolean("enableHanyiFont", true));
                mFontSwitchFZ.set(jSONObject.optBoolean("enableFounderFont", true));
                JSONArray optJSONArray = jSONObject.optJSONArray("blackList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        int optInt = optJSONArray.optInt(i3);
                        if (!mFontBlackList.contains(Integer.valueOf(optInt))) {
                            mFontBlackList.add(Integer.valueOf(optInt));
                        }
                    }
                }
            } catch (JSONException unused) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "updateFontSwitch configContent not json: ", str);
                }
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "updateFontSwitch error: ", e16);
        }
    }

    public static boolean parseMagicFont(MessageRecord messageRecord) {
        if (!magicFontEnable || TextUtils.isEmpty(getSenderUin(messageRecord))) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("vip_font_id");
        return !TextUtils.isEmpty(extInfoFromExtStr) && TextUtils.isDigitsOnly(extInfoFromExtStr) && ((Long.parseLong(extInfoFromExtStr) >> 24) & 1) == 1;
    }

    public static int generateFontValue(ExtensionInfo extensionInfo) {
        int i3;
        if (extensionInfo != null) {
            long j3 = extensionInfo.uVipFont;
            i3 = ((int) (((j3 & 255) << 8) + ((j3 >> 8) & 255))) + (extensionInfo.vipFontType << 16) + (extensionInfo.magicFont << 24);
        } else {
            i3 = 0;
        }
        if (isTest && extensionInfo != null) {
            testFontId.put(Long.valueOf(i3), Integer.valueOf((int) extensionInfo.uVipFont));
        }
        return i3;
    }
}
