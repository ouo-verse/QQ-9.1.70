package com.tencent.tav.decoder;

import android.media.MediaCodecInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.logger.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@RequiresApi(api = 21)
/* loaded from: classes26.dex */
public class EncodeFormatFixHelper {
    private static final int DEFAULT_BLOCK_SIZE = 16;
    public static int MIN_ENCODE_SIZE = 540;
    private static final int SIZE_SCALE_MAX_COUNT = 20;
    private static final double SIZE_SCALE_WEIGHT = 0.9d;
    private static final String TAG = "EncodeFormatFixHelper";
    private final String codecName;
    private final MediaCodecInfo.VideoCapabilities videoCapabilities;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EncodeFormatFixHelper(String str, @NonNull MediaCodecInfo.VideoCapabilities videoCapabilities) {
        this.codecName = str;
        this.videoCapabilities = videoCapabilities;
    }

    private CGSize fixSizeForBlockCount(CGSize cGSize, CGSize cGSize2) {
        for (int i3 = 0; i3 < 20; i3++) {
            float f16 = (float) (cGSize2.width * 0.9d);
            cGSize2.width = f16;
            float f17 = (float) (cGSize2.height * 0.9d);
            cGSize2.height = f17;
            int i16 = MIN_ENCODE_SIZE;
            if (f16 < i16 || f17 < i16) {
                break;
            }
            if (isSizeSupported(cGSize2)) {
                return cGSize2;
            }
            fixToAlignment(cGSize2);
            if (isSizeSupported(cGSize2)) {
                return cGSize2;
            }
            fixToAlignment(cGSize2, 16, 16);
            if (isSizeSupported(cGSize2)) {
                return cGSize2;
            }
        }
        Logger.e(TAG, "fixSizeForBlockCount: size \u9002\u914d\u5931\u8d25, srcSize = " + cGSize + ", lastFixSize = " + cGSize2 + ", codecName = " + this.codecName);
        return null;
    }

    private void fixToAlignment(CGSize cGSize) {
        fixToAlignment(cGSize, this.videoCapabilities.getWidthAlignment(), this.videoCapabilities.getHeightAlignment());
    }

    private void fixToMaxSize(CGSize cGSize) {
        int i3 = (int) cGSize.width;
        int i16 = (int) cGSize.height;
        int intValue = this.videoCapabilities.getSupportedWidths().clamp(Integer.valueOf(i3)).intValue();
        if (i3 > intValue) {
            i16 = (int) (i16 * ((intValue * 1.0f) / i3));
            i3 = intValue;
        }
        int intValue2 = this.videoCapabilities.getSupportedHeights().clamp(Integer.valueOf(i16)).intValue();
        if (i16 > intValue2) {
            i3 = (int) (i3 * ((intValue2 * 1.0f) / i16));
            i16 = intValue2;
        }
        cGSize.width = i3;
        cGSize.height = i16;
    }

    private boolean isSizeSupported(CGSize cGSize) {
        return this.videoCapabilities.isSizeSupported((int) cGSize.width, (int) cGSize.height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double fixFrameRate(CGSize cGSize, double d16) {
        try {
            return this.videoCapabilities.getSupportedFrameRatesFor((int) cGSize.width, (int) cGSize.height).clamp(Double.valueOf(d16)).doubleValue();
        } catch (Throwable th5) {
            Logger.e(TAG, "fixFrameRate: getSupportedFrameRatesFor fail", th5);
            return -1.0d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public CGSize fixSize(CGSize cGSize) {
        CGSize m258clone = cGSize.m258clone();
        if (isSizeSupported(m258clone)) {
            return m258clone;
        }
        fixToMaxSize(m258clone);
        if (isSizeSupported(m258clone)) {
            return m258clone;
        }
        fixToAlignment(m258clone);
        if (isSizeSupported(m258clone)) {
            return m258clone;
        }
        fixToAlignment(m258clone, 16, 16);
        if (isSizeSupported(m258clone)) {
            return m258clone;
        }
        return fixSizeForBlockCount(cGSize, m258clone);
    }

    private void fixToAlignment(CGSize cGSize, int i3, int i16) {
        cGSize.width = CodecHelper.ceilTo(cGSize.width, i3);
        cGSize.height = CodecHelper.ceilTo(cGSize.height, i16);
    }
}
