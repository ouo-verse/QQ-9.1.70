package com.tencent.ecommerce.base.list;

import androidx.lifecycle.ViewModelProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006H\n\u00a2\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "VM", "Landroidx/lifecycle/ViewModel;", "REQUEST", "BEAN", "COOKIE", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class ListViewModelLazyKt$listViewModels$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ d $factoryPromise;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListViewModelLazyKt$listViewModels$2(d dVar) {
        super(0);
        this.$factoryPromise = dVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return this.$factoryPromise;
    }
}
