package gy0;

import com.tencent.icgame.game.userinfo.impl.db.role.UserDefaultRoleEntity;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.icgame.trpc.yes.common.GameDataServerOuterClass$UserDefaultRole;
import com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$SmobaExtInfo;
import com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAchievement;
import com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$YesGameRoleInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lgy0/d;", "Ley0/c;", "", "id", "", "g", "", "f", "", "Lcom/tencent/icgame/trpc/yes/common/YesGameInfoOuterClass$YesGameRoleAchievement;", "b", "", "d", "c", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "qqUserId", "e", "a", "Lcom/tencent/icgame/game/userinfo/impl/db/role/UserDefaultRoleEntity;", "Lcom/tencent/icgame/game/userinfo/impl/db/role/UserDefaultRoleEntity;", "getEntity", "()Lcom/tencent/icgame/game/userinfo/impl/db/role/UserDefaultRoleEntity;", "setEntity", "(Lcom/tencent/icgame/game/userinfo/impl/db/role/UserDefaultRoleEntity;)V", "entity", "Lcom/tencent/icgame/trpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "Lcom/tencent/icgame/trpc/yes/common/GameDataServerOuterClass$UserDefaultRole;", "userDefaultRole", "<init>", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class d implements ey0.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UserDefaultRoleEntity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameDataServerOuterClass$UserDefaultRole userDefaultRole;

    public d(@Nullable UserDefaultRoleEntity userDefaultRoleEntity) {
        this.entity = userDefaultRoleEntity;
        f();
    }

    private final void f() {
        byte[] bArr;
        if (this.userDefaultRole == null) {
            UserDefaultRoleEntity userDefaultRoleEntity = this.entity;
            if (userDefaultRoleEntity != null) {
                bArr = userDefaultRoleEntity.defaultRoleInfo;
            } else {
                bArr = null;
            }
            if (bArr != null) {
                GameDataServerOuterClass$UserDefaultRole gameDataServerOuterClass$UserDefaultRole = new GameDataServerOuterClass$UserDefaultRole();
                try {
                    gameDataServerOuterClass$UserDefaultRole.mergeFrom(bArr);
                    this.userDefaultRole = gameDataServerOuterClass$UserDefaultRole;
                } catch (IOException e16) {
                    g.d("UserDefaultRoleInfo", "initUserDefaultRole error " + e16);
                }
            }
        }
    }

    private final boolean g(long id5) {
        boolean z16;
        boolean z17;
        if (id5 == 0) {
            return false;
        }
        UserDefaultRoleEntity userDefaultRoleEntity = this.entity;
        if (userDefaultRoleEntity != null && id5 == userDefaultRoleEntity.uid) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (userDefaultRoleEntity != null && id5 == userDefaultRoleEntity.qqUin) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return false;
            }
        }
        return true;
    }

    @Override // ey0.c
    public long a() {
        UserDefaultRoleEntity userDefaultRoleEntity = this.entity;
        if (userDefaultRoleEntity != null) {
            return userDefaultRoleEntity.qqUin;
        }
        return 0L;
    }

    @Override // ey0.c
    @NotNull
    public List<YesGameInfoOuterClass$YesGameRoleAchievement> b() {
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        YesGameInfoOuterClass$SmobaExtInfo yesGameInfoOuterClass$SmobaExtInfo;
        PBRepeatMessageField<YesGameInfoOuterClass$YesGameRoleAchievement> pBRepeatMessageField;
        List<YesGameInfoOuterClass$YesGameRoleAchievement> list;
        ArrayList arrayList = new ArrayList();
        GameDataServerOuterClass$UserDefaultRole gameDataServerOuterClass$UserDefaultRole = this.userDefaultRole;
        if (gameDataServerOuterClass$UserDefaultRole != null && (yesGameInfoOuterClass$YesGameRoleInfo = gameDataServerOuterClass$UserDefaultRole.game_role_info) != null && (yesGameInfoOuterClass$SmobaExtInfo = yesGameInfoOuterClass$YesGameRoleInfo.smoba_ext_info) != null && (pBRepeatMessageField = yesGameInfoOuterClass$SmobaExtInfo.role_achievement) != null && (list = pBRepeatMessageField.get()) != null) {
            for (YesGameInfoOuterClass$YesGameRoleAchievement it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(it);
            }
        }
        return arrayList;
    }

    @Override // ey0.c
    @NotNull
    public String c() {
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        String str;
        GameDataServerOuterClass$UserDefaultRole gameDataServerOuterClass$UserDefaultRole = this.userDefaultRole;
        if (gameDataServerOuterClass$UserDefaultRole == null || (yesGameInfoOuterClass$YesGameRoleInfo = gameDataServerOuterClass$UserDefaultRole.game_role_info) == null) {
            return "";
        }
        PBStringField pBStringField = yesGameInfoOuterClass$YesGameRoleInfo.grade_icon;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "it.grade_icon?.get() ?: \"\"");
        return str;
    }

    @Override // ey0.c
    @NotNull
    public String d() {
        String str;
        YesGameInfoOuterClass$YesGameRoleInfo yesGameInfoOuterClass$YesGameRoleInfo;
        PBStringField pBStringField;
        GameDataServerOuterClass$UserDefaultRole gameDataServerOuterClass$UserDefaultRole = this.userDefaultRole;
        if (gameDataServerOuterClass$UserDefaultRole != null && (yesGameInfoOuterClass$YesGameRoleInfo = gameDataServerOuterClass$UserDefaultRole.game_role_info) != null && (pBStringField = yesGameInfoOuterClass$YesGameRoleInfo.role_name) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // ey0.c
    public boolean e(@Nullable CommonOuterClass$QQUserId qqUserId) {
        long j3;
        PBUInt64Field pBUInt64Field;
        PBUInt64Field pBUInt64Field2;
        long j16 = 0;
        if (qqUserId != null && (pBUInt64Field2 = qqUserId.uid) != null) {
            j3 = pBUInt64Field2.get();
        } else {
            j3 = 0;
        }
        if (!g(j3)) {
            if (qqUserId != null && (pBUInt64Field = qqUserId.yes_uid) != null) {
                j16 = pBUInt64Field.get();
            }
            if (!g(j16)) {
                return false;
            }
        }
        return true;
    }
}
