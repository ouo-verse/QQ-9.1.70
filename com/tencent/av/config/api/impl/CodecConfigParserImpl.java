package com.tencent.av.config.api.impl;

import android.os.Build;
import com.tencent.av.config.api.ICodecConfigParser;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.avcore.jni.codec.HWCodecAbility;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.AVCoreUtil;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* loaded from: classes3.dex */
public class CodecConfigParserImpl implements ICodecConfigParser {
    private static final String STR_ASYNC = "async/";
    private static final String STR_ASYNC_CODEC = "codec";
    private static final String STR_ASYNC_MIN_SDK = "min_sdk";
    private static final String STR_AVC_DECODER = "avc_decoder/";
    private static final String STR_AVC_ENCODER = "avc_encoder/";
    private static final String STR_BLACK_LIST = "black_list/";
    private static final String STR_CODEC = "codec";
    private static final String STR_DISABLE_SDK = "disable_sdk";
    private static final String STR_FINGERPRINT = "fingerprint";
    private static final String STR_HEVC_DECODER = "hevc_decoder/";
    private static final String STR_HEVC_ENCODER = "hevc_encoder/";
    private static final String STR_MAX_H = "max_h";
    private static final String STR_MAX_W = "max_w";
    private static final String STR_MIN_SDK = "min_sdk";
    private static final String STR_MIN_VERSION = "min_version";
    private static final String STR_MODEL = "model";
    private static final String STR_PRODUCT = "product";
    private static final String STR_ROOT1 = "sharp/hwcodec_new/";
    private static final String STR_ROOT2 = "sharp/hwcodec_new2/";
    private static final String STR_SDK = "sdk";
    private static final String STR_TEST = "test/";
    private static final String STR_TEST_ASYNC_MIN_SDK = "async_min_sdk";
    private static final String STR_VERSION = "version";
    private static final String STR_WHITE_LIST = "white_list/";
    static final String TAG = "CodecConfigParser";
    private static final String VERSION2_FLAG = "hwcodec_new2";
    private String mKeyAvcdecWLMinSdk = null;
    private String mKeyAvcdecWLMinVersion = null;
    private String mKeyAvcdecBLModel = null;
    private String mKeyAvcdecBLProduct = null;
    private String mKeyAvcdecBLFingerprint = null;
    private String mKeyAvcdecBLSdk = null;
    private String mKeyAvcdecBLVersion = null;
    private String mKeyAvcdecWLMaxW = null;
    private String mKeyAvcdecWLMaxH = null;
    private String mKeyAvcencWLMinSdk = null;
    private String mKeyAvcencWLMinVersion = null;
    private String mKeyAvcencBLModel = null;
    private String mKeyAvcencBLProduct = null;
    private String mKeyAvcencBLFingerprint = null;
    private String mKeyAvcencBLSdk = null;
    private String mKeyAvcencBLVersion = null;
    private String mKeyAvcencWLMaxW = null;
    private String mKeyAvcencWLMaxH = null;
    private String mKeyHevcdecWLMinSdk = null;
    private String mKeyHevcdecWLMinVersion = null;
    private String mKeyHevcdecBLModel = null;
    private String mKeyHevcdecBLProduct = null;
    private String mKeyHevcdecBLFingerprint = null;
    private String mKeyHevcdecBLSdk = null;
    private String mKeyHevcdecBLVersion = null;
    private String mKeyHevcdecWLMaxW = null;
    private String mKeyHevcdecWLMaxH = null;
    private String mKeyHevcencWLMinSdk = null;
    private String mKeyHevcencWLMinVersion = null;
    private String mKeyHevcencBLModel = null;
    private String mKeyHevcencBLProduct = null;
    private String mKeyHevcencBLFingerprint = null;
    private String mKeyHevcencBLSdk = null;
    private String mKeyHevcencBLVersion = null;
    private String mKeyHevcencWLMaxW = null;
    private String mKeyHevcencWLMaxH = null;
    private String mKeyAsyncMinSdk = null;
    private String mKeyAsyncCodec = null;
    private int mVer = 1;
    private String mStrRoot = STR_ROOT1;
    private IConfigParser mParser = null;

