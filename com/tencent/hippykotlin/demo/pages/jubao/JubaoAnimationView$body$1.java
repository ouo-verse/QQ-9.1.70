package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoAnimationView$body$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ JubaoAnimationView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JubaoAnimationView$body$1(JubaoAnimationView jubaoAnimationView) {
        super(1);
        this.this$0 = jubaoAnimationView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final JubaoAnimationView jubaoAnimationView = this.this$0;
        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView$body$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(m mVar) {
                boolean booleanValue;
                boolean booleanValue2;
                boolean booleanValue3;
                m mVar2 = mVar;
                booleanValue = ((Boolean) r0.translateAnimationFlag$delegate.getValue(JubaoAnimationView.this, JubaoAnimationView.$$delegatedProperties[0])).booleanValue();
                if (booleanValue) {
                    mVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    b f16 = b.Companion.f(b.INSTANCE, 0.2f, null, 2, null);
                    booleanValue3 = ((Boolean) r1.translateAnimationFlag$delegate.getValue(JubaoAnimationView.this, JubaoAnimationView.$$delegatedProperties[0])).booleanValue();
                    mVar2.m134animation(f16, (Object) Boolean.valueOf(booleanValue3));
                } else {
                    mVar2.transform(new y(1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    b f17 = b.Companion.f(b.INSTANCE, 0.2f, null, 2, null);
                    booleanValue2 = ((Boolean) r1.translateAnimationFlag$delegate.getValue(JubaoAnimationView.this, JubaoAnimationView.$$delegatedProperties[0])).booleanValue();
                    mVar2.m134animation(f17, (Object) Boolean.valueOf(booleanValue2));
                }
                return Unit.INSTANCE;
            }
        });
        final JubaoAnimationView jubaoAnimationView2 = this.this$0;
        viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView$body$1.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Event event) {
                final JubaoAnimationView jubaoAnimationView3 = JubaoAnimationView.this;
                event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView.body.1.2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                        boolean booleanValue;
                        Function0<Unit> function0;
                        booleanValue = ((Boolean) r1.translateAnimationFlag$delegate.getValue(JubaoAnimationView.this, JubaoAnimationView.$$delegatedProperties[0])).booleanValue();
                        if (booleanValue && (function0 = JubaoAnimationView.this.inAnimationComplete) != null) {
                            function0.invoke();
                        }
                        Function0<Unit> function02 = JubaoAnimationView.this.outAnimationComplete;
                        if (function02 != null) {
                            function02.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
