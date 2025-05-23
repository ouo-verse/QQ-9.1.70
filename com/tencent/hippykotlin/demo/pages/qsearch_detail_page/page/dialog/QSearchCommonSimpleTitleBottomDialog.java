package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchCommonSimpleTitleBottomDialog extends ComposeView<QSearchCommonSimpleTitleBottomDialogAttr, QSearchCommonSimpleTitleBottomDialogEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchCommonSimpleTitleBottomDialogAttr access$getAttr(QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog) {
        return (QSearchCommonSimpleTitleBottomDialogAttr) qSearchCommonSimpleTitleBottomDialog.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchCommonSimpleTitleBottomDialogEvent access$getEvent(QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog) {
        return (QSearchCommonSimpleTitleBottomDialogEvent) qSearchCommonSimpleTitleBottomDialog.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog = QSearchCommonSimpleTitleBottomDialog.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog$body$1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        QSearchCommonSimpleTitleBottomDialogAttr access$getAttr = QSearchCommonSimpleTitleBottomDialog.access$getAttr(QSearchCommonSimpleTitleBottomDialog.this);
                        return Boolean.valueOf(((Boolean) access$getAttr.isShowDialog$delegate.getValue(access$getAttr, QSearchCommonSimpleTitleBottomDialogAttr.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog2 = QSearchCommonSimpleTitleBottomDialog.this;
                ConditionViewKt.c(viewContainer, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog3 = QSearchCommonSimpleTitleBottomDialog.this;
                        e.a(conditionView, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetView actionSheetView) {
                                ActionSheetView actionSheetView2 = actionSheetView;
                                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog4 = QSearchCommonSimpleTitleBottomDialog.this;
                                actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                        ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                        actionSheetAttr2.r(false);
                                        QSearchCommonSimpleTitleBottomDialogAttr access$getAttr = QSearchCommonSimpleTitleBottomDialog.access$getAttr(QSearchCommonSimpleTitleBottomDialog.this);
                                        actionSheetAttr2.w(((Boolean) access$getAttr.isShowDialog$delegate.getValue(access$getAttr, QSearchCommonSimpleTitleBottomDialogAttr.$$delegatedProperties[0])).booleanValue());
                                        final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog5 = QSearchCommonSimpleTitleBottomDialog.this;
                                        actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog6 = QSearchCommonSimpleTitleBottomDialog.this;
                                                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar) {
                                                        v vVar2 = vVar;
                                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog7 = QSearchCommonSimpleTitleBottomDialog.this;
                                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog8 = QSearchCommonSimpleTitleBottomDialog.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginTop(18.0f);
                                                                        ceVar2.marginBottom(10.0f);
                                                                        ceVar2.alignSelfCenter();
                                                                        QSearchCommonSimpleTitleBottomDialogAttr access$getAttr2 = QSearchCommonSimpleTitleBottomDialog.access$getAttr(QSearchCommonSimpleTitleBottomDialog.this);
                                                                        ceVar2.text((String) access$getAttr2.title$delegate.getValue(access$getAttr2, QSearchCommonSimpleTitleBottomDialogAttr.$$delegatedProperties[1]));
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
                                                                        ceVar2.fontWeight500();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog8 = QSearchCommonSimpleTitleBottomDialog.this;
                                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                ImageView imageView2 = imageView;
                                                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        Attr.absolutePosition$default(afVar2, 18.0f, 0.0f, 0.0f, 16.0f, 6, null);
                                                                        afVar2.size(24.0f, 24.0f);
                                                                        b.a.b(afVar2, QUIToken.INSTANCE.image("close", null), false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog9 = QSearchCommonSimpleTitleBottomDialog.this;
                                                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageEvent imageEvent) {
                                                                        final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog10 = QSearchCommonSimpleTitleBottomDialog.this;
                                                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.1.1.1.3.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                QSearchCommonSimpleTitleBottomDialog.access$getAttr(QSearchCommonSimpleTitleBottomDialog.this).setShowDialog(false);
                                                                                Function0<Unit> function02 = QSearchCommonSimpleTitleBottomDialog.access$getEvent(QSearchCommonSimpleTitleBottomDialog.this).onDismiss;
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
                                                        });
                                                        Function1<? super ViewContainer<?, ?>, Unit> function1 = QSearchCommonSimpleTitleBottomDialog.access$getAttr(QSearchCommonSimpleTitleBottomDialog.this).contentBuilder;
                                                        if (function1 != null) {
                                                            function1.invoke(vVar2);
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
                                final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog5 = QSearchCommonSimpleTitleBottomDialog.this;
                                actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(d dVar) {
                                        final QSearchCommonSimpleTitleBottomDialog qSearchCommonSimpleTitleBottomDialog6 = QSearchCommonSimpleTitleBottomDialog.this;
                                        dVar.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.dialog.QSearchCommonSimpleTitleBottomDialog.body.1.2.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QSearchCommonSimpleTitleBottomDialog.access$getAttr(QSearchCommonSimpleTitleBottomDialog.this).setShowDialog(false);
                                                Function0<Unit> function02 = QSearchCommonSimpleTitleBottomDialog.access$getEvent(QSearchCommonSimpleTitleBottomDialog.this).onDismiss;
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
        return new QSearchCommonSimpleTitleBottomDialogAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchCommonSimpleTitleBottomDialogEvent();
    }
}
