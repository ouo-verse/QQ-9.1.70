package com.tencent.mobileqq.troopmanage.component;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi;
import com.tencent.mobileqq.troopmanage.api.ITroopManageService;
import com.tencent.mobileqq.troopmanage.base.TroopManagerHandler;
import com.tencent.pb.troop.intelligentmanage.IntelligentManageSvrPB$GetManagePageRsp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R(\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/ap;", "", "", "troopUin", "", "c", "", "Lcom/tencent/mobileqq/troopmanage/model/a;", "b", "", "Ljava/util/Map;", "uin2DataMap", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ap {

    /* renamed from: a, reason: collision with root package name */
    public static final ap f303070a = new ap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<com.tencent.mobileqq.troopmanage.model.a>> uin2DataMap = new LinkedHashMap();

    ap() {
    }

    public final List<com.tencent.mobileqq.troopmanage.model.a> b(String troopUin) {
        if (troopUin == null || troopUin.length() == 0) {
            return null;
        }
        return uin2DataMap.get(troopUin);
    }

    public final void c(String troopUin) {
        if (troopUin == null || troopUin.length() == 0) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        TroopManagerHandler troopManageHandler = ((ITroopManageService) qQAppInterface.getRuntimeService(ITroopManageService.class, "")).getTroopManageHandler();
        Intrinsics.checkNotNullExpressionValue(troopManageHandler, "app.getRuntimeService(IT\u2026.MAIN).troopManageHandler");
        ((ITroopIntelligentManageApi) QRoute.api(ITroopIntelligentManageApi.class)).getIntelligentSettingItem(troopUin, new a(troopUin, troopManageHandler));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troopmanage/component/ap$a", "Lcom/tencent/mobileqq/troop/troopmanager/api/ITroopIntelligentManageApi$d;", "", "isSuccess", "Lcom/tencent/pb/troop/intelligentmanage/IntelligentManageSvrPB$GetManagePageRsp;", "resp", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ITroopIntelligentManageApi.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f303072a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TroopManagerHandler f303073b;

        a(String str, TroopManagerHandler troopManagerHandler) {
            this.f303072a = str;
            this.f303073b = troopManagerHandler;
        }

        @Override // com.tencent.mobileqq.troop.troopmanager.api.ITroopIntelligentManageApi.d
        public void a(boolean isSuccess, IntelligentManageSvrPB$GetManagePageRsp resp) {
            if (!isSuccess || resp == null) {
                return;
            }
            Map map = ap.uin2DataMap;
            String str = this.f303072a;
            map.put(str, this.f303073b.T2(str, resp));
        }
    }
}
