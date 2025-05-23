package md2;

import com.tencent.mobileqq.app.qqdaily.FrontBackData;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes16.dex */
public class s implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 300;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.createSQLStatement(new FrontBackData())};
    }
}
