package com.tencent.sqshow.zootopia.utils;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/app/QBaseActivity;", "", "a", "superqqshow-portal-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {
    public static final void a(QBaseActivity qBaseActivity) {
        Intrinsics.checkNotNullParameter(qBaseActivity, "<this>");
        if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
            SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
            return;
        }
        SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
        SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
        SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
    }
}
