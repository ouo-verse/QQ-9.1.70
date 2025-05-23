package com.tencent.ntcompose.material;

import bp3.KeyboardOptions;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.cc;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import yo3.Size;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/TextFieldViewPropUpdater;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TextFieldViewPropUpdater implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final TextFieldViewPropUpdater f339356a = new TextFieldViewPropUpdater();

    TextFieldViewPropUpdater() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0079. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:137:0x047e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x047b  */
    @Override // com.tencent.ntcompose.core.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setPropToView(final ComposeRenderView view, String propKey, final Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        String str;
        Object obj13;
        Object obj14;
        InputView inputView;
        com.tencent.kuikly.core.views.ai aiVar;
        cc ccVar;
        Object obj15;
        String str2;
        Object obj16;
        Object obj17;
        Object obj18;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        TextAreaView textAreaView = b16 instanceof TextAreaView ? (TextAreaView) b16 : null;
        Object obj19 = "cursorColor";
        Object obj20 = "onFocusChanged";
        Object obj21 = "onKeyboardHeightChange";
        Object obj22 = "onReturnAction";
        Object obj23 = "textContentSizeChanged";
        Object obj24 = "onValueChange";
        if (textAreaView != null && (ccVar = (cc) textAreaView.getViewAttr()) != null) {
            switch (propKey.hashCode()) {
                case -2093329081:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    obj18 = obj22;
                    if (!propKey.equals(obj23)) {
                        obj23 = obj23;
                        obj22 = obj18;
                        str = str2;
                        Object obj25 = obj20;
                        obj8 = obj21;
                        obj11 = obj15;
                        obj7 = obj25;
                        obj10 = obj23;
                        obj = obj16;
                        obj2 = obj17;
                        obj9 = obj22;
                        obj3 = "onReachMaxInputLength";
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj14 = "value";
                        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                        break;
                    } else {
                        Boolean bool = propArg1 instanceof Boolean ? (Boolean) propArg1 : null;
                        boolean booleanValue = bool != null ? bool.booleanValue() : false;
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.ntcompose.ui.geometry.Size, kotlin.Unit>");
                        final Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1);
                        obj23 = obj23;
                        obj22 = obj18;
                        ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).m(booleanValue, new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$8
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.base.w it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function1.invoke(new Size(it.getWidth(), it.getHeight()));
                            }
                        });
                        obj3 = "onReachMaxInputLength";
                        str = str2;
                        obj2 = obj17;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj = obj16;
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj11 = obj15;
                        obj14 = "value";
                        break;
                    }
                case -2031186171:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    obj18 = obj22;
                    if (propKey.equals(obj18)) {
                        ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).l(new Function1<String, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                invoke2(str3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
                                ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 0)).invoke();
                            }
                        });
                        obj9 = obj18;
                        obj3 = "onReachMaxInputLength";
                        str = str2;
                        obj2 = obj17;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj10 = obj23;
                        obj = obj16;
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj11 = obj15;
                        obj14 = "value";
                        break;
                    }
                    obj22 = obj18;
                    str = str2;
                    Object obj252 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj252;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case -2004248131:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    if (!propKey.equals(obj21)) {
                        obj21 = obj21;
                        obj16 = "textStyle";
                        obj6 = obj19;
                        obj17 = "readOnly";
                        str = str2;
                        Object obj2522 = obj20;
                        obj8 = obj21;
                        obj11 = obj15;
                        obj7 = obj2522;
                        obj10 = obj23;
                        obj = obj16;
                        obj2 = obj17;
                        obj9 = obj22;
                        obj3 = "onReachMaxInputLength";
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj14 = "value";
                        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                        break;
                    } else {
                        obj21 = obj21;
                        obj6 = obj19;
                        Boolean bool2 = propArg1 instanceof Boolean ? (Boolean) propArg1 : null;
                        obj16 = "textStyle";
                        obj17 = "readOnly";
                        ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).j(bool2 != null ? bool2.booleanValue() : false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$7
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyboardParams keyboardParams) {
                                invoke2(keyboardParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyboardParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.KeyboardParams, kotlin.Unit>");
                                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 1)).invoke(it);
                            }
                        });
                        obj3 = "onReachMaxInputLength";
                        str = str2;
                        obj2 = obj17;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj = obj16;
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj11 = obj15;
                        obj14 = "value";
                        break;
                    }
                case -1974694341:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    if (!propKey.equals(obj20)) {
                        obj20 = obj20;
                        obj16 = "textStyle";
                        obj6 = obj19;
                        obj17 = "readOnly";
                        str = str2;
                        Object obj25222 = obj20;
                        obj8 = obj21;
                        obj11 = obj15;
                        obj7 = obj25222;
                        obj10 = obj23;
                        obj = obj16;
                        obj2 = obj17;
                        obj9 = obj22;
                        obj3 = "onReachMaxInputLength";
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj14 = "value";
                        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                        break;
                    } else {
                        obj20 = obj20;
                        ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).h(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$9
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                invoke2(inputParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(InputParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
                                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 1)).invoke(Boolean.FALSE);
                            }
                        });
                        ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).i(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$10
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                invoke2(inputParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(InputParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
                                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 1)).invoke(Boolean.TRUE);
                            }
                        });
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        str = str2;
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj11 = obj15;
                        obj14 = "value";
                        break;
                    }
                case -1595747923:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    if (!propKey.equals(obj19)) {
                        obj6 = obj19;
                        obj16 = "textStyle";
                        obj17 = "readOnly";
                        str = str2;
                        Object obj252222 = obj20;
                        obj8 = obj21;
                        obj11 = obj15;
                        obj7 = obj252222;
                        obj10 = obj23;
                        obj = obj16;
                        obj2 = obj17;
                        obj9 = obj22;
                        obj3 = "onReachMaxInputLength";
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj14 = "value";
                        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                        break;
                    } else {
                        cc ccVar2 = (cc) ((TextAreaView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, str2);
                        obj19 = obj19;
                        ccVar2.H((com.tencent.kuikly.core.base.h) propArg0);
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        str = str2;
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj11 = obj15;
                        obj14 = "value";
                        break;
                    }
                case -1576785488:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj15 = "placeholderColor";
                    if (!propKey.equals(obj15)) {
                        obj24 = obj24;
                        obj16 = "textStyle";
                        obj6 = obj19;
                        str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj17 = "readOnly";
                        str = str2;
                        Object obj2522222 = obj20;
                        obj8 = obj21;
                        obj11 = obj15;
                        obj7 = obj2522222;
                        obj10 = obj23;
                        obj = obj16;
                        obj2 = obj17;
                        obj9 = obj22;
                        obj3 = "onReachMaxInputLength";
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj14 = "value";
                        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                        break;
                    } else {
                        cc ccVar3 = (cc) ((TextAreaView) view.b()).getViewAttr();
                        str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        Intrinsics.checkNotNull(propArg0, str2);
                        obj24 = obj24;
                        ccVar3.x((com.tencent.kuikly.core.base.h) propArg0);
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        str = str2;
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj11 = obj15;
                        obj14 = "value";
                        break;
                    }
                case -1415151326:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    if (!propKey.equals(obj24)) {
                        obj24 = obj24;
                        obj6 = obj19;
                        obj15 = "placeholderColor";
                        str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj16 = "textStyle";
                        obj17 = "readOnly";
                        str = str2;
                        Object obj25222222 = obj20;
                        obj8 = obj21;
                        obj11 = obj15;
                        obj7 = obj25222222;
                        obj10 = obj23;
                        obj = obj16;
                        obj2 = obj17;
                        obj9 = obj22;
                        obj3 = "onReachMaxInputLength";
                        obj12 = obj24;
                        obj13 = "textWillChange";
                        obj14 = "value";
                        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                        break;
                    } else {
                        final Function1 function12 = TypeIntrinsics.isFunctionOfArity(propArg0, 1) ? (Function1) propArg0 : null;
                        if (function12 != null) {
                            ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).n(true, new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                    invoke2(inputParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(InputParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    function12.invoke(it);
                                }
                            });
                        }
                        obj12 = obj24;
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                case -1048634236:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    if (propKey.equals("textStyle")) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.ui.text.TextStyle");
                        TextFieldKt.i(ccVar, (bp3.k) propArg0);
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj252222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj252222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case -867683742:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    if (propKey.equals("readOnly")) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                        ccVar.j(!((Boolean) propArg0).booleanValue());
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj2522222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj2522222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case -403868864:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    if (propKey.equals("onReachMaxInputLength")) {
                        ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).p(new Function1<Object, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj26) {
                                invoke2(obj26);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj26) {
                                Object obj27 = propArg0;
                                Intrinsics.checkNotNull(obj27, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
                                ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj27, 0)).invoke();
                            }
                        });
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj25222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj25222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case -159754449:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    if (propKey.equals("textWillChange")) {
                        final Function1 function13 = TypeIntrinsics.isFunctionOfArity(propArg0, 1) ? (Function1) propArg0 : null;
                        if (function13 != null) {
                            ((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent()).q(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                    invoke2(inputParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(InputParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    function13.invoke(it);
                                }
                            });
                        }
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj252222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj252222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 109757585:
                    obj5 = "keyboardActions";
                    if (propKey.equals("state")) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.TextFieldState");
                        obj4 = "state";
                        ((ak) propArg0).a(new com.tencent.kuikly.core.base.aa<>(view.b().getPagerId(), view.b().getNativeRef()));
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj4 = "state";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj2522222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj2522222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 111972721:
                    obj5 = "keyboardActions";
                    if (propKey.equals("value")) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                        ccVar.D((String) propArg0);
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj4 = "state";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj4 = "state";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj25222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj25222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 726714551:
                    obj5 = "keyboardActions";
                    if (propKey.equals("keyboardOptions")) {
                        KeyboardOptions keyboardOptions = propArg0 instanceof KeyboardOptions ? (KeyboardOptions) propArg0 : null;
                        if (keyboardOptions != null) {
                            TextFieldKt.g((cc) ((TextAreaView) view.b()).getViewAttr(), keyboardOptions);
                        }
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj4 = "state";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj4 = "state";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj252222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj252222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 814385942:
                    if (propKey.equals("keyboardActions")) {
                        bp3.e eVar = propArg0 instanceof bp3.e ? (bp3.e) propArg0 : null;
                        if (eVar != null) {
                            obj5 = "keyboardActions";
                            TextFieldKt.e((TextAreaEvent) ((TextAreaView) view.b()).getViewEvent(), eVar, new Function0<String>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$1$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    Object prop = ((cc) ((TextAreaView) ComposeRenderView.this.b()).getViewAttr()).getProp("returnKeyType");
                                    String str3 = prop instanceof String ? (String) prop : null;
                                    return str3 == null ? "" : str3;
                                }
                            });
                        } else {
                            obj5 = "keyboardActions";
                        }
                        obj = "textStyle";
                        obj2 = "readOnly";
                        obj3 = "onReachMaxInputLength";
                        obj4 = "state";
                        obj14 = "value";
                        obj6 = obj19;
                        obj7 = obj20;
                        obj8 = obj21;
                        obj9 = obj22;
                        obj10 = obj23;
                        obj11 = "placeholderColor";
                        obj12 = obj24;
                        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                        obj13 = "textWillChange";
                        break;
                    }
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj2522222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj2522222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 1638055017:
                    if (propKey.equals("autoFocus")) {
                        cc ccVar4 = (cc) ((TextAreaView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                        ccVar4.h(((Boolean) propArg0).booleanValue());
                        break;
                    }
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj25222222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj25222222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 1750748480:
                    if (propKey.equals("placeholderText")) {
                        cc ccVar5 = (cc) ((TextAreaView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                        ccVar5.w((String) propArg0);
                        break;
                    }
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj252222222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj252222222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                case 1790933836:
                    if (propKey.equals("maxInputLength")) {
                        cc ccVar6 = (cc) ((TextAreaView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                        ccVar6.v(((Integer) propArg0).intValue());
                        break;
                    }
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj2522222222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj2522222222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
                default:
                    obj4 = "state";
                    obj5 = "keyboardActions";
                    obj6 = obj19;
                    obj15 = "placeholderColor";
                    str2 = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
                    obj16 = "textStyle";
                    obj17 = "readOnly";
                    str = str2;
                    Object obj25222222222222222222 = obj20;
                    obj8 = obj21;
                    obj11 = obj15;
                    obj7 = obj25222222222222222222;
                    obj10 = obj23;
                    obj = obj16;
                    obj2 = obj17;
                    obj9 = obj22;
                    obj3 = "onReachMaxInputLength";
                    obj12 = obj24;
                    obj13 = "textWillChange";
                    obj14 = "value";
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    break;
            }
            DeclarativeBaseView<?, ?> b17 = view.b();
            inputView = !(b17 instanceof InputView) ? (InputView) b17 : null;
            if (inputView != null || (aiVar = (com.tencent.kuikly.core.views.ai) inputView.getViewAttr()) == null) {
            }
            switch (propKey.hashCode()) {
                case -2093329081:
                    if (propKey.equals(obj10)) {
                        Boolean bool3 = propArg1 instanceof Boolean ? (Boolean) propArg1 : null;
                        boolean booleanValue2 = bool3 != null ? bool3.booleanValue() : false;
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.ntcompose.ui.geometry.Size, kotlin.Unit>");
                        final Function1 function14 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1);
                        ((InputEvent) ((InputView) view.b()).getViewEvent()).n(booleanValue2, new Function1<com.tencent.kuikly.core.base.w, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$8
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.w wVar) {
                                invoke2(wVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.base.w it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function14.invoke(new Size(it.getWidth(), it.getHeight()));
                            }
                        });
                        return;
                    }
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    return;
                case -2031186171:
                    if (propKey.equals(obj9)) {
                        ((InputEvent) ((InputView) view.b()).getViewEvent()).m(new Function1<String, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$6
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str3) {
                                invoke2(str3);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
                                ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 0)).invoke();
                            }
                        });
                        return;
                    }
                    com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                    return;
                case -2004248131:
                    if (propKey.equals(obj8)) {
                        Boolean bool4 = propArg1 instanceof Boolean ? (Boolean) propArg1 : null;
                        ((InputEvent) ((InputView) view.b()).getViewEvent()).k(bool4 != null ? bool4.booleanValue() : false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$7
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(KeyboardParams keyboardParams) {
                                invoke2(keyboardParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(KeyboardParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.KeyboardParams, kotlin.Unit>");
                                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 1)).invoke(it);
                            }
                        });
                        return;
                    }
                    break;
                case -1974694341:
                    if (propKey.equals(obj7)) {
                        ((InputEvent) ((InputView) view.b()).getViewEvent()).h(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$9
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                invoke2(inputParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(InputParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
                                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 1)).invoke(Boolean.FALSE);
                            }
                        });
                        ((InputEvent) ((InputView) view.b()).getViewEvent()).i(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$10
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                invoke2(inputParams);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(InputParams it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                Object obj26 = propArg0;
                                Intrinsics.checkNotNull(obj26, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
                                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj26, 1)).invoke(Boolean.TRUE);
                            }
                        });
                        return;
                    }
                    break;
                case -1595747923:
                    String str3 = str;
                    if (propKey.equals(obj6)) {
                        com.tencent.kuikly.core.views.ai aiVar2 = (com.tencent.kuikly.core.views.ai) ((InputView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, str3);
                        aiVar2.F((com.tencent.kuikly.core.base.h) propArg0);
                        return;
                    }
                    break;
                case -1576785488:
                    if (propKey.equals(obj11)) {
                        com.tencent.kuikly.core.views.ai aiVar3 = (com.tencent.kuikly.core.views.ai) ((InputView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, str);
                        aiVar3.v((com.tencent.kuikly.core.base.h) propArg0);
                        return;
                    }
                    break;
                case -1415151326:
                    if (propKey.equals(obj12)) {
                        final Function1 function15 = TypeIntrinsics.isFunctionOfArity(propArg0, 1) ? (Function1) propArg0 : null;
                        if (function15 != null) {
                            ((InputEvent) ((InputView) view.b()).getViewEvent()).p(true, new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                    invoke2(inputParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(InputParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    function15.invoke(it);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    break;
                case -1048634236:
                    if (propKey.equals(obj)) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.ui.text.TextStyle");
                        TextFieldKt.h(aiVar, (bp3.k) propArg0);
                        return;
                    }
                    break;
                case -867683742:
                    if (propKey.equals(obj2)) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                        aiVar.j(!((Boolean) propArg0).booleanValue());
                        return;
                    }
                    break;
                case -403868864:
                    if (propKey.equals(obj3)) {
                        ((InputEvent) ((InputView) view.b()).getViewEvent()).r(new Function1<Object, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$5
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj26) {
                                invoke2(obj26);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj26) {
                                Object obj27 = propArg0;
                                Intrinsics.checkNotNull(obj27, "null cannot be cast to non-null type kotlin.Function0<kotlin.Unit>");
                                ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj27, 0)).invoke();
                            }
                        });
                        return;
                    }
                    break;
                case -159754449:
                    if (propKey.equals(obj13)) {
                        final Function1 function16 = TypeIntrinsics.isFunctionOfArity(propArg0, 1) ? (Function1) propArg0 : null;
                        if (function16 != null) {
                            ((InputEvent) ((InputView) view.b()).getViewEvent()).s(new Function1<InputParams, Unit>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(InputParams inputParams) {
                                    invoke2(inputParams);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(InputParams it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    function16.invoke(it);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    break;
                case 109757585:
                    if (propKey.equals(obj4)) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.TextFieldState");
                        ((ak) propArg0).a(new com.tencent.kuikly.core.base.aa<>(view.b().getPagerId(), view.b().getNativeRef()));
                        return;
                    }
                    break;
                case 111972721:
                    if (propKey.equals(obj14)) {
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                        aiVar.B((String) propArg0);
                        return;
                    }
                    break;
                case 726714551:
                    if (propKey.equals("keyboardOptions")) {
                        KeyboardOptions keyboardOptions2 = propArg0 instanceof KeyboardOptions ? (KeyboardOptions) propArg0 : null;
                        if (keyboardOptions2 != null) {
                            TextFieldKt.f((com.tencent.kuikly.core.views.ai) ((InputView) view.b()).getViewAttr(), keyboardOptions2);
                            return;
                        }
                        return;
                    }
                    break;
                case 814385942:
                    if (propKey.equals(obj5)) {
                        bp3.e eVar2 = propArg0 instanceof bp3.e ? (bp3.e) propArg0 : null;
                        if (eVar2 != null) {
                            TextFieldKt.d((InputEvent) ((InputView) view.b()).getViewEvent(), eVar2, new Function0<String>() { // from class: com.tencent.ntcompose.material.TextFieldViewPropUpdater$setPropToView$2$4$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // kotlin.jvm.functions.Function0
                                public final String invoke() {
                                    Object prop = ((com.tencent.kuikly.core.views.ai) ((InputView) ComposeRenderView.this.b()).getViewAttr()).getProp("returnKeyType");
                                    String str4 = prop instanceof String ? (String) prop : null;
                                    return str4 == null ? "" : str4;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    break;
                case 1638055017:
                    if (propKey.equals("autoFocus")) {
                        com.tencent.kuikly.core.views.ai aiVar4 = (com.tencent.kuikly.core.views.ai) ((InputView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                        aiVar4.h(((Boolean) propArg0).booleanValue());
                        return;
                    }
                    break;
                case 1750748480:
                    if (propKey.equals("placeholderText")) {
                        com.tencent.kuikly.core.views.ai aiVar5 = (com.tencent.kuikly.core.views.ai) ((InputView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                        aiVar5.u((String) propArg0);
                        return;
                    }
                    break;
                case 1790933836:
                    if (propKey.equals("maxInputLength")) {
                        com.tencent.kuikly.core.views.ai aiVar6 = (com.tencent.kuikly.core.views.ai) ((InputView) view.b()).getViewAttr();
                        Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                        aiVar6.t(((Integer) propArg0).intValue());
                        return;
                    }
                    break;
            }
            com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
            return;
        }
        obj = "textStyle";
        obj2 = "readOnly";
        obj3 = "onReachMaxInputLength";
        obj4 = "state";
        obj5 = "keyboardActions";
        obj6 = obj19;
        obj7 = obj20;
        obj8 = obj21;
        obj9 = obj22;
        obj10 = obj23;
        obj11 = "placeholderColor";
        obj12 = obj24;
        str = "null cannot be cast to non-null type com.tencent.kuikly.core.base.Color";
        obj13 = "textWillChange";
        obj14 = "value";
        DeclarativeBaseView<?, ?> b172 = view.b();
        if (!(b172 instanceof InputView)) {
        }
        if (inputView != null) {
        }
    }
}
