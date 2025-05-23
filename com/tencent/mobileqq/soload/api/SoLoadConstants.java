package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SoLoadConstants {
    static IPatchRedirector $redirector_ = null;
    public static final String APNG_SO = "apng_encoder";
    public static final String BRICK_SO = "sava";
    public static final String LIBS_4_CORE = "tinyskia";
    public static final String LIBS_4_JSC = "jsc";
    public static final String MONET_SO = "monet";
    public static final String QQ_SO_KEY_FEATURE_CONFIG = "qqso_key_feature_switch";
    public static final String QQ_SO_MMKV_KEY_PREFIX = "qqso_";
    public static final String QQ_SO_PRIORITY_FEATURE_SWITCH = "qqso_feature_switch";
    public static final String QQ_STEP_REPORT_FEATURE_SWITCH = "qqso_step_report_switch";
    public static final String SONAME_AV_HARDWARE_DETECT_SO = "VideoEngine";
    public static final String SONAME_AV_HEVC_DEC = "TcHevcDec2";
    public static final String SONAME_AV_HEVC_ENC = "TcHevcEnc";
    public static final String SONAME_AV_LIGHT_SR = "LightSR";
    public static final String SONAME_AV_OLD_AVC_DEC = "TcVpxDec_old";
    public static final String SONAME_CKEYGENERATORV2 = "ckeygeneratorV2";
    public static final String SONAME_CKGUARD = "ckguard";
    public static final String SONAME_DOWNLOADPROXY = "DownloadProxy-gray";
    public static final String SONAME_FACE_TRACK_WRAP = "facetrackwrap";
    public static final String SONAME_FLEXBOX = "flexbox";
    public static final String SONAME_GRADISH_WRAPPER = "gradishwrapper";
    public static final String SONAME_HDIFF_PATCH = "hpatchz";
    public static final String SONAME_HIPPY = "hippy";
    public static final String SONAME_HIPPY_QQ_021306 = "hippy_qq_021306";
    public static final String SONAME_IMSDK = "ImSDK";
    public static final String SONAME_KARAOKE_GUILD = "KaraokeGuild";
    public static final String SONAME_MP4V2 = "mp4v2";
    public static final String SONAME_MP4_SYNTHESIZER = "mp4synthesizer";
    public static final String SONAME_NATIVE_LIB = "native-lib";
    public static final String SONAME_NNPACK = "nnpack";
    public static final String SONAME_QWALLET_CFTUTILS = "cftutils";
    public static final String SONAME_SHARPDEC = "TcHevcDec";
    public static final String SONAME_TPCORE_GRAY = "TPCore-gray";
    public static final String SONAME_TPCORE_MASTER = "TPCore-master-gray";
    public static final String SONAME_TRTC = "trtc_entry_64";
    public static final String SONAME_V8_SHARED = "v8_shared";
    public static final String SONAME_X264 = "x264";
    public static final String SONAME_YTCOMMON = "YTCommon";
    public static final String SONAME_YTHANDDETECTOR = "YTHandDetector";
    public static final String SONAME_YTILLMINATION = "YTIllumination";
    public static final String SONAME_ZPLAN_MULTI_DOWNLOADER = "multidownloader";

    public SoLoadConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
