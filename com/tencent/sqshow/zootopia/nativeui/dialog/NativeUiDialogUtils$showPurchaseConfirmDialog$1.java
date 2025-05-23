package com.tencent.sqshow.zootopia.nativeui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import k94.DialogCustomData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NativeUiDialogUtils$showPurchaseConfirmDialog$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j $avatarPanelChannel;
    final /* synthetic */ Function0<Unit> $backHandler;
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeUiDialogUtils$showPurchaseConfirmDialog$1(Context context, com.tencent.sqshow.zootopia.nativeui.data.j jVar, Function0<Unit> function0) {
        super(0);
        this.$context = context;
        this.$avatarPanelChannel = jVar;
        this.$backHandler = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, Function0 backHandler, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "$avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(backHandler, "$backHandler");
        NativeUiDialogUtils.f371177a.l(avatarPanelChannel, context, backHandler);
        ZplanViewReportHelper mReporter = avatarPanelChannel.getReporter().getMReporter();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        ZplanViewReportHelper.f(mReporter, btnLeft, "em_zplan_exit_notice_exit", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        ga4.g a16;
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "$avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "$context");
        a16 = ga4.j.f401682a.a(22, avatarPanelChannel, context, (r22 & 8) != 0 ? new DialogCustomData(null, null, null, null, null, 0, 63, null) : null, (r22 & 16) != 0 ? false : false);
        a16.show();
        ZplanViewReportHelper mReporter = avatarPanelChannel.getReporter().getMReporter();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        mReporter.e(btnight, "em_zplan_exit_notice_purchase", com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.c(avatarPanelChannel.getStoreItemPool()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(com.tencent.sqshow.zootopia.nativeui.data.j avatarPanelChannel, Context context, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(avatarPanelChannel, "$avatarPanelChannel");
        Intrinsics.checkNotNullParameter(context, "$context");
        ZplanViewReportHelper mReporter = avatarPanelChannel.getReporter().getMReporter();
        ViewGroup rootView = qQCustomDialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
        mReporter.a(context, rootView, avatarPanelChannel.getReporter().c(context), avatarPanelChannel.getReporter().b());
        ZplanViewReportHelper mReporter2 = avatarPanelChannel.getReporter().getMReporter();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        mReporter2.g(btnLeft, "em_zplan_exit_notice_exit", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper mReporter3 = avatarPanelChannel.getReporter().getMReporter();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        mReporter3.g(btnight, "em_zplan_exit_notice_purchase", (r16 & 4) != 0 ? null : com.tencent.sqshow.zootopia.nativeui.data.cart.c.f370946a.c(avatarPanelChannel.getStoreItemPool()), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.$context, 0, (String) null, resources.getString(R.string.xsg), 0, 0, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
        String string = resources.getString(R.string.xsf);
        final com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.$avatarPanelChannel;
        final Context context = this.$context;
        final Function0<Unit> function0 = this.$backHandler;
        createCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NativeUiDialogUtils$showPurchaseConfirmDialog$1.d(com.tencent.sqshow.zootopia.nativeui.data.j.this, context, function0, createCustomDialog, dialogInterface, i3);
            }
        });
        String string2 = resources.getString(R.string.xsd);
        final com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.$avatarPanelChannel;
        final Context context2 = this.$context;
        createCustomDialog.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NativeUiDialogUtils$showPurchaseConfirmDialog$1.e(com.tencent.sqshow.zootopia.nativeui.data.j.this, context2, createCustomDialog, dialogInterface, i3);
            }
        });
        final com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.$avatarPanelChannel;
        final Context context3 = this.$context;
        createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.m
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                NativeUiDialogUtils$showPurchaseConfirmDialog$1.f(com.tencent.sqshow.zootopia.nativeui.data.j.this, context3, createCustomDialog, dialogInterface);
            }
        });
        createCustomDialog.setMessageTextSize(NativeUiDialogUtils.f371177a.k());
        createCustomDialog.show();
    }
}
