package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.hippykotlin.demo.pages.base.model.KTVAlertInfo;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.IQPPromoteReceiverCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.QPPromoteReceiverViewAttr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.nvi.serialization.json.e;
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
import com.tencent.pts.ui.vnode.PTSNodeTextBase;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverSelectSectionView extends IQPPromoteReceiverCardView {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverViewAttr access$getAttr(QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView) {
        return (QPPromoteReceiverViewAttr) qPPromoteReceiverSelectSectionView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView = QPPromoteReceiverSelectSectionView.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(90.0f);
                                tVar2.mo153width(tVar2.getPagerData().m());
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView2 = QPPromoteReceiverSelectSectionView.this;
                        int i3 = QPPromoteReceiverSelectSectionView.$r8$clinit;
                        qPPromoteReceiverSelectSectionView2.getClass();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView$bodyWithSectionOption$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView3 = QPPromoteReceiverSelectSectionView.this;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView$bodyWithSectionOption$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(tVar2.getPagerData().m());
                                                tVar2.mo141height(45.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentFlexEnd();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView4 = QPPromoteReceiverSelectSectionView.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.mo141height(45.0f);
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.justifyContentFlexStart();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView5 = QPPromoteReceiverSelectSectionView.this;
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView6 = QPPromoteReceiverSelectSectionView.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(16.0f, 16.0f);
                                                                afVar2.marginLeft(17.0f);
                                                                afVar2.borderRadius(8.0f);
                                                                if (!QPPromoteReceiverSelectSectionView.access$getAttr(QPPromoteReceiverSelectSectionView.this).getViewModel().getHasSelectCustomOption()) {
                                                                    b.a.b(afVar2, "qecommerce_skin_checkbox_general_selected_red", false, 2, null);
                                                                } else {
                                                                    b.a.b(afVar2, "qecommerce_skin_checkbox_general_normal", false, 2, null);
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ceVar2.fontFamily(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM);
                                                                ceVar2.fontWeight500();
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.mo141height(20.0f);
                                                                ceVar2.marginLeft(13.0f);
                                                                ceVar2.textAlignCenter();
                                                                ceVar2.text("\u667a\u80fd\u4f18\u9009");
                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView6 = QPPromoteReceiverSelectSectionView.this;
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView7 = QPPromoteReceiverSelectSectionView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.2.4.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                QPPromoteReceiverSelectSectionView.access$getAttr(QPPromoteReceiverSelectSectionView.this).getViewModel().onSelectItem(1);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(45.0f, 45.0f);
                                                        tVar2.alignItemsCenter();
                                                        tVar2.flexDirectionRow();
                                                        tVar2.justifyContentFlexEnd();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3.2.1
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
                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Utils.INSTANCE.currentBridgeModule().showAlert(new KTVAlertInfo("\u667a\u80fd\u4f18\u9009", "\u7cfb\u7edf\u5c06\u6839\u636e\u89c6\u9891\u5185\u5bb9\u5c5e\u6027\uff0c\u63a8\u8350\u7ed9\u6f5c\u5728\u5174\u8da3\u7528\u6237\u3002"), "\u6211\u77e5\u9053\u4e86", null, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.1.3.3.1.1
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
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView4 = QPPromoteReceiverSelectSectionView.this;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView$bodyWithSectionOption$1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(tVar2.getPagerData().m());
                                                tVar2.mo141height(45.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentFlexStart();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView5 = QPPromoteReceiverSelectSectionView.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView6 = QPPromoteReceiverSelectSectionView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(16.0f, 16.0f);
                                                        afVar2.marginLeft(17.0f);
                                                        afVar2.borderRadius(8.0f);
                                                        if (QPPromoteReceiverSelectSectionView.access$getAttr(QPPromoteReceiverSelectSectionView.this).getViewModel().getHasSelectCustomOption()) {
                                                            b.a.b(afVar2, "qecommerce_skin_checkbox_general_selected_red", false, 2, null);
                                                        } else {
                                                            b.a.b(afVar2, "qecommerce_skin_checkbox_general_normal", false, 2, null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.fontFamily(PTSNodeTextBase.FONT_FAMILY_PING_FANG_SC_MEDIUM);
                                                        ceVar2.fontWeight500();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.mo141height(20.0f);
                                                        ceVar2.textAlignCenter();
                                                        ceVar2.marginLeft(13.0f);
                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                        ceVar2.text("\u81ea\u5b9a\u4e49\u4eba\u7fa4");
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView6 = QPPromoteReceiverSelectSectionView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final QPPromoteReceiverSelectSectionView qPPromoteReceiverSelectSectionView7 = QPPromoteReceiverSelectSectionView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button.QPPromoteReceiverSelectSectionView.bodyWithSectionOption.1.2.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        QPPromoteReceiverSelectSectionView.access$getAttr(QPPromoteReceiverSelectSectionView.this).getViewModel().onSelectItem(2);
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
                        }.invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }
}
