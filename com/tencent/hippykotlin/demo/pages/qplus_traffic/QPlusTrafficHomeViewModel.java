package com.tencent.hippykotlin.demo.pages.qplus_traffic;

import c01.c;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusTrafficHomeDataViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video.QPlusTrafficHomeVideoViewModel;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.IQPlusTrafficHomePageDelegate;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPlusTrafficHomeViewModel.class, "cards", "getCards()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final QPlusTrafficHomeAccountViewModel accountViewModel;
    public final ReadWriteProperty cards$delegate = c.b();
    public final QPlusTrafficHomeDataViewModel dataViewModel;
    public final QPlusTrafficHomeOrderViewModel orderViewModel;
    public final IQPlusTrafficHomePageDelegate pageDelegate;
    public final Lazy videoViewModel$delegate;

    public QPlusTrafficHomeViewModel(IQPlusTrafficHomePageDelegate iQPlusTrafficHomePageDelegate) {
        Lazy lazy;
        this.pageDelegate = iQPlusTrafficHomePageDelegate;
        QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel = new QPlusTrafficHomeAccountViewModel(iQPlusTrafficHomePageDelegate);
        this.accountViewModel = qPlusTrafficHomeAccountViewModel;
        QPlusTrafficHomeDataViewModel qPlusTrafficHomeDataViewModel = new QPlusTrafficHomeDataViewModel();
        this.dataViewModel = qPlusTrafficHomeDataViewModel;
        QPlusTrafficHomeOrderViewModel qPlusTrafficHomeOrderViewModel = new QPlusTrafficHomeOrderViewModel();
        this.orderViewModel = qPlusTrafficHomeOrderViewModel;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPlusTrafficHomeVideoViewModel>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.QPlusTrafficHomeViewModel$videoViewModel$2
            @Override // kotlin.jvm.functions.Function0
            public final QPlusTrafficHomeVideoViewModel invoke() {
                return new QPlusTrafficHomeVideoViewModel(Utils.INSTANCE.currentBridgeModule().getCurrentAccount(), "", true, true);
            }
        });
        this.videoViewModel$delegate = lazy;
        getCards().add(getVideoViewModel());
        getCards().add(qPlusTrafficHomeAccountViewModel);
        getCards().add(qPlusTrafficHomeDataViewModel);
        getCards().add(qPlusTrafficHomeOrderViewModel);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<IQPlusTrafficCardHomeViewModel> getCards() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.cards$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final QPlusTrafficHomeVideoViewModel getVideoViewModel() {
        return (QPlusTrafficHomeVideoViewModel) this.videoViewModel$delegate.getValue();
    }
}
