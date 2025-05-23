package com.tencent.ttpic.openapi.filter;

import android.graphics.PointF;
import android.hardware.SensorEvent;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.openrender.internal.AEChainI;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.ttpic.CommonUtils;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.openapi.PTFaceAttr;
import com.tencent.ttpic.openapi.TransformUtils;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.ttpic.openapi.listener.LightNodeAppliedListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.libpag.VideoDecoder;
import org.light.AudioFrame;
import org.light.AudioOutput;
import org.light.AudioPlaceHolder;
import org.light.CameraConfig;
import org.light.CameraController;
import org.light.Config;
import org.light.DebugUtils;
import org.light.DeviceCameraConfig;
import org.light.LightAsset;
import org.light.LightConstants;
import org.light.LightEngine;
import org.light.LightSurface;
import org.light.MaterialConfig;
import org.light.PerformanceMonitor;
import org.light.PhotoClip;
import org.light.RendererConfig;
import org.light.VideoOutput;
import org.light.WatermarkConfig;
import org.light.avatar.AvatarAIInfo;
import org.light.bean.ExposureInfo;
import org.light.bean.LightAIDataWrapper;
import org.light.bean.WMElement;
import org.light.callback.ExternalRenderCallback;
import org.light.listener.OnClickWatermarkListener;
import org.light.listener.OnLoadAssetListener;
import org.light.listener.OnTipsStatusListener;
import org.light.listener.OnWatermarkDataListener;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LightNode extends AEChainI {
    private static final int FRAME_INTERN_TIME = 80000;
    public static final int LIGHT_TIP_TYPE_NORMAL = 0;
    public static final int LIGHT_TIP_TYPE_PAG = 1;
    public static final String TAG = "LightNode";
    private static String assetsDir;
    private static String emptyMaterialPath;
    private Map<String, String> aiSwitchMap;
    LightNodeAppliedListener appliedListener;
    private LightAsset asset;
    private boolean assetFixedRenderSize;
    private String assetPath;
    private AudioFrame audioFrame;
    private AudioOutput audioReader;
    private boolean avatarMode;
    private HashMap<String, String> bundlePathMap;
    private CameraConfig cameraConfig;
    private CameraController cameraController;
    private CameraConfig.DeviceCameraOrientation cameraOrientation;
    private boolean cameraOrientationChanged;
    final String defaultSmoothVersion;
    private HashMap<String, Integer> detectShorterLengthMap;
    private DeviceCameraConfig deviceCameraConfig;
    private CameraConfig.ImageOrigin inputOrigin;
    private boolean isBgmHidden;
    private boolean isPicNeedFlip;
    private boolean isRealtime;
    private int lastRenderHeight;
    private int lastRenderWidth;
    private LightEngine lightEngine;
    private LightSurface lightSurface;
    private boolean mAutoTest;
    private ILightNodeCameraExposureListener mCameraExposureListener;
    private VideoFilterBase mCopyFilter;
    private Frame mCopyFrame;
    private int mFrameIndex;
    private OnLoadAssetListener mLightAssetListener;
    private boolean mNeedSetBundle;
    private ILightNodeTipsListener mTipsListener;
    private OnClickWatermarkListener mWatermarkClickListener;
    private boolean needDowngrade;
    private boolean needInitBodySegment;
    private boolean needLowEndDownGrade;
    private boolean orientationChanged;
    int[] outTexs;
    private int previewHeight;
    private int previewWidth;
    private SensorEvent sensorEvent;
    private long startTime;
    private VideoOutput videoOutput;
    private WatermarkConfig watermarkConfig;
    HashMap<String, OnWatermarkDataListener> wmDelegateMap;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ILightNodeCameraExposureListener {
        void onChangeExposureInfo(ExposureInfo exposureInfo);

        void onFetchExposureInfo(ExposureInfo exposureInfo);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ILightNodeTipsListener {
        void onHideNormalTip();

        void onHidePagTip();

        void onShowNormalTip(String str, String str2, int i3);

        void onShowPagTip(String str, int i3);
    }

    public LightNode() {
        this("defaultBeautyV6.json", false, true, null, false);
    }

    private void addSwitchMap(Map<String, String> map) {
        Map<String, String> map2 = this.aiSwitchMap;
        if (map2 != null) {
            map.putAll(map2);
        }
    }

    public static String getEmptyMaterialPath() {
        return emptyMaterialPath;
    }

    public static int initLightEngineAuth(String str, String str2, String str3) {
        return LightEngine.initAuth(AEModule.getContext(), str3, str, str2);
    }

    public static void initResourcePath(String str, String str2) {
        LogUtils.d(TAG, "[initResourcePath] dirPath = " + str + " materialPath = " + str2);
        assetsDir = str;
        emptyMaterialPath = str2;
    }

    private void iterateSetShorterEdgeFromMap() {
        HashMap<String, Integer> hashMap = this.detectShorterLengthMap;
        if (hashMap != null) {
            for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                setDetectShortLength(entry.getKey(), entry.getValue().intValue());
            }
        }
    }

    private CameraController setAssetForCamera() {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.setDisableRendererFlag(this.avatarMode);
        }
        return this.lightEngine.setAssetForCamera(this.asset);
    }

    private void setBundleToLightEngine(String str, String str2) {
        if (str != null && str2 != null) {
            LogUtils.i(TAG, "setBundleToLightEngine " + str2);
            this.cameraConfig.setLightAIModelPath(str, str2);
        }
    }

    private void setFaceDetectLengthByDevice() {
        try {
            if (DeviceInstance.getInstance().getDeviceName() == null) {
                return;
            }
            String trim = DeviceInstance.getInstance().getDeviceName().toLowerCase().trim();
            Log.d(TAG, "setFaceDetectByDevice:" + trim);
            for (DeviceInstance.DEVICE_GENERAL_SIZE device_general_size : DeviceInstance.DEVICE_GENERAL_SIZE.values()) {
                if (trim.endsWith(device_general_size.device.toLowerCase()) && this.cameraConfig != null) {
                    Log.w(TAG, "general detect setFaceDetectLengthByDevice " + trim + ", " + device_general_size.size);
                    this.cameraConfig.setDetectShorterEdgeLength(device_general_size.size, "");
                }
            }
            for (DeviceInstance.DEVICE_DETECT_FACE device_detect_face : DeviceInstance.DEVICE_DETECT_FACE.values()) {
                if (trim.endsWith(device_detect_face.device.toLowerCase()) && this.cameraConfig != null) {
                    Log.w(TAG, "face detect setFaceDetectLengthByDevice " + trim + ", " + device_detect_face.faceDetectSize);
                    this.cameraConfig.setDetectShorterEdgeLength(device_detect_face.faceDetectSize, "FACE_AGENT");
                }
            }
        } catch (Exception e16) {
            Log.e(TAG, "setFaceDetectByDevice:" + e16.getMessage());
        }
    }

    private void setListenersForConfig() {
        Log.d(TAG, "setListenersForConfig: ");
        this.cameraConfig.setOnClickWatermarkListener(new OnClickWatermarkListener() { // from class: com.tencent.ttpic.openapi.filter.LightNode.1
            @Override // org.light.listener.OnClickWatermarkListener
            public void onClickWatermark() {
                if (LightNode.this.mWatermarkClickListener != null) {
                    LightNode.this.mWatermarkClickListener.onClickWatermark();
                }
            }
        });
        HashMap<String, OnWatermarkDataListener> hashMap = this.wmDelegateMap;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, OnWatermarkDataListener> entry : this.wmDelegateMap.entrySet()) {
                if (entry != null) {
                    LogUtils.d(TAG, "\u6ce8\u5165\u6c34\u5370Delegate\uff1a" + entry.getKey() + "|" + entry.getValue());
                    this.cameraConfig.setWatermarkDataListener(entry.getKey(), entry.getValue());
                }
            }
        }
        this.cameraConfig.setTipsStatusListener(new OnTipsStatusListener() { // from class: com.tencent.ttpic.openapi.filter.LightNode.2
            @Override // org.light.listener.OnTipsStatusListener
            public void tipsNeedHide(String str, String str2, int i3) {
                Log.d(LightNode.TAG, "tipsNeedHide: tips=" + str + ", icon=" + str2 + ", type=" + i3);
                if (LightNode.this.mTipsListener != null) {
                    if (i3 == 0) {
                        LightNode.this.mTipsListener.onHideNormalTip();
                    } else if (i3 == 1) {
                        LightNode.this.mTipsListener.onHidePagTip();
                    }
                }
            }

            @Override // org.light.listener.OnTipsStatusListener
            public void tipsNeedShow(String str, String str2, int i3, int i16) {
                Log.d(LightNode.TAG, "tipsNeedShow: tips=" + str + ", icon=" + str2 + ", type=" + i3 + ", duration=" + i16);
                if (LightNode.this.mTipsListener != null) {
                    if (i3 == 0) {
                        LightNode.this.mTipsListener.onShowNormalTip(str, str2, i16);
                    } else if (i3 == 1) {
                        LightNode.this.mTipsListener.onShowPagTip(str2, i16);
                    }
                }
            }
        });
        this.cameraConfig.setLoadAssetListener(new OnLoadAssetListener() { // from class: com.tencent.ttpic.openapi.filter.LightNode.3
            @Override // org.light.listener.OnLoadAssetListener
            public void OnAssetProcessing(HashMap<String, String> hashMap2) {
                Log.d(LightNode.TAG, "OnAssetProcessing: " + hashMap2);
                if (LightNode.this.mLightAssetListener != null) {
                    LightNode.this.mLightAssetListener.OnAssetProcessing(hashMap2);
                }
            }

            @Override // org.light.listener.OnLoadAssetListener
            public void OnLoadAssetError(int i3) {
                Log.d(LightNode.TAG, "OnLoadAssetError: " + i3);
                if (LightNode.this.mLightAssetListener != null) {
                    LightNode.this.mLightAssetListener.OnLoadAssetError(i3);
                }
            }

            @Override // org.light.listener.OnLoadAssetListener
            public void OnAssetDurationChange(long j3) {
            }
        });
        this.cameraConfig.setManualExposureCallback(new CameraConfig.ManualExposureCallback() { // from class: com.tencent.ttpic.openapi.filter.LightNode.4
            @Override // org.light.CameraConfig.ManualExposureCallback
            public void onChangeExposureInfo(ExposureInfo exposureInfo) {
                if (LightNode.this.mCameraExposureListener != null) {
                    LightNode.this.mCameraExposureListener.onChangeExposureInfo(exposureInfo);
                }
            }

            @Override // org.light.CameraConfig.ManualExposureCallback
            public void onFetchExposureInfo(ExposureInfo exposureInfo) {
                if (LightNode.this.mCameraExposureListener != null) {
                    LightNode.this.mCameraExposureListener.onFetchExposureInfo(exposureInfo);
                }
            }
        });
    }

    private void updateRenderSize(int i3, int i16) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null && i3 != 0 && i16 != 0) {
            if (i3 != this.lastRenderWidth || i16 != this.lastRenderHeight) {
                this.lastRenderWidth = i3;
                this.lastRenderHeight = i16;
                cameraConfig.setRenderSize(i3, i16);
            }
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void apply() {
        String str;
        if (isApplied()) {
            return;
        }
        if (!TextUtils.isEmpty(assetsDir) && !TextUtils.isEmpty(emptyMaterialPath)) {
            int[] iArr = this.outTexs;
            GLES20.glGenTextures(iArr.length, iArr, 0);
            RendererConfig rendererConfig = new RendererConfig(assetsDir);
            rendererConfig.enablePerfReport = ReportUtil.isEnablePerfReport();
            rendererConfig.bundlePath = assetsDir;
            rendererConfig.enableOutputCrop = true;
            this.lightEngine = LightEngine.make(null, null, rendererConfig);
            LightSurface makeFromTexture = LightSurface.makeFromTexture(this.outTexs[0], this.previewWidth, this.previewHeight, false);
            this.lightSurface = makeFromTexture;
            this.lightEngine.setSurface(makeFromTexture);
            this.videoOutput = this.lightEngine.videoOutput();
            this.audioReader = this.lightEngine.audioOutput();
            this.cameraConfig = CameraConfig.make();
            PerformanceMonitor.setBenchEnable(false);
            this.lightEngine.setConfig(this.cameraConfig);
            this.cameraConfig.setWatermarkConfig(this.watermarkConfig);
            this.cameraConfig.setDefaultBeautyVersion(this.defaultSmoothVersion);
            this.cameraConfig.setBGMusicHidden(this.isBgmHidden);
            HashMap hashMap = new HashMap();
            hashMap.put(Config.ConfigKeys.ResourceDir.value(), assetsDir);
            addSwitchMap(hashMap);
            if (this.needLowEndDownGrade) {
                str = "true";
            } else {
                str = "false";
            }
            hashMap.put(LightConstants.Others.DEVICE_FALLBACK_SMOOTH, str);
            this.cameraConfig.setConfigData(hashMap);
            updateRenderSize(this.previewWidth, this.previewHeight);
            setListenersForConfig();
            this.asset = LightAsset.Load(emptyMaterialPath, 0);
            this.assetFixedRenderSize = false;
            this.cameraController = setAssetForCamera();
            if (this.mNeedSetBundle) {
                for (Map.Entry<String, String> entry : this.bundlePathMap.entrySet()) {
                    if (entry != null) {
                        setBundleToLightEngine(entry.getValue(), entry.getKey());
                    }
                }
                this.mNeedSetBundle = false;
            }
            this.cameraConfig.setDetectShorterEdgeLength(180, "");
            this.cameraConfig.setDetectShorterEdgeLength(480, LightConstants.AGENT_TYPE.kGAZE_AGENT);
            this.cameraConfig.setDetectShorterEdgeLength(320, "BODY3D_POINT_AGENT");
            setFaceDetectLengthByDevice();
            iterateSetShorterEdgeFromMap();
            if (this.orientationChanged) {
                CameraConfig cameraConfig = this.cameraConfig;
                float[] fArr = this.sensorEvent.values;
                cameraConfig.sensorOrientationChanged((int) fArr[0], (int) fArr[1]);
                this.orientationChanged = false;
            }
            if (this.cameraOrientationChanged) {
                this.cameraConfig.sensorOrientationChanged(this.cameraOrientation);
                this.cameraOrientationChanged = false;
            }
            this.startTime = System.nanoTime();
            VideoFilterBase videoFilterBase = this.mCopyFilter;
            if (videoFilterBase != null) {
                videoFilterBase.apply();
            }
            this.mIsApplied = true;
            LightNodeAppliedListener lightNodeAppliedListener = this.appliedListener;
            if (lightNodeAppliedListener != null) {
                lightNodeAppliedListener.onLightNodeApplied();
                return;
            }
            return;
        }
        LogUtils.e(TAG, "apply LightNode terminated with exception: path null ! --> assetsDir=" + assetsDir + " ,emptyMaterialPath=" + emptyMaterialPath);
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public void clear() {
        VideoFilterBase videoFilterBase = this.mCopyFilter;
        if (videoFilterBase != null) {
            videoFilterBase.clear();
            this.mCopyFilter = null;
        }
        Frame frame = this.mCopyFrame;
        if (frame != null) {
            frame.clear();
            this.mCopyFrame = null;
        }
        VideoOutput videoOutput = this.videoOutput;
        if (videoOutput != null) {
            videoOutput.release();
            this.videoOutput = null;
        }
        AudioOutput audioOutput = this.audioReader;
        if (audioOutput != null) {
            audioOutput.release();
            this.audioReader = null;
        }
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            cameraController.release();
            this.cameraController = null;
        }
        LightEngine lightEngine = this.lightEngine;
        if (lightEngine != null) {
            lightEngine.release();
            this.lightEngine = null;
        }
        LightSurface lightSurface = this.lightSurface;
        if (lightSurface != null) {
            lightSurface.release();
            this.lightSurface = null;
        }
        this.cameraConfig = null;
        this.mIsApplied = false;
        this.mWatermarkClickListener = null;
        this.mTipsListener = null;
        this.mLightAssetListener = null;
        this.appliedListener = null;
        this.mCameraExposureListener = null;
    }

    public boolean currentMaterialIsCyberpunk() {
        LightAsset lightAsset = this.asset;
        if (lightAsset != null && lightAsset.needRenderAbility(LightConstants.AssetFeatureKey.HAS_CYBERPUNK)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public String filterName() {
        return TAG;
    }

    protected String formatDecimalValue(int i3) {
        return Float.toString(i3 / 100.0f);
    }

    public void freeCache() {
        LightSurface lightSurface = this.lightSurface;
        if (lightSurface != null) {
            lightSurface.freeCache();
        }
    }

    public LightAsset getAsset() {
        return this.asset;
    }

    @Nullable
    public AudioPlaceHolder[] getAudioPlaceHolder(@NonNull LightAsset lightAsset) {
        CameraController cameraController;
        Throwable th5;
        try {
            cameraController = setAssetForCamera();
        } catch (Exception unused) {
            cameraController = null;
        } catch (Throwable th6) {
            cameraController = null;
            th5 = th6;
        }
        try {
            AudioPlaceHolder[] audioPlaceHolders = cameraController.getAudioPlaceHolders();
            cameraController.release();
            return audioPlaceHolders;
        } catch (Exception unused2) {
            if (cameraController != null) {
                cameraController.release();
            }
            return null;
        } catch (Throwable th7) {
            th5 = th7;
            if (cameraController != null) {
                cameraController.release();
            }
            throw th5;
        }
    }

    public AudioOutput getAudioReader() {
        return this.audioReader;
    }

    public List<WMElement> getEditableWMElement() {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            return cameraController.getEditableWMElement();
        }
        return null;
    }

    public LightAIDataWrapper getLightAIDataWrapper(String[] strArr, int i3) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig == null) {
            return null;
        }
        return cameraConfig.getAIData(strArr, i3);
    }

    public AvatarAIInfo getLightAvatarAIInfo() {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            return cameraConfig.getLightAvatarAIInfo();
        }
        return null;
    }

    public LightSurface getLightSurface() {
        return this.lightSurface;
    }

    public PTFaceAttr getPtFaceAttr() {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig == null) {
            return null;
        }
        return TransformUtils.lightFaceToPTFaceAttr(cameraConfig.getFaceData());
    }

    public void initPreviewSize(int i3, int i16) {
        this.previewWidth = i3;
        this.previewHeight = i16;
    }

    public boolean isAbilityOn(String str) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig == null || cameraConfig.getConfigData() == null || this.cameraConfig.getConfigData().get(str) == null) {
            return false;
        }
        return Boolean.valueOf(this.cameraConfig.getConfigData().get(str)).booleanValue();
    }

    public void onSensorOrientationChanged(CameraConfig.DeviceCameraOrientation deviceCameraOrientation) {
        this.cameraOrientation = deviceCameraOrientation;
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig == null) {
            this.cameraOrientationChanged = true;
        } else {
            cameraConfig.sensorOrientationChanged(deviceCameraOrientation);
        }
    }

    public void openAndUpdateBasicLips(String str, int i3, int i16) {
        HashMap hashMap = new HashMap();
        hashMap.put("beauty.faceFeatureLipsLut", formatDecimalValue(i3));
        hashMap.put(LightConstants.BeautyConfigKey.BEAUTY_LIPS_LIPS_MASK, str);
        hashMap.put(LightConstants.BeautyConfigKey.BEAUTY_LIPS_LIPS_TYPE, String.valueOf(i16));
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(hashMap);
        }
    }

    public void openAndUpdateBasicMultiply(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("beauty.faceFeatureRedCheek", formatDecimalValue(i3));
        hashMap.put(LightConstants.BeautyConfigKey.BEAUTY_MAKEUP_MULTIPLY_MULTIPLY_MASK, str);
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(hashMap);
        }
    }

    public void openAndUpdateBasicSoftLight(String str, int i3) {
        HashMap hashMap = new HashMap();
        hashMap.put("beauty.faceFeatureSoftlight", formatDecimalValue(i3));
        hashMap.put(LightConstants.BeautyConfigKey.BEAUTY_SOFTLIGHT_SOFTLIGHT_MASK, str);
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.setConfigData(hashMap);
        }
    }

    @Override // com.tencent.aekit.openrender.internal.AEChainI
    public Frame render(Frame frame) {
        int render = render(frame.getTextureId(), this.previewWidth, this.previewHeight);
        Frame frame2 = new Frame();
        frame2.setSizedTexture(render, this.previewWidth, this.previewHeight);
        return frame2;
    }

    public void resetAsset() {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            cameraController.resetAsset();
            LogUtils.d(TAG, "[resetAsset] success, start time(" + this.startTime + ") is reset to " + System.nanoTime());
            this.startTime = System.nanoTime();
            this.audioReader.seekTo(0L);
        }
    }

    public void setApplyListener(LightNodeAppliedListener lightNodeAppliedListener) {
        this.appliedListener = lightNodeAppliedListener;
    }

    public void setAssetData(String str, String str2) {
        if (str != null && this.cameraController != null) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(str, str2);
            this.cameraController.setAssetData(hashMap);
        }
    }

    public void setAutoTest(boolean z16) {
        this.mAutoTest = z16;
    }

    public void setAvatarMode(boolean z16) {
        this.avatarMode = z16;
    }

    public void setCameraExposureListener(ILightNodeCameraExposureListener iLightNodeCameraExposureListener) {
        this.mCameraExposureListener = iLightNodeCameraExposureListener;
    }

    public void setCustomMaterial(String str) {
        LightAsset lightAsset;
        MaterialConfig[] materialConfigs;
        if (!TextUtils.isEmpty(str) && (lightAsset = this.asset) != null && (materialConfigs = lightAsset.getMaterialConfigs()) != null && materialConfigs.length >= 1) {
            MaterialConfig materialConfig = materialConfigs[0];
            PhotoClip photoClip = new PhotoClip();
            photoClip.path = str;
            photoClip.duration = 0L;
            PhotoClip[] photoClipArr = {photoClip};
            CameraController cameraController = this.cameraController;
            if (cameraController != null) {
                cameraController.setMaterialClipAssets(materialConfig.key, photoClipArr);
            }
        }
    }

    public void setDetectShortLength(String str, int i3) {
        if (str != null && i3 > 0 && this.cameraConfig != null) {
            Log.e(TAG, "setDetectShortLength:" + str + "," + i3);
            this.cameraConfig.setDetectShorterEdgeLength(i3, str);
        }
    }

    public void setDetectShorterEdgeLengthMap(HashMap<String, Integer> hashMap) {
        HashMap<String, Integer> hashMap2;
        if (hashMap != null && (hashMap2 = this.detectShorterLengthMap) != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public void setExternalRenderCallback(ExternalRenderCallback externalRenderCallback) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.setExternalRenderCallback(externalRenderCallback);
        }
    }

    public void setFrameIndex(int i3) {
        this.mFrameIndex = i3;
    }

    public void setGetOnlineUsrCountDelegate(String str, OnWatermarkDataListener onWatermarkDataListener) {
        this.wmDelegateMap.put(str, onWatermarkDataListener);
        if (this.cameraConfig != null) {
            LogUtils.d(TAG, "\u8bbe\u7f6e\u6c34\u5370delegate\u65f6config\u521d\u59cb\u5316\u5b8c\u6210\uff0c\u76f4\u63a5\u6ce8\u5165");
            this.cameraConfig.setWatermarkDataListener(str, onWatermarkDataListener);
        } else {
            LogUtils.d(TAG, "\u8bbe\u7f6e\u6c34\u5370delegate\u65f6config\u5c1a\u672a\u521d\u59cb\u5316\uff0c\u7b49\u5f85\u8282\u70b9apply\u540e\u6ce8\u5165");
        }
    }

    public void setInputOrigin(CameraConfig.ImageOrigin imageOrigin) {
        this.inputOrigin = imageOrigin;
    }

    public void setLightAIDataWrapper(LightAIDataWrapper lightAIDataWrapper) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.replaceAIData(lightAIDataWrapper);
        }
    }

    public void setLightBundle(String str, String str2) {
        if (this.cameraConfig == null) {
            this.bundlePathMap.put(str2, str);
            this.mNeedSetBundle = true;
            LogUtils.w(TAG, "can not set to sdk now ");
        } else {
            setBundleToLightEngine(str, str2);
            this.mNeedSetBundle = false;
        }
    }

    public void setLightNodeLightAssetListener(OnLoadAssetListener onLoadAssetListener) {
        this.mLightAssetListener = onLoadAssetListener;
    }

    public void setLightNodeTipsListener(ILightNodeTipsListener iLightNodeTipsListener) {
        this.mTipsListener = iLightNodeTipsListener;
    }

    public void setOnClickWatermarkListener(OnClickWatermarkListener onClickWatermarkListener) {
        this.mWatermarkClickListener = onClickWatermarkListener;
    }

    public void setPicNeedFlip(boolean z16) {
        this.isPicNeedFlip = z16;
    }

    public void setPtFaceAttr(PTFaceAttr pTFaceAttr) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig == null) {
            return;
        }
        cameraConfig.setExternalFaceData(TransformUtils.ptFaceAttrToLightFaceData(pTFaceAttr));
    }

    public void setSensorEvent(SensorEvent sensorEvent) {
        if (sensorEvent == null) {
            LogUtils.e(TAG, "[setSensorEvent]: event is null ");
            return;
        }
        if (this.cameraConfig == null) {
            if (this.sensorEvent != sensorEvent) {
                this.sensorEvent = sensorEvent;
                this.orientationChanged = true;
                return;
            }
            return;
        }
        this.sensorEvent = sensorEvent;
        LogUtils.d(TAG, "[setSensorEvent]: x=" + ((int) this.sensorEvent.values[0]) + " y=" + ((int) this.sensorEvent.values[1]));
        CameraConfig cameraConfig = this.cameraConfig;
        float[] fArr = this.sensorEvent.values;
        cameraConfig.sensorOrientationChanged((int) fArr[0], (int) fArr[1]);
    }

    public void setSyncMode(boolean z16) {
        CameraConfig cameraConfig = this.cameraConfig;
        if (cameraConfig != null) {
            cameraConfig.setSyncMode(z16);
        }
    }

    public void setWatermarkConfig(WatermarkConfig watermarkConfig) {
        this.watermarkConfig = watermarkConfig;
    }

    public void switchDebugImage(boolean z16, String str, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27) {
        if (this.lightEngine != null) {
            DebugUtils.setImageDebugInfo(z16, str, z17, z18, z19, z26, z27);
        }
    }

    public void switchSegmentFastMode(boolean z16) {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            cameraController.setSegmentationFastMode(z16);
        }
    }

    public void updateAsset(String str) {
        if (str == null || str.equals(this.assetPath)) {
            return;
        }
        this.assetPath = str;
        LogUtils.i(TAG, "LightAsset Path: " + str);
        updateAsset(LightAsset.Load(str, 0));
    }

    public void updateCameraConfigData(Map<String, String> map) {
        CameraConfig cameraConfig;
        if (map == null || (cameraConfig = this.cameraConfig) == null) {
            return;
        }
        cameraConfig.setConfigData(map);
    }

    public void updateCameraTextureTimestamp(long j3) {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            cameraController.updateCameraTextureTimestamp(j3);
        }
    }

    public void updateDeviceCameraConfig(DeviceCameraConfig deviceCameraConfig) {
        boolean z16;
        LightEngine lightEngine;
        CameraConfig cameraConfig;
        CameraConfig cameraConfig2;
        CameraConfig cameraConfig3;
        if (deviceCameraConfig == null) {
            return;
        }
        if (this.deviceCameraConfig == null) {
            this.deviceCameraConfig = new DeviceCameraConfig();
        }
        int i3 = deviceCameraConfig.cameraIndex;
        boolean z17 = true;
        if (i3 != this.deviceCameraConfig.cameraIndex && (cameraConfig3 = this.cameraConfig) != null) {
            cameraConfig3.cameraSwitched(i3);
            this.cameraConfig.clearAICachedData();
            this.deviceCameraConfig.cameraIndex = deviceCameraConfig.cameraIndex;
            z16 = true;
        } else {
            z16 = false;
        }
        float f16 = deviceCameraConfig.cameraHorizontalFov;
        if (f16 != this.deviceCameraConfig.cameraHorizontalFov && (cameraConfig2 = this.cameraConfig) != null) {
            cameraConfig2.setHorizontalFov(f16);
            this.deviceCameraConfig.cameraHorizontalFov = deviceCameraConfig.cameraHorizontalFov;
        } else {
            z17 = z16;
        }
        if (z17 && (lightEngine = this.lightEngine) != null && (cameraConfig = this.cameraConfig) != null) {
            lightEngine.setConfig(cameraConfig);
        }
    }

    public void updatePreviewSize(int i3, int i16) {
        initPreviewSize(i3, i16);
        updateRenderSize(i3, i16);
        LightSurface lightSurface = this.lightSurface;
        if (lightSurface != null) {
            lightSurface.updateSize(i3, i16);
        }
    }

    public void updateTouchEvent(int i3, long j3, long j16, ArrayList<PointF> arrayList, int i16, int i17) {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            cameraController.updateTouchEvent(i3, j3, j16, arrayList, i16, i17);
        }
    }

    public void updateVoiceDecibel(float f16) {
        CameraController cameraController = this.cameraController;
        if (cameraController != null) {
            cameraController.updateVoiceDecibel(f16);
        }
    }

    public LightNode(String str, boolean z16, boolean z17, Map<String, String> map, boolean z18) {
        this.outTexs = new int[2];
        this.bundlePathMap = new HashMap<>();
        this.detectShorterLengthMap = new HashMap<>();
        this.mNeedSetBundle = false;
        this.orientationChanged = false;
        this.needDowngrade = false;
        this.cameraOrientation = CameraConfig.DeviceCameraOrientation.ROTATION_0;
        this.cameraOrientationChanged = false;
        this.wmDelegateMap = new HashMap<>();
        this.inputOrigin = CameraConfig.ImageOrigin.BottomLeft;
        this.startTime = 0L;
        this.assetPath = "";
        this.previewWidth = 1;
        this.previewHeight = 1;
        this.mFrameIndex = 0;
        this.mAutoTest = false;
        this.isPicNeedFlip = false;
        this.isBgmHidden = false;
        this.isRealtime = true;
        this.needLowEndDownGrade = false;
        this.needInitBodySegment = true;
        this.assetFixedRenderSize = false;
        this.mCopyFilter = new VideoFilterBase("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
        this.avatarMode = false;
        this.watermarkConfig = null;
        this.lastRenderWidth = 0;
        this.lastRenderHeight = 0;
        this.defaultSmoothVersion = str;
        this.isBgmHidden = z16;
        this.isRealtime = z17;
        this.aiSwitchMap = map;
        this.needLowEndDownGrade = z18;
        VideoDecoder.SetMaxHardwareDecoderCount(CommonUtils.getPAGSupportedDecoderInstanceCount());
    }

    public void updateCameraConfigData(String str, String str2) {
        if (str == null || this.cameraConfig == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        this.cameraConfig.setConfigData(hashMap);
    }

    public int render(int i3, int i16, int i17) {
        long nanoTime;
        if (this.assetFixedRenderSize && i16 != 0 && i17 != 0) {
            double d16 = i16;
            double d17 = i17;
            double max = Math.max((this.previewWidth * 1.0d) / d16, (this.previewHeight * 1.0d) / d17);
            updateRenderSize((int) (d16 * max), (int) (max * d17));
        } else {
            updateRenderSize(this.previewWidth, this.previewHeight);
        }
        CameraConfig.ImageOrigin imageOrigin = this.inputOrigin;
        if (this.isPicNeedFlip) {
            CameraConfig.ImageOrigin imageOrigin2 = CameraConfig.ImageOrigin.BottomLeft;
            imageOrigin = imageOrigin == imageOrigin2 ? CameraConfig.ImageOrigin.TopLeft : imageOrigin2;
        }
        this.cameraConfig.setCameraTexture(i3, i16, i17, CameraConfig.DeviceCameraOrientation.ROTATION_0, imageOrigin);
        if (this.mAutoTest) {
            nanoTime = this.mFrameIndex * 80000;
        } else {
            nanoTime = (System.nanoTime() - this.startTime) / 1000;
        }
        VideoOutput videoOutput = this.videoOutput;
        if (videoOutput != null) {
            videoOutput.readSample(nanoTime);
        }
        GLES20.glDisable(3042);
        GLES30.glBindVertexArray(0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        return this.outTexs[0];
    }

    public void updateAsset(LightAsset lightAsset) {
        if (lightAsset != null && this.asset != lightAsset) {
            LogUtils.d(TAG, "[configFilters][updateAsset] \u66f4\u65b0\u7d20\u6750:" + lightAsset.toString());
            LightAsset lightAsset2 = this.asset;
            if (lightAsset2 != null) {
                lightAsset2.performFinalize();
                this.asset = null;
            }
            this.asset = lightAsset;
            if (this.lightEngine != null) {
                this.cameraController = setAssetForCamera();
            }
            this.startTime = System.nanoTime();
            this.assetFixedRenderSize = this.asset.needRenderAtMaxSize();
            return;
        }
        LogUtils.d(TAG, "[updateAsset] lightAsset is null or already set, return");
    }

    public void onPause() {
    }

    public void onResume() {
    }
}
