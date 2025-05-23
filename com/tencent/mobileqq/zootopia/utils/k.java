package com.tencent.mobileqq.zootopia.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J5\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022%\b\u0002\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zootopia/utils/k;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "c", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isUpgrade", "clickCallback", "d", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "a", "Lmqq/util/WeakReference;", "upgradeDialog", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k {

    /* renamed from: a, reason: from kotlin metadata */
    private WeakReference<QQCustomDialog> upgradeDialog;

    private final void c(Activity r65) {
        com.tencent.mobileqq.upgrade.k i3 = com.tencent.mobileqq.upgrade.k.i();
        UpgradeDetailWrapper j3 = i3 != null ? i3.j() : null;
        if ((j3 != null ? j3.f306170d : null) != null && j3.f306170d.iUpgradeType > 0) {
            UpgradeDetailActivity.Y2(r65, j3, false, false, true);
            return;
        }
        Intent intent = new Intent(r65, (Class<?>) QQBrowserActivity.class);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            intent.putExtra("uin", waitAppRuntime.getCurrentAccountUin());
        }
        intent.putExtra("url", "https://im.qq.com/mobileqq/touch/android");
        r65.startActivity(intent);
        QLog.e("UpgradeUtils", 1, "doUpgrade maybe error! upgradeWrapper:" + j3);
    }

    public static final void f(k this$0, Activity activity, Function1 function1, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        this$0.c(activity);
        dialogInterface.dismiss();
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
    }

    public static final void g(Function1 function1, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
    
        if ((r0 != null ? r0.get() : null) == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(final Activity r102, final Function1<? super Boolean, Unit> clickCallback) {
        QQCustomDialog qQCustomDialog;
        Intrinsics.checkNotNullParameter(r102, "activity");
        WeakReference<QQCustomDialog> weakReference = this.upgradeDialog;
        if (weakReference != null) {
        }
        this.upgradeDialog = new WeakReference<>(DialogUtil.createCustomDialog(r102, 230, "\u7248\u672c\u66f4\u65b0", "\u5f53\u524d\u7248\u672c\u8fc7\u4f4e\uff0c\u5347\u7ea7\u7248\u672c\u5373\u53ef\u8fdb\u5165\u6e38\u73a9", "\u53d6\u6d88", "\u7acb\u5373\u5347\u7ea7", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.utils.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.f(k.this, r102, clickCallback, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.utils.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                k.g(Function1.this, dialogInterface, i3);
            }
        }));
        WeakReference<QQCustomDialog> weakReference2 = this.upgradeDialog;
        if (weakReference2 == null || (qQCustomDialog = weakReference2.get()) == null) {
            return;
        }
        qQCustomDialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(k kVar, Activity activity, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        kVar.d(activity, function1);
    }
}
