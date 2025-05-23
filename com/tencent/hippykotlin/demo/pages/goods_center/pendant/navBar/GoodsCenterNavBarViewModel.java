package com.tencent.hippykotlin.demo.pages.goods_center.pendant.navBar;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataBackEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataSearchText;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GoodsCenterNavBarViewModel implements IGoodsCenterPendantViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewModel.class, "searchText", "getSearchText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewModel.class, "isAfterSearch", "isAfterSearch()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewModel.class, "searchBarBackgroundColor", "getSearchBarBackgroundColor()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterNavBarViewModel.class, "sysBackCalledAutoIncreaseId", "getSysBackCalledAutoIncreaseId()I", 0)};
    public boolean isSearching;
    public final ReadWriteProperty searchText$delegate = c.a("");
    public final ReadWriteProperty isAfterSearch$delegate = c.a(Boolean.FALSE);
    public int sourceFrom = 0;
    public final ReadWriteProperty searchBarBackgroundColor$delegate = c.a("qecommerce_skin_color_bg_default");
    public final ReadWriteProperty sysBackCalledAutoIncreaseId$delegate = c.a(0);

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"tap_search_bar", "click_search", "click_back"});
        return of5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel
    public final GoodsCenterPendantView getPendantView() {
        return new GoodsCenterNavBarView();
    }

    public final String getSearchText() {
        return (String) this.searchText$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final int getSysBackCalledAutoIncreaseId() {
        return ((Number) this.sysBackCalledAutoIncreaseId$delegate.getValue(this, $$delegatedProperties[3])).intValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        if (Intrinsics.areEqual(str, "click_search")) {
            setAfterSearch(true);
            GoodsCenterEventDataSearchText goodsCenterEventDataSearchText = obj instanceof GoodsCenterEventDataSearchText ? (GoodsCenterEventDataSearchText) obj : null;
            if (goodsCenterEventDataSearchText != null) {
                if (Intrinsics.areEqual(goodsCenterEventDataSearchText.text, getSearchText())) {
                    setSearchText("");
                }
                setSearchText(goodsCenterEventDataSearchText.text);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "tap_search_bar")) {
            this.searchBarBackgroundColor$delegate.setValue(this, $$delegatedProperties[2], "qecommerce_skin_color_bg_backplate");
        } else if (Intrinsics.areEqual(str, "click_back")) {
            GoodsCenterEventDataBackEvent goodsCenterEventDataBackEvent = obj instanceof GoodsCenterEventDataBackEvent ? (GoodsCenterEventDataBackEvent) obj : null;
            if (goodsCenterEventDataBackEvent != null ? Intrinsics.areEqual(goodsCenterEventDataBackEvent.isAfterSearch, Boolean.TRUE) : false) {
                return;
            }
            this.searchBarBackgroundColor$delegate.setValue(this, $$delegatedProperties[2], "qecommerce_skin_color_bg_default");
        }
    }

    public final void setAfterSearch(boolean z16) {
        this.isAfterSearch$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final void setSearchText(String str) {
        this.searchText$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setSourceFrom(int i3) {
        this.sourceFrom = i3;
    }
}
