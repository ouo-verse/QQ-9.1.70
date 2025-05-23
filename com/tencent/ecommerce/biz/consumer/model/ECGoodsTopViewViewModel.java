package com.tencent.ecommerce.biz.consumer.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.view.topview.ECTopViewCardView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.Advertisement;
import com.tencent.ecommerce.repo.consumer.resp.PlayInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lh0.a;
import lh0.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0002H\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsTopViewViewModel;", "Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel;", "", "visibility", "", "r0", "", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "playInfoList", "p0", "Llh0/a;", "event", "q0", "w", "Z", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "advertisement", "U", "T", "sendEvent", "uiType", "p", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsTopViewViewModel extends ECGoodsBaseViewModel {
    public ECGoodsTopViewViewModel(Context context, ECContentInfo eCContentInfo) {
        super(context, eCContentInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PlayInfo p0(List<PlayInfo> playInfoList) {
        for (PlayInfo playInfo : playInfoList) {
            int playType = playInfo.getPlayPlan().getPlayType();
            if (playType != 0 && playType == 3) {
                return playInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(a event) {
        View view = D(w()).getView();
        if (view instanceof ECTopViewCardView) {
            ECTopViewCardView eCTopViewCardView = (ECTopViewCardView) view;
            if (event != null) {
                eCTopViewCardView.v((b) event);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.event.ECTopViewEvent");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r0(int visibility) {
        ViewParent parent;
        ViewGroup wrapperView = getWrapperView();
        if (wrapperView == null || (parent = wrapperView.getParent()) == null) {
            return;
        }
        ((ViewGroup) parent).setVisibility(visibility);
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void T() {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsTopViewViewModel$loadDataErrorOrEmpty$1
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
                ECGoodsTopViewViewModel.this.r0(8);
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void U(final Advertisement advertisement) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsTopViewViewModel$loadDataSucces$1
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
                PlayInfo p06;
                try {
                    if (!advertisement.getVideoAd().getPlayInfos().isEmpty()) {
                        p06 = ECGoodsTopViewViewModel.this.p0(advertisement.getVideoAd().getPlayInfos());
                        if (p06 != null) {
                            ECGoodsTopViewViewModel eCGoodsTopViewViewModel = ECGoodsTopViewViewModel.this;
                            eCGoodsTopViewViewModel.q(eCGoodsTopViewViewModel.M(p06.getUi()), p06.getUi().getUiType());
                            oh0.a.f422682b.c(ECGoodsTopViewViewModel.this.getContentInfo().getContentId());
                        }
                        ECGoodsTopViewViewModel.this.o();
                        if (ECGoodsTopViewViewModel.this.getIsUIShowing()) {
                            ECGoodsTopViewViewModel eCGoodsTopViewViewModel2 = ECGoodsTopViewViewModel.this;
                            eCGoodsTopViewViewModel2.p(eCGoodsTopViewViewModel2.w());
                            return;
                        }
                        return;
                    }
                    cg0.a.a(ECGoodsTopViewViewModel.this.getTAG(), "loadDataSucces", ECGoodsTopViewViewModel.this.getPRE_LOG() + "loadDataSucces error by playInfos null");
                } catch (Exception unused) {
                    cg0.a.a(ECGoodsTopViewViewModel.this.getTAG(), "loadDataSucces", ECGoodsTopViewViewModel.this.getPRE_LOG() + "loadDataSucces error exception by by playInfos null");
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public void Z() {
        if (Q()) {
            r0(8);
            return;
        }
        r0(0);
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

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel, com.tencent.ecommerce.biz.consumer.event.IECEvent
    public void sendEvent(final a event) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsTopViewViewModel$sendEvent$1
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
                ECGoodsTopViewViewModel.this.q0(event);
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel
    public int w() {
        return PlayUI.UIType.TOP_VIEW;
    }
}
