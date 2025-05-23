package com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.global.GlobalFunctions;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class LBPCountdownText extends ComposeView<LBPCountdownTextAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(LBPCountdownText.class, "leftTimeInfo", "getLeftTimeInfo()Ljava/lang/String;", 0)};
    public final ReadWriteProperty leftTimeInfo$delegate = c.a("");
    public String timeCallbackRef = "";

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPCountdownText$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final LBPCountdownText lBPCountdownText = LBPCountdownText.this;
                cg.a(viewContainer, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPCountdownText$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final LBPCountdownText lBPCountdownText2 = LBPCountdownText.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qlive.lucky_bag_pendant_page.LBPCountdownText.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 8.0f, null, 2, null);
                                ceVar2.color(h.INSTANCE.m());
                                ceVar2.fontFamily("EurostileNextPro-SemiBold");
                                LBPCountdownText lBPCountdownText3 = LBPCountdownText.this;
                                ceVar2.text((String) lBPCountdownText3.leftTimeInfo$delegate.getValue(lBPCountdownText3, LBPCountdownText.$$delegatedProperties[0]));
                                ceVar2.lines(1);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new LBPCountdownTextAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        Utils.INSTANCE.bridgeModule(getPagerId()).localServeTime(new LBPCountdownText$startTimer$1(this));
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        if (this.timeCallbackRef.length() > 0) {
            GlobalFunctions.f117252a.c(getPagerId(), this.timeCallbackRef);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int leftTime(int i3) {
        double d16 = ((LBPCountdownTextAttr) getAttr()).endTime - (i3 + ((LBPCountdownTextAttr) getAttr()).localTimeDiffServe);
        if (d16 < 0.0d) {
            return 0;
        }
        return (int) d16;
    }
}
