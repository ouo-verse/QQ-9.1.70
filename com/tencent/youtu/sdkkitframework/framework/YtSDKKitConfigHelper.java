package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tencent.youtu.sdkkitframework.common.ErrorCode;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import com.tencent.youtu.sdkkitframework.common.StringCode;
import com.tencent.youtu.sdkkitframework.common.YtLogger;
import com.tencent.youtu.sdkkitframework.common.YtSDKStats;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitCommon;
import com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class YtSDKKitConfigHelper {
    static IPatchRedirector $redirector_ = null;
    private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> SDK_SETTINGS;
    private static final String TAG = "YtSDKKitConfigHelper";
    private static final HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String> UI_SETTINGS;

    /* compiled from: P */
    /* renamed from: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper$9, reason: invalid class name */
    /* loaded from: classes27.dex */
    public static /* synthetic */ class AnonymousClass9 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13829);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            YtSDKKitFramework.YtSDKKitFrameworkWorkMode.values();
            int[] iArr = new int[8];
            $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr2[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode2 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr3[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode3 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr4[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode4 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr5[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode5 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr6[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = $SwitchMap$com$tencent$youtu$sdkkitframework$framework$YtSDKKitFramework$YtSDKKitFrameworkWorkMode;
                YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode6 = YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_UNKNOWN;
                iArr7[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15405);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            SDK_SETTINGS = new HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE, "ocr_settings");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE, "silent_settings");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE, "action_settings");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE, "reflect_settings");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE, "action+reflect_settings");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_DETECTONLY_TYPE, "detectonly_settings");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_VIID_TYPE, "ocr_video_ident_settings");
                }
            };
            UI_SETTINGS = new HashMap<YtSDKKitFramework.YtSDKKitFrameworkWorkMode, String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                        return;
                    }
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_TYPE, "ocr_card_ui");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_SILENT_TYPE, "silent_ui");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTION_TYPE, "action_ui");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_REFLECT_TYPE, "reflect_ui");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_ACTREFLECT_TYPE, "action+reflect_ui");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_DETECTONLY_TYPE, "detectonly_ui");
                    put(YtSDKKitFramework.YtSDKKitFrameworkWorkMode.YT_FW_OCR_VIID_TYPE, "ocr_video_ident_ui");
                }
            };
        }
    }

    public YtSDKKitConfigHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getConfigStringBy(JSONObject jSONObject, String str, boolean z16) {
        String str2;
        try {
            str2 = jSONObject.getString(str);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "Parse json object failed ", e16);
            str2 = null;
        }
        if (z16 && (str2 == null || str2.equals(""))) {
            YtLogger.e(TAG, "Parse json object failed " + str + "\u53c2\u6570\u89e3\u6790\u5931\u8d25, \u4e0d\u5b58\u5728\u6216\u8005\u4e0d\u80fd\u4e3a\u7a7a", null);
            YtSDKStats.getInstance().reportError(ErrorCode.YT_SDK_JSON_PARAM_ERROR, StringCode.MSG_PARAM_ERROR);
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put(StateEvent.Name.PROCESS_RESULT, "failed");
            hashMap.put("error_code", Integer.valueOf(ErrorCode.YT_SDK_JSON_PARAM_ERROR));
            hashMap.put("message", CommonUtils.makeMessageJson(ErrorCode.YT_SDK_JSON_PARAM_ERROR, StringCode.MSG_PARAM_ERROR, str + "\u53c2\u6570\u89e3\u6790\u5931\u8d25, \u4e0d\u5b58\u5728\u6216\u8005\u4e0d\u80fd\u4e3a\u7a7a"));
            YtFSM.getInstance().sendFSMEvent(hashMap);
        }
        return str2;
    }

    public static ArrayList<String> getPipleStateNames(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode) {
        switch (ytSDKKitFrameworkWorkMode.ordinal()) {
            case 1:
                return new ArrayList<String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.3
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_AUTO_DETECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_MANUAL_DETECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_OCR_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                    }
                };
            case 2:
            case 3:
                return new ArrayList<String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.4
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.QUALITY_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                    }
                };
            case 4:
                return new ArrayList<String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.5
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.QUALITY_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                    }
                };
            case 5:
                return new ArrayList<String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.6
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_FETCH_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.SILENT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.QUALITY_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.ACTION_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.REFLECT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_LIVENESS_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.TIMEOUT_STATE));
                    }
                };
            case 6:
                return new ArrayList<String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.7
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        } else {
                            add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.DETECTONLY_STATE));
                            add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                        }
                    }
                };
            case 7:
                return new ArrayList<String>() { // from class: com.tencent.youtu.sdkkitframework.framework.YtSDKKitConfigHelper.8
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                            return;
                        }
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.OCR_VIID_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.NET_VIID_REQ_RESULT_STATE));
                        add(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
                    }
                };
            default:
                return null;
        }
    }

    public static JSONObject getSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject(SDK_SETTINGS.get(ytSDKKitFrameworkWorkMode));
        } catch (NullPointerException | JSONException e16) {
            YtLogger.e(TAG, "getSDKConfig error", e16);
            return null;
        }
    }

    public static JSONObject getUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject) {
        try {
            return jSONObject.getJSONObject(UI_SETTINGS.get(ytSDKKitFrameworkWorkMode));
        } catch (JSONException e16) {
            YtLogger.e(TAG, "getUIConfig error", e16);
            return null;
        }
    }

    public static void setSDKConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject.put(SDK_SETTINGS.get(ytSDKKitFrameworkWorkMode), jSONObject2);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "setSDKConfig error", e16);
        }
    }

    public static void setUIConfig(YtSDKKitFramework.YtSDKKitFrameworkWorkMode ytSDKKitFrameworkWorkMode, JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject.put(UI_SETTINGS.get(ytSDKKitFrameworkWorkMode), jSONObject2);
        } catch (JSONException e16) {
            YtLogger.e(TAG, "setUIConfig error", e16);
        }
    }
}
