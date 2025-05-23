package com.tencent.mobileqq.zplan.utils.stack.lifecycle.impl;

import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IZPlanLifeCycleRecorderHelper;
import k74.i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yk3.d;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J*\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/stack/lifecycle/impl/ZPlanLifeCycleRecorderHelperImpl;", "Lcom/tencent/mobileqq/zplan/utils/stack/lifecycle/IZPlanLifeCycleRecorderHelper;", "()V", "activityCreate", "", "isEnginePage", "", "activityName", "", "hashCode", "", "processName", "activityDestroy", "activityFinish", "activityResume", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ZPlanLifeCycleRecorderHelperImpl implements IZPlanLifeCycleRecorderHelper {
    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IZPlanLifeCycleRecorderHelper
    public void activityCreate(boolean isEnginePage, String activityName, int hashCode, String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        ((d) i.INSTANCE.a(d.class)).activityCreate(isEnginePage, activityName, hashCode, processName);
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IZPlanLifeCycleRecorderHelper
    public void activityDestroy(boolean isEnginePage, String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        ((d) i.INSTANCE.a(d.class)).activityDestroy(isEnginePage, activityName, hashCode);
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IZPlanLifeCycleRecorderHelper
    public void activityFinish(boolean isEnginePage, String activityName, int hashCode) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        ((d) i.INSTANCE.a(d.class)).activityFinish(isEnginePage, activityName, hashCode);
    }

    @Override // com.tencent.mobileqq.zplan.utils.stack.lifecycle.IZPlanLifeCycleRecorderHelper
    public void activityResume(boolean isEnginePage, String activityName, int hashCode, String processName) {
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        ((d) i.INSTANCE.a(d.class)).activityResume(isEnginePage, activityName, hashCode, processName);
    }
}
