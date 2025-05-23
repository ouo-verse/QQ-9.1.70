package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LBPCountdownText$startTimer$1 extends Lambda implements Function1<e, Unit> {
    public final /* synthetic */ LBPCountdownText this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LBPCountdownText$startTimer$1(LBPCountdownText lBPCountdownText) {
        super(1);
        this.this$0 = lBPCountdownText;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(e eVar) {
        e eVar2 = eVar;
        Intrinsics.checkNotNull(eVar2);
        int h16 = (int) eVar2.h("time");
        LBPCountdownText lBPCountdownText = this.this$0;
        int leftTime = lBPCountdownText.leftTime(h16);
        int i3 = leftTime % 60;
        String valueOf = String.valueOf(i3);
        if (i3 < 10) {
            valueOf = '0' + valueOf;
        }
        int i16 = leftTime / 60;
        String valueOf2 = String.valueOf(i16);
        if (i16 < 10) {
            valueOf2 = '0' + valueOf2;
        }
        lBPCountdownText.leftTimeInfo$delegate.setValue(lBPCountdownText, LBPCountdownText.$$delegatedProperties[0], valueOf2 + ':' + valueOf);
        if (this.this$0.leftTime(h16) > 0) {
            LBPCountdownText lBPCountdownText2 = this.this$0;
            String pagerId = lBPCountdownText2.getPagerId();
            final LBPCountdownText lBPCountdownText3 = this.this$0;
            lBPCountdownText2.timeCallbackRef = TimerKt.e(pagerId, 1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPCountdownText$startTimer$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    LBPCountdownText lBPCountdownText4 = LBPCountdownText.this;
                    KProperty<Object>[] kPropertyArr = LBPCountdownText.$$delegatedProperties;
                    lBPCountdownText4.getClass();
                    Utils.INSTANCE.bridgeModule(lBPCountdownText4.getPagerId()).localServeTime(new LBPCountdownText$startTimer$1(lBPCountdownText4));
                    return Unit.INSTANCE;
                }
            });
        } else {
            this.this$0.timeCallbackRef = "";
        }
        return Unit.INSTANCE;
    }
}
