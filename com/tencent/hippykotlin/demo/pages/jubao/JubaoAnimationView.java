package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class JubaoAnimationView extends ComposeView<k, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoAnimationView.class, "translateAnimationFlag", "getTranslateAnimationFlag()Z", 0)};
    public Function0<Unit> inAnimationComplete;
    public Function0<Unit> outAnimationComplete;
    public final ReadWriteProperty translateAnimationFlag$delegate = c.a(Boolean.FALSE);

    @Override // com.tencent.kuikly.core.base.ComposeView
    public Function1<ViewContainer<?, ?>, Unit> body() {
        return new JubaoAnimationView$body$1(this);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView$viewDidLayout$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                JubaoAnimationView jubaoAnimationView = JubaoAnimationView.this;
                jubaoAnimationView.translateAnimationFlag$delegate.setValue(jubaoAnimationView, JubaoAnimationView.$$delegatedProperties[0], Boolean.TRUE);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 1, function0);
    }
}
