package com.tencent.hippykotlin.demo.pages.retain.viewModel;

import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes33.dex */
public final class RetainPopWindowLiveViewModel$countDown$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ RetainPopWindowLiveViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RetainPopWindowLiveViewModel$countDown$1(RetainPopWindowLiveViewModel retainPopWindowLiveViewModel) {
        super(0);
        this.this$0 = retainPopWindowLiveViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        if (this.this$0.getCountDownSecond() >= -1) {
            this.this$0.updateTimeInfo();
            RetainPopWindowLiveViewModel retainPopWindowLiveViewModel = this.this$0;
            retainPopWindowLiveViewModel.getClass();
            TimerKt.g(new RetainPopWindowLiveViewModel$countDown$1(retainPopWindowLiveViewModel), 500);
        }
        return Unit.INSTANCE;
    }
}
