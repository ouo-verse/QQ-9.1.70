package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.ExtractorUtils;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes26.dex */
public class DecoderUtils {
    public static final int AUDIO_SAMPLE_SIZE = 8192;
    public static final String MIME = "mime";
    public static final int NO_TRACK_FOUND = -1;
    public static final int RESAMPLE_CHANNEL_COUNT = 1;
    public static final int RESAMPLE_SAMPLE_RATE = 44100;
    public static final int TIMEOUT_US = 1000;

    public static long getAudioDuration(long j3, int i3, int i16) {
        return (j3 * 1000000) / ((i3 * 2) * i16);
    }

    public static long getDuration(String str) {
        return ExtractorUtils.getDuration(str);
    }

    public static ByteBuffer getInputBuffer(MediaCodec mediaCodec, int i3) throws IllegalStateException {
        return mediaCodec.getInputBuffer(i3);
    }

    public static Rectangle getMatrixAndCropRect(CGSize cGSize, int i3, float f16, float f17, Point point, Matrix matrix) {
        float f18;
        float f19;
        while (i3 < 0) {
            i3 += 4;
        }
        int i16 = i3 % 4;
        getRotationMatrix(matrix, i16, cGSize.width, cGSize.height);
        CGSize transformedSize = getTransformedSize(cGSize, i16, f17);
        if (f17 <= 0.0f && f16 <= 1.0f) {
            return null;
        }
        CGSize cGSize2 = new CGSize();
        if (i16 % 2 == 1) {
            cGSize2.width = cGSize.height;
            cGSize2.height = cGSize.width;
        } else {
            cGSize2.width = cGSize.width;
            cGSize2.height = cGSize.height;
        }
        float f26 = transformedSize.width;
        float f27 = cGSize2.width;
        if (f26 != f27) {
            f19 = (f27 - f26) * 0.5f;
            f18 = 0.0f;
        } else {
            float f28 = transformedSize.height;
            float f29 = cGSize2.height;
            if (f28 != f29) {
                f18 = (f29 - f28) * 0.5f;
                f19 = 0.0f;
            } else {
                f18 = 0.0f;
                f19 = 0.0f;
            }
        }
        Matrix matrix2 = new Matrix();
        matrix2.setTranslate(-f19, -f18);
        float f36 = transformedSize.width;
        float f37 = transformedSize.height;
        float f38 = f36 / f16;
        float f39 = f37 / f16;
        float f46 = (f16 - 1.0f) / f16;
        float f47 = (((-f36) * 0.5f) * f46) - point.x;
        float f48 = (((-f37) * 0.5f) * f46) - point.y;
        Matrix matrix3 = new Matrix();
        matrix3.setTranslate(f47, f48);
        float f49 = f19 - f47;
        float f56 = f18 - f48;
        matrix2.postConcat(matrix3);
        matrix2.postScale(f16, f16);
        Matrix matrix4 = new Matrix();
        matrix.invert(matrix4);
        RectF rectF = new RectF(f49, f56, f38 + f49, f39 + f56);
        matrix4.mapRect(rectF);
        Rectangle rectangle = new Rectangle(rectF.left, rectF.top, rectF.width(), rectF.height());
        float f57 = rectangle.f374241x;
        if (f57 < 0.0f) {
            rectangle.width += f57;
            rectangle.f374241x = 0.0f;
        }
        float f58 = rectangle.f374242y;
        if (f58 < 0.0f) {
            rectangle.height += f58;
            rectangle.f374242y = 0.0f;
        }
        float f59 = rectangle.f374241x;
        if (rectangle.width + f59 > cGSize.width) {
            rectangle.width = cGSize2.width - f59;
        }
        float f65 = rectangle.f374242y;
        if (rectangle.height + f65 > cGSize.height) {
            rectangle.height = cGSize2.height - f65;
        }
        matrix.postConcat(matrix2);
        return rectangle;
    }

    public static ByteBuffer getOutputBuffer(MediaCodec mediaCodec, int i3) throws IllegalStateException {
        return mediaCodec.getOutputBuffer(i3);
    }

