package com.tencent.hippykotlin.demo.pages.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECTransitionView extends ViewContainer<ECTransitionAttr, ECTransitionEvent> implements c {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECTransitionView.class, "didLayout", "getDidLayout()Z", 0)};
    public final ReadWriteProperty didLayout$delegate = c01.c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECTransitionAttr access$getAttr(ECTransitionView eCTransitionView) {
        return (ECTransitionAttr) eCTransitionView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECTransitionEvent access$getEvent(ECTransitionView eCTransitionView) {
        return (ECTransitionEvent) eCTransitionView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ECTransitionAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECTransitionEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        final b p16 = b.Companion.p(b.INSTANCE, 0.35f, 0.9f, 1.0f, null, 8, null);
        attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionView$didInit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                if (ECTransitionView.access$getAttr(ECTransitionView.this).transitionType == 1) {
                    if (ECTransitionView.this.getDidLayout() && ECTransitionView.access$getAttr(ECTransitionView.this).getTransitionAppear()) {
                        eCTransitionAttr2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    } else {
                        eCTransitionAttr2.transform(new y(0.0f, 1.0f, 0.0f, 0.0f, 12, null));
                    }
                } else if (ECTransitionView.access$getAttr(ECTransitionView.this).transitionType == 3) {
                    if (ECTransitionView.this.getDidLayout() && ECTransitionView.access$getAttr(ECTransitionView.this).getTransitionAppear()) {
                        eCTransitionAttr2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    } else {
                        eCTransitionAttr2.transform(new y(1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    }
                } else if (ECTransitionView.access$getAttr(ECTransitionView.this).transitionType == 4) {
                    if (ECTransitionView.this.getDidLayout() && ECTransitionView.access$getAttr(ECTransitionView.this).getTransitionAppear()) {
                        eCTransitionAttr2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    } else {
                        eCTransitionAttr2.transform(new y(-1.0f, 0.0f, 0.0f, 0.0f, 12, null));
                    }
                } else if (ECTransitionView.access$getAttr(ECTransitionView.this).transitionType == 2) {
                    if (ECTransitionView.this.getDidLayout() && ECTransitionView.access$getAttr(ECTransitionView.this).getTransitionAppear()) {
                        eCTransitionAttr2.transform(new u(1.0f, 1.0f));
                    } else {
                        eCTransitionAttr2.transform(new u(0.0f, 0.0f));
                    }
                } else if (ECTransitionView.access$getAttr(ECTransitionView.this).transitionType == 5) {
                    if (ECTransitionView.this.getDidLayout() && ECTransitionView.access$getAttr(ECTransitionView.this).getTransitionAppear()) {
                        eCTransitionAttr2.m147opacity(1.0f);
                    } else {
                        eCTransitionAttr2.m147opacity(0.0f);
                    }
                }
                eCTransitionAttr2.m134animation(p16, (Object) Boolean.valueOf(ECTransitionView.this.getDidLayout()));
                eCTransitionAttr2.m134animation(p16, (Object) Boolean.valueOf(ECTransitionView.access$getAttr(ECTransitionView.this).getTransitionAppear()));
                return Unit.INSTANCE;
            }
        });
        event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionView$didInit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                final ECTransitionView eCTransitionView = ECTransitionView.this;
                eCTransitionEvent.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECTransitionView$didInit$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                        ECTransitionView.access$getEvent(ECTransitionView.this).onFireEvent("transitionFinish", ECTransitionView.access$getAttr(ECTransitionView.this));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        getPager().addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerEventObserver(this);
    }

    public final boolean getDidLayout() {
        return ((Boolean) this.didLayout$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            ((ECTransitionAttr) getAttr()).setTransitionAppear(false);
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void setFrameToRenderView(d dVar) {
        super.setFrameToRenderView(dVar);
        if (getDidLayout()) {
            return;
        }
        this.didLayout$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "KRView";
    }
}
