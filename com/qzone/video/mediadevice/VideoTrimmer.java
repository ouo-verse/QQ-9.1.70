package com.qzone.video.mediadevice;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.util.ag;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCKeyGenerator;
import com.tencent.qzonehub.api.utils.IQzoneHardwareRestriction;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.richmedia.videocompress.VideoConverter;
import com.tencent.richmedia.videocompress.VideoConverterConfig;
import com.tencent.xweb.FileReaderHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneVideoCommonUtils;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import cooperation.vip.manager.i;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes37.dex */
public class VideoTrimmer {
    private static int A;
    private static int B;
    private static int C;
    private static int G;
    private static int H;
    private static boolean I;
    private static boolean J;
    private static boolean K;
    private static int L;
    private static int M;

    /* renamed from: i, reason: collision with root package name */
    private static VideoConverter f60061i;

    /* renamed from: j, reason: collision with root package name */
    private static int f60062j;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f60063k;

    /* renamed from: l, reason: collision with root package name */
    private static int f60064l;

    /* renamed from: m, reason: collision with root package name */
    private static boolean f60065m;

    /* renamed from: n, reason: collision with root package name */
    private static int f60066n;

    /* renamed from: o, reason: collision with root package name */
    private static int f60067o;

    /* renamed from: p, reason: collision with root package name */
    private static int f60068p;

    /* renamed from: q, reason: collision with root package name */
    private static int f60069q;

    /* renamed from: r, reason: collision with root package name */
    private static int f60070r;

    /* renamed from: s, reason: collision with root package name */
    private static String f60071s;

    /* renamed from: t, reason: collision with root package name */
    private static String f60072t;

    /* renamed from: u, reason: collision with root package name */
    private static String f60073u;

    /* renamed from: v, reason: collision with root package name */
    private static String f60074v;

    /* renamed from: w, reason: collision with root package name */
    private static String f60075w;

    /* renamed from: x, reason: collision with root package name */
    private static String f60076x;

    /* renamed from: y, reason: collision with root package name */
    private static int f60077y;

    /* renamed from: z, reason: collision with root package name */
    private static String f60078z;

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f60053a = {"baseline", "main", "high"};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f60054b = {SemanticAttributes.HttpFlavorValues.HTTP_2_0, "2.1", "2.2", "3.0", "3.1", "3.2", "4.0", TVKCKeyGenerator.ENCRYPT_VER_4, TVKCKeyGenerator.ENCRYPT_VER_4_2};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f60055c = {"ultrafast", "superfast", "veryfast", VideoConverterConfig.SoftwareConfig.PRESET_FASTER, VideoConverterConfig.SoftwareConfig.PRESET_FAST, "medium", VideoConverterConfig.SoftwareConfig.PRESET_SLOW, VideoConverterConfig.SoftwareConfig.PRESET_SLOWER, "veryslow"};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f60056d = {"film", "animation", "grain", "stillimage", "psnr", QzoneConfig.DefaultValue.VIDEO_TUNE, "fastdecode", "zerolatency"};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f60057e = {0, 1, 2};

    /* renamed from: f, reason: collision with root package name */
    private static int f60058f = 1;

    /* renamed from: g, reason: collision with root package name */
    private static int f60059g = 2;

