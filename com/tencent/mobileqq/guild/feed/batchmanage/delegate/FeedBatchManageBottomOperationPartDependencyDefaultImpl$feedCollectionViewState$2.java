package com.tencent.mobileqq.guild.feed.batchmanage.delegate;

import androidx.arch.core.util.Function;
import androidx.core.util.Supplier;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tencent.richframework.data.base.UIStateData;
import do1.b;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroidx/lifecycle/LiveData;", "Ldo1/a;", "", "", "invoke", "()Landroidx/lifecycle/LiveData;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedBatchManageBottomOperationPartDependencyDefaultImpl$feedCollectionViewState$2 extends Lambda implements Function0<LiveData<do1.a<? extends Collection<?>, Integer>>> {
    final /* synthetic */ FeedBatchManageBottomOperationPartDependencyDefaultImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBatchManageBottomOperationPartDependencyDefaultImpl$feedCollectionViewState$2(FeedBatchManageBottomOperationPartDependencyDefaultImpl feedBatchManageBottomOperationPartDependencyDefaultImpl) {
        super(0);
        this.this$0 = feedBatchManageBottomOperationPartDependencyDefaultImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final do1.a b(UIStateData uIStateData) {
        b bVar = new b();
        bVar.d(uIStateData.getData());
        bVar.e(uIStateData.getIsFinish());
        return bVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final LiveData<do1.a<? extends Collection<?>, Integer>> invoke() {
        Supplier supplier;
        LiveData<do1.a<? extends Collection<?>, Integer>> map;
        supplier = this.this$0.feedListUIStateProvider;
        LiveData liveData = (LiveData) supplier.get();
        return (liveData == null || (map = Transformations.map(liveData, new Function() { // from class: com.tencent.mobileqq.guild.feed.batchmanage.delegate.a
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                do1.a b16;
                b16 = FeedBatchManageBottomOperationPartDependencyDefaultImpl$feedCollectionViewState$2.b((UIStateData) obj);
                return b16;
            }
        })) == null) ? new MutableLiveData() : map;
    }
}
