package com.tencent.qcircle.weseevideo.model.utils;

import android.text.TextUtils;
import com.tencent.qcircle.oscar.app.GlobalContext;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.qcircle.weseevideo.model.data.MusicMaterialMetaDataBean;
import com.tencent.qcircle.weseevideo.model.effect.MusicModel;
import com.tencent.tavsticker.model.TAVStickerLayerInfo;
import java.io.File;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.device.LightDeviceUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Utils {
    public static final String ONLINE_MATERIAL_FOLDER = "musicdot";
    public static final String ONLINE_MATERIAL_PARENT_FOLDER = "olm";
    public static final String TAG = "Utils";

    public static boolean equals(String str, String str2) {
        if (!TextUtils.isEmpty(str) && TextUtils.equals(str, str2)) {
            return true;
        }
        return false;
    }

    private static String getDir(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        File externalFilesDir = LightDeviceUtils.getExternalFilesDir(GlobalContext.getContext(), ONLINE_MATERIAL_PARENT_FOLDER);
        if (externalFilesDir == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(externalFilesDir.getPath());
        String str = File.separator;
        sb5.append(str);
        sb5.append(ONLINE_MATERIAL_FOLDER);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            Logger.i("Utils", "getDir downloadDir mkdirs result:" + file.mkdirs());
        } else if (!file.isDirectory()) {
            Logger.i("Utils", "getDir, downloadDir delete result:" + file.delete());
            if (!file.mkdirs()) {
                Logger.i("Utils", "getDir, downloadDir mkdir err ");
                return null;
            }
        }
        if (TextUtils.isEmpty(file.getPath())) {
            return null;
        }
        File file2 = new File(file.getPath() + str + musicMaterialMetaDataBean.id);
        if (!file2.exists()) {
            file2.mkdirs();
            Logger.i("Utils", "getDir dir mkdirs result:$r");
        } else if (!file2.isDirectory()) {
            file2.delete();
            Logger.i("Utils", "getDir, dir delete result:$r");
            if (!file2.mkdirs()) {
                Logger.i("Utils", "getDir, dir mkdir err ");
                return null;
            }
        }
        return file2.getPath();
    }

    public static String getPath(MusicMaterialMetaDataBean musicMaterialMetaDataBean) {
        String dir = getDir(musicMaterialMetaDataBean);
        if (TextUtils.isEmpty(dir)) {
            return null;
        }
        String str = musicMaterialMetaDataBean.stuckPointJsonUrl;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return dir + File.separator + MD5Util.getUrlStrMd5(str);
    }

    public static float getPlayVolume(MusicModel musicModel) {
        if (musicModel != null) {
            if (musicModel.getMetaDataBean() == null && !musicModel.isManuallyChangedVolume()) {
                return 1.0f;
            }
            return musicModel.getVolume();
        }
        return 0.0f;
    }

    public static boolean isLayerFillAble(TAVStickerLayerInfo tAVStickerLayerInfo) {
        List<TAVStickerLayerInfo.TAVStickerUserData> userDataList;
        JSONObject jSONObject;
        if (tAVStickerLayerInfo == null || (userDataList = tAVStickerLayerInfo.getUserDataList()) == null || userDataList.isEmpty()) {
            return false;
        }
        for (TAVStickerLayerInfo.TAVStickerUserData tAVStickerUserData : userDataList) {
            if (tAVStickerUserData != null) {
                String data = tAVStickerUserData.getData();
                if (TextUtils.isEmpty(data)) {
                    continue;
                } else {
                    try {
                        jSONObject = new JSONObject(data);
                    } catch (JSONException e16) {
                        Logger.e("Utils", "isLayerFillAble JSONException " + e16.getMessage());
                        e16.printStackTrace();
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        if (jSONObject.optInt("videoTrack", 0) <= 0) {
                            return false;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
