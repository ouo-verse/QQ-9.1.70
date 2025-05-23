package com.tencent.hippy.qq.adapter.image;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mtt.hippy.views.image.HippyImageView;
import com.tencent.mtt.supportui.adapters.image.IDrawableTarget;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQImageView extends HippyImageView {
    private static final String TAG = "HippyQQImageView";
    private Bitmap mBlurBitmap;
    private String mBlurBitmapKey;
    private int mBlurRadius;
    private WeakReference<HippyImageInfo> mImageInfoRef;

    public HippyQQImageView(Context context) {
        super(context);
        this.mImageInfoRef = new WeakReference<>(null);
        resetBlurData();
    }

    private float calculateBlurSampleRate(int i3, int i16, int i17) {
        float sqrt = (float) Math.sqrt(i17);
        float f16 = i3;
        if (sqrt > f16) {
            sqrt = f16;
        }
        float f17 = i16;
        if (sqrt > f17) {
            return f17;
        }
        return sqrt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBlurComplete$1() {
        performSetContent();
    }

    private void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public void bindImageInfo(HippyImageInfo hippyImageInfo) {
        this.mImageInfoRef = new WeakReference<>(hippyImageInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: blurBitmap, reason: merged with bridge method [inline-methods] */
    public void lambda$shouldSetContent$0() {
        Bitmap bitmap;
        IDrawableTarget iDrawableTarget = this.mSourceDrawable;
        if (iDrawableTarget != null) {
            bitmap = iDrawableTarget.getBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float calculateBlurSampleRate = calculateBlurSampleRate(width, height, this.mBlurRadius);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (width / calculateBlurSampleRate), (int) (height / calculateBlurSampleRate), true);
                eh.a(createScaledBitmap, (int) (this.mBlurRadius / calculateBlurSampleRate));
                onBlurComplete(createScaledBitmap);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "blurBitmap BlurRadius:", Integer.valueOf(this.mBlurRadius), " blurRate:", Float.valueOf(calculateBlurSampleRate));
                    return;
                }
                return;
            } catch (Throwable th5) {
                onBlurComplete(null);
                QLog.e(TAG, 1, "blurBitmap e:", th5);
                return;
            }
        }
        QLog.e(TAG, 1, "blurBitmap sourceBitmap is null or recycled");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public Bitmap getBitmap() {
        if (this.mBlurRadius > 0) {
            return this.mBlurBitmap;
        }
        return super.getBitmap();
    }

    public HippyImageInfo getImageInfo() {
        return this.mImageInfoRef.get();
    }

    protected void onBlurComplete(Bitmap bitmap) {
        Bitmap bitmap2 = this.mBlurBitmap;
        this.mBlurBitmap = bitmap;
        recycleBitmap(bitmap2);
        post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.image.c
            @Override // java.lang.Runnable
            public final void run() {
                HippyQQImageView.this.lambda$onBlurComplete$1();
            }
        });
    }

    public void onViewDestroy() {
        recycleBitmap(this.mBlurBitmap);
        this.mBlurBitmap = null;
    }

    public void resetBlurData() {
        Bitmap bitmap = this.mBlurBitmap;
        this.mBlurRadius = 0;
        this.mBlurBitmap = null;
        this.mBlurBitmapKey = null;
        recycleBitmap(bitmap);
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.views.list.HippyRecycler
    public void resetProps() {
        super.resetProps();
        resetBlurData();
    }

    public void setBlurRadius(int i3) {
        this.mBlurRadius = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView
    public boolean shouldSetContent() {
        IDrawableTarget iDrawableTarget;
        String source;
        IDrawableTarget iDrawableTarget2 = this.mSourceDrawable;
        if (iDrawableTarget2 != null && (source = iDrawableTarget2.getSource()) != null && !source.equals(this.mUrl) && isAttached()) {
            return false;
        }
        if (this.mBlurRadius > 0 && (iDrawableTarget = this.mSourceDrawable) != null && iDrawableTarget.getBitmap() != null) {
            String str = getUrl() + "_" + this.mBlurRadius;
            if (str.equals(this.mBlurBitmapKey)) {
                return true;
            }
            this.mBlurBitmapKey = str;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.adapter.image.b
                @Override // java.lang.Runnable
                public final void run() {
                    HippyQQImageView.this.lambda$shouldSetContent$0();
                }
            }, 16, null, false);
            return false;
        }
        return super.shouldSetContent();
    }
}
