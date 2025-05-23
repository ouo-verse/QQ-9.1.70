package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchMultiMediaInfo;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchMultiMediaView extends ComposeView<QSearchMultiMediaAttr, QSearchMultiMediaEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchMultiMediaAttr access$getAttr(QSearchMultiMediaView qSearchMultiMediaView) {
        return (QSearchMultiMediaAttr) qSearchMultiMediaView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float m3 = ((getPagerData().m() - 48) - 6) / 3;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                List<List<QSearchMultiMediaInfo>> list = QSearchMultiMediaView.access$getAttr(QSearchMultiMediaView.this).mediaList;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mediaList");
                    list = null;
                }
                final QSearchMultiMediaView qSearchMultiMediaView = QSearchMultiMediaView.this;
                final float f16 = m3;
                final int i3 = 0;
                for (Object obj : list) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    final List list2 = (List) obj;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaView$body$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final int i17 = i3;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaView$body$1$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    tVar2.flexDirectionRow();
                                    tVar2.m140flex(1.0f);
                                    if (i17 != 0) {
                                        tVar2.marginTop(3.0f);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            final List<QSearchMultiMediaInfo> list3 = list2;
                            final QSearchMultiMediaView qSearchMultiMediaView2 = qSearchMultiMediaView;
                            final int i18 = i3;
                            final float f17 = f16;
                            final int i19 = 0;
                            for (Object obj2 : list3) {
                                int i26 = i19 + 1;
                                if (i19 < 0) {
                                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                                }
                                final QSearchMultiMediaInfo qSearchMultiMediaInfo = (QSearchMultiMediaInfo) obj2;
                                QSearchSingleMediaViewKt.QSearchSingleMedia(vVar2, new Function1<QSearchSingleMediaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaView$body$1$1$1$2$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(QSearchSingleMediaView qSearchSingleMediaView) {
                                        final QSearchMultiMediaInfo qSearchMultiMediaInfo2 = QSearchMultiMediaInfo.this;
                                        final QSearchMultiMediaView qSearchMultiMediaView3 = qSearchMultiMediaView2;
                                        final int i27 = i18;
                                        final int i28 = i19;
                                        final List<QSearchMultiMediaInfo> list4 = list3;
                                        final float f18 = f17;
                                        qSearchSingleMediaView.attr(new Function1<QSearchSingleMediaAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view.QSearchMultiMediaView$body$1$1$1$2$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(QSearchSingleMediaAttr qSearchSingleMediaAttr) {
                                                QSearchSingleMediaAttr qSearchSingleMediaAttr2 = qSearchSingleMediaAttr;
                                                qSearchSingleMediaAttr2.mediaInfo = QSearchMultiMediaInfo.this;
                                                qSearchSingleMediaAttr2.moreCount = QSearchMultiMediaView.access$getAttr(qSearchMultiMediaView3).moreCount;
                                                int i29 = i27;
                                                List<List<QSearchMultiMediaInfo>> list5 = QSearchMultiMediaView.access$getAttr(qSearchMultiMediaView3).mediaList;
                                                if (list5 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("mediaList");
                                                    list5 = null;
                                                }
                                                qSearchSingleMediaAttr2.showMoreCount = i29 == list5.size() - 1 && i28 == list4.size() - 1;
                                                float f19 = f18;
                                                qSearchSingleMediaAttr2.size(f19, f19);
                                                if (i28 == 1) {
                                                    qSearchSingleMediaAttr2.marginLeft(3.0f).marginRight(3.0f);
                                                }
                                                qSearchSingleMediaAttr2.reportParams = QSearchMultiMediaView.access$getAttr(qSearchMultiMediaView3).reportParams;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                i19 = i26;
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    i3 = i16;
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchMultiMediaAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchMultiMediaEvent();
    }
}
