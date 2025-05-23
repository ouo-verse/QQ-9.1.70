package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.troop.SearchNetLabel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class TroopTagView extends QSearchBaseAdaptWidthView<TroopTagAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TroopTagView.class, "labelList", "getLabelList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TroopTagView.class, "needTail", "getNeedTail()Z", 0)};
    public final ReadWriteProperty labelList$delegate = c.b();
    public final ReadWriteProperty needTail$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TroopTagAttr access$getAttr(TroopTagView troopTagView) {
        return (TroopTagAttr) troopTagView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView, com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        if (!((TroopTagAttr) getAttr()).useWrapMode) {
            return super.body();
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.marginTop(0.0f);
                        return Unit.INSTANCE;
                    }
                });
                final TroopTagView troopTagView = TroopTagView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.TroopTagView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.flexWrapWrap();
                                tVar2.overflow(true);
                                return Unit.INSTANCE;
                            }
                        });
                        TroopTagView troopTagView2 = TroopTagView.this;
                        troopTagView2.getClass();
                        new TroopTagView$buildContent$1(troopTagView2).invoke(vVar2);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView
    public final Function1<ViewContainer<?, ?>, Unit> buildContent() {
        return new TroopTagView$buildContent$1(this);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new TroopTagAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        getLabelList().addAll(((TroopTagAttr) getAttr()).labelList);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<SearchNetLabel> getLabelList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.labelList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.adapt_width.QSearchBaseAdaptWidthView
    public final boolean shrinkWidth() {
        if (getLabelList().size() > 1) {
            CollectionsKt__MutableCollectionsKt.removeLast(getLabelList());
            return true;
        }
        this.needTail$delegate.setValue(this, $$delegatedProperties[1], Boolean.TRUE);
        return false;
    }
}
