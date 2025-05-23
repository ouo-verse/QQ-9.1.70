package cg4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "", "a", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {
    public static final boolean a(@NotNull YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
        Intrinsics.checkNotNullParameter(yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, "<this>");
        if (yesGameInfoOuterClass$GetUserGameDefaultRoleRsp.role_info.area.get() > 0) {
            return true;
        }
        return false;
    }
}