    /* renamed from: h, reason: collision with root package name */
    private static int f60060h = 3;
    private static boolean D = false;
    private static String E = "";
    private static String F = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return Pattern.matches("cpu[0-9]", file.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b implements VideoConverter.Processor {

        /* renamed from: h, reason: collision with root package name */
        private static final int[] f60082h = {1, 2, 8};

        /* renamed from: i, reason: collision with root package name */
        private static final int[] f60083i = {32, 64, 128, 256, 512, 1024, 2048, 4096, 8192};

        /* renamed from: a, reason: collision with root package name */
        final String f60084a;

        /* renamed from: b, reason: collision with root package name */
        final int f60085b;

        /* renamed from: c, reason: collision with root package name */
        final int f60086c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f60087d;

        /* renamed from: e, reason: collision with root package name */
        final long f60088e;

        /* renamed from: f, reason: collision with root package name */
        final long f60089f;

        /* renamed from: g, reason: collision with root package name */
        boolean f60090g;

        b(String str, int i3, int i16, boolean z16, long j3, long j16) {
            this.f60084a = str;
            this.f60085b = i3;
            this.f60087d = z16;
            this.f60088e = j3;
            this.f60089f = j16;
            if (i16 > 0) {
                this.f60086c = i16;
            } else {
                this.f60086c = 30;
            }
            if (str == null) {
                throw new IllegalArgumentException("null == outputFilePath");
            }
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public VideoConverterConfig getEncodeConfig(int i3, int i16) {
            int i17;
            VideoConverterConfig videoConverterConfig = new VideoConverterConfig();
            if (i3 <= i16) {
                i3 = i16;
            }
            videoConverterConfig.output = this.f60084a;
            videoConverterConfig.bitrateMode = VideoTrimmer.f60057e[VideoTrimmer.C];
            if (!this.f60087d) {
                if (i3 < VideoTrimmer.A) {
                    videoConverterConfig.videoBitRate = (int) (((VideoTrimmer.B * 1.0d) / VideoTrimmer.A) * i3);
                    videoConverterConfig.scaleRate = 1.0f;
                } else {
                    videoConverterConfig.videoBitRate = VideoTrimmer.B;
                    videoConverterConfig.scaleRate = VideoTrimmer.A / i3;
                }
                if (this.f60086c > VideoTrimmer.f60077y) {
                    i17 = VideoTrimmer.f60077y;
                } else {
                    i17 = this.f60086c;
                }
                videoConverterConfig.videoFrameRate = i17;
            } else {
                videoConverterConfig.videoBitRate = this.f60085b;
                videoConverterConfig.videoFrameRate = this.f60086c;
                videoConverterConfig.scaleRate = 1.0f;
            }
            videoConverterConfig.iFrameInterval = VideoTrimmer.H;
            videoConverterConfig.setProfileLevel = !Build.MANUFACTURER.equalsIgnoreCase("xiaomi");
            int i18 = 0;
            int i19 = 0;
            while (true) {
                if (i19 >= VideoTrimmer.f60053a.length) {
                    break;
                }
                if (VideoTrimmer.f60076x.equalsIgnoreCase(VideoTrimmer.f60053a[i19])) {
                    videoConverterConfig.profile = f60082h[i19];
                    break;
                }
                i19++;
            }
            while (true) {
                if (i18 >= VideoTrimmer.f60054b.length) {
                    break;
                }
                if (VideoTrimmer.f60078z.equalsIgnoreCase(VideoTrimmer.f60054b[i18])) {
                    videoConverterConfig.level = f60083i[i18];
                    break;
                }
                i18++;
            }
            videoConverterConfig.beginTime = this.f60088e;
            videoConverterConfig.endTime = this.f60089f;
            if (QZLog.isColorLevel()) {
                QZLog.d("[upload2]VideoTrimmer", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + videoConverterConfig.setRotation + ", scaleRate=" + videoConverterConfig.scaleRate + ", videoBitRate=" + videoConverterConfig.videoBitRate + ", videoFrameRate=" + videoConverterConfig.videoFrameRate + ", mIsOrigin=" + this.f60087d + ", beginTime=" + videoConverterConfig.beginTime + ", endTime=" + videoConverterConfig.endTime);
            }
            return videoConverterConfig;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onCancel() {
            QZLog.i("[upload2]VideoTrimmer", 1, "CompressTask, step: HWCompressProcessor onCanceled");
            this.f60090g = true;
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onFail(Throwable th5) {
            QZLog.e("[upload2]VideoTrimmer", "CompressTask, step: HWCompressProcessor onFailed");
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onProgress(int i3) {
            QZLog.d("[upload2]VideoTrimmer", 1, "CompressTask, step: HWCompressProcessor onProgress:" + i3);
        }

        @Override // com.tencent.richmedia.videocompress.VideoConverter.Processor
        public void onSuccess() {
            QZLog.d("[upload2]VideoTrimmer", 1, "CompressTask, step: HWCompressProcessor onSuccessed");
        }
    }

    public static void k(String str) {
        VideoConverter videoConverter = f60061i;
        if (videoConverter != null) {
            videoConverter.cancelCompress();
        }
        ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).cancel(str);
    }

    public static int m() {
        if (M == 0) {
            try {
                File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new a());
                if (listFiles == null) {
                    return 1;
                }
                M = listFiles.length;
            } catch (Exception e16) {
                QZLog.w("[upload2]VideoTrimmer", "getCpuCores exception occured,e=", e16);
                M = 1;
            }
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload2]VideoTrimmer", 2, "getCpuCores, num=" + M);
        }
        return M;
    }

    private static boolean n() {
        String lowerCase;
        QZoneVideoCommonUtils.VideoSupport trimHWSupport = QZoneVideoCommonUtils.getTrimHWSupport();
        if (!trimHWSupport.isAvailable()) {
            QZLog.i("[upload2]VideoTrimmer", 1, "isHwCompressEnable: hardware trim support not available : " + trimHWSupport.getTip());
            return false;
        }
        if (DeviceInfoMonitor.getModel() == null) {
            lowerCase = "";
        } else {
            lowerCase = DeviceInfoMonitor.getModel().trim().toLowerCase();
        }
        if (cp.a.a(E, "\\|", lowerCase, "[upload2]VideoTrimmer")) {
            QZLog.i("[upload2]VideoTrimmer", "isHwCompressEnable: in force compress list");
            I = true;
            return true;
        }
        if (f60062j != 1) {
            QZLog.i("[upload2]VideoTrimmer", "isHwCompressEnable: enableHw != 1");
            return false;
        }
        if (Build.VERSION.SDK_INT < G) {
            QZLog.i("[upload2]VideoTrimmer", "isHwCompressEnable\uff1asdk too low");
            return false;
        }
        if (cp.a.a(F, "\\|", lowerCase, "[upload2]VideoTrimmer")) {
            QZLog.i("[upload2]VideoTrimmer", "isHwCompressEnable: in black list");
            return false;
        }
        String str = Build.MANUFACTURER;
        if (str.equalsIgnoreCase("xiaomi")) {
            QZLog.i("[upload2]VideoTrimmer", "isHwCompressEnable: xiaomi");
            return false;
        }
        if (!str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            return true;
        }
        QZLog.i("[upload2]VideoTrimmer", "isHwCompressEnable: huawei");
        return false;
    }

    private static void o() {
        String str;
        f60062j = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TRIM_ENABLE_HW, 1);
        f60064l = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TIME_NO_TRIM_THRESHOLD, 1000);
        f60065m = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_CLIENT_COMPRESS, 1) == 1;
        f60066n = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_MAX_BITRATE, 700000);
        f60067o = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_LONGEST_EDGE, 960);
        f60068p = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_FRAME_RATE, 24);
        f60069q = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_AUDIO_MAX_SAMPLE, 44100);
        f60070r = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_AUDIO_MAX_BITRATE, 64000);
        if (((IQzoneHardwareRestriction) QRoute.api(IQzoneHardwareRestriction.class)).meetHardwareRestriction(0, 2)) {
            f60071s = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_PRESET, "medium");
        } else {
            f60071s = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_PRESET_FOR_LOW_CPU, "veryfast");
        }
        f60072t = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_TUNE, QzoneConfig.DefaultValue.VIDEO_TUNE);
        f60073u = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_PROFILE, "high");
        f60074v = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_LEVEL, "3.0");
        H = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_IFRAME_INTERVAL, 1);
        f60075w = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_OTHER_CONFIG, "-refs 2 -subq 3 -me_method hex -sws_flags lanczos -rc-lookahead 30  -weightp 1");
        f60076x = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_PROFILE, "high");
        f60077y = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_FRAME_RATE, 30);
        A = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_LONGEST_EDGE, 960);
        B = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_MAX_BITRATE, 700000);
        F = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_COMPRESS_BLACKLIST, "TRT-AL00|TRT-AL00A|KNT-AL10|NXT-AL10|HUAWEI NXT-TL00|HUAWEI NXT-DL00|HUAWEI NXT-CL00|OPPO R9s|OPPO R9s Plus|OPPO R11|OPPO R11 Plus|OPPO R11t|OPPO R11t Plus|OPPO R11s|OPPO R11s Plus|OPPO R11st|OPPO R11s Plust|PACM00|PACT00|PAAM00|PAAT00|vivo x9|vivo x9Plus|vivo x20|vivo X20A|vivo X20Plus A|vivo x20Plus|x21a|x21ud|x21uda|vivo y85|vivo y85a|M5 Note");
        G = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_COMPRESS_ANDROID_VERSION, 24);
        f60078z = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_LEVEL, "4.0");
        C = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_HW_BITRATE_MODE, 1);
        E = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_FORCE_HW_COMPRESS_LIST, "BKL-AL20|EML-AL00");
        L = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_SUPPORT_MULTITHREAD, 1);
        String[] split = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NEWPARAM_ALL, "0,1280,2000000|0,1280,2000000|960,700000|960,700000").split("\\|");
        if (i.r().z() >= 0) {
            D = true;
        }
        try {
            if (split.length == 4) {
                String[] split2 = split[0].split(",");
                String[] split3 = split[1].split(",");
                String[] split4 = split[2].split(",");
                String[] split5 = split[3].split(",");
                if (split4.length == 2 && split5.length == 2) {
                    f60067o = Integer.valueOf(split4[0]).intValue();
                    f60066n = Integer.valueOf(split4[1]).intValue();
                    A = Integer.valueOf(split5[0]).intValue();
                    B = Integer.valueOf(split5[1]).intValue();
                }
                if (D && split2.length == 3 && split3.length == 3) {
                    if (i.r().x() >= Integer.valueOf(split2[0]).intValue()) {
                        f60067o = Integer.valueOf(split2[1]).intValue();
                        f60066n = Integer.valueOf(split2[2]).intValue();
                        A = Integer.valueOf(split3[1]).intValue();
                        B = Integer.valueOf(split3[2]).intValue();
                    }
                }
            }
        } catch (Throwable unused) {
            QZLog.i("[upload2]VideoTrimmer", 1, "isQualityDebugEnable=" + f60063k);
        }
        if (K) {
            QZLog.i("[upload2]VideoTrimmer", 1, "use Qcircle rate...");
            String[] split6 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_QCIRCLE_VIDEO_COMPRESS_PARAM_ALL, "1280,3000000|1280,3000000").split("\\|");
            try {
                if (split6.length == 2) {
                    String[] split7 = split6[0].split(",");
                    String[] split8 = split6[1].split(",");
                    f60067o = Integer.valueOf(split7[0]).intValue();
                    f60066n = Integer.valueOf(split7[1]).intValue();
                    A = Integer.valueOf(split8[0]).intValue();
                    B = Integer.valueOf(split8[1]).intValue();
                }
            } catch (Throwable unused2) {
                QZLog.i("[upload2]VideoTrimmer", 1, "isQualityDebugEnable=" + f60063k);
            }
        }
        QZLog.i("[upload2]VideoTrimmer", 1, "loadConfig enableHW=" + f60062j + " timeThreshold=" + f60064l + " clientCompress=" + f60065m + " videoMaxBitrate=" + f60066n + " videoLongestEdge=" + f60067o + " frameRate=" + f60068p + " audioMaxSample=" + f60069q + " audioMaxBitrate=" + f60070r + " preset=" + f60071s + " tune=" + f60072t + " profile=" + f60073u + " level=" + f60074v + " mHwVideoLongestEdge:" + A + " mHwVideoMaxBitrate:" + B);
        f60063k = LocalMultiProcConfig.getBool("key_video_quality_debug_enable", false);
        if (QZLog.isDevelopLevel()) {
            QZLog.i("[upload2]VideoTrimmer", 4, "isQualityDebugEnable=" + f60063k);
        }
        if (f60063k) {
            boolean bool = LocalMultiProcConfig.getBool("key_force_software_encode", false);
            boolean bool2 = LocalMultiProcConfig.getBool("key_video_quality_only_change_encode_mode", false);
            I = LocalMultiProcConfig.getBool("key_force_software_encode", false);
            int i3 = LocalMultiProcConfig.getInt("key_video_quality_long_edge", f60067o);
            int i16 = LocalMultiProcConfig.getInt("key_video_quality_bitrate", f60066n / 1000) * 1000;
            int i17 = LocalMultiProcConfig.getInt("key_video_quality_frame_rate", f60068p);
            int i18 = LocalMultiProcConfig.getInt("key_video_quality_i_frame_interval", H);
            int i19 = LocalMultiProcConfig.getInt("key_video_quality_profile", 0);
            int i26 = LocalMultiProcConfig.getInt("key_video_quality_level", 0);
            int i27 = LocalMultiProcConfig.getInt("key_video_quality_preset", 0);
            int i28 = LocalMultiProcConfig.getInt("key_video_quality_tune", 0);
            int i29 = LocalMultiProcConfig.getInt("key_video_quality_encode_mode", 0);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadConfig debug quality, forceSoftwareEncode=");
            sb5.append(bool);
            sb5.append(" forceHardwareEncode=");
            sb5.append(I);
            sb5.append(" debugLongEdge=");
            sb5.append(i3);
            sb5.append(" debugBitrate=");
            sb5.append(i16);
            sb5.append(" debugFrameRate=");
            sb5.append(i17);
            sb5.append(" debugIFrameInterval=");
            sb5.append(i18);
            sb5.append(" debugProfile=");
            String[] strArr = f60053a;
            sb5.append(strArr[i19]);
            sb5.append(" debugLevel=");
            String[] strArr2 = f60054b;
            str = QzoneConfig.MAIN_KEY_MINI_VIDEO;
            sb5.append(strArr2[i26]);
            sb5.append(" debugPreset=");
            String[] strArr3 = f60055c;
            sb5.append(strArr3[i27]);
            sb5.append(" debugTune=");
            String[] strArr4 = f60056d;
            sb5.append(strArr4[i28]);
            QZLog.i("[upload2]VideoTrimmer", 1, sb5.toString());
            if (bool) {
                f60062j = 0;
            }
            if (!bool2) {
                f60067o = i3;
                f60066n = i16;
                f60068p = i17;
                H = i18;
                f60073u = strArr[i19];
                f60074v = strArr2[i26];
                f60071s = strArr3[i27];
                f60072t = strArr4[i28];
            }
            if (i29 == 0) {
                f60071s = strArr3[5];
                f60075w = "-refs 3 -subq 3 -me_method hex";
            } else if (i29 == 1) {
                f60071s = strArr3[8];
                f60075w = "";
            }
        } else {
            str = QzoneConfig.MAIN_KEY_MINI_VIDEO;
        }
        if (J) {
            String str2 = str;
            f60066n = QzoneConfig.getInstance().getConfig(str2, QzoneConfig.SECONDARY_WEISHI_VIDEO_MAX_BITRATE, QzoneConfig.DefaultValue.DEFAULT_WEISHI_VIDEO_MAX_BITRATE);
            f60067o = QzoneConfig.getInstance().getConfig(str2, QzoneConfig.SECONDARY_WEISHI_VIDEO_LONGESTEDGE, 1280);
        }
    }

    private static void p(final String str, final String str2, final String str3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.ReportThread).post(new Runnable() { // from class: com.qzone.video.mediadevice.VideoTrimmer.1
            @Override // java.lang.Runnable
            public void run() {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("PhoneType", DeviceInfoMonitor.getModel());
                hashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
                hashMap.put("app_version", QUA.getQUA3());
                hashMap.put(str2, str3);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(LoginData.getInstance().getUinString(), str, true, 0L, 0L, hashMap, null);
            }
        });
    }

    public static int r(String str, String str2, String str3, String str4, long j3, long j16, long j17, boolean z16, int i3, Handler handler, String str5, String str6, boolean z17, boolean z18) {
        boolean z19;
        long j18;
        long j19;
        int i16;
        String str7;
        int i17;
        String str8;
        int i18;
        String str9 = str4;
        String str10 = "[upload2]VideoTrimmer";
        QZLog.i("[upload2]VideoTrimmer", 1, "trimVideo: input=" + str3 + " output=" + str9 + " start=" + j3 + " end=" + j16 + " totalDuration=" + j17 + " needOrigin=" + z16 + " retryNum=" + i3 + " tmpVideoPath=" + str5 + " targetKey=" + str6 + " isSyncToWeishi=" + z17 + " isQcircle=" + z18);
        J = z17;
        K = z18;
        o();
        long length = new File(str3).length();
        if (j17 != 0) {
            length = (length * (j16 - j3)) / j17;
        }
        long j26 = length;
        if (n()) {
            QZLog.i("[upload2]VideoTrimmer", 1, "useHwEncode=true");
            z19 = true;
        } else {
            z19 = false;
        }
        if (I || (z19 && i3 == 0 && !D)) {
            if (Math.abs((j16 - j3) - j17) < f60064l) {
                j18 = -1;
                j19 = -1;
            } else {
                j18 = j3;
                j19 = j16;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int s16 = s(str3, str5, z16, j18, j19);
            if (s16 == 0) {
                int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(str6, new String[]{Argument.FILE_INPUT, str5, Argument.AUDIO_CODEC, "copy", Argument.VIDEO_CODEC, "copy", "-movflags", "faststart", "-y", str9});
                str10 = "[upload2]VideoTrimmer";
                QZLog.i(str10, 1, "trimVideoByHW, faststart ret2=" + trimByFFmpeg);
                if (trimByFFmpeg < 0) {
                    str9 = str5;
                } else {
                    File file = new File(str5);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                long j27 = j26 / currentTimeMillis2;
                StringBuilder sb5 = new StringBuilder();
                i16 = s16;
                sb5.append("trimVideoByHW, time=");
                sb5.append(currentTimeMillis2);
                str7 = " speed=";
                sb5.append(str7);
                sb5.append(j27);
                QZLog.i(str10, 1, sb5.toString());
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_TRIM_VIDEO_COST_HW, currentTimeMillis2);
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_TRIM_VIDEO_SPEED_HW, j27);
            } else {
                i16 = s16;
                str7 = " speed=";
                str10 = "[upload2]VideoTrimmer";
            }
            i17 = i16;
        } else {
            i17 = -1;
            str7 = " speed=";
        }
        String str11 = str9;
        if (i17 != 0 && !I) {
            File file2 = new File(str5);
            if (file2.exists()) {
                file2.delete();
            }
            if (i17 < 0) {
                long currentTimeMillis3 = System.currentTimeMillis();
                String str12 = str7;
                i18 = 1;
                str8 = str10;
                i17 = t(str2, str3, str11, j3, j16, z16, i3, handler, str6);
                if (i17 == 0) {
                    long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                    long j28 = j26 / currentTimeMillis4;
                    QZLog.i(str8, 1, "trimVideoBySoftware, time=" + currentTimeMillis4 + str12 + j28);
                    QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_TRIM_VIDEO_COST_SW, currentTimeMillis4);
                    QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_TRIM_VIDEO_SPEED_SW, j28);
                    LocalMultiProcConfig.putLong(LocalMultiProcConfig.Constants.KEY_VIDEO_COMPRESS_SPEED, j28);
                }
                QZLog.i(str8, i18, "trim video ret=" + i17);
                return i17;
            }
        }
        str8 = str10;
        i18 = 1;
        QZLog.i(str8, i18, "trim video ret=" + i17);
        return i17;
    }

    private static int s(String str, String str2, boolean z16, long j3, long j16) {
        VideoConverterConfig compressConfig = ShortVideoTrimmer.getCompressConfig(str);
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: Try to compress using MediaCodec");
        }
        b bVar = new b(str2, (int) (compressConfig.srcBitrate * 1024), (int) compressConfig.srcFrameRate, z16, j3, j16);
        VideoConverter videoConverter = new VideoConverter(new br2.a());
        f60061i = videoConverter;
        int i3 = 1;
        videoConverter.setCompressMode(1);
        BaseApplicationImpl.getApplication();
        int startCompress = f60061i.startCompress(BaseApplication.getContext(), str, bVar, true);
        if (startCompress == -6) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_HW_SUPPORT, "19", DeviceInfoMonitor.getModel());
            i3 = -3;
        } else {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_HW_SUPPORT, "18", null);
            if (startCompress != 0 && startCompress != -1002) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: compress failed using MediaCodec");
                }
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_HW_SUCCESS, "21", DeviceInfoMonitor.getModel());
                i3 = -2;
            } else if (bVar.f60090g) {
                if (QZLog.isColorLevel()) {
                    QZLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: compress canceled using MediaCodec");
                }
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_HW_SUCCESS, "22", null);
            } else {
                if (QZLog.isColorLevel()) {
                    QZLog.d("[upload2]VideoTrimmer", 2, "trimVideoByHW, step: compress completed using MediaCodec");
                }
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_HW_SUCCESS, "20", null);
                i3 = 0;
            }
        }
        p("local_video_compress", "hardware_compress_result", String.valueOf(i3));
        return i3;
    }

    private static int t(String str, String str2, String str3, long j3, long j16, boolean z16, int i3, Handler handler, String str4) {
        long currentTimeMillis = System.currentTimeMillis();
        String[] l3 = l(str, str2, str3, j3, j16, z16, i3);
        if (l3 == null) {
            return -1;
        }
        handler.sendEmptyMessage(1004);
        int trimByFFmpeg = ((IQzoneVideoHelper) QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(str4, l3);
        handler.removeMessages(1004);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload2]VideoTrimmer", 2, "trim video time cost:" + currentTimeMillis2 + "ms, ret=" + trimByFFmpeg);
        }
        if (trimByFFmpeg == 0) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_SW_SUCCESS, "20", null);
        } else if (trimByFFmpeg == 2) {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_SW_SUCCESS, "22", null);
        } else {
            QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_SW_SUCCESS, "21", DeviceInfoMonitor.getModel());
        }
        p("local_video_compress", "software_compress_result", String.valueOf(trimByFFmpeg));
        return trimByFFmpeg;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x049b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String[] l(String str, String str2, String str3, long j3, long j16, boolean z16, int i3) {
        String str4;
        String str5;
        String str6;
        String str7;
        int config;
        int config2;
        String str8;
        int i16;
        boolean isAvcodecNewVersion;
        int i17;
        String[] strArr;
        char c16;
        int i18;
        String format;
        String str9;
        boolean z17;
        Object obj;
        Object obj2;
        int i19;
        ActivityManager.MemoryInfo memoryInfo;
        String str10;
        String q16 = q(j3);
        String q17 = q(j16 - j3);
        try {
            str4 = TrimNative.getRealProperties(str2, f60067o, 1);
        } catch (Throwable th5) {
            QZLog.e("[upload2]VideoTrimmer", "generateCommand error:", th5);
            str4 = null;
        }
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        String[] split = str4.split(",");
        if (split.length < 4 || !split[0].equals("0")) {
            return null;
        }
        int intValue = Integer.valueOf(split[3]).intValue();
        if (L == 0 || m() < 2) {
            str5 = "1";
        } else {
            str5 = "2";
        }
        try {
            ActivityManager activityManager = (ActivityManager) BaseApplication.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo2);
            int g16 = ag.g(f60071s, z16);
            str6 = memoryInfo2;
            try {
                if (memoryInfo2.availMem < g16) {
                    if (z16) {
                        ActivityManager.MemoryInfo memoryInfo3 = str6;
                        str6 = q16;
                        str7 = q17;
                        if (memoryInfo3.availMem > ag.g("ultrafast", true)) {
                            f60071s = "superfast";
                            str10 = memoryInfo3;
                        } else {
                            f60071s = "ultrafast";
                            str10 = memoryInfo3;
                        }
                    } else {
                        f60071s = "ultrafast";
                        str7 = q17;
                        str10 = str6;
                        str6 = q16;
                    }
                    QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, "22", null);
                    memoryInfo = str10;
                } else {
                    str7 = q17;
                    memoryInfo = str6;
                    str6 = q16;
                }
                if (QZLog.isColorLevel()) {
                    QZLog.d("[upload2]VideoTrimmer", 2, "availMem=" + memoryInfo.availMem + ", threshold=" + memoryInfo.threshold + ", lowMem=" + memoryInfo.lowMemory + ", minRam=" + g16 + ", preset=" + f60071s);
                }
            } catch (Exception e16) {
                e = e16;
                if (!z16) {
                    f60071s = "ultrafast";
                } else {
                    f60071s = "superfast";
                }
                QZLog.w(e);
                config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_VIDEO_RETRY_DOWN_LOW, f60058f);
                int config3 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_VIDEO_RETRY_DOWN_MEDIUM, f60059g);
                config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_VIDEO_RETRY_DOWN_HIGH, f60060h);
                if (i3 >= config) {
                }
                if (i3 < config3) {
                }
                if (i3 < config2) {
                }
                QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_NUM, i3 + "", null);
                TrimVideoThread.U = i16;
                if (QZLog.isColorLevel()) {
                }
                String valueOf = String.valueOf(f60068p * H);
                isAvcodecNewVersion = VideoEnvironment.isAvcodecNewVersion();
                if (z16) {
                }
                i17 = 0;
                String[] split2 = f60075w.split(" ");
                ArrayList arrayList = new ArrayList();
                arrayList.add("-threads");
                arrayList.add(str8);
                arrayList.add(Argument.START_TIME);
                arrayList.add(str6);
                arrayList.add("-accurate_seek");
                arrayList.add(Argument.FILE_INPUT);
                arrayList.add(str2);
                arrayList.add(Argument.DURATION);
                arrayList.add(str7);
                arrayList.add(Argument.AUDIO_CODEC);
                arrayList.add(FileReaderHelper.AAC_EXT);
                arrayList.add(Argument.VIDEO_CODEC);
                if (!isAvcodecNewVersion) {
                }
                arrayList.add("-movflags");
                arrayList.add("faststart");
                if (!isAvcodecNewVersion) {
                }
                arrayList.add("-y");
                arrayList.add(str3);
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                if (QZLog.isColorLevel()) {
                }
                return strArr;
            }
        } catch (Exception e17) {
            e = e17;
            str6 = q16;
            str7 = q17;
        }
        config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_VIDEO_RETRY_DOWN_LOW, f60058f);
        int config32 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_VIDEO_RETRY_DOWN_MEDIUM, f60059g);
        config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_TRIM, QzoneConfig.SECONDARY_VIDEO_RETRY_DOWN_HIGH, f60060h);
        if (i3 >= config) {
            f60071s = "ultrafast";
        }
        str8 = i3 < config32 ? "1" : str5;
        if (i3 < config2) {
            i16 = 10;
            Process.setThreadPriority(10);
        } else {
            Process.setThreadPriority(0);
            i16 = 0;
        }
        QzoneVideoBeaconReport.reportVideoEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_VIDEO_TRIM, QzoneVideoBeaconReport.KEY_VIDEO_TRIM_RETRY_NUM, i3 + "", null);
        TrimVideoThread.U = i16;
        if (QZLog.isColorLevel()) {
            QZLog.d("[upload2]VideoTrimmer", 2, "retryNum=" + i3 + ", preset=" + f60071s + ", priority=" + i16 + ", threads=" + str8);
        }
        String valueOf2 = String.valueOf(f60068p * H);
        isAvcodecNewVersion = VideoEnvironment.isAvcodecNewVersion();
        if (z16 && f60065m) {
            int intValue2 = Integer.valueOf(split[1]).intValue();
            int intValue3 = Integer.valueOf(split[2]).intValue();
            int round = Math.round((intValue2 * 1.0f) / 16.0f) * 16;
            int round2 = Math.round((intValue3 * 1.0f) / 16.0f) * 16;
            if (intValue != 0) {
                if (intValue != 1) {
                    i18 = 2;
                    if (intValue == 2) {
                        i17 = 0;
                        c16 = 1;
                    } else if (intValue != 3) {
                        format = "";
                        i17 = 0;
                        int max = Math.max(round, round2);
                        if (K) {
                            str9 = format;
                            z17 = isAvcodecNewVersion;
                            obj = Argument.VIDEO_CODEC;
                            obj2 = FileReaderHelper.AAC_EXT;
                            i19 = f60066n;
                        } else {
                            z17 = isAvcodecNewVersion;
                            int i26 = f60067o;
                            if (max < i26) {
                                obj = Argument.VIDEO_CODEC;
                                int i27 = f60066n;
                                obj2 = FileReaderHelper.AAC_EXT;
                                str9 = format;
                                i19 = (int) (((i27 * 1.0d) / i26) * max);
                            } else {
                                str9 = format;
                                obj = Argument.VIDEO_CODEC;
                                obj2 = FileReaderHelper.AAC_EXT;
                                i19 = f60066n;
                            }
                        }
                        if (QZLog.isColorLevel()) {
                            QZLog.d("[upload2]VideoTrimmer", 2, "videoMaxBitrate=" + f60066n + " videoBitrate=" + i19 + " videoLongestEdge=" + f60067o + " outputWidth=" + round + " outputHeight=" + round2 + " frameRate=" + f60068p + " audioMaxSample=" + f60069q + " audioMaxBitrate=" + f60070r);
                        }
                        String[] split3 = f60075w.split(" ");
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("-threads");
                        arrayList2.add(str8);
                        arrayList2.add(Argument.START_TIME);
                        arrayList2.add(str6);
                        arrayList2.add("-accurate_seek");
                        arrayList2.add(Argument.FILE_INPUT);
                        arrayList2.add(str2);
                        arrayList2.add(Argument.DURATION);
                        arrayList2.add(str7);
                        arrayList2.add("-s");
                        arrayList2.add(str9);
                        arrayList2.add(Argument.AUDIO_CODEC);
                        arrayList2.add(obj2);
                        arrayList2.add(obj);
                        if (z17) {
                            arrayList2.add("libo264rt");
                        } else {
                            arrayList2.add(VideoConverterConfig.SoftwareConfig.ENCODER_X264);
                        }
                        arrayList2.add("-movflags");
                        arrayList2.add("faststart");
                        if (!z17) {
                            arrayList2.add("-preset");
                            arrayList2.add(f60071s);
                            arrayList2.add("-tune");
                            arrayList2.add(f60072t);
                            arrayList2.add("-profile:v");
                            arrayList2.add(f60073u);
                            arrayList2.add("-level");
                            arrayList2.add(f60074v);
                            for (int i28 = i17; i28 < split3.length; i28++) {
                                if (!TextUtils.isEmpty(split3[i28])) {
                                    arrayList2.add(split3[i28]);
                                }
                            }
                        }
                        if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NEW_PARAMS, 1) == 1) {
                            if (z17) {
                                arrayList2.add("-o264rt_params");
                            } else {
                                arrayList2.add("-x264-params");
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("vbv-maxrate=");
                            int i29 = i19 / 1000;
                            sb5.append(i29);
                            sb5.append(":vbv-bufsize=");
                            sb5.append(i29);
                            arrayList2.add(sb5.toString());
                        } else {
                            arrayList2.add(Argument.BITRATE_VIDEO);
                            arrayList2.add(String.valueOf(i19));
                            arrayList2.add("-bufsize");
                            arrayList2.add(String.valueOf(i19));
                        }
                        arrayList2.add("-g");
                        arrayList2.add(valueOf2);
                        arrayList2.add(Argument.BITRATE_AUDIO);
                        arrayList2.add(String.valueOf(f60070r));
                        arrayList2.add("-r:v");
                        arrayList2.add(String.valueOf(f60068p));
                        arrayList2.add(Argument.FREQ_AUDIO);
                        arrayList2.add(String.valueOf(f60069q));
                        arrayList2.add("-y");
                        arrayList2.add(str3);
                        strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                    }
                }
                i17 = 0;
                format = String.format("%dx%d", Integer.valueOf(round2), Integer.valueOf(round));
                int max2 = Math.max(round, round2);
                if (K) {
                }
                if (QZLog.isColorLevel()) {
                }
                String[] split32 = f60075w.split(" ");
                ArrayList arrayList22 = new ArrayList();
                arrayList22.add("-threads");
                arrayList22.add(str8);
                arrayList22.add(Argument.START_TIME);
                arrayList22.add(str6);
                arrayList22.add("-accurate_seek");
                arrayList22.add(Argument.FILE_INPUT);
                arrayList22.add(str2);
                arrayList22.add(Argument.DURATION);
                arrayList22.add(str7);
                arrayList22.add("-s");
                arrayList22.add(str9);
                arrayList22.add(Argument.AUDIO_CODEC);
                arrayList22.add(obj2);
                arrayList22.add(obj);
                if (z17) {
                }
                arrayList22.add("-movflags");
                arrayList22.add("faststart");
                if (!z17) {
                }
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NEW_PARAMS, 1) == 1) {
                }
                arrayList22.add("-g");
                arrayList22.add(valueOf2);
                arrayList22.add(Argument.BITRATE_AUDIO);
                arrayList22.add(String.valueOf(f60070r));
                arrayList22.add("-r:v");
                arrayList22.add(String.valueOf(f60068p));
                arrayList22.add(Argument.FREQ_AUDIO);
                arrayList22.add(String.valueOf(f60069q));
                arrayList22.add("-y");
                arrayList22.add(str3);
                strArr = (String[]) arrayList22.toArray(new String[arrayList22.size()]);
            } else {
                i17 = 0;
                c16 = 1;
                i18 = 2;
            }
            Object[] objArr = new Object[i18];
            objArr[i17] = Integer.valueOf(round);
            objArr[c16] = Integer.valueOf(round2);
            format = String.format("%dx%d", objArr);
            int max22 = Math.max(round, round2);
            if (K) {
            }
            if (QZLog.isColorLevel()) {
            }
            String[] split322 = f60075w.split(" ");
            ArrayList arrayList222 = new ArrayList();
            arrayList222.add("-threads");
            arrayList222.add(str8);
            arrayList222.add(Argument.START_TIME);
            arrayList222.add(str6);
            arrayList222.add("-accurate_seek");
            arrayList222.add(Argument.FILE_INPUT);
            arrayList222.add(str2);
            arrayList222.add(Argument.DURATION);
            arrayList222.add(str7);
            arrayList222.add("-s");
            arrayList222.add(str9);
            arrayList222.add(Argument.AUDIO_CODEC);
            arrayList222.add(obj2);
            arrayList222.add(obj);
            if (z17) {
            }
            arrayList222.add("-movflags");
            arrayList222.add("faststart");
            if (!z17) {
            }
            if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_MINI_VIDEO, QzoneConfig.SECONDARY_VIDEO_NEW_PARAMS, 1) == 1) {
            }
            arrayList222.add("-g");
            arrayList222.add(valueOf2);
            arrayList222.add(Argument.BITRATE_AUDIO);
            arrayList222.add(String.valueOf(f60070r));
            arrayList222.add("-r:v");
            arrayList222.add(String.valueOf(f60068p));
            arrayList222.add(Argument.FREQ_AUDIO);
            arrayList222.add(String.valueOf(f60069q));
            arrayList222.add("-y");
            arrayList222.add(str3);
            strArr = (String[]) arrayList222.toArray(new String[arrayList222.size()]);
        } else {
            i17 = 0;
            String[] split22 = f60075w.split(" ");
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add("-threads");
            arrayList3.add(str8);
            arrayList3.add(Argument.START_TIME);
            arrayList3.add(str6);
            arrayList3.add("-accurate_seek");
            arrayList3.add(Argument.FILE_INPUT);
            arrayList3.add(str2);
            arrayList3.add(Argument.DURATION);
            arrayList3.add(str7);
            arrayList3.add(Argument.AUDIO_CODEC);
            arrayList3.add(FileReaderHelper.AAC_EXT);
            arrayList3.add(Argument.VIDEO_CODEC);
            if (!isAvcodecNewVersion) {
                arrayList3.add("libo264rt");
            } else {
                arrayList3.add(VideoConverterConfig.SoftwareConfig.ENCODER_X264);
            }
            arrayList3.add("-movflags");
            arrayList3.add("faststart");
            if (!isAvcodecNewVersion) {
                arrayList3.add("-preset");
                arrayList3.add(f60071s);
                arrayList3.add("-tune");
                arrayList3.add(f60072t);
                arrayList3.add("-profile:v");
                arrayList3.add(f60073u);
                arrayList3.add("-level");
                arrayList3.add(f60074v);
                for (int i36 = 0; i36 < split22.length; i36++) {
                    if (!TextUtils.isEmpty(split22[i36])) {
                        arrayList3.add(split22[i36]);
                    }
                }
            }
            arrayList3.add("-y");
            arrayList3.add(str3);
            strArr = (String[]) arrayList3.toArray(new String[arrayList3.size()]);
        }
        if (QZLog.isColorLevel()) {
            int length = strArr.length;
            for (int i37 = i17; i37 < length; i37++) {
                QZLog.d("[upload2]VideoTrimmer", 2, strArr[i37] + "\n");
            }
        }
        return strArr;
    }

    private static String q(long j3) {
        if (j3 < 0) {
            j3 = 0;
        }
        return String.valueOf((j3 * 1.0d) / 1000.0d);
    }
}
