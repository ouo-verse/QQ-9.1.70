package com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSearchHistoryView extends DeclarativeBaseView<GoodsCenterSearchHistoryAttr, GoodsCenterSearchHistoryEvent> {
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GoodsCenterSearchHistoryAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GoodsCenterSearchHistoryEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        if (((GoodsCenterSearchHistoryAttr) getAttr()).getPagerData().getIsIOS()) {
            return "QQECSelectProductSearchHistoryView";
        }
        return "KRView";
    }
}
