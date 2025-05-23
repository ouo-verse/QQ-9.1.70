package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.statistics.DcReportUtil;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasReportUtils {
    public static final String BUSINESS_TYPE_DOWNLOADFACTORY = "downloadfactoryType";
    public static final String BUSINESS_TYPE_EMOTION = "emotionType";
    public static final String BUSINESS_TYPE_EXTERNAL_STORAGE = "externalStorageType";
    public static final String EMOTION_ACITON_AIO = "emotionActionAIO";
    public static final String EMOTION_ACITON_DOWNLOAD = "emotionActionDownload";
    public static final String EMOTION_ACITON_PANEL = "emotionAcitonPanel";
    public static final String EMOTION_ACITON_SEND = "emotionActionSend";
    public static final String EMOTION_ACTION_FAV = "emotionActionFav";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_GIF_DOWNFAIL = "5";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_GIF_FILENOTEXIST = "6";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_GIF_KEYLOSS = "4";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_GIF_KEYSAVE = "7";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_GIF_THROWABLE = "8";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_PRIVIEWDOWNFAIL = "3";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_SDCARD_FULL = "1";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_SDCARD_UNUSABLE = "2";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_STATIC_DOWNFIAL = "9";
    public static final String EMOTION_AIO_DOWNLOAD_ERRORCODE_VOICE_DOWNFAIL = "10";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ADDEMOTIONTAST_ERROR = "5";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_EPID_NOTNUM = "1";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_JSON_DOWNFAIL = "3";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_JSON_PARSE_ERROR = "4";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_NETWORK_NOTSUPPORT = "2";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ONDONE_FAIL = "11";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ONFILEDOWN_FAIL = "10";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ONFILEDOWN_KEYLOSS = "7";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ONFILEDOWN_PATHNULL = "6";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ONFILEDOWN_SAVEEMOTION_ERROR = "8";
    public static final String EMOTION_DOWNLOAD_ERRORCODE_ONFILEDOWN_THROWABLE = "9";
    public static final String EMOTION_FAV_DOWNLOAD_ERRORCODE_FUNNY_DOWNFAIL = "3";
    public static final String EMOTION_FAV_DOWNLOAD_ERRORCODE_JSON_DOWNFAIL = "1";
    public static final String EMOTION_FAV_DOWNLOAD_ERRORCODE_JSON_PARSE_ERROR = "2";
    public static final String EMOTION_FAV_UPLOAD_ERRORCODE_UPLOADFAIL = "4";
    public static final String EMOTION_SEND_ERRORCODE_BIG_AUTH_FAILE = "10";
    public static final String EMOTION_SEND_ERRORCODE_BIG_EMOTIONPKG_NULL = "9";
    public static final String EMOTION_SEND_ERRORCODE_EPNULL = "3";
    public static final String EMOTION_SEND_ERRORCODE_FAV_FILEPROBLEM = "6";
    public static final String EMOTION_SEND_ERRORCODE_FAV_URLEMPTY = "5";
    public static final String EMOTION_SEND_ERRORCODE_INFOEMPTY = "1";
    public static final String EMOTION_SEND_ERRORCODE_KEYLOSS = "2";
    public static final String EMOTION_SEND_ERRORCODE_SMALL_AUTH_FAILE = "8";
    public static final String EMOTION_SEND_ERRORCODE_SMALL_EIDERROR = "4";
    public static final String EMOTION_SEND_ERRORCODE_SMALL_EMOTIONPKG_NULL = "7";

    public static void reportEmotionError(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        DcReportUtil.c(null, "sendtdbank|b_sng_qqvip_vas_status_report|vas_errorcode_report", str + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + str7 + "|" + str8 + "|" + str9 + "|" + str10, true);
    }
}
