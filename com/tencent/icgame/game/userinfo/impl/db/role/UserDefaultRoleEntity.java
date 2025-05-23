package com.tencent.icgame.game.userinfo.impl.db.role;

import androidx.annotation.NonNull;
import com.tencent.icgame.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import my0.h;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid,gameId")
/* loaded from: classes7.dex */
public class UserDefaultRoleEntity extends BaseTimiGameEntity {
    public byte[] defaultRoleInfo;
    public long qqUin;
    public long uid = 0;
    public int gameId = 0;

    public String acquireKey() {
        return h.f417777a.b(Long.valueOf(this.uid), Integer.valueOf(this.gameId));
    }

    @NonNull
    public String toString() {
        return "UserDefaultRoleEntity{, uid=" + g.i(this.uid) + ", gameId=" + this.gameId + '}';
    }
}
