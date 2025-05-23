package com.tencent.gamematrix.gmcg.sdk.env;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGCodecHelper {
    private static final String TAG = "GmCg-Codec";
    private static Integer h264ResFpsLevel;
    private static Integer h265ResFpsLevel;
    private static Boolean isH264HardSupport;
    private static Boolean isH265HardSupport;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static CharSequence getCodecInfo() {
        int i3;
        Object obj;
        StringBuilder sb5 = new StringBuilder();
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        int length = codecInfos.length;
        int i16 = 0;
        while (i16 < length) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i16];
            if (!mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length2 = supportedTypes.length;
                int i17 = 0;
                while (i17 < length2) {
                    String str = supportedTypes[i17];
                    if ((!"video/hevc".equalsIgnoreCase(str) && !"video/avc".equalsIgnoreCase(str)) || !isHardwareDecoder(mediaCodecInfo)) {
                        i3 = i16;
                    } else {
                        sb5.append("----------------");
                        sb5.append(mediaCodecInfo.getName());
                        sb5.append("----------------");
                        sb5.append('\n');
                        sb5.append("support type: ");
                        sb5.append(str);
                        sb5.append('\n');
                        MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities();
                        if (videoCapabilities != null) {
                            sb5.append("support width: ");
                            sb5.append(videoCapabilities.getSupportedWidths());
                            sb5.append('\n');
                            sb5.append("support height: ");
                            sb5.append(videoCapabilities.getSupportedHeights());
                            sb5.append('\n');
                            sb5.append("is support 1080p 60fps: ");
                            sb5.append(videoCapabilities.areSizeAndRateSupported(1920, 1080, 60.0d));
                            sb5.append("\n");
                            sb5.append("is support 1080p 30fps: ");
                            i3 = i16;
                            sb5.append(videoCapabilities.areSizeAndRateSupported(1920, 1080, 30.0d));
                            sb5.append("\n");
                            sb5.append("is support 720p 60fps: ");
                            sb5.append(videoCapabilities.areSizeAndRateSupported(1280, 720, 60.0d));
                            sb5.append("\n");
                            sb5.append("is support 720p 30fps: ");
                            sb5.append(videoCapabilities.areSizeAndRateSupported(1280, 720, 30.0d));
                            sb5.append("\n");
                            Object obj2 = null;
                            try {
                                obj = videoCapabilities.getSupportedFrameRatesFor(1920, 1080);
                                try {
                                    obj2 = videoCapabilities.getSupportedFrameRatesFor(1280, 720);
                                } catch (Exception e16) {
                                    e = e16;
                                    CGLog.e(e.getMessage());
                                    sb5.append("1080p fps: ");
                                    if (obj == null) {
                                    }
                                    sb5.append(obj);
                                    sb5.append("\n");
                                    sb5.append("720p fps: ");
                                    if (obj2 == null) {
                                    }
                                    sb5.append(obj2);
                                    sb5.append("\n");
                                    i17++;
                                    i16 = i3;
                                }
                            } catch (Exception e17) {
                                e = e17;
                                obj = null;
                            }
                            sb5.append("1080p fps: ");
                            if (obj == null) {
                                obj = "not support";
                            }
                            sb5.append(obj);
                            sb5.append("\n");
                            sb5.append("720p fps: ");
                            if (obj2 == null) {
                                obj2 = "not support";
                            }
                            sb5.append(obj2);
                            sb5.append("\n");
                        } else {
                            i3 = i16;
                            Log.w(TAG, str + " no capabilities");
                        }
                    }
                    i17++;
                    i16 = i3;
                }
            }
            i16++;
        }
        return sb5;
    }

    public static int getH264ResFpsLevel(Context context) {
        Integer num = h264ResFpsLevel;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(getResFpsLevel(context, "video/avc"));
        h264ResFpsLevel = valueOf;
        return valueOf.intValue();
    }

    public static int getH265ResFpsLevel(Context context) {
        Integer num = h265ResFpsLevel;
        if (num != null) {
            return num.intValue();
        }
        Integer valueOf = Integer.valueOf(getResFpsLevel(context, "video/hevc"));
        h265ResFpsLevel = valueOf;
        return valueOf.intValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d1 A[SYNTHETIC] */
    @RequiresApi(api = 21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getResFpsLevel(Context context, String str) {
        int i3;
        if (!isHardH264Support() && !isHardH265Support()) {
            return 1;
        }
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(new Point());
        float max = (Math.max(r2.x, r2.y) * 1.0f) / Math.min(r2.x, r2.y);
        int i16 = (int) (720 * max);
        int i17 = (int) (max * 1080);
        int i18 = 0;
        CGLog.i(TAG, String.format(Locale.getDefault(), "1080p\u5b9e\u9645\u5c3a\u5bf8: %d \u00d7 %d\n720p\u5b9e\u9645\u5c3a\u5bf8: %d \u00d7 %d", Integer.valueOf(i17), 1080, Integer.valueOf(i16), 720));
        int length = codecInfos.length;
        int i19 = 1;
        int i26 = 0;
        while (i26 < length) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i26];
            if (!mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length2 = supportedTypes.length;
                for (int i27 = i18; i27 < length2; i27++) {
                    String str2 = supportedTypes[i27];
                    if (str.equalsIgnoreCase(str2) && isHardwareDecoder(mediaCodecInfo)) {
                        MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str2).getVideoCapabilities();
                        if (videoCapabilities != null) {
                            if (videoCapabilities.areSizeAndRateSupported(i17, 1080, 60.0d)) {
                                i3 = 4;
                            } else if (videoCapabilities.areSizeAndRateSupported(i16, 720, 60.0d)) {
                                i3 = 3;
                            } else if (videoCapabilities.areSizeAndRateSupported(i17, 1080, 30.0d)) {
                                i3 = 2;
                            }
                            if (i19 >= i3) {
                                i19 = i3;
                            }
                        }
                        i3 = 1;
                        if (i19 >= i3) {
                        }
                    }
                }
            }
            i26++;
            i18 = 0;
        }
        return i19;
    }

    private static String getSoCInfo() {
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.startsWith("Hardware")) {
                    str = readLine.split(":\\s+", 2)[1];
                    break;
                }
            }
            bufferedReader.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return str;
    }

    @RequiresApi(api = 21)
    private static boolean isHardDecodeSupport(String str) {
        boolean z16 = false;
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (supportedTypes == null) {
                    CGLog.w("supportedTypes is null");
                } else {
                    for (String str2 : supportedTypes) {
                        try {
                            CGLog.i("codecInfo: " + mediaCodecInfo.getName() + " type: " + str2);
                        } catch (Exception e16) {
                            CGLog.e("isHardDecodeSupport failed: " + e16);
                        }
                        if (str.equalsIgnoreCase(str2) && isHardwareDecoder(mediaCodecInfo)) {
                            CGLog.i(mediaCodecInfo.getName() + " support hard decode " + str);
                            z16 = true;
                        }
                    }
                }
            }
        }
        return z16;
    }

    public static boolean isHardH264Support() {
        Boolean bool = isH264HardSupport;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(isHardDecodeSupport("video/avc"));
        isH264HardSupport = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isHardH265Support() {
        Boolean bool = isH265HardSupport;
        if (bool != null) {
            return bool.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(isHardDecodeSupport("video/hevc"));
        isH265HardSupport = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isHardwareCodecSupported(int i3, int i16) {
        String[] supportedTypes;
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder() && (supportedTypes = mediaCodecInfo.getSupportedTypes()) != null) {
                for (String str : supportedTypes) {
                    if ("video/hevc".equalsIgnoreCase(str) && isHardwareDecoder(mediaCodecInfo)) {
                        Log.i(TAG, "\u652f\u6301\u786c\u4ef6: " + mediaCodecInfo.getName());
                        MediaCodecInfo.VideoCapabilities videoCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getVideoCapabilities();
                        if (videoCapabilities != null && videoCapabilities.isSizeSupported(i3, i16)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isHardwareDecoder(MediaCodecInfo mediaCodecInfo) {
        boolean isHardwareAccelerated;
        String canonicalName;
        boolean isHardwareAccelerated2;
        boolean isSoftwareOnly;
        boolean isVendor;
        boolean isAlias;
        String name = mediaCodecInfo.getName();
        if (Build.VERSION.SDK_INT >= 29) {
            isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("name: ");
            sb5.append(name);
            sb5.append(", canonicalName: ");
            canonicalName = mediaCodecInfo.getCanonicalName();
            sb5.append(canonicalName);
            sb5.append(", isHardwareAccelerated: ");
            isHardwareAccelerated2 = mediaCodecInfo.isHardwareAccelerated();
            sb5.append(isHardwareAccelerated2);
            sb5.append(", isSoftwareOnly: ");
            isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
            sb5.append(isSoftwareOnly);
            sb5.append(", isVendor: ");
            isVendor = mediaCodecInfo.isVendor();
            sb5.append(isVendor);
            sb5.append(", isAlias: ");
            isAlias = mediaCodecInfo.isAlias();
            sb5.append(isAlias);
            CGLog.i(sb5.toString());
            return isHardwareAccelerated;
        }
        if (TextUtils.isEmpty(name) || !name.startsWith("OMX.") || name.startsWith("OMX.google.")) {
            return false;
        }
        return true;
    }
}
