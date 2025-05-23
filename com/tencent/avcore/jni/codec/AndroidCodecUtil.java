package com.tencent.avcore.jni.codec;

import android.media.MediaCodecInfo;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class AndroidCodecUtil {
    static IPatchRedirector $redirector_;
    public static int mH264DecBaseLineLevel;
    public static int mH264DecHighProfileLevel;
    public static int mH264EncBaseLineLevel;
    public static int mH264EncHighProfileLevel;
    public static int mH265DecLevel;
    public static int mH265EncLevel;
    public static boolean mHasGetLevelInfo;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14260);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        mHasGetLevelInfo = false;
        mH264EncBaseLineLevel = 0;
        mH264DecBaseLineLevel = 0;
        mH264EncHighProfileLevel = 0;
        mH264DecHighProfileLevel = 0;
        mH265EncLevel = 0;
        mH265DecLevel = 0;
    }

    public AndroidCodecUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @RequiresApi(api = 16)
    private static void getDecodeInfo(String str) {
        List<MediaCodecInfo> decoderInfos = AndroidCodecBase.getDecoderInfos(str);
        if (decoderInfos.size() == 0) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e("NativeCodec", "getDecoderInfos list.size\u4e3a0");
                return;
            }
            return;
        }
        int i3 = 0;
        MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(decoderInfos.get(0), str);
        if (codecCapabilities != null && codecCapabilities.profileLevels != null) {
            if (str.contains("video/avc")) {
                while (i3 < codecCapabilities.profileLevels.length) {
                    AVCoreLog.d("NativeCodec", "AVC DEC caps: " + i3 + ", profile: " + codecCapabilities.profileLevels[i3].profile + ", level:" + codecCapabilities.profileLevels[i3].level);
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecCapabilities.profileLevels[i3];
                    int i16 = codecProfileLevel.profile;
                    if (i16 != 1) {
                        if (i16 == 8) {
                            mH264DecHighProfileLevel = codecProfileLevel.level;
                        }
                    } else {
                        mH264DecBaseLineLevel = codecProfileLevel.level;
                    }
                    i3++;
                }
                return;
            }
            if (str.contains("video/hevc")) {
                while (i3 < codecCapabilities.profileLevels.length) {
                    AVCoreLog.d("NativeCodec", "HEVC DEC caps: " + i3 + ", profile: " + codecCapabilities.profileLevels[i3].profile + ", level:" + codecCapabilities.profileLevels[i3].level);
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecCapabilities.profileLevels[i3];
                    if (codecProfileLevel2.profile == 1) {
                        mH265DecLevel = codecProfileLevel2.level;
                        return;
                    }
                    i3++;
                }
            }
        }
    }

    @RequiresApi(api = 16)
    private static void getEncodeInfo(String str) {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        List<MediaCodecInfo> endoderInfos = AndroidCodecBase.getEndoderInfos(str);
        int i3 = 0;
        int i16 = 0;
        while (i16 < endoderInfos.size() && (codecCapabilities = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(i16), str)) != null) {
            if (ArrayUtils.contains(codecCapabilities.colorFormats, 21) || ArrayUtils.contains(codecCapabilities.colorFormats, 19)) {
                break;
            } else {
                i16++;
            }
        }
        i16 = 0;
        if (endoderInfos.size() == 0) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e("NativeCodec", "getEndoderInfos list.size\u4e3a0");
                return;
            }
            return;
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities2 = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(i16), str);
        if (codecCapabilities2 != null) {
            if (str.contains("video/avc")) {
                while (i3 < codecCapabilities2.profileLevels.length) {
                    AVCoreLog.d("NativeCodec", "AVC ENC caps: " + i3 + ", profile: " + codecCapabilities2.profileLevels[i3].profile + ", level:" + codecCapabilities2.profileLevels[i3].level);
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecCapabilities2.profileLevels[i3];
                    int i17 = codecProfileLevel.profile;
                    if (i17 != 1) {
                        if (i17 == 8) {
                            mH264EncHighProfileLevel = codecProfileLevel.level;
                        }
                    } else {
                        mH264EncBaseLineLevel = codecProfileLevel.level;
                    }
                    i3++;
                }
                return;
            }
            if (str.contains("video/hevc")) {
                while (i3 < codecCapabilities2.profileLevels.length) {
                    AVCoreLog.d("NativeCodec", "HEVC ENC caps: " + i3 + ", profile: " + codecCapabilities2.profileLevels[i3].profile + ", level:" + codecCapabilities2.profileLevels[i3].level);
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = codecCapabilities2.profileLevels[i3];
                    if (codecProfileLevel2.profile == 1) {
                        mH265EncLevel = codecProfileLevel2.level;
                        return;
                    }
                    i3++;
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void hardwareCodecLevelInfo() {
        if (mHasGetLevelInfo) {
            return;
        }
        String[] strArr = {"video/avc", "video/hevc"};
        for (int i3 = 0; i3 < 2; i3++) {
            String str = strArr[i3];
            getEncodeInfo(str);
            getDecodeInfo(str);
        }
        mHasGetLevelInfo = true;
    }
}
