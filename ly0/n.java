package ly0;

import com.tencent.icgame.game.userinfo.api.IUserInfo;
import com.tencent.icgame.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$BaseInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$MiniInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQGroupProInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQNearbyUserInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$QQUserInfo;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$UserGameOpenid;
import com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$UserRoomList;
import com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0014\u0010\u000b\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001d"}, d2 = {"Lly0/n;", "", "", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/icgame/trpc/yes/common/YesGameInfoOuterClass$GameConfigInfo;", "a", "Lqu0/b;", "Lcom/tencent/icgame/game/userinfo/api/IUserInfo;", "listener", "", "f", "i", "Lcom/tencent/icgame/trpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "info", "Lcom/tencent/icgame/game/userinfo/impl/db/UserInfoEntity;", "g", "", "d", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "e", "userId", "", tl.h.F, "", "c", "b", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f415773a = new n();

    n() {
    }

    private final YesGameInfoOuterClass$GameConfigInfo a(int gameId) {
        return null;
    }

    @NotNull
    public final String b(int gameId) {
        String str;
        PBStringField pBStringField;
        if (gameId == 0) {
            return "";
        }
        YesGameInfoOuterClass$GameConfigInfo a16 = a(gameId);
        if (a16 != null && (pBStringField = a16.game_helper_icon) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String c(int gameId) {
        String str;
        PBStringField pBStringField;
        if (gameId == 0) {
            return "";
        }
        YesGameInfoOuterClass$GameConfigInfo a16 = a(gameId);
        if (a16 != null && (pBStringField = a16.game_helper_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public final long d(@NotNull UserProxyCmdOuterClass$QQUserInfo info) {
        long j3;
        Intrinsics.checkNotNullParameter(info, "info");
        PBUInt64Field pBUInt64Field = info.yes_uid;
        long j16 = 0;
        if (pBUInt64Field != null) {
            j3 = pBUInt64Field.get();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            PBUInt64Field pBUInt64Field2 = info.uid;
            if (pBUInt64Field2 != null) {
                j16 = pBUInt64Field2.get();
            }
            return j16;
        }
        return j3;
    }

    public final long e(@Nullable CommonOuterClass$QQUserId qqUserId) {
        long j3;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        long j16 = 0;
        if (qqUserId != null && (pBUInt64Field2 = qqUserId.yes_uid) != null) {
            j3 = pBUInt64Field2.get();
        } else {
            j3 = 0;
        }
        if (j3 == 0) {
            if (qqUserId != null && (pBUInt64Field = qqUserId.uid) != null) {
                j16 = pBUInt64Field.get();
            }
            return j16;
        }
        return j3;
    }

    public final void f(@NotNull qu0.b<IUserInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        hy0.b.INSTANCE.a().a(listener);
    }

    @NotNull
    public final UserInfoEntity g(@NotNull UserProxyCmdOuterClass$QQUserInfo info) {
        byte[] bArr;
        byte[] bArr2;
        String str;
        String str2;
        byte[] bArr3;
        int i3;
        byte[] bArr4;
        byte[] bArr5;
        long j3;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        UserProxyCmdOuterClass$BaseInfo userProxyCmdOuterClass$BaseInfo;
        Intrinsics.checkNotNullParameter(info, "info");
        UserInfoEntity userInfoEntity = new UserInfoEntity();
        UserProxyCmdOuterClass$MiniInfo userProxyCmdOuterClass$MiniInfo = info.mini_info;
        byte[] bArr6 = null;
        if (userProxyCmdOuterClass$MiniInfo != null && (userProxyCmdOuterClass$BaseInfo = userProxyCmdOuterClass$MiniInfo.base_info) != null) {
            bArr = userProxyCmdOuterClass$BaseInfo.toByteArray();
        } else {
            bArr = null;
        }
        userInfoEntity.qqBaseInfo = bArr;
        UserProxyCmdOuterClass$UserGameOpenid userProxyCmdOuterClass$UserGameOpenid = info.game_openid;
        if (userProxyCmdOuterClass$UserGameOpenid != null) {
            bArr2 = userProxyCmdOuterClass$UserGameOpenid.toByteArray();
        } else {
            bArr2 = null;
        }
        userInfoEntity.userGameOpenid = bArr2;
        UserProxyCmdOuterClass$MiniInfo userProxyCmdOuterClass$MiniInfo2 = info.mini_info;
        if (userProxyCmdOuterClass$MiniInfo2 != null && (pBStringField2 = userProxyCmdOuterClass$MiniInfo2.avatar) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        userInfoEntity.extensionAvatar = str;
        UserProxyCmdOuterClass$MiniInfo userProxyCmdOuterClass$MiniInfo3 = info.mini_info;
        if (userProxyCmdOuterClass$MiniInfo3 != null && (pBStringField = userProxyCmdOuterClass$MiniInfo3.long_nick) != null) {
            str2 = pBStringField.get();
        } else {
            str2 = null;
        }
        userInfoEntity.extensionNick = str2;
        userInfoEntity.uid = d(info);
        UserProxyCmdOuterClass$QQGroupProInfo userProxyCmdOuterClass$QQGroupProInfo = info.group_pro_info;
        if (userProxyCmdOuterClass$QQGroupProInfo != null) {
            bArr3 = userProxyCmdOuterClass$QQGroupProInfo.toByteArray();
        } else {
            bArr3 = null;
        }
        userInfoEntity.groupProInfo = bArr3;
        PBInt32Field pBInt32Field = info.auth_status;
        if (pBInt32Field != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = 0;
        }
        userInfoEntity.authStatus = i3;
        GameRoleOuterClass$SmobaGameRoleInfo gameRoleOuterClass$SmobaGameRoleInfo = info.defaul_smoba_role;
        if (gameRoleOuterClass$SmobaGameRoleInfo != null) {
            bArr4 = gameRoleOuterClass$SmobaGameRoleInfo.toByteArray();
        } else {
            bArr4 = null;
        }
        userInfoEntity.defaultSmobaRoleExtInfo = bArr4;
        UserProxyCmdOuterClass$UserRoomList userProxyCmdOuterClass$UserRoomList = info.user_room_list;
        if (userProxyCmdOuterClass$UserRoomList != null) {
            bArr5 = userProxyCmdOuterClass$UserRoomList.toByteArray();
        } else {
            bArr5 = null;
        }
        userInfoEntity.userRoomList = bArr5;
        UserProxyCmdOuterClass$QQNearbyUserInfo userProxyCmdOuterClass$QQNearbyUserInfo = info.nearby_user_info;
        if (userProxyCmdOuterClass$QQNearbyUserInfo != null) {
            bArr6 = userProxyCmdOuterClass$QQNearbyUserInfo.toByteArray();
        }
        userInfoEntity.nearbyUserInfo = bArr6;
        PBUInt64Field pBUInt64Field = info.uid;
        if (pBUInt64Field != null) {
            j3 = pBUInt64Field.get();
        } else {
            j3 = 0;
        }
        userInfoEntity.qqUin = j3;
        return userInfoEntity;
    }

    public final boolean h(@Nullable CommonOuterClass$QQUserId userId, int gameId) {
        YesGameInfoOuterClass$GameConfigInfo a16;
        if (gameId == 0 || (a16 = a(gameId)) == null || userId == null) {
            return false;
        }
        if (userId.uid.get() != a16.game_helper_uid.get() && userId.yes_uid.get() != a16.game_helper_uid.get()) {
            return false;
        }
        return true;
    }

    public final void i(@NotNull qu0.b<IUserInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        hy0.b.INSTANCE.a().e(listener);
    }
}
