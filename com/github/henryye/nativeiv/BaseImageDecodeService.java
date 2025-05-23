package com.github.henryye.nativeiv;

import android.graphics.Bitmap;
import android.util.Base64;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.github.henryye.nativeiv.api.IImageDecodeService;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.libra.util.ImageContentType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class BaseImageDecodeService implements IImageDecodeService {
    private static final String TAG = "BaseImageDecodeService";
    private com.tencent.luggage.wxa.i.d mFallbackImageStreamFetcher;
    private final com.tencent.luggage.wxa.i.c mHttpImageStreamFetcher;
    private LinkedList<com.tencent.luggage.wxa.i.d> mImageStreamFetcherList;
    private boolean mIsTrackInitImages = false;
    private IImageDecodeService.a mDecodeSlave = null;
    private final List<IImageDecodeService.b> mDecodeEventListeners = new LinkedList();
    private final IImageDecodeService.b mCompactDecodeEventListener = new b();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c implements IImageDecodeService.c {
        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.c
        public void a(String str, Object obj) {
            if (obj != null) {
                ((IBitmap) obj).recycle();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Object f32856a;

        /* renamed from: b, reason: collision with root package name */
        public ImageDecodeConfig f32857b;

        /* renamed from: d, reason: collision with root package name */
        public WeakReference f32859d;

        /* renamed from: c, reason: collision with root package name */
        public volatile boolean f32858c = false;

        /* renamed from: e, reason: collision with root package name */
        public final c f32860e = new c();

        public d(BaseImageDecodeService baseImageDecodeService, Object obj, ImageDecodeConfig imageDecodeConfig) {
            this.f32856a = obj;
            this.f32857b = imageDecodeConfig;
            this.f32859d = new WeakReference(baseImageDecodeService);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f32858c || this.f32859d.get() == null) {
                return;
            }
            IBitmap loadBitmapSync = ((BaseImageDecodeService) this.f32859d.get()).loadBitmapSync(this.f32856a, this.f32857b);
            if (this.f32858c) {
                if (loadBitmapSync != null) {
                    loadBitmapSync.recycle();
                    return;
                }
                return;
            }
            ((BaseImageDecodeService) this.f32859d.get()).mCompactDecodeEventListener.a(this.f32856a.toString(), loadBitmapSync, this.f32860e, this.f32857b);
        }
    }

    public BaseImageDecodeService() {
        com.tencent.luggage.wxa.i.c cVar = new com.tencent.luggage.wxa.i.c();
        this.mHttpImageStreamFetcher = cVar;
        this.mImageStreamFetcherList = new LinkedList<>();
        addImageStreamFetcher(cVar, false);
        setBitmapDecodeSlave(new com.tencent.luggage.wxa.d.a());
    }

    private Bitmap.CompressFormat ensureCompressFormat(String str) {
        if ("image/webp".equals(str)) {
            return Bitmap.CompressFormat.WEBP;
        }
        if (!"image/jpeg".equals(str) && !ImageContentType.MIME_TYPE_JPG.equals(str)) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    private int ensureQuality(float f16) {
        if (f16 < 0.0f || f16 > 1.0f) {
            f16 = 0.92f;
        }
        return (int) (f16 * 100.0f);
    }

    private void runInThreadPool(Object obj, Runnable runnable) {
        if (this.mHttpImageStreamFetcher.accept(obj)) {
            com.github.henryye.nativeiv.a.INSTANCE.b(runnable);
        } else {
            com.github.henryye.nativeiv.a.INSTANCE.a(runnable);
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void addDecodeEventListener(@NonNull IImageDecodeService.b bVar) {
        this.mDecodeEventListeners.add(bVar);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void addImageStreamFetcher(@NonNull com.tencent.luggage.wxa.i.d dVar, boolean z16) {
        com.tencent.luggage.wxa.h.b.c(TAG, "hy: %d adding stream fetcher: %s %b", Integer.valueOf(hashCode()), dVar.getClass().getSimpleName(), Boolean.valueOf(z16));
        if (!z16) {
            this.mImageStreamFetcherList.push(dVar);
        } else {
            this.mFallbackImageStreamFetcher = dVar;
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public String encodeToBase64(Bitmap bitmap, int i3, float f16) {
        if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0 && !bitmap.isRecycled()) {
            Bitmap.CompressFormat ensureCompressFormat = ensureCompressFormat(i3);
            int ensureQuality = ensureQuality(f16);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            boolean compress = bitmap.compress(ensureCompressFormat, ensureQuality, byteArrayOutputStream);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.h.b.b(TAG, "base64_encode IOException e %s", e16.toString());
                compress = false;
            }
            if (compress && byteArrayOutputStream.size() > 0) {
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            }
            com.tencent.luggage.wxa.h.b.b(TAG, "base64_encode Bitmap compress error.", new Object[0]);
        }
        return null;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public byte[] encodeToBuffer(Bitmap bitmap, int i3, float f16) {
        if (bitmap != null && bitmap.getWidth() != 0 && bitmap.getHeight() != 0 && !bitmap.isRecycled()) {
            Bitmap.CompressFormat ensureCompressFormat = ensureCompressFormat(i3);
            int ensureQuality = ensureQuality(f16);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            boolean compress = bitmap.compress(ensureCompressFormat, ensureQuality, byteArrayOutputStream);
            try {
                byteArrayOutputStream.close();
            } catch (IOException e16) {
                com.tencent.luggage.wxa.h.b.b(TAG, "encodeToBuffer IOException e %s", e16.toString());
                compress = false;
            }
            if (compress && byteArrayOutputStream.size() > 0) {
                return byteArrayOutputStream.toByteArray();
            }
            com.tencent.luggage.wxa.h.b.b(TAG, "encodeToBuffer Bitmap compress error.", new Object[0]);
        }
        return null;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void forceSetUseType(BitmapType bitmapType) {
        this.mDecodeSlave.forceSetUseType(bitmapType);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public Bitmap getBitmap(int i3, int i16) {
        return com.tencent.luggage.wxa.d.d.a().a(i3, i16);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void loadBitmapAsync(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        loadBitmapAsync(str, new ImageDecodeConfig());
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public IBitmap loadBitmapSync(Object obj, ImageDecodeConfig imageDecodeConfig) {
        com.tencent.luggage.wxa.i.d dVar;
        if (imageDecodeConfig == null) {
            imageDecodeConfig = new ImageDecodeConfig();
        }
        Iterator<com.tencent.luggage.wxa.i.d> it = this.mImageStreamFetcherList.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            dVar = it.next();
            if (dVar.accept(obj)) {
                break;
            }
        }
        if (dVar == null) {
            dVar = this.mFallbackImageStreamFetcher;
        }
        if (dVar == null) {
            com.tencent.luggage.wxa.h.b.b(TAG, "No fit image stream fetcher found for %s", obj.toString());
            return null;
        }
        IImageDecodeService.a aVar = this.mDecodeSlave;
        if (aVar != null && !aVar.a()) {
            return aVar.a(obj.toString(), obj, dVar, imageDecodeConfig);
        }
        com.tencent.luggage.wxa.h.b.d(TAG, "BitmapDecodeSlave destroyed", new Object[0]);
        return null;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void release() {
        IImageDecodeService.a aVar = this.mDecodeSlave;
        if (aVar != null) {
            aVar.destroy();
            this.mDecodeSlave = null;
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void releaseBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        com.tencent.luggage.wxa.h.b.c(TAG, "recycle because releaseBitmap", new Object[0]);
        bitmap.recycle();
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void removeDecodeEventListener(@NonNull IImageDecodeService.b bVar) {
        this.mDecodeEventListeners.remove(bVar);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void removeImageStreamFetcher(@NonNull com.tencent.luggage.wxa.i.d dVar, boolean z16) {
        com.tencent.luggage.wxa.h.b.c(TAG, "hy: %d removing stream fetcher: %s %b", Integer.valueOf(hashCode()), dVar.getClass().getSimpleName(), Boolean.valueOf(z16));
        if (!z16) {
            this.mImageStreamFetcherList.remove(dVar);
        } else {
            this.mFallbackImageStreamFetcher = null;
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setBitmapDecodeSlave(@NonNull IImageDecodeService.a aVar) {
        this.mDecodeSlave = aVar;
        aVar.a(this.mCompactDecodeEventListener);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setMaxDecodeDimension(int i3, int i16) {
        this.mDecodeSlave.a(i3, i16);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setNetworkTimeout(int i3, int i16) {
        this.mHttpImageStreamFetcher.a(i3, i16);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements IImageDecodeService.b {
        public b() {
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public void a(String str, IImageDecodeService.b.a aVar, com.tencent.luggage.wxa.e.a aVar2) {
            Iterator it = new LinkedList(BaseImageDecodeService.this.mDecodeEventListeners).iterator();
            while (it.hasNext()) {
                ((IImageDecodeService.b) it.next()).a(str, aVar, aVar2);
            }
        }

        @Override // com.github.henryye.nativeiv.api.IImageDecodeService.b
        public void a(String str, Object obj, IImageDecodeService.c cVar, ImageDecodeConfig imageDecodeConfig) {
            Iterator it = new LinkedList(BaseImageDecodeService.this.mDecodeEventListeners).iterator();
            while (it.hasNext()) {
                ((IImageDecodeService.b) it.next()).a(str, obj, cVar, imageDecodeConfig);
            }
        }
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void loadBitmapAsync(String str, ImageDecodeConfig imageDecodeConfig) {
        loadBitmapAsync((Object) str, imageDecodeConfig);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void loadBitmapAsync(Object obj, ImageDecodeConfig imageDecodeConfig) {
        if (imageDecodeConfig == null) {
            imageDecodeConfig = new ImageDecodeConfig();
        }
        runInThreadPool(obj, new d(this, obj, imageDecodeConfig));
    }

    private Bitmap.CompressFormat ensureCompressFormat(int i3) {
        if (i3 == 1) {
            return Bitmap.CompressFormat.WEBP;
        }
        if (i3 != 2) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public IBitmap loadBitmapSync(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return loadBitmapSync(str, new ImageDecodeConfig());
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public IBitmap loadBitmapSync(String str, ImageDecodeConfig imageDecodeConfig) {
        return loadBitmapSync((Object) str, imageDecodeConfig);
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void init() {
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setIdKeyReportDelegate(com.tencent.luggage.wxa.h.c cVar) {
    }

    @Override // com.github.henryye.nativeiv.api.IImageDecodeService
    public void setKvReportDelegate(com.tencent.luggage.wxa.h.d dVar) {
    }
}
