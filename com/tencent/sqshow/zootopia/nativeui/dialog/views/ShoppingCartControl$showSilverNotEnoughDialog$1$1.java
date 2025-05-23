package com.tencent.sqshow.zootopia.nativeui.dialog.views;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.dialog.NativeUiDialogUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class ShoppingCartControl$showSilverNotEnoughDialog$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SilverNotEnoughConfig $error;
    final /* synthetic */ ShoppingCartControl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShoppingCartControl$showSilverNotEnoughDialog$1$1(ShoppingCartControl shoppingCartControl, SilverNotEnoughConfig silverNotEnoughConfig) {
        super(0);
        this.this$0 = shoppingCartControl;
        this.$error = silverNotEnoughConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QQCustomDialog qQCustomDialog, ShoppingCartControl this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        qQCustomDialog.dismiss();
        ZplanViewReportHelper mReporter = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        ZplanViewReportHelper.j(mReporter, btnLeft, "em_zplan_silver_insufficient_close_btn", null, false, null, 20, null);
        ZplanViewReportHelper mReporter2 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        TextView btnLeft2 = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft2, "dialog.btnLeft");
        ZplanViewReportHelper.f(mReporter2, btnLeft2, "em_zplan_silver_insufficient_close_btn", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QQCustomDialog qQCustomDialog, ShoppingCartControl this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        qQCustomDialog.dismiss();
        ShoppingCartControl.B(this$0, 0, 1, null);
        ZplanViewReportHelper mReporter = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        ZplanViewReportHelper.j(mReporter, btnight, "em_zplan_silver_insufficient_do_task", null, false, null, 20, null);
        ZplanViewReportHelper mReporter2 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        TextView btnight2 = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight2, "dialog.btnight");
        ZplanViewReportHelper.f(mReporter2, btnight2, "em_zplan_silver_insufficient_do_task", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ShoppingCartControl this$0, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper mReporter = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        Context context = this$0.getContext();
        ViewGroup rootView = qQCustomDialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
        mReporter.a(context, rootView, this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().c(this$0.getContext()), this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().b());
        ZplanViewReportHelper mReporter2 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        mReporter2.g(btnLeft, "em_zplan_silver_insufficient_close_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper mReporter3 = this$0.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.CHANNEL java.lang.String().getReporter().getMReporter();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        mReporter3.g(btnight, "em_zplan_silver_insufficient_do_task", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.this$0.getContext(), 0, (String) null, this.$error.getMessage(), 0, 0, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
        String cancelText = this.$error.getCancelText();
        final ShoppingCartControl shoppingCartControl = this.this$0;
        createCustomDialog.setNegativeButton(cancelText, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ShoppingCartControl$showSilverNotEnoughDialog$1$1.d(QQCustomDialog.this, shoppingCartControl, dialogInterface, i3);
            }
        });
        String confirmText = this.$error.getConfirmText();
        final ShoppingCartControl shoppingCartControl2 = this.this$0;
        createCustomDialog.setPositiveButton(confirmText, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ShoppingCartControl$showSilverNotEnoughDialog$1$1.e(QQCustomDialog.this, shoppingCartControl2, dialogInterface, i3);
            }
        });
        final ShoppingCartControl shoppingCartControl3 = this.this$0;
        createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.views.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                ShoppingCartControl$showSilverNotEnoughDialog$1$1.f(ShoppingCartControl.this, createCustomDialog, dialogInterface);
            }
        });
        createCustomDialog.setMessageTextSize(NativeUiDialogUtils.f371177a.k());
        createCustomDialog.show();
    }
}
