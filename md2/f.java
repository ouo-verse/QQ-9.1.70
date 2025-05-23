package md2;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes16.dex */
public class f implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 137;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.dropSQLStatement(MessageRecord.getTableName(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0))};
    }
}
