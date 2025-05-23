package com.tencent.mobileqq.springhb.interactive;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0004"}, d2 = {"Landroid/content/Context;", "", "a", "b", "springhb-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    public static final boolean a(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (!((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isSplashActivity(context) || !((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isFoldDevice()) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isSplashActivity(context) || !((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).isFoldDevice()) {
            return false;
        }
        return true;
    }
}
