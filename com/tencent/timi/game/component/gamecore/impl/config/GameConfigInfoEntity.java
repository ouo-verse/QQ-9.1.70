package com.tencent.timi.game.component.gamecore.impl.config;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.timi.game.utils.l;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "yesGameId")
/* loaded from: classes26.dex */
public class GameConfigInfoEntity extends BaseTimiGameEntity {
    public byte[] fullData;
    public String gameName;
    public String gameScheme;
    public String pkgName;
    public int roomType;
    public int yesGameId;

    public YesGameInfoOuterClass$GameConfigInfo getGameConfigInfo() {
        if (this.fullData != null) {
            try {
                return new YesGameInfoOuterClass$GameConfigInfo().mergeFrom(this.fullData);
            } catch (Exception e16) {
                l.f("GameConfigInfoEntity", "getGameConfigInfo error", e16);
                return null;
            }
        }
        return null;
    }

    public void saveInfo(YesGameInfoOuterClass$GameConfigInfo yesGameInfoOuterClass$GameConfigInfo) {
        if (yesGameInfoOuterClass$GameConfigInfo != null) {
            this.yesGameId = yesGameInfoOuterClass$GameConfigInfo.game_id.get();
            this.gameName = yesGameInfoOuterClass$GameConfigInfo.game_name.get();
            this.roomType = yesGameInfoOuterClass$GameConfigInfo.game_room_type.get();
            this.pkgName = yesGameInfoOuterClass$GameConfigInfo.game_package_name.get();
            this.gameScheme = yesGameInfoOuterClass$GameConfigInfo.game_adr_scheme.get();
            this.fullData = yesGameInfoOuterClass$GameConfigInfo.toByteArray();
        }
    }

    public String toString() {
        return "GameConfigInfoEntity{yesGameId='" + this.yesGameId + "', gameName=" + this.gameName + ", roomType='" + this.roomType + ", pkgName='" + this.pkgName + ", gameScheme='" + this.gameScheme + '}';
    }
}
