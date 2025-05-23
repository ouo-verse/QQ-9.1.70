package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.PageListView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerEvent;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.be;

/* loaded from: classes32.dex */
public final class QSearchPageListView extends PageListView<QSearchPageListAttr, QSearchPageListEvent> {
    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchPageListAttr();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchPageListEvent();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final ao createAttr() {
        return new QSearchPageListAttr();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final ap createEvent() {
        return new QSearchPageListEvent();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final be createAttr() {
        return new QSearchPageListAttr();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final PageListEvent createEvent() {
        return new QSearchPageListEvent();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final ScrollerAttr createAttr() {
        return new QSearchPageListAttr();
    }

    @Override // com.tencent.kuikly.core.views.PageListView, com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public final ScrollerEvent createEvent() {
        return new QSearchPageListEvent();
    }
}
