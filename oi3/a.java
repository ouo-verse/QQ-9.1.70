package oi3;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u0000 \u00072\u00020\u0001:\u0001\tB\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H&R\"\u0010\u000e\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0011\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Loi3/a;", "", "", "d", "", "", "extra", "c", "Lal0/a;", "a", "Lal0/a;", "()Lal0/a;", "setDownloadSo", "(Lal0/a;)V", "downloadSo", "b", "e", "loadSo", "<init>", "(Lal0/a;Lal0/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private al0.a downloadSo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private al0.a loadSo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003J\n\u0010\b\u001a\u00020\u0007*\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Loi3/a$a;", "", "Lal0/a;", "", "key", "Lkotlin/Pair;", "b", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: oi3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(al0.a aVar) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            aVar.l(0L);
            aVar.i(0L);
            aVar.m(true);
            aVar.j(0);
            aVar.k(null);
        }

        public final Pair<String, String> b(al0.a aVar, String key) {
            Intrinsics.checkNotNullParameter(aVar, "<this>");
            Intrinsics.checkNotNullParameter(key, "key");
            return new Pair<>(key, String.valueOf(aVar.f()));
        }

        Companion() {
        }
    }

    public a(al0.a downloadSo, al0.a loadSo) {
        Intrinsics.checkNotNullParameter(downloadSo, "downloadSo");
        Intrinsics.checkNotNullParameter(loadSo, "loadSo");
        this.downloadSo = downloadSo;
        this.loadSo = loadSo;
    }

    /* renamed from: a, reason: from getter */
    public al0.a getDownloadSo() {
        return this.downloadSo;
    }

    /* renamed from: b, reason: from getter */
    public al0.a getLoadSo() {
        return this.loadSo;
    }

    public abstract void c(Map<String, String> extra);

    public void d() {
        Companion companion = INSTANCE;
        companion.a(getDownloadSo());
        companion.a(getLoadSo());
    }

    public void e(al0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.loadSo = aVar;
    }

    public /* synthetic */ a(al0.a aVar, al0.a aVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new al0.a(0L, 0L, false, 0, null, 31, null) : aVar, (i3 & 2) != 0 ? new al0.a(0L, 0L, false, 0, null, 31, null) : aVar2);
    }
}
