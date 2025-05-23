package com.tencent.mobileqq.zplan.utils.stack.ipc;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yk3.c;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/stack/ipc/UEActivityQueryApiZPlanImpl;", "Lyk3/c;", "", "key", "", "finishCheck", "(Ljava/lang/String;)Ljava/lang/Boolean;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UEActivityQueryApiZPlanImpl implements c {
    @Override // yk3.a
    public Boolean finishCheck(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).finishCheck(key);
    }
}
