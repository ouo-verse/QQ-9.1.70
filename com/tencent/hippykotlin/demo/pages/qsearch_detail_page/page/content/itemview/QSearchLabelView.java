package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.extension.FontModuleExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchLabelView extends ComposeView<QSearchLabelAttr, QSearchLabelEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchLabelAttr access$getAttr(QSearchLabelView qSearchLabelView) {
        return (QSearchLabelAttr) qSearchLabelView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchLabelView qSearchLabelView = QSearchLabelView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.paddingTop(8.0f);
                        mVar2.paddingBottom(8.0f);
                        mVar2.paddingLeft(16.0f);
                        mVar2.paddingRight(16.0f);
                        mVar2.flexDirectionRow();
                        mVar2.borderRadius(6.0f);
                        if (QSearchLabelView.access$getAttr(QSearchLabelView.this).isSelected()) {
                            mVar2.mo113backgroundColor(QUISkinColor.INSTANCE.blueLabelBackground());
                        } else {
                            mVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("fill_standard_primary"));
                        }
                        return Unit.INSTANCE;
                    }
                });
                final QSearchLabelView qSearchLabelView2 = QSearchLabelView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final QSearchLabelView qSearchLabelView3 = QSearchLabelView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.m140flex(1.0f);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.lines(1);
                                ceVar2.textOverFlowTail();
                                QSearchLabelAttr access$getAttr = QSearchLabelView.access$getAttr(QSearchLabelView.this);
                                ceVar2.text((String) access$getAttr.label$delegate.getValue(access$getAttr, QSearchLabelAttr.$$delegatedProperties[0]));
                                if (QSearchLabelView.access$getAttr(QSearchLabelView.this).isSelected()) {
                                    ceVar2.fontWeightMedium();
                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("brand_standard"));
                                } else {
                                    ceVar2.fontWeightNormal();
                                    ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_secondary"));
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchLabelView qSearchLabelView3 = QSearchLabelView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final QSearchLabelView qSearchLabelView4 = QSearchLabelView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchLabelView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String sb5;
                                String sb6;
                                af afVar2 = afVar;
                                afVar2.size(FontModuleExtKt.qqFontScale() * 16.0f, FontModuleExtKt.qqFontScale() * 16.0f);
                                if (QSearchLabelView.access$getAttr(QSearchLabelView.this).isSelected()) {
                                    String m3 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", "chevron_up", "?color=", "icon_aio_toolbar_active");
                                    if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                        StringBuilder m16 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                        m16.append(SkinColor.colorUniqueID);
                                        sb6 = m16.toString();
                                    } else {
                                        StringBuilder m17 = HotViewKt$$ExternalSyntheticOutline0.m(m3, "&image_unique_id=");
                                        m17.append(SkinColor.colorUniqueID);
                                        sb6 = m17.toString();
                                    }
                                    b.a.b(afVar2, sb6, false, 2, null);
                                } else {
                                    String m18 = QUISkinImage$$ExternalSyntheticOutline0.m("qui_image://", "chevron_down", "?color=", "icon_secondary");
                                    if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                        StringBuilder m19 = HotViewKt$$ExternalSyntheticOutline0.m(m18, "&image_unique_id=");
                                        m19.append(SkinColor.colorUniqueID);
                                        sb5 = m19.toString();
                                    } else {
                                        StringBuilder m26 = HotViewKt$$ExternalSyntheticOutline0.m(m18, "&image_unique_id=");
                                        m26.append(SkinColor.colorUniqueID);
                                        sb5 = m26.toString();
                                    }
                                    b.a.b(afVar2, sb5, false, 2, null);
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
        return new QSearchLabelAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchLabelEvent();
    }
}
