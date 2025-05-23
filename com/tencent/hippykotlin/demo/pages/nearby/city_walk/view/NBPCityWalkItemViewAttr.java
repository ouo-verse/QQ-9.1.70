package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.l;

/* loaded from: classes31.dex */
public final class NBPCityWalkItemViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkItemViewAttr.class, "isLineFirst", "isLineFirst()Z", 0)};
    public final ReadWriteProperty isLineFirst$delegate = c.a(Boolean.FALSE);
    public l statusFeed;
    public NBPCityWalkViewModel viewModel;

    public final NBPCityWalkViewModel getViewModel() {
        NBPCityWalkViewModel nBPCityWalkViewModel = this.viewModel;
        if (nBPCityWalkViewModel != null) {
            return nBPCityWalkViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
