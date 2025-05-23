package com.tencent.mobileqq.zplan.mod.impl;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zootopia.download.DownloadDialogUtils;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ModComponentsApiImpl$handleBaseModError$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ int $code;
    final /* synthetic */ Function0<Unit> $onHandleFinish;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModComponentsApiImpl$handleBaseModError$1(int i3, Activity activity, Function0<Unit> function0) {
        super(0);
        this.$code = i3;
        this.$activity = activity;
        this.$onHandleFinish = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function0 onHandleFinish, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(onHandleFinish, "$onHandleFinish");
        onHandleFinish.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function0 onHandleFinish, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(onHandleFinish, "$onHandleFinish");
        onHandleFinish.invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int i3 = this.$code;
        if (i3 == -1002) {
            DownloadDialogUtils downloadDialogUtils = DownloadDialogUtils.f327978a;
            Activity activity = this.$activity;
            Integer valueOf = Integer.valueOf(R.string.xiz);
            final Function0<Unit> function0 = this.$onHandleFinish;
            DownloadDialogUtils.q(downloadDialogUtils, activity, valueOf, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zplan.mod.impl.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ModComponentsApiImpl$handleBaseModError$1.c(Function0.this, dialogInterface);
                }
            }, null, 8, null);
            return;
        }
        if (i3 == -1003 || i3 == -4) {
            DownloadDialogUtils downloadDialogUtils2 = DownloadDialogUtils.f327978a;
            Activity activity2 = this.$activity;
            final Function0<Unit> function02 = this.$onHandleFinish;
            downloadDialogUtils2.n(activity2, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.zplan.mod.impl.c
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    ModComponentsApiImpl$handleBaseModError$1.d(Function0.this, dialogInterface);
                }
            });
            return;
        }
        if (i3 == -1004) {
            this.$onHandleFinish.invoke();
            return;
        }
        String string = this.$activity.getString(R.string.xir);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ia_download_batch_failed)");
        QQToastUtil.showQQToast(1, string);
        this.$onHandleFinish.invoke();
    }
}
