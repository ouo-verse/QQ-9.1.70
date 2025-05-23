package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.util.LruCache;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.cover.ICoverProvider;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u00010\u0018\u0000 :2\u00020\u0001:\u0002\u001e\u001aB\u0007\u00a2\u0006\u0004\b8\u00109J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002JD\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\t2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010\u0011J\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\"\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R \u0010#\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\"R\u0016\u0010%\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010$R\u0016\u0010&\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010$R\u0016\u0010)\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010+R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00101R\u001b\u00106\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u00104\u001a\u0004\b-\u00105R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/d;", "", "timeUs", "normalizedTime", "", "tag", "", "i", "", "assetPath", "e", "duration", "g", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "renderModel", "templateDir", "", "Lcom/tencent/tavcut/core/render/rendernode/BaseEffectNode;", "renderNodes", "Lcom/tencent/videocut/model/MediaClip;", "mediaModels", "k", tl.h.F, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "listener", "b", "c", "Landroid/graphics/Bitmap;", "getBitmapByTime", "a", "", "", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "Ljava/util/Map;", "listenerCache", "I", "width", "height", "d", "Landroid/graphics/Bitmap;", "defaultBitmap", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "Lcom/tencent/tavcut/core/render/cover/ICoverProvider;", "thumbProvider", "f", "J", "maxDurationUs", "com/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl$c", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl$c;", "thumbCache", "Landroid/os/Handler;", "Lkotlin/Lazy;", "()Landroid/os/Handler;", "generateHandler", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "<init>", "()V", "j", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class RenderModelThumbnailProviderImpl implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, e> listenerCache = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bitmap defaultBitmap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ICoverProvider thumbProvider;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long maxDurationUs;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c thumbCache;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy generateHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LAKRenderModel renderModel;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl$b;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "getListener", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "listener", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener;

        public b(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.listener = listener;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.e
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            this.listener.a(tag, startTimeMs, bitmap);
        }
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/thumbnail/RenderModelThumbnailProviderImpl$c", "Landroid/util/LruCache;", "", "Landroid/graphics/Bitmap;", "key", "value", "", "b", "(Ljava/lang/Long;Landroid/graphics/Bitmap;)I", "", "evicted", "oldValue", "newValue", "", "a", "(ZLjava/lang/Long;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends LruCache<Long, Bitmap> {
        c() {
            super(30720);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean evicted, @Nullable Long key, @Nullable Bitmap oldValue, @Nullable Bitmap newValue) {
            super.entryRemoved(evicted, key, oldValue, newValue);
            if (evicted && oldValue != null && !oldValue.isRecycled()) {
                oldValue.recycle();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(@Nullable Long key, @Nullable Bitmap value) {
            int i3;
            if (value != null) {
                i3 = value.getAllocationByteCount();
            } else {
                i3 = 0;
            }
            return i3 / 1024;
        }
    }

    public RenderModelThumbnailProviderImpl() {
        Lazy lazy;
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        this.width = eVar.a(56.0f);
        this.height = eVar.a(56.0f);
        this.thumbCache = new c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.wink.editor.clipping.thumbnail.RenderModelThumbnailProviderImpl$generateHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Handler invoke() {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("RenderModelThumbnailProviderImpl", 0);
                baseHandlerThread.start();
                return new Handler(baseHandlerThread.getLooper());
            }
        });
        this.generateHandler = lazy;
        Bitmap bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
        bitmap.eraseColor(Color.parseColor("#4dffffff"));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        this.defaultBitmap = bitmap;
    }

    private final long e(long timeUs, Object tag, String assetPath) {
        List<ClipSource> clipsAssets;
        LAKRenderModel lAKRenderModel = this.renderModel;
        if (lAKRenderModel != null && (clipsAssets = lAKRenderModel.getClipsAssets()) != null) {
            long j3 = 0;
            for (ClipSource clipSource : clipsAssets) {
                if (Intrinsics.areEqual(clipSource.getPath(), assetPath)) {
                    break;
                }
                j3 += clipSource.getDuration();
            }
            return j3 + timeUs;
        }
        return timeUs;
    }

    private final Handler f() {
        return (Handler) this.generateHandler.getValue();
    }

    private final long g(long timeUs, long duration) {
        long j3 = 1000000;
        long j16 = timeUs / j3;
        if (timeUs % j3 >= 500000) {
            j16++;
        }
        long j17 = j16 * j3;
        if (j17 < 0) {
            j17 = 0;
        }
        if (j17 >= duration) {
            return duration - 100000;
        }
        return j17;
    }

    private final void i(final long timeUs, final long normalizedTime, final Object tag) {
        f().postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.thumbnail.h
            @Override // java.lang.Runnable
            public final void run() {
                RenderModelThumbnailProviderImpl.j(RenderModelThumbnailProviderImpl.this, normalizedTime, tag, timeUs);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(RenderModelThumbnailProviderImpl this$0, long j3, Object obj, long j16) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bitmap bitmap2 = this$0.thumbCache.get(Long.valueOf(j3));
        if (bitmap2 != null) {
            Iterator<T> it = this$0.listenerCache.values().iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(obj, j16, bitmap2);
            }
            return;
        }
        ICoverProvider iCoverProvider = this$0.thumbProvider;
        if (iCoverProvider != null) {
            bitmap = iCoverProvider.getCoverAtTime(j3 / 1000);
        } else {
            bitmap = null;
        }
        if (bitmap != null) {
            this$0.thumbCache.put(Long.valueOf(j3), bitmap);
        }
        Iterator<T> it5 = this$0.listenerCache.values().iterator();
        while (it5.hasNext()) {
            ((e) it5.next()).a(obj, j16, bitmap);
        }
    }

    public static /* synthetic */ void l(RenderModelThumbnailProviderImpl renderModelThumbnailProviderImpl, LAKRenderModel lAKRenderModel, long j3, String str, List list, List list2, int i3, Object obj) {
        List list3;
        List list4;
        if ((i3 & 8) != 0) {
            list3 = null;
        } else {
            list3 = list;
        }
        if ((i3 & 16) != 0) {
            list4 = null;
        } else {
            list4 = list2;
        }
        renderModelThumbnailProviderImpl.k(lAKRenderModel, j3, str, list3, list4);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    @NotNull
    /* renamed from: a, reason: from getter */
    public Bitmap getDefaultBitmap() {
        return this.defaultBitmap;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    public void b(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (!this.listenerCache.containsKey(Integer.valueOf(listener.hashCode()))) {
            this.listenerCache.put(Integer.valueOf(listener.hashCode()), new b(listener));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    public void c(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listenerCache.remove(Integer.valueOf(listener.hashCode()));
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d
    @NotNull
    public Bitmap getBitmapByTime(long timeUs, @Nullable Object tag, @NotNull String assetPath) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        long g16 = g(e(timeUs, tag, assetPath), this.maxDurationUs);
        Bitmap bitmap = this.thumbCache.get(Long.valueOf(g16));
        if (bitmap == null) {
            i(timeUs, g16, tag);
        }
        if (bitmap == null) {
            return getDefaultBitmap();
        }
        return bitmap;
    }

    public final void h() {
        if (!this.defaultBitmap.isRecycled()) {
            this.defaultBitmap.recycle();
        }
        ICoverProvider iCoverProvider = this.thumbProvider;
        if (iCoverProvider != null) {
            iCoverProvider.release();
        }
    }

    public final void k(@NotNull LAKRenderModel renderModel, long duration, @NotNull String templateDir, @Nullable List<? extends BaseEffectNode> renderNodes, @Nullable List<? extends MediaClip> mediaModels) {
        Object orNull;
        ResourceModel resourceModel;
        SizeF sizeF;
        Intrinsics.checkNotNullParameter(renderModel, "renderModel");
        Intrinsics.checkNotNullParameter(templateDir, "templateDir");
        f().removeCallbacksAndMessages(null);
        ICoverProvider iCoverProvider = this.thumbProvider;
        if (iCoverProvider != null) {
            iCoverProvider.release();
        }
        this.thumbCache.evictAll();
        if (mediaModels != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(mediaModels, 0);
            MediaClip mediaClip = (MediaClip) orNull;
            if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (sizeF = resourceModel.size) != null) {
                float f16 = sizeF.width;
                float f17 = sizeF.height;
                if (f16 > f17) {
                    this.width = (int) ((f16 / f17) * this.height);
                } else if (f17 > f16) {
                    this.height = (int) ((f17 / f16) * this.width);
                }
            }
        }
        this.thumbProvider = rd4.c.e(rd4.c.f431135f, renderModel, new Size(this.width, this.height), templateDir, renderNodes, null, 16, null);
        this.renderModel = renderModel;
        this.maxDurationUs = duration;
    }
}
