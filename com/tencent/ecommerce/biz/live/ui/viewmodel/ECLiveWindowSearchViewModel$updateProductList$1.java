package com.tencent.ecommerce.biz.live.ui.viewmodel;

import cg0.a;
import com.tencent.ecommerce.repo.live.LiveProduct;
import com.tencent.ecommerce.repo.live.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/repo/live/k$d;", "pageResponse", "", "invoke", "(Lcom/tencent/ecommerce/repo/live/k$d;)V", "onResponse"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowSearchViewModel$updateProductList$1 extends Lambda implements Function1<k.PageResponse, Unit> {
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ ECLiveWindowSearchViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSearchViewModel$updateProductList$1(ECLiveWindowSearchViewModel eCLiveWindowSearchViewModel, boolean z16) {
        super(1);
        this.this$0 = eCLiveWindowSearchViewModel;
        this.$isLoadMore = z16;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(k.PageResponse pageResponse) {
        invoke2(pageResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(k.PageResponse pageResponse) {
        AtomicInteger atomicInteger;
        List<LiveProduct> b16;
        atomicInteger = this.this$0._refreshStatus;
        if (atomicInteger.get() != 1) {
            return;
        }
        if (!pageResponse.result.isSuccess) {
            this.this$0.f2(3);
            a.a("ECLiveWindowSearchViewModel", "updateProductList", "rsp error, code=" + pageResponse.result.code + ", msg=" + pageResponse.result.msg);
            return;
        }
        this.this$0.getIsListEnd().set(pageResponse.isEnd);
        LiveProduct liveProduct = pageResponse.topProduct;
        if (liveProduct != null) {
            b16 = CollectionsKt__CollectionsKt.mutableListOf(liveProduct);
            b16.addAll(pageResponse.b());
        } else {
            b16 = pageResponse.b();
        }
        this.this$0.e2(b16, this.$isLoadMore);
        this.this$0.f2(2);
        a.b("ECLiveWindowSearchViewModel", "updateProductList onSuccess,tabInfo: " + ECLiveWindowSearchViewModel.O1(this.this$0) + TokenParser.SP + "listSize:" + pageResponse.b().size() + TokenParser.SP);
    }
}
