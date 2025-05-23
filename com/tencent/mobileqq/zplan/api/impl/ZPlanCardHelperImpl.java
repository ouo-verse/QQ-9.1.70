package com.tencent.mobileqq.zplan.api.impl;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanCardHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanCardHelperImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanCardHelper;", "()V", "createCard", "Landroid/view/View;", "viewType", "", "context", "Landroid/content/Context;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "mapResViewModel", "", "sourceCurrent", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanCardHelperImpl implements IZPlanCardHelper {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanCardHelper
    public View createCard(int viewType, Context context, LifecycleOwner owner, Object mapResViewModel, ZootopiaSource sourceCurrent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        return ((nf3.a) vb3.a.f441346a.b(nf3.a.class)).b0(viewType, context, owner, (oa4.a) mapResViewModel, sourceCurrent);
    }
}
