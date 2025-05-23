package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
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
public final class QSearchEmptyItemView extends QSearchBaseSingleItemView<QSearchEmptyItemAttr, QSearchEmptyItemEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchEmptyItemAttr access$getAttr(QSearchEmptyItemView qSearchEmptyItemView) {
        return (QSearchEmptyItemAttr) qSearchEmptyItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                String str;
                                af afVar2 = afVar;
                                if (SkinColor.INSTANCE.isNightMode(BridgeManager.f117344a.u())) {
                                    str = "data:image/png;base64,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";
                                } else {
                                    str = "data:image/png;base64,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";
                                }
                                b.a.b(afVar2, str, false, 2, null);
                                afVar2.size(100.0f, 100.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final QSearchEmptyItemView qSearchEmptyItemView = QSearchEmptyItemView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final QSearchEmptyItemView qSearchEmptyItemView2 = QSearchEmptyItemView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.guide.QSearchEmptyItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(24.0f);
                                QSearchEmptyItemAttr access$getAttr = QSearchEmptyItemView.access$getAttr(QSearchEmptyItemView.this);
                                ceVar2.text((String) access$getAttr.text$delegate.getValue(access$getAttr, QSearchEmptyItemAttr.$$delegatedProperties[0]));
                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                ceVar2.color(QUISkinColor.INSTANCE.wrapColor("text_primary"));
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
        return new QSearchEmptyItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchEmptyItemEvent();
    }
}
