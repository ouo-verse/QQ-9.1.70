package com.tencent.mobileqq.vas.pay.newcustomer;

import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/vas/pay/newcustomer/QVipUserInfoCard;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QVipNewCustomerPage$getScrollContent$1$2$1$1 extends Lambda implements Function0<QVipUserInfoCard> {
    final /* synthetic */ Context $context;
    final /* synthetic */ QVipNewCustomerPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipNewCustomerPage$getScrollContent$1$2$1$1(Context context, QVipNewCustomerPage qVipNewCustomerPage) {
        super(0);
        this.$context = context;
        this.this$0 = qVipNewCustomerPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(QVipNewCustomerPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vm.b0(this$0.getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QVipNewCustomerPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QVipNewCustomerViewModel.g0(this$0.vm, false, 1, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QVipUserInfoCard invoke() {
        QVipUserInfoCard qVipUserInfoCard = new QVipUserInfoCard(this.$context);
        final QVipNewCustomerPage qVipNewCustomerPage = this.this$0;
        qVipUserInfoCard.setPayBtnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QVipNewCustomerPage$getScrollContent$1$2$1$1.c(QVipNewCustomerPage.this, view);
            }
        });
        qVipUserInfoCard.setGetSVipExperienceClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QVipNewCustomerPage$getScrollContent$1$2$1$1.d(QVipNewCustomerPage.this, view);
            }
        });
        return qVipUserInfoCard;
    }
}
