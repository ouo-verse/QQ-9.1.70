package com.tencent.hippykotlin.demo.pages.goods_center.pendant.filter;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterFilterPanelViewModel;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.GoodsCenterPendantView;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPageData;
import com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel;
import com.tencent.kuikly.core.log.KLog;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GoodsCenterFilterPendantViewModel extends GoodsCenterFilterPanelViewModel implements IGoodsCenterPendantViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterFilterPendantViewModel.class, "isCeilingOrSearchState", "isCeilingOrSearchState()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterFilterPendantViewModel.class, "isFilterPanelVisibility", "isFilterPanelVisibility()Z", 0)};
    public final ReadWriteProperty isCeilingOrSearchState$delegate;
    public final ReadWriteProperty isFilterPanelVisibility$delegate;

    public GoodsCenterFilterPendantViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"change_filter_panel_visibility", "check_category", "change_ceiling_state", "click_search"});
        return of5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel
    public final GoodsCenterPendantView getPendantView() {
        return new GoodsCenterFilterPendantView();
    }

    public final boolean isFilterPanelVisibility() {
        return ((Boolean) this.isFilterPanelVisibility$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        boolean z16 = false;
        if (Intrinsics.areEqual(str, "change_filter_panel_visibility")) {
            if (obj == null) {
                if (!isFilterPanelVisibility()) {
                    z16 = true;
                }
            } else if (obj instanceof Boolean) {
                z16 = ((Boolean) obj).booleanValue();
            }
            setFilterPanelVisibility(z16);
            Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("eventName = ", str, " isFilterPanelVisibility = ");
            m3.append(isFilterPanelVisibility());
            kLog.i("GoodsCenterFilterPendantViewModel", m3.toString());
            return;
        }
        if (Intrinsics.areEqual(str, "check_category")) {
            resetFilterData();
            return;
        }
        if (Intrinsics.areEqual(str, "change_ceiling_state")) {
            if (obj == null || !(obj instanceof Boolean)) {
                return;
            }
            this.isCeilingOrSearchState$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(((Boolean) obj).booleanValue()));
            return;
        }
        if (Intrinsics.areEqual(str, "click_search")) {
            resetFilterData();
        }
    }

    public final void setFilterPanelVisibility(boolean z16) {
        this.isFilterPanelVisibility$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public /* synthetic */ GoodsCenterFilterPendantViewModel(IGoodsCenterPageData iGoodsCenterPageData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }

    public GoodsCenterFilterPendantViewModel(IGoodsCenterPageData iGoodsCenterPageData) {
        super(iGoodsCenterPageData);
        Boolean bool = Boolean.FALSE;
        this.isCeilingOrSearchState$delegate = c.a(bool);
        this.isFilterPanelVisibility$delegate = c.a(bool);
    }
}
