package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views;

import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverInterestTag extends ComposeView<QPPromoteReceiverInterestTagViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPPromoteReceiverInterestTagViewAttr access$getAttr(QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag) {
        return (QPPromoteReceiverInterestTagViewAttr) qPPromoteReceiverInterestTag.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTag$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag = QPPromoteReceiverInterestTag.this;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTag$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag2 = QPPromoteReceiverInterestTag.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTag.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(28.0f);
                                QPPromoteReceiverInterestTagViewAttr access$getAttr = QPPromoteReceiverInterestTag.access$getAttr(QPPromoteReceiverInterestTag.this);
                                if (((Boolean) access$getAttr.status$delegate.getValue(access$getAttr, QPPromoteReceiverInterestTagViewAttr.$$delegatedProperties[0])).booleanValue()) {
                                    AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_tag_light");
                                } else {
                                    AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_tag_normal");
                                }
                                tVar2.borderRadius(4.0f);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag3 = QPPromoteReceiverInterestTag.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTag.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final QPPromoteReceiverInterestTag qPPromoteReceiverInterestTag4 = QPPromoteReceiverInterestTag.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.tags_views.QPPromoteReceiverInterestTag.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.textAlignCenter();
                                        QPPromoteReceiverInterestTagViewAttr access$getAttr = QPPromoteReceiverInterestTag.access$getAttr(QPPromoteReceiverInterestTag.this);
                                        if (((Boolean) access$getAttr.status$delegate.getValue(access$getAttr, QPPromoteReceiverInterestTagViewAttr.$$delegatedProperties[0])).booleanValue()) {
                                            AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_red_brand");
                                        } else {
                                            AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                        }
                                        ceVar2.text(QPPromoteReceiverInterestTag.access$getAttr(QPPromoteReceiverInterestTag.this).labelText);
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
        return new QPPromoteReceiverInterestTagViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
