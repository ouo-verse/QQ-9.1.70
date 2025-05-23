package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template;

import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchPlaylet;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes32.dex */
public final class QSearchPlayletTemplateView$buildItems$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchPlaylet $contentData;
    public final /* synthetic */ QSearchPlayletTemplateView $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchPlayletTemplateView$buildItems$1(QSearchPlaylet qSearchPlaylet, QSearchPlayletTemplateView qSearchPlayletTemplateView) {
        super(1);
        this.$contentData = qSearchPlaylet;
        this.$ctx = qSearchPlayletTemplateView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        final QSearchPlaylet qSearchPlaylet = this.$contentData;
        final List<QSearchButton> list = qSearchPlaylet.playletButton;
        if (list != null) {
            final QSearchPlayletTemplateView qSearchPlayletTemplateView = this.$ctx;
            final int i3 = qSearchPlayletTemplateView.getPagerData().h() >= 375.0f ? 3 : 2;
            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildItems$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(v vVar) {
                    v vVar2 = vVar;
                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.QSearchPlayletTemplateView$buildItems$1$1$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(t tVar) {
                            tVar.flexDirectionRow();
                            return Unit.INSTANCE;
                        }
                    });
                    int size = list.size();
                    int i16 = i3;
                    if (size > i16 + 2 + 1) {
                        List<QSearchButton> subList = list.subList(0, i16);
                        List<QSearchButton> subList2 = list.subList(r1.size() - 2, list.size());
                        QSearchPlayletTemplateView qSearchPlayletTemplateView2 = qSearchPlayletTemplateView;
                        Iterator<T> it = subList.iterator();
                        while (it.hasNext()) {
                            ((QSearchPlayletTemplateView$buildSingleItem$1) QSearchPlayletTemplateView.access$buildSingleItem(qSearchPlayletTemplateView2, (QSearchButton) it.next(), false)).invoke(vVar2);
                        }
                        QSearchButton qSearchButton = qSearchPlaylet.moreButton;
                        if (qSearchButton != null) {
                            ((QSearchPlayletTemplateView$buildSingleItem$1) QSearchPlayletTemplateView.access$buildSingleItem(qSearchPlayletTemplateView, qSearchButton, true)).invoke(vVar2);
                        }
                        QSearchPlayletTemplateView qSearchPlayletTemplateView3 = qSearchPlayletTemplateView;
                        Iterator<T> it5 = subList2.iterator();
                        while (it5.hasNext()) {
                            ((QSearchPlayletTemplateView$buildSingleItem$1) QSearchPlayletTemplateView.access$buildSingleItem(qSearchPlayletTemplateView3, (QSearchButton) it5.next(), false)).invoke(vVar2);
                        }
                    } else {
                        List<QSearchButton> list2 = list;
                        QSearchPlayletTemplateView qSearchPlayletTemplateView4 = qSearchPlayletTemplateView;
                        Iterator<T> it6 = list2.iterator();
                        while (it6.hasNext()) {
                            ((QSearchPlayletTemplateView$buildSingleItem$1) QSearchPlayletTemplateView.access$buildSingleItem(qSearchPlayletTemplateView4, (QSearchButton) it6.next(), false)).invoke(vVar2);
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
