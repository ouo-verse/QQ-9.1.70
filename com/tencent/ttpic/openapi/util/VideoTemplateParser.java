package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.VideoMaterial;

/* loaded from: classes27.dex */
public class VideoTemplateParser {
    public static final String DELAYED_TIP = "delayTips";
    public static final String DOUBLE_POUBLE = "isDualPeople";
    public static final String ENABLE_FACE_DETECT = "enableFaceDetect";
    public static final String FACE_DETECT_TYPE = "faceDetectorType";
    public static final int FaceDetector_FaceU = 0;
    public static final int FaceDetector_Ulsee = 1;
    public static final String ITEM_LIST = "itemList";
    public static final String ITEM_TIPS = "itemTips";
    public static final String POSTFIX_DAT = "dat";
    private static final String POSTFIX_JSON = "json";
    private static final String TAG = "VideoTemplateParser";

    public static VideoMaterial parseVideoMaterial(String str) {
        return VideoMaterial.loadLightAsset(str);
    }

    public static VideoMaterial parseVideoMaterialForEdit(String str) {
        return parseVideoMaterial(str);
    }
}
