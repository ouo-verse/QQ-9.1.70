package com.tencent.hippykotlin.demo.pages.qplus_traffic.video_select;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPVideoSelectViewModel$handleReqFailure$1 extends Lambda implements Function2<Integer, String, Unit> {
    public final /* synthetic */ QPVideoSelectViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QPVideoSelectViewModel$handleReqFailure$1(QPVideoSelectViewModel qPVideoSelectViewModel) {
        super(2);
        this.this$0 = qPVideoSelectViewModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Integer num, String str) {
        num.intValue();
        this.this$0.setUiState(QPlusTrafficUIState.FAILURE);
        return Unit.INSTANCE;
    }
}
