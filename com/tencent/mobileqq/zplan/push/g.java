package com.tencent.mobileqq.zplan.push;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import kotlin.Metadata;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/g;", "", "Landroid/app/Activity;", EventKey.ACT, "", "d", "", "msg", "", "f", "c", "e", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f335038a = new g();

    g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Activity activity, String str) {
        if (f335038a.d(activity)) {
            DialogUtil.createCenterTextDialog(activity, 0, "\u63d0\u793a", str, null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.push.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.h(dialogInterface, i3);
                }
            }, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(DialogInterface dialogInterface, int i3) {
        f335038a.c();
        dialogInterface.dismiss();
    }

    public final void c() {
        BaseApplication baseApplication = BaseApplication.context;
        Intent intent = new Intent();
        intent.setComponent(SplashActivity.getAliasComponent(baseApplication));
        intent.setFlags(335544320);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        baseApplication.startActivity(intent);
    }

    public final Activity e() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            return topActivity;
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity instanceof Activity) {
            return qBaseActivity;
        }
        return null;
    }

    public final void f(final Activity act, final String msg2) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.push.e
            @Override // java.lang.Runnable
            public final void run() {
                g.g(act, msg2);
            }
        });
    }

    public final boolean d(Activity act) {
        return (act == null || act.isFinishing() || act.isDestroyed()) ? false : true;
    }
}
