package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.CheckBoxView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.q;
import com.tencent.kuikly.core.views.r;
import com.tencent.kuikly.core.views.s;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoSelectView extends ComposeView<k, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(JubaoSelectView.class, "canClick", "getCanClick()Z", 0)};
    public Function1<? super ArrayList<JubaoSelectData>, Unit> continueCallback;
    public final List<JubaoSelectData> data;
    public final PageModel pageModel;
    public final ArrayList<JubaoSelectData> selectedData = new ArrayList<>();
    public final ReadWriteProperty canClick$delegate = c.a(Boolean.FALSE);

    public JubaoSelectView(PageModel pageModel, List<JubaoSelectData> list) {
        this.pageModel = pageModel;
        this.data = list;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                w.a(viewContainer2, JubaoUtil$O3BgView$1.INSTANCE);
                JubaoNavBarKt.JubaoNavBar(viewContainer2, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(JubaoNavBar jubaoNavBar) {
                        jubaoNavBar.setBarData(new NavBarData("\u8fdd\u89c4\u573a\u666f", false, false));
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginRight(16.0f);
                                ceVar2.marginBottom(34.0f);
                                ceVar2.marginTop(16.0f);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                ceVar2.text("\u9009\u62e9\u7cbe\u786e\u7684\u8fdd\u89c4\u573a\u666f\u6709\u52a9\u4e8e\u5e73\u53f0\u63d0\u9ad8\u5ba1\u6838\u6548\u7387\u3002\uff08\u591a\u9009\uff09");
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoSelectView jubaoSelectView = JubaoSelectView.this;
                final int i3 = 0;
                for (Object obj : jubaoSelectView.data) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    final JubaoSelectData jubaoSelectData = (JubaoSelectData) obj;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1$3$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final int i17 = i3;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1$3$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    if (i17 > 0) {
                                        tVar2.marginTop(24.0f);
                                    }
                                    tVar2.flexDirectionColumn();
                                    return Unit.INSTANCE;
                                }
                            });
                            final JubaoSelectView jubaoSelectView2 = jubaoSelectView;
                            final JubaoSelectData jubaoSelectData2 = JubaoSelectData.this;
                            w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1$3$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar3) {
                                    v vVar4 = vVar3;
                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            tVar.flexDirectionRow();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                                    final JubaoSelectView jubaoSelectView3 = JubaoSelectView.this;
                                    final JubaoSelectData jubaoSelectData3 = jubaoSelectData2;
                                    s.a(vVar4, new Function1<CheckBoxView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Type inference failed for: r5v1, types: [T, com.tencent.kuikly.core.base.AbstractBaseView, com.tencent.kuikly.core.views.CheckBoxView] */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(CheckBoxView checkBoxView) {
                                            CheckBoxView checkBoxView2 = checkBoxView;
                                            objectRef.element = checkBoxView2;
                                            checkBoxView2.attr(new Function1<q, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(q qVar) {
                                                    q qVar2 = qVar;
                                                    qVar2.mo141height(20.0f);
                                                    qVar2.mo153width(20.0f);
                                                    qVar2.marginLeft(16.0f);
                                                    qVar2.i("data:image/png;base64,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");
                                                    qVar2.k("data:image/png;base64,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");
                                                    qVar2.alignSelfCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final Ref.BooleanRef booleanRef2 = booleanRef;
                                            final JubaoSelectView jubaoSelectView4 = jubaoSelectView3;
                                            final JubaoSelectData jubaoSelectData4 = jubaoSelectData3;
                                            checkBoxView2.event(new Function1<r, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.2.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(r rVar) {
                                                    final Ref.BooleanRef booleanRef3 = Ref.BooleanRef.this;
                                                    final JubaoSelectView jubaoSelectView5 = jubaoSelectView4;
                                                    final JubaoSelectData jubaoSelectData5 = jubaoSelectData4;
                                                    rVar.h(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.2.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(Boolean bool) {
                                                            boolean booleanValue = bool.booleanValue();
                                                            Ref.BooleanRef.this.element = booleanValue;
                                                            if (booleanValue) {
                                                                jubaoSelectView5.selectedData.add(jubaoSelectData5);
                                                            } else {
                                                                jubaoSelectView5.selectedData.remove(jubaoSelectData5);
                                                            }
                                                            JubaoSelectView jubaoSelectView6 = jubaoSelectView5;
                                                            jubaoSelectView6.canClick$delegate.setValue(jubaoSelectView6, JubaoSelectView.$$delegatedProperties[0], Boolean.valueOf(!jubaoSelectView6.selectedData.isEmpty()));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final JubaoSelectData jubaoSelectData4 = jubaoSelectData2;
                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final JubaoSelectData jubaoSelectData5 = JubaoSelectData.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginLeft(8.0f);
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(JubaoThemeData.INSTANCE.getItemViewTextColor());
                                                    ceVar2.text(JubaoSelectData.this.description);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            final Ref.ObjectRef<CheckBoxView> objectRef2 = objectRef;
                                            final Ref.BooleanRef booleanRef2 = booleanRef;
                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.2.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                /* JADX WARN: Multi-variable type inference failed */
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    q qVar;
                                                    CheckBoxView checkBoxView = objectRef2.element;
                                                    if (checkBoxView != null && (qVar = (q) checkBoxView.getViewAttr()) != null) {
                                                        qVar.h(!booleanRef2.element);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            if (JubaoSelectData.this.subDescription.length() > 0) {
                                final JubaoSelectData jubaoSelectData3 = JubaoSelectData.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1$3$1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final JubaoSelectData jubaoSelectData4 = JubaoSelectData.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.3.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.marginTop(8.0f);
                                                ceVar2.fontWeight400();
                                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                                ceVar2.text(JubaoSelectData.this.subDescription);
                                                ceVar2.marginLeft(43.0f);
                                                ceVar2.includePadding(false);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    i3 = i16;
                }
                final JubaoSelectView jubaoSelectView2 = JubaoSelectView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final JubaoSelectView jubaoSelectView3 = JubaoSelectView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                int collectionSizeOrDefault;
                                String joinToString$default;
                                t tVar2 = tVar;
                                tVar2.mo141height(40.0f);
                                tVar2.mo153width(168.0f);
                                tVar2.marginTop(31.0f);
                                tVar2.borderRadius(12.0f);
                                JubaoSelectView jubaoSelectView4 = JubaoSelectView.this;
                                if (((Boolean) jubaoSelectView4.canClick$delegate.getValue(jubaoSelectView4, JubaoSelectView.$$delegatedProperties[0])).booleanValue()) {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getConfirmBtnBgColor());
                                } else {
                                    tVar2.mo113backgroundColor(JubaoThemeData.INSTANCE.getDisableBtnBgColor());
                                }
                                tVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.j()));
                                tVar2.allCenter();
                                tVar2.alignSelfCenter();
                                com.tencent.kuikly.core.nvi.serialization.json.e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
                                ArrayList<JubaoSelectData> arrayList = JubaoSelectView.this.selectedData;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
                                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                                Iterator<JubaoSelectData> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    arrayList2.add(it.next().description);
                                }
                                joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, ",", null, null, 0, null, null, 62, null);
                                jubaoDTBaseParams.v("jb_detail", joinToString$default);
                                Unit unit = Unit.INSTANCE;
                                EcommerceExtKt.elementVR(tVar2, "em_safe_next_button", jubaoDTBaseParams);
                                return Unit.INSTANCE;
                            }
                        });
                        final JubaoSelectView jubaoSelectView4 = JubaoSelectView.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final JubaoSelectView jubaoSelectView5 = JubaoSelectView.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.4.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        JubaoSelectView jubaoSelectView6;
                                        Function1<? super ArrayList<JubaoSelectData>, Unit> function1;
                                        if ((!JubaoSelectView.this.selectedData.isEmpty()) && (function1 = (jubaoSelectView6 = JubaoSelectView.this).continueCallback) != null) {
                                            function1.invoke(jubaoSelectView6.selectedData);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.4.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.4.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u4e0b\u4e00\u6b65");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(JubaoThemeData.INSTANCE.getConfirmBtnTextColor());
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoSelectView jubaoSelectView3 = JubaoSelectView.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(JubaoSelectView.this.pageModel.getOperateStatus() == 3 || JubaoSelectView.this.pageModel.getOperateStatus() == 9);
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView$body$1.6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.6.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        tVar2.m150top(0.0f);
                                        tVar2.m142left(0.0f);
                                        tVar2.m149right(0.0f);
                                        tVar2.m138bottom(240.0f);
                                        tVar2.m143maxHeight(300.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.6.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.6.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ECLoadingViewKt.ECLoading(vVar2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.6.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingView eCLoadingView) {
                                        eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoSelectView.body.1.6.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                eCLoadingAttr.delayShow = true;
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
