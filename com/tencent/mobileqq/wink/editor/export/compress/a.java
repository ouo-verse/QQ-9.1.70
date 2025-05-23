package com.tencent.mobileqq.wink.editor.export.compress;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.qqlive.api.common.RTCAudioDefine;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.tav.decoder.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f320190a = false;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    static MediaCodecList f320191b = new MediaCodecList(0);

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Integer, Integer> f320192c;

    static {
        HashMap hashMap = new HashMap();
        f320192c = hashMap;
        hashMap.put(96000, 0);
        hashMap.put(88200, 1);
        hashMap.put(64000, 2);
        hashMap.put(48000, 3);
        hashMap.put(44100, 4);
        hashMap.put(32000, 5);
        hashMap.put(Integer.valueOf(RTCAudioDefine.RTC_AUDIO_SAMPLE_RATE_24000), 6);
        hashMap.put(22050, 7);
        hashMap.put(16000, 8);
        hashMap.put(12000, 9);
        hashMap.put(11025, 10);
        hashMap.put(8000, 11);
        hashMap.put(7350, 12);
    }

    private static float b(long j3, long j16, long j17, long j18, long j19) {
        if (j18 > 0 && j17 != -1) {
            j17 = (j17 + ((j17 / j18) * j18)) % j18;
        }
        return ((float) Math.max(j3, Math.max(j16, j17))) / ((float) j19);
    }

    public static void c() {
        f320190a = true;
        w53.b.g("WinkPublish-Export-WinkMediaCodecUtils", "cancel");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized MediaCodec d(MediaFormat mediaFormat, int i3) throws IOException {
        String str;
        synchronized (a.class) {
            String string = mediaFormat.getString("mime");
            if (i3 == 1) {
                try {
                    str = f(mediaFormat);
                } catch (Throwable th5) {
                    th = th5;
                    str = null;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        return MediaCodec.createByCodecName(str);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    Logger.e("WinkPublish-Export-WinkMediaCodecUtils", "createDecoder: createByCodecName fail, name = " + str, th);
                    return MediaCodec.createDecoderByType(string);
                }
            }
            return MediaCodec.createDecoderByType(string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized MediaCodec e(MediaFormat mediaFormat, int i3) throws IOException {
        String str;
        synchronized (a.class) {
            String string = mediaFormat.getString("mime");
            if (i3 == 1) {
                try {
                    str = g(mediaFormat);
                } catch (Throwable th5) {
                    th = th5;
                    str = null;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        return MediaCodec.createByCodecName(str);
                    }
                } catch (Throwable th6) {
                    th = th6;
                    Logger.e("WinkPublish-Export-WinkMediaCodecUtils", "createEncoder: createByCodecName fail, name = " + str, th);
                    return MediaCodec.createEncoderByType(string);
                }
            }
            return MediaCodec.createEncoderByType(string);
        }
    }

    @Nullable
    @RequiresApi(api = 21)
    static String f(MediaFormat mediaFormat) {
        MediaCodecList mediaCodecList = f320191b;
        if (mediaCodecList == null) {
            return null;
        }
        return mediaCodecList.findDecoderForFormat(mediaFormat);
    }

    @Nullable
    @RequiresApi(api = 21)
    static String g(MediaFormat mediaFormat) {
        MediaCodecList mediaCodecList = f320191b;
        if (mediaCodecList == null) {
            return null;
        }
        return mediaCodecList.findEncoderForFormat(mediaFormat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v3, types: [double] */
    public static int h(String str) {
        int i3 = 0;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            int j3 = j(mediaExtractor, "video/");
            if (j3 == -1) {
                return -1;
            }
            mediaExtractor.selectTrack(j3);
            int i16 = 0;
            long j16 = 0;
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime < 0) {
                    mediaExtractor.release();
                    i3 = Math.ceil(i16 / ((((float) j16) / 1000.0f) / 1000.0f));
                    return (int) i3;
                }
                i16++;
                mediaExtractor.advance();
                j16 = sampleTime;
            }
        } catch (IOException e16) {
            QLog.e("WinkPublish-Export-WinkMediaCodecUtils", 1, e16, new Object[i3]);
            return -1;
        }
    }

    public static int i(MediaCodec mediaCodec, String str) {
        try {
            return mediaCodec.getCodecInfo().getCapabilitiesForType(str).getVideoCapabilities().getBitrateRange().getUpper().intValue();
        } catch (Exception e16) {
            QLog.e("WinkPublish-Export-WinkMediaCodecUtils", 1, e16, new Object[0]);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(MediaExtractor mediaExtractor, String str) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            String string = mediaExtractor.getTrackFormat(i3).getString("mime");
            if (string != null && string.startsWith(str)) {
                return i3;
            }
        }
        return -1;
    }

    public static boolean k() {
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(0).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder() && mediaCodecInfo.getName().contains("hevc") && !l(mediaCodecInfo.getName())) {
                QLog.e("WinkPublish-Export-WinkMediaCodecUtils", 1, "Support265 codecInfo name = " + mediaCodecInfo.getName());
                return true;
            }
        }
        return false;
    }

    public static boolean l(String str) {
        if (str.startsWith("OMX.google.") || str.contains(".sw.") || !str.startsWith("OMX.")) {
            return true;
        }
        return false;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(java.lang.String r87, com.tencent.mobileqq.wink.editor.export.compress.base.b r88, long r89, long r91, java.lang.String r93, float r94, java.lang.String r95, long r96, long r98, float r100) {
        /*
            Method dump skipped, instructions count: 4317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mobileqq.wink.editor.export.compress.a.m(java.lang.String, com.tencent.mobileqq.wink.editor.export.compress.base.b, long, long, java.lang.String, float, java.lang.String, long, long, float):void");
    }

    @SuppressLint({"WrongConstant"})
    public static void n(final String str, final String str2, final long j3, final long j16, final String str3, final float f16, final float f17, final long j17, final long j18, final com.tencent.mobileqq.wink.editor.export.compress.base.b bVar) {
        if (bVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (file.exists()) {
                if (!file.delete()) {
                    w53.b.c("WinkPublish-Export-WinkMediaCodecUtils", "Failed to delete existing file: " + str2);
                    bVar.d(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_COMPRESS_FAILED_UNKNOWN, "Failed to delete existing output file"));
                    return;
                }
                w53.b.f("WinkPublish-Export-WinkMediaCodecUtils", "Existing file deleted: " + str2);
            }
            RFWThreadManager.createNewThreadHandler("WinkVideoQuickClip", 0).post(new Runnable() { // from class: n63.e
                @Override // java.lang.Runnable
                public final void run() {
                    com.tencent.mobileqq.wink.editor.export.compress.a.m(str, bVar, j16, j3, str2, f16, str3, j17, j18, f17);
                }
            });
            return;
        }
        w53.b.c("WinkPublish-Export-WinkMediaCodecUtils", "param error inPutPath = " + str + " outPutPath = " + str2);
        bVar.d(new ExportErrorCode(ExportErrorCode.ERROR_CODE_VIDEO_COMPRESS_INVALID_METADATA, ""));
    }

    public static boolean o(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, int i3, int i16) {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodec.getCodecInfo().getCapabilitiesForType(str).profileLevels;
        if (codecProfileLevelArr == null) {
            return false;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
            if (codecProfileLevel.profile == i3 && codecProfileLevel.level == i16) {
                mediaFormat.setInteger("profile", i3);
                mediaFormat.setInteger("level", i16);
                return true;
            }
        }
        return false;
    }
}
