package gm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import fm1.i;
import gm1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u001e\u0010B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JH\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b2\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002JF\u0010\u0015\u001a\u00020\u00142\u0010\u0010\f\u001a\f\u0012\u0004\u0012\u00020\n0\u0006j\u0002`\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R&\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!\u00a8\u0006%"}, d2 = {"Lgm1/a;", "Lgm1/c;", "Lcom/tencent/mobileqq/guild/temp/api/c;", "albumResult", "Lgm1/a$a;", "d", "", "Lfm1/i;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/datadelegate/PreviewMediaList;", "previewMediaList", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/datadelegate/LocalMediaList;", "selectedLocalMediaList", "", "", "editMap", "b", "notInAlbumPreviewMediaList", "", "isQuality", "", "f", "Lgm1/c$c;", "src", "Lgm1/c$b;", "e", "", "getMediaType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "Lgm1/a$b;", "Lgm1/a$b;", "dataSource", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<i> previewMediaList = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MediaDataSource dataSource;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lgm1/a$a;", "Lgm1/c$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lfm1/i;", "a", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "<init>", "(Ljava/util/List;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gm1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class MediaDataResult implements c.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<i> mediaList;

        /* JADX WARN: Multi-variable type inference failed */
        public MediaDataResult(@NotNull List<? extends i> mediaList) {
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            this.mediaList = mediaList;
        }

        @NotNull
        public final List<i> a() {
            return this.mediaList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof MediaDataResult) && Intrinsics.areEqual(this.mediaList, ((MediaDataResult) other).mediaList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.mediaList.hashCode();
        }

        @NotNull
        public String toString() {
            return "MediaDataResult(mediaList=" + this.mediaList + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001f\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lgm1/a$b;", "Lgm1/c$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/temp/api/c;", "a", "Lcom/tencent/mobileqq/guild/temp/api/c;", "()Lcom/tencent/mobileqq/guild/temp/api/c;", "albumResult", "", "Lfm1/i;", "b", "Ljava/util/List;", "()Ljava/util/List;", "mediaList", "", "c", "Ljava/util/Set;", "getUnModifiableMediaSet", "()Ljava/util/Set;", "unModifiableMediaSet", "<init>", "(Lcom/tencent/mobileqq/guild/temp/api/c;Ljava/util/List;Ljava/util/Set;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: gm1.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class MediaDataSource implements c.InterfaceC10387c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final com.tencent.mobileqq.guild.temp.api.c albumResult;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<i> mediaList;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Set<i> unModifiableMediaSet;

        /* JADX WARN: Multi-variable type inference failed */
        public MediaDataSource(@NotNull com.tencent.mobileqq.guild.temp.api.c albumResult, @NotNull List<? extends i> mediaList, @Nullable Set<? extends i> set) {
            Intrinsics.checkNotNullParameter(albumResult, "albumResult");
            Intrinsics.checkNotNullParameter(mediaList, "mediaList");
            this.albumResult = albumResult;
            this.mediaList = mediaList;
            this.unModifiableMediaSet = set;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final com.tencent.mobileqq.guild.temp.api.c getAlbumResult() {
            return this.albumResult;
        }

        @NotNull
        public final List<i> b() {
            return this.mediaList;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MediaDataSource)) {
                return false;
            }
            MediaDataSource mediaDataSource = (MediaDataSource) other;
            if (Intrinsics.areEqual(this.albumResult, mediaDataSource.albumResult) && Intrinsics.areEqual(this.mediaList, mediaDataSource.mediaList) && Intrinsics.areEqual(this.unModifiableMediaSet, mediaDataSource.unModifiableMediaSet)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.albumResult.hashCode() * 31) + this.mediaList.hashCode()) * 31;
            Set<i> set = this.unModifiableMediaSet;
            if (set == null) {
                hashCode = 0;
            } else {
                hashCode = set.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "MediaDataSource(albumResult=" + this.albumResult + ", mediaList=" + this.mediaList + ", unModifiableMediaSet=" + this.unModifiableMediaSet + ")";
        }
    }

    private final List<i> b(List<? extends i> previewMediaList, List<? extends LocalMediaInfo> selectedLocalMediaList, Map<String, String> editMap) {
        Set<String> set;
        String str;
        ArrayList<LocalMediaInfo> arrayList = new ArrayList();
        for (Object obj : selectedLocalMediaList) {
            if (hm1.a.f((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (LocalMediaInfo localMediaInfo : arrayList) {
            if (editMap != null && editMap.containsKey(localMediaInfo.picPathBeforeEdit)) {
                str = localMediaInfo.picPathBeforeEdit;
            } else {
                str = localMediaInfo.path;
            }
            if (str != null) {
                arrayList2.add(str);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        ArrayList<i> arrayList3 = new ArrayList();
        for (Object obj2 : previewMediaList) {
            if (!set.contains(((i) obj2).getVideoPlayUrl())) {
                arrayList3.add(obj2);
            }
        }
        if (QLog.isColorLevel()) {
            for (String str2 : set) {
                QLog.i(c(), 2, "[InAlbum]--" + str2);
            }
            for (i iVar : arrayList3) {
                QLog.i(c(), 2, "[notInAlbum]--" + iVar.getVideoPlayUrl());
            }
        }
        return arrayList3;
    }

    private final MediaDataResult d(com.tencent.mobileqq.guild.temp.api.c albumResult) {
        boolean isQuality = albumResult.getIsQuality();
        List<Object> b16 = albumResult.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.activity.photo.LocalMediaInfo>");
        f(b16, b(this.previewMediaList, b16, albumResult.a()), albumResult.a(), isQuality);
        Logger logger = Logger.f235387a;
        String c16 = c();
        logger.d().d(c16, 1, "[updateFromAlbumResult]--mediaSize:" + this.previewMediaList.size() + ", isQuality:" + isQuality);
        return new MediaDataResult(this.previewMediaList);
    }

    private final void f(List<? extends LocalMediaInfo> selectedLocalMediaList, List<? extends i> notInAlbumPreviewMediaList, Map<String, String> editMap, boolean isQuality) {
        List b16;
        Object obj;
        LinkedList linkedList = new LinkedList();
        b16 = b.b(this.previewMediaList);
        Iterator<? extends i> it = notInAlbumPreviewMediaList.iterator();
        for (LocalMediaInfo localMediaInfo : selectedLocalMediaList) {
            if (!hm1.a.f(localMediaInfo) && it.hasNext()) {
                linkedList.add(it.next());
            } else if (!hm1.a.f(localMediaInfo)) {
                QLog.e(c(), 1, "[onUpdatePreviewList]--selectMedia is valid but not in notInAlbumPreviewList!");
            } else {
                String str = localMediaInfo.path;
                Iterator it5 = b16.iterator();
                while (true) {
                    if (it5.hasNext()) {
                        obj = it5.next();
                        if (Intrinsics.areEqual(((fm1.c) obj).getVideoPlayUrl(), str)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                fm1.c cVar = (fm1.c) obj;
                if (cVar != null) {
                    cVar.n(localMediaInfo);
                } else {
                    cVar = new fm1.c(localMediaInfo, com.tencent.mobileqq.guild.feed.nativepublish.publish.a.f222223a.b());
                }
                cVar.p(isQuality);
                if (editMap != null) {
                    String videoPlayUrl = cVar.getVideoPlayUrl();
                    if (editMap.containsKey(videoPlayUrl)) {
                        String str2 = editMap.get(videoPlayUrl);
                        Intrinsics.checkNotNull(str2);
                        cVar.o(str2);
                    }
                }
                QLog.i(c(), 1, "previewMedia--isQuality:" + cVar.l() + ",beforeEditPath:" + cVar.d() + ", path:" + cVar.getVideoPlayUrl());
                linkedList.add(cVar);
            }
        }
        this.previewMediaList.clear();
        this.previewMediaList.addAll(linkedList);
    }

    @NotNull
    public String c() {
        return c.a.a(this);
    }

    @NotNull
    public c.b e(@NotNull c.InterfaceC10387c src) {
        Intrinsics.checkNotNullParameter(src, "src");
        MediaDataSource mediaDataSource = (MediaDataSource) src;
        this.dataSource = mediaDataSource;
        this.previewMediaList = bg.f302144a.n(mediaDataSource.b());
        return d(mediaDataSource.getAlbumResult());
    }

    @Override // gm1.c
    public int getMediaType() {
        return 0;
    }
}
