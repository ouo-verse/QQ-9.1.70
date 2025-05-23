package my0;

import com.tencent.icgame.game.userinfo.impl.db.role.UserDefaultRoleEntity;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ly0.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000b\u0010\fJ!\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011\u00a8\u0006\u0016"}, d2 = {"Lmy0/h;", "", "Lcom/tencent/icgame/game/userinfo/impl/db/role/UserDefaultRoleEntity;", "entity", "Ley0/c;", "d", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "", VirtualAppProxy.KEY_GAME_ID, "", "a", "(Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;Ljava/lang/Integer;)Ljava/lang/String;", "", "uid", "b", "(Ljava/lang/Long;Ljava/lang/Integer;)Ljava/lang/String;", "Lcom/tencent/icgame/trpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "userDefaultRole", "c", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f417777a = new h();

    h() {
    }

    @NotNull
    public final String a(@NotNull CommonOuterClass$QQUserId qqUserId, @Nullable Integer gameId) {
        Intrinsics.checkNotNullParameter(qqUserId, "qqUserId");
        return b(Long.valueOf(n.f415773a.e(qqUserId)), gameId);
    }

    @NotNull
    public final String b(@Nullable Long uid, @Nullable Integer gameId) {
        String str;
        if (uid != null) {
            str = uid.toString();
        } else {
            str = null;
        }
        return str + "_" + gameId;
    }

    @NotNull
    public final UserDefaultRoleEntity c(int gameId, @NotNull GameDataServerOuterClass$UserDefaultRole userDefaultRole) {
        Intrinsics.checkNotNullParameter(userDefaultRole, "userDefaultRole");
        UserDefaultRoleEntity userDefaultRoleEntity = new UserDefaultRoleEntity();
        userDefaultRoleEntity.uid = n.f415773a.e(userDefaultRole.user_id);
        userDefaultRoleEntity.gameId = gameId;
        userDefaultRoleEntity.defaultRoleInfo = userDefaultRole.toByteArray();
        userDefaultRoleEntity.qqUin = userDefaultRole.user_id.uid.get();
        return userDefaultRoleEntity;
    }

    @NotNull
    public final ey0.c d(@NotNull UserDefaultRoleEntity entity) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        return new gy0.d(entity);
    }
}
