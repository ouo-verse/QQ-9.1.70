package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.graphics.Bitmap;
import android.util.LruCache;
import androidx.annotation.WorkerThread;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a1\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00014\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001!BY\u0012\u0006\u0010%\u001a\u00020 \u0012\u0006\u0010+\u001a\u00020&\u0012\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X0V\u0012\u0006\u0010[\u001a\u00020Z\u0012\u0006\u0010\\\u001a\u00020X\u0012\u0006\u0010]\u001a\u00020X\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010^\u001a\u00020\u0018\u00a2\u0006\u0004\b_\u0010`J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0003J\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J$\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0018R\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010>R&\u0010C\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010A0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010BR$\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u00060Dj\b\u0012\u0004\u0012\u00020\u0006`E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010PR\u0014\u0010T\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010SR\u0011\u0010U\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\bF\u0010$\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/l;", "", "", "g", "u", "", "", "l", "nearbyTime", "tag", "Landroid/graphics/Bitmap;", "k", "time", tl.h.F, "timeMs", "t", "timeUs", "duration", DomainData.DOMAIN_NAME, MimeHelper.IMAGE_SUBTYPE_BITMAP, "v", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "videoThumbListener", "w", "", "isAccurate", "j", "r", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "f", "", "a", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/lang/String;", "groupId", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "b", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "getResourceModel", "()Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;", "resourceModel", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "c", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "getLakRenderModel", "()Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "setLakRenderModel", "(Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;)V", "lakRenderModel", "com/tencent/mobileqq/wink/editor/clipping/thumbnail/l$b", "d", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/l$b;", "defaultVideoThumbListener", "e", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "userVideoThumbListener", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/c;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/c;", "cacheHelper", "Landroid/graphics/Bitmap;", "defaultBitmap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "tagTable", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "keyFrameList", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "refCount", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/f;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/f;", "generatorHelper", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/m;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/m;", "generator", "o", "()J", "sourceTimeDuration", "assetPath", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/g;", "", "lruCache", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;", "handler", "coverWidth", "coverHeight", "useCoverProvider", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/i;Landroid/util/LruCache;Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/d;IILcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String groupId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ThumbAssetModel resourceModel;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LAKRenderModel lakRenderModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b defaultVideoThumbListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e userVideoThumbListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c cacheHelper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap defaultBitmap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<Object>> tagTable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<Long> keyFrameList;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicInteger refCount;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f generatorHelper;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final m generator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/thumbnail/l$b", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/e;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements e {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.thumbnail.e
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            if (bitmap != null) {
                l.this.cacheHelper.b(startTimeMs, bitmap);
            }
            String valueOf = String.valueOf(startTimeMs);
            List list = (List) l.this.tagTable.get(valueOf);
            if (list != null) {
                l lVar = l.this;
                lVar.tagTable.remove(valueOf);
                e eVar = lVar.userVideoThumbListener;
                if (eVar != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        eVar.a(it.next(), startTimeMs, bitmap);
                    }
                }
            }
        }
    }

    public l(@NotNull String groupId, @NotNull ThumbAssetModel resourceModel, @NotNull LruCache<LRUKey, Integer> lruCache, @NotNull d handler, int i3, int i16, @Nullable LAKRenderModel lAKRenderModel, boolean z16) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(resourceModel, "resourceModel");
        Intrinsics.checkNotNullParameter(lruCache, "lruCache");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.groupId = groupId;
        this.resourceModel = resourceModel;
        this.lakRenderModel = lAKRenderModel;
        b bVar = new b();
        this.defaultVideoThumbListener = bVar;
        this.tagTable = new ConcurrentHashMap<>();
        this.keyFrameList = new ArrayList<>();
        this.refCount = new AtomicInteger(0);
        this.cacheHelper = new p(new j(resourceModel.getAssetPath(), lruCache));
        m mVar = new m(bVar, i16, i3, handler);
        this.generator = mVar;
        ThumbnailGeneratorHelper thumbnailGeneratorHelper = new ThumbnailGeneratorHelper(mVar, resourceModel);
        thumbnailGeneratorHelper.s(this.lakRenderModel);
        thumbnailGeneratorHelper.t(z16);
        this.generatorHelper = thumbnailGeneratorHelper;
        handler.postRunnable(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.thumbnail.k
            @Override // java.lang.Runnable
            public final void run() {
                l.b(l.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(l this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.g();
    }

    private final void g() {
        if (u53.i.f438432e == null) {
            Boolean valueOf = Boolean.valueOf(QzoneConfig.isOpenNonAccurateExtractFrame(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount()));
            u53.i.f438432e = valueOf;
            w53.b.c("VideoThumbAssetProvider", "[wns][fetchKeyFrames]  isOpenNonAccurateExtractFrame = " + valueOf);
        }
        w53.b.c("VideoThumbAssetProvider", "[wns][fetchKeyFrames]  isOpenNonAccurateExtractFrame = " + u53.i.f438432e);
        Boolean isOpenNonAccurateExtractFrame = u53.i.f438432e;
        Intrinsics.checkNotNullExpressionValue(isOpenNonAccurateExtractFrame, "isOpenNonAccurateExtractFrame");
        if (isOpenNonAccurateExtractFrame.booleanValue()) {
            u();
        }
    }

    private final long h(long time) {
        long o16 = o() + 1;
        Iterator<T> it = this.keyFrameList.iterator();
        long j3 = -1;
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            long j16 = time - longValue;
            if (Math.abs(j16) < o16) {
                o16 = Math.abs(j16);
                j3 = longValue;
            }
        }
        return j3;
    }

    private final Bitmap k(long nearbyTime, Object tag) {
        Bitmap bitmap;
        BitmapPoint c16 = this.cacheHelper.c(nearbyTime);
        if (c16 != null) {
            bitmap = c16.getBitmap();
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            t(tag, nearbyTime);
            return this.defaultBitmap;
        }
        if (c16.getTime() != nearbyTime) {
            t(tag, nearbyTime);
            return this.defaultBitmap;
        }
        w53.b.a("VideoThumbAssetProvider", "getBitmapByNearbyTime hit memery, path = " + this.resourceModel.getAssetPath());
        return c16.getBitmap();
    }

    @WorkerThread
    private final List<Long> l() {
        List mutableList;
        boolean z16;
        List<Long> list;
        List<Long> emptyList;
        List<Long> b16 = com.tencent.tavcut.core.utils.a.b(i());
        Intrinsics.checkNotNullExpressionValue(b16, "getKeyFrameTime(assetPath)");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) b16);
        List list2 = mutableList;
        int i3 = 1;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        while (i3 < mutableList.size()) {
            long longValue = ((Number) mutableList.get(i3)).longValue();
            int i16 = i3 - 1;
            Object obj = mutableList.get(i16);
            Intrinsics.checkNotNullExpressionValue(obj, "keyFramesPts[i-1]");
            if (longValue - ((Number) obj).longValue() > 2000000) {
                mutableList.add(i3, Long.valueOf(((Number) mutableList.get(i16)).longValue() + AECameraConstants.TRIBE_MAX_RATE));
            } else {
                i3++;
            }
        }
        list = CollectionsKt___CollectionsKt.toList(mutableList);
        return list;
    }

    private final long n(long timeUs, long duration) {
        if (timeUs < 0) {
            timeUs = 0;
        }
        if (timeUs > duration) {
            return duration - 100000;
        }
        return timeUs;
    }

    private final long o() {
        return this.resourceModel.getSourceTimeDurationUs();
    }

    private final void t(Object tag, long timeMs) {
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
        w53.b.f("VideoThumbAssetProvider", "sendGenerateRequest time:" + timeMs + ",Object:" + tag);
        this.generatorHelper.a(timeMs);
    }

    private final void u() {
        this.keyFrameList.clear();
        this.keyFrameList.addAll(l());
        Iterator<T> it = this.keyFrameList.iterator();
        while (it.hasNext()) {
            k(n(((Number) it.next()).longValue(), o()), null);
        }
        w53.b.f("VideoThumbAssetProvider", "[serialExtractKeyFrames] get keyframes list finished size = " + this.keyFrameList.size());
    }

    public final boolean f() {
        if (this.refCount.get() <= 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String i() {
        return this.resourceModel.getAssetPath();
    }

    @Nullable
    public final Bitmap j(long timeUs, @Nullable Object tag, boolean isAccurate) {
        boolean z16 = true;
        if (this.resourceModel.getType() == 1) {
            return k(0L, tag);
        }
        if (!isAccurate) {
            ArrayList<Long> arrayList = this.keyFrameList;
            if (arrayList != null && !arrayList.isEmpty()) {
                z16 = false;
            }
            if (!z16) {
                timeUs = h(timeUs);
            }
        }
        return k(n(timeUs, o()), tag);
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    public final void p() {
        this.refCount.getAndDecrement();
    }

    public final void q() {
        this.refCount.getAndIncrement();
    }

    public final void r() {
        w53.b.f("VideoThumbAssetProvider", "release:" + this.resourceModel.getAssetPath());
        this.generatorHelper.release();
        this.cacheHelper.release();
        this.userVideoThumbListener = null;
    }

    public final void s(long time) {
        this.cacheHelper.a(time);
    }

    public final void v(@Nullable Bitmap bitmap) {
        this.defaultBitmap = bitmap;
    }

    public final void w(@Nullable e videoThumbListener) {
        this.userVideoThumbListener = videoThumbListener;
    }
}
