package com.tencent.avcore.jni.codec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MediaCodecHelper {
    static IPatchRedirector $redirector_ = null;
    private static final String AVC_CODEC_MIME = "video/avc";
    public static final String FEATURE_LowLatency = "low-latency";
    private static final String HEVC_CODEC_MIME = "video/hevc";
    public static final String KEY_LOW_LATENCY = "low-latency";
    private static final String TAG = "MediaCodecHelper";
    private static final List<String> exynosDecoderPrefixes;
    private static final List<String> kirinDecoderPrefixes;
    private static final List<String> qualcommDecoderPrefixes;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14332);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        LinkedList linkedList = new LinkedList();
        qualcommDecoderPrefixes = linkedList;
        linkedList.add("omx.qcom");
        linkedList.add("c2.qti");
        LinkedList linkedList2 = new LinkedList();
        kirinDecoderPrefixes = linkedList2;
        linkedList2.add("omx.hisi");
        LinkedList linkedList3 = new LinkedList();
        exynosDecoderPrefixes = linkedList3;
        linkedList3.add("omx.exynos");
    }

    public MediaCodecHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean decoderSupportsAndroidRLowLatency(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                if (mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("low-latency")) {
                    AVCoreLog.e(TAG, mediaCodecInfo.getName() + " Low latency decoding mode supported (FEATURE_LowLatency)");
                    return true;
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            AVCoreLog.e(TAG, mediaCodecInfo.getName() + " not support decoding Low latency");
            return false;
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    private static List<MediaCodecInfo> findKnownSafeDecoderV29(String str, int i3) throws Exception {
        MediaCodecInfo mediaCodecInfo;
        ArrayList arrayList = new ArrayList();
        for (int i16 = 0; i16 < 2; i16++) {
            Iterator<MediaCodecInfo> it = getMediaCodecList().iterator();
            while (it.hasNext()) {
                MediaCodecInfo next = it.next();
                if (!next.isEncoder()) {
                    String[] supportedTypes = next.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i17 = 0;
                    while (true) {
                        if (i17 < length) {
                            String str2 = supportedTypes[i17];
                            if (str2.equalsIgnoreCase(str)) {
                                AVCoreLog.e(TAG, "Examining decoder capabilities of " + next.getName() + " (round " + (i16 + 1) + ")");
                                if (!isCodecBlacklisted(next)) {
                                    MediaCodecInfo.CodecCapabilities capabilitiesForType = next.getCapabilitiesForType(str2);
                                    if (i16 == 0 && !decoderSupportsAndroidRLowLatency(next, str2)) {
                                        AVCoreLog.e(TAG, "Skipping decoder that lacks FEATURE_LowLatency for round 1");
                                    } else if (i3 != -1) {
                                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType.profileLevels;
                                        int length2 = codecProfileLevelArr.length;
                                        int i18 = 0;
                                        while (true) {
                                            if (i18 < length2) {
                                                if (codecProfileLevelArr[i18].profile == i3) {
                                                    mediaCodecInfo = next;
                                                    break;
                                                }
                                                i18++;
                                            } else {
                                                mediaCodecInfo = null;
                                                break;
                                            }
                                        }
                                        if (mediaCodecInfo != null) {
                                            arrayList.add(mediaCodecInfo);
                                            AVCoreLog.e(TAG, "Decoder " + next.getName() + " supports required profile");
                                            break;
                                        }
                                        AVCoreLog.e(TAG, "Decoder " + next.getName() + " does NOT support required profile");
                                    } else {
                                        arrayList.add(next);
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                            i17++;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static List<MediaCodecInfo> getMediaCodecDecoderV29(String str, int i3) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(findKnownSafeDecoderV29(str, i3));
        } catch (Exception unused) {
            AVCoreLog.e(TAG, "getMediaCodecDecoderV29 error");
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    private static LinkedList<MediaCodecInfo> getMediaCodecList() {
        LinkedList<MediaCodecInfo> linkedList = new LinkedList<>();
        Collections.addAll(linkedList, new MediaCodecList(0).getCodecInfos());
        return linkedList;
    }

    public static boolean isCodecBlacklisted(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        if (Build.VERSION.SDK_INT >= 29) {
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            if (isSoftwareOnly) {
                return true;
            }
        }
        return isCodecBlacklistedBelowV29(mediaCodecInfo);
    }

    @SuppressLint({"NewApi"})
    private static boolean isCodecBlacklistedBelowV29(MediaCodecInfo mediaCodecInfo) {
        String name = mediaCodecInfo.getName();
        if (name.contains(".sw.") || name.contains(".SW.") || name.contains("google") || name.contains("Google") || name.contains("GOOGLE") || name.startsWith("omx.google.") || name.startsWith("omx.ffmpeg.") || name.startsWith("c2.android.") || name.startsWith("c2.google.")) {
            return true;
        }
        return false;
    }

    private static boolean isDecoderInList(List<String> list, String str) {
        for (String str2 : list) {
            if (str.length() >= str2.length() && str.substring(0, str2.length()).equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static void setDecoderLowLatencyOptions(MediaFormat mediaFormat, MediaCodecInfo mediaCodecInfo, String str) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30 && decoderSupportsAndroidRLowLatency(mediaCodecInfo, str)) {
            mediaFormat.setInteger("low-latency", 1);
            return;
        }
        if (i3 >= 26) {
            if (isDecoderInList(qualcommDecoderPrefixes, mediaCodecInfo.getName())) {
                mediaFormat.setInteger("vendor.qti-ext-dec-low-latency.enable", 1);
                return;
            }
            if (isDecoderInList(kirinDecoderPrefixes, mediaCodecInfo.getName())) {
                mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                mediaFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
            } else if ("video/avc".equalsIgnoreCase(str) && isDecoderInList(exynosDecoderPrefixes, mediaCodecInfo.getName())) {
                mediaFormat.setInteger("vendor.rtc-ext-dec-low-latency.enable", 1);
            }
        }
    }
}
