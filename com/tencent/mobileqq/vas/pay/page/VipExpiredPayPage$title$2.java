package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/vas/pay/page/QVipRenewalTitle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
final class VipExpiredPayPage$title$2 extends Lambda implements Function0<QVipRenewalTitle> {
    final /* synthetic */ VipExpiredPayPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipExpiredPayPage$title$2(VipExpiredPayPage vipExpiredPayPage) {
        super(0);
        this.this$0 = vipExpiredPayPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipExpiredPayPage this$0, View view) {
        FragmentActivity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.onBackEvent() && (activity = this$0.getActivity()) != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QVipRenewalTitle invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QVipRenewalTitle qVipRenewalTitle = new QVipRenewalTitle(requireContext);
        final VipExpiredPayPage vipExpiredPayPage = this.this$0;
        qVipRenewalTitle.setLeftOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipExpiredPayPage$title$2.b(VipExpiredPayPage.this, view);
            }
        });
        return qVipRenewalTitle;
    }
}
