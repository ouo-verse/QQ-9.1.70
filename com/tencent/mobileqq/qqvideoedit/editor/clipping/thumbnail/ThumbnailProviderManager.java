package com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.util.LruCache;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0085\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00011\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001DB\t\b\u0002\u00a2\u0006\u0004\bB\u0010CJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J4\u0010\f\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J,\u0010\u0013\u001a\u00020\u00072\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u001c\u0010\u0018\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J$\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u000e\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u001cJ\b\u0010$\u001a\u0004\u0018\u00010\u001cR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010+R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u001e0.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00102R&\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010>\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010<\u001a\u0004\b8\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010@\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager;", "", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;", "assetModelList", "", "groupId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/i;", "findCallback", "d", "resourceModel", "assetPath", "e", "", "sourceList", "exceptList", "k", "", "dpValue", "", "f", "l", "", "timeMs", "tag", "Landroid/graphics/Bitmap;", "g", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "listener", "j", "o", MimeHelper.IMAGE_SUBTYPE_BITMAP, DomainData.DOMAIN_NAME, tl.h.F, "b", "Ljava/util/List;", "videoThumbAssetProviders", "c", "Landroid/graphics/Bitmap;", "defaultBitmap", "I", "width", "height", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "videoThumbListeners", "com/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$c;", "subVideoThumbListener", "", "Ljava/util/Map;", "groupAssetIdMapping", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$a;", "i", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$a;", "lruCache", "Landroid/os/Handler;", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "generateHandler", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "runnableHandler", "<init>", "()V", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ThumbnailProviderManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ThumbnailProviderManager f275307a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<i> videoThumbAssetProviders;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Bitmap defaultBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<d> videoThumbListeners;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final c subVideoThumbListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, List<String>> groupAssetIdMapping;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a lruCache;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy generateHandler;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.c runnableHandler;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0014J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$a;", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/f;", "", "key", "value", "b", "", "evicted", "oldValue", "newValue", "", "a", "(ZLcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/f;ILjava/lang/Integer;)V", "maxSize", "<init>", "(I)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends LruCache<LRUKey, Integer> {
        public a(int i3) {
            super(i3);
        }

        protected void a(boolean evicted, @NotNull LRUKey key, int oldValue, @Nullable Integer newValue) {
            Object obj;
            Intrinsics.checkNotNullParameter(key, "key");
            super.entryRemoved(evicted, key, Integer.valueOf(oldValue), newValue);
            if (!evicted) {
                return;
            }
            Iterator it = ThumbnailProviderManager.videoThumbAssetProviders.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(key.getAssetPath(), ((i) obj).e())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            i iVar = (i) obj;
            if (iVar != null) {
                iVar.l(key.getTime());
            }
        }

        protected int b(@NotNull LRUKey key, int value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return value / 1024;
        }

        @Override // android.util.LruCache
        public /* bridge */ /* synthetic */ void entryRemoved(boolean z16, LRUKey lRUKey, Integer num, Integer num2) {
            a(z16, lRUKey, num.intValue(), num2);
        }

        @Override // android.util.LruCache
        public /* bridge */ /* synthetic */ int sizeOf(LRUKey lRUKey, Integer num) {
            return b(lRUKey, num.intValue());
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "Ljava/lang/Runnable;", "runnable", "", "postRunnable", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.c {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.c
        public void postRunnable(@Nullable Runnable runnable) {
            if (runnable != null) {
                ThumbnailProviderManager.f275307a.i().postAtFrontOfQueue(runnable);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/ThumbnailProviderManager$c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements d {
        c() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.d
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            Iterator it = ThumbnailProviderManager.videoThumbListeners.iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(tag, startTimeMs, bitmap);
            }
        }
    }

    static {
        Lazy lazy;
        ThumbnailProviderManager thumbnailProviderManager = new ThumbnailProviderManager();
        f275307a = thumbnailProviderManager;
        videoThumbAssetProviders = new ArrayList();
        videoThumbListeners = new CopyOnWriteArrayList<>();
        subVideoThumbListener = new c();
        groupAssetIdMapping = new LinkedHashMap();
        lruCache = new a(10240);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.ThumbnailProviderManager$generateHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VideoThumbProviderManager", 0);
                baseHandlerThread.start();
                return new Handler(baseHandlerThread.getLooper());
            }
        });
        generateHandler = lazy;
        runnableHandler = new b();
        width = thumbnailProviderManager.f(56.0f);
        int f16 = thumbnailProviderManager.f(56.0f);
        height = f16;
        Bitmap bitmap = Bitmap.createBitmap(width, f16, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#4dffffff"));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        thumbnailProviderManager.n(bitmap);
    }

    ThumbnailProviderManager() {
    }

    private final void d(List<ThumbAssetModel> assetModelList, String groupId, Function1<? super i, Unit> findCallback) {
        Object obj;
        for (ThumbAssetModel thumbAssetModel : assetModelList) {
            String assetPath = thumbAssetModel.getAssetPath();
            Iterator<T> it = videoThumbAssetProviders.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(assetPath, ((i) obj).e())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            i iVar = (i) obj;
            if (iVar == null) {
                videoThumbAssetProviders.add(f275307a.e(groupId, thumbAssetModel, assetPath));
            } else {
                Logger.f275870a.f("VideoThumbProviderManager", "resetProvider find:" + assetPath);
                if (findCallback != null) {
                    findCallback.invoke(iVar);
                }
            }
        }
    }

    private final i e(String groupId, ThumbAssetModel resourceModel, String assetPath) {
        Logger.f275870a.f("VideoThumbProviderManager", "resetProvider can't find:" + assetPath);
        i iVar = new i(groupId, resourceModel, lruCache, runnableHandler, width, height);
        iVar.o(subVideoThumbListener);
        iVar.n(defaultBitmap);
        return iVar;
    }

    private final int f(float dpValue) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(dpValue * Resources.getSystem().getDisplayMetrics().density);
        return roundToInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler i() {
        return (Handler) generateHandler.getValue();
    }

    private final void k(List<i> sourceList, String groupId, List<String> exceptList) {
        boolean z16;
        ArrayList<i> arrayList = new ArrayList();
        for (Object obj : sourceList) {
            i iVar = (i) obj;
            if (Intrinsics.areEqual(iVar.getGroupId(), groupId) && !exceptList.contains(iVar.e())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        for (i iVar2 : arrayList) {
            if (iVar2.d()) {
                Logger.f275870a.f("VideoThumbProviderManager", "release provider:" + iVar2.e());
                sourceList.remove(iVar2);
                iVar2.k();
            } else {
                Logger.f275870a.f("VideoThumbProviderManager", "can't release provider:" + iVar2.e());
            }
        }
    }

    private final void m(List<ThumbAssetModel> assetModelList, String groupId) {
        int collectionSizeOrDefault;
        Logger.f275870a.f("VideoThumbProviderManager", "resetProvider start");
        d(assetModelList, groupId, null);
        List<ThumbAssetModel> list = assetModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ThumbAssetModel) it.next()).getAssetPath());
        }
        k(videoThumbAssetProviders, groupId, arrayList);
        Map<String, List<String>> map = groupAssetIdMapping;
        map.remove(groupId);
        map.put(groupId, arrayList);
    }

    @Nullable
    public final Bitmap g(long timeMs, @Nullable Object tag, @Nullable String assetPath) {
        Object obj;
        if (height == 0 && width == 0) {
            return defaultBitmap;
        }
        List<i> list = videoThumbAssetProviders;
        if (list.isEmpty()) {
            return defaultBitmap;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(assetPath, ((i) obj).e())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        i iVar = (i) obj;
        if (iVar == null) {
            return defaultBitmap;
        }
        return iVar.f(timeMs, tag);
    }

    @Nullable
    public final Bitmap h() {
        return defaultBitmap;
    }

    public final void j(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<d> copyOnWriteArrayList = videoThumbListeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
            Logger.f275870a.f("VideoThumbProviderManager", "registerListener addSuccess");
        }
    }

    public final void l(@NotNull List<ThumbAssetModel> assetModelList, @NotNull String groupId) {
        Intrinsics.checkNotNullParameter(assetModelList, "assetModelList");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (width != 0 && height != 0) {
            m(assetModelList, groupId);
        }
    }

    public final void n(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        defaultBitmap = bitmap;
        Iterator<T> it = videoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            ((i) it.next()).n(bitmap);
        }
    }

    public final void o(@NotNull d listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        boolean remove = videoThumbListeners.remove(listener);
        Logger.f275870a.f("VideoThumbProviderManager", "unRegisterListener removeSuccess:" + remove);
    }
}
