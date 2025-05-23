package com.tencent.hippykotlin.demo.pages.vas_base.views;

import com.tencent.hippykotlin.demo.pages.foundation.lib.mqq.Mqq;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarView;
import com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class VasNavigationBar extends ComposeView<VasNavBarAttr, VasNavBarEvent> {
    public final VasNavBarAttr navBarAttr = new VasNavBarAttr();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ VasNavBarAttr access$getAttr(VasNavigationBar vasNavigationBar) {
        return (VasNavBarAttr) vasNavigationBar.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ VasNavBarEvent access$getEvent(VasNavigationBar vasNavigationBar) {
        return (VasNavBarEvent) vasNavigationBar.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final VasNavigationBar vasNavigationBar = VasNavigationBar.this;
                viewContainer.addChild(new QNavigationBarView(), new Function1<QNavigationBarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QNavigationBarView qNavigationBarView) {
                        final VasNavigationBar vasNavigationBar2 = VasNavigationBar.this;
                        qNavigationBarView.attr(new Function1<QNavigationBarViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QNavigationBarViewAttr qNavigationBarViewAttr) {
                                final QNavigationBarViewAttr qNavigationBarViewAttr2 = qNavigationBarViewAttr;
                                VasNavBarAttr access$getAttr = VasNavigationBar.access$getAttr(VasNavigationBar.this);
                                ReadWriteProperty readWriteProperty = access$getAttr.navTitle$delegate;
                                KProperty<?>[] kPropertyArr = VasNavBarAttr.$$delegatedProperties;
                                String str = (String) readWriteProperty.getValue(access$getAttr, kPropertyArr[0]);
                                ReadWriteProperty readWriteProperty2 = qNavigationBarViewAttr2.title$delegate;
                                KProperty<?>[] kPropertyArr2 = QNavigationBarViewAttr.$$delegatedProperties;
                                readWriteProperty2.setValue(qNavigationBarViewAttr2, kPropertyArr2[4], str);
                                final Function1 function1 = null;
                                qNavigationBarViewAttr2.slotTitle$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[13], new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$title$4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final QNavigationBarViewAttr qNavigationBarViewAttr3 = QNavigationBarViewAttr.this;
                                        final Function1<ClickParams, Unit> function12 = function1;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr$title$4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final QNavigationBarViewAttr qNavigationBarViewAttr4 = QNavigationBarViewAttr.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.title.4.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.marginTop(tVar2.getPagerData().getStatusBarHeight());
                                                        tVar2.absolutePositionAllZero();
                                                        tVar2.mo153width(tVar2.getPagerData().m());
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionRow();
                                                        QNavigationBarViewAttr qNavigationBarViewAttr5 = QNavigationBarViewAttr.this;
                                                        tVar2.accessibility((String) qNavigationBarViewAttr5.title$delegate.getValue(qNavigationBarViewAttr5, QNavigationBarViewAttr.$$delegatedProperties[4]));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final Function1<ClickParams, Unit> function13 = function12;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.title.4.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        u uVar2 = uVar;
                                                        final Function1<ClickParams, Unit> function14 = function13;
                                                        if (function14 != null) {
                                                            uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.title.4.1.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    function14.invoke(clickParams);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QNavigationBarViewAttr qNavigationBarViewAttr5 = QNavigationBarViewAttr.this;
                                                RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.title.4.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextView richTextView) {
                                                        final QNavigationBarViewAttr qNavigationBarViewAttr6 = QNavigationBarViewAttr.this;
                                                        richTextView.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.qui_component.QNavigationBarViewAttr.title.4.1.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(RichTextAttr richTextAttr) {
                                                                RichTextAttr richTextAttr2 = richTextAttr;
                                                                ce.fontSize$default(richTextAttr2, 17.0f, null, 2, null);
                                                                richTextAttr2.lineHeight(24.0f);
                                                                richTextAttr2.fontWeightMedium();
                                                                richTextAttr2.color(QNavigationBarViewAttr.this.getTextColor$qecommerce_biz_release());
                                                                QNavigationBarViewAttr qNavigationBarViewAttr7 = QNavigationBarViewAttr.this;
                                                                richTextAttr2.text((String) qNavigationBarViewAttr7.title$delegate.getValue(qNavigationBarViewAttr7, QNavigationBarViewAttr.$$delegatedProperties[4]));
                                                                richTextAttr2.lines(1);
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
                                VasNavBarAttr access$getAttr2 = VasNavigationBar.access$getAttr(VasNavigationBar.this);
                                qNavigationBarViewAttr2.bgImg$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[3], (String) access$getAttr2.bgImg$delegate.getValue(access$getAttr2, kPropertyArr[3]));
                                VasNavBarAttr access$getAttr3 = VasNavigationBar.access$getAttr(VasNavigationBar.this);
                                qNavigationBarViewAttr2.bgColor$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[1], (h) access$getAttr3.bgColor$delegate.getValue(access$getAttr3, kPropertyArr[1]));
                                VasNavBarAttr access$getAttr4 = VasNavigationBar.access$getAttr(VasNavigationBar.this);
                                qNavigationBarViewAttr2.textColor$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[2], (h) access$getAttr4.textColor$delegate.getValue(access$getAttr4, kPropertyArr[2]));
                                final VasNavigationBar vasNavigationBar3 = VasNavigationBar.this;
                                Function1<ClickParams, Unit> function12 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar.body.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        VasNavigationBar.access$getEvent(VasNavigationBar.this).getClass();
                                        Mqq.INSTANCE.getUi().popBack();
                                        return Unit.INSTANCE;
                                    }
                                };
                                qNavigationBarViewAttr2.leftIcon$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[8], "");
                                qNavigationBarViewAttr2.leftIconAccessibilityText$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[10], "");
                                qNavigationBarViewAttr2.leftClickHandler$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[9], function12);
                                VasNavBarAttr access$getAttr5 = VasNavigationBar.access$getAttr(VasNavigationBar.this);
                                String str2 = (String) access$getAttr5.rightText$delegate.getValue(access$getAttr5, kPropertyArr[4]);
                                final VasNavigationBar vasNavigationBar4 = VasNavigationBar.this;
                                Function1<ClickParams, Unit> function13 = new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasNavigationBar.body.1.1.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        VasNavigationBar.access$getEvent(VasNavigationBar.this).getClass();
                                        return Unit.INSTANCE;
                                    }
                                };
                                qNavigationBarViewAttr2.rightText$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[6], str2);
                                qNavigationBarViewAttr2.rightClickHandler$delegate.setValue(qNavigationBarViewAttr2, kPropertyArr2[7], function13);
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
        return this.navBarAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new VasNavBarEvent();
    }
}
