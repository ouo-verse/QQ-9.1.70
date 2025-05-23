package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ExtractorUtils {
    public static final int EXTRACT_AUDIO_TACK_ERROR = 2;
    public static final int EXTRACT_TACK_COUNT_ERROR = 1;
    public static final String MIME_AUDIO = "audio/";
    public static final String MIME_OTHER = "application/octet-stream";
    public static final String MIME_VIDEO = "video/";
    private static final String TAG = "ExtractorUtils";
    private static IExtractErrorListener sErrorListener;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IExtractErrorListener {
        void onError(int i3, Throwable th5, Object obj);
    }

    public static void applyMirror(Matrix matrix, int i3, int i16, int i17) {
        if (matrix == null) {
            return;
        }
        Matrix matrix2 = new Matrix();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    matrix2.postScale(-1.0f, -1.0f);
                    matrix2.postTranslate(i16, i17);
                }
            } else {
                matrix2.postScale(1.0f, -1.0f);
                matrix2.postTranslate(0.0f, i17);
            }
        } else {
            matrix2.postScale(-1.0f, 1.0f);
            matrix2.postTranslate(i16, 0.0f);
        }
        matrix.postConcat(matrix2);
    }

    public static long getAudioDuration(AssetExtractor assetExtractor) {
        return getAudioDuration(getMediaFormats(assetExtractor));
    }

    public static long getDuration(String str) {
        try {
            AssetExtractor assetExtractor = new AssetExtractor();
            assetExtractor.setDataSource(str);
            long duration = getDuration(assetExtractor);
            try {
                assetExtractor.release();
            } catch (Error e16) {
                e16.printStackTrace();
            } catch (Exception e17) {
                e17.printStackTrace();
            }
            return duration;
        } catch (Error | Exception unused) {
            return 0L;
        }
    }

    public static MediaFormat getFirstFormat(AssetExtractor assetExtractor, String str) {
        return getFirstFormat(getMediaFormats(assetExtractor), str);
    }

    public static int getFirstTrackIndex(AssetExtractor assetExtractor, String str) {
        return getFirstTrackIndex(getMediaFormats(assetExtractor), str);
    }

    public static MediaFormat getFirstVideoFormat(String str) {
        AssetExtractor assetExtractor = new AssetExtractor();
        assetExtractor.setDataSource(str);
        return getFirstFormat(assetExtractor, "video/");
    }

    public static int getFrameRate(MediaFormat mediaFormat) {
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey("frame-rate")) {
                    return mediaFormat.getInteger("frame-rate");
                }
                return 0;
            } catch (Error | Exception unused) {
                return 0;
            }
        }
        return 0;
    }

    @NonNull
    public static ArrayList<MediaFormat> getMediaFormats(AssetExtractor assetExtractor) {
        IExtractErrorListener iExtractErrorListener;
        ArrayList<MediaFormat> arrayList = new ArrayList<>();
        try {
            int trackCount = assetExtractor.getTrackCount();
            for (int i3 = 0; i3 < trackCount; i3++) {
                arrayList.add(assetExtractor.getTrackFormat(i3));
            }
            if (!isAudioTrackSupport(assetExtractor) && (iExtractErrorListener = sErrorListener) != null) {
                iExtractErrorListener.onError(2, null, assetExtractor);
            }
        } catch (Throwable th5) {
            Logger.e(TAG, "getMediaFormats:" + th5);
            IExtractErrorListener iExtractErrorListener2 = sErrorListener;
            if (iExtractErrorListener2 != null) {
                iExtractErrorListener2.onError(1, th5, assetExtractor);
            }
        }
        return arrayList;
    }

    public static int getPreferRotation(AssetExtractor assetExtractor) {
        return getPreferRotation(getMediaFormats(assetExtractor));
    }

    public static CGSize getVideoSize(AssetExtractor assetExtractor) {
        return getVideoSize(getMediaFormats(assetExtractor));
    }

    public static boolean isAudioTrackSupport(String str) {
        try {
            AssetExtractor assetExtractor = new AssetExtractor();
            assetExtractor.setDataSource(str);
            boolean isAudioTrackSupport = isAudioTrackSupport(assetExtractor);
            try {
                assetExtractor.release();
            } catch (Throwable th5) {
                Logger.e(TAG, "isAudioTrackSupport extractor.release error:" + th5);
            }
            return isAudioTrackSupport;
        } catch (Throwable th6) {
            Logger.e(TAG, "isAudioTrackSupport videoPath:" + str + ", error:" + th6);
            return false;
        }
    }

    public static boolean isSameExtractor(DecoderAssetTrack decoderAssetTrack, DecoderAssetTrack decoderAssetTrack2) {
        boolean z16;
        String str;
        if (decoderAssetTrack != null && decoderAssetTrack2 != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (str = decoderAssetTrack.assetPath) != null && str.equals(decoderAssetTrack2.assetPath)) {
            return true;
        }
        return false;
    }

    public static void setExtractErrorListener(IExtractErrorListener iExtractErrorListener) {
        sErrorListener = iExtractErrorListener;
    }

    public static long getAudioDuration(ArrayList<MediaFormat> arrayList) {
        try {
            Iterator<MediaFormat> it = arrayList.iterator();
            while (it.hasNext()) {
                MediaFormat next = it.next();
                if (next.getString("mime").startsWith("audio/") && next.containsKey("durationUs")) {
                    return next.getLong("durationUs");
                }
            }
            return 0L;
        } catch (Error | Exception unused) {
            return 0L;
        }
    }

    @Nullable
    public static MediaFormat getFirstFormat(ArrayList<MediaFormat> arrayList, String str) {
        try {
            Iterator<MediaFormat> it = arrayList.iterator();
            while (it.hasNext()) {
                MediaFormat next = it.next();
                if (next.getString("mime").startsWith(str)) {
                    return next;
                }
            }
            return null;
        } catch (Error | Exception unused) {
            return null;
        }
    }

    public static int getFirstTrackIndex(ArrayList<MediaFormat> arrayList, String str) {
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            try {
                if (arrayList.get(i3).getString("mime").startsWith(str)) {
                    return i3;
                }
            } catch (Error | Exception unused) {
                return -1;
            }
        }
        return -1;
    }

    public static int getPreferRotation(ArrayList<MediaFormat> arrayList) {
        try {
            MediaFormat firstFormat = getFirstFormat(arrayList, "video/");
            if (firstFormat == null || !firstFormat.containsKey("rotation-degrees")) {
                return 0;
            }
            return firstFormat.getInteger("rotation-degrees") / 90;
        } catch (Error | Exception unused) {
            return 0;
        }
    }

    @NonNull
    public static CGSize getVideoSize(ArrayList<MediaFormat> arrayList) {
        try {
            MediaFormat firstFormat = getFirstFormat(arrayList, "video/");
            CGSize cGSize = new CGSize();
            if (firstFormat != null) {
                if (firstFormat.containsKey("display-width")) {
                    cGSize.width = firstFormat.getInteger("display-width");
                } else {
                    cGSize.width = firstFormat.getInteger("width");
                }
                if (firstFormat.containsKey("display-height")) {
                    cGSize.height = firstFormat.getInteger("display-height");
                } else {
                    cGSize.height = firstFormat.getInteger("height");
                }
            }
            return cGSize;
        } catch (Error | Exception unused) {
            return new CGSize();
        }
    }

    public static long getDuration(AssetExtractor assetExtractor) {
        return getDuration(getMediaFormats(assetExtractor));
    }

    public static boolean isAudioTrackSupport(AssetExtractor assetExtractor) {
        try {
            int trackCount = assetExtractor.getTrackCount();
            int i3 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < trackCount; i17++) {
                String string = assetExtractor.getTrackFormat(i17).getString("mime");
                if (string.startsWith("audio/")) {
                    i3++;
                }
                if (string.startsWith("application/octet-stream")) {
                    i16++;
                }
            }
            boolean z16 = true;
            if (trackCount > 1 && i3 == 0 && i16 > 0) {
                z16 = false;
            }
            Logger.d(TAG, "isAudioTrackSupport support:" + z16);
            return z16;
        } catch (Throwable th5) {
            Logger.e(TAG, "isAudioTrackSupport error:" + th5);
            return false;
        }
    }

    public static long getDuration(ArrayList<MediaFormat> arrayList) {
        try {
            Iterator<MediaFormat> it = arrayList.iterator();
            long j3 = 0;
            long j16 = 0;
            while (it.hasNext()) {
                MediaFormat next = it.next();
                String string = next.getString("mime");
                if (string.startsWith("video/")) {
                    if (next.containsKey("durationUs")) {
                        j3 = next.getLong("durationUs");
                    }
                } else if (string.startsWith("audio/") && next.containsKey("durationUs")) {
                    j16 = next.getLong("durationUs");
                }
            }
            return j3 > 0 ? j3 : j16;
        } catch (Error | Exception unused) {
            return 0L;
        }
    }
}
