package com.tencent.avcore.jni.codec;

import android.media.MediaCodecInfo;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.luggage.wxa.rf.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import java.util.List;

/* compiled from: P */
@RequiresApi(api = 16)
/* loaded from: classes3.dex */
public class NativeCodecBase {
    static IPatchRedirector $redirector_ = null;
    public static final int H264BaselineProfile = 3;
    public static final int H264HighProfile = 5;
    public static final int H264MainProfile = 4;
    public static final int H265MainProfile = 6;
    private static AVCCaps gAVCDecoderCaps;
    private static AVCCaps gAVCEncoderCaps;
    private static AVCCaps gHEVCDecoderCaps;
    private static AVCCaps gHEVCEncoderCaps;
    static boolean sUseAsyncAPI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AVCCaps {
        static IPatchRedirector $redirector_;
        public int height;
        public int profile;
        public int width;

        AVCCaps() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.width = 0;
            this.height = 0;
            this.profile = 3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14362);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sUseAsyncAPI = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NativeCodecBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            sUseAsyncAPI = AndroidCodecAdapterProxy.getInstance().isSupportAsyncAPI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntValuesImp(String str, String str2, String str3, boolean z16, boolean z17) {
        if ("supportAsync".equalsIgnoreCase(str3)) {
            return sUseAsyncAPI ? 1 : 0;
        }
        AndroidCodecBase.isCallFuncTimeout = z17;
        if (str2.equalsIgnoreCase("video/avc")) {
            if (z16) {
                if (gAVCDecoderCaps == null) {
                    initAVCDecoderCaps(str);
                }
                if (gAVCDecoderCaps != null) {
                    if (str3.equalsIgnoreCase("width")) {
                        return gAVCDecoderCaps.width;
                    }
                    if (str3.equalsIgnoreCase("height")) {
                        return gAVCDecoderCaps.height;
                    }
                    if (str3.equalsIgnoreCase("profile")) {
                        return gAVCDecoderCaps.profile;
                    }
                    return 0;
                }
                return 0;
            }
            if (gAVCEncoderCaps == null) {
                initAVCEncoderCaps(str);
            }
            if (gAVCEncoderCaps != null) {
                if (str3.equalsIgnoreCase("width")) {
                    return gAVCEncoderCaps.width;
                }
                if (str3.equalsIgnoreCase("height")) {
                    return gAVCEncoderCaps.height;
                }
                if (str3.equalsIgnoreCase("profile")) {
                    return gAVCEncoderCaps.profile;
                }
                return 0;
            }
            return 0;
        }
        if (str2.equalsIgnoreCase("video/hevc")) {
            if (z16) {
                if (gHEVCDecoderCaps == null) {
                    initHevcDecoderCaps(str);
                }
                if (gHEVCDecoderCaps != null) {
                    if (str3.equalsIgnoreCase("width")) {
                        return gHEVCDecoderCaps.width;
                    }
                    if (str3.equalsIgnoreCase("height")) {
                        return gHEVCDecoderCaps.height;
                    }
                    if (str3.equalsIgnoreCase("profile")) {
                        return gHEVCDecoderCaps.profile;
                    }
                    return 0;
                }
                return 0;
            }
            if (gHEVCEncoderCaps == null) {
                initHevcEncoderCaps();
            }
            if (gHEVCEncoderCaps != null) {
                if (str3.equalsIgnoreCase("width")) {
                    return gHEVCEncoderCaps.width;
                }
                if (str3.equalsIgnoreCase("height")) {
                    return gHEVCEncoderCaps.height;
                }
                if (str3.equalsIgnoreCase("profile")) {
                    return gHEVCEncoderCaps.profile;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    private static void initAVCDecoderCaps(String str) {
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.d(str, "initAVCDecoderCaps");
        }
        List<MediaCodecInfo> decoderInfos = AndroidCodecBase.getDecoderInfos("video/avc");
        if (decoderInfos.size() == 0) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(str, "initAVCDecoderCaps fail, list.size\u4e3a0");
                return;
            }
            return;
        }
        int i3 = 0;
        MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(decoderInfos.get(0), "video/avc");
        if (codecCapabilities != null && codecCapabilities.profileLevels != null) {
            gAVCDecoderCaps = new AVCCaps();
            while (true) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
                if (i3 < codecProfileLevelArr.length) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i3];
                    int i16 = codecProfileLevel.profile;
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 4) {
                                if (i16 != 8) {
                                    if (i16 != 16) {
                                        if (i16 != 32) {
                                            if (i16 == 64) {
                                                AVCCaps aVCCaps = gAVCDecoderCaps;
                                                if (aVCCaps.profile <= 5) {
                                                    aVCCaps.profile = 5;
                                                }
                                            }
                                        } else {
                                            AVCCaps aVCCaps2 = gAVCDecoderCaps;
                                            if (aVCCaps2.profile <= 5) {
                                                aVCCaps2.profile = 5;
                                            }
                                        }
                                    } else {
                                        AVCCaps aVCCaps3 = gAVCDecoderCaps;
                                        if (aVCCaps3.profile <= 5) {
                                            aVCCaps3.profile = 5;
                                        }
                                    }
                                } else {
                                    AVCCaps aVCCaps4 = gAVCDecoderCaps;
                                    if (aVCCaps4.profile <= 5) {
                                        aVCCaps4.profile = 5;
                                    }
                                }
                            } else {
                                AVCCaps aVCCaps5 = gAVCDecoderCaps;
                                if (aVCCaps5.profile <= 5) {
                                    aVCCaps5.profile = 5;
                                }
                            }
                        } else {
                            AVCCaps aVCCaps6 = gAVCDecoderCaps;
                            if (aVCCaps6.profile <= 4) {
                                aVCCaps6.profile = 4;
                            }
                        }
                    } else {
                        AVCCaps aVCCaps7 = gAVCDecoderCaps;
                        if (aVCCaps7.profile <= 3) {
                            aVCCaps7.profile = 3;
                        }
                    }
                    int i17 = codecProfileLevel.level;
                    if (i17 != 1) {
                        if (i17 != 2) {
                            switch (i17) {
                                case 4:
                                    AVCCaps aVCCaps8 = gAVCDecoderCaps;
                                    if (aVCCaps8.width >= 352 && aVCCaps8.height >= 288) {
                                        break;
                                    } else {
                                        aVCCaps8.width = g.CTRL_INDEX;
                                        aVCCaps8.height = 288;
                                        break;
                                    }
                                case 8:
                                    AVCCaps aVCCaps9 = gAVCDecoderCaps;
                                    if (aVCCaps9.width >= 352 && aVCCaps9.height >= 288) {
                                        break;
                                    } else {
                                        aVCCaps9.width = g.CTRL_INDEX;
                                        aVCCaps9.height = 288;
                                        break;
                                    }
                                case 16:
                                    AVCCaps aVCCaps10 = gAVCDecoderCaps;
                                    if (aVCCaps10.width >= 352 && aVCCaps10.height >= 288) {
                                        break;
                                    } else {
                                        aVCCaps10.width = g.CTRL_INDEX;
                                        aVCCaps10.height = 288;
                                        break;
                                    }
                                case 32:
                                    AVCCaps aVCCaps11 = gAVCDecoderCaps;
                                    if (aVCCaps11.width >= 352 && aVCCaps11.height >= 288) {
                                        break;
                                    } else {
                                        aVCCaps11.width = g.CTRL_INDEX;
                                        aVCCaps11.height = 288;
                                        break;
                                    }
                                case 64:
                                    AVCCaps aVCCaps12 = gAVCDecoderCaps;
                                    if (aVCCaps12.width >= 352 && aVCCaps12.height >= 576) {
                                        break;
                                    } else {
                                        aVCCaps12.width = g.CTRL_INDEX;
                                        aVCCaps12.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                                        break;
                                    }
                                    break;
                                case 128:
                                    AVCCaps aVCCaps13 = gAVCDecoderCaps;
                                    if (aVCCaps13.width >= 720 && aVCCaps13.height >= 576) {
                                        break;
                                    } else {
                                        aVCCaps13.width = 720;
                                        aVCCaps13.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                                        break;
                                    }
                                    break;
                                case 256:
                                    AVCCaps aVCCaps14 = gAVCDecoderCaps;
                                    if (aVCCaps14.width >= 720 && aVCCaps14.height >= 576) {
                                        break;
                                    } else {
                                        aVCCaps14.width = 720;
                                        aVCCaps14.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                                        break;
                                    }
                                    break;
                                case 512:
                                    AVCCaps aVCCaps15 = gAVCDecoderCaps;
                                    if (aVCCaps15.width >= 1280 && aVCCaps15.height >= 720) {
                                        break;
                                    } else {
                                        aVCCaps15.width = 1280;
                                        aVCCaps15.height = 720;
                                        break;
                                    }
                                    break;
                                case 1024:
                                    AVCCaps aVCCaps16 = gAVCDecoderCaps;
                                    if (aVCCaps16.width >= 1280 && aVCCaps16.height >= 1024) {
                                        break;
                                    } else {
                                        aVCCaps16.width = 1280;
                                        aVCCaps16.height = 1024;
                                        break;
                                    }
                                    break;
                                case 2048:
                                    AVCCaps aVCCaps17 = gAVCDecoderCaps;
                                    if (aVCCaps17.width >= 2048 && aVCCaps17.height >= 1024) {
                                        break;
                                    } else {
                                        aVCCaps17.width = 2048;
                                        aVCCaps17.height = 1024;
                                        break;
                                    }
                                    break;
                                case 4096:
                                    AVCCaps aVCCaps18 = gAVCDecoderCaps;
                                    if (aVCCaps18.width >= 2048 && aVCCaps18.height >= 1024) {
                                        break;
                                    } else {
                                        aVCCaps18.width = 2048;
                                        aVCCaps18.height = 1024;
                                        break;
                                    }
                                    break;
                                case 8192:
                                    AVCCaps aVCCaps19 = gAVCDecoderCaps;
                                    if (aVCCaps19.width >= 2048 && aVCCaps19.height >= 1088) {
                                        break;
                                    } else {
                                        aVCCaps19.width = 2048;
                                        aVCCaps19.height = 1088;
                                        break;
                                    }
                                    break;
                                case 16384:
                                    AVCCaps aVCCaps20 = gAVCDecoderCaps;
                                    if (aVCCaps20.width >= 3680 && aVCCaps20.height >= 1536) {
                                        break;
                                    } else {
                                        aVCCaps20.width = 3680;
                                        aVCCaps20.height = 1536;
                                        break;
                                    }
                                case 32768:
                                    AVCCaps aVCCaps21 = gAVCDecoderCaps;
                                    if (aVCCaps21.width >= 4096 && aVCCaps21.height >= 2048) {
                                        break;
                                    } else {
                                        aVCCaps21.width = 4096;
                                        aVCCaps21.height = 2048;
                                        break;
                                    }
                                default:
                                    if (i17 < 1) {
                                        AVCCaps aVCCaps22 = gAVCDecoderCaps;
                                        if (aVCCaps22.width >= 176 && aVCCaps22.height >= 144) {
                                            break;
                                        } else {
                                            aVCCaps22.width = 176;
                                            aVCCaps22.height = 144;
                                            break;
                                        }
                                    } else if (i17 > 32768) {
                                        AVCCaps aVCCaps23 = gAVCDecoderCaps;
                                        if (aVCCaps23.width >= 4096 && aVCCaps23.height >= 2160) {
                                            break;
                                        } else {
                                            aVCCaps23.width = 4096;
                                            aVCCaps23.height = 2160;
                                            break;
                                        }
                                    } else {
                                        AVCoreLog.e(str, "initAVCDecoder caps.profileLevels[k].level: " + codecCapabilities.profileLevels[i3].level);
                                        break;
                                    }
                            }
                        } else {
                            AVCCaps aVCCaps24 = gAVCDecoderCaps;
                            if (aVCCaps24.width < 352 || aVCCaps24.height < 288) {
                                aVCCaps24.width = g.CTRL_INDEX;
                                aVCCaps24.height = 288;
                            }
                        }
                    } else {
                        AVCCaps aVCCaps25 = gAVCDecoderCaps;
                        if (aVCCaps25.width < 176 || aVCCaps25.height < 144) {
                            aVCCaps25.width = 176;
                            aVCCaps25.height = 144;
                        }
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private static void initAVCEncoderCaps(String str) {
        List<MediaCodecInfo> endoderInfos = AndroidCodecBase.getEndoderInfos("video/avc");
        if (endoderInfos.size() == 0) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(str, "initAVCEncoderCaps fail, lists.size\u4e3a0");
                return;
            }
            return;
        }
        MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(endoderInfos.get(0), "video/avc");
        if (codecCapabilities != null && codecCapabilities.profileLevels != null) {
            gAVCEncoderCaps = new AVCCaps();
            if (codecCapabilities.profileLevels.length > 0) {
                for (int i3 = 0; i3 < codecCapabilities.profileLevels.length; i3++) {
                    if (AVCoreLog.isColorLevel()) {
                        AVCoreLog.e(str, "initAVCEncoderCaps, index[" + i3 + "], profile[" + codecCapabilities.profileLevels[i3].profile + "]");
                    }
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecCapabilities.profileLevels[i3];
                    if (codecProfileLevel.profile == 1) {
                        gAVCEncoderCaps.profile = 3;
                        if (!AVCoreLog.isGrayVersion() && !AVCoreLog.isDebugVersion()) {
                            codecProfileLevel.level = 512;
                        } else {
                            codecProfileLevel.level = 8192;
                        }
                        setLevel(codecProfileLevel, gAVCEncoderCaps);
                    }
                }
                return;
            }
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e(str, "initAVCEncoderCaps fail, caps[true]");
            }
        }
    }

    private static void initHevcDecoderCaps(String str) {
        String str2;
        List<MediaCodecInfo> decoderInfos = AndroidCodecBase.getDecoderInfos("video/hevc");
        if (decoderInfos.size() == 0) {
            return;
        }
        int i3 = 0;
        MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(decoderInfos.get(0), "video/hevc");
        if (codecCapabilities != null && codecCapabilities.profileLevels != null) {
            gHEVCDecoderCaps = new AVCCaps();
            if (codecCapabilities.profileLevels.length == 0 && ((AVCoreLog.isGrayVersion() || AVCoreLog.isDebugVersion()) && (str2 = Build.HARDWARE) != null && (str2.startsWith("hi6250") || str2.startsWith("hi3650")))) {
                AVCCaps aVCCaps = gHEVCDecoderCaps;
                aVCCaps.profile = 1;
                aVCCaps.width = 1920;
                aVCCaps.height = 1080;
            }
            while (true) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
                if (i3 < codecProfileLevelArr.length) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i3];
                    int i16 = codecProfileLevel.profile;
                    if (i16 <= 1) {
                        AVCCaps aVCCaps2 = gHEVCDecoderCaps;
                        if (aVCCaps2.profile <= 1) {
                            aVCCaps2.profile = 1;
                        }
                    } else if (i16 == 2) {
                        AVCCaps aVCCaps3 = gHEVCDecoderCaps;
                        if (aVCCaps3.profile <= 2) {
                            aVCCaps3.profile = 2;
                        }
                    } else if (i16 >= 2) {
                        AVCCaps aVCCaps4 = gHEVCDecoderCaps;
                        if (aVCCaps4.profile <= 2) {
                            aVCCaps4.profile = 2;
                        }
                    }
                    int i17 = codecProfileLevel.level;
                    if (i17 > 1 && i17 > 2) {
                        if (i17 != 4 && i17 != 8) {
                            if (i17 != 16 && i17 != 32) {
                                if (i17 != 64 && i17 != 128) {
                                    if (i17 != 256 && i17 != 512) {
                                        if (i17 != 1024 && i17 != 2048) {
                                            if (i17 != 4096 && i17 != 8192) {
                                                if (i17 != 16384 && i17 != 32768) {
                                                    if (i17 != 65536 && i17 != 131072) {
                                                        if (i17 != 262144 && i17 != 524288) {
                                                            if (i17 != 1048576 && i17 != 2097152) {
                                                                if (i17 != 4194304 && i17 != 8388608) {
                                                                    if (i17 < 16777216 && i17 < 33554432) {
                                                                        AVCoreLog.e(str, "initHevcDecoderCaps caps.profileLevels[" + i3 + "].level = " + codecCapabilities.profileLevels[i3].level);
                                                                    } else {
                                                                        AVCCaps aVCCaps5 = gHEVCDecoderCaps;
                                                                        if (aVCCaps5.width < 8192 || aVCCaps5.height < 4320) {
                                                                            aVCCaps5.width = 8192;
                                                                            aVCCaps5.height = 4320;
                                                                        }
                                                                    }
                                                                } else {
                                                                    AVCCaps aVCCaps6 = gHEVCDecoderCaps;
                                                                    if (aVCCaps6.width < 8192 || aVCCaps6.height < 4320) {
                                                                        aVCCaps6.width = 8192;
                                                                        aVCCaps6.height = 4320;
                                                                    }
                                                                }
                                                            } else {
                                                                AVCCaps aVCCaps7 = gHEVCDecoderCaps;
                                                                if (aVCCaps7.width < 8192 || aVCCaps7.height < 4320) {
                                                                    aVCCaps7.width = 8192;
                                                                    aVCCaps7.height = 4320;
                                                                }
                                                            }
                                                        } else {
                                                            AVCCaps aVCCaps8 = gHEVCDecoderCaps;
                                                            if (aVCCaps8.width < 4096 || aVCCaps8.height < 2160) {
                                                                aVCCaps8.width = 4096;
                                                                aVCCaps8.height = 2160;
                                                            }
                                                        }
                                                    } else {
                                                        AVCCaps aVCCaps9 = gHEVCDecoderCaps;
                                                        if (aVCCaps9.width < 4096 || aVCCaps9.height < 2160) {
                                                            aVCCaps9.width = 4096;
                                                            aVCCaps9.height = 2160;
                                                        }
                                                    }
                                                } else {
                                                    AVCCaps aVCCaps10 = gHEVCDecoderCaps;
                                                    if (aVCCaps10.width < 4096 || aVCCaps10.height < 2160) {
                                                        aVCCaps10.width = 4096;
                                                        aVCCaps10.height = 2160;
                                                    }
                                                }
                                            } else {
                                                AVCCaps aVCCaps11 = gHEVCDecoderCaps;
                                                if (aVCCaps11.width < 2048 || aVCCaps11.height < 1080) {
                                                    aVCCaps11.width = 2048;
                                                    aVCCaps11.height = 1080;
                                                }
                                            }
                                        } else {
                                            AVCCaps aVCCaps12 = gHEVCDecoderCaps;
                                            if (aVCCaps12.width < 2048 || aVCCaps12.height < 1080) {
                                                aVCCaps12.width = 2048;
                                                aVCCaps12.height = 1080;
                                            }
                                        }
                                    } else {
                                        AVCCaps aVCCaps13 = gHEVCDecoderCaps;
                                        if (aVCCaps13.width < 1280 || aVCCaps13.height < 720) {
                                            aVCCaps13.width = 1280;
                                            aVCCaps13.height = 720;
                                        }
                                    }
                                } else {
                                    AVCCaps aVCCaps14 = gHEVCDecoderCaps;
                                    if (aVCCaps14.width < 960 || aVCCaps14.height < 540) {
                                        aVCCaps14.width = 960;
                                        aVCCaps14.height = 540;
                                    }
                                }
                            } else {
                                AVCCaps aVCCaps15 = gHEVCDecoderCaps;
                                if (aVCCaps15.width < 640 || aVCCaps15.height < 360) {
                                    aVCCaps15.width = 640;
                                    aVCCaps15.height = 360;
                                }
                            }
                        } else {
                            AVCCaps aVCCaps16 = gHEVCDecoderCaps;
                            if (aVCCaps16.width < 352 || aVCCaps16.height < 288) {
                                aVCCaps16.width = g.CTRL_INDEX;
                                aVCCaps16.height = 288;
                            }
                        }
                    } else {
                        AVCCaps aVCCaps17 = gHEVCDecoderCaps;
                        if (aVCCaps17.width < 176 || aVCCaps17.height < 144) {
                            aVCCaps17.width = 176;
                            aVCCaps17.height = 144;
                        }
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private static void initHevcEncoderCaps() {
        List<MediaCodecInfo> decoderInfos = AndroidCodecBase.getDecoderInfos("video/hevc");
        if (decoderInfos.size() == 0) {
            if (AVCoreLog.isColorLevel()) {
                AVCoreLog.e("NativieCodec", "initHevcEncoderCaps fail, lists.size\u4e3a0");
                return;
            }
            return;
        }
        int i3 = 0;
        MediaCodecInfo.CodecCapabilities codecCapabilities = AndroidCodecBase.getCodecCapabilities(decoderInfos.get(0), "video/hevc");
        if (codecCapabilities != null && codecCapabilities.profileLevels != null) {
            gHEVCEncoderCaps = new AVCCaps();
            while (true) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecCapabilities.profileLevels;
                if (i3 < codecProfileLevelArr.length) {
                    MediaCodecInfo.CodecProfileLevel codecProfileLevel = codecProfileLevelArr[i3];
                    if (codecProfileLevel.profile == 1) {
                        AVCCaps aVCCaps = gHEVCEncoderCaps;
                        aVCCaps.profile = 1;
                        codecProfileLevel.level = 16384;
                        setHevcLevel(codecProfileLevel, aVCCaps);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private static void setHevcLevel(MediaCodecInfo.CodecProfileLevel codecProfileLevel, AVCCaps aVCCaps) {
        int i3 = codecProfileLevel.level;
        if (i3 == 1) {
            if (aVCCaps.width < 192 || aVCCaps.height < 144) {
                aVCCaps.width = 192;
                aVCCaps.height = 144;
                return;
            }
            return;
        }
        if (i3 == 4) {
            if (aVCCaps.width < 352 || aVCCaps.height < 288) {
                aVCCaps.width = g.CTRL_INDEX;
                aVCCaps.height = 288;
                return;
            }
            return;
        }
        if (i3 == 16) {
            if (aVCCaps.width < 352 || aVCCaps.height < 576) {
                aVCCaps.width = g.CTRL_INDEX;
                aVCCaps.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                return;
            }
            return;
        }
        if (i3 == 64) {
            if (aVCCaps.width < 720 || aVCCaps.height < 576) {
                aVCCaps.width = 720;
                aVCCaps.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                return;
            }
            return;
        }
        if (i3 == 256) {
            if (aVCCaps.width < 1280 || aVCCaps.height < 720) {
                aVCCaps.width = 1280;
                aVCCaps.height = 720;
                return;
            }
            return;
        }
        if (i3 == 1024) {
            if (aVCCaps.width < 1920 || aVCCaps.height < 1080) {
                aVCCaps.width = 1920;
                aVCCaps.height = 1080;
                return;
            }
            return;
        }
        if (i3 == 4096) {
            if (aVCCaps.width < 1920 || aVCCaps.height < 1080) {
                aVCCaps.width = 1920;
                aVCCaps.height = 1080;
                return;
            }
            return;
        }
        if (i3 == 16384) {
            if (aVCCaps.width < 4096 || aVCCaps.height < 2048) {
                aVCCaps.width = 4096;
                aVCCaps.height = 2048;
                return;
            }
            return;
        }
        if (i3 == 65536) {
            if (aVCCaps.width < 4096 || aVCCaps.height < 2048) {
                aVCCaps.width = 4096;
                aVCCaps.height = 2048;
                return;
            }
            return;
        }
        if (i3 == 262144) {
            if (aVCCaps.width < 4096 || aVCCaps.height < 2048) {
                aVCCaps.width = 4096;
                aVCCaps.height = 2048;
                return;
            }
            return;
        }
        if (i3 == 1048576) {
            if (aVCCaps.width < 4096 || aVCCaps.height < 4096) {
                aVCCaps.width = 4096;
                aVCCaps.height = 4096;
                return;
            }
            return;
        }
        if (i3 == 4194304) {
            if (aVCCaps.width < 4096 || aVCCaps.height < 4096) {
                aVCCaps.width = 4096;
                aVCCaps.height = 4096;
                return;
            }
            return;
        }
        if (i3 == 16777216) {
            if (aVCCaps.width < 4096 || aVCCaps.height < 4096) {
                aVCCaps.width = 4096;
                aVCCaps.height = 4096;
                return;
            }
            return;
        }
        AVCoreLog.e("NativeCodec", "setHevcLevel level.level = " + codecProfileLevel.level);
    }

    protected static void setLevel(MediaCodecInfo.CodecProfileLevel codecProfileLevel, AVCCaps aVCCaps) {
        int i3 = codecProfileLevel.level;
        if (i3 != 1) {
            if (i3 != 2) {
                switch (i3) {
                    case 4:
                        if (aVCCaps.width < 352 || aVCCaps.height < 288) {
                            aVCCaps.width = g.CTRL_INDEX;
                            aVCCaps.height = 288;
                            return;
                        }
                        return;
                    case 8:
                        if (aVCCaps.width < 352 || aVCCaps.height < 288) {
                            aVCCaps.width = g.CTRL_INDEX;
                            aVCCaps.height = 288;
                            return;
                        }
                        return;
                    case 16:
                        if (aVCCaps.width < 352 || aVCCaps.height < 288) {
                            aVCCaps.width = g.CTRL_INDEX;
                            aVCCaps.height = 288;
                            return;
                        }
                        return;
                    case 32:
                        if (aVCCaps.width < 352 || aVCCaps.height < 288) {
                            aVCCaps.width = g.CTRL_INDEX;
                            aVCCaps.height = 288;
                            return;
                        }
                        return;
                    case 64:
                        if (aVCCaps.width < 352 || aVCCaps.height < 576) {
                            aVCCaps.width = g.CTRL_INDEX;
                            aVCCaps.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                            return;
                        }
                        return;
                    case 128:
                        if (aVCCaps.width < 720 || aVCCaps.height < 576) {
                            aVCCaps.width = 720;
                            aVCCaps.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                            return;
                        }
                        return;
                    case 256:
                        if (aVCCaps.width < 720 || aVCCaps.height < 576) {
                            aVCCaps.width = 720;
                            aVCCaps.height = PlayerResources.ViewId.CANVAS_VIDEO_TOTAL_TRAFFIC_TEXT;
                            return;
                        }
                        return;
                    case 512:
                        if (aVCCaps.width < 1280 || aVCCaps.height < 720) {
                            aVCCaps.width = 1280;
                            aVCCaps.height = 720;
                            return;
                        }
                        return;
                    case 1024:
                        if (aVCCaps.width < 1280 || aVCCaps.height < 1024) {
                            aVCCaps.width = 1280;
                            aVCCaps.height = 1024;
                            return;
                        }
                        return;
                    case 2048:
                        if (aVCCaps.width < 2048 || aVCCaps.height < 1024) {
                            aVCCaps.width = 2048;
                            aVCCaps.height = 1024;
                            return;
                        }
                        return;
                    case 4096:
                        if (aVCCaps.width < 2048 || aVCCaps.height < 1024) {
                            aVCCaps.width = 2048;
                            aVCCaps.height = 1024;
                            return;
                        }
                        return;
                    case 8192:
                        if (aVCCaps.width < 2048 || aVCCaps.height < 1088) {
                            aVCCaps.width = 2048;
                            aVCCaps.height = 1088;
                            return;
                        }
                        return;
                    case 16384:
                        if (aVCCaps.width < 3680 || aVCCaps.height < 1536) {
                            aVCCaps.width = 3680;
                            aVCCaps.height = 1536;
                            return;
                        }
                        return;
                    case 32768:
                        if (aVCCaps.width < 4096 || aVCCaps.height < 2304) {
                            aVCCaps.width = 4096;
                            aVCCaps.height = 2304;
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
            if (aVCCaps.width < 352 || aVCCaps.height < 288) {
                aVCCaps.width = g.CTRL_INDEX;
                aVCCaps.height = 288;
                return;
            }
            return;
        }
        if (aVCCaps.width < 176 || aVCCaps.height < 144) {
            aVCCaps.width = 176;
            aVCCaps.height = 144;
        }
    }
}
