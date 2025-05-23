package com.tencent.hippykotlin.demo.pages.goods_center.card.error_view;

import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.kuikly.core.base.ComposeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterErrorViewModel implements IGoodsCenterCardViewModel {
    public final Function0<Unit> buttonAction;

    /* renamed from: msg, reason: collision with root package name */
    public final String f114194msg;

    public GoodsCenterErrorViewModel(String str, Function0<Unit> function0) {
        this.f114194msg = str;
        this.buttonAction = function0;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterErrorView(this.f114194msg, this.buttonAction);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }
}
