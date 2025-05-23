package com.tencent.richmedia.videocompress.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import com.tencent.richmedia.videocompress.utils.ConvertLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
@RequiresApi(api = 18)
/* loaded from: classes25.dex */
public class MediaCodecUtil {
    private static String TAG = "CodecUtil";

    public static MediaCodecWrapper createVideoDecoder(MediaFormat mediaFormat, Surface surface) {
        List<MediaCodecInfo> decoderInfoList = getDecoderInfoList(mediaFormat.getString("mime"), false);
        if (decoderInfoList.isEmpty()) {
            return null;
        }
        MediaCodecInfo mediaCodecInfo = decoderInfoList.get(0);
        MediaCodecWrapper mediaCodecWrapper = new MediaCodecWrapper(null);
        mediaCodecWrapper.init(mediaFormat, mediaCodecInfo.getName(), surface);
        mediaCodecWrapper.start();
        return mediaCodecWrapper;
    }

    public static MediaCodecWrapper createVideoEncoder(MediaFormat mediaFormat, AtomicReference<Surface> atomicReference) {
        MediaCodecWrapper mediaCodecWrapper = new MediaCodecWrapper(null);
        mediaCodecWrapper.init(mediaFormat, MediaCodecWrapper.ENC_CODEC);
        atomicReference.set(mediaCodecWrapper.getInnerMediaCodec().createInputSurface());
        mediaCodecWrapper.start();
        return mediaCodecWrapper;
    }

    public static int getAndSelectAudioTrackIndex(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            try {
                String string = mediaExtractor.getTrackFormat(i3).getString("mime");
                if (ConvertLog.isColorLevel()) {
                    ConvertLog.d(TAG, 2, "format for track ", Integer.valueOf(i3), " is ", string);
                }
                if (string != null && string.startsWith("audio/")) {
                    mediaExtractor.selectTrack(i3);
                    return i3;
                }
            } catch (Exception e16) {
                ConvertLog.e(TAG, 1, "getAndSelectAudioTrackIndex error", e16);
                return -1;
            }
        }
        return -1;
    }

    public static int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            try {
                String string = mediaExtractor.getTrackFormat(i3).getString("mime");
                if (ConvertLog.isColorLevel()) {
                    ConvertLog.d(TAG, 2, "format for track ", Integer.valueOf(i3), " is ", string);
                }
                if (string != null && string.startsWith("video/")) {
                    mediaExtractor.selectTrack(i3);
                    return i3;
                }
            } catch (Exception e16) {
                ConvertLog.e(TAG, 1, "getAndSelectVideoTrackIndex error", e16);
                return -1;
            }
        }
        return -1;
    }

    public static MediaCodecInfo.CodecCapabilities getCodecCapabilities(MediaCodecInfo mediaCodecInfo, String str) {
        try {
            return mediaCodecInfo.getCapabilitiesForType(str);
        } catch (Exception e16) {
            ConvertLog.e(TAG, 1, "getCodecCapabilities error, mime:" + str, e16);
            return null;
        }
    }

    public static List<MediaCodecInfo> getDecoderInfoList(String str, boolean z16) {
        ArrayList arrayList = new ArrayList();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            try {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (!codecInfoAt.isEncoder() && (!z16 || (!codecInfoAt.getName().contains(".sw.") && !codecInfoAt.getName().contains(".SW.") && !codecInfoAt.getName().contains("google") && !codecInfoAt.getName().contains("Google") && !codecInfoAt.getName().contains("GOOGLE")))) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            arrayList.add(codecInfoAt);
                        }
                    }
                }
            } catch (Throwable th5) {
                ConvertLog.e(TAG, 1, "getDecoderInfoList error, mime:" + str, th5);
            }
        }
        return arrayList;
    }

    public static List<MediaCodecInfo> getEncoderInfoList(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                if (codecInfoAt.isEncoder() && !codecInfoAt.getName().contains(".sw.") && !codecInfoAt.getName().contains(".SW.") && !codecInfoAt.getName().contains("google") && !codecInfoAt.getName().contains("Google") && !codecInfoAt.getName().contains("GOOGLE")) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            arrayList.add(codecInfoAt);
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            ConvertLog.e(TAG, 1, "getEncoderInfoList error, mime:" + str, th5);
        }
        return arrayList;
    }

    public static MediaCodecInfo selectCodec(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i3 = 0; i3 < codecCount; i3++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        return codecInfoAt;
                    }
                }
            }
        }
        return null;
    }
}
