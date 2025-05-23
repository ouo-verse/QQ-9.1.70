package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.mobileqq.vas.club.ClubContentJsonTaskConstants;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.File;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ClubContentJsonTask {
    private static final byte PLATFORM_ID_ALL = 0;
    private static final byte PLATFORM_ID_ANDROID = 2;
    public static final String TAG = "ClubContentJsonTask";
    public static final String UPDATE_UIN = "";
    public static final int URL_TYPE_ACTIVITY = 3;
    public static final int URL_TYPE_EMOJI_DETAIL = 2;
    public static final int URL_TYPE_EMOJI_HOME = 1;
    public static TaskInfo sEPPromotionTask = new TaskInfo("recommendEmotion.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aioPanal/xydata.json", "recommendEmotionVersion", "vipData_emoji_aio_recommend.json");
    public static TaskInfo sIndividuationUrlTask = new TaskInfo("IndividuationUrls.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation_url/android.json", "individuationUrlJsonNewVersion", "vipData_individuation_url_json");
    public static TaskInfo sIndividuationTask = new TaskInfo("Individuation.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    public static TaskInfo sEmoticonWordingTask = new TaskInfo("EmoticonWording.json", "", "https://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    public static TaskInfo WebViewCrashJSONTask = new TaskInfo("WebviewCrashReport.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vip_crash_report/WebviewCrashReport.json", "WebviewCrashJSONVersion", "WebviewCrashReport.json");
    public static TaskInfo sFunnyPicTask = new TaskInfo("Qutu_xydata.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/vipQutu_release_zip/xydata.json", "QutuXYDataJsonVersion", "xydata.json");
    public static TaskInfo iRedPacketJSONTask = new TaskInfo("iRedPacket_v2.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipRedPacketDataV2/xydata.mobile.v1.json", "vipRedPacketData_json_v2", "vipRedPacketData_json_v2");
    public static TaskInfo UrlInterceptJSONTask = new TaskInfo("UrlIntercept.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_url_to_api/android.json", "UrlIntercept_json", "UrlIntercept_json");
    public static String sPendantMarketJSONUpdateFlag = "clubContentPendantMarketJsonUpdate";
    public static TaskInfo sFontInfoListJSONTask = new TaskInfo("font_info.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data", "https://i.gtimg.cn/qqshow/admindata/comdata/vipList_font_data/version.json", "FontInfoList_json", "FontInfoList_json");
    public static TaskInfo[] sTasks = {sEPPromotionTask, sIndividuationTask, sEmoticonWordingTask};
    public static String ContentPicHost = "https://i.gtimg.cn/xydata";
    public static HashMap<String, Boolean> loadTimeMap = new HashMap<>();
    static com.tencent.mobileqq.vip.f jsonDownloadListener = new a();
    public static PersonalCardUrlInfo mPersonCardUrlInfo = null;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class PersonalCardUrlInfo {
        public String guestUrl;
        public String masterUrl;
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class TaskInfo {
        public static final String TAG = "TaskInfo";
        public String businessName;
        public String jsonName;
        public String jsonUrl;
        public JSONObject rootJson;
        public String urlPrefix;
        public String versionKey;

        public TaskInfo(String str, String str2, String str3, String str4, String str5) {
            this.jsonName = str;
            this.urlPrefix = str2;
            this.jsonUrl = str3;
            this.versionKey = str4;
            this.businessName = str5;
        }

        public synchronized JSONObject readLocalJsonFile(Context context) {
            JSONObject jSONObject = this.rootJson;
            if (jSONObject != null) {
                return jSONObject;
            }
            if (context != null && !TextUtils.isEmpty(this.jsonName)) {
                File file = new File(context.getFilesDir(), this.jsonName);
                if (file.exists()) {
                    try {
                        this.rootJson = new JSONObject(FileUtils.readFileContent(file));
                    } catch (Exception e16) {
                        this.rootJson = null;
                        QLog.e(TAG, 1, "readLocalJsonFile, exception=" + MsfSdkUtils.getStackTraceString(e16));
                    }
                }
                return this.rootJson;
            }
            QLog.e(TAG, 1, "readLocalJsonFile, context or json_name null, context=" + context + ", json_name=" + this.jsonName);
            return null;
        }
    }

    @Nullable
    private static Boolean abTest(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (jSONObject.has("AList") && (jSONObject.get("AList") instanceof JSONArray)) {
            jSONArray = jSONObject.getJSONArray("AList");
        } else {
            jSONArray = new JSONArray();
        }
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            if (str.equals(jSONArray.getString(i3))) {
                return Boolean.TRUE;
            }
        }
        if (jSONObject.has("BList") && (jSONObject.get("BList") instanceof JSONArray)) {
            jSONArray2 = jSONObject.getJSONArray("BList");
        } else {
            jSONArray2 = new JSONArray();
        }
        for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
            if (str.equals(jSONArray2.getString(i16))) {
                return Boolean.FALSE;
            }
        }
        return null;
    }

    private static void diySignatureSwitch(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("diySignatureConfig");
        boolean z16 = true;
        if (optJSONObject != null) {
            IVasCommonAdapter iVasCommonAdapter = (IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class);
            if (optJSONObject.optInt("diySignatureEnable", 0) != 1) {
                z16 = false;
            }
            iVasCommonAdapter.setSignatureEnable(z16);
            if (QLog.isColorLevel()) {
                QLog.d("DiySignature", 2, "diySigEnable = " + optJSONObject.optInt("diySignatureEnable", 0));
                return;
            }
            return;
        }
        QLog.e("Signature", 1, "no diy signature config");
    }

    public static void downloadAllIfNotExist(AppInterface appInterface) {
        appInterface.getApplication().getApplicationContext();
        int i3 = 0;
        while (true) {
            TaskInfo[] taskInfoArr = sTasks;
            if (i3 < taskInfoArr.length) {
                downloadIfNotExist(appInterface, taskInfoArr[i3]);
                i3++;
            } else {
                return;
            }
        }
    }

    public static synchronized void downloadFile(AppInterface appInterface, TaskInfo taskInfo, String str, File file, Bundle bundle) {
        String name;
        synchronized (ClubContentJsonTask.class) {
            if (file == null) {
                return;
            }
            if (str == null) {
                if (taskInfo != null) {
                    str = taskInfo.jsonUrl;
                } else {
                    return;
                }
            }
            String str2 = str;
            if (taskInfo != null) {
                name = taskInfo.jsonName;
            } else {
                name = file.getName();
            }
            String str3 = name;
            String string = bundle.getString("method");
            if (string == null) {
                string = "other";
            }
            forceDownloadFile(appInterface, str2, file, bundle, str3, string);
        }
    }

    public static void downloadIfNotExist(AppInterface appInterface, TaskInfo taskInfo) {
        if (appInterface != null && taskInfo != null) {
            File file = new File(appInterface.getApplication().getApplicationContext().getFilesDir(), taskInfo.jsonName);
            if (!file.exists()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "downloadIfNotExist, not exist: " + taskInfo.jsonName);
                }
                int i3 = 0;
                try {
                    String valueOf = String.valueOf(NetConnInfoCenter.getServerTime());
                    int i16 = 10;
                    if (valueOf.length() <= 10) {
                        i16 = valueOf.length();
                    }
                    String substring = valueOf.substring(0, i16);
                    if (Long.parseLong(substring) < TTL.MAX_VALUE) {
                        i3 = Integer.parseInt(substring);
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, "downloadIfNotExist, Integer.parseInt Err:" + e16.getMessage());
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version", i3);
                bundle.putString("version_key", taskInfo.versionKey);
                bundle.putString("method", "downloadIfNotExist");
                bundle.putString("ifromet", "null1");
                downloadFile(appInterface, taskInfo, ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).insertMtype("VIP_emosm", taskInfo.jsonUrl), file, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadIfNotExist, exists.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void downloadSuccess(com.tencent.mobileqq.vip.g gVar, Bundle bundle, AppRuntime appRuntime) {
        boolean z16;
        String string = bundle.getString("version_key");
        boolean z17 = false;
        if (string != null) {
            setJsonVersion(MobileQQ.sMobileQQ.getApplicationContext(), string, bundle.getInt("version", 0));
        }
        String str = gVar.f313004c;
        if (str != null && appRuntime != null) {
            if (sIndividuationTask.jsonName.equals(str)) {
                TaskInfo taskInfo = sIndividuationTask;
                taskInfo.rootJson = null;
                taskInfo.readLocalJsonFile(appRuntime.getApplication());
                return;
            }
            if (gVar.f313004c.equals(sFunnyPicTask.jsonName)) {
                ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).resolveFunnyPicJson(appRuntime);
                return;
            }
            if (!gVar.f313004c.equals(sIndividuationUrlTask.jsonName)) {
                if (gVar.f313004c.equals(UrlInterceptJSONTask.jsonName)) {
                    ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).parseURLJson(appRuntime);
                    return;
                }
                if (gVar.f313004c.equals(sEmoticonWordingTask.jsonName)) {
                    TaskInfo taskInfo2 = sEmoticonWordingTask;
                    taskInfo2.rootJson = null;
                    taskInfo2.readLocalJsonFile(appRuntime.getApplication());
                    return;
                } else {
                    if (gVar.f313004c.equals(sFontInfoListJSONTask.jsonName)) {
                        return;
                    }
                    return;
                }
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("jsonDownloadListener, app == null:");
        if (appRuntime == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(",key == null:");
        if (gVar.f313004c == null) {
            z17 = true;
        }
        sb5.append(z17);
        QLog.e(TAG, 2, sb5.toString());
    }

    private static void forceDownloadFile(AppInterface appInterface, String str, File file, Bundle bundle, String str2, String str3) {
        boolean z16;
        String string = bundle.getString("ifromet");
        if (string == null) {
            string = "false";
        }
        if (bundle.containsKey("forceUpdate")) {
            z16 = bundle.getBoolean("forceUpdate");
        } else {
            z16 = false;
        }
        int i3 = bundle.getInt("version", 0);
        String str4 = str2 + "_" + i3;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "club_downloadFile,method:" + str3 + ",key:" + str2 + ", server version:" + i3 + ",ifromet:" + string);
        }
        if (z16 || !loadTimeMap.containsKey(str4) || !loadTimeMap.get(str4).booleanValue()) {
            loadTimeMap.put(str4, Boolean.TRUE);
            com.tencent.mobileqq.vip.g gVar = new com.tencent.mobileqq.vip.g(str, file);
            gVar.Q = true;
            gVar.f313004c = str2;
            ((IDownloaderFactory) QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(gVar, jsonDownloadListener, bundle);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, str3 + ",cdownloadFile url=" + str);
            }
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_key", str2);
                hashMap.put("param_ifromet", string);
                StatisticCollector.getInstance(appInterface.getApplication().getApplicationContext()).collectPerformance(appInterface.getAccount(), "VipClubContentJsonTaskLoad", true, 1L, 0L, hashMap, "", false);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "downloadFile, downloadFile error=" + e16.toString());
                }
            }
        }
    }

    public static boolean getIfATest(JSONObject jSONObject, String str, boolean z16) {
        try {
            Boolean abTest = abTest(jSONObject, str);
            if (abTest != null) {
                return abTest.booleanValue();
            }
            int parseInt = Integer.parseInt(jSONObject.getString("ARate"));
            int parseInt2 = Integer.parseInt(str.substring(str.length() - 2));
            if (z16) {
                if (parseInt2 >= parseInt) {
                    return false;
                }
                return true;
            }
            if (parseInt2 > parseInt) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
                return true;
            }
            return true;
        }
    }

    public static JSONObject getJsonFromLocalFile(AppInterface appInterface, TaskInfo taskInfo, boolean z16) {
        String str;
        Context applicationContext = appInterface.getApplicationContext();
        String str2 = taskInfo.jsonName;
        File file = new File(applicationContext.getFilesDir(), str2);
        if (file.exists()) {
            try {
                str = FileUtils.readFileToStringEx(file, -1);
            } catch (Throwable th5) {
                QLog.e(TAG, 2, "getJsonFromLocalFile err,json_name:" + str2 + ", msg:" + th5.getMessage());
                str = null;
            }
            if (str != null) {
                try {
                    return new JSONObject(str);
                } catch (Throwable th6) {
                    QLog.e(TAG, 2, "getJsonFromLocalFile new Json err,json_name:" + str2 + ", msg:" + th6.getMessage());
                    file.delete();
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "getJsonFromLocalFile not exist,json_name:" + str2 + " _ " + z16);
            }
            if (z16) {
                downloadIfNotExist(appInterface, taskInfo);
            }
        }
        return null;
    }

    public static int getJsonVersion(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ClubContentJsonTaskConstants.CONTENT_VERSION, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "--getJsonVersion ,key=" + str + ",version:" + sharedPreferences.getInt(str, 0));
        }
        return sharedPreferences.getInt(str, 0);
    }

    public static void getPersonalCardUrlInfo(AppInterface appInterface) {
        boolean z16;
        boolean z17 = false;
        JSONArray jSONArray = null;
        JSONObject jSONFromLocal = VasUpdateUtil.getJSONFromLocal(appInterface, VasUpdateConstants.SCID_PERSONAL_CONFIG, false, null);
        if (jSONFromLocal == null) {
            return;
        }
        FontManagerConstants.magicFontConfigInited.set(false);
        try {
            mPersonCardUrlInfo = new PersonalCardUrlInfo();
            int optInt = jSONFromLocal.optInt("frequency");
            if (optInt != 0) {
                VasUserData.set(appInterface, VasUserData.Key.TICKET_REQ_INTERVAL, Integer.toString(optInt));
            }
            if (jSONFromLocal.has("vipPersonalCard")) {
                jSONArray = jSONFromLocal.getJSONArray("vipPersonalCard");
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                vipCardInfoConfig(jSONArray);
            }
            JSONObject optJSONObject = jSONFromLocal.optJSONObject("magicFont");
            if (optJSONObject != null) {
                if (optJSONObject.optInt("enable") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                FontManagerConstants.magicFontEnable = z16;
                if (z16) {
                    if (optJSONObject.optInt("changeRuleOneWordEnable") == 1) {
                        z17 = true;
                    }
                    FontManagerConstants.magicFontOneWordEnable = z17;
                    FontManagerConstants.magicFontSize1Number = (float) optJSONObject.optDouble("changeRuleFontSize1");
                    FontManagerConstants.magicFontSize2Number = (float) optJSONObject.optDouble("changeRuleFontSize2");
                    FontManagerConstants.magicFontNormalSize1 = (float) optJSONObject.optDouble("fontSizeNormal1");
                    FontManagerConstants.magicFontNormalSize2 = (float) optJSONObject.optDouble("fontSizeNormal2");
                    FontManagerConstants.magicFontMaxSize1 = (float) optJSONObject.optDouble("fontSizeMax1");
                    FontManagerConstants.magicFontMaxSize2 = (float) optJSONObject.optDouble("fontSizeMax2");
                    FontManagerConstants.magicFontGroupSize = optJSONObject.optInt("groupSize");
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "parseMagicFontConfig oneWordEnable = " + FontManagerConstants.magicFontOneWordEnable + " magicFontSize1Number = " + FontManagerConstants.magicFontSize1Number + " magicFontSize2Number = " + FontManagerConstants.magicFontSize2Number + " magicFontNormalSize1 = " + FontManagerConstants.magicFontNormalSize1 + " magicFontNormalSize2 = " + FontManagerConstants.magicFontNormalSize2 + " magicFontMaxSize1 = " + FontManagerConstants.magicFontMaxSize1 + " magicFontMaxSize2 = " + FontManagerConstants.magicFontMaxSize2 + " magicFontGroupSize = " + FontManagerConstants.magicFontGroupSize);
                    }
                } else {
                    QLog.d(TAG, 2, "parseMagicFontConfig enable = false");
                }
                FontManagerConstants.magicFontConfigInited.set(true);
                ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).clearMagicFontCache(appInterface);
            }
            diySignatureSwitch(jSONFromLocal);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getPersonalCardUrlInfo error: ", e16);
        }
    }

    public static void setJsonVersion(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setJsonVersion ,key=" + str + ",version:" + i3);
        }
        context.getSharedPreferences(ClubContentJsonTaskConstants.CONTENT_VERSION, 0).edit().putInt(str, i3).commit();
    }

    public static void updateJson(AppInterface appInterface, TaskInfo taskInfo, int i3, boolean z16) {
        Context applicationContext = appInterface.getApplication().getApplicationContext();
        Bundle bundle = new Bundle();
        bundle.putInt("version", i3);
        bundle.putString("version_key", taskInfo.versionKey);
        bundle.putString("method", "updateJson");
        bundle.putString("ifromet", String.valueOf(z16));
        downloadFile(appInterface, taskInfo, null, new File(applicationContext.getFilesDir(), taskInfo.jsonName), bundle);
    }

    private static void vipCardInfoConfig(JSONArray jSONArray) throws JSONException {
        int i3;
        String str;
        for (int i16 = 0; i16 < jSONArray.length(); i16++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i16);
            if (jSONObject.has("platformid")) {
                i3 = jSONObject.getInt("platformid");
            } else {
                i3 = -1;
            }
            if (i3 == 0 || i3 == 2) {
                String str2 = "";
                if (!jSONObject.has("masterUrl")) {
                    str = "";
                } else {
                    str = jSONObject.getString("masterUrl");
                }
                if (jSONObject.has("guestUrl")) {
                    str2 = jSONObject.getString("guestUrl");
                }
                PersonalCardUrlInfo personalCardUrlInfo = mPersonCardUrlInfo;
                personalCardUrlInfo.masterUrl = str;
                personalCardUrlInfo.guestUrl = str2;
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "personalcardurlInfo : platformId = " + i3 + ";masterUrl = " + str + ";guestUrl = " + str2);
                    return;
                }
                return;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends com.tencent.mobileqq.vip.f {
        a() {
        }

        private boolean b(com.tencent.mobileqq.vip.g gVar, AppRuntime appRuntime) {
            QLog.e(ClubContentJsonTask.TAG, 1, "ClubContentJsonTask jsondownfail task.key = " + gVar.f313004c);
            String str = gVar.f313004c;
            if (str != null && str.equals(ClubContentJsonTask.iRedPacketJSONTask.jsonName) && appRuntime != null) {
                c(appRuntime);
                return false;
            }
            return false;
        }

        private void c(AppRuntime appRuntime) {
            ((IVasCommonAdapter) QRoute.api(IVasCommonAdapter.class)).reportRedPacket(appRuntime);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(com.tencent.mobileqq.vip.g gVar) {
            boolean b16;
            super.onDone(gVar);
            Bundle h16 = gVar.h();
            String string = h16.getString("method");
            if (string == null) {
                string = "other";
            }
            String string2 = h16.getString("ifromet");
            if (string2 == null) {
                string2 = "null";
            }
            if (QLog.isColorLevel()) {
                QLog.d(ClubContentJsonTask.TAG, 2, "Club_jsonDownloadListener key = " + gVar.f313004c + ",satatus = " + gVar.i() + ",errCode = " + gVar.f313006d + ",errMsg = " + gVar.f313007e);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (gVar.i() == 3 && gVar.f313006d == 0) {
                ClubContentJsonTask.downloadSuccess(gVar, h16, peekAppRuntime);
                b16 = true;
            } else {
                b16 = b(gVar, peekAppRuntime);
            }
            if (QLog.isColorLevel()) {
                QLog.d(ClubContentJsonTask.TAG, 2, "jsonDownloadListener,ret=" + b16 + ",file.name:" + gVar.f313004c + ",method:" + string + ",ifromet:" + string2);
            }
            if (peekAppRuntime != null) {
                try {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_jsonName", gVar.f313004c);
                    hashMap.put("param_method", string);
                    hashMap.put(ISelectMemberActivityConstants.PARAM_FROM, string2);
                    StatisticCollector.getInstance(peekAppRuntime.getApplication().getApplicationContext()).collectPerformance(peekAppRuntime.getAccount(), "ClubContentJsonLoaded", b16, 1L, 0L, hashMap, "", false);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(com.tencent.mobileqq.vip.g gVar) {
            return super.onStart(gVar);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onProgress(com.tencent.mobileqq.vip.g gVar) {
        }
    }
}
