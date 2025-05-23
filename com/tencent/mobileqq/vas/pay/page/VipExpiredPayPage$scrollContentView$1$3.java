package com.tencent.mobileqq.vas.pay.page;

import android.content.Context;
import android.view.View;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/vas/pay/page/QvipRenewalPersonalInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VipExpiredPayPage$scrollContentView$1$3 extends Lambda implements Function0<QvipRenewalPersonalInfo> {
    final /* synthetic */ VipExpiredPayPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VipExpiredPayPage$scrollContentView$1$3(VipExpiredPayPage vipExpiredPayPage) {
        super(0);
        this.this$0 = vipExpiredPayPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipExpiredPayPage this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.vm.N(this$0.getActivity());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final QvipRenewalPersonalInfo invoke() {
        Context requireContext = this.this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        QvipRenewalPersonalInfo qvipRenewalPersonalInfo = new QvipRenewalPersonalInfo(requireContext);
        final VipExpiredPayPage vipExpiredPayPage = this.this$0;
        qvipRenewalPersonalInfo.setSubtitleClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.page.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipExpiredPayPage$scrollContentView$1$3.b(VipExpiredPayPage.this, view);
            }
        });
        return qvipRenewalPersonalInfo;
    }
}
