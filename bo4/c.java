package bo4;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0005H&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\r\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lbo4/c;", "", "", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAchievement;", "b", "", "d", "c", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "id", "", "e", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public interface c {
    long a();

    @NotNull
    List<YesGameInfoOuterClass$YesGameRoleAchievement> b();

    @NotNull
    String c();

    @NotNull
    String d();

    boolean e(@Nullable CommonOuterClass$QQUserId id5);
}
