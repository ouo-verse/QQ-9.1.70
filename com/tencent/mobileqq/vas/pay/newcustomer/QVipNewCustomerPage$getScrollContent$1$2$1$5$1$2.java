package com.tencent.mobileqq.vas.pay.newcustomer;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.vas.pay.page.PreferentialItemAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QVipNewCustomerPage$getScrollContent$1$2$1$5$1$2 extends Lambda implements Function0<RecyclerView> {
    final /* synthetic */ QVipNewCustomerPage this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QVipNewCustomerPage$getScrollContent$1$2$1$5$1$2(QVipNewCustomerPage qVipNewCustomerPage) {
        super(0);
        this.this$0 = qVipNewCustomerPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QVipNewCustomerPage this$0, View view, int i3, int i16, int i17, int i18) {
        PreferentialItemAdapter Th;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.vm.G()) {
            Th = this$0.Th();
            Th.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final RecyclerView invoke() {
        PreferentialItemAdapter Th;
        RecyclerView recyclerView = new RecyclerView(this.this$0.requireContext());
        final QVipNewCustomerPage qVipNewCustomerPage = this.this$0;
        com.tencent.mobileqq.vas.pay.page.o.q(recyclerView, com.tencent.mobileqq.vas.pay.page.o.i(7));
        Th = qVipNewCustomerPage.Th();
        recyclerView.setAdapter(Th);
        com.tencent.mobileqq.vas.pay.page.a aVar = new com.tencent.mobileqq.vas.pay.page.a(qVipNewCustomerPage.requireContext(), 0, false);
        qVipNewCustomerPage.centerLayoutManager = aVar;
        recyclerView.setLayoutManager(aVar);
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.vas.pay.newcustomer.x
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i3, int i16, int i17, int i18) {
                QVipNewCustomerPage$getScrollContent$1$2$1$5$1$2.b(QVipNewCustomerPage.this, view, i3, i16, i17, i18);
            }
        });
        recyclerView.setClipToPadding(false);
        return recyclerView;
    }
}