    public static Matrix getPreferMatrix(CGSize cGSize, CGSize cGSize2, int i3) {
        Matrix matrix = new Matrix();
        getMatrixAndCropRect(cGSize2, i3, 1.0f, 0.0f, new Point(0, 0), matrix);
        Matrix matrix2 = new Matrix();
        CGSize transformedSize = getTransformedSize(cGSize2, i3, 0.0f);
        float f16 = transformedSize.width;
        float f17 = cGSize.width;
        float f18 = (f16 * 1.0f) / f17;
        float f19 = transformedSize.height;
        float f26 = cGSize.height;
        if (f18 > (1.0f * f19) / f26) {
            float f27 = f17 / f16;
            matrix2.setScale(f27, f27);
            matrix2.postTranslate(0.0f, Math.round((cGSize.height - (transformedSize.height * f27)) * 0.5f));
        } else {
            float f28 = f26 / f19;
            matrix2.setScale(f28, f28);
            matrix2.postTranslate(Math.round((cGSize.width - (transformedSize.width * f28)) * 0.5f), 0.0f);
        }
        matrix.postConcat(matrix2);
        return matrix;
    }

    public static Matrix getRotationMatrix(int i3, float f16, float f17) {
        Matrix matrix = new Matrix();
        getRotationMatrix(matrix, i3, f16, f17);
        return matrix;
    }

    public static CGSize getTransformedSize(CGSize cGSize, int i3, float f16) {
        CGSize m258clone = cGSize.m258clone();
        if (Math.abs(i3) % 2 == 1) {
            float f17 = m258clone.width;
            m258clone.width = m258clone.height;
            m258clone.height = f17;
        }
        if (f16 > 0.0f) {
            float f18 = m258clone.width;
            if ((f18 * 1.0f) / m258clone.height > f16) {
                m258clone.width = (int) Math.ceil(r2 * f16);
            } else {
                m258clone.height = (int) Math.ceil((f18 * 1.0f) / f16);
            }
        }
        return m258clone;
    }

    public static int selectTrack(MediaExtractor mediaExtractor, String str) {
        if (mediaExtractor != null && !TextUtils.isEmpty(str)) {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i3 = 0; i3 < trackCount; i3++) {
                if (mediaExtractor.getTrackFormat(i3).getString("mime").startsWith(str)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private static void swap(float[] fArr, int i3, int i16) {
        float f16 = fArr[i3];
        fArr[i3] = fArr[i16];
        fArr[i16] = f16;
    }

    public static float[] toOpenGL2DMatrix(Matrix matrix) {
        float f16;
        float[] fArr = new float[9];
        if (matrix == null) {
            for (int i3 = 0; i3 < 9; i3++) {
                if (i3 % 4 == 0) {
                    f16 = 1.0f;
                } else {
                    f16 = 0.0f;
                }
                fArr[i3] = f16;
            }
        } else {
            matrix.getValues(fArr);
            swap(fArr, 1, 3);
            swap(fArr, 2, 6);
            swap(fArr, 5, 7);
        }
        return fArr;
    }

    public static void getRotationMatrix(Matrix matrix, int i3, float f16, float f17) {
        float f18;
        float f19;
        float f26;
        int i16 = i3 % 4;
        if (i16 < 0) {
            i16 += 4;
        }
        float f27 = -1.0f;
        if (i16 != 1) {
            if (i16 == 2) {
                f26 = -1.0f;
                f18 = 0.0f;
                f19 = 0.0f;
            } else if (i16 != 3) {
                f27 = 1.0f;
                f26 = 1.0f;
                f18 = 0.0f;
                f16 = 0.0f;
                f17 = 0.0f;
                f19 = 0.0f;
            } else {
                f17 = f16;
                f19 = -1.0f;
                f18 = 1.0f;
                f16 = 0.0f;
                f27 = 0.0f;
            }
            matrix.setValues(new float[]{f27, f18, f16, f19, f26, f17, 0.0f, 0.0f, 1.0f});
        }
        f16 = f17;
        f18 = -1.0f;
        f19 = 1.0f;
        f17 = 0.0f;
        f27 = 0.0f;
        f26 = f27;
        matrix.setValues(new float[]{f27, f18, f16, f19, f26, f17, 0.0f, 0.0f, 1.0f});
    }
}
