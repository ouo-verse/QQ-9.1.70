package com.tencent.mobileqq.onlinestatus.utils;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/t;", "Lcom/tencent/mobileqq/onlinestatus/utils/i;", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "", "a", "Landroid/content/Context;", "context", "b", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class t implements i {
    @Override // com.tencent.mobileqq.onlinestatus.utils.i
    public boolean a(@NotNull AppRuntime.Status status, long extStatus) {
        Intrinsics.checkNotNullParameter(status, "status");
        if (status == AppRuntime.Status.online && extStatus == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.onlinestatus.utils.i
    public boolean b(@NotNull Context context, @NotNull AppRuntime.Status status, long extStatus) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(status, "status");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            activity = Foreground.getTopActivity();
        }
        if (activity == null) {
            return false;
        }
        ((ICustomOnlineStatusManager) QRoute.api(ICustomOnlineStatusManager.class)).openH5(activity, WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL);
        return true;
    }
}
