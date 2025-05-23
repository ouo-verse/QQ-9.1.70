package com.tencent.mobileqq.zplan.cc.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ \u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/m;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "", "confirmAction", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f332568a = new m();

    m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Activity activity, Function0 function0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        }
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Activity activity, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Activity activity, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        activity.finish();
    }

    public final void d(final Activity activity, final Function0<Unit> confirmAction) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230);
        createCustomDialog.setTitle("\u65e0\u6cd5\u4f7f\u7528\u76f8\u673a");
        createCustomDialog.setMessage("\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u5f00\u542f\u76f8\u673a\u6743\u9650");
        createCustomDialog.setPositiveButton("\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cc.util.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.e(activity, confirmAction, dialogInterface, i3);
            }
        });
        createCustomDialog.setNegativeButton("\u53d6\u6d88", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.cc.util.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                m.f(activity, dialogInterface, i3);
            }
        });
        createCustomDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.tencent.mobileqq.zplan.cc.util.l
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                m.g(activity, dialogInterface);
            }
        });
        createCustomDialog.show();
    }
}
