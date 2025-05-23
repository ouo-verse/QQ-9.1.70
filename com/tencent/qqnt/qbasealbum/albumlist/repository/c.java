package com.tencent.qqnt.qbasealbum.albumlist.repository;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.beacon.NTBeaconReport;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.TabType;
import com.tencent.qqnt.qbasealbum.utils.e;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0002J*\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J(\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015R\u0016\u0010\u0019\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c;", "", "", "Lcom/tencent/qqnt/qbasealbum/model/b;", "imageAlbums", "videoAlbums", "", "c", "albums", "", h.F, "d", "a", "b", "g", "", "limit", "Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c$a;", "listener", "Lcom/tencent/qqnt/qbasealbum/model/TabType;", "tabType", "", "isRealAlbumID", "e", "I", "totalMediaCnt", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int totalMediaCnt;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c$a;", "", "", "Lcom/tencent/qqnt/qbasealbum/model/b;", "albums", "", "a", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface a {
        void a(@Nullable List<com.tencent.qqnt.qbasealbum.model.b> albums);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/albumlist/repository/c$b;", "", "", "EVENT_ALBUM_COUNT", "Ljava/lang/String;", "NULL_ALBUM_EVENT", "PARAM_COUNT", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.albumlist.repository.c$b, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.qqnt.qbasealbum.albumlist.repository.c$c, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public /* synthetic */ class C9680c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360880a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34217);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[TabType.values().length];
            try {
                iArr[TabType.TAB_IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabType.TAB_MEDIA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabType.TAB_ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TabType.TAB_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f360880a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class d<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.qqnt.qbasealbum.model.b) t17).a()), Long.valueOf(((com.tencent.qqnt.qbasealbum.model.b) t16).a()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34220);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.qqnt.qbasealbum.model.b a(List<com.tencent.qqnt.qbasealbum.model.b> albums) {
        Object orNull;
        Object orNull2;
        Object orNull3;
        List listOfNotNull;
        Object next;
        LocalMediaInfo localMediaInfo;
        com.tencent.qqnt.qbasealbum.model.b bVar = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        bVar.i(aVar.a());
        bVar.n(Long.valueOf(Long.parseLong(aVar.a())));
        bVar.m("\u6700\u8fd1\u7167\u7247");
        orNull = CollectionsKt___CollectionsKt.getOrNull(albums, 0);
        com.tencent.qqnt.qbasealbum.model.b bVar2 = (com.tencent.qqnt.qbasealbum.model.b) orNull;
        if (bVar2 == null) {
            bVar2 = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
        }
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(albums, 1);
        com.tencent.qqnt.qbasealbum.model.b bVar3 = (com.tencent.qqnt.qbasealbum.model.b) orNull2;
        if (bVar3 == null) {
            bVar3 = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
        }
        orNull3 = CollectionsKt___CollectionsKt.getOrNull(albums, 2);
        com.tencent.qqnt.qbasealbum.model.b bVar4 = (com.tencent.qqnt.qbasealbum.model.b) orNull3;
        if (bVar4 == null) {
            bVar4 = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
        }
        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull((Object[]) new com.tencent.qqnt.qbasealbum.model.b[]{bVar3, bVar4, bVar2});
        Iterator it = listOfNotNull.iterator();
        if (!it.hasNext()) {
            next = null;
        } else {
            next = it.next();
            if (it.hasNext()) {
                long a16 = ((com.tencent.qqnt.qbasealbum.model.b) next).a();
                do {
                    Object next2 = it.next();
                    long a17 = ((com.tencent.qqnt.qbasealbum.model.b) next2).a();
                    if (a16 < a17) {
                        next = next2;
                        a16 = a17;
                    }
                } while (it.hasNext());
            }
        }
        com.tencent.qqnt.qbasealbum.model.b bVar5 = (com.tencent.qqnt.qbasealbum.model.b) next;
        if (bVar5 == null || (localMediaInfo = bVar5.c()) == null) {
            localMediaInfo = new LocalMediaInfo(false, 1, null);
        }
        bVar.j(localMediaInfo);
        bVar.h(bVar.c().getModifiedDate());
        bVar.k(this.totalMediaCnt);
        return bVar;
    }

    private final com.tencent.qqnt.qbasealbum.model.b b(List<com.tencent.qqnt.qbasealbum.model.b> videoAlbums) {
        Object orNull;
        LocalMediaInfo localMediaInfo;
        com.tencent.qqnt.qbasealbum.model.b bVar = new com.tencent.qqnt.qbasealbum.model.b(0, null, 0L, null, 0, 0, null, 127, null);
        com.tencent.qqnt.qbasealbum.model.a aVar = com.tencent.qqnt.qbasealbum.model.a.f361348a;
        bVar.i(aVar.b());
        bVar.n(Long.valueOf(Long.parseLong(aVar.b())));
        bVar.m("\u672c\u5730\u89c6\u9891");
        int i3 = 0;
        orNull = CollectionsKt___CollectionsKt.getOrNull(videoAlbums, 0);
        com.tencent.qqnt.qbasealbum.model.b bVar2 = (com.tencent.qqnt.qbasealbum.model.b) orNull;
        if (bVar2 == null || (localMediaInfo = bVar2.c()) == null) {
            localMediaInfo = new LocalMediaInfo(false, 1, null);
        }
        bVar.j(localMediaInfo);
        bVar.h(bVar.c().getModifiedDate());
        Iterator<T> it = videoAlbums.iterator();
        while (it.hasNext()) {
            i3 += ((com.tencent.qqnt.qbasealbum.model.b) it.next()).e();
        }
        bVar.k(i3);
        return bVar;
    }

    private final List<com.tencent.qqnt.qbasealbum.model.b> c(List<com.tencent.qqnt.qbasealbum.model.b> imageAlbums, List<com.tencent.qqnt.qbasealbum.model.b> videoAlbums) {
        QLog.i("queryAlbums", 1, "start compact");
        com.tencent.qqnt.qbasealbum.model.b b16 = b(videoAlbums);
        List<com.tencent.qqnt.qbasealbum.model.b> d16 = d(imageAlbums, videoAlbums);
        if (d16.isEmpty()) {
            return d16;
        }
        h(d16);
        if (!videoAlbums.isEmpty()) {
            d16.add(0, b16);
        }
        d16.add(0, a(d16));
        QLog.i("queryAlbums", 1, "end compact");
        return d16;
    }

    private final List<com.tencent.qqnt.qbasealbum.model.b> d(List<com.tencent.qqnt.qbasealbum.model.b> imageAlbums, List<com.tencent.qqnt.qbasealbum.model.b> videoAlbums) {
        List<com.tencent.qqnt.qbasealbum.model.b> mutableList;
        HashMap hashMap = new HashMap();
        for (com.tencent.qqnt.qbasealbum.model.b bVar : videoAlbums) {
            String b16 = bVar.b();
            Intrinsics.checkNotNull(b16);
            hashMap.put(b16, bVar);
        }
        for (com.tencent.qqnt.qbasealbum.model.b bVar2 : imageAlbums) {
            if (hashMap.containsKey(bVar2.b())) {
                com.tencent.qqnt.qbasealbum.model.b bVar3 = (com.tencent.qqnt.qbasealbum.model.b) hashMap.get(bVar2.b());
                if (bVar3 != null) {
                    bVar3.k(bVar3.d() + bVar2.d());
                    if (bVar2.a() > bVar3.a()) {
                        bVar3.j(bVar2.c());
                        bVar3.h(bVar2.a());
                    }
                }
            } else {
                String b17 = bVar2.b();
                Intrinsics.checkNotNull(b17);
                hashMap.put(b17, bVar2);
            }
        }
        Collection values = hashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "result.values");
        mutableList = CollectionsKt___CollectionsKt.toMutableList(values);
        return mutableList;
    }

    public static /* synthetic */ void f(c cVar, int i3, a aVar, TabType tabType, boolean z16, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        cVar.e(i3, aVar, tabType, z16);
    }

    private final void g() {
        String str;
        AppRuntime peekAppRuntime;
        HashMap hashMap = new HashMap();
        hashMap.put("count", String.valueOf(this.totalMediaCnt));
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null && (peekAppRuntime = mobileQQ.peekAppRuntime()) != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        NTBeaconReport.h(str, "album_media_count_more_than_5w", hashMap);
    }

    private final void h(List<com.tencent.qqnt.qbasealbum.model.b> albums) {
        if (albums.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(albums, new d());
        }
        int size = albums.size();
        for (int i3 = 1; i3 < size; i3++) {
            com.tencent.qqnt.qbasealbum.model.b bVar = albums.get(i3);
            if (e.f361653a.a(bVar.f())) {
                albums.remove(bVar);
                albums.add(0, bVar);
            }
        }
    }

    public final void e(int limit, @NotNull a listener, @NotNull TabType tabType, boolean isRealAlbumID) {
        List<com.tencent.qqnt.qbasealbum.model.b> d16;
        List<com.tencent.qqnt.qbasealbum.model.b> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(limit), listener, tabType, Boolean.valueOf(isRealAlbumID));
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(tabType, "tabType");
        g gVar = g.f361234b;
        if (gVar.k()) {
            QLog.i("queryAlbums", 1, "App is background, don't query image");
            return;
        }
        int[] iArr = C9680c.f360880a;
        int i16 = iArr[tabType.ordinal()];
        if (i16 != 1 && i16 != 2 && i16 != 3) {
            d16 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            d16 = AlbumQueryHelper.f360873a.d(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), limit, isRealAlbumID);
        }
        if (gVar.k()) {
            QLog.i("queryAlbums", 1, "App is background, don't query video");
            return;
        }
        int i17 = iArr[tabType.ordinal()];
        if (i17 != 2 && i17 != 3 && i17 != 4) {
            e16 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            e16 = AlbumQueryHelper.f360873a.e(com.tencent.qqnt.qbasealbum.inject.a.f361230a.a(), limit, isRealAlbumID);
        }
        Iterator<T> it = d16.iterator();
        int i18 = 0;
        while (it.hasNext()) {
            i18 += ((com.tencent.qqnt.qbasealbum.model.b) it.next()).d();
        }
        Iterator<T> it5 = e16.iterator();
        while (it5.hasNext()) {
            i3 += ((com.tencent.qqnt.qbasealbum.model.b) it5.next()).e();
        }
        this.totalMediaCnt = i18 + i3;
        if (d16.isEmpty() || e16.isEmpty()) {
            QLog.i("queryAlbums", 1, "image size: " + d16.size() + " video size: " + e16.size());
            NTBeaconReport.f("null_album_event");
        }
        listener.a(c(d16, e16));
        if (limit != -1 && (d16.size() == limit || e16.size() == limit)) {
            e(-1, listener, tabType, isRealAlbumID);
        }
        g();
    }
}
