package com.tencent.mobileqq.wink.templatelibrary.meme.part;

import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.templatelibrary.meme.viewmodel.WinkMemeViewModel;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/tencent/mobileqq/wink/view/QCircleCommonLoadingDialog;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkMemeDetailPart$loadingView$2 extends Lambda implements Function0<QCircleCommonLoadingDialog> {
    final /* synthetic */ WinkMemeDetailPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMemeDetailPart$loadingView$2(WinkMemeDetailPart winkMemeDetailPart) {
        super(0);
        this.this$0 = winkMemeDetailPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean d() {
        return Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(WinkMemeDetailPart this$0, View view) {
        WinkMemeDetailPart$runnable$1 winkMemeDetailPart$runnable$1;
        WinkMemeViewModel S9;
        Unit unit;
        WinkMemeViewModel S92;
        WinkMemeViewModel S93;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        winkMemeDetailPart$runnable$1 = this$0.runnable;
        uIHandlerV2.removeCallbacks(winkMemeDetailPart$runnable$1);
        S9 = this$0.S9();
        String value = S9.c2().getValue();
        if (value != null) {
            S93 = this$0.S9();
            S93.d2(value);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            w53.b.g("WinkMemeDetailPart", "no taskId for Cancel");
        }
        S92 = this$0.S9();
        S92.T1();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final QCircleCommonLoadingDialog invoke() {
        QCircleCommonLoadingDialog.c d16 = new QCircleCommonLoadingDialog.c(this.this$0.getContext()).n(true).p("\u89c6\u9891\u751f\u6210\u4e2d").d(new Callable() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.j
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean d17;
                d17 = WinkMemeDetailPart$loadingView$2.d();
                return d17;
            }
        });
        final WinkMemeDetailPart winkMemeDetailPart = this.this$0;
        return d16.h(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.templatelibrary.meme.part.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMemeDetailPart$loadingView$2.e(WinkMemeDetailPart.this, view);
            }
        }).a();
    }
}
