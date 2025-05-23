package com.tencent.ecommerce.biz.register.refactoring.fragment;

import cg0.a;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECWxAuthSuccessEvent;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/e;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1 implements EventObserver<ECWxAuthSuccessEvent> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECommerceSettleAuthenticationFragment f104097d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1(ECommerceSettleAuthenticationFragment eCommerceSettleAuthenticationFragment) {
        this.f104097d = eCommerceSettleAuthenticationFragment;
    }

    @Override // com.tencent.ecommerce.base.eventbus.EventObserver
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onEvent(final ECWxAuthSuccessEvent event) {
        a.b("ECommerceSettleAuthenticationFragment", "[EventObserver] isSuccessWxAuth = " + event.isSuccessWxAuth + " nickName = " + event.nickName);
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1$onEvent$1
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
                ECommerceSettleAuthenticationFragment.Oh(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d).dismiss();
                if (event.isSuccessWxAuth) {
                    ECommerceSettleAuthenticationFragment.Rh(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d).setText(event.nickName);
                    ECommerceSettleAuthenticationFragment.Ph(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d).setVisibility(4);
                    ECommerceSettleAuthenticationFragment.Mh(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d).setEnabled(event.isSuccessWxAuth);
                } else {
                    ECommerceSettleAuthenticationFragment.Rh(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d).setText(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d.getResources().getString(R.string.wub));
                    Integer color = ECSkin.INSTANCE.getColor("qecommerce_skin_color_text_secondary");
                    if (color != null) {
                        ECommerceSettleAuthenticationFragment.Qh(ECommerceSettleAuthenticationFragment$successWxAuthEventObserve$1.this.f104097d).setTextColor(color.intValue());
                    }
                }
            }
        });
    }
}
