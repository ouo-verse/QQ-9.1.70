package d54;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.robot.adelie.homepage.api.IAdelieHomePageApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Ld54/d;", "Ld54/h;", "Lcom/tencent/mobileqq/utils/ax;", "jumpAction", "", "b", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements h {
    private final void b(ax jumpAction) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", "em_bas_agent_entry");
        hashMap.put("qq_pgid", "pg_bas_msglist");
        hashMap.put("qq_pgstp", 1);
        hashMap.put("qq_ref_pgid", PageUtils.VR_PAGE_NONE);
        BaseQQAppInterface baseQQAppInterface = jumpAction.f307436a;
        String str2 = null;
        if (baseQQAppInterface != null) {
            str = baseQQAppInterface.getCurrentUid();
        } else {
            str = null;
        }
        String str3 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "jumpAction.app?.currentUid ?: \"\"");
        }
        hashMap.put("uid", str);
        BaseQQAppInterface baseQQAppInterface2 = jumpAction.f307436a;
        if (baseQQAppInterface2 != null) {
            str2 = baseQQAppInterface2.getCurrentUin();
        }
        if (str2 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, "jumpAction.app?.currentUin ?: \"\"");
            str3 = str2;
        }
        hashMap.put("home_uin", str3);
        hashMap.put("msglist_type", 0);
        VideoReport.reportEvent("qq_clck", hashMap);
    }

    @Override // d54.h
    public boolean a(@NotNull ax jumpAction) {
        Intrinsics.checkNotNullParameter(jumpAction, "jumpAction");
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            QLog.w("AdelieJumpAction", 1, "openHome, getTopActivity is null");
            Context context = jumpAction.f307437b;
            if (context instanceof Activity) {
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                topActivity = (Activity) context;
            } else {
                topActivity = null;
            }
            if (topActivity == null) {
                QLog.w("AdelieJumpAction", 1, "openHome, activity is null");
                return true;
            }
        }
        b(jumpAction);
        Bundle bundle = new Bundle();
        String f16 = jumpAction.f("source");
        String f17 = jumpAction.f("clear_top");
        bundle.putString("source", f16);
        bundle.putBoolean("clear_top", Intrinsics.areEqual("1", f17));
        ((IAdelieHomePageApi) QRoute.api(IAdelieHomePageApi.class)).startAdelieHomePage(topActivity, bundle);
        return true;
    }
}
