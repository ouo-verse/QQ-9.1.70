package com.tencent.mobileqq.onlinestatus.view;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.onlinestatus.OnlineStatusExtInfoServlet;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000\u001a0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\n0\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a8\u0006\u000e"}, d2 = {"", "birthday", "age", LpReport_UserInfo_dc02148.CONSTELLATION, "", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Intent;", "intent", "", "currentConstellation", "Lkotlin/Pair;", "a", "qqonlinestatus-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ae {
    @NotNull
    public static final Pair<Integer, String> a(@NotNull AppRuntime app, @Nullable Intent intent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(app, "app");
        Pair<Integer, String> pair = new Pair<>(0, "");
        if (intent != null) {
            short shortExtra = intent.getShortExtra("param_year", (short) 1990);
            byte byteExtra = intent.getByteExtra("param_month", (byte) 1);
            byte byteExtra2 = intent.getByteExtra("param_day", (byte) 1);
            int intExtra = intent.getIntExtra("param_age", 0);
            int intExtra2 = intent.getIntExtra("param_constellation_id", kc2.a.DEFAULT_CONSTELLATION);
            int i3 = (shortExtra << 16) | (byteExtra << 8) | byteExtra2;
            String u16 = com.tencent.mobileqq.onlinestatus.bs.u(intExtra2);
            if (QLog.isColorLevel()) {
                QLog.d("ConstellationView", 2, "applyActivityResult: called. ", "constellationStr: " + u16);
            }
            if (!Intrinsics.areEqual(u16, str)) {
                b(i3, intExtra, intExtra2);
                OnlineStatusExtInfoServlet.b(app, u16);
                if (QLog.isColorLevel()) {
                    QLog.d("ConstellationView", 2, "applyActivityResult: called. ", "constellation: " + u16);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("ConstellationView", 2, "applyActivityResult: called. ", "not changed, birthdayValue: " + str);
            }
            return new Pair<>(Integer.valueOf(i3), u16);
        }
        return pair;
    }

    public static final void b(int i3, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putInt("birthday", i3);
        bundle.putInt("age", i16);
        bundle.putInt(IProfileProtocolConst.KEY_CONSTELLATION, i17);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IProfileProtocolService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026va, ProcessConstant.MAIN)");
        ((IProfileProtocolService) runtimeService).setProfileDetail(bundle);
        if (QLog.isColorLevel()) {
            QLog.d("ConstellationView", 2, "sendBirthDayChangedRequest: called. ", "constellation: " + i17);
        }
    }
}
