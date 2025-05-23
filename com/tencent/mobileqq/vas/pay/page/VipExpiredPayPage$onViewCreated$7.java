package com.tencent.mobileqq.vas.pay.page;

import android.content.DialogInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.vas.pay.page.bean.RenewalPageToggleConfig;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "dialogInfo", "Lcom/tencent/mobileqq/vas/pay/page/bean/RenewalPageToggleConfig$DialogCall;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipExpiredPayPage$onViewCreated$7 extends Lambda implements Function1<RenewalPageToggleConfig.DialogCall, Unit> {
    final /* synthetic */ VipExpiredPayPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipExpiredPayPage$onViewCreated$7(VipExpiredPayPage vipExpiredPayPage) {
        super(1);
        this.this$0 = vipExpiredPayPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenewalPageToggleConfig.DialogCall dialogCall) {
        invoke2(dialogCall);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable RenewalPageToggleConfig.DialogCall dialogCall) {
        QLog.i(VipExpiredPayPage.S, 1, "observe call dialog 2099 > " + dialogCall);
        if (dialogCall == null) {
            return;
        }
        DialogUtil.createCustomDialog(this.this$0.requireContext(), 230, dialogCall.getTitle(), dialogCall.getContent(), dialogCall.getConfirm(), dialogCall.getCancel(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VipExpiredPayPage$onViewCreated$7.c(dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.ad
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                VipExpiredPayPage$onViewCreated$7.d(dialogInterface, i3);
            }
        }).show();
    }
}
