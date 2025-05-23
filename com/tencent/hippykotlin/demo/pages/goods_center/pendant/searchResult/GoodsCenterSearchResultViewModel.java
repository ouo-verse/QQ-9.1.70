package com.tencent.hippykotlin.demo.pages.goods_center.pendant.searchResult;

import c01.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataBackEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataSearchText;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterSearchResultViewModel implements IGoodsCenterPendantViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterSearchResultViewModel.class, "bShowResultView", "getBShowResultView()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterSearchResultViewModel.class, "query", "getQuery()Ljava/lang/String;", 0)};
    public final ReadWriteProperty bShowResultView$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty query$delegate = c.a("");

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"tap_search_bar", "begin_editing", "click_search", "click_back"});
        return of5;
    }

    public final boolean getBShowResultView() {
        return ((Boolean) this.bShowResultView$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel
    public final GoodsCenterPendantView getPendantView() {
        return new GoodsCenterSearchResultView();
    }

    public final String getQuery() {
        return (String) this.query$delegate.getValue(this, $$delegatedProperties[1]);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        boolean bShowResultView = getBShowResultView();
        if (Intrinsics.areEqual(str, "tap_search_bar") ? true : Intrinsics.areEqual(str, "begin_editing")) {
            setBShowResultView(true);
        } else {
            if (Intrinsics.areEqual(str, "click_search")) {
                GoodsCenterEventDataSearchText goodsCenterEventDataSearchText = obj instanceof GoodsCenterEventDataSearchText ? (GoodsCenterEventDataSearchText) obj : null;
                if (goodsCenterEventDataSearchText != null) {
                    this.query$delegate.setValue(this, $$delegatedProperties[1], goodsCenterEventDataSearchText.text);
                }
                setBShowResultView(false);
            } else if (Intrinsics.areEqual(str, "click_back")) {
                GoodsCenterEventDataBackEvent goodsCenterEventDataBackEvent = obj instanceof GoodsCenterEventDataBackEvent ? (GoodsCenterEventDataBackEvent) obj : null;
                setBShowResultView(goodsCenterEventDataBackEvent != null ? Intrinsics.areEqual(goodsCenterEventDataBackEvent.isAfterSearch, Boolean.TRUE) : false);
            }
        }
        if (!getBShowResultView() || bShowResultView) {
            return;
        }
        e eVar = new e();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils.INSTANCE.currentBridgeModule().reportDT("xuanpin_search_history_query_exp", m3);
    }

    public final void setBShowResultView(boolean z16) {
        this.bShowResultView$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
