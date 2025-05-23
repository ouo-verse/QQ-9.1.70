package com.tencent.mobileqq.matchfriend.reborn.login;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/login/d;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lp72/a;", "loginInfo", "Landroid/view/View;", "loadingPage", "", "f", "d", "<init>", "()V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(d this$0, Activity activity, p72.a loginInfo, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        this$0.f(activity, loginInfo, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(p72.a loginInfo, Activity activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        if (loginInfo.f425677g == 9 && activity != null) {
            activity.finish();
        }
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(View view, p72.a loginInfo, Activity activity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(loginInfo, "$loginInfo");
        if (view != null) {
            view.setVisibility(8);
        }
        if (loginInfo.f425677g != 9 || activity == null) {
            return;
        }
        activity.finish();
    }

    public final void d(final Activity activity, final p72.a loginInfo, final View loadingPage) {
        Intrinsics.checkNotNullParameter(loginInfo, "loginInfo");
        if (!loginInfo.f425673c || loginInfo.f425677g == 50 || activity == null) {
            return;
        }
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            f(activity, loginInfo, loadingPage);
        } else {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(d.this, activity, loginInfo, loadingPage);
                }
            });
        }
    }

    private final void f(final Activity activity, final p72.a loginInfo, final View loadingPage) {
        if (loadingPage != null) {
            loadingPage.setVisibility(0);
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, loginInfo.f425674d, loginInfo.f425675e + "\n" + loginInfo.f425676f, (String) null, "\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.g(p72.a.this, activity, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026 },\n                null)");
        createCustomDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.login.c
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                d.h(loadingPage, loginInfo, activity, dialogInterface);
            }
        });
        createCustomDialog.show();
    }
}
