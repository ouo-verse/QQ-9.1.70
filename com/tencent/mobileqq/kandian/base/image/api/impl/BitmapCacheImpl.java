package com.tencent.mobileqq.kandian.base.image.api.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.kandian.base.image.a;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.b;
import com.tencent.mobileqq.kandian.base.image.h;
import com.tencent.mobileqq.kandian.base.image.imageloader.BitmapCache;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0001J\u001d\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u0096\u0001J\u0015\u0010\f\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0001J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001J\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0096\u0001J\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0013H\u0096\u0001J\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001J\t\u0010\u001a\u001a\u00020\u0019H\u0096\u0001J\u001d\u0010\u001c\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\bH\u0096\u0001J\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u0019H\u0096\u0001\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/kandian/base/image/api/impl/BitmapCacheImpl;", "Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;", "", "byteArray", "", "addTempBuffer", "Lcom/tencent/mobileqq/kandian/base/image/b;", Const.BUNDLE_KEY_REQUEST, "Lk52/b;", "state", "cacheBitmap", "clean", "getBitmap", "Lcom/tencent/mobileqq/kandian/base/image/a;", "getBytePool", "", "key", "Lcom/tencent/mobileqq/kandian/base/image/imageloader/a;", "getCloseableBitmapFromCache", "Lcom/tencent/mobileqq/kandian/base/image/h;", "Landroid/graphics/Bitmap;", "getReleaser", "Landroid/graphics/BitmapFactory$Options;", "options", "getReusableBitmap", "", "getTempBufferSize", MimeHelper.IMAGE_SUBTYPE_BITMAP, "putImageToCache", "index", "removeTempBuffer", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class BitmapCacheImpl implements IBitmapCache {
    private final /* synthetic */ BitmapCache $$delegate_0 = new BitmapCache();

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public void addTempBuffer(byte[] byteArray) {
        this.$$delegate_0.addTempBuffer(byteArray);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public void cacheBitmap(b request, k52.b state) {
        this.$$delegate_0.cacheBitmap(request, state);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public void clean() {
        this.$$delegate_0.clean();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public k52.b getBitmap(b request) {
        return this.$$delegate_0.getBitmap(request);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public a getBytePool() {
        return this.$$delegate_0.getBytePool();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public com.tencent.mobileqq.kandian.base.image.imageloader.a getCloseableBitmapFromCache(String key) {
        return this.$$delegate_0.getCloseableBitmapFromCache(key);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public h<Bitmap> getReleaser() {
        return this.$$delegate_0.getReleaser();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public Bitmap getReusableBitmap(BitmapFactory.Options options) {
        return this.$$delegate_0.getReusableBitmap(options);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public int getTempBufferSize() {
        return this.$$delegate_0.getTempBufferSize();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public void putImageToCache(String key, k52.b bitmap) {
        this.$$delegate_0.putImageToCache(key, bitmap);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public byte[] removeTempBuffer(int index) {
        return this.$$delegate_0.removeTempBuffer(index);
    }
}
