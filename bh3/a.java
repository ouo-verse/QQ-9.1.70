package bh3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lbh3/a;", "", "Lbh3/d;", "task", "", "c", "d", "b", "a", "", "errorCode", "", "errorMessage", "g", h.F, "f", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: bh3.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C0128a {
        public static void a(@NotNull a aVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void b(@NotNull a aVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void c(@NotNull a aVar, @NotNull DownloadTask task, int i3, @Nullable String str) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void d(@NotNull a aVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void e(@NotNull a aVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void f(@NotNull a aVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }

        public static void g(@NotNull a aVar, @NotNull DownloadTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
        }
    }

    void a(@NotNull DownloadTask task);

    void b(@NotNull DownloadTask task);

    void c(@NotNull DownloadTask task);

    void d(@NotNull DownloadTask task);

    void f(@NotNull DownloadTask task);

    void g(@NotNull DownloadTask task, int errorCode, @Nullable String errorMessage);

    void h(@NotNull DownloadTask task);
}
