package com.tencent.mobileqq.zplan.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.api.IZPlanForceUpdateHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZPlanForceUpdateHelperImpl;", "Lcom/tencent/mobileqq/zplan/api/IZPlanForceUpdateHelper;", "()V", "clearShowedFlag", "", "tryShowForceUpdateDialog", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "callback", "Lkotlin/Function1;", "", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZPlanForceUpdateHelperImpl implements IZPlanForceUpdateHelper {
    @Override // com.tencent.mobileqq.zplan.api.IZPlanForceUpdateHelper
    public void clearShowedFlag() {
        qe3.a.f428883a.b();
    }

    @Override // com.tencent.mobileqq.zplan.api.IZPlanForceUpdateHelper
    public void tryShowForceUpdateDialog(Activity activity, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        qe3.a.f428883a.c(activity, callback);
    }
}
