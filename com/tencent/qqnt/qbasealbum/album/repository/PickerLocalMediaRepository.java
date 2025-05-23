package com.tencent.qqnt.qbasealbum.album.repository;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.qbasealbum.base.repository.b;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J.\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/repository/PickerLocalMediaRepository;", "Lcom/tencent/qqnt/qbasealbum/base/repository/b;", "", "albumId", "", "mediaNum", "", "", "payload", "", "b", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "c", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Ljava/util/concurrent/ConcurrentHashMap;", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "updateSizeMap", "<init>", "(Lcom/tencent/qqnt/qbasealbum/model/PageType;)V", "e", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PickerLocalMediaRepository extends com.tencent.qqnt.qbasealbum.base.repository.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PageType pageType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<Long, Integer> updateSizeMap;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/album/repository/PickerLocalMediaRepository$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.album.repository.PickerLocalMediaRepository$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30765);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PickerLocalMediaRepository(@NotNull PageType pageType) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pageType);
        } else {
            this.pageType = pageType;
            this.updateSizeMap = new ConcurrentHashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r2v19, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List, T] */
    public static final void c(Map map, final String albumId, PickerLocalMediaRepository this$0, int i3) {
        Object obj;
        Boolean bool;
        Object obj2;
        final long j3;
        int i16;
        boolean z16;
        final int size;
        List emptyList;
        final int coerceAtMost;
        List emptyList2;
        Long l3;
        Intrinsics.checkNotNullParameter(albumId, "$albumId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map map2 = null;
        if (map != null) {
            obj = map.get("firstPageFlag");
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        final boolean areEqual = Intrinsics.areEqual(bool, Boolean.TRUE);
        if (map != null) {
            obj2 = map.get("fetchSeqKey");
        } else {
            obj2 = null;
        }
        if (TypeIntrinsics.isMutableMap(obj2)) {
            map2 = (Map) obj2;
        }
        if (map2 != null && (l3 = (Long) map2.get(albumId)) != null) {
            j3 = l3.longValue();
        } else {
            j3 = 0;
        }
        ox3.a.c("QBaseAlbum.MediaLoad", new Function0<String>(albumId, areEqual, j3) { // from class: com.tencent.qqnt.qbasealbum.album.repository.PickerLocalMediaRepository$queryMediaNext$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $albumId;
            final /* synthetic */ long $fetchSeq;
            final /* synthetic */ boolean $isFirstPage;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$albumId = albumId;
                this.$isFirstPage = areEqual;
                this.$fetchSeq = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, albumId, Boolean.valueOf(areEqual), Long.valueOf(j3));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "queryMediaNext, albumId=" + this.$albumId + " isFirstPage=" + this.$isFirstPage + ", fetchSeq=" + this.$fetchSeq;
            }
        });
        if (areEqual) {
            this$0.updateSizeMap.put(Long.valueOf(j3), 0);
        }
        Integer num = this$0.updateSizeMap.get(Long.valueOf(j3));
        Intrinsics.checkNotNull(num);
        final int intValue = num.intValue();
        LocalMediaDataHub.Companion companion = LocalMediaDataHub.INSTANCE;
        boolean a06 = companion.a().a0();
        boolean W = companion.a().W();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = companion.a().U(albumId, this$0.pageType);
        final boolean z17 = true;
        if (areEqual && (!((Collection) r9).isEmpty())) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(intValue + i3, ((List) objectRef.element).size());
            if (coerceAtMost <= intValue) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            } else {
                emptyList2 = new ArrayList((Collection) objectRef.element).subList(intValue, coerceAtMost);
                Intrinsics.checkNotNullExpressionValue(emptyList2, "ArrayList(medias).subList(oldSize, newSize)");
            }
            if (W && coerceAtMost == ((List) objectRef.element).size()) {
                z17 = false;
            }
            this$0.updateSizeMap.put(Long.valueOf(j3), Integer.valueOf(coerceAtMost));
            ox3.a.g("QBaseAlbum.MediaLoad", new Function0<String>(intValue, coerceAtMost, z17) { // from class: com.tencent.qqnt.qbasealbum.album.repository.PickerLocalMediaRepository$queryMediaNext$1$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ boolean $hasMore;
                final /* synthetic */ int $newSize;
                final /* synthetic */ int $oldSize;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$oldSize = intValue;
                    this.$newSize = coerceAtMost;
                    this.$hasMore = z17;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, Integer.valueOf(intValue), Integer.valueOf(coerceAtMost), Boolean.valueOf(z17));
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "queryMediaNext, oldSize=" + this.$oldSize + ", newSize=" + this.$newSize + ", hasMore=" + this.$hasMore;
                }
            });
            b.InterfaceC9681b interfaceC9681b = this$0.mediaQueryListener;
            if (interfaceC9681b != null) {
                interfaceC9681b.j0(new com.tencent.qqnt.qbasealbum.base.repository.a(albumId, emptyList2, true, z17, true, map));
                return;
            }
            return;
        }
        int i17 = 0;
        while (true) {
            i16 = intValue + i3;
            if (((List) objectRef.element).size() >= i16 || W) {
                break;
            }
            if (a06) {
                LocalMediaDataHub.Companion companion2 = LocalMediaDataHub.INSTANCE;
                companion2.a().v0();
                a06 = companion2.a().a0();
                W = companion2.a().W();
                objectRef.element = companion2.a().U(albumId, this$0.pageType);
            } else {
                int i18 = i17 + 1;
                if (i17 >= 5) {
                    ox3.a.f("QBaseAlbum.MediaLoad", PickerLocalMediaRepository$queryMediaNext$1$3.INSTANCE);
                    z16 = false;
                    break;
                }
                LockMethodProxy.sleep(200L);
                LocalMediaDataHub.Companion companion3 = LocalMediaDataHub.INSTANCE;
                boolean a07 = companion3.a().a0();
                W = companion3.a().W();
                objectRef.element = companion3.a().U(albumId, this$0.pageType);
                a06 = a07;
                i17 = i18;
            }
        }
        z16 = true;
        ox3.a.c("QBaseAlbum.MediaLoad", new Function0<String>(objectRef) { // from class: com.tencent.qqnt.qbasealbum.album.repository.PickerLocalMediaRepository$queryMediaNext$1$4
            static IPatchRedirector $redirector_;
            final /* synthetic */ Ref.ObjectRef<List<LocalMediaInfo>> $medias;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$medias = objectRef;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) objectRef);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "getCurrentPageMedias, localMedias size = " + this.$medias.element.size();
            }
        });
        if (areEqual) {
            size = RangesKt___RangesKt.coerceAtMost(i16, ((List) objectRef.element).size());
        } else {
            size = ((List) objectRef.element).size();
        }
        if (size <= intValue) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList((Collection) objectRef.element).subList(intValue, size);
            Intrinsics.checkNotNullExpressionValue(emptyList, "ArrayList(medias).subList(oldSize, newSize)");
        }
        if (W && size == ((List) objectRef.element).size()) {
            z17 = false;
        }
        this$0.updateSizeMap.put(Long.valueOf(j3), Integer.valueOf(size));
        ox3.a.g("QBaseAlbum.MediaLoad", new Function0<String>(intValue, size, z17) { // from class: com.tencent.qqnt.qbasealbum.album.repository.PickerLocalMediaRepository$queryMediaNext$1$5
            static IPatchRedirector $redirector_;
            final /* synthetic */ boolean $hasMore;
            final /* synthetic */ int $newSize;
            final /* synthetic */ int $oldSize;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$oldSize = intValue;
                this.$newSize = size;
                this.$hasMore = z17;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, Integer.valueOf(intValue), Integer.valueOf(size), Boolean.valueOf(z17));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return "queryMediaNext, oldSize=" + this.$oldSize + ", newSize=" + this.$newSize + ", hasMore=" + this.$hasMore;
            }
        });
        b.InterfaceC9681b interfaceC9681b2 = this$0.mediaQueryListener;
        if (interfaceC9681b2 != null) {
            interfaceC9681b2.j0(new com.tencent.qqnt.qbasealbum.base.repository.a(albumId, emptyList, true, z17, z16, map));
        }
    }

    public void b(@NotNull final String albumId, final int mediaNum, @Nullable final Map<String, ? extends Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, albumId, Integer.valueOf(mediaNum), payload);
        } else {
            Intrinsics.checkNotNullParameter(albumId, "albumId");
            g.f361234b.execute(new Runnable() { // from class: com.tencent.qqnt.qbasealbum.album.repository.b
                @Override // java.lang.Runnable
                public final void run() {
                    PickerLocalMediaRepository.c(payload, albumId, this, mediaNum);
                }
            }, 32);
        }
    }
}
