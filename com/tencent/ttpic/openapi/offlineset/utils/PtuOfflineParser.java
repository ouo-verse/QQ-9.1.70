package com.tencent.ttpic.openapi.offlineset.utils;

import com.google.gson.reflect.TypeToken;
import com.tencent.ttpic.offlineset.beans.AEKitDownSetting;
import com.tencent.ttpic.offlineset.beans.AIBeautyConfigJsonBean;
import com.tencent.ttpic.offlineset.beans.AIBeautyParamsJsonBean;
import com.tencent.ttpic.offlineset.beans.DeviceDownConfigJsonBean;
import com.tencent.ttpic.util.GsonUtils;

/* loaded from: classes27.dex */
public class PtuOfflineParser {
    private static PtuOfflineParser sParser;

    public static PtuOfflineParser getInstance() {
        if (sParser == null) {
            sParser = new PtuOfflineParser();
        }
        return sParser;
    }

    public AIBeautyParamsJsonBean getDefaultAIBeautyParam() {
        return parseAIBeautyParam("camera/camera_video/configsetting/beauty.json", true);
    }

    public AEKitDownSetting parseAEKitDownSetting(String str) {
        if (str == null) {
            return null;
        }
        return (AEKitDownSetting) GsonUtils.json2Obj(str, new TypeToken<AEKitDownSetting>() { // from class: com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser.4
        }.getType());
    }

    public AIBeautyConfigJsonBean parseAIBeautyConfig(String str) {
        if (str == null) {
            return null;
        }
        return (AIBeautyConfigJsonBean) GsonUtils.json2Obj(str, new TypeToken<AIBeautyConfigJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser.2
        }.getType());
    }

    public AIBeautyParamsJsonBean parseAIBeautyParam(String str, boolean z16) {
        String readJsonStringFromFile;
        if (z16) {
            readJsonStringFromFile = FileOfflineUtil.readStringFromAssets(str);
        } else {
            readJsonStringFromFile = FileOfflineUtil.readJsonStringFromFile(str);
        }
        if (readJsonStringFromFile == null) {
            return null;
        }
        return (AIBeautyParamsJsonBean) GsonUtils.json2Obj(readJsonStringFromFile, new TypeToken<AIBeautyParamsJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser.1
        }.getType());
    }

    public DeviceDownConfigJsonBean parseDeviceDownConfig(String str) {
        if (str == null) {
            return null;
        }
        return (DeviceDownConfigJsonBean) GsonUtils.json2Obj(str, new TypeToken<DeviceDownConfigJsonBean>() { // from class: com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser.3
        }.getType());
    }

    public AEKitDownSetting.DownResInfo parseDownResInfo(String str) {
        if (str == null) {
            return null;
        }
        return (AEKitDownSetting.DownResInfo) GsonUtils.json2Obj(str, new TypeToken<AEKitDownSetting.DownResInfo>() { // from class: com.tencent.ttpic.openapi.offlineset.utils.PtuOfflineParser.5
        }.getType());
    }
}
