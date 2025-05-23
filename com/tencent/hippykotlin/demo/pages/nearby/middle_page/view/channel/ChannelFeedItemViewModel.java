package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModel;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.card_view_model.BaseComposeCardViewModelKt;
import com.tencent.ntcompose.foundation.lazy.layout.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import l25.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ChannelFeedItemViewModel extends BaseComposeCardViewModel {
    public final c feed;
    public float offsetY;
    public final Function1<c, Unit> onClick;
    public final Function2<c, Float, Unit> onExpose;

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFeedItemViewModel(c cVar, Function2<? super c, ? super Float, Unit> function2, Function1<? super c, Unit> function1) {
        this.feed = cVar;
        this.onExpose = function2;
        this.onClick = function1;
        BaseComposeCardViewModelKt.setCardViewBuilder(this, ComposableLambdaKt.composableLambdaInstance(-1811432457, true, new Function5<a, BaseComposeCardViewModel, Integer, Composer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewModel.1
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final Unit invoke(a aVar, BaseComposeCardViewModel baseComposeCardViewModel, Integer num, Composer composer, Integer num2) {
                num.intValue();
                Composer composer2 = composer;
                int intValue = num2.intValue();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1811432457, intValue, -1, "com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.channel.ChannelFeedItemViewModel.<anonymous> (ChannelFeedItemViewModel.kt:15)");
                }
                ChannelFeedItemViewKt.ChannelFeedItemView(ChannelFeedItemViewModel.this, composer2, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                return Unit.INSTANCE;
            }
        }));
    }
}
