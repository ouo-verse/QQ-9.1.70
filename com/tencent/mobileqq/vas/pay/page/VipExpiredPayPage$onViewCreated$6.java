package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dialogInfo", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipExpiredPayPage$onViewCreated$6 extends Lambda implements Function1<RenewalPageToggleConfig.DialogCall, Unit> {
    final /* synthetic */ VipExpiredPayPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipExpiredPayPage$onViewCreated$6(VipExpiredPayPage vipExpiredPayPage) {
        super(1);
        this.this$0 = vipExpiredPayPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VipExpiredPayPage this$0, RenewalPageToggleConfig.DialogCall dialogCall, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        Intent intent = new Intent(this$0.getContext(), (Class<?>) QQBrowserActivity.class);
        intent.setFlags(268435456);
        VasWebviewUtil.openQQBrowserActivity(this$0.getContext(), dialogCall.getJumpUrl(), -1L, intent, false, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(VipExpiredPayPage this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.vm.P(this$0.getActivity(), false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenewalPageToggleConfig.DialogCall dialogCall) {
        invoke2(dialogCall);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final RenewalPageToggleConfig.DialogCall dialogCall) {
        QLog.i(VipExpiredPayPage.S, 1, "observe phone call dialog > " + dialogCall);
        if (dialogCall == null) {
            return;
        }
        Context requireContext = this.this$0.requireContext();
        String title = dialogCall.getTitle();
        String content = dialogCall.getContent();
        String confirm = dialogCall.getConfirm();
        String cancel = dialogCall.getCancel();
        final VipExpiredPayPage vipExpiredPayPage = this.this$0;
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.aa
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VipExpiredPayPage$onViewCreated$6.c(VipExpiredPayPage.this, dialogCall, dialogInterface, i3);
            }
        };
        final VipExpiredPayPage vipExpiredPayPage2 = this.this$0;
        DialogUtil.createCustomDialog(requireContext, 230, title, content, confirm, cancel, onClickListener, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.ab
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VipExpiredPayPage$onViewCreated$6.d(VipExpiredPayPage.this, dialogInterface, i3);
            }
        }).show();
    }
}
