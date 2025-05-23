package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.util.LruCache;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.videocut.model.MediaClip;
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
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001B\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001VB\t\b\u0002\u00a2\u0006\u0004\bT\u0010UJ0\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0002JF\u0010\u000e\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0002J2\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0002J6\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0002J,\u0010\u001b\u001a\u00020\t2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00182\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J.\u0010\"\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u0002J\u0006\u0010#\u001a\u00020\tJ\u0006\u0010$\u001a\u00020\tJ\u001c\u0010%\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J.\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010)\u001a\u00020\u0015J\u000e\u0010.\u001a\u00020\t2\u0006\u0010-\u001a\u00020,J\u000e\u0010/\u001a\u00020\t2\u0006\u0010-\u001a\u00020,J\u000e\u00100\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u00101\u001a\u00020\tJ\u000e\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020*J\b\u00104\u001a\u0004\u0018\u00010*R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\f0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010;R\u0016\u0010=\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010;R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020,0>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010CR&\u0010H\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010JR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010M\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010R\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager;", "", "", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "assetModelList", "", "groupId", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "sources", "", "v", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/l;", "findCallback", "e", "assetModel", "assetPath", "i", "resourceModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "templateRenderModel", "", "useCoverProvider", "g", "", "sourceList", "exceptList", "t", "", "dpValue", "", "j", "Lcom/tencent/videocut/model/MediaClip;", "mediaModels", "u", "p", "o", "d", "", "timeMs", "tag", "isAccurate", "Landroid/graphics/Bitmap;", "k", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "listener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "r", ReportConstant.COSTREPORT_PREFIX, MimeHelper.IMAGE_SUBTYPE_BITMAP, "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Ljava/util/List;", "videoThumbAssetProviders", "c", "Landroid/graphics/Bitmap;", "defaultBitmap", "I", "width", "height", "Ljava/util/concurrent/CopyOnWriteArrayList;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "videoThumbListeners", "com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$b", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$b;", "subVideoThumbListener", "", tl.h.F, "Ljava/util/Map;", "groupAssetIdMapping", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$a;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$a;", "lruCache", "Landroid/os/Handler;", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/os/Handler;", "generateHandler", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;", "runnableHandler", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ThumbnailProviderManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ThumbnailProviderManager f319211a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<l> videoThumbAssetProviders;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Bitmap defaultBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int width;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int height;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<e> videoThumbListeners;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b subVideoThumbListener;

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
    private static final d runnableHandler;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0014J1\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$a;", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/g;", "", "key", "value", "b", "", "evicted", "oldValue", "newValue", "", "a", "(ZLcom/tencent/mobileqq/wink/editor/clipping/thumbnail/g;ILjava/lang/Integer;)V", "maxSize", "<init>", "(I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
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
                    if (Intrinsics.areEqual(key.getAssetPath(), ((l) obj).i())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            l lVar = (l) obj;
            if (lVar != null) {
                lVar.s(key.getTime());
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

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/thumbnail/ThumbnailProviderManager$b", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements e {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.e
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            Iterator it = ThumbnailProviderManager.videoThumbListeners.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(tag, startTimeMs, bitmap);
            }
        }
    }

    static {
        Lazy lazy;
        ThumbnailProviderManager thumbnailProviderManager = new ThumbnailProviderManager();
        f319211a = thumbnailProviderManager;
        videoThumbAssetProviders = new ArrayList();
        videoThumbListeners = new CopyOnWriteArrayList<>();
        subVideoThumbListener = new b();
        groupAssetIdMapping = new LinkedHashMap();
        lruCache = new a(30720);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager$generateHandler$2
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
        runnableHandler = new d() { // from class: com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager$runnableHandler$1
            @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.d
            public void postRunnable(@Nullable Runnable runnable) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), null, null, new ThumbnailProviderManager$runnableHandler$1$postRunnable$1(runnable, null), 3, null);
            }
        };
        width = thumbnailProviderManager.j(56.0f);
        int j3 = thumbnailProviderManager.j(56.0f);
        height = j3;
        Bitmap bitmap = Bitmap.createBitmap(width, j3, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#4dffffff"));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        thumbnailProviderManager.w(bitmap);
    }

    ThumbnailProviderManager() {
    }

    private final void e(List<ThumbAssetModel> assetModelList, String groupId, Function1<? super l, Unit> findCallback, List<ClipSource> sources) {
        Object obj;
        for (ThumbAssetModel thumbAssetModel : assetModelList) {
            String assetPath = thumbAssetModel.getAssetPath();
            Iterator<T> it = videoThumbAssetProviders.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(assetPath, ((l) obj).i())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            l lVar = (l) obj;
            if (lVar == null) {
                f319211a.i(thumbAssetModel, groupId, assetPath, sources);
            } else {
                w53.b.f("VideoThumbProviderManager", "resetProvider find:" + assetPath);
                if (findCallback != null) {
                    findCallback.invoke(lVar);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void f(ThumbnailProviderManager thumbnailProviderManager, List list, String str, Function1 function1, List list2, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            list2 = null;
        }
        thumbnailProviderManager.e(list, str, function1, list2);
    }

    private final l g(String groupId, ThumbAssetModel resourceModel, String assetPath, LAKRenderModel templateRenderModel, boolean useCoverProvider) {
        l lVar = new l(groupId, resourceModel, lruCache, runnableHandler, width, height, templateRenderModel, useCoverProvider);
        lVar.w(subVideoThumbListener);
        lVar.v(defaultBitmap);
        return lVar;
    }

    static /* synthetic */ l h(ThumbnailProviderManager thumbnailProviderManager, String str, ThumbAssetModel thumbAssetModel, String str2, LAKRenderModel lAKRenderModel, boolean z16, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            lAKRenderModel = null;
        }
        LAKRenderModel lAKRenderModel2 = lAKRenderModel;
        if ((i3 & 16) != 0) {
            z16 = false;
        }
        return thumbnailProviderManager.g(str, thumbAssetModel, str2, lAKRenderModel2, z16);
    }

    private final void i(ThumbAssetModel assetModel, String groupId, String assetPath, List<ClipSource> sources) {
        Object obj;
        List<ClipSource> mutableListOf;
        if (1 == assetModel.getType()) {
            videoThumbAssetProviders.add(h(this, groupId, assetModel, assetPath, null, false, 24, null));
            return;
        }
        LAKRenderModel lAKRenderModel = null;
        if (sources != null) {
            Iterator<T> it = sources.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(assetPath, ((ClipSource) obj).getPath())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            ClipSource clipSource = (ClipSource) obj;
            if (clipSource != null) {
                rd4.c cVar = rd4.c.f431135f;
                mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(clipSource);
                lAKRenderModel = cVar.y(mutableListOf);
            }
        }
        boolean d16 = q.f319269a.d(assetPath);
        w53.b.f("VideoThumbProviderManager", "isUnSupportFile=" + d16);
        videoThumbAssetProviders.add(g(groupId, assetModel, assetPath, lAKRenderModel, d16));
    }

    private final int j(float dpValue) {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(dpValue * Resources.getSystem().getDisplayMetrics().density);
        return roundToInt;
    }

    public static /* synthetic */ Bitmap l(ThumbnailProviderManager thumbnailProviderManager, long j3, Object obj, String str, boolean z16, int i3, Object obj2) {
        if ((i3 & 8) != 0) {
            z16 = true;
        }
        return thumbnailProviderManager.k(j3, obj, str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler n() {
        return (Handler) generateHandler.getValue();
    }

    private final void t(List<l> sourceList, String groupId, List<String> exceptList) {
        boolean z16;
        ArrayList<l> arrayList = new ArrayList();
        for (Object obj : sourceList) {
            l lVar = (l) obj;
            if (Intrinsics.areEqual(lVar.getGroupId(), groupId) && !exceptList.contains(lVar.i())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        for (l lVar2 : arrayList) {
            if (lVar2.f()) {
                w53.b.f("VideoThumbProviderManager", "release provider:" + lVar2.i());
                sourceList.remove(lVar2);
                lVar2.r();
            } else {
                w53.b.f("VideoThumbProviderManager", "can't release provider:" + lVar2.i());
            }
        }
    }

    private final void v(List<ThumbAssetModel> assetModelList, String groupId, List<ClipSource> sources) {
        int collectionSizeOrDefault;
        e(assetModelList, groupId, null, sources);
        List<ThumbAssetModel> list = assetModelList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((ThumbAssetModel) it.next()).getAssetPath());
        }
        t(videoThumbAssetProviders, groupId, arrayList);
        Map<String, List<String>> map = groupAssetIdMapping;
        map.remove(groupId);
        map.put(groupId, arrayList);
    }

    public final void d(@NotNull List<ThumbAssetModel> assetModelList, @NotNull String groupId) {
        Intrinsics.checkNotNullParameter(assetModelList, "assetModelList");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        f(this, assetModelList, groupId, new Function1<l, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.thumbnail.ThumbnailProviderManager$addProvider$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(l lVar) {
                invoke2(lVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull l it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.q();
            }
        }, null, 8, null);
    }

    @Nullable
    public final Bitmap k(long timeMs, @Nullable Object tag, @Nullable String assetPath, boolean isAccurate) {
        Object obj;
        if (height == 0 && width == 0) {
            return defaultBitmap;
        }
        List<l> list = videoThumbAssetProviders;
        if (list.isEmpty()) {
            return defaultBitmap;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (Intrinsics.areEqual(assetPath, ((l) obj).i())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        l lVar = (l) obj;
        if (lVar == null) {
            return defaultBitmap;
        }
        boolean z16 = false;
        boolean b16 = AECameraPrefsUtil.c().b("SP_USE_COARSE_TIMELINE", false, 0);
        if (isAccurate && !b16) {
            z16 = true;
        }
        return lVar.j(timeMs, tag, z16);
    }

    @Nullable
    public final Bitmap m() {
        return defaultBitmap;
    }

    public final void o() {
        Iterator<T> it = videoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            ((l) it.next()).p();
        }
    }

    public final void p() {
        Iterator<T> it = videoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            ((l) it.next()).q();
        }
    }

    public final void q(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CopyOnWriteArrayList<e> copyOnWriteArrayList = videoThumbListeners;
        if (!copyOnWriteArrayList.contains(listener)) {
            copyOnWriteArrayList.add(listener);
            w53.b.a("VideoThumbProviderManager", "registerListener addSuccess");
        }
    }

    public final void r(@NotNull String groupId) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        List<l> list = videoThumbAssetProviders;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        t(list, groupId, emptyList);
        w53.b.f("VideoThumbProviderManager", "release:" + groupId);
    }

    public final void s() {
        Iterator<T> it = videoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            ((l) it.next()).r();
        }
        videoThumbAssetProviders.clear();
        videoThumbListeners.clear();
    }

    public final void u(@NotNull List<ThumbAssetModel> assetModelList, @NotNull String groupId, @Nullable List<? extends MediaClip> mediaModels) {
        Intrinsics.checkNotNullParameter(assetModelList, "assetModelList");
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        if (width != 0 && height != 0) {
            List<ClipSource> list = null;
            if (mediaModels != null) {
                list = com.tencent.videocut.render.extension.e.B(mediaModels, false, null, 3, null);
            }
            v(assetModelList, groupId, list);
        }
    }

    public final void w(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        defaultBitmap = bitmap;
        Iterator<T> it = videoThumbAssetProviders.iterator();
        while (it.hasNext()) {
            ((l) it.next()).v(bitmap);
        }
    }

    public final void x(@NotNull e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        w53.b.a("VideoThumbProviderManager", "unRegisterListener removeSuccess:" + videoThumbListeners.remove(listener));
    }
}
