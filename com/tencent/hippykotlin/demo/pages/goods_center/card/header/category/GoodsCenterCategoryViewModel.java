package com.tencent.hippykotlin.demo.pages.goods_center.card.header.category;

import c01.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.game_content_page.GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsReq;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public class GoodsCenterCategoryViewModel implements IGoodsCenterCardViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterCategoryViewModel.class, "categoryList", "getCategoryList()Ljava/util/ArrayList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterCategoryViewModel.class, "selectedIndex", "getSelectedIndex()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterCategoryViewModel.class, "showAllCategory", "getShowAllCategory()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterCategoryViewModel.class, "indicatorFrameX", "getIndicatorFrameX()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterCategoryViewModel.class, "contentOffsetX", "getContentOffsetX()F", 0)};
    public boolean isHeaderOnTop;
    public final IGoodsCenterPageModel pageModel;
    public final ReadWriteProperty categoryList$delegate = c.a(new ArrayList());
    public final ReadWriteProperty selectedIndex$delegate = c.a(0);
    public final ReadWriteProperty showAllCategory$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty indicatorFrameX$delegate = c.a(Float.valueOf(6.0f));
    public final ReadWriteProperty contentOffsetX$delegate = c.a(Float.valueOf(0.0f));
    public boolean needRebuild = true;

    public GoodsCenterCategoryViewModel(IGoodsCenterPageModel iGoodsCenterPageModel) {
        this.pageModel = iGoodsCenterPageModel;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"tap_search_bar", "click_back", "click_search"});
        return of5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterCategoryView();
    }

    public final ArrayList<GoodsCenterCategory> getCategoryList() {
        return (ArrayList) this.categoryList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getSelectedIndex() {
        return ((Number) this.selectedIndex$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final boolean getShowAllCategory() {
        return ((Boolean) this.showAllCategory$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final boolean handleUpdateCategoryItem(int i3, GoodsCenterCategory goodsCenterCategory) {
        e eVar = new e();
        eVar.u("pri_sort_id", goodsCenterCategory.f114195id);
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("bus_id", GameContentPage$body$1$3$1$3$1$$ExternalSyntheticOutline0.m(BridgeManager.f117344a, com.tencent.kuikly.core.manager.c.f117352a, WadlProxyConsts.CHANNEL));
        Iterator<String> c16 = eVar.c();
        while (c16.hasNext()) {
            String next = c16.next();
            m3.v(next, eVar.p(next));
        }
        Utils utils = Utils.INSTANCE;
        utils.currentBridgeModule().reportDT("xuanpin_goods_sort_choose", m3);
        if (i3 == getSelectedIndex()) {
            utils.logToNative("GoodsCenterCategoryViewModel: same category, do nothing");
            return false;
        }
        this.selectedIndex$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
        setShowAllCategory(false);
        this.pageModel.refreshData(GoodsCenterSelectProductsReq.copy$default(this.pageModel.pageDataFilterParams(), null, null, goodsCenterCategory, "", 0, null, 417));
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        if (Intrinsics.areEqual(str, "tap_search_bar")) {
            setShowAllCategory(false);
        } else if (Intrinsics.areEqual(str, "click_back")) {
            setShowAllCategory(false);
        } else if (Intrinsics.areEqual(str, "click_search")) {
            this.selectedIndex$delegate.setValue(this, $$delegatedProperties[1], 0);
        }
    }

    public final void setShowAllCategory(boolean z16) {
        this.showAllCategory$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }
}
