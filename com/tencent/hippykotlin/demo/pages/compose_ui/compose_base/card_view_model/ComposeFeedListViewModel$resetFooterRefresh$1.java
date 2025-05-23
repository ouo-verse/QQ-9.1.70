package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model;

import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ComposeFeedListViewModel$resetFooterRefresh$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ Function0<Unit> $resetCompletion;
    public final /* synthetic */ ComposeFeedListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposeFeedListViewModel$resetFooterRefresh$1(ComposeFeedListViewModel composeFeedListViewModel, Function0<Unit> function0) {
        super(0);
        this.this$0 = composeFeedListViewModel;
        this.$resetCompletion = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.this$0.disableFooterRefresh.setValue(Boolean.FALSE);
        final Function0<Unit> function0 = this.$resetCompletion;
        TimerKt.c(16, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.ComposeFeedListViewModel$resetFooterRefresh$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
