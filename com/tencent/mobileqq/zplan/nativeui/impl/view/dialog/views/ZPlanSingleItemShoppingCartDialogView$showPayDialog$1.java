package com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
final class ZPlanSingleItemShoppingCartDialogView$showPayDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ int $currentGoldCoin;
    final /* synthetic */ int $diffGoldCoin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ZPlanSingleItemShoppingCartDialogView$showPayDialog$1(Context context, int i3, int i16, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$context = context;
        this.$currentGoldCoin = i3;
        this.$diffGoldCoin = i16;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Boolean.TRUE);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.$context, 0, (String) null, resources.getString(R.string.xsb, Integer.valueOf(this.$currentGoldCoin), Integer.valueOf(this.$diffGoldCoin)), 0, 0, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
        String string = resources.getString(R.string.f169768xi0);
        final Function1<Boolean, Unit> function1 = this.$callback;
        createCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanSingleItemShoppingCartDialogView$showPayDialog$1.c(Function1.this, dialogInterface, i3);
            }
        });
        String string2 = resources.getString(R.string.xsc);
        int color = this.$context.getResources().getColor(R.color.f8436y);
        final Function1<Boolean, Unit> function12 = this.$callback;
        createCustomDialog.setPositiveButton(string2, color, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.zplan.nativeui.impl.view.dialog.views.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ZPlanSingleItemShoppingCartDialogView$showPayDialog$1.d(Function1.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setMessageTextSize(NativeUiDialogUtils.f371177a.k());
        createCustomDialog.show();
    }
}
