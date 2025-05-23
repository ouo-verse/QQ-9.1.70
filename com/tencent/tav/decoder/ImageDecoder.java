package com.tencent.tav.decoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.filter.GLSLRender;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.IVideoDecoder;
import com.tencent.tav.decoder.logger.Logger;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ImageDecoder implements IVideoDecoder {
    public static String EXTRA_INFO_KEY_DECODE_SIZE = "extra_info_key_decode_size";
    public static final CGSize IMAGE_DECODE_SIZE = new CGSize(720.0f, 1280.0f);
    private final String TAG;
    private Bitmap bitmap;
    private CMTime currentDecoderTime;
    private CGSize displaySize;
    private CMTime frameDuration;
    private int preferRotation;
    private String sourceImagePath;
    private TextureInfo textureInfo;
    private long threadId;
    private CMTimeRange timeRange;

    public ImageDecoder(IVideoDecoder.Params params) {
        String str = "ImageDecoder@" + Integer.toHexString(hashCode());
        this.TAG = str;
        this.preferRotation = 0;
        this.currentDecoderTime = CMTime.CMTimeInvalid;
        this.frameDuration = new CMTime(1L, 30);
        this.threadId = -1L;
        Logger.i(str, "ImageDecoder() called with: params = [" + params + "]");
        this.sourceImagePath = params.filePath;
        readExtraDecodeSize(params);
        this.displaySize = params.outputSize;
    }

    private void checkThread() {
        long j3 = this.threadId;
        if (j3 != -1 && j3 != Thread.currentThread().getId()) {
            Logger.e(this.TAG, "\u7ebf\u7a0b\u4e0d\u5bf9\uff0c\u6ce8\u610fEGL\u76f8\u5173\u7684\u6cc4\u9732\u95ee\u9898\uff01threadId = " + this.threadId + ", Thread.currentThread() name = " + Thread.currentThread().getName(), new RuntimeException());
        }
    }

    private synchronized TextureInfo createTexture() {
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null && !textureInfo.isReleased()) {
            return this.textureInfo;
        }
        if (this.bitmap == null) {
            Bitmap decodeBitmap = decodeBitmap(this.sourceImagePath, this.displaySize);
            this.bitmap = decodeBitmap;
            this.bitmap = TAVImageFactory.fixSupportImageConfig(decodeBitmap);
            this.preferRotation = readImagePreferRotation(this.sourceImagePath);
        }
        if (this.bitmap != null) {
            this.threadId = Thread.currentThread().getId();
            TextureInfo textureInfo2 = new TextureInfo(RenderContext.createTexture(GLSLRender.GL_TEXTURE_2D), GLSLRender.GL_TEXTURE_2D, this.bitmap.getWidth(), this.bitmap.getHeight(), getImageTextureMatrix(), this.preferRotation);
            this.textureInfo = textureInfo2;
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureInfo2.textureID);
            GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.bitmap, 0);
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
            return this.textureInfo;
        }
        Logger.e(this.TAG, "createTexture: bitmap is null! path = " + this.sourceImagePath, new RuntimeException("\u5806\u6808"));
        return null;
    }

    private Bitmap decodeBitmap(String str, CGSize cGSize) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i3 = 1;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        if (cGSize != null) {
            i3 = (int) (options.outWidth / cGSize.width);
        }
        options2.inSampleSize = i3;
        return BitmapFactory.decodeFile(str, options2);
    }

    public static CGSize getDefaultOutputImageSize(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = (int) (options.outWidth / IMAGE_DECODE_SIZE.width);
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options2);
        int i3 = options2.outWidth;
        int i16 = options2.outHeight;
        if (readImagePreferRotation(str) % 2 == 1) {
            return new CGSize(i16, i3);
        }
        return new CGSize(i3, i16);
    }

    @NonNull
    private Matrix getImageTextureMatrix() {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
        return matrix;
    }

    private void readExtraDecodeSize(IVideoDecoder.Params params) {
        HashMap<String, Object> hashMap = params.extraInfo;
        if (hashMap == null) {
            return;
        }
        Object obj = hashMap.get(EXTRA_INFO_KEY_DECODE_SIZE);
        if (obj instanceof CGSize) {
            params.outputSize = (CGSize) obj;
        }
    }

    private static int readImagePreferRotation(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt == 6) {
                    return 3;
                }
                if (attributeInt != 8) {
                    return 0;
                }
                return 1;
            }
            return 2;
        } catch (IOException e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public String getSourcePath() {
        return this.sourceImagePath;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public TextureInfo getTextureInfo() {
        return this.textureInfo;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public boolean hasTrack() {
        if (this.sourceImagePath != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public boolean isLastFrameValid() {
        return true;
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public Surface outputSurface() {
        return null;
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public synchronized CMSampleState readSample(CMTime cMTime) {
        if (cMTime.getTimeUs() >= this.timeRange.getDuration().getTimeUs()) {
            return CMSampleState.fromError(-1L);
        }
        createTexture();
        return new CMSampleState(cMTime);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public synchronized void release(boolean z16) {
        Logger.i(this.TAG, "release() start: disposeSource = [" + z16 + "]");
        checkThread();
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null) {
            textureInfo.release();
            this.textureInfo = null;
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        Logger.i(this.TAG, "release() end: disposeSource = [" + z16 + "]");
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void seekTo(CMTime cMTime) {
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void start(@Nullable CMTimeRange cMTimeRange) {
        start(cMTimeRange, CMTime.CMTimeZero);
    }

    @Override // com.tencent.tav.decoder.IVideoDecoder
    public void seekTo(CMTime cMTime, boolean z16) {
    }

    @Override // com.tencent.tav.decoder.IDecoder
    public void start(CMTimeRange cMTimeRange, CMTime cMTime) {
        if (cMTimeRange == null) {
            this.timeRange = new CMTimeRange(CMTime.CMTimeZero, this.frameDuration);
        } else {
            this.timeRange = new CMTimeRange(cMTimeRange.getStart(), cMTimeRange.getDuration());
        }
    }
}
