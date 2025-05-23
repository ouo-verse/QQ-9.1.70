package md2;

import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class l implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 217;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(TroopAIOAppInfo.class))};
    }
}
