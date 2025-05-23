package com.tencent.mobileqq.zplan.minixwconnected;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/MiniHomeConnectedPermissions;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "access", "", "execution", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectedPermissions {

    /* renamed from: a, reason: collision with root package name */
    public static final MiniHomeConnectedPermissions f334440a = new MiniHomeConnectedPermissions();

    MiniHomeConnectedPermissions() {
    }

    public final void a(Function1<? super Boolean, Unit> execution) {
        Intrinsics.checkNotNullParameter(execution, "execution");
        if (w84.a.f445029a.b()) {
            execution.invoke(Boolean.FALSE);
            QLog.w("MiniHomeConnectedPermissions", 1, "isStudyMode disallow.");
            return;
        }
        if (!com.tencent.mobileqq.zplan.lite.util.e.j(com.tencent.mobileqq.zplan.lite.util.e.f333809a, null, 1, null)) {
            execution.invoke(Boolean.FALSE);
            QLog.w("MiniHomeConnectedPermissions", 1, "enableZPlanFilament disallow.");
            return;
        }
        if (!MiniHomeConnectedWhiteList.f334443a.a()) {
            execution.invoke(Boolean.FALSE);
            QLog.w("MiniHomeConnectedPermissions", 1, "MiniHomeConnectedWhiteList disallow.");
            return;
        }
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        if (e16.length() == 0) {
            execution.invoke(Boolean.FALSE);
            QLog.w("MiniHomeConnectedPermissions", 1, "ZPlanUtil.currentUin is null disallow.");
        } else {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.c.f261781e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "MiniHomeConnectedPermissions_getZplanAccessibleDetail", null, null, null, new MiniHomeConnectedPermissions$allow$1(e16, execution, null), 14, null);
            }
        }
    }
}
