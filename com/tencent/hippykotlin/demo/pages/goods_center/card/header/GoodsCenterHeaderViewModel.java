package com.tencent.hippykotlin.demo.pages.goods_center.card.header;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.category.GoodsCenterCategoryViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.category.GoodsCenterCategoryPendantViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort.GoodsCenterSortPendantViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterCategory;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterOrderBy;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.layout.d;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterHeaderViewModel implements IGoodsCenterCardViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeaderViewModel.class, "cardFrameY", "getCardFrameY()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeaderViewModel.class, "isSearching", "isSearching()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeaderViewModel.class, "isAddProductState", "isAddProductState()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeaderViewModel.class, "isHeaderOnTop", "isHeaderOnTop()Z", 0)};
    public final ReadWriteProperty cardFrameY$delegate = c.a(Float.valueOf(0.0f));
    public final GoodsCenterCategoryPendantViewModel categoryViewModel;
    public final ReadWriteProperty isAddProductState$delegate;
    public final ReadWriteProperty isHeaderOnTop$delegate;
    public final ReadWriteProperty isSearching$delegate;
    public final IGoodsCenterPageModel pageModel;
    public boolean showAllCategoryAfterScroll;
    public final GoodsCenterSortPendantViewModel sortViewModel;

    public GoodsCenterHeaderViewModel(IGoodsCenterPageModel iGoodsCenterPageModel) {
        this.pageModel = iGoodsCenterPageModel;
        this.categoryViewModel = new GoodsCenterCategoryPendantViewModel(iGoodsCenterPageModel);
        this.sortViewModel = new GoodsCenterSortPendantViewModel(iGoodsCenterPageModel);
        Boolean bool = Boolean.FALSE;
        this.isSearching$delegate = c.a(bool);
        this.isAddProductState$delegate = c.a(bool);
        this.isHeaderOnTop$delegate = c.a(bool);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> mutableSetOf;
        mutableSetOf = SetsKt__SetsKt.mutableSetOf("category_place_holder_change_frame", "show_all_category_after_scroll");
        mutableSetOf.addAll(this.sortViewModel.canHandleEventName());
        return mutableSetOf;
    }

    public final float getCardFrameY() {
        return ((Number) this.cardFrameY$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterHeaderView();
    }

    public final GoodsCenterCategoryPendantViewModel getCategoryViewModel() {
        return this.categoryViewModel;
    }

    public final boolean isHeaderOnTop() {
        return ((Boolean) this.isHeaderOnTop$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final boolean isSearching() {
        return ((Boolean) this.isSearching$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return true;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        if (this.sortViewModel.canHandleEventName().contains(str)) {
            this.sortViewModel.onEvent(str, obj);
        }
        if (Intrinsics.areEqual(str, "category_place_holder_change_frame")) {
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar == null || dVar.getY() <= 0.0f) {
                return;
            }
            this.cardFrameY$delegate.setValue(this, $$delegatedProperties[0], Float.valueOf(dVar.getY()));
            return;
        }
        if (Intrinsics.areEqual(str, "show_all_category_after_scroll")) {
            this.showAllCategoryAfterScroll = true;
        }
    }

    public final void setAddProductState(boolean z16) {
        this.isAddProductState$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public final void updateRsp(GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp) {
        GoodsCenterCategoryPendantViewModel goodsCenterCategoryPendantViewModel = this.categoryViewModel;
        goodsCenterCategoryPendantViewModel.getClass();
        ArrayList<GoodsCenterCategory> arrayList = goodsCenterSelectProductsRsp.categoryList;
        if (arrayList != null && goodsCenterCategoryPendantViewModel.needRebuild) {
            goodsCenterCategoryPendantViewModel.categoryList$delegate.setValue(goodsCenterCategoryPendantViewModel, GoodsCenterCategoryViewModel.$$delegatedProperties[0], arrayList);
            goodsCenterCategoryPendantViewModel.needRebuild = false;
        }
        ArrayList<GoodsCenterOrderBy> arrayList2 = goodsCenterSelectProductsRsp.orderByList;
        if (arrayList2 != null) {
            GoodsCenterSortPendantViewModel goodsCenterSortPendantViewModel = this.sortViewModel;
            goodsCenterSortPendantViewModel.sortByList$delegate.setValue(goodsCenterSortPendantViewModel, GoodsCenterSortViewModel.$$delegatedProperties[0], arrayList2);
        }
    }
}
