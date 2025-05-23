package com.qzone.module.feedcomponent.ui;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"com/qzone/module/feedcomponent/ui/QZoneOldFrdHotVideoItemView$updateData$1$1", "Lcom/tencent/component/media/image/ImageLoader$ImageLoadListener;", "onImageCanceled", "", "url", "", "option", "Lcom/tencent/component/media/image/ImageLoader$Options;", "onImageFailed", "onImageLoaded", "drawable", "Landroid/graphics/drawable/Drawable;", "onImageProgress", "p0", "p1", "", "p2", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class QZoneOldFrdHotVideoItemView$updateData$1$1 implements ImageLoader.ImageLoadListener {
    final /* synthetic */ QZoneOldFrdHotVideoItemView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QZoneOldFrdHotVideoItemView$updateData$1$1(QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView) {
        this.this$0 = qZoneOldFrdHotVideoItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onImageLoaded$lambda$0(QZoneOldFrdHotVideoItemView this$0, Drawable drawable) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        imageView = this$0.videoCoverView;
        imageView.setImageDrawable(drawable);
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageFailed(String url, ImageLoader.Options option) {
        QLog.i("QZoneOldFrdHotVideoItemView", 1, "onImageFailed, url=" + url);
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageLoaded(String url, final Drawable drawable, ImageLoader.Options option) {
        ImageView imageView;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            imageView = this.this$0.videoCoverView;
            imageView.setImageDrawable(drawable);
        } else {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final QZoneOldFrdHotVideoItemView qZoneOldFrdHotVideoItemView = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.qzone.module.feedcomponent.ui.f
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneOldFrdHotVideoItemView$updateData$1$1.onImageLoaded$lambda$0(QZoneOldFrdHotVideoItemView.this, drawable);
                }
            });
        }
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageCanceled(String url, ImageLoader.Options option) {
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageProgress(String p06, float p16, ImageLoader.Options p26) {
    }
}
