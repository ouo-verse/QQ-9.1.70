package com.tencent.troopguild;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
final class TroopGuildInfoListProcessor$onGetTroopListWithDetail$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AppInterface $app;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopGuildInfoListProcessor$onGetTroopListWithDetail$1(AppInterface appInterface) {
        super(0);
        this.$app = appInterface;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AppInterface app) {
        Intrinsics.checkNotNullParameter(app, "$app");
        QLog.i("TroopGuildInfoListProcessor", 1, "TroopGuildInfoListProcessor.onGetTroopList delay task run.");
        HashSet hashSet = new HashSet();
        Iterator<T> it = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache().iterator();
        while (it.hasNext()) {
            hashSet.add(((TroopInfo) it.next()).getTroopUin());
        }
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            List<IGProGuildInfo> groupGuildList = ((IGPSService) app.getRuntimeService(IGPSService.class, "")).getGroupGuildList();
            if (groupGuildList != null) {
                QLog.i("TroopGuildInfoListProcessor", 1, "clearGuildRelatedData groupGuildList size: " + groupGuildList.size());
                for (IGProGuildInfo it5 : groupGuildList) {
                    if (it5 != null) {
                        Intrinsics.checkNotNullExpressionValue(it5, "it");
                        if (it5.getGroupId() != 0 && !hashSet.contains(String.valueOf(it5.getGroupId()))) {
                            String guildID = it5.getGuildID();
                            Intrinsics.checkNotNullExpressionValue(guildID, "guildID");
                            arrayList.add(Long.valueOf(Long.parseLong(guildID)));
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("TroopGuildInfoListProcessor", 1, "clearGuildRelatedData e: " + e16);
        }
        if (!arrayList.isEmpty()) {
            ((IGPSService) app.getRuntimeService(IGPSService.class, "")).clearGuildRelatedData(arrayList);
            QLog.i("TroopGuildInfoListProcessor", 1, "clearGuildRelatedData delGuildIds: " + arrayList);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final AppInterface appInterface = this.$app;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.troopguild.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopGuildInfoListProcessor$onGetTroopListWithDetail$1.b(AppInterface.this);
            }
        }, 16, null, false);
    }
}
