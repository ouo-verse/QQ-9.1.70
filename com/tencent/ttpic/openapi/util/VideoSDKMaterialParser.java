package com.tencent.ttpic.openapi.util;

import com.tencent.ttpic.openapi.model.VideoMaterial;

/* loaded from: classes27.dex */
public class VideoSDKMaterialParser {
    public static VideoMaterial parseVideoMaterial(String str, String str2) {
        return VideoTemplateParser.parseVideoMaterial(str);
    }

    public static VideoMaterial parseVideoMaterialForEdit(String str, String str2) {
        return VideoTemplateParser.parseVideoMaterialForEdit(str);
    }
}
