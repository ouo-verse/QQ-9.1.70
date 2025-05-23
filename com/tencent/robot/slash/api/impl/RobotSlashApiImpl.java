package com.tencent.robot.slash.api.impl;

import android.view.View;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotPageApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.robot.aio.bottombar.promptfunction.e;
import com.tencent.robot.at.manager.RobotAtBusinessDelegate;
import com.tencent.robot.at.manager.RobotAtDialogManager;
import com.tencent.robot.draw.RobotDrawDialogManager;
import com.tencent.robot.menu.RobotMenuBusinessDelegate;
import com.tencent.robot.menu.RobotMenuDialogManager;
import com.tencent.robot.search.RobotSearchDialogManager;
import com.tencent.robot.slash.api.IRobotSlashApi;
import com.tencent.robot.slash.business.c2c.C2CSlashBusinessDelegate;
import com.tencent.robot.slash.manager.DefaultSlashDialogManager;
import com.tencent.robot.slash.manager.b;
import com.tencent.robot.slash.manager.c;
import com.tencent.robot.slash.manager.d;
import com.tencent.robot.write.RobotWriteDialogManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/robot/slash/api/impl/RobotSlashApiImpl;", "Lcom/tencent/robot/slash/api/IRobotSlashApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/view/View;", "anchorView", "Lcom/tencent/robot/slash/manager/d;", "createGuildSlashManager", "createSlashManagerFromAIO", "Lcom/tencent/robot/slash/manager/b;", "createRobotFunctionManager", "Lcom/tencent/robot/slash/manager/c;", "createRobotMenuManager", "Lf54/a;", "createRobotSearchManager", "Lz34/a;", "createRobotDrawManager", "Ld74/a;", "createRobotWriteManager", "Lg34/c;", "createRobotPromptFunctionManager", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSlashApiImpl implements IRobotSlashApi {
    private final d createGuildSlashManager(a aioContext, View anchorView) {
        if (((IGuildRobotPageApi) QRoute.api(IGuildRobotPageApi.class)).isDirectRobotAIO(aioContext)) {
            return new DefaultSlashDialogManager(aioContext, new p54.a(aioContext, anchorView));
        }
        return new DefaultSlashDialogManager(aioContext, new o54.a(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public z34.a createRobotDrawManager(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        return new RobotDrawDialogManager(aioContext, new com.tencent.robot.draw.a(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public b createRobotFunctionManager(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        return new RobotAtDialogManager(aioContext, new RobotAtBusinessDelegate(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public c createRobotMenuManager(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        return new RobotMenuDialogManager(aioContext, new RobotMenuBusinessDelegate(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public g34.c createRobotPromptFunctionManager(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        return new e(aioContext, new com.tencent.robot.aio.bottombar.promptfunction.c(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public f54.a createRobotSearchManager(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        return new RobotSearchDialogManager(aioContext, new com.tencent.robot.search.a(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public d74.a createRobotWriteManager(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        return new RobotWriteDialogManager(aioContext, new com.tencent.robot.write.a(aioContext, anchorView));
    }

    @Override // com.tencent.robot.slash.api.IRobotSlashApi
    @NotNull
    public d createSlashManagerFromAIO(@NotNull a aioContext, @NotNull View anchorView) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        int e16 = aioContext.g().r().c().e();
        if (e16 != 1) {
            if (e16 != 2) {
                if (e16 != 4) {
                    return new DefaultSlashDialogManager(aioContext, new s54.a(aioContext, anchorView));
                }
                return createGuildSlashManager(aioContext, anchorView);
            }
            return new DefaultSlashDialogManager(aioContext, new s54.a(aioContext, anchorView));
        }
        return new DefaultSlashDialogManager(aioContext, new C2CSlashBusinessDelegate(aioContext, anchorView));
    }
}
