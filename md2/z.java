package md2;

import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes16.dex */
public class z implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 41;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.dropSQLStatement(Card.class.getSimpleName()), TableBuilder.createSQLStatement(new Card()), TableBuilder.dropSQLStatement(ResourcePluginInfo.class.getSimpleName()), TableBuilder.createSQLStatement(new ResourcePluginInfo())};
    }
}
