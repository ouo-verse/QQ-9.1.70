package com.tencent.ecommerce.biz.showwindow.repo.window;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.showwindow.repo.window.ECShowWindowAddProductRsp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
final class ECShowWindowAddProductRsp$Companion$showMessageBox$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ECShowWindowAddProductRsp.a $respMsgInfo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECShowWindowAddProductRsp$Companion$showMessageBox$1(ECShowWindowAddProductRsp.a aVar, Context context) {
        super(0);
        this.$respMsgInfo = aVar;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        final String title = this.$respMsgInfo.getTitle();
        final String text = this.$respMsgInfo.getText();
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(this.$context);
        gVar.setTitle(text.length() == 0 ? "" : title);
        gVar.Y(text.length() == 0 ? title : text);
        gVar.b0(this.$respMsgInfo.getLeftBtnText());
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.repo.window.ECShowWindowAddProductRsp$Companion$showMessageBox$1$$special$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g(ECShowWindowAddProductRsp$Companion$showMessageBox$1.this.$respMsgInfo.getLeftBtnUrl(), null, 2, null);
                cg0.a.b("ECShowWindowAddProductRsp", "[showMessageBox] leftBtnUrl = " + ECShowWindowAddProductRsp$Companion$showMessageBox$1.this.$respMsgInfo.getLeftBtnUrl());
            }
        });
        gVar.f0(this.$respMsgInfo.getRightBtnText());
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.repo.window.ECShowWindowAddProductRsp$Companion$showMessageBox$1$$special$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g(ECShowWindowAddProductRsp$Companion$showMessageBox$1.this.$respMsgInfo.getRightBtnUrl(), null, 2, null);
                cg0.a.b("ECShowWindowAddProductRsp", "[showMessageBox] rightBtnUrl = " + ECShowWindowAddProductRsp$Companion$showMessageBox$1.this.$respMsgInfo.getRightBtnUrl());
            }
        });
        gVar.show();
    }
}
