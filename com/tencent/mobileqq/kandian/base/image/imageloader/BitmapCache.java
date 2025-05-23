package com.tencent.mobileqq.kandian.base.image.imageloader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.h;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class BitmapCache implements IBitmapCache {
    public static final int DECODE_BUFFER_SIZE = 16384;
    public static final String TAG = ImageManager.TAG_PREFIX + BitmapCache.class.getSimpleName();
    private final h<Bitmap> mReleaser;
    private final List<byte[]> mTempBuffers = Collections.synchronizedList(new LinkedList());
    private final com.tencent.mobileqq.kandian.base.image.a mPool = new com.tencent.mobileqq.kandian.base.image.a(2097152);
    private final List<SoftReference<Bitmap>> cachedForReuseBitmap = Collections.synchronizedList(new ArrayList());
    int reuseBitmapCount = 0;
    int totalGetBitmap = 0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements h<Bitmap> {
        a() {
        }

        @Override // com.tencent.mobileqq.kandian.base.image.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void release(Bitmap bitmap) {
            boolean z16;
            if (bitmap == null) {
                return;
            }
            c.e(BitmapCache.TAG, "recycle:" + bitmap);
            if (c.d()) {
                synchronized (BitmapCache.this.cachedForReuseBitmap) {
                    ArrayList arrayList = new ArrayList();
                    z16 = false;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= BitmapCache.this.cachedForReuseBitmap.size()) {
                            break;
                        }
                        Bitmap bitmap2 = (Bitmap) ((SoftReference) BitmapCache.this.cachedForReuseBitmap.get(i3)).get();
                        if (bitmap2 != null) {
                            if (bitmap2 == bitmap) {
                                z16 = true;
                                break;
                            }
                        } else {
                            arrayList.add((SoftReference) BitmapCache.this.cachedForReuseBitmap.get(i3));
                        }
                        i3++;
                    }
                    if (!arrayList.isEmpty()) {
                        BitmapCache.this.cachedForReuseBitmap.removeAll(arrayList);
                    }
                }
                if (!z16) {
                    BitmapCache.this.cachedForReuseBitmap.add(new SoftReference(bitmap));
                    return;
                }
                QLog.e(BitmapCache.TAG, 1, "reuse same bitmap " + bitmap);
                return;
            }
            bitmap.recycle();
        }
    }

    public BitmapCache() {
        for (int i3 = 0; i3 < 5; i3++) {
            addTempBuffer(new byte[16384]);
        }
        this.mReleaser = new a();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public void addTempBuffer(byte[] bArr) {
        this.mTempBuffers.add(bArr);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public synchronized void cacheBitmap(com.tencent.mobileqq.kandian.base.image.b bVar, k52.b bVar2) {
        if (bVar == null) {
            return;
        }
        putImageToCache(bVar.a(), bVar2);
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public synchronized void clean() {
        this.mPool.a();
        this.cachedForReuseBitmap.clear();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    @Nullable
    public k52.b getBitmap(com.tencent.mobileqq.kandian.base.image.b bVar) {
        com.tencent.mobileqq.kandian.base.image.imageloader.a closeableBitmapFromCache;
        if (bVar != null && (closeableBitmapFromCache = getCloseableBitmapFromCache(bVar.a())) != null) {
            synchronized (closeableBitmapFromCache) {
                if (closeableBitmapFromCache.b()) {
                    return closeableBitmapFromCache.mo197clone();
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public com.tencent.mobileqq.kandian.base.image.a getBytePool() {
        return this.mPool;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    @Nullable
    public com.tencent.mobileqq.kandian.base.image.imageloader.a getCloseableBitmapFromCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object g16 = ImageCacheHelper.f98636a.g(str);
        if (!(g16 instanceof com.tencent.mobileqq.kandian.base.image.imageloader.a)) {
            return null;
        }
        return (com.tencent.mobileqq.kandian.base.image.imageloader.a) g16;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public h<Bitmap> getReleaser() {
        return this.mReleaser;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    @Nullable
    public synchronized Bitmap getReusableBitmap(BitmapFactory.Options options) {
        Bitmap bitmap;
        this.totalGetBitmap++;
        String str = "notFound";
        ArrayList arrayList = new ArrayList();
        synchronized (this.cachedForReuseBitmap) {
            int i3 = 0;
            while (true) {
                if (i3 < this.cachedForReuseBitmap.size()) {
                    bitmap = this.cachedForReuseBitmap.get(i3).get();
                    if (bitmap != null) {
                        if (c.a(bitmap, options)) {
                            str = "cache";
                            arrayList.add(this.cachedForReuseBitmap.get(i3));
                            break;
                        }
                    } else {
                        arrayList.add(this.cachedForReuseBitmap.get(i3));
                    }
                    i3++;
                } else {
                    bitmap = null;
                    break;
                }
            }
            if (!arrayList.isEmpty()) {
                this.cachedForReuseBitmap.removeAll(arrayList);
            }
        }
        if (bitmap != null) {
            this.reuseBitmapCount++;
        }
        if (QLog.isColorLevel()) {
            c.e(TAG, "getReuseableBitmap found:" + str + " picSize:" + options.outWidth + HippyTKDListViewAdapter.X + options.outHeight + " bitmap:" + bitmap + " state:" + toString());
        }
        return bitmap;
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public int getTempBufferSize() {
        return this.mTempBuffers.size();
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    public void putImageToCache(String str, k52.b bVar) {
        if (!TextUtils.isEmpty(str) && bVar != null) {
            ImageCacheHelper.f98636a.i(str, bVar.clone(), Business.Default);
        }
    }

    @Override // com.tencent.mobileqq.kandian.base.image.api.IBitmapCache
    @Nullable
    public byte[] removeTempBuffer(int i3) {
        return this.mTempBuffers.remove(i3);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("total:");
        sb5.append(this.totalGetBitmap);
        sb5.append(" reuse:");
        sb5.append(this.reuseBitmapCount);
        if (this.totalGetBitmap > 0) {
            sb5.append(" rate:");
            sb5.append(this.reuseBitmapCount / this.totalGetBitmap);
        }
        return sb5.toString();
    }
}
