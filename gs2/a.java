package gs2;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troopguild.api.ITroopUpgradeUtilsApi;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a extends com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a {
    public a(QQAppInterface qQAppInterface, String str) {
        super(qQAppInterface, str);
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public String c() {
        return "TroopUpgradeRedDotProcessor";
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void d() {
        if (this.f298278b == null || TextUtils.isEmpty(this.f298277a)) {
            return;
        }
        ITroopUpgradeUtilsApi iTroopUpgradeUtilsApi = (ITroopUpgradeUtilsApi) QRoute.api(ITroopUpgradeUtilsApi.class);
        if (!iTroopUpgradeUtilsApi.hasTouchRedDotOfTroopUpgrade(this.f298277a) && iTroopUpgradeUtilsApi.shouldShowTroopUpgradeSetting(this.f298278b, this.f298277a)) {
            QLog.d("TroopUpgradeRedDotProcessor", 1, "initTroopSettingRedPointInfo | updateRedPointInfo");
            ((IRedPointUtilsApi) QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(this.f298278b, this.f298277a, "troop", 6, 1);
        }
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void b() {
        this.f298278b = null;
    }

    @Override // com.tencent.mobileqq.troop.redpoint.troopsettingredpoint.a
    public void a() {
    }
}
