package com.tencent.ttpic.openapi.manager;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.initializer.ImageAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.LightSdkInitializer;
import com.tencent.ttpic.openapi.initializer.PagInitializer;
import com.tencent.ttpic.openapi.initializer.PtuAlgoInitializer;
import com.tencent.ttpic.openapi.initializer.PtuToolsInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import java.io.File;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FeatureManager {
    private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
    private static final String TAG = "FeatureManager";
    private static boolean enableResourceCheck = false;
    private static boolean enableSoLoadCheck = true;
    private static String filamentDir;
    private static String pagDir;
    private static String resourceDir;
    private static String soDir;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Features {
        public static final YTCommonInitializer YT_COMMON = new YTCommonInitializer();
        public static final PtuToolsInitializer PTU_TOOLS = new PtuToolsInitializer();
        public static final PtuAlgoInitializer PTU_ALGO = new PtuAlgoInitializer();
        public static final PagInitializer PAG = new PagInitializer();
        public static final ImageAlgoInitializer IMAGE_ALGO = new ImageAlgoInitializer();
        public static final LightSdkInitializer LIGHT_SDK = new LightSdkInitializer();
    }

    public static void createNoMedia() {
        try {
            Context context = AEModule.getContext();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(FileUtils.genSeperateFileDir(context.getExternalFilesDir(null).getPath()));
            sb5.append("Tencent");
            String str = File.separator;
            sb5.append(str);
            sb5.append("aekit");
            String sb6 = sb5.toString();
            File file = new File(sb6);
            if (!file.exists() && !file.mkdirs()) {
                LogUtils.e(TAG, "FeatureManager create dir fail : " + sb6);
            }
            File file2 = new File(sb6 + str + ".nomedia");
            if (!file2.exists()) {
                file2.createNewFile();
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void enableResourceCheck(boolean z16) {
        enableResourceCheck = z16;
    }

    public static void enableSoLoadCheck(boolean z16) {
        enableSoLoadCheck = z16;
    }

    public static boolean ensureMaterialSoLoaded(VideoMaterial videoMaterial) {
        if (videoMaterial == null) {
            return true;
        }
        LightSdkInitializer lightSdkInitializer = Features.LIGHT_SDK;
        if (lightSdkInitializer.isFunctionReady()) {
            return true;
        }
        return lightSdkInitializer.init();
    }

    public static String getFilamentDir() {
        return filamentDir;
    }

    public static String getPagDir() {
        return pagDir;
    }

    public static String getResourceDir() {
        return resourceDir;
    }

    public static String getSoDir() {
        return soDir;
    }

    @Deprecated
    public static boolean isBasicFeaturesFunctionReady() {
        return isBasicFeaturesReadyInHostProcess();
    }

    public static boolean isBasicFeaturesReadyInDir(String str) {
        return Features.LIGHT_SDK.isSoReadyInDirectory(str) & Features.YT_COMMON.isSoReadyInDirectory(str) & Features.PTU_ALGO.isSoReadyInDirectory(str) & Features.PTU_TOOLS.isSoReadyInDirectory(str);
    }

    public static boolean isBasicFeaturesReadyInHostProcess() {
        if (Features.YT_COMMON.isFunctionReady() && Features.PTU_TOOLS.isFunctionReady() && Features.PTU_ALGO.isFunctionReady() && Features.LIGHT_SDK.isFunctionReady()) {
            return true;
        }
        return false;
    }

    public static boolean isEnableResourceCheck() {
        return enableResourceCheck;
    }

    public static boolean isEnableSoLoadCheck() {
        return enableSoLoadCheck;
    }

    public static boolean loadBasicFeatures(boolean z16) {
        if (AEModule.isAeKitSupportVersion()) {
            return Features.PTU_TOOLS.init() & (z16 ? true & Features.YT_COMMON.init() : true) & Features.PTU_ALGO.init() & Features.LIGHT_SDK.init();
        }
        return false;
    }

    public static boolean loadFeaturesOnlyLight() {
        return Features.LIGHT_SDK.init() & true;
    }

    public static void setFilamentDir(String str) {
        if (TextUtils.isEmpty(str)) {
            filamentDir = null;
        } else {
            filamentDir = FileUtils.genSeperateFileDir(str);
        }
    }

    public static void setModelDir(String str) {
        if (TextUtils.isEmpty(str)) {
            resourceDir = null;
        } else {
            resourceDir = FileUtils.genSeperateFileDir(str);
        }
    }

    public static void setPagDir(String str) {
        if (TextUtils.isEmpty(str)) {
            pagDir = null;
        } else {
            pagDir = FileUtils.genSeperateFileDir(str);
        }
    }

    public static void setSoDir(String str) {
        if (TextUtils.isEmpty(str)) {
            soDir = null;
        } else {
            soDir = FileUtils.genSeperateFileDir(str);
        }
    }

    public static boolean loadBasicFeatures() {
        return loadBasicFeatures(true);
    }
}
