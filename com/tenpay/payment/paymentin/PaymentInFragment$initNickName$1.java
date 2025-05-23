package com.tenpay.payment.paymentin;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "currentNick", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class PaymentInFragment$initNickName$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ PaymentInFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaymentInFragment$initNickName$1(PaymentInFragment paymentInFragment) {
        super(1);
        this.this$0 = paymentInFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(PaymentInFragment this$0, String str) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        textView = this$0.nickNameView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickNameView");
            textView = null;
        }
        textView.setText(str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final PaymentInFragment paymentInFragment = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tenpay.payment.paymentin.g
            @Override // java.lang.Runnable
            public final void run() {
                PaymentInFragment$initNickName$1.invoke$lambda$0(PaymentInFragment.this, str);
            }
        });
    }
}