    boolean checkQQVer(IConfigParser iConfigParser, String str, String str2) {
        String[] stringValues;
        if (this.mVer != 2) {
            return true;
        }
        int qQVersion = AVCoreUtil.getQQVersion();
        if (AVCoreUtil.strVersionToInt(iConfigParser.getStringValue(str, "")) > qQVersion) {
            return false;
        }
        if (str2 != null && (stringValues = iConfigParser.getStringValues(str2)) != null) {
            for (String str3 : stringValues) {
                if (AVCoreUtil.strVersionToInt(str3) == qQVersion) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.av.config.api.ICodecConfigParser
    public HWCodecAbility getAVCDecoderAbility() {
        int i3;
        int i16;
        if (this.mParser == null) {
            return null;
        }
        int i17 = Build.VERSION.SDK_INT;
        HWCodecAbility hWCodecAbility = new HWCodecAbility(1, true);
        try {
            int[] intValues = getIntValues(this.mParser, this.mKeyAvcdecWLMinSdk);
            if (intValues == null || i17 < intValues[0] || !checkQQVer(this.mParser, this.mKeyAvcdecWLMinVersion, this.mKeyAvcdecBLVersion)) {
                return null;
            }
            int[] intValues2 = getIntValues(this.mParser, this.mKeyAvcdecBLSdk);
            if (intValues2 != null) {
                for (int i18 : intValues2) {
                    if (Build.VERSION.SDK_INT == i18) {
                        return null;
                    }
                }
            }
            String[] stringValues = getStringValues(this.mParser, this.mKeyAvcdecBLModel);
            if (stringValues != null) {
                for (String str : stringValues) {
                    if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                        return null;
                    }
                }
            }
            String[] stringValues2 = getStringValues(this.mParser, this.mKeyAvcdecBLProduct);
            if (stringValues2 != null) {
                for (String str2 : stringValues2) {
                    if (Build.PRODUCT.equalsIgnoreCase(str2)) {
                        return null;
                    }
                }
            }
            String[] stringValues3 = getStringValues(this.mParser, this.mKeyAvcdecBLFingerprint);
            if (stringValues3 != null) {
                for (String str3 : stringValues3) {
                    if (Build.PRODUCT.equalsIgnoreCase(str3)) {
                        return null;
                    }
                }
            }
            int[] intValues3 = getIntValues(this.mParser, this.mKeyAvcdecWLMaxW);
            if (intValues3 != null && (i16 = intValues3[0]) > 0) {
                hWCodecAbility.maxW = i16;
            }
            int[] intValues4 = getIntValues(this.mParser, this.mKeyAvcdecWLMaxH);
            if (intValues4 != null && (i3 = intValues4[0]) > 0) {
                hWCodecAbility.maxH = i3;
            }
            return hWCodecAbility;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.av.config.api.ICodecConfigParser
    public HWCodecAbility getAVCEncoderAbility() {
        int i3;
        int i16;
        if (this.mParser == null) {
            return null;
        }
        int i17 = Build.VERSION.SDK_INT;
        HWCodecAbility hWCodecAbility = new HWCodecAbility(2, true);
        try {
            int[] intValues = getIntValues(this.mParser, this.mKeyAvcencWLMinSdk);
            if (intValues == null || i17 < intValues[0] || !checkQQVer(this.mParser, this.mKeyAvcencWLMinVersion, this.mKeyAvcencBLVersion)) {
                return null;
            }
            int[] intValues2 = getIntValues(this.mParser, this.mKeyAvcencBLSdk);
            if (intValues2 != null) {
                for (int i18 : intValues2) {
                    if (Build.VERSION.SDK_INT == i18) {
                        return null;
                    }
                }
            }
            String[] stringValues = getStringValues(this.mParser, this.mKeyAvcencBLModel);
            if (stringValues != null) {
                for (String str : stringValues) {
                    if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                        return null;
                    }
                }
            }
            String[] stringValues2 = getStringValues(this.mParser, this.mKeyAvcencBLProduct);
            if (stringValues2 != null) {
                for (String str2 : stringValues2) {
                    if (Build.PRODUCT.equalsIgnoreCase(str2)) {
                        return null;
                    }
                }
            }
            String[] stringValues3 = getStringValues(this.mParser, this.mKeyAvcencBLFingerprint);
            if (stringValues3 != null) {
                for (String str3 : stringValues3) {
                    if (Build.PRODUCT.equalsIgnoreCase(str3)) {
                        return null;
                    }
                }
            }
            int[] intValues3 = getIntValues(this.mParser, this.mKeyAvcencWLMaxW);
            if (intValues3 != null && (i16 = intValues3[0]) > 0) {
                hWCodecAbility.maxW = i16;
            }
            int[] intValues4 = getIntValues(this.mParser, this.mKeyAvcencWLMaxH);
            if (intValues4 != null && (i3 = intValues4[0]) > 0) {
                hWCodecAbility.maxH = i3;
            }
            return hWCodecAbility;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.av.config.api.ICodecConfigParser
    public HWCodecAbility getHevcDecoderAbility() {
        int i3;
        int i16;
        if (this.mParser == null) {
            return null;
        }
        int i17 = Build.VERSION.SDK_INT;
        HWCodecAbility hWCodecAbility = new HWCodecAbility(4, true);
        try {
            int[] intValues = getIntValues(this.mParser, this.mKeyHevcdecWLMinSdk);
            if (intValues == null || i17 < intValues[0] || !checkQQVer(this.mParser, this.mKeyHevcdecWLMinVersion, this.mKeyHevcdecBLVersion)) {
                return null;
            }
            int[] intValues2 = getIntValues(this.mParser, this.mKeyHevcdecBLSdk);
            if (intValues2 != null) {
                for (int i18 : intValues2) {
                    if (Build.VERSION.SDK_INT == i18) {
                        return null;
                    }
                }
            }
            String[] stringValues = getStringValues(this.mParser, this.mKeyHevcdecBLModel);
            if (stringValues != null) {
                for (String str : stringValues) {
                    if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                        return null;
                    }
                }
            }
            String[] stringValues2 = getStringValues(this.mParser, this.mKeyHevcdecBLProduct);
            if (stringValues2 != null) {
                for (String str2 : stringValues2) {
                    if (Build.PRODUCT.equalsIgnoreCase(str2)) {
                        return null;
                    }
                }
            }
            String[] stringValues3 = getStringValues(this.mParser, this.mKeyHevcdecBLFingerprint);
            if (stringValues3 != null) {
                for (String str3 : stringValues3) {
                    if (Build.PRODUCT.equalsIgnoreCase(str3)) {
                        return null;
                    }
                }
            }
            int[] intValues3 = getIntValues(this.mParser, this.mKeyHevcdecWLMaxW);
            if (intValues3 != null && (i16 = intValues3[0]) > 0) {
                hWCodecAbility.maxW = i16;
            }
            int[] intValues4 = getIntValues(this.mParser, this.mKeyHevcdecWLMaxH);
            if (intValues4 != null && (i3 = intValues4[0]) > 0) {
                hWCodecAbility.maxH = i3;
            }
            return hWCodecAbility;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.av.config.api.ICodecConfigParser
    public HWCodecAbility getHevcEncoderAbility() {
        int i3;
        int i16;
        if (this.mParser == null) {
            return null;
        }
        int i17 = Build.VERSION.SDK_INT;
        HWCodecAbility hWCodecAbility = new HWCodecAbility(8, true);
        try {
            int[] intValues = getIntValues(this.mParser, this.mKeyHevcencWLMinSdk);
            if (intValues == null) {
                AVCoreLog.e(TAG, "getHevcEncoderAbility failed. minsdk == null.");
                return null;
            }
            if (i17 < intValues[0]) {
                AVCoreLog.e(TAG, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT < minsdk[0]. minsdk[0] = " + intValues[0]);
                return null;
            }
            if (!checkQQVer(this.mParser, this.mKeyHevcencWLMinVersion, this.mKeyHevcencBLVersion)) {
                AVCoreLog.e(TAG, "getHevcEncoderAbility failed. checkQQVer failed.");
                return null;
            }
            int[] intValues2 = getIntValues(this.mParser, this.mKeyHevcencBLSdk);
            if (intValues2 != null) {
                for (int i18 : intValues2) {
                    if (Build.VERSION.SDK_INT == i18) {
                        AVCoreLog.e(TAG, "getHevcEncoderAbility failed. Build.VERSION.SDK_INT == disablesdk[i].");
                        return null;
                    }
                }
            }
            String[] stringValues = getStringValues(this.mParser, this.mKeyHevcencBLModel);
            if (stringValues != null) {
                for (String str : stringValues) {
                    if (DeviceInfoMonitor.getModel().equalsIgnoreCase(str)) {
                        AVCoreLog.e(TAG, "getHevcEncoderAbility failed. Build.MODEL.equalsIgnoreCase(models[i]).");
                        return null;
                    }
                }
            }
            String[] stringValues2 = getStringValues(this.mParser, this.mKeyHevcencBLProduct);
            if (stringValues2 != null) {
                for (String str2 : stringValues2) {
                    if (Build.PRODUCT.equalsIgnoreCase(str2)) {
                        AVCoreLog.e(TAG, "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(products[i]).");
                        return null;
                    }
                }
            }
            String[] stringValues3 = getStringValues(this.mParser, this.mKeyHevcencBLFingerprint);
            if (stringValues3 != null) {
                for (String str3 : stringValues3) {
                    if (Build.PRODUCT.equalsIgnoreCase(str3)) {
                        AVCoreLog.e(TAG, "getHevcEncoderAbility failed. Build.PRODUCT.equalsIgnoreCase(fingerprints[i].");
                        return null;
                    }
                }
            }
            int[] intValues3 = getIntValues(this.mParser, this.mKeyHevcencWLMaxW);
            if (intValues3 != null && (i16 = intValues3[0]) > 0) {
                hWCodecAbility.maxW = i16;
            }
            int[] intValues4 = getIntValues(this.mParser, this.mKeyHevcencWLMaxH);
            if (intValues4 != null && (i3 = intValues4[0]) > 0) {
                hWCodecAbility.maxH = i3;
            }
            return hWCodecAbility;
        } catch (Exception e16) {
            e16.printStackTrace();
            AVCoreLog.e(TAG, "getHevcEncoderAbility failed. err msg = " + e16.getMessage());
            return null;
        }
    }

    int[] getIntValues(IConfigParser iConfigParser, String str) {
        return iConfigParser.getIntValues(str);
    }

    String[] getStringValues(IConfigParser iConfigParser, String str) {
        return iConfigParser.getStringValues(str);
    }

    @Override // com.tencent.av.config.api.ICodecConfigParser
    public void init(IConfigParser iConfigParser) {
        String str;
        if (iConfigParser != null && !iConfigParser.isEmpty() && iConfigParser.getData().contains(VERSION2_FLAG)) {
            this.mVer = 2;
        }
        this.mParser = iConfigParser;
        if (this.mVer == 2) {
            str = STR_ROOT2;
        } else {
            str = STR_ROOT1;
        }
        this.mStrRoot = str;
        AVCoreLog.e(TAG, "ver = " + this.mVer + ", root = " + this.mStrRoot);
        this.mKeyAvcdecWLMinSdk = this.mStrRoot + STR_AVC_DECODER + STR_WHITE_LIST + "min_sdk";
        this.mKeyAvcdecWLMinVersion = this.mStrRoot + STR_AVC_DECODER + STR_WHITE_LIST + STR_MIN_VERSION;
        this.mKeyAvcdecBLModel = this.mStrRoot + STR_AVC_DECODER + STR_BLACK_LIST + "model";
        this.mKeyAvcdecBLProduct = this.mStrRoot + STR_AVC_DECODER + STR_BLACK_LIST + "product";
        this.mKeyAvcdecBLFingerprint = this.mStrRoot + STR_AVC_DECODER + STR_BLACK_LIST + "fingerprint";
        this.mKeyAvcdecBLSdk = this.mStrRoot + STR_AVC_DECODER + STR_BLACK_LIST + STR_SDK;
        this.mKeyAvcdecBLVersion = this.mStrRoot + STR_AVC_DECODER + STR_BLACK_LIST + "version";
        this.mKeyAvcdecWLMaxW = this.mStrRoot + STR_AVC_DECODER + STR_WHITE_LIST + STR_MAX_W;
        this.mKeyAvcdecWLMaxH = this.mStrRoot + STR_AVC_DECODER + STR_WHITE_LIST + STR_MAX_H;
        this.mKeyAvcencWLMinSdk = this.mStrRoot + STR_AVC_ENCODER + STR_WHITE_LIST + "min_sdk";
        this.mKeyAvcencWLMinVersion = this.mStrRoot + STR_AVC_ENCODER + STR_WHITE_LIST + STR_MIN_VERSION;
        this.mKeyAvcencBLModel = this.mStrRoot + STR_AVC_ENCODER + STR_BLACK_LIST + "model";
        this.mKeyAvcencBLProduct = this.mStrRoot + STR_AVC_ENCODER + STR_BLACK_LIST + "product";
        this.mKeyAvcencBLFingerprint = this.mStrRoot + STR_AVC_ENCODER + STR_BLACK_LIST + "fingerprint";
        this.mKeyAvcencBLSdk = this.mStrRoot + STR_AVC_ENCODER + STR_BLACK_LIST + STR_SDK;
        this.mKeyAvcencBLVersion = this.mStrRoot + STR_AVC_ENCODER + STR_BLACK_LIST + "version";
        this.mKeyAvcencWLMaxW = this.mStrRoot + STR_AVC_ENCODER + STR_WHITE_LIST + STR_MAX_W;
        this.mKeyAvcencWLMaxH = this.mStrRoot + STR_AVC_ENCODER + STR_WHITE_LIST + STR_MAX_H;
        this.mKeyHevcdecWLMinSdk = this.mStrRoot + STR_HEVC_DECODER + STR_WHITE_LIST + "min_sdk";
        this.mKeyHevcdecWLMinVersion = this.mStrRoot + STR_HEVC_DECODER + STR_WHITE_LIST + STR_MIN_VERSION;
        this.mKeyHevcdecBLModel = this.mStrRoot + STR_HEVC_DECODER + STR_BLACK_LIST + "model";
        this.mKeyHevcdecBLProduct = this.mStrRoot + STR_HEVC_DECODER + STR_BLACK_LIST + "product";
        this.mKeyHevcdecBLFingerprint = this.mStrRoot + STR_HEVC_DECODER + STR_BLACK_LIST + "fingerprint";
        this.mKeyHevcdecBLSdk = this.mStrRoot + STR_HEVC_DECODER + STR_BLACK_LIST + STR_SDK;
        this.mKeyHevcdecBLVersion = this.mStrRoot + STR_HEVC_DECODER + STR_BLACK_LIST + "version";
        this.mKeyHevcdecWLMaxW = this.mStrRoot + STR_HEVC_DECODER + STR_WHITE_LIST + STR_MAX_W;
        this.mKeyHevcdecWLMaxH = this.mStrRoot + STR_HEVC_DECODER + STR_WHITE_LIST + STR_MAX_H;
        this.mKeyHevcencWLMinSdk = this.mStrRoot + STR_HEVC_ENCODER + STR_WHITE_LIST + "min_sdk";
        this.mKeyHevcencWLMinVersion = this.mStrRoot + STR_HEVC_ENCODER + STR_WHITE_LIST + STR_MIN_VERSION;
        this.mKeyHevcencBLModel = this.mStrRoot + STR_HEVC_ENCODER + STR_BLACK_LIST + "model";
        this.mKeyHevcencBLProduct = this.mStrRoot + STR_HEVC_ENCODER + STR_BLACK_LIST + "product";
        this.mKeyHevcencBLFingerprint = this.mStrRoot + STR_HEVC_ENCODER + STR_BLACK_LIST + "fingerprint";
        this.mKeyHevcencBLSdk = this.mStrRoot + STR_HEVC_ENCODER + STR_BLACK_LIST + STR_SDK;
        this.mKeyHevcencBLVersion = this.mStrRoot + STR_HEVC_ENCODER + STR_BLACK_LIST + "version";
        this.mKeyHevcencWLMaxW = this.mStrRoot + STR_HEVC_ENCODER + STR_WHITE_LIST + STR_MAX_W;
        this.mKeyHevcencWLMaxH = this.mStrRoot + STR_HEVC_ENCODER + STR_WHITE_LIST + STR_MAX_H;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.mStrRoot);
        sb5.append(STR_ASYNC);
        sb5.append("min_sdk");
        this.mKeyAsyncMinSdk = sb5.toString();
        this.mKeyAsyncCodec = this.mStrRoot + STR_ASYNC + "codec";
    }

    @Override // com.tencent.av.config.api.ICodecConfigParser
    public boolean isEnableAsyncApi(int i3) {
        int[] intValues;
        IConfigParser iConfigParser = this.mParser;
        if (iConfigParser == null) {
            return false;
        }
        try {
            int[] intValues2 = getIntValues(iConfigParser, this.mKeyAsyncMinSdk);
            if (intValues2 != null && Build.VERSION.SDK_INT >= intValues2[0] && (intValues = getIntValues(this.mParser, this.mKeyAsyncCodec)) != null) {
                if (ArrayUtils.contains(intValues, i3)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
