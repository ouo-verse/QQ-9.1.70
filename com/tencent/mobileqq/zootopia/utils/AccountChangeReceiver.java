package com.tencent.mobileqq.zootopia.utils;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u0013\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/AccountChangeReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "b", "c", "", "", "a", "()[Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AccountChangeReceiver extends BroadcastReceiver {
    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IntentFilter intentFilter = new IntentFilter();
        for (String str : a()) {
            intentFilter.addAction(str);
        }
        context.registerReceiver(this, intentFilter);
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    public final String[] a() {
        return new String[]{NewIntent.ACTION_ACCOUNT_KICKED, "mqq.intent.action.EXIT_" + BaseApplication.getContext().getPackageName(), NewIntent.ACTION_ACCOUNT_CHANGED, NewIntent.ACTION_ACCOUNT_EXPIRED, NewIntent.ACTION_LOGOUT};
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        QLog.i("AccountChangeReceiver", 1, "onReceive action=" + (intent != null ? intent.getAction() : null));
        if (t74.h.e()) {
            QLog.i("AccountChangeReceiver", 1, "onReceive is zplan process stop engine");
            Context ctx = context == null ? MobileQQ.sMobileQQ.getBaseContext() : context;
            ZPlanServiceHelper zPlanServiceHelper = ZPlanServiceHelper.I;
            if (zPlanServiceHelper.l0()) {
                Intrinsics.checkNotNullExpressionValue(ctx, "ctx");
                zPlanServiceHelper.Y0(ctx);
            }
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
    }
}
