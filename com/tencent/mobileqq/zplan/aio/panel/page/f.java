package com.tencent.mobileqq.zplan.aio.panel.page;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.utils.bb;
import kotlin.Metadata;
import lx4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"", "a", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {
    public static final String a() {
        b.Companion companion = lx4.b.INSTANCE;
        IZPlanDataHelper iZPlanDataHelper = (IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class);
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            return "0";
        }
        return companion.a(iZPlanDataHelper.getUserZPlanInfo(e16).hasCustomDressUp());
    }
}
