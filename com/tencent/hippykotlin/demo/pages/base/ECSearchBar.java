package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSearchBar extends ComposeView<ECSearchBarAttr, ECSearchBarEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECSearchBar.class, "state", "getState()Lcom/tencent/hippykotlin/demo/pages/base/ECSearchState;", 0)};
    public aa<InputView> inputRef;
    public final ReadWriteProperty state$delegate = c.a(ECSearchState.ECSearchInputBarUnactived);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECSearchBarAttr access$getAttr(ECSearchBar eCSearchBar) {
        return (ECSearchBarAttr) eCSearchBar.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        return Unit.INSTANCE;
                    }
                });
                final ECSearchBar eCSearchBar = ECSearchBar.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final ECSearchBar eCSearchBar2 = ECSearchBar.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginLeft(10.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.marginLeft(10.0f);
                                                b.a.b(afVar2, "qecommerce_skin_icon_general_search_secondary", false, 2, null);
                                                afVar2.size(16.0f, 16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECSearchBar eCSearchBar3 = ECSearchBar.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(ECSearchBar.this.getState() == ECSearchState.ECSearchInputBarUnactived || ECSearchBar.this.getState() == ECSearchState.ECSearchInputBarBeginEditing);
                                    }
                                };
                                final ECSearchBar eCSearchBar4 = ECSearchBar.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final ECSearchBar eCSearchBar5 = ECSearchBar.this;
                                        cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final ECSearchBar eCSearchBar6 = ECSearchBar.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.2.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(4.0f);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.lineHeight(20.0f);
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                        ECSearchBarAttr access$getAttr = ECSearchBar.access$getAttr(ECSearchBar.this);
                                                        ceVar2.text((String) access$getAttr.placeHolderText$delegate.getValue(access$getAttr, ECSearchBarAttr.$$delegatedProperties[0]));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ECSearchBar eCSearchBar3 = ECSearchBar.this;
                        am.a(vVar2, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(InputView inputView) {
                                InputView inputView2 = inputView;
                                final ECSearchBar eCSearchBar4 = ECSearchBar.this;
                                inputView2.ref(inputView2, new Function1<aa<InputView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<InputView> aaVar) {
                                        ECSearchBar.this.inputRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECSearchBar eCSearchBar5 = ECSearchBar.this;
                                inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InputEvent inputEvent) {
                                        InputEvent inputEvent2 = inputEvent;
                                        final ECSearchBar eCSearchBar6 = ECSearchBar.this;
                                        InputEvent.q(inputEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputParams inputParams) {
                                                ECSearchState eCSearchState;
                                                InputParams inputParams2 = inputParams;
                                                ECSearchBar eCSearchBar7 = ECSearchBar.this;
                                                if (inputParams2.getText().length() > 0) {
                                                    eCSearchState = ECSearchState.ECSearchInputBarEditingHasText;
                                                } else {
                                                    eCSearchState = ECSearchState.ECSearchInputBarBeginEditing;
                                                }
                                                eCSearchBar7.setState(eCSearchState);
                                                ECSearchBar.this.emit("didChangedWithText", inputParams2);
                                                return Unit.INSTANCE;
                                            }
                                        }, 1, null);
                                        final ECSearchBar eCSearchBar7 = ECSearchBar.this;
                                        inputEvent2.i(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputParams inputParams) {
                                                InputParams inputParams2 = inputParams;
                                                if (inputParams2.getText().length() > 0) {
                                                    ECSearchBar.this.setState(ECSearchState.ECSearchInputBarEditingHasText);
                                                } else {
                                                    ECSearchBar.this.setState(ECSearchState.ECSearchInputBarBeginEditing);
                                                }
                                                ECSearchBar.this.emit("didBeginEditingWithText", inputParams2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ECSearchBar eCSearchBar8 = ECSearchBar.this;
                                        inputEvent2.h(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputParams inputParams) {
                                                ECSearchBar.this.emit("didEndEditingWithText", inputParams);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ECSearchBar eCSearchBar9 = ECSearchBar.this;
                                        inputEvent2.o(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InputParams inputParams) {
                                                InputParams inputParams2 = inputParams;
                                                ECSearchBar.this.setState(ECSearchState.ECSearchInputBarAfterSearch);
                                                InputView b16 = ECSearchBar.this.getInputRef().b();
                                                if (b16 != null) {
                                                    b16.h();
                                                }
                                                ECSearchBar.this.emit("didSearchWithText", inputParams2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.2.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ai aiVar) {
                                        h hVar;
                                        h hVar2;
                                        ai aiVar2 = aiVar;
                                        aiVar2.absolutePosition(0.0f, 40.0f, 0.0f, 0.0f);
                                        hVar = IPagerIdKtxKt.getSkinColor(aiVar2).tokenColor("qecommerce_skin_color_text_red_brand", false);
                                        aiVar2.F(hVar);
                                        hVar2 = IPagerIdKtxKt.getSkinColor(aiVar2).tokenColor("qecommerce_skin_color_text_primary", false);
                                        aiVar2.i(hVar2);
                                        ai.m(aiVar2, 14.0f, null, 2, null);
                                        aiVar2.z();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ECSearchBar eCSearchBar2 = ECSearchBar.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(ECSearchBar.this.getState() == ECSearchState.ECSearchInputBarEditingHasText);
                    }
                };
                final ECSearchBar eCSearchBar3 = ECSearchBar.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final ECSearchBar eCSearchBar4 = ECSearchBar.this;
                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        b.a.b(afVar2, "qecommerce_skin_icon_general_close_solid_light", false, 2, null);
                                        afVar2.size(16.0f, 16.0f);
                                        afVar2.marginRight(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECSearchBar eCSearchBar5 = ECSearchBar.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.4.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final ECSearchBar eCSearchBar6 = ECSearchBar.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECSearchBar.body.1.4.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                InputView b16 = ECSearchBar.this.getInputRef().b();
                                                if (b16 != null) {
                                                    b16.setText("");
                                                }
                                                InputView b17 = ECSearchBar.this.getInputRef().b();
                                                if (b17 != null) {
                                                    b17.k();
                                                }
                                                ECSearchBar.this.setState(ECSearchState.ECSearchInputBarBeginEditing);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
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
        return new ECSearchBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECSearchBarEvent();
    }

    public final aa<InputView> getInputRef() {
        aa<InputView> aaVar = this.inputRef;
        if (aaVar != null) {
            return aaVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputRef");
        return null;
    }

    public final ECSearchState getState() {
        return (ECSearchState) this.state$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setState(ECSearchState eCSearchState) {
        this.state$delegate.setValue(this, $$delegatedProperties[0], eCSearchState);
    }
}
