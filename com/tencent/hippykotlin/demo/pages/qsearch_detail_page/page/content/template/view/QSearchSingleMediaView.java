package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import com.tencent.hippykotlin.demo.pages.base.EcommerceExtKt;
import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPicture;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchTemplateReportInfo;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchUtilKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchSingleMediaView extends ComposeView<QSearchSingleMediaAttr, QSearchSingleMediaEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchSingleMediaAttr access$getAttr(QSearchSingleMediaView qSearchSingleMediaView) {
        return (QSearchSingleMediaAttr) qSearchSingleMediaView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final QSearchPicture qSearchPicture = ((QSearchSingleMediaAttr) getAttr()).getMediaInfo().pictureInfo;
        if (qSearchPicture == null) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$pictureInfo$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(ViewContainer<?, ?> viewContainer) {
                    return Unit.INSTANCE;
                }
            };
        }
        final QSearchTemplateReportInfo qSearchTemplateReportInfo = ((QSearchSingleMediaAttr) getAttr()).getMediaInfo().reportInfo;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                boolean isBlank;
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final QSearchTemplateReportInfo qSearchTemplateReportInfo2 = qSearchTemplateReportInfo;
                final QSearchSingleMediaView qSearchSingleMediaView = this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        QSearchTemplateReportInfo qSearchTemplateReportInfo3 = QSearchTemplateReportInfo.this;
                        if (qSearchTemplateReportInfo3 != null) {
                            EcommerceExtKt.vr$default(mVar2, null, qSearchTemplateReportInfo3.eid, qSearchTemplateReportInfo3.getReportParams(QSearchSingleMediaView.access$getAttr(qSearchSingleMediaView).reportParams), null, String.valueOf(qSearchTemplateReportInfo3.hashCode()), true, 9);
                        }
                        return Unit.INSTANCE;
                    }
                });
                isBlank = StringsKt__StringsJVMKt.isBlank(QSearchPicture.this.picLink);
                if (!isBlank) {
                    final QSearchPicture qSearchPicture2 = QSearchPicture.this;
                    final QSearchSingleMediaView qSearchSingleMediaView2 = this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            final QSearchPicture qSearchPicture3 = QSearchPicture.this;
                            final QSearchSingleMediaView qSearchSingleMediaView3 = qSearchSingleMediaView2;
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    afVar2.m140flex(1.0f);
                                    b.a.b(afVar2, QSearchPicture.this.picLink, false, 2, null);
                                    afVar2.borderRadius(QSearchSingleMediaView.access$getAttr(qSearchSingleMediaView3).borderRadius);
                                    if (QSearchSingleMediaView.access$getAttr(qSearchSingleMediaView3).isShowAsThumbnail && QSearchSingleMediaView.access$getAttr(qSearchSingleMediaView3).getMediaInfo().type == 1) {
                                        afVar2.p();
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1.3
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    tVar.m140flex(1.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (QSearchSingleMediaView.access$getAttr(this).getMediaInfo().type == 2) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1.4
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.absolutePositionAllZero();
                                    tVar2.allCenter();
                                    return Unit.INSTANCE;
                                }
                            });
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.4.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.4.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.size(48.0f, 48.0f);
                                            b.a.b(afVar2, "data:image/png;base64,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", false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (QSearchSingleMediaView.access$getAttr(this).showMoreCount && QSearchSingleMediaView.access$getAttr(this).moreCount > 0) {
                    final QSearchSingleMediaView qSearchSingleMediaView3 = this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1.5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final QSearchSingleMediaView qSearchSingleMediaView4 = QSearchSingleMediaView.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.5.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.absolutePositionAllZero();
                                    tVar2.mo113backgroundColor(QUISkinColor.picMark);
                                    tVar2.borderRadius(QSearchSingleMediaView.access$getAttr(QSearchSingleMediaView.this).borderRadius);
                                    tVar2.allCenter();
                                    return Unit.INSTANCE;
                                }
                            });
                            final QSearchSingleMediaView qSearchSingleMediaView5 = QSearchSingleMediaView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.5.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final QSearchSingleMediaView qSearchSingleMediaView6 = QSearchSingleMediaView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.5.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.color(h.INSTANCE.m());
                                            ce.fontSize$default(ceVar2, 24.0f, null, 2, null);
                                            ceVar2.fontWeight500();
                                            StringBuilder sb5 = new StringBuilder();
                                            sb5.append('+');
                                            sb5.append(QSearchSingleMediaView.access$getAttr(QSearchSingleMediaView.this).moreCount);
                                            ceVar2.text(sb5.toString());
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (QSearchSingleMediaView.access$getAttr(this).isShowAsThumbnail && QSearchSingleMediaView.access$getAttr(this).getMediaInfo().type == 1) {
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1.6
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.6.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 8.0f, 8.0f, 3, null);
                                    tVar2.borderRadius(4.0f);
                                    tVar2.allCenter();
                                    tVar2.mo113backgroundColor(QUIToken.color$default("fill_allblack_medium"));
                                    tVar2.padding(3.0f, 6.0f, 3.0f, 6.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.6.2
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView.body.1.6.2.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text("\u67e5\u770b\u5927\u56fe");
                                            ceVar2.color(QUIToken.color$default("text_allwhite_primary"));
                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final QSearchJump qSearchJump = QSearchPicture.this.jumpLink;
                if (qSearchJump != null) {
                    viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1$7$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Event event) {
                            final Event event2 = event;
                            final QSearchJump qSearchJump2 = QSearchJump.this;
                            event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchSingleMediaView$body$1$7$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ClickParams clickParams) {
                                    QSearchUtilKt.allInOneJump$default(QSearchJump.this, event2.getPager(), 0L, 60);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchSingleMediaAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchSingleMediaEvent();
    }
}
