package com.tencent.ecommerce.biz.consumer.model;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import cg0.a;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.Advertisement;
import com.tencent.ecommerce.repo.consumer.resp.CommentAdInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0014\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsCommentViewModel;", "Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel;", "", "visibility", "", "n0", "w", "Z", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "advertisement", "U", "T", "uiType", "p", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsCommentViewModel extends ECGoodsBaseViewModel {
    public ECGoodsCommentViewModel(Context context, ECContentInfo eCContentInfo) {
        super(context, eCContentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(int visibility) {
        ViewParent parent;
        ViewGroup wrapperView = getWrapperView();
        if (wrapperView == null || (parent = wrapperView.getParent()) == null) {
            return;
        }
        ((ViewGroup) parent).setVisibility(visibility);
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void T() {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsCommentViewModel$loadDataErrorOrEmpty$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECGoodsCommentViewModel.this.n0(8);
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void U(final Advertisement advertisement) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsCommentViewModel$loadDataSucces$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CommentAdInfo commentAd = advertisement.getCommentAd();
                if ((commentAd != null ? commentAd.getBaseUI() : null) != null) {
                    ECGoodsCommentViewModel.this.q(advertisement.getCommentAd().getBaseUI().getRichUiInfo(), ECGoodsCommentViewModel.this.w());
                    ECGoodsCommentViewModel.this.o();
                    if (ECGoodsCommentViewModel.this.getIsUIShowing()) {
                        ECGoodsCommentViewModel eCGoodsCommentViewModel = ECGoodsCommentViewModel.this;
                        eCGoodsCommentViewModel.p(eCGoodsCommentViewModel.w());
                        return;
                    }
                    return;
                }
                a.a(ECGoodsCommentViewModel.this.getTAG(), "loadDataSucces", ECGoodsCommentViewModel.this.getPRE_LOG() + "loadDataSucces error by commentAd or baseUI null");
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void Z() {
        if (Q()) {
            n0(8);
            return;
        }
        n0(0);
        o();
        j0(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void p(int uiType) {
        if (getAdvertisement() == null) {
            return;
        }
        super.p(uiType);
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public int w() {
        return 700;
    }
}
