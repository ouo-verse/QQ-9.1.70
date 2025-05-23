package com.tencent.gamematrix.gmcg.sdk.event.dcevent;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.gamematrix.gmcg.api.GmCgDcEventParser;
import com.tencent.gamematrix.gmcg.api.constant.GmCgDcEventDefine;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGJsonUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.TVInputManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.SDKSceneElement;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapConfigManager;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.keymapconfig.KeyMapSceneConfig;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class CGDcEventAndroidEventParser implements GmCgDcEventParser {
    private static final String ACTION_DOWNLOAD_GAME_TRANSPARENT_FROM_CLOUD_APP = "CMD_MSG_FROM_CLOUDAPP_TO_NATIVE_DOWNLOADGAME";
    private static final String ACTION_OPEN_ASSIST_SCREEN_TRANSPARENT_FROM_CLOUD_APP = "CMD_MSG_FROM_CLOUDAPP_TO_NATIVE_OPEN_ASSIST_SCREEN";
    private static final String ACTION_OPEN_OUTER_WEB_TRANSPARENT_FROM_CLOUD_APP = "CMD_MSG_FROM_CLOUDAPP_TO_NATIVE_OPEN_OUTER_WEB";
    private static final String ACTION_OPEN_SHOP_TRANSPARENT_FROM_CLOUD_APP = "CLOUD_SHOP_PAY";
    private static final String ACTION_POWER_SAVE_MODE_STATUS_TRANSPARENT_FROM_CLOUD_APP = "CMD_MSG_FROM_CLOUDAPP_TO_NATIVE_POWER_SAVE_MODE_STATUS";
    private static final String CMD_TRANSPARENT_MESSAGE_FROM_CLOUD_APP = "CMD_TRANSPARENT_MESSAGE_FROM_CLIENT";
    private static final String SDK_SCENE_MONITOR = "SDK_SCENE_MONITOR";
    private final String mPackageName;
    private final ResultListener mResultListener;

    /* loaded from: classes6.dex */
    public interface ResultListener {
        void onGmCgDcEventAllAndroidEvent(String str);

        void onGmCgDcEventDownloadGame(String str, String str2);

        void onGmCgDcEventOpenAssistScreen(String str, String str2, String str3);

        void onGmCgDcEventOpenOuterScreen(String str, String str2);

        void onGmCgDcEventPowerSaveModeStatusChange(boolean z16);

        void onGmCgDcEventQQIntentForward(Intent intent);

        void onGmCgDcEventSDKScence(int i3, boolean z16);

        void onGmCgDcEventShopInject(String str);

        void onGmCgDcEventTGPAAction(String str, String str2);

        void onGmCgDcEventTGPAScene(String str, String str2);

        void onGmCgDcEventUnknownAndroidEvent(String str);

        void onGmCgDcEventWXFaceIdentify(String str);
    }

    public CGDcEventAndroidEventParser(String str, ResultListener resultListener) {
        this.mPackageName = str;
        this.mResultListener = resultListener;
    }

    private String getSceneFromEventString(String str) {
        String group;
        if (CGStringUtil.notEmpty(str)) {
            Matcher matcher = Pattern.compile("\"scene\"\\s?:\\s?(\\d+)").matcher(str);
            if (matcher.find() && (group = matcher.group(1)) != null) {
                return group;
            }
            return "";
        }
        return "";
    }

    private void handleTGPAAndCGSDKEvent(JSONObject jSONObject) {
        JSONObject jsonObjectFromJsonObject;
        JSONObject jsonObjectFromJsonObject2;
        if (jSONObject != null) {
            CGLog.i("handleTGPAAndCGSDKEvent data: " + jSONObject);
            String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(jSONObject, "cmd");
            String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jSONObject, "gmcg_task_action");
            if (!CGStringUtil.notEmpty(stringFromJsonObject2)) {
                if (!GmCgDcEventDefine.HK_EVENT_GAME_NOTIFY.equals(stringFromJsonObject) || (jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(jSONObject, "data")) == null || (jsonObjectFromJsonObject2 = CGJsonUtil.getJsonObjectFromJsonObject(jsonObjectFromJsonObject, "event")) == null) {
                    stringFromJsonObject2 = "";
                } else {
                    stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "gmcg_task_action");
                }
            }
            CGLog.i("handleTGPAAndCGSDKEvent eventAction: " + stringFromJsonObject2 + ", data: " + jSONObject);
            ResultListener resultListener = this.mResultListener;
            if (resultListener != null) {
                resultListener.onGmCgDcEventTGPAAction(stringFromJsonObject2, "");
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public void parseDcEventDataFromReceive(String str) {
        ResultListener resultListener;
        ResultListener resultListener2;
        ResultListener resultListener3;
        int i3;
        ResultListener resultListener4 = this.mResultListener;
        if (resultListener4 != null) {
            resultListener4.onGmCgDcEventAllAndroidEvent(str);
        }
        String stringFromJsonObject = CGJsonUtil.getStringFromJsonObject(CGJsonUtil.getJsonObjectFromString(str), "androidEvent");
        if (CGStringUtil.notEmpty(stringFromJsonObject)) {
            String str2 = "";
            if (stringFromJsonObject.contains(SDK_SCENE_MONITOR)) {
                JSONObject jsonObjectFromJsonObject = CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromJsonObject(CGJsonUtil.getJsonObjectFromString(stringFromJsonObject), "data"), "event");
                int intFromJsonObject = CGJsonUtil.getIntFromJsonObject(jsonObjectFromJsonObject, "scene", -1);
                boolean boolFromJsonObject = CGJsonUtil.getBoolFromJsonObject(jsonObjectFromJsonObject, "isSceneLeft");
                Log.d("unityscene", "id=" + intFromJsonObject + " isSceneLeft=" + boolFromJsonObject);
                if (!boolFromJsonObject) {
                    JSONArray jsonArrayFromJsonObject = CGJsonUtil.getJsonArrayFromJsonObject(jsonObjectFromJsonObject, "sceneElements");
                    ArrayList<SDKSceneElement> arrayList = new ArrayList<>();
                    if (jsonArrayFromJsonObject != null) {
                        for (int i16 = 0; i16 < jsonArrayFromJsonObject.length(); i16++) {
                            try {
                                JSONObject jSONObject = (JSONObject) jsonArrayFromJsonObject.get(i16);
                                SDKSceneElement sDKSceneElement = new SDKSceneElement();
                                sDKSceneElement.path = jSONObject.optString("path", "");
                                sDKSceneElement.percent_x = (float) jSONObject.optDouble("percent_x", 0.0d);
                                sDKSceneElement.percent_y = (float) jSONObject.optDouble("percent_y", 0.0d);
                                sDKSceneElement.f108117id = jSONObject.optInt("id");
                                arrayList.add(sDKSceneElement);
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                    KeyMapConfigManager keyMapConfigManager = KeyMapConfigManager.getInstance();
                    if (keyMapConfigManager != null) {
                        if (TVInputManager.getInstance().hasMFGamepadConnected()) {
                            i3 = 3;
                        } else {
                            i3 = 1;
                        }
                        KeyMapSceneConfig findScenesConfigByScenesId = keyMapConfigManager.findScenesConfigByScenesId(i3, intFromJsonObject);
                        if (findScenesConfigByScenesId != null) {
                            findScenesConfigByScenesId.changeSceneElementCoordinate(arrayList);
                        }
                    }
                    KeyMapConfigManager.getInstance().setGameTypeMixedKeyMapEnabled(true);
                } else {
                    KeyMapConfigManager.getInstance().setGameTypeMixedKeyMapEnabled(false);
                }
                ResultListener resultListener5 = this.mResultListener;
                if (resultListener5 != null) {
                    resultListener5.onGmCgDcEventSDKScence(intFromJsonObject, boolFromJsonObject);
                    return;
                }
                return;
            }
            if ((stringFromJsonObject.contains("TGPA") || stringFromJsonObject.contains("tgpa") || stringFromJsonObject.contains(GmCgDcEventDefine.HK_EVENT_GAME_NOTIFY)) && stringFromJsonObject.contains("gmcg_task_action")) {
                JSONObject jsonObjectFromString = CGJsonUtil.getJsonObjectFromString(stringFromJsonObject);
                CGLog.i("parseDcEventDataFromReceive TGPA taskAction event: " + jsonObjectFromString.toString());
                handleTGPAAndCGSDKEvent(jsonObjectFromString);
                return;
            }
            if (!stringFromJsonObject.contains("scene") && !stringFromJsonObject.contains("TGPA")) {
                JSONObject jsonObjectFromString2 = CGJsonUtil.getJsonObjectFromString(stringFromJsonObject);
                if (jsonObjectFromString2 != null) {
                    CGLog.i("parseDcEventDataFromReceive android event: " + jsonObjectFromString2.toString());
                    String stringFromJsonObject2 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "event");
                    String stringFromJsonObject3 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "intent");
                    String stringFromJsonObject4 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "faceIdentifyUrl");
                    String stringFromJsonObject5 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromString2, "cmd");
                    if ("QQIntentForward".equalsIgnoreCase(stringFromJsonObject2) && CGStringUtil.notEmpty(stringFromJsonObject3)) {
                        try {
                            Intent parseUri = Intent.parseUri(stringFromJsonObject3, 0);
                            if (parseUri != null) {
                                String uri = parseUri.toUri(0);
                                if (uri.startsWith("mqqapi:")) {
                                    if (uri.contains("#Intent")) {
                                        str2 = uri.substring(0, uri.indexOf("#Intent"));
                                    } else {
                                        str2 = uri;
                                    }
                                }
                                if (CGStringUtil.notEmpty(str2)) {
                                    parseUri = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str2));
                                    parseUri.setFlags(805306368);
                                }
                            }
                            if (parseUri != null && (resultListener3 = this.mResultListener) != null) {
                                resultListener3.onGmCgDcEventQQIntentForward(parseUri);
                                return;
                            }
                            return;
                        } catch (URISyntaxException e17) {
                            e17.printStackTrace();
                            return;
                        }
                    }
                    if (CGStringUtil.notEmpty(stringFromJsonObject4)) {
                        ResultListener resultListener6 = this.mResultListener;
                        if (resultListener6 != null) {
                            resultListener6.onGmCgDcEventWXFaceIdentify(stringFromJsonObject4);
                            return;
                        }
                        return;
                    }
                    if (TextUtils.equals(stringFromJsonObject5, CMD_TRANSPARENT_MESSAGE_FROM_CLOUD_APP)) {
                        CGLog.d("rogers-cloudapp, now androidevent = " + stringFromJsonObject);
                        JSONObject jsonObjectFromJsonObject2 = CGJsonUtil.getJsonObjectFromJsonObject(jsonObjectFromString2, "data");
                        String stringFromJsonObject6 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "cmd");
                        if (TextUtils.equals(ACTION_OPEN_SHOP_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject7 = CGJsonUtil.getStringFromJsonObject(CGJsonUtil.getJsonObjectFromString(CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg")), "body");
                            ResultListener resultListener7 = this.mResultListener;
                            if (resultListener7 != null) {
                                resultListener7.onGmCgDcEventShopInject(stringFromJsonObject7);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_OPEN_ASSIST_SCREEN_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject8 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            String stringFromJsonObject9 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "title");
                            String stringFromJsonObject10 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "extra");
                            ResultListener resultListener8 = this.mResultListener;
                            if (resultListener8 != null) {
                                resultListener8.onGmCgDcEventOpenAssistScreen(stringFromJsonObject8, stringFromJsonObject9, stringFromJsonObject10);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_OPEN_OUTER_WEB_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject11 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            String stringFromJsonObject12 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "extra");
                            ResultListener resultListener9 = this.mResultListener;
                            if (resultListener9 != null) {
                                resultListener9.onGmCgDcEventOpenOuterScreen(stringFromJsonObject11, stringFromJsonObject12);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_POWER_SAVE_MODE_STATUS_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject13 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            if (TextUtils.equals("OPEN", stringFromJsonObject13)) {
                                ResultListener resultListener10 = this.mResultListener;
                                if (resultListener10 != null) {
                                    resultListener10.onGmCgDcEventPowerSaveModeStatusChange(true);
                                    return;
                                }
                                return;
                            }
                            if (TextUtils.equals("CLOSE", stringFromJsonObject13) && (resultListener2 = this.mResultListener) != null) {
                                resultListener2.onGmCgDcEventPowerSaveModeStatusChange(false);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_OPEN_ASSIST_SCREEN_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject14 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            String stringFromJsonObject15 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "title");
                            String stringFromJsonObject16 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "extra");
                            ResultListener resultListener11 = this.mResultListener;
                            if (resultListener11 != null) {
                                resultListener11.onGmCgDcEventOpenAssistScreen(stringFromJsonObject14, stringFromJsonObject15, stringFromJsonObject16);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_OPEN_OUTER_WEB_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject17 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            String stringFromJsonObject18 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "extra");
                            ResultListener resultListener12 = this.mResultListener;
                            if (resultListener12 != null) {
                                resultListener12.onGmCgDcEventOpenOuterScreen(stringFromJsonObject17, stringFromJsonObject18);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_POWER_SAVE_MODE_STATUS_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject19 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            if (TextUtils.equals("OPEN", stringFromJsonObject19)) {
                                ResultListener resultListener13 = this.mResultListener;
                                if (resultListener13 != null) {
                                    resultListener13.onGmCgDcEventPowerSaveModeStatusChange(true);
                                    return;
                                }
                                return;
                            }
                            if (TextUtils.equals("CLOSE", stringFromJsonObject19) && (resultListener = this.mResultListener) != null) {
                                resultListener.onGmCgDcEventPowerSaveModeStatusChange(false);
                                return;
                            }
                            return;
                        }
                        if (TextUtils.equals(ACTION_DOWNLOAD_GAME_TRANSPARENT_FROM_CLOUD_APP, stringFromJsonObject6)) {
                            String stringFromJsonObject20 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "msg");
                            String stringFromJsonObject21 = CGJsonUtil.getStringFromJsonObject(jsonObjectFromJsonObject2, "extra");
                            ResultListener resultListener14 = this.mResultListener;
                            if (resultListener14 != null) {
                                resultListener14.onGmCgDcEventDownloadGame(stringFromJsonObject20, stringFromJsonObject21);
                                return;
                            }
                            return;
                        }
                        ResultListener resultListener15 = this.mResultListener;
                        if (resultListener15 != null) {
                            resultListener15.onGmCgDcEventUnknownAndroidEvent(stringFromJsonObject);
                            return;
                        }
                        return;
                    }
                    ResultListener resultListener16 = this.mResultListener;
                    if (resultListener16 != null) {
                        resultListener16.onGmCgDcEventUnknownAndroidEvent(stringFromJsonObject);
                        return;
                    }
                    return;
                }
                return;
            }
            CGLog.i("CGDcEventAndroidEventParser parseDcEventDataFromReceive: local broadcast to tgpa");
            Intent intent = new Intent("com.tencent.tgpa.cloudgame.ACTION_TGPA_FORWARD");
            intent.putExtra("com.tencent.tgpa.cloudgame.extra.PACKAGE_NAME", this.mPackageName);
            intent.putExtra("com.tencent.tgpa.cloudgame.extra.FORWARD_DATA", stringFromJsonObject);
            ResultListener resultListener17 = this.mResultListener;
            if (resultListener17 != null) {
                resultListener17.onGmCgDcEventTGPAScene(this.mPackageName, getSceneFromEventString(stringFromJsonObject));
            }
        }
    }

    @Override // com.tencent.gamematrix.gmcg.api.GmCgDcEventParser
    public String provideDcEventCmd() {
        return GmCgDcEventDefine.CMD_ANDROID_EVENT;
    }
}
