package com.tencent.mobileqq.zootopia.download;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class DownloadDialogUtils$notifyDownloadMemoryLacking$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ DialogInterface.OnDismissListener $onDismissListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadDialogUtils$notifyDownloadMemoryLacking$1(Context context, DialogInterface.OnDismissListener onDismissListener) {
        super(0);
        this.$context = context;
        this.$onDismissListener = onDismissListener;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.$context, 0, resources.getString(R.string.xit), resources.getString(R.string.xiy), "", resources.getString(R.string.xiw), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.s
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$notifyDownloadMemoryLacking$1.b(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null);
        createCustomDialog.setOnDismissListener(this.$onDismissListener);
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogInterface dialogInterface, int i3) {
    }
}
