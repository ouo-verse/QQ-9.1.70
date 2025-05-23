package com.tencent.qqnt.pluspanel.data.loader;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qidian.QidianManager;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import com.tencent.qqnt.pluspanel.utils.a;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012JB\u0010\t\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006`\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002JD\u0010\r\u001a.\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00060\u0005j\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006`\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/loader/b;", "Lcom/tencent/qqnt/pluspanel/data/loader/d;", "", "", "list", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Landroid/os/Bundle;", "Lkotlin/collections/ArrayList;", "c", "", "curId", "curType", "a", "appID", "Lcom/tencent/qqnt/pluspanel/data/b;", "b", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b implements d {
    private final ArrayList<Pair<Integer, Bundle>> c(List<Integer> list) {
        ArrayList<Pair<Integer, Bundle>> arrayList = new ArrayList<>();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new Pair<>(Integer.valueOf(((Number) it.next()).intValue()), null));
        }
        return arrayList;
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    public ArrayList<Pair<Integer, Bundle>> a(String curId, int curType) {
        List<Integer> listOf;
        Boolean isBuddy;
        Intrinsics.checkNotNullParameter(curId, "curId");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{1104651886, 1106658188, 1104864066});
        m b16 = com.tencent.qqnt.msg.f.b();
        boolean booleanValue = (b16 == null || (isBuddy = b16.isBuddy(curId)) == null) ? false : isBuddy.booleanValue();
        if (!booleanValue) {
            return c(listOf);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return c(listOf);
        }
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        String uinFromUid = iRelationNTUinAndUidApi != null ? iRelationNTUinAndUidApi.getUinFromUid(curId) : null;
        QidianManager qidianManager = (QidianManager) peekAppRuntime.getManager(QQManagerFactory.QIDIAN_MANAGER);
        boolean L = qidianManager != null ? qidianManager.L(uinFromUid) : false;
        com.tencent.xaction.log.b.a("CRMAppLoaderInjector", 1, "[fillAppList] uid=" + curId + " uin=" + uinFromUid + " isBuddy=" + booleanValue + " isQidianExt=" + L);
        if (L) {
            a.Companion companion = com.tencent.qqnt.pluspanel.utils.a.INSTANCE;
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(companion.x()), Integer.valueOf(companion.y()), Integer.valueOf(companion.A()), Integer.valueOf(companion.s()), Integer.valueOf(companion.u()), Integer.valueOf(companion.q()), Integer.valueOf(companion.t()), Integer.valueOf(companion.F()), Integer.valueOf(companion.p()), Integer.valueOf(companion.g0()), Integer.valueOf(companion.J()), Integer.valueOf(companion.l()), Integer.valueOf(companion.r()), Integer.valueOf(companion.I())});
        }
        return c(listOf);
    }

    @Override // com.tencent.qqnt.pluspanel.data.loader.d
    public com.tencent.qqnt.pluspanel.data.b b(int appID, String curId, int curType) {
        Intrinsics.checkNotNullParameter(curId, "curId");
        com.tencent.qqnt.pluspanel.config.b bVar = ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getAppConfigDatas().get(String.valueOf(appID));
        if (bVar == null) {
            return null;
        }
        com.tencent.qqnt.pluspanel.data.b bVar2 = new com.tencent.qqnt.pluspanel.data.b(0);
        bVar2.q(bVar.r());
        bVar2.p(bVar.o());
        bVar2.w(bVar.p());
        bVar2.l(bVar.h());
        bVar2.m(bVar.i());
        bVar2.t(bVar.n());
        return bVar2;
    }
}
