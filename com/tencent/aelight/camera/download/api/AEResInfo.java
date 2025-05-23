package com.tencent.aelight.camera.download.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AEResInfo implements Serializable {
    public static final AEResInfo AE_RES_BASE_PACKAGE;
    public static final List<String> AGENT_TYPES_IN_3DMM_BUNDLE;
    public static final List<String> AGENT_TYPES_IN_FACE_BUNDLE = new ArrayList();
    public static final String AGENT_TYPE_AE_BASE_RES = "AGENT_TYPE_AE_BASE_RES";
    public static final String AGENT_TYPE_BODY_3D_AGENT = "BODY3D_POINT_AGENT";
    public static final String AGENT_TYPE_FILAMENT;
    public static final String AGENT_TYPE_LIGHT_SCENE = "SCENE_CLASSIFY";
    public static final String AGENT_TYPE_LIGHT_SDK_BASE;
    public static final String AGENT_TYPE_PAG;
    public static final String AGENT_TYPE_PIC_QUALITY = "MEDIA_PRECHECK";
    public static final String AGENT_TYPE_TRACK = "TRACK_AGENT";
    public static final String AGENT_TYPE_VIDEO_FILTER = "AGENT_TYPE_VIDEO_FILTER";
    public static final String AGENT_TYPE_Z_PLAN = "kZPLAN_AGENT";
    public static final String FILAMENT_BASIC32 = "FILAMENT_ZPLAN_32";
    public static final String FILAMENT_BASIC64 = "FILAMENT_ZPLAN_64";
    public static final AEResInfo LIGHT_RES_BASE_PACKAGE;
    public static final AEResInfo LIGHT_RES_BUNDLE_3DMM;
    public static final AEResInfo LIGHT_RES_BUNDLE_ACE3D;
    public static final AEResInfo LIGHT_RES_BUNDLE_BG_SEG;
    public static final AEResInfo LIGHT_RES_BUNDLE_BODY;
    public static final AEResInfo LIGHT_RES_BUNDLE_BODY_3D;
    public static final AEResInfo LIGHT_RES_BUNDLE_CAT;
    public static final AEResInfo LIGHT_RES_BUNDLE_DEPTH;
    public static final AEResInfo LIGHT_RES_BUNDLE_EMOTION;
    public static final AEResInfo LIGHT_RES_BUNDLE_FACE;
    public static final AEResInfo LIGHT_RES_BUNDLE_FACE_CLASSIFY;
    public static final AEResInfo LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE;
    public static final AEResInfo LIGHT_RES_BUNDLE_HAND;
    public static final AEResInfo LIGHT_RES_BUNDLE_PIC_ENHANCE;
    public static final AEResInfo LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME;
    public static final AEResInfo LIGHT_RES_BUNDLE_PIC_QUALITY;
    public static final AEResInfo LIGHT_RES_BUNDLE_SCENE;
    public static final AEResInfo LIGHT_RES_BUNDLE_SEG_HAIR;
    public static final AEResInfo LIGHT_RES_BUNDLE_SEG_HEAD;
    public static final AEResInfo LIGHT_RES_BUNDLE_SEG_SKY;
    public static final AEResInfo LIGHT_RES_BUNDLE_TRACK_AGENT;
    public static final AEResInfo LIGHT_RES_BUNDLE_VIDEO_FILTER;
    public static final AEResInfo LIGHT_RES_DEPTH_RELATIVE_AGENT;
    public static final AEResInfo LIGHT_RES_EMOTION_SCORE_AGENT;
    public static final AEResInfo LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT;
    public static final AEResInfo LIGHT_RES_FILAMENT;
    public static final AEResInfo LIGHT_RES_PAG;
    public static final AEResInfo LIGHT_RES_QNN_HTP_BUNDLE;
    public static final AEResInfo LIGHT_RES_SMILE_AGENT;
    public static final String LIGHT_SDK_BASIC32 = "BASIC_32";
    public static final String LIGHT_SDK_BASIC64 = "BASIC_64";
    public static final String PAG_BASIC32 = "PAG_BASIC32";
    public static final String PAG_BASIC64 = "PAG_BASIC64";
    public static final AEResInfo[] values;
    public String agentType;

    @Deprecated
    public final String description;

    @Deprecated
    public final int index;

    @Deprecated
    public boolean isPredownload = true;

    @Deprecated
    public final int resVersionLimit = 8855013;

    @Deprecated
    public final int resVersion = 8855;

    @Deprecated
    public final boolean isPackage = true;

    static {
        ArrayList arrayList = new ArrayList();
        AGENT_TYPES_IN_3DMM_BUNDLE = arrayList;
        AGENT_TYPE_LIGHT_SDK_BASE = LIGHT_SDK_BASIC64;
        AGENT_TYPE_FILAMENT = FILAMENT_BASIC64;
        AGENT_TYPE_PAG = PAG_BASIC64;
        arrayList.add("k3D_MM_AGENT_V2");
        arrayList.add("kZPLAN_AGENT");
        AEResInfo aEResInfo = new AEResInfo(0, "AEBasePackage", AGENT_TYPE_AE_BASE_RES);
        AE_RES_BASE_PACKAGE = aEResInfo;
        AEResInfo aEResInfo2 = new AEResInfo(1, "LightBasePackage", LIGHT_SDK_BASIC64);
        LIGHT_RES_BASE_PACKAGE = aEResInfo2;
        AEResInfo aEResInfo3 = new AEResInfo(27, "", FILAMENT_BASIC64);
        LIGHT_RES_FILAMENT = aEResInfo3;
        AEResInfo aEResInfo4 = new AEResInfo(28, "", PAG_BASIC64);
        LIGHT_RES_PAG = aEResInfo4;
        AEResInfo aEResInfo5 = new AEResInfo(2, "LightBundleHand", "HAND_AGENT");
        LIGHT_RES_BUNDLE_HAND = aEResInfo5;
        AEResInfo aEResInfo6 = new AEResInfo(3, "LightBundleFaceStaticFeature", LightConstants.AgentType.FACE_STATIC_FEATURE_AGENT);
        LIGHT_RES_BUNDLE_FACE_STATIC_FEATURE = aEResInfo6;
        AEResInfo aEResInfo7 = new AEResInfo(4, "LightBundleCat", "CAT_AGENT");
        LIGHT_RES_BUNDLE_CAT = aEResInfo7;
        AEResInfo aEResInfo8 = new AEResInfo(5, "LightBundleDepth", "DEPTH_AGENT");
        LIGHT_RES_BUNDLE_DEPTH = aEResInfo8;
        AEResInfo aEResInfo9 = new AEResInfo(6, "LightBundleSegHair", "HAIR_SEG_AGENT");
        LIGHT_RES_BUNDLE_SEG_HAIR = aEResInfo9;
        AEResInfo aEResInfo10 = new AEResInfo(7, "LightBundleSegSky", "SKY_SEG_AGENT");
        LIGHT_RES_BUNDLE_SEG_SKY = aEResInfo10;
        AEResInfo aEResInfo11 = new AEResInfo(8, "LightBundleAce3D", "Ace_3d_Engine");
        LIGHT_RES_BUNDLE_ACE3D = aEResInfo11;
        AEResInfo aEResInfo12 = new AEResInfo(9, "LightBundle3DMM", "k3D_MM_AGENT");
        LIGHT_RES_BUNDLE_3DMM = aEResInfo12;
        AEResInfo aEResInfo13 = new AEResInfo(10, "LightBundleSegHead", "HEAD_SEG_AGENT");
        LIGHT_RES_BUNDLE_SEG_HEAD = aEResInfo13;
        AEResInfo aEResInfo14 = new AEResInfo(11, "LightBundleScene", "SCENE_CLASSIFY");
        LIGHT_RES_BUNDLE_SCENE = aEResInfo14;
        AEResInfo aEResInfo15 = new AEResInfo(12, "LightBundleEmotion", "EMOTION_AGENT");
        LIGHT_RES_BUNDLE_EMOTION = aEResInfo15;
        AEResInfo aEResInfo16 = new AEResInfo(13, "LightBundleBody", "BODY_AGENT");
        LIGHT_RES_BUNDLE_BODY = aEResInfo16;
        AEResInfo aEResInfo17 = new AEResInfo(14, "LightBundleBody3D", "BODY3D_POINT_AGENT");
        LIGHT_RES_BUNDLE_BODY_3D = aEResInfo17;
        AEResInfo aEResInfo18 = new AEResInfo(15, "LightBundlePicEnhance", LightConstants.AgentType.PIC_ENHANCE_AGENT);
        LIGHT_RES_BUNDLE_PIC_ENHANCE = aEResInfo18;
        AEResInfo aEResInfo19 = new AEResInfo(16, "LightBundlePicQuality", "MEDIA_PRECHECK");
        LIGHT_RES_BUNDLE_PIC_QUALITY = aEResInfo19;
        AEResInfo aEResInfo20 = new AEResInfo(17, "LightBundleFace", "FACE_AGENT");
        LIGHT_RES_BUNDLE_FACE = aEResInfo20;
        AEResInfo aEResInfo21 = new AEResInfo(18, "LightBundleFaceClassify", LightConstants.AgentType.FACE_CLASSIFY_AGENT);
        LIGHT_RES_BUNDLE_FACE_CLASSIFY = aEResInfo21;
        AEResInfo aEResInfo22 = new AEResInfo(19, "LightBundleVideoFilter", AGENT_TYPE_VIDEO_FILTER);
        LIGHT_RES_BUNDLE_VIDEO_FILTER = aEResInfo22;
        AEResInfo aEResInfo23 = new AEResInfo(20, "", "BG_SEG_AGENT");
        LIGHT_RES_BUNDLE_BG_SEG = aEResInfo23;
        AEResInfo aEResInfo24 = new AEResInfo(21, "", LightConstants.AgentType.REALTIME_PIC_ENHANCE_AGENT);
        LIGHT_RES_BUNDLE_PIC_ENHANCE_REALTIME = aEResInfo24;
        AEResInfo aEResInfo25 = new AEResInfo(22, "LightTrackSticker", "TRACK_AGENT");
        LIGHT_RES_BUNDLE_TRACK_AGENT = aEResInfo25;
        AEResInfo aEResInfo26 = new AEResInfo(23, "", LightConstants.AgentType.DEPTH_RELATIVE_AGENT);
        LIGHT_RES_DEPTH_RELATIVE_AGENT = aEResInfo26;
        AEResInfo aEResInfo27 = new AEResInfo(24, "", "SMILE_AGENT");
        LIGHT_RES_SMILE_AGENT = aEResInfo27;
        AEResInfo aEResInfo28 = new AEResInfo(25, "", LightConstants.AgentType.EMOTION_SCOER_AGENT);
        LIGHT_RES_EMOTION_SCORE_AGENT = aEResInfo28;
        LIGHT_RES_FACE_3D_MM_AGENT_V2_AGENT = new AEResInfo(26, "", "k3D_MM_AGENT_V2");
        AEResInfo aEResInfo29 = new AEResInfo(27, "LightQnnHtp", LightConstants.AgentType.QNN_HTP_BUNDLE);
        LIGHT_RES_QNN_HTP_BUNDLE = aEResInfo29;
        values = new AEResInfo[]{aEResInfo3, aEResInfo4, aEResInfo, aEResInfo2, aEResInfo20, aEResInfo23, aEResInfo25, aEResInfo21, aEResInfo5, aEResInfo6, aEResInfo7, aEResInfo8, aEResInfo9, aEResInfo10, aEResInfo11, aEResInfo12, aEResInfo13, aEResInfo14, aEResInfo16, aEResInfo17, aEResInfo15, aEResInfo18, aEResInfo19, aEResInfo22, aEResInfo24, aEResInfo26, aEResInfo27, aEResInfo28, aEResInfo29};
    }

    AEResInfo(int i3, String str, String str2) {
        this.index = i3;
        this.description = str;
        this.agentType = str2;
    }

    @Deprecated
    public static AEResInfo getAEResInfoByPrefix(String str) {
        return null;
    }

    public static boolean isAdditionPackage(AEResInfo aEResInfo) {
        if (aEResInfo != null && aEResInfo.index > 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "{index:" + this.index + ", description:" + this.description + ", resVersionLimit:" + this.resVersionLimit + ", resVersion:" + this.resVersion + ", isPackage:" + this.isPackage + "}";
    }
}
