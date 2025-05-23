package com.tencent.mobileqq.vas.pay.newcustomer;

import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipBottomBtn;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class QVipNewCustomerPage$bottomBtn$2 extends Lambda implements Function0<QVipBottomBtn> {
    final /* synthetic */ QVipNewCustomerPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipNewCustomerPage$bottomBtn$2(QVipNewCustomerPage qVipNewCustomerPage) {
        super(0);
        this.this$0 = qVipNewCustomerPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QVipNewCustomerPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vm.W();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QVipBottomBtn invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QVipBottomBtn qVipBottomBtn = new QVipBottomBtn(requireContext);
        final QVipNewCustomerPage qVipNewCustomerPage = this.this$0;
        qVipBottomBtn.setGotoOfficialWebBtnClick(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QVipNewCustomerPage$bottomBtn$2.b(QVipNewCustomerPage.this, view);
            }
        });
        return qVipBottomBtn;
    }
}
