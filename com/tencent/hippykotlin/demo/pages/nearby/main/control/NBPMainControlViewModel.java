package com.tencent.hippykotlin.demo.pages.nearby.main.control;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.CameraPosition;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPMainControlViewModel extends NBPMainBaseViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainControlViewModel.class, "showLocationBtn", "getShowLocationBtn()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainControlViewModel.class, "showDeletePositionActionSheet", "getShowDeletePositionActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPMainControlViewModel.class, "showFeedsEntranceTips", "getShowFeedsEntranceTips()Z", 0)};
    public CameraPosition curCameraPos;
    public final ReadWriteProperty showDeletePositionActionSheet$delegate;
    public final ReadWriteProperty showFeedsEntranceTips$delegate;
    public final ReadWriteProperty showLocationBtn$delegate;

    public NBPMainControlViewModel() {
        Boolean bool = Boolean.FALSE;
        this.showLocationBtn$delegate = c.a(bool);
        this.showDeletePositionActionSheet$delegate = c.a(bool);
        this.showFeedsEntranceTips$delegate = c.a(bool);
    }

    public final boolean getShowFeedsEntranceTips() {
        return ((Boolean) this.showFeedsEntranceTips$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onMapCameraChangedFinish(CameraPosition cameraPosition) {
        this.curCameraPos = cameraPosition;
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainBaseViewModel
    public final void onReceiveEvent(String str, Object obj) {
        if (Intrinsics.areEqual(str, "EVENT_HOST_PERSON_APPEAR")) {
            this.showLocationBtn$delegate.setValue(this, $$delegatedProperties[0], Boolean.FALSE);
            e jsonWithMainPgParamsImp = NearbyConstKt.jsonWithMainPgParamsImp();
            jsonWithMainPgParamsImp.v("dt_eid", "em_nearby_location");
            jsonWithMainPgParamsImp.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", jsonWithMainPgParamsImp);
            return;
        }
        if (Intrinsics.areEqual(str, "EVENT_HOST_PERSON_DISAPPEAR")) {
            this.showLocationBtn$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
        }
    }

    public final void setShowDeletePositionActionSheet(boolean z16) {
        this.showDeletePositionActionSheet$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
