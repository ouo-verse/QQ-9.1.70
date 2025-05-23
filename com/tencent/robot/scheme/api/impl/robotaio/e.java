package com.tencent.robot.scheme.api.impl.robotaio;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IRobotAIORouteApi;
import com.tencent.robot.api.RobotAIORouteArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/robot/scheme/api/impl/robotaio/e;", "Lcom/tencent/robot/scheme/api/impl/robotaio/a;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "Landroid/app/Activity;", "b", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e implements a {
    private final Activity b(ax jumpAction) {
        if (Foreground.getTopActivity() != null) {
            QLog.i("RobotAIOOpenProcessor", 1, "getActivity from getTopActivity");
            return Foreground.getTopActivity();
        }
        if (jumpAction.f307437b instanceof Activity) {
            QLog.i("RobotAIOOpenProcessor", 1, "getActivity from jumpAction.context");
            Context context = jumpAction.f307437b;
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        return null;
    }

    @Override // com.tencent.robot.scheme.api.impl.robotaio.a
    public boolean a(@NotNull ax jumpAction) {
        boolean z16;
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        Activity b16 = b(jumpAction);
        if (b16 == null) {
            QLog.e("RobotAIOOpenProcessor", 1, "process activity is null!");
            return false;
        }
        String str = jumpAction.f307441f.get("uin");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("RobotAIOOpenProcessor", 1, "process uin is null");
            return false;
        }
        String str2 = jumpAction.f307441f.get("source");
        if (str2 == null) {
            str2 = "14";
        }
        String str3 = str2;
        String str4 = jumpAction.f307441f.get("scene");
        if (str4 == null) {
            str4 = "1000";
        }
        String str5 = str4;
        String str6 = jumpAction.f307441f.get("callback_data");
        if (str6 == null) {
            str6 = "";
        }
        String str7 = str6;
        String str8 = jumpAction.f307441f.get("scale_aio");
        String str9 = "0";
        if (str8 == null) {
            str8 = "0";
        }
        boolean areEqual = Intrinsics.areEqual(str8, "1");
        String str10 = jumpAction.f307441f.get("blockHistoricalMsg");
        if (str10 != null) {
            str9 = str10;
        }
        boolean areEqual2 = Intrinsics.areEqual(str9, "1");
        Bundle bundle = new Bundle();
        if (areEqual2) {
            bundle.putBoolean("key_hide_history_msg", true);
        }
        ((IRobotAIORouteApi) QRoute.api(IRobotAIORouteApi.class)).fetchAndRouteToRobotAIO(new RobotAIORouteArgs(b16, str, null, str3, str5, areEqual, bundle, str7, null, 256, null));
        return true;
    }
}
