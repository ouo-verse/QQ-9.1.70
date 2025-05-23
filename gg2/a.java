package gg2;

import com.tencent.ecommerce.biz.qtroop.api.IECQTroopServiceApi;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import si0.ECTroopInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lgg2/a;", "Lcom/tencent/ecommerce/biz/qtroop/api/IECQTroopServiceApi;", "", "Lsi0/a;", "getTroopList", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECQTroopServiceApi {
    @Override // com.tencent.ecommerce.biz.qtroop.api.IECQTroopServiceApi
    public List<ECTroopInfo> getTroopList() {
        try {
            QRouteApi api = QRoute.api(ITroopAvatarUtilApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(ITroopAvatarUtilApi::class.java)");
            ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) api;
            ArrayList arrayList = new ArrayList();
            for (TroopInfo troopInfo : ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache()) {
                Intrinsics.checkNotNull(troopInfo, "null cannot be cast to non-null type com.tencent.mobileqq.data.troop.TroopInfo");
                String troopUin = troopInfo.getTroopUin();
                String troopHeadUrl = iTroopAvatarUtilApi.getAvatarAddress("", troopUin, 0);
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                String str = troopInfo.troopname;
                Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopname");
                Intrinsics.checkNotNullExpressionValue(troopHeadUrl, "troopHeadUrl");
                arrayList.add(new ECTroopInfo(troopUin, str, troopHeadUrl, troopInfo.extDBInfo.troopType));
            }
            QLog.i("ECQTroopServiceImpl", 1, "[getTroopList] ecTroopList size = " + arrayList.size());
            return arrayList;
        } catch (Exception e16) {
            QLog.e("ECQTroopServiceImpl", 1, "[getTroopList] excaption = " + e16);
            return new ArrayList();
        }
    }
}
