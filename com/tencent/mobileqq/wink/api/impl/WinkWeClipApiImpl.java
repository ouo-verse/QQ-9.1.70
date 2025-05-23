package com.tencent.mobileqq.wink.api.impl;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IWinkWeClipApi;
import com.tencent.mobileqq.wink.api.impl.WinkWeClipApiImpl;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.newalbum.forward.WinkNewAlbumForwardProcessor;
import com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResFetchResult;
import com.tencent.mobileqq.wink.newalbum.resmanager.WinkNewAlbumResManager;
import com.tencent.mobileqq.wink.newalbum.scale.WinkNewAlbumPhotoScaleProcessor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J1\u0010\u0010\u001a\u00020\u00042\u0018\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u00172\u0006\u0010\u0003\u001a\u00020\u001cH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0019H\u0016R\u0018\u0010\"\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/wink/api/impl/WinkWeClipApiImpl;", "Lcom/tencent/mobileqq/wink/api/IWinkWeClipApi;", "Li83/c;", "listener", "", "mediaScan", "stopScan", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "resDownLoadListener", "preDownloadWeClipModel", "Li83/i;", "preloadListener", "preloadWeClipModel", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", s4.c.PICS, "doClipForward", "releaseClip", "", "feature1", "feature2", "", "getSimilarityFromClipFeature", "", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "bitmaps", "Li83/h;", "([Lkotlin/Pair;Li83/h;)V", "photoId", "loadImageFeature", "removeImageFeature", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "mProcessor", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "mClipProcessor", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkWeClipApiImpl implements IWinkWeClipApi {

    @NotNull
    public static final String TAG = "WinkWeClipApiImpl";

    @Nullable
    private com.tencent.mobileqq.wink.newalbum.processor.a mClipProcessor;

    @Nullable
    private com.tencent.mobileqq.wink.newalbum.processor.a mProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkWeClipApiImpl$b", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/a;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/WinkNewAlbumResFetchResult;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements com.tencent.mobileqq.wink.newalbum.resmanager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference<i83.h> f317990a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Pair<String, Bitmap>[] f317991b;

        b(WeakReference<i83.h> weakReference, Pair<String, Bitmap>[] pairArr) {
            this.f317990a = weakReference;
            this.f317991b = pairArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(Pair[] bitmaps, com.tencent.mobileqq.wink.newalbum.forward.b winkNewAlbumForwardManager, WeakReference listenerWrf) {
            Unit unit;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(bitmaps, "$bitmaps");
            Intrinsics.checkNotNullParameter(winkNewAlbumForwardManager, "$winkNewAlbumForwardManager");
            Intrinsics.checkNotNullParameter(listenerWrf, "$listenerWrf");
            ArrayList arrayList = new ArrayList(bitmaps.length);
            int i3 = 0;
            for (Pair pair : bitmaps) {
                arrayList.add(winkNewAlbumForwardManager.i((Bitmap) pair.getSecond()));
            }
            QLog.d(WinkWeClipApiImpl.TAG, 1, "[modelForward] success. ");
            i83.h hVar = (i83.h) listenerWrf.get();
            if (hVar != null) {
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                for (Object obj : arrayList) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    arrayList2.add(new Pair<>(bitmaps[i3].getFirst(), (float[]) obj));
                    i3 = i16;
                }
                hVar.onSuccess(arrayList2);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                QLog.d(WinkWeClipApiImpl.TAG, 1, "[modelForward] listener is null. ");
            }
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.a
        public void a(@NonNull @NotNull WinkNewAlbumResFetchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            boolean c16 = com.tencent.mobileqq.wink.newalbum.forward.f.b().c(result);
            QLog.d(WinkWeClipApiImpl.TAG, 1, "[onResReady] load complete");
            if (!c16) {
                QLog.d(WinkWeClipApiImpl.TAG, 1, "[onResReady] load so fail");
                i83.h hVar = this.f317990a.get();
                if (hVar != null) {
                    hVar.onFail();
                    return;
                }
                return;
            }
            final com.tencent.mobileqq.wink.newalbum.forward.b bVar = new com.tencent.mobileqq.wink.newalbum.forward.b();
            QLog.d(WinkWeClipApiImpl.TAG, 1, "[onResReady] loadModelResult: " + bVar.g(result));
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final Pair<String, Bitmap>[] pairArr = this.f317991b;
            final WeakReference<i83.h> weakReference = this.f317990a;
            rFWThreadManager.execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.wink.api.impl.l
                @Override // java.lang.Runnable
                public final void run() {
                    WinkWeClipApiImpl.b.c(pairArr, bVar, weakReference);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkWeClipApiImpl$c", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/a;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/WinkNewAlbumResFetchResult;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements com.tencent.mobileqq.wink.newalbum.resmanager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ResDownLoadListener f317992a;

        c(ResDownLoadListener resDownLoadListener) {
            this.f317992a = resDownLoadListener;
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.a
        public void a(@NotNull WinkNewAlbumResFetchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(WinkWeClipApiImpl.TAG, 1, "onResReady, download complete!");
            this.f317992a.onDownloadFinish(true);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/api/impl/WinkWeClipApiImpl$d", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/a;", "Lcom/tencent/mobileqq/wink/newalbum/resmanager/WinkNewAlbumResFetchResult;", "result", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements com.tencent.mobileqq.wink.newalbum.resmanager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i83.i f317993a;

        d(i83.i iVar) {
            this.f317993a = iVar;
        }

        @Override // com.tencent.mobileqq.wink.newalbum.resmanager.a
        public void a(@NotNull WinkNewAlbumResFetchResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i(WinkWeClipApiImpl.TAG, 1, "onResReady, download complete!");
            if (com.tencent.mobileqq.wink.newalbum.forward.f.b().c(result)) {
                QLog.i(WinkWeClipApiImpl.TAG, 1, "preloadWeClipModel, success!");
                i83.i iVar = this.f317993a;
                if (iVar != null) {
                    iVar.onSuccess();
                    return;
                }
                return;
            }
            QLog.i(WinkWeClipApiImpl.TAG, 1, "preloadWeClipModel, fail!");
            i83.i iVar2 = this.f317993a;
            if (iVar2 != null) {
                iVar2.onFail();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void doClipForward(@NotNull List<? extends LocalMediaInfo> pics, @NotNull i83.c listener) {
        Intrinsics.checkNotNullParameter(pics, "pics");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mClipProcessor != null) {
            QLog.i(TAG, 1, "media forward processing...");
            listener.onError("media forward processing...");
            return;
        }
        String str = "WinkWeClip_" + System.nanoTime();
        com.tencent.mobileqq.wink.newalbum.processor.a winkNewAlbumForwardProcessor = new WinkNewAlbumForwardProcessor(new a93.a(listener), str);
        if (!w83.b.f445025a.G()) {
            winkNewAlbumForwardProcessor = new WinkNewAlbumPhotoScaleProcessor(winkNewAlbumForwardProcessor, str);
        }
        com.tencent.mobileqq.wink.newalbum.forward.c cVar = new com.tencent.mobileqq.wink.newalbum.forward.c(winkNewAlbumForwardProcessor, str);
        cVar.k(pics);
        cVar.start();
        QLog.d(TAG, 1, "media forward start, traceId: " + str);
        this.mClipProcessor = cVar;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public float getSimilarityFromClipFeature(@NotNull float[] feature1, @NotNull float[] feature2) {
        Intrinsics.checkNotNullParameter(feature1, "feature1");
        Intrinsics.checkNotNullParameter(feature2, "feature2");
        return com.tencent.mobileqq.wink.newalbum.collector.m.f324110a.e(feature1, feature2);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    @Nullable
    public float[] loadImageFeature(@NotNull String photoId) {
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        return WinkNewAlbumDatabaseImp.M(photoId);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void mediaScan(@NotNull i83.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (this.mProcessor != null) {
            QLog.d(TAG, 1, "media scan processing...");
            return;
        }
        String str = "WinkWeClip_" + System.nanoTime();
        com.tencent.mobileqq.wink.newalbum.processor.a winkNewAlbumForwardProcessor = new WinkNewAlbumForwardProcessor(new a93.a(listener), str);
        if (!w83.b.f445025a.G()) {
            winkNewAlbumForwardProcessor = new WinkNewAlbumPhotoScaleProcessor(winkNewAlbumForwardProcessor, str);
        }
        WinkNewAlbumMediaScanProcessor winkNewAlbumMediaScanProcessor = new WinkNewAlbumMediaScanProcessor(winkNewAlbumForwardProcessor, str);
        winkNewAlbumMediaScanProcessor.start();
        QLog.d(TAG, 1, "media scan start, traceId: " + str);
        this.mProcessor = winkNewAlbumMediaScanProcessor;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void preDownloadWeClipModel(@NotNull ResDownLoadListener resDownLoadListener) {
        Intrinsics.checkNotNullParameter(resDownLoadListener, "resDownLoadListener");
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).preLoadWinkInferenceRes();
        WinkNewAlbumResManager.f324315d.c(new c(resDownLoadListener));
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void preloadWeClipModel(@NotNull i83.i preloadListener) {
        Intrinsics.checkNotNullParameter(preloadListener, "preloadListener");
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).preLoadWinkInferenceRes();
        WinkNewAlbumResManager.f324315d.c(new d(preloadListener));
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void releaseClip() {
        QLog.i(TAG, 1, "cancelClipForward");
        com.tencent.mobileqq.wink.newalbum.processor.a aVar = this.mClipProcessor;
        if (aVar != null) {
            aVar.stop();
        }
        this.mClipProcessor = null;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void removeImageFeature(@NotNull String photoId) {
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        WinkNewAlbumDatabaseImp.R(photoId);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void stopScan() {
        com.tencent.mobileqq.wink.newalbum.processor.a aVar = this.mProcessor;
        if (aVar != null) {
            aVar.stop();
        }
        this.mProcessor = null;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkWeClipApi
    public void doClipForward(@NotNull Pair<String, Bitmap>[] bitmaps, @NotNull i83.h listener) {
        Intrinsics.checkNotNullParameter(bitmaps, "bitmaps");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (bitmaps.length == 0) {
            return;
        }
        WinkNewAlbumResManager.f324315d.c(new b(new WeakReference(listener), bitmaps));
    }
}
