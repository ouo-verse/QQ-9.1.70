package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.filter.GLSLRender;
import com.tencent.mapsdk.internal.by;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.TAVImageFactory;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.utils.MathUtils;
import com.tencent.tavkit.utils.TAVBitmapUtils;
import com.tencent.tavkit.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CIImage implements Cloneable {

    @FloatRange(from = 0.0d, to = by.f147964a)
    private float alpha;

    @Nullable
    private Bitmap bitmap;

    @Nullable
    private CGRect frame;
    private boolean isHardMode;
    private final String mTAG;
    private final List<CIImage> overlayImages;
    private int preferRotation;
    private int rotation;
    private final CGSize size;
    private String textureCacheKey;

    @Nullable
    private TextureInfo textureInfo;

    @Nullable
    private Matrix transform;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tavkit.ciimage.CIImage$1, reason: invalid class name */
    /* loaded from: classes26.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode;

        static {
            int[] iArr = new int[TAVVideoConfiguration.TAVVideoConfigurationContentMode.values().length];
            $SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode = iArr;
            try {
                iArr[TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFit.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[TAVVideoConfiguration.TAVVideoConfigurationContentMode.scaleToFit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CIImage(@NonNull CGSize cGSize) {
        String str = "CIImage@" + Integer.toHexString(hashCode());
        this.mTAG = str;
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        Logger.v(str, "CIImage() called with: renderSize = [" + cGSize + "]");
        this.size = cGSize;
    }

    private void addOverlayImage(CIImage cIImage) {
        synchronized (this) {
            this.overlayImages.add(cIImage);
        }
    }

    private void applyFrameOriginTransition(PointF pointF) {
        if (pointF.x != 0.0f || pointF.y != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.postTranslate(-pointF.x, -pointF.y);
            imageByApplyingTransform(matrix);
        }
    }

    private CGRect applyRotationToFrame(CGRect cGRect, int i3) {
        if (i3 % 2 != 0) {
            PointF pointF = cGRect.origin;
            float f16 = pointF.y;
            float f17 = pointF.x;
            CGSize cGSize = cGRect.size;
            return new CGRect(f16, f17, cGSize.height, cGSize.width);
        }
        return cGRect.m257clone();
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
        options2.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options2);
    }

    @NonNull
    private Matrix getImageTextureMatrix() {
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f});
        return matrix;
    }

    private boolean isByTransform() {
        if (this.preferRotation == 0 && this.transform == null && this.rotation == 0) {
            return false;
        }
        return true;
    }

    public void applyFillInFrame(CGRect cGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        Matrix matrix = new Matrix();
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[tAVVideoConfigurationContentMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(cGRect.size.width / getExtent().size.width, cGRect.size.height / getExtent().size.height);
                    matrix.postConcat(matrix2);
                    Matrix matrix3 = new Matrix();
                    PointF pointF = cGRect.origin;
                    matrix3.postTranslate(pointF.x, pointF.y);
                    matrix.postConcat(matrix3);
                    imageByApplyingTransform(matrix);
                    return;
                }
                return;
            }
            matrix.postConcat(MathUtils.transformBySourceRectFill(getExtent(), cGRect));
            imageByApplyingTransform(matrix);
            return;
        }
        matrix.postConcat(MathUtils.transformBySourceRectFit(getExtent(), cGRect));
        imageByApplyingTransform(matrix);
    }

    public void applyFixInSize(CGSize cGSize, TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        CGSize sizeFit;
        if (!Utils.isSizeValid(cGSize)) {
            return;
        }
        int i3 = AnonymousClass1.$SwitchMap$com$tencent$tavkit$composition$model$TAVVideoConfiguration$TAVVideoConfigurationContentMode[tAVVideoConfigurationContentMode.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    sizeFit = MathUtils.sizeFit(this.size, cGSize);
                } else {
                    sizeFit = MathUtils.sizeScale(this.size, cGSize);
                }
            } else {
                sizeFit = MathUtils.sizeFill(this.size, cGSize);
            }
        } else {
            sizeFit = MathUtils.sizeFit(this.size, cGSize);
        }
        Matrix matrix = new Matrix();
        float f16 = sizeFit.width;
        CGSize cGSize2 = this.size;
        matrix.postScale(f16 / cGSize2.width, sizeFit.height / cGSize2.height);
        imageByApplyingTransform(matrix);
        CGSize cGSize3 = this.size;
        cGSize3.height = sizeFit.height;
        cGSize3.width = sizeFit.width;
    }

    public void applyFlip(boolean z16, boolean z17) {
        float f16;
        float f17;
        if (!z16 && !z17) {
            return;
        }
        float f18 = -1.0f;
        if (z16) {
            f16 = -1.0f;
        } else {
            f16 = 1.0f;
        }
        float f19 = 0.0f;
        if (z16) {
            f17 = this.size.width;
        } else {
            f17 = 0.0f;
        }
        if (!z17) {
            f18 = 1.0f;
        }
        if (z17) {
            f19 = this.size.height;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f18);
        matrix.postTranslate(f17, f19);
        imageByApplyingTransform(matrix);
    }

    public void applyPreferRotation() {
        applyPreferRotation(0);
    }

    public void clearSelfTexture() {
        this.textureInfo = null;
    }

    @Deprecated
    public Bitmap convertToBitmap() {
        return TAVGLUtils.saveBitmap(this);
    }

    public void drawTo(Renderer renderer) {
        TextureInfo drawTextureInfo = getDrawTextureInfo();
        if (drawTextureInfo != null) {
            Logger.v(this.mTAG, "draw: with drawTexture = " + drawTextureInfo + ", filter = " + renderer);
            renderer.render(drawTextureInfo, this.transform, drawTextureInfo.getTextureMatrix(), this.alpha, this.frame);
        }
        if (this.overlayImages.isEmpty()) {
            return;
        }
        Logger.v(this.mTAG, "draw: with: draw overlayImages = " + this.overlayImages + ", filter = " + renderer);
        Iterator<CIImage> it = this.overlayImages.iterator();
        while (it.hasNext()) {
            it.next().drawTo(renderer);
        }
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getAlpha() {
        return this.alpha;
    }

    @Nullable
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    @Nullable
    public TextureInfo getDrawTextureInfo() {
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null) {
            return textureInfo;
        }
        EGLContext eglGetCurrentContext = EGL14.eglGetCurrentContext();
        if (this.textureCacheKey == null) {
            this.textureCacheKey = String.valueOf(hashCode());
        }
        TextureInfo textureInfo2 = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
        if (eglGetCurrentContext != null && textureInfo2 != null && !textureInfo2.isReleased()) {
            return textureInfo2;
        }
        if (this.bitmap == null) {
            return null;
        }
        TextureInfo textureInfo3 = new TextureInfo(RenderContext.createTexture(GLSLRender.GL_TEXTURE_2D), GLSLRender.GL_TEXTURE_2D, this.bitmap.getWidth(), this.bitmap.getHeight(), getImageTextureMatrix(), this.preferRotation);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, textureInfo3.textureID);
        GLUtils.texImage2D(GLSLRender.GL_TEXTURE_2D, 0, this.bitmap, 0);
        GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, 0);
        ThreadLocalTextureCache.getInstance().putTextureInfo(this.textureCacheKey, textureInfo3);
        Logger.v(this.mTAG, "getDrawTextureInfo: bind bitmap texture, texture = " + textureInfo3 + ", eglContext = " + eglGetCurrentContext);
        if (this.isHardMode) {
            this.bitmap.recycle();
            this.bitmap = null;
            Logger.v(this.mTAG, "getDrawTextureInfo: isHardMode, bitmap.recycle()");
        }
        return textureInfo3;
    }

    public CGRect getExtent() {
        return new CGRect(new PointF(0.0f, 0.0f), this.size);
    }

    @NonNull
    public List<CIImage> getOverlayImages() {
        return this.overlayImages;
    }

    @NonNull
    public CGSize getSize() {
        return this.size;
    }

    @NonNull
    public CGSize getTargetSize() {
        int i3;
        int i16 = this.rotation;
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null) {
            i3 = textureInfo.preferRotation;
        } else {
            i3 = 0;
        }
        if ((i16 + i3) % 2 == 1) {
            CGSize cGSize = this.size;
            return new CGSize(cGSize.height, cGSize.width);
        }
        return this.size.m258clone();
    }

    @Nullable
    public Matrix getTransform() {
        return this.transform;
    }

    public boolean hasOverlay() {
        return !this.overlayImages.isEmpty();
    }

    public CIImage imageApplyFillInFrame(CGRect cGRect, TAVVideoConfiguration.TAVVideoConfigurationContentMode tAVVideoConfigurationContentMode) {
        if (tAVVideoConfigurationContentMode == TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill) {
            imageByCroppingToRect(MathUtils.rectFit(new CGRect(new PointF(), cGRect.size), getExtent()));
        }
        applyFillInFrame(cGRect, tAVVideoConfigurationContentMode);
        return this;
    }

    public CIImage imageByApplyingTransform(Matrix matrix) {
        if (this.transform == null) {
            this.transform = new Matrix();
        }
        this.transform.postConcat(matrix);
        Logger.v(this.mTAG, "imageByApplyingTransform() called with: in transform = [" + matrix + "], result transform = " + this.transform);
        return this;
    }

    public CIImage imageByCompositingOverImage(CIImage cIImage) {
        Logger.v(this.mTAG, "imageByCompositingOverImage() called with: destImage = [" + cIImage + "]");
        cIImage.addOverlayImage(this);
        return cIImage;
    }

    public CIImage imageByCroppingToRect(CGRect cGRect) {
        int i3;
        if (!Utils.isRectValid(cGRect)) {
            return this;
        }
        Logger.v(this.mTAG, "imageByCroppingToRect: frame = [" + cGRect + "]");
        CGSize cGSize = this.size;
        CGSize cGSize2 = cGRect.size;
        cGSize.width = cGSize2.width;
        cGSize.height = cGSize2.height;
        TextureInfo textureInfo = this.textureInfo;
        if (textureInfo != null) {
            i3 = textureInfo.preferRotation;
        } else {
            i3 = 0;
        }
        this.frame = applyRotationToFrame(cGRect, i3);
        applyFrameOriginTransition(cGRect.origin);
        return this;
    }

    public boolean isCanvasImage() {
        if (this.bitmap == null && this.textureInfo == null && this.overlayImages.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isOriginal() {
        if (isByTransform() || this.frame != null || hasOverlay() || this.alpha != 1.0f) {
            return false;
        }
        return true;
    }

    public synchronized void release() {
        Logger.d(this.mTAG, "release() start");
        Bitmap bitmap = this.bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.bitmap.recycle();
            this.bitmap = null;
        }
        releaseCacheTexture();
        for (CIImage cIImage : this.overlayImages) {
            if (cIImage != null) {
                cIImage.release();
            }
        }
        this.overlayImages.clear();
        Logger.d(this.mTAG, "release() end");
    }

    public void releaseCacheTexture() {
        TextureInfo textureInfo = ThreadLocalTextureCache.getInstance().getTextureInfo(this.textureCacheKey);
        if (textureInfo != null) {
            textureInfo.release();
            ThreadLocalTextureCache.getInstance().remove(this.textureCacheKey);
        }
    }

    public void reset() {
        Logger.v(this.mTAG, "reset() called, before transform = " + this.transform);
        if (this.transform != null) {
            this.transform = null;
        }
    }

    public CIImage safeApplyTransform(Matrix matrix) {
        if (matrix != null && !matrix.isIdentity()) {
            Logger.v(this.mTAG, "safeApplyTransform: transform = [" + matrix + "]");
            float f16 = getExtent().origin.x + (getExtent().size.width / 2.0f);
            float f17 = getExtent().origin.y + (getExtent().size.height / 2.0f);
            Matrix matrix2 = new Matrix();
            matrix2.postTranslate(-f16, -f17);
            matrix2.postConcat(matrix);
            Matrix matrix3 = new Matrix();
            matrix3.postTranslate(f16, f17);
            matrix2.postConcat(matrix3);
            return imageByApplyingTransform(matrix2);
        }
        return this;
    }

    public void setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        this.alpha = f16;
    }

    public void setFrame(CGRect cGRect) {
        this.frame = cGRect;
    }

    public void setHardMode(boolean z16) {
        this.isHardMode = z16;
    }

    public CIImage simpleClone() {
        CIImage cIImage = new CIImage(this.size.m258clone());
        cIImage.textureInfo = this.textureInfo;
        cIImage.preferRotation = this.preferRotation;
        cIImage.bitmap = this.bitmap;
        cIImage.alpha = this.alpha;
        return cIImage;
    }

    public String toString() {
        return "CIImage{hash=" + Integer.toHexString(hashCode()) + ", size=" + this.size + ", textureInfo=" + this.textureInfo + ", bitmap=" + this.bitmap + ", transform=" + this.transform + ", frame=" + this.frame + ", overlayImages=" + this.overlayImages + '}';
    }

    public void applyPreferRotation(int i3) {
        TextureInfo drawTextureInfo = getDrawTextureInfo();
        if (drawTextureInfo == null) {
            return;
        }
        int i16 = i3 + drawTextureInfo.preferRotation;
        this.rotation = i16;
        if (i16 == 0) {
            return;
        }
        Logger.v(this.mTAG, "applyPreferRotation: textureInfo.preferRotation = " + this.rotation);
        Matrix matrix = new Matrix();
        DecoderUtils.getRotationMatrix(matrix, this.rotation, (float) drawTextureInfo.width, (float) drawTextureInfo.height);
        imageByApplyingTransform(matrix);
        if (this.rotation % 2 == 1) {
            CGSize cGSize = this.size;
            cGSize.width = drawTextureInfo.height;
            cGSize.height = drawTextureInfo.width;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CIImage m267clone() {
        CIImage cIImage = new CIImage(this.size.m258clone());
        cIImage.textureInfo = this.textureInfo;
        cIImage.textureCacheKey = this.textureCacheKey;
        cIImage.bitmap = this.bitmap;
        cIImage.preferRotation = this.preferRotation;
        cIImage.transform = new Matrix(this.transform);
        CGRect cGRect = this.frame;
        cIImage.frame = cGRect != null ? new CGRect(cGRect.origin, cGRect.size) : null;
        cIImage.overlayImages.clear();
        cIImage.overlayImages.addAll(this.overlayImages);
        cIImage.alpha = this.alpha;
        return cIImage;
    }

    public CIImage(TextureInfo textureInfo) {
        String str = "CIImage@" + Integer.toHexString(hashCode());
        this.mTAG = str;
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        Logger.v(str, "CIImage() called with: textureInfo = [" + textureInfo + "]");
        this.textureInfo = textureInfo;
        this.size = new CGSize((float) textureInfo.width, (float) textureInfo.height);
    }

    public CIImage(Bitmap bitmap) {
        String str = "CIImage@" + Integer.toHexString(hashCode());
        this.mTAG = str;
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        Logger.v(str, "CIImage() called with: bitmap = [" + bitmap + "]");
        this.bitmap = TAVImageFactory.fixSupportImageConfig(bitmap);
        this.size = new CGSize((float) bitmap.getWidth(), (float) bitmap.getHeight());
    }

    public CIImage(String str) {
        this(str, null);
    }

    public CIImage(String str, CGSize cGSize) {
        String str2 = "CIImage@" + Integer.toHexString(hashCode());
        this.mTAG = str2;
        this.overlayImages = new ArrayList();
        this.isHardMode = false;
        this.alpha = 1.0f;
        long currentTimeMillis = System.currentTimeMillis();
        this.preferRotation = TAVBitmapUtils.readImagePreferRotation(str);
        Bitmap decodeBitmap = decodeBitmap(str, cGSize);
        this.bitmap = decodeBitmap;
        Bitmap fixSupportImageConfig = TAVImageFactory.fixSupportImageConfig(decodeBitmap);
        this.bitmap = fixSupportImageConfig;
        if (fixSupportImageConfig != null) {
            CGSize cGSize2 = new CGSize(this.bitmap.getWidth(), this.bitmap.getHeight());
            this.size = cGSize2;
            Logger.v(str2, "CIImage() called with: imagePath = [" + str + "], sampleSize = " + cGSize + ", BitmapFactory.decodeFile cons ms = " + (System.currentTimeMillis() - currentTimeMillis) + ", outBitmapSize = " + cGSize2);
            return;
        }
        Logger.e(str2, "CIImage: \u56fe\u7247\u89e3\u7801\u5931\u8d25\uff01imagePath = " + str);
        this.size = new CGSize();
    }
}
