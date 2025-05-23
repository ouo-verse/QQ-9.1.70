package com.tencent.hippykotlin.demo.pages.goods_center.pendant.headMap;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.goods_center.event.GoodsCenterEventDataBackEvent;
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
public final class GoodsCenterHeadMapViewModel implements IGoodsCenterPendantViewModel, IGoodsCenterEvent {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeadMapViewModel.class, "showBackground", "getShowBackground()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GoodsCenterHeadMapViewModel.class, "keepViewInNavBar", "getKeepViewInNavBar()Z", 0)};
    public final ReadWriteProperty showBackground$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty keepViewInNavBar$delegate = c.a(Boolean.FALSE);

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final Set<String> canHandleEventName() {
        Set<String> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new String[]{"tap_search_bar", "click_back"});
        return of5;
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterPendantViewModel
    public final GoodsCenterPendantView getPendantView() {
        return new GoodsCenterHeadMapView();
    }

    @Override // com.tencent.hippykotlin.demo.pages.goods_center.shell.IGoodsCenterEvent
    public final void onEvent(String str, Object obj) {
        if (Intrinsics.areEqual(str, "tap_search_bar")) {
            this.showBackground$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
        } else if (Intrinsics.areEqual(str, "click_back")) {
            GoodsCenterEventDataBackEvent goodsCenterEventDataBackEvent = obj instanceof GoodsCenterEventDataBackEvent ? (GoodsCenterEventDataBackEvent) obj : null;
            if (goodsCenterEventDataBackEvent != null ? Intrinsics.areEqual(goodsCenterEventDataBackEvent.isAfterSearch, Boolean.TRUE) : false) {
                return;
            }
            this.showBackground$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
        }
    }

    public final void setKeepViewInNavBar(boolean z16) {
        this.keepViewInNavBar$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
