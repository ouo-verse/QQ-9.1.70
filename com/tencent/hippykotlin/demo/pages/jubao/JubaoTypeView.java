package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.bo;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoTypeView extends JubaoAnimationView {
    public Function0<Unit> backClickCallback;
    public Function1<? super JubaoTypeData, Unit> itemClickCallback;
    public final PageModel pageModel;
    public final JubaoReasonData reasonData;

    public JubaoTypeView(JubaoReasonData jubaoReasonData, PageModel pageModel) {
        this.reasonData = jubaoReasonData;
        this.pageModel = pageModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.jubao.JubaoAnimationView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        JubaoAnimationView$body$1 jubaoAnimationView$body$1 = new JubaoAnimationView$body$1(this);
        w.a(this, JubaoUtil$O3BgView$1.INSTANCE);
        JubaoNavBarKt.JubaoNavBar(this, new Function1<JubaoNavBar, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(JubaoNavBar jubaoNavBar) {
                JubaoNavBar jubaoNavBar2 = jubaoNavBar;
                jubaoNavBar2.setBarData(new NavBarData("\u8fdd\u89c4\u7c7b\u578b", true, false));
                final JubaoTypeView jubaoTypeView = JubaoTypeView.this;
                jubaoNavBar2.backClickCallback = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Function0<Unit> function0 = JubaoTypeView.this.backClickCallback;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                };
                return Unit.INSTANCE;
            }
        });
        bo.a(this, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                ScrollerView<?, ?> scrollerView2 = scrollerView;
                scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerAttr scrollerAttr) {
                        ScrollerAttr scrollerAttr2 = scrollerAttr;
                        scrollerAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                        scrollerAttr2.flexDirectionColumn();
                        scrollerAttr2.marginTop(66.0f);
                        scrollerAttr2.showScrollerIndicator(false);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(scrollerView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$2.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.2.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginLeft(16.0f);
                                ceVar2.marginRight(16.0f);
                                ceVar2.marginBottom(16.0f);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.color(JubaoThemeData.INSTANCE.getContentTextColor());
                                ceVar2.fontWeight400();
                                ceVar2.text("\u9009\u62e9\u66f4\u8be6\u7ec6\u7684\u8fdd\u89c4\u7c7b\u578b\u6709\u52a9\u4e8e\u5b89\u5168\u4e2d\u5fc3\u5bf9\u4e0d\u540c\u7684\u8fdd\u89c4\u884c\u4e3a\u8fdb\u884c\u5904\u7f6e\uff0c\u63d0\u9ad8\u4e3e\u62a5\u6210\u529f\u7387\u3002");
                                EcommerceExtKt.elementVR(ceVar2, "em_safe_police_immediately", ConstantsKt.getJubaoDTBaseParams());
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final JubaoTypeView jubaoTypeView = JubaoTypeView.this;
                ArrayList<JubaoTypeData> arrayList = jubaoTypeView.reasonData.types;
                if (arrayList != null) {
                    final int i3 = 0;
                    for (Object obj : arrayList) {
                        int i16 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt__CollectionsKt.throwIndexOverflow();
                        }
                        final JubaoTypeData jubaoTypeData = (JubaoTypeData) obj;
                        scrollerView2.addChild(new JubaoArrowTextView(), new Function1<JubaoArrowTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$2$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(JubaoArrowTextView jubaoArrowTextView) {
                                JubaoArrowTextView jubaoArrowTextView2 = jubaoArrowTextView;
                                final JubaoTypeData jubaoTypeData2 = JubaoTypeData.this;
                                final int i17 = i3;
                                final JubaoTypeView jubaoTypeView2 = jubaoTypeView;
                                jubaoArrowTextView2.attr(new Function1<JubaoArrowTextViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$2$3$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(JubaoArrowTextViewAttr jubaoArrowTextViewAttr) {
                                        JubaoArrowTextViewAttr jubaoArrowTextViewAttr2 = jubaoArrowTextViewAttr;
                                        jubaoArrowTextViewAttr2.text = JubaoTypeData.this.name;
                                        if (i17 == jubaoTypeView2.reasonData.types.size() - 1) {
                                            jubaoArrowTextViewAttr2.marginBottom(50.0f);
                                        }
                                        jubaoArrowTextViewAttr2.accessibility(JubaoTypeData.this.name);
                                        jubaoArrowTextViewAttr2.accessibilityRole(AccessibilityRole.TEXT);
                                        e dTParams = jubaoTypeView2.pageModel.getDTParams();
                                        dTParams.v("jb_detail", JubaoTypeData.this.name);
                                        Unit unit = Unit.INSTANCE;
                                        EcommerceExtKt.elementVR(jubaoArrowTextViewAttr2, "em_safe_reporting_rules", dTParams);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final JubaoTypeView jubaoTypeView3 = jubaoTypeView;
                                final JubaoTypeData jubaoTypeData3 = JubaoTypeData.this;
                                jubaoArrowTextView2.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$2$3$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(l lVar) {
                                        final JubaoTypeView jubaoTypeView4 = JubaoTypeView.this;
                                        final JubaoTypeData jubaoTypeData4 = jubaoTypeData3;
                                        lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.2.3.1.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function1<? super JubaoTypeData, Unit> function1 = JubaoTypeView.this.itemClickCallback;
                                                if (function1 != null) {
                                                    function1.invoke(jubaoTypeData4);
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
                        i3 = i16;
                    }
                }
                return Unit.INSTANCE;
            }
        });
        ConditionViewKt.c(this, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$3
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(JubaoTypeView.this.pageModel.getOperateStatus() == 3);
            }
        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$4
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ConditionView conditionView) {
                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView$body$1$4.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.4.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                tVar2.m143maxHeight(475.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.4.1.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.4.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ECLoadingViewKt.ECLoading(vVar2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.4.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoTypeView.body.1.4.1.3.1
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
        return jubaoAnimationView$body$1;
    }
}
