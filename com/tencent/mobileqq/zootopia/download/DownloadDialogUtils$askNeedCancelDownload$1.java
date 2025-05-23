package com.tencent.mobileqq.zootopia.download;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
final class DownloadDialogUtils$askNeedCancelDownload$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DownloadDialogUtils$askNeedCancelDownload$1(Context context, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$context = context;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        Context context = this.$context;
        String string = resources.getString(R.string.xie);
        String string2 = resources.getString(R.string.f169768xi0);
        String string3 = resources.getString(R.string.xkd);
        final Function1<Boolean, Unit> function1 = this.$callback;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeedCancelDownload$1.c(Function1.this, dialogInterface, i3);
            }
        };
        final Function1<Boolean, Unit> function12 = this.$callback;
        DialogUtil.createCustomDialog(context, 0, (String) null, string, string2, string3, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.download.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                DownloadDialogUtils$askNeedCancelDownload$1.d(Function1.this, dialogInterface, i3);
            }
        }).show();
    }
}
