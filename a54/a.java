package a54;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"La54/a;", "", "", "robotUin", "", "b", "c", "a", "troopUin", WadlProxyConsts.EXTRA_DATA, "d", "e", "f", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: a54.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static final class C0013a {
        public static void a(@NotNull a aVar, @NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        }

        public static void b(@NotNull a aVar, @NotNull String robotUin, @NotNull String troopUin, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        }

        public static void c(@NotNull a aVar, @NotNull String robotUin, @NotNull String troopUin, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        }

        public static void d(@NotNull a aVar, @NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        }

        public static void e(@NotNull a aVar, @NotNull String robotUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        }

        public static void f(@NotNull a aVar, @NotNull String robotUin, @NotNull String troopUin) {
            Intrinsics.checkNotNullParameter(robotUin, "robotUin");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        }
    }

    void a(@NotNull String robotUin);

    void b(@NotNull String robotUin);

    void c(@NotNull String robotUin);

    void d(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData);

    void e(@NotNull String robotUin, @NotNull String troopUin, @Nullable Object extraData);

    void f(@NotNull String robotUin, @NotNull String troopUin);
}
