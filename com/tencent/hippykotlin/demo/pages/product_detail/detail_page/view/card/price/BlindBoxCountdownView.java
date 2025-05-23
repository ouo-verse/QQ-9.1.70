package com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexAlign;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class BlindBoxCountdownView extends ComposeView<BlindBoxCountDownViewAttr, l> {
    public BlindBoxCountDownViewAttr viewAttr = new BlindBoxCountDownViewAttr();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class BlindBoxCountDownViewAttr extends k {
        public long countdownSec;
    }

    public static final Function1 access$createDescItemView(BlindBoxCountdownView blindBoxCountdownView, String str, float f16, float f17) {
        blindBoxCountdownView.getClass();
        return new BlindBoxCountdownView$createDescItemView$1(f16, f17, str);
    }

    public static final Function1 access$createTimeItemView(BlindBoxCountdownView blindBoxCountdownView, String str) {
        blindBoxCountdownView.getClass();
        return new BlindBoxCountdownView$createTimeItemView$1(str);
    }

    public static final String access$formatTime(BlindBoxCountdownView blindBoxCountdownView, long j3) {
        blindBoxCountdownView.getClass();
        if (j3 >= 10) {
            return String.valueOf(j3);
        }
        if (j3 > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append('0');
            sb5.append(j3);
            return sb5.toString();
        }
        return "00";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        long j3 = ((BlindBoxCountDownViewAttr) getAttr()).countdownSec;
        if (j3 <= 0) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxCountdownView$body$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        long j16 = 86400;
        final long j17 = j3 / j16;
        long j18 = 3600;
        final long j19 = (j3 % j16) / j18;
        long j26 = j3 % j18;
        long j27 = 60;
        final long j28 = j26 / j27;
        final long j29 = j3 % j27;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxCountdownView$body$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.product_detail.detail_page.view.card.price.BlindBoxCountdownView$body$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.alignItems(FlexAlign.CENTER);
                        mVar2.justifyContent(FlexJustifyContent.FLEX_END);
                        mVar2.mo153width(118.0f);
                        mVar2.mo141height(20.0f);
                        return Unit.INSTANCE;
                    }
                });
                BlindBoxCountdownView blindBoxCountdownView = BlindBoxCountdownView.this;
                ((BlindBoxCountdownView$createTimeItemView$1) BlindBoxCountdownView.access$createTimeItemView(blindBoxCountdownView, BlindBoxCountdownView.access$formatTime(blindBoxCountdownView, j17))).invoke(viewContainer2);
                ((BlindBoxCountdownView$createDescItemView$1) BlindBoxCountdownView.access$createDescItemView(BlindBoxCountdownView.this, "\u5929", 4.0f, 4.0f)).invoke(viewContainer2);
                BlindBoxCountdownView blindBoxCountdownView2 = BlindBoxCountdownView.this;
                ((BlindBoxCountdownView$createTimeItemView$1) BlindBoxCountdownView.access$createTimeItemView(blindBoxCountdownView2, BlindBoxCountdownView.access$formatTime(blindBoxCountdownView2, j19))).invoke(viewContainer2);
                ((BlindBoxCountdownView$createDescItemView$1) BlindBoxCountdownView.access$createDescItemView(BlindBoxCountdownView.this, ":", 2.0f, 2.0f)).invoke(viewContainer2);
                BlindBoxCountdownView blindBoxCountdownView3 = BlindBoxCountdownView.this;
                ((BlindBoxCountdownView$createTimeItemView$1) BlindBoxCountdownView.access$createTimeItemView(blindBoxCountdownView3, BlindBoxCountdownView.access$formatTime(blindBoxCountdownView3, j28))).invoke(viewContainer2);
                ((BlindBoxCountdownView$createDescItemView$1) BlindBoxCountdownView.access$createDescItemView(BlindBoxCountdownView.this, ":", 2.0f, 2.0f)).invoke(viewContainer2);
                BlindBoxCountdownView blindBoxCountdownView4 = BlindBoxCountdownView.this;
                ((BlindBoxCountdownView$createTimeItemView$1) BlindBoxCountdownView.access$createTimeItemView(blindBoxCountdownView4, BlindBoxCountdownView.access$formatTime(blindBoxCountdownView4, j29))).invoke(viewContainer2);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
