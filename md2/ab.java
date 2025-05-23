package md2;

import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.mobileqq.search.searchlocal.model.SearchHistory;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ab implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 67;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.createSQLStatement(new SearchHistory())};
    }
}
