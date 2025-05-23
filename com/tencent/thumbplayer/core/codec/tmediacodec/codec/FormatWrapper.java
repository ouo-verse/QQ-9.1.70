package com.tencent.thumbplayer.core.codec.tmediacodec.codec;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.LogUtils;
import com.tencent.thumbplayer.core.codec.tmediacodec.util.TUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class FormatWrapper {
    public static final int NO_VALUE = -1;
    public static final String TAG = "FormatWrapper";
    public int channelCount;
    private boolean isVideo;
    private boolean isVideoFieldInit;
    public int rotationDegrees;

    @NonNull
    public final String sampleMimeType;
    public int sampleRate;

    @NonNull
    public ArrayList<byte[]> initializationData = new ArrayList<>();
    public int width = -1;
    public int height = -1;
    public int maxWidth = -1;
    public int maxHeight = -1;
    public int maxInputSize = -1;

    public FormatWrapper(@NonNull String str) {
        this.sampleMimeType = str;
    }

    private static String configCsdArray(String str, byte[] bArr) {
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append(", length:");
        sb5.append(bArr.length);
        sb5.append("  [");
        for (int i3 = 0; i3 < Math.min(bArr.length, 20); i3++) {
            if (i3 != 0) {
                sb5.append(" ,");
            }
            sb5.append((int) bArr[i3]);
        }
        sb5.append("]");
        return sb5.toString();
    }

    public static FormatWrapper create(@NonNull MediaFormat mediaFormat) {
        FormatWrapper formatWrapper = new FormatWrapper(mediaFormat.getString("mime"));
        try {
            formatWrapper.sampleRate = getInteger(mediaFormat, "sample-rate");
            formatWrapper.maxInputSize = getInteger(mediaFormat, "max-input-size");
            formatWrapper.initializationData = TUtils.getCsdBuffers(mediaFormat);
            if (formatWrapper.isVideo()) {
                formatWrapper.rotationDegrees = getInteger(mediaFormat, "rotation-degrees");
                formatWrapper.width = getInteger(mediaFormat, "width");
                formatWrapper.height = getInteger(mediaFormat, "height");
                formatWrapper.maxWidth = getInteger(mediaFormat, "max-width");
                formatWrapper.maxHeight = getInteger(mediaFormat, "max-height");
            } else {
                formatWrapper.channelCount = getInteger(mediaFormat, "channel-count");
            }
        } catch (Throwable th5) {
            LogUtils.e("FormatWrapper", "create format error", th5);
        }
        return formatWrapper;
    }

    public static void dumpCsdArray(ArrayList<byte[]> arrayList) {
        if (arrayList != null && LogUtils.isLogEnable()) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                sb5.append(configCsdArray(TUtils.CSD_INDEX_ARRAY[i3], arrayList.get(i3)));
                sb5.append("\n");
            }
            LogUtils.d("FormatWrapper", "csdData size:" + arrayList.size() + "    " + sb5.toString());
        }
    }

    public static int getInteger(@NonNull MediaFormat mediaFormat, @NonNull String str) {
        return getInteger(mediaFormat, str, -1);
    }

    public final boolean initializationDataEquals(@NonNull FormatWrapper formatWrapper) {
        if (this.initializationData.size() != formatWrapper.initializationData.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.initializationData.size(); i3++) {
            if (!this.initializationData.get(i3).equals(formatWrapper.initializationData.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final boolean isVideo() {
        if (!this.isVideoFieldInit) {
            this.isVideoFieldInit = true;
            this.isVideo = TUtils.isVideo(this.sampleMimeType);
        }
        return this.isVideo;
    }

    public static int getInteger(@NonNull MediaFormat mediaFormat, @NonNull String str, int i3) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i3;
    }
}
