package com.tencent.timi.game.userinfo.impl.db.role;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.timi.game.utils.l;
import jo4.h;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid,gameId")
/* loaded from: classes26.dex */
public class UserDefaultRoleEntity extends BaseTimiGameEntity {
    public byte[] defaultRoleInfo;
    public long qqUin;
    public long uid = 0;
    public int gameId = 0;

    public String acquireKey() {
        return h.f410758a.a(Long.valueOf(this.uid), Integer.valueOf(this.gameId));
    }

    @NonNull
    public String toString() {
        return "UserDefaultRoleEntity{, uid=" + l.j(this.uid) + ", gameId=" + this.gameId + '}';
    }
}
