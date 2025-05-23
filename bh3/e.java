package bh3;

import bh3.a;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.download.api.IFileDownloadHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lbh3/e;", "Lbh3/a;", "Lbh3/d;", "task", "", "e", "b", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface e extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f28436a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lbh3/e$a;", "", "Lbh3/e;", "Lbh3/f;", "a", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bh3.e$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f28436a = new Companion();

        Companion() {
        }

        @NotNull
        public final f a(@NotNull e eVar) {
            Intrinsics.checkNotNullParameter(eVar, "<this>");
            return ((IFileDownloadHelper) QRoute.api(IFileDownloadHelper.class)).createFileDownloadListenerWrapper(eVar);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static boolean a(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            return false;
        }

        public static void b(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.a(eVar, task);
        }

        public static void c(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.b(eVar, task);
        }

        public static void d(@NotNull e eVar, @NotNull DownloadTask task, int i3, @Nullable String str) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.c(eVar, task, i3, str);
        }

        public static void e(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.d(eVar, task);
        }

        public static void f(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.e(eVar, task);
        }

        public static void g(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.f(eVar, task);
        }

        public static void h(@NotNull e eVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            a.C0128a.g(eVar, task);
        }
    }

    boolean e(@NotNull DownloadTask task);
}
