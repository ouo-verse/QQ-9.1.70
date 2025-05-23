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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes34.dex */
public final class NativeUiDialogUtils$askNeedRecharge$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j $channel;
    final /* synthetic */ Context $context;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NativeUiDialogUtils$askNeedRecharge$1(Context context, Function1<? super Boolean, Unit> function1, com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        super(0);
        this.$context = context;
        this.$callback = function1;
        this.$channel = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 callback, com.tencent.sqshow.zootopia.nativeui.data.j channel, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        callback.invoke(Boolean.FALSE);
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        ZplanViewReportHelper.f(mReporter, btnLeft, "em_zplan_coin_insufficient_win_close", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 callback, com.tencent.sqshow.zootopia.nativeui.data.j channel, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        callback.invoke(Boolean.TRUE);
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        ZplanViewReportHelper.f(mReporter, btnight, "em_zplan_coin_insufficient_win_confirm", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(com.tencent.sqshow.zootopia.nativeui.data.j channel, Context context, QQCustomDialog qQCustomDialog, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(channel, "$channel");
        Intrinsics.checkNotNullParameter(context, "$context");
        ZplanViewReportHelper mReporter = channel.getReporter().getMReporter();
        ViewGroup rootView = qQCustomDialog.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "dialog.rootView");
        mReporter.a(context, rootView, channel.getReporter().c(context), channel.getReporter().b());
        ZplanViewReportHelper mReporter2 = channel.getReporter().getMReporter();
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        Intrinsics.checkNotNullExpressionValue(btnLeft, "dialog.btnLeft");
        mReporter2.g(btnLeft, "em_zplan_coin_insufficient_win_close", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        ZplanViewReportHelper mReporter3 = channel.getReporter().getMReporter();
        TextView btnight = qQCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight, "dialog.btnight");
        mReporter3.g(btnight, "em_zplan_coin_insufficient_win_confirm", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Resources resources = this.$context.getResources();
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.$context, 0, (String) null, resources.getString(R.string.xso), 0, 0, (DialogInterface.OnClickListener) null, (DialogInterface.OnClickListener) null);
        String string = resources.getString(R.string.f169768xi0);
        final Function1<Boolean, Unit> function1 = this.$callback;
        final com.tencent.sqshow.zootopia.nativeui.data.j jVar = this.$channel;
        createCustomDialog.setNegativeButton(string, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NativeUiDialogUtils$askNeedRecharge$1.d(Function1.this, jVar, createCustomDialog, dialogInterface, i3);
            }
        });
        String string2 = resources.getString(R.string.xsn);
        final Function1<Boolean, Unit> function12 = this.$callback;
        final com.tencent.sqshow.zootopia.nativeui.data.j jVar2 = this.$channel;
        createCustomDialog.setPositiveButton(string2, new DialogInterface.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                NativeUiDialogUtils$askNeedRecharge$1.e(Function1.this, jVar2, createCustomDialog, dialogInterface, i3);
            }
        });
        final com.tencent.sqshow.zootopia.nativeui.data.j jVar3 = this.$channel;
        final Context context = this.$context;
        createCustomDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.sqshow.zootopia.nativeui.dialog.f
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                NativeUiDialogUtils$askNeedRecharge$1.f(com.tencent.sqshow.zootopia.nativeui.data.j.this, context, createCustomDialog, dialogInterface);
            }
        });
        createCustomDialog.setMessageTextSize(NativeUiDialogUtils.f371177a.k());
        createCustomDialog.show();
    }
}
