package io4;

import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass$BaseInfo;
import trpc.yes.common.UserProxyCmdOuterClass$QQGroupProInfo;
import trpc.yes.common.UserProxyCmdOuterClass$QQNearbyUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass$UserGameOpenid;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0010"}, d2 = {"Lio4/l;", "", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "entity", "Ltrpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "a", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "e", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "c", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "b", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "d", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f408121a = new l();

    l() {
    }

    @Nullable
    public final UserProxyCmdOuterClass$BaseInfo a(@Nullable UserInfoEntity entity) {
        byte[] bArr;
        UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo = null;
        if (entity != null) {
            bArr = entity.qqBaseInfo;
        } else {
            bArr = null;
        }
        if (bArr != null) {
            userProxyCmdOuterClass$BaseInfo = new UserProxyCmdOuterClass$BaseInfo();
            try {
                userProxyCmdOuterClass$BaseInfo.mergeFrom(bArr);
            } catch (IOException e16) {
                com.tencent.timi.game.utils.l.e("UserInfoEntityUtil_", "convertToBaseInfo error " + e16);
            }
        }
        return userProxyCmdOuterClass$BaseInfo;
    }

    @Nullable
    public final UserProxyCmdOuterClass$QQNearbyUserInfo b(@Nullable UserInfoEntity entity) {
        byte[] bArr;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = null;
        if (entity != null) {
            bArr = entity.nearbyUserInfo;
        } else {
            bArr = null;
        }
        if (bArr != null) {
            userProxyCmdOuterClass$QQNearbyUserInfo = new UserProxyCmdOuterClass$QQNearbyUserInfo();
            try {
                userProxyCmdOuterClass$QQNearbyUserInfo.mergeFrom(bArr);
            } catch (IOException e16) {
                com.tencent.timi.game.utils.l.e("UserInfoEntityUtil_", "convertToQQNearbyUserInfo error " + e16);
            }
        }
        return userProxyCmdOuterClass$QQNearbyUserInfo;
    }

    @Nullable
    public final UserProxyCmdOuterClass$QQGroupProInfo c(@Nullable UserInfoEntity entity) {
        byte[] bArr;
        UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = null;
        if (entity != null) {
            bArr = entity.groupProInfo;
        } else {
            bArr = null;
        }
        if (bArr != null) {
            userProxyCmdOuterClass$QQGroupProInfo = new UserProxyCmdOuterClass$QQGroupProInfo();
            try {
                userProxyCmdOuterClass$QQGroupProInfo.mergeFrom(bArr);
            } catch (IOException e16) {
                com.tencent.timi.game.utils.l.e("UserInfoEntityUtil_", "convertToQQGroupProInfo error " + e16);
            }
        }
        return userProxyCmdOuterClass$QQGroupProInfo;
    }

    @Nullable
    public final GameRoleOuterClass$SmobaGameRoleInfo d(@Nullable UserInfoEntity entity) {
        byte[] bArr;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = null;
        if (entity != null) {
            bArr = entity.defaultSmobaRoleExtInfo;
        } else {
            bArr = null;
        }
        if (bArr != null) {
            gameRoleOuterClass$SmobaGameRoleInfo = new GameRoleOuterClass$SmobaGameRoleInfo();
            try {
                gameRoleOuterClass$SmobaGameRoleInfo.mergeFrom(bArr);
            } catch (IOException e16) {
                com.tencent.timi.game.utils.l.e("UserInfoEntityUtil_", "convertToSmobaGameRoleExtInfo error " + e16);
            }
        }
        return gameRoleOuterClass$SmobaGameRoleInfo;
    }

    @Nullable
    public final UserProxyCmdOuterClass$UserGameOpenid e(@Nullable UserInfoEntity entity) {
        byte[] bArr;
        UserProxyCmdOuterClass$UserGameOpenid userProxyCmdOuterClass$UserGameOpenid = null;
        if (entity != null) {
            bArr = entity.userGameOpenid;
        } else {
            bArr = null;
        }
        if (bArr != null) {
            userProxyCmdOuterClass$UserGameOpenid = new UserProxyCmdOuterClass$UserGameOpenid();
            try {
                userProxyCmdOuterClass$UserGameOpenid.mergeFrom(bArr);
            } catch (IOException e16) {
                com.tencent.timi.game.utils.l.e("UserInfoEntityUtil_", "convertToUserGameOpenid error " + e16);
            }
        }
        return userProxyCmdOuterClass$UserGameOpenid;
    }
}
