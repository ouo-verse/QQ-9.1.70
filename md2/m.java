package md2;

import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PushRecommend;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes16.dex */
public class m implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 233;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowRecommend.class)), TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(PushRecommend.class)), TableBuilder.dropSQLStatement(TableBuilder.getTableNameSafe(MayKnowExposure.class))};
    }
}
