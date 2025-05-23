package com.tencent.mobileqq.onlinestatus.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.ar;
import com.tencent.mobileqq.onlinestatus.bv;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/c;", "Lcom/tencent/mobileqq/onlinestatus/utils/i;", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "", "a", "Landroid/content/Context;", "context", "b", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c implements i {
    @Override // com.tencent.mobileqq.onlinestatus.utils.i
    public boolean a(@NotNull AppRuntime.Status status, long extStatus) {
        Intrinsics.checkNotNullParameter(status, "status");
        return ar.a(status);
    }

    @Override // com.tencent.mobileqq.onlinestatus.utils.i
    public boolean b(@NotNull Context context, @NotNull AppRuntime.Status status, long extStatus) {
        Activity activity;
        int i3;
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
        if (status == AppRuntime.Status.away) {
            i3 = 1;
        } else if (status == AppRuntime.Status.busy) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        bv.e("0X800B754", i3, null, null, 12, null);
        Intent intent = new Intent();
        intent.putExtra("KEY_ONLINE_STATUS", status);
        intent.putExtra("KEY_ONLINE_EXT_STATUS", extStatus);
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) AccountOnlineStateActivity.class, 234);
        return true;
    }
}
