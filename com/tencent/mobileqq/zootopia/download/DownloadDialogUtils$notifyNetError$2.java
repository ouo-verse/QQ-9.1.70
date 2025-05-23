package com.tencent.mobileqq.zootopia.download;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class DownloadDialogUtils$notifyNetError$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $callback;
    final /* synthetic */ Integer $contentResId;
    final /* synthetic */ Context $context;
    final /* synthetic */ DialogInterface.OnDismissListener $onDismissListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDialogUtils$notifyNetError$2(Context context, Integer num, DialogInterface.OnDismissListener onDismissListener, Function0<Unit> function0) {
        super(0);
        this.$context = context;
        this.$contentResId = num;
        this.$onDismissListener = onDismissListener;
        this.$callback = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function0 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        Integer num = this.$contentResId;
        int intValue = num != null ? num.intValue() : R.string.xiz;
        Context context = this.$context;
        String string = resources.getString(R.string.xit);
        String string2 = resources.getString(intValue);
        String string3 = resources.getString(R.string.xiw);
        final Function0<Unit> function0 = this.$callback;
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 0, string, string2, "", string3, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.t
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$notifyNetError$2.b(Function0.this, dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        createCustomDialog.setOnDismissListener(this.$onDismissListener);
        Context context2 = this.$context;
        Activity activity = context2 instanceof Activity ? (Activity) context2 : null;
        boolean z16 = false;
        if (activity != null && !activity.isFinishing()) {
            z16 = true;
        }
        if (z16) {
            createCustomDialog.show();
        }
    }
}
