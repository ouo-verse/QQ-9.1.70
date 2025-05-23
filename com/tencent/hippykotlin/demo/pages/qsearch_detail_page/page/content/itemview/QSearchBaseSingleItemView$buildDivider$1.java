package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import com.tencent.hippykotlin.demo.pages.base.QUISkinColor;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchBaseSingleItemView$buildDivider$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QSearchBaseSingleItemView<QSearchBaseSingleItemAttr, l> $ctx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QSearchBaseSingleItemView$buildDivider$1(QSearchBaseSingleItemView<QSearchBaseSingleItemAttr, l> qSearchBaseSingleItemView) {
        super(1);
        this.$ctx = qSearchBaseSingleItemView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        if (QSearchBaseSingleItemView.access$getAttr(this.$ctx).showDivider) {
            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView$buildDivider$1.1
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(v vVar) {
                    vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.QSearchBaseSingleItemView.buildDivider.1.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(t tVar) {
                            t tVar2 = tVar;
                            tVar2.positionAbsolute();
                            tVar2.m138bottom(0.0f);
                            tVar2.m149right(0.0f);
                            tVar2.m142left(64.0f);
                            tVar2.mo141height(0.5f);
                            tVar2.mo113backgroundColor(QUISkinColor.INSTANCE.wrapColor("border_standard"));
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            });
        }
        return Unit.INSTANCE;
    }
}
