package com.tencent.mobileqq.wink.picker.core.repository;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.querymedia.ICursor;
import com.tencent.mobileqq.activity.photo.album.querymedia.ImageCursor;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.activity.photo.album.querymedia.VideoCursor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u0011\u0014B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J=\u0010\u000e\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042'\u0010\r\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007J\u0006\u0010\u000f\u001a\u00020\fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository;", "", "Lcom/tencent/mobileqq/activity/photo/album/querymedia/MediaQueryHelper;", "e", "", "", "mediaPaths", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/ParameterName;", "name", QAdVrReportParams.ParamKey.MEDIA, "", "onQueryFinish", "f", tl.h.F, "", "a", "Ljava/util/List;", "selectedMediaPaths", "b", "Lkotlin/Lazy;", "d", "()Lcom/tencent/mobileqq/activity/photo/album/querymedia/MediaQueryHelper;", "mediaQueryHelper", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSelectedLocalMediaRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> selectedMediaPaths = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaQueryHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository$a;", "Lcom/tencent/mobileqq/activity/photo/album/querymedia/ImageCursor;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "needMediaInfo", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository;Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class a extends ImageCursor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkSelectedLocalMediaRepository f324635a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull WinkSelectedLocalMediaRepository winkSelectedLocalMediaRepository, Context context) {
            super(context, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f324635a = winkSelectedLocalMediaRepository;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ImageCursor, com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
        public boolean needMediaInfo(@NotNull LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return this.f324635a.selectedMediaPaths.remove(info.path);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository$b;", "Lcom/tencent/mobileqq/activity/photo/album/querymedia/VideoCursor;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "needMediaInfo", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/mobileqq/wink/picker/core/repository/WinkSelectedLocalMediaRepository;Landroid/content/Context;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class b extends VideoCursor {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkSelectedLocalMediaRepository f324636a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull WinkSelectedLocalMediaRepository winkSelectedLocalMediaRepository, Context context) {
            super(context, QAlbumCustomAlbumConstants.RECENT_ALBUM_ID);
            Intrinsics.checkNotNullParameter(context, "context");
            this.f324636a = winkSelectedLocalMediaRepository;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.activity.photo.album.querymedia.ICursor
        public boolean needMediaInfo(@NotNull LocalMediaInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            return this.f324636a.selectedMediaPaths.remove(info.path);
        }
    }

    public WinkSelectedLocalMediaRepository() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MediaQueryHelper>() { // from class: com.tencent.mobileqq.wink.picker.core.repository.WinkSelectedLocalMediaRepository$mediaQueryHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaQueryHelper invoke() {
                MediaQueryHelper e16;
                e16 = WinkSelectedLocalMediaRepository.this.e();
                return e16;
            }
        });
        this.mediaQueryHelper = lazy;
    }

    private final MediaQueryHelper d() {
        return (MediaQueryHelper) this.mediaQueryHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaQueryHelper e() {
        List<ICursor> listOf;
        Context context = MobileQQ.sMobileQQ.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ICursor[]{new a(this, context), new b(this, context)});
        MediaQueryHelper build = new MediaQueryHelper.Builder().setAlbumId(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID).setEachCount(100).needImage(true).needVideo(true).setCursors(listOf).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              \u2026\n                .build()");
        return build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(List mediaPaths, WinkSelectedLocalMediaRepository this$0, List selectedMediaListCopy, Function1 onQueryFinish) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        List list;
        Intrinsics.checkNotNullParameter(mediaPaths, "$mediaPaths");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectedMediaListCopy, "$selectedMediaListCopy");
        Intrinsics.checkNotNullParameter(onQueryFinish, "$onQueryFinish");
        int size = mediaPaths.size();
        while (!this$0.d().mTraversalDone && this$0.d().mediaList.size() < size) {
            this$0.d().queryNext();
        }
        List<LocalMediaInfo> list2 = this$0.d().mediaList;
        Intrinsics.checkNotNullExpressionValue(list2, "mediaQueryHelper.mediaList");
        List<LocalMediaInfo> list3 = list2;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list3) {
            String str = ((LocalMediaInfo) obj).path;
            Intrinsics.checkNotNullExpressionValue(str, "it.path");
            linkedHashMap.put(str, obj);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = selectedMediaListCopy.iterator();
        while (it.hasNext()) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) linkedHashMap.get((String) it.next());
            if (localMediaInfo != null) {
                arrayList.add(localMediaInfo);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        onQueryFinish.invoke(list);
    }

    public final void f(@NotNull final List<String> mediaPaths, @NotNull final Function1<? super List<? extends LocalMediaInfo>, Unit> onQueryFinish) {
        Intrinsics.checkNotNullParameter(mediaPaths, "mediaPaths");
        Intrinsics.checkNotNullParameter(onQueryFinish, "onQueryFinish");
        if (mediaPaths.isEmpty()) {
            return;
        }
        this.selectedMediaPaths.clear();
        this.selectedMediaPaths.addAll(mediaPaths);
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.selectedMediaPaths);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.core.repository.n
            @Override // java.lang.Runnable
            public final void run() {
                WinkSelectedLocalMediaRepository.g(mediaPaths, this, arrayList, onQueryFinish);
            }
        }, 32, null, true);
    }

    public final void h() {
        if (!d().isQuerying.get()) {
            d().close();
        }
    }
}
