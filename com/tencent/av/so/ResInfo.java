package com.tencent.av.so;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.confighandler.ConfigInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ResInfo extends ConfigInfo {
    private static final String FIELD_FOR_ARM64 = "ForArm64";
    private static final String FIELD_RES_FILE_NAME = "resFileName";
    private static final String FIELD_RES_ID = "resId";
    private static final String FIELD_RES_IS_AUTO_DOWNLOAD = "isAutoDownload";
    private static final String FIELD_RES_LIST = "resList";
    private static final String FIELD_RES_MD5 = "resMd5";
    private static final String FIELD_RES_TYPE = "resType";
    private static final String FIELD_RES_VERSION = "resVersion";
    private static final String FIELD_RES_ZIP_MD5 = "resZipMd5";
    private static final String FIELD_RES_ZIP_URL = "resZipUrl";
    public static final String RES_TYPE_MODEL = "model";
    public static final String RES_TYPE_SO = "so";
    public static final String RES_VERSION_AV_AI_NS_MEDIALAB_GRU_MODEL = "QQ8.7.5";
    public static final String RES_VERSION_AV_AI_NS_MEDIALAB_MODEL = "QQ8.5.8";
    public static final String RES_VERSION_AV_AUDIO_PENGUINS_CODEC_MODEL = "QQ8.9.35";
    public static final String RES_VERSION_AV_AUDIO_PENGUINS_CODEC_SO = "QQ8.9.35";
    public static final String RES_VERSION_AV_QQ_AUDIO_AI_NS_MODEL = "QQ8.8.60";
    public static final String RES_VERSION_AV_QQ_AUDIO_AI_SO = "QQ8.8.60";
    public static final String RES_VERSION_AV_TRAE_SO;
    public static final String RES_VERSION_AV_VOICE_RECOG_MODEL = "QQ8.4.8";
    public static final String RES_VERSION_AV_VOICE_RECOG_SO = "QQ8.4.8";
    public static final String RES_VERSION_QAV_RTC_SDK_SO;
    public static final String RES_ID_AV_VOICE_RECOG_SO = "AVVoiceRecogSo";
    public static final String RES_ID_AV_VOICE_RECOG_MODEL = "AVVoiceRecogModel";
    public static final String RES_ID_AV_TRAE_SO = "AVTraeSo";
    public static final String RES_ID_AV_AI_NS_MEDIALAB_MODEL = "AVAINSMediaLabModel";
    public static final String RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL = "AVAINSMediaLabGruModel";
    public static final String RES_ID_QAV_RTC_SDK_SO = "QAVRTCSDKSo";
    public static final String RES_ID_AV_QQ_AUDIO_AI_SO = "AVQQAudioAISo";
    public static final String RES_ID_AV_QQ_AUDIO_AI_NS_MODEL = "AVQQAudioAINSModel";
    public static final String RES_ID_AV_AUDIO_PENGUINS_CODEC_SO = "AVAudioPenguinsCodecSo";
    public static final String RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL = "AVAudioPenguinsCodecModel";
    public static final String[] ALL_RES_ID_LIST = {RES_ID_AV_VOICE_RECOG_SO, RES_ID_AV_VOICE_RECOG_MODEL, RES_ID_AV_TRAE_SO, RES_ID_AV_AI_NS_MEDIALAB_MODEL, RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL, RES_ID_QAV_RTC_SDK_SO, RES_ID_AV_QQ_AUDIO_AI_SO, RES_ID_AV_QQ_AUDIO_AI_NS_MODEL, RES_ID_AV_AUDIO_PENGUINS_CODEC_SO, RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL};
    public String resId = "";
    public String resType = "";
    public String resVersion = "";
    public String resFileName = "";
    public String resMd5 = "";
    public String resZipUrl = "";
    public String resZipMd5 = "";
    public boolean isAutoDownload = true;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("QQ");
        String str = AppSetting.f99551k;
        sb5.append(str);
        sb5.append(".");
        String str2 = AppSetting.f99542b;
        sb5.append(str2);
        RES_VERSION_AV_TRAE_SO = sb5.toString();
        RES_VERSION_QAV_RTC_SDK_SO = "QQ" + str + "." + str2;
    }

    public static String getResType(String str) {
        if (RES_ID_AV_VOICE_RECOG_SO.equalsIgnoreCase(str)) {
            return RES_TYPE_SO;
        }
        if (RES_ID_AV_VOICE_RECOG_MODEL.equalsIgnoreCase(str)) {
            return "model";
        }
        if (RES_ID_AV_TRAE_SO.equalsIgnoreCase(str)) {
            return RES_TYPE_SO;
        }
        if (RES_ID_AV_AI_NS_MEDIALAB_MODEL.equalsIgnoreCase(str) || RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL.equalsIgnoreCase(str)) {
            return "model";
        }
        if (RES_ID_QAV_RTC_SDK_SO.equalsIgnoreCase(str) || RES_ID_AV_QQ_AUDIO_AI_SO.equalsIgnoreCase(str)) {
            return RES_TYPE_SO;
        }
        if (RES_ID_AV_QQ_AUDIO_AI_NS_MODEL.equalsIgnoreCase(str)) {
            return "model";
        }
        if (RES_ID_AV_AUDIO_PENGUINS_CODEC_SO.equalsIgnoreCase(str)) {
            return RES_TYPE_SO;
        }
        if (RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL.equalsIgnoreCase(str)) {
            return "model";
        }
        return "";
    }

    public static String getResVersion(String str) {
        if (RES_ID_AV_VOICE_RECOG_SO.equalsIgnoreCase(str) || RES_ID_AV_VOICE_RECOG_MODEL.equalsIgnoreCase(str)) {
            return "QQ8.4.8";
        }
        if (RES_ID_AV_TRAE_SO.equalsIgnoreCase(str)) {
            return RES_VERSION_AV_TRAE_SO;
        }
        if (RES_ID_AV_AI_NS_MEDIALAB_MODEL.equalsIgnoreCase(str)) {
            return RES_VERSION_AV_AI_NS_MEDIALAB_MODEL;
        }
        if (RES_ID_AV_AI_NS_MEDIALAB_GRU_MODEL.equalsIgnoreCase(str)) {
            return RES_VERSION_AV_AI_NS_MEDIALAB_GRU_MODEL;
        }
        if (RES_ID_QAV_RTC_SDK_SO.equalsIgnoreCase(str)) {
            return RES_VERSION_QAV_RTC_SDK_SO;
        }
        if (RES_ID_AV_QQ_AUDIO_AI_SO.equalsIgnoreCase(str) || RES_ID_AV_QQ_AUDIO_AI_NS_MODEL.equalsIgnoreCase(str)) {
            return "QQ8.8.60";
        }
        if (RES_ID_AV_AUDIO_PENGUINS_CODEC_SO.equalsIgnoreCase(str) || RES_ID_AV_AUDIO_PENGUINS_CODEC_MODEL.equalsIgnoreCase(str)) {
            return "QQ8.9.35";
        }
        return "";
    }

    public static ArrayList<ResInfo> parseConfig(JSONObject jSONObject) {
        try {
            ArrayList<ResInfo> arrayList = new ArrayList<>();
            if (jSONObject.has(FIELD_RES_LIST)) {
                JSONArray jSONArray = jSONObject.getJSONArray(FIELD_RES_LIST);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    ResInfo resInfo = new ResInfo();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    if (jSONObject2.has("resId")) {
                        resInfo.resId = jSONObject2.getString("resId");
                    }
                    if (jSONObject2.has("resType")) {
                        resInfo.resType = jSONObject2.getString("resType");
                    }
                    if (jSONObject2.has(FIELD_RES_VERSION)) {
                        resInfo.resVersion = jSONObject2.getString(FIELD_RES_VERSION);
                    }
                    if (jSONObject2.has(FIELD_RES_FILE_NAME)) {
                        resInfo.resFileName = jSONObject2.getString(FIELD_RES_FILE_NAME);
                    }
                    setCPUBitRelatedResInfo(resInfo, jSONObject2);
                    if (jSONObject2.has(FIELD_RES_IS_AUTO_DOWNLOAD)) {
                        resInfo.isAutoDownload = jSONObject2.getBoolean(FIELD_RES_IS_AUTO_DOWNLOAD);
                    }
                    if (!TextUtils.isEmpty(resInfo.resId) && !TextUtils.isEmpty(resInfo.resType) && !TextUtils.isEmpty(resInfo.resVersion) && !TextUtils.isEmpty(resInfo.resZipUrl) && !TextUtils.isEmpty(resInfo.resZipMd5) && !TextUtils.isEmpty(resInfo.resFileName) && !TextUtils.isEmpty(resInfo.resMd5)) {
                        if (!getResVersion(resInfo.resId).equalsIgnoreCase(resInfo.resVersion)) {
                            if (QLog.isColorLevel()) {
                                QLog.i("AVResMgr", 1, "parseJson. discard res. version is not match. " + resInfo + ", apk version[" + getResVersion(resInfo.resId) + "]");
                            }
                            ResMgr.f(ResMgr.z(resInfo), "");
                        } else {
                            arrayList.add(resInfo);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("AVResMgr", 1, "parseJson. discard res. config fields are empty. " + resInfo);
                    }
                }
            }
            return arrayList;
        } catch (Exception e16) {
            QLog.e("AVResMgr", 1, "parseJson failed. err: " + e16);
            return null;
        }
    }

    private static void setCPUBitRelatedResInfo(ResInfo resInfo, JSONObject jSONObject) throws Exception {
        if (jSONObject.has("resMd5ForArm64")) {
            resInfo.resMd5 = jSONObject.getString("resMd5ForArm64");
        } else if (jSONObject.has("resMd5")) {
            resInfo.resMd5 = jSONObject.getString("resMd5");
        }
        if (jSONObject.has("resZipUrlForArm64")) {
            resInfo.resZipUrl = jSONObject.getString("resZipUrlForArm64");
        } else if (jSONObject.has(FIELD_RES_ZIP_URL)) {
            resInfo.resZipUrl = jSONObject.getString(FIELD_RES_ZIP_URL);
        }
        if (jSONObject.has("resZipMd5ForArm64")) {
            resInfo.resZipMd5 = jSONObject.getString("resZipMd5ForArm64");
        } else if (jSONObject.has(FIELD_RES_ZIP_MD5)) {
            resInfo.resZipMd5 = jSONObject.getString(FIELD_RES_ZIP_MD5);
        }
    }

    @Override // com.tencent.mobileqq.utils.confighandler.ConfigInfo
    protected boolean parse(JSONObject jSONObject) {
        if (parseConfig(jSONObject) != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ResInfo{resId = " + this.resId + ", resType = " + this.resType + ", resVersion = " + this.resVersion + ", resFileName = " + this.resFileName + ", resMd5 = " + this.resMd5 + ", resZipUrl = " + this.resZipUrl + ", resZipMd5 = " + this.resZipMd5 + ", isAutoDownload = " + this.isAutoDownload + "}";
    }
}
