package ly0;

import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$BaseInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQGroupProInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQNearbyUserInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$UserGameOpenid;
import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000e"}, d2 = {"Lly0/l;", "", "Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;", "entity", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "a", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "d", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "c", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQNearbyUserInfo;", "b", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f415771a = new l();

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
                com.tencent.icgame.game.utils.g.d("ICGameUserInfoEntityUtil_", "convertToBaseInfo error " + e16);
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
                com.tencent.icgame.game.utils.g.d("ICGameUserInfoEntityUtil_", "convertToQQNearbyUserInfo error " + e16);
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
                com.tencent.icgame.game.utils.g.d("ICGameUserInfoEntityUtil_", "convertToQQGroupProInfo error " + e16);
            }
        }
        return userProxyCmdOuterClass$QQGroupProInfo;
    }

    @Nullable
    public final UserProxyCmdOuterClass$UserGameOpenid d(@Nullable UserInfoEntity entity) {
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
                com.tencent.icgame.game.utils.g.d("ICGameUserInfoEntityUtil_", "convertToUserGameOpenid error " + e16);
            }
        }
        return userProxyCmdOuterClass$UserGameOpenid;
    }
}
