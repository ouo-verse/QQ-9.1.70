package org.light;

import org.light.LightConstants;
import org.light.bean.LightAgentBundleInfo;
import org.light.datasource.LightDataSource;
import org.light.lightAssetKit.components.Size;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightAsset {
    private static final String TAG = "LightAsset";
    private long nativeContext = 0;
    private int errorCode = 0;

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    public static LightAsset Load(String str, int i3) {
        return nativeLoad(str, i3);
    }

    public static LightAsset LoadFromString(String str, String str2, int i3) {
        return nativeLoadFromString(str, str2, i3);
    }

    private native long nativeDefaultFragmentDuration();

    private native void nativeFinalize();

    private native boolean nativeForbiddenBasicMakeup();

    private native boolean nativeForbiddenBasicNonReshapeBeauty();

    private native boolean nativeForbiddenBasicReshape();

    private native boolean nativeForbiddenBasicSmooth();

    private native LightDataSource[] nativeGetAllDataSource();

    private native String[] nativeGetBgmMusicIDs();

    private native String[] nativeGetBoundsTrackerPlaceHolders();

    private native int nativeGetDefaultCameraPosition();

    private native int nativeGetFixedExposureTime();

    private native FontAsset[] nativeGetFontAssets();

    private native String nativeGetJsonString();

    private native LUTPlaceHolder[] nativeGetLUTPlaceHolders();

    private native Size nativeGetLightSurfaceSize();

    private native String nativeGetMainPagFilePath();

    private native MaterialConfig[] nativeGetMaterialConfigs();

    private native String nativeGetMaterialID();

    private native TemplateConfig nativeGetMovieConfig();

    private native LightAgentBundleInfo[] nativeGetRenderAgentBundleInfos();

    private native String[] nativeGetRenderAgentTypes();

    private native int nativeGetSupportCameraPosition();

    private native int nativeGetVoiceEnvironment();

    private native int nativeGetVoiceKind();

    private native boolean nativeHasFactorMakeup();

    private native boolean nativeHasLut();

    private native boolean nativeHasMakeup();

    private native boolean nativeHasMesh();

    private native int nativeHeight();

    private static native void nativeInit();

    private native boolean nativeIsFragment();

    private static native LightAsset nativeLoad(String str, int i3);

    private static native LightAsset nativeLoadFromString(String str, String str2, int i3);

    private native boolean nativeNeedLowResolutionInput();

    private native boolean nativeNeedRenderAbility(String str);

    private native boolean nativeNeedRenderAtMaxSize();

    private native boolean nativeNeedResetAssetWhenStartRecord();

    private native boolean nativeNeedUseWideAngleLens();

    private native int nativeWidth();

    public long defaultFragmentDuration() {
        return nativeDefaultFragmentDuration();
    }

    protected void finalize() throws Throwable {
        nativeFinalize();
        super.finalize();
    }

    public boolean forbiddenBasicMakeup() {
        return nativeForbiddenBasicMakeup();
    }

    public boolean forbiddenBasicNonReshapeBeauty() {
        return nativeForbiddenBasicNonReshapeBeauty();
    }

    public boolean forbiddenBasicReshape() {
        return nativeForbiddenBasicReshape();
    }

    public boolean forbiddenBasicSmooth() {
        return nativeForbiddenBasicSmooth();
    }

    public LightDataSource[] getAllDataSource() {
        return nativeGetAllDataSource();
    }

    public String[] getBgmMusicIDs() {
        return nativeGetBgmMusicIDs();
    }

    public String[] getBoundsTrackerPlaceHolders() {
        return nativeGetBoundsTrackerPlaceHolders();
    }

    public int getDefaultCameraPosition() {
        return nativeGetDefaultCameraPosition();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public int getFixedExposureTime() {
        return nativeGetFixedExposureTime();
    }

    public FontAsset[] getFontAssets() {
        return nativeGetFontAssets();
    }

    public String getJsonString() {
        return nativeGetJsonString();
    }

    public LUTPlaceHolder[] getLUTPlaceHolders() {
        return nativeGetLUTPlaceHolders();
    }

    public Size getLightSurfaceSize() {
        Size nativeGetLightSurfaceSize = nativeGetLightSurfaceSize();
        if (nativeGetLightSurfaceSize == null) {
            return new Size(0, 0);
        }
        return nativeGetLightSurfaceSize;
    }

    public String getMainPagFilePath() {
        return nativeGetMainPagFilePath();
    }

    public MaterialConfig[] getMaterialConfigs() {
        return nativeGetMaterialConfigs();
    }

    public String getMaterialID() {
        return nativeGetMaterialID();
    }

    public TemplateConfig getMovieConfig() {
        return nativeGetMovieConfig();
    }

    public LightAgentBundleInfo[] getRenderAgentBundleInfos() {
        return nativeGetRenderAgentBundleInfos();
    }

    public String[] getRenderAgentTypes() {
        return nativeGetRenderAgentTypes();
    }

    public int getSupportCameraPosition() {
        return nativeGetSupportCameraPosition();
    }

    public int getVoiceEnvironment() {
        return nativeGetVoiceEnvironment();
    }

    public int getVoiceKind() {
        return nativeGetVoiceKind();
    }

    public boolean hasFactorMakeup() {
        return nativeHasFactorMakeup();
    }

    public boolean hasLut() {
        return nativeHasLut();
    }

    public boolean hasMakeup() {
        return nativeHasMakeup();
    }

    public boolean hasMesh() {
        return nativeHasMesh();
    }

    public int height() {
        return nativeHeight();
    }

    public boolean isFragment() {
        return nativeIsFragment();
    }

    public boolean needLowResolutionInput() {
        return nativeNeedLowResolutionInput();
    }

    public boolean needRenderAbility(String str) {
        return nativeNeedRenderAbility(str);
    }

    public boolean needRenderAtMaxSize() {
        return nativeNeedRenderAtMaxSize();
    }

    public boolean needResetAssetWhenStartRecord() {
        return nativeNeedResetAssetWhenStartRecord();
    }

    public boolean needUseWideAngleLens() {
        return nativeNeedUseWideAngleLens();
    }

    public boolean needVoiceDecibel() {
        return needRenderAbility(LightConstants.AssetFeatureKey.HAS_VOICE_DECIBEL);
    }

    public void performFinalize() {
        if (this.nativeContext != 0) {
            nativeFinalize();
        }
    }

    public native void setRenderMediaSize(int i3, int i16);

    public int width() {
        return nativeWidth();
    }
}
