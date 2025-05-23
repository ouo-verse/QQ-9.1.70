package com.tencent.timi.game.userinfo.impl.db;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import java.util.Arrays;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "uid")
/* loaded from: classes26.dex */
public class UserInfoEntity extends BaseTimiGameEntity {
    public int authStatus;
    public byte[] defaultSmobaRoleExtInfo;
    public String extensionAvatar;
    public String extensionNick;
    public byte[] groupProInfo;
    public byte[] nearbyUserInfo;
    public byte[] qqBaseInfo;
    public long qqUin;
    public long uid = 0;
    public byte[] userGameOpenid;
    public byte[] userRoomList;

    @NonNull
    public String toString() {
        return "UserInfoEntity{, qqBaseInfo=" + Arrays.toString(this.qqBaseInfo) + ", userGameOpenid=" + Arrays.toString(this.userGameOpenid) + ", extensionAvatar='" + this.extensionAvatar + "', extensionNick=" + this.extensionNick + '}';
    }
}
