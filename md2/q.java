package md2;

import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes16.dex */
public class q implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return FilterEnum.MIC_PTU_BAIXI;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.createSQLStatement(new ColorNote())};
    }
}
