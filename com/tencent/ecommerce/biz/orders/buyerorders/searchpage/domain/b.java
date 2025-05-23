package com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/b;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "a", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "searchScene", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b implements ViewModelProvider.Factory {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ECOrderSearchScene searchScene;

    public b(ECOrderSearchScene eCOrderSearchScene) {
        this.searchScene = eCOrderSearchScene;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return new a(this.searchScene);
    }
}
