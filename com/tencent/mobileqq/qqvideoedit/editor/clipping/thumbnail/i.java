package com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001$\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0019BC\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u0012\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020F0D\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010J\u001a\u00020F\u0012\u0006\u0010K\u001a\u00020F\u00a2\u0006\u0004\bL\u0010MJ\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0016R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010/R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00101R&\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000104038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u00105R\u0014\u00109\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010?R\u0014\u0010B\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b;\u0010AR\u0011\u0010C\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u001c\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/i;", "", "", "nearbyTime", "tag", "Landroid/graphics/Bitmap;", "g", "timeMs", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "timeUs", "duration", "i", MimeHelper.IMAGE_SUBTYPE_BITMAP, DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "videoThumbListener", "o", "f", "k", "time", "l", "", "d", "", "a", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", "groupId", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;", "getResourceModel", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;", "resourceModel", "com/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/i$b", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/i$b;", "defaultVideoThumbListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "userVideoThumbListener", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/b;", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/b;", "cacheHelper", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/h;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/h;", "cache", "Landroid/graphics/Bitmap;", "defaultBitmap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "tagTable", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "refCount", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/e;", "j", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/e;", "generatorHelper", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/j;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/j;", "generator", "()J", "sourceTimeDuration", "assetPath", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/f;", "", "lruCache", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;", "handler", "coverWidth", "coverHeight", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/g;Landroid/util/LruCache;Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/c;II)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String groupId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThumbAssetModel resourceModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b defaultVideoThumbListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d userVideoThumbListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.b cacheHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final h cache;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap defaultBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> tagTable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger refCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e generatorHelper;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final j generator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/i$b", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/thumbnail/d;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements d {
        b() {
        }

        @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.thumbnail.d
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            if (bitmap != null) {
                i.this.cacheHelper.b(startTimeMs, bitmap);
            }
            String valueOf = String.valueOf(startTimeMs);
            List list = (List) i.this.tagTable.get(valueOf);
            if (list != null) {
                i iVar = i.this;
                iVar.tagTable.remove(valueOf);
                d dVar = iVar.userVideoThumbListener;
                if (dVar != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        dVar.a(it.next(), startTimeMs, bitmap);
                    }
                }
            }
        }
    }

    public i(@NotNull String groupId, @NotNull ThumbAssetModel resourceModel, @NotNull LruCache<LRUKey, Integer> lruCache, @NotNull c handler, int i3, int i16) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(resourceModel, "resourceModel");
        Intrinsics.checkNotNullParameter(lruCache, "lruCache");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.groupId = groupId;
        this.resourceModel = resourceModel;
        b bVar = new b();
        this.defaultVideoThumbListener = bVar;
        this.tagTable = new ConcurrentHashMap<>();
        this.refCount = new AtomicInteger(0);
        h hVar = new h(resourceModel.getAssetPath(), lruCache);
        this.cacheHelper = new l(hVar);
        this.cache = hVar;
        j jVar = new j(bVar, i16, i3, handler);
        this.generator = jVar;
        this.generatorHelper = new ThumbnailGeneratorHelper(jVar, resourceModel);
    }

    private final Bitmap g(long nearbyTime, Object tag) {
        Bitmap bitmap;
        BitmapPoint c16 = this.cacheHelper.c(nearbyTime);
        if (c16 != null) {
            bitmap = c16.getBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            m(tag, nearbyTime);
            return this.defaultBitmap;
        }
        if (c16.getTime() != nearbyTime) {
            m(tag, nearbyTime);
        }
        return c16.getBitmap();
    }

    private final long i(long timeUs, long duration) {
        long j3 = 1000000;
        long j16 = timeUs / j3;
        if (timeUs % j3 >= 500000) {
            j16++;
        }
        long j17 = j16 * j3;
        if (j17 < 0) {
            j17 = 0;
        }
        if (j17 > duration) {
            return duration - 100000;
        }
        return j17;
    }

    private final long j() {
        return this.resourceModel.getSourceTimeDurationUs();
    }

    private final void m(Object tag, long timeMs) {
        String valueOf = String.valueOf(timeMs);
        CopyOnWriteArrayList<Object> copyOnWriteArrayList = this.tagTable.get(valueOf);
        if (copyOnWriteArrayList != null) {
            if (!copyOnWriteArrayList.contains(tag)) {
                copyOnWriteArrayList.add(tag);
                return;
            }
            return;
        }
        CopyOnWriteArrayList<Object> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList2.add(tag);
        this.tagTable.put(valueOf, copyOnWriteArrayList2);
        Logger.f275870a.f("VideoThumbAssetProvider", "sendGenerateRequest time:" + timeMs + ",Object:" + tag);
        this.generatorHelper.a(timeMs);
    }

    public final boolean d() {
        if (this.refCount.get() <= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String e() {
        return this.resourceModel.getAssetPath();
    }

    @Nullable
    public final Bitmap f(long timeUs, @Nullable Object tag) {
        if (this.resourceModel.getType() == 1) {
            return g(0L, tag);
        }
        return g(i(timeUs, j()), tag);
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final void k() {
        Logger.f275870a.f("VideoThumbAssetProvider", "release:" + this.resourceModel.getAssetPath());
        this.generatorHelper.release();
        this.cacheHelper.release();
    }

    public final void l(long time) {
        this.cacheHelper.a(time);
    }

    public final void n(@Nullable Bitmap bitmap) {
        this.defaultBitmap = bitmap;
    }

    public final void o(@Nullable d videoThumbListener) {
        this.userVideoThumbListener = videoThumbListener;
    }
}
