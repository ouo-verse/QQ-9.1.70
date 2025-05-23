package pb3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"Lpb3/a;", "", "", "curCount", "", "onDownloadCountChanged", "curDownloadingCount", "onDownloadingCountChanged", "", "id", "onTaskDelete", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    void onDownloadCountChanged(int curCount);

    void onDownloadingCountChanged(int curDownloadingCount);

    void onTaskDelete(@NotNull String id5);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: pb3.a$a, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C10996a {
        public static void c(@NotNull a aVar, @NotNull String id5) {
            Intrinsics.checkNotNullParameter(id5, "id");
        }

        public static void a(@NotNull a aVar, int i3) {
        }

        public static void b(@NotNull a aVar, int i3) {
        }
    }
}
