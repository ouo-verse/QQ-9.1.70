package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.IQPlusTrafficHomePageDelegate;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.QPlusTrafficRepository;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.IQPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.cache.QPlusTrafficCache;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCoinAccount;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCouponAccount;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetAccountRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeAccountViewModel implements IQPlusTrafficCardHomeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeAccountViewModel.class, "coinStr", "getCoinStr()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeAccountViewModel.class, "couponStr", "getCouponStr()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeAccountViewModel.class, "uiState", "getUiState()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/define/QPlusTrafficUIState;", 0)};
    public final IQPlusTrafficHomePageDelegate pageDelegate;
    public final ReadWriteProperty coinStr$delegate = c.a("");
    public final ReadWriteProperty couponStr$delegate = c.a("");
    public final ReadWriteProperty uiState$delegate = c.a(QPlusTrafficUIState.LOADING);
    public String notifyCallbackRef = "";

    public QPlusTrafficHomeAccountViewModel(IQPlusTrafficHomePageDelegate iQPlusTrafficHomePageDelegate) {
        this.pageDelegate = iQPlusTrafficHomePageDelegate;
    }

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel
    public final QPlusTrafficHomeCardView getCardView() {
        return new QPlusTrafficHomeAccountView();
    }

    public final QPlusTrafficUIState getUiState() {
        return (QPlusTrafficUIState) this.uiState$delegate.getValue(this, $$delegatedProperties[2]);
    }

    public final void refresh() {
        QPlusTrafficRepository qPlusTrafficRepository = QPlusTrafficRepository.INSTANCE;
        refreshData((QPlusGetAccountRsp) IQPlusTrafficCache.DefaultImpls.getCache$default((QPlusTrafficCache) QPlusTrafficRepository.accountCache$delegate.getValue(), null, false, 3, null));
        qPlusTrafficRepository.reqAccountInfo(new Function1<QPlusGetAccountRsp, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel$refresh$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusGetAccountRsp qPlusGetAccountRsp) {
                QPlusTrafficHomeAccountViewModel.this.refreshData(qPlusGetAccountRsp);
                return Unit.INSTANCE;
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountViewModel$handleReqFailure$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Integer num, String str) {
                num.intValue();
                QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel = QPlusTrafficHomeAccountViewModel.this;
                ReadWriteProperty readWriteProperty = qPlusTrafficHomeAccountViewModel.coinStr$delegate;
                KProperty<?>[] kPropertyArr = QPlusTrafficHomeAccountViewModel.$$delegatedProperties;
                readWriteProperty.setValue(qPlusTrafficHomeAccountViewModel, kPropertyArr[0], "--");
                QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel2 = QPlusTrafficHomeAccountViewModel.this;
                qPlusTrafficHomeAccountViewModel2.couponStr$delegate.setValue(qPlusTrafficHomeAccountViewModel2, kPropertyArr[1], "--");
                QPlusTrafficHomeAccountViewModel qPlusTrafficHomeAccountViewModel3 = QPlusTrafficHomeAccountViewModel.this;
                qPlusTrafficHomeAccountViewModel3.uiState$delegate.setValue(qPlusTrafficHomeAccountViewModel3, kPropertyArr[2], QPlusTrafficUIState.FAILURE);
                return Unit.INSTANCE;
            }
        });
    }

    public final void refreshData(QPlusGetAccountRsp qPlusGetAccountRsp) {
        if (qPlusGetAccountRsp == null) {
            return;
        }
        QPlusCoinAccount qPlusCoinAccount = qPlusGetAccountRsp.coinAccount;
        String valueOf = String.valueOf(qPlusCoinAccount != null ? qPlusCoinAccount.coinAmount : 0);
        ReadWriteProperty readWriteProperty = this.coinStr$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], valueOf);
        QPlusCouponAccount qPlusCouponAccount = qPlusGetAccountRsp.couponAccount;
        this.couponStr$delegate.setValue(this, kPropertyArr[1], String.valueOf(qPlusCouponAccount != null ? qPlusCouponAccount.totalCouponCnt : 0));
        this.uiState$delegate.setValue(this, kPropertyArr[2], QPlusTrafficUIState.COMPLETED);
    }
}
