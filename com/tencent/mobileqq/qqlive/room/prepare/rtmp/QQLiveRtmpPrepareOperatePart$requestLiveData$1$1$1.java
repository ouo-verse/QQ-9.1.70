package com.tencent.mobileqq.qqlive.room.prepare.rtmp;

import android.os.Handler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqecommerce.biz.live.api.QQECLiveEntryGoodsData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "result", "Lcom/tencent/mobileqq/qqecommerce/biz/live/api/QQECLiveEntryGoodsData;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQLiveRtmpPrepareOperatePart$requestLiveData$1$1$1 extends Lambda implements Function1<QQECLiveEntryGoodsData, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ com.tencent.mobileqq.qqlive.room.prepare.k $viewModel;
    final /* synthetic */ QQLiveRtmpPrepareOperatePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveRtmpPrepareOperatePart$requestLiveData$1$1$1(QQLiveRtmpPrepareOperatePart qQLiveRtmpPrepareOperatePart, com.tencent.mobileqq.qqlive.room.prepare.k kVar) {
        super(1);
        this.this$0 = qQLiveRtmpPrepareOperatePart;
        this.$viewModel = kVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveRtmpPrepareOperatePart, (Object) kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.mobileqq.qqlive.room.prepare.k viewModel, QQECLiveEntryGoodsData result, QQLiveRtmpPrepareOperatePart this$0) {
        boolean R9;
        int N9;
        int M9;
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        viewModel.S = result;
        R9 = this$0.R9();
        if (R9) {
            boolean g26 = viewModel.g2();
            N9 = this$0.N9();
            M9 = this$0.M9();
            this$0.da(g26, N9, M9);
        }
        QLog.d(this$0.getTAG(), 2, "requestLiveData LIVE_SCHEME_TYPE_ENTRY respData:" + viewModel.S);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(QQECLiveEntryGoodsData qQECLiveEntryGoodsData) {
        invoke2(qQECLiveEntryGoodsData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final QQECLiveEntryGoodsData result) {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.d(this.this$0.getTAG(), 2, "requestLiveData LIVE_SCHEME_TYPE_ENTRY success");
        handler = this.this$0.uiHandler;
        final com.tencent.mobileqq.qqlive.room.prepare.k kVar = this.$viewModel;
        final QQLiveRtmpPrepareOperatePart qQLiveRtmpPrepareOperatePart = this.this$0;
        handler.post(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.rtmp.v
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveRtmpPrepareOperatePart$requestLiveData$1$1$1.b(com.tencent.mobileqq.qqlive.room.prepare.k.this, result, qQLiveRtmpPrepareOperatePart);
            }
        });
    }
}
