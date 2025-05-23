package com.tencent.hippykotlin.demo.pages.foundation.qui_component;

import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.DynamicAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicView;
import com.tencent.hippykotlin.demo.pages.foundation.view.VasDynamicViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QNavigationBarView extends ComposeView<QNavigationBarViewAttr, QNavigationBarViewEvent> {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public static final boolean access$isWhiteColor(h hVar) {
            Companion companion = QNavigationBarView.Companion;
            return Intrinsics.areEqual(hVar.toString(), "4293980404") || Intrinsics.areEqual(h.INSTANCE.m(), hVar);
        }

        public final void log$qecommerce_biz_release(String str) {
            KLog.INSTANCE.d("QNavigationBarView", c.f117352a.g().getPageName() + TokenParser.SP + str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QNavigationBarViewAttr access$getAttr(QNavigationBarView qNavigationBarView) {
        return (QNavigationBarViewAttr) qNavigationBarView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float access$getLeftWidth(QNavigationBarView qNavigationBarView) {
        QNavigationBarViewAttr qNavigationBarViewAttr = (QNavigationBarViewAttr) qNavigationBarView.getAttr();
        ReadWriteProperty readWriteProperty = qNavigationBarViewAttr.slotLeftWidth$delegate;
        KProperty<?>[] kPropertyArr = QNavigationBarViewAttr.$$delegatedProperties;
        if (((Number) readWriteProperty.getValue(qNavigationBarViewAttr, kPropertyArr[15])).floatValue() < 0.0f) {
            return 55.0f;
        }
        QNavigationBarViewAttr qNavigationBarViewAttr2 = (QNavigationBarViewAttr) qNavigationBarView.getAttr();
        return ((Number) qNavigationBarViewAttr2.slotLeftWidth$delegate.getValue(qNavigationBarViewAttr2, kPropertyArr[15])).floatValue();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QNavigationBarView qNavigationBarView = QNavigationBarView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        QNavigationBarView qNavigationBarView2 = QNavigationBarView.this;
                        QNavigationBarView.Companion companion = QNavigationBarView.Companion;
                        mVar2.size(qNavigationBarView2.getPager().getPageData().m(), QNavigationBarView.this.getPager().getPageData().getNavigationBarHeight());
                        QNavigationBarViewAttr access$getAttr = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                        mVar2.mo113backgroundColor((h) access$getAttr.bgColor$delegate.getValue(access$getAttr, QNavigationBarViewAttr.$$delegatedProperties[1]));
                        return Unit.INSTANCE;
                    }
                });
                final QNavigationBarView qNavigationBarView2 = QNavigationBarView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QNavigationBarView.access$getAttr(QNavigationBarView.this).getTextColor$qecommerce_biz_release();
                    }
                };
                final QNavigationBarView qNavigationBarView3 = QNavigationBarView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        QNavigationBarView qNavigationBarView4 = QNavigationBarView.this;
                        qNavigationBarView4.updateStatusBarStyle(QNavigationBarView.access$getAttr(qNavigationBarView4).getTextColor$qecommerce_biz_release());
                        return Unit.INSTANCE;
                    }
                });
                final QNavigationBarView qNavigationBarView4 = QNavigationBarView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QNavigationBarViewAttr access$getAttr = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                        return Boolean.valueOf(((String) access$getAttr.bgImg$delegate.getValue(access$getAttr, QNavigationBarViewAttr.$$delegatedProperties[3])).length() > 0);
                    }
                };
                final QNavigationBarView qNavigationBarView5 = QNavigationBarView.this;
                ConditionViewKt.c(viewContainer2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QNavigationBarView qNavigationBarView6 = QNavigationBarView.this;
                        VasDynamicViewKt.VasDynamicImg(conditionView, new Function1<VasDynamicView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(VasDynamicView vasDynamicView) {
                                final QNavigationBarView qNavigationBarView7 = QNavigationBarView.this;
                                vasDynamicView.attr(new Function1<DynamicAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.5.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(DynamicAttr dynamicAttr) {
                                        DynamicAttr dynamicAttr2 = dynamicAttr;
                                        dynamicAttr2.absolutePositionAllZero();
                                        QNavigationBarViewAttr access$getAttr = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                                        dynamicAttr2.with("src", (String) access$getAttr.bgImg$delegate.getValue(access$getAttr, QNavigationBarViewAttr.$$delegatedProperties[3]));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                QNavigationBarViewAttr access$getAttr = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                Function1 function1 = (Function1) access$getAttr.slotTitle$delegate.getValue(access$getAttr, QNavigationBarViewAttr.$$delegatedProperties[13]);
                if (function1 != null) {
                    function1.invoke(viewContainer2);
                }
                final QNavigationBarView qNavigationBarView6 = QNavigationBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView$body$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QNavigationBarView qNavigationBarView7 = QNavigationBarView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                QNavigationBarView qNavigationBarView8 = QNavigationBarView.this;
                                QNavigationBarView.Companion companion = QNavigationBarView.Companion;
                                tVar2.marginTop(qNavigationBarView8.getPager().getPageData().getStatusBarHeight());
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionRow();
                                tVar2.justifyContentSpaceBetween();
                                return Unit.INSTANCE;
                            }
                        });
                        final QNavigationBarView qNavigationBarView8 = QNavigationBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.6.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                Function1<ViewContainer<?, ?>, Unit> function12;
                                Function1<ViewContainer<?, ?>, Unit> function13;
                                v vVar4 = vVar3;
                                final QNavigationBarView qNavigationBarView9 = QNavigationBarView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.6.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo153width(QNavigationBarView.access$getLeftWidth(QNavigationBarView.this));
                                        QNavigationBarViewAttr access$getAttr2 = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                                        tVar2.m152visibility(((Boolean) access$getAttr2.showLeftIcon$delegate.getValue(access$getAttr2, QNavigationBarViewAttr.$$delegatedProperties[0])).booleanValue());
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentFlexStart();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QNavigationBarViewAttr access$getAttr2 = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                                ReadWriteProperty readWriteProperty = access$getAttr2.slotLeft$delegate;
                                KProperty<?>[] kPropertyArr = QNavigationBarViewAttr.$$delegatedProperties;
                                if (((Function1) readWriteProperty.getValue(access$getAttr2, kPropertyArr[12])) != null) {
                                    function13 = (Function1) access$getAttr2.slotLeft$delegate.getValue(access$getAttr2, kPropertyArr[12]);
                                } else {
                                    if (((String) access$getAttr2.leftText$delegate.getValue(access$getAttr2, kPropertyArr[11])).length() > 0) {
                                        function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotLeftViewBuilder$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                final QNavigationBarViewAttr qNavigationBarViewAttr = QNavigationBarViewAttr.this;
                                                cg.a(viewContainer4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotLeftViewBuilder$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotLeftViewBuilder.1.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginLeft(16.0f);
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.lineHeight(24.0f);
                                                                ceVar2.fontWeightNormal();
                                                                ceVar2.color(QNavigationBarViewAttr.this.getTextColor$qecommerce_biz_release());
                                                                QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                                ReadWriteProperty readWriteProperty2 = qNavigationBarViewAttr3.leftText$delegate;
                                                                KProperty<?>[] kPropertyArr2 = QNavigationBarViewAttr.$$delegatedProperties;
                                                                ceVar2.text((String) readWriteProperty2.getValue(qNavigationBarViewAttr3, kPropertyArr2[11]));
                                                                QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                                ceVar2.accessibility((String) qNavigationBarViewAttr4.leftText$delegate.getValue(qNavigationBarViewAttr4, kPropertyArr2[11]));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                viewContainer4.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotLeftViewBuilder$1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Event event) {
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotLeftViewBuilder.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                ClickParams clickParams2 = clickParams;
                                                                if (QNavigationBarViewAttr.access$getLeftClickHandler(QNavigationBarViewAttr.this) == null) {
                                                                    QNavigationBarView.Companion.log$qecommerce_biz_release("click left text, close page");
                                                                    Mqq.INSTANCE.getUi().popBack();
                                                                } else {
                                                                    QNavigationBarView.Companion.log$qecommerce_biz_release("click left text, invoke leftClickHandler");
                                                                    Function1 access$getLeftClickHandler = QNavigationBarViewAttr.access$getLeftClickHandler(QNavigationBarViewAttr.this);
                                                                    if (access$getLeftClickHandler != null) {
                                                                        access$getLeftClickHandler.invoke(clickParams2);
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        };
                                    } else {
                                        function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotLeftViewBuilder$2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                final QNavigationBarViewAttr qNavigationBarViewAttr = QNavigationBarViewAttr.this;
                                                ah.a(viewContainer4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotLeftViewBuilder$2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotLeftViewBuilder.2.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.marginLeft(12.0f);
                                                                afVar2.size(24.0f, 24.0f);
                                                                QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                                ReadWriteProperty readWriteProperty2 = qNavigationBarViewAttr3.leftIcon$delegate;
                                                                KProperty<?>[] kPropertyArr2 = QNavigationBarViewAttr.$$delegatedProperties;
                                                                String str = (String) readWriteProperty2.getValue(qNavigationBarViewAttr3, kPropertyArr2[8]);
                                                                QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                                if (str.length() == 0) {
                                                                    str = QUIToken.INSTANCE.image("chevron_left", qNavigationBarViewAttr4.getTextColor$qecommerce_biz_release());
                                                                }
                                                                b.a.b(afVar2, str, false, 2, null);
                                                                QNavigationBarViewAttr qNavigationBarViewAttr5 = QNavigationBarViewAttr.this;
                                                                String str2 = (String) qNavigationBarViewAttr5.leftIconAccessibilityText$delegate.getValue(qNavigationBarViewAttr5, kPropertyArr2[10]);
                                                                if (str2.length() == 0) {
                                                                    str2 = "\u8fd4\u56de";
                                                                }
                                                                afVar2.accessibility(str2);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                viewContainer4.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotLeftViewBuilder$2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Event event) {
                                                        Event event2 = event;
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotLeftViewBuilder.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                ClickParams clickParams2 = clickParams;
                                                                if (QNavigationBarViewAttr.access$getLeftClickHandler(QNavigationBarViewAttr.this) == null) {
                                                                    QNavigationBarView.Companion.log$qecommerce_biz_release("click left icon, close page");
                                                                    Mqq.INSTANCE.getUi().popBack();
                                                                } else {
                                                                    QNavigationBarView.Companion.log$qecommerce_biz_release("click left icon, invoke leftClickHandler");
                                                                    Function1 access$getLeftClickHandler = QNavigationBarViewAttr.access$getLeftClickHandler(QNavigationBarViewAttr.this);
                                                                    if (access$getLeftClickHandler != null) {
                                                                        access$getLeftClickHandler.invoke(clickParams2);
                                                                    }
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        if (!PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
                                                            final QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                            event2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotLeftViewBuilder.2.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(LongPressParams longPressParams) {
                                                                    if (Intrinsics.areEqual(longPressParams.getState(), "start")) {
                                                                        QNavigationBarViewAttr qNavigationBarViewAttr5 = QNavigationBarViewAttr.this;
                                                                        qNavigationBarViewAttr5.getClass();
                                                                        if (!PageDataExtKt.isPublic(c.f117352a.g().getPageData())) {
                                                                            BuildersKt.e(e.f117232d, null, null, new QNavigationBarViewAttr$showDebugInfo$1(qNavigationBarViewAttr5, null), 3, null);
                                                                        }
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        };
                                    }
                                    function13 = function12;
                                }
                                if (function13 != null) {
                                    function13.invoke(vVar4);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QNavigationBarView qNavigationBarView9 = QNavigationBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.6.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                Function1<ViewContainer<?, ?>, Unit> function12;
                                Function1<ViewContainer<?, ?>, Unit> function13;
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView.body.1.6.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentFlexEnd();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QNavigationBarViewAttr access$getAttr2 = QNavigationBarView.access$getAttr(QNavigationBarView.this);
                                ReadWriteProperty readWriteProperty = access$getAttr2.slotRight$delegate;
                                KProperty<?>[] kPropertyArr = QNavigationBarViewAttr.$$delegatedProperties;
                                if (((Function1) readWriteProperty.getValue(access$getAttr2, kPropertyArr[14])) != null) {
                                    function13 = (Function1) access$getAttr2.slotRight$delegate.getValue(access$getAttr2, kPropertyArr[14]);
                                } else {
                                    if (((String) access$getAttr2.rightText$delegate.getValue(access$getAttr2, kPropertyArr[6])).length() > 0) {
                                        function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotRightViewBuilder$1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                ViewContainer<?, ?> viewContainer4 = viewContainer3;
                                                final QNavigationBarViewAttr qNavigationBarViewAttr = QNavigationBarViewAttr.this;
                                                cg.a(viewContainer4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotRightViewBuilder$1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.1.1.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.marginRight(16.0f);
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.lineHeight(24.0f);
                                                                ceVar2.fontWeightNormal();
                                                                ceVar2.color(QNavigationBarViewAttr.this.getTextColor$qecommerce_biz_release());
                                                                ceVar2.lines(1);
                                                                QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                                ReadWriteProperty readWriteProperty2 = qNavigationBarViewAttr3.rightText$delegate;
                                                                KProperty<?>[] kPropertyArr2 = QNavigationBarViewAttr.$$delegatedProperties;
                                                                ceVar2.text((String) readWriteProperty2.getValue(qNavigationBarViewAttr3, kPropertyArr2[6]));
                                                                QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                                ceVar2.accessibility((String) qNavigationBarViewAttr4.rightText$delegate.getValue(qNavigationBarViewAttr4, kPropertyArr2[6]));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                viewContainer4.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotRightViewBuilder$1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Event event) {
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                ClickParams clickParams2 = clickParams;
                                                                QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                                Function1 function14 = (Function1) qNavigationBarViewAttr4.rightClickHandler$delegate.getValue(qNavigationBarViewAttr4, QNavigationBarViewAttr.$$delegatedProperties[7]);
                                                                if (function14 != null) {
                                                                    function14.invoke(clickParams2);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        };
                                    } else {
                                        function12 = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotRightViewBuilder$2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                                final QNavigationBarViewAttr qNavigationBarViewAttr = QNavigationBarViewAttr.this;
                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotRightViewBuilder$2.1
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                        return Boolean.valueOf(!((com.tencent.kuikly.core.reactive.collection.c) qNavigationBarViewAttr2.rightIconList$delegate.getValue(qNavigationBarViewAttr2, QNavigationBarViewAttr.$$delegatedProperties[5])).isEmpty());
                                                    }
                                                };
                                                final QNavigationBarViewAttr qNavigationBarViewAttr2 = QNavigationBarViewAttr.this;
                                                ConditionViewKt.c(viewContainer3, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$getSlotRightViewBuilder$2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        ConditionView conditionView2 = conditionView;
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                                        Function0<com.tencent.kuikly.core.reactive.collection.c<IconInfo>> function04 = new Function0<com.tencent.kuikly.core.reactive.collection.c<IconInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.1
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final com.tencent.kuikly.core.reactive.collection.c<IconInfo> invoke() {
                                                                QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                                return (com.tencent.kuikly.core.reactive.collection.c) qNavigationBarViewAttr4.rightIconList$delegate.getValue(qNavigationBarViewAttr4, QNavigationBarViewAttr.$$delegatedProperties[5]);
                                                            }
                                                        };
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                        LoopDirectivesViewKt.a(conditionView2, function04, new Function2<LoopDirectivesView<IconInfo>, IconInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2
                                                            {
                                                                super(2);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function2
                                                            public final Unit invoke(LoopDirectivesView<IconInfo> loopDirectivesView, IconInfo iconInfo) {
                                                                final IconInfo iconInfo2 = iconInfo;
                                                                final QNavigationBarViewAttr qNavigationBarViewAttr5 = QNavigationBarViewAttr.this;
                                                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        v vVar6 = vVar5;
                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.alignSelfCenter();
                                                                                tVar2.flexDirectionRow();
                                                                                tVar2.justifyContentFlexStart();
                                                                                tVar2.alignItemsCenter();
                                                                                tVar2.mo153width(36.0f);
                                                                                tVar2.mo141height(36.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final IconInfo iconInfo3 = IconInfo.this;
                                                                        final QNavigationBarViewAttr qNavigationBarViewAttr6 = qNavigationBarViewAttr5;
                                                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2.1.2
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                final IconInfo iconInfo4 = IconInfo.this;
                                                                                final QNavigationBarViewAttr qNavigationBarViewAttr7 = qNavigationBarViewAttr6;
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2.1.2.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(24.0f, 24.0f);
                                                                                        IconInfo iconInfo5 = IconInfo.this;
                                                                                        ReadWriteProperty readWriteProperty2 = iconInfo5.iconUrl$delegate;
                                                                                        KProperty<?>[] kPropertyArr2 = IconInfo.$$delegatedProperties;
                                                                                        String str = (String) readWriteProperty2.getValue(iconInfo5, kPropertyArr2[0]);
                                                                                        QNavigationBarViewAttr qNavigationBarViewAttr8 = qNavigationBarViewAttr7;
                                                                                        if (str.length() == 0) {
                                                                                            str = QUIToken.INSTANCE.image("more", qNavigationBarViewAttr8.getTextColor$qecommerce_biz_release());
                                                                                        }
                                                                                        b.a.b(afVar2, str, false, 2, null);
                                                                                        IconInfo iconInfo6 = IconInfo.this;
                                                                                        if (((h) iconInfo6.tintColor$delegate.getValue(iconInfo6, kPropertyArr2[1])) != null) {
                                                                                            IconInfo iconInfo7 = IconInfo.this;
                                                                                            h hVar = (h) iconInfo7.tintColor$delegate.getValue(iconInfo7, kPropertyArr2[1]);
                                                                                            if (hVar == null) {
                                                                                                hVar = h.INSTANCE.k();
                                                                                            }
                                                                                            afVar2.t(hVar);
                                                                                        }
                                                                                        IconInfo iconInfo8 = IconInfo.this;
                                                                                        String str2 = (String) iconInfo8.accessibility$delegate.getValue(iconInfo8, kPropertyArr2[2]);
                                                                                        if (str2.length() == 0) {
                                                                                            str2 = "\u66f4\u591a";
                                                                                        }
                                                                                        afVar2.accessibility(str2);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2.1.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final IconInfo iconInfo4 = IconInfo.this;
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.2.1.3.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        IconInfo.this.getClass();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        iconInfo3.getClass();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.3
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.getSlotRightViewBuilder.2.2.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.mo153width(4.0f);
                                                                        tVar2.mo141height(36.0f);
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
                                    function13 = function12;
                                }
                                if (function13 != null) {
                                    function13.invoke(vVar4);
                                }
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
        return new QNavigationBarViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QNavigationBarViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        updateStatusBarStyle(((QNavigationBarViewAttr) getAttr()).getTextColor$qecommerce_biz_release());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void updateStatusBarStyle(h hVar) {
        QNavigationBarViewAttr qNavigationBarViewAttr = (QNavigationBarViewAttr) getAttr();
        if (((Boolean) qNavigationBarViewAttr.autoChangeStatusBarStyle$delegate.getValue(qNavigationBarViewAttr, QNavigationBarViewAttr.$$delegatedProperties[16])).booleanValue()) {
            BuildersKt.b(e.f117232d, null, null, new QNavigationBarView$updateStatusBarStyle$1(hVar, null), 3, null);
        }
    }
}
