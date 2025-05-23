package com.tencent.hippykotlin.demo.pages.goods_center.pendant.sort;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.goods_center.card.header.sort.GoodsCenterSortViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataBackEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GoodsCenterSortPendantViewModel extends GoodsCenterSortViewModel implements IGoodsCenterPendantViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterSortPendantViewModel.class, "isSearching", "isSearching()Z", 0)};
    public final ReadWriteProperty isSearching$delegate;

    public GoodsCenterSortPendantViewModel(IGoodsCenterPageModel iGoodsCenterPageModel) {
        super(iGoodsCenterPageModel);
        this.isSearching$delegate = c.a(Boolean.FALSE);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"click_back", "click_search", "check_category", "filter_status_changed", "change_filter_panel_visibility", "filter_visibility_changed"});
        return of5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel
    public final GoodsCenterPendantView getPendantView() {
        return new GoodsCenterSortPendantView();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if ((r4.length() > 0) == true) goto L22;
     */
    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onEvent(String str, Object obj) {
        boolean z16 = true;
        if (Intrinsics.areEqual(str, "click_back")) {
            GoodsCenterEventDataBackEvent goodsCenterEventDataBackEvent = obj instanceof GoodsCenterEventDataBackEvent ? (GoodsCenterEventDataBackEvent) obj : null;
            if (goodsCenterEventDataBackEvent != null ? Intrinsics.areEqual(goodsCenterEventDataBackEvent.isAfterSearch, Boolean.TRUE) : false) {
                return;
            }
            if (goodsCenterEventDataBackEvent != null && (r4 = goodsCenterEventDataBackEvent.lastQueryText) != null) {
            }
            z16 = false;
            if (z16) {
                this.isSearching$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, "click_search")) {
            this.isSearching$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
            resetOrderByStatus();
            this.hasFilterCond = false;
            setFilterBtnSelected(false);
            return;
        }
        if (Intrinsics.areEqual(str, "check_category")) {
            resetOrderByStatus();
            this.hasFilterCond = false;
            setFilterBtnSelected(false);
            return;
        }
        if (Intrinsics.areEqual(str, "filter_status_changed")) {
            if (obj == null || !(obj instanceof Boolean)) {
                return;
            }
            Boolean bool = (Boolean) obj;
            this.hasFilterCond = bool.booleanValue();
            setFilterBtnSelected(bool.booleanValue());
            return;
        }
        if (Intrinsics.areEqual(str, "filter_visibility_changed") && obj != null && (obj instanceof Boolean)) {
            if (!((Boolean) obj).booleanValue()) {
                Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
                z16 = this.hasFilterCond;
            }
            setFilterBtnSelected(z16);
        }
    }
}
