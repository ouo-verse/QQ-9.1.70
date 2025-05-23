package com.tencent.mobileqq.cardcontainer.framework;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.cardcontainer.framework.CardsViewModelImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/mobileqq/cardcontainer/data/a;", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class CardContainerView$initData$2 extends Lambda implements Function1<List<? extends com.tencent.mobileqq.cardcontainer.data.a>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ CardContainerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardContainerView$initData$2(CardContainerView cardContainerView) {
        super(1);
        this.this$0 = cardContainerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cardContainerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CardContainerView this$0) {
        boolean x16;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x16 = this$0.x();
        if (x16) {
            recyclerView = this$0.recyclerView;
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPosition(0);
            }
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.cardcontainer.data.a> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends com.tencent.mobileqq.cardcontainer.data.a> it) {
        CardsAdapter cardsAdapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CardContainer.CardContainerView", 2, "[observe] cards updated: " + it.size());
            CardsViewModelImpl.Companion companion = CardsViewModelImpl.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            companion.c("Card-Data-Changed", it);
        }
        if (it.isEmpty()) {
            com.tencent.mobileqq.cardcontainer.h p16 = this.this$0.p();
            if (p16 != null) {
                p16.b();
            }
        } else {
            com.tencent.mobileqq.cardcontainer.h p17 = this.this$0.p();
            if (p17 != null) {
                p17.a();
            }
        }
        cardsAdapter = this.this$0.adapter;
        ArrayList arrayList = new ArrayList(it);
        final CardContainerView cardContainerView = this.this$0;
        cardsAdapter.submitList(arrayList, new Runnable() { // from class: com.tencent.mobileqq.cardcontainer.framework.c
            @Override // java.lang.Runnable
            public final void run() {
                CardContainerView$initData$2.b(CardContainerView.this);
            }
        });
        this.this$0.o();
    }
}
