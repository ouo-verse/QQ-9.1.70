package com.tencent.ecommerce.biz.live.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import cg0.a;
import ci0.ECLiveWindowContentSizeChangeEvent;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.repo.live.LiveCouponDetail;
import com.tencent.ecommerce.repo.live.k;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/repo/live/k$d;", "pageResponse", "", "invoke", "(Lcom/tencent/ecommerce/repo/live/k$d;)V", "onResponse"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveWindowSubViewModel$updateProductList$1 extends Lambda implements Function1<k.PageResponse, Unit> {
    final /* synthetic */ String $couponId;
    final /* synthetic */ boolean $isLoadMore;
    final /* synthetic */ String $successToast;
    final /* synthetic */ ECLiveWindowSubViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECLiveWindowSubViewModel$updateProductList$1(ECLiveWindowSubViewModel eCLiveWindowSubViewModel, boolean z16, String str, String str2) {
        super(1);
        this.this$0 = eCLiveWindowSubViewModel;
        this.$isLoadMore = z16;
        this.$couponId = str;
        this.$successToast = str2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(k.PageResponse pageResponse) {
        invoke2(pageResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(k.PageResponse pageResponse) {
        AtomicInteger atomicInteger;
        boolean isBlank;
        boolean isBlank2;
        MutableLiveData mutableLiveData;
        atomicInteger = this.this$0._refreshStatus;
        boolean z16 = true;
        if (atomicInteger.get() != 1) {
            return;
        }
        if (!pageResponse.result.isSuccess) {
            this.this$0.Q2(3);
            ECLiveWindowSubViewModel eCLiveWindowSubViewModel = this.this$0;
            k.CommonResponse commonResponse = pageResponse.result;
            eCLiveWindowSubViewModel.l2(commonResponse.code, commonResponse.msg);
            a.a(ECLiveWindowSubViewModel.S1(this.this$0), "updateProductList", "rsp error, code=" + pageResponse.result.code + ", msg=" + pageResponse.result.msg);
            return;
        }
        this.this$0.getIsListEnd().set(pageResponse.isEnd);
        a.b(ECLiveWindowSubViewModel.S1(this.this$0), "updateProductList onSuccess,tabInfo: " + ECLiveWindowSubViewModel.W1(this.this$0) + TokenParser.SP + "listSize:" + pageResponse.b().size() + TokenParser.SP);
        this.this$0.O2(pageResponse.b(), this.$isLoadMore);
        if (!this.$isLoadMore && ECLiveWindowSubViewModel.W1(this.this$0).id == LiveTabId.LIVE_TAB_GOK) {
            this.this$0.K2(pageResponse.topProduct, null);
            this.this$0.J2(null);
        }
        if (!this.$isLoadMore && ECLiveWindowSubViewModel.U1(this.this$0).f() != null) {
            this.this$0.D2(2);
        }
        String str = this.$couponId;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if ((!isBlank2) && (pageResponse.getExtra() instanceof LiveCouponDetail)) {
                mutableLiveData = this.this$0._liveCouponLabelLiveData;
                mutableLiveData.postValue(pageResponse.getExtra());
            }
        }
        this.this$0.Q2(2);
        String str2 = this.$successToast;
        if (str2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank) {
                z16 = false;
            }
        }
        if (!z16) {
            i.f101155b.d(this.$successToast, ECToastIcon.ICON_SUCCESS, 0);
        }
        if (ECLiveWindowSubViewModel.W1(this.this$0).id == LiveTabId.LIVE_TAB_COUPON) {
            LifecycleEventBus.f100688b.f(new ECLiveWindowContentSizeChangeEvent(ECLiveWindowSubViewModel.W1(this.this$0).id, pageResponse.totalCount));
        }
    }
}
