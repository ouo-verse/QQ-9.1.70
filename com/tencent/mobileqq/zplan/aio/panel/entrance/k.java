package com.tencent.mobileqq.zplan.aio.panel.entrance;

import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002\u00a8\u0006\u0005"}, d2 = {"", "eventId", "elementId", "", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, String str2) {
        IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class);
        iMutualMarkHelperApi.reportItemEvent(str, "pg_aio_swipleft", str2, iMutualMarkHelperApi.getPgSwipLeftData(), null);
    }
}
