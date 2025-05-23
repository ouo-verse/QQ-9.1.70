package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverItemSectionView extends ComposeView<QPPromoteReceiverItemSectionViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverItemSectionViewAttr access$getAttr(QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView) {
        return (QPPromoteReceiverItemSectionViewAttr) qPPromoteReceiverItemSectionView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float m3 = (((getPagerData().m() - 16.0f) - 16.0f) - 16.0f) / 3.0f;
        final float ceil = (float) Math.ceil((((QPPromoteReceiverItemSectionViewAttr) getAttr()).sectionViewModel.items.size() * 1.0f) / 3);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView = QPPromoteReceiverItemSectionView.this;
                final float f16 = ceil;
                final float f17 = m3;
                final int i3 = 3;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.marginBottom(15.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView2 = QPPromoteReceiverItemSectionView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentFlexEnd();
                                        tVar2.m140flex(1.0f);
                                        tVar2.mo141height(20.0f);
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView3 = QPPromoteReceiverItemSectionView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView4 = QPPromoteReceiverItemSectionView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.m140flex(1.0f);
                                                QPPromoteReceiverItemSectionViewAttr access$getAttr = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this);
                                                ceVar2.text((String) access$getAttr.sectionTitle$delegate.getValue(access$getAttr, QPPromoteReceiverItemSectionViewAttr.$$delegatedProperties[1]));
                                                if (QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).viewModel.getHasSelectCustomOption()) {
                                                    AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                } else {
                                                    AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                }
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.marginLeft(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView4 = QPPromoteReceiverItemSectionView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel;
                                        return Boolean.valueOf(((Boolean) qPPromoteReceiverSectionViewModel.hasQuestionIcon$delegate.getValue(qPPromoteReceiverSectionViewModel, QPPromoteReceiverSectionViewModel.$$delegatedProperties[3])).booleanValue());
                                    }
                                };
                                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView5 = QPPromoteReceiverItemSectionView.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView6 = QPPromoteReceiverItemSectionView.this;
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(20.0f, 20.0f);
                                                        tVar2.alignItemsCenter();
                                                        tVar2.justifyContentFlexEnd();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView7 = QPPromoteReceiverItemSectionView.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView8 = QPPromoteReceiverItemSectionView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Utils.INSTANCE.currentBridgeModule().showAlert(QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel.alertInfo, "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1.2.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.2.4.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(15.0f, 15.0f);
                                                                afVar2.marginRight(16.5f);
                                                                b.a.b(afVar2, "qecommerce_skin_icon_general_question_secondary", false, 2, null);
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
                        });
                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView3 = QPPromoteReceiverItemSectionView.this;
                        final float f18 = f16;
                        final int i16 = i3;
                        final float f19 = f17;
                        cn.a(vVar2, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cm cmVar) {
                                cm cmVar2 = cmVar;
                                final float f26 = f18;
                                final int i17 = i16;
                                cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ck ckVar) {
                                        ck ckVar2 = ckVar;
                                        ckVar2.marginTop(15.0f);
                                        ckVar2.mo141height((f26 * 45.0f) - 5.0f);
                                        ckVar2.marginLeft(16.0f);
                                        ckVar2.marginRight(16.0f);
                                        ckVar2.w((ckVar2.getPagerData().m() - 16.0f) - 16.0f);
                                        ckVar2.h(i17);
                                        ckVar2.t(8.0f);
                                        ckVar2.u(5.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                ArrayList<QPPromoteReceiverItem> arrayList = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel.items;
                                QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView4 = QPPromoteReceiverItemSectionView.this;
                                final float f27 = f19;
                                Iterator<QPPromoteReceiverItem> it = arrayList.iterator();
                                while (it.hasNext()) {
                                    final QPPromoteReceiverItem next = it.next();
                                    final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemSectionView.access$getAttr(qPPromoteReceiverItemSectionView4).sectionViewModel;
                                    final QPPromoteReceiverViewModel qPPromoteReceiverViewModel = QPPromoteReceiverItemSectionView.access$getAttr(qPPromoteReceiverItemSectionView4).viewModel;
                                    final QPPromoteReceiverItemSectionView$body$1$1$3$2$1 qPPromoteReceiverItemSectionView$body$1$1$3$2$1 = new Function1<QPPromoteReceiverItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView$body$1$1$3$2$1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final /* bridge */ /* synthetic */ Unit invoke(QPPromoteReceiverItemView qPPromoteReceiverItemView) {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    cmVar2.addChild(new QPPromoteReceiverItemView(), new Function1<QPPromoteReceiverItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionViewKt$QPPromoteReceiverItemViewFun$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(QPPromoteReceiverItemView qPPromoteReceiverItemView) {
                                            QPPromoteReceiverItemView qPPromoteReceiverItemView2 = qPPromoteReceiverItemView;
                                            final QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel2 = qPPromoteReceiverSectionViewModel;
                                            final QPPromoteReceiverViewModel qPPromoteReceiverViewModel2 = qPPromoteReceiverViewModel;
                                            final QPPromoteReceiverItem qPPromoteReceiverItem = next;
                                            final float f28 = f27;
                                            qPPromoteReceiverItemView2.attr(new Function1<QPPromoteReceiverItemSectionViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionViewKt$QPPromoteReceiverItemViewFun$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(QPPromoteReceiverItemSectionViewAttr qPPromoteReceiverItemSectionViewAttr) {
                                                    QPPromoteReceiverItemSectionViewAttr qPPromoteReceiverItemSectionViewAttr2 = qPPromoteReceiverItemSectionViewAttr;
                                                    qPPromoteReceiverItemSectionViewAttr2.sectionViewModel = QPPromoteReceiverSectionViewModel.this;
                                                    qPPromoteReceiverItemSectionViewAttr2.viewModel = qPPromoteReceiverViewModel2;
                                                    qPPromoteReceiverItemSectionViewAttr2.item$delegate.setValue(qPPromoteReceiverItemSectionViewAttr2, QPPromoteReceiverItemSectionViewAttr.$$delegatedProperties[0], qPPromoteReceiverItem);
                                                    qPPromoteReceiverItemSectionViewAttr2.mo153width(f28);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            qPPromoteReceiverItemSectionView$body$1$1$3$2$1.invoke(qPPromoteReceiverItemView2);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView4 = QPPromoteReceiverItemSectionView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel;
                                return Boolean.valueOf(((String) qPPromoteReceiverSectionViewModel.descLabel$delegate.getValue(qPPromoteReceiverSectionViewModel, QPPromoteReceiverSectionViewModel.$$delegatedProperties[1])).length() > 0);
                            }
                        };
                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView5 = QPPromoteReceiverItemSectionView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView6 = QPPromoteReceiverItemSectionView.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView7 = QPPromoteReceiverItemSectionView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.5.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(4.0f);
                                                ceVar2.marginLeft(16.0f);
                                                ceVar2.marginRight(16.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.lines(1);
                                                QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel;
                                                ceVar2.text((String) qPPromoteReceiverSectionViewModel.descLabel$delegate.getValue(qPPromoteReceiverSectionViewModel, QPPromoteReceiverSectionViewModel.$$delegatedProperties[1]));
                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView6 = QPPromoteReceiverItemSectionView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.6
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel;
                                return Boolean.valueOf(((String) qPPromoteReceiverSectionViewModel.subDescLabel$delegate.getValue(qPPromoteReceiverSectionViewModel, QPPromoteReceiverSectionViewModel.$$delegatedProperties[2])).length() > 0);
                            }
                        };
                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView7 = QPPromoteReceiverItemSectionView.this;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.7
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView8 = QPPromoteReceiverItemSectionView.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.7.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final QPPromoteReceiverItemSectionView qPPromoteReceiverItemSectionView9 = QPPromoteReceiverItemSectionView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverItemSectionView.body.1.1.7.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginTop(4.0f);
                                                ceVar2.marginLeft(16.0f);
                                                ceVar2.marginRight(16.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.lines(1);
                                                QPPromoteReceiverSectionViewModel qPPromoteReceiverSectionViewModel = QPPromoteReceiverItemSectionView.access$getAttr(QPPromoteReceiverItemSectionView.this).sectionViewModel;
                                                ceVar2.text((String) qPPromoteReceiverSectionViewModel.subDescLabel$delegate.getValue(qPPromoteReceiverSectionViewModel, QPPromoteReceiverSectionViewModel.$$delegatedProperties[2]));
                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
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
        return new QPPromoteReceiverItemSectionViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
