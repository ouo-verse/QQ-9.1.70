package com.tencent.comic.hippy.view;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class BoodoHippyImageView extends HippyImageView {
    private Bitmap mBlurBitmap;
    private String mBlurBitmapKey;
    private int mBlurRadius;

    public BoodoHippyImageView(Context context) {
        super(context);
        this.mBlurBitmap = null;
        this.mBlurBitmapKey = null;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGuassian() {
        Bitmap bitmap = this.mSourceDrawable.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    float blurRate = getBlurRate(width, height, this.mBlurRadius);
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) (width / blurRate), (int) (height / blurRate), true);
                    eh.a(bitmap, (int) (this.mBlurRadius / blurRate));
                    if (QLog.isColorLevel()) {
                        QLog.d("QQHippyImageView", 2, "mBlurRadius", Integer.valueOf(this.mBlurRadius), " blurRate:", Float.valueOf(blurRate));
                    }
                } catch (Exception e16) {
                    QLog.e("QQHippyImageView", 1, e16, new Object[0]);
                } catch (OutOfMemoryError unused) {
                    QLog.e("QQHippyImageView", 1, "shouldSetContent BlurBitmap oom");
                }
                return;
            } finally {
                onGaussianBlurComplete(bitmap, null);
            }
        }
        QLog.e("QQHippyImageView", 1, "shouldSetContent BlurBitmap tempBitmap == null || tempBitmap.isRecycled()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public Bitmap getBitmap() {
        if (this.mBlurRadius > 0) {
            return this.mBlurBitmap;
        }
        return super.getBitmap();
    }

    public void onGaussianBlurComplete(Bitmap bitmap, Map map) {
        this.mBlurBitmap = bitmap;
        post(new Runnable() { // from class: com.tencent.comic.hippy.view.BoodoHippyImageView.2
            @Override // java.lang.Runnable
            public void run() {
                BoodoHippyImageView.this.performSetContent();
            }
        });
    }

    public void setBlurRadius(int i3) {
        this.mBlurRadius = i3;
        if (QLog.isColorLevel()) {
            QLog.d("hippyImageView", 2, "setBlurRadius blurRadius:" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public boolean shouldSetContent() {
        IDrawableTarget iDrawableTarget;
        if (this.mBlurRadius > 0 && (iDrawableTarget = this.mSourceDrawable) != null && iDrawableTarget.getBitmap() != null) {
            String str = getUrl() + "_" + this.mBlurRadius;
            if (str.equals(this.mBlurBitmapKey)) {
                return true;
            }
            this.mBlurBitmapKey = str;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.comic.hippy.view.BoodoHippyImageView.1
                @Override // java.lang.Runnable
                public void run() {
                    BoodoHippyImageView.this.handleGuassian();
                }
            }, 16, null, false);
            return false;
        }
        return super.shouldSetContent();
    }

    private float getBlurRate(int i3, int i16, int i17) {
        float sqrt = (float) Math.sqrt(i17);
        float f16 = i3;
        if (sqrt > f16) {
            sqrt = f16;
        }
        float f17 = i16;
        return sqrt > f17 ? f17 : sqrt;
    }

    private void init() {
        this.mBlurRadius = 0;
        this.mBlurBitmap = null;
        this.mBlurBitmapKey = null;
    }
}
