package com.tencent.mobileqq.vas;

import android.graphics.Color;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.gamecenter.api.impl.GameCenterCommonApiImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import cooperation.photoplus.sticker.Sticker;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SignatureTemplateConfig {
    public static final int SIGNATURE_COVER = 16;
    public static final String SIGNATURE_ITEM_APP = "vipSignature_item";
    public static final int SIGNATURE_TEMPLATE_IMAGE = 17;
    public static final String SIGNATURE_TEMPLATE_JSON_PATH = VasConstant.SIGNATURE_TEMPLATE_DIR + "sign_tpl.json";
    public static final int SIGNATURE_TEMPLATE_ZIP = 18;
    public static final int SIGNATURE_TEMPLATE_ZIP_DIR = 19;
    public static final String SIGNATURE_TYPE_APP = "vipSignature_common_data";
    public static final String TAG = "SignatureTemplateConfig";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class SignatureTemplateType {
        public int sigId;
        public ArrayList<SignatureTemplateInfo> sigTlpList = new ArrayList<>();
        public String sigType;
    }

    public static String getSignatureFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(VasConstant.SIGNATURE_TEMPLATE_DIR);
        String str3 = File.separator;
        sb5.append(str3);
        sb5.append(str);
        sb5.append(str3);
        sb5.append(str2);
        return sb5.toString();
    }

    public static SignatureTemplateInfo getSignatureTemplateInfoFromFile(AppRuntime appRuntime, int i3) {
        if (i3 == 0) {
            return null;
        }
        try {
            String readFileToStringEx = FileUtils.readFileToStringEx(VasUpdateUtil.getFileFromLocal(appRuntime, 1000L, VasUpdateConstants.SCID_SIGNATURE_TEMPLATE_CONFIG_PREFIX + i3 + Sticker.JSON_SUFFIX, VasConstant.SIGNATURE_TEMPLATE_DIR + i3 + File.separator + "config.json", true, null), -1);
            if (readFileToStringEx == null) {
                QLog.e(TAG, 1, "read config fail result = null");
                return null;
            }
            SignatureTemplateInfo signatureTemplateInfo = new SignatureTemplateInfo(Integer.toString(i3));
            parseConfig(readFileToStringEx, signatureTemplateInfo);
            return signatureTemplateInfo;
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "read config fail", e16);
            return null;
        }
    }

    private static void optParseColor(SignatureTemplateInfo signatureTemplateInfo) {
        try {
            Color.parseColor(signatureTemplateInfo.fontColor);
        } catch (Exception unused) {
            signatureTemplateInfo.fontColor = "";
        }
    }

    public static void parseConfig(String str, SignatureTemplateInfo signatureTemplateInfo) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null && optJSONArray.length() == 1) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
                if (jSONObject2.optInt("platId") == 1) {
                    signatureTemplateInfo.setDefaultInfo();
                    return;
                }
                String optString = jSONObject2.optString(VasUserData.Key.QQ_VER, AEResManagerConfigBean.DEFAULT_VERSION);
                signatureTemplateInfo.qqVer = optString;
                if (AppSetting.b(optString) < 0) {
                    signatureTemplateInfo.setDefaultInfo();
                    return;
                }
                signatureTemplateInfo.name = jSONObject2.optString("name", HardCodeUtil.qqStr(R.string.tiq));
                signatureTemplateInfo.type = jSONObject2.optInt("type", -1);
                signatureTemplateInfo.feeType = jSONObject2.optInt(VipFunCallConstants.KEY_FEET_TYPE, 1);
                signatureTemplateInfo.actUrl = jSONObject2.optString(GameCenterCommonApiImpl.KEY_ACT_URL, null);
                signatureTemplateInfo.newOrHot = jSONObject2.optInt("newOrHot", 0);
                signatureTemplateInfo.platId = jSONObject2.optInt("platId");
                signatureTemplateInfo.fontColor = jSONObject2.optString("fontColor", "");
                signatureTemplateInfo.signType = jSONObject2.optInt(PayProxy.Source.PAY_REQUEST_SIGN_TYPE_KEY, 0);
                optParseColor(signatureTemplateInfo);
                signatureTemplateInfo.defText = jSONObject2.optString("defText", "");
                String optString2 = jSONObject2.optString("defTextColor", "");
                signatureTemplateInfo.defTextColor = optString2;
                try {
                    Color.parseColor(optString2);
                } catch (Exception unused) {
                    signatureTemplateInfo.defTextColor = "";
                }
                String optString3 = jSONObject2.optString("timeAndLocation", "");
                signatureTemplateInfo.timeAndLocationColor = optString3;
                try {
                    Color.parseColor(optString3);
                } catch (Exception unused2) {
                    signatureTemplateInfo.timeAndLocationColor = "";
                }
                signatureTemplateInfo.isLimited = jSONObject2.optInt("isLimited", 1);
                signatureTemplateInfo.startTime = jSONObject2.optString("startTime");
                signatureTemplateInfo.endTime = jSONObject2.optString("endTime");
                signatureTemplateInfo.dot9png = jSONObject2.optString("dot9png");
                signatureTemplateInfo.cover = jSONObject2.optString("cover");
                signatureTemplateInfo.aio2 = jSONObject2.optString("aio_2");
                signatureTemplateInfo.aio3 = jSONObject2.optString("aio_3");
                signatureTemplateInfo.aio4 = jSONObject2.optString("aio_4");
                signatureTemplateInfo.icon = jSONObject2.optString("icon");
                signatureTemplateInfo.view = jSONObject2.optString("view");
                signatureTemplateInfo.actionOff = jSONObject2.optString("action_off");
                signatureTemplateInfo.actionOn = jSONObject2.optString("action_on");
                signatureTemplateInfo.backgroundColor = jSONObject2.optString("backgroundColor");
                signatureTemplateInfo.shadowColor = jSONObject2.optString(NodeProps.SHADOW_COLOR);
                signatureTemplateInfo.materialVersion = jSONObject2.optInt("materialVersion");
                if (jSONObject.has("dynamicItem")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("dynamicItem");
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        setSigTlpInfo(signatureTemplateInfo, jSONArray.getJSONObject(i3));
                    }
                }
                setImgItem(signatureTemplateInfo, jSONObject);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getSignatureTemplateInfoFromFile error: " + e16.getMessage());
        }
    }

    public static SignatureTemplateType[] parseConfigFile(AppRuntime appRuntime) {
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String readFileString = readFileString(new File(SIGNATURE_TEMPLATE_JSON_PATH));
            if (readFileString == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject((String) readFileString.subSequence(readFileString.indexOf("{"), readFileString.length())).getJSONObject("data");
            JSONArray jSONArray = jSONObject.getJSONArray("itemType");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                SignatureTemplateType signatureTemplateType = new SignatureTemplateType();
                signatureTemplateType.sigId = jSONObject2.getInt("sigId");
                signatureTemplateType.sigType = jSONObject2.getString("sigType");
                linkedHashMap.put(Integer.valueOf(signatureTemplateType.sigId), signatureTemplateType);
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("items");
            Iterator keys = jSONObject3.keys();
            while (keys.hasNext()) {
                parseConfigFormJson(linkedHashMap, jSONObject3, keys);
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (((SignatureTemplateType) ((Map.Entry) it.next()).getValue()).sigTlpList.size() == 0) {
                    it.remove();
                }
            }
            SignatureTemplateType[] signatureTemplateTypeArr = new SignatureTemplateType[linkedHashMap.values().size()];
            linkedHashMap.values().toArray(signatureTemplateTypeArr);
            return signatureTemplateTypeArr;
        } catch (Exception e16) {
            File file = new File(SIGNATURE_TEMPLATE_JSON_PATH);
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d(TAG, 2, "parse sig cfg fail " + e16.getMessage());
            return null;
        }
    }

    private static void parseConfigFormJson(Map<Integer, SignatureTemplateType> map, JSONObject jSONObject, Iterator it) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray((String) it.next());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            SignatureTemplateInfo signatureTemplateInfo = new SignatureTemplateInfo(jSONObject2.getString("id"));
            parseItemDatasFormJson(signatureTemplateInfo, jSONObject2.getJSONArray("data"));
            if (jSONObject2.has("dynamicItem")) {
                parseDynamicArrayFormJson(signatureTemplateInfo, jSONObject2.getJSONArray("dynamicItem"));
            }
            setImgItem(signatureTemplateInfo, jSONObject2);
            SignatureTemplateType signatureTemplateType = map.get(Integer.valueOf(signatureTemplateInfo.type));
            if (signatureTemplateType != null) {
                signatureTemplateType.sigTlpList.add(signatureTemplateInfo);
            }
        }
    }

    private static void parseDynamicArrayFormJson(SignatureTemplateInfo signatureTemplateInfo, JSONArray jSONArray) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            parseDynamicItemFormJson(signatureTemplateInfo, jSONArray.getJSONObject(i3));
        }
    }

    private static void parseDynamicItemFormJson(SignatureTemplateInfo signatureTemplateInfo, JSONObject jSONObject) throws JSONException {
        int i3;
        int i16;
        if (jSONObject.has("aio_rows")) {
            i3 = jSONObject.getInt("aio_rows");
        } else {
            i3 = -1;
        }
        if (i3 == 0 || (i3 > 1 && i3 < 6)) {
            if (i3 == 0) {
                i16 = i3;
            } else {
                i16 = i3 - 1;
            }
            SignatureTemplateInfo.DynamicItem dynamicItem = signatureTemplateInfo.dynamicItem[i16];
            dynamicItem.aioRows = i3;
            dynamicItem.pngZip = (String) parseJsonData(jSONObject.has("pngZip"), jSONObject.getString("pngZip"), "");
            signatureTemplateInfo.dynamicItem[i16].posX = ((Float) parseJsonData(jSONObject.has("posX"), jSONObject.getString("posX"), 0)).floatValue();
            signatureTemplateInfo.dynamicItem[i16].posY = ((Float) parseJsonData(jSONObject.has("posY"), jSONObject.getString("posY"), 0)).floatValue();
            signatureTemplateInfo.dynamicItem[i16].width = ((Float) parseJsonData(jSONObject.has("width"), jSONObject.getString("width"), 0)).floatValue();
            signatureTemplateInfo.dynamicItem[i16].height = ((Float) parseJsonData(jSONObject.has("height"), jSONObject.getString("height"), 0)).floatValue();
            signatureTemplateInfo.dynamicItem[i16].repeatTimes = ((Integer) parseJsonData(jSONObject.has("repeatTimes"), jSONObject.getString("repeatTimes"), 0)).intValue();
            signatureTemplateInfo.dynamicItem[i16].interval = ((Integer) parseJsonData(jSONObject.has(WidgetCacheConstellationData.INTERVAL), jSONObject.getString(WidgetCacheConstellationData.INTERVAL), 0)).intValue();
        }
    }

    private static void parseItemDatasFormJson(SignatureTemplateInfo signatureTemplateInfo, JSONArray jSONArray) throws JSONException {
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i3);
            if (jSONObject.getInt("platId") != 1) {
                String string = jSONObject.getString(VasUserData.Key.QQ_VER);
                signatureTemplateInfo.qqVer = string;
                if (AppSetting.b(string) >= 0) {
                    signatureTemplateInfo.name = (String) parseJsonData(jSONObject.has("name"), jSONObject.getString("name"), HardCodeUtil.qqStr(R.string.tiq));
                    signatureTemplateInfo.type = ((Integer) parseJsonData(jSONObject.has("type"), Integer.valueOf(jSONObject.getInt("type")), -1)).intValue();
                    signatureTemplateInfo.feeType = ((Integer) parseJsonData(jSONObject.has(VipFunCallConstants.KEY_FEET_TYPE), Integer.valueOf(jSONObject.getInt(VipFunCallConstants.KEY_FEET_TYPE)), 1)).intValue();
                    signatureTemplateInfo.actUrl = (String) parseJsonData(jSONObject.has(GameCenterCommonApiImpl.KEY_ACT_URL), jSONObject.getString(GameCenterCommonApiImpl.KEY_ACT_URL), null);
                    signatureTemplateInfo.newOrHot = ((Integer) parseJsonData(jSONObject.has("newOrHot"), jSONObject.getString("newOrHot"), 0)).intValue();
                    signatureTemplateInfo.platId = jSONObject.getInt("platId");
                    signatureTemplateInfo.fontColor = (String) parseJsonData(jSONObject.has("fontColor"), jSONObject.getString("fontColor"), "");
                    optParseColor(signatureTemplateInfo);
                    signatureTemplateInfo.defText = (String) parseJsonData(jSONObject.has("defText"), jSONObject.getString("defText"), "");
                    String str = (String) parseJsonData(jSONObject.has("defTextColor"), jSONObject.getString("defTextColor"), "");
                    signatureTemplateInfo.defTextColor = str;
                    try {
                        Color.parseColor(str);
                    } catch (Exception unused) {
                        signatureTemplateInfo.defTextColor = "";
                    }
                    String str2 = (String) parseJsonData(jSONObject.has("timeAndLocation"), jSONObject.getString("timeAndLocation"), "");
                    signatureTemplateInfo.timeAndLocationColor = str2;
                    try {
                        Color.parseColor(str2);
                    } catch (Exception unused2) {
                        signatureTemplateInfo.timeAndLocationColor = "";
                    }
                    signatureTemplateInfo.isLimited = ((Integer) parseJsonData(jSONObject.has("isLimited"), jSONObject.getString("isLimited"), 1)).intValue();
                    signatureTemplateInfo.startTime = (String) parseJsonData(jSONObject.has("startTime"), jSONObject.getString("startTime"), "");
                    signatureTemplateInfo.endTime = (String) parseJsonData(jSONObject.has("endTime"), jSONObject.getString("endTime"), "");
                    signatureTemplateInfo.dot9png = (String) parseJsonData(jSONObject.has("dot9png"), jSONObject.getString("dot9png"), "");
                    signatureTemplateInfo.backgroundColor = (String) parseJsonData(jSONObject.has("backgroundColor"), jSONObject.getString("backgroundColor"), "");
                    parseTlpInfo(signatureTemplateInfo, jSONObject);
                }
            }
        }
    }

    private static Object parseJsonData(boolean z16, Object obj, Object obj2) {
        if (!z16) {
            return obj2;
        }
        return obj;
    }

    private static void parseTlpInfo(SignatureTemplateInfo signatureTemplateInfo, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("cover")) {
            signatureTemplateInfo.cover = jSONObject.getString("cover");
        }
        if (jSONObject.has("aio_2")) {
            signatureTemplateInfo.aio2 = jSONObject.getString("aio_2");
        }
        if (jSONObject.has("aio_3")) {
            signatureTemplateInfo.aio3 = jSONObject.getString("aio_3");
        }
        if (jSONObject.has("aio_4")) {
            signatureTemplateInfo.aio4 = jSONObject.getString("aio_4");
        }
        if (jSONObject.has("icon")) {
            signatureTemplateInfo.icon = jSONObject.getString("icon");
        }
        if (jSONObject.has("view")) {
            signatureTemplateInfo.view = jSONObject.getString("view");
        }
        if (jSONObject.has("action_off")) {
            signatureTemplateInfo.actionOff = jSONObject.getString("action_off");
        }
        if (jSONObject.has("action_on")) {
            signatureTemplateInfo.actionOn = jSONObject.getString("action_on");
        }
    }

    @Nullable
    private static String readFileString(File file) {
        try {
            String readFileToStringEx = FileUtils.readFileToStringEx(file, -1);
            if (readFileToStringEx == null) {
                return null;
            }
            return readFileToStringEx;
        } catch (OutOfMemoryError e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "read config fail", e16);
            }
            return null;
        }
    }

    private static void setImgItem(SignatureTemplateInfo signatureTemplateInfo, JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("imgItem");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(0);
            Objects.requireNonNull(signatureTemplateInfo);
            SignatureTemplateInfo.ImageItem imageItem = new SignatureTemplateInfo.ImageItem();
            imageItem.content = jSONObject2.optString("content");
            imageItem.imgUrl = jSONObject2.optString("img");
            imageItem.width = jSONObject2.optInt("imgWidth");
            imageItem.height = jSONObject2.optInt("imgHeight");
            imageItem.coverUrl = jSONObject2.optString("imgCover");
            signatureTemplateInfo.imageItem = imageItem;
        }
    }

    private static void setSigTlpInfo(SignatureTemplateInfo signatureTemplateInfo, JSONObject jSONObject) {
        int i3;
        int optInt = jSONObject.optInt("aio_rows", -1);
        if (optInt == 0 || (optInt > 1 && optInt < 6)) {
            if (optInt == 0) {
                i3 = optInt;
            } else {
                i3 = optInt - 1;
            }
            SignatureTemplateInfo.DynamicItem dynamicItem = signatureTemplateInfo.dynamicItem[i3];
            dynamicItem.aioRows = optInt;
            dynamicItem.pngZip = jSONObject.optString("pngZip");
            signatureTemplateInfo.dynamicItem[i3].posX = (float) jSONObject.optDouble("posX", 0.0d);
            signatureTemplateInfo.dynamicItem[i3].posY = (float) jSONObject.optDouble("posY", 0.0d);
            signatureTemplateInfo.dynamicItem[i3].width = (float) jSONObject.optDouble("width", 0.0d);
            signatureTemplateInfo.dynamicItem[i3].height = (float) jSONObject.optDouble("height", 0.0d);
            signatureTemplateInfo.dynamicItem[i3].repeatTimes = jSONObject.optInt("repeatTimes", 0);
            signatureTemplateInfo.dynamicItem[i3].interval = jSONObject.optInt(WidgetCacheConstellationData.INTERVAL, 0);
        }
    }
}
