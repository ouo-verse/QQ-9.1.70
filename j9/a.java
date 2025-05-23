package j9;

import kj.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zh.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\n8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lj9/a;", "", "Lkj/d;", "b", "Lkj/d;", "sIntimateDownloadStrategy", "Lzh/c;", "c", "Lzh/c;", "sGroupAlbumDownloadStrategy", "Lkc/c;", "d", "Lkc/c;", "sQZAlbumxDownloadQueueStrategy", "()Lkj/d;", "intimateDownloadStrategy", "a", "()Lzh/c;", "groupAlbumDownloadStrategy", "()Lkc/c;", "qzAlbumxDownloadQueueStrategy", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f409661a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static d sIntimateDownloadStrategy;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static c sGroupAlbumDownloadStrategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static kc.c sQZAlbumxDownloadQueueStrategy;

    a() {
    }

    public final c a() {
        if (sGroupAlbumDownloadStrategy == null) {
            sGroupAlbumDownloadStrategy = new c();
        }
        c cVar = sGroupAlbumDownloadStrategy;
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }

    public final d b() {
        if (sIntimateDownloadStrategy == null) {
            sIntimateDownloadStrategy = new d();
        }
        d dVar = sIntimateDownloadStrategy;
        Intrinsics.checkNotNull(dVar);
        return dVar;
    }

    public final kc.c c() {
        if (sQZAlbumxDownloadQueueStrategy == null) {
            sQZAlbumxDownloadQueueStrategy = new kc.c();
        }
        kc.c cVar = sQZAlbumxDownloadQueueStrategy;
        Intrinsics.checkNotNull(cVar);
        return cVar;
    }
}
