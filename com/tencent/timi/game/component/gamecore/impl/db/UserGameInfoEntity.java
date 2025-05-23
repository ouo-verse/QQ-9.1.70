package com.tencent.timi.game.component.gamecore.impl.db;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ll4.a;
import mm4.b;
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uin,yesGameId")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/db/UserGameInfoEntity;", "Lcom/tencent/timi/game/databasecore/impl/base/BaseTimiGameEntity;", "", "toString", "uin", "Ljava/lang/String;", "", "yesGameId", "I", "", "defaultAccountInfo", "[B", "accountListInfo", "authDescInfo", "<init>", "()V", "Companion", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class UserGameInfoEntity extends BaseTimiGameEntity {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @Nullable
    public byte[] accountListInfo;

    @JvmField
    @Nullable
    public byte[] authDescInfo;

    @JvmField
    @Nullable
    public byte[] defaultAccountInfo;

    @JvmField
    @NotNull
    public String uin = "";

    @JvmField
    public int yesGameId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/db/UserGameInfoEntity$a;", "", "", "yesGameId", "Lcom/tencent/timi/game/component/gamecore/impl/db/UserGameInfoEntity;", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.component.gamecore.impl.db.UserGameInfoEntity$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UserGameInfoEntity a(int yesGameId) {
            UserGameInfoEntity userGameInfoEntity = new UserGameInfoEntity();
            userGameInfoEntity.yesGameId = yesGameId;
            String B = ((a) b.b(a.class)).B();
            Intrinsics.checkNotNullExpressionValue(B, "getService(ILoginCoreSer\u2026:class.java).userIdString");
            userGameInfoEntity.uin = B;
            return userGameInfoEntity;
        }

        Companion() {
        }
    }

    @NotNull
    public String toString() {
        return "uin:" + LogUtil.getSafePrintUin(this.uin) + ", gameId:" + this.yesGameId + " defaultAccountInfo:" + this.defaultAccountInfo + ", accountListInfo:" + this.accountListInfo + ", authDescInfo:" + this.authDescInfo;
    }
}
