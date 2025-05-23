package md2;

import com.tencent.commonsdk.util.notification.NotificationUtil;
import com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.persistence.TableBuilder;

/* compiled from: P */
/* loaded from: classes16.dex */
public class y implements DBUpgradeEntity {
    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public int maxVersion() {
        return NotificationUtil.Constants.NOTIFY_ID_UNIFORM_DOWNLOAD_END;
    }

    @Override // com.tencent.mobileqq.data.entitymanager.upgrade.DBUpgradeEntity
    public String[] sqlStatement() {
        return new String[]{TableBuilder.dropSQLStatement(QQMiniManager.getDeskTopAppEntityClass().getSimpleName()), TableBuilder.createSQLStatement(QQMiniManager.createDeskTopAppEntity())};
    }
}
