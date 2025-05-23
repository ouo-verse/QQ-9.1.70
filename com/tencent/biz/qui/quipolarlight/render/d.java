package com.tencent.biz.qui.quipolarlight.render;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/render/d;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "onSuccess", "", "errorMsg", "onFailed", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public interface d {
    void onFailed(@Nullable String errorMsg);

    void onSuccess(@Nullable Bitmap bitmap);
}
