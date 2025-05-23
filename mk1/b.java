package mk1;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000eR \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u0012\u0010\u001e\u00a8\u0006\""}, d2 = {"Lmk1/b;", "", "", "key", "Lmk1/d;", "b", "", "d", "Lmk1/c;", "a", "c", "", "Ljava/lang/String;", "TAG", "Ljava/lang/Object;", "recyclePooLock", "optionCacheLock", "Ljava/util/concurrent/ConcurrentHashMap;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "recyclePoolMap", "f", "optionCacheMap", "Lkotlin/Pair;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "Landroid/graphics/Bitmap;", "g", "Lkotlin/Pair;", "getFirstImageBitmap", "()Lkotlin/Pair;", "(Lkotlin/Pair;)V", "firstImageBitmap", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f416885a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String TAG = "Guild_Feed_GAL_GuildFeedGalleryCacheHelper";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object recyclePooLock = new Object();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object optionCacheLock = new Object();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, d> recyclePoolMap = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, c> optionCacheMap = new ConcurrentHashMap<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static volatile Pair<GProStImage, Bitmap> firstImageBitmap;

    b() {
    }

    @NotNull
    public final c a(int key) {
        c cVar;
        synchronized (optionCacheLock) {
            ConcurrentHashMap<Integer, c> concurrentHashMap = optionCacheMap;
            if (concurrentHashMap.containsKey(Integer.valueOf(key))) {
                c cVar2 = concurrentHashMap.get(Integer.valueOf(key));
                Intrinsics.checkNotNull(cVar2);
                Intrinsics.checkNotNullExpressionValue(cVar2, "{\n                option\u2026eMap[key]!!\n            }");
                cVar = cVar2;
            } else {
                c cVar3 = new c();
                concurrentHashMap.put(Integer.valueOf(key), cVar3);
                QLog.i(TAG, 1, "getOptionCache key:" + key + " init");
                cVar = cVar3;
            }
        }
        return cVar;
    }

    @NotNull
    public final d b(int key) {
        d dVar;
        synchronized (recyclePooLock) {
            ConcurrentHashMap<Integer, d> concurrentHashMap = recyclePoolMap;
            if (concurrentHashMap.containsKey(Integer.valueOf(key))) {
                d dVar2 = concurrentHashMap.get(Integer.valueOf(key));
                Intrinsics.checkNotNull(dVar2);
                Intrinsics.checkNotNullExpressionValue(dVar2, "{\n                recycl\u2026lMap[key]!!\n            }");
                dVar = dVar2;
            } else {
                d dVar3 = new d();
                concurrentHashMap.put(Integer.valueOf(key), dVar3);
                QLog.i(TAG, 1, "getRecyclePool key:" + key + " init");
                dVar = dVar3;
            }
        }
        return dVar;
    }

    public final void c(int key) {
        synchronized (optionCacheLock) {
            ConcurrentHashMap<Integer, c> concurrentHashMap = optionCacheMap;
            if (concurrentHashMap.containsKey(Integer.valueOf(key))) {
                c cVar = concurrentHashMap.get(Integer.valueOf(key));
                Intrinsics.checkNotNull(cVar);
                cVar.b();
            }
            concurrentHashMap.remove(Integer.valueOf(key));
            QLog.i(TAG, 1, "removeOptionCache key:" + key + " remain_size: " + concurrentHashMap.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void d(int key) {
        synchronized (recyclePooLock) {
            ConcurrentHashMap<Integer, d> concurrentHashMap = recyclePoolMap;
            concurrentHashMap.remove(Integer.valueOf(key));
            QLog.i(TAG, 1, "removeRecyclePool key:" + key + " remain_size: " + concurrentHashMap.size());
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void e(@Nullable Pair<GProStImage, Bitmap> pair) {
        firstImageBitmap = pair;
    }
}
