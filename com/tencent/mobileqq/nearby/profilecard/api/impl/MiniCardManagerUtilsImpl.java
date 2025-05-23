package com.tencent.mobileqq.nearby.profilecard.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils;
import com.tencent.mobileqq.nearby.profilecard.api.impl.MiniCardManagerUtilsImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard$MiniCard;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import u92.a;
import u92.b;
import u92.d;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniCardManagerUtilsImpl implements IMiniCardManagerUtils {
    @Override // com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils
    public boolean containsKey(String str) {
        return d.d(str);
    }

    @Override // com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils
    public void handleMiniCardReq(List<RecentBaseData> list, b bVar, IMiniCardManagerUtils.a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            long longValue = Long.valueOf(list.get(i3).getRecentUserUin()).longValue();
            if (longValue > 10000) {
                if (((INearbyCardManagerUtils) QRoute.api(INearbyCardManagerUtils.class)).isTinyId(String.valueOf(longValue))) {
                    arrayList.add(Long.valueOf(longValue));
                } else {
                    arrayList2.add(Long.valueOf(longValue));
                }
            }
        }
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime instanceof QQAppInterface) {
            if (bVar == null) {
                bVar = (b) ((QQAppInterface) runtime).getManager(QQManagerFactory.MINI_CARD_MANAGER);
            }
            doRequestMiniCardInfo(arrayList, 0, list, bVar, aVar);
            doRequestMiniCardInfo(arrayList2, 1, list, bVar, aVar);
        }
    }

    @Override // com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils
    public void putMiniCard(String str, Object obj) {
        d.h(str, obj);
    }

    @Override // com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils
    public NowSummaryCard$MiniCard getMiniCard(String str) {
        return d.g(str);
    }

    private void doRequestMiniCardInfo(List<Long> list, int i3, final List<RecentBaseData> list2, b bVar, final IMiniCardManagerUtils.a aVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        bVar.a(list, i3, new a(aVar, list2) { // from class: v92.a

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List f441258a;

            {
                this.f441258a = list2;
            }

            @Override // u92.a
            public final void a(int i16, List list3, String str) {
                MiniCardManagerUtilsImpl.lambda$doRequestMiniCardInfo$0(null, this.f441258a, i16, list3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$doRequestMiniCardInfo$0(IMiniCardManagerUtils.a aVar, List list, int i3, List list2, String str) {
        if (i3 != 0 || list2 == null || list2.size() <= 0) {
            return;
        }
        aVar.a(list);
    }
}
