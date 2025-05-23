package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.tencent.avcore.jni.codec.HWColorFormat;

/* compiled from: P */
/* loaded from: classes2.dex */
public class RoundedVignetteBitmapDisplayer extends RoundedBitmapDisplayer {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    protected static class RoundedVignetteDrawable extends RoundedBitmapDisplayer.RoundedDrawable {
        RoundedVignetteDrawable(Bitmap bitmap, int i3, int i16) {
            super(bitmap, i3, i16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer.RoundedDrawable, android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RadialGradient radialGradient = new RadialGradient(this.mRect.centerX(), (this.mRect.centerY() * 1.0f) / 0.7f, 1.3f * this.mRect.centerX(), new int[]{0, 0, HWColorFormat.COLOR_FormatVendorStartUnused}, new float[]{0.0f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(1.0f, 0.7f);
            radialGradient.setLocalMatrix(matrix);
            this.paint.setShader(new ComposeShader(this.bitmapShader, radialGradient, PorterDuff.Mode.SRC_OVER));
        }
    }

    public RoundedVignetteBitmapDisplayer(int i3, int i16) {
        super(i3, i16);
    }

    @Override // com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer, com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new RoundedVignetteDrawable(bitmap, this.cornerRadius, this.margin));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
