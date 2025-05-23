package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class ZplanPagHolderView$runAfterPagViewReady$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Runnable $runnable;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZplanPagHolderView$runAfterPagViewReady$1(Runnable runnable) {
        super(0);
        this.$runnable = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        QLog.d("ZplanPagHolderView", 1, "pag file ready, do action ");
        runnable.run();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Runnable runnable = this.$runnable;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.card.impl.view.banner.l
            @Override // java.lang.Runnable
            public final void run() {
                ZplanPagHolderView$runAfterPagViewReady$1.b(runnable);
            }
        });
    }
}
