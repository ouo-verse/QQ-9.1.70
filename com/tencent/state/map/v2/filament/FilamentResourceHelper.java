package com.tencent.state.map.v2.filament;

import com.tencent.component.network.module.base.QDLog;
import com.tencent.filament.zplan.scene.square.SquareImageData;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.cache.DiskLruCache;
import com.tencent.state.square.download.SquareDownloader;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/state/map/v2/filament/FilamentResourceHelper;", "", "()V", "DIR_NAME", "", "MAX_CACHE_COUNT", "", "TAG", "cacheDir", "Ljava/io/File;", "getCacheDir", "()Ljava/io/File;", "diskCache", "Lcom/tencent/state/square/cache/DiskLruCache;", QDLog.TAG_DOWNLOAD, "Lcom/tencent/state/square/download/SquareDownloader;", "getCachePath", "url", "forceFileName", "getSuffix", "loadImageParams", "Lcom/tencent/filament/zplan/scene/square/SquareImageData;", "image", "Lcom/tencent/state/map/v2/filament/ImageResource;", "(Lcom/tencent/state/map/v2/filament/ImageResource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startDownloadJob", "Lkotlinx/coroutines/Deferred;", "", "remoteUrl", "savePath", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FilamentResourceHelper {
    private static final String DIR_NAME = "map/filament/resource";
    public static final FilamentResourceHelper INSTANCE;
    private static final int MAX_CACHE_COUNT = 200;
    private static final String TAG = "FilamentResourceHelper";
    private static final DiskLruCache diskCache;
    private static final SquareDownloader downloader;

    static {
        FilamentResourceHelper filamentResourceHelper = new FilamentResourceHelper();
        INSTANCE = filamentResourceHelper;
        DiskLruCache diskLruCache = new DiskLruCache(filamentResourceHelper.getCacheDir(), 200, null, 4, null);
        diskCache = diskLruCache;
        downloader = new SquareDownloader(diskLruCache);
    }

    FilamentResourceHelper() {
    }

    private final File getCacheDir() {
        return new File(SquareBase.INSTANCE.getConfig().getRootCacheDir(), DIR_NAME);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getSuffix(String url) {
        List split$default;
        Object lastOrNull;
        boolean z16;
        boolean isBlank;
        split$default = StringsKt__StringsKt.split$default((CharSequence) url, new String[]{"."}, false, 0, 6, (Object) null);
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
        String str = (String) lastOrNull;
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return "";
                }
                return '.' + str;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final Deferred<Unit> startDownloadJob(String remoteUrl, String savePath) {
        Deferred<Unit> async$default;
        async$default = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new FilamentResourceHelper$startDownloadJob$1(remoteUrl, savePath, null), 3, null);
        return async$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadImageParams(ImageResource imageResource, Continuation<? super SquareImageData> continuation) {
        FilamentResourceHelper$loadImageParams$1 filamentResourceHelper$loadImageParams$1;
        Object coroutine_suspended;
        int i3;
        boolean isBlank;
        String cachePath$default;
        String str;
        if (continuation instanceof FilamentResourceHelper$loadImageParams$1) {
            filamentResourceHelper$loadImageParams$1 = (FilamentResourceHelper$loadImageParams$1) continuation;
            int i16 = filamentResourceHelper$loadImageParams$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                filamentResourceHelper$loadImageParams$1.label = i16 - Integer.MIN_VALUE;
                Object obj = filamentResourceHelper$loadImageParams$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = filamentResourceHelper$loadImageParams$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    String url = imageResource.getUrl();
                    isBlank = StringsKt__StringsJVMKt.isBlank(url);
                    if (isBlank) {
                        return null;
                    }
                    cachePath$default = getCachePath$default(this, url, null, 2, null);
                    if (!new File(cachePath$default).exists()) {
                        Deferred<Unit> startDownloadJob = startDownloadJob(url, cachePath$default);
                        filamentResourceHelper$loadImageParams$1.L$0 = cachePath$default;
                        filamentResourceHelper$loadImageParams$1.label = 1;
                        if (startDownloadJob.await(filamentResourceHelper$loadImageParams$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = cachePath$default;
                    }
                    return new SquareImageData(cachePath$default);
                }
                if (i3 == 1) {
                    str = (String) filamentResourceHelper$loadImageParams$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cachePath$default = str;
                return new SquareImageData(cachePath$default);
            }
        }
        filamentResourceHelper$loadImageParams$1 = new FilamentResourceHelper$loadImageParams$1(this, continuation);
        Object obj2 = filamentResourceHelper$loadImageParams$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = filamentResourceHelper$loadImageParams$1.label;
        if (i3 != 0) {
        }
        cachePath$default = str;
        return new SquareImageData(cachePath$default);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getCachePath(String url, String forceFileName) {
        boolean z16;
        boolean isBlank;
        if (forceFileName != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(forceFileName);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    forceFileName = d.c(url) + getSuffix(url);
                }
                return getCacheDir() + '/' + forceFileName;
            }
        }
        z16 = true;
        if (z16) {
        }
        return getCacheDir() + '/' + forceFileName;
    }

    static /* synthetic */ String getCachePath$default(FilamentResourceHelper filamentResourceHelper, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = null;
        }
        return filamentResourceHelper.getCachePath(str, str2);
    }
}
