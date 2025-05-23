package com.tencent.ttpic.params;

import android.util.Log;
import java.util.Map;
import org.light.CameraConfig;
import org.light.CameraController;
import org.light.LightConstants;

/* compiled from: P */
@Deprecated
/* loaded from: classes27.dex */
public class BeautyController {
    static final String LIPS_STRENGTH_DEFULT = "0";
    public static final int MAKEUP_TYPE_BEAUTY_MULTIPLY = 3;
    public static final int MAKEUP_TYPE_LIPS = 1;
    public static final int MAKEUP_TYPE_SOFT_LIGHT = 2;
    static final String MULTIPLY_STRENGTH_DEFAULT = "0";
    static final String SOFTLIGHT_STRENGTH_DEFAULT = "0";
    private static final String TAG = "BeautyController";
    private CameraController cameraController;
    private CameraConfig config;
    protected Map<String, String> configData;

    public BeautyController(Map<String, String> map) {
        this.configData = map;
    }

    public void enableAssetBeautyMakeup(int i3, boolean z16) {
        String str = "true";
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Map<String, String> map = this.configData;
                    if (!z16) {
                        str = "false";
                    }
                    map.put(LightConstants.BasicSwitchKey.MATERIAL_MAKEUP_MULTIPLY_ENABLE, str);
                }
            } else {
                Map<String, String> map2 = this.configData;
                if (!z16) {
                    str = "false";
                }
                map2.put(LightConstants.BasicSwitchKey.MATERIAL_SOFT_LIGHT_ENABLE, str);
            }
        } else {
            Map<String, String> map3 = this.configData;
            if (!z16) {
                str = "false";
            }
            map3.put(LightConstants.BasicSwitchKey.MATERIAL_LIPS_ENABLE, str);
        }
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void enableBasicBeautyMakeup(int i3, boolean z16) {
        String str = "true";
        if (z16) {
            this.configData.put("beauty.faceFeature.enable", "true");
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Map<String, String> map = this.configData;
                    if (!z16) {
                        str = "false";
                    }
                    map.put("beauty.makeupMultiply.enable", str);
                }
            } else {
                Map<String, String> map2 = this.configData;
                if (!z16) {
                    str = "false";
                }
                map2.put("beauty.softLight.enable", str);
            }
        } else {
            Map<String, String> map3 = this.configData;
            if (!z16) {
                str = "false";
            }
            map3.put("beauty.lips.enable", str);
        }
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String formatDecimalValue(int i3) {
        return Float.toString(i3 / 100.0f);
    }

    public boolean isAssetHasMakeUp(int i3) {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            return cameraController.hasSpecificMakeUpType(i3);
        }
        return false;
    }

    public void openAndUpdateBasicLips(String str, int i3, int i16) {
        enableAssetBeautyMakeup(1, false);
        enableBasicBeautyMakeup(1, true);
        this.configData.put("beauty.faceFeatureLipsLut", formatDecimalValue(i3));
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_LIPS_LIPS_MASK, str);
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_LIPS_LIPS_TYPE, String.valueOf(i16));
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void openAndUpdateBasicMultiply(String str, int i3) {
        enableAssetBeautyMakeup(3, false);
        enableBasicBeautyMakeup(3, true);
        this.configData.put("beauty.faceFeature.enable", "true");
        this.configData.put("beauty.faceFeatureRedCheek", formatDecimalValue(i3));
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_MAKEUP_MULTIPLY_MULTIPLY_MASK, str);
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void openAndUpdateBasicSoftLight(String str, int i3) {
        enableAssetBeautyMakeup(2, false);
        enableBasicBeautyMakeup(2, true);
        this.configData.put("beauty.faceFeature.enable", "true");
        this.configData.put("beauty.faceFeatureSoftlight", formatDecimalValue(i3));
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_SOFTLIGHT_SOFTLIGHT_MASK, str);
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void setBeautyLipsLevel(int i3) {
        this.configData.put("beauty.faceFeatureLipsLut", formatDecimalValue(i3));
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void setBeautyMultiplyLevel(int i3) {
        this.configData.put("beauty.faceFeatureRedCheek", formatDecimalValue(i3));
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void setBeautyMultiplyMask(String str) {
        this.configData.put("beauty.faceFeature.enable", "true");
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_MAKEUP_MULTIPLY_MULTIPLY_MASK, str);
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void setBeautySoftLevel(int i3) {
        this.configData.put("beauty.faceFeatureSoftlight", formatDecimalValue(i3));
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void setCameraConfig(CameraConfig cameraConfig) {
        this.config = cameraConfig;
        cameraConfig.setConfigData(this.configData);
    }

    public void setCameraController(CameraController cameraController) {
        this.cameraController = cameraController;
    }

    public void setLipsLut(String str, int i3) {
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_LIPS_LIPS_MASK, str);
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_LIPS_LIPS_TYPE, String.valueOf(i3));
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
        Log.d(TAG, "setLipsLut " + str);
    }

    public void setSoftLightMask(String str) {
        this.configData.put("beauty.faceFeature.enable", "true");
        this.configData.put(LightConstants.BeautyConfigKey.BEAUTY_SOFTLIGHT_SOFTLIGHT_MASK, str);
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }

    public void setStrength(int i3, float f16) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.configData.put("beauty.faceFeatureRedCheek", String.valueOf(f16));
                }
            } else {
                this.configData.put("beauty.faceFeatureSoftlight", String.valueOf(f16));
            }
        } else {
            this.configData.put("beauty.faceFeatureLipsLut", String.valueOf(f16));
        }
        CameraConfig cameraConfig = this.config;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(this.configData);
        }
    }
}
