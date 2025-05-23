package com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/detail/presentation/ECOrderDetailOperation;", "", "Landroid/content/Context;", "context", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "a", "content", "Lkotlin/Function0;", "", "onDismiss", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderDetailOperation {

    /* renamed from: a, reason: collision with root package name */
    public static final ECOrderDetailOperation f103235a = new ECOrderDetailOperation();

    ECOrderDetailOperation() {
    }

    public final String a(Context context, String orderId) {
        Object systemService = context.getSystemService("clipboard");
        if (!(systemService instanceof ClipboardManager)) {
            systemService = null;
        }
        ClipboardManager clipboardManager = (ClipboardManager) systemService;
        ClipData newPlainText = ClipData.newPlainText(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, orderId);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, newPlainText);
            i.f101155b.d(context.getString(R.string.wiu), ECToastIcon.ICON_SUCCESS, 0);
        }
        return QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID;
    }

    public final void b(final Context context, final String content, final Function0<Unit> onDismiss) {
        com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(context);
        gVar.Y(content);
        gVar.b0("");
        gVar.f0(context.getString(R.string.wo7));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailOperation$showAlertDialog$$inlined$also$lambda$1
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
                Function0 function0 = onDismiss;
                if (function0 != null) {
                }
            }
        });
        gVar.c0(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.buyerorders.detail.presentation.ECOrderDetailOperation$showAlertDialog$$inlined$also$lambda$2
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
                Function0 function0 = onDismiss;
                if (function0 != null) {
                }
            }
        });
        gVar.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(ECOrderDetailOperation eCOrderDetailOperation, Context context, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        eCOrderDetailOperation.b(context, str, function0);
    }
}
