package com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterOrderBy;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterCardAttr;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.kuikly.core.base.ComposeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public class GoodsCenterSortViewModel implements IGoodsCenterCardViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterSortViewModel.class, "sortByList", "getSortByList()Ljava/util/List;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterSortViewModel.class, "isFilterBtnSelected", "isFilterBtnSelected()Z", 0)};
    public float cardYOffset;
    public boolean hasFilterCond;
    public final ReadWriteProperty isFilterBtnSelected$delegate;
    public final IGoodsCenterPageModel pageModel;
    public final ReadWriteProperty sortByList$delegate;

    public GoodsCenterSortViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final ComposeView<GoodsCenterCardAttr, GoodsCenterEvent> getCardView() {
        return new GoodsCenterSortView();
    }

    public final List<GoodsCenterOrderBy> getSortByList() {
        return (List) this.sortByList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isFilterBtnSelected() {
        return ((Boolean) this.isFilterBtnSelected$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterCardViewModel
    public final boolean isTopOfCard() {
        return false;
    }

    public final void resetOrderByStatus() {
        int i3 = 0;
        for (Object obj : getSortByList()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            GoodsCenterOrderBy goodsCenterOrderBy = (GoodsCenterOrderBy) obj;
            goodsCenterOrderBy.setCurOrderByType(0);
            goodsCenterOrderBy.setCurIsSelected(false);
            if (i3 == 0) {
                goodsCenterOrderBy.setCurIsSelected(true);
                if (goodsCenterOrderBy.getSortable()) {
                    goodsCenterOrderBy.setCurOrderByType(goodsCenterOrderBy.defaultOrderByType);
                }
            }
            i3 = i16;
        }
    }

    public final void setFilterBtnSelected(boolean z16) {
        this.isFilterBtnSelected$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public GoodsCenterSortViewModel(IGoodsCenterPageModel iGoodsCenterPageModel) {
        this.pageModel = iGoodsCenterPageModel;
        this.sortByList$delegate = c.a(new ArrayList());
        this.isFilterBtnSelected$delegate = c.a(Boolean.FALSE);
    }

    public /* synthetic */ GoodsCenterSortViewModel(IGoodsCenterPageModel iGoodsCenterPageModel, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
