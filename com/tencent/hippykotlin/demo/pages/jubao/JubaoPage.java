package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class JubaoPage extends Pager {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final JubaoPage jubaoPage = JubaoPage.this;
                viewContainer.addChild(new QUSHalfScreenFloatingView(), new Function1<QUSHalfScreenFloatingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
                        final JubaoPage jubaoPage2 = JubaoPage.this;
                        qUSHalfScreenFloatingView.attr(new Function1<QUSHalfScreenFloatingViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(QUSHalfScreenFloatingViewAttr qUSHalfScreenFloatingViewAttr) {
                                String str;
                                QUSHalfScreenFloatingViewAttr qUSHalfScreenFloatingViewAttr2 = qUSHalfScreenFloatingViewAttr;
                                qUSHalfScreenFloatingViewAttr2.mo141height(JubaoPage.this.getPageData().l());
                                qUSHalfScreenFloatingViewAttr2.mo153width(JubaoPage.this.getPageData().m());
                                e m3 = qUSHalfScreenFloatingViewAttr2.getPagerData().n().m("jubaoModel");
                                if (m3 == null || (str = m3.p("gray_tip_id")) == null) {
                                    str = "";
                                }
                                e m16 = qUSHalfScreenFloatingViewAttr2.getPagerData().n().m("jubaoModel");
                                int i3 = 0;
                                boolean g16 = m16 != null ? m16.g("useDefaultHeight", false) : false;
                                if ((str.length() == 0) && !g16) {
                                    i3 = 1;
                                }
                                qUSHalfScreenFloatingViewAttr2.with("initState", Integer.valueOf(i3));
                                qUSHalfScreenFloatingViewAttr2.with(NodeProps.MAX_HEIGHT, 541);
                                qUSHalfScreenFloatingViewAttr2.with("defaultHeight", 386);
                                qUSHalfScreenFloatingViewAttr2.with("postData", qUSHalfScreenFloatingViewAttr2.getPagerData().n().p("jubaoModel"));
                                qUSHalfScreenFloatingViewAttr2.with("pageName", "Jubao_inner");
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
}
