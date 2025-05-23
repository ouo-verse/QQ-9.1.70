package com.tencent.biz.qui.quipolarlight;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qui.quipolarlight.render.d;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qui/quipolarlight/QUIPolarLightView$polarRenderCallback$1", "Lcom/tencent/biz/qui/quipolarlight/render/d;", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "errorMsg", "onFailed", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUIPolarLightView$polarRenderCallback$1 implements d {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ QUIPolarLightView f95202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public QUIPolarLightView$polarRenderCallback$1(QUIPolarLightView qUIPolarLightView) {
        this.f95202a = qUIPolarLightView;
    }

    @Override // com.tencent.biz.qui.quipolarlight.render.d
    public void onFailed(@Nullable String errorMsg) {
        ud0.d.b("QUIPolarLightView", ud0.d.f438811e, "polar light render failed: " + errorMsg);
    }

    @Override // com.tencent.biz.qui.quipolarlight.render.d
    public void onSuccess(@Nullable final Bitmap bitmap) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.biz.qui.quipolarlight.QUIPolarLightView$polarRenderCallback$1$onSuccess$1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        QUIPolarLightView$polarRenderCallback$1.this.f95202a.setImageBitmap(bitmap2);
                    }
                }
            });
        } else if (bitmap != null) {
            this.f95202a.setImageBitmap(bitmap);
        }
    }
}
