package com.tencent.mobileqq.search.business.contact;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.search.api.ISearchPieceFetcher;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J]\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fH\u0007\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/e;", "", "Lcom/tencent/common/app/AppInterface;", "app", "", IProfileCardConst.KEY_FROM_TYPE, "", "Lwn2/c;", "modelFriends", "", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "categories", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "uin", "Lcom/tencent/mobileqq/search/business/contact/entity/b;", "proxy", "", "a", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f282913a = new e();

    e() {
    }

    @JvmStatic
    public static final void a(@NotNull AppInterface app, int fromType, @NotNull List<wn2.c> modelFriends, @NotNull Map<Integer, com.tencent.qqnt.ntrelation.friendsinfo.bean.a> categories, @NotNull Function1<? super String, ? extends com.tencent.mobileqq.search.business.contact.entity.b> proxy) {
        String str;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(modelFriends, "modelFriends");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        ac robotService = ((IKernelService) app.getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService == null) {
            return;
        }
        ArrayList<RobotCoreInfo> cached = robotService.getAllRobotFriendsFromCache();
        com.tencent.qqnt.ntrelation.friendsinfo.bean.a aVar = categories.get(0);
        QRouteApi api = QRoute.api(ISearchPieceFetcher.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(\n            ISearch\u2026her::class.java\n        )");
        ISearchPieceFetcher iSearchPieceFetcher = (ISearchPieceFetcher) api;
        Intrinsics.checkNotNullExpressionValue(cached, "cached");
        for (RobotCoreInfo robotCoreInfo : cached) {
            if (robotCoreInfo.allowAddGroup) {
                String str2 = robotCoreInfo.uid;
                Intrinsics.checkNotNullExpressionValue(str2, "it.uid");
                com.tencent.qqnt.ntrelation.friendsinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.c(str2, String.valueOf(robotCoreInfo.robotUin), robotCoreInfo.name, null, 0, 0, false, 120, null);
                if (iSearchPieceFetcher.filterQidianMasterSearch(app, cVar, fromType)) {
                    if (aVar == null || (str = aVar.d()) == null) {
                        str = "";
                    }
                    modelFriends.add(new wn2.c(app, fromType, cVar, str, proxy.invoke(String.valueOf(robotCoreInfo.robotUin))));
                }
            }
        }
    }
}
