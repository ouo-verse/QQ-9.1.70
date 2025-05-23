package com.tencent.ttpic.baseutils.device;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.util.GsonUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DeviceAttrs {
    public static final String ACTION_CHECK_ONLINE_UPDATE_FINISH = "action_check_online_update_finish";
    public static final int CAMERASDK_FAILED_THRESHOLD = 4;
    public static final int DEGREE_0 = 0;
    public static final int DEGREE_180 = 180;
    public static final int DEGREE_270 = 270;
    public static final int DEGREE_90 = 90;
    public static final int DEGREE_INVALIDATE = -1;
    public static final Boolean ENABLE_LOG;
    public static final int ENABLE_PERFORMANCE_MONITOR_THRESHOLD = 604800000;
    private static final DeviceAttrs INSTANCE;
    public static final String KEY_CAMERASDK_DISABLE = "pref_camerasdk_disable";
    public static final String KEY_CAMERASDK_FAILED_TIMES = "pref_camerasdk_open_failed_times";
    public static final String KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME = "enable_performance_monitor_begin_time";
    public static final String KEY_NEED_PARSE_XML = "is_need_parse_xml";
    public static final String KEY_PARSE_RESULT = "parse_result";
    public static final String KEY_URL_VALUE = "black_list_url";
    public static final String KEY_VERSION = "xml_version";
    public static final Boolean PARSE_XML_DEBUG_MODE;
    private static final String TAG;
    private static final Boolean TEST_URL;
    private static final String XML_FILE_NAME = "phone_attrs_config.dat";
    private static final String ZIP_FILE_NAME = "phone_attrs_config.zip";
    private static final String backCamCannotRotateKey = "backCamCannotRotate";
    private static final String backExposureStepOneKey = "backExposureStepOne";
    private static final String backFlashModeExceptionKey = "backFlashModeException";
    private static final String backFlashNoAutoKey = "backFlashNoAuto";
    private static final String backFlashNoOnKey = "backFlashNoOn";
    private static final String backFlashNoTorchKey = "backFlashNoTorch";
    private static final String beBlurredPicAfterTakePicKey = "beBlurredPicAfterTakePic";
    private static final String beBlurredPreviewAfterTakePicKey = "beBlurredPreviewAfterTakePic";
    private static final String cannotFlashWhileAutoFocusKey = "cannotFlashWhileAutoFocus";
    private static final String cannotFlashWhileFlashOnKey = "cannotFlashWhileFlashOn";
    private static final String cannotRotatePreviewKey = "cannotRotatePreview";
    private static final String deviceJpegDisableKey = "deviceJpegDisable";
    private static final String disableAutoFocusDoubleKey = "disableAutoFocusDouble";
    private static final String disableBackExposureKey = "disableBackExposure";
    private static final String disableBackFlashModeKey = "disableBackFlashMode";
    private static final String disableCameraSDKKey = "disableCameraSDK";
    private static final String disableCameraVideoKey = "disableCameraVideo";
    private static final String disableFaceDetectionKey = "disableFaceDetection";
    private static final String disableFocusModeContinuousPictureKey = "disableFocusModeContinuousPicture";
    private static final String disableFocusModeKey = "disableFocusMode";
    private static final String disableFrontCameraKey = "disableFrontCamera";
    private static final String disableFrontExposureKey = "disableFrontExposure";
    private static final String disableGridCaptureKey = "disableGridCapture";
    private static final String disableLiteEditorKey = "disableLiteEditor";
    private static final String disableMultiPreviewKey = "disableMultiPreview";
    private static final String disableVideoTransformKey = "disableVideoTransform";
    private static final String enableFastCapture4BackCameraKey = "enableFastCapture4BackCamera";
    private static final String enableFastCapture4FrontCameraKey = "enableFastCapture4FrontCamera";
    private static final String enablePerformanceMonitorKey = "enablePerformanceMonitor";
    private static final String es_GL_EXT_shader_framebuffer_fetch_key = "es_GL_EXT_shader_framebuffer_fetch";
    private static final String frontCamCannotRotateKey = "frontCamCannotRotate";
    private static final String frontCamFlipHKey = "frontCamFlipH";
    private static final String frontExposureStepOneKey = "frontExposureStepOne";
    private static final String frontFlashModeExceptionKey = "frontFlashModeException";
    private static final String frontFlashNoAutoKey = "frontFlashNoAuto";
    private static final String gpuProcessNeedBackTexture_key = "gpuProcessNeedBackTexture";
    private static final String int_backCamRotate0Key = "int_backCamRotate0";
    private static final String int_backCamRotate180Key = "int_backCamRotate180";
    private static final String int_backCamRotate270Key = "int_backCamRotate270";
    private static final String int_backCamRotate90Key = "int_backCamRotate90";
    private static final String int_backExifRotate0Key = "int_backExifRotate0";
    private static final String int_backExifRotate180Key = "int_backExifRotate180";
    private static final String int_backExifRotate270Key = "int_backExifRotate270";
    private static final String int_backExifRotate90Key = "int_backExifRotate90";
    private static final String int_frontCamRotate0Key = "int_frontCamRotate0";
    private static final String int_frontCamRotate180Key = "int_frontCamRotate180";
    private static final String int_frontCamRotate270Key = "int_frontCamRotate270";
    private static final String int_frontCamRotate90Key = "int_frontCamRotate90";
    private static final String int_frontExifRotate0Key = "int_frontExifRotate0";
    private static final String int_frontExifRotate180Key = "int_frontExifRotate180";
    private static final String int_frontExifRotate270Key = "int_frontExifRotate270";
    private static final String int_frontExifRotate90Key = "int_frontExifRotate90";
    private static final String readCamNumExceptionKey = "readCamNumException";
    private static final String readMaxNumFocusAreasAbnormalKey = "readMaxNumFocusAreasAbnormal";
    private static final String readMaxNumMeteringAreasAbnormalKey = "readMaxNumMeteringAreasAbnormal";
    private static final String sReleaseURL = "https://xiangji.qq.com/services/cameraCoreSvr.php";
    private static final String sTestURL = "https://test.xiangji.qq.com/services/cameraCoreSvr.php";
    private static final String str_backPictureSize169Key = "str_backPictureSize169";
    private static final String str_backPictureSize43Key = "str_backPictureSize43";
    private static final String str_backPreviewSize169Key = "str_backPreviewSize169";
    private static final String str_backPreviewSize43Key = "str_backPreviewSize43";
    private static final String str_deviceSocInfoKey = "str_deviceSocInfo";
    private static final String str_frontPictureSize169Key = "str_frontPictureSize169";
    private static final String str_frontPictureSize43Key = "str_frontPictureSize43";
    private static final String str_frontPreviewSize169Key = "str_frontPreviewSize169";
    private static final String str_frontPreviewSize43Key = "str_frontPreviewSize43";
    private static final String str_recordVideoSizeKey = "str_recordVideoSize";
    private static final String str_videoPreviewFpsKey = "str_videoPreview720Fps";
    private static final String useNewPreviewKey = "useNewPreview";
    public boolean deviceJpegDisable;
    public boolean es_GL_EXT_shader_framebuffer_fetch;
    public boolean gpuProcessNeedBackTexture;
    public boolean gpuWorkaroundForTU880;
    private String mBuildInFileDir;
    private SharedPreferences mCameraMatchPref;
    private Context mContext;
    private List<String> mFastCaptureKeys;
    private List<String> mFastCaptureOnValues;
    private String mRequestUrl;
    private String mSignature;
    public String str_backPictureSize169;
    public String str_backPictureSize43;
    public String str_backPreviewSize169;
    public String str_backPreviewSize43;
    public String str_deviceSocInfo;
    public String str_frontPictureSize169;
    public String str_frontPictureSize43;
    public String str_frontPreviewSize169;
    public String str_frontPreviewSize43;
    public String str_recordVideoSize;
    public String str_videoPreview720Fps;
    public boolean disableCameraSDK = false;
    public boolean disableLiteEditor = false;
    public boolean disableCameraVideo = false;
    public boolean enablePerformanceMonitor = false;
    public boolean readCamNumException = false;
    public boolean disableBackCamera = false;
    public boolean disableFrontCamera = false;
    public boolean beBlurredPreviewAfterTakePic = false;
    public boolean beBlurredPicAfterTakePic = false;
    public boolean enableFastCapture4FrontCamera = false;
    public boolean enableFastCapture4BackCamera = false;
    public boolean disableBackFlashMode = false;
    public boolean frontFlashModeException = false;
    public boolean frontFlashNoAuto = false;
    public boolean backFlashModeException = false;
    public boolean backFlashNoOn = false;
    public boolean backFlashNoAuto = false;
    public boolean backFlashNoTorch = true;
    public boolean disableFocusMode = false;
    public boolean disableAutoFocusDouble = false;
    public boolean disableFocusModeContinuousPicture = false;
    public boolean disableFaceDetection = false;
    public int int_frontCamRotate0 = -1;
    public int int_frontCamRotate90 = -1;
    public int int_frontCamRotate180 = -1;
    public int int_frontCamRotate270 = -1;
    public int int_backCamRotate0 = -1;
    public int int_backCamRotate90 = -1;
    public int int_backCamRotate180 = -1;
    public int int_backCamRotate270 = -1;
    public int int_frontExifRotate0 = -1;
    public int int_frontExifRotate90 = -1;
    public int int_frontExifRotate180 = -1;
    public int int_frontExifRotate270 = -1;
    public int int_backExifRotate0 = -1;
    public int int_backExifRotate90 = -1;
    public int int_backExifRotate180 = -1;
    public int int_backExifRotate270 = -1;
    public boolean frontCamFlipH = false;
    public boolean disableFrontExposure = false;
    public boolean disableBackExposure = false;
    public boolean frontExposureStepOne = false;
    public boolean backExposureStepOne = false;
    public boolean serverJpegEnable = true;
    private boolean cannotFlashWhileAutoFocus = false;
    private boolean cannotFlashWhileFlashOn = false;
    private boolean backCamCannotRotate = false;
    private boolean frontCamCannotRotate = false;
    private boolean cannotRotatePreview = false;
    private boolean readMaxNumMeteringAreasAbnormal = false;
    private boolean readMaxNumFocusAreasAbnormal = false;
    private String mPrevUrl = "";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface UpdateListener {
        void onFailed(String str);

        void onSuccess(String str);
    }

    static {
        Boolean bool = Boolean.FALSE;
        ENABLE_LOG = bool;
        PARSE_XML_DEBUG_MODE = bool;
        TEST_URL = bool;
        TAG = DeviceAttrs.class.getSimpleName();
        INSTANCE = new DeviceAttrs();
    }

    DeviceAttrs() {
        String str;
        if (TEST_URL.booleanValue()) {
            str = sTestURL;
        } else {
            str = sReleaseURL;
        }
        this.mRequestUrl = str;
        this.mFastCaptureKeys = new ArrayList();
        this.mFastCaptureOnValues = new ArrayList();
    }

    private String editKey(Set<String> set, String str, String str2) {
        if (set.contains(str)) {
            return str + "_" + str2;
        }
        return str;
    }

    private String getCameraPrefName(Context context) {
        return context.getPackageName() + "_preferences_camera_adapter";
    }

    public static DeviceAttrs getInstance() {
        return INSTANCE;
    }

    private void initFastCaptureKeyValue() {
        List<String> list = this.mFastCaptureKeys;
        if (list != null && this.mFastCaptureOnValues != null && list.isEmpty() && this.mFastCaptureOnValues.isEmpty()) {
            this.mFastCaptureKeys.clear();
            this.mFastCaptureOnValues.clear();
            try {
                JsonObject parseFastCaptureFile = parseFastCaptureFile();
                if (parseFastCaptureFile != null) {
                    JsonArray asJsonArray = parseFastCaptureFile.getAsJsonArray("key");
                    if (asJsonArray != null) {
                        for (int i3 = 0; i3 < asJsonArray.size(); i3++) {
                            this.mFastCaptureKeys.add(GsonUtils.getStringUnsafe(asJsonArray, i3));
                        }
                    }
                    JsonArray asJsonArray2 = parseFastCaptureFile.getAsJsonArray("value");
                    if (asJsonArray2 != null) {
                        for (int i16 = 0; i16 < asJsonArray2.size(); i16++) {
                            this.mFastCaptureOnValues.add(GsonUtils.getStringUnsafe(asJsonArray2, i16));
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private boolean isInFastCaptureWhiteList(boolean z16) {
        if (z16) {
            return getInstance().enableFastCapture4FrontCamera;
        }
        return getInstance().enableFastCapture4BackCamera;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAttrsFromPref() {
        String str = TAG;
        LogUtils.i(str, "[loadAttrsFromPref] + BEGIN");
        this.str_deviceSocInfo = this.mCameraMatchPref.getString(str_deviceSocInfoKey, "");
        boolean z16 = this.mCameraMatchPref.getBoolean(disableCameraSDKKey, false);
        this.disableCameraSDK = z16;
        if (z16) {
            this.mCameraMatchPref.edit().putBoolean(KEY_CAMERASDK_DISABLE, true).apply();
            LogUtils.i(str, "set camerasdk disable flag true");
        }
        this.disableCameraVideo = this.mCameraMatchPref.getBoolean(disableCameraVideoKey, false);
        this.enablePerformanceMonitor = this.mCameraMatchPref.getBoolean(enablePerformanceMonitorKey, false);
        this.disableLiteEditor = this.mCameraMatchPref.getBoolean(disableLiteEditorKey, false);
        this.readCamNumException = this.mCameraMatchPref.getBoolean(readCamNumExceptionKey, false);
        this.disableFrontCamera = this.mCameraMatchPref.getBoolean(disableFrontCameraKey, false);
        this.str_frontPreviewSize43 = this.mCameraMatchPref.getString(str_frontPreviewSize43Key, null);
        this.str_frontPreviewSize169 = this.mCameraMatchPref.getString(str_frontPreviewSize169Key, null);
        this.str_backPreviewSize43 = this.mCameraMatchPref.getString(str_backPreviewSize43Key, null);
        this.str_backPreviewSize169 = this.mCameraMatchPref.getString(str_backPreviewSize169Key, null);
        this.str_videoPreview720Fps = this.mCameraMatchPref.getString(str_videoPreviewFpsKey, null);
        this.str_frontPictureSize43 = this.mCameraMatchPref.getString(str_frontPictureSize43Key, null);
        this.str_frontPictureSize169 = this.mCameraMatchPref.getString(str_frontPictureSize169Key, null);
        this.str_backPictureSize43 = this.mCameraMatchPref.getString(str_backPictureSize43Key, null);
        this.str_backPictureSize169 = this.mCameraMatchPref.getString(str_backPictureSize169Key, null);
        this.str_recordVideoSize = this.mCameraMatchPref.getString(str_recordVideoSizeKey, null);
        this.beBlurredPreviewAfterTakePic = this.mCameraMatchPref.getBoolean(beBlurredPreviewAfterTakePicKey, false);
        this.beBlurredPicAfterTakePic = this.mCameraMatchPref.getBoolean(beBlurredPicAfterTakePicKey, false);
        this.enableFastCapture4FrontCamera = this.mCameraMatchPref.getBoolean(enableFastCapture4FrontCameraKey, false);
        this.enableFastCapture4BackCamera = this.mCameraMatchPref.getBoolean(enableFastCapture4BackCameraKey, false);
        this.disableBackFlashMode = this.mCameraMatchPref.getBoolean(disableBackFlashModeKey, false);
        this.backFlashModeException = this.mCameraMatchPref.getBoolean(backFlashModeExceptionKey, false);
        this.frontFlashModeException = this.mCameraMatchPref.getBoolean(frontFlashModeExceptionKey, false);
        this.backFlashNoOn = this.mCameraMatchPref.getBoolean(backFlashNoOnKey, false);
        this.backFlashNoAuto = this.mCameraMatchPref.getBoolean(backFlashNoAutoKey, false);
        this.backFlashNoTorch = this.mCameraMatchPref.getBoolean(backFlashNoTorchKey, true);
        this.frontFlashNoAuto = this.mCameraMatchPref.getBoolean(frontFlashNoAutoKey, false);
        this.disableFocusMode = this.mCameraMatchPref.getBoolean(disableFocusModeKey, false);
        this.disableFocusModeContinuousPicture = this.mCameraMatchPref.getBoolean(disableFocusModeContinuousPictureKey, false);
        this.disableAutoFocusDouble = this.mCameraMatchPref.getBoolean(disableAutoFocusDoubleKey, false);
        this.disableFaceDetection = this.mCameraMatchPref.getBoolean(disableFaceDetectionKey, false);
        this.int_frontCamRotate0 = this.mCameraMatchPref.getInt(int_frontCamRotate0Key, -1);
        this.int_frontCamRotate90 = this.mCameraMatchPref.getInt(int_frontCamRotate90Key, -1);
        this.int_frontCamRotate180 = this.mCameraMatchPref.getInt(int_frontCamRotate180Key, -1);
        this.int_frontCamRotate270 = this.mCameraMatchPref.getInt(int_frontCamRotate270Key, -1);
        this.int_backCamRotate0 = this.mCameraMatchPref.getInt(int_backCamRotate0Key, -1);
        this.int_backCamRotate90 = this.mCameraMatchPref.getInt(int_backCamRotate90Key, -1);
        this.int_backCamRotate180 = this.mCameraMatchPref.getInt(int_backCamRotate180Key, -1);
        this.int_backCamRotate270 = this.mCameraMatchPref.getInt(int_backCamRotate270Key, -1);
        this.int_frontExifRotate0 = this.mCameraMatchPref.getInt(int_frontExifRotate0Key, -1);
        this.int_frontExifRotate90 = this.mCameraMatchPref.getInt(int_frontExifRotate90Key, -1);
        this.int_frontExifRotate180 = this.mCameraMatchPref.getInt(int_frontExifRotate180Key, -1);
        this.int_frontExifRotate270 = this.mCameraMatchPref.getInt(int_frontExifRotate270Key, -1);
        this.int_backExifRotate0 = this.mCameraMatchPref.getInt(int_backExifRotate0Key, -1);
        this.int_backExifRotate90 = this.mCameraMatchPref.getInt(int_backExifRotate90Key, -1);
        this.int_backExifRotate180 = this.mCameraMatchPref.getInt(int_backExifRotate180Key, -1);
        this.int_backExifRotate270 = this.mCameraMatchPref.getInt(int_backExifRotate270Key, -1);
        this.frontCamFlipH = this.mCameraMatchPref.getBoolean(frontCamFlipHKey, false);
        this.disableFrontExposure = this.mCameraMatchPref.getBoolean(disableFrontExposureKey, false);
        this.disableBackExposure = this.mCameraMatchPref.getBoolean(disableBackExposureKey, false);
        this.frontExposureStepOne = this.mCameraMatchPref.getBoolean(frontExposureStepOneKey, false);
        this.backExposureStepOne = this.mCameraMatchPref.getBoolean(backExposureStepOneKey, false);
        this.deviceJpegDisable = this.mCameraMatchPref.getBoolean(deviceJpegDisableKey, false);
        this.es_GL_EXT_shader_framebuffer_fetch = this.mCameraMatchPref.getBoolean(es_GL_EXT_shader_framebuffer_fetch_key, true);
        this.cannotFlashWhileAutoFocus = this.mCameraMatchPref.getBoolean(cannotFlashWhileAutoFocusKey, false);
        this.frontCamCannotRotate = this.mCameraMatchPref.getBoolean(frontCamCannotRotateKey, false);
        this.readMaxNumMeteringAreasAbnormal = this.mCameraMatchPref.getBoolean(readMaxNumMeteringAreasAbnormalKey, false);
        this.readMaxNumFocusAreasAbnormal = this.mCameraMatchPref.getBoolean(readMaxNumFocusAreasAbnormalKey, false);
        this.cannotRotatePreview = this.mCameraMatchPref.getBoolean(cannotRotatePreviewKey, false);
        this.cannotFlashWhileFlashOn = this.mCameraMatchPref.getBoolean(cannotFlashWhileFlashOnKey, false);
        this.backCamCannotRotate = this.mCameraMatchPref.getBoolean(backCamCannotRotateKey, false);
        LogUtils.i(str, "[loadAttrsFromPref] + END");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAttrsValues() {
        String str = TAG;
        LogUtils.i(str, "DeviceAttrs start-------------------------------------------------------------");
        LogUtils.i(str, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
        LogUtils.d(str, "DeviceAttrs str_deviceSocInfo = " + this.str_deviceSocInfo);
        LogUtils.i(str, "DeviceAttrs disableCameraSDK = " + this.disableCameraSDK);
        LogUtils.i(str, "DeviceAttrs disableCameraVideo = " + this.disableCameraVideo);
        LogUtils.i(str, "DeviceAttrs enablePerformanceMonitor = " + this.enablePerformanceMonitor);
        LogUtils.i(str, "DeviceAttrs disableLiteEditor = " + this.disableLiteEditor);
        LogUtils.i(str, "DeviceAttrs readCamNumException = " + this.readCamNumException);
        LogUtils.i(str, "DeviceAttrs disableFrontCamera = " + this.disableFrontCamera);
        LogUtils.i(str, "DeviceAttrs beBlurredPreviewAfterTakePic = " + this.beBlurredPreviewAfterTakePic);
        LogUtils.i(str, "DeviceAttrs beBlurredPicAfterTakePic = " + this.beBlurredPicAfterTakePic);
        LogUtils.i(str, "DeviceAttrs enableFastCapture4FrontCamera = " + this.enableFastCapture4FrontCamera);
        LogUtils.i(str, "DeviceAttrs enableFastCapture4BackCamera = " + this.enableFastCapture4BackCamera);
        LogUtils.i(str, "DeviceAttrs str_videoPreview720Fps = " + this.str_videoPreview720Fps);
        LogUtils.i(str, "DeviceAttrs str_frontPreviewSize43 = " + this.str_frontPreviewSize43);
        LogUtils.i(str, "DeviceAttrs str_frontPreviewSize169 = " + this.str_frontPreviewSize169);
        LogUtils.i(str, "DeviceAttrs str_backPreviewSize43 = " + this.str_backPreviewSize43);
        LogUtils.i(str, "DeviceAttrs str_backPreviewSize169 = " + this.str_backPreviewSize169);
        LogUtils.i(str, "DeviceAttrs str_frontPictureSize43 = " + this.str_frontPictureSize43);
        LogUtils.i(str, "DeviceAttrs str_backPictureSize43 = " + this.str_backPictureSize43);
        LogUtils.i(str, "DeviceAttrs str_recordVideoSize = " + this.str_recordVideoSize);
        LogUtils.i(str, "DeviceAttrs disableBackFlashMode = " + this.disableBackFlashMode);
        LogUtils.i(str, "DeviceAttrs frontFlashModeException = " + this.frontFlashModeException);
        LogUtils.i(str, "DeviceAttrs backFlashModeException = " + this.backFlashModeException);
        LogUtils.i(str, "DeviceAttrs backFlashNoOn = " + this.backFlashNoOn);
        LogUtils.i(str, "DeviceAttrs backFlashNoAuto = " + this.backFlashNoAuto);
        LogUtils.i(str, "DeviceAttrs backFlashNoTorch = " + this.backFlashNoTorch);
        LogUtils.i(str, "DeviceAttrs frontFlashNoAuto = " + this.frontFlashNoAuto);
        LogUtils.i(str, "DeviceAttrs disableFocusMode = " + this.disableFocusMode);
        LogUtils.i(str, "DeviceAttrs disableFocusModeContinuousPicture = " + this.disableFocusModeContinuousPicture);
        LogUtils.i(str, "DeviceAttrs disableAutoFocusDouble = " + this.disableAutoFocusDouble);
        LogUtils.i(str, "DeviceAttrs disableFaceDetection = " + this.disableFaceDetection);
        LogUtils.i(str, "DeviceAttrs int_frontCamRotate0 = " + this.int_frontCamRotate0);
        LogUtils.i(str, "DeviceAttrs int_frontCamRotate90 = " + this.int_frontCamRotate90);
        LogUtils.i(str, "DeviceAttrs int_frontCamRotate180 = " + this.int_frontCamRotate180);
        LogUtils.i(str, "DeviceAttrs int_frontCamRotate270 = " + this.int_frontCamRotate270);
        LogUtils.i(str, "DeviceAttrs int_backCamRotate0 = " + this.int_backCamRotate0);
        LogUtils.i(str, "DeviceAttrs int_backCamRotate90 = " + this.int_backCamRotate90);
        LogUtils.i(str, "DeviceAttrs int_backCamRotate180 = " + this.int_backCamRotate180);
        LogUtils.i(str, "DeviceAttrs int_backCamRotate270 = " + this.int_backCamRotate270);
        LogUtils.i(str, "DeviceAttrs int_frontExifRotate0 = " + this.int_frontExifRotate0);
        LogUtils.i(str, "DeviceAttrs int_frontExifRotate90 = " + this.int_frontExifRotate90);
        LogUtils.i(str, "DeviceAttrs int_frontExifRotate180 = " + this.int_frontExifRotate180);
        LogUtils.i(str, "DeviceAttrs int_frontExifRotate270 = " + this.int_frontExifRotate270);
        LogUtils.i(str, "DeviceAttrs int_backExifRotate0 = " + this.int_backExifRotate0);
        LogUtils.i(str, "DeviceAttrs int_backExifRotate90 = " + this.int_backExifRotate90);
        LogUtils.i(str, "DeviceAttrs int_backExifRotate180 = " + this.int_backExifRotate180);
        LogUtils.i(str, "DeviceAttrs int_backExifRotate270 = " + this.int_backExifRotate270);
        LogUtils.i(str, "DeviceAttrs frontCamFlipH = " + this.frontCamFlipH);
        LogUtils.i(str, "DeviceAttrs disableFrontExposure = " + this.disableFrontExposure);
        LogUtils.i(str, "DeviceAttrs disableBackExposure = " + this.disableBackExposure);
        LogUtils.i(str, "DeviceAttrs frontExposureStepOne = " + this.frontExposureStepOne);
        LogUtils.i(str, "DeviceAttrs backExposureStepOne = " + this.backExposureStepOne);
        LogUtils.i(str, "DeviceAttrs serverJpegEnable = " + this.serverJpegEnable);
        LogUtils.i(str, "DeviceAttrs deviceJpegDisable = " + this.deviceJpegDisable);
        LogUtils.i(str, "DeviceAttrs es_GL_EXT_shader_framebuffer_fetch = " + this.es_GL_EXT_shader_framebuffer_fetch);
        LogUtils.i(str, "DeviceAttrs gpuProcessNeedBackTexture = " + this.gpuProcessNeedBackTexture);
        LogUtils.i(str, "DeviceAttrs cannotFlashWhileAutoFocus = " + this.cannotFlashWhileAutoFocus);
        LogUtils.i(str, "DeviceAttrs frontCamCannotRotate = " + this.frontCamCannotRotate);
        LogUtils.i(str, "DeviceAttrs readMaxNumMeteringAreasAbnormal = " + this.readMaxNumMeteringAreasAbnormal);
        LogUtils.i(str, "DeviceAttrs readMaxNumFocusAreasAbnormal = " + this.readMaxNumFocusAreasAbnormal);
        LogUtils.i(str, "DeviceAttrs cannotRotatePreview = " + this.cannotRotatePreview);
        LogUtils.i(str, "DeviceAttrs cannotFlashWhileFlashOn = " + this.cannotFlashWhileFlashOn);
        LogUtils.i(str, "DeviceAttrs backCamCannotRotate = " + this.backCamCannotRotate);
        LogUtils.i(str, "DeviceAttrs end-------------------------------------------------------------");
    }

    private boolean openFastCaptureMode(Camera.Parameters parameters) {
        if (parameters == null || this.mFastCaptureKeys == null || this.mFastCaptureOnValues == null) {
            return false;
        }
        boolean z16 = false;
        for (int i3 = 0; i3 < this.mFastCaptureKeys.size() && i3 < this.mFastCaptureOnValues.size(); i3++) {
            String str = this.mFastCaptureKeys.get(i3);
            if (parameters.get(str) != null) {
                parameters.set(str, this.mFastCaptureOnValues.get(i3));
                z16 = true;
            }
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseCurrentAttrsXML(String str) {
        int attributeCount;
        int i3;
        String str2 = TAG;
        LogUtils.i(str2, "[parseCurrentAttrsXML] + BEGIN");
        if (TextUtils.isEmpty(str)) {
            LogUtils.e(str2, "[parseCurrentAttrsXML] sourceString is empty");
            return;
        }
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(new StringReader(str));
            SharedPreferences.Editor edit = this.mCameraMatchPref.edit();
            Boolean bool = Boolean.FALSE;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    String name = newPullParser.getName();
                    String str3 = "default_defalut";
                    try {
                        str3 = DeviceInstance.getInstance().getDeviceName();
                    } catch (NoClassDefFoundError e16) {
                        LogUtils.e(e16);
                    }
                    String str4 = str3 + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
                    String str5 = str3 + "_Condition";
                    String str6 = "int_";
                    if (name.equals(str3)) {
                        LogUtils.d(TAG, "parseCurrentAttrsXML myPhoneType = " + str3 + ", subTagName = " + str4);
                        int attributeCount2 = newPullParser.getAttributeCount();
                        int i16 = 0;
                        while (i16 < attributeCount2) {
                            String attributeName = newPullParser.getAttributeName(i16);
                            String attributeValue = newPullParser.getAttributeValue(i16);
                            if (attributeName.startsWith("int_")) {
                                edit.putInt(attributeName, Integer.valueOf(Integer.parseInt(attributeValue)).intValue());
                            } else if (attributeName.startsWith("str_")) {
                                edit.putString(attributeName, String.valueOf(attributeValue));
                            } else {
                                edit.putBoolean(attributeName, Boolean.valueOf(Boolean.parseBoolean(attributeValue)).booleanValue());
                            }
                            String str7 = TAG;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("parseCurrentAttrsXML item[");
                            i16++;
                            sb5.append(i16);
                            sb5.append("] name = ");
                            sb5.append(attributeName);
                            sb5.append(", value = ");
                            sb5.append(attributeValue);
                            LogUtils.i(str7, sb5.toString());
                        }
                        bool = Boolean.TRUE;
                    } else if (str4.startsWith(name)) {
                        LogUtils.d(TAG, "parseCurrentAttrsXML myPhoneType = " + str3 + ", subTagName = " + str4);
                        int attributeCount3 = newPullParser.getAttributeCount();
                        int i17 = 0;
                        while (i17 < attributeCount3) {
                            String attributeName2 = newPullParser.getAttributeName(i17);
                            String attributeValue2 = newPullParser.getAttributeValue(i17);
                            if (attributeName2.startsWith("int_")) {
                                edit.putInt(attributeName2, Integer.valueOf(Integer.parseInt(attributeValue2)).intValue());
                            } else if (attributeName2.startsWith("str_")) {
                                edit.putString(attributeName2, String.valueOf(attributeValue2));
                            } else {
                                edit.putBoolean(attributeName2, Boolean.valueOf(Boolean.parseBoolean(attributeValue2)).booleanValue());
                            }
                            String str8 = TAG;
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("parseCurrentAttrsXML(subNode) item[");
                            i17++;
                            sb6.append(i17);
                            sb6.append("] name = ");
                            sb6.append(attributeName2);
                            sb6.append(", value = ");
                            sb6.append(attributeValue2);
                            LogUtils.i(str8, sb6.toString());
                        }
                    } else if (name.equals(str5) && (attributeCount = newPullParser.getAttributeCount()) != 0) {
                        String attributeName3 = newPullParser.getAttributeName(0);
                        String attributeValue3 = newPullParser.getAttributeValue(0);
                        if (attributeName3.startsWith("condition")) {
                            HashSet hashSet = new HashSet();
                            int i18 = 1;
                            while (i18 < attributeCount) {
                                String str9 = newPullParser.getAttributeName(i18) + "_" + attributeName3 + "_" + attributeValue3;
                                String attributeValue4 = newPullParser.getAttributeValue(i18);
                                if (str9.startsWith(str6)) {
                                    i3 = attributeCount;
                                    edit.putInt(str9, Integer.valueOf(Integer.parseInt(attributeValue4)).intValue());
                                } else {
                                    i3 = attributeCount;
                                    if (str9.startsWith("str_")) {
                                        edit.putString(str9, String.valueOf(attributeValue4));
                                    } else {
                                        edit.putBoolean(str9, Boolean.valueOf(Boolean.parseBoolean(attributeValue4)).booleanValue());
                                    }
                                }
                                hashSet.add(newPullParser.getAttributeName(i18));
                                String str10 = TAG;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("parseCurrentAttrsXML(condition) item[");
                                i18++;
                                sb7.append(i18);
                                sb7.append("] name = ");
                                sb7.append(str9);
                                sb7.append(", value = ");
                                sb7.append(attributeValue4);
                                LogUtils.i(str10, sb7.toString());
                                attributeCount = i3;
                                str6 = str6;
                            }
                            edit.putStringSet(attributeName3 + "_" + attributeValue3, hashSet);
                            edit.apply();
                        }
                    }
                }
            }
            if (bool.booleanValue()) {
                edit.putBoolean(KEY_NEED_PARSE_XML, false);
                edit.apply();
            }
        } catch (IOException e17) {
            LogUtils.e(e17);
        } catch (XmlPullParserException e18) {
            LogUtils.e(e18);
        }
        LogUtils.i(TAG, "[parseCurrentAttrsXML] + END");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private JsonObject parseFastCaptureFile() {
        InputStream inputStream;
        String str;
        InputStream open;
        InputStream inputStream2 = null;
        try {
            if (!PARSE_XML_DEBUG_MODE.booleanValue()) {
                str = DeviceParser.parseFastCaptureFile(this.mContext, "camera_fast_capture.dat", this.mSignature);
                open = null;
            } else {
                open = this.mContext.getAssets().open("camera_fast_capture.json");
                try {
                    str = IOUtils.toString(open);
                } catch (Exception e16) {
                    inputStream = open;
                    e = e16;
                    try {
                        LogUtils.e(e);
                        if (inputStream != null) {
                            IOUtils.closeQuietly(inputStream);
                        }
                        str = "";
                        if (!TextUtils.isEmpty(str)) {
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = inputStream;
                        if (inputStream2 != null) {
                            IOUtils.closeQuietly(inputStream2);
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    inputStream2 = open;
                    if (inputStream2 != null) {
                    }
                    throw th;
                }
            }
            if (open != null) {
                IOUtils.closeQuietly(open);
            }
        } catch (Exception e17) {
            e = e17;
            inputStream = null;
        } catch (Throwable th7) {
            th = th7;
        }
        if (!TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return GsonUtils.json2JsonObject(str);
        } catch (Exception e18) {
            e18.printStackTrace();
            return null;
        }
    }

    public void checkOnlineUpdate(String str, UpdateListener updateListener) {
        String str2 = TAG;
        LogUtils.i(str2, "[checkOnlineUpdate] + BEGIN, downloadUrl = " + str);
        String str3 = this.mBuildInFileDir + ZIP_FILE_NAME;
        String string = this.mCameraMatchPref.getString(KEY_URL_VALUE, null);
        if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(string)) {
            if (DeviceUpdate.httpDownloadFile(str, str3)) {
                String unZip = DeviceUpdate.unZip(str3, this.mBuildInFileDir);
                if (!TextUtils.isEmpty(unZip)) {
                    LogUtils.d(str2, "[checkOnlineUpdate] storageName = " + str3 + ", mBuildInFileDir = " + this.mBuildInFileDir);
                    SharedPreferences.Editor edit = this.mCameraMatchPref.edit();
                    edit.putString(KEY_URL_VALUE, str);
                    edit.apply();
                    String parseCameraAttrsFile = DeviceParser.parseCameraAttrsFile(this.mContext, unZip, DeviceInstance.getInstance().getDeviceName(), this.mSignature);
                    LogUtils.d(str2, "[checkOnlineUpdate] source = " + parseCameraAttrsFile);
                    if (!TextUtils.isEmpty(parseCameraAttrsFile)) {
                        parseCurrentAttrsXML(parseCameraAttrsFile);
                    }
                    if (updateListener != null) {
                        updateListener.onSuccess(str + ", download and parse success");
                    }
                    loadAttrsFromPref();
                    logAttrsValues();
                    Intent intent = new Intent();
                    intent.setAction(ACTION_CHECK_ONLINE_UPDATE_FINISH);
                    if (!TextUtils.isEmpty(parseCameraAttrsFile)) {
                        intent.putExtra(KEY_PARSE_RESULT, true);
                    } else {
                        intent.putExtra(KEY_PARSE_RESULT, false);
                    }
                    this.mContext.sendBroadcast(intent);
                } else {
                    updateListener.onFailed(str + ", download success, but unZip failed");
                }
            } else {
                updateListener.onFailed(str + ", download failed!");
            }
        } else if (updateListener != null) {
            updateListener.onFailed(str + ", this url has been downloaded, no need check update!");
        }
        LogUtils.i(str2, "[checkOnlineUpdate] + END");
    }

    public void checkVersion(final String str, final String str2, final String str3, final UpdateListener updateListener) {
        String str4 = TAG;
        LogUtils.i(str4, "[checkVersion] + BEGIN");
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.tencent.ttpic.baseutils.device.DeviceAttrs.1
            @Override // java.lang.Runnable
            public void run() {
                String string = DeviceAttrs.this.mCameraMatchPref.getString(DeviceAttrs.KEY_VERSION, "0");
                LogUtils.d(DeviceAttrs.TAG, "[checkVersion] currentVer = " + string);
                String checkConfigVersion = DeviceUpdate.checkConfigVersion(DeviceAttrs.this.mRequestUrl, str, string, str2, str3);
                LogUtils.d(DeviceAttrs.TAG, "[checkVersion] jsonStr = " + checkConfigVersion);
                if (TextUtils.isEmpty(checkConfigVersion)) {
                    return;
                }
                try {
                    JsonObject json2JsonObject = GsonUtils.json2JsonObject(checkConfigVersion);
                    if (json2JsonObject == null) {
                        return;
                    }
                    String stringUnsafe = GsonUtils.getStringUnsafe(json2JsonObject, "ret");
                    LogUtils.d(DeviceAttrs.TAG, "[checkVersion] retStr = " + stringUnsafe);
                    if (stringUnsafe.equals("1")) {
                        String stringUnsafe2 = GsonUtils.getStringUnsafe(json2JsonObject, "camCoreConfUrl");
                        LogUtils.d(DeviceAttrs.TAG, "[checkVersion] urlStr = " + stringUnsafe2);
                        String stringUnsafe3 = GsonUtils.getStringUnsafe(json2JsonObject, "curCamCoreVersion");
                        LogUtils.d(DeviceAttrs.TAG, "[checkVersion] verStr = " + stringUnsafe3);
                        String str5 = DeviceAttrs.this.mBuildInFileDir + DeviceAttrs.ZIP_FILE_NAME;
                        if (DeviceUpdate.httpDownloadFile(stringUnsafe2, str5)) {
                            String unZip = DeviceUpdate.unZip(str5, DeviceAttrs.this.mBuildInFileDir);
                            if (!TextUtils.isEmpty(unZip)) {
                                LogUtils.d(DeviceAttrs.TAG, "[checkVersion] unZipfilePath = " + unZip);
                                SharedPreferences.Editor edit = DeviceAttrs.this.mCameraMatchPref.edit();
                                edit.putString(DeviceAttrs.KEY_VERSION, stringUnsafe3);
                                edit.apply();
                                String parseCameraAttrsFile = DeviceParser.parseCameraAttrsFile(DeviceAttrs.this.mContext, unZip, DeviceInstance.getInstance().getDeviceName(), DeviceAttrs.this.mSignature);
                                if (parseCameraAttrsFile != null) {
                                    DeviceAttrs.this.parseCurrentAttrsXML(parseCameraAttrsFile);
                                }
                                DeviceAttrs.this.loadAttrsFromPref();
                                DeviceAttrs.this.logAttrsValues();
                                UpdateListener updateListener2 = updateListener;
                                if (updateListener2 != null) {
                                    updateListener2.onSuccess(DeviceAttrs.this.mRequestUrl + ", download and parse success");
                                }
                                Intent intent = new Intent();
                                intent.setAction(DeviceAttrs.ACTION_CHECK_ONLINE_UPDATE_FINISH);
                                DeviceAttrs.this.mContext.sendBroadcast(intent);
                            }
                        }
                    }
                    DeviceAttrs deviceAttrs = DeviceAttrs.this;
                    boolean z16 = true;
                    if (GsonUtils.optInt(json2JsonObject, "nativeJpegEnable", 1) != 1) {
                        z16 = false;
                    }
                    deviceAttrs.serverJpegEnable = z16;
                } catch (Exception e16) {
                    LogUtils.e(DeviceAttrs.TAG, "checkVersion JSONException e = " + e16);
                }
            }
        });
        LogUtils.i(str4, "[checkVersion] + END");
    }

    public void clearAllPreference() {
        SharedPreferences sharedPreferences = this.mCameraMatchPref;
        if (sharedPreferences != null) {
            sharedPreferences.edit().clear().apply();
        }
    }

    public long getMonitorEnableTime() {
        SharedPreferences sharedPreferences = this.mCameraMatchPref;
        if (sharedPreferences == null) {
            return 0L;
        }
        return sharedPreferences.getLong(KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME, 0L);
    }

    public String getPreviousUrl() {
        SharedPreferences sharedPreferences = this.mCameraMatchPref;
        if (sharedPreferences == null) {
            return "";
        }
        return sharedPreferences.getString(KEY_URL_VALUE, "");
    }

    public SizeI getRecordVideoSize(int i3, int i16) {
        SizeI sizeI = new SizeI(i3, i16);
        String str = getInstance().str_recordVideoSize;
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\*");
            if (split.length < 2) {
                return sizeI;
            }
            try {
                return new SizeI(Integer.parseInt(split[1]), Integer.parseInt(split[0]));
            } catch (Exception e16) {
                LogUtils.e(TAG, "Parse record size error!");
                e16.printStackTrace();
            }
        }
        return sizeI;
    }

    public void init(Context context, String str) {
        String str2;
        LogUtils.i(TAG, "[init] + BEGIN");
        long currentTimeMillis = System.currentTimeMillis();
        this.mContext = context;
        this.mSignature = str;
        if (context.getFilesDir() != null) {
            this.mBuildInFileDir = context.getFilesDir().toString() + "/";
        }
        Context context2 = this.mContext;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(getCameraPrefName(context2), 0);
        this.mCameraMatchPref = sharedPreferences;
        if (sharedPreferences != null) {
            boolean z16 = sharedPreferences.getBoolean(KEY_NEED_PARSE_XML, true);
            try {
                str2 = DeviceInstance.getInstance().getDeviceName();
            } catch (NoClassDefFoundError e16) {
                LogUtils.e(e16);
                str2 = "default_defalut";
            }
            String str3 = TAG;
            LogUtils.d(str3, "[init] deviceName = " + str2);
            if (z16) {
                String parseCameraAttrsFile = DeviceParser.parseCameraAttrsFile(this.mContext, XML_FILE_NAME, str2, this.mSignature);
                LogUtils.d(str3, "[init] source: " + parseCameraAttrsFile);
                if (!TextUtils.isEmpty(parseCameraAttrsFile)) {
                    parseCurrentAttrsXML(parseCameraAttrsFile);
                }
                if (LogUtils.isEnabled()) {
                    if (!TextUtils.isEmpty(parseCameraAttrsFile)) {
                        LogUtils.d(str3, "\u672c\u5730\u9002\u914d\u6587\u4ef6\u89e3\u5bc6\u5e76\u89e3\u6790 [\u6210\u529f]");
                    } else {
                        LogUtils.d(str3, "\u672c\u5730\u9002\u914d\u6587\u4ef6\u89e3\u5bc6\u5e76\u89e3\u6790 [\u5931\u8d25]");
                    }
                }
            }
            loadAttrsFromPref();
            logAttrsValues();
        }
        LogUtils.i(TAG, "[init] + END, time cost = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public boolean isCameraSDKDisable() {
        SharedPreferences sharedPreferences = this.mCameraMatchPref;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.getBoolean(KEY_CAMERASDK_DISABLE, false);
    }

    public boolean isEnableEXTShaderFramebufferFetch() {
        return getInstance().es_GL_EXT_shader_framebuffer_fetch;
    }

    public boolean isNativeJpegCompressEnable() {
        if (getInstance().serverJpegEnable && !getInstance().deviceJpegDisable) {
            return true;
        }
        return false;
    }

    public void setMonitorEnableTime(long j3) {
        SharedPreferences sharedPreferences = this.mCameraMatchPref;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putLong(KEY_ENABLE_PERFORMANCE_MONITOR_BEGIN_TIME, j3).apply();
        }
    }

    public void setRecordVideoSize(int i3, int i16) {
        SharedPreferences sharedPreferences = this.mCameraMatchPref;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str_recordVideoSizeKey, i16 + "*" + i3).apply();
        }
    }

    public void update(String str, UpdateListener updateListener) {
        String str2;
        try {
            str2 = DeviceInstance.getInstance().getDeviceName();
        } catch (NoClassDefFoundError e16) {
            LogUtils.e(e16);
            str2 = "default_defalut";
        }
        String str3 = TAG;
        LogUtils.d(str3, "[update] deviceName = " + str2);
        String parseCameraAttrsFile = DeviceParser.parseCameraAttrsFile(this.mContext, str, str2, this.mSignature);
        LogUtils.d(str3, "[update] source: " + parseCameraAttrsFile);
        if (parseCameraAttrsFile != null) {
            parseCurrentAttrsXML(parseCameraAttrsFile);
        }
        loadAttrsFromPref();
        logAttrsValues();
        if (updateListener != null) {
            updateListener.onSuccess(str + ", parse and reload success");
        }
        Intent intent = new Intent();
        intent.setAction(ACTION_CHECK_ONLINE_UPDATE_FINISH);
        Context context = this.mContext;
        if (context != null) {
            context.sendBroadcast(intent);
        }
    }

    public boolean updateCameraParametersFastCapture(Camera.Parameters parameters, boolean z16) {
        if (isInFastCaptureWhiteList(z16)) {
            initFastCaptureKeyValue();
            boolean openFastCaptureMode = openFastCaptureMode(parameters);
            LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list YES, OPEN fast mode, isFrontCamera = " + z16 + ", updated = " + openFastCaptureMode);
            return openFastCaptureMode;
        }
        LogUtils.d(TAG, "[updateCameraParametersFastCapture] this camera id in white list NO, do NOTHING, isFrontCamera = " + z16);
        return false;
    }

    public void updatePreviewCondition(int i3, int i16) {
        if (this.mCameraMatchPref == null) {
            return;
        }
        String str = "conditionPreviewSize_" + i3 + "*" + i16;
        Set<String> stringSet = this.mCameraMatchPref.getStringSet(str, new HashSet());
        this.int_frontCamRotate0 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontCamRotate0Key, str), -1);
        this.int_frontCamRotate90 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontCamRotate90Key, str), -1);
        this.int_frontCamRotate180 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontCamRotate180Key, str), -1);
        this.int_frontCamRotate270 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontCamRotate270Key, str), -1);
        this.int_backCamRotate0 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backCamRotate0Key, str), -1);
        this.int_backCamRotate90 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backCamRotate90Key, str), -1);
        this.int_backCamRotate180 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backCamRotate180Key, str), -1);
        this.int_backCamRotate270 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backCamRotate270Key, str), -1);
        this.int_frontExifRotate0 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontExifRotate0Key, str), -1);
        this.int_frontExifRotate90 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontExifRotate90Key, str), -1);
        this.int_frontExifRotate180 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontExifRotate180Key, str), -1);
        this.int_frontExifRotate270 = this.mCameraMatchPref.getInt(editKey(stringSet, int_frontExifRotate270Key, str), -1);
        this.int_backExifRotate0 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backExifRotate0Key, str), -1);
        this.int_backExifRotate90 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backExifRotate90Key, str), -1);
        this.int_backExifRotate180 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backExifRotate180Key, str), -1);
        this.int_backExifRotate270 = this.mCameraMatchPref.getInt(editKey(stringSet, int_backExifRotate270Key, str), -1);
    }
}
