package com.tencent.robot.route;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.pubaccount.weishi.report.WSStatisticsBaseCollector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0011\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0096\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/route/RobotClickUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "info", "", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/core/a;", "context", "Landroid/os/Bundle;", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "interestedIn", "needUnifiedAnim", "invoke", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotClickUseCase implements b {
    private final Bundle a(g item, a context) {
        long j3;
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_isblock", item.s().isBlock);
        bundle.putString("key_from", "0");
        bundle.putInt("key_from_chat_listtype", context.b());
        if (item.x().c() == 1) {
            j3 = item.x().b();
        } else {
            j3 = 0;
        }
        bundle.putLong("key_enter_unread_cnt", j3);
        bundle.putString("key_robot_aio_scene", "1001");
        com.tencent.qqnt.chats.api.b chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o());
        if (chatsListReport != null) {
            b.d v3 = chatsListReport.v();
            bundle.putString(WSStatisticsBaseCollector.KEY_REF_PAGE_ID, v3.a());
            bundle.putInt("key_page_stp", v3.b());
        }
        return bundle;
    }

    private final boolean b(RobotCoreInfo info) {
        boolean z16;
        if (info == null || info.robotUin == 0) {
            return false;
        }
        String str = info.avatarDominantColor;
        Intrinsics.checkNotNullExpressionValue(str, "info.avatarDominantColor");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            g gVar = (g) b16;
            return ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotAIO(String.valueOf(gVar.l()), Integer.valueOf(gVar.n()));
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        View c16 = params.c();
        if (b16 instanceof g) {
            g gVar = (g) b16;
            if (b(((IRobotProfileInfoApi) QRoute.api(IRobotProfileInfoApi.class)).getRobotCoreInfoFromFriendsCache(String.valueOf(gVar.l())))) {
                IAIOStarterApi iAIOStarterApi = (IAIOStarterApi) QRoute.api(IAIOStarterApi.class);
                Context context = c16.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "view.context");
                iAIOStarterApi.navigateToAIO(context, gVar.n(), gVar.k(), gVar.w().e(), gVar.l(), a(gVar, params.a()));
            } else {
                QLog.d("RobotClickUseCase", 1, "robot no coreInfo uin=" + gVar.l());
                IRobotAIORouteApi iRobotAIORouteApi = (IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class);
                Context context2 = c16.getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                iRobotAIORouteApi.fetchAndRouteToRobotAIO(new RobotAIORouteArgs((Activity) context2, String.valueOf(gVar.l()), null, "0", "1001", false, null, null, null, 484, null));
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return false;
    }
}
