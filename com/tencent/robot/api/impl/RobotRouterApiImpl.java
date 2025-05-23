package com.tencent.robot.api.impl;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.bi;
import com.tencent.robot.api.IRobotRouterApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/robot/api/impl/RobotRouterApiImpl;", "Lcom/tencent/robot/api/IRobotRouterApi;", "()V", "launchScheme", "", "context", "Landroid/content/Context;", "schemeUrl", "", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RobotRouterApiImpl implements IRobotRouterApi {
    @Override // com.tencent.robot.api.IRobotRouterApi
    public void launchScheme(@NotNull Context context, @NotNull String schemeUrl) {
        boolean startsWith;
        boolean startsWith2;
        BaseQQAppInterface baseQQAppInterface;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schemeUrl, "schemeUrl");
        startsWith = StringsKt__StringsJVMKt.startsWith(schemeUrl, "http", true);
        if (!startsWith) {
            startsWith2 = StringsKt__StringsJVMKt.startsWith(schemeUrl, "https", true);
            if (!startsWith2) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof BaseQQAppInterface) {
                    baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
                } else {
                    baseQQAppInterface = null;
                }
                if (baseQQAppInterface != null) {
                    bi.c(baseQQAppInterface, context, schemeUrl).b();
                    return;
                }
                return;
            }
        }
        com.tencent.robot.adelie.homepage.utils.n.f366680a.f(context, schemeUrl);
    }
}
