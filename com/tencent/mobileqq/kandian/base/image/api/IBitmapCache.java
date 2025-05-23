package com.tencent.mobileqq.kandian.base.image.api;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.kandian.base.image.a;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.kandian.base.image.h;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\u0012\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH&J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H&J\u001c\u0010\u0018\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H&J\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&J\b\u0010\u001b\u001a\u00020\u0004H&J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "byteArray", "", "addTempBuffer", "", "index", "removeTempBuffer", "getTempBufferSize", "Lcom/tencent/mobileqq/kandian/base/image/h;", "Landroid/graphics/Bitmap;", "getReleaser", "Lcom/tencent/mobileqq/kandian/base/image/a;", "getBytePool", "Lcom/tencent/mobileqq/kandian/base/image/b;", Const.BUNDLE_KEY_REQUEST, "Lk52/b;", "getBitmap", "state", "cacheBitmap", "", "key", MimeHelper.IMAGE_SUBTYPE_BITMAP, "putImageToCache", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/a;", "getCloseableBitmapFromCache", "clean", "Landroid/graphics/BitmapFactory$Options;", "options", "getReusableBitmap", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IBitmapCache extends QRouteApi {
    void addTempBuffer(@Nullable byte[] byteArray);

    void cacheBitmap(@Nullable b request, @Nullable k52.b state);

    void clean();

    @Nullable
    k52.b getBitmap(@Nullable b request);

    @Nullable
    a getBytePool();

    @Nullable
    com.tencent.mobileqq.kandian.base.image.imageloader.a getCloseableBitmapFromCache(@Nullable String key);

    @Nullable
    h<Bitmap> getReleaser();

    @Nullable
    Bitmap getReusableBitmap(@Nullable BitmapFactory.Options options);

    int getTempBufferSize();

    void putImageToCache(@Nullable String key, @Nullable k52.b bitmap);

    @Nullable
    byte[] removeTempBuffer(int index);
}
