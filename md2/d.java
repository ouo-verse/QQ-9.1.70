package md2;

import com.tencent.mobileqq.data.DateEventMsg;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.data.DatingRecentDetail;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return 113;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.dropSQLStatement(DatingInfo.class.getSimpleName()), TableBuilder.dropSQLStatement(DateEventMsg.class.getSimpleName()), TableBuilder.dropSQLStatement(DatingRecentDetail.class.getSimpleName())};
    }
}
