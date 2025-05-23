package com.tencent.mobileqq.apollo.game.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.apollo.game.process.data.CmGameAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/apollo/game/api/impl/CmGameHelperImpl;", "Lcom/tencent/mobileqq/apollo/game/api/ICmGameHelper;", "()V", "createGameAppInterface", "Lcom/tencent/common/app/AppInterface;", "app", "Lmqq/app/MobileQQ;", "processName", "", "getAppInterface", "cmshow_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class CmGameHelperImpl implements ICmGameHelper {
    @Override // com.tencent.mobileqq.apollo.game.api.ICmGameHelper
    public AppInterface createGameAppInterface(MobileQQ app, String processName) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(processName, "processName");
        return new CmGameAppInterface(app, processName);
    }

    @Override // com.tencent.mobileqq.apollo.game.api.ICmGameHelper
    public AppInterface getAppInterface() {
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null) {
            AppRuntime runtime = application.getRuntime();
            Intrinsics.checkNotNullExpressionValue(runtime, "application.runtime");
            if (runtime instanceof ToolAppRuntime) {
                AppRuntime appRuntime = runtime.getAppRuntime("cmshowgame_module");
                Intrinsics.checkNotNullExpressionValue(appRuntime, "runtime.getAppRuntime(Ap\u2026meConst.CMGAME_MODULE_ID)");
                if (appRuntime instanceof AppInterface) {
                    return (AppInterface) appRuntime;
                }
            } else if (runtime instanceof QQAppInterface) {
                return (AppInterface) runtime;
            }
        }
        return null;
    }
}
